package com.tencent.luggage.wxa.zp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface i {
    com.tencent.luggage.wxa.jq.c a(Runnable runnable);

    com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3);

    com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, long j16);

    com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, String str);

    com.tencent.luggage.wxa.jq.c a(Runnable runnable, String str);

    com.tencent.luggage.wxa.jq.c a(Callable callable);

    b a(String str);

    b a(String str, int i3, int i16, BlockingQueue blockingQueue);

    com.tencent.luggage.wxa.jq.c b(Runnable runnable);

    com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3);

    com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3, long j16);

    com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3, String str);

    com.tencent.luggage.wxa.jq.c b(Runnable runnable, String str);

    com.tencent.luggage.wxa.jq.c b(Callable callable);

    com.tencent.luggage.wxa.jq.c c(Runnable runnable);

    com.tencent.luggage.wxa.jq.c c(Runnable runnable, long j3);

    com.tencent.luggage.wxa.jq.c c(Runnable runnable, String str);

    com.tencent.luggage.wxa.jq.c d(Runnable runnable);

    com.tencent.luggage.wxa.jq.c d(Runnable runnable, String str);

    com.tencent.luggage.wxa.jq.c e(Runnable runnable);

    com.tencent.luggage.wxa.jq.c execute(Runnable runnable);

    boolean isShutdown();
}
