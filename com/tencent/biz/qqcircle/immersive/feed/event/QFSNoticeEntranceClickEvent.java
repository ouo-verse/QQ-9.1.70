package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNoticeEntranceClickEvent extends SimpleBaseEvent {
    private final int mActivityHashCode;
    private FeedCloudCommon$StCommonExt mStCommonExt;
    private final WeakReference<View> mWeakClickView;

    public QFSNoticeEntranceClickEvent(View view, int i3) {
        this.mWeakClickView = new WeakReference<>(view);
        this.mActivityHashCode = i3;
    }

    public int getActivityHashCode() {
        return this.mActivityHashCode;
    }

    public View getClickView() {
        return this.mWeakClickView.get();
    }

    public FeedCloudCommon$StCommonExt getStCommonExt() {
        return this.mStCommonExt;
    }

    public void setStCommonExt(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        this.mStCommonExt = feedCloudCommon$StCommonExt;
    }
}
