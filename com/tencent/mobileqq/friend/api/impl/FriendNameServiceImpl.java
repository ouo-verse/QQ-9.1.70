package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.friend.inject.b;
import com.tencent.mobileqq.friend.name.a;
import com.tencent.mobileqq.friend.name.c;
import com.tencent.mobileqq.friend.name.d;
import com.tencent.mobileqq.friend.name.e;
import com.tencent.mobileqq.friend.name.f;
import com.tencent.mobileqq.friend.name.g;
import com.tencent.mobileqq.friend.name.h;
import com.tencent.mobileqq.friend.name.i;
import com.tencent.mobileqq.friend.utils.MMKForUinUid;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ev;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FriendNameServiceImpl implements IFriendNameService {
    static IPatchRedirector $redirector_ = null;
    private static final String SEPARATOR = "_";
    private static final String STRATEGY_KEY_ACCOUNT_NAME;
    private static final String STRATEGY_KEY_FRIEND_ALIAS;
    private static final String STRATEGY_KEY_FRIEND_NICK;
    private static final String STRATEGY_KEY_FRIEND_REMARK;
    private static final String STRATEGY_KEY_FRIEND_UIN;
    private static final String STRATEGY_KEY_PHONE_CONTACT;
    private static final String STRATEGY_KEY_PROFILE_CARD;
    private static final String STRATEGY_KEY_PUBLIC_ACCOUNT;
    private static final String TAG = "IMCore.friend.FriendNameServiceImpl";
    private static final String UID_PREFIX_KEY = "uid_prefix_key";
    private b mContactFacadeService;
    private IFriendDataService mFriendDataService;
    private HashMap<String, c> mFriendNameStrategies;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        STRATEGY_KEY_ACCOUNT_NAME = a.class.getSimpleName();
        STRATEGY_KEY_FRIEND_REMARK = h.class.getSimpleName();
        STRATEGY_KEY_PHONE_CONTACT = e.class.getSimpleName();
        STRATEGY_KEY_FRIEND_NICK = d.class.getSimpleName();
        STRATEGY_KEY_PROFILE_CARD = f.class.getSimpleName();
        STRATEGY_KEY_FRIEND_ALIAS = com.tencent.mobileqq.friend.name.b.class.getSimpleName();
        STRATEGY_KEY_FRIEND_UIN = i.class.getSimpleName();
        STRATEGY_KEY_PUBLIC_ACCOUNT = g.class.getSimpleName();
    }

    public FriendNameServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getBuddyName(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_PUBLIC_ACCOUNT);
        arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        return getFriendName(str, arrayList, z16);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getFriendAlias(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_FRIEND_ALIAS);
        arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        return getFriendName(str, arrayList);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getFriendName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getFriendName(str, true) : (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getFriendNick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_FRIEND_NICK);
        arrayList.add(STRATEGY_KEY_PROFILE_CARD);
        arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        return getFriendName(str, arrayList);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getFriendRemark(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_FRIEND_REMARK);
        arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        return getFriendName(str, arrayList);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getPhoneContactName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_PHONE_CONTACT);
        arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        return getFriendName(str, arrayList);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mFriendDataService = (IFriendDataService) appRuntime.getRuntimeService(IFriendDataService.class, "all");
        HashMap<String, c> hashMap = new HashMap<>();
        this.mFriendNameStrategies = hashMap;
        hashMap.put(STRATEGY_KEY_ACCOUNT_NAME, new a());
        this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_REMARK, new h());
        this.mFriendNameStrategies.put(STRATEGY_KEY_PHONE_CONTACT, new e());
        this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_NICK, new d());
        this.mFriendNameStrategies.put(STRATEGY_KEY_PROFILE_CARD, new f());
        this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_ALIAS, new com.tencent.mobileqq.friend.name.b());
        this.mFriendNameStrategies.put(STRATEGY_KEY_FRIEND_UIN, new i());
        this.mFriendNameStrategies.put(STRATEGY_KEY_PUBLIC_ACCOUNT, new g());
        this.mContactFacadeService = com.tencent.mobileqq.friend.inject.a.a();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public void saveFriendRemark(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        String c16 = MMKForUinUid.c("uid_prefix_key_" + str, "");
        if (c16 == null) {
            return;
        }
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(c16, str);
        dVar.M();
        if (str2 == null) {
            QLog.d(TAG, 1, "saveFriendRemark, remark is null");
            str2 = "";
        }
        dVar.m0(str2);
        dVar.g0(System.currentTimeMillis());
        iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TAG, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendNameService
    public String getFriendName(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(STRATEGY_KEY_FRIEND_REMARK);
        arrayList.add(STRATEGY_KEY_PHONE_CONTACT);
        arrayList.add(STRATEGY_KEY_FRIEND_NICK);
        if (z16) {
            arrayList.add(STRATEGY_KEY_FRIEND_UIN);
        }
        return getFriendName(str, arrayList);
    }

    private String getFriendName(String str, List<String> list) {
        return getFriendName(str, list, false);
    }

    private String getFriendName(String str, List<String> list, boolean z16) {
        b bVar;
        String str2 = null;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(ev.b(str), TAG);
        Iterator<String> it = list.iterator();
        String str3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            c cVar = this.mFriendNameStrategies.get(next);
            if (cVar != null) {
                str3 = cVar.a(str, friendsSimpleInfoWithUid);
                if (!TextUtils.isEmpty(str3)) {
                    str2 = next;
                    break;
                }
            }
        }
        if (z16 && ((TextUtils.isEmpty(str2) || STRATEGY_KEY_FRIEND_UIN.equals(str2)) && (bVar = this.mContactFacadeService) != null)) {
            bVar.a(str);
        }
        return str3;
    }
}
