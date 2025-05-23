package com.tencent.mobileqq.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.impl.a;
import com.tencent.mobileqq.loginregister.p;
import com.tencent.mobileqq.loginregister.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.servlet.PhoneBindAccountHandler;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J,\u0010\u001f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010#R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/impl/a;", "Lcom/tencent/mobileqq/loginregister/p;", "Ltencent/im/oidb/oidb_0x87a$RspBody;", "rspBody", "", "k", "Ltencent/im/oidb/oidb_0x87c$RspBody;", "l", "", "code", "", "message", "j", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/loginregister/q;", "smsPage", "", "i", "smsPageFunc", "d", "onActivityResume", "onActivityDestroy", "c", "e", "smsCode", "b", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "a", "Ljava/lang/String;", "mFrom", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mActivityRef", "mSmsPageRef", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements p {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFrom;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<q> mSmsPageRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/impl/a$a;", "", "", "SECONDS_60", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/impl/a$b", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements PhoneBindAccountHandler.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Object data, a this$0) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.l((oidb_0x87c$RspBody) data);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onFailed(final int errorCode, @Nullable final String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            } else {
                final a aVar = a.this;
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.b.c(a.this, errorCode, errorMsg);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onSuccess(@NotNull final Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            final a aVar = a.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.d(data, aVar);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/impl/a$c", "Lcom/tencent/mobileqq/servlet/PhoneBindAccountHandler$a;", "", "data", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements PhoneBindAccountHandler.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Object data, a this$0) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.k((oidb_0x87a$RspBody) data);
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onFailed(final int errorCode, @Nullable final String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            } else {
                final a aVar = a.this;
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.c(a.this, errorCode, errorMsg);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.servlet.PhoneBindAccountHandler.a
        public void onSuccess(@NotNull final Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            final a aVar = a.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.d(data, aVar);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19477);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean i(QBaseActivity activity, q smsPage) {
        if (activity != null && smsPage != null && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int code, String message) {
        QBaseActivity qBaseActivity;
        q qVar;
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        WeakReference<q> weakReference2 = this.mSmsPageRef;
        if (weakReference2 != null) {
            qVar = weakReference2.get();
        } else {
            qVar = null;
        }
        if (i(qBaseActivity, qVar)) {
            QLog.e("PhoneBindAccountSmsVerifyImpl", 1, "onFailedResponse, but context is invalid");
            return;
        }
        Intrinsics.checkNotNull(qVar);
        qVar.clearWrongCode();
        if (code == -1) {
            message = null;
        }
        if (TextUtils.isEmpty(message)) {
            Intrinsics.checkNotNull(qBaseActivity);
            message = qBaseActivity.getString(R.string.g0j);
        }
        QQToast.makeText(qBaseActivity, 1, message, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(oidb_0x87a$RspBody rspBody) {
        QBaseActivity qBaseActivity;
        int i3;
        QLog.d("PhoneBindAccountSmsVerifyImpl", 1, "sendSmsCodeSuccess");
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        q qVar = null;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        WeakReference<q> weakReference2 = this.mSmsPageRef;
        if (weakReference2 != null) {
            qVar = weakReference2.get();
        }
        if (i(qBaseActivity, qVar)) {
            QLog.e("PhoneBindAccountSmsVerifyImpl", 1, "sendSmsCodeSuccess, but context is invalid");
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        if (qBaseActivity.isFinishing()) {
            QLog.d("PhoneBindAccountSmsVerifyImpl", 1, "sendSmsCodeSuccess, activity is finish");
            return;
        }
        Intrinsics.checkNotNull(qVar);
        qVar.dismissDialog();
        if (rspBody.uint32_resend_interval.get() > 0) {
            i3 = rspBody.uint32_resend_interval.get();
        } else {
            i3 = 60;
        }
        qVar.startTimer(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(oidb_0x87c$RspBody rspBody) {
        QBaseActivity qBaseActivity;
        QLog.d("PhoneBindAccountSmsVerifyImpl", 1, "verifySmsCodeSuccess");
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        q qVar = null;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        WeakReference<q> weakReference2 = this.mSmsPageRef;
        if (weakReference2 != null) {
            qVar = weakReference2.get();
        }
        if (i(qBaseActivity, qVar)) {
            QLog.e("PhoneBindAccountSmsVerifyImpl", 1, "verifySmsCodeSuccess, but context is invalid");
            return;
        }
        Intrinsics.checkNotNull(qVar);
        qVar.dismissDialog();
        byte[] byteArray = rspBody.bytes_key.get().toByteArray();
        Intent intent = new Intent();
        intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, byteArray);
        Intrinsics.checkNotNull(qBaseActivity);
        qBaseActivity.setResult(-1, intent);
        qBaseActivity.finish();
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void a(@Nullable QBaseActivity activity, int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean b(@NotNull QBaseActivity activity, @NotNull q smsPageFunc, @NotNull String smsCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, activity, smsPageFunc, smsCode)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(smsPageFunc, "smsPageFunc");
        Intrinsics.checkNotNullParameter(smsCode, "smsCode");
        if (!Intrinsics.areEqual("from_phone_bind_account_manager", this.mFrom)) {
            return false;
        }
        QLog.d("PhoneBindAccountSmsVerifyImpl", 2, "checkSms, smsCode : ", smsCode);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PhoneBindAccountHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.PhoneBindAccountHandler");
        ((PhoneBindAccountHandler) businessHandler).F2(smsCode, new b());
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean c(@NotNull QBaseActivity activity, @NotNull q smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(smsPageFunc, "smsPageFunc");
        if (!Intrinsics.areEqual("from_phone_bind_account_manager", this.mFrom)) {
            return false;
        }
        smsPageFunc.startTimer(60);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void d(@NotNull QBaseActivity activity, @NotNull q smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) smsPageFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(smsPageFunc, "smsPageFunc");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        this.mFrom = intent.getStringExtra(MQPSecJsPlugin.KEY_FROM);
        this.mActivityRef = new WeakReference<>(activity);
        this.mSmsPageRef = new WeakReference<>(smsPageFunc);
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean e(@NotNull QBaseActivity activity, @NotNull q smsPageFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) smsPageFunc)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(smsPageFunc, "smsPageFunc");
        if (!Intrinsics.areEqual("from_phone_bind_account_manager", this.mFrom)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PhoneBindAccountHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.PhoneBindAccountHandler");
        ((PhoneBindAccountHandler) businessHandler).E2(null, new c());
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
