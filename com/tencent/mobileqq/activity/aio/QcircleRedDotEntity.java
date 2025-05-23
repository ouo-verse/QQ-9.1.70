package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class QcircleRedDotEntity extends Entity {
    public boolean isShowRedDot;
    public String jumpSchema;
    public long timeStamp;

    @unique
    public String uin;

    public QcircleRedDotEntity(String str, boolean z16, long j3, String str2) {
        this.uin = str;
        this.isShowRedDot = z16;
        this.timeStamp = j3;
        this.jumpSchema = str2;
    }

    public boolean equals(Object obj) {
        QcircleRedDotEntity qcircleRedDotEntity;
        String str;
        if (obj instanceof QcircleRedDotEntity) {
            qcircleRedDotEntity = (QcircleRedDotEntity) obj;
        } else {
            qcircleRedDotEntity = null;
        }
        if (obj != this && ((str = this.uin) == null || qcircleRedDotEntity == null || !str.equals(qcircleRedDotEntity.uin))) {
            return false;
        }
        return true;
    }

    public QcircleRedDotEntity() {
        this.uin = "";
        this.isShowRedDot = false;
        this.timeStamp = 0L;
        this.jumpSchema = "";
    }
}
