package com.tencent.biz.qqcircle.fragments;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleBlockContainer extends BlockContainer {
    public QCircleBlockContainer(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QCircleBlockMerger createBlockMerger() {
        return new QCircleBlockMerger(this);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QCircleBlockMerger getBlockMerger() {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger instanceof QCircleBlockMerger) {
            return (QCircleBlockMerger) blockMerger;
        }
        return null;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.mRecyclerView.canScrollVertically(i3);
    }

    public QCircleBlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleBlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
