package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadTask {
    public int businessType;
    public boolean isCompleted;
    public boolean isReadyUpload;
    public boolean isUploadByBdh;
    public int rspExtType;
    public long seq;
    public int status;
    public int storageExtType;
    public long ukeyTtlSec;
    public BatchUploadTimeInfo timeInfo = new BatchUploadTimeInfo();
    public String taskId = "";
    public String sessionId = "";
    public byte[] bizTransInfo = new byte[0];
    public BatchUploadTaskErrorInfo errorInfo = new BatchUploadTaskErrorInfo();
    public FileInfo fileInfo = new FileInfo();
    public ExtBizInfo extBizInfo = new ExtBizInfo();
    public byte[] storageExtInfo = new byte[0];
    public byte[] rspExtInfo = new byte[0];
    public String ukey = "";
    public ArrayList<Addr> ipv4 = new ArrayList<>();
    public ArrayList<AddrIpv6> ipv6 = new ArrayList<>();
    public MsgInfo msgInfo = new MsgInfo();
    public String domain = "";
    public String dbKey = "";

    public byte[] getBizTransInfo() {
        return this.bizTransInfo;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String getDbKey() {
        return this.dbKey;
    }

    public String getDomain() {
        return this.domain;
    }

    public BatchUploadTaskErrorInfo getErrorInfo() {
        return this.errorInfo;
    }

    public ExtBizInfo getExtBizInfo() {
        return this.extBizInfo;
    }

    public FileInfo getFileInfo() {
        return this.fileInfo;
    }

    public ArrayList<Addr> getIpv4() {
        return this.ipv4;
    }

    public ArrayList<AddrIpv6> getIpv6() {
        return this.ipv6;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public boolean getIsReadyUpload() {
        return this.isReadyUpload;
    }

    public boolean getIsUploadByBdh() {
        return this.isUploadByBdh;
    }

    public MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    public byte[] getRspExtInfo() {
        return this.rspExtInfo;
    }

    public int getRspExtType() {
        return this.rspExtType;
    }

    public long getSeq() {
        return this.seq;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getStatus() {
        return this.status;
    }

    public byte[] getStorageExtInfo() {
        return this.storageExtInfo;
    }

    public int getStorageExtType() {
        return this.storageExtType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public BatchUploadTimeInfo getTimeInfo() {
        return this.timeInfo;
    }

    public String getUkey() {
        return this.ukey;
    }

    public long getUkeyTtlSec() {
        return this.ukeyTtlSec;
    }

    public String toString() {
        return "BatchUploadTask{timeInfo=" + this.timeInfo + ",taskId=" + this.taskId + ",seq=" + this.seq + ",isReadyUpload=" + this.isReadyUpload + ",sessionId=" + this.sessionId + ",status=" + this.status + ",isCompleted=" + this.isCompleted + ",bizTransInfo=" + this.bizTransInfo + ",isUploadByBdh=" + this.isUploadByBdh + ",errorInfo=" + this.errorInfo + ",businessType=" + this.businessType + ",fileInfo=" + this.fileInfo + ",extBizInfo=" + this.extBizInfo + ",storageExtType=" + this.storageExtType + ",storageExtInfo=" + this.storageExtInfo + ",rspExtType=" + this.rspExtType + ",rspExtInfo=" + this.rspExtInfo + ",ukey=" + this.ukey + ",ukeyTtlSec=" + this.ukeyTtlSec + ",ipv4=" + this.ipv4 + ",ipv6=" + this.ipv6 + ",msgInfo=" + this.msgInfo + ",domain=" + this.domain + ",dbKey=" + this.dbKey + ",}";
    }
}
