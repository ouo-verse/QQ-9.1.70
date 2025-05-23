package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.tvideo.pullqqlive.h;
import java.util.Map;
import tvideo.Video;

/* loaded from: classes19.dex */
public class QFSTVideoPageWebViewShowEvent extends SimpleBaseEvent {
    private String callAppTest;
    private boolean isFromAuthPay;
    private boolean needInterceptVideo;
    private Map<String, ?> paramsMap;
    private String url;
    private Video videoFeed;
    private String word;

    public QFSTVideoPageWebViewShowEvent() {
        String str;
        if (h.f()) {
            str = "1";
        } else {
            str = "0";
        }
        this.callAppTest = str;
    }

    public String getAppCallTest() {
        return this.callAppTest;
    }

    public Map<String, ?> getParamsMap() {
        return this.paramsMap;
    }

    public String getUrl() {
        return this.url;
    }

    public Video getVideoFeed() {
        return this.videoFeed;
    }

    public String getWord() {
        return this.word;
    }

    public boolean isFromAuthPay() {
        return this.isFromAuthPay;
    }

    public boolean isNeedInterceptVideo() {
        return this.needInterceptVideo;
    }

    public void setFromAuthPay(boolean z16) {
        this.isFromAuthPay = z16;
    }

    public void setNeedInterceptVideo(boolean z16) {
        this.needInterceptVideo = z16;
    }

    public void setParamsMap(Map<String, ?> map) {
        this.paramsMap = map;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoFeed(Video video) {
        this.videoFeed = video;
    }

    public void setWord(String str) {
        this.word = str;
    }
}
