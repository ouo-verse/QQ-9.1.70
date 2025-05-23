package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static c f185697a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, Integer> f185698b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Integer, Integer> f185699c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<Integer, String> f185700d;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<String, com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b> f185701e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f185698b = new HashMap();
        f185699c = new HashMap();
        f185700d = new HashMap();
        f185701e = new HashMap<>();
        try {
            f185697a = com.tencent.mobileqq.activity.recent.msgbox.inject.a.f185703b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("TempMsgBoxUtil", 1, "registerCallback error: ", e16);
        }
        f185700d.put(10007, "tempGameMsg");
        f185700d.put(1024, IPublicAccountJavascriptInterface.NAME_SPACE);
        f185698b.put(1000, Integer.valueOf(R.string.f2053255a));
        f185698b.put(1004, Integer.valueOf(R.string.f2053255a));
        f185698b.put(1006, Integer.valueOf(R.string.f2053455c));
        f185698b.put(1023, Integer.valueOf(R.string.f2053555d));
        f185698b.put(1022, Integer.valueOf(R.string.f2053955h));
        f185698b.put(10010, Integer.valueOf(R.string.f20530559));
        f185698b.put(1024, Integer.valueOf(R.string.f2053155_));
        f185698b.put(1005, Integer.valueOf(R.string.f2054055i));
        f185699c.put(1000, 0);
        f185699c.put(1004, 1);
        f185699c.put(1006, 130);
        f185699c.put(1023, 133);
        f185699c.put(1022, 134);
        f185699c.put(10010, 167);
    }

    public static void a(int i3, String str, MsgSummary msgSummary) {
        if (i3 == 10011 && !TextUtils.isEmpty(str)) {
            msgSummary.strPrefix = str;
        }
    }

    public static HashMap<String, com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b> b() {
        return f185701e;
    }

    public static Map<Integer, String> c() {
        return f185700d;
    }

    @NonNull
    private static List<ConversationInfo> d(Set<ConversationInfo> set, AppInterface appInterface) {
        ArrayList arrayList = new ArrayList();
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) appInterface.getRuntimeService(ITempMsgBoxManager.class, "");
        for (ConversationInfo conversationInfo : set) {
            if (iTempMsgBoxManager.isBelongToFilterBox(conversationInfo.uin, conversationInfo.type)) {
                arrayList.add(conversationInfo);
            }
        }
        return arrayList;
    }

    public static Map<Integer, Integer> e() {
        return f185699c;
    }

    public static Map<Integer, Integer> f() {
        return f185698b;
    }

    public static int g(AppInterface appInterface) {
        return 0;
    }

    public static int h(boolean z16, boolean z17) {
        if (!z16) {
            return 2;
        }
        if (z17) {
            return 1;
        }
        return 0;
    }

    public static String i(AppInterface appInterface, RecentUser recentUser) {
        String str;
        com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b bVar;
        int type = recentUser.getType();
        com.tencent.mobileqq.activity.recent.msgbox.tempchat.a tempChatPlugin = ((ITempChatPluginManager) appInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(type);
        if (tempChatPlugin != null) {
            return tempChatPlugin.c(recentUser.uin);
        }
        String str2 = f185700d.get(Integer.valueOf(type));
        if (str2 == null || (bVar = f185701e.get(str2)) == null) {
            str = "";
        } else {
            str = bVar.c(appInterface, recentUser.uin);
        }
        if (type == 1000) {
            return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getTroopNickName(recentUser.uin, ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(recentUser.troopUin), recentUser.troopUin, true, null);
        }
        if (type == 1004) {
            String discussionMemberShowName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getDiscussionMemberShowName(recentUser.troopUin, recentUser.uin);
            if (discussionMemberShowName != null && discussionMemberShowName.equals(recentUser.uin)) {
                return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(recentUser.uin, true);
            }
            return discussionMemberShowName;
        }
        if (type == 1006) {
            return j(appInterface, recentUser);
        }
        if (TextUtils.isEmpty(str)) {
            return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(recentUser.uin, true);
        }
        return str;
    }

    private static String j(AppInterface appInterface, RecentUser recentUser) {
        IPhoneContactService iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
        String uinByPhoneNum = iPhoneContactService.getUinByPhoneNum(recentUser.uin);
        PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(recentUser.uin);
        if (queryContactByCodeNumber != null) {
            return queryContactByCodeNumber.name;
        }
        if (uinByPhoneNum != null) {
            return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(uinByPhoneNum, true);
        }
        return recentUser.uin;
    }

    public static ConversationInfo k(ConversationInfo conversationInfo) {
        if (conversationInfo == null) {
            return new ConversationInfo();
        }
        if (TextUtils.equals(conversationInfo.uin, AppConstants.FILTER_MSG_UIN)) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            List<ConversationInfo> d16 = d(((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet(), appInterface);
            ConversationInfo conversationInfo2 = new ConversationInfo();
            for (ConversationInfo conversationInfo3 : d16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TempMsgBoxUtil", 2, "onGetUnreadCount() called with: info = [" + conversationInfo3 + "]");
                }
                if (conversationInfo3.type == 7000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TempMsgBoxUtil", 2, "onGetUnreadCount() called skip UIN_TYPE_SUBACCOUNT_ASSISTANT ");
                    }
                } else {
                    conversationInfo2.setUnread(conversationInfo2.unreadCount + conversationInfo3.unreadCount);
                    conversationInfo2.setUnreadMark(conversationInfo2.unreadMark + conversationInfo3.unreadMark);
                }
            }
            return conversationInfo2;
        }
        return conversationInfo;
    }

    public static void l() {
        HashMap<String, Class<? extends com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b>> hashMap = com.tencent.mobileqq.activity.recent.msgbox.inject.a.f185702a;
        for (String str : hashMap.keySet()) {
            Class<? extends com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b> cls = hashMap.get(str);
            if (cls != null) {
                try {
                    f185701e.put(str, cls.newInstance());
                } catch (Exception e16) {
                    QLog.e("TempMsgBoxUtil", 1, "registerBusinessHandler error: ", e16);
                }
            }
        }
    }

    public static void m(AppInterface appInterface, boolean z16) {
    }

    public static void n(AppInterface appInterface, Object obj) {
    }
}
