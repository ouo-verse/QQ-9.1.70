package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends VideoForC2C {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.filemanager.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.b f208247a;

        a(g.b bVar) {
            this.f208247a = bVar;
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void a(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
            long j17;
            QLog.i("VideoForDisc<QFile>", 2, "[" + g.this.f208221a.nSessionId + "],[getOnlinePlay Url]  ID[" + j16 + "] OnDiscDownloadInfo");
            if (j3 != -100001) {
                if (j3 != -25081 && j3 != -6101 && j3 != -7003) {
                    if (!z16) {
                        g.this.d(false);
                        this.f208247a.onError((int) 0, BaseApplication.getContext().getResources().getString(R.string.a5j));
                        return;
                    }
                } else {
                    g.this.d(true);
                    this.f208247a.onError((int) j3, BaseApplication.getContext().getResources().getString(R.string.bfo));
                    return;
                }
            }
            if (str3 != null && str3.length() != 0) {
                String str6 = "http://" + str3 + ":" + String.valueOf(i3) + "/ftn_handler/" + str4;
                if (QLog.isColorLevel()) {
                    QLog.d("VideoForDisc<QFile>", 1, str6);
                }
                this.f208247a.b(str6, str5);
                return;
            }
            if (j3 == 0) {
                j17 = 9048;
            } else {
                j17 = 9360;
            }
            this.f208247a.onError((int) j17, BaseApplication.getContext().getResources().getString(R.string.a5j));
        }
    }

    public g(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C, com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        this.f208221a.nOpType = 1;
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForDisc<QFile>", 1, "getUrl appInterface is null return");
            return;
        }
        FileTransferHandler fileTransferHandler = i3.getFileTransferHandler();
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileTransferHandler.F(fileManagerEntity.nSessionId, fileManagerEntity.fileName, Long.parseLong(fileManagerEntity.peerUin), this.f208221a.Uuid, new a(bVar));
    }
}
