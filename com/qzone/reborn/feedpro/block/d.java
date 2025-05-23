package com.qzone.reborn.feedpro.block;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d extends com.qzone.reborn.base.c {

    /* renamed from: e, reason: collision with root package name */
    public static final int f53896e = ar.e(0.5f);

    /* renamed from: d, reason: collision with root package name */
    private boolean f53897d;

    public d(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        this.f53897d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D9, reason: merged with bridge method [inline-methods] */
    public void I9(int i3, boolean z16, int i16) {
        if (!this.f53897d) {
            i3 = 0;
        }
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getRecyclerView() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.mBlockContainer.getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int C9 = C9(i3) + i16;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (Math.abs(linearLayoutManager.findFirstVisibleItemPosition() - i3) <= 10 && !z16) {
                com.qzone.reborn.feedx.scroller.n nVar = new com.qzone.reborn.feedx.scroller.n(this.mBlockContainer.getContext());
                nVar.setTargetPosition(i3);
                nVar.a(C9);
                layoutManager.startSmoothScroll(nVar);
                return;
            }
            this.mBlockContainer.getRecyclerView().stopScroll();
            linearLayoutManager.scrollToPositionWithOffset(i3, C9);
        }
    }

    private int F9(int i3) {
        int blockPositionStartOffset = this.mBlockContainer.getBlockMerger().getBlockPositionStartOffset(G9());
        if (this.mBlockContainer.getBlockMerger().isEnableRefresh()) {
            blockPositionStartOffset++;
        }
        return i3 + blockPositionStartOffset;
    }

    private void H9() {
        if (G9() != null) {
            G9().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9() {
        scrollToTop();
        refresh();
    }

    public int E9() {
        return 0;
    }

    protected abstract vd.b G9();

    public void L9(int i3, boolean z16, int i16) {
        O9(F9(i3), z16, i16);
    }

    public void O9(final int i3, final boolean z16, final int i16) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.block.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.I9(i3, z16, i16);
            }
        });
    }

    public void P9() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.block.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.J9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("SCROLL_TO_TOP".equals(str)) {
            scrollToTop();
            return;
        }
        if ("SCROLL_TO_FIRST_FEED".equals(str)) {
            K9(0);
            return;
        }
        if ("notify_list_adapter_ui".equals(str)) {
            H9();
        } else if ("SCROLL_TO_TOP_AND_REFRESH".equals(str)) {
            P9();
        } else if ("DO_FEED_REFRESH".equals(str)) {
            refresh();
        }
    }

    public void refresh() {
        if (G9() != null) {
            LoadInfo loadInfo = new LoadInfo();
            loadInfo.setCurrentState(2);
            G9().loadData(loadInfo);
        }
    }

    public void K9(int i3) {
        L9(i3, false, E9());
    }

    public void M9(int i3) {
        N9(i3, false);
    }

    public void N9(int i3, boolean z16) {
        O9(i3, z16, 0);
    }

    public void scrollToTop() {
        M9(0);
    }

    public int C9(int i3) {
        if (i3 <= 0 || getContext() == null || getContext().getResources() == null) {
            return 0;
        }
        return QZoneFeedxViewUtils.e(getActivity());
    }
}
