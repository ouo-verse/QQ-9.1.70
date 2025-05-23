package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LoverImageUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public String albumId;
    public int code;
    public int height;
    public String name;
    public String photoId;
    public int picType;
    public int uploadTs;
    public String url;
    public int width;

    public LoverImageUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.code = 0;
        this.url = "";
        this.albumId = "";
        this.photoId = "";
        this.width = 0;
        this.height = 0;
        this.name = "";
        this.uploadTs = 0;
        this.picType = 0;
    }
}
