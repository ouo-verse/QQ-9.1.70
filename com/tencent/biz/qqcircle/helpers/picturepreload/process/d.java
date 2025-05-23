package com.tencent.biz.qqcircle.helpers.picturepreload.process;

import android.os.Message;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends a {
    private void f(Option option, boolean z16) {
        String localPath;
        int seq;
        u30.a f16 = u30.d.d().f();
        if (f16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadTaskResultProcess", 1, "[updatePreloadTaskFail] data cache should not be null.");
            return;
        }
        if (option == null) {
            localPath = null;
        } else {
            localPath = option.getLocalPath();
        }
        if (option == null) {
            seq = 0;
        } else {
            seq = option.getSeq();
        }
        QLog.d("PIC_LOAD_QFSPicturePreloadTaskResultProcess", 1, "[updatePreloadTaskResult] seq: " + seq + " | isSuccess: " + z16 + " | localPath: " + localPath);
        f16.h(localPath, z16);
        f16.f(localPath);
    }

    @Override // com.tencent.biz.qqcircle.helpers.picturepreload.process.a
    public boolean e(Message message) {
        Option d16 = d(message);
        if (d16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadTaskResultProcess", 1, "[handlerMessage] option should not be null.");
            return false;
        }
        LoadState c16 = c(message);
        if (c16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadTaskResultProcess", 1, "[handlerMessage] state should not be null.");
            return false;
        }
        if (c16 == LoadState.STATE_PREPARE || c16 == LoadState.STATE_DOWNLOADING) {
            return false;
        }
        if (c16 != LoadState.STATE_DOWNLOAD_SUCCESS && c16 != LoadState.STATE_SUCCESS) {
            f(d16, false);
        } else {
            f(d16, true);
        }
        return true;
    }
}
