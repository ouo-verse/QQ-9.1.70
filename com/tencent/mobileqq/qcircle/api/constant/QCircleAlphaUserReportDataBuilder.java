package com.tencent.mobileqq.qcircle.api.constant;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleAlphaUserReportDataBuilder {
    public static final String CORE_INDICATOR_REPORT_VERSION = "3";
    public String attachInfo;
    public String cmd;
    public int count;
    public String ext1;
    public String ext2;
    public String ext3;
    public String ext4;
    public String ext5;
    public String extraInfo;
    public HashMap<String, String> extras = new HashMap<>();
    public String feedId;
    public String gwRpTransfer;
    public String info;

    /* renamed from: msg, reason: collision with root package name */
    public String f261575msg;
    public double rate;
    public String refer;
    public String retCode;
    public String state;
    public String svrRetCode;
    public long timeCost;
    public String type;
    public String url;
    public String user;

    public QCircleAlphaUserReportDataBuilder setAttachInfo(String str) {
        this.attachInfo = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setCmd(String str) {
        this.cmd = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setCount(int i3) {
        this.count = i3;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExt1(String str) {
        this.ext1 = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExt2(String str) {
        this.ext2 = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExt3(String str) {
        this.ext3 = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExt4(String str) {
        this.ext4 = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExt5(String str) {
        this.ext5 = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExtraInfo(String str) {
        this.extraInfo = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setExtras(HashMap<String, String> hashMap) {
        this.extras = hashMap;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setFeedId(String str) {
        this.feedId = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setGwRpTransfer(String str) {
        this.gwRpTransfer = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setInfo(String str) {
        this.info = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setMsg(String str) {
        this.f261575msg = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setRate(double d16) {
        this.rate = d16;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setRefer(String str) {
        this.refer = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setRetCode(String str) {
        this.retCode = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setState(String str) {
        this.state = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setSvrRetCode(String str) {
        this.svrRetCode = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setTimeCost(long j3) {
        this.timeCost = j3;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setType(String str) {
        this.type = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setUrl(String str) {
        this.url = str;
        return this;
    }

    public QCircleAlphaUserReportDataBuilder setUser(String str) {
        this.user = str;
        return this;
    }
}
