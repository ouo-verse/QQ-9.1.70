package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class AndroidImportParseMsgs {
    public ArrayList<ImportMsgPbRecord> importMsgPbRecord;
    public long nextId;
    public long parseTime;
    public int readCount;
    public long readTime;
    public ArrayList<MsgRecord> specialMsgRecord;

    public AndroidImportParseMsgs() {
        this.importMsgPbRecord = new ArrayList<>();
        this.specialMsgRecord = new ArrayList<>();
    }

    public ArrayList<ImportMsgPbRecord> getImportMsgPbRecord() {
        return this.importMsgPbRecord;
    }

    public long getNextId() {
        return this.nextId;
    }

    public long getParseTime() {
        return this.parseTime;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public long getReadTime() {
        return this.readTime;
    }

    public ArrayList<MsgRecord> getSpecialMsgRecord() {
        return this.specialMsgRecord;
    }

    public String toString() {
        return "AndroidImportParseMsgs{readCount=" + this.readCount + ",nextId=" + this.nextId + ",readTime=" + this.readTime + ",parseTime=" + this.parseTime + ",importMsgPbRecord=" + this.importMsgPbRecord + ",specialMsgRecord=" + this.specialMsgRecord + ",}";
    }

    public AndroidImportParseMsgs(int i3, long j3, long j16, long j17, ArrayList<ImportMsgPbRecord> arrayList, ArrayList<MsgRecord> arrayList2) {
        this.importMsgPbRecord = new ArrayList<>();
        new ArrayList();
        this.readCount = i3;
        this.nextId = j3;
        this.readTime = j16;
        this.parseTime = j17;
        this.importMsgPbRecord = arrayList;
        this.specialMsgRecord = arrayList2;
    }
}
