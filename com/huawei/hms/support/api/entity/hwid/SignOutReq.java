package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.core.aidl.IMessageEntity;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SignOutReq implements IMessageEntity {
    public String toJson() {
        return new JSONObject().toString();
    }
}
