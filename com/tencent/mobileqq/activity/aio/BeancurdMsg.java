package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "busiid,frienduin")
/* loaded from: classes10.dex */
public class BeancurdMsg extends Entity {
    public String buffer;
    public int busiid;
    public String frienduin;
    public boolean isNeedDelHistory;
    public boolean ispush;
    public long msgTime = -1;
    public long originTime;
    public long startTime;
    public long token;
    public long validTime;

    public String toString() {
        return String.format(" busiid:%d,frienduin:%s,ipush:%b,isNeedDelHistory:%b,buffer:%s,startTime:%d,validTime:%d,msgTime:%d", Integer.valueOf(this.busiid), this.frienduin, Boolean.valueOf(this.ispush), Boolean.valueOf(this.isNeedDelHistory), this.buffer, Long.valueOf(this.startTime), Long.valueOf(this.validTime), Long.valueOf(this.msgTime));
    }
}
