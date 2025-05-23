package com.tencent.upload.task.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.utils.Const;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileInfo {
    static IPatchRedirector $redirector_;
    public Map<String, String> extendInfo;
    public String fileId;
    public Const.FileType fileType;
    public String url;

    public FileInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.fileId = "";
        this.extendInfo = new HashMap();
    }
}
