package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BooleanResult implements IMessageEntity {

    @Packed
    private boolean status;

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z16) {
        this.status = z16;
    }
}
