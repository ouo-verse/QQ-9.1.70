package com.tencent.qqlive.superplayer.tools.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import tt3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f345487a = false;

    /* renamed from: b, reason: collision with root package name */
    private static a.c f345488b;

    public static void a(String str, String str2) {
        f(10, str, str2, new Object[0]);
    }

    public static void b(String str, Throwable th5) {
        c(str, th5, "");
    }

    public static void c(String str, Throwable th5, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2 + "\n";
        } else {
            str3 = "";
        }
        if (th5 != null) {
            str3 = str3 + Log.getStackTraceString(th5);
        }
        f(10, str, str3, new Object[0]);
    }

    public static void d(String str, String str2) {
        f(40, str, str2, new Object[0]);
    }

    private static void e(int i3, String str, String str2) {
        if (i3 != 10) {
            if (i3 != 20) {
                if (i3 != 40) {
                    if (i3 != 50) {
                        if (i3 == 60) {
                            f345488b.v(str, str2);
                            return;
                        }
                        return;
                    }
                    f345488b.d(str, str2);
                    return;
                }
                f345488b.i(str, str2);
                return;
            }
            f345488b.w(str, str2);
            return;
        }
        f345488b.e(str, str2);
    }

    private static void f(int i3, String str, String str2, Object... objArr) {
        if (i3 != 60 && i3 != 50) {
            if (i3 == 20) {
                i3 = 10;
            }
            if (objArr != null) {
                try {
                    if (objArr.length != 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (OutOfMemoryError unused) {
                    return;
                } catch (MissingFormatArgumentException e16) {
                    e16.printStackTrace();
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            if (f345488b != null) {
                if (i3 <= vt3.d.J0.a().intValue()) {
                    e(i3, str, str2);
                }
            } else if (f345487a && i3 <= vt3.d.J0.a().intValue()) {
                Log.println(h(i3), str, str2);
            }
        }
    }

    public static void g(a.c cVar) {
        f345488b = cVar;
    }

    private static int h(int i3) {
        if (i3 != 10) {
            if (i3 != 20) {
                if (i3 != 40) {
                    if (i3 != 50) {
                        if (i3 != 60) {
                            return 0;
                        }
                        return 2;
                    }
                    return 3;
                }
                return 4;
            }
            return 5;
        }
        return 6;
    }

    public static void i(String str, String str2) {
        f(20, str, str2, new Object[0]);
    }
}
