package com.tencent.luggage.wxa.i;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public InputStream f129189a;

        /* renamed from: b, reason: collision with root package name */
        public String f129190b;

        public a() {
        }

        public a(InputStream inputStream) {
            this.f129189a = inputStream;
        }
    }

    a a(Object obj, ImageDecodeConfig imageDecodeConfig);

    String a();

    boolean accept(Object obj);
}
