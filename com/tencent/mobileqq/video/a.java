package com.tencent.mobileqq.video;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static synchronized boolean a(QQAppInterface qQAppInterface, String str, long j3) {
        synchronized (a.class) {
            IHttpCommunicatorListener findProcessor = ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(str + j3);
            if (findProcessor != null && (findProcessor instanceof ShortVideoDownloadProcessor)) {
                ((ShortVideoDownloadProcessor) findProcessor).pause();
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean b(QQAppInterface qQAppInterface, String str, long j3) {
        boolean z16;
        synchronized (a.class) {
            String str2 = str + j3;
            ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
            if (iTransFileController.containsProcessor(str, j3)) {
                IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(str2);
                if (findProcessor != null) {
                    if (findProcessor instanceof IShortVideoUploadProcessor) {
                        ((BaseTransProcessor) findProcessor).pause();
                    } else if (findProcessor instanceof xq2.a) {
                        ((BaseTransProcessor) findProcessor).pause();
                    }
                }
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static synchronized boolean c(QQAppInterface qQAppInterface, String str, long j3) {
        synchronized (a.class) {
            String str2 = str + j3;
            ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
            if (iTransFileController.containsProcessor(str, j3)) {
                IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(str2);
                if (findProcessor != null) {
                    if (findProcessor instanceof IShortVideoUploadProcessor) {
                        ((BaseTransProcessor) findProcessor).pause();
                    } else if (findProcessor instanceof xq2.a) {
                        ((BaseTransProcessor) findProcessor).pause();
                    }
                }
                iTransFileController.removeProcessor(str2);
                return true;
            }
            return false;
        }
    }
}
