package com.tencent.tbs.one.impl.common;

import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.o;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c<T> extends m<T> {
    @Override // com.tencent.tbs.one.impl.a.m
    public void a(final int i3, final int i16) {
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.common.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.super.a(i3, i16);
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.m
    public void a(final T t16) {
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.common.c.2
            @Override // java.lang.Runnable
            public final void run() {
                c.super.a(t16);
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.m
    public void a(final int i3, final String str, final Throwable th5) {
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.common.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c.super.a(i3, str, th5);
            }
        });
    }
}
