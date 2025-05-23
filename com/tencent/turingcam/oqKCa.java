package com.tencent.turingcam;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public class oqKCa {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f382330a;

        /* renamed from: b, reason: collision with root package name */
        public int f382331b;

        /* renamed from: c, reason: collision with root package name */
        public int f382332c;

        /* renamed from: d, reason: collision with root package name */
        public String f382333d;

        /* renamed from: e, reason: collision with root package name */
        public int f382334e;

        public spXPg(int i3, int i16, String str, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f382330a = i3;
            this.f382331b = i16;
            this.f382333d = str;
            this.f382332c = i17;
            this.f382334e = i18;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "" + String.format("% 6d", Integer.valueOf(this.f382330a)) + "    " + String.format("% 6d", Integer.valueOf(this.f382331b)) + "    " + String.format("% 6d", Integer.valueOf(this.f382332c)) + "    " + this.f382333d;
        }
    }

    public static String a(int i3) {
        try {
            byte[] a16 = F2BEC.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/cmdline", Integer.valueOf(i3)), 100);
            String str = a16 != null ? new String(a16, 0, a(a16, 0, (char) 0)) : "";
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            byte[] a17 = F2BEC.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i3)), 150);
            if (a17 == null) {
                return str;
            }
            int a18 = a(a17, 7, '\n');
            return a18 == 0 ? "" : new String(a17, 6, a18 - 6);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static spXPg b(int i3) {
        String str;
        int i16;
        int i17;
        int i18;
        String str2;
        int i19;
        int i26;
        String str3;
        try {
            str = a(i3);
            try {
                if (i3 != -1) {
                    str3 = new String(F2BEC.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i3))));
                } else {
                    str3 = new String(F2BEC.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/self/status", new Object[0])));
                }
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split("\n")) {
                    String[] split = str4.split(":");
                    if (split.length >= 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    }
                }
                i16 = Integer.parseInt((String) hashMap.get("PPid"));
                try {
                    i17 = Integer.parseInt(((String) hashMap.get(AppConstants.Key.UID)).split("\\s+")[0]);
                } catch (Throwable unused) {
                    i17 = -1;
                }
                try {
                    str2 = str;
                    i19 = i16;
                    i26 = i17;
                    i18 = Integer.parseInt((String) hashMap.get("TracerPid"));
                } catch (Throwable unused2) {
                    i18 = -1;
                    str2 = str;
                    i19 = i16;
                    i26 = i17;
                    if (str2 == null) {
                    }
                }
            } catch (Throwable unused3) {
                i16 = -1;
                i17 = -1;
                i18 = -1;
                str2 = str;
                i19 = i16;
                i26 = i17;
                return str2 == null ? null : null;
            }
        } catch (Throwable unused4) {
            str = null;
        }
        if (str2 == null || i19 == -1 || i26 == -1) {
            return null;
        }
        return new spXPg(i3, i19, str2, i26, i18);
    }

    public static int a(byte[] bArr, int i3, char c16) {
        int i16;
        int i17 = i3 - 1;
        while (true) {
            i16 = i17 + 1;
            if (i17 >= bArr.length) {
                return 0;
            }
            if (i16 == bArr.length || bArr[i16] == c16) {
                break;
            }
            i17 = i16;
        }
        return i16;
    }
}
