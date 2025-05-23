package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "grpID,mId")
/* loaded from: classes10.dex */
public class GrpMemberInfo extends Entity {
    public String grpID;
    public String mId;
    public String name;
    public byte nature;
}
