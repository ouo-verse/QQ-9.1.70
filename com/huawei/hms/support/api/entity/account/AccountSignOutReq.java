package com.huawei.hms.support.api.entity.account;

import com.huawei.hms.core.aidl.IMessageEntity;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AccountSignOutReq implements IMessageEntity {
    public String toJson() {
        return new JSONObject().toString();
    }
}
