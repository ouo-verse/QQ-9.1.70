package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalMenuTopItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends k {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSPersonalMenuTopItemView qFSPersonalMenuTopItemView = new QFSPersonalMenuTopItemView(viewGroup.getContext());
        qFSPersonalMenuTopItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new BaseListViewAdapter.BaseVH(qFSPersonalMenuTopItemView);
    }
}
