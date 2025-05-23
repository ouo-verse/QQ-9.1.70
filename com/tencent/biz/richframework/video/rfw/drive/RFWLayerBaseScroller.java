package com.tencent.biz.richframework.video.rfw.drive;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLayerBaseScroller {
    protected HashSet<RecyclerView.ViewHolder> mHolderSet;

    public boolean needReceiveSelectedAnyWay() {
        return false;
    }

    public void onDestroy() {
        this.mHolderSet = null;
    }

    public void setHolderSet(HashSet<RecyclerView.ViewHolder> hashSet) {
        this.mHolderSet = hashSet;
    }

    public void onDataRefresh() {
    }

    public void notifyIdle(int i3) {
    }

    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    public void onSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
    }

    public void onUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
    }

    public void onPageScrolled(int i3, float f16, int i16) {
    }

    public void notifyPageScrolledWithSelectedPos(int i3, float f16, int i16, int i17) {
    }
}
