package com.tencent.sqshow.zootopia.publish.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTextViewPagerTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vc4.l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentBtmTitle;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentTitleData;", "Lvc4/l;", "", "j", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SelectPublishContentBtmTitle extends BaseZPlanTextViewPagerTitle<SelectPublishContentPageType, SelectPublishContentTitleData, l> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectPublishContentBtmTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTextViewPagerTitle
    public String j() {
        return "SelectPublishContentBtmTitle_";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectPublishContentBtmTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SelectPublishContentBtmTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectPublishContentBtmTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
