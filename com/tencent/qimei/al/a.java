package com.tencent.qimei.al;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.ag.e;
import com.tencent.qimei.ag.h;
import com.tencent.qimei.ap.d;
import com.tencent.qimei.uin.U;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f343058a;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.al.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9307a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f343059a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20141);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f343059a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (a.class) {
            File filesDir = context.getFilesDir();
            boolean z16 = false;
            if (!filesDir.exists()) {
                return false;
            }
            File file = new File(filesDir, str2);
            if (!file.exists()) {
                return false;
            }
            String absolutePath = new File(filesDir, str).getAbsolutePath();
            try {
                FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
                FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
                z16 = true;
            } catch (Exception unused) {
            }
            return z16;
        }
    }

    public final boolean a(String str, Context context, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, context, str2, str3, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f343058a) {
            return true;
        }
        if (context == null) {
            return false;
        }
        File filesDir = context.getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        boolean a16 = U.a(context, new File(filesDir, str2).getAbsolutePath(), str3, z16);
        this.f343058a = a16;
        if (!a16) {
            h a17 = h.a();
            a17.getClass();
            e eVar = new e();
            eVar.f342975a.put("6", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR);
            com.tencent.qimei.ae.a a18 = com.tencent.qimei.ae.a.a(str);
            HashMap hashMap = new HashMap();
            Context e16 = d.c().e();
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_1, e16 == null ? "" : (String) com.tencent.qimei.f.a.a(ApplicationInfo.class.getName(), e16.getApplicationInfo(), "primaryCpuAbi"));
            Context e17 = d.c().e();
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_2, e17 != null ? (String) com.tencent.qimei.f.a.a(ApplicationInfo.class.getName(), e17.getApplicationInfo(), "nativeLibraryDir") : "");
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_3, Build.CPU_ABI);
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_4, Build.CPU_ABI2);
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_5, a18.b());
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_6, Build.BRAND);
            hashMap.put(ICustomDataEditor.STRING_ARRAY_PARAM_7, Build.VERSION.SDK);
            eVar.f342975a.put("7", new JSONObject(hashMap).toString());
            a17.a(eVar, "v2", str);
        }
        c.b("SDK_INIT \uff5c LOCAL_ENC", " initialization is complete (%b),fileName is %s ", Boolean.valueOf(this.f343058a), str2);
        return this.f343058a;
    }
}
