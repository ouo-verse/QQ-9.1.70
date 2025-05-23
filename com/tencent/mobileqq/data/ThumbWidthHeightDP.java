package com.tencent.mobileqq.data;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes10.dex */
public class ThumbWidthHeightDP {
    public boolean mLimitSizeByGuild;
    public boolean mLimitSizeByServer;
    public int mMaxHeight;
    public int mMaxWidth;
    public int mMinHeight;
    public int mMinWidth;

    public ThumbWidthHeightDP(int i3, int i16, int i17, int i18) {
        this(i3, i16, i17, i18, false);
    }

    public int maxPx() {
        return Utils.n((this.mMaxWidth + this.mMaxHeight) / 2, BaseApplication.getContext().getResources());
    }

    public int minPx() {
        return Utils.n((this.mMinWidth + this.mMinHeight) / 2, BaseApplication.getContext().getResources());
    }

    public void setmLimitSizeByGuild(boolean z16) {
        this.mLimitSizeByGuild = z16;
    }

    public String toString() {
        return this.mMinWidth + ", " + this.mMinHeight + ", " + this.mMaxWidth + ", " + this.mMaxHeight;
    }

    public boolean useCustomSize() {
        if (this.mMinWidth != 0 && this.mMinHeight != 0 && this.mMaxWidth != 0 && this.mMaxHeight != 0) {
            return true;
        }
        return false;
    }

    public ThumbWidthHeightDP(int i3, int i16, int i17, int i18, boolean z16) {
        this.mMinWidth = i3;
        this.mMinHeight = i16;
        this.mMaxWidth = i17;
        this.mMaxHeight = i18;
        this.mLimitSizeByServer = z16;
    }
}
