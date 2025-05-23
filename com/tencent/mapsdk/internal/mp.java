package com.tencent.mapsdk.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mp {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149324a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f149325b = 100;

    /* renamed from: c, reason: collision with root package name */
    private a<String> f149326c = new a<>();

    /* renamed from: d, reason: collision with root package name */
    private Hashtable<String, Integer> f149327d = new Hashtable<>();

    /* renamed from: e, reason: collision with root package name */
    private IntBuffer f149328e;

    public mp() {
        b();
    }

    private synchronized void a(String str, int i3) {
        if (this.f149327d.size() == this.f149325b) {
            b();
            if (this.f149328e == null) {
                return;
            }
            a<String> aVar = this.f149326c;
            int i16 = aVar.f149332d;
            int i17 = aVar.f149331c;
            Object obj = null;
            if (!(i16 == i17)) {
                int i18 = i17 % aVar.f149329a;
                Object[] objArr = aVar.f149330b;
                Object obj2 = objArr[i18];
                objArr[i18] = null;
                aVar.f149331c = i18 + 1;
                obj = obj2;
            }
            Integer remove = this.f149327d.remove((String) obj);
            if (this.f149328e.position() < this.f149325b) {
                this.f149328e.put(remove.intValue());
            }
        }
        a<String> aVar2 = this.f149326c;
        int i19 = aVar2.f149332d;
        int i26 = aVar2.f149329a;
        if (!((i19 + 1) % i26 == aVar2.f149331c)) {
            int i27 = i19 % i26;
            Object[] objArr2 = aVar2.f149330b;
            aVar2.f149332d = i27 + 1;
            objArr2[i27] = str;
        }
        this.f149327d.put(str, Integer.valueOf(i3));
    }

    private synchronized void b() {
        if (this.f149328e == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f149325b * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f149328e = allocateDirect.asIntBuffer();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a<E> {

        /* renamed from: a, reason: collision with root package name */
        int f149329a = 100;

        /* renamed from: b, reason: collision with root package name */
        Object[] f149330b = new Object[100];

        /* renamed from: d, reason: collision with root package name */
        int f149332d = 0;

        /* renamed from: c, reason: collision with root package name */
        int f149331c = 0;

        private void b() {
            this.f149332d = 0;
            this.f149331c = 0;
        }

        private E c() {
            boolean z16;
            int i3 = this.f149332d;
            int i16 = this.f149331c;
            if (i3 == i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            int i17 = i16 % this.f149329a;
            Object[] objArr = this.f149330b;
            E e16 = (E) objArr[i17];
            objArr[i17] = null;
            this.f149331c = i17 + 1;
            return e16;
        }

        private boolean d() {
            if ((this.f149332d + 1) % this.f149329a == this.f149331c) {
                return true;
            }
            return false;
        }

        private boolean e() {
            if (this.f149332d == this.f149331c) {
                return true;
            }
            return false;
        }

        public final void a() {
            b();
            int i3 = 0;
            while (true) {
                Object[] objArr = this.f149330b;
                if (i3 >= objArr.length) {
                    return;
                }
                objArr[i3] = null;
                i3++;
            }
        }

        private boolean a(E e16) {
            int i3 = this.f149332d;
            int i16 = this.f149329a;
            if ((i3 + 1) % i16 == this.f149331c) {
                return false;
            }
            int i17 = i3 % i16;
            Object[] objArr = this.f149330b;
            this.f149332d = i17 + 1;
            objArr[i17] = e16;
            return true;
        }
    }

    private synchronized void b(GL10 gl10) {
        IntBuffer intBuffer = this.f149328e;
        if (intBuffer == null) {
            return;
        }
        int position = intBuffer.position();
        if (position > 0) {
            this.f149328e.rewind();
            gl10.glDeleteTextures(position, this.f149328e);
            this.f149328e.clear();
        }
    }

    private synchronized int a(String str) {
        Integer num = this.f149327d.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final synchronized void a() {
        this.f149327d.clear();
        this.f149326c.a();
        IntBuffer intBuffer = this.f149328e;
        if (intBuffer != null) {
            intBuffer.clear();
        }
    }

    public final synchronized void a(GL10 gl10) {
        if (this.f149328e != null) {
            Iterator<String> it = this.f149327d.keySet().iterator();
            while (it.hasNext()) {
                this.f149328e.put(this.f149327d.get(it.next()).intValue());
            }
            b(gl10);
        }
        this.f149327d.clear();
        this.f149326c.a();
    }
}
