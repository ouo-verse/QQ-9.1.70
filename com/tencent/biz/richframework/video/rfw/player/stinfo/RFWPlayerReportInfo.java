package com.tencent.biz.richframework.video.rfw.player.stinfo;

import java.util.HashMap;

/* loaded from: classes5.dex */
public class RFWPlayerReportInfo<T> {
    private int mDuration;
    private String mFeedId;
    private int mFileSize;
    private T mOriginBusinessData;
    private HashMap<String, String> mReportElement = new HashMap<>();
    private String mTraceId;
    private String mVideoId;

    public RFWPlayerReportInfo(T t16) {
        this.mOriginBusinessData = t16;
    }

    public RFWPlayerReportInfo<T> addReportElement(String str, String str2) {
        this.mReportElement.put(str, str2);
        return this;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public T getOriginBusinessData() {
        return this.mOriginBusinessData;
    }

    public HashMap<String, String> getReportElement() {
        return this.mReportElement;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public RFWPlayerReportInfo<T> setDuration(int i3) {
        this.mDuration = i3;
        return this;
    }

    public RFWPlayerReportInfo<T> setFeedId(String str) {
        this.mFeedId = str;
        return this;
    }

    public RFWPlayerReportInfo<T> setFileSize(int i3) {
        this.mFileSize = i3;
        return this;
    }

    public RFWPlayerReportInfo<T> setTraceId(String str) {
        this.mTraceId = str;
        return this;
    }

    public RFWPlayerReportInfo<T> setVideoId(String str) {
        this.mVideoId = str;
        return this;
    }
}
