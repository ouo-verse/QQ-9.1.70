package com.tencent.mobileqq.nearby.redtouch;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RedTouchItemExtMsg implements Serializable {
    private static final long serialVersionUID = 0;
    public byte[] bytesData;
    public long seq;
    public int time;

    public String toString() {
        return "[seq:" + this.seq + " time:" + this.time + " bytesData:" + this.bytesData + " ]";
    }
}
