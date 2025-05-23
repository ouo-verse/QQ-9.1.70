package com.tencent.mobileqq.wink.publish.adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class a<E> extends MultiViewBlock<E> {

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f325644m;

    public a(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f325644m = recyclerView;
    }
}
