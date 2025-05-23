package com.tencent.biz.qqcircle.immersive.gallery.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryRecommendTagFeedItemView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private QQCircleDitto$StItemContainer C;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f86434m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public QFSGalleryRecommendTagFeedItemView E;

        public a(@NonNull QFSGalleryRecommendTagFeedItemView qFSGalleryRecommendTagFeedItemView) {
            super(qFSGalleryRecommendTagFeedItemView);
            this.E = qFSGalleryRecommendTagFeedItemView;
        }

        public void l(List<QQCircleDitto$StItemInfo> list) {
            this.E.setData(list);
        }
    }

    private List<QQCircleDitto$StItemInfo> i0(int i3) {
        int i16;
        int i17;
        ArrayList arrayList = new ArrayList();
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.C;
        if (qQCircleDitto$StItemContainer != null && qQCircleDitto$StItemContainer.items.get() != null) {
            List<QQCircleDitto$StItemInfo> list = this.C.items.get();
            if (!list.isEmpty() && list.size() > (i17 = (i16 = i3 * 2) + 1)) {
                arrayList.add(list.get(i16));
                arrayList.add(list.get(i17));
                return arrayList;
            }
            QLog.d("QFSGalleryRecommendTagFeedAdapter", 1, "index is bigger than size");
            return arrayList;
        }
        QLog.d("QFSGalleryRecommendTagFeedAdapter", 1, "ditto item list is null");
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.C;
        if (qQCircleDitto$StItemContainer != null && qQCircleDitto$StItemContainer.items.get() != null) {
            return this.C.items.get().size() / 2;
        }
        return 0;
    }

    public void j0(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer == null) {
            QLog.d("QFSGalleryRecommendTagFeedAdapter", 1, "ditto feed is null");
        } else {
            this.C = qQCircleDitto$StItemContainer;
            notifyDataSetChanged();
        }
    }

    public void k0(RecyclerView recyclerView) {
        this.f86434m = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).l(i0(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(new QFSGalleryRecommendTagFeedItemView(viewGroup.getContext()));
    }
}
