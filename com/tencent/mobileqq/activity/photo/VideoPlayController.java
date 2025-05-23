package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public abstract class VideoPlayController {
    static IPatchRedirector $redirector_;

    /* renamed from: com.tencent.mobileqq.activity.photo.VideoPlayController$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ VideoPlayController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "hideCoverRunnable");
                }
                throw null;
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.activity.photo.VideoPlayController$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ VideoPlayController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            throw null;
        }
    }

    /* renamed from: com.tencent.mobileqq.activity.photo.VideoPlayController$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ VideoPlayController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            throw null;
        }
    }

    /* renamed from: com.tencent.mobileqq.activity.photo.VideoPlayController$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ VideoPlayController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            throw null;
        }
    }
}
