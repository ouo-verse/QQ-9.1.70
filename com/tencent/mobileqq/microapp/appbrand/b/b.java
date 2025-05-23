package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f245946b;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.microapp.a.c f245947a;

    /* renamed from: c, reason: collision with root package name */
    private String f245948c;

    /* renamed from: d, reason: collision with root package name */
    private String f245949d;

    /* renamed from: e, reason: collision with root package name */
    private Map f245950e;

    /* renamed from: f, reason: collision with root package name */
    private Map f245951f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f245951f = new HashMap();
        }
    }

    public static b a() {
        if (f245946b == null) {
            synchronized (b.class) {
                if (f245946b == null) {
                    f245946b = new b();
                }
            }
        }
        return f245946b;
    }

    private String d(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String e16 = e(str);
        if (TextUtils.isEmpty(e16)) {
            str2 = "";
        } else {
            str2 = "." + e16;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(MD5.toMD5(System.currentTimeMillis() + ""));
        sb5.append(str2);
        String sb6 = sb5.toString();
        StringBuffer stringBuffer = new StringBuffer("wxfile://");
        stringBuffer.append("tmp");
        stringBuffer.append("_");
        stringBuffer.append(sb6);
        String stringBuffer2 = stringBuffer.toString();
        this.f245950e.put(stringBuffer2, str);
        return stringBuffer2;
    }

    private static String e(String str) {
        int lastIndexOf;
        int i3;
        try {
            str = new URL(str).getPath();
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) != -1 && (i3 = lastIndexOf + 1) < str.length()) {
            return str.substring(i3);
        }
        return "";
    }

    public String b(String str) {
        String str2 = "store";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            if (!a(0).equals(absolutePath) && !a(1).equals(absolutePath)) {
                if (absolutePath.startsWith(a(2))) {
                    return MiniAppFileManager.WXFILE_PREFIX_USR + file.getAbsolutePath().replace(a(2), "");
                }
                if (!new File(str).exists()) {
                    return "";
                }
                return d(str);
            }
            if (!file.getParentFile().getName().equals("store")) {
                str2 = "tmp";
            }
            String name = new File(str).getName();
            StringBuffer stringBuffer = new StringBuffer("wxfile://");
            stringBuffer.append(str2);
            stringBuffer.append("_");
            stringBuffer.append(name);
            return stringBuffer.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = (String) this.f245950e.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (str.startsWith(MiniAppFileManager.WXFILE_PREFIX_TMP)) {
            File file = new File(a(0), str.replace(MiniAppFileManager.WXFILE_PREFIX_TMP, ""));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
        } else if (str.startsWith(MiniAppFileManager.WXFILE_PREFIX_STORE)) {
            File file2 = new File(a(1), str.replace(MiniAppFileManager.WXFILE_PREFIX_STORE, ""));
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
        } else if (str.startsWith(MiniAppFileManager.WXFILE_PREFIX_USR)) {
            File file3 = new File(a(2), str.replace(MiniAppFileManager.WXFILE_PREFIX_USR, ""));
            if (file3.exists()) {
                return file3.getAbsolutePath();
            }
        } else if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
            if (new File(this.f245947a.j(str)).exists()) {
                return this.f245947a.j(str);
            }
        } else {
            return str;
        }
        return "";
    }

    public void a(com.tencent.mobileqq.microapp.a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        this.f245948c = cVar.f245823d;
        this.f245949d = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        this.f245947a = cVar;
        String str = this.f245948c + this.f245949d;
        Map map = (Map) this.f245951f.get(str);
        this.f245950e = map;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.f245950e = hashMap;
            this.f245951f.put(str, hashMap);
        }
    }

    public String a(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        return new File(a(0), MD5.toMD5(System.currentTimeMillis() + "") + str2).getAbsolutePath();
    }

    private String a(int i3) {
        String str = "tmp";
        if (i3 != 0) {
            if (i3 == 1) {
                str = "store";
            } else if (i3 == 2) {
                str = "usr";
            }
        }
        return Environment.getExternalStorageDirectory().getPath() + "/miniApp/files/" + this.f245948c + "/" + this.f245949d + "/" + str;
    }
}
