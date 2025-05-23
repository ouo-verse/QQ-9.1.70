package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class TempMsgInfo extends Entity implements Serializable {
    public long timeStamp;

    @unique
    public String typeWithUin;

    public TempMsgInfo(String str, long j3) {
        this.typeWithUin = str;
        this.timeStamp = j3;
    }

    public TempMsgInfo() {
    }
}
