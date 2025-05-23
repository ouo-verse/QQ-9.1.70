package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class GlobalImageCache {
    static IPatchRedirector $redirector_;
    public static MQLruCache<String, Object> sImageCache;
    public static int sImageCacheSize;
    public static ConcurrentHashMap<String, Bitmap> sImageHashMap;

    public GlobalImageCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
