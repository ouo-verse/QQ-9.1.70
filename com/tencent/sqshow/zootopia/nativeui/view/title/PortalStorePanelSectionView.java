package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u00a2\u0006\u0004\b(\u0010)J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J(\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelSectionView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/l;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "X", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "Z", DomainData.DOMAIN_NAME, "W", "Y", "", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "a0", "", "selected", "e0", "b0", "c0", "d0", "V", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/l;", "currentViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelSectionView extends BaseViewPagerTitleWithLineHint<l, String, PortalStorePanelSectionData, BaseViewPagerTitleWithLineHint.c> {

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: W, reason: from kotlin metadata */
    private l currentViewHolder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelSectionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> X(PortalStorePanelSectionData data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getSectionCfgV1().f440331a;
        Intrinsics.checkNotNullExpressionValue(str, "data.sectionCfgV1.id");
        hashMap.put("zplan_tab_id", str);
        hashMap.put("zplan_tab_name", data.getTitle());
        hashMap.put("zplan_tab_type", "section");
        return hashMap;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected String W() {
        return "PortalStorePanelTitleView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public l q(PortalStorePanelSectionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.deb, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        l lVar = new l(itemView);
        lVar.getMTextView().setText(data.getTitle());
        lVar.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        return lVar;
    }

    public final void Z(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void B(int index, PortalStorePanelSectionData data, LinearLayout container, l holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(data.getSectionCfgV1().f440339i);
        holder.getMTextView().setText(data.getTitle());
        holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.sqshow.zootopia.utils.i.b(36));
        if (index == 0) {
            layoutParams.leftMargin = com.tencent.sqshow.zootopia.utils.i.a(7.5f);
        } else {
            layoutParams.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
        }
        if (index == t().size() - 1) {
            layoutParams.rightMargin = com.tencent.sqshow.zootopia.utils.i.a(7.5f);
        }
        layoutParams.gravity = 16;
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().g(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : X(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void C(l holder, int index, PortalStorePanelSectionData data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        l lVar = this.currentViewHolder;
        if (lVar != null) {
            lVar.c();
        }
        holder.d(data.getSectionCfgV1().f440339i);
        this.currentViewHolder = holder;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().e(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", X(data));
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void D(l holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.D(holder);
        QLog.d(W(), 1, "onItemViewSelected, holder: " + holder);
        l lVar = this.currentViewHolder;
        if (lVar != null) {
            lVar.c();
        }
        holder.c();
    }

    public void d0() {
        String W = W();
        l lVar = this.currentViewHolder;
        QLog.d(W, 1, "clear current subTitle holder red dot, when view hide, id: " + (lVar != null ? Integer.valueOf(lVar.getRedDotId()) : null));
        l lVar2 = this.currentViewHolder;
        if (lVar2 != null) {
            lVar2.c();
        }
        this.currentViewHolder = null;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void K(l holder, boolean selected) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (selected) {
            this.currentViewHolder = holder;
            holder.getMTextView().setTextColor(getMSelectedTxtColor());
            holder.getMTextView().setTextSize(1, getMSelectedTxtSize());
        } else {
            holder.getMTextView().setTextColor(getMUnselectedTxtColor());
            holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected void n() {
        M(getResources().getColor(R.color.qui_common_brand_standard));
        T(getResources().getColor(R.color.qui_common_text_primary));
        N(16.0f);
        U(16.0f);
        Q(com.tencent.sqshow.zootopia.utils.i.a(2.0f));
        R((int) getContext().getResources().getDimension(R.dimen.f11344i));
        S((int) getContext().getResources().getDimension(R.dimen.f11344i));
        O(com.tencent.sqshow.zootopia.utils.i.b(4));
        L(R.drawable.h4i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelSectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStorePanelSectionView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelSectionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
