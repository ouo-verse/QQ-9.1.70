package com.tencent.mobileqq.config.operation;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "taskid,uin,uinType")
/* loaded from: classes10.dex */
public class QQOperationVoipTipsTaskExcuteRecord extends Entity {
    public int count;
    public int taskid;
    public long time;
    public int tipType;
    public String uin = "0";
    public int uinType;
}
