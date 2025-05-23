package com.tencent.mobileqq.wink.editor.aitemplate;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.aitemplate.a;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B/\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "", "n0", "", "index", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "itemClickListener", BdhLogUtil.LogTag.Tag_Conn, "retryClickListener", "D", "Ljava/util/List;", "E", "I", "selectedIndex", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", UserInfo.SEX_FEMALE, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<MetaMaterial, Unit> retryClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<MetaMaterial> materials;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectedIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<MetaMaterial, Unit> itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "t", "", "position", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "E", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "thumbnailIv", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "retryOverlay", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "nameTv", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aitemplate/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final WinkRoundedCornerImageView thumbnailIv;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View retryOverlay;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTv;
        final /* synthetic */ a H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = aVar;
            View findViewById = itemView.findViewById(R.id.y9v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_thumbnail)");
            this.thumbnailIv = (WinkRoundedCornerImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f82404gs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026select_overlay_container)");
            this.retryOverlay = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_name)");
            this.nameTv = (TextView) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(MetaMaterial material, int i3, a this$0, b this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!FastClickUtils.isFastDoubleClick("WinkEditorAITemplateAdapter_" + material.f30533id, 500L)) {
                w53.b.f("WinkEditorAITemplateAdapter", "itemClick: " + material.f30533id + ", position: " + i3);
                this$0.itemClickListener.invoke(material);
                this$1.s(material);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(MetaMaterial material, int i3, a this$0, b this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!FastClickUtils.isFastDoubleClick("WinkEditorAITemplateAdapter_" + material.f30533id, 500L)) {
                w53.b.f("WinkEditorAITemplateAdapter", "retryClick: " + material.f30533id + ", position: " + i3);
                this$0.retryClickListener.invoke(material);
                this$1.t(material);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void q(MetaMaterial material) {
            Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", com.tencent.mobileqq.wink.editor.c.t(material));
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AGAIN_GENERATE_BUTTON);
            com.tencent.mobileqq.wink.report.e.f326265a.e(this.retryOverlay, WinkDaTongReportConstant.ElementId.EM_XSJ_AGAIN_GENERATE_BUTTON, params, material.f30533id);
            VideoReport.setElementEndExposePolicy(this.retryOverlay, EndExposurePolicy.REPORT_ALL);
        }

        private final void r(MetaMaterial material) {
            Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("material_id", com.tencent.mobileqq.wink.editor.c.t(material));
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AI_TEMPLATE_MATERIAL);
            com.tencent.mobileqq.wink.report.e.f326265a.e(this.thumbnailIv, WinkDaTongReportConstant.ElementId.EM_XSJ_AI_TEMPLATE_MATERIAL, params, material.f30533id);
            VideoReport.setElementEndExposePolicy(this.thumbnailIv, EndExposurePolicy.REPORT_ALL);
        }

        private final void s(MetaMaterial material) {
            Map<String, ?> mutableMapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", material.f30533id));
            com.tencent.mobileqq.wink.report.e.f326265a.l(this.thumbnailIv, WinkDaTongReportConstant.ElementId.EM_XSJ_AI_TEMPLATE_MATERIAL, mutableMapOf, material.f30533id);
        }

        private final void t(MetaMaterial material) {
            Map<String, ?> mutableMapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", com.tencent.mobileqq.wink.editor.c.t(material)));
            com.tencent.mobileqq.wink.report.e.f326265a.l(this.retryOverlay, WinkDaTongReportConstant.ElementId.EM_XSJ_AGAIN_GENERATE_BUTTON, mutableMapOf, material.f30533id);
        }

        public final void n(final int position) {
            final MetaMaterial metaMaterial = (MetaMaterial) this.H.materials.get(position);
            this.nameTv.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            Option obtain = Option.obtain();
            obtain.setLoadingDrawable(new ColorDrawable(Color.parseColor("#0FFFFFFF")));
            obtain.setTargetView(this.thumbnailIv);
            obtain.setUrl(com.tencent.mobileqq.wink.editor.c.s0(metaMaterial));
            QQPicLoader.f201806a.d().loadImage(obtain, null);
            if (this.H.selectedIndex == position) {
                this.retryOverlay.setVisibility(0);
                this.nameTv.setTextColor(this.itemView.getContext().getColor(R.color.qui_common_text_allwhite_primary));
            } else {
                this.retryOverlay.setVisibility(8);
                this.nameTv.setTextColor(this.itemView.getContext().getColor(R.color.qui_common_text_allwhite_secondary));
            }
            r(metaMaterial);
            WinkRoundedCornerImageView winkRoundedCornerImageView = this.thumbnailIv;
            final a aVar = this.H;
            winkRoundedCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.o(MetaMaterial.this, position, aVar, this, view);
                }
            });
            q(metaMaterial);
            View view = this.retryOverlay;
            final a aVar2 = this.H;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.p(MetaMaterial.this, position, aVar2, this, view2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super MetaMaterial, Unit> itemClickListener, @NotNull Function1<? super MetaMaterial, Unit> retryClickListener) {
        List<MetaMaterial> emptyList;
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        Intrinsics.checkNotNullParameter(retryClickListener, "retryClickListener");
        this.itemClickListener = itemClickListener;
        this.retryClickListener = retryClickListener;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.materials = emptyList;
        this.selectedIndex = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.materials.size();
    }

    public final void m0(int index) {
        if (this.selectedIndex == index) {
            return;
        }
        this.selectedIndex = index;
        notifyDataSetChanged();
    }

    public final void n0(@Nullable List<MetaMaterial> materials) {
        if (materials == null) {
            w53.b.c("WinkEditorAITemplateAdapter", "materials is null");
        } else {
            this.materials = materials;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).n(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hcr, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }
}
