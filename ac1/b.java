package ac1;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends com.tencent.mobileqq.filemanager.fileviewer.d {

    /* renamed from: h, reason: collision with root package name */
    private FileInfo f25796h;

    public b(FileInfo fileInfo) {
        this.f25796h = fileInfo;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int a() {
        if (QLog.isDevelopLevel()) {
            QLog.w("LocalFileViewerAdapter", 4, "getOpType: has not opType");
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
        if (QLog.isDevelopLevel()) {
            QLog.w("LocalFileViewerAdapter", 4, "getFileStatus: has not status");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String e() {
        if (this.f25796h.getType() == 5 && q.f(this.f25796h.k())) {
            return this.f25796h.k();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public FileManagerEntity getEntity() {
        if (QLog.isDevelopLevel()) {
            QLog.w("LocalFileViewerAdapter", 4, "getEntity should not be called on LocalFileViewAdapter");
        }
        return ah.k1(this.f25796h);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileId() {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileName() {
        return this.f25796h.j();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFilePath() {
        return this.f25796h.k();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getFileSize() {
        return this.f25796h.l();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int getFileType() {
        if (this.f25796h.getType() == 5) {
            return 5;
        }
        return FileManagerUtil.getFileType(this.f25796h.j());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getPeerUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getSessionId() {
        return -1L;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getUuid() {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public boolean o() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public WeiYunFileInfo s() {
        if (QLog.isDevelopLevel()) {
            QLog.w("LocalFileViewerAdapter", 4, "getWeiyunInfo should not be called on LocalFileViewAdapter");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String u() {
        return this.f25796h.k();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int v() {
        return 3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long w() {
        return e.K0() * 1000;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void d(FileManagerEntity fileManagerEntity) {
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void t(String str) {
    }
}
