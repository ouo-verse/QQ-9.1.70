package com.tencent.qav.monitor;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.ai;
import com.tencent.av.utils.ak;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 (2\u00020\u0001:\u0002\u0013\u0019B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007RC\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u000fj\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0011`\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R$\u0010,\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00188F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", "", "Landroid/content/Context;", "context", "", "e", "Lkotlin/Function0;", "block", "k", "Lcom/tencent/av/utils/PhoneStatusMonitor$a;", "listener", "i", DomainData.DOMAIN_NAME, "j", "o", "Ljava/util/HashMap;", "", "Lmqq/util/WeakReference;", "Lkotlin/collections/HashMap;", "a", "Lkotlin/Lazy;", "g", "()Ljava/util/HashMap;", "mInCallListenerMap", "", "b", "I", "mAudioMode", "", "c", "Z", "mIsRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsRegistering", "Landroid/media/AudioManager$OnModeChangedListener;", "Landroid/media/AudioManager$OnModeChangedListener;", "mAudioModeChangeListener", "value", "f", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "audioMode", h.F, "()Z", "isRegistered", "<init>", "()V", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PhoneStatusAudioModeMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInCallListenerMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mAudioMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRegistered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsRegistering;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AudioManager.OnModeChangedListener mAudioModeChangeListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qav.monitor.PhoneStatusAudioModeMonitor$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor$b;", "Landroid/media/AudioManager$OnModeChangedListener;", "", "mode", "", "onModeChanged", "Lmqq/util/WeakReference;", "Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", "a", "Lmqq/util/WeakReference;", "getMonitorRef", "()Lmqq/util/WeakReference;", "monitorRef", "", "b", "Z", "getMIsCalling", "()Z", "setMIsCalling", "(Z)V", "mIsCalling", "<init>", "(Lmqq/util/WeakReference;Z)V", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
    @TargetApi(31)
    /* loaded from: classes22.dex */
    public static final class b implements AudioManager.OnModeChangedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<PhoneStatusAudioModeMonitor> monitorRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean mIsCalling;

        public b(@NotNull WeakReference<PhoneStatusAudioModeMonitor> monitorRef, boolean z16) {
            Intrinsics.checkNotNullParameter(monitorRef, "monitorRef");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, monitorRef, Boolean.valueOf(z16));
            } else {
                this.monitorRef = monitorRef;
                this.mIsCalling = z16;
            }
        }

        @Override // android.media.AudioManager.OnModeChangedListener
        public void onModeChanged(int mode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, mode);
                return;
            }
            PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = this.monitorRef.get();
            if (phoneStatusAudioModeMonitor == null) {
                return;
            }
            boolean f16 = ai.INSTANCE.f(mode);
            phoneStatusAudioModeMonitor.m(mode);
            boolean z16 = this.mIsCalling;
            if (z16 == f16) {
                return;
            }
            QLog.d("PhoneStatusAudioModeMonitor", 1, "InCallStatusListener onModeChanged mode: " + mode + " isCalling: " + f16 + " currentIsCall: " + z16);
            this.mIsCalling = f16;
            Collection values = phoneStatusAudioModeMonitor.g().values();
            Intrinsics.checkNotNullExpressionValue(values, "monitor.mInCallListenerMap.values");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                PhoneStatusMonitor.a aVar = (PhoneStatusMonitor.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.a(f16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhoneStatusAudioModeMonitor() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PhoneStatusAudioModeMonitor$mInCallListenerMap$2.INSTANCE);
            this.mInCallListenerMap = lazy;
            this.mAudioMode = -2;
            this.mIsRegistering = new AtomicBoolean(false);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(31)
    public final void e(Context context) {
        AudioManager audioManager;
        Executor mainExecutor;
        if (!this.mIsRegistering.compareAndSet(false, true)) {
            QLog.e("PhoneStatusAudioModeMonitor", 1, "mode listener is registering!");
            return;
        }
        Object systemService = context.getSystemService("audio");
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        } else {
            audioManager = null;
        }
        if (audioManager != null) {
            QLog.d("PhoneStatusAudioModeMonitor", 1, "registerModeListener!!!");
            int mode = audioManager.getMode();
            this.mAudioMode = mode;
            this.mAudioModeChangeListener = new b(new WeakReference(this), ai.INSTANCE.f(mode));
            mainExecutor = context.getMainExecutor();
            AudioManager.OnModeChangedListener onModeChangedListener = this.mAudioModeChangeListener;
            Intrinsics.checkNotNull(onModeChangedListener);
            audioManager.addOnModeChangedListener(mainExecutor, onModeChangedListener);
            this.mIsRegistered = true;
        }
        this.mIsRegistering.compareAndSet(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, WeakReference<PhoneStatusMonitor.a>> g() {
        return (HashMap) this.mInCallListenerMap.getValue();
    }

    private final void k(final Function0<Unit> block) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qav.monitor.b
            @Override // java.lang.Runnable
            public final void run() {
                PhoneStatusAudioModeMonitor.l(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i3) {
        this.mAudioMode = i3;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mAudioMode;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsRegistered;
    }

    public final void i(@Nullable PhoneStatusMonitor.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        if (listener == null) {
            return;
        }
        String obj = listener.toString();
        g().put(obj, new WeakReference<>(listener));
        QLog.d("PhoneStatusAudioModeMonitor", 1, "registerInCallListener key: " + obj);
    }

    @TargetApi(31)
    public final void j(@Nullable final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        if (context != null && this.mAudioModeChangeListener == null && !this.mIsRegistered) {
            if (!ak.e("qav_phone_calling_switch", true)) {
                QLog.d("PhoneStatusAudioModeMonitor", 1, "registerModeListener switch is close!");
            } else if (ak.c("qav_phone_calling_switch", "async_register_mode_listener", true)) {
                k(new Function0<Unit>(context) { // from class: com.tencent.qav.monitor.PhoneStatusAudioModeMonitor$registerModeListener$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Context $context;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$context = context;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneStatusAudioModeMonitor.this, (Object) context);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            PhoneStatusAudioModeMonitor.this.e(this.$context);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                e(context);
            }
        }
    }

    public final void n(@Nullable PhoneStatusMonitor.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        if (listener == null) {
            return;
        }
        String obj = listener.toString();
        g().remove(obj);
        QLog.d("PhoneStatusAudioModeMonitor", 1, "unregisterInCallListener key: " + obj);
    }

    @TargetApi(31)
    public final void o(@Nullable Context context) {
        AudioManager audioManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        if (context != null && this.mAudioModeChangeListener != null && this.mIsRegistered) {
            Object systemService = context.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                audioManager = (AudioManager) systemService;
            } else {
                audioManager = null;
            }
            if (audioManager != null) {
                QLog.d("PhoneStatusAudioModeMonitor", 1, "unregisterModeListener!!!");
                AudioManager.OnModeChangedListener onModeChangedListener = this.mAudioModeChangeListener;
                Intrinsics.checkNotNull(onModeChangedListener);
                audioManager.removeOnModeChangedListener(onModeChangedListener);
                this.mAudioModeChangeListener = null;
                this.mIsRegistered = false;
            }
        }
    }
}
