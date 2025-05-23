package com.tencent.biz.qqcircle.push;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.part.push.a;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import qqcircle.QQCircleClient$TaskInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends com.tencent.biz.qqcircle.bizparts.a<QQCircleClient$TaskInfo> {

    /* renamed from: m, reason: collision with root package name */
    private a.e f91851m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(QQCircleClient$TaskInfo qQCircleClient$TaskInfo, int i3) {
            View view = this.itemView;
            if (view instanceof QFSPushMissionItemView) {
                ((QFSPushMissionItemView) view).setData(qQCircleClient$TaskInfo, i3);
                ((QFSPushMissionItemView) this.itemView).setDismissClickListener(i.this.f91851m);
            }
        }
    }

    public i(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPushMissionListAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 0;
    }

    public void j0(a.e eVar) {
        this.f91851m = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        ((a) viewHolder).l(getDataList().get(i3), i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(new QFSPushMissionItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
