package com.tencent.qui.quilistitem;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0000\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u0016\u0010\u0010\u001a\u00020\u0004*\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u0001H\u0000\"(\u0010\u0016\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Landroid/view/View;", "", "width", "height", "", "g", "", "radius", "e", "d", "Landroid/widget/ImageView;", "", "url", "c", "a", "drawableId", "b", "value", "getMarginHorizontal", "(Landroid/view/View;)I", "f", "(Landroid/view/View;I)V", NodeProps.MARGIN_HORIZONTAL, "QUIListItem_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class v {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qui/quilistitem/v$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f363894a;

        a(float f16) {
            this.f363894a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f363894a);
        }
    }

    public static final void a(@NotNull ImageView loadAvatar, @NotNull String url) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(loadAvatar, "$this$loadAvatar");
        Intrinsics.checkNotNullParameter(url, "url");
        td0.m c16 = Delegates.f363724d.c();
        if (c16 != null) {
            drawable = c16.c(url);
        } else {
            drawable = null;
        }
        loadAvatar.setImageDrawable(drawable);
    }

    public static final void b(@NotNull ImageView loadIcon, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(loadIcon, "$this$loadIcon");
        loadIcon.setImageResource(i3);
    }

    public static final void c(@NotNull ImageView loadImage, @NotNull String url) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
        Intrinsics.checkNotNullParameter(url, "url");
        td0.m c16 = Delegates.f363724d.c();
        if (c16 != null) {
            drawable = c16.c(url);
        } else {
            drawable = null;
        }
        loadImage.setImageDrawable(drawable);
    }

    public static final void d(@NotNull View removeFromParent) {
        Intrinsics.checkNotNullParameter(removeFromParent, "$this$removeFromParent");
        ViewParent parent = removeFromParent.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(removeFromParent);
        }
    }

    public static final void e(@NotNull View roundRadius, float f16) {
        Intrinsics.checkNotNullParameter(roundRadius, "$this$roundRadius");
        roundRadius.setClipToOutline(true);
        roundRadius.setOutlineProvider(new a(f16));
    }

    public static final void f(@NotNull View marginHorizontal, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(marginHorizontal, "$this$marginHorizontal");
        ViewGroup.LayoutParams layoutParams = marginHorizontal.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = marginHorizontal.getLayoutParams();
            int i17 = -2;
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = marginHorizontal.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        marginLayoutParams.leftMargin = i3;
        marginLayoutParams.rightMargin = i3;
        marginHorizontal.setLayoutParams(marginLayoutParams);
    }

    public static final void g(@NotNull View setSize, int i3, int i16) {
        Intrinsics.checkNotNullParameter(setSize, "$this$setSize");
        if (setSize.getLayoutParams() == null) {
            setSize.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
        } else {
            setSize.getLayoutParams().width = i3;
            setSize.getLayoutParams().height = i16;
        }
        setSize.setLayoutParams(setSize.getLayoutParams());
    }
}
