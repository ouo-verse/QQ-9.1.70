package com.qzone.homepage.diy.preload;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class DIYPreloadData implements SmartParcelable {

    @NeedParcel
    public String mImageUrl;

    @NeedParcel
    public boolean mIsVideo;

    @NeedParcel
    public String mVideoFrameUrl;

    @NeedParcel
    public String mVideoUrl;

    public boolean isParseData() {
        if (this.mIsVideo) {
            return (TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mVideoFrameUrl)) ? false : true;
        }
        return !TextUtils.isEmpty(this.mImageUrl);
    }

    public String toString() {
        return " mIsVideo = " + this.mIsVideo + " mVideoUrl = " + this.mVideoUrl + " mVideoFrameUrl= " + this.mVideoFrameUrl + " mImageUrl = " + this.mImageUrl;
    }
}
