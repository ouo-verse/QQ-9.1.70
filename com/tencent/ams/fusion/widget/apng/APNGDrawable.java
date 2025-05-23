package com.tencent.ams.fusion.widget.apng;

import android.content.Context;
import android.os.Handler;
import com.tencent.ams.fusion.widget.apng.decode.APNGDecoder;
import com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.AssetStreamLoader;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.FileLoader;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.ResourceStreamLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class APNGDrawable extends FrameAnimationDrawable<APNGDecoder> {
    static IPatchRedirector $redirector_;

    public APNGDrawable(Loader loader) {
        super(loader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) loader);
    }

    public static APNGDrawable fromAsset(Context context, String str) {
        return new APNGDrawable(new AssetStreamLoader(context, str));
    }

    public static APNGDrawable fromFile(String str) {
        return new APNGDrawable(new FileLoader(str));
    }

    public static APNGDrawable fromResource(Context context, int i3) {
        return new APNGDrawable(new ResourceStreamLoader(context, i3));
    }

    public APNGDrawable(Loader loader, Handler handler) {
        super(loader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setOutHandler(new WeakReference<>(handler));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loader, (Object) handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable
    public APNGDecoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new APNGDecoder(loader, renderListener) : (APNGDecoder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) loader, (Object) renderListener);
    }

    public APNGDrawable(APNGDecoder aPNGDecoder) {
        super(aPNGDecoder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) aPNGDecoder);
    }
}
