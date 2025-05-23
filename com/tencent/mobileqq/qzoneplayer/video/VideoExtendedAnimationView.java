package com.tencent.mobileqq.qzoneplayer.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.transfile.report.ReportConstant;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoExtendedAnimationView extends RelativeLayout {
    public static int R = 3;
    TextView C;
    ImageView D;
    TextView E;
    public int F;
    int G;
    boolean H;
    CountDownTimer I;
    boolean J;
    boolean K;
    private int L;
    private int M;
    private boolean N;
    private int P;
    private boolean Q;

    /* renamed from: d, reason: collision with root package name */
    LinearLayout f279912d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f279913e;

    /* renamed from: f, reason: collision with root package name */
    LinearLayout f279914f;

    /* renamed from: h, reason: collision with root package name */
    TextView f279915h;

    /* renamed from: i, reason: collision with root package name */
    ImageView f279916i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f279917m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzoneplayer.video.VideoExtendedAnimationView$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ VideoExtendedAnimationView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoExtendedAnimationView.this.f279917m.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends CountDownTimer {
        b(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VideoExtendedAnimationView.this.getClass();
            throw null;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            VideoExtendedAnimationView.this.E.setText(String.valueOf(VideoExtendedAnimationView.this.G) + ReportConstant.COSTREPORT_PREFIX);
            VideoExtendedAnimationView videoExtendedAnimationView = VideoExtendedAnimationView.this;
            videoExtendedAnimationView.G = videoExtendedAnimationView.G + (-1);
            if (j3 / 1000 > VideoExtendedAnimationView.R || videoExtendedAnimationView.H) {
                return;
            }
            videoExtendedAnimationView.getClass();
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 1) {
                VideoExtendedAnimationView.this.getClass();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 1) {
                VideoExtendedAnimationView.this.getClass();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 1) {
                VideoExtendedAnimationView.this.getClass();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 1) {
                VideoExtendedAnimationView.this.getClass();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoExtendedAnimationView.this.f279912d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoExtendedAnimationView.this.f279916i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoExtendedAnimationView videoExtendedAnimationView = VideoExtendedAnimationView.this;
            if (videoExtendedAnimationView.K) {
                return;
            }
            if (!videoExtendedAnimationView.Q) {
                VideoExtendedAnimationView.this.i();
            } else {
                VideoExtendedAnimationView videoExtendedAnimationView2 = VideoExtendedAnimationView.this;
                videoExtendedAnimationView2.P = videoExtendedAnimationView2.G;
            }
            VideoExtendedAnimationView.this.J = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoExtendedAnimationView.this.C.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface j {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface k {
    }

    public VideoExtendedAnimationView(Context context) {
        super(context);
        this.F = 3;
        this.J = true;
        this.K = false;
        this.N = false;
    }

    private void e() {
        this.f279912d.setVisibility(4);
        this.f279916i.setVisibility(4);
        this.f279917m.setVisibility(4);
        this.C.setVisibility(4);
        this.D.setVisibility(4);
        this.E.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.I != null) {
            d();
            this.G = this.F;
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.I.start();
        }
    }

    public void d() {
        CountDownTimer countDownTimer = this.I;
        if (countDownTimer != null) {
            this.H = false;
            countDownTimer.cancel();
        }
    }

    public void f() {
        this.f279912d = (LinearLayout) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD));
        this.f279913e = (ImageView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT));
        this.f279915h = (TextView) findViewById(FeedVideoEnv.playerResources.getViewId(567));
        this.f279916i = (ImageView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON));
        this.f279917m = (ImageView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON));
        this.C = (TextView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT));
        this.D = (ImageView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE));
        this.E = (TextView) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_TV_COUNTDOWN));
        this.f279914f = (LinearLayout) findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER));
    }

    public void g() {
        e();
        ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 0.6f).setDuration(300L);
        float measuredHeight = getMeasuredHeight() / 2.0f;
        float measuredHeight2 = measuredHeight - (this.f279912d.getMeasuredHeight() / 2);
        ObjectAnimator.ofFloat(this.f279912d, "Y", measuredHeight2).setDuration(10L).start();
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f279912d, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f)).setDuration(400L);
        duration.setStartDelay(500L);
        duration.addListener(new g());
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f279912d, "Y", measuredHeight2, (measuredHeight - (this.f279912d.getMeasuredHeight() / 2)) - FeedVideoEnv.dp32).setDuration(300L);
        duration2.setStartDelay(1100L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.f279916i, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(800L);
        duration3.setStartDelay(1100L);
        duration3.addListener(new h());
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.C, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(240L);
        duration4.setStartDelay(1260L);
        duration4.addListener(new i());
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.f279917m, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 0.0f).setDuration(1300L);
        if (this.F >= 3) {
            duration5.setRepeatCount(1);
        }
        duration5.setStartDelay(1900L);
        duration5.addListener(new a());
        duration.start();
        duration2.start();
        duration3.start();
        duration4.start();
        if (this.F > 1) {
            duration5.start();
        }
    }

    public void h() {
        d();
        this.J = true;
    }

    public void j() {
        if (this.N) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = this.L;
            layoutParams.height = this.M;
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.N) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.L, 1073741824);
            i16 = View.MeasureSpec.makeMeasureSpec(this.M, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public void setAnimationCancled(boolean z16) {
        this.K = z16;
    }

    public void setBtn_jump_to_target(String str) {
        this.C.setText(str);
    }

    public void setBtn_jump_to_targetWithInvalidate(String str) {
        this.C.setText(str);
        TextView textView = this.C;
        textView.invalidate(0, 0, textView.getWidth(), this.C.getHeight());
    }

    public void setCanLandscape(boolean z16) {
        this.J = z16;
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.L = i3;
        this.M = i16;
        this.N = z16;
    }

    public void setCoutndown(int i3) {
        this.F = i3;
        this.G = i3;
        this.I = new b(this.G * 1000, 950L);
    }

    public void setItemOnTouchListener() {
        setOnTouchListener(new c());
        this.f279914f.setOnTouchListener(new d());
        this.f279915h.setOnTouchListener(new e());
        this.f279916i.setOnTouchListener(new f());
    }

    public void setShowUpWaveBtnCountDownSecond(int i3) {
        R = i3;
    }

    public void setTv_user_name(String str) {
        this.f279915h.setText(str);
    }

    public VideoExtendedAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 3;
        this.J = true;
        this.K = false;
        this.N = false;
    }

    public VideoExtendedAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 3;
        this.J = true;
        this.K = false;
        this.N = false;
    }

    public void setOnExtendedAnimationClickedListener(j jVar) {
    }

    public void setOnJumpToNextVideoListener(k kVar) {
    }
}
