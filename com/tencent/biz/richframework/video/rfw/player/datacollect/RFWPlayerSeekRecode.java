package com.tencent.biz.richframework.video.rfw.player.datacollect;

import uq3.n;

/* loaded from: classes5.dex */
public class RFWPlayerSeekRecode {
    private long mSeekCompleteTime;
    private String mSeekCompleteTimeDate;
    private float mSeekCostS;
    private long mSeekEndPoi;
    private float mSeekGapS;
    private long mSeekStartPoi;
    private long mSeekStartTime;
    private String mSeekStartTimeDate;

    public float getSeekCostS() {
        return this.mSeekCostS;
    }

    public long getSeekStartTime() {
        return this.mSeekStartTime;
    }

    public RFWPlayerSeekRecode setSeekCompleteTime(long j3) {
        this.mSeekCompleteTime = j3;
        this.mSeekCompleteTimeDate = n.a(j3);
        return this;
    }

    public RFWPlayerSeekRecode setSeekCostS(float f16) {
        this.mSeekCostS = f16;
        return this;
    }

    public RFWPlayerSeekRecode setSeekEndPoi(long j3) {
        this.mSeekEndPoi = j3;
        this.mSeekGapS = Math.abs(((float) (j3 - this.mSeekStartPoi)) / 1000.0f);
        return this;
    }

    public RFWPlayerSeekRecode setSeekStartPoi(long j3) {
        this.mSeekStartPoi = j3;
        return this;
    }

    public RFWPlayerSeekRecode setSeekStartTime(long j3) {
        this.mSeekStartTime = j3;
        this.mSeekStartTimeDate = n.a(j3);
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSPlaySeekRecode{");
        stringBuffer.append("mSeekStartPoi=");
        stringBuffer.append(this.mSeekStartPoi);
        stringBuffer.append(", mSeekEndPoi=");
        stringBuffer.append(this.mSeekEndPoi);
        stringBuffer.append(", mSeekGapS=");
        stringBuffer.append(this.mSeekGapS);
        stringBuffer.append(", mSeekCostS=");
        stringBuffer.append(this.mSeekCostS);
        stringBuffer.append(", mSeekStartTime=");
        stringBuffer.append(this.mSeekStartTimeDate);
        stringBuffer.append(", mSeekCompleteTime=");
        stringBuffer.append(this.mSeekCompleteTimeDate);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
