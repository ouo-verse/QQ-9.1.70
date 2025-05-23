package com.tencent.biz.richframework.video.rfw.drive.feeds;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus;
import com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive;
import com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWFeedScrollManager extends RFWBaseScrollStatusManager {
    public static float CHECK_PLAY_SPEED = 3.0f;
    public static float CHECK_TIME_INTERVAL = 500.0f;
    public static int SCROLL_IDLE = -1;
    private boolean mIsScrollUp;
    private int mOrientation;
    private final RecyclerView mRecyclerView;
    private int mScrollDisY;
    private int mScrollOrient;
    private float mShowRate;
    private long mStartComputeTime;

    public RFWFeedScrollManager(String str, RecyclerView recyclerView) {
        super(str, (IRFWViewPager2AdapterDrive) recyclerView.getAdapter());
        this.mOrientation = -1;
        this.mIsScrollUp = false;
        this.mShowRate = 0.8f;
        recyclerView.addOnScrollListener(this);
        this.mRecyclerView = recyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkTargetPlayItemSelect(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if ((findViewByPosition instanceof IRFWLayerItemViewScrollerStatus) && ((IRFWLayerItemViewScrollerStatus) findViewByPosition).isVideoType()) {
                int i17 = 0;
                if (!inPlayArea(findViewByPosition, this.mShowRate)) {
                    if (this.mCurrentFeedPos == i3) {
                        RFWFeedSelectInfo rFWFeedSelectInfo = new RFWFeedSelectInfo(i3);
                        if (this.mIsScrollUp) {
                            i17 = i3 + 1;
                        } else if (i3 > 0) {
                            i17 = i3 - 1;
                        }
                        onFeedUnSelected(rFWFeedSelectInfo.setNextPosition(i17).setUnSelectedType("TYPE_UNSELECTED_NORMAL"));
                    }
                } else {
                    this.mCurrentFeedPos = i3;
                    onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType("TYPE_SELECT_NORMAL"));
                    RFWLog.d("RFWFeedScrollManager", RFWLog.USR, "checkPlayStatus , trigger play   | pos = " + i3 + " | view = " + findViewByPosition);
                    return;
                }
            }
            i3++;
        }
    }

    private int[] computeGridLayout(RecyclerView recyclerView) {
        int[] iArr = new int[4];
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            iArr[0] = gridLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = gridLayoutManager.findLastVisibleItemPosition();
            iArr[2] = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = gridLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    private int[] computeLinearLayout(RecyclerView recyclerView) {
        int[] iArr = new int[4];
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            iArr[0] = linearLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = linearLayoutManager.findLastVisibleItemPosition();
            iArr[2] = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    private int[] computeStaggeredGridLayout(RecyclerView recyclerView) {
        int[] iArr = new int[4];
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            iArr[0] = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            iArr[1] = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
            iArr[2] = staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            iArr[3] = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
        }
        return iArr;
    }

    private void dispatchScroll(RecyclerView recyclerView, int i3, int i16, boolean z16, int[] iArr) {
        ArrayList<RFWLayerBaseScroller> arrayList = this.mScrollerList;
        if (arrayList == null) {
            return;
        }
        Iterator<RFWLayerBaseScroller> it = arrayList.iterator();
        while (it.hasNext()) {
            RFWLayerBaseScroller next = it.next();
            if (next instanceof RFWFeedBaseScroller) {
                ((RFWFeedBaseScroller) next).onScroll(recyclerView, i3, i16, z16, iArr[0], iArr[1], iArr[2], iArr[3]);
            }
        }
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        ArrayList<RFWLayerBaseScroller> arrayList = this.mScrollerList;
        if (arrayList == null) {
            return;
        }
        Iterator<RFWLayerBaseScroller> it = arrayList.iterator();
        while (it.hasNext()) {
            RFWLayerBaseScroller next = it.next();
            if (next instanceof RFWFeedBaseScroller) {
                ((RFWFeedBaseScroller) next).onScrollStateChanged(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.mIsScrollUp);
            }
        }
    }

    private void dispatchSlowScroll(RecyclerView recyclerView, boolean z16, int[] iArr) {
        if (this.mScrollerList == null) {
            return;
        }
        checkTargetPlayItemSelect(recyclerView.getLayoutManager(), iArr[0], iArr[1]);
        Iterator<RFWLayerBaseScroller> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            RFWLayerBaseScroller next = it.next();
            if (next instanceof RFWFeedBaseScroller) {
                ((RFWFeedBaseScroller) next).triggerSlowScroll(iArr[0], iArr[1], iArr[2], iArr[3], z16);
            }
        }
    }

    private int getOrientation(RecyclerView recyclerView) {
        if (this.mOrientation == -1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                this.mOrientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
            } else if (layoutManager instanceof LinearLayoutManager) {
                this.mOrientation = ((LinearLayoutManager) layoutManager).getOrientation();
            }
        }
        return this.mOrientation;
    }

    private boolean inPlayAreaHorizontal(View view, float f16) {
        int i3;
        Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(rect);
        int width = view.getWidth();
        int i16 = rect.right;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenWidth()) {
                rect.right = DisplayUtil.getScreenWidth();
            }
            i3 = rect.right - rect.left;
        } else {
            i3 = 0;
        }
        float f17 = i3 / width;
        RFWLog.d("RFWFeedScrollManager", RFWLog.USR, "inPlayAreaHorizontal  | rate = " + f17 + " | showRate = " + f16);
        if (f17 < f16) {
            return false;
        }
        return true;
    }

    private boolean inPlayAreaVertical(View view, float f16) {
        int i3;
        Rect rect = new Rect(0, 0, DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        int i16 = rect.bottom;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenHeight()) {
                rect.bottom = DisplayUtil.getScreenHeight();
            }
            i3 = rect.bottom - rect.top;
        } else {
            i3 = 0;
        }
        float f17 = i3 / height;
        RFWLog.d("RFWFeedScrollManager", RFWLog.USR, "inPlayAreaVertical  | rate = " + f17 + " | showRate = " + f16);
        if (f17 < f16) {
            return false;
        }
        return true;
    }

    private void onScrollDown(int i3) {
        this.mIsScrollUp = false;
        int i16 = this.mScrollOrient;
        if (i16 != 1 && i16 != SCROLL_IDLE) {
            resetScrollParam();
            if (QLog.isColorLevel()) {
                QLog.d("RFWFeedScrollManager", 2, "change orient to down:" + this.mScrollOrient);
            }
        }
        if (this.mStartComputeTime == 0) {
            this.mStartComputeTime = System.currentTimeMillis();
        }
        this.mScrollDisY += i3;
        this.mScrollOrient = 1;
    }

    private void onScrollUp(int i3) {
        this.mIsScrollUp = true;
        int i16 = this.mScrollOrient;
        if (i16 != 0 && i16 != SCROLL_IDLE) {
            resetScrollParam();
            if (QLog.isColorLevel()) {
                QLog.d("RFWFeedScrollManager", 2, "change orient to up:" + this.mScrollOrient);
            }
        }
        if (this.mStartComputeTime == 0) {
            this.mStartComputeTime = System.currentTimeMillis();
        }
        this.mScrollDisY += i3;
        this.mScrollOrient = 0;
    }

    public int[] computePosition(RecyclerView recyclerView) {
        int[] computeLinearLayout;
        int[] iArr = new int[4];
        if (recyclerView == null) {
            return iArr;
        }
        try {
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                computeLinearLayout = computeStaggeredGridLayout(recyclerView);
            } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                computeLinearLayout = computeGridLayout(recyclerView);
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                computeLinearLayout = computeLinearLayout(recyclerView);
            } else {
                return iArr;
            }
            return computeLinearLayout;
        } catch (Exception e16) {
            e16.printStackTrace();
            return iArr;
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager
    public int getTargetItemPosition() {
        return -1;
    }

    protected boolean inPlayArea(View view, float f16) {
        if (view == null) {
            return false;
        }
        RFWVideoView rFWVideoView = (RFWVideoView) view.findViewById(R.id.f74163vi);
        if (rFWVideoView != null) {
            view = rFWVideoView;
        }
        if (isVertical()) {
            return inPlayAreaVertical(view, f16);
        }
        return inPlayAreaHorizontal(view, f16);
    }

    protected boolean isVertical() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || getOrientation(recyclerView) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager
    public void onDataRefresh() {
        super.onDataRefresh();
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            onScrollStateChanged(recyclerView, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int[] computePosition = computePosition(recyclerView);
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, computePosition[0], computePosition[1], computePosition[2], computePosition[3]);
        if (i3 != 0) {
            return;
        }
        checkTargetPlayItemSelect(layoutManager, computePosition[0], computePosition[1]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        boolean z17;
        if (i16 >= 0) {
            onScrollUp(i16);
        } else {
            onScrollDown(i16);
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.mStartComputeTime);
        int[] computePosition = computePosition(recyclerView);
        if (currentTimeMillis > CHECK_TIME_INTERVAL && Math.abs(this.mScrollDisY / currentTimeMillis) < CHECK_PLAY_SPEED) {
            if (i16 >= 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            dispatchSlowScroll(recyclerView, z17, computePosition);
            resetScrollParam();
        }
        if (i16 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        dispatchScroll(recyclerView, i3, i16, z16, computePosition);
    }

    public void resetScrollParam() {
        this.mScrollOrient = SCROLL_IDLE;
        this.mScrollDisY = 0;
        this.mStartComputeTime = 0L;
    }
}
