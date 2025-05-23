package com.qzone.reborn.feedpro.block;

import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends com.qzone.reborn.base.b {
    public g(BlockContainer blockContainer) {
        super(blockContainer);
        setHasStableIds(false);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void triggerToLoadMore() {
        MultiViewBlock multiViewBlock;
        int size = this.mDataList.size() - 1;
        while (true) {
            if (size < 0) {
                multiViewBlock = null;
                break;
            } else {
                if (this.mDataList.get(size) instanceof h) {
                    multiViewBlock = (MultiViewBlock) this.mDataList.get(size);
                    break;
                }
                size--;
            }
        }
        if (multiViewBlock == null) {
            return;
        }
        BlockContainer blockContainer = getBlockContainer();
        if ((blockContainer == null || blockContainer.isEnableLoadMore()) && !multiViewBlock.getLoadInfo().isLoading()) {
            if (multiViewBlock.getLoadInfo().isFinish()) {
                multiViewBlock.getLoadInfo().setCurrentState(4);
            } else if (multiViewBlock.getDataList().size() > 0) {
                onLoadingStart();
                multiViewBlock.getLoadInfo().setCurrentState(3);
                multiViewBlock.loadMoreData(multiViewBlock.getLoadInfo());
            }
        }
    }
}
