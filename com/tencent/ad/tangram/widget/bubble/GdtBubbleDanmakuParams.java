package com.tencent.ad.tangram.widget.bubble;

import java.util.List;

/* loaded from: classes3.dex */
public final class GdtBubbleDanmakuParams {
    private int mBubbleItemCount;
    private List<String> mContents;
    private int mMotionLengthDp;

    public int getBubbleItemCount() {
        return this.mBubbleItemCount;
    }

    public List<String> getContents() {
        return this.mContents;
    }

    public int getMotionLengthDp() {
        return this.mMotionLengthDp;
    }

    public boolean isValid() {
        if (getBubbleItemCount() > 0 && getMotionLengthDp() > 0 && getContents() != null && getContents().size() > 0) {
            return true;
        }
        return false;
    }

    public void setBubbleItemCount(int i3) {
        this.mBubbleItemCount = i3;
    }

    public void setContents(List<String> list) {
        this.mContents = list;
    }

    public void setMotionLengthDp(int i3) {
        this.mMotionLengthDp = i3;
    }
}
