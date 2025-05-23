package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckDeviceStatusRsp {
    public HashMap<Integer, String> invalidStatus = new HashMap<>();
    public int seq;

    public HashMap<Integer, String> getInvalidStatus() {
        return this.invalidStatus;
    }

    public int getSeq() {
        return this.seq;
    }
}
