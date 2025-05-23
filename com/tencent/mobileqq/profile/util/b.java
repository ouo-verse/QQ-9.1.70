package com.tencent.mobileqq.profile.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardArkMsgOption;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profile.util.b;
import com.tencent.mobileqq.profilecard.utils.ProfileCardShareBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQToastUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x11b2.oidb_0x11b2$BusinessCardV3Req;
import tencent.im.oidb.cmd0x11b2.oidb_0x11b2$BusinessCardV3Rsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f260351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProfileCardShareBean f260352b;

        a(Activity activity, ProfileCardShareBean profileCardShareBean) {
            this.f260351a = activity;
            this.f260352b = profileCardShareBean;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) profileCardShareBean);
            }
        }

        @Override // com.tencent.mobileqq.profile.util.b.e
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Activity activity = this.f260351a;
            if (activity != null && !activity.isFinishing()) {
                Intent k3 = b.k(this.f260351a, str);
                if (this.f260352b.useBottomPreviewFS) {
                    k3.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
                }
                this.f260351a.startActivity(k3);
                return;
            }
            QLog.e("ProfileCardShareUtil", 1, "shareArkToFriend activity is null or finished!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8248b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f260353d;

        C8248b(e eVar) {
            this.f260353d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                oidb_0x11b2$BusinessCardV3Rsp oidb_0x11b2_businesscardv3rsp = new oidb_0x11b2$BusinessCardV3Rsp();
                try {
                    oidb_0x11b2_businesscardv3rsp.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNetNew mergeFrom error: ", e16);
                }
                String str = oidb_0x11b2_businesscardv3rsp.signed_ark_msg.get();
                if (TextUtils.isEmpty(str)) {
                    QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNetNew fail, rsp.signed_ark_msg.get data is null!");
                    QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
                }
                e eVar = this.f260353d;
                if (eVar != null) {
                    eVar.a(str);
                    return;
                }
                return;
            }
            QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNetNew, server error:" + i3);
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
            this.f260353d.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f260354d;

        c(e eVar) {
            this.f260354d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                oidb_0x11b2$BusinessCardV3Rsp oidb_0x11b2_businesscardv3rsp = new oidb_0x11b2$BusinessCardV3Rsp();
                try {
                    oidb_0x11b2_businesscardv3rsp.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCardShareUtil", 2, "getArkMessageFromNet, merge data is error!");
                    }
                    String str = oidb_0x11b2_businesscardv3rsp.signed_ark_msg.get();
                    if (TextUtils.isEmpty(str)) {
                        QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNet fail, rsp.signed_ark_msg.get data is null!");
                        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
                        return;
                    } else {
                        e eVar = this.f260354d;
                        if (eVar == null) {
                            return;
                        }
                        eVar.a(str);
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardShareUtil", 2, "getArkMessageFromNet, server error:" + i3);
            }
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a(Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        void a(String str);
    }

    public static void b(final Activity activity, ProfileCardShareBean profileCardShareBean, final d dVar) {
        e(profileCardShareBean, new e() { // from class: com.tencent.mobileqq.profile.util.a
            @Override // com.tencent.mobileqq.profile.util.b.e
            public final void a(String str) {
                b.l(b.d.this, activity, str);
            }
        });
    }

    public static String c(String str) {
        JSONObject i3 = i(str);
        if (i3 == null) {
            return "";
        }
        return i3.optString("androidJumpUrl");
    }

    public static void d(AppRuntime appRuntime, ProfileCardShareBean profileCardShareBean, e eVar) {
        if (appRuntime == null && (appRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNet app is null!");
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        } else if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        } else if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("AndroidProfileCardShareWithV3Key", false)) {
            f(appRuntime, profileCardShareBean, eVar);
        }
    }

    public static void e(ProfileCardShareBean profileCardShareBean, e eVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ProfileCardShareUtil", 1, "getArkMessageFromNetNew app is null");
            eVar.a(null);
        } else {
            ProtoUtils.a(peekAppRuntime, new C8248b(eVar), h(profileCardShareBean).toByteArray(), "OidbSvcTrpcTcp.0x11ca_0", 4790, 0);
        }
    }

    private static void f(AppRuntime appRuntime, ProfileCardShareBean profileCardShareBean, e eVar) {
        ProtoUtils.a(appRuntime, new c(eVar), h(profileCardShareBean).toByteArray(), "OidbSvcTrpcTcp.0x11ca_0", 4790, 0);
    }

    public static String g(String str) {
        JSONObject i3 = i(str);
        if (i3 == null) {
            return "";
        }
        return i3.optString("avatar");
    }

    public static oidb_0x11b2$BusinessCardV3Req h(ProfileCardShareBean profileCardShareBean) {
        oidb_0x11b2$BusinessCardV3Req oidb_0x11b2_businesscardv3req = new oidb_0x11b2$BusinessCardV3Req();
        if (profileCardShareBean.getUin() == 0) {
            oidb_0x11b2_businesscardv3req.phone.set(profileCardShareBean.getPhone());
        } else {
            oidb_0x11b2_businesscardv3req.uin.set(profileCardShareBean.getUin());
        }
        oidb_0x11b2_businesscardv3req.jump_url.set(profileCardShareBean.getIosJumpUrl());
        return oidb_0x11b2_businesscardv3req;
    }

    public static JSONObject i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String optString = new JSONObject(str).optString(PublicAccountMessageUtilImpl.META_NAME);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            String optString2 = new JSONObject(optString).optString("contact");
            if (TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new JSONObject(optString2);
        } catch (JSONException unused) {
            QLog.e("ProfileCardShareUtil", 1, "getContactJsonFromData is error!");
            return null;
        }
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString(DownloadInfo.spKey_Config);
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            return new JSONObject(optString).optString("forward").equals("1");
        } catch (JSONException unused) {
            QLog.e("ProfileCardShareUtil", 1, "getIsForwardFromArkJson is error!");
            return false;
        }
    }

    public static Intent k(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        try {
            intent.putExtra("forward_type", 53);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", com.tencent.relation.common.utils.c.d(str, ""));
            intent.putExtra("forward_ark_app_view", com.tencent.relation.common.utils.c.g(str, ""));
            intent.putExtra("forward_ark_app_ver", com.tencent.relation.common.utils.c.f(str, Constants.DEFAULT_MIN_APP_VERSION));
            intent.putExtra("forward_ark_app_prompt", com.tencent.relation.common.utils.c.e(str, "\u63a8\u8350\u8054\u7cfb\u4eba~"));
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, com.tencent.relation.common.utils.c.b(str));
            intent.putExtra("k_dataline", false);
            String c16 = com.tencent.relation.common.utils.c.c(str);
            intent.putExtra("forward_ark_app_meta", c16);
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardShareUtil", 2, "getShareArkIntent metaDataString: " + c16);
            }
            String a16 = com.tencent.relation.common.utils.c.a(str, null);
            if (a16 != null) {
                intent.putExtra("forward_ark_biz_src", a16);
            }
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(com.tencent.relation.common.utils.c.d(str, ""), com.tencent.relation.common.utils.c.g(str, ""), com.tencent.relation.common.utils.c.f(str, Constants.DEFAULT_MIN_APP_VERSION), c16, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
        } catch (Exception e16) {
            QLog.e("ProfileCardShareUtil", 1, "getShareArkIntent exception", e16);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(d dVar, Activity activity, String str) {
        if (str == null) {
            dVar.a(null);
        } else {
            dVar.a(k(activity, str));
        }
    }

    public static boolean m() {
        return com.tencent.relation.common.config.toggle.c.f364693f.g(true);
    }

    public static void n(QQAppInterface qQAppInterface, Bundle bundle, SessionInfo sessionInfo) {
        ForwardArkMsgOption.n(bundle, qQAppInterface, sessionInfo.f179557e, sessionInfo.f179555d, sessionInfo.f179559f, 0);
    }

    public static void o(AppInterface appInterface, Activity activity, ProfileCardShareBean profileCardShareBean) {
        d(appInterface, profileCardShareBean, new a(activity, profileCardShareBean));
    }
}
