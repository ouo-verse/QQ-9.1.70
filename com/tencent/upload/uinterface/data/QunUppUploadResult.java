package com.tencent.upload.uinterface.data;

import FileUpload.stPhotoSepcInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QunUppUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public Map<Long, stPhotoSepcInfo> mapSpecInfo;
    public String photoId;
    public String url;

    public QunUppUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.photoId = "";
        this.mapSpecInfo = null;
    }
}
