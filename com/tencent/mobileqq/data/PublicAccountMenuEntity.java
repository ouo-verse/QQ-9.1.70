package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes10.dex */
public class PublicAccountMenuEntity extends Entity {
    public byte[] data;
    public long savedDateTime;
    public int seqno;

    @unique
    public String uin;

    public PublicAccountMenuEntity() {
        this.data = null;
        this.seqno = 0;
        this.savedDateTime = 0L;
    }

    public void clone(PublicAccountMenuEntity publicAccountMenuEntity) {
        this.uin = publicAccountMenuEntity.uin;
        this.data = (byte[]) publicAccountMenuEntity.data.clone();
        this.savedDateTime = publicAccountMenuEntity.savedDateTime;
        this.seqno = publicAccountMenuEntity.seqno;
    }

    public PublicAccountMenuEntity(String str, mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse, long j3) {
        this.data = null;
        this.seqno = 0;
        this.savedDateTime = 0L;
        this.uin = str;
        this.data = mobileqq_mp_getpublicaccountmenuresponse.toByteArray();
        this.savedDateTime = j3;
        this.seqno = mobileqq_mp_getpublicaccountmenuresponse.seqno.has() ? mobileqq_mp_getpublicaccountmenuresponse.seqno.get() : 0;
    }

    public PublicAccountMenuEntity(String str, mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse) {
        this(str, mobileqq_mp_getpublicaccountmenuresponse, System.currentTimeMillis());
    }
}
