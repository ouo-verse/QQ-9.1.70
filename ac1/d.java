package ac1;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends com.tencent.mobileqq.filemanager.fileviewer.d {

    /* renamed from: h, reason: collision with root package name */
    private final QQAppInterface f25798h;

    /* renamed from: i, reason: collision with root package name */
    private WeiYunFileInfo f25799i;

    /* renamed from: j, reason: collision with root package name */
    private FileManagerEntity f25800j;

    public d(QQAppInterface qQAppInterface, WeiYunFileInfo weiYunFileInfo) {
        this.f25798h = qQAppInterface;
        this.f25799i = weiYunFileInfo;
    }

    private void k(FileManagerEntity fileManagerEntity) {
        this.f25800j = fileManagerEntity;
        ah.e(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int a() {
        if (QLog.isDevelopLevel()) {
            QLog.w("WeiyunFileViewerAdapter", 4, "getOpType: has not opType");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int b() {
        return 0;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int c() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.status;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("WeiyunFileViewerAdapter", 4, "getFileStatus: has not status");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void d(FileManagerEntity fileManagerEntity) {
        k(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String e() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null && fileManagerEntity.nFileType == 5 && q.f(fileManagerEntity.getFilePath())) {
            return this.f25800j.getFilePath();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public FileManagerEntity getEntity() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            return fileManagerEntity;
        }
        FileManagerEntity c16 = this.f25798h.getFileManagerRSCenter().c(this.f25799i.f209603d);
        if (c16 == null) {
            c16 = this.f25798h.getFileManagerDataCenter().H(this.f25799i.f209603d);
        }
        if (c16 == null) {
            c16 = FileManagerUtil.newEntityByWeiYunFileInfo(this.f25799i);
        }
        if (c16 != null) {
            k(c16);
        }
        return this.f25800j;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileId() {
        return this.f25799i.f209603d;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileName() {
        return this.f25799i.f209605f;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFilePath() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.getFilePath();
        }
        FileManagerEntity c16 = this.f25798h.getFileManagerRSCenter().c(this.f25799i.f209603d);
        if (c16 == null) {
            c16 = this.f25798h.getFileManagerDataCenter().H(this.f25799i.f209603d);
        }
        if (c16 != null) {
            k(c16);
            return c16.getFilePath();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getFileSize() {
        return this.f25799i.f209606h;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int getFileType() {
        WeiYunFileInfo weiYunFileInfo = this.f25799i;
        if (weiYunFileInfo.K && weiYunFileInfo.f209605f.toLowerCase().endsWith("heic")) {
            return 0;
        }
        return FileManagerUtil.getFileType(this.f25799i.f209605f);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getPeerUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getSessionId() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.nSessionId;
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getUuid() {
        return null;
    }

    public void l(String str) {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            fileManagerEntity.strThumbPath = str;
        } else {
            this.f25799i.H = str;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public boolean o() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.d, com.tencent.mobileqq.filemanager.fileviewer.j
    public String q() {
        return u();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public WeiYunFileInfo s() {
        return this.f25799i;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void t(String str) {
        l(str);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String u() {
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            if (q.f(fileManagerEntity.getFilePath())) {
                return this.f25800j.getFilePath();
            }
            return this.f25800j.strThumbPath;
        }
        FileManagerEntity c16 = this.f25798h.getFileManagerRSCenter().c(this.f25799i.f209603d);
        if (c16 == null) {
            c16 = this.f25798h.getFileManagerDataCenter().H(this.f25799i.f209603d);
        }
        if (c16 != null) {
            k(c16);
            if (q.f(c16.getFilePath())) {
                return c16.getFilePath();
            }
            return c16.strThumbPath;
        }
        return this.f25799i.H;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int v() {
        int i3;
        FileManagerEntity fileManagerEntity = this.f25800j;
        if (fileManagerEntity != null) {
            i3 = fileManagerEntity.getCloudType();
        } else {
            FileManagerEntity c16 = this.f25798h.getFileManagerRSCenter().c(this.f25799i.f209603d);
            if (c16 == null) {
                c16 = this.f25798h.getFileManagerDataCenter().H(this.f25799i.f209603d);
            }
            if (c16 != null) {
                k(c16);
                i3 = c16.getCloudType();
            } else {
                i3 = 2;
            }
        }
        if (2 == i3 && q.f(getFilePath())) {
            return 3;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long w() {
        return e.K0() * 1000;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.d, com.tencent.mobileqq.filemanager.fileviewer.j
    public String x() {
        return q.g(getFileSize());
    }
}
