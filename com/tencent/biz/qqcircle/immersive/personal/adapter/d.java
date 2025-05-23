package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxDetailFeedItemView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSPersonalCollectBoxAddFeedAdapter {
    public d(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter, com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter, com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalCollectBoxDetailFeedItemView(viewGroup.getContext()));
    }
}
