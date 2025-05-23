package com.tencent.luggage.wxa.s1;

import android.graphics.Typeface;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.s8.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.magicbrush.MBRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f139989a = new a();

    public void a(MBRuntime mBRuntime, g gVar) {
        ((i) mBRuntime.e()).a(new C6698a(new WeakReference(gVar)));
    }

    public byte[] a(String str, l lVar) {
        String b16;
        if (str != null && str.length() != 0) {
            w.d("MBFontManagerRegistry", "readDataFromURLSync at path[%s]", str);
            if (lVar == null) {
                w.f("MBFontManagerRegistry", "service released");
                return null;
            }
            g runtime = lVar.getRuntime();
            if (runtime == null) {
                w.f("MBFontManagerRegistry", "no runtime provided");
                return null;
            }
            try {
                if (str.startsWith("wxfile://")) {
                    v absoluteFile = runtime.P().getAbsoluteFile(str);
                    if (absoluteFile != null) {
                        b16 = absoluteFile.g();
                    } else {
                        w.b("MBFontManagerRegistry", "read [%s] from filesystem failed, no file", str);
                        b16 = null;
                    }
                } else {
                    b16 = k0.b(runtime, str);
                }
                if (b16 == null) {
                    w.b("MBFontManagerRegistry", "read file failed");
                    return null;
                }
                byte[] byteArray = IOUtils.toByteArray(x.n(b16));
                if (byteArray != null) {
                    w.d("MBFontManagerRegistry", "readFile success, size = %d", Integer.valueOf(byteArray.length));
                } else {
                    w.b("MBFontManagerRegistry", "readFile at path [%s] failed", b16);
                }
                return byteArray;
            } catch (Exception e16) {
                w.a("MBFontManagerRegistry", e16, "readDataFromURLSync failed", new Object[0]);
                return null;
            }
        }
        w.f("MBFontManagerRegistry", "read data with empty path");
        return null;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6698a implements com.tencent.luggage.wxa.s8.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139990a;

        public C6698a(WeakReference weakReference) {
            this.f139990a = weakReference;
        }

        @Override // com.tencent.luggage.wxa.s8.b
        public byte[] a(String str) {
            String b16 = b(str);
            if (b16 == null) {
                w.d("MBFontManagerRegistry", "getFontData [%s] failed", str);
                return new byte[0];
            }
            try {
                byte[] byteArray = IOUtils.toByteArray(x.n(b16));
                w.d("MBFontManagerRegistry", "getFontData [%s], size[%d]", str, Integer.valueOf(byteArray.length));
                return byteArray;
            } catch (IOException e16) {
                w.b("MBFontManagerRegistry", "getFontData [%s] failed [%s]", str, e16);
                return new byte[0];
            }
        }

        @Override // com.tencent.luggage.wxa.s8.b
        public String b(String str) {
            w.d("MBFontManagerRegistry", "getFontPath at path[%s]", str);
            if (str == null || str.length() == 0) {
                return null;
            }
            g gVar = (g) this.f139990a.get();
            if (gVar == null) {
                w.b("MBFontManagerRegistry", "hy: runtime released");
                return null;
            }
            if (str.startsWith("wxfile://")) {
                return a(gVar, str);
            }
            return b(gVar, str);
        }

        @Override // com.tencent.luggage.wxa.s8.b
        public Typeface loadFont(String str) {
            w.d("MBFontManagerRegistry", "loadFont at path[%s]", str);
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                return Typeface.createFromFile(str);
            } catch (Exception unused) {
                w.b("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", str);
                return null;
            }
        }

        public final String a(g gVar, String str) {
            v absoluteFile;
            try {
                absoluteFile = gVar.P().getAbsoluteFile(str);
            } catch (Exception unused) {
                w.b("MBFontManagerRegistry", "Read [%s] from filesystem failed", str);
            }
            if (absoluteFile != null) {
                return absoluteFile.g();
            }
            w.b("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", str);
            return null;
        }

        public final String b(g gVar, String str) {
            try {
                return k0.b(gVar, str);
            } catch (Exception unused) {
                w.b("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", str);
                return null;
            }
        }
    }
}
