package com.tencent.mobileqq.tvideo.like;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import feedcloud.FeedCloudMeta$StFeed;
import zt2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoLikeAnimationView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f304471f = ViewUtils.dpToPx(125.0f);

    /* renamed from: h, reason: collision with root package name */
    private static final int f304472h = ViewUtils.dpToPx(125.0f);

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f304473d;

    /* renamed from: e, reason: collision with root package name */
    private int f304474e;

    public TVideoLikeAnimationView(Context context) {
        this(context, null);
    }

    private void a(@NonNull final ImageView imageView) {
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.f154898t3);
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.f154899t4);
        AnimationSet animationSet2 = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.f154900t5);
        animationSet.setAnimationListener(new a(imageView, scaleAnimation));
        scaleAnimation.setAnimationListener(new b(imageView, animationSet2));
        animationSet2.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.tvideo.like.TVideoLikeAnimationView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.like.TVideoLikeAnimationView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        TVideoLikeAnimationView.this.removeView(imageView);
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        imageView.startAnimation(animationSet);
    }

    private void b(float f16, float f17) {
        if (this.f304473d == null || !e.f453199a.k()) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        int i3 = f304471f;
        int i16 = f304472h;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.leftMargin = (int) (f16 - (i3 / 2));
        layoutParams.topMargin = (int) (f17 - i16);
        imageView.setRotation(e(this.f304474e));
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.ns9);
        addView(imageView);
        a(imageView);
        this.f304474e++;
    }

    private void c() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSDoublePraiseEvent(this.f304473d.f398449id.get()));
    }

    private float e(int i3) {
        int i16 = i3 % 3;
        if (i16 == 0) {
            return 0.0f;
        }
        if (i16 == 1) {
            return 15.0f;
        }
        return -15.0f;
    }

    public void f(float f16, float f17) {
        b(f16, f17);
        c();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.like.TVideoLikeAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                TVideoLikeAnimationView.this.removeAllViews();
            }
        });
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        setFeed(feedCloudMeta$StFeed, 0);
    }

    public TVideoLikeAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f304473d = feedCloudMeta$StFeed;
    }

    public TVideoLikeAnimationView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f304478d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f304479e;

        a(ImageView imageView, ScaleAnimation scaleAnimation) {
            this.f304478d = imageView;
            this.f304479e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f304478d.startAnimation(this.f304479e);
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
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f304481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimationSet f304482e;

        b(ImageView imageView, AnimationSet animationSet) {
            this.f304481d = imageView;
            this.f304482e = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f304481d.startAnimation(this.f304482e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void d() {
    }
}
