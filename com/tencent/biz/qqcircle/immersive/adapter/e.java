package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.hobbylabel.QFSHobbyLabelItemView;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
            View view = this.itemView;
            if (!(view instanceof QFSHobbyLabelItemView)) {
                return;
            }
            ((QFSHobbyLabelItemView) view).bindData(qQCircleDitto$StItemInfo, i3);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && i3 <= list.size() && this.mDataList.get(i3) != null && (viewHolder instanceof a) && this.mDataList.get(i3) != null) {
            ((a) viewHolder).l((QQCircleDitto$StItemInfo) this.mDataList.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSHobbyLabelItemView qFSHobbyLabelItemView = new QFSHobbyLabelItemView(viewGroup.getContext());
        qFSHobbyLabelItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new a(qFSHobbyLabelItemView);
    }
}
