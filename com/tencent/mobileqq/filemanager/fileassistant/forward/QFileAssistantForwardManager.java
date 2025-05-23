package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileAssistantForwardManager {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f207998a;

    /* renamed from: b, reason: collision with root package name */
    private String f207999b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f208000c = false;

    public QFileAssistantForwardManager(QQAppInterface qQAppInterface) {
        this.f207998a = qQAppInterface;
        this.f207999b = h.g(qQAppInterface);
    }

    private void d(final String str) {
        if (!this.f208000c) {
            return;
        }
        String string = this.f207998a.getApp().getString(R.string.f170969bc3);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
                    QQToast.makeText(QFileAssistantForwardManager.this.f207998a.getApp(), 2, str, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            }
        }, 300L);
    }

    public void b(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return;
        }
        FileManagerEngine fileManagerEngine = this.f207998a.getFileManagerEngine();
        if (fileManagerEntity.getCloudType() == 4) {
            fileManagerEngine.G(fileManagerEntity.nSessionId, fileManagerEntity.strFilePath, fileManagerEntity.TroopUin, Long.valueOf(this.f207999b).longValue(), "", 0, 0);
        } else {
            fileManagerEngine.D0(fileManagerEntity.nSessionId, this.f207998a.getAccount(), this.f207999b, "", 0, true);
        }
        d("");
    }

    public void c(boolean z16) {
        this.f208000c = z16;
    }
}
