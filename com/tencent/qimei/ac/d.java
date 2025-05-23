package com.tencent.qimei.ac;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.uin.U;
import java.lang.ref.WeakReference;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Object> f342937a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f342938a;

        public a(String str) {
            this.f342938a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d.this.a(this.f342938a);
            }
        }
    }

    public d(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.f342937a = new WeakReference<>(obj);
        }
    }

    public final void a(String str) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        String str2 = "javascript:window.qimeiCallback('" + str + "')";
        WeakReference<Object> weakReference = this.f342937a;
        if (weakReference != null) {
            obj = weakReference.get();
        } else {
            obj = null;
        }
        if (obj instanceof WebView) {
            ((WebView) obj).loadUrl(str2);
        } else if (obj instanceof com.tencent.smtt.sdk.WebView) {
            ((com.tencent.smtt.sdk.WebView) obj).loadUrl(str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(String str) {
        String str2;
        byte[] a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        String str3 = com.tencent.qimei.ac.a.f342930a;
        boolean z16 = false;
        try {
            a16 = U.a(str.getBytes("UTF-8"), "35b4cfe6f7eae7acbd7bace522d0db54".getBytes());
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(com.tencent.qimei.ac.a.f342930a, "do encrypt message exception: " + e16, new Object[0]);
        }
        if (a16 != null) {
            char[] cArr = new char[a16.length << 1];
            int i3 = 0;
            for (byte b16 : a16) {
                int i16 = i3 + 1;
                char[] cArr2 = com.tencent.qimei.ac.a.f342931b;
                cArr[i3] = cArr2[(b16 & 240) >>> 4];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            str2 = new String(cArr);
            Handler handler = e.f342940a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z16 = true;
            }
            if (!z16) {
                a(str2);
                return;
            } else {
                e.f342940a.post(new a(str2));
                return;
            }
        }
        str2 = "";
        Handler handler2 = e.f342940a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
        }
        if (!z16) {
        }
    }
}
