package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AudioTransitionAnimManager {

    /* renamed from: h, reason: collision with root package name */
    private static Map<Integer, String> f178232h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f178233i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f178234j;

    /* renamed from: b, reason: collision with root package name */
    private Set<c> f178236b;

    /* renamed from: c, reason: collision with root package name */
    private Set<Integer> f178237c;

    /* renamed from: d, reason: collision with root package name */
    private Cancellable f178238d;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f178240f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f178241g;

    /* renamed from: e, reason: collision with root package name */
    private boolean f178239e = false;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, LottieDrawable> f178235a = new HashMap(20);

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final AudioTransitionAnimManager f178250a = new AudioTransitionAnimManager();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(LottieDrawable lottieDrawable, int i3);

        void b(Animator animator, int i3);
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_ROOT;
        sb5.append(str);
        sb5.append("/Tencent/MobileQQ/pttPanelAnimations/");
        f178233i = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        f178234j = VFSAssistantUtils.getSDKPrivatePath(str + "/Tencent/MobileQQ/pttPanelAnimations/qq_android_ptt_transition_anim_res_v8820/");
    }

    AudioTransitionAnimManager() {
        f178232h = new HashMap(20);
        this.f178236b = new HashSet();
        this.f178237c = new CopyOnWriteArraySet();
        f178232h.put(1, "ptt_voicechange_to_press_anim/");
        f178232h.put(2, "ptt_press_to_voicechange_anim/");
        f178232h.put(3, "ptt_press_to_record_anim/");
        f178232h.put(4, "ptt_record_to_press_anim/");
        f178232h.put(5, "ptt_record_to_stop_record_anim/");
        f178232h.put(201, "ptt_recordstop_to_play_anim/");
        f178232h.put(202, "ptt_play_to_stop_anim/");
        f178232h.put(203, "ptt_stop_to_play_anim/");
        f178232h.put(6, "ptt_record_to_voicechange_anim/");
        f178232h.put(7, "ptt_voicechange_to_record_anim/");
        f178232h.put(101, "ptt_voicechange_to_press_anim_night/");
        f178232h.put(102, "ptt_press_to_voicechange_anim_night/");
        f178232h.put(103, "ptt_press_to_record_anim_night/");
        f178232h.put(104, "ptt_record_to_press_anim_night/");
        f178232h.put(105, "ptt_record_to_stop_record_anim_night/");
        f178232h.put(301, "ptt_recordstop_to_play_anim_night/");
        f178232h.put(302, "ptt_play_to_stop_anim_night/");
        f178232h.put(303, "ptt_stop_to_play_anim_night/");
        f178232h.put(106, "ptt_record_to_voicechange_anim_night/");
        f178232h.put(107, "ptt_voicechange_to_record_anim_night/");
    }

    private void h() {
        Iterator<String> it = this.f178235a.keySet().iterator();
        while (it.hasNext()) {
            LottieDrawable lottieDrawable = this.f178235a.get(it.next());
            lottieDrawable.cancelAnimation();
            lottieDrawable.removeAllAnimatorListeners();
            lottieDrawable.setImageAssetDelegate(null);
        }
        this.f178235a.clear();
    }

    public static AudioTransitionAnimManager k() {
        return b.f178250a;
    }

    private void l() {
        if (this.f178240f == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AudioTransitionAnimManager");
            this.f178240f = baseHandlerThread;
            baseHandlerThread.start();
            this.f178241g = new Handler(this.f178240f.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Animator animator, int i3) {
        for (c cVar : this.f178236b) {
            if (cVar != null) {
                cVar.b(animator, i3);
            }
        }
    }

    private void r(LottieDrawable lottieDrawable, int i3) {
        for (c cVar : this.f178236b) {
            if (cVar != null) {
                cVar.a(lottieDrawable, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void p(LottieComposition lottieComposition, int i3, String str, Context context) {
        if (lottieComposition == null) {
            QLog.e("AudioTransitionAnimManager", 2, "getDrawable onCompositionLoaded lottieComposition is null or mIsDestroyed:");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable finish type" + i3);
        }
        this.f178237c.remove(Integer.valueOf(i3));
        LottieDrawable lottieDrawable = new LottieDrawable();
        f fVar = new f(context, str);
        lottieDrawable.setComposition(lottieComposition);
        lottieDrawable.setImageAssetDelegate(fVar);
        if (!o()) {
            this.f178235a.put(str, lottieDrawable);
        }
        r(lottieDrawable, i3);
    }

    private void v() {
        Handler handler = this.f178241g;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.f178241g = null;
        }
        HandlerThread handlerThread = this.f178240f;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f178240f = null;
        }
    }

    private void w(final int i3, final String str, final Context context) {
        if (o()) {
            x(i3, str, context);
        } else {
            this.f178241g.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager$1$a */
                /* loaded from: classes10.dex */
                class a implements OnCompositionLoadedListener {
                    a() {
                    }

                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AudioTransitionAnimManager.this.p(lottieComposition, i3, str, context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AudioTransitionAnimManager.this.f178238d = LottieComposition.Factory.fromInputStream(new FileInputStream(AudioTransitionAnimManager.f178234j + str + LottieLoader.FILE_DATA_JSON), new a());
                    } catch (Throwable th5) {
                        QLog.e("AudioTransitionAnimManager", 1, "loadVoiceAnimation fail.", th5);
                        AudioTransitionAnimManager.this.f178237c.remove(Integer.valueOf(i3));
                    }
                }
            });
        }
    }

    private void x(final int i3, final String str, final Context context) {
        try {
            StringBuilder sb5 = new StringBuilder();
            String str2 = f178234j;
            sb5.append(str2);
            sb5.append(str);
            sb5.append(LottieLoader.FILE_DATA_JSON);
            LottieCompositionFactory.fromJsonInputStream(new FileInputStream(sb5.toString()), str2 + str + LottieLoader.FILE_DATA_JSON).addListener(new LottieListener() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.d
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    AudioTransitionAnimManager.this.p(i3, str, context, (LottieComposition) obj);
                }
            });
        } catch (Throwable th5) {
            QLog.e("AudioTransitionAnimManager", 1, "runLoadResUseCache fail.", th5);
            this.f178237c.remove(Integer.valueOf(i3));
        }
    }

    public void f(c cVar) {
        this.f178236b.add(cVar);
    }

    public void g(LottieDrawable lottieDrawable) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel cancelAnimation drawable=" + lottieDrawable);
        }
        lottieDrawable.cancelAnimation();
    }

    public LottieDrawable i(Context context, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable type" + i3);
        }
        l();
        Map<Integer, String> map = f178232h;
        if (map != null && map.containsKey(Integer.valueOf(i3))) {
            String str = f178232h.get(Integer.valueOf(i3));
            if (QLog.isColorLevel()) {
                QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable type=" + i3 + ", path=" + str + ", UNZipFilePath=" + f178234j);
            }
            if (!o() && this.f178235a.containsKey(str) && this.f178235a.get(str) != null) {
                return this.f178235a.get(str);
            }
            if (this.f178237c.contains(Integer.valueOf(i3))) {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable loading type" + i3);
                }
                return null;
            }
            this.f178237c.add(Integer.valueOf(i3));
            w(i3, str, context);
            return null;
        }
        QLog.e("AudioTransitionAnimManager", 1, "getDrawable mResPathMap error.");
        return null;
    }

    public boolean j() {
        return n();
    }

    public boolean m(LottieDrawable lottieDrawable) {
        return lottieDrawable.isAnimating();
    }

    public boolean n() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioTransitionAnimManager", 2, "isFileExsit fileExsit = " + this.f178239e);
        }
        if (this.f178239e) {
            return true;
        }
        File file = new File(f178234j);
        if (file.exists() && f178232h != null && file.listFiles() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioTransitionAnimManager", 2, "isFileExsit f.listFiles().length = " + file.listFiles().length + ", mResPathMap.size() = " + f178232h.size());
            }
            if (file.listFiles().length >= f178232h.size()) {
                this.f178239e = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean o() {
        return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("9065_aio_ptt_panel_122941576", Boolean.TRUE).booleanValue();
    }

    public void s() {
        this.f178236b.clear();
        this.f178237c.clear();
        Cancellable cancellable = this.f178238d;
        if (cancellable != null) {
            cancellable.cancel();
            this.f178238d = null;
        }
        if (this.f178235a != null) {
            h();
        }
        v();
    }

    public void u(LottieDrawable lottieDrawable, int i3, ImageView imageView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel playTransitionAnim   type" + i3 + " drawable=" + lottieDrawable + " needDoPlay= " + z16);
        }
        if (lottieDrawable != null && imageView != null) {
            imageView.setImageDrawable(lottieDrawable);
            lottieDrawable.removeAllAnimatorListeners();
            lottieDrawable.addAnimatorListener(new a(lottieDrawable, i3, imageView));
            if (z16) {
                lottieDrawable.playAnimation();
            }
        }
    }

    public void y(LottieDrawable lottieDrawable, float f16, int i3, boolean z16) {
        if (!z16 && f16 <= 1.0f && f16 >= 0.0f) {
            if (e.e(i3)) {
                f16 = 1.0f - f16;
            }
            lottieDrawable.setProgress(f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieDrawable f178246d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f178247e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f178248f;

        a(LottieDrawable lottieDrawable, int i3, ImageView imageView) {
            this.f178246d = lottieDrawable;
            this.f178247e = i3;
            this.f178248f = imageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationCancel drawable=" + this.f178246d);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationEnd drawable=" + this.f178246d);
            }
            AudioTransitionAnimManager.this.q(animator, this.f178247e);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationStart drawable=" + this.f178246d);
            }
            if (e.e(this.f178247e) && this.f178246d.getSpeed() > 0.0f) {
                this.f178246d.reverseAnimationSpeed();
            }
            this.f178248f.invalidateDrawable(this.f178246d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
