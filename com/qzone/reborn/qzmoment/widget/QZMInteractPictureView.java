package com.qzone.reborn.qzmoment.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.qzmoment.view.DragViewLayout;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.j;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes37.dex */
public class QZMInteractPictureView extends QZoneBaseWidgetView<bn.e> {
    private bn.b C;

    /* renamed from: e, reason: collision with root package name */
    private DragViewLayout f59119e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneTouchImageView f59120f;

    /* renamed from: h, reason: collision with root package name */
    private RoundCornerImageView f59121h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneTouchImageView f59122i;

    /* renamed from: m, reason: collision with root package name */
    private RoundCornerImageView f59123m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements j {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.j
        public void onScaleBegin(float f16) {
            QZMInteractPictureView.this.f59121h.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements com.tencent.biz.qqcircle.widgets.multitouchimg.e {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.e
        public void onDragEnd() {
            QZMInteractPictureView.this.f59121h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZMInteractPictureView.this.f59123m.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZMInteractPictureView.this.f59122i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class g implements IPicLoadStateListener {
        g() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishError()) {
                QLog.d("QZMInteractPictureView", 1, "[updateBigPicData] onStateChange  isFinishError | feedId = " + QZMInteractPictureView.this.getData().b().a().f430362id.get() + " | pos = " + QZMInteractPictureView.this.getData().c() + " | bigViewUrl = " + QZMInteractPictureView.this.y0(true) + " | hashCode = " + hashCode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class h implements IPicLoadStateListener {
        h() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishError()) {
                QLog.d("QZMInteractPictureView", 1, "[updateBigPicData] onStateChange  isFinishError | feedId = " + QZMInteractPictureView.this.getData().b().a().f430362id.get() + " | pos = " + QZMInteractPictureView.this.getData().c() + " | smallViewUrl = " + QZMInteractPictureView.this.y0(false) + " | hashCode = " + hashCode());
            }
        }
    }

    public QZMInteractPictureView(Context context) {
        this(context, null);
    }

    private void B0() {
        this.f59119e.setDragViewClickListener(new DragViewLayout.b() { // from class: com.qzone.reborn.qzmoment.widget.a
            @Override // com.qzone.reborn.qzmoment.view.DragViewLayout.b
            public final void onClick() {
                QZMInteractPictureView.this.C0();
            }
        });
        this.f59119e.e(R.id.jop);
        this.f59120f.setOnScaleBeginListener(new a());
        this.f59120f.setOnDragEndListener(new b());
    }

    private void u0() {
        int i3 = (int) dn.a.f394285a;
        int i16 = (int) (i3 / 0.7507f);
        ViewGroup.LayoutParams layoutParams = this.f59120f.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f59120f.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f59122i.getLayoutParams();
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        this.f59122i.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y0(boolean z16) {
        if (getData() == null || getData().a() == null || getData().d() == null) {
            return "";
        }
        if (z16) {
            if (getData().b().c()) {
                return getData().d().picUrl.get();
            }
            return getData().a().picUrl.get();
        }
        if (getData().b().c()) {
            return getData().a().picUrl.get();
        }
        return getData().d().picUrl.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void C0() {
        boolean c16 = getData().b().c();
        QLog.i("QZMInteractPictureView", 1, "handleOnClickSmallPic click  | feedId = " + getData().b().a().f430362id.get() + " | pos = " + getData().c() + " | reversePic = " + c16);
        getData().b().e(c16 ^ true);
        E0(this.f59121h);
        D0(this.f59120f);
        x0();
        w0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128232t;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u0();
    }

    public QZMInteractPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ImageView imageView) {
        Option failDrawable = Option.obtain().setUrl(y0(true)).setTargetView(imageView).setLoadingDrawable(getResources().getDrawable(R.drawable.at8)).setFailDrawable(getResources().getDrawable(R.drawable.at_));
        if (imageView.getLayoutParams() != null) {
            failDrawable.setRequestWidth(imageView.getLayoutParams().width);
            failDrawable.setRequestHeight(imageView.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(failDrawable, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(ImageView imageView) {
        Option failDrawable = Option.obtain().setUrl(y0(false)).setTargetView(imageView).setLoadingDrawable(getResources().getDrawable(R.drawable.at8)).setFailDrawable(getResources().getDrawable(R.drawable.at_));
        if (imageView.getLayoutParams() != null) {
            failDrawable.setRequestWidth(imageView.getLayoutParams().width);
            failDrawable.setRequestHeight(imageView.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(failDrawable, new h());
    }

    private void w0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new e());
        ofFloat.addListener(new f());
        ofFloat.start();
    }

    private void x0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new c());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    private void A0() {
        this.f59119e = (DragViewLayout) findViewById(R.id.f20498j);
        this.f59120f = (QZoneTouchImageView) findViewById(R.id.kue);
        this.f59122i = (QZoneTouchImageView) findViewById(R.id.kud);
        this.f59123m = (RoundCornerImageView) findViewById(R.id.lrz);
        this.f59121h = (RoundCornerImageView) findViewById(R.id.lva);
        this.f59120f.setCorner(ImmersiveUtils.dpToPx(20.0f));
        this.f59122i.setCorner(ImmersiveUtils.dpToPx(20.0f));
        this.f59121h.setBorder(true);
        this.f59121h.setCorner(ImmersiveUtils.dpToPx(10.0f));
        this.f59121h.setBorderWidth(ImmersiveUtils.dpToPx(4.0f));
        this.f59121h.setColor(getResources().getColor(R.color.qui_common_fill_light_tertiary));
        this.f59123m.setBorder(true);
        this.f59123m.setCorner(ImmersiveUtils.dpToPx(10.0f));
        this.f59123m.setBorderWidth(ImmersiveUtils.dpToPx(4.0f));
        this.f59123m.setColor(getResources().getColor(R.color.qui_common_fill_light_tertiary));
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void bindData(bn.e eVar, int i3) {
        if (eVar == null) {
            return;
        }
        this.C = eVar.b();
        u0();
        D0(this.f59120f);
        E0(this.f59121h);
        D0(this.f59122i);
        E0(this.f59123m);
        this.f59119e.setFeedData(this.C);
        QLog.i("QZMInteractPictureView", 1, "bindData  | feedId = " + eVar.b().a().f430362id.get() + " | pos = " + eVar.c() + " | bigViewUrl = " + y0(true) + " | smallViewUrl = " + y0(false) + " | reversePic = " + getData().b().c() + " | hashCode = " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZMInteractPictureView.this.f59123m.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QZMInteractPictureView.this.f59123m.setVisibility(0);
            QZMInteractPictureView qZMInteractPictureView = QZMInteractPictureView.this;
            qZMInteractPictureView.E0(qZMInteractPictureView.f59123m);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZMInteractPictureView.this.f59122i.setVisibility(8);
            QZMInteractPictureView qZMInteractPictureView = QZMInteractPictureView.this;
            qZMInteractPictureView.D0(qZMInteractPictureView.f59122i);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QZMInteractPictureView.this.f59122i.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
