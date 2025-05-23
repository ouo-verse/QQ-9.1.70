package com.tencent.mobileqq.kandian.base.image;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g<T> {

    /* renamed from: d, reason: collision with root package name */
    public static final String f239039d = ImageManager.TAG_PREFIX + g.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private T f239040a;

    /* renamed from: b, reason: collision with root package name */
    private int f239041b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final h<T> f239042c;

    public g(T t16, h<T> hVar) {
        this.f239040a = t16;
        this.f239042c = hVar;
    }

    public synchronized void a() {
        this.f239041b++;
    }

    public synchronized void b() {
        int i3 = this.f239041b - 1;
        this.f239041b = i3;
        if (i3 == 0) {
            QLog.isColorLevel();
            T t16 = this.f239040a;
            if (t16 != null) {
                this.f239042c.release(t16);
                this.f239040a = null;
            }
        }
    }

    public synchronized T c() {
        return this.f239040a;
    }
}
