package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomDynamicGuideEvent extends SimpleBaseEvent {
    public static final int DYNAMIC_GUIDE_BUTTON_TYPE = 392;
    public static final int DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE = 393;
    private int mDynamicGuideType;
    private boolean mIsShowGuide;
    private String mTargetFeedId;

    public QFSBottomDynamicGuideEvent(String str, int i3, boolean z16) {
        this.mTargetFeedId = str;
        this.mDynamicGuideType = i3;
        this.mIsShowGuide = z16;
    }

    public int getDynamicGuideType() {
        return this.mDynamicGuideType;
    }

    public String getTargetFeedId() {
        return this.mTargetFeedId;
    }

    public boolean isShowGuide() {
        return this.mIsShowGuide;
    }
}
