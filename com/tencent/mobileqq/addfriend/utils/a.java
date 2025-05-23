package com.tencent.mobileqq.addfriend.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.troop.utils.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x1004.oidb_cmd0x1004$Person;
import tencent.im.oidb.cmd0x1004.oidb_cmd0x1004$Tag;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f187604a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.addfriend.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7229a implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f187605a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f187606b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f187607c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e.a f187608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f187609e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f187610f;

        C7229a(AppRuntime appRuntime, String str, Context context, e.a aVar, int i3, Bundle bundle) {
            this.f187605a = appRuntime;
            this.f187606b = str;
            this.f187607c = context;
            this.f187608d = aVar;
            this.f187609e = i3;
            this.f187610f = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, str, context, aVar, Integer.valueOf(i3), bundle);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d("AddFriendUtil", 2, "AddFriendUtil checkApiState get pskey fail");
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
                return;
            }
            if (!map.containsKey("connect.qq.com")) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendUtil", 2, "AddFriendUtil checkApiState get pskey onSuccess key-erro");
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a.f187604a);
            String account = this.f187605a.getAccount();
            String str = map.get("connect.qq.com");
            bundle.putString("Referer", "https://cgi.connect.qq.com/");
            bundle.putString("Cookie", "pSkey=" + str + ";pUin=" + account + ";uin=" + account);
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("appid=");
            sb6.append(this.f187606b);
            sb5.append(sb6.toString());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("BUNDLE", bundle);
            hashMap.put("CONTEXT", this.f187607c);
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendUtil", 2, "new checkApiState params = " + bundle);
            }
            new f(sb5.toString(), "GET", this.f187608d, this.f187609e, this.f187610f).b(hashMap);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f187604a = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
        }
    }

    public static void a(AppRuntime appRuntime, Context context, String str, e.a aVar, int i3, Bundle bundle) {
        if (appRuntime != null && context != null) {
            ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{"connect.qq.com"}, new C7229a(appRuntime, str, context, aVar, i3, bundle));
        } else if (QLog.isColorLevel()) {
            QLog.d("AddFriendUtil", 2, "AddFriendUtil checkApiState null == app || null == context");
        }
    }

    public static void b(AppRuntime appRuntime, Context context, String str, e.a aVar, int i3, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f187604a);
        String account = appRuntime.getAccount();
        String pskey = ((TicketManager) appRuntime.getManager(2)).getPskey(account, "connect.qq.com");
        bundle2.putString("Referer", "https://cgi.connect.qq.com/");
        bundle2.putString("Cookie", "p_skey=" + pskey + ";p_uin=" + account + ";uin=" + account);
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("appid=");
        sb6.append(str);
        sb5.append(sb6.toString());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle2);
        hashMap.put("CONTEXT", context);
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendUtil", 2, "old checkApiState params = " + bundle2);
        }
        new f(sb5.toString(), "GET", aVar, i3, bundle).b(hashMap);
    }

    public static long c(String str) {
        long parseLong;
        if (str == null) {
            return 0L;
        }
        if (!str.isEmpty()) {
            try {
                parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    public static boolean d(int i3, int i16, boolean z16) {
        if (i3 == 0 || i3 != 100 || z16) {
            return false;
        }
        return true;
    }

    public static int e(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        if (bArr.length % 3 == 0) {
            return bArr.length / 3;
        }
        return (bArr.length / 3) + 1;
    }

    public static AppInterface f() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendUtil", 2, "getAppInterface MobileQQ peek NULL!!!");
            }
            return null;
        }
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendUtil", 2, "getAppInterface MobileQQ peek not AppInterface!!!");
            }
            return null;
        }
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static String g(AppRuntime appRuntime) {
        String account = appRuntime.getAccount();
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(account, "AddFriendUtil")) {
            return account;
        }
        return h(appRuntime, account);
    }

    public static String h(AppRuntime appRuntime, String str) {
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, "AddFriendUtil")) {
            return str;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "AddFriendUtil") == null) {
            return str;
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(uidFromUin);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    public static String i(AppInterface appInterface, int i3) {
        Groups group;
        if (appInterface == null || (group = ((IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "")).getGroup(i3)) == null) {
            return "";
        }
        return group.group_name;
    }

    public static String j(String str) {
        while (e(str) > 32) {
            int length = str.length();
            if (length >= 2) {
                int i3 = length - 2;
                if (Character.isHighSurrogate(str.charAt(i3))) {
                    str = str.substring(0, i3);
                }
            }
            str = str.substring(0, length - 1);
        }
        return str;
    }

    public static String k(AppRuntime appRuntime, String str, String str2) {
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return "";
        }
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "AddFriendUtil");
        if (troopMemberInfoSync != null && troopMemberInfoSync.isValidMember()) {
            String showName = troopMemberInfoSync.nickInfo.getShowName();
            if (!TextUtils.isEmpty(showName) && !showName.equals(str2)) {
                return troopMemberInfoSync.nickInfo.getShowName();
            }
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "");
        if (iTroopInfoService == null) {
            return "";
        }
        TroopMemberInfo troopMemberInfoSync2 = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(iTroopInfoService.getTroopUin(str), str2, null, "AddFriendUtil");
        if (troopMemberInfoSync2 == null) {
            return "";
        }
        return troopMemberInfoSync2.nickInfo.getShowName();
    }

    public static String l(AppInterface appInterface, String str) {
        ITroopInfoService iTroopInfoService;
        if (appInterface == null || TextUtils.isEmpty(str) || (iTroopInfoService = (ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")) == null) {
            return "";
        }
        String troopNameByID = iTroopInfoService.getTroopNameByID(str);
        if (!str.equals(troopNameByID)) {
            return troopNameByID;
        }
        String troopUin = iTroopInfoService.getTroopUin(str);
        String troopNameByID2 = iTroopInfoService.getTroopNameByID(troopUin);
        if (TextUtils.isEmpty(troopNameByID2) || troopNameByID2.equals(troopUin)) {
            return "";
        }
        return troopNameByID2;
    }

    public static boolean m(int i3, int i16) {
        if (i3 == 3016 || i3 == 3103 || i3 == 3090 || i3 == 3024 || i3 == 3007 || i3 == 3177 || i3 == 3912 || i3 == 3156) {
            return true;
        }
        if (i3 == 3094) {
            if (i16 == 21 || i16 == 16 || i16 == 22 || i16 == 23 || i16 == 24 || i16 == 25 || i16 == 26 || i16 == 27 || i16 == 28 || i16 == 29) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static List<LabelTag> n(oidb_cmd0x1004$Person oidb_cmd0x1004_person) {
        PBRepeatMessageField<oidb_cmd0x1004$Tag> pBRepeatMessageField;
        if (oidb_cmd0x1004_person != null && oidb_cmd0x1004_person.has() && (pBRepeatMessageField = oidb_cmd0x1004_person.tags) != null && pBRepeatMessageField.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < oidb_cmd0x1004_person.tags.size(); i3++) {
                String str = oidb_cmd0x1004_person.tags.get(i3).icon.get();
                String str2 = oidb_cmd0x1004_person.tags.get(i3).text.get();
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    LabelTag labelTag = new LabelTag();
                    labelTag.setIcon(str);
                    labelTag.setText(str2);
                    arrayList.add(labelTag);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static boolean o(int i3, String str) {
        if (!friendlist.a.a(i3) && i3 != 3016 && i3 != 3103 && i3 != 3024 && !TextUtils.isEmpty(str) && i3 != 3093 && !str.equals(String.valueOf(0L))) {
            return true;
        }
        return false;
    }

    public static boolean p(int i3) {
        if (!friendlist.a.a(i3) && i3 != 3016 && i3 != 3103 && i3 != 3003 && i3 != 3093 && i3 != 3912) {
            return false;
        }
        return true;
    }
}
