package com.tencent.image.api;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ILog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final int USR = 1;

    void d(String str, int i3, String str2);

    void e(String str, int i3, String str2);

    void e(String str, int i3, String str2, Throwable th5);

    void i(String str, int i3, String str2);

    void i(String str, int i3, String str2, Throwable th5);

    boolean isColorLevel();

    void w(String str, int i3, String str2);

    void w(String str, int i3, Throwable th5);
}
