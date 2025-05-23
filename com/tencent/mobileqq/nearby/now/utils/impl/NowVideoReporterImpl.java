package com.tencent.mobileqq.nearby.now.utils.impl;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowVideoReporterImpl implements INowVideoReporter {
    public static String anchorUin = "";
    public static String feedId = "";
    public static String feedType = "";
    public static String from = "";
    public static long playTimeBegin;
    public static int rePlayCount;
    protected int mOpIn;
    protected int mOpResult;
    protected String timelong = "";
    protected String feedid = "";
    protected String feed_type = "";
    protected String source = "";
    protected String networktype = "";
    protected String mOpType = "";
    protected String mOpName = "";
    protected String mToUin = "";

    /* renamed from: d1, reason: collision with root package name */
    protected String f252781d1 = "";

    /* renamed from: d2, reason: collision with root package name */
    protected String f252782d2 = "";

    /* renamed from: d3, reason: collision with root package name */
    protected String f252783d3 = "";

    /* renamed from: d4, reason: collision with root package name */
    protected String f252784d4 = "";
    protected int mCount = 1;
    boolean lvInd1 = false;
    boolean genderInd1 = false;

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public String getAnchorUin() {
        return anchorUin;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public String getFeedId() {
        return feedId;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public String getFeedType() {
        return feedType;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public String getFrom() {
        return from;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public long getPlayTimeBegin() {
        return playTimeBegin;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public int getRePlayCount() {
        return rePlayCount;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setAnchorUin(String str) {
        anchorUin = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setFeedId(String str) {
        feedId = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setFeedType(String str) {
        feedType = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setFrom(String str) {
        from = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setPlayTimeBegin(long j3) {
        playTimeBegin = j3;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void setRePlayCount(int i3) {
        rePlayCount = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl LvInd1() {
        this.lvInd1 = true;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl count(int i3) {
        this.mCount = i3;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl d1(String str) {
        this.f252781d1 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl d2(String str) {
        this.f252782d2 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl d3(String str) {
        this.f252783d3 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl d4(String str) {
        this.f252784d4 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl feed_type(String str) {
        this.feed_type = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl feedid(String str) {
        this.feedid = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl genderInd1() {
        this.genderInd1 = true;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl networktype(String str) {
        this.networktype = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl opIn(int i3) {
        this.mOpIn = i3;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl opName(String str) {
        this.mOpName = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl opResult(int i3) {
        this.mOpResult = i3;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl opType(String str) {
        this.mOpType = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void report(AppInterface appInterface) {
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (this.lvInd1 && qQAppInterface != null) {
            this.f252781d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + qQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
        }
        if (this.genderInd1 && qQAppInterface != null) {
            this.genderInd1 = true;
            this.f252781d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + qQAppInterface.getCurrentAccountUin(), 4).getInt("gender", 0));
        }
        this.networktype = HttpUtil.getNetWorkType() + "";
        ReportController.n(qQAppInterface, INowVideoReporter.TAG, "grp_lbs", this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, this.f252781d1, this.f252782d2, this.f252783d3, this.f252784d4 + "|" + this.timelong + "|" + this.feedid + "|" + this.feed_type + "|" + this.source + "|" + this.networktype);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public void reportByVideo(AppInterface appInterface) {
        int i3;
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (this.lvInd1) {
            this.f252781d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + qQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
        }
        if (this.genderInd1) {
            this.f252781d1 = "" + ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(qQAppInterface.getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1));
        }
        long currentTimeMillis = System.currentTimeMillis() - playTimeBegin;
        if (currentTimeMillis % 1000 > 500) {
            i3 = (((int) currentTimeMillis) / 1000) + 1;
        } else {
            i3 = ((int) currentTimeMillis) / 1000;
        }
        this.timelong = i3 + "";
        this.feedid = feedId;
        this.feed_type = feedType;
        this.source = from;
        this.networktype = HttpUtil.getNetWorkType() + "";
        ReportController.n(qQAppInterface, INowVideoReporter.TAG, "grp_lbs", this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, this.f252781d1, this.f252782d2, this.f252783d3, this.f252784d4 + "|" + this.timelong + "|" + this.feedid + "|" + this.feed_type + "|" + this.source + "|" + this.networktype);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl source(String str) {
        this.source = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl timelong(String str) {
        this.timelong = str;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.INowVideoReporter
    public NowVideoReporterImpl toUin(String str) {
        this.mToUin = str;
        return this;
    }
}
