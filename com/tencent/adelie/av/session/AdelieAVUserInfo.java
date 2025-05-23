package com.tencent.adelie.av.session;

import com.tencent.qav.QavDef$MultiUserInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVUserInfo extends QavDef$MultiUserInfo {
    public int mAudioEnergy;
    public boolean mIsSelf;
    public boolean mIsSpeaking;
    public boolean mVideoOn = false;
    public int mVideoSrc = 0;
    public boolean mBigVideo = false;
    public long mVideoTime = 0;
    public boolean mSubVideoOn = false;
    public int mSubVideoSrc = 0;
    public long mSubVideoTime = 0;
    public long mEnterTime = 0;
    public int mVolumeValue = 0;

    public AdelieAVUserInfo(QavDef$MultiUserInfo qavDef$MultiUserInfo, long j3) {
        long j16 = qavDef$MultiUserInfo.mUin;
        this.mUin = j16;
        this.mOpenId = qavDef$MultiUserInfo.mOpenId;
        this.mMicOn = qavDef$MultiUserInfo.mMicOn;
        this.mIsSelf = j3 == j16;
    }

    public boolean hasCameraVideo() {
        return this.mVideoOn;
    }

    public boolean hasSubVideo() {
        return this.mSubVideoOn;
    }

    public boolean hasVideo() {
        return this.mVideoOn || this.mSubVideoOn;
    }

    @Override // com.tencent.qav.QavDef$MultiUserInfo
    public String toString() {
        return "AdelieAVUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + "', mMicOn=" + this.mMicOn + ", mVideoOn=" + this.mVideoOn + ", mSubVideoOn=" + this.mSubVideoOn + ", mAudioEnergy=" + this.mAudioEnergy + '}';
    }
}
