package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements com.tencent.mobileqq.filebrowser.c {

    /* renamed from: a, reason: collision with root package name */
    protected FileManagerEntity f208987a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f208988b;

    public a(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.f208987a = fileManagerEntity;
        int d16 = d();
        if (1 == d16 || 2 == d16) {
            this.f208988b = FileManagerUtil.canPreview(qQAppInterface.getApplication().getBaseContext(), fileManagerEntity.fileName, fileManagerEntity.fileSize);
        }
    }

    private int d() {
        int cloudType = this.f208987a.getCloudType();
        if ((2 == cloudType || 5 == cloudType) && q.f(getFilePath())) {
            return 3;
        }
        return cloudType;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public int a() {
        return this.f208987a.nOpType;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public int b() {
        return this.f208987a.peerType;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public int c() {
        FileManagerEntity fileManagerEntity = this.f208987a;
        if (fileManagerEntity.isZipInnerFile && q.f(fileManagerEntity.getFilePath())) {
            this.f208987a.status = 1;
        }
        return this.f208987a.status;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String e() {
        FileManagerEntity fileManagerEntity = this.f208987a;
        if (fileManagerEntity.nFileType == 5 && q.f(fileManagerEntity.getFilePath())) {
            return this.f208987a.getFilePath();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String f() {
        return this.f208987a.apkSafeMsg;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public int g() {
        return this.f208987a.apkSafeLevel;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String getFileId() {
        return this.f208987a.WeiYunFileId;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String getFileName() {
        return this.f208987a.fileName;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String getFilePath() {
        return this.f208987a.getFilePath();
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public long getFileSize() {
        return this.f208987a.fileSize;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public int getFileType() {
        return this.f208987a.nFileType;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public long getSessionId() {
        return this.f208987a.nSessionId;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public long getTroopUin() {
        return this.f208987a.TroopUin;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String getUuid() {
        return this.f208987a.Uuid;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public void h(FileManagerEntity fileManagerEntity) {
        this.f208987a = fileManagerEntity;
    }

    @Override // com.tencent.mobileqq.filebrowser.c
    public String i() {
        return this.f208987a.apkSafeDetailUrl;
    }
}
