package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,msgid,uSessionID")
/* loaded from: classes10.dex */
public class RouterMsgRecord extends MessageRecord implements Cloneable {
    public static final int MSG_TYPE_DATALINE_APP = -2335;
    public static final int MSG_TYPE_DATALINE_FILE = -2005;
    public static final int MSG_TYPE_DATALINE_PIC = -2000;
    public static final int MSG_TYPE_DATALINE_PROMPT = -2334;
    public static final int MSG_TYPE_DATALINE_TEXT = -1000;
    public static final int MSG_TYPE_DATALINE_VIDEO = -2009;
    public static final int oppositestatus_Fail = 3;
    public static final int oppositestatus_FileDel = 5;
    public static final int oppositestatus_MsgDel = 4;
    public static final int oppositestatus_Suc = 2;
    public static final int oppositestatus_Unknown = 1;
    public static String sBasicTableName = "mr_dataline_router_";
    public static final int status_New = 1;
    public static final int status_transfer_fail = 4;
    public static final int status_transfer_pause = 5;
    public static final int status_transfer_suc = 3;
    public static final int status_transfering = 2;

    @notColumn
    public long entityID;
    public long fileSize;
    public String filename;
    public long peerDin;
    public long uSessionID = 0;
    public double progress = 0.0d;
    public int status = 1;
    public int oppositestatus = 1;
    public String sTableName = null;

    public RouterMsgRecord() {
        this.versionCode = 0;
    }

    public static String tableBasicName() {
        return sBasicTableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return RouterMsgRecord.class;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return this.sTableName;
    }

    public void setTableName(String str) {
        this.sTableName = sBasicTableName + str;
        this.peerDin = Long.parseLong(str);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RouterMsgRecord m174clone() {
        try {
            return (RouterMsgRecord) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public RouterMsgRecord(long j3) {
        this.versionCode = 0;
        this.msgId = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
    }
}
