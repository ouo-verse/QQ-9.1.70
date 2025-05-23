package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupResEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TABLE_NAME = "res";
    public byte[] extraData;

    @notColumn
    public String extraDataStr;
    public String filePath;
    public long fileSize;
    public long msgRandom;
    public long msgSeq;
    public int msgSubType;
    public int msgType;

    public MsgBackupResEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "res";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.postRead();
        com.tencent.mobileqq.msgbackup.util.f.c(this);
        try {
            byte[] bArr = this.extraData;
            if (bArr != null) {
                this.extraDataStr = new String(bArr, "utf-8");
            }
        } catch (Exception unused) {
            com.tencent.mobileqq.msgbackup.util.f.B("MsgBackup", "MsgBackupMsgEntity  postRead is called error!", new Object[0]);
            this.extraDataStr = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.prewrite();
        if (!TextUtils.isEmpty(this.extraDataStr)) {
            this.extraData = this.extraDataStr.getBytes();
        }
        com.tencent.mobileqq.msgbackup.util.f.m(this);
        this.filePath = com.tencent.mobileqq.msgbackup.util.f.k(this.filePath);
    }

    public String toLogString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MsgBackupResEntity{msgSeq=" + this.msgSeq + ", msgRandom=" + this.msgRandom + ", msgType=" + this.msgType + ", msgSubType=" + this.msgSubType + ", filePath='" + this.filePath + "', extraDataStr='" + this.extraDataStr + "'}";
    }
}
