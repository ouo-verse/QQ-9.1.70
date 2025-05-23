package ac1;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.filemanager.fileviewer.d {

    /* renamed from: h, reason: collision with root package name */
    private FileManagerEntity f25792h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f25793i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f25794j;

    /* renamed from: k, reason: collision with root package name */
    protected long f25795k;

    public a(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.f25792h = fileManagerEntity;
        boolean z16 = true;
        if (1 == v() || 2 == v()) {
            this.f25793i = FileManagerUtil.canPreview(qQAppInterface.getApplication().getBaseContext(), fileManagerEntity.fileName, fileManagerEntity.fileSize);
        }
        this.f25795k = 3145728L;
        if ((3 != v() || !FileManagerUtil.isTBSPreviewLocal(this)) && (6 != v() || c() != 1 || !FileUtils.fileExistsAndNotEmpty(getFilePath()))) {
            z16 = false;
        }
        this.f25794j = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int a() {
        return this.f25792h.nOpType;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int b() {
        return this.f25792h.peerType;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int c() {
        FileManagerEntity fileManagerEntity = this.f25792h;
        if (fileManagerEntity.isZipInnerFile && q.f(fileManagerEntity.getFilePath())) {
            this.f25792h.status = 1;
        }
        return this.f25792h.status;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void d(FileManagerEntity fileManagerEntity) {
        this.f25792h = fileManagerEntity;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String e() {
        FileManagerEntity fileManagerEntity = this.f25792h;
        if (fileManagerEntity.nFileType == 5 && q.f(fileManagerEntity.getFilePath())) {
            return this.f25792h.getFilePath();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public FileManagerEntity getEntity() {
        return this.f25792h;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileId() {
        return this.f25792h.WeiYunFileId;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFileName() {
        return this.f25792h.fileName;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getFilePath() {
        return this.f25792h.getFilePath();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getFileSize() {
        return this.f25792h.fileSize;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int getFileType() {
        return this.f25792h.nFileType;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getPeerUin() {
        return this.f25792h.peerUin;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long getSessionId() {
        return this.f25792h.nSessionId;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String getUuid() {
        return this.f25792h.Uuid;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public boolean o() {
        return this.f25792h.bSend;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.d, com.tencent.mobileqq.filemanager.fileviewer.j
    public String q() {
        if (q.f(this.f25792h.getFilePath())) {
            return this.f25792h.getFilePath();
        }
        return this.f25792h.strLargeThumPath;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public WeiYunFileInfo s() {
        if (QLog.isDevelopLevel()) {
            QLog.w("EntityFileViewerAdapter", 4, "getWeiyunInfo should not be called on EntityFileViewAdapter");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void t(String str) {
        this.f25792h.strLargeThumPath = str;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String u() {
        if (q.f(this.f25792h.getFilePath())) {
            return this.f25792h.getFilePath();
        }
        return this.f25792h.strThumbPath;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public int v() {
        int cloudType = this.f25792h.getCloudType();
        if ((2 == cloudType || 5 == cloudType) && q.f(getFilePath())) {
            return 3;
        }
        return cloudType;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public long w() {
        return this.f25792h.srvTime;
    }
}
