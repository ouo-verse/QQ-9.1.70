package com.tencent.mobileqq.guild.feed.gallery.widget;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedDoublePraiseView;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes13.dex */
public class GuildFeedDoublePraiseView extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private static final int f219778e = ViewUtils.dpToPx(55.0f);

    /* renamed from: f, reason: collision with root package name */
    private static final int f219779f = ViewUtils.dpToPx(55.0f);

    /* renamed from: d, reason: collision with root package name */
    private int f219780d;

    /* loaded from: classes13.dex */
    public interface d {
    }

    public GuildFeedDoublePraiseView(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ d b(GuildFeedDoublePraiseView guildFeedDoublePraiseView) {
        guildFeedDoublePraiseView.getClass();
        return null;
    }

    private void c(float f16, float f17, float f18) {
        ImageView imageView = new ImageView(getContext());
        int i3 = (int) (f219778e * f18);
        int i16 = (int) (f219779f * f18);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.leftMargin = (int) (f16 - (i3 / 2));
        layoutParams.topMargin = (int) (f17 - i16);
        imageView.setRotation(e(this.f219780d));
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.guild_feed_gallery_like_double_click_anim);
        addView(imageView);
        d(imageView);
        this.f219780d++;
    }

    private void d(@NonNull ImageView imageView) {
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.f154596o4);
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.f154597o5);
        AnimationSet animationSet2 = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.f154598o6);
        animationSet.setAnimationListener(new a(imageView, scaleAnimation));
        scaleAnimation.setAnimationListener(new b(imageView, animationSet2));
        animationSet2.setAnimationListener(new c(imageView));
        imageView.startAnimation(animationSet);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        removeAllViews();
    }

    public void g(float f16, float f17) {
        c(f16, f17, 1.0f);
    }

    public void h(float f16, float f17, float f18) {
        c(f16, f17, f18);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDoublePraiseView.this.f();
            }
        });
    }

    public GuildFeedDoublePraiseView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedDoublePraiseView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f219781d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f219782e;

        a(ImageView imageView, ScaleAnimation scaleAnimation) {
            this.f219781d = imageView;
            this.f219782e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f219781d.startAnimation(this.f219782e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f219784d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimationSet f219785e;

        b(ImageView imageView, AnimationSet animationSet) {
            this.f219784d = imageView;
            this.f219785e = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f219784d.startAnimation(this.f219785e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f219787d;

        c(ImageView imageView) {
            this.f219787d = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ImageView imageView) {
            GuildFeedDoublePraiseView.this.removeView(imageView);
            GuildFeedDoublePraiseView.b(GuildFeedDoublePraiseView.this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            final ImageView imageView = this.f219787d;
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedDoublePraiseView.c.this.b(imageView);
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void setAnimationEndCallback(d dVar) {
    }
}
