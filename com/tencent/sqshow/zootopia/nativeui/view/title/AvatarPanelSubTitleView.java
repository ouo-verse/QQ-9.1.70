package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.title.AvatarPanelSubTitleData;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u000f\u00a2\u0006\u0004\b%\u0010&J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/AvatarPanelSubTitleView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/h;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/AvatarPanelSubTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "X", "", DomainData.DOMAIN_NAME, "W", "Y", "", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "Z", "", "selected", "c0", "a0", "b0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "V", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/h;", "currentViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPanelSubTitleView extends BaseViewPagerTitleWithLineHint<h, String, AvatarPanelSubTitleData, BaseViewPagerTitleWithLineHint.c> {

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: W, reason: from kotlin metadata */
    private h currentViewHolder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelSubTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> X(AvatarPanelSubTitleData data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getStoreTypeCfg().f440349a;
        Intrinsics.checkNotNullExpressionValue(str, "data.storeTypeCfg.id");
        hashMap.put("zplan_tab_id", str);
        hashMap.put("zplan_tab_name", data.getTitle());
        hashMap.put("zplan_tab_level", 2);
        return hashMap;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected String W() {
        return "AvatarPanelSubTitleView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public h q(AvatarPanelSubTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.f167431da0, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        h hVar = new h(itemView);
        hVar.getMTextView().setText(data.getTitle());
        hVar.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        return hVar;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void B(int index, AvatarPanelSubTitleData data, LinearLayout container, h holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(data.getStoreTypeCfg().f440359k);
        holder.getMTextView().setText(data.getTitle());
        holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) getContext().getResources().getDimension(R.dimen.f115452));
        if (index == 0) {
            layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.f11354j);
        }
        if (index == t().size() - 1) {
            layoutParams.rightMargin = (int) getContext().getResources().getDimension(R.dimen.f11354j);
        }
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().g(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : X(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void C(h holder, int index, AvatarPanelSubTitleData data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        h hVar = this.currentViewHolder;
        if (hVar != null) {
            hVar.c();
        }
        holder.d(data.getStoreTypeCfg().f440359k);
        this.currentViewHolder = holder;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().e(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", X(data));
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void D(h holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.D(holder);
        QLog.d(W(), 1, "onItemViewSelected, holder: " + holder);
        h hVar = this.currentViewHolder;
        if (hVar != null) {
            hVar.c();
        }
        holder.c();
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void K(h holder, boolean selected) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (selected) {
            this.currentViewHolder = holder;
            holder.getMTextView().setAlpha(1.0f);
            holder.getMTextView().setTextColor(getMSelectedTxtColor());
            holder.getMTextView().setTextSize(1, getMSelectedTxtSize());
            return;
        }
        holder.getMTextView().setAlpha(0.6f);
        holder.getMTextView().setTextColor(getMUnselectedTxtColor());
        holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected void n() {
        M(Color.parseColor("#0099FF"));
        T(Color.parseColor("#2C3951"));
        N(12.0f);
        U(12.0f);
        Q(com.tencent.sqshow.zootopia.utils.i.a(1.0f));
        R((int) getContext().getResources().getDimension(R.dimen.f11344i));
        S((int) getContext().getResources().getDimension(R.dimen.f11344i));
        L(R.drawable.h4i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelSubTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AvatarPanelSubTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelSubTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
