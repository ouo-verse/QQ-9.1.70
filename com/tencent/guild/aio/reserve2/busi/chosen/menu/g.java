package com.tencent.guild.aio.reserve2.busi.chosen.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.q;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u000b*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000eB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b&\u0010'J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "", "T", "Lcom/tencent/guild/aio/halfpop/menu/b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", "data", "", "a", "(Ljava/lang/Object;)Z", "", "o", "(Ljava/lang/Object;)V", "Lcom/tencent/guild/aio/halfpop/menu/s;", "itemUIAttrs", "d", "view", "b", "(Landroid/view/View;Ljava/lang/Object;)V", "", "I", "getTitleRes", "()I", "titleRes", "Lvn0/h;", "e", "Lvn0/h;", "p", "()Lvn0/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lvn0/h;)V", "binding", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class g<T> extends com.tencent.guild.aio.halfpop.menu.b<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int titleRes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public vn0.h binding;

    public g(int i3) {
        this.titleRes = i3;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public boolean a(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return true;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void b(@NotNull View view, @NotNull T data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void d(@Nullable s itemUIAttrs) {
        Integer num;
        Integer num2;
        p color;
        q drawable;
        Integer num3;
        q drawable2;
        q drawable3;
        Integer num4 = null;
        if (itemUIAttrs != null && (drawable3 = itemUIAttrs.getDrawable()) != null) {
            num = drawable3.getTextMenuItemBgId();
        } else {
            num = null;
        }
        if (n(num)) {
            ConstraintLayout root = p().getRoot();
            if (itemUIAttrs != null && (drawable2 = itemUIAttrs.getDrawable()) != null) {
                num3 = drawable2.getTextMenuItemBgId();
            } else {
                num3 = null;
            }
            Intrinsics.checkNotNull(num3);
            root.setBackgroundResource(num3.intValue());
        }
        if (itemUIAttrs != null && (drawable = itemUIAttrs.getDrawable()) != null) {
            num2 = drawable.getTextMenuItemBgId();
        } else {
            num2 = null;
        }
        if (n(num2)) {
            TextView textView = p().f441958c;
            Context context = p().getRoot().getContext();
            if (itemUIAttrs != null && (color = itemUIAttrs.getColor()) != null) {
                num4 = color.getTextMenuTextColorId();
            }
            Intrinsics.checkNotNull(num4);
            textView.setTextColor(AppCompatResources.getColorStateList(context, num4.intValue()));
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        vn0.h g16 = vn0.h.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        q(g16);
        o(i());
        ConstraintLayout root = p().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void o(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("TextMenuItem", 4, "bindView");
        p().f441958c.setText(this.titleRes);
    }

    @NotNull
    public final vn0.h p() {
        vn0.h hVar = this.binding;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void q(@NotNull vn0.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.binding = hVar;
    }
}
