package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSRedPointTipsEvent extends SimpleBaseEvent {
    private boolean mIsShow;
    private int mLeftMargin;
    private List<String> mSenderList;
    private String mTipsText;

    public QFSRedPointTipsEvent(List<String> list, String str, int i3, boolean z16) {
        this.mSenderList = list;
        this.mTipsText = str;
        this.mLeftMargin = i3;
        this.mIsShow = z16;
    }

    public int getLeftMargin() {
        return this.mLeftMargin;
    }

    public List<String> getSenderList() {
        return this.mSenderList;
    }

    public String getTipsText() {
        return this.mTipsText;
    }

    public boolean isShow() {
        return this.mIsShow;
    }
}
