package com.tencent.mobileqq.winkpublish.event;

import NS_MOBILE_OPERATION.MediaInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;

/* compiled from: P */
@PluginInterface
/* loaded from: classes21.dex */
public class GuildUploadStateEvent extends SimpleBaseEvent {
    private long mBatchId;
    private boolean mByUser;
    private String mClientKey;
    private MediaInfo mMediaInfo;
    private String mMissionId;
    private long mResultCode;
    private String mResultMsg;
    private int mState;
    private long mTaskId;
    private ShuoshuoVideoInfo mVideoInfo;

    public long getBatchId() {
        return this.mBatchId;
    }

    public String getClientKey() {
        return this.mClientKey;
    }

    public MediaInfo getMediaInfo() {
        return this.mMediaInfo;
    }

    public String getMissionId() {
        return this.mMissionId;
    }

    public long getResultCode() {
        return this.mResultCode;
    }

    public String getResultMsg() {
        return this.mResultMsg;
    }

    public int getState() {
        return this.mState;
    }

    public long getTaskId() {
        return this.mTaskId;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isByUser() {
        return this.mByUser;
    }

    public boolean isUploading() {
        int i3 = this.mState;
        if (i3 == 0 || i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public void setBatchId(long j3) {
        this.mBatchId = j3;
    }

    public void setByUser(boolean z16) {
        this.mByUser = z16;
    }

    public void setClientKey(String str) {
        this.mClientKey = str;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mMediaInfo = mediaInfo;
    }

    public void setMissionId(String str) {
        this.mMissionId = str;
    }

    public void setResultCode(long j3) {
        this.mResultCode = j3;
    }

    public void setResultMsg(String str) {
        this.mResultMsg = str;
    }

    public void setState(int i3) {
        this.mState = i3;
    }

    public void setTaskId(long j3) {
        this.mTaskId = j3;
    }

    public void setVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        this.mVideoInfo = shuoshuoVideoInfo;
    }

    public String toString() {
        return "GuildUploadStateEvent{mTaskId=" + this.mTaskId + ", mState=" + this.mState + ", mBatchId=" + this.mBatchId + ", mMissionId='" + this.mMissionId + "', mClientKey='" + this.mClientKey + "', mResultCode=" + this.mResultCode + ", mResultMsg='" + this.mResultMsg + "', mByUser=" + this.mByUser + ", mVideoInfo=" + this.mVideoInfo + ", mMediaInfo=" + this.mMediaInfo + '}';
    }
}
