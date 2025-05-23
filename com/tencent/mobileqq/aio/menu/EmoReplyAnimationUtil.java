package com.tencent.mobileqq.aio.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Size;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.utils.ag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi;
import com.tencent.qqnt.aio.api.impl.AIOEmoReplyMenuApiImpl;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySetVisibleMsgEvent;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/menu/EmoReplyAnimationUtil;", "", "Landroidx/fragment/app/FragmentActivity;", EventKey.ACT, "Lcom/tencent/qqnt/aio/emoreply/h;", "info", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Landroid/view/View;", "g", h.F, "Lkotlin/Triple;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "f", "parentLayout", "animationImageView", "lottieImageView", "", "i", "", "start", "control", "end", "", "t", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "lottieFilePath", "l", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class EmoReplyAnimationUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final EmoReplyAnimationUtil f189971a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MsgRecord msgRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/menu/EmoReplyAnimationUtil$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f189973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f189974e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f189975f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f189976h;

        a(FragmentActivity fragmentActivity, ImageView imageView, ImageView imageView2, Ref.ObjectRef<String> objectRef) {
            this.f189973d = fragmentActivity;
            this.f189974e = imageView;
            this.f189975f = imageView2;
            this.f189976h = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fragmentActivity, imageView, imageView2, objectRef);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                EmoReplyAnimationUtil.f189971a.l(this.f189973d, this.f189974e, this.f189975f, this.f189976h.element);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f189971a = new EmoReplyAnimationUtil();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.menu.b
                @Override // java.lang.Runnable
                public final void run() {
                    EmoReplyAnimationUtil.d();
                }
            }, 16, null, true);
        }
    }

    EmoReplyAnimationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        com.tencent.qqnt.aio.anisticker.view.h.f348873a.e();
    }

    private final float e(int start, int control, int end, float t16) {
        float f16 = 1 - t16;
        double d16 = 2;
        return (((float) Math.pow(f16, d16)) * start) + (2 * f16 * t16 * control) + (((float) Math.pow(t16, d16)) * end);
    }

    private final Triple<FrameLayout, ImageView, ImageView> f(FragmentActivity act, com.tencent.qqnt.aio.emoreply.h info, MsgRecord msg2) {
        String str;
        FrameLayout frameLayout = new FrameLayout(act);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.b(100), l.b(100));
        layoutParams.leftMargin = info.f()[0];
        layoutParams.topMargin = info.f()[1];
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(act);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.b(100), l.b(100));
        layoutParams2.gravity = 17;
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView2 = new ImageView(act);
        imageView2.setId(R.id.y9o);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) l.a(20.0f), (int) l.a(20.0f));
        layoutParams3.gravity = 17;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageDrawable(info.b().a());
        List<String> topBgEmojiIdList = ((IAIOEmoReplyMenuApi) QRoute.api(IAIOEmoReplyMenuApi.class)).getTopBgEmojiIdList();
        MsgEmojiLikes d16 = info.d();
        if (d16 == null || (str = d16.emojiId) == null) {
            str = "";
        }
        if (topBgEmojiIdList.contains(str)) {
            frameLayout.addView(imageView2);
            frameLayout.addView(imageView);
        } else {
            frameLayout.addView(imageView);
            frameLayout.addView(imageView2);
        }
        msgRecord = msg2;
        return new Triple<>(frameLayout, imageView2, imageView);
    }

    private final View g(FragmentActivity act, com.tencent.qqnt.aio.emoreply.h info, MsgRecord msg2) {
        Triple<FrameLayout, ImageView, ImageView> f16 = f(act, info, msg2);
        FrameLayout component1 = f16.component1();
        i(act, info, component1, f16.component2(), f16.component3());
        return component1;
    }

    private final View h(FragmentActivity act, com.tencent.qqnt.aio.emoreply.h info, MsgRecord msg2) {
        Triple<FrameLayout, ImageView, ImageView> f16 = f(act, info, msg2);
        FrameLayout component1 = f16.component1();
        ImageView component2 = f16.component2();
        ImageView component3 = f16.component3();
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f17 != null) {
            CorountineFunKt.e(f17, "EmoReplyAnimationUtil", null, null, null, new EmoReplyAnimationUtil$createScaleAnimationView$1(component1, info, act, component2, component3, null), 14, null);
        }
        return component1;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.String] */
    private final void i(FragmentActivity act, final com.tencent.qqnt.aio.emoreply.h info, final FrameLayout parentLayout, ImageView animationImageView, ImageView lottieImageView) {
        String str;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AIOEmoReplyMenuApiImpl.Companion companion = AIOEmoReplyMenuApiImpl.INSTANCE;
        objectRef.element = companion.a();
        MsgEmojiLikes d16 = info.d();
        if (d16 != null && (str = d16.emojiId) != null) {
            final File file = new File(companion.b() + str + Sticker.JSON_SUFFIX);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.menu.c
                @Override // java.lang.Runnable
                public final void run() {
                    EmoReplyAnimationUtil.j(Ref.ObjectRef.this, file);
                }
            }, 16, null, true);
        }
        final int[] iArr = {(info.f()[0] + info.c()[0]) / 2, info.f()[1] - 200};
        ArrayList arrayList = new ArrayList();
        ValueAnimator translateAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        translateAnimator.setInterpolator(new LinearInterpolator());
        final float a16 = ((-l.b(100)) / 2) + (l.a(20.0f) / 2);
        translateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.menu.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmoReplyAnimationUtil.k(com.tencent.qqnt.aio.emoreply.h.this, iArr, parentLayout, a16, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(translateAnimator, "translateAnimator");
        arrayList.add(translateAnimator);
        View g16 = info.g();
        if (g16 != null) {
            g16.setPivotX(0.0f);
            g16.setPivotY(g16.getMeasuredHeight() / 2.0f);
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(g16, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(g16, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(g16, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(alphaAnimator, "alphaAnimator");
            arrayList.add(alphaAnimator);
            Intrinsics.checkNotNullExpressionValue(scaleXAnimator, "scaleXAnimator");
            arrayList.add(scaleXAnimator);
            Intrinsics.checkNotNullExpressionValue(scaleYAnimator, "scaleYAnimator");
            arrayList.add(scaleYAnimator);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.addListener(new a(act, animationImageView, lottieImageView, objectRef));
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Ref.ObjectRef lottieFilePath, File file) {
        T t16;
        Intrinsics.checkNotNullParameter(lottieFilePath, "$lottieFilePath");
        Intrinsics.checkNotNullParameter(file, "$file");
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            t16 = absolutePath;
        } else {
            t16 = AIOEmoReplyMenuApiImpl.INSTANCE.a();
        }
        lottieFilePath.element = t16;
        QLog.i("EmoReplyAnimationUtil", 1, "doParabolaAnimation  filePath:" + t16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(com.tencent.qqnt.aio.emoreply.h info, int[] controlPoint, FrameLayout parentLayout, float f16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(controlPoint, "$controlPoint");
        Intrinsics.checkNotNullParameter(parentLayout, "$parentLayout");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        EmoReplyAnimationUtil emoReplyAnimationUtil = f189971a;
        float e16 = emoReplyAnimationUtil.e(info.f()[0], controlPoint[0], info.c()[0], floatValue);
        float e17 = emoReplyAnimationUtil.e(info.f()[1], controlPoint[1], info.c()[1] + info.a(), floatValue);
        parentLayout.setX(e16 + f16);
        parentLayout.setY(e17 + f16);
    }

    public final void l(@NotNull final FragmentActivity act, @NotNull final ImageView animationImageView, @NotNull final ImageView lottieImageView, @NotNull String lottieFilePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, act, animationImageView, lottieImageView, lottieFilePath);
            return;
        }
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(animationImageView, "animationImageView");
        Intrinsics.checkNotNullParameter(lottieImageView, "lottieImageView");
        Intrinsics.checkNotNullParameter(lottieFilePath, "lottieFilePath");
        animationImageView.setPivotX(l.a(20.0f) / 2.0f);
        animationImageView.setPivotY(l.a(20.0f) / 2.0f);
        float[] fArr = {1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 1.5f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(animationImageView, BasicAnimation.KeyPath.SCALE_X, Arrays.copyOf(fArr, 8));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(animationImageView, BasicAnimation.KeyPath.SCALE_Y, Arrays.copyOf(fArr, 8));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1400L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        ag.f194106a.e(act, lottieImageView, new Size(l.b(100), l.b(100)), lottieFilePath, new Function0<Unit>(animationImageView, lottieImageView, act) { // from class: com.tencent.mobileqq.aio.menu.EmoReplyAnimationUtil$doScaleAnimation$onAnimationEnd$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ FragmentActivity $act;
            final /* synthetic */ ImageView $animationImageView;
            final /* synthetic */ ImageView $lottieImageView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$animationImageView = animationImageView;
                this.$lottieImageView = lottieImageView;
                this.$act = act;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, animationImageView, lottieImageView, act);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                this.$animationImageView.setVisibility(8);
                this.$lottieImageView.setVisibility(8);
                EmoReplyAnimationUtil.f189971a.n(this.$act);
            }
        });
    }

    @NotNull
    public final View m(@NotNull FragmentActivity act, @NotNull com.tencent.qqnt.aio.emoreply.h info, @NotNull MsgRecord msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, act, info, msg2);
        }
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (info.h()) {
            return g(act, info, msg2);
        }
        return h(act, info, msg2);
    }

    public final void n(@Nullable FragmentActivity act) {
        MsgRecord msgRecord2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) act);
            return;
        }
        if (act != null && (msgRecord2 = msgRecord) != null) {
            com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
            cVar.a(act, new AIOEmoReplySetVisibleMsgEvent(msgRecord2));
            cVar.a(act, AIOMsgListEvent.DismissEmoReplyAnimationEvent.f188286d);
            msgRecord = null;
        }
    }
}
