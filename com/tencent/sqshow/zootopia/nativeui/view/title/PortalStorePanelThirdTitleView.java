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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelTypeData;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u00018B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0012\u00a2\u0006\u0004\b6\u00107J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J(\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018J0\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J \u0010\u001f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010)R\u001b\u0010.\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010-R\u001b\u00100\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b!\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelThirdTitleView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/k;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelTypeData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "H", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "L", "i", "G", "I", "", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "M", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelThirdTitleView$a;", "listener", "setOnItemSelectedListener", "", "selected", "formUserSelected", "P", "N", "O", "K", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/k;", "currentViewHolder", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "mItemDataController", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelThirdTitleView$a;", "mOnThirdTitleItemSelectedListener", "Lkotlin/Lazy;", "J", "()I", "mSelectedTxtColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mUnselectedTxtColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelThirdTitleView extends BaseViewPagerTitle<k, String, PortalStorePanelTypeData, BaseViewPagerTitle.c> {

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: L, reason: from kotlin metadata */
    private k currentViewHolder;

    /* renamed from: M, reason: from kotlin metadata */
    private PanelSubTitlePageDataRepo mItemDataController;

    /* renamed from: N, reason: from kotlin metadata */
    private a mOnThirdTitleItemSelectedListener;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy mSelectedTxtColor;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy mUnselectedTxtColor;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelThirdTitleView$a;", "", "", "index", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(int index);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelThirdTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> H(PortalStorePanelTypeData data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getStoreTypeCfg().f440349a;
        Intrinsics.checkNotNullExpressionValue(str, "data.storeTypeCfg.id");
        hashMap.put("zplan_tab_id", str);
        hashMap.put("zplan_tab_name", data.getTitle());
        hashMap.put("zplan_tab_type", "type");
        hashMap.put("zplan_is_bigcard_show", Integer.valueOf(data.getStoreTypeCfg().f440362n != 1 ? 0 : 1));
        return hashMap;
    }

    private final int J() {
        return ((Number) this.mSelectedTxtColor.getValue()).intValue();
    }

    private final int K() {
        return ((Number) this.mUnselectedTxtColor.getValue()).intValue();
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    protected String G() {
        return "PortalStorePanelThirdTitleView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public k l(PortalStorePanelTypeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.f167431da0, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        k kVar = new k(itemView);
        kVar.getMTextView().setText(data.getTitle());
        kVar.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        return kVar;
    }

    public final void L(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        this.mItemDataController = new PanelSubTitlePageDataRepo(channel);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void u(int index, PortalStorePanelTypeData data, LinearLayout container, k holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(data.getStoreTypeCfg().f440359k);
        holder.getMTextView().setText(data.getTitle());
        holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.sqshow.zootopia.utils.i.b(25));
        if (index == 0) {
            layoutParams.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(12);
        } else {
            layoutParams.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(8);
        }
        if (index == p().size() - 1) {
            layoutParams.rightMargin = com.tencent.sqshow.zootopia.utils.i.b(12);
        }
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().g(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : H(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void v(k holder, int index, PortalStorePanelTypeData data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        k kVar = this.currentViewHolder;
        if (kVar != null) {
            kVar.c();
        }
        holder.d(data.getStoreTypeCfg().f440359k);
        this.currentViewHolder = holder;
        a aVar = this.mOnThirdTitleItemSelectedListener;
        if (aVar != null) {
            aVar.a(index);
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().e(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", H(data));
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void w(k holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.w(holder);
        QLog.d(G(), 1, "onItemViewSelected, holder: " + holder);
        k kVar = this.currentViewHolder;
        if (kVar != null) {
            kVar.c();
        }
        holder.c();
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void C(k holder, boolean selected, int index, PortalStorePanelTypeData data, boolean formUserSelected) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        if (selected) {
            this.currentViewHolder = holder;
            holder.getMTextView().setTextColor(J());
            holder.getMTextView().setTextSize(1, getMSelectedTxtSize());
            holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String().setBackgroundResource(R.drawable.f159919i54);
            return;
        }
        holder.getMTextView().setTextColor(K());
        holder.getMTextView().setTextSize(1, getMUnselectedTxtSize());
        holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String().setBackgroundResource(R.drawable.f159920i55);
    }

    public final void setOnItemSelectedListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnThirdTitleItemSelectedListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelThirdTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStorePanelThirdTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    protected void i() {
        E(12.0f);
        F(12.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelThirdTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelThirdTitleView$mSelectedTxtColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(PortalStorePanelThirdTitleView.this.getResources().getColor(R.color.qui_common_brand_standard));
            }
        });
        this.mSelectedTxtColor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelThirdTitleView$mUnselectedTxtColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(PortalStorePanelThirdTitleView.this.getResources().getColor(R.color.qui_common_text_secondary));
            }
        });
        this.mUnselectedTxtColor = lazy2;
    }
}
