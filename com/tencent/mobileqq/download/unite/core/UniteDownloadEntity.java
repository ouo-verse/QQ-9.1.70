package com.tencent.mobileqq.download.unite.core;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.base.g;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "apkMd5")
/* loaded from: classes10.dex */
public class UniteDownloadEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "[UniteDownload] UniteDownloadEntity";
    public String apkMd5;
    public String apkPath;
    public String appId;
    public long downloadTimestamp;
    public String source;

    public UniteDownloadEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static UniteDownloadEntity fromDownloadInfo(DownloadInfo downloadInfo) {
        UniteDownloadEntity uniteDownloadEntity = new UniteDownloadEntity();
        uniteDownloadEntity.downloadTimestamp = NetConnInfoCenter.getServerTimeMillis();
        uniteDownloadEntity.apkPath = downloadInfo.L;
        uniteDownloadEntity.apkMd5 = g.b(new File(downloadInfo.L));
        uniteDownloadEntity.source = downloadInfo.M;
        uniteDownloadEntity.appId = downloadInfo.f341184e;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[db] fromDownloadInfo: invoked. ", " uniteDownloadEntity: ", uniteDownloadEntity);
        }
        return uniteDownloadEntity;
    }

    public static String tableName() {
        return new UniteDownloadEntity().getTableName();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "UniteDownloadEntity{source='" + this.source + "', apkMd5='" + this.apkMd5 + "', apkPath='" + this.apkPath + "', downloadTimestamp=" + this.downloadTimestamp + ", appId='" + this.appId + "'}";
    }
}
