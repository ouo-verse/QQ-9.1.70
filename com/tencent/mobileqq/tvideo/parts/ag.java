package com.tencent.mobileqq.tvideo.parts;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.parts.ag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes19.dex */
public class ag extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {
    private com.tencent.biz.qqcircle.immersive.layer.base.e D;
    private LottieAnimationView E;
    private TranslateAnimation F;
    private TranslateAnimation G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends com.tencent.biz.qqcircle.viewmodels.a> f304523d;

    /* renamed from: e, reason: collision with root package name */
    private View f304524e;

    /* renamed from: f, reason: collision with root package name */
    private View f304525f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f304526h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f304527i = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f304528m = false;
    private int C = 0;
    private Runnable I = new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.ac
        @Override // java.lang.Runnable
        public final void run() {
            ag.this.I9();
        }
    };

    public ag(Class<? extends com.tencent.biz.qqcircle.viewmodels.a> cls) {
        this.f304523d = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        View view;
        QLog.d("QFSTVideoPageNextVideoGuidePart", 1, "clearMantle");
        if (!isFinishing() && (view = this.f304524e) != null && view.getVisibility() != 8) {
            this.f304527i = false;
            if (iy2.a.g()) {
                this.f304524e.animate().alpha(0.0f).setDuration(500L).setListener(new b());
                return;
            }
            TranslateAnimation translateAnimation = this.F;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            TranslateAnimation translateAnimation2 = this.G;
            if (translateAnimation2 != null) {
                translateAnimation2.cancel();
            }
            this.f304528m = false;
            this.f304524e.setVisibility(8);
        }
    }

    private String E9() {
        return "https://ugd.gtimg.com//vg/1680860291622_slide_guide_anim.json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        LottieAnimationView lottieAnimationView = this.E;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        this.f304524e.setVisibility(8);
        this.f304528m = false;
    }

    private void G9(long j3) {
        if (this.f304527i && !this.f304528m) {
            this.f304528m = true;
            getMainHandler().removeCallbacks(this.I);
            getMainHandler().postDelayed(this.I, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(UIStateData uIStateData) {
        if (uIStateData != null && !uIStateData.isFakeData() && uIStateData.getData() != null && ((List) uIStateData.getData()).size() > 0 && !this.f304526h) {
            this.f304526h = true;
            this.C = uIStateData.getPos();
            O9(5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9() {
        if (iy2.a.g()) {
            D9();
        } else {
            L9();
        }
    }

    private void K9() {
        D9();
        this.f304528m = false;
        this.f304527i = false;
        uq3.k.a().j("tvideo_sp_is_show_next_guide_key", false);
    }

    private void L9() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -200.0f, 0.0f);
        this.G = translateAnimation;
        translateAnimation.setDuration(1000L);
        this.G.setAnimationListener(new a());
        this.f304525f.startAnimation(this.G);
    }

    private void M9() {
        View view = this.f304525f;
        if (view == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f45241rc);
        if (iy2.a.g()) {
            viewStub.setLayoutResource(R.layout.ggy);
            this.f304524e = viewStub.inflate();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f304524e.setLayoutParams(layoutParams);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f304524e.findViewById(R.id.f165628x12);
            this.E = lottieAnimationView;
            lottieAnimationView.setAnimationFromUrl(E9());
        } else {
            viewStub.setLayoutResource(R.layout.ggx);
            View inflate = viewStub.inflate();
            this.f304524e = inflate.findViewById(R.id.v8_);
            Option targetView = Option.obtain().setUrl("https://ugd.gtimg.com//vg/1672831714247_icon_general_doublearrow_down_secondary.png").setTargetView((ImageView) inflate.findViewById(R.id.f46731vd));
            targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(targetView, null);
        }
        uq3.k.a().j("tvideo_sp_is_show_next_guide_key", false);
    }

    private void N9() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -200.0f);
        this.F = translateAnimation;
        translateAnimation.setFillAfter(true);
        this.F.setDuration(1000L);
        this.f304525f.startAnimation(this.F);
    }

    private void O9(long j3) {
        G9(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void I9() {
        long j3;
        if (!this.f304527i) {
            this.f304528m = false;
            return;
        }
        M9();
        if (iy2.a.g()) {
            j3 = 5000;
        } else {
            N9();
            j3 = 2000;
        }
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.ae
            @Override // java.lang.Runnable
            public final void run() {
                ag.this.J9();
            }
        }, j3);
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.layer.base.e eVar = (com.tencent.biz.qqcircle.immersive.layer.base.e) getViewModel(this.f304523d);
        this.D = eVar;
        eVar.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.tvideo.parts.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ag.this.H9((UIStateData) obj);
            }
        });
    }

    private boolean isFinishing() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTVideoPageNextVideoGuidePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("layer_notify_part_update_feed_index".equals(str)) {
            Integer num = (Integer) obj;
            QLog.d("QFSTVideoPageNextVideoGuidePart", 1, "[handleBroadcastMessage] position : " + num + " mFirstFeedIndex = " + this.C);
            if (num.intValue() != 0) {
                if (this.C == 0 || num.intValue() != this.C) {
                    K9();
                    return;
                }
                return;
            }
            return;
        }
        if ("layer_notify_part_action_down".equals(str) && this.f304528m) {
            D9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        D9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f304525f = view;
        initViewModel();
        this.f304527i = uq3.k.a().c("tvideo_sp_is_show_next_guide_key", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        D9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.H = true;
        if (this.f304528m) {
            this.f304528m = false;
            getMainHandler().removeCallbacks(this.I);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.f304526h && this.H) {
            this.H = false;
            O9(5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ag.this.D9();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ag.this.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.a.this.b();
                }
            }, 2000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ag.this.F9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
