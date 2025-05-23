package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CustomEmotionBase<T extends CustomEmotionBase> extends Entity {
    public String RomaingType = "init";

    @unique
    public int emoId;
    public String emoOriginalPath;
    public String emoPath;
    public boolean isAPNG;
    public String md5;
    public String resid;
    public String thumbPath;
    public String uin;
    public String url;

    public void replace(T t16) {
        if (t16 != null) {
            this.uin = t16.uin;
            this.emoId = t16.emoId;
            this.emoPath = t16.emoPath;
            this.RomaingType = t16.RomaingType;
            this.resid = t16.resid;
            this.url = t16.url;
            this.md5 = t16.md5;
            this.isAPNG = t16.isAPNG;
        }
    }
}
