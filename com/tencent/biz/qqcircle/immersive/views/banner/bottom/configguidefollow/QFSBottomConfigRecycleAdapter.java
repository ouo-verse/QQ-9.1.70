package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QFSDefaultItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView C;
    private final ShowScene D;

    /* renamed from: m, reason: collision with root package name */
    private List<d> f90642m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum ShowScene {
        SCENE_FEED_MASK(0),
        SCENE_FOLLOW_AUTHOR(1);

        private final int value;

        ShowScene(int i3) {
            this.value = i3;
        }

        public int getValue() {
            return this.value;
        }
    }

    public QFSBottomConfigRecycleAdapter(ShowScene showScene) {
        this.D = showScene;
        QLog.d("QFSBottomConfigRecycleAdapter", 1, "initAdapter, hashCode:" + hashCode());
    }

    private void i0() {
        RecyclerView recyclerView = this.C;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.isComputingLayout()) {
            this.C.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSBottomConfigRecycleAdapter.this.notifyDataSetChanged();
                }
            });
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f90642m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<d> list = this.f90642m;
        if (list != null && list.size() > i3) {
            return this.f90642m.get(i3).b();
        }
        QLog.e("QFSBottomConfigRecycleAdapter", 1, "[getItemViewType] return ITEM_TYPE_NONE");
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.C = recyclerView;
        QLog.d("QFSBottomConfigRecycleAdapter", 1, "adapter onAttachedToRecyclerView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<d> list = this.f90642m;
        if (list != null && list.size() > i3) {
            if (viewHolder instanceof c) {
                ((c) viewHolder).l(this.f90642m.get(i3), i3);
                return;
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).l(this.f90642m.get(i3), i3);
                return;
            } else {
                if (viewHolder instanceof a) {
                    ((a) viewHolder).l(this.f90642m.get(i3), i3);
                    return;
                }
                return;
            }
        }
        QLog.e("QFSBottomConfigRecycleAdapter", 1, "[onBindViewHolder] mStDrawerCardList =" + this.f90642m + ", pos=" + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder cVar;
        if (i3 == -103) {
            cVar = new a(new QFSBottomConfigFeedItemView(viewGroup.getContext()));
        } else if (i3 == -101) {
            cVar = new c(new QFSBottomConfigGuideFollowItemView(viewGroup.getContext(), this.D));
        } else if (i3 == -102) {
            cVar = new b(new QFSBottomConfigGuideFollowAllItemView(viewGroup.getContext()));
        } else {
            cVar = new c(new QFSDefaultItemView(viewGroup.getContext()));
        }
        cVar.setIsRecyclable(false);
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        VideoReport.traversePage(this.C);
        QLog.d("QFSBottomConfigRecycleAdapter", 1, "adapter onViewAttachedToWindow");
    }

    public void setData(List<d> list) {
        if (list == null) {
            QLog.e("QFSBottomConfigRecycleAdapter", 1, "[setData] data should not be null");
            return;
        }
        this.f90642m.clear();
        this.f90642m.addAll(list);
        i0();
        QLog.d("QFSBottomConfigRecycleAdapter", 1, "adapter setData and notify current size:" + this.f90642m.size());
    }
}
