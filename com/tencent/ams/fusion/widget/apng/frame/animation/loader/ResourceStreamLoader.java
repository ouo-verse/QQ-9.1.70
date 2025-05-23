package com.tencent.ams.fusion.widget.apng.frame.animation.loader;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResourceStreamLoader extends StreamLoader {
    static IPatchRedirector $redirector_;
    private final Context mContext;
    private final int mResId;

    public ResourceStreamLoader(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.mContext = context.getApplicationContext();
            this.mResId = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.StreamLoader
    protected InputStream getInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InputStream) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext.getResources().openRawResource(this.mResId);
    }
}
