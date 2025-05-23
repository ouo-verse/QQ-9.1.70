package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ClientPollControl {
    public boolean isNextPollForbidden;
    public long nextPollIntervalMs;

    public boolean getIsNextPollForbidden() {
        return this.isNextPollForbidden;
    }

    public long getNextPollIntervalMs() {
        return this.nextPollIntervalMs;
    }
}
