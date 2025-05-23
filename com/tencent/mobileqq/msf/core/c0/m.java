package com.tencent.mobileqq.msf.core.c0;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f247880a = "VideoProxyRateReport";

    /* renamed from: b, reason: collision with root package name */
    static String f247881b = "";

    /* renamed from: c, reason: collision with root package name */
    static m f247882c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f247883d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f247884e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f247885f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f247886g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f247887h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f247888i = 5;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247889j = 6;

    /* renamed from: k, reason: collision with root package name */
    public static final int f247890k = 7;

    /* renamed from: l, reason: collision with root package name */
    public static final int f247891l = 8;

    /* renamed from: m, reason: collision with root package name */
    public static final int f247892m = 9;

    /* renamed from: n, reason: collision with root package name */
    public static final int f247893n = 10;

    /* renamed from: o, reason: collision with root package name */
    public static final int f247894o = 11;

    /* renamed from: p, reason: collision with root package name */
    public static final int f247895p = 12;

    /* renamed from: q, reason: collision with root package name */
    public static final int f247896q = 13;

    /* renamed from: r, reason: collision with root package name */
    public static final int f247897r = 14;

    /* renamed from: s, reason: collision with root package name */
    public static final int f247898s = 15;

    /* renamed from: t, reason: collision with root package name */
    public static final int f247899t = 16;

    /* renamed from: u, reason: collision with root package name */
    public static final int f247900u = 17;

    /* renamed from: v, reason: collision with root package name */
    public static final int f247901v = 18;

    /* renamed from: w, reason: collision with root package name */
    public static final int f247902w = 19;

    /* renamed from: x, reason: collision with root package name */
    public static final int f247903x = 20;

    /* renamed from: y, reason: collision with root package name */
    public static final int f247904y = 100;

    /* renamed from: z, reason: collision with root package name */
    public static final String f247905z = "/msf/tencent/audio/";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f247906a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f247907b;

        /* renamed from: c, reason: collision with root package name */
        public static final a f247908c;

        /* renamed from: d, reason: collision with root package name */
        public static final a f247909d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f247910e;

        /* renamed from: f, reason: collision with root package name */
        public static final a f247911f;

        /* renamed from: g, reason: collision with root package name */
        public static final a f247912g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f247913h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f247914i;

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f247915j;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11939);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a("eNone", 0);
            f247906a = aVar;
            a aVar2 = new a("eMSFRecvInviteMsg", 1);
            f247907b = aVar2;
            a aVar3 = new a("eMSFTransferInviteMsg", 2);
            f247908c = aVar3;
            a aVar4 = new a("eVideoServletCreate", 3);
            f247909d = aVar4;
            a aVar5 = new a("eVideoAddMsg", 4);
            f247910e = aVar5;
            a aVar6 = new a("eVideoMSFReceiverProcess", 5);
            f247911f = aVar6;
            a aVar7 = new a("eVideoRecvInviteMsg", 6);
            f247912g = aVar7;
            a aVar8 = new a("eVideoSendACK", 7);
            f247913h = aVar8;
            a aVar9 = new a("eMSFSendVideoACK", 8);
            f247914i = aVar9;
            f247915j = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        }

        a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static a a(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f247915j.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String a() {
        File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
        if (externalCacheDir == null) {
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247880a, 2, "getExternalPath: " + externalCacheDir.getParent());
        }
        return externalCacheDir.getParent();
    }

    public static m b() {
        if (f247882c == null) {
            f247882c = new m();
            f247881b = c();
        }
        return f247882c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f247881b)) {
            String a16 = a();
            if (TextUtils.isEmpty(a16)) {
                a16 = BaseApplication.getContext().getCacheDir().getAbsolutePath();
            }
            f247881b = a16 + f247905z;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247880a, 2, "getsPrivateDir: " + f247881b);
        }
        return f247881b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
    
        if (r6 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        if (r6 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(a aVar, byte[] bArr, int i3) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, bArr, Integer.valueOf(i3));
            return;
        }
        if (bArr == null) {
            return;
        }
        String str = aVar + "_" + String.valueOf(SystemClock.elapsedRealtime()) + "_" + i3 + ".msf";
        File file = new File(f247881b);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(f247881b + str);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            } catch (FileNotFoundException unused4) {
                fileOutputStream2 = fileOutputStream;
            } catch (IOException unused5) {
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused6) {
                        z16 = false;
                    }
                }
                if (!z16) {
                    file2.delete();
                    throw th;
                }
                throw th;
            }
            file2.delete();
        }
    }
}
