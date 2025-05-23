package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OdidResp extends AbstractMessageEntity {

    /* renamed from: id, reason: collision with root package name */
    @Packed
    public String f37553id;

    public String getId() {
        return this.f37553id;
    }

    public void setId(String str) {
        this.f37553id = str;
    }
}
