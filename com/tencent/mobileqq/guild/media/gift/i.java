package com.tencent.mobileqq.guild.media.gift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.guild.media.core.notify.m;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/i;", "", "Landroid/view/View;", "animViewBg", "Landroid/widget/ImageView;", "giftView", "avatarView", "", "Landroid/animation/ValueAnimator;", "d", "giftImageView", "Lcom/tencent/mobileqq/guild/media/core/notify/m;", "giftEvent", "", "b", "view", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/guild/media/gift/k;", "Ljava/util/concurrent/ConcurrentHashMap;", "animViewDataMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f228937a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, ViewAnimBean> animViewDataMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/gift/i$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f228939d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f228940e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f228941f;

        a(View view, ImageView imageView, AnimatorSet animatorSet) {
            this.f228939d = view;
            this.f228940e = imageView;
            this.f228941f = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            Integer num;
            ViewAnimBean viewAnimBean = (ViewAnimBean) i.animViewDataMap.get(Integer.valueOf(this.f228939d.hashCode()));
            boolean z16 = false;
            if (viewAnimBean != null && viewAnimBean.getNeedReStart()) {
                z16 = true;
            }
            if (z16) {
                this.f228941f.start();
            } else {
                ViewAnimBean viewAnimBean2 = (ViewAnimBean) i.animViewDataMap.get(Integer.valueOf(this.f228939d.hashCode()));
                if (viewAnimBean2 != null) {
                    viewAnimBean2.d(-1);
                }
                this.f228940e.setVisibility(8);
                this.f228939d.animate().alpha(0.0f).setDuration(150L).start();
            }
            Logger logger = Logger.f235387a;
            View view = this.f228939d;
            Logger.a d16 = logger.d();
            int hashCode = view.hashCode();
            ViewAnimBean viewAnimBean3 = (ViewAnimBean) i.animViewDataMap.get(Integer.valueOf(view.hashCode()));
            if (viewAnimBean3 != null) {
                num = Integer.valueOf(viewAnimBean3.getGiftId());
            } else {
                num = null;
            }
            d16.i("GuildMediaGiftMicAnimIm", 1, "[checkToShowMicGiftAnim onAnimationEnd] id:" + hashCode + ", , giftID=" + num);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            Integer num;
            ViewAnimBean viewAnimBean = (ViewAnimBean) i.animViewDataMap.get(Integer.valueOf(this.f228939d.hashCode()));
            if (viewAnimBean != null) {
                viewAnimBean.e(false);
            }
            if (this.f228940e.getVisibility() != 0) {
                this.f228940e.setVisibility(0);
            }
            Logger logger = Logger.f235387a;
            View view = this.f228939d;
            Logger.a d16 = logger.d();
            int hashCode = view.hashCode();
            ViewAnimBean viewAnimBean2 = (ViewAnimBean) i.animViewDataMap.get(Integer.valueOf(view.hashCode()));
            if (viewAnimBean2 != null) {
                num = Integer.valueOf(viewAnimBean2.getGiftId());
            } else {
                num = null;
            }
            d16.i("GuildMediaGiftMicAnimIm", 1, "[checkToShowMicGiftAnim onAnimationStart] id:" + hashCode + ", giftID=" + num);
        }
    }

    i() {
    }

    private final List<ValueAnimator> d(View animViewBg, ImageView giftView, View avatarView) {
        ArrayList arrayListOf;
        if (giftView == null) {
            return new ArrayList();
        }
        animViewBg.setAlpha(1.0f);
        animViewBg.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(giftView, "translationY", giftView.getHeight(), -(animViewBg.getHeight() - (giftView.getHeight() / 3)));
        ofFloat.setDuration(400L);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(\n               \u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_X, 1.5f, 1.2f);
        ofFloat2.setDuration(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_Y, 1.5f, 1.2f);
        ofFloat3.setDuration(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(giftView, "translationY", -(animViewBg.getHeight() - (giftView.getHeight() / 3)), -((animViewBg.getHeight() - avatarView.getHeight()) - (giftView.getHeight() / 2)));
        ofFloat4.setDuration(400L);
        ofFloat4.setStartDelay(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(\n               \u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_X, 1.2f, 1.0f);
        ofFloat5.setDuration(700L);
        ofFloat5.setStartDelay(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_Y, 1.2f, 1.0f);
        ofFloat6.setDuration(700L);
        ofFloat6.setStartDelay(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat6, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(giftView, "translationY", -((animViewBg.getHeight() - avatarView.getHeight()) - (giftView.getHeight() / 2)), -(animViewBg.getHeight() - (giftView.getHeight() / 3)));
        ofFloat7.setDuration(300L);
        ofFloat7.setStartDelay(1900L);
        Intrinsics.checkNotNullExpressionValue(ofFloat7, "ofFloat(\n               \u2026+ ANIM_STAY\n            }");
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_X, 1.2f, 0.9f);
        ofFloat8.setDuration(700L);
        ofFloat8.setStartDelay(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat8, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_Y, 1.2f, 0.9f);
        ofFloat9.setDuration(700L);
        ofFloat9.setStartDelay(400L);
        Intrinsics.checkNotNullExpressionValue(ofFloat9, "ofFloat(giftView, ATTE_S\u2026IM_DURATION\n            }");
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(giftView, "translationY", -(animViewBg.getHeight() - (giftView.getHeight() / 3)), -((float) ((animViewBg.getHeight() - (avatarView.getHeight() * 1.2d)) - (giftView.getHeight() / 2))));
        ofFloat10.setDuration(200L);
        ofFloat10.setStartDelay(2200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat10, "ofFloat(\n               \u2026+ ANIM_STAY\n            }");
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_X, 0.9f, 0.0f);
        ofFloat11.setDuration(200L);
        ofFloat11.setStartDelay(2200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat11, "ofFloat(giftView, ATTE_S\u2026+ ANIM_STAY\n            }");
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(giftView, BasicAnimation.KeyPath.SCALE_Y, 0.9f, 0.0f);
        ofFloat12.setDuration(200L);
        ofFloat12.setStartDelay(2200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat12, "ofFloat(giftView, ATTE_S\u2026+ ANIM_STAY\n            }");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofFloat8, ofFloat9, ofFloat10, ofFloat11, ofFloat12);
        return arrayListOf;
    }

    public final void b(@NotNull View animViewBg, @NotNull View avatarView, @NotNull ImageView giftImageView, @NotNull m giftEvent) {
        int i3;
        AnimatorSet animSet;
        Intrinsics.checkNotNullParameter(animViewBg, "animViewBg");
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(giftImageView, "giftImageView");
        Intrinsics.checkNotNullParameter(giftEvent, "giftEvent");
        ViewAnimBean viewAnimBean = animViewDataMap.get(Integer.valueOf(animViewBg.hashCode()));
        if (viewAnimBean != null) {
            i3 = viewAnimBean.getGiftId();
        } else {
            i3 = -1;
        }
        if (i3 == giftEvent.getGiftData().f264910a) {
            ViewAnimBean viewAnimBean2 = animViewDataMap.get(Integer.valueOf(animViewBg.hashCode()));
            if (viewAnimBean2 != null) {
                viewAnimBean2.e(true);
                return;
            }
            return;
        }
        ViewAnimBean viewAnimBean3 = animViewDataMap.get(Integer.valueOf(animViewBg.hashCode()));
        if (viewAnimBean3 != null) {
            viewAnimBean3.e(false);
        }
        giftImageView.setImageURI(Uri.parse(giftEvent.getPngFilePath()));
        ViewAnimBean viewAnimBean4 = animViewDataMap.get(Integer.valueOf(animViewBg.hashCode()));
        if (viewAnimBean4 != null && (animSet = viewAnimBean4.getAnimSet()) != null) {
            animSet.cancel();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(f228937a.d(animViewBg, giftImageView, avatarView));
        animatorSet.addListener(new a(animViewBg, giftImageView, animatorSet));
        animViewDataMap.put(Integer.valueOf(animViewBg.hashCode()), new ViewAnimBean(giftEvent.getGiftData().f264910a, false, animatorSet));
        animatorSet.start();
    }

    public final void c(@NotNull View view) {
        AnimatorSet animSet;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewAnimBean viewAnimBean = animViewDataMap.get(Integer.valueOf(view.hashCode()));
        if (viewAnimBean != null && (animSet = viewAnimBean.getAnimSet()) != null) {
            animSet.cancel();
        }
        animViewDataMap.remove(Integer.valueOf(view.hashCode()));
    }
}
