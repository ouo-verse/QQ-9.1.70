package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Object f121628a;

    /* renamed from: b, reason: collision with root package name */
    public Callable f121629b;

    public d(Callable callable) {
        this.f121629b = callable;
    }

    public Object a() {
        Object obj = this.f121628a;
        if (obj instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) obj)) {
                return this.f121628a;
            }
        } else if (obj != null) {
            return obj;
        }
        synchronized (this) {
            Object obj2 = this.f121628a;
            if (obj2 instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj2)) {
                    return this.f121628a;
                }
            } else if (obj2 != null) {
                return obj2;
            }
            try {
                this.f121628a = this.f121629b.call();
            } catch (Exception e16) {
                e16.printStackTrace();
                x0.c("Stash", "Get value failed. msg:" + e16.getMessage());
            }
            return this.f121628a;
        }
    }
}
