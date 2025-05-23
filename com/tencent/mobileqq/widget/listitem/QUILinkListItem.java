package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUILinkListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Lcom/tencent/mobileqq/widget/listitem/d;", DownloadInfo.spKey_Config, "", "setConfig", "I", "Lcom/tencent/mobileqq/widget/listitem/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QUILinkListItem extends QUIListItem<d> {

    /* renamed from: I, reason: from kotlin metadata */
    private d config;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUILinkListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setConfig(@NotNull d config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        l().m().setText(config.getText());
    }

    public /* synthetic */ QUILinkListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUILinkListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TextView m3 = l().m();
        int dp12 = getDp12();
        ViewGroup.LayoutParams layoutParams = m3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = m3.getLayoutParams();
            int i3 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = m3.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (dp12 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = dp12;
            m3.setLayoutParams(marginLayoutParams);
        }
        QUIListItem.d<TextView> d16 = l().d(l().m());
        if (d16 != null) {
            setTextColor$qqui_kit_release(d16, l().m(), R.color.qui_common_text_link);
            d16.d(getThemeId());
        }
        d(l().m());
    }
}
