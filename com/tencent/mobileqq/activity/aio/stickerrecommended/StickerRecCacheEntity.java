package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "md5")
/* loaded from: classes10.dex */
public class StickerRecCacheEntity extends Entity {
    public String filePath;
    public long lastTime;
    public String md5;

    public StickerRecCacheEntity() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass() || !(obj instanceof StickerRecCacheEntity)) {
            return false;
        }
        return this.md5.equals(((StickerRecCacheEntity) obj).md5);
    }

    public void replace(StickerRecCacheEntity stickerRecCacheEntity) {
        if (stickerRecCacheEntity != null) {
            this.lastTime = stickerRecCacheEntity.lastTime;
        }
    }

    public StickerRecCacheEntity(String str, long j3, String str2) {
        this.filePath = str;
        this.lastTime = j3;
        this.md5 = str2;
    }
}
