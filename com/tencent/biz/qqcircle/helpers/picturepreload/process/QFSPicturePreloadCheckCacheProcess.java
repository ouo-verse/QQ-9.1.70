package com.tencent.biz.qqcircle.helpers.picturepreload.process;

import android.os.Message;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class QFSPicturePreloadCheckCacheProcess extends a {

    /* loaded from: classes4.dex */
    private static class GenerateOptionKeyTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Option> f84647d;

        public GenerateOptionKeyTask(Option option) {
            this.f84647d = new WeakReference<>(option);
        }

        private void a(Option option, String str) {
            if (option == null) {
                QLog.e("PIC_LOAD_QFSPicturePreloadCheckCacheProcess", 1, "[notifyCacheKeyGenerateFinish] option should not be null.");
                return;
            }
            u30.a f16 = u30.d.d().f();
            if (f16 == null) {
                QLog.e("PIC_LOAD_QFSPicturePreloadCheckCacheProcess", 1, "[notifyCacheKeyGenerateFinish] data cache should not be null.");
            } else {
                if (f16.d(str)) {
                    return;
                }
                u30.d.d().k(option);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Option option;
            WeakReference<Option> weakReference = this.f84647d;
            if (weakReference == null) {
                option = null;
            } else {
                option = weakReference.get();
            }
            if (option == null) {
                QLog.e("PIC_LOAD_QFSPicturePreloadCheckCacheProcess", 1, "[run] option is null, end flow.");
            } else {
                a(option, QCircleFeedPicLoader.g().getPicLocalPath(option));
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.helpers.picturepreload.process.a
    public boolean e(Message message) {
        Option d16 = d(message);
        if (d16 == null) {
            QLog.e("PIC_LOAD_QFSPicturePreloadCheckCacheProcess", 1, "[handlerMessage] option should not be null, end flow.");
            return false;
        }
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new GenerateOptionKeyTask(d16));
        return true;
    }
}
