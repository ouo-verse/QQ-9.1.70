package com.tencent.guild.aio.reserve2.busi.chosen.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.halfpop.menu.p;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/h;", "Lcom/tencent/guild/aio/halfpop/menu/b;", "", "Landroid/view/ViewGroup$LayoutParams;", "o", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", "Lcom/tencent/guild/aio/halfpop/menu/s;", "itemUIAttrs", "", "d", "Landroid/view/View;", "itemView", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h extends com.tencent.guild.aio.halfpop.menu.b<Object> {

    /* renamed from: f, reason: collision with root package name */
    private static final int f112208f = com.tencent.guild.aio.util.c.b(10);

    /* renamed from: g, reason: collision with root package name */
    private static int f112209g = com.tencent.guild.aio.util.c.b(0);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemView;

    private final ViewGroup.LayoutParams o() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, f112208f);
        int i3 = f112209g;
        marginLayoutParams.leftMargin = i3;
        marginLayoutParams.rightMargin = i3;
        return marginLayoutParams;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void d(@Nullable s itemUIAttrs) {
        Context context;
        Integer num;
        p color;
        p color2;
        View view = this.itemView;
        Integer num2 = null;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (itemUIAttrs != null && (color2 = itemUIAttrs.getColor()) != null) {
            num = color2.getThickLineDividerBgColorId();
        } else {
            num = null;
        }
        if (n(num) && context != null) {
            Resources resources = context.getResources();
            if (itemUIAttrs != null && (color = itemUIAttrs.getColor()) != null) {
                num2 = color.getThickLineDividerBgColorId();
            }
            Intrinsics.checkNotNull(num2);
            int color3 = resources.getColor(num2.intValue());
            View view2 = this.itemView;
            if (view2 != null) {
                view2.setBackgroundColor(color3);
            }
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.guild_aio_pop_menu_thick_line_color));
        view.setLayoutParams(o());
        this.itemView = view;
        return view;
    }
}
