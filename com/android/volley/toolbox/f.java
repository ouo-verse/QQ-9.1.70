package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f31415a;

    /* renamed from: b, reason: collision with root package name */
    private final List<com.android.volley.e> f31416b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31417c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final InputStream f31418d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final byte[] f31419e;

    public f(int i3, List<com.android.volley.e> list) {
        this(i3, list, -1, null);
    }

    @Nullable
    public final InputStream a() {
        InputStream inputStream = this.f31418d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f31419e != null) {
            return new ByteArrayInputStream(this.f31419e);
        }
        return null;
    }

    public final int b() {
        return this.f31417c;
    }

    public final List<com.android.volley.e> c() {
        return Collections.unmodifiableList(this.f31416b);
    }

    public final int d() {
        return this.f31415a;
    }

    public f(int i3, List<com.android.volley.e> list, int i16, InputStream inputStream) {
        this.f31415a = i3;
        this.f31416b = list;
        this.f31417c = i16;
        this.f31418d = inputStream;
        this.f31419e = null;
    }
}
