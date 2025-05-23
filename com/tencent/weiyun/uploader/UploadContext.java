package com.tencent.weiyun.uploader;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.uploader.xplatform.UploadNative;

/* compiled from: P */
/* loaded from: classes27.dex */
class UploadContext {
    static IPatchRedirector $redirector_;
    private final Context mContext;
    private final IReporter mReporter;
    private final String mTag;
    private final UploadNative mXpUploader;

    public UploadContext(Context context, String str, UploadNative uploadNative, IReporter iReporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, uploadNative, iReporter);
            return;
        }
        this.mContext = context;
        this.mTag = str;
        this.mXpUploader = uploadNative;
        this.mReporter = iReporter;
    }

    public Context context() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    public IReporter reporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IReporter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mReporter;
    }

    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mTag;
    }

    public UploadNative xpUploader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadNative) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mXpUploader;
    }
}
