package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "mr_time,mr_seq,selfUin,friendUin")
/* loaded from: classes10.dex */
public class TransFileInfo extends Entity {
    public String fileName;
    public String friendUin;
    public long mr_seq;
    public long mr_time;
    public String selfUin;
    public int status;
    public long transferedSize;
    public byte[] uuid;
}
