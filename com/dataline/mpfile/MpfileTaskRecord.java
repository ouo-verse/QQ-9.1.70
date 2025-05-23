package com.dataline.mpfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,msgid")
/* loaded from: classes2.dex */
public class MpfileTaskRecord extends MessageRecord implements Cloneable {
    public long currentSize;
    public long din;
    public String fileId;
    public String fileName;
    public String filePath;
    public String fileTempPath;
    public String fileTime;
    public long sessionId;
    public long totalSize;

    public MpfileTaskRecord() {
        String valueOf = String.valueOf(AppConstants.DATALINE_PC_UIN);
        this.selfuin = valueOf;
        this.frienduin = valueOf;
        this.senderuin = valueOf;
        this.istroop = 6000;
        this.versionCode = 1;
    }

    public static String tableName() {
        return "mr_dataline_mpfile";
    }

    public void doPrewrite() {
        prewrite();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return MpfileTaskRecord.class;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return "mr_dataline_mpfile";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MpfileTaskRecord m42clone() {
        try {
            return (MpfileTaskRecord) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
    }
}
