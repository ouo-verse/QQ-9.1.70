package com.tencent.mobileqq.filemanager.openbrowser;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends a {

    /* renamed from: c, reason: collision with root package name */
    private t f209038c;

    public i(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface, fileManagerEntity);
        int cloudType;
        boolean z16 = true;
        if (fileManagerEntity.isZipInnerFile && q.f(fileManagerEntity.getFilePath())) {
            fileManagerEntity.status = 1;
        }
        if (fileManagerEntity.isZipInnerFile && FileManagerUtil.isZipFile(qQAppInterface, fileManagerEntity.fileName, fileManagerEntity.status, true)) {
            this.f208988b = false;
        } else {
            this.f208988b = FileManagerUtil.canPreview(qQAppInterface.getApplication().getBaseContext(), fileManagerEntity.fileName, fileManagerEntity.fileSize);
        }
        if (!this.f208988b) {
            return;
        }
        t n3 = TroopFileUtils.n(qQAppInterface, fileManagerEntity);
        this.f209038c = n3;
        int i3 = n3.f294972f;
        if (i3 == 2 || i3 == 3) {
            if (q.f(fileManagerEntity.getFilePath())) {
                cloudType = 3;
            } else {
                cloudType = fileManagerEntity.getCloudType();
            }
            if (cloudType != 3) {
                return;
            }
            if (fileManagerEntity.status != 1 || (TextUtils.isEmpty(fileManagerEntity.Uuid) && TextUtils.isEmpty(fileManagerEntity.WeiYunFileId))) {
                z16 = false;
            }
            this.f208988b = z16;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.openbrowser.a, com.tencent.mobileqq.filebrowser.c
    public int c() {
        if (this.f208987a.getCloudType() == 6 && a() == 31) {
            return super.c();
        }
        t tVar = this.f209038c;
        if (tVar != null) {
            return tVar.f294972f;
        }
        return 0;
    }
}
