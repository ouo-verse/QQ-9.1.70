package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0002\u0007\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/pushnotice/proxy/HonorPushProcessor;", "Lcom/tencent/mobileqq/pushnotice/proxy/ThirdPushProcessorImpl;", "", "p", "d", "", "token", "a", "", "c", "", "l", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "g", "Z", "isSdkInitSuccess", "<init>", "()V", h.F, "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HonorPushProcessor extends ThirdPushProcessorImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isSdkInitSuccess;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/pushnotice/proxy/HonorPushProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pushnotice.proxy.HonorPushProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J+\u0010\r\u001a\u00020\u000b2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J\u0006\u0010\u000e\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/pushnotice/proxy/HonorPushProcessor$b;", "", "Landroid/content/Context;", "context", "", "c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "token", "", "callback", "b", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f261383a;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/pushnotice/proxy/HonorPushProcessor$b$a", "Lcom/hihonor/push/sdk/HonorPushCallback;", "", NodeProps.ENABLED, "", "a", "(Ljava/lang/Boolean;)V", "", "errorCode", "", "errorString", "onFailure", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a implements HonorPushCallback<Boolean> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable Boolean enabled) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) enabled);
                    return;
                }
                QLog.i("HonorPushProcessor", 1, "[getNotificationCenterStatus] enabled=" + enabled);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int errorCode, @NotNull String errorString) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorString);
                    return;
                }
                Intrinsics.checkNotNullParameter(errorString, "errorString");
                QLog.i("HonorPushProcessor", 1, "[getNotificationCenterStatus] error=" + errorCode + ", " + errorString);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/pushnotice/proxy/HonorPushProcessor$b$b", "Lcom/hihonor/push/sdk/HonorPushCallback;", "", "token", "", "a", "", "errorCode", "errorString", "onFailure", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.pushnotice.proxy.HonorPushProcessor$b$b, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final class C8276b implements HonorPushCallback<String> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1<String, Unit> f261384a;

            /* JADX WARN: Multi-variable type inference failed */
            C8276b(Function1<? super String, Unit> function1) {
                this.f261384a = function1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
                }
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable String token) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) token);
                    return;
                }
                QLog.i("HonorPushProcessor", 1, "[getToken] success, token=" + token);
                this.f261384a.invoke(token);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int errorCode, @Nullable String errorString) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorString);
                    return;
                }
                QLog.w("HonorPushProcessor", 1, "[getToken] failed, err=" + errorCode + ", " + errorString);
                this.f261384a.invoke(null);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59917);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                f261383a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        public static final boolean c(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                boolean checkSupportHonorPush = HonorPushClient.getInstance().checkSupportHonorPush(context);
                QLog.i("HonorPushProcessor", 1, "[isSupport] support is " + checkSupportHonorPush);
                return checkSupportHonorPush;
            } catch (Throwable th5) {
                QLog.w("HonorPushProcessor", 1, "[isSupport] exc=" + th5);
                return false;
            }
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("HonorPushProcessor", 4, "[checkNotificationSwitch] start");
            }
            try {
                HonorPushClient.getInstance().getNotificationCenterStatus(new a());
            } catch (Throwable th5) {
                QLog.w("HonorPushProcessor", 1, "[checkNotificationSwitch] exc=" + th5);
            }
        }

        public final void b(@NotNull Function1<? super String, Unit> callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (QLog.isColorLevel()) {
                QLog.i("HonorPushProcessor", 2, "[getToken] start");
            }
            try {
                HonorPushClient.getInstance().getPushToken(new C8276b(callback));
            } catch (Throwable th5) {
                QLog.w("HonorPushProcessor", 1, "[getToken] exc=" + th5);
                callback.invoke(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HonorPushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        this.context = applicationContext;
        try {
            HonorPushClient.getInstance().init(applicationContext, false);
            if (QLog.isColorLevel()) {
                QLog.i("HonorPushProcessor", 1, "init sdk finished");
            }
        } catch (Throwable th5) {
            QLog.w("HonorPushProcessor", 1, "failed to init sdk, exc=" + th5);
            z16 = false;
        }
        this.isSdkInitSuccess = z16;
    }

    private final void p() {
        if (!TextUtils.isEmpty(k())) {
            if (QLog.isColorLevel()) {
                QLog.i("HonorPushProcessor", 2, "[sendPushToken] upload token");
            }
            o();
            return;
        }
        b.f261383a.b(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.pushnotice.proxy.HonorPushProcessor$sendPushToken$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HonorPushProcessor.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                } else {
                    if (str == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("HonorPushProcessor", 2, "[sendPushToken] set token and upload");
                    }
                    HonorPushProcessor.this.a(str);
                    HonorPushProcessor.this.o();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void a(@NotNull String token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) token);
        } else {
            Intrinsics.checkNotNullParameter(token, "token");
            this.f261389a = token;
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!l()) {
            QLog.w("HonorPushProcessor", 1, "[registerPush] not support, brand:" + Build.BRAND + " model:" + DeviceInfoMonitor.getModel());
            return;
        }
        b.f261383a.a();
        p();
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.isSdkInitSuccess && b.c(this.context)) {
            return true;
        }
        return false;
    }
}
