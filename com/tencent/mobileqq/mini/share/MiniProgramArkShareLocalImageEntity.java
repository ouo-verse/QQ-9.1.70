package com.tencent.mobileqq.mini.share;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class MiniProgramArkShareLocalImageEntity extends Entity implements Serializable {
    public String arkPath;
    public String localPath;

    public MiniProgramArkShareLocalImageEntity() {
    }

    public String toString() {
        return "MiniProgramArkShareLocalImageEntity{arkPath='" + this.arkPath + "', localPath='" + this.localPath + "'}";
    }

    public MiniProgramArkShareLocalImageEntity(String str, String str2) {
        this.arkPath = str;
        this.localPath = str2;
    }
}
