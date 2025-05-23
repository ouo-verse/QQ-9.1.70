package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/aq;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchor", "", "blewAnchor", "", "text", "Landroid/widget/PopupWindow;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class aq {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aq f235442a = new aq();

    aq() {
    }

    @JvmStatic
    @NotNull
    public static final PopupWindow a(@NotNull Context context, @NotNull View anchor, boolean blewAnchor, @NotNull String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(text, "text");
        View inflate = LayoutInflater.from(context).inflate(R.layout.f2e, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ow_layout_array_up, null)");
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        ((TextView) inflate.findViewById(R.id.f108466d7)).setText(text);
        popupWindow.getContentView().measure(-2, -2);
        popupWindow.showAsDropDown(anchor, (-(popupWindow.getContentView().getMeasuredWidth() - anchor.getWidth())) / 2, 0);
        return popupWindow;
    }
}
