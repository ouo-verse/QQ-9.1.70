package com.tencent.mobileqq.guild.feed.publish.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "mMainTaskId,mTaskId,mUploadTaskId,mClientKey,mState,mPath,mProgress,mErrCode,mErrMsg,mType,mPicId,mVideoId,mCoverUrl, mOriginalPic, mIsGif, mIsUndo")
/* loaded from: classes13.dex */
public class GuildMediaProgressState extends Entity implements Serializable, Cloneable {

    @notColumn
    public static final String TYPE_PIC = "pic";

    @notColumn
    public static final String TYPE_VIDEO = "video";
    public String mClientKey;
    public String mCoverUrl;
    public int mErrCode;
    public String mErrMsg;
    public String mMainTaskId;
    public String mPath;
    public String mPicId;
    public int mProgress;
    public int mState;

    @unique
    public String mTaskId;
    public String mType;
    public long mUploadTaskId;
    public String mVideoId;
    public int mOriginalPic = 0;
    public int mIsGif = 0;
    public int mIsUndo = 0;

    @notColumn
    public long mLastUpdateTimestamp = System.currentTimeMillis();

    public GuildMediaProgressState() {
    }

    public String getClientKey() {
        return this.mClientKey;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public int getIsUndo() {
        return this.mIsUndo;
    }

    public long getLastUpdateTimestamp() {
        return this.mLastUpdateTimestamp;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getPicId() {
        return this.mPicId;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getState() {
        return this.mState;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    public String getType() {
        return this.mType;
    }

    public long getUploadTaskId() {
        return this.mUploadTaskId;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public int isOriginalPic() {
        return this.mOriginalPic;
    }

    public void setClientKey(String str) {
        this.mClientKey = str;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setErrCode(int i3) {
        this.mErrCode = i3;
    }

    public void setErrMsg(String str) {
        this.mErrMsg = str;
    }

    public void setIsUndo(int i3) {
        this.mIsUndo = i3;
    }

    public void setLastUpdateTimestamp(long j3) {
        this.mLastUpdateTimestamp = j3;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setOriginalPic(int i3) {
        this.mOriginalPic = i3;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setPicId(String str) {
        this.mPicId = str;
    }

    public void setProgress(int i3) {
        this.mProgress = i3;
    }

    public void setState(int i3) {
        this.mState = i3;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setUploadTaskId(long j3) {
        this.mUploadTaskId = j3;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public String toString() {
        return "GuildMediaProgressState{mMainTaskId='" + this.mMainTaskId + "', mTaskId='" + this.mTaskId + "', mUploadTaskId=" + this.mUploadTaskId + ", mClientKey='" + this.mClientKey + "', mState=" + this.mState + ", mPath='" + this.mPath + "', mProgress=" + this.mProgress + ", mErrCode=" + this.mErrCode + ", mErrMsg='" + this.mErrMsg + "', mType='" + this.mType + "', mPicId='" + this.mPicId + "', mVideoId='" + this.mVideoId + "', mCoverUrl='" + this.mCoverUrl + "', mLastTimestamp=" + this.mLastUpdateTimestamp + ", mOriginalPic=" + this.mOriginalPic + ", mIsGif=" + this.mIsGif + ", misUndo=" + this.mIsUndo + "} " + super.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GuildMediaProgressState m183clone() {
        GuildMediaProgressState guildMediaProgressState = new GuildMediaProgressState();
        guildMediaProgressState.mMainTaskId = this.mMainTaskId;
        guildMediaProgressState.mTaskId = this.mTaskId;
        guildMediaProgressState.mUploadTaskId = this.mUploadTaskId;
        guildMediaProgressState.mClientKey = this.mClientKey;
        guildMediaProgressState.mState = this.mState;
        guildMediaProgressState.mPath = TextUtils.isEmpty(this.mPath) ? "" : this.mPath;
        guildMediaProgressState.mProgress = this.mProgress;
        guildMediaProgressState.mErrCode = this.mErrCode;
        guildMediaProgressState.mErrMsg = this.mErrMsg;
        guildMediaProgressState.mType = this.mType;
        guildMediaProgressState.mPicId = this.mPicId;
        guildMediaProgressState.mVideoId = this.mVideoId;
        guildMediaProgressState.mCoverUrl = this.mCoverUrl;
        guildMediaProgressState.mOriginalPic = this.mOriginalPic;
        guildMediaProgressState.mIsGif = this.mIsGif;
        guildMediaProgressState.mIsUndo = this.mIsUndo;
        return guildMediaProgressState;
    }

    public GuildMediaProgressState(String str) {
        this.mTaskId = str;
    }
}
