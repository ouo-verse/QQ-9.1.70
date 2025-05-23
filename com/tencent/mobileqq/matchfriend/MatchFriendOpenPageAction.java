package com.tencent.mobileqq.matchfriend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes15.dex */
public class MatchFriendOpenPageAction extends ax {
    static IPatchRedirector $redirector_;
    private static final Integer Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchFriendOpenPageAction.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                String string = bundle.getString("key_open_id");
                if (!TextUtils.isEmpty(string)) {
                    ((IQQStrangerUserInfoMgr) MatchFriendOpenPageAction.this.f307436a.getRuntimeService(IQQStrangerUserInfoMgr.class)).reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, string), null);
                }
                MatchFriendOpenPageAction.this.L();
            }
            QLog.i("MatchFriendOpenPageAction", 1, "scheme_enter_aio, isSuccess=" + z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            Q = 0;
        }
    }

    public MatchFriendOpenPageAction(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean G() {
        if (Z()) {
            return true;
        }
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchingFriend(this.f307437b);
        return true;
    }

    private int H(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                QLog.e("MatchFriendOpenPageAction", 1, "getInt:" + str);
            }
        }
        return i3;
    }

    private long I(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                QLog.e("MatchFriendOpenPageAction", 1, "getLong:" + str);
                return 0L;
            }
        }
        return 0L;
    }

    private String J(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private boolean K() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("MatchFriendOpenPageAction", 1, "scheme_enter_aio_fail, network not available");
            return true;
        }
        if (u.a().b()) {
            QLog.e("MatchFriendOpenPageAction", 1, "scheme_enter_aio_fail, fast click forbidden");
            return true;
        }
        QQStrangerUserInfo selfUserInfo = ((IQQStrangerUserInfoMgr) this.f307436a.getRuntimeService(IQQStrangerUserInfoMgr.class)).getSelfUserInfo();
        if (selfUserInfo != null && !TextUtils.isEmpty(selfUserInfo.openId)) {
            L();
        } else {
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).executeLoginRequest(new a());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        String str = this.f307441f.get("open_id");
        String str2 = this.f307441f.get("to_tiny_id");
        String str3 = this.f307441f.get("topic_id");
        String str4 = this.f307441f.get("source_id");
        String str5 = this.f307441f.get("feed_id");
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if ("1111111111111111FFFFFFFFFFFFFFFF".equals(str)) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterOfficialAccount(this.f307437b);
            return true;
        }
        int H = H(str4, 0);
        long I = I(str2);
        long I2 = I(str3);
        Bundle bundle = new Bundle();
        bundle.putLong("key_match_friend_topic_id", I2);
        if (!TextUtils.isEmpty(str5)) {
            bundle.putString("quote_feed_id", str5);
        }
        if (!TextUtils.isEmpty(str)) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(this.f307436a, this.f307437b, str, H, bundle);
        } else if (I > 0) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(this.f307437b, I, "", H, bundle);
        }
        return true;
    }

    private boolean M() {
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).launchAgeSelectFragment(this.f307437b);
        return true;
    }

    private boolean N() {
        int H = H(this.f307441f.get("app_id"), 0);
        String J = J(this.f307441f.get("feed_id"));
        String J2 = J(this.f307441f.get("open_id"));
        int H2 = H(this.f307441f.get("gender"), 0);
        int H3 = H(this.f307441f.get("source"), -1);
        if (this.f307437b != null && !TextUtils.isEmpty(J) && !TextUtils.isEmpty(J2)) {
            QLog.d("MatchFriendOpenPageAction", 1, "gotoFeedDetail appId=" + H + " feedId=" + J + " openId=" + J2 + " gender=" + H2 + " source=" + H3);
            if (Z()) {
                return true;
            }
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterFeedDetail(this.f307437b, H, J, J2, H2, H3);
            return true;
        }
        QLog.e("MatchFriendOpenPageAction", 1, "gotoFeedDetail param is invalid feedId=" + J + " openId=" + J2);
        return false;
    }

    private boolean O() {
        if (TextUtils.isEmpty(this.f307441f.get(INetChannelCallback.KEY_TINY_ID))) {
            return false;
        }
        String str = this.f307441f.get(INetChannelCallback.KEY_TINY_ID);
        if (Z()) {
            return true;
        }
        ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).startMatchFriendJubaoByScene(this.f307436a, this.f307437b, IMatchFriendJubaoApi.From.AIO, str, null, null);
        return true;
    }

    @Deprecated
    private boolean P() {
        try {
            String str = this.f307441f.get("is_check_needed");
            if (str != null && !"true".equals(str) && !((IQQStrangerDataApi) QRoute.api(IQQStrangerDataApi.class)).hasSaveMiniUserInfo()) {
                ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(this.f307437b, 2, Q.intValue(), "mqqapi://stranger/jump_liteactionlist_page");
                return true;
            }
            ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterLiteActionListPage(this.f307437b, new Intent());
            return true;
        } catch (Exception e16) {
            QLog.e("MatchFriendOpenPageAction", 1, "Forward to lite action list page meets exception: " + e16);
            return false;
        }
    }

    private boolean Q() {
        int i3 = 0;
        if (StudyModeManager.t()) {
            QLog.d("MatchFriendOpenPageAction", 1, "gotoMatchFriendHomePage jump fail: studyModeSwitch on");
            return false;
        }
        QLog.d("MatchFriendOpenPageAction", 1, "gotoMatchFriendHomePage jump success");
        String str = this.f307441f.get("from");
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            QLog.e("MatchFriendOpenPageAction", 1, "jumpHomePage parse error. actionType=" + str);
        }
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(this.f307437b, new com.tencent.mobileqq.matchfriend.reborn.api.a(2, i3, 1, null, 0, "0".equals(this.f307441f.get("support_guest"))));
        return true;
    }

    private boolean R() {
        int i3;
        String str = this.f307441f.get("action_type");
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            QLog.e("MatchFriendOpenPageAction", 1, "gotoMatchHome parse error. actionType=" + str);
            i3 = 0;
        }
        int i16 = i3;
        if (Z()) {
            return true;
        }
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(this.f307437b, new com.tencent.mobileqq.matchfriend.reborn.api.a(2, 0, 1, null, i16, false));
        return true;
    }

    private boolean S() {
        PublicFragmentActivity.start(this.f307437b, null, NotifyPushSettingFragment.class);
        return true;
    }

    private boolean T() {
        QLog.d("MatchFriendOpenPageAction", 1, "gotoMsgTab");
        if (Z()) {
            return true;
        }
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(this.f307437b, 2, 0, 0);
        return true;
    }

    private boolean U() {
        QLog.d("MatchFriendOpenPageAction", 1, "gotoNotification");
        if (Z()) {
            return true;
        }
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterLiteActionListPage(this.f307437b, new Intent());
        return true;
    }

    private boolean V() {
        int parseInt;
        int parseInt2;
        String str = this.f307441f.get("open_id");
        String str2 = this.f307441f.get("source_id");
        String str3 = this.f307441f.get("from_id");
        String str4 = this.f307441f.get("feed_id");
        if (TextUtils.isEmpty(str2)) {
            parseInt = 5;
        } else {
            parseInt = Integer.parseInt(str2);
        }
        int i3 = parseInt;
        if (Z()) {
            return true;
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        Context context = this.f307437b;
        if (TextUtils.isEmpty(str3)) {
            parseInt2 = 0;
        } else {
            parseInt2 = Integer.parseInt(str3);
        }
        iMatchFriendEntryApi.enterProfileCard(context, str, i3, parseInt2, str4);
        return true;
    }

    private boolean W() {
        int parseInt;
        String str = this.f307441f.get(INetChannelCallback.KEY_TINY_ID);
        String str2 = this.f307441f.get("from_id");
        if (Z()) {
            return true;
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        BaseQQAppInterface baseQQAppInterface = this.f307436a;
        Context context = this.f307437b;
        long parseLong = Long.parseLong(str);
        if (TextUtils.isEmpty(str2)) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(str2);
        }
        iMatchFriendEntryApi.enterProfileCard(baseQQAppInterface, context, parseLong, 0, parseInt);
        return true;
    }

    private boolean X() {
        long j3;
        String str = this.f307441f.get("partner_id");
        if (!TextUtils.isEmpty(str)) {
            j3 = I(str);
        } else {
            j3 = 0;
        }
        if (Z()) {
            return true;
        }
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterSignalSquare(this.f307437b, j3);
        return true;
    }

    private boolean Y() {
        if (this.f307437b == null) {
            QLog.e("MatchFriendOpenPageAction", 1, "launchQQStrangerFeedPublish but context is null");
            return false;
        }
        if (Z()) {
            return true;
        }
        int H = H(this.f307441f.get("source"), 0);
        Intent intent = new Intent();
        intent.putExtra("key_source", H);
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).launchFeedPublish(this.f307437b, intent);
        return true;
    }

    private boolean Z() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean hasLogin = ((IQQStrangerRuntimeService) peekAppRuntime.getRuntimeService(IQQStrangerRuntimeService.class, "")).hasLogin();
        boolean hasRegister = ((IQQStrangerRuntimeService) peekAppRuntime.getRuntimeService(IQQStrangerRuntimeService.class, "")).hasRegister();
        if (hasLogin && hasRegister) {
            return false;
        }
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(this.f307437b, new com.tencent.mobileqq.matchfriend.reborn.api.a(2, 0, 1, this.f307438c, 0, false));
        return true;
    }

    private void a0() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.MatchFriendOpenPageAction.2
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.matchfriend.MatchFriendOpenPageAction$2$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchFriendOpenPageAction.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(QBaseActivity.sTopActivity, 230);
                createCustomDialog.setMessage("\u62b1\u6b49\uff0c\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u652f\u6301\u8bbf\u95ee");
                createCustomDialog.setPositiveButton("\u6211\u77e5\u9053\u4e86", new a());
                createCustomDialog.show();
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.d("MatchFriendOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d("MatchFriendOpenPageAction", 1, "doAction jump fail: studyModeSwitch on");
            a0();
            return false;
        }
        try {
            String str = this.f307440e;
            switch (str.hashCode()) {
                case -1864052018:
                    if (str.equals("publish_feed")) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1722508652:
                    if (str.equals("signal_square")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1644098897:
                    if (str.equals("feed_info")) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1076319305:
                    if (str.equals("immediate_match")) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -849676261:
                    if (str.equals("jump_liteactionlist_page")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 96583:
                    if (str.equals("aio")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 101476069:
                    if (str.equals("jubao")) {
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 401172254:
                    if (str.equals("jump_home_page")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 417874450:
                    if (str.equals("feed_detail")) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 595233003:
                    if (str.equals("notification")) {
                        c16 = 14;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 749577972:
                    if (str.equals("open_age_selector")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1216225589:
                    if (str.equals("user_profile")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1344073175:
                    if (str.equals("msg_tab")) {
                        c16 = '\r';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1779528338:
                    if (str.equals("message_notify_setting")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1864902425:
                    if (str.equals("match_home")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    return Q();
                case 1:
                    if (!TextUtils.isEmpty(this.f307441f.get("open_id"))) {
                        return V();
                    }
                    return W();
                case 2:
                    return K();
                case 3:
                    return R();
                case 4:
                    return O();
                case 5:
                    return M();
                case 6:
                    return S();
                case 7:
                    return P();
                case '\b':
                    return X();
                case '\t':
                    return Y();
                case '\n':
                    return G();
                case 11:
                case '\f':
                    return N();
                case '\r':
                    return T();
                case 14:
                    return U();
                default:
                    return true;
            }
        } catch (Exception e16) {
            QLog.e("MatchFriendOpenPageAction", 1, "doAction error: " + e16.getMessage());
            i("MatchFriendOpenPageAction");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            super.i(str);
        }
    }
}
