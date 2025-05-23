package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f extends c {
    static IPatchRedirector $redirector_;

    public f(MsgBackupResEntity msgBackupResEntity) {
        super(msgBackupResEntity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgBackupResEntity);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return j(this.f251272c);
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public com.tencent.mobileqq.msgbackup.controller.k d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.msgbackup.controller.k) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MsgBackupResEntity msgBackupResEntity = this.f251272c;
        com.tencent.mobileqq.msgbackup.controller.k kVar = new com.tencent.mobileqq.msgbackup.controller.k();
        String k3 = k(msgBackupResEntity);
        boolean z16 = false;
        if (k3 == null) {
            b("getResDownloadObject realPath is null");
            kVar.f251095a = false;
            return kVar;
        }
        String l3 = l(k3);
        boolean a16 = a(l3);
        boolean a17 = a(k3);
        if (QLog.isColorLevel()) {
            b("getResDownloadObject,entity:" + msgBackupResEntity.toLogString() + " tempPath:" + l3 + " exist:" + a16 + " realPath:" + k3 + " exist:" + a17);
        }
        if (!a16 && !a17) {
            z16 = true;
        }
        kVar.f251095a = z16;
        kVar.f251096b = l3;
        return kVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String k3 = k(this.f251272c);
        if (TextUtils.isEmpty(k3)) {
            b("getTempPath realPath is null");
            return null;
        }
        return l(k3);
    }

    public String j(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgBackupResEntity);
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            return "";
        }
        String dataMigrationGetResourceLocalDestinyPath = e16.dataMigrationGetResourceLocalDestinyPath(new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr));
        if (dataMigrationGetResourceLocalDestinyPath != null && !TextUtils.isEmpty(dataMigrationGetResourceLocalDestinyPath)) {
            return dataMigrationGetResourceLocalDestinyPath;
        }
        QLog.d("MsgBackup", 1, "MsgProcessPic picSavePath is null or empty");
        return "";
    }

    public String k(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgBackupResEntity);
        }
        return j(msgBackupResEntity);
    }

    public String l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        try {
            return com.tencent.mobileqq.msgbackup.util.a.f251368a + str.substring(c.e());
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
