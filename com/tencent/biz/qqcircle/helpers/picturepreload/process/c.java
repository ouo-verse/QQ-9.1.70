package com.tencent.biz.qqcircle.helpers.picturepreload.process;

import android.os.Message;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.helpers.picturepreload.process.a {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            u30.d.d().l(option, loadState);
        }
    }

    @Override // com.tencent.biz.qqcircle.helpers.picturepreload.process.a
    public boolean e(Message message) {
        Option d16 = d(message);
        if (d16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadExecuteProcess", 1, "[handlerMessage] option should not be null, end flow.");
            return false;
        }
        u30.a f16 = u30.d.d().f();
        if (f16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadExecuteProcess", 1, "[handlerMessage] current data cache should not be null.");
            return false;
        }
        int seq = d16.getSeq();
        String localPath = d16.getLocalPath();
        if (f16.d(localPath)) {
            QLog.d("PIC_LOAD_QFSPicturePreloadExecuteProcess", 1, "[handlerMessage] current preload exists, not exeute task.");
            return false;
        }
        int b16 = f16.b();
        int c16 = f16.c();
        if (uq3.c.Q5() && c16 >= b16) {
            return false;
        }
        f16.h(localPath, false);
        QLog.d("PIC_LOAD_QFSPicturePreloadExecuteProcess", 1, "[handlerMessage] execute picture preload, seq=" + seq + " | local path: " + localPath + " | url: " + d16.getUrl());
        f16.a(localPath);
        QCircleFeedPicLoader.g().loadImage(d16, new a());
        return true;
    }
}
