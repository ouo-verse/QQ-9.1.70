package com.tencent.mobileqq.wink.editor.template;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g extends com.tencent.mobileqq.wink.view.ab {
    private RecyclerView T;
    protected int U;
    protected int V;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a extends AbsWinkMaterialPanelContentAdapter.e {
        void b(int i3, @Nullable MetaMaterial metaMaterial);
    }

    public g(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
        this.U = -1;
        this.V = 0;
    }

    private void s0(View view, MetaMaterial metaMaterial) {
        String str;
        Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        if (metaMaterial != null) {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_ENTRANCE + metaMaterial.hashCode();
        } else {
            str = null;
        }
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        eVar.e(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_ENTRANCE, buildElementParams, str);
        eVar.c(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_ENTRANCE, buildElementParams, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(MetaMaterial metaMaterial, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u0(view, metaMaterial);
        AbsWinkMaterialPanelContentAdapter.e eVar = this.I;
        if (eVar instanceof a) {
            ((a) eVar).b(i3, metaMaterial);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void u0(View view, MetaMaterial metaMaterial) {
        String str;
        Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        if (metaMaterial != null) {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_ENTRANCE + metaMaterial.hashCode();
        } else {
            str = null;
        }
        com.tencent.mobileqq.wink.report.e.f326265a.j(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_CHAR_ENTRANCE, buildElementParams, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, final int i3, @NonNull @NotNull final MetaMaterial metaMaterial) {
        boolean z16;
        super.n0(aVar, i3, metaMaterial);
        if (this.f326745h == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        s0(aVar.F, metaMaterial);
        if (z16 && i3 == this.U) {
            aVar.F.setVisibility(0);
            aVar.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.this.t0(metaMaterial, i3, view);
                }
            });
        } else {
            aVar.F.setVisibility(4);
        }
        aVar.l(Boolean.valueOf(metaMaterial.hasRedDot));
        VideoReport.setElementId(aVar.itemView, "em_xsj_template_item");
        VideoReport.setElementReuseIdentifier(aVar.itemView, String.valueOf(metaMaterial.hashCode()));
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_template_name", metaMaterial.f30533id);
        buildElementParams.put("xsj_template_id", metaMaterial.f30533id);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, com.tencent.mobileqq.wink.editor.c.p(metaMaterial));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, Integer.valueOf(this.V));
        buildElementParams.put("xsj_if_red_dot", Integer.valueOf(metaMaterial.hasRedDot ? 1 : 0));
        VideoReport.setElementExposePolicy(aVar.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(aVar.itemView, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(aVar.itemView, buildElementParams);
    }

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.T = recyclerView;
    }

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.T = null;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void v0(MetaMaterial metaMaterial) {
        this.U = com.tencent.mobileqq.wink.editor.c.g(B(), metaMaterial);
        notifyDataSetChanged();
        RecyclerView recyclerView = this.T;
        if (recyclerView != null) {
            final com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Objects.requireNonNull(eVar);
            recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.template.f
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.wink.report.e.this.y();
                }
            }, 500L);
        }
    }
}
