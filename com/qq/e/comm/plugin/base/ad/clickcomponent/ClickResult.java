package com.qq.e.comm.plugin.base.ad.clickcomponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickResult {

    /* renamed from: a, reason: collision with root package name */
    private Throwable f38522a;

    /* renamed from: b, reason: collision with root package name */
    private int f38523b;

    /* renamed from: c, reason: collision with root package name */
    private String f38524c;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Code {
    }

    public ClickResult(int i3, String str) {
        this(i3, str, null);
    }

    public int a() {
        return this.f38523b;
    }

    public ClickResult(int i3, String str, Throwable th5) {
        this.f38523b = i3;
        this.f38524c = str;
        this.f38522a = th5;
    }
}
