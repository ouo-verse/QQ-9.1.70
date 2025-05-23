package com.tencent.richmediabrowser.log;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IBrowserLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final int USR = 1;

    void d(String str, int i3, String str2);

    void e(String str, int i3, String str2);

    void i(String str, int i3, String str2);

    boolean isColorLevel();

    void w(String str, int i3, String str2);
}
