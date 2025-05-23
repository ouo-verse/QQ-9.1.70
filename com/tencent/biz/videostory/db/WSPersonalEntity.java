package com.tencent.biz.videostory.db;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes5.dex */
public class WSPersonalEntity extends Entity {

    @unique
    public String uin;
    public byte[] weiShiPersonalRsp = null;

    public void updateWeiShiFeedListEntity(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.uin = str;
            this.weiShiPersonalRsp = bArr;
        }
    }
}
