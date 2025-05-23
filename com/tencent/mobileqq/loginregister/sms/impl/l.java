package com.tencent.mobileqq.loginregister.sms.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.CheckLimitHandleResultReq;
import com.tencent.qqnt.kernel.nativeinterface.GetRegisterSmsCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityLimit;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityRsp;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 F2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\"\u0010\u0017\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001c\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010!\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\"\u00105\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00100R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00100R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010&R\u001a\u0010A\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/impl/l;", "Lcom/tencent/mobileqq/loginregister/sms/b;", "", "sms", "Lcom/tencent/mobileqq/loginregister/sms/c;", "smsPageFunc", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msg", "", "icon", ReportConstant.COSTREPORT_PREFIX, "msgStr", "p", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "onActivityResume", "onActivityDestroy", "", "hasClickSendSms", "", "clickOtherVerifyBtnLastTime", "f", "e", "b", "g", "smsCode", "c", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mActivity", "Lcom/tencent/mobileqq/loginregister/sms/c;", "mCommonSmsView", "Ljava/lang/String;", "getPhoneNum", "()Ljava/lang/String;", "setPhoneNum", "(Ljava/lang/String;)V", "phoneNum", "d", "getCountryCode", "setCountryCode", "countryCode", "Z", "getMHasPwd", "()Z", "setMHasPwd", "(Z)V", "mHasPwd", "I", "getMFrom", "()I", "setMFrom", "(I)V", "mFrom", "mFromFriendVerify", "mFromFaceVerify", "i", "j", "getSECONDS_60", "SECONDS_60", "k", "tmpSecond", "<init>", "()V", "l", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l implements com.tencent.mobileqq.loginregister.sms.b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.sms.c mCommonSmsView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String phoneNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String countryCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasPwd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mFromFriendVerify;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mFromFaceVerify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String smsCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int SECONDS_60;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int tmpSecond;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/impl/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.sms.impl.l$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24610);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.phoneNum = "";
        this.countryCode = "86";
        this.mHasPwd = true;
        this.mFrom = -1;
        this.SECONDS_60 = 60;
        this.tmpSecond = 60;
    }

    private final void m(String sms, final com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        byte[] bArr;
        Intent intent;
        QLog.d("NTPhoneRegisterVerifyCodeApiImpl", 1, "checkSmsContent phone: " + this.phoneNum);
        CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
            bArr = intent.getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
        } else {
            bArr = null;
        }
        checkLimitHandleResultReq.context = bArr;
        checkLimitHandleResultReq.handleResult = sms;
        ((ILoginService) QRoute.api(ILoginService.class)).checkLimitHandleResult(checkLimitHandleResultReq, new IRegisterIdentityCallback() { // from class: com.tencent.mobileqq.loginregister.sms.impl.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback
            public final void onResult(int i3, String str, RegisterIdentityRsp registerIdentityRsp) {
                l.n(l.this, smsPageFunc, i3, str, registerIdentityRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final l this$0, final com.tencent.mobileqq.loginregister.sms.c cVar, final int i3, final String str, final RegisterIdentityRsp registerIdentityRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NTPhoneRegisterVerifyCodeApiImpl", 1, "checkSmsContent result: " + i3 + ", errMsg: " + str + ", business code: " + registerIdentityRsp.retCode);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                l.o(l.this, cVar, registerIdentityRsp, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(l this$0, com.tencent.mobileqq.loginregister.sms.c cVar, RegisterIdentityRsp registerIdentityRsp, int i3, String errMsg) {
        String string;
        int i16;
        int i17;
        int i18;
        boolean z16;
        byte[] bArr;
        QBaseActivity qBaseActivity;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity2 = this$0.mActivity;
        if (qBaseActivity2 != null) {
            Intrinsics.checkNotNull(qBaseActivity2);
            if (!qBaseActivity2.isFinishing()) {
                if (cVar != null) {
                    cVar.dismissDialog();
                }
                if (registerIdentityRsp != null && (bArr = registerIdentityRsp.context) != null && (qBaseActivity = this$0.mActivity) != null && (intent = qBaseActivity.getIntent()) != null) {
                    intent.putExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, bArr);
                }
                String str = "";
                if (i3 == 0 && ((i16 = registerIdentityRsp.retCode) == 10000 || i16 == 10001)) {
                    if (i16 == 10001) {
                        str = registerIdentityRsp.limit.handleUrl;
                        Intrinsics.checkNotNullExpressionValue(str, "registerRspInfo.limit.handleUrl");
                        i17 = registerIdentityRsp.limit.type;
                    } else {
                        i17 = 0;
                    }
                    String str2 = this$0.smsCode;
                    if (str2 != null) {
                        int length = str2.length() - 1;
                        int i19 = 0;
                        boolean z17 = false;
                        while (i19 <= length) {
                            if (!z17) {
                                i18 = i19;
                            } else {
                                i18 = length;
                            }
                            if (Intrinsics.compare((int) str2.charAt(i18), 32) <= 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z17) {
                                if (!z16) {
                                    z17 = true;
                                } else {
                                    i19++;
                                }
                            } else if (!z16) {
                                break;
                            } else {
                                length--;
                            }
                        }
                        str2 = str2.subSequence(i19, length + 1).toString();
                    }
                    QBaseActivity qBaseActivity3 = this$0.mActivity;
                    Intrinsics.checkNotNull(qBaseActivity3);
                    IRuntimeService runtimeService = qBaseActivity3.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "mRuntime.getRuntimeServi\u2026ALL\n                    )");
                    RegisterVerifyResult registerVerifyResult = new RegisterVerifyResult(true);
                    registerVerifyResult.f242903e = str2;
                    registerVerifyResult.f242904f = str;
                    registerVerifyResult.f242905h = false;
                    registerVerifyResult.f242906i = i17;
                    QBaseActivity qBaseActivity4 = this$0.mActivity;
                    Intrinsics.checkNotNull(qBaseActivity4);
                    registerVerifyResult.f242907m = qBaseActivity4.getIntent().getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
                    ((ISmsVerifyCodeService) runtimeService).handleNTRegisterVerifySuccess(this$0.mActivity, str2, registerVerifyResult);
                    QBaseActivity qBaseActivity5 = this$0.mActivity;
                    Intrinsics.checkNotNull(qBaseActivity5);
                    qBaseActivity5.finish();
                    return;
                }
                QBaseActivity qBaseActivity6 = this$0.mActivity;
                if (qBaseActivity6 != null && (string = qBaseActivity6.getString(R.string.g0j)) != null) {
                    str = string;
                }
                if (!TextUtils.isEmpty(errMsg)) {
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                } else {
                    errMsg = str;
                }
                com.tencent.mobileqq.loginregister.sms.c cVar2 = this$0.mCommonSmsView;
                Intrinsics.checkNotNull(cVar2);
                cVar2.clearWrongCode();
                this$0.s(errMsg, 1);
            }
        }
    }

    private final void p(String msgStr, int icon) {
        boolean endsWith$default;
        if (msgStr != null && msgStr.length() != 0) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(msgStr, "\n", false, 2, null);
            if (endsWith$default) {
                msgStr = msgStr.substring(0, msgStr.length() - 1);
                Intrinsics.checkNotNullExpressionValue(msgStr, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            QQToast.makeText(this.mActivity, icon, msgStr, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final l this$0, final QBaseActivity qBaseActivity, final int i3, final String str, final RegisterIdentityRsp registerIdentityRsp) {
        Integer num;
        RegisterIdentityLimit registerIdentityLimit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num2 = null;
        if (registerIdentityRsp != null) {
            num = Integer.valueOf(registerIdentityRsp.retCode);
        } else {
            num = null;
        }
        if (registerIdentityRsp != null && (registerIdentityLimit = registerIdentityRsp.limit) != null) {
            num2 = Integer.valueOf(registerIdentityLimit.type);
        }
        QLog.d("NTPhoneRegisterVerifyCodeApiImpl", 1, "resendSms: " + i3 + " resultCode: " + num + " limit type: " + num2 + " errMsg: " + str);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                l.r(l.this, qBaseActivity, registerIdentityRsp, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(l this$0, QBaseActivity qBaseActivity, RegisterIdentityRsp registerIdentityRsp, int i3, String errMsg) {
        String str;
        byte[] bArr;
        Intent intent;
        RegisterIdentityLimit registerIdentityLimit;
        boolean z16;
        boolean z17;
        Intent intent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity2 = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity2);
        if (qBaseActivity2.isFinishing()) {
            QLog.e("NTPhoneRegisterVerifyCodeApiImpl", 1, "resendSms activity is finishing");
            return;
        }
        if (qBaseActivity != null && (intent2 = qBaseActivity.getIntent()) != null) {
            intent2.putExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, registerIdentityRsp.context);
        }
        com.tencent.mobileqq.loginregister.sms.c cVar = this$0.mCommonSmsView;
        if (cVar != null) {
            cVar.dismissDialog();
        }
        boolean z18 = false;
        if (i3 == 0) {
            if (registerIdentityRsp != null && registerIdentityRsp.retCode == 10001) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                RegisterIdentityLimit registerIdentityLimit2 = registerIdentityRsp.limit;
                if (registerIdentityLimit2 != null && registerIdentityLimit2.type == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    int i16 = this$0.SECONDS_60;
                    this$0.tmpSecond = i16;
                    com.tencent.mobileqq.loginregister.sms.c cVar2 = this$0.mCommonSmsView;
                    if (cVar2 != null) {
                        cVar2.startTimer(i16);
                        return;
                    }
                    return;
                }
            }
        }
        if (registerIdentityRsp != null && (registerIdentityLimit = registerIdentityRsp.limit) != null && registerIdentityLimit.type == 6) {
            z18 = true;
        }
        if (z18) {
            QBaseActivity qBaseActivity3 = this$0.mActivity;
            Intrinsics.checkNotNull(qBaseActivity3);
            qBaseActivity3.finish();
            Intent intent3 = new Intent();
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_PROMPT_UPMSG, registerIdentityRsp.limit.upSmsInfo.content);
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_PROMPT_PHONE, registerIdentityRsp.limit.upSmsInfo.maskPhone);
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_PROMPT_UPSMS_PORT, registerIdentityRsp.limit.upSmsInfo.port);
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_PROMPT_TEXT, registerIdentityRsp.limit.upSmsInfo.prompt);
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_TIPS, registerIdentityRsp.limit.upSmsInfo.tips);
            intent3.putExtra(AppConstants.Key.KEY_REGISTER_FROM, 7);
            QBaseActivity qBaseActivity4 = this$0.mActivity;
            if (qBaseActivity4 != null && (intent = qBaseActivity4.getIntent()) != null) {
                bArr = intent.getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
            } else {
                bArr = null;
            }
            intent3.putExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT, bArr);
            Bundle extras = intent3.getExtras();
            QBaseActivity qBaseActivity5 = this$0.mActivity;
            Intrinsics.checkNotNull(qBaseActivity5);
            IRuntimeService runtimeService = qBaseActivity5.getAppRuntime().getRuntimeService(ISmsVerifyCodeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "mActivity!!.appRuntime.g\u2026                        )");
            ((ISmsVerifyCodeService) runtimeService).handleTransToSendUpSms(this$0.mActivity, extras);
            return;
        }
        if (!TextUtils.isEmpty(errMsg)) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            this$0.s(errMsg, 1);
            return;
        }
        QBaseActivity qBaseActivity6 = this$0.mActivity;
        if (qBaseActivity6 == null || (str = qBaseActivity6.getString(R.string.g0j)) == null) {
            str = "";
        }
        this$0.s(str, 1);
    }

    private final void s(String msg2, int icon) {
        p(msg2, icon);
        int c16 = ao.INSTANCE.c();
        QBaseActivity qBaseActivity = this.mActivity;
        Intrinsics.checkNotNull(qBaseActivity);
        as.g(qBaseActivity.getAppRuntime(), "0X800C1C7", "", c16, msg2);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void a(@Nullable QBaseActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, activity, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean b(@Nullable QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        Intrinsics.checkNotNull(smsPageFunc);
        smsPageFunc.startTimer(60);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean c(@Nullable QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc, @Nullable String smsCode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, activity, smsPageFunc, smsCode)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            Intrinsics.checkNotNull(activity);
            String string = activity.getString(R.string.b3j);
            Intrinsics.checkNotNullExpressionValue(string, "activity!!.getString(R.string.failedconnection)");
            s(string, 0);
            return true;
        }
        if (smsCode != null && smsCode.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                m(smsCode, smsPageFunc);
                if (smsPageFunc != null) {
                    smsPageFunc.Xc(R.string.fyv);
                }
                this.smsCode = smsCode;
            } catch (Exception unused) {
                QLog.e("NTPhoneRegisterVerifyCodeApiImpl", 1, "checkSms showDialog exception");
            }
        } else {
            Intrinsics.checkNotNull(activity);
            String string2 = activity.getString(R.string.fz6);
            Intrinsics.checkNotNullExpressionValue(string2, "activity!!.getString(R.s\u2026ing.qr_input_verify_code)");
            s(string2, 0);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean f(@Nullable QBaseActivity activity, boolean hasClickSendSms, long clickOtherVerifyBtnLastTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 14, this, activity, Boolean.valueOf(hasClickSendSms), Long.valueOf(clickOtherVerifyBtnLastTime))).booleanValue();
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean g(@Nullable final QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        byte[] bArr;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        GetRegisterSmsCodeReq getRegisterSmsCodeReq = new GetRegisterSmsCodeReq();
        Integer num = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            bArr = intent.getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
        } else {
            bArr = null;
        }
        getRegisterSmsCodeReq.context = bArr;
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        }
        QLog.d("NTPhoneRegisterVerifyCodeApiImpl", 1, "resendSms by NT cookie length: " + num);
        ((ILoginService) QRoute.api(ILoginService.class)).getRegisterSmsCode(getRegisterSmsCodeReq, new IRegisterIdentityCallback() { // from class: com.tencent.mobileqq.loginregister.sms.impl.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback
            public final void onResult(int i3, String str, RegisterIdentityRsp registerIdentityRsp) {
                l.q(l.this, activity, i3, str, registerIdentityRsp);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(@Nullable QBaseActivity activity, @Nullable com.tencent.mobileqq.loginregister.sms.c smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, (Object) smsPageFunc);
            return;
        }
        this.mActivity = activity;
        this.mCommonSmsView = smsPageFunc;
        Intrinsics.checkNotNull(activity);
        String stringExtra = activity.getIntent().getStringExtra(AppConstants.Key.PHONENUM);
        Intrinsics.checkNotNull(stringExtra);
        this.phoneNum = stringExtra;
        String stringExtra2 = activity.getIntent().getStringExtra("key");
        Intrinsics.checkNotNull(stringExtra2);
        this.countryCode = stringExtra2;
        this.mFromFriendVerify = activity.getIntent().getBooleanExtra(AppConstants.Key.KEY_REGISTER_FROM_FRIEND_VERIFY, false);
        this.mFromFaceVerify = activity.getIntent().getBooleanExtra(AppConstants.Key.KEY_REGISTER_FROM_FACE_VERIFY, false);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            q.c().l(3);
        }
    }
}
