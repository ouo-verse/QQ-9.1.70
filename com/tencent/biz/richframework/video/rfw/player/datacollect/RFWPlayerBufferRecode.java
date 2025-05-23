package com.tencent.biz.richframework.video.rfw.player.datacollect;

import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.mobileqq.qcircle.picload.listener.a;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import uq3.n;

/* loaded from: classes5.dex */
public class RFWPlayerBufferRecode {
    private float mBufferCostTimeS;
    private String mBufferEdnTimeDate;
    private long mBufferEndTime;
    private long mBufferStartTime;
    private String mBufferStartTimeDate;
    private boolean mIsTriggerBySeek;
    private final float mPredictNetKBS = (float) RFWVideoUtils.getPredictSpeedWithOutDownGrade(126);
    private final float mFeedTimeCostS = ((Double) VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate().first).floatValue() / 1000.0f;
    private final boolean mHasNetWorkWhenBuffStart = ((INetworkUtilApi) QRoute.api(INetworkUtilApi.class)).isNetworkAvailable();
    private final float mPicKBS = ((Double) a.c().getSpeedAndSucceedRate().first).floatValue();

    public float getBufferCostTimeS() {
        return this.mBufferCostTimeS;
    }

    public long getBufferStartTime() {
        return this.mBufferStartTime;
    }

    public float getFeedTimeCostS() {
        return this.mFeedTimeCostS;
    }

    public boolean getIsTriggerBySeek() {
        return this.mIsTriggerBySeek;
    }

    public float getPicKBS() {
        return this.mPicKBS;
    }

    public float getPredictNetKBS() {
        return this.mPredictNetKBS;
    }

    public boolean hasNetWorkWhenBuffStart() {
        return this.mHasNetWorkWhenBuffStart;
    }

    public RFWPlayerBufferRecode setBufferCostTimeS(float f16) {
        this.mBufferCostTimeS = f16;
        return this;
    }

    public RFWPlayerBufferRecode setBufferEndTime(long j3) {
        this.mBufferEndTime = j3;
        this.mBufferEdnTimeDate = n.a(j3);
        return this;
    }

    public RFWPlayerBufferRecode setBufferStartTime(long j3) {
        this.mBufferStartTime = j3;
        this.mBufferStartTimeDate = n.a(j3);
        return this;
    }

    public RFWPlayerBufferRecode setIsTriggerBySeek(boolean z16) {
        this.mIsTriggerBySeek = z16;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSBufferRecode{");
        stringBuffer.append("mBufferStartTime=");
        stringBuffer.append(this.mBufferStartTimeDate);
        stringBuffer.append(", mBufferEndTime=");
        stringBuffer.append(this.mBufferEdnTimeDate);
        stringBuffer.append(", mBufferCostTimeS=");
        stringBuffer.append(this.mBufferCostTimeS);
        stringBuffer.append(", mIsTriggerBySeek=");
        stringBuffer.append(this.mIsTriggerBySeek);
        stringBuffer.append(", mHasNetWorkWhenBuffStart=");
        stringBuffer.append(this.mHasNetWorkWhenBuffStart);
        stringBuffer.append(", mPredictNetKBS=");
        stringBuffer.append(this.mPredictNetKBS);
        stringBuffer.append(", mFeedTimeCostS=");
        stringBuffer.append(this.mFeedTimeCostS);
        stringBuffer.append(", mPicKBS");
        stringBuffer.append(this.mPicKBS);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
