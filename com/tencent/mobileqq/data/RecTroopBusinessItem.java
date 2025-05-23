package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecTroopBusinessItem extends Entity {
    public String btnText;
    public String des;
    public long endTime;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f203115id;
    public String jumpParam;
    public int jumpType;
    public String jumpUrl;
    public long startTime;
    public long timeStamp;
    public String title;
}
