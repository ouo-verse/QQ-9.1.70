package com.tencent.qqnt.audio;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.audio.AudioBottomCircleView;
import com.tencent.mobileqq.audio.AudioVolumeWaveView;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.audio.AudioNTPopupWindow;
import com.tencent.qqnt.audio.SpeechToTextNTLayout;
import com.tencent.util.hapticcreator.HapticUtil;
import com.tencent.widget.immersive.SystemBarTintManager;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;

/* loaded from: classes23.dex */
public class AudioNTPopupWindow extends PopupWindow implements m, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m0, reason: collision with root package name */
    private static final int[] f352486m0;

    @NonNull
    private final n C;
    private ViewGroup D;
    private ConstraintLayout E;
    private View F;
    private AudioVolumeWaveView G;
    private PttAudioWaveView H;
    private TextView I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private AudioBottomCircleView N;
    private ImageView P;
    private View[] Q;
    private SpeechToTextNTLayout R;
    private LottieDrawable S;
    private String T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private volatile int f352487a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f352488b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f352489c0;

    /* renamed from: d, reason: collision with root package name */
    private RecorderState f352490d;

    /* renamed from: d0, reason: collision with root package name */
    private final Handler f352491d0;

    /* renamed from: e, reason: collision with root package name */
    private final String f352492e;

    /* renamed from: e0, reason: collision with root package name */
    private final boolean f352493e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f352494f;

    /* renamed from: f0, reason: collision with root package name */
    private VoicePlayer f352495f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f352496g0;

    /* renamed from: h, reason: collision with root package name */
    private final AppActivity f352497h;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<Byte> f352498h0;

    /* renamed from: i, reason: collision with root package name */
    private final RecordParams.RecorderParam f352499i;

    /* renamed from: i0, reason: collision with root package name */
    private double f352500i0;

    /* renamed from: j0, reason: collision with root package name */
    private long f352501j0;

    /* renamed from: k0, reason: collision with root package name */
    private final d.a f352502k0;

    /* renamed from: l0, reason: collision with root package name */
    private final VoicePlayer.a f352503l0;

    /* renamed from: m, reason: collision with root package name */
    private final View f352504m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes23.dex */
    public static final class RecorderState {
        private static final /* synthetic */ RecorderState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RecorderState RECORD_TO_CANCEL;
        public static final RecorderState RECORD_TO_ENTER_LISTEN;
        public static final RecorderState RECORD_TO_SEND;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46795);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RecorderState recorderState = new RecorderState("RECORD_TO_CANCEL", 0);
            RECORD_TO_CANCEL = recorderState;
            RecorderState recorderState2 = new RecorderState("RECORD_TO_SEND", 1);
            RECORD_TO_SEND = recorderState2;
            RecorderState recorderState3 = new RecorderState("RECORD_TO_ENTER_LISTEN", 2);
            RECORD_TO_ENTER_LISTEN = recorderState3;
            $VALUES = new RecorderState[]{recorderState, recorderState2, recorderState3};
        }

        RecorderState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RecorderState valueOf(String str) {
            return (RecorderState) Enum.valueOf(RecorderState.class, str);
        }

        public static RecorderState[] values() {
            return (RecorderState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f352505d;

        a(boolean z16) {
            this.f352505d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AudioNTPopupWindow.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AudioNTPopupWindow.this.E.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f352505d) {
                AudioNTPopupWindow.this.D();
            }
            AudioNTPopupWindow.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements SpeechToTextNTLayout.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioNTPopupWindow.this);
            }
        }

        @Override // com.tencent.qqnt.audio.SpeechToTextNTLayout.e
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                AudioNTPopupWindow.this.C.c(str);
            }
        }

        @Override // com.tencent.qqnt.audio.SpeechToTextNTLayout.e
        public void finish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AudioNTPopupWindow.this.G(false);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f352508d;

        c(Runnable runnable) {
            this.f352508d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioNTPopupWindow.this, (Object) runnable);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                this.f352508d.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class d implements d.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioNTPopupWindow.this);
            }
        }

        private void h(String str, RecordParams.RecorderParam recorderParam) {
            AudioNTPopupWindow.this.C.a(str, 1, recorderParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            AudioNTPopupWindow.this.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            AudioNTPopupWindow.this.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            AudioNTPopupWindow.this.G(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(String str, RecordParams.RecorderParam recorderParam, double d16) {
            if (AudioNTPopupWindow.this.f352487a0 == 4) {
                h(str, recorderParam);
                AudioNTPopupWindow.this.C.a(str, 2, recorderParam);
                AudioNTPopupWindow.this.m0(str);
            } else {
                h(str, recorderParam);
                AudioNTPopupWindow.this.f352496g0 = str;
                AudioNTPopupWindow.this.f352500i0 = d16;
                AudioNTPopupWindow.this.f352498h0 = k.a(recorderParam.D, recorderParam.C);
                AudioNTPopupWindow.this.k0(k.a(recorderParam.D, recorderParam.C), recorderParam.C);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m() {
            AudioNTPopupWindow.this.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(int i3) {
            AudioNTPopupWindow.this.n0(i3);
            if (AudioNTPopupWindow.this.f352487a0 == 2 || AudioNTPopupWindow.this.Z == 1) {
                AudioNTPopupWindow.this.I.setText(com.tencent.mobileqq.audio.a.b(AudioNTPopupWindow.this.f352500i0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(boolean z16) {
            if (z16 && !AudioNTPopupWindow.this.f352488b0) {
                AudioNTPopupWindow.this.G(true);
            }
        }

        private void p(String str, RecordParams.RecorderParam recorderParam, float f16, final boolean z16, ArrayList<Byte> arrayList) {
            AudioNTPopupWindow.this.C.e(str, Float.valueOf(f16), arrayList, recorderParam);
            AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.j
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.d.this.o(z16);
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) recorderParam)).intValue();
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) recorderParam);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onInitFailed, path:" + str);
            }
            AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.h
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.d.this.i();
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onInitSuccess");
            }
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) recorderParam);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onRecorderAbnormal, path:" + str);
            }
            AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.i
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.d.this.j();
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderEnd(final String str, final RecordParams.RecorderParam recorderParam, final double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, str, recorderParam, Double.valueOf(d16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onRecorderEnd, path:" + str);
            }
            if (AudioNTPopupWindow.this.f352500i0 < 500.0d) {
                AudioNTPopupWindow.this.C.f(str);
                AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioNTPopupWindow.d.this.k();
                    }
                });
                if (QLog.isColorLevel()) {
                    QLog.d("AudioPopupWindow", 2, "onRecorderEnd too short");
                    return;
                }
                return;
            }
            ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(1, (int) AudioNTPopupWindow.this.f352500i0);
            QLog.i("AudioPopupWindow", 1, "onRecorderEnd, totalTime:" + d16 + ", fate:" + AudioNTPopupWindow.this.f352490d);
            RecorderState recorderState = AudioNTPopupWindow.this.f352490d;
            RecorderState recorderState2 = RecorderState.RECORD_TO_CANCEL;
            if (recorderState == recorderState2) {
                h(str, recorderParam);
                return;
            }
            if (AudioNTPopupWindow.this.f352490d == RecorderState.RECORD_TO_SEND) {
                p(str, recorderParam, (float) d16, false, k.a(recorderParam.D, recorderParam.C));
                return;
            }
            if (AudioNTPopupWindow.this.f352487a0 == 1) {
                p(str, recorderParam, (float) d16, true, k.a(recorderParam.D, recorderParam.C));
            } else if (AudioNTPopupWindow.this.f352490d == RecorderState.RECORD_TO_ENTER_LISTEN) {
                AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioNTPopupWindow.d.this.l(str, recorderParam, d16);
                    }
                });
            } else {
                h(str, recorderParam);
                AudioNTPopupWindow.this.f352490d = recorderState2;
            }
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, str, recorderParam, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onRecorderError, path:" + str + ", throwable:" + str2);
            }
            AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.e
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.d.this.m();
                }
            });
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) recorderParam);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onRecorderPrepare, path:" + str);
            }
            AudioNTPopupWindow.this.C.b(str);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderSilceEnd(String str, byte[] bArr, int i3, final int i16, double d16, RecordParams.RecorderParam recorderParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                AudioNTPopupWindow.this.f352500i0 = d16;
                AudioNTPopupWindow.this.f352491d0.post(new Runnable() { // from class: com.tencent.qqnt.audio.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioNTPopupWindow.d.this.n(i16);
                    }
                });
            } else {
                iPatchRedirector.redirect((short) 6, this, str, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16), recorderParam);
            }
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onRecorderStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPopupWindow", 2, "onRecorderStart");
            }
            AudioNTPopupWindow.this.H();
            AudioNTPopupWindow.this.f352500i0 = 0.0d;
            return 250;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderVolumeStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                AudioNTPopupWindow.this.C.d(i3);
            }
        }
    }

    /* loaded from: classes23.dex */
    class e implements VoicePlayer.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioNTPopupWindow.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void c5(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                AudioNTPopupWindow.this.H.setProgress(i16 / i3);
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void ic(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void u4(int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                AudioNTPopupWindow.this.Z();
                AudioNTPopupWindow.this.H.setProgress(0.0f);
                AudioNTPopupWindow.this.b0();
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f352486m0 = new int[]{0, 500, 1000, 1500, 2300, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, 5000, 7000, 10000, 15000, 20000};
        }
    }

    public AudioNTPopupWindow(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            return;
        }
        this.f352490d = RecorderState.RECORD_TO_CANCEL;
        this.Z = 1;
        this.f352487a0 = 1;
        this.f352491d0 = new Handler(Looper.getMainLooper());
        this.f352493e0 = HapticUtil.INSTANCE.isExperiment();
        this.f352502k0 = new d();
        this.f352503l0 = new e();
        this.f352492e = oVar.f352544a;
        this.f352494f = oVar.f352545b;
        this.f352497h = oVar.f352546c;
        this.f352504m = oVar.f352548e;
        this.C = oVar.f352549f;
        this.f352499i = RecordParams.c(oVar.f352547d, false);
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        int i3;
        if (SystemBarTintManager.hasNavBar(this.f352497h) && ScreenUtil.isNavigationBarExist(this.f352497h)) {
            i3 = SystemBarTintManager.getNavigationBarHeight(this.f352497h);
        } else {
            i3 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
        this.Y = layoutParams.height + i3;
        if (QLog.isColorLevel()) {
            QLog.d("AudioPopupWindow", 2, "adjustNavigationBar, originHeight:" + layoutParams.height + ", navigationBarHeight:" + i3);
        }
        if (i3 == 0) {
            return;
        }
        layoutParams.height = this.Y;
        this.N.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int[] iArr = new int[2];
        this.D.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        this.D.getWidth();
        this.U = (this.D.getWidth() / 3) + i3;
        this.V = i3 + ((this.D.getWidth() / 3) * 2);
        int[] iArr2 = new int[2];
        this.J.getLocationOnScreen(iArr2);
        this.W = iArr2[1] + this.J.getHeight();
        int[] iArr3 = new int[2];
        this.K.getLocationOnScreen(iArr3);
        this.X = iArr3[1] + this.K.getHeight();
        if (QLog.isColorLevel()) {
            QLog.d("AudioPopupWindow", 2, "calculateTouchArea, widthDividerLeft:" + this.U + ", widthDividerRight:" + this.V + ", audioButtonNormal:" + this.W + ", audioButtonMiddle:" + this.X);
        }
    }

    private void F() {
        this.L.setBackgroundResource(R.drawable.jam);
        this.L.setImageResource(R.drawable.mo6);
        this.L.setVisibility(0);
        this.L.setContentDescription(this.f352497h.getString(R.string.a1p));
        int O = O(R.dimen.c37);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
        marginLayoutParams.width = O;
        marginLayoutParams.height = O;
        this.L.setLayoutParams(marginLayoutParams);
        int O2 = O(R.dimen.c39);
        this.L.setPadding(O2, O2, O2, O2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z16) {
        QLog.i("AudioPopupWindow", 1, "dismiss, isShowing:" + isShowing());
        if (!isShowing()) {
            return;
        }
        this.f352488b0 = true;
        if (z16) {
            I(true, new Runnable() { // from class: com.tencent.qqnt.audio.a
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.this.dismiss();
                }
            });
        } else {
            this.f352497h.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.audio.a
                @Override // java.lang.Runnable
                public final void run() {
                    AudioNTPopupWindow.this.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.f352493e0) {
            HapticUtil.INSTANCE.playActually(this.f352504m);
        } else {
            ((Vibrator) this.f352497h.getSystemService("vibrator")).vibrate(50L);
        }
    }

    private void I(boolean z16, @Nullable Runnable runnable) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (View view : this.Q) {
            float[] fArr = {100.0f, 0.0f};
            if (z16) {
                // fill-array-data instruction
                fArr[0] = 0.0f;
                fArr[1] = 100.0f;
            }
            arrayList.add(ObjectAnimator.ofFloat(view, "translationY", fArr).setDuration(300L));
        }
        animatorSet.playTogether(arrayList);
        if (runnable != null) {
            animatorSet.addListener(new c(runnable));
        }
        animatorSet.start();
    }

    private void J() {
        if (this.Z == 2) {
            return;
        }
        this.Z = 2;
        H();
        this.F.setBackgroundResource(R.drawable.jav);
        this.I.setText(R.string.z7d);
        this.M.setVisibility(8);
        this.J.setBackgroundResource(R.drawable.jaj);
        this.K.setBackgroundResource(R.drawable.jak);
        this.L.setBackgroundResource(R.drawable.jak);
        this.N.setHighlight(false);
        this.P.setAlpha(0.5f);
        j0(this.J);
        if (T()) {
            com.tencent.mobileqq.util.c.a(this.J, HardCodeUtil.qqStr(R.string.z7d));
        }
    }

    private void K() {
        if (this.Z == 3) {
            return;
        }
        this.Z = 3;
        H();
        this.F.setBackgroundResource(R.drawable.jaw);
        this.I.setText(R.string.z7e);
        this.M.setVisibility(8);
        this.J.setBackgroundResource(R.drawable.jak);
        this.K.setBackgroundResource(R.drawable.jal);
        this.L.setBackgroundResource(R.drawable.jak);
        this.N.setHighlight(false);
        this.P.setAlpha(0.5f);
        j0(this.K);
        if (T()) {
            com.tencent.mobileqq.util.c.a(this.K, HardCodeUtil.qqStr(R.string.z7e));
        }
    }

    private void L() {
        if (this.Z == 1) {
            return;
        }
        this.Z = 1;
        this.F.setBackgroundResource(R.drawable.jaw);
        this.I.setText(com.tencent.mobileqq.audio.a.b(this.f352500i0));
        this.M.setVisibility(0);
        this.J.setBackgroundResource(R.drawable.jak);
        this.K.setBackgroundResource(R.drawable.jak);
        this.L.setBackgroundResource(R.drawable.jak);
        this.N.setHighlight(true);
        this.P.setAlpha(1.0f);
        a0();
        if (T()) {
            com.tencent.mobileqq.util.c.a(this.N, HardCodeUtil.qqStr(R.string.z7f));
        }
    }

    private void M() {
        if (this.Z == 4) {
            return;
        }
        this.Z = 4;
        H();
        this.F.setBackgroundResource(R.drawable.jaw);
        this.I.setText(R.string.z7g);
        this.M.setVisibility(8);
        this.J.setBackgroundResource(R.drawable.jak);
        this.K.setBackgroundResource(R.drawable.jak);
        this.L.setBackgroundResource(R.drawable.jal);
        this.N.setHighlight(false);
        this.P.setAlpha(0.5f);
        j0(this.L);
        if (T()) {
            com.tencent.mobileqq.util.c.a(this.L, HardCodeUtil.qqStr(R.string.z7g));
        }
    }

    private AppInterface N() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private int O(int i3) {
        int dimensionPixelSize = this.f352497h.getResources().getDimensionPixelSize(i3);
        if (FontSettingManager.getFontLevel() != 16.0f) {
            return (int) FontSettingManager.revertSize2Normal(this.f352497h, dimensionPixelSize);
        }
        return dimensionPixelSize;
    }

    private ValueAnimator P() {
        ValueAnimator ofInt = ValueAnimator.ofInt(O(R.dimen.c3c), O(R.dimen.c3d));
        ofInt.setDuration(300L);
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.audio.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AudioNTPopupWindow.this.U(marginLayoutParams, valueAnimator);
            }
        });
        return ofInt;
    }

    private List<Animator> Q(View view, boolean z16) {
        float[] fArr;
        if (z16) {
            fArr = new float[]{1.0f, 1.15f};
        } else {
            fArr = new float[]{1.15f, 1.0f};
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, fArr).setDuration(300L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, fArr).setDuration(300L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(duration);
        arrayList.add(duration2);
        return arrayList;
    }

    private void R() {
        VoicePlayer voicePlayer = this.f352495f0;
        if (voicePlayer == null) {
            VoicePlayer voicePlayer2 = new VoicePlayer(this.f352496g0, this.f352491d0, this.f352499i.f307257f);
            this.f352495f0 = voicePlayer2;
            voicePlayer2.y(this.f352497h);
            this.f352495f0.z();
            this.f352495f0.l(this.f352503l0);
            e0();
            return;
        }
        if (voicePlayer.p() == 2) {
            this.f352495f0.s();
            b0();
            this.K.setContentDescription(this.f352497h.getString(R.string.z7t));
        } else if (this.f352495f0.p() == 3) {
            e0();
        }
    }

    private void S() {
        QLog.i("AudioPopupWindow", 1, "initPopupWindow");
        setWidth(-1);
        setHeight(-1);
        this.D = (ViewGroup) LayoutInflater.from(this.f352497h).inflate(R.layout.dz_, (ViewGroup) null);
        if (FontSettingManager.getFontLevel() != 16.0f) {
            FontSettingManager.resetViewSize2Normal(this.f352497h, this.D);
        } else {
            FontSettingManager.isFontSizeNormal();
        }
        setContentView(this.D);
        this.E = (ConstraintLayout) this.D.findViewById(R.id.ydp);
        this.F = this.D.findViewById(R.id.f166031yg3);
        this.H = (PttAudioWaveView) this.D.findViewById(R.id.f28750js);
        this.G = (AudioVolumeWaveView) this.D.findViewById(R.id.sx_);
        this.I = (TextView) this.D.findViewById(R.id.f111436l8);
        this.J = (ImageView) this.D.findViewById(R.id.y0a);
        this.K = (ImageView) this.D.findViewById(R.id.y0c);
        this.L = (ImageView) this.D.findViewById(R.id.y0d);
        this.M = (TextView) this.D.findViewById(R.id.f110646j3);
        this.N = (AudioBottomCircleView) this.D.findViewById(R.id.swu);
        ImageView imageView = (ImageView) this.D.findViewById(R.id.y0b);
        this.P = imageView;
        this.Q = new View[]{this.N, imageView};
        this.I.setText(com.tencent.mobileqq.audio.a.b(this.f352500i0));
        this.H.setShowProgressLine(false);
        if (!QQTheme.isNowThemeIsNight()) {
            this.D.findViewById(R.id.f1185874j).setVisibility(0);
        }
        Y(true);
        setTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAttachedInDecor(false);
        setClippingEnabled(false);
    }

    private boolean T() {
        if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable_2") && AppSetting.f99565y) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        marginLayoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.K.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(String str, LottieDrawable lottieDrawable) {
        if (lottieDrawable == null) {
            QLog.i("AudioPopupWindow", 1, "loadLottieAnimFromAssets return null, lottieAnim:" + str);
            return;
        }
        this.S = lottieDrawable;
        this.K.setImageDrawable(lottieDrawable);
        this.T = str;
        lottieDrawable.playAnimation();
    }

    private void W(final String str) {
        if (TextUtils.equals(this.T, str)) {
            this.S.setSpeed(1.0f);
            this.S.playAnimation();
        } else {
            int O = O(R.dimen.c38);
            LottieHelper.b(this.f352497h, str, null, O, O, 0, new LottieHelper.d() { // from class: com.tencent.qqnt.audio.c
                @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
                public final void onLoad(LottieDrawable lottieDrawable) {
                    AudioNTPopupWindow.this.V(str, lottieDrawable);
                }
            });
        }
    }

    private boolean X() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f352501j0 < 75) {
            return false;
        }
        this.f352501j0 = uptimeMillis;
        return true;
    }

    private void Y(boolean z16) {
        this.E.getViewTreeObserver().addOnGlobalLayoutListener(new a(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPopupWindow", 2, "releaseAudioPlayer");
        }
        VoicePlayer voicePlayer = this.f352495f0;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.f352495f0 = null;
        }
    }

    private void a0() {
        View view = this.f352489c0;
        if (view != null) {
            c0(view, false);
            this.f352489c0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        LottieDrawable lottieDrawable = this.S;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setSpeed(-1.0f);
        this.S.playAnimation();
    }

    private void c0(View view, boolean z16) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(Q(view, z16));
        animatorSet.start();
    }

    private void d0() {
        QLog.i("AudioPopupWindow", 1, "startRecord");
        if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(this.f352499i.f307257f)) {
            QQToast.makeText(BaseApplication.getContext(), R.string.by8, 0).show();
            destroy();
            return;
        }
        if (this.C.isRecording()) {
            QQToast.makeText(BaseApplication.getContext(), R.string.z6q, 0).show();
            destroy();
            return;
        }
        if (!this.C.n() && com.tencent.mobileqq.audio.a.a()) {
            if (AudioUtil.h(1)) {
                ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this.f352497h);
                destroy();
                return;
            } else {
                this.f352490d = RecorderState.RECORD_TO_SEND;
                this.C.i(this.f352502k0, this.f352499i);
                return;
            }
        }
        QQToast.makeText(BaseApplication.getContext(), R.string.f171206d52, 0).show();
        destroy();
    }

    private void e0() {
        this.f352495f0.A();
        W("audio_play_to_stop.json");
        this.K.setContentDescription(this.f352497h.getString(R.string.z7u));
    }

    private void f0() {
        this.f352490d = RecorderState.RECORD_TO_CANCEL;
        if (this.C.isRecording()) {
            if (AppSetting.f99565y) {
                com.tencent.mobileqq.util.c.a(this.f352504m, this.f352497h.getString(R.string.f170482z73));
            }
            this.C.g(Boolean.FALSE);
        }
    }

    private void g0() {
        this.f352490d = RecorderState.RECORD_TO_SEND;
        if (this.C.isRecording()) {
            this.C.g(Boolean.FALSE);
        }
    }

    private void i0() {
        this.f352490d = RecorderState.RECORD_TO_ENTER_LISTEN;
        this.f352487a0 = 4;
        if (this.C.isRecording()) {
            this.C.g(Boolean.FALSE);
        }
    }

    private void j0(View view) {
        a0();
        c0(view, true);
        this.f352489c0 = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(@NonNull ArrayList<Byte> arrayList, int i3) {
        this.f352487a0 = 3;
        this.J.setImageResource(R.drawable.mnu);
        this.J.setBackgroundResource(R.drawable.jan);
        W("audio_ready_to_play.json");
        this.K.setBackgroundResource(R.drawable.jan);
        this.K.setContentDescription(this.f352497h.getString(R.string.z7t));
        c0(this.K, false);
        if (AppSetting.f99565y) {
            com.tencent.mobileqq.util.c.a(this.K, this.f352497h.getString(R.string.z6p));
        }
        F();
        this.G.setVisibility(4);
        this.H.setVisibility(0);
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = arrayList.get(i16).byteValue();
        }
        PttAudioWaveView.d(iArr, i3);
        PttAudioWaveView pttAudioWaveView = this.H;
        pttAudioWaveView.setAudioData(iArr, pttAudioWaveView.getWidth(), ((int) this.f352500i0) / 1000);
        String b16 = com.tencent.mobileqq.audio.a.b(this.f352500i0 + 100.0d);
        this.I.setText(b16);
        ViewCompat.setImportantForAccessibility(this.I, 1);
        this.I.setContentDescription(this.f352497h.getString(R.string.f170478z70, b16));
    }

    private void l0() {
        this.f352487a0 = 2;
        this.f352490d = RecorderState.RECORD_TO_ENTER_LISTEN;
        setFocusable(true);
        update();
        this.N.setVisibility(4);
        this.P.setVisibility(8);
        this.J.setImageResource(R.drawable.mnu);
        this.J.setBackgroundResource(R.drawable.jan);
        W("audio_record_to_stop.json");
        this.K.setContentDescription(this.f352497h.getString(R.string.z7v));
        List<Animator> Q = Q(this.K, true);
        Q.add(P());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(Q);
        animatorSet.start();
        this.L.setVisibility(4);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str) {
        setFocusable(true);
        update();
        this.E.setVisibility(8);
        SpeechToTextNTLayout speechToTextNTLayout = this.R;
        if (speechToTextNTLayout == null) {
            SpeechToTextNTLayout speechToTextNTLayout2 = (SpeechToTextNTLayout) View.inflate(this.f352497h, R.layout.dzc, null);
            this.R = speechToTextNTLayout2;
            speechToTextNTLayout2.a1(this.f352492e, this.f352494f, N(), this.f352504m, this.Y, new b());
            this.D.addView(this.R, -1, -1);
        } else {
            speechToTextNTLayout.setVisibility(0);
        }
        this.R.setParam(str, this.C.j());
    }

    @Override // com.tencent.qqnt.audio.m
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("AudioPopupWindow", 1, "releaseTouch, curActiveArea:" + this.Z);
        int i3 = this.Z;
        if (i3 == 2) {
            f0();
            G(true);
            ReportController.y(N(), "0X800BFD8");
        } else if (i3 == 3) {
            l0();
            ReportController.y(N(), "0X800BFD9");
        } else if (i3 == 4) {
            i0();
            ReportController.y(N(), "0X800BFDE");
        } else {
            g0();
            G(true);
            ReportController.o(N(), "dc00898", "", "", "0X800BFD7", "0X800BFD7", 0, 1, "", "", "", "");
        }
    }

    @Override // com.tencent.qqnt.audio.m
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f352487a0 == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.audio.m
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("AudioPopupWindow", 1, "resetUi");
        setFocusable(false);
        update();
        this.E.setVisibility(0);
        SpeechToTextNTLayout speechToTextNTLayout = this.R;
        if (speechToTextNTLayout != null) {
            speechToTextNTLayout.setVisibility(8);
        }
        L();
        this.G.b();
        this.G.setVisibility(0);
        this.H.setVisibility(4);
        this.H.m();
        this.f352500i0 = 0.0d;
        this.I.setText(com.tencent.mobileqq.audio.a.b(0.0d));
        ViewCompat.setImportantForAccessibility(this.I, 2);
        this.T = null;
        this.J.setImageResource(R.drawable.mnt);
        this.J.setBackgroundResource(R.drawable.jak);
        this.K.setImageResource(R.drawable.f160325mo4);
        this.K.setBackgroundResource(R.drawable.jak);
        int O = O(R.dimen.c3c);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
        marginLayoutParams.bottomMargin = O;
        this.K.setLayoutParams(marginLayoutParams);
        c0(this.K, false);
        this.L.setImageResource(R.drawable.mo7);
        this.L.setBackgroundResource(R.drawable.jak);
        this.L.setVisibility(0);
        int O2 = O(R.dimen.c38);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
        marginLayoutParams2.width = O2;
        marginLayoutParams2.height = O2;
        this.L.setLayoutParams(marginLayoutParams2);
        int O3 = O(R.dimen.c3_);
        this.L.setPadding(O3, O3, O3, O3);
        this.M.setVisibility(0);
        this.N.setVisibility(0);
        this.P.setVisibility(0);
        this.P.setAlpha(1.0f);
        this.f352487a0 = 1;
        this.f352488b0 = false;
        Y(false);
    }

    @Override // com.tencent.qqnt.audio.m
    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.I.setText(com.tencent.mobileqq.audio.a.b(i3));
        }
    }

    @Override // com.tencent.qqnt.audio.m
    public void destroy() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        boolean isRecording = this.C.isRecording();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("destroy, isRecording:");
        sb5.append(isRecording);
        sb5.append("\uff0c isDismissed\uff1a");
        sb5.append(this.f352488b0);
        sb5.append(", speechToTextLayout is null:");
        if (this.R == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("AudioPopupWindow", 1, sb5.toString());
        this.f352491d0.removeCallbacksAndMessages(null);
        if (isRecording) {
            this.C.g(Boolean.FALSE);
            this.f352490d = RecorderState.RECORD_TO_CANCEL;
        }
        if (!this.f352488b0) {
            G(false);
        }
        SpeechToTextNTLayout speechToTextNTLayout = this.R;
        if (speechToTextNTLayout != null) {
            speechToTextNTLayout.destroy();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.dismiss();
        QLog.i("AudioPopupWindow", 1, "real dismiss");
        if (this.f352487a0 == 4) {
            SpeechToTextNTLayout speechToTextNTLayout = this.R;
            if (speechToTextNTLayout != null) {
                speechToTextNTLayout.i1();
                return;
            }
            return;
        }
        if (this.f352487a0 == 3) {
            Z();
        } else if (this.C.isRecording()) {
            this.C.g(Boolean.FALSE);
        }
    }

    @Override // com.tencent.qqnt.audio.m
    public void e(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent);
            return;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (rawX < this.U && rawY < this.W) {
            J();
            return;
        }
        if (rawX > this.V && rawY < this.W) {
            M();
        } else if (rawY < this.X) {
            K();
        } else {
            L();
        }
    }

    public void n0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (!X()) {
            return;
        }
        int length = f352486m0.length - 1;
        while (true) {
            if (length >= 0) {
                if (i3 > f352486m0[length]) {
                    break;
                } else {
                    length--;
                }
            } else {
                length = 0;
                break;
            }
        }
        this.G.c(length);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.y0a) {
                G(true);
            } else if (id5 == R.id.y0c) {
                if (this.f352487a0 == 3) {
                    R();
                } else if (this.C.isRecording()) {
                    this.C.g(Boolean.TRUE);
                }
            } else if (id5 == R.id.y0d) {
                Z();
                double d16 = this.f352500i0;
                if (d16 < 1000.0d) {
                    QQToast.makeText(this.f352497h, R.string.f8z, 0).show();
                } else {
                    this.C.h(this.f352496g0, Float.valueOf((float) d16), this.f352498h0, this.f352499i);
                    ReportController.o(N(), "dc00898", "", "", "0X800BFD7", "0X800BFD7", 0, 2, "", "", "", "");
                    G(false);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.audio.m
    public void show() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("show, windowToken is null:");
        if (this.f352504m.getWindowToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("AudioPopupWindow", 1, sb5.toString());
        if (this.f352504m.getWindowToken() == null) {
            return;
        }
        showAtLocation(this.f352504m, 0, 0, 0);
        I(false, null);
        d0();
    }
}
