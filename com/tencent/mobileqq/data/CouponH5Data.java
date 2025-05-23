package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CouponH5Data extends Entity {
    public String mData;
    public String mHost;
    public String mKey;
    public String mPath;

    public CouponH5Data() {
    }

    public CouponH5Data(String str, String str2, String str3, String str4) {
        this.mHost = str;
        this.mPath = str2;
        this.mKey = str3;
        this.mData = str4;
    }
}
