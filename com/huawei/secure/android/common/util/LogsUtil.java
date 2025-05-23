package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LogsUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f38007a = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");

    /* renamed from: b, reason: collision with root package name */
    private static final char f38008b = '*';

    /* renamed from: c, reason: collision with root package name */
    private static final int f38009c = 2;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        private static final long f38010d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        private String f38011a;

        /* renamed from: b, reason: collision with root package name */
        private Throwable f38012b;

        /* renamed from: c, reason: collision with root package name */
        private Throwable f38013c;

        public a(Throwable th5) {
            this.f38013c = th5;
        }

        public void a(Throwable th5) {
            this.f38012b = th5;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th5 = this.f38012b;
            if (th5 == this) {
                return null;
            }
            return th5;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f38011a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th5 = this.f38013c;
            if (th5 == null) {
                return "";
            }
            String name = th5.getClass().getName();
            if (this.f38011a != null) {
                String str = name + MsgSummary.STR_COLON;
                if (this.f38011a.startsWith(str)) {
                    return this.f38011a;
                }
                return str + this.f38011a;
            }
            return name;
        }

        public void a(String str) {
            this.f38011a = str;
        }
    }

    private static String a(String str, boolean z16) {
        StringBuilder sb5 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z16) {
                sb5.append(a(str));
            } else {
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (i3 % 2 == 0) {
                charArray[i3] = f38008b;
            }
        }
        return new String(charArray);
    }

    public static void d(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, z16));
    }

    public static void e(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, z16));
    }

    public static void i(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, a(str2, z16));
    }

    public static void w(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(str, a(str2, z16));
    }

    public static void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.d(str, a(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.e(str, a(str2, str3));
    }

    public static void i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.i(str, a(str2, str3));
    }

    public static void w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.w(str, a(str2, str3));
    }

    public static void d(String str, String str2, String str3, Throwable th5) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.d(str, a(str2, str3), a(th5));
    }

    public static void e(String str, String str2, String str3, Throwable th5) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.e(str, a(str2, str3), a(th5));
    }

    public static void i(String str, String str2, String str3, Throwable th5) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.i(str, a(str2, str3), a(th5));
    }

    public static void w(String str, String str2, String str3, Throwable th5) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        Log.w(str, a(str2, str3), a(th5));
    }

    private static String a(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(a(str2));
        }
        return sb5.toString();
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, false));
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, false));
    }

    public static void i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, a(str2, false));
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(str, a(str2, false));
    }

    public static void d(String str, String str2, Throwable th5, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, a(str2, z16), a(th5));
    }

    public static void e(String str, String str2, Throwable th5, boolean z16) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.e(str, a(str2, z16), a(th5));
    }

    public static void i(String str, String str2, Throwable th5, boolean z16) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.i(str, a(str2, z16), a(th5));
    }

    public static void w(String str, String str2, Throwable th5, boolean z16) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.w(str, a(str2, z16), a(th5));
    }

    public static void d(String str, String str2, Throwable th5) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.d(str, a(str2, false), a(th5));
    }

    public static void e(String str, String str2, Throwable th5) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.e(str, a(str2, false), a(th5));
    }

    public static void i(String str, String str2, Throwable th5) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.i(str, a(str2, false), a(th5));
    }

    public static void w(String str, String str2, Throwable th5) {
        if (TextUtils.isEmpty(str2) && th5 == null) {
            return;
        }
        Log.w(str, a(str2, false), a(th5));
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i3 = 1;
        if (1 == length) {
            return String.valueOf(f38008b);
        }
        StringBuilder sb5 = new StringBuilder(length);
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (f38007a.matcher(String.valueOf(charAt)).matches()) {
                if (i3 % 2 == 0) {
                    charAt = '*';
                }
                i3++;
            }
            sb5.append(charAt);
        }
        return sb5.toString();
    }

    private static Throwable a(Throwable th5) {
        if (th5 == null) {
            return null;
        }
        a aVar = new a(th5);
        aVar.setStackTrace(th5.getStackTrace());
        aVar.a(b(th5.getMessage()));
        Throwable cause = th5.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(b(cause.getMessage()));
            aVar2.a(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }
}
