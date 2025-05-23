package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StBarrage;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetBarrageEvent extends SimpleBaseEvent {
    private boolean isLoadMore;
    private boolean isLoadSuccess;
    private List<FeedCloudMeta$StBarrage> mBarrageList;
    private String mErrMsg;
    private String mFeedId;
    private boolean mIsFinish;
    private long mPlayTime;
    private long mRetCode;
    private int mStartIndex;
    private int mTotal;

    public static QFSGetBarrageEvent build() {
        return new QFSGetBarrageEvent();
    }

    public long getAttachInfo() {
        return this.mPlayTime;
    }

    public List<FeedCloudMeta$StBarrage> getBarrageList() {
        return this.mBarrageList;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean getIsFinish() {
        return this.mIsFinish;
    }

    public long getRetCode() {
        return this.mRetCode;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotal() {
        return this.mTotal;
    }

    public boolean isLoadMore() {
        return this.isLoadMore;
    }

    public boolean isLoadSuccess() {
        return this.isLoadSuccess;
    }

    public QFSGetBarrageEvent setAttachInfo(long j3) {
        this.mPlayTime = j3;
        return this;
    }

    public QFSGetBarrageEvent setBarrageList(List<FeedCloudMeta$StBarrage> list) {
        this.mBarrageList = list;
        return this;
    }

    public QFSGetBarrageEvent setErrMsg(String str) {
        this.mErrMsg = str;
        return this;
    }

    public QFSGetBarrageEvent setFeedId(String str) {
        this.mFeedId = str;
        return this;
    }

    public QFSGetBarrageEvent setIsFinish(boolean z16) {
        this.mIsFinish = z16;
        return this;
    }

    public QFSGetBarrageEvent setLoadMore(boolean z16) {
        this.isLoadMore = z16;
        return this;
    }

    public QFSGetBarrageEvent setLoadSuccess(boolean z16) {
        this.isLoadSuccess = z16;
        return this;
    }

    public QFSGetBarrageEvent setRetCode(long j3) {
        this.mRetCode = j3;
        return this;
    }

    public QFSGetBarrageEvent setStartIndex(int i3) {
        this.mStartIndex = i3;
        return this;
    }

    public QFSGetBarrageEvent setTotal(int i3) {
        this.mTotal = i3;
        return this;
    }
}
