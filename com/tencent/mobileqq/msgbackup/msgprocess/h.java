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
public class h extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static final String f251273g;

    /* renamed from: h, reason: collision with root package name */
    public static String f251274h;

    /* renamed from: d, reason: collision with root package name */
    private String f251275d;

    /* renamed from: e, reason: collision with root package name */
    private String f251276e;

    /* renamed from: f, reason: collision with root package name */
    private String f251277f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f251273g = RmVFSUtils.getVFSPath(com.tencent.mobileqq.msgbackup.util.a.f251368a + "ptt" + File.separator);
        f251274h = com.tencent.mobileqq.vfs.d.f312456f;
    }

    public h(MsgBackupResEntity msgBackupResEntity) {
        super(msgBackupResEntity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgBackupResEntity);
            return;
        }
        this.f251275d = this.f251271b.get("md5");
        this.f251276e = this.f251271b.get("uuid");
        String str = this.f251271b.get("selfuin");
        this.f251277f = str;
        if (this.f251275d == null) {
            this.f251275d = "";
        }
        if (this.f251276e == null) {
            this.f251276e = "";
        }
        if (str == null) {
            this.f251277f = "";
        }
        if (TextUtils.isEmpty(this.f251275d) || TextUtils.isEmpty(this.f251276e) || TextUtils.isEmpty(this.f251277f)) {
            b("md5:" + this.f251275d + " mUUID:" + this.f251276e + " mSelfuin:" + this.f251277f);
        }
    }

    public static String j(MsgBackupResEntity msgBackupResEntity) {
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            return "";
        }
        String dataMigrationGetResourceLocalDestinyPath = e16.dataMigrationGetResourceLocalDestinyPath(new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr));
        if (dataMigrationGetResourceLocalDestinyPath != null && !TextUtils.isEmpty(dataMigrationGetResourceLocalDestinyPath)) {
            return dataMigrationGetResourceLocalDestinyPath;
        }
        QLog.d("MsgBackup", 1, "MsgProcessPtt pttSavePath is null or empty");
        return "";
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return j(this.f251272c);
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public com.tencent.mobileqq.msgbackup.controller.k d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.msgbackup.controller.k) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        MsgBackupResEntity msgBackupResEntity = this.f251272c;
        String f16 = f();
        boolean a16 = a(f16);
        if (QLog.isColorLevel()) {
            b("getResDownloadObject,entity:" + msgBackupResEntity.toLogString() + " tempPath:" + f16 + " exist:" + a16);
        }
        com.tencent.mobileqq.msgbackup.controller.k kVar = new com.tencent.mobileqq.msgbackup.controller.k();
        kVar.f251095a = !a16;
        kVar.f251096b = f16;
        return kVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.c
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f251273g + this.f251275d + this.f251276e + this.f251277f;
    }
}
