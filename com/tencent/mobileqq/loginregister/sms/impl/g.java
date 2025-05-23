package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.impl.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.AccountType;
import com.tencent.qqnt.kernel.nativeinterface.AppInfo;
import com.tencent.qqnt.kernel.nativeinterface.CheckSmsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.GetSmsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.UserInfo;
import com.tencent.qqnt.kernel.nativeinterface.VerifySuccessSign;
import com.tencent.qqnt.kernel.nativeinterface.VerifyType;
import cooperation.qzone.QzoneIPCModule;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\"\u0010\u001d\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001f\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010 \u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eJ&\u0010%\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010*\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J \u0010.\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011R\u0014\u00100\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010/R\u0014\u00102\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00103R\u0018\u0010$\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00106R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00101R\u0018\u00109\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010/\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/impl/g;", "Lcom/tencent/mobileqq/loginregister/sms/b;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/loginregister/sms/c;", "smsPageFunc", "Lcom/tencent/qqnt/kernel/nativeinterface/GetSmsReqBody;", "getSmsReq", "", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/UserInfo;", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/AppInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", ReportConstant.COSTREPORT_PREFIX, "msg", "", "icon", "y", "msgStr", "u", tl.h.F, "onActivityResume", "onActivityDestroy", "", "hasClickSendSms", "", "clickOtherVerifyBtnLastTime", "f", "e", "b", "g", "urlString", "parameterName", "r", "smsCode", "c", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "a", "str", "type", "errCode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/lang/String;", "TAG", "I", "SECONDS_60", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mActivity", "d", "Lcom/tencent/mobileqq/loginregister/sms/c;", "mCommonSmsView", "mEntrance", "phoneNum", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g implements com.tencent.mobileqq.loginregister.sms.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int SECONDS_60;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity mActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String smsCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.sms.c mCommonSmsView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mEntrance;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String phoneNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/loginregister/sms/impl/g$a", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242985b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GetSmsReqBody f242986c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f242987d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.sms.c f242988e;

        a(LoginResult loginResult, GetSmsReqBody getSmsReqBody, QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar) {
            this.f242985b = loginResult;
            this.f242986c = getSmsReqBody;
            this.f242987d = qBaseActivity;
            this.f242988e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, g.this, loginResult, getSmsReqBody, qBaseActivity, cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(g this$0, QBaseActivity qBaseActivity, com.tencent.mobileqq.loginregister.sms.c cVar, GetSmsReqBody getSmsReq) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(getSmsReq, "$getSmsReq");
            this$0.v(qBaseActivity, cVar, getSmsReq);
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d(g.this.TAG, 1, "onVerifyCancel cancel resend Sms");
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
            byte[] bArr;
            byte[] bArr2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), ticket, randStr, appId);
                return;
            }
            Iframe iframe = new Iframe();
            byte[] bArr3 = null;
            if (ticket != null) {
                bArr = ticket.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            iframe.iframeSig = bArr;
            if (randStr != null) {
                bArr2 = randStr.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr2 = null;
            }
            iframe.iframeRandstr = bArr2;
            g gVar = g.this;
            String str = this.f242985b.rspInfo.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str, "loginResult.rspInfo.jumpUrl");
            String r16 = gVar.r(str, "sid");
            if (r16 != null) {
                bArr3 = r16.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
            }
            iframe.iframeSid = bArr3;
            VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
            verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_CAPTCHA;
            verifySuccessSign.iframe = iframe;
            GetSmsReqBody getSmsReqBody = this.f242986c;
            getSmsReqBody.verifySign = verifySuccessSign;
            getSmsReqBody.loginContext = this.f242985b.rspInfo.loginContext;
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final g gVar2 = g.this;
            final QBaseActivity qBaseActivity = this.f242987d;
            final com.tencent.mobileqq.loginregister.sms.c cVar = this.f242988e;
            final GetSmsReqBody getSmsReqBody2 = this.f242986c;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.a.d(g.this, qBaseActivity, cVar, getSmsReqBody2);
                }
            });
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "SmsVerifyComponent.NTPhoneLoginVerifyCodeApiImpl";
            this.SECONDS_60 = 60;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final g this$0, final com.tencent.mobileqq.loginregister.sms.c cVar, final QBaseActivity qBaseActivity, final int i3, final String str, final LoginResult loginResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "checkSms result : " + i3 + ", errMsg: " + str);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                g.p(com.tencent.mobileqq.loginregister.sms.c.this, loginResult, this$0, qBaseActivity, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(com.tencent.mobileqq.loginregister.sms.c cVar, LoginResult loginResult, g this$0, QBaseActivity qBaseActivity, int i3, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cVar.dismissDialog();
        if (loginResult.rspInfo.errCode != 0) {
            Intrinsics.checkNotNull(qBaseActivity);
            this$0.z(qBaseActivity.getString(R.string.f173065h22), 1, i3);
            com.tencent.mobileqq.loginregister.sms.c cVar2 = this$0.mCommonSmsView;
            Intrinsics.checkNotNull(cVar2);
            cVar2.clearWrongCode();
            if (TextUtils.isEmpty(str)) {
                QBaseActivity qBaseActivity2 = this$0.mActivity;
                Intrinsics.checkNotNull(qBaseActivity2);
                str2 = qBaseActivity2.getString(R.string.f173065h22);
            } else {
                str2 = str;
            }
            QBaseActivity qBaseActivity3 = this$0.mActivity;
            Intrinsics.checkNotNull(qBaseActivity3);
            ReportController.r(qBaseActivity3.getAppRuntime(), "dc00898", "", this$0.s(), "0X800B10B", "0X800B10B", this$0.mEntrance, 0, "", "", str2, "");
            return;
        }
        QBaseActivity qBaseActivity4 = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity4);
        ReportController.r(qBaseActivity4.getAppRuntime(), "dc00898", "", this$0.s(), "0X800B10C", "0X800B10C", this$0.mEntrance, 0, "", "", "", "");
        QBaseActivity qBaseActivity5 = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity5);
        IRuntimeService runtimeService = qBaseActivity5.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mActivity!!.appRuntime.g\u2026                        )");
        ((ISmsVerifyCodeService) runtimeService).handleNTPhoneLoginSmsVerifySuccess(this$0.mActivity, loginResult);
        QBaseActivity qBaseActivity6 = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity6);
        qBaseActivity6.finish();
    }

    private final AppInfo q(QBaseActivity activity) {
        Boolean bool;
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null) {
            bool = Boolean.valueOf(intent.getBooleanExtra("is_open_sdk_add_account", false));
        } else {
            bool = null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.appName = "com.tencent.mobileqq";
        appInfo.qua = BaseApplication.getContext().getQua();
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            appInfo.appId = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            appInfo.appId = 16L;
        }
        return appInfo;
    }

    private final String s() {
        QBaseActivity qBaseActivity = this.mActivity;
        Intrinsics.checkNotNull(qBaseActivity);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime == null || appRuntime.isLogin()) {
            return "";
        }
        String str = this.phoneNum;
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final UserInfo t(QBaseActivity activity) {
        String str;
        Intent intent;
        UserInfo userInfo = new UserInfo();
        userInfo.accountType = AccountType.ACCOUNTTYPE_PHONENUM;
        userInfo.account = this.phoneNum;
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("key");
        } else {
            str = null;
        }
        if (str != null) {
            userInfo.countryCode = Integer.parseInt(str);
        }
        return userInfo;
    }

    private final void u(String msgStr, int icon) {
        boolean z16;
        boolean endsWith$default;
        if (msgStr != null && msgStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(msgStr, "\n", false, 2, null);
            if (endsWith$default) {
                msgStr = msgStr.substring(0, msgStr.length() - 1);
                Intrinsics.checkNotNullExpressionValue(msgStr, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            QQToast.makeText(this.mActivity, icon, msgStr, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(final QBaseActivity activity, final com.tencent.mobileqq.loginregister.sms.c smsPageFunc, final GetSmsReqBody getSmsReq) {
        ((ILoginService) QRoute.api(ILoginService.class)).getSms(getSmsReq, new ILoginCallback() { // from class: com.tencent.mobileqq.loginregister.sms.impl.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
            public final void onResult(int i3, String str, LoginResult loginResult) {
                g.w(g.this, activity, smsPageFunc, getSmsReq, i3, str, loginResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final g this$0, final QBaseActivity qBaseActivity, final com.tencent.mobileqq.loginregister.sms.c cVar, final GetSmsReqBody getSmsReq, final int i3, final String str, final LoginResult loginResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(getSmsReq, "$getSmsReq");
        QLog.d(this$0.TAG, 1, "resendSms result: " + i3 + " errorMsg: " + str);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                g.x(g.this, i3, qBaseActivity, str, loginResult, cVar, getSmsReq);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(g this$0, int i3, QBaseActivity qBaseActivity, String str, LoginResult loginResult, com.tencent.mobileqq.loginregister.sms.c cVar, GetSmsReqBody getSmsReq) {
        Intent intent;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(getSmsReq, "$getSmsReq");
        QBaseActivity qBaseActivity2 = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity2);
        if (qBaseActivity2.isFinishing()) {
            return;
        }
        if (i3 != 0) {
            Intrinsics.checkNotNull(qBaseActivity);
            this$0.z(qBaseActivity.getString(R.string.f173065h22), 1, i3);
            if (TextUtils.isEmpty(str)) {
                QBaseActivity qBaseActivity3 = this$0.mActivity;
                Intrinsics.checkNotNull(qBaseActivity3);
                str2 = qBaseActivity3.getString(R.string.f173065h22);
            } else {
                str2 = str;
            }
            QBaseActivity qBaseActivity4 = this$0.mActivity;
            Intrinsics.checkNotNull(qBaseActivity4);
            ReportController.r(qBaseActivity4.getAppRuntime(), "dc00898", "", this$0.s(), "0X800B10B", "0X800B10B", this$0.mEntrance, 0, "", "", str2, "");
            return;
        }
        if (loginResult.rspInfo.errCode == 140022008) {
            new PuzzleVerifyComponent().d(2, loginResult.rspInfo.jumpUrl, new a(loginResult, getSmsReq, qBaseActivity, cVar));
        } else {
            if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
                intent.putExtra("sendSmsCookies", loginResult.rspInfo.loginContext);
            }
            com.tencent.mobileqq.loginregister.sms.c cVar2 = this$0.mCommonSmsView;
            Intrinsics.checkNotNull(cVar2);
            cVar2.startTimer(this$0.SECONDS_60);
        }
        if (cVar != null) {
            cVar.dismissDialog();
        }
    }

    private final void y(String msg2, int icon) {
        u(msg2, icon);
        QBaseActivity qBaseActivity = this.mActivity;
        Intrinsics.checkNotNull(qBaseActivity);
        as.g(qBaseActivity.getAppRuntime(), "0X800C1C7", "", this.mEntrance, msg2);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void a(@Nullable QBaseActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean b(@Nullable QBaseActivity activity, @NotNull com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(smsPageFunc, "smsPageFunc");
        smsPageFunc.startTimer(this.SECONDS_60);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean c(@Nullable final QBaseActivity activity, @Nullable final com.tencent.mobileqq.loginregister.sms.c smsPageFunc, @Nullable String smsCode) {
        String str;
        byte[] bArr;
        Intent intent;
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, activity, smsPageFunc, smsCode)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            Intrinsics.checkNotNull(activity);
            String string = activity.getString(R.string.b3j);
            Intrinsics.checkNotNullExpressionValue(string, "activity!!.getString(R.string.failedconnection)");
            y(string, 0);
            return false;
        }
        if (smsCode != null) {
            int length = smsCode.length() - 1;
            int i16 = 0;
            boolean z17 = false;
            while (i16 <= length) {
                if (!z17) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) smsCode.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z17) {
                    if (!z16) {
                        z17 = true;
                    } else {
                        i16++;
                    }
                } else {
                    if (!z16) {
                        break;
                    }
                    length--;
                }
            }
            str = smsCode.subSequence(i16, length + 1).toString();
        } else {
            str = smsCode;
        }
        if (!TextUtils.isEmpty(str)) {
            this.smsCode = smsCode;
            Intrinsics.checkNotNull(smsPageFunc);
            smsPageFunc.showLoadingDialog();
            QLog.d(this.TAG, 1, "commitSmsCode start...");
            CheckSmsReqBody checkSmsReqBody = new CheckSmsReqBody();
            checkSmsReqBody.userInfo = t(activity);
            checkSmsReqBody.smsCode = smsCode;
            if (activity != null && (intent = activity.getIntent()) != null) {
                bArr = intent.getByteArrayExtra("sendSmsCookies");
            } else {
                bArr = null;
            }
            checkSmsReqBody.loginContext = bArr;
            checkSmsReqBody.appInfo = q(activity);
            ((ILoginService) QRoute.api(ILoginService.class)).checkSms(checkSmsReqBody, new ILoginCallback() { // from class: com.tencent.mobileqq.loginregister.sms.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
                public final void onResult(int i17, String str2, LoginResult loginResult) {
                    g.o(g.this, smsPageFunc, activity, i17, str2, loginResult);
                }
            });
        } else {
            Intrinsics.checkNotNull(activity);
            String string2 = activity.getString(R.string.fz6);
            Intrinsics.checkNotNullExpressionValue(string2, "activity!!.getString(R.s\u2026ing.qr_input_verify_code)");
            y(string2, 0);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public /* synthetic */ void d(QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar) {
        com.tencent.mobileqq.loginregister.sms.a.a(this, qBaseActivity, j3, aVar);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void e(@Nullable QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean f(@Nullable QBaseActivity activity, boolean hasClickSendSms, long clickOtherVerifyBtnLastTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, this, activity, Boolean.valueOf(hasClickSendSms), Long.valueOf(clickOtherVerifyBtnLastTime))).booleanValue();
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean g(@Nullable QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            Intrinsics.checkNotNull(activity);
            String string = activity.getString(R.string.b3j);
            Intrinsics.checkNotNullExpressionValue(string, "activity!!.getString(R.string.failedconnection)");
            y(string, 0);
            return false;
        }
        Intrinsics.checkNotNull(smsPageFunc);
        smsPageFunc.showLoadingDialog();
        GetSmsReqBody getSmsReqBody = new GetSmsReqBody();
        getSmsReqBody.appInfo = q(activity);
        getSmsReqBody.userInfo = t(activity);
        v(activity, smsPageFunc, getSmsReqBody);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(@Nullable QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) smsPageFunc);
            return;
        }
        this.mActivity = activity;
        this.mCommonSmsView = smsPageFunc;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.mEntrance = intent.getIntExtra("phoneNumLoginEntrance", 0);
        }
        this.phoneNum = activity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        ReportController.r(activity.getAppRuntime(), "dc00898", "", s(), "0X800B109", "0X800B109", this.mEntrance, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Nullable
    public final String r(@NotNull String urlString, @NotNull String parameterName) {
        List split$default;
        List split$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) urlString, (Object) parameterName);
        }
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        String query = new URL(urlString).getQuery();
        try {
            Intrinsics.checkNotNullExpressionValue(query, "query");
            split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), parameterName)) {
                    return (String) split$default2.get(1);
                }
            }
            return null;
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, "getParameterValue error : " + e16);
            return null;
        }
    }

    public final void z(@Nullable String str, int type, int errCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(type), Integer.valueOf(errCode));
            return;
        }
        u(str, type);
        QBaseActivity qBaseActivity = this.mActivity;
        Intrinsics.checkNotNull(qBaseActivity);
        as.f(qBaseActivity.getAppRuntime(), "0X800C1A1", "", this.mEntrance, errCode, str);
    }
}
