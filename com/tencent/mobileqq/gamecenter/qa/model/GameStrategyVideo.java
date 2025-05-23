package com.tencent.mobileqq.gamecenter.qa.model;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyVideo implements Serializable {
    private static final long serialVersionUID = 1;
    public int mCoverHeight;
    public String mCoverUrl;
    public int mCoverWidth;
    public long mDuration;
    public String mLocalPath;
    public String mVideoUrl;

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.mVideoUrl) && this.mDuration > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GameStrategyVideo{mVideoUrl='" + this.mVideoUrl + "', mDuration=" + this.mDuration + ", mCoverUrl='" + this.mCoverUrl + "', mCoverWidth=" + this.mCoverWidth + ", mCoverHeight=" + this.mCoverHeight + '}';
    }
}
