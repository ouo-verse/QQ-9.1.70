package com.tencent.luggage.wxa.dq;

import android.os.Looper;
import android.os.Message;
import android.util.Printer;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {
    Looper a();

    Message a(int i3, int i16, int i17, Object obj);

    Message a(int i3, Object obj);

    void a(Printer printer, String str);

    void a(Object obj);

    boolean a(int i3);

    boolean a(int i3, long j3);

    boolean a(Message message);

    boolean a(Message message, long j3);

    boolean a(Runnable runnable);

    boolean a(Runnable runnable, long j3);

    String b();

    void b(int i3, Object obj);

    void b(Runnable runnable);

    boolean b(int i3);

    void c(int i3);

    boolean c(Runnable runnable);

    boolean e();
}
