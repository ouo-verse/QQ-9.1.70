package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EqqConfig extends Entity {

    @unique
    public String data;

    public EqqConfig() {
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public EqqConfig(String str) {
        this.data = str;
    }
}
