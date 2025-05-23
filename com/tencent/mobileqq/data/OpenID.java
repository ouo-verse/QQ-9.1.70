package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class OpenID extends Entity {

    @unique
    public String appID;
    public String openID;

    public String toString() {
        return "appid = " + this.appID + "; openid = " + this.openID;
    }
}
