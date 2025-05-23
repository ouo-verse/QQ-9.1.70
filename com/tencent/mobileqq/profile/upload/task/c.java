package com.tencent.mobileqq.profile.upload.task;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements Manager {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends com.tencent.mobileqq.profile.upload.config.a {
        static IPatchRedirector $redirector_;

        a(long j3) {
            super(j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadConfig
        public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize uploadImageSize, int i3, AbstractUploadTask abstractUploadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IUploadConfig.UploadImageSize) iPatchRedirector.redirect((short) 2, this, uploadImageSize, Integer.valueOf(i3), abstractUploadTask);
            }
            Bitmap e16 = com.tencent.mobileqq.profile.upload.a.e(abstractUploadTask.uploadFilePath);
            if (e16 != null) {
                IUploadConfig.UploadImageSize uploadImageSize2 = new IUploadConfig.UploadImageSize(e16.getWidth(), e16.getHeight(), 100);
                e16.recycle();
                return uploadImageSize2;
            }
            return new IUploadConfig.UploadImageSize(640, 1136, 100);
        }
    }

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        }
    }

    private void a(QQAppInterface qQAppInterface, com.tencent.mobileqq.profile.upload.config.a aVar) {
        UploadEnv uploadEnv = new UploadEnv();
        if (aVar != null) {
            UploadServiceBuilder.getInstance().init(qQAppInterface.getApp().getApplicationContext(), aVar, null, null, uploadEnv, uploadEnv);
        } else {
            UploadServiceBuilder.getInstance().init(qQAppInterface.getApp().getApplicationContext(), new a(Long.parseLong(qQAppInterface.getCurrentAccountUin())), null, null, uploadEnv, uploadEnv);
        }
    }

    public void b(QQAppInterface qQAppInterface, com.tencent.mobileqq.profile.upload.config.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) aVar);
        } else if (!UploadServiceBuilder.getInstance().isInitialized()) {
            a(qQAppInterface, aVar);
        }
    }

    public void c(QQAppInterface qQAppInterface, com.tencent.mobileqq.profile.upload.task.a aVar, com.tencent.mobileqq.profile.upload.config.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, aVar, aVar2);
            return;
        }
        if (!UploadServiceBuilder.getInstance().isInitialized()) {
            a(qQAppInterface, aVar2);
        }
        aVar.g();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
