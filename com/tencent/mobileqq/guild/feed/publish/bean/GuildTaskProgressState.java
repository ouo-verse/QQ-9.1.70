package com.tencent.mobileqq.guild.feed.publish.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jn1.b;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "mTaskId,mState,mProgress,mGuildId,mChannelId,mUin,mFakePublishProgress,mPublishErrCode,mPublishErrMsg,mIsTriggerPublish,mIsTriggerSave,mJson,mUpdateTime,mIsEdit")
/* loaded from: classes13.dex */
public class GuildTaskProgressState extends Entity implements Serializable, Cloneable {
    public static final String TABLE_NAME = "GuildTaskProgressStatev1";
    private static final String TAG = "GuildTaskProgressState";
    public int mBusinessType;
    public String mChannelId;
    public int mFakePublishProgress;
    public String mGuildId;
    public boolean mIsEdit;
    public boolean mIsTriggerPublish;
    public boolean mIsTriggerSave;
    public String mJson;
    public int mProgress;
    public long mPublishErrCode;
    public String mPublishErrMsg;
    public GuildFeedReportSourceInfo mReportMap;
    public int mState;

    @unique
    public String mTaskId;
    public long mTriggerPublishTimeNs;
    public String mUin;
    public long mUpdateTime;

    @notColumn
    private List<GuildMediaProgressState> mMediaProgressStates = new CopyOnWriteArrayList();
    public int mScope = 0;

    public GuildTaskProgressState() {
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public int getFakePublishProgress() {
        return this.mFakePublishProgress;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getJson() {
        return this.mJson;
    }

    public int getMainState() {
        return this.mState;
    }

    public String getMainTaskId() {
        return this.mTaskId;
    }

    public List<GuildMediaProgressState> getMediaProgressStates() {
        if (this.mMediaProgressStates == null) {
            this.mMediaProgressStates = new CopyOnWriteArrayList();
        }
        return this.mMediaProgressStates;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public long getPublishErrCode() {
        return this.mPublishErrCode;
    }

    public String getPublishErrMsg() {
        return this.mPublishErrMsg;
    }

    public int getScope() {
        return this.mScope;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return TABLE_NAME;
    }

    public long getTriggerPublishTimeNs() {
        return this.mTriggerPublishTimeNs;
    }

    public String getUin() {
        return this.mUin;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public boolean isEdit() {
        return this.mIsEdit;
    }

    public boolean isSubMediaTaskListValid() {
        b bVar;
        if (TextUtils.isEmpty(this.mJson)) {
            return true;
        }
        try {
            bVar = (b) new Gson().fromJson(this.mJson, b.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isSubMediaTaskListValid error", e16);
            bVar = null;
        }
        if (bVar != null && !bl.b(bVar.taskIds)) {
            if (bVar.taskIds.size() == this.mMediaProgressStates.size()) {
                return true;
            }
            return false;
        }
        QLog.d(TAG, 1, "TaskId: " + this.mTaskId + " jsBean is null, so return true");
        return true;
    }

    public boolean isTriggerPublish() {
        return this.mIsTriggerPublish;
    }

    public boolean isTriggerSave() {
        return this.mIsTriggerSave;
    }

    public void setBusinessType(int i3) {
        this.mBusinessType = i3;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setEdit(boolean z16) {
        this.mIsEdit = z16;
    }

    public void setExtra(GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        this.mReportMap = guildFeedReportSourceInfo;
    }

    public void setFakePublishProgress(int i3) {
        this.mFakePublishProgress = i3;
    }

    public void setGuildId(String str) {
        this.mGuildId = str;
    }

    public void setJson(String str) {
        this.mJson = str;
    }

    public void setMainState(int i3) {
        this.mState = i3;
    }

    public void setMainTaskId(String str) {
        this.mTaskId = str;
    }

    public void setMediaProgressStates(List<GuildMediaProgressState> list) {
        if (list == null) {
            this.mMediaProgressStates = new CopyOnWriteArrayList();
        } else {
            this.mMediaProgressStates = new CopyOnWriteArrayList(list);
        }
    }

    public void setProgress(int i3) {
        this.mProgress = i3;
    }

    public void setPublishErrCode(long j3) {
        this.mPublishErrCode = j3;
    }

    public void setPublishErrMsg(String str) {
        this.mPublishErrMsg = str;
    }

    public void setTriggerPublish(boolean z16) {
        this.mIsTriggerPublish = z16;
    }

    public void setTriggerPublishTimeNs(long j3) {
        this.mTriggerPublishTimeNs = j3;
    }

    public void setTriggerSave(boolean z16) {
        this.mIsTriggerSave = z16;
    }

    public void setUin(String str) {
        this.mUin = str;
    }

    public void setUpdateTime(long j3) {
        this.mUpdateTime = j3;
    }

    public String toString() {
        return "GuildTaskProgressState{mMainTaskId='" + this.mTaskId + "', mMainState=" + this.mState + ", mProgress=" + this.mProgress + ", mGuildId='" + this.mGuildId + "', mChannelId='" + this.mChannelId + "', mUin='" + this.mUin + "', mFakePublishProgress=" + this.mFakePublishProgress + ", mPublishErrCode=" + this.mPublishErrCode + ", mPublishErrMsg='" + this.mPublishErrMsg + "', mIsTriggerPublish=" + this.mIsTriggerPublish + ", mIsTriggerSave=" + this.mIsTriggerSave + ", mIsEdit=" + this.mIsEdit + ", mUpdateTime=" + this.mUpdateTime + ", mMediaProgressStates=" + this.mMediaProgressStates + ", mBusinessType=" + this.mBusinessType + ", mReportMap=" + this.mReportMap + ", mScope=" + this.mScope + ", mTriggerPublishTimeNs=" + this.mTriggerPublishTimeNs + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GuildTaskProgressState m184clone() {
        GuildTaskProgressState guildTaskProgressState = new GuildTaskProgressState();
        guildTaskProgressState.mTaskId = this.mTaskId;
        guildTaskProgressState.mState = this.mState;
        guildTaskProgressState.mProgress = this.mProgress;
        guildTaskProgressState.mGuildId = this.mGuildId;
        guildTaskProgressState.mChannelId = this.mChannelId;
        guildTaskProgressState.mUin = this.mUin;
        Iterator<GuildMediaProgressState> it = this.mMediaProgressStates.iterator();
        while (it.hasNext()) {
            guildTaskProgressState.mMediaProgressStates.add(it.next().m183clone());
        }
        guildTaskProgressState.mFakePublishProgress = this.mFakePublishProgress;
        guildTaskProgressState.mPublishErrCode = this.mPublishErrCode;
        guildTaskProgressState.mPublishErrMsg = this.mPublishErrMsg;
        guildTaskProgressState.mIsTriggerPublish = this.mIsTriggerPublish;
        guildTaskProgressState.mIsTriggerSave = this.mIsTriggerSave;
        guildTaskProgressState.mJson = this.mJson;
        guildTaskProgressState.mUpdateTime = this.mUpdateTime;
        guildTaskProgressState.mIsEdit = this.mIsEdit;
        guildTaskProgressState.mBusinessType = this.mBusinessType;
        guildTaskProgressState.mReportMap = this.mReportMap;
        guildTaskProgressState.mScope = this.mScope;
        guildTaskProgressState.mTriggerPublishTimeNs = this.mTriggerPublishTimeNs;
        return guildTaskProgressState;
    }

    public GuildTaskProgressState(String str) {
        this.mTaskId = str;
    }
}
