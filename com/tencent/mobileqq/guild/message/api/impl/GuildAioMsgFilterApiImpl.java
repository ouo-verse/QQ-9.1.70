package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildAioMsgFilterApiImpl implements IGuildAioMsgFilterApi {
    private static final String TAG = "GuildAioMsgFilterApiImpl";
    private ConcurrentHashMap<String, IGuildAioMsgFilterApi.a> mLatestMsgSeqMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, IGuildAioMsgFilterApi.a> mCurAIOLatestMsgSeqMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, IGuildAioMsgFilterApi.a> mReadLatestMsgSeqMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, IGuildAioMsgFilterApi.a> mOnlinePushLatestMsgSeqMap = new ConcurrentHashMap<>();
    private boolean mIsOneClickJumpSuccess = false;
    private boolean mIsJumpToBottom = false;

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public IGuildAioMsgFilterApi.a getCurAioLatestMsgSeqItem(String str) {
        IGuildAioMsgFilterApi.a aVar;
        synchronized (this.mCurAIOLatestMsgSeqMap) {
            aVar = this.mCurAIOLatestMsgSeqMap.get(str);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public boolean getJumpToBottomStatus() {
        return this.mIsJumpToBottom;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public IGuildAioMsgFilterApi.a getLatestMsgSeqItem(String str) {
        IGuildAioMsgFilterApi.a aVar;
        synchronized (this.mLatestMsgSeqMap) {
            aVar = this.mLatestMsgSeqMap.get(str);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public IGuildAioMsgFilterApi.a getLatestOnlineMsgSeqItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mOnlinePushLatestMsgSeqMap) {
            if (!this.mOnlinePushLatestMsgSeqMap.containsKey(str)) {
                return null;
            }
            return this.mOnlinePushLatestMsgSeqMap.get(str);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public boolean getOneClickJumpSuccessStatus() {
        QLog.i(TAG, 1, "getOneClickJumpSuccessStatus, isSuccess = " + this.mIsOneClickJumpSuccess);
        return this.mIsOneClickJumpSuccess;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public IGuildAioMsgFilterApi.a getReadLatestMsgSeqItem(String str) {
        IGuildAioMsgFilterApi.a aVar;
        synchronized (this.mReadLatestMsgSeqMap) {
            aVar = this.mReadLatestMsgSeqMap.get(str);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public synchronized void resetCurAioLatestMsgSeqItem(String str) {
        this.mLatestMsgSeqMap.remove(str);
        this.mCurAIOLatestMsgSeqMap.remove(str);
        this.mReadLatestMsgSeqMap.remove(str);
        this.mIsOneClickJumpSuccess = false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void setJumpToBottomStatus(boolean z16) {
        this.mIsJumpToBottom = z16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void setOneClickJumpSuccessStatus(boolean z16) {
        QLog.i(TAG, 1, "setOneClickJumpSuccessStatus, isSuccess = " + z16);
        this.mIsOneClickJumpSuccess = z16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void updateCurAioLatestMsgSeqItem(String str, IGuildAioMsgFilterApi.a aVar, boolean z16) {
        QLog.i(TAG, 1, "updateCurAioLatestMsgSeqItem, msgSeqItem = " + aVar + ", channelId = " + str + ", bForce = " + z16 + ", mCurAIOLatestMsgSeqItem = " + this.mCurAIOLatestMsgSeqMap);
        if (!TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.mCurAIOLatestMsgSeqMap) {
                if (!this.mCurAIOLatestMsgSeqMap.containsKey(str) || aVar.f230115b >= this.mCurAIOLatestMsgSeqMap.get(str).f230115b || z16) {
                    this.mCurAIOLatestMsgSeqMap.put(str, aVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void updateLatestMsgSeqItem(String str, IGuildAioMsgFilterApi.a aVar, boolean z16) {
        QLog.i(TAG, 1, "updateLatestMsgSeqItem, msgSeqItem = " + aVar + ", channelId = " + str + ", bForce = " + z16 + ", mLatestMsgSeqItem = " + this.mLatestMsgSeqMap);
        if (!TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.mLatestMsgSeqMap) {
                if (!this.mLatestMsgSeqMap.containsKey(str) || aVar.f230115b >= this.mLatestMsgSeqMap.get(str).f230115b || z16) {
                    this.mLatestMsgSeqMap.put(str, aVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void updateLatestOnlineMsgMsgSeqItem(String str, IGuildAioMsgFilterApi.a aVar, boolean z16) {
        if (aVar != null && str != null) {
            synchronized (this.mOnlinePushLatestMsgSeqMap) {
                if (!this.mOnlinePushLatestMsgSeqMap.containsKey(str) || aVar.f230115b >= this.mOnlinePushLatestMsgSeqMap.get(str).f230115b || z16) {
                    this.mOnlinePushLatestMsgSeqMap.put(str, aVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi
    public void updateReadLatestMsgSeqItem(String str, IGuildAioMsgFilterApi.a aVar, boolean z16) {
        QLog.i(TAG, 1, "updateReadLatestMsgSeqItem, msgSeqItem = " + aVar + ", channelId = " + str + ", bForce = " + z16 + ", mReadLatestMsgSeqItem = " + this.mReadLatestMsgSeqMap);
        if (!TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.mReadLatestMsgSeqMap) {
                if (!this.mReadLatestMsgSeqMap.containsKey(str) || aVar.f230115b >= this.mReadLatestMsgSeqMap.get(str).f230115b || z16) {
                    this.mReadLatestMsgSeqMap.put(str, aVar);
                }
            }
        }
    }
}
