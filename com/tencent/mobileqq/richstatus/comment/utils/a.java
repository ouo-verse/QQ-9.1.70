package com.tencent.mobileqq.richstatus.comment.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Array;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<T>[] f282331a;

    /* renamed from: b, reason: collision with root package name */
    private int f282332b;

    public a() {
        this(16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public synchronized T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int i3 = this.f282332b;
        if (i3 != -1) {
            WeakReference<T>[] weakReferenceArr = this.f282331a;
            if (i3 <= weakReferenceArr.length) {
                T t16 = weakReferenceArr[i3].get();
                WeakReference<T>[] weakReferenceArr2 = this.f282331a;
                int i16 = this.f282332b;
                weakReferenceArr2[i16] = null;
                this.f282332b = i16 - 1;
                return t16;
            }
        }
        return null;
    }

    public synchronized boolean b(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) t16)).booleanValue();
        }
        int i3 = this.f282332b;
        if (i3 != -1 && i3 >= this.f282331a.length - 1) {
            return false;
        }
        int i16 = i3 + 1;
        this.f282332b = i16;
        this.f282331a[i16] = new WeakReference<>(t16);
        return true;
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f282332b = -1;
            this.f282331a = (WeakReference[]) Array.newInstance((Class<?>) WeakReference.class, i3);
        }
    }
}
