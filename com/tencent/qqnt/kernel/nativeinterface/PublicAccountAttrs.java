package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PublicAccountAttrs {
    public Integer ack;
    public Long bitmap;
    public byte[] gdtCliData;
    public byte[] gdtImpData;

    /* renamed from: op, reason: collision with root package name */
    public Integer f359203op;
    public Long pubMsgId;
    public Integer report;
    public Integer showTime;
    public Long uniqueId;
    public byte[] viewId;

    public PublicAccountAttrs() {
    }

    public Integer getAck() {
        return this.ack;
    }

    public Long getBitmap() {
        return this.bitmap;
    }

    public byte[] getGdtCliData() {
        return this.gdtCliData;
    }

    public byte[] getGdtImpData() {
        return this.gdtImpData;
    }

    public Integer getOp() {
        return this.f359203op;
    }

    public Long getPubMsgId() {
        return this.pubMsgId;
    }

    public Integer getReport() {
        return this.report;
    }

    public Integer getShowTime() {
        return this.showTime;
    }

    public Long getUniqueId() {
        return this.uniqueId;
    }

    public byte[] getViewId() {
        return this.viewId;
    }

    public String toString() {
        return "PublicAccountAttrs{pubMsgId=" + this.pubMsgId + ",uniqueId=" + this.uniqueId + ",op=" + this.f359203op + ",showTime=" + this.showTime + ",report=" + this.report + ",ack=" + this.ack + ",bitmap=" + this.bitmap + ",gdtImpData=" + this.gdtImpData + ",gdtCliData=" + this.gdtCliData + ",viewId=" + this.viewId + ",}";
    }

    public PublicAccountAttrs(Long l3, Long l16, Integer num, Integer num2, Integer num3, Integer num4, Long l17, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.pubMsgId = l3;
        this.uniqueId = l16;
        this.f359203op = num;
        this.showTime = num2;
        this.report = num3;
        this.ack = num4;
        this.bitmap = l17;
        this.gdtImpData = bArr;
        this.gdtCliData = bArr2;
        this.viewId = bArr3;
    }
}
