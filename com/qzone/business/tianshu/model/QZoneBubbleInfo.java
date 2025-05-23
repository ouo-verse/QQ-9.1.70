package com.qzone.business.tianshu.model;

import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneBubbleInfo extends TianShuInfo {
    private static final long serialVersionUID = -8089473082340748393L;
    private int adPostId;
    private String arrowUrl;
    private String backgroundUrl;
    private long endTime;

    /* renamed from: id, reason: collision with root package name */
    private String f44881id;
    private TianShuAccess.AdItem mAdItem;
    private String mDifferIconUrl;
    private boolean mIsShowArrow;
    private String mJumpUrl;
    private String mLeftImageUrl;
    private ArrayList<String> mLoopPicList;
    private final TianShuAccess.AdItem mOriginAdItem;
    private String mPublishTag;
    private String mPublishTagUin;
    private String mType;
    private int maxTimes;
    private long startTime;
    private String words;
    private boolean wordsIsTag;

    public QZoneBubbleInfo(TianShuAccess.AdItem adItem) {
        this.mOriginAdItem = adItem;
    }

    public TianShuAccess.AdItem getAdItem() {
        return this.mAdItem;
    }

    public int getAdPostId() {
        return this.adPostId;
    }

    public String getArrowUrl() {
        return this.arrowUrl;
    }

    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public String getDifferIcon() {
        return this.mDifferIconUrl;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.f44881id;
    }

    public String getJumpUrl() {
        return this.mJumpUrl;
    }

    public String getLeftImageUrl() {
        return this.mLeftImageUrl;
    }

    public ArrayList<String> getLoopPicList() {
        return this.mLoopPicList;
    }

    public int getMaxTimes() {
        return this.maxTimes;
    }

    public TianShuAccess.AdItem getOriginAdItem() {
        return this.mOriginAdItem;
    }

    public String getPublishTag() {
        return this.mPublishTag;
    }

    public String getPublishTagUin() {
        return this.mPublishTagUin;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getType() {
        return this.mType;
    }

    public String getWords() {
        return this.words;
    }

    public boolean isShowArrow() {
        return this.mIsShowArrow;
    }

    public void setAdItem(TianShuAccess.AdItem adItem) {
        this.mAdItem = adItem;
    }

    public void setAdPostId(int i3) {
        this.adPostId = i3;
    }

    public void setArrowUrl(String str) {
        this.arrowUrl = str;
    }

    public void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }

    public void setDifferIconUrl(String str) {
        this.mDifferIconUrl = str;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setId(String str) {
        this.f44881id = str;
    }

    public void setIsShowArrow(boolean z16) {
        this.mIsShowArrow = z16;
    }

    public void setJumpUrl(String str) {
        this.mJumpUrl = str;
    }

    public void setLeftImageUrl(String str) {
        this.mLeftImageUrl = str;
    }

    public void setLoopPicList(ArrayList<String> arrayList) {
        this.mLoopPicList = arrayList;
    }

    public void setMaxTimes(int i3) {
        this.maxTimes = i3;
    }

    public void setPublishTag(String str) {
        this.mPublishTag = str;
    }

    public void setPublishTagUin(String str) {
        this.mPublishTagUin = str;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setWords(String str) {
        this.words = str;
    }

    public void setWordsIsTag(boolean z16) {
        this.wordsIsTag = z16;
    }

    public String toString() {
        return "QZoneBubbleInfo{id='" + this.f44881id + "', adId='" + this.adPostId + "', words='" + this.words + "', maxTimes=" + this.maxTimes + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", arrowUrl='" + this.arrowUrl + "', backgroundUrl='" + this.backgroundUrl + "', wordsIsTag=" + this.wordsIsTag + ", posId=" + this.posId + ", traceInfo='" + this.traceInfo + "', timeStamp=" + this.timeStamp + ", mLeftImageUrl=" + this.mLeftImageUrl + '}';
    }

    public boolean wordsIsTag() {
        return this.wordsIsTag;
    }
}
