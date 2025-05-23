package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tR\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelperKt;", "", "", tl.h.F, "f", "g", "Landroid/media/AudioManager;", "audioManager", "e", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "onHeadsetDisconnected", "j", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Lkotlin/Lazy;", "c", "()Z", "useKtImpl", "d", "useTimeoutHeadset", "streamTypeVoice", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelperKt$HeadsetBroadcastReceiver;", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelperKt$HeadsetBroadcastReceiver;", "headsetReceiver", "recorderHeadsetReceiver", "<init>", "()V", "HeadsetBroadcastReceiver", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AudioDeviceHelperKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AudioDeviceHelperKt f262108a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy useKtImpl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy useTimeoutHeadset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy streamTypeVoice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static HeadsetBroadcastReceiver headsetReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static HeadsetBroadcastReceiver recorderHeadsetReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelperKt$HeadsetBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "onHeadsetDisconnected", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class HeadsetBroadcastReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> onHeadsetDisconnected;

        public HeadsetBroadcastReceiver(@NotNull Function0<Unit> onHeadsetDisconnected) {
            Intrinsics.checkNotNullParameter(onHeadsetDisconnected, "onHeadsetDisconnected");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onHeadsetDisconnected);
            } else {
                this.onHeadsetDisconnected = onHeadsetDisconnected;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), "android.media.AUDIO_BECOMING_NOISY")) {
                this.onHeadsetDisconnected.invoke();
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f262108a = new AudioDeviceHelperKt();
        lazy = LazyKt__LazyJVMKt.lazy(AudioDeviceHelperKt$useKtImpl$2.INSTANCE);
        useKtImpl = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AudioDeviceHelperKt$useTimeoutHeadset$2.INSTANCE);
        useTimeoutHeadset = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AudioDeviceHelperKt$streamTypeVoice$2.INSTANCE);
        streamTypeVoice = lazy3;
    }

    AudioDeviceHelperKt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean d() {
        return ((Boolean) useTimeoutHeadset.getValue()).booleanValue();
    }

    private final boolean f() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(2);
        Intrinsics.checkNotNullExpressionValue(devices, "audioManager.getDevices(\u2026ager.GET_DEVICES_OUTPUTS)");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 22) {
                return true;
            }
        }
        return false;
    }

    private final boolean h() {
        try {
            Object obj = ThreadManager.execute(new Callable() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean i3;
                    i3 = AudioDeviceHelperKt.i();
                    return i3;
                }
            }, 16).get(2000L, TimeUnit.MILLISECONDS);
            Intrinsics.checkNotNullExpressionValue(obj, "{\n            val task =\u2026t.MILLISECONDS)\n        }");
            return ((Boolean) obj).booleanValue();
        } catch (InterruptedException e16) {
            QLog.d("AudioDeviceHelperKt", 2, "isWiredHeadsetOnWithTimeout:", e16);
            return false;
        } catch (ExecutionException e17) {
            QLog.d("AudioDeviceHelperKt", 2, "isWiredHeadsetOnWithTimeout:", e17);
            return false;
        } catch (TimeoutException e18) {
            QLog.d("AudioDeviceHelperKt", 2, "isWiredHeadsetOnWithTimeout:", e18);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean i() {
        return Boolean.valueOf(f262108a.f());
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((Boolean) streamTypeVoice.getValue()).booleanValue();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) useKtImpl.getValue()).booleanValue();
    }

    public final boolean e(@NotNull AudioManager audioManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) audioManager)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(audioManager, "audioManager");
        AudioDeviceInfo[] devices = audioManager.getDevices(2);
        Intrinsics.checkNotNullExpressionValue(devices, "audioManager.getDevices(\u2026ager.GET_DEVICES_OUTPUTS)");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 7 || type == 8 || type == 22) {
                QLog.d("AudioDeviceHelperKt", 1, "headset on, type: " + type);
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (d()) {
            return h();
        }
        return f();
    }

    public final synchronized void j(@NotNull Context context, @NotNull Function0<Unit> onHeadsetDisconnected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) onHeadsetDisconnected);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onHeadsetDisconnected, "onHeadsetDisconnected");
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        l(sMobileQQ);
        headsetReceiver = new HeadsetBroadcastReceiver(onHeadsetDisconnected);
        IntentFilter intentFilter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
        HeadsetBroadcastReceiver headsetBroadcastReceiver = headsetReceiver;
        if (headsetBroadcastReceiver != null) {
            MobileQQ.sMobileQQ.registerReceiver(headsetBroadcastReceiver, intentFilter);
        }
    }

    public final synchronized void k(@NotNull Context context, @NotNull Function0<Unit> onHeadsetDisconnected) {
        MobileQQ mobileQQ;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) onHeadsetDisconnected);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onHeadsetDisconnected, "onHeadsetDisconnected");
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        m(sMobileQQ);
        recorderHeadsetReceiver = new HeadsetBroadcastReceiver(onHeadsetDisconnected);
        IntentFilter intentFilter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
        HeadsetBroadcastReceiver headsetBroadcastReceiver = recorderHeadsetReceiver;
        if (headsetBroadcastReceiver != null && (mobileQQ = MobileQQ.sMobileQQ) != null) {
            mobileQQ.registerReceiver(headsetBroadcastReceiver, intentFilter);
        }
    }

    public final synchronized void l(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        HeadsetBroadcastReceiver headsetBroadcastReceiver = headsetReceiver;
        if (headsetBroadcastReceiver != null) {
            MobileQQ.sMobileQQ.unregisterReceiver(headsetBroadcastReceiver);
        }
        headsetReceiver = null;
    }

    public final synchronized void m(@NotNull Context context) {
        MobileQQ mobileQQ;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        HeadsetBroadcastReceiver headsetBroadcastReceiver = recorderHeadsetReceiver;
        if (headsetBroadcastReceiver != null && (mobileQQ = MobileQQ.sMobileQQ) != null) {
            mobileQQ.unregisterReceiver(headsetBroadcastReceiver);
        }
        recorderHeadsetReceiver = null;
    }
}
