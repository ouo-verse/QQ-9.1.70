package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f251279f;

    /* renamed from: d, reason: collision with root package name */
    private String f251280d;

    /* renamed from: e, reason: collision with root package name */
    private String f251281e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f251279f = RmVFSUtils.getVFSPath(com.tencent.mobileqq.msgbackup.util.a.f251368a + "shortvideo" + File.separator);
    }

    public k(MsgBackupResEntity msgBackupResEntity) {
        super(msgBackupResEntity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgBackupResEntity);
            return;
        }
        this.f251280d = this.f251271b.get("md5");
        this.f251281e = this.f251271b.get("thumbMd5");
        if (TextUtils.isEmpty(this.f251280d) || TextUtils.isEmpty(this.f251281e)) {
            b("md5:" + this.f251280d + " mThumbMD5:" + this.f251281e);
        }
    }

    private String j(String str) {
        return f251279f + str;
    }

    private String k(String str) {
        return f251279f + "thumbs" + File.separator + str;
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            return "";
        }
        MsgBackupResEntity msgBackupResEntity = this.f251272c;
        String dataMigrationGetResourceLocalDestinyPath = e16.dataMigrationGetResourceLocalDestinyPath(new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr));
        if (dataMigrationGetResourceLocalDestinyPath != null && !TextUtils.isEmpty(dataMigrationGetResourceLocalDestinyPath)) {
            return dataMigrationGetResourceLocalDestinyPath;
        }
        QLog.d("MsgBackup", 1, "MsgProcessVideo videoSavePath is null or empty");
        return "";
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public com.tencent.mobileqq.msgbackup.controller.k d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.msgbackup.controller.k) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MsgBackupResEntity msgBackupResEntity = this.f251272c;
        int i3 = msgBackupResEntity.msgSubType;
        com.tencent.mobileqq.msgbackup.controller.k kVar = new com.tencent.mobileqq.msgbackup.controller.k();
        String f16 = f();
        String c16 = c();
        boolean a16 = a(f16);
        boolean a17 = a(c16);
        if (QLog.isColorLevel()) {
            b("getResDownloadObject,entity:" + msgBackupResEntity.toLogString() + " tempPath:" + f16 + " exist:" + a16 + " realPath:" + c16 + " exist:" + a17);
        }
        kVar.f251096b = f16;
        if (!a16 && !a17) {
            z16 = true;
        } else {
            z16 = false;
        }
        kVar.f251095a = z16;
        return kVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        switch (this.f251272c.msgSubType) {
            case 4:
            case 5:
            case 6:
                return j(this.f251280d);
            case 7:
            case 8:
            case 9:
                return k(this.f251281e);
            default:
                return null;
        }
    }
}
