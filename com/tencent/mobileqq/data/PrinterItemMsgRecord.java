package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Timer;

@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,msgid")
/* loaded from: classes10.dex */
public class PrinterItemMsgRecord extends MessageRecord implements Cloneable {
    public static final String sTagleName = "mr_dataline_printer";
    public static final int status_New = 1;
    public static final int status_print_fail = 11;
    public static final int status_print_suc = 10;
    public static final int status_running = 2;
    public static final int status_transfer_fail = 12;
    public String filename;
    public long uSessionID = 0;
    public double progress = 0.0d;
    public int status = 1;

    @notColumn
    public Timer mTimer_for_Print = null;

    public PrinterItemMsgRecord() {
        this.versionCode = 0;
    }

    public static String tableName() {
        return sTagleName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return PrinterItemMsgRecord.class;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return sTagleName;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PrinterItemMsgRecord m172clone() {
        try {
            return (PrinterItemMsgRecord) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public PrinterItemMsgRecord(long j3) {
        this.versionCode = 0;
        this.msgId = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
    }
}
