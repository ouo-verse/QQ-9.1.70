package com.tencent.sqshow.zootopia.publish.page.samestyle;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateCat;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0002#$B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0014J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleViewPagerTitleInner;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint;", "Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleViewPagerTitleInner$b;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "", DomainData.DOMAIN_NAME, "", "W", "data", "X", "", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "Y", "Z", "", "selected", "a0", "V", "I", "mTitleMarin", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SameStyleViewPagerTitleInner extends BaseViewPagerTitleWithLineHint<b, Long, ZPlanTemplateCat, BaseViewPagerTitleWithLineHint.c> {

    /* renamed from: V, reason: from kotlin metadata */
    private int mTitleMarin;

    /* renamed from: W, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleViewPagerTitleInner$b;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "titleTxv", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "kotlin.jvm.PlatformType", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "()Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDotView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends BaseViewPagerTitleWithLineHint.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final TextView titleTxv;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final ZPlanRedDotView redDotView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.qri);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.titleTxt)");
            this.titleTxv = (TextView) findViewById;
            this.redDotView = (ZPlanRedDotView) itemView.findViewById(R.id.qgr);
        }

        /* renamed from: b, reason: from getter */
        public final ZPlanRedDotView getRedDotView() {
            return this.redDotView;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getTitleTxv() {
            return this.titleTxv;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SameStyleViewPagerTitleInner(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected String W() {
        return "SameStylePageViewPagerTitleInner_";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b q(ZPlanTemplateCat data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.dey, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        b bVar = new b(itemView);
        bVar.getTitleTxv().setText(data.getTitle());
        bVar.getRedDotView().setTag(data);
        int i3 = data.getReddotMsg().f417682a != 1 ? data.getReddotMsg().f417682a : 0;
        bVar.getRedDotView().l();
        bVar.getRedDotView().n(i3);
        if (data.getReddotMsg().f417682a > 0) {
            bVar.getRedDotView().setVisibility(0);
        } else {
            bVar.getRedDotView().setVisibility(4);
        }
        return bVar;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void B(int index, ZPlanTemplateCat data, LinearLayout container, b holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, i.a(32.0f));
        if (index != 0) {
            layoutParams.leftMargin += this.mTitleMarin;
        }
        layoutParams.gravity = 80;
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        View view = holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_tab_id", data.getId());
        linkedHashMap.put("zplan_tab_name", data.getName());
        Unit unit = Unit.INSTANCE;
        ZplanViewReportHelper.h(zplanViewReportHelper, view, "em_zplan_tab_btn", linkedHashMap, false, null, false, 56, null);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void C(b holder, int index, ZPlanTemplateCat data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        View view = holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_tab_id", data.getId());
        linkedHashMap.put("zplan_tab_name", data.getName());
        Unit unit = Unit.INSTANCE;
        zplanViewReportHelper.e(view, "em_zplan_tab_btn", linkedHashMap);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void K(b holder, boolean selected) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (selected) {
            holder.getTitleTxv().setTextColor(getMSelectedTxtColor());
            holder.getTitleTxv().setTextSize(1, getMSelectedTxtSize());
            holder.getRedDotView().setVisibility(4);
            Object tag = holder.getRedDotView().getTag();
            ZPlanTemplateCat zPlanTemplateCat = tag instanceof ZPlanTemplateCat ? (ZPlanTemplateCat) tag : null;
            if (zPlanTemplateCat != null) {
                ZPlanRedDotManager.f373437a.h(zPlanTemplateCat.getId().longValue());
                return;
            }
            return;
        }
        holder.getTitleTxv().setTextColor(getMUnselectedTxtColor());
        holder.getTitleTxv().setTextSize(1, getMUnselectedTxtSize());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SameStyleViewPagerTitleInner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SameStyleViewPagerTitleInner(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected void n() {
        N(16.0f);
        U(16.0f);
        R(i.b(12));
        S(i.b(12));
        M(-16777216);
        T(Color.parseColor("#80000000"));
        this.mTitleMarin = i.b(0);
        Q(i.a(2.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SameStyleViewPagerTitleInner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mReporter = new ZplanViewReportHelper();
    }
}
