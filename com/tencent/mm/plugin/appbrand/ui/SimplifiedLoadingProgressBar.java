package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.msf.core.net.r.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.Reflect;

@RequiresApi(23)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0012B+\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedLoadingProgressBar;", "Landroid/view/View;", "", "inside", "", "setForegroundInsidePadding", "Landroid/graphics/drawable/Drawable;", a.f248963o, "setForeground", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "luggage-wxa-app_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SimplifiedLoadingProgressBar extends View {

    /* loaded from: classes9.dex */
    public static final class b extends Animatable2.AnimationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final a f152296a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimplifiedLoadingProgressBar f152297b;

        /* loaded from: classes9.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Animatable2 f152298a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SimplifiedLoadingProgressBar f152299b;

            public a(Animatable2 animatable2, SimplifiedLoadingProgressBar simplifiedLoadingProgressBar) {
                this.f152298a = animatable2;
                this.f152299b = simplifiedLoadingProgressBar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj = this.f152298a;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                if (this.f152299b.verifyDrawable((Drawable) this.f152298a) && this.f152298a.isRunning()) {
                    ((Drawable) this.f152298a).invalidateSelf();
                    this.f152299b.postOnAnimation(this);
                }
            }
        }

        public b(Animatable2 animatable2, SimplifiedLoadingProgressBar simplifiedLoadingProgressBar) {
            this.f152297b = simplifiedLoadingProgressBar;
            this.f152296a = new a(animatable2, simplifiedLoadingProgressBar);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            this.f152297b.removeCallbacks(this.f152296a);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            this.f152297b.postOnAnimation(this.f152296a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplifiedLoadingProgressBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setForegroundInsidePadding(boolean inside) {
        try {
            Reflect.on(Reflect.on(this).get("mForegroundInfo")).set("mInsidePadding", Boolean.valueOf(inside));
        } catch (Exception e16) {
            w.b("Luggage.SimplifiedLoadingProgressBar", "setForegroundInsidePadding(" + inside + ") get exception:" + e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void setForeground(@Nullable Drawable foreground) {
        Animatable2 animatable2;
        Object foreground2 = getForeground();
        super.setForeground(foreground);
        if (!Intrinsics.areEqual(foreground2, foreground)) {
            Animatable2 animatable22 = null;
            if (foreground2 instanceof Animatable2) {
                animatable2 = (Animatable2) foreground2;
            } else {
                animatable2 = null;
            }
            if (animatable2 != null) {
                animatable2.clearAnimationCallbacks();
            }
            if (foreground instanceof Animatable2) {
                animatable22 = (Animatable2) foreground;
            }
            if (animatable22 != null) {
                animatable22.registerAnimationCallback(new b(animatable22, this));
            }
            setForegroundInsidePadding(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplifiedLoadingProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplifiedLoadingProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplifiedLoadingProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
