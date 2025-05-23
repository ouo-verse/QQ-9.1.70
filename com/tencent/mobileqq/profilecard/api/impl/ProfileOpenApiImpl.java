package com.tencent.mobileqq.profilecard.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileOpenApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileOpenApiImpl implements IProfileOpenApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileOpenApiImpl";

    public ProfileOpenApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void asyncGetNickFromProfileService(String str, String str2, @NonNull IProfileOpenApi.ProfileServiceCallback profileServiceCallback, AppRuntime appRuntime) {
        if (!(appRuntime instanceof AppInterface)) {
            return;
        }
        ((AppInterface) appRuntime).addObserver(new ProfileCardObserver(str2, appRuntime, profileServiceCallback, str) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileOpenApiImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AppRuntime val$app;
            final /* synthetic */ IProfileOpenApi.ProfileServiceCallback val$callback;
            final /* synthetic */ String val$source;
            final /* synthetic */ String val$uin;

            {
                this.val$source = str2;
                this.val$app = appRuntime;
                this.val$callback = profileServiceCallback;
                this.val$uin = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileOpenApiImpl.this, str2, appRuntime, profileServiceCallback, str);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                Bundle bundle = new Bundle();
                if (!z16) {
                    ProfileOpenApiImpl.logError(this.val$source, 1, "getNick fail, onGetProfileCard isSuccess=false");
                    ((AppInterface) this.val$app).removeObserver(this);
                    this.val$callback.onResult(1000, "sSuccess=false", bundle);
                    return;
                }
                if (!(obj instanceof Card)) {
                    ProfileOpenApiImpl.logError(this.val$source, 1, "getNick fail, onGetProfileCard data is not subtype of Card");
                    ((AppInterface) this.val$app).removeObserver(this);
                    this.val$callback.onResult(1000, "data is not subtype of Card", bundle);
                    return;
                }
                Card card = (Card) obj;
                bundle.putString(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK, card.strNick);
                ProfileOpenApiImpl.logColor(this.val$source, 1, "getNick from FriendDataService, uin=" + ProfileOpenApiImpl.getCrypticStr(this.val$uin) + ", nick=" + card.strNick);
                this.val$callback.onResult(0, "", bundle);
                ((AppInterface) this.val$app).removeObserver(this);
                ((IProfileDataService) this.val$app.getRuntimeService(IProfileDataService.class, "all")).saveProfileCard(card);
            }
        });
        ((IProfileProtocolService) appRuntime.getRuntimeService(IProfileProtocolService.class, "all")).requestProfileCard(appRuntime.getCurrentUin(), str, 12, 0L, (byte) 0, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCrypticStr(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = str.length() - 4;
        int i3 = length - 4;
        if (length < 0) {
            length = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 < length && length > 0) {
            stringBuffer.replace(i3, length, "*");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getNick$0(String str, IProfileOpenApi.ProfileServiceCallback profileServiceCallback, HashMap hashMap, int i3, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (i3 != 0) {
            logError(str, 1, "errorcode=" + i3);
            profileServiceCallback.onResult(1, "fetch fail", bundle2);
            return;
        }
        if (bundle == null) {
            logError(str, 1, "fetch data is null");
            profileServiceCallback.onResult(1, "fetch data is null", bundle2);
            return;
        }
        Serializable serializable = bundle.getSerializable(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK_MAP);
        if (!(serializable instanceof SerializableMap)) {
            logError(str, 1, "fetch data return invalid");
            profileServiceCallback.onResult(1, "fetch data return invalid", bundle2);
            return;
        }
        try {
            HashMap hashMap2 = (HashMap) ((SerializableMap) serializable).getMap();
            for (String str2 : hashMap2.keySet()) {
                String str3 = (String) hashMap2.get(str2);
                hashMap.put(str2, str3);
                logColor(str, 1, "getNick from server, uin=" + getCrypticStr(str2) + ", nick=" + str3);
            }
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(hashMap);
            bundle2.putSerializable(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK_MAP, serializableMap);
            profileServiceCallback.onResult(0, "fetch data success", bundle2);
        } catch (ClassCastException unused) {
            logError(str, 1, "fetch data return invalid");
            profileServiceCallback.onResult(1, "fetch data return invalid", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logColor(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("ProfileOpenApiImpl_" + str, i3, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logError(String str, int i3, String str2) {
        QLog.e("ProfileOpenApiImpl_" + str, i3, str2);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileOpenApi
    public String getNick(String str, String str2, IProfileOpenApi.ProfileServiceCallback profileServiceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, str, str2, profileServiceCallback);
        }
        if (TextUtils.isEmpty(str)) {
            logError(str2, 1, "getNick fail, input uin is null");
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            logError(str2, 1, "getNick fail, app is null");
            return str;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(uidFromUin);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (nameWithConfig != null) {
                return nameWithConfig;
            }
        }
        Card profileCard = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(str, true);
        if (profileCard == null || TextUtils.isEmpty(profileCard.strNick)) {
            if (profileServiceCallback != null) {
                asyncGetNickFromProfileService(str, str2, profileServiceCallback, peekAppRuntime);
            }
            return str;
        }
        String str3 = profileCard.strNick;
        logColor(str2, 1, "getNick from FriendDataLocal, uin=" + getCrypticStr(str) + ", nick=" + str3);
        return str3;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileOpenApi
    public HashMap<String, String> getNick(ArrayList<String> arrayList, final String str, final IProfileOpenApi.ProfileServiceCallback profileServiceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, this, arrayList, str, profileServiceCallback);
        }
        final HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap.put(next, next);
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            logError(str, 1, "getNick fail, app is null");
            return hashMap;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            String next2 = it5.next();
            String syncFetchFriendNick = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).syncFetchFriendNick(next2);
            if (!TextUtils.isEmpty(syncFetchFriendNick) && !next2.equals(syncFetchFriendNick)) {
                hashMap.put(next2, syncFetchFriendNick);
                logColor(str, 1, "getNick from local, uin=" + getCrypticStr(next2) + ", nick=" + syncFetchFriendNick);
            } else {
                arrayList2.add(next2);
            }
        }
        ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).batchFetchFriendNick(arrayList2, new IProfileCardBusinessApi.CommonCallback() { // from class: com.tencent.mobileqq.profilecard.api.impl.f
            @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi.CommonCallback
            public final void onResult(int i3, Bundle bundle) {
                ProfileOpenApiImpl.lambda$getNick$0(str, profileServiceCallback, hashMap, i3, bundle);
            }
        });
        return hashMap;
    }
}
