package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupMsgEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TABLE_NAME = "msg";
    public int chatType;
    public String chatUin;
    public byte[] extensionData;
    public byte[] extraData;

    @notColumn
    public String extraDataStr;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public int msgType;

    public MsgBackupMsgEntity() {
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
        return "msg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.postRead();
        com.tencent.mobileqq.msgbackup.util.f.e(this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.prewrite();
        if (!TextUtils.isEmpty(this.extraDataStr)) {
            this.extraData = this.extraDataStr.getBytes();
        }
        com.tencent.mobileqq.msgbackup.util.f.l(this);
    }
}
