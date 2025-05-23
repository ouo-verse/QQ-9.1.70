package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRevokeOptions {
    public int revokeMsgDuration;

    public GProRevokeOptions() {
    }

    public int getRevokeMsgDuration() {
        return this.revokeMsgDuration;
    }

    public String toString() {
        return "GProRevokeOptions{revokeMsgDuration=" + this.revokeMsgDuration + ",}";
    }

    public GProRevokeOptions(int i3) {
        this.revokeMsgDuration = i3;
    }
}
