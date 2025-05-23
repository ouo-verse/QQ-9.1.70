package com.tencent.mobileqq.qwallet.hb.grap;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/grap/b;", "", "", "position", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "beforeView", "afterView", "", "b", "", "start", "end", "centerX", "centerY", "reverse", "Landroid/view/animation/Animation;", "c", "<init>", "()V", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f277405a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/grap/b$b", "Lcom/tencent/mobileqq/qwallet/hb/grap/b$a;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.grap.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8462b extends a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f277406d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f277407e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f277408f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f277409h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f277410i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ViewGroup f277411m;

        C8462b(boolean z16, View view, View view2, float f16, float f17, ViewGroup viewGroup) {
            this.f277406d = z16;
            this.f277407e = view;
            this.f277408f = view2;
            this.f277409h = f16;
            this.f277410i = f17;
            this.f277411m = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            float f16;
            if (this.f277406d) {
                f16 = -90.0f;
            } else {
                f16 = 90.0f;
            }
            this.f277407e.setVisibility(8);
            this.f277408f.setVisibility(0);
            this.f277411m.startAnimation(b.f277405a.c(f16, 0.0f, this.f277409h, this.f277410i, false));
        }
    }

    b() {
    }

    @JvmStatic
    public static final void b(boolean position, @NotNull ViewGroup container, @NotNull View beforeView, @NotNull View afterView) {
        float f16;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(beforeView, "beforeView");
        Intrinsics.checkNotNullParameter(afterView, "afterView");
        if (position) {
            f16 = 90.0f;
        } else {
            f16 = -90.0f;
        }
        float width = container.getWidth() / 2.0f;
        float height = container.getHeight() / 2.0f;
        beforeView.setVisibility(0);
        afterView.setVisibility(8);
        Animation c16 = f277405a.c(0.0f, f16, width, height, true);
        c16.setAnimationListener(new C8462b(position, beforeView, afterView, width, height, container));
        container.startAnimation(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Animation c(float start, float end, float centerX, float centerY, boolean reverse) {
        Animation createRotate3dAnimation = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(start, end, centerX, centerY, 610.0f, reverse);
        createRotate3dAnimation.setDuration(250L);
        createRotate3dAnimation.setFillAfter(true);
        createRotate3dAnimation.setInterpolator(new AccelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(createRotate3dAnimation, "api(IQWalletTemp::class.\u2026erpolator()\n            }");
        return createRotate3dAnimation;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/grap/b$a;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static class a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
