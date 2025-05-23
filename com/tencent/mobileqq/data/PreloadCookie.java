package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "host,cookieKey")
/* loaded from: classes10.dex */
public class PreloadCookie extends Entity {
    public String cookieKey;
    public long hitCount;
    public String host;
}
