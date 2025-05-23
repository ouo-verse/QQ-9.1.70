package com.tencent.mobileqq.qzonealbumreddot;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class QzonePhotoGuideNotifyService {
    static IPatchRedirector $redirector_;

    /* renamed from: com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QzonePhotoGuideNotifyService this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("QzonePhotoGuideNotifyServlet", 2, "sendRedRunnable");
                }
                throw null;
            }
        }
    }
}
