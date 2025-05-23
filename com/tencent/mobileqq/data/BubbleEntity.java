package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BubbleEntity extends Entity {
    public int bubble_id;
    public long expire;
    public String hash;
    public int opType;
    public int power;
    public String resUrl;
    public int version;

    public BubbleEntity() {
        this.bubble_id = 0;
        this.opType = 0;
        this.power = 0;
        this.expire = 0L;
        this.resUrl = null;
        this.version = 1;
        this.hash = "";
    }

    public BubbleEntity(int i3, int i16, String str, int i17, long j3) {
        this.version = 1;
        this.hash = "";
        this.bubble_id = i3;
        this.opType = i16;
        this.resUrl = str;
        this.power = i17;
        this.expire = j3;
    }

    public BubbleEntity(int i3, int i16, String str, int i17, long j3, int i18) {
        this.hash = "";
        this.bubble_id = i3;
        this.opType = i16;
        this.resUrl = str;
        this.power = i17;
        this.expire = j3;
        this.version = i18;
    }
}
