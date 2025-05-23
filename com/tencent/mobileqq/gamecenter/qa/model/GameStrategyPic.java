package com.tencent.mobileqq.gamecenter.qa.model;

import android.text.TextUtils;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes12.dex */
public class GameStrategyPic implements Serializable {
    private static final long serialVersionUID = 1;
    public int mHeight;
    public String mLocalPath;
    public String mUrl;
    public int mWidth;

    public boolean isCoverValid() {
        if ((!TextUtils.isEmpty(this.mLocalPath) && new File(this.mLocalPath).exists()) || !TextUtils.isEmpty(this.mUrl)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GameStrategyPic{mUrl='" + this.mUrl + "', mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
    }
}
