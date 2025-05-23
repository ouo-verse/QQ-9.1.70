package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSettingSwitchInfoEntity extends Entity {
    public static final String TAG = "MiniAppSettingSwitchInfoEntity";

    @unique
    public String key;
    public String subTitle;
    public String title;
    public int value;

    public MiniAppSettingSwitchInfoEntity() {
    }

    public String toString() {
        return "key:" + this.key + ", title:" + this.title + ", subTitle:" + this.subTitle + ", value:" + this.value;
    }

    public MiniAppSettingSwitchInfoEntity(String str, String str2, String str3, int i3) {
        this.key = str;
        this.title = str2;
        this.subTitle = str3;
        this.value = i3;
    }
}
