package com.tencent.mobileqq.wink.view;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class x extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f327149d;

    /* renamed from: e, reason: collision with root package name */
    private List<MetaCategory> f327150e;

    /* renamed from: f, reason: collision with root package name */
    private final b f327151f;

    /* renamed from: h, reason: collision with root package name */
    private c f327152h = null;

    /* renamed from: i, reason: collision with root package name */
    protected int f327153i = 0;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        public TextView f327154d;

        /* renamed from: e, reason: collision with root package name */
        public View f327155e;

        public a(View view) {
            super(view);
            this.f327154d = (TextView) view.findViewById(R.id.f918556a);
            this.f327155e = view.findViewById(R.id.f9181567);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(a aVar, int i3, @Nullable MetaCategory metaCategory);

        void b(a aVar, int i3, @Nullable MetaCategory metaCategory);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void a(int i3, @Nullable MetaCategory metaCategory);
    }

    public x(List<MetaCategory> list, b bVar) {
        this.f327150e = list;
        this.f327151f = bVar;
    }

    private void q(View view, MetaCategory metaCategory) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_CATEGORY_ITEM);
        VideoReport.setElementReuseIdentifier(view, String.valueOf(metaCategory.hashCode()));
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, metaCategory.name);
        buildElementParams.put("xsj_if_red_dot", Integer.valueOf(metaCategory.hasRedDot ? 1 : 0));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(int i3, MetaCategory metaCategory, a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B(i3);
        if (metaCategory != null) {
            metaCategory.hasRedDot = false;
        }
        this.f327151f.a(aVar, i3, metaCategory);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void x(int i3, int i16) {
        if (i16 != i3 && this.f327150e.size() > i16) {
            MetaCategory metaCategory = this.f327150e.get(i16);
            metaCategory.hasRedDot = false;
            c cVar = this.f327152h;
            if (cVar != null) {
                cVar.a(i16, metaCategory);
            }
        }
    }

    public void A(c cVar) {
        this.f327152h = cVar;
    }

    public void B(int i3) {
        C(i3, true);
    }

    public void C(int i3, boolean z16) {
        int i16;
        if (i3 < 0 || i3 >= this.f327150e.size() || (i16 = this.f327153i) == i3) {
            return;
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.wink.utils.b.f(this.f327149d, i16, i3, z16, false);
        }
        x(this.f327153i, i3);
        this.f327153i = i3;
        notifyDataSetChanged();
        w53.b.a("WinkMaterialPanelCategoryAdapter", " setSelectedIndex index = " + i3);
    }

    public void D(int i3) {
        this.f327153i = i3;
        x(i3, i3);
        notifyDataSetChanged();
        w53.b.a("WinkMaterialPanelCategoryAdapter", "setSelectedIndexWithoutScroll index = " + i3);
    }

    public void E(List<MetaCategory> list) {
        this.f327150e = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaCategory> list = this.f327150e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f327149d = recyclerView;
    }

    public String r(int i3) {
        if (i3 >= 0 && i3 < this.f327150e.size()) {
            return this.f327150e.get(i3).f30532id;
        }
        return null;
    }

    public int s(String str) {
        if (str != null && this.f327150e != null) {
            for (int i3 = 0; i3 < this.f327150e.size(); i3++) {
                if (this.f327150e.get(i3) != null && str.equals(this.f327150e.get(i3).f30532id)) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public MetaCategory t() {
        List<MetaCategory> list = this.f327150e;
        if (list != null && this.f327153i < list.size()) {
            return this.f327150e.get(this.f327153i);
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, final int i3) {
        final MetaCategory metaCategory = this.f327150e.get(i3);
        this.f327151f.b(aVar, i3, metaCategory);
        if (metaCategory != null) {
            aVar.f327154d.setText(metaCategory.name);
            if (metaCategory.hasRedDot) {
                aVar.f327155e.setVisibility(0);
            } else {
                aVar.f327155e.setVisibility(8);
            }
        }
        if (this.f327153i == i3) {
            aVar.f327154d.setTextColor(aVar.itemView.getContext().getResources().getColor(R.color.bfp));
            aVar.f327154d.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            aVar.f327154d.setTextColor(aVar.itemView.getContext().getResources().getColor(R.color.bfq));
            aVar.f327154d.setTypeface(Typeface.defaultFromStyle(0));
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.this.u(i3, metaCategory, aVar, view);
            }
        });
        if (metaCategory != null) {
            q(aVar.itemView, metaCategory);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hf6, viewGroup, false));
    }

    public void y(List<String> list) {
        for (String str : list) {
            for (int i3 = 0; i3 < this.f327150e.size(); i3++) {
                if (str.equals(this.f327150e.get(i3).f30532id)) {
                    this.f327150e.get(i3).hasRedDot = false;
                    notifyItemChanged(i3);
                }
            }
        }
    }

    public void z(int i3, boolean z16) {
        if (this.f327153i == i3) {
            return;
        }
        if (i3 < 0) {
            i3 = getItemCount() - 1;
        }
        if (i3 >= 0) {
            this.f327151f.a(null, i3, this.f327150e.get(i3));
            com.tencent.mobileqq.wink.utils.b.f(this.f327149d, this.f327153i, i3, z16, false);
            this.f327153i = i3;
            notifyDataSetChanged();
            w53.b.a("WinkMaterialPanelCategoryAdapter", " scrollCatAdapterToPosition index = " + i3);
        }
    }
}
