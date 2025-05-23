package com.qq.e.tg.nativ;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class NativeUnifiedParams {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f40592a;

    /* renamed from: b, reason: collision with root package name */
    private String f40593b;

    /* renamed from: c, reason: collision with root package name */
    private String f40594c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<NativeADUnifiedListener> f40595d;

    public final String getAppId() {
        return this.f40593b;
    }

    public final String getPosId() {
        return this.f40594c;
    }

    public final WeakReference<Context> getWeakContext() {
        return this.f40592a;
    }

    public final WeakReference<NativeADUnifiedListener> getWeakNativeListener() {
        return this.f40595d;
    }

    public final void setAppId(String str) {
        this.f40593b = str;
    }

    public final void setPosId(String str) {
        this.f40594c = str;
    }

    public final void setWeakContext(WeakReference<Context> weakReference) {
        this.f40592a = weakReference;
    }

    public final void setWeakNativeListener(WeakReference<NativeADUnifiedListener> weakReference) {
        this.f40595d = weakReference;
    }
}
