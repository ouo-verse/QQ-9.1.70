package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecommendFriend extends Entity {
    public String name;
    public String source;

    @unique
    public String uin;
}
