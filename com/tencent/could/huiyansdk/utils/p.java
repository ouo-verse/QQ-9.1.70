package com.tencent.could.huiyansdk.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p<T> implements Pools.Pool<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f100318a;

    /* renamed from: b, reason: collision with root package name */
    public int f100319b;

    public p(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            if (i3 > 0) {
                this.f100318a = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    @Override // androidx.core.util.Pools.Pool
    @Nullable
    public T acquire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int i3 = this.f100319b;
        if (i3 <= 0) {
            return null;
        }
        int i16 = i3 - 1;
        Object[] objArr = this.f100318a;
        T t16 = (T) objArr[i16];
        objArr[i16] = null;
        this.f100319b = i16;
        return t16;
    }

    @Override // androidx.core.util.Pools.Pool
    public boolean release(@NonNull T t16) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16)).booleanValue();
        }
        int i16 = 0;
        while (true) {
            i3 = this.f100319b;
            if (i16 < i3) {
                if (this.f100318a[i16] == t16) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            Object[] objArr = this.f100318a;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = t16;
            this.f100319b = i3 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
