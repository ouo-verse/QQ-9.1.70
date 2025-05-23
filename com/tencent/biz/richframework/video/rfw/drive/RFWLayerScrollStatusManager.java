package com.tencent.biz.richframework.video.rfw.drive;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWScrollerReNotifyResumeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLayerScrollStatusManager extends RFWBaseScrollStatusManager implements SimpleEventReceiver {
    boolean isScrollDraw;
    private final ViewPager2.OnPageChangeCallback mCallBack;
    private int mExportPosition;
    private final ViewPager2 mViewPage2;

    public RFWLayerScrollStatusManager(String str, ViewPager2 viewPager2) {
        super(str, (IRFWViewPager2AdapterDrive) viewPager2.getAdapter());
        this.mExportPosition = 0;
        this.isScrollDraw = false;
        this.mViewPage2 = viewPager2;
        ViewPager2.OnPageChangeCallback callback = getCallback();
        this.mCallBack = callback;
        viewPager2.registerOnPageChangeCallback(callback);
        if (!(viewPager2.getAdapter() instanceof IRFWViewPager2AdapterDrive) && AppSetting.isDebugVersion()) {
            throw new RuntimeException("you adapter must implement IRFWPagerAdapter ");
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void fixAttachToWindowSelected(RecyclerView.ViewHolder viewHolder) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_selected_when_attach", true) && getTargetItemPosition() == viewHolder.getAdapterPosition()) {
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle addViewHolder hit target , try faster dispatch:" + viewHolder.hashCode());
            notifyItemViewOnFeedSelected(new RFWFeedSelectInfo(viewHolder.getAdapterPosition()).setSelectedType("TYPE_SELECT_ADAPTER_BIND_HOLDER"), viewHolder);
        }
    }

    @NonNull
    private ViewPager2.OnPageChangeCallback getCallback() {
        return new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.biz.richframework.video.rfw.drive.RFWLayerScrollStatusManager.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                super.onPageScrollStateChanged(i3);
                if (i3 == 0) {
                    RFWLayerScrollStatusManager.this.onPageScrollStateIdle();
                }
                RFWLayerScrollStatusManager.this.handlerPageScrollStateChanged(i3);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i3, float f16, int i16) {
                super.onPageScrolled(i3, f16, i16);
                RFWLayerScrollStatusManager.this.onFeedPageScrolled(i3, f16, i16);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                super.onPageSelected(i3);
                RFWLayerScrollStatusManager.this.pageContainerOnPageSelected(i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerPageScrollStateChanged(int i3) {
        if (i3 == 1) {
            this.isScrollDraw = true;
        } else if (i3 == 0 || i3 == 2) {
            this.isScrollDraw = false;
        }
    }

    private void handlerPageScrolledWithSelectedPos(int i3, float f16, int i16) {
        boolean z16;
        int i17;
        if (i16 > 1 && this.isScrollDraw) {
            if (f16 <= 0.5f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i17 = this.mCurrentFeedPos + 1;
            } else {
                i17 = this.mCurrentFeedPos - 1;
            }
            if (this.mExportPosition != i17) {
                notifyItemLoadFeedExport(i17);
                this.mExportPosition = i17;
            }
        }
    }

    private void notifyItemLoadFeedExport(int i3) {
        IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive;
        int size;
        if (this.mExportPosition != i3 && (iRFWViewPager2AdapterDrive = this.mAdapter) != null) {
            List dataList = iRFWViewPager2AdapterDrive.getDataList();
            if (dataList == null) {
                size = 0;
            } else {
                size = dataList.size();
            }
            int min = Math.min(Math.max(i3, 0), size - 1);
            RecyclerView.ViewHolder finViewHolderByPos = this.mAdapter.finViewHolderByPos(min);
            if (finViewHolderByPos == null) {
                return;
            }
            KeyEvent.Callback callback = finViewHolderByPos.itemView;
            if (callback instanceof IRFWLayerScrollerStatus) {
                ((IRFWLayerScrollerStatus) callback).onLoadFeedExport(min, this.mCurrentFeedPos);
            }
        }
    }

    private void notifyPageScrolledWithSelectedPos(int i3, float f16, int i16) {
        Iterator<RFWLayerBaseScroller> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            it.next().notifyPageScrolledWithSelectedPos(i3, f16, i16, this.mCurrentFeedPos);
        }
    }

    private void notifyScrollIdle() {
        Iterator<RFWLayerBaseScroller> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            it.next().notifyIdle(this.mCurrentFeedPos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageScrollStateIdle() {
        RecyclerView.ViewHolder viewHolder = getViewHolder(this.mCurrentFeedPos);
        if (viewHolder != null) {
            KeyEvent.Callback callback = viewHolder.itemView;
            if (callback instanceof IRFWLayerScrollerStatus) {
                ((IRFWLayerScrollerStatus) callback).onPageScrolledIdle(this.mCurrentFeedPos);
            }
        }
        notifyScrollIdle();
    }

    private void reNotifyResume() {
        IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive = this.mAdapter;
        if (iRFWViewPager2AdapterDrive != null && iRFWViewPager2AdapterDrive.getHostFragment() != null) {
            if (!this.mAdapter.getHostFragment().isResumed()) {
                RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, RFWLog.USR, "reNotifyResume not resume status");
                return;
            }
            RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, RFWLog.USR, "reNotifyResume notify resume");
            onResumed(new RFWFeedSelectInfo(this.mCurrentFeedPos).setSelectedType("TYPE_RE_ON_RESUME"));
            return;
        }
        RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, RFWLog.USR, "reNotifyResume error return");
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager
    public void addViewHolder(RecyclerView.ViewHolder viewHolder) {
        super.addViewHolder(viewHolder);
        fixAttachToWindowSelected(viewHolder);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWScrollerReNotifyResumeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager
    public int getTargetItemPosition() {
        ViewPager2 viewPager2 = this.mViewPage2;
        if (viewPager2 == null) {
            return 0;
        }
        return viewPager2.getCurrentItem();
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        super.onDestroy();
        ViewPager2 viewPager2 = this.mViewPage2;
        if (viewPager2 != null && (onPageChangeCallback = this.mCallBack) != null) {
            viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedPageScrolled(int i3, float f16, int i16) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.getAdapterPosition() == i3) {
                    KeyEvent.Callback callback = next.itemView;
                    if (callback instanceof IRFWLayerScrollerStatus) {
                        ((IRFWLayerScrollerStatus) callback).onFeedPageScrolled(i3, f16, i16);
                    }
                    Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
                    while (it5.hasNext()) {
                        it5.next().onPageScrolled(i3, f16, i16);
                    }
                }
            }
            notifyPageScrolledWithSelectedPos(i3, f16, i16);
            handlerPageScrolledWithSelectedPos(i3, f16, i16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWScrollerReNotifyResumeEvent) {
            reNotifyResume();
        }
    }

    protected void pageContainerOnPageSelected(int i3) {
        boolean z16;
        QLog.d("RFWBaseScrollStatusManager", 2, "fs_lifecycle mLayerPageContainer onPageSelected  position = " + i3 + " , mCurrentFeedPos = " + this.mCurrentFeedPos);
        int i16 = this.mCurrentFeedPos;
        if (i16 != -1 && i16 != i3) {
            notifyAdapterOnUnselected(i16, i3);
        }
        if (i3 > this.mCurrentFeedPos) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mCurrentFeedPos = i3;
        notifyAdapterOnSelected(i3, "TYPE_SELECT_NORMAL", z16);
    }
}
