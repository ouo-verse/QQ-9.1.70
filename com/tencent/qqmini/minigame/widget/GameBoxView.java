package com.tencent.qqmini.minigame.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameBoxView extends DragableView {
    private ImageView U;
    private TextView V;
    private RelativeLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private View f346879a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f346880b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f346881c0;

    /* renamed from: d0, reason: collision with root package name */
    private ValueAnimator f346882d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = Integer.valueOf(valueAnimator.getAnimatedValue().toString()).intValue();
            ViewGroup.LayoutParams layoutParams = GameBoxView.this.getLayoutParams();
            layoutParams.width = intValue;
            GameBoxView.this.setLayoutParams(layoutParams);
            GameBoxView.this.v(intValue, layoutParams.height);
        }
    }

    public GameBoxView(Context context) {
        super(context);
        this.f346880b0 = false;
        this.f346881c0 = false;
        B(context);
    }

    private void B(Context context) {
        View.inflate(context, R.layout.mini_sdk_float_box_view, this);
        this.W = (RelativeLayout) findViewById(R.id.rl_content);
        this.U = (ImageView) findViewById(R.id.iv_icon);
        this.V = (TextView) findViewById(R.id.tv_dec);
        this.f346879a0 = findViewById(R.id.iv_red_dot);
    }

    public void A() {
        if (this.f346879a0.getVisibility() == 8) {
            return;
        }
        this.f346879a0.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams.leftMargin = ViewUtils.dpToPx(0.0f);
        layoutParams.topMargin = ViewUtils.dpToPx(0.0f);
        this.W.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.width = this.U.getWidth() + ViewUtils.dpToPx(10.0f);
        setLayoutParams(layoutParams2);
    }

    public boolean C() {
        if (this.f346879a0.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void D() {
        if (this.f346879a0.getVisibility() == 0) {
            return;
        }
        this.f346879a0.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams.leftMargin = ViewUtils.dpToPx(5.0f);
        layoutParams.topMargin = ViewUtils.dpToPx(5.0f);
        this.W.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView
    protected void k() {
        int i3;
        float x16 = getX();
        QMLog.e("GameBoxView", "[landSide] width:" + ViewUtils.getScreenWidth());
        int i16 = 2;
        if ((LiuHaiUtils.sHasNotch && getResources().getConfiguration().orientation == 2) || x16 > this.D / 2.0f) {
            i3 = this.D;
        } else {
            i3 = 0;
            i16 = 1;
        }
        ViewPropertyAnimator animate = animate();
        this.T = animate;
        animate.setInterpolator(new DecelerateInterpolator()).x(a(i3)).setDuration(250L).setListener(new c(i16)).start();
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public void n() {
        super.n();
        ValueAnimator valueAnimator = this.f346882d0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f346881c0 = false;
            z();
        }
        if (motionEvent.getAction() == 1) {
            this.f346881c0 = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setData(ku3.a aVar) {
        if (aVar == null) {
            return;
        }
        QMLog.d("GameBoxView", "[setData] icon: " + aVar.f413046b + ", title: " + aVar.f413049e);
        this.U.setImageDrawable(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(getContext(), aVar.f413046b, 0, 0, getContext().getResources().getDrawable(R.drawable.mini_sdk_game_box_icon), true));
        this.V.setText(aVar.f413049e);
        if (aVar.f413051g == null) {
            return;
        }
        QMLog.d("GameBoxView", "[setData] redInfo:" + aVar.f413051g.a());
        if (aVar.f413051g.f413053a) {
            D();
        } else {
            A();
        }
    }

    public void z() {
        if (this.f346880b0) {
            return;
        }
        this.f346880b0 = true;
        int width = this.U.getWidth() + ViewUtils.dpToPx(10.0f);
        if (this.f346879a0.getVisibility() == 0) {
            width += this.f346879a0.getWidth() / 2;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getWidth(), width);
        this.f346882d0 = ofInt;
        ofInt.setDuration(300L);
        this.f346882d0.addUpdateListener(new a());
        this.f346882d0.addListener(new b());
        this.f346882d0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!GameBoxView.this.f346881c0) {
                return;
            }
            int width = GameBoxView.this.U.getWidth() + ViewUtils.dpToPx(10.0f);
            if (GameBoxView.this.f346879a0.getVisibility() == 0) {
                width += GameBoxView.this.f346879a0.getWidth() / 2;
            }
            GameBoxView gameBoxView = GameBoxView.this;
            gameBoxView.v(width, gameBoxView.getHeight());
            GameBoxView.this.k();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f346885d;

        c(int i3) {
            this.f346885d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GameBoxView.this.o(this.f346885d);
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
}
