package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAuthority implements Serializable {
    public long eventIntVal;
    public int switchVal;
    long serialVersionUID = 1;
    public byte[] eventBytesVal = new byte[0];

    public byte[] getEventBytesVal() {
        return this.eventBytesVal;
    }

    public long getEventIntVal() {
        return this.eventIntVal;
    }

    public int getSwitchVal() {
        return this.switchVal;
    }

    public String toString() {
        return "GroupAuthority{switchVal=" + this.switchVal + ",eventIntVal=" + this.eventIntVal + ",eventBytesVal=" + this.eventBytesVal + ",}";
    }
}
