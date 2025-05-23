package com.tencent.biz.qqcircle.richframework.sender.iml;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f92006a;

    public static b a() {
        if (f92006a == null) {
            synchronized (b.class) {
                if (f92006a == null) {
                    f92006a = new b();
                }
            }
        }
        return f92006a;
    }

    public QCircleRequestCall b() {
        return new QCircleRequestCall();
    }
}
