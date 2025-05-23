package com.tencent.biz.qqcircle.picload.avatar;

import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes4.dex */
public class AvatarOption extends Option {
    private long mTimeStamp;
    private String mUin;
    private QCircleAvatarUrlListener mUrlListener;

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getUin() {
        return this.mUin;
    }

    public QCircleAvatarUrlListener getUrlListener() {
        return this.mUrlListener;
    }

    public AvatarOption setTimeStamp(long j3) {
        this.mTimeStamp = j3;
        return this;
    }

    public AvatarOption setUin(String str) {
        this.mUin = str;
        return this;
    }

    public AvatarOption setUrlListener(QCircleAvatarUrlListener qCircleAvatarUrlListener) {
        this.mUrlListener = qCircleAvatarUrlListener;
        return this;
    }
}
