package com.tencent.biz.richframework.delegate;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ILogDelegate {
    void d(String str, int i3, String str2);

    void d(String str, int i3, Object... objArr);

    void e(String str, int i3, String str2);

    void e(String str, int i3, Object... objArr);

    int getCLRValue();

    int getDEVValue();

    int getUSRValue();

    void i(String str, int i3, String str2);

    boolean isColorLevel();

    boolean isDevelopLevel();

    void w(String str, int i3, String str2);
}
