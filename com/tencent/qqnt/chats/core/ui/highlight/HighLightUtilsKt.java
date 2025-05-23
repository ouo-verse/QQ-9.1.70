package com.tencent.qqnt.chats.core.ui.highlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002\u001a6\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002\u00a8\u0006\u0013"}, d2 = {"Landroid/view/View;", "view", "", "isTopStyle", "", "d", "", "color", "", "coefficient", "diff", "e", "startColor", "endColor", "", "duration", "Lkotlin/Function0;", "cb", "b", "chats_view_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HighLightUtilsKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chats/core/ui/highlight/HighLightUtilsKt$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationEnd", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f354950d;

        a(Function0<Unit> function0) {
            this.f354950d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354950d.invoke();
            }
        }
    }

    private static final void b(final View view, int i3, int i16, long j3, Function0<Unit> function0) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i3), Integer.valueOf(i16));
        ofObject.setDuration(j3);
        ofObject.setRepeatMode(2);
        if (QQTheme.isNowThemeIsNight()) {
            ofObject.setRepeatCount(0);
        } else {
            ofObject.setRepeatCount(1);
        }
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.chats.core.ui.highlight.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HighLightUtilsKt.c(view, valueAnimator);
            }
        });
        ofObject.addListener(new a(function0));
        ofObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public static final void d(@NotNull View view, boolean z16) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(view, "view");
        int f16 = f(view.getContext().getColor(R.color.qui_common_brand_standard), 0.2f, 0, 4, null);
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int o16 = chatsColorCache.o(context, R.color.qui_common_fill_light_primary);
        if (z16) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            int k3 = chatsColorCache.k(context2);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            int a16 = com.tencent.biz.qui.quicommon.a.a(k3, chatsColorCache.o(context3, R.color.qui_common_overlay_light));
            QLog.i("RecentContactItemHolder", 1, "is black mode blinkColorInt is " + f16 + ", originColorInt i s " + a16);
            i3 = a16;
        } else {
            i3 = o16;
        }
        QLog.i("RecentContactItemHolder", 1, "blinkColorInt is " + f16 + ", originColorInt is " + i3);
        if (view.getTag(R.id.d26) == null) {
            view.setTag(R.id.d26, view.getBackground());
            if (QQTheme.isNowThemeIsNight()) {
                i16 = 600;
            } else {
                i16 = 300;
            }
            b(view, i3, f16, i16, new HighLightUtilsKt$highLightView$1(view));
        }
    }

    private static final int e(int i3, float f16, int i16) {
        return ((i3 & 255) | (((i3 >> 16) & 255) << 16) | (((i3 >> 8) & 255) << 8) | (((int) (((i3 >> 24) & 255) * f16)) << 24)) + i16;
    }

    static /* synthetic */ int f(int i3, float f16, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return e(i3, f16, i16);
    }
}
