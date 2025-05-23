package com.qzone.module.feedcomponent.actionreport;

import android.util.Log;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedContainerAdapter;
import com.qzone.module.feedcomponent.ui.FeedScrollContainerArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ContainerLeftRightScrollReport {
    static ContainerLeftRightScrollReport mInstance;
    int currentSelectPaged;
    boolean isLeftScrollToEnd;
    int moveDirection;
    float touchMoveEndedX;
    float touchMoveStartedX;
    boolean touchMoved;
    final int DIRECTION_RIGHT = 1;
    final int DIRECTION_LEFT = 2;

    public static ContainerLeftRightScrollReport getInstance() {
        if (mInstance == null) {
            synchronized (ContainerLeftRightScrollReport.class) {
                if (mInstance == null) {
                    mInstance = new ContainerLeftRightScrollReport();
                }
            }
        }
        return mInstance;
    }

    void doFeedContainerScrollReport(Object obj, int i3, int i16) {
        BusinessFeedData selectFeedViewData = getSelectFeedViewData(obj, i3);
        if (selectFeedViewData == null) {
            return;
        }
        int containerFeedPos = getContainerFeedPos(obj);
        if (i16 == 1) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("feedReport", "feedContainer right scroll,current selected = " + i3);
            }
            FeedActionRecorder.getInstance().addAction(selectFeedViewData, containerFeedPos, System.currentTimeMillis(), 23, 22);
        } else if (i16 == 2) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("feedReport", "feedContainer left scroll,current selected = " + i3);
            }
            FeedActionRecorder.getInstance().addAction(selectFeedViewData, containerFeedPos, System.currentTimeMillis(), 23, 20);
        }
        if (selectFeedViewData.getFeedCommInfo() != null && selectFeedViewData.getFeedCommInfo().isRealTimeTTTReport()) {
            i.H().y(12, 26, 19, System.currentTimeMillis(), null, selectFeedViewData, containerFeedPos, i3 + 1);
        } else {
            FeedActionRecorder.getInstance().addAction(selectFeedViewData, containerFeedPos, System.currentTimeMillis(), 26, 19, i3 + 1);
        }
    }

    int getContainerFeedPos(Object obj) {
        if (obj instanceof FeedContainerAdapter) {
            return ((FeedContainerAdapter) obj).getFeedPos();
        }
        if (obj instanceof FeedAdvContainer.FeedContainerViewPager) {
            return ((FeedAdvContainer.FeedContainerViewPager) obj).getFeedPos();
        }
        if (obj instanceof FeedScrollContainerArea.FeedContainerViewPager) {
            return ((FeedScrollContainerArea.FeedContainerViewPager) obj).getFeedPos();
        }
        return -1;
    }

    BusinessFeedData getSelectFeedViewData(Object obj, int i3) {
        if (obj instanceof FeedContainerAdapter) {
            FeedContainerAdapter feedContainerAdapter = (FeedContainerAdapter) obj;
            if (i3 >= feedContainerAdapter.getCount()) {
                return null;
            }
            return feedContainerAdapter.getItem(i3);
        }
        if (obj instanceof FeedAdvContainer.FeedContainerViewPager) {
            FeedAdvContainer.FeedContainerViewPager feedContainerViewPager = (FeedAdvContainer.FeedContainerViewPager) obj;
            if (i3 >= feedContainerViewPager.getCount()) {
                return null;
            }
            return feedContainerViewPager.getItem(i3);
        }
        if (!(obj instanceof FeedScrollContainerArea.FeedContainerViewPager)) {
            return null;
        }
        FeedScrollContainerArea.FeedContainerViewPager feedContainerViewPager2 = (FeedScrollContainerArea.FeedContainerViewPager) obj;
        if (i3 >= feedContainerViewPager2.getCount()) {
            return null;
        }
        return feedContainerViewPager2.getItem(i3);
    }

    public void containerOnTouchEvent(MotionEvent motionEvent, Object obj) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && !this.touchMoved) {
                this.touchMoveStartedX = motionEvent.getX();
                this.touchMoved = true;
                return;
            }
            return;
        }
        float x16 = motionEvent.getX();
        this.touchMoveEndedX = x16;
        this.touchMoved = false;
        float f16 = this.touchMoveStartedX;
        if (x16 > f16 && x16 - f16 > 7.0f) {
            this.moveDirection = 1;
            int i3 = this.currentSelectPaged;
            if (i3 == 0) {
                doFeedContainerScrollReport(obj, i3, 1);
                return;
            }
            return;
        }
        if (f16 <= x16 || f16 - x16 <= 7.0f) {
            return;
        }
        this.moveDirection = 2;
        if (this.isLeftScrollToEnd) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("feedReport", "feedContainer left scroll,and it is last,current selected = " + this.currentSelectPaged);
            }
            FeedActionRecorder.getInstance().addAction(getSelectFeedViewData(obj, this.currentSelectPaged), getContainerFeedPos(obj), System.currentTimeMillis(), 23, 21);
            FeedActionRecorder.getInstance().addAction(getSelectFeedViewData(obj, this.currentSelectPaged), getContainerFeedPos(obj), System.currentTimeMillis(), 26, 19, this.currentSelectPaged + 1);
        }
    }

    public void feedAdvContainerPageSelected(int i3, int i16, Object obj) {
        if (i3 == i16 - 1) {
            this.isLeftScrollToEnd = true;
            this.currentSelectPaged = i3;
        } else {
            this.currentSelectPaged = i3;
            this.isLeftScrollToEnd = false;
        }
        doFeedContainerScrollReport(obj, this.currentSelectPaged, this.moveDirection);
    }

    public void feedContainerOverScroll(int i3, int i16, boolean z16, boolean z17, int i17, Object obj) {
        if (z16 && i3 != 0) {
            this.isLeftScrollToEnd = true;
            this.currentSelectPaged = i17 - 1;
            return;
        }
        if (i3 != 0) {
            double d16 = i3;
            int i18 = AreaConst.SCREEN_WIDTH;
            if (d16 > i18 * 3.05d) {
                if (this.currentSelectPaged != 4) {
                    doFeedContainerScrollReport(obj, 4, this.moveDirection);
                }
                this.currentSelectPaged = 4;
            } else if (d16 > i18 * 2.2d) {
                if (this.currentSelectPaged != 3) {
                    doFeedContainerScrollReport(obj, 3, this.moveDirection);
                }
                this.currentSelectPaged = 3;
            } else if (d16 > i18 * 1.35d) {
                if (this.currentSelectPaged != 2) {
                    doFeedContainerScrollReport(obj, 2, this.moveDirection);
                }
                this.currentSelectPaged = 2;
            } else if (d16 > i18 * 0.5d) {
                if (this.currentSelectPaged != 1) {
                    doFeedContainerScrollReport(obj, 1, this.moveDirection);
                }
                this.currentSelectPaged = 1;
            } else {
                if (this.currentSelectPaged != 0) {
                    doFeedContainerScrollReport(obj, 0, this.moveDirection);
                }
                this.currentSelectPaged = 0;
            }
            this.isLeftScrollToEnd = false;
        }
    }
}
