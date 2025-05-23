package com.tencent.ams.fusion.widget.apng.frame.animation.loader;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AssetStreamLoader extends StreamLoader {
    static IPatchRedirector $redirector_;
    private final String mAssetName;
    private final Context mContext;

    public AssetStreamLoader(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        } else {
            this.mContext = context.getApplicationContext();
            this.mAssetName = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.StreamLoader
    protected InputStream getInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InputStream) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext.getAssets().open(this.mAssetName);
    }
}
