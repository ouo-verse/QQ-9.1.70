package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends TransProcessorHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static String f259947b;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<PLUploadManager> f259948a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f259947b = "PLTransProcessorHandler";
        }
    }

    public b(PLUploadManager pLUploadManager, Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pLUploadManager, (Object) looper);
        } else {
            this.f259948a = new WeakReference<>(pLUploadManager);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        PLUploadManager.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        FileMsg fileMsg = (FileMsg) message.obj;
        if (fileMsg.fileType != 56) {
            return;
        }
        PLUploadManager pLUploadManager = this.f259948a.get();
        if (pLUploadManager == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f259947b, 2, "PLUploadManager is null");
                return;
            }
            return;
        }
        String str = fileMsg.fileKey;
        if (QLog.isColorLevel()) {
            QLog.i(f259947b, 2, "personality_label handlemsg key:" + str);
        }
        int i3 = 0;
        while (true) {
            if (i3 < pLUploadManager.f259791h.size()) {
                if (pLUploadManager.f259791h.get(i3).f259798d.getKeyForTransfer().equals(str)) {
                    aVar = pLUploadManager.f259791h.get(i3);
                    break;
                }
                i3++;
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f259947b, 2, "personality_label handlemsg find:" + aVar.f259797c.uniseq);
        }
        switch (message.what) {
            case 1001:
                aVar.f259800f = 0;
                aVar.f259799e = 1;
                break;
            case 1002:
                aVar.f259799e = 2;
                aVar.f259800f = (int) ((fileMsg.transferedSize * 100) / fileMsg.fileSize);
                break;
            case 1003:
                aVar.f259799e = 4;
                PersonalityLabelPhoto personalityLabelPhoto = aVar.f259797c;
                personalityLabelPhoto.fileId = fileMsg.fileID;
                personalityLabelPhoto.url = fileMsg.fileUrl;
                if (aVar.f259800f < 100) {
                    aVar.f259800f = 100;
                }
                pLUploadManager.f259791h.remove(aVar);
                break;
            case 1005:
                aVar.f259799e = 3;
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f259947b, 2, "personality_label handlemsg. state:" + aVar.f259799e + " " + aVar.f259797c.uniseq);
        }
        if (aVar.f259799e == 4 && QLog.isColorLevel()) {
            QLog.i(f259947b, 2, "personality_label handlemsg url:" + aVar.f259797c.url);
        }
        PLUploadManager.b bVar = pLUploadManager.f259789e;
        if (bVar != null) {
            bVar.w0(aVar.f259796b, aVar);
        }
    }
}
