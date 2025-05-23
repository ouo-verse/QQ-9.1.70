package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestRsp {
    public int digestTime;
    public long digestUin;
    public int errorCode;
    public String wording = "";

    /* renamed from: msg, reason: collision with root package name */
    public DigestMsg f359164msg = new DigestMsg();

    public int getDigestTime() {
        return this.digestTime;
    }

    public long getDigestUin() {
        return this.digestUin;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public DigestMsg getMsg() {
        return this.f359164msg;
    }

    public String getWording() {
        return this.wording;
    }

    public String toString() {
        return "DigestRsp{wording=" + this.wording + ",digestUin=" + this.digestUin + ",digestTime=" + this.digestTime + ",msg=" + this.f359164msg + ",errorCode=" + this.errorCode + ",}";
    }
}
