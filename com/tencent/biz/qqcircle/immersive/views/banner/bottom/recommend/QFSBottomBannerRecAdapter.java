package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomBannerRecAdapter extends RecyclerView.Adapter<a> {
    private RecyclerView C;

    /* renamed from: m, reason: collision with root package name */
    private List<e30.b> f90713m = new ArrayList();

    private void l0() {
        RecyclerView recyclerView = this.C;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.isComputingLayout()) {
            this.C.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSBottomBannerRecAdapter.this.notifyDataSetChanged();
                }
            });
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f90713m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull @NotNull a aVar, int i3) {
        if (this.f90713m.size() <= i3) {
            return;
        }
        aVar.l(this.f90713m.get(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i3) {
        return new a(new QFSBottomBannerRecItemView(viewGroup.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NonNull @NotNull a aVar) {
        super.onViewAttachedToWindow(aVar);
        VideoReport.traversePage(this.C);
        QLog.d("QFSFeedBottomRecommendView", 1, "adapter onViewAttachedToWindow");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull @NotNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.C = recyclerView;
        QLog.d("QFSFeedBottomRecommendView", 1, "adapter onAttachedToRecyclerView");
    }

    public void setData(List<e30.b> list) {
        this.f90713m.clear();
        this.f90713m.addAll(list);
        l0();
        QLog.d("QFSFeedBottomRecommendView", 1, "adapter setData and notify current size:" + this.f90713m.size());
    }
}
