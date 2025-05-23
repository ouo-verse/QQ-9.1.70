package com.qzone.album.env.common;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import u4.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f43884a = new AtomicBoolean(false);

    public static void a() {
        AtomicBoolean atomicBoolean = f43884a;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        a.A(new AlbumEnvCommonImpl());
        t4.a.S(new t4.b());
        u4.b.a(new u4.a());
        u4.c.j(new d());
        QLog.d("AlbumEnvInitializer", 1, "[init] init env: " + Thread.currentThread().getName());
    }
}
