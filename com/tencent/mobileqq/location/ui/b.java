package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f241553c;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, com.tencent.mobileqq.location.model.a> f241554a;

    /* renamed from: b, reason: collision with root package name */
    private final IFaceDecoder f241555b;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241554a = new HashMap<>(10);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f241555b = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
    }

    public static b c() {
        if (f241553c == null) {
            synchronized (b.class) {
                if (f241553c == null) {
                    f241553c = new b();
                }
            }
        }
        return f241553c;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f241555b;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        f241553c = null;
    }

    public com.tencent.mobileqq.location.model.a b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.location.model.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return this.f241554a.get(str);
    }

    public Bitmap d(String str) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.location.model.a aVar = this.f241554a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar != null) {
            if (currentTimeMillis - aVar.f241298a < 4000 && (bitmap = aVar.f241300c) != null) {
                return bitmap;
            }
            if (currentTimeMillis - aVar.f241299b < 2000) {
                return null;
            }
        } else {
            aVar = new com.tencent.mobileqq.location.model.a();
            this.f241554a.put(str, aVar);
        }
        aVar.f241299b = currentTimeMillis;
        Bitmap bitmapFromCache = this.f241555b.getBitmapFromCache(1, str);
        if (bitmapFromCache == null) {
            this.f241555b.requestDecodeFace(str, 200, false, 1, true, (byte) 0, 4);
        } else {
            aVar.f241298a = currentTimeMillis;
            aVar.f241300c = bitmapFromCache;
        }
        return bitmapFromCache;
    }

    public void e(String str, com.tencent.mobileqq.location.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) aVar);
        } else {
            this.f241554a.put(str, aVar);
        }
    }

    public void f(DecodeTaskCompletionListener decodeTaskCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) decodeTaskCompletionListener);
        } else {
            this.f241555b.setDecodeTaskCompletionListener(decodeTaskCompletionListener);
        }
    }
}
