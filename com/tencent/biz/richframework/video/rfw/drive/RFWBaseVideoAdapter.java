package com.tencent.biz.richframework.video.rfw.drive;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.video.rfw.drive.feeds.RFWFeedScrollManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWBaseVideoAdapter<E> extends BaseListViewAdapter<E> implements IRFWViewPager2AdapterDrive, IRFWLayerScrollerStatus {
    private Fragment mHostFragment;
    protected RFWBaseScrollStatusManager mScrollManager;
    private HashSet<RFWLayerBaseScroller> mScrollerList = new HashSet<>();

    public RFWBaseVideoAdapter() {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public RecyclerView.ViewHolder finViewHolderByPos(int i3) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.findViewHolderForAdapterPosition(i3);
        }
        return null;
    }

    public String getDataSingleKey(int i3) {
        return "";
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public Fragment getHostFragment() {
        return this.mHostFragment;
    }

    public RFWBaseScrollStatusManager getScrollManger() {
        return this.mScrollManager;
    }

    public /* synthetic */ String getSourceType() {
        return c.a(this);
    }

    public String getUniquePageId() {
        return "null";
    }

    protected RFWBaseScrollStatusManager initScrollManager(@NonNull RecyclerView recyclerView) {
        RFWBaseScrollStatusManager rFWLayerScrollStatusManager;
        if (isFeedScrollType()) {
            rFWLayerScrollStatusManager = new RFWFeedScrollManager(getUniquePageId(), recyclerView);
        } else {
            rFWLayerScrollStatusManager = new RFWLayerScrollStatusManager(getUniquePageId(), (ViewPager2) recyclerView.getParent());
        }
        rFWLayerScrollStatusManager.addScroller(new RFWLayerVideoPreloadScroller(this));
        Iterator<RFWLayerBaseScroller> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            rFWLayerScrollStatusManager.addScroller(it.next());
        }
        QLog.d("RFWBaseViewPager2Adapter", 4, "initScrollManger:" + getUniquePageId());
        return rFWLayerScrollStatusManager;
    }

    protected boolean isFeedScrollType() {
        return false;
    }

    public /* synthetic */ boolean isSimpleFeed(int i3) {
        return c.b(this, i3);
    }

    public /* synthetic */ boolean mayPreloadPreVideo() {
        return c.c(this);
    }

    protected boolean needScrollManger() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (!needScrollManger()) {
            return;
        }
        this.mScrollManager = initScrollManager(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager != null) {
            rFWBaseScrollStatusManager.bindViewHolder(viewHolder);
        }
    }

    public void onDataRefresh() {
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager == null) {
            return;
        }
        rFWBaseScrollStatusManager.onDataRefresh();
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        if (this.mScrollManager != null && !uq3.c.U()) {
            this.mScrollManager.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager != null) {
            rFWBaseScrollStatusManager.onDestroy();
            this.mScrollManager = null;
            QLog.d("RFWBaseViewPager2Adapter", 4, "onDetachedFromRecyclerView:" + getUniquePageId());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedPageScrolled(int i3, float f16, int i16) {
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager == null) {
            return;
        }
        rFWBaseScrollStatusManager.onFeedPageScrolled(i3, f16, i16);
    }

    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager == null) {
            return;
        }
        rFWBaseScrollStatusManager.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager == null) {
            return;
        }
        rFWBaseScrollStatusManager.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onLoadFeedExport(int i3, int i16) {
        b.c(this, i3, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPageScrolledIdle(int i3) {
        b.d(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (this.mScrollManager != null && !uq3.c.U()) {
            this.mScrollManager.onPaused(rFWFeedSelectInfo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPosUpdate(int i3) {
        b.f(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (this.mScrollManager != null && !uq3.c.U()) {
            this.mScrollManager.onResumed(rFWFeedSelectInfo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (this.mScrollManager != null && !uq3.c.U()) {
            this.mScrollManager.onStart(rFWFeedSelectInfo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (this.mScrollManager != null && !uq3.c.U()) {
            this.mScrollManager.onStop(rFWFeedSelectInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        String uniquePageId = getUniquePageId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fs_lifecycle onViewAttachedToWindow  | holder = ");
        sb5.append(viewHolder);
        sb5.append(" | pageId = ");
        if (TextUtils.isEmpty(uniquePageId)) {
            uniquePageId = "null";
        }
        sb5.append(uniquePageId);
        QLog.d("RFWBaseViewPager2Adapter", 1, sb5.toString());
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager != null) {
            rFWBaseScrollStatusManager.addViewHolder(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        String uniquePageId = getUniquePageId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fs_lifecycle onViewDetachedFromWindow  | holder = ");
        sb5.append(viewHolder);
        sb5.append(" | pageId = ");
        if (TextUtils.isEmpty(uniquePageId)) {
            uniquePageId = "null";
        }
        sb5.append(uniquePageId);
        QLog.d("RFWBaseViewPager2Adapter", 1, sb5.toString());
        RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
        if (rFWBaseScrollStatusManager != null) {
            rFWBaseScrollStatusManager.removeViewHolder(viewHolder);
        }
    }

    public void registerScroller(@NonNull RFWLayerBaseScroller rFWLayerBaseScroller) {
        QLog.d("RFWBaseViewPager2Adapter", 1, "registerScroller :" + rFWLayerBaseScroller);
        if (this.mScrollManager != null) {
            QLog.d("RFWBaseViewPager2Adapter", 1, "registerScroller :" + rFWLayerBaseScroller + ", attach to scrollManager");
            this.mScrollManager.addScroller(rFWLayerBaseScroller);
        }
        if (rFWLayerBaseScroller == null) {
            return;
        }
        this.mScrollerList.add(rFWLayerBaseScroller);
    }

    public void setHostFragment(Fragment fragment) {
        this.mHostFragment = fragment;
    }

    public boolean showReNotify(RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    public void triggerFeedReplace(int i3) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition != null) {
            onBindViewHolder(findViewHolderForAdapterPosition, i3);
            RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
            if (rFWBaseScrollStatusManager != null) {
                rFWBaseScrollStatusManager.onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType("TYPE_SELECT_TRIGGER_FEED_REPLACE"));
                return;
            }
            return;
        }
        QLog.d("RFWBaseViewPager2Adapter", 1, "[triggerFeedReplace] holder == null, end flow.");
    }

    public void triggerFullDetailFeed(int i3) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            QLog.e("RFWBaseViewPager2Adapter", 1, "[triggerFeedReplace] mRecyclerView is null");
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition != null) {
            onBindViewHolder(findViewHolderForAdapterPosition, i3);
            RFWBaseScrollStatusManager rFWBaseScrollStatusManager = this.mScrollManager;
            if (rFWBaseScrollStatusManager != null) {
                rFWBaseScrollStatusManager.onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType("TYPE_SELECT_TRIGGER_DETAIL_FEED_FULL"));
                return;
            }
            return;
        }
        QLog.d("RFWBaseViewPager2Adapter", 1, "[triggerFeedReplace] holder == null, end flow.");
    }

    public RFWBaseVideoAdapter(Fragment fragment) {
        this.mHostFragment = fragment;
    }
}
