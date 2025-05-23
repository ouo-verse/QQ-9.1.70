package com.tencent.biz.pubaccount.util;

import com.tencent.image.AbstractGifImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f80334a;

    public static void a() {
        f80334a = AbstractGifImage.DoAccumulativeRunnable.DELAY;
        AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    }

    public static void b() {
        AbstractGifImage.DoAccumulativeRunnable.DELAY = f80334a;
    }
}
