package com.tencent.ecommerce.biz.productcenter.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.b;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&B\u0013\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b%\u0010'B\u001d\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b%\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECFlexBoxLayoutMaxLines;", "Lcom/google/android/flexbox/FlexboxLayout;", "", "maxLine", "", "setMaxLine", "d", "", "expand", "setExpand", "Landroid/view/View;", "view", "setExpandView", "setCollapseView", "", "Lcom/google/android/flexbox/b;", "i", "N", "I", "maxLinesVal", "P", "maxLines", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "expandView", BdhLogUtil.LogTag.Tag_Req, "collapseView", ExifInterface.LATITUDE_SOUTH, "Z", "isExpand", "T", "isFooterViewAdded", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECFlexBoxLayoutMaxLines extends FlexboxLayout {

    /* renamed from: N, reason: from kotlin metadata */
    private int maxLinesVal;

    /* renamed from: P, reason: from kotlin metadata */
    private int maxLines;

    /* renamed from: Q, reason: from kotlin metadata */
    private View expandView;

    /* renamed from: R, reason: from kotlin metadata */
    private View collapseView;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isExpand;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isFooterViewAdded;

    public ECFlexBoxLayoutMaxLines(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.maxLinesVal = -1;
        this.maxLines = -1;
        setMaxLine(super.d());
        super.setMaxLine(-1);
        setExpand(false);
    }

    @Override // com.google.android.flexbox.FlexboxLayout, com.google.android.flexbox.a
    public int d() {
        return -1;
    }

    @Override // com.google.android.flexbox.FlexboxLayout, com.google.android.flexbox.a
    public List<b> i() {
        List<b> i3 = super.i();
        int size = i3.size();
        int i16 = this.maxLines;
        if (1 <= i16 && size > i16) {
            i3.subList(i16, size).clear();
        }
        return i3;
    }

    public final void setCollapseView(View view) {
        this.collapseView = view;
    }

    public final void setExpand(boolean expand2) {
        this.isExpand = expand2;
        this.maxLines = expand2 ? -1 : this.maxLinesVal;
        this.isFooterViewAdded = false;
    }

    public final void setExpandView(View view) {
        this.expandView = view;
    }

    @Override // com.google.android.flexbox.FlexboxLayout
    public void setMaxLine(int maxLine) {
        this.maxLinesVal = maxLine;
    }

    public ECFlexBoxLayoutMaxLines(Context context) {
        this(context, null);
    }

    public ECFlexBoxLayoutMaxLines(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
