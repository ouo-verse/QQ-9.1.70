package com.tencent.liteav.base.util;

import android.text.TextUtils;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class p<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f119044a;

    /* renamed from: b, reason: collision with root package name */
    private Callable<T> f119045b;

    public p(Callable<T> callable) {
        this.f119045b = callable;
    }

    public final void a(T t16) {
        synchronized (this) {
            this.f119044a = t16;
        }
    }

    public final T a() {
        T t16 = this.f119044a;
        if (t16 instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) t16)) {
                return this.f119044a;
            }
        } else if (t16 != null) {
            return t16;
        }
        synchronized (this) {
            T t17 = this.f119044a;
            if (t17 instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) t17)) {
                    return this.f119044a;
                }
            } else if (t17 != null) {
                return t17;
            }
            try {
                this.f119044a = this.f119045b.call();
            } catch (Exception e16) {
                e16.printStackTrace();
                LiteavLog.e("Stash", "Get value failed. msg:" + e16.getMessage());
            }
            return this.f119044a;
        }
    }
}
