package com.qzone.reborn.base;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d extends c {

    /* renamed from: d, reason: collision with root package name */
    private boolean f53563d;

    public d(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        this.f53563d = true;
    }

    private int B9(int i3) {
        int blockPositionStartOffset = this.mBlockContainer.getBlockMerger().getBlockPositionStartOffset(C9());
        if (this.mBlockContainer.getBlockMerger().isEnableRefresh()) {
            blockPositionStartOffset++;
        }
        return i3 + blockPositionStartOffset;
    }

    private void D9() {
        if (C9() != null) {
            C9().notifyDataSetChanged();
        }
    }

    protected abstract we.b C9();

    public void G9(int i3, boolean z16, int i16) {
        J9(B9(i3), z16, i16);
    }

    public void J9(int i3, boolean z16, int i16) {
        if (!this.f53563d) {
            i3 = 0;
        }
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getRecyclerView() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.mBlockContainer.getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int A9 = A9(i3) + i16;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (Math.abs(linearLayoutManager.findFirstVisibleItemPosition() - i3) <= 10 && !z16) {
                com.qzone.reborn.feedx.scroller.n nVar = new com.qzone.reborn.feedx.scroller.n(this.mBlockContainer.getContext());
                nVar.setTargetPosition(i3);
                nVar.a(A9);
                layoutManager.startSmoothScroll(nVar);
                return;
            }
            this.mBlockContainer.getRecyclerView().stopScroll();
            linearLayoutManager.scrollToPositionWithOffset(i3, A9);
        }
    }

    public void K9() {
        scrollToTop();
        refresh();
    }

    public void L9(boolean z16) {
        this.f53563d = z16;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("SCROLL_TO_TOP".equals(str)) {
            scrollToTop();
            return;
        }
        if ("SCROLL_TO_FIRST_FEED".equals(str)) {
            E9(0);
            return;
        }
        if ("notify_list_adapter_ui".equals(str)) {
            D9();
        } else if ("SCROLL_TO_TOP_AND_REFRESH".equals(str)) {
            K9();
        } else if ("DO_FEED_REFRESH".equals(str)) {
            refresh();
        }
    }

    public void refresh() {
        if (C9() != null) {
            LoadInfo loadInfo = new LoadInfo();
            loadInfo.setCurrentState(2);
            C9().loadData(loadInfo);
        }
    }

    public void E9(int i3) {
        F9(i3, false);
    }

    public void F9(int i3, boolean z16) {
        G9(i3, z16, 0);
    }

    public void H9(int i3) {
        I9(i3, false);
    }

    public void I9(int i3, boolean z16) {
        J9(i3, z16, 0);
    }

    public void scrollToTop() {
        H9(0);
    }

    public int A9(int i3) {
        if (i3 <= 0 || getContext() == null || getContext().getResources() == null) {
            return 0;
        }
        return QZoneFeedxViewUtils.e(getActivity());
    }
}
