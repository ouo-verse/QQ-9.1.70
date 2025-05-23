package com.tencent.sqshow.zootopia.widget;

import android.content.Context;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.style.NoScrollLinkMovementMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/ZPlanAsyncTextView;", "Lcom/tencent/richframework/text/rich/RFWAsyncRichTextView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getDefaultMovementMethod", "Landroid/text/method/MovementMethod;", "performClick", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanAsyncTextView extends RFWAsyncRichTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAsyncTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView
    protected MovementMethod getDefaultMovementMethod() {
        NoScrollLinkMovementMethod noScrollLinkMovementMethod = NoScrollLinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(noScrollLinkMovementMethod, "getInstance()");
        return noScrollLinkMovementMethod;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isSpanClick()) {
            return true;
        }
        return super.performClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAsyncTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanAsyncTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAsyncTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
