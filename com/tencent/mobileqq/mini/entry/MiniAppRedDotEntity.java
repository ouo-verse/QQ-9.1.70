package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppRedDotEntity extends Entity {
    public static final String TAG = "MiniAppRedDotEntity";

    @unique
    public String appId;
    public int publicAccountRedDotNum;
    public int wnsPushRedDotNum;

    public MiniAppRedDotEntity() {
    }

    public String toString() {
        return "appId:" + this.appId + ", publicAccountRedDotNum:" + this.publicAccountRedDotNum + ", wnsPushRedDotNum:" + this.wnsPushRedDotNum;
    }

    public MiniAppRedDotEntity(String str, int i3, int i16) {
        this.appId = str;
        this.publicAccountRedDotNum = i3;
        this.wnsPushRedDotNum = i16;
    }
}
