package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class QzoneRedDotEntity extends Entity {
    public String iconUrl;
    public boolean isShowRedDot;
    public String jumpSchema;
    public long timeStamp;

    @unique
    public String uin;

    public QzoneRedDotEntity(@NotNull String str, boolean z16, long j3, @NotNull String str2, @NotNull String str3) {
        this.uin = str;
        this.isShowRedDot = z16;
        this.timeStamp = j3;
        this.jumpSchema = str2;
        this.iconUrl = str3;
    }

    public boolean equals(Object obj) {
        QzoneRedDotEntity qzoneRedDotEntity;
        String str;
        if (obj instanceof QzoneRedDotEntity) {
            qzoneRedDotEntity = (QzoneRedDotEntity) obj;
        } else {
            qzoneRedDotEntity = null;
        }
        if (obj != this && ((str = this.uin) == null || qzoneRedDotEntity == null || !str.equals(qzoneRedDotEntity.uin))) {
            return false;
        }
        return true;
    }

    public QzoneRedDotEntity() {
        this.uin = "";
        this.isShowRedDot = false;
        this.timeStamp = 0L;
        this.jumpSchema = "";
        this.iconUrl = "";
    }
}
