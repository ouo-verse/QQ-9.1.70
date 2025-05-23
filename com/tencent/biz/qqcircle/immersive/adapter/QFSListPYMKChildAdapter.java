package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.pymk.QFSListPYMKChildItemView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSListPYMKChildAdapter extends com.tencent.biz.qqcircle.immersive.adapter.a<FeedCloudMeta$StFeed> {
    private RecyclerView C;
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private final List<FeedCloudMeta$StFeed> f84718m = new ArrayList();

    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        private String E;

        public a(View view) {
            super(view);
        }

        public void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            View view = this.itemView;
            if (view instanceof QFSListPYMKChildItemView) {
                ((QFSListPYMKChildItemView) view).bindData(feedCloudMeta$StFeed, i3);
                ((QFSListPYMKChildItemView) this.itemView).setViewModelKey(this.E);
            }
        }

        public void m(String str) {
            this.E = str;
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f84718m.size();
    }

    protected void i0() {
        RecyclerView recyclerView = this.C;
        if (recyclerView == null) {
            QLog.d("QFSListPYMKChildAdapter", 1, "[safeNotify] recycle view should not be null.");
        } else if (recyclerView.isComputingLayout()) {
            this.C.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.adapter.QFSListPYMKChildAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSListPYMKChildAdapter.this.notifyDataSetChanged();
                }
            }, 500L);
        } else {
            notifyDataSetChanged();
        }
    }

    public void j0(String str) {
        this.D = str;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.C = recyclerView;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.m(this.D);
            aVar.l(this.f84718m.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(new QFSListPYMKChildItemView(viewGroup.getContext()));
    }

    public void setData(List<FeedCloudMeta$StFeed> list) {
        this.f84718m.clear();
        this.f84718m.addAll(list);
        i0();
    }
}
