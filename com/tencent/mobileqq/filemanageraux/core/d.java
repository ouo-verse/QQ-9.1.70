package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f209597a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f209598b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f209599c;

    /* renamed from: d, reason: collision with root package name */
    private final y43.c f209600d;

    /* renamed from: e, reason: collision with root package name */
    private final UploadManager.IUploadStatusListener f209601e;

    /* renamed from: f, reason: collision with root package name */
    private String f209602f;

    public d(String str, Object obj, boolean z16, UploadManager.IUploadStatusListener iUploadStatusListener, y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, obj, Boolean.valueOf(z16), iUploadStatusListener, cVar);
            return;
        }
        this.f209597a = str;
        this.f209598b = obj;
        this.f209599c = z16;
        this.f209601e = iUploadStatusListener;
        this.f209600d = cVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.f209599c) {
            WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.f209597a);
        } else {
            ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).removeJob(this.f209597a);
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f209602f = str;
        }
    }
}
