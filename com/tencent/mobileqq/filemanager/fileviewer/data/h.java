package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h extends VideoForC2C {
    public h(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C, com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        if (TextUtils.isEmpty(this.f208221a.strServerPath)) {
            d(true);
            bVar.onError(-6101, k(R.string.bfo));
            QLog.e("VideoForQQMail<QFile>XOXO", 2, "[" + this.f208221a.nSessionId + "],[getOnlinePlay] serverpath is null");
            return;
        }
        bVar.b(this.f208221a.strServerPath, "");
    }

    String k(int i3) {
        return BaseApplication.getContext().getResources().getString(i3);
    }
}
