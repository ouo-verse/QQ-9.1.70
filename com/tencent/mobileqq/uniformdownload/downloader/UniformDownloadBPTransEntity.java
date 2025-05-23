package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "mUrl")
/* loaded from: classes17.dex */
public class UniformDownloadBPTransEntity extends Entity implements Cloneable {
    static IPatchRedirector $redirector_;
    public String mFileName;
    public String mFilePath;
    public long mFileSize;
    public String mTempPath;

    @unique
    public String mUrl;

    public UniformDownloadBPTransEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mFileSize = 0L;
        }
    }

    public static String tableName() {
        return "mr_UDLBPTrans";
    }

    public synchronized void copyFrom(UniformDownloadBPTransEntity uniformDownloadBPTransEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uniformDownloadBPTransEntity);
            return;
        }
        this.mUrl = uniformDownloadBPTransEntity.mUrl;
        this.mFileName = uniformDownloadBPTransEntity.mFileName;
        this.mFileSize = uniformDownloadBPTransEntity.mFileSize;
        this.mTempPath = uniformDownloadBPTransEntity.mTempPath;
        this.mFilePath = uniformDownloadBPTransEntity.mFilePath;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "mr_UDLBPTrans";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UniformDownloadBPTransEntity m227clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UniformDownloadBPTransEntity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            return (UniformDownloadBPTransEntity) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
