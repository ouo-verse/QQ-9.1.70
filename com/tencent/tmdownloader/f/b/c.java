package com.tencent.tmdownloader.f.b;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f380652a;

    /* renamed from: b, reason: collision with root package name */
    protected String f380653b;

    /* renamed from: c, reason: collision with root package name */
    protected long f380654c;

    public c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f380654c = 0L;
        this.f380652a = str;
        this.f380653b = str2;
        this.f380654c = c();
    }

    public static String a(String str) {
        String a16;
        if (str == null || (a16 = a()) == null) {
            return null;
        }
        return a16;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String a16 = a();
        Log.i("TMAssistantFile", "getSaveFilePath rootDirString=" + a16);
        if (a16 == null) {
            return null;
        }
        return a16 + File.separator + str;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        String b16 = b(this.f380653b);
        if (b16 == null) {
            return 0L;
        }
        File file = new File(b16);
        if (!file.exists()) {
            String c16 = c(this.f380652a);
            if (c16 != null) {
                File file2 = new File(c16);
                if (!file2.exists()) {
                    this.f380654c = 0L;
                } else {
                    this.f380654c = file2.length();
                }
            }
        } else {
            this.f380654c = file.length();
        }
        return this.f380654c;
    }

    public static String a() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            return null;
        }
        boolean b16 = b();
        String a16 = a(context);
        com.tencent.tmassistantbase.util.u.b.a("TMAssistantFile", "hasExternalStorage=" + b16 + ", externalPath=" + a16);
        if (b16 && !TextUtils.isEmpty(a16)) {
            return a16 + ("/tencent/TMAssistantSDK/Download/" + context.getPackageName());
        }
        return context.getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
    }

    public static boolean b() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static String a(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return externalCacheDir.getParent();
            }
        } catch (Exception e16) {
            com.tencent.tmassistantbase.util.u.b.a("TMAssistantFile", "getExternalPath failed:", e16);
        }
        return "";
    }

    public String c(String str) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str == null || (a16 = a()) == null) {
            return null;
        }
        return a16 + "/.tmp/" + str + ".tmp";
    }
}
