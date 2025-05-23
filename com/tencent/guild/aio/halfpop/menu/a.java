package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\tH\u0016J\u001f\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/a;", "", "T", "Lcom/tencent/guild/aio/halfpop/menu/b;", "Landroid/graphics/drawable/Drawable;", "drawable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/halfpop/b;", "ctrl", "", "c", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", "Lcom/tencent/guild/aio/halfpop/menu/s;", "itemUIAttrs", "d", "data", "o", "(Ljava/lang/Object;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "view", "b", "(Landroid/view/View;Ljava/lang/Object;)V", "Lvn0/g;", "Lvn0/g;", "p", "()Lvn0/g;", "r", "(Lvn0/g;)V", "binding", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class a<T> extends b<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public vn0.g binding;

    private final Drawable q(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void b(@NotNull View view, @NotNull T data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ActionMenuItem", 4, "onItemClick");
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void c(@NotNull com.tencent.guild.aio.halfpop.b ctrl) {
        Intrinsics.checkNotNullParameter(ctrl, "ctrl");
        super.c(ctrl);
        QLog.i("ActionMenuItem", 4, "onCreate");
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void d(@Nullable s itemUIAttrs) {
        Integer num;
        Integer num2;
        ColorFilter colorFilter;
        q drawable;
        q drawable2;
        Integer num3;
        q drawable3;
        q drawable4;
        Integer num4;
        p color;
        p color2;
        Resources resources = p().f441955d.getResources();
        Drawable drawable5 = null;
        r1 = null;
        ColorFilter colorFilter2 = null;
        if (itemUIAttrs != null && (color2 = itemUIAttrs.getColor()) != null) {
            num = color2.getActionMenuTextColorId();
        } else {
            num = null;
        }
        if (n(num)) {
            TextView textView = p().f441955d;
            if (itemUIAttrs != null && (color = itemUIAttrs.getColor()) != null) {
                num4 = color.getActionMenuTextColorId();
            } else {
                num4 = null;
            }
            Intrinsics.checkNotNull(num4);
            textView.setTextColor(resources.getColor(num4.intValue()));
        }
        if (itemUIAttrs != null && (drawable4 = itemUIAttrs.getDrawable()) != null) {
            num2 = drawable4.getActionMenuItemBgId();
        } else {
            num2 = null;
        }
        if (n(num2)) {
            ConstraintLayout root = p().getRoot();
            if (itemUIAttrs != null && (drawable3 = itemUIAttrs.getDrawable()) != null) {
                num3 = drawable3.getActionMenuItemBgId();
            } else {
                num3 = null;
            }
            Intrinsics.checkNotNull(num3);
            root.setBackgroundResource(num3.intValue());
        }
        if (itemUIAttrs != null && (drawable2 = itemUIAttrs.getDrawable()) != null) {
            colorFilter = drawable2.getActionMenuIconBgColorFilter();
        } else {
            colorFilter = null;
        }
        if (n(colorFilter)) {
            ImageView imageView = p().f441953b;
            Drawable q16 = q(p().f441953b.getBackground());
            if (q16 != null) {
                if (itemUIAttrs != null && (drawable = itemUIAttrs.getDrawable()) != null) {
                    colorFilter2 = drawable.getActionMenuIconBgColorFilter();
                }
                q16.setColorFilter(colorFilter2);
            }
            imageView.setBackground(q16);
        } else {
            ImageView imageView2 = p().f441953b;
            Drawable q17 = q(p().f441953b.getBackground());
            if (q17 != null) {
                q17.setColorFilter(new PorterDuffColorFilter(ResourcesCompat.getColor(resources, k.f110719a.a(), null), PorterDuff.Mode.SRC_IN));
                drawable5 = q17;
            }
            imageView2.setBackground(drawable5);
        }
        Drawable background = p().f441953b.getBackground();
        if (background != null) {
            background.mutate();
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        vn0.g g16 = vn0.g.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        r(g16);
        o(i());
        ConstraintLayout root = p().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void o(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ActionMenuItem", 4, "bindView");
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void onDestroy() {
        QLog.i("ActionMenuItem", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @NotNull
    public final vn0.g p() {
        vn0.g gVar = this.binding;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void r(@NotNull vn0.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.binding = gVar;
    }
}
