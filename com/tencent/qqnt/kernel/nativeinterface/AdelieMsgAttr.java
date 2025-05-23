package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AdelieMsgAttr {
    public byte[] msgBotBuf;
    public long msgDirection;
    public long msgPushStatus;

    public AdelieMsgAttr() {
    }

    public byte[] getMsgBotBuf() {
        return this.msgBotBuf;
    }

    public long getMsgDirection() {
        return this.msgDirection;
    }

    public long getMsgPushStatus() {
        return this.msgPushStatus;
    }

    public AdelieMsgAttr(long j3, long j16, byte[] bArr) {
        this.msgPushStatus = j3;
        this.msgDirection = j16;
        this.msgBotBuf = bArr;
    }
}
