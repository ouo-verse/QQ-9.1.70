package com.tencent.qzone.image.api;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qzone.image.decode.c;
import com.tencent.qzone.image.decode.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<com.tencent.qzone.image.decode.a> f364010a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static a f364011a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16967);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364011a = new a(null);
            }
        }
    }

    /* synthetic */ a(C9722a c9722a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) c9722a);
    }

    public static a c() {
        return b.f364011a;
    }

    public Bitmap a(File file, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, file, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (file == null) {
            ImageManagerLog.e("QzoneImageDecodeManager", "decode fail, file is null, imageKey: " + str);
            return null;
        }
        try {
            for (com.tencent.qzone.image.decode.a aVar : f364010a) {
                if (aVar.a(file)) {
                    ImageManagerLog.w("QzoneImageDecodeManager", "handle decoder: " + aVar + ", imageKey: " + str + ", width: " + i3 + ", height: " + i16);
                    Bitmap b16 = aVar.b(file, str, i3, i16);
                    if (b16 != null) {
                        ImageManagerLog.w("QzoneImageDecodeManager", "decodeImage result: " + b16 + ", imageKey: " + str + ", outWidth: " + b16.getWidth() + ", outHeight: " + b16.getHeight());
                        return b16;
                    }
                    ImageManagerLog.e("QzoneImageDecodeManager", "decodeImage result is null, imageKey: " + str);
                }
            }
            ImageManagerLog.w("QzoneImageDecodeManager", "no decoder can handle, imageKey: " + str);
        } catch (Throwable th5) {
            ImageManagerLog.fatal("QzoneImageDecodeManager", th5);
        }
        return null;
    }

    public Bitmap b(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (!TextUtils.isEmpty(str)) {
            return a(new File(str), str2, i3, i16);
        }
        ImageManagerLog.e("QzoneImageDecodeManager", "decode fail, file path is empty, imageKey: " + str2);
        return null;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f364010a = arrayList;
        arrayList.add(new com.tencent.qzone.image.decode.b());
        f364010a.add(new d());
        f364010a.add(new c());
    }
}
