package com.tencent.mobileqq.filemanager.proto;

import com.tencent.mobileqq.filemanager.app.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMTransC2CMsgInfo implements Serializable {
    public int busiType;
    public int cmd;
    public FileManagerEntity entity;
    public int subCmd;
    public String toUin = "";
    public long msgSeq = -1;
    public long queueSeq = -1;
    public long msgUid = -1;
    public long uniseq = 0;
    public String uuid = "";
    public long sessionId = -1;
    public long observerSeq = -1;
    public d fileTransferObserver = null;

    public String toString() {
        return "msgSeq[" + this.msgSeq + "] msgUid[" + this.msgUid + "] subCmd[" + this.subCmd + "] sessionId[" + this.sessionId + "] uuid[" + this.uuid + "] busiType[" + this.busiType + "] uniseq" + this.uniseq;
    }
}
