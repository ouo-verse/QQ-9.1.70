package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.template.templatepanel.a;
import com.tencent.mobileqq.wink.editor.template.templatepanel.b;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends com.tencent.mobileqq.wink.editor.template.templatepanel.a {
    private a Y;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.template.templatepanel.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9044b extends ab.a {
        private a H;

        public C9044b(View view, a aVar) {
            super(view);
            VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            this.H = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = this.H;
            if (aVar != null) {
                aVar.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void d() {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: q73.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C9044b.this.n(view);
                }
            });
        }
    }

    public b(@NonNull Context context, WinkEditorViewModel.EditMode editMode, a aVar, a.InterfaceC9043a interfaceC9043a) {
        super(context, editMode, interfaceC9043a);
        this.Y = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y0(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY);
        VideoReport.reportEvent("dt_imp", view, WinkDTParamBuilder.buildElementParams());
    }

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override // com.tencent.mobileqq.wink.view.ab, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 != getItemCount() - 1) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.a, com.tencent.mobileqq.wink.view.ab
    public ab.a o0(ViewGroup viewGroup, int i3) {
        if (i3 == 2) {
            return new C9044b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfl, viewGroup, false), this.Y);
        }
        return super.o0(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab, com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public <T extends RecyclerView.ViewHolder> void x(T t16, int i3, @NonNull MetaMaterial metaMaterial) {
        if (t16 instanceof C9044b) {
            final View view = ((C9044b) t16).itemView;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: q73.n
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.wink.editor.template.templatepanel.b.y0(view);
                }
            });
        } else {
            super.x(t16, i3, metaMaterial);
        }
    }
}
