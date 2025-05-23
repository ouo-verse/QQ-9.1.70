package com.tencent.mobileqq.uftransfer.utility;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.utility.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8875a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f305705a;

        /* renamed from: b, reason: collision with root package name */
        public int f305706b;

        /* renamed from: c, reason: collision with root package name */
        public int f305707c;

        public C8875a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f305706b = 0;
                this.f305707c = 0;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static long b(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return 0L;
            }
            return file.length();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int c(String str) {
        int indexOf;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("H_") || (indexOf = str.indexOf("_")) == -1 || indexOf == (lastIndexOf = str.lastIndexOf("_"))) {
            return 0;
        }
        try {
            return Integer.valueOf(str.substring(indexOf, lastIndexOf - 1)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int d(String str) {
        int indexOf;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("H_") || (indexOf = str.indexOf("_")) == -1 || indexOf == (lastIndexOf = str.lastIndexOf("_"))) {
            return 0;
        }
        try {
            return Integer.valueOf(str.substring(lastIndexOf)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int e(String str) {
        int indexOf;
        int indexOf2;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("User-ReturnCode=[")) == -1) {
            return 0;
        }
        String substring = str.substring(indexOf + 17);
        if (TextUtils.isEmpty(substring) || (indexOf2 = substring.indexOf("]")) == -1) {
            return 0;
        }
        try {
            return Integer.valueOf(substring.substring(0, indexOf2)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static C8875a f(String str) {
        int i3;
        String str2;
        boolean z16;
        int indexOf;
        C8875a c8875a = new C8875a();
        if (TextUtils.isEmpty(str)) {
            return c8875a;
        }
        try {
            int indexOf2 = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            if (indexOf2 == -1) {
                i3 = 0;
            } else {
                i3 = indexOf2 + 3;
            }
            String substring = str.substring(i3);
            int indexOf3 = substring.indexOf("/");
            if (-1 == indexOf3) {
                indexOf3 = substring.length() - 1;
            }
            int i16 = indexOf3 + i3;
            int indexOf4 = str.indexOf("&bHost=");
            if (-1 == indexOf4 || -1 == (indexOf = str.indexOf("&bPort=", indexOf4))) {
                str2 = null;
                z16 = false;
            } else {
                str2 = str.substring(indexOf4 + 7, indexOf) + ":" + str.substring(indexOf + 7);
                z16 = true;
            }
            if (str2 == null) {
                str2 = str.substring(i3, i16);
            }
        } catch (Exception unused) {
        }
        if (str2 == null) {
            return c8875a;
        }
        int indexOf5 = str2.indexOf(":");
        if (indexOf5 >= 0) {
            String substring2 = str2.substring(0, indexOf5);
            String substring3 = str2.substring(indexOf5 + 1);
            c8875a.f305705a = substring2;
            c8875a.f305706b = Integer.valueOf(substring3).intValue();
        } else {
            c8875a.f305705a = str2;
            c8875a.f305706b = 0;
        }
        if (z16) {
            c8875a.f305707c = 1;
        }
        return c8875a;
    }
}
