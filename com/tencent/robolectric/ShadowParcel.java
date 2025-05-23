package com.tencent.robolectric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes25.dex */
public class ShadowParcel {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Long, ByteBuffer> f365896a;

    /* renamed from: b, reason: collision with root package name */
    private static long f365897b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class ByteBuffer {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private static final byte[] f365898e;

        /* renamed from: a, reason: collision with root package name */
        private FakeEncodedItem[] f365899a;

        /* renamed from: b, reason: collision with root package name */
        private int f365900b;

        /* renamed from: c, reason: collision with root package name */
        private int f365901c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f365902d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes25.dex */
        public static class FakeEncodedItem implements Serializable {
            static IPatchRedirector $redirector_;
            final boolean isEncodedAsAllZeroBytes;
            final int sizeBytes;
            final Object value;

            FakeEncodedItem(int i3, Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, obj);
                    return;
                }
                this.sizeBytes = i3;
                this.value = obj;
                this.isEncodedAsAllZeroBytes = ByteBuffer.f(obj);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50938);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 27)) {
                redirector.redirect((short) 27);
            } else {
                f365898e = new byte[0];
            }
        }

        ByteBuffer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                d();
            }
        }

        private int b(int i3) {
            return ((i3 + 3) / 4) * 4;
        }

        private void c(Class<?> cls, FakeEncodedItem fakeEncodedItem) {
            FakeEncodedItem fakeEncodedItem2;
            Object obj;
            int i3 = this.f365900b;
            int i16 = fakeEncodedItem.sizeBytes + i3;
            while (i3 < i16) {
                if (i3 < this.f365901c) {
                    fakeEncodedItem2 = this.f365899a[i3];
                } else {
                    fakeEncodedItem2 = null;
                }
                if (fakeEncodedItem2 != fakeEncodedItem) {
                    int i17 = this.f365900b;
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[2];
                    if (fakeEncodedItem2 == null) {
                        obj = "uninitialized data or the end of the buffer";
                    } else {
                        obj = fakeEncodedItem2.value;
                    }
                    objArr[0] = obj;
                    objArr[1] = Integer.valueOf(i3);
                    throw new UnreliableBehaviorError(cls, i17, fakeEncodedItem, String.format(locale, "but [%s] interrupts it at position %d", objArr));
                }
                i3++;
            }
            this.f365900b = Math.min(this.f365901c, this.f365900b + fakeEncodedItem.sizeBytes);
        }

        private static boolean e(byte[] bArr, int i3, int i16) {
            while (i3 < i16) {
                if (bArr[i3] != 0) {
                    return false;
                }
                i3++;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean f(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number.longValue() != 0 || number.doubleValue() != 0.0d) {
                    return false;
                }
                return true;
            }
            if (!(obj instanceof byte[])) {
                return false;
            }
            byte[] bArr = (byte[]) obj;
            return e(bArr, 0, bArr.length);
        }

        private <T> FakeEncodedItem g(Class<T> cls) {
            FakeEncodedItem fakeEncodedItem = this.f365899a[this.f365900b];
            if (fakeEncodedItem != null) {
                c(cls, fakeEncodedItem);
                return fakeEncodedItem;
            }
            throw new UnreliableBehaviorError("Reading uninitialized data at position " + this.f365900b);
        }

        private void o(FakeEncodedItem fakeEncodedItem) {
            int i3 = this.f365900b + fakeEncodedItem.sizeBytes;
            if (i3 > this.f365899a.length) {
                h((i3 * 3) / 2);
            }
            if (i3 > this.f365901c) {
                this.f365902d = true;
                this.f365901c = i3;
            }
            Arrays.fill(this.f365899a, this.f365900b, i3, fakeEncodedItem);
            this.f365900b = i3;
        }

        private void r(int i3, Object obj) {
            o(new FakeEncodedItem(b(i3), obj));
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f365899a = new FakeEncodedItem[0];
            this.f365900b = 0;
            this.f365901c = 0;
            this.f365902d = false;
        }

        public void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, i3);
                return;
            }
            if (i3 > this.f365899a.length) {
                FakeEncodedItem[] fakeEncodedItemArr = new FakeEncodedItem[i3];
                int min = Math.min(this.f365901c, i3);
                this.f365901c = min;
                this.f365900b = Math.min(this.f365900b, min);
                System.arraycopy(this.f365899a, 0, fakeEncodedItemArr, 0, this.f365901c);
                this.f365899a = fakeEncodedItemArr;
            }
        }

        public void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, i3);
                return;
            }
            if (i3 <= this.f365901c) {
                this.f365900b = i3;
                this.f365902d = false;
            } else {
                throw new UnreliableBehaviorError(i3 + " greater than dataSize " + this.f365901c);
            }
        }

        public byte[] j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            int i3 = this.f365900b;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    ArrayList<FakeEncodedItem> arrayList = new ArrayList();
                    this.f365900b = 0;
                    while (this.f365900b < this.f365901c) {
                        arrayList.add(g(Object.class));
                    }
                    objectOutputStream.writeInt(arrayList.size());
                    for (FakeEncodedItem fakeEncodedItem : arrayList) {
                        objectOutputStream.writeInt(fakeEncodedItem.sizeBytes);
                        objectOutputStream.writeObject(fakeEncodedItem.value);
                    }
                    objectOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e16) {
                    throw new UnreliableBehaviorError("ErrorProne unable to serialize its custom format", e16);
                }
            } finally {
                this.f365900b = i3;
            }
        }

        public void k(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            n(i16);
            if (i16 != 0) {
                r(i16, Arrays.copyOfRange(bArr, i3, i16));
            }
        }

        public void l(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Double.valueOf(d16));
            } else {
                r(8, Double.valueOf(d16));
            }
        }

        public void m(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            } else {
                r(4, Float.valueOf(f16));
            }
        }

        public void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                r(4, Integer.valueOf(i3));
            }
        }

        public void p(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, j3);
            } else {
                r(8, Long.valueOf(j3));
            }
        }

        public void q(String str) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
                return;
            }
            if (str != null) {
                i3 = str.length() + 1;
            } else {
                i3 = 0;
            }
            r((i3 * 2) + 4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class UnreliableBehaviorError extends Error {
        static IPatchRedirector $redirector_;

        UnreliableBehaviorError(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }

        UnreliableBehaviorError(String str, Throwable th5) {
            super(str, th5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) th5);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        UnreliableBehaviorError(Class<?> cls, int i3, ByteBuffer.FakeEncodedItem fakeEncodedItem, String str) {
            super(String.format(r0, "Looking for %s at position %d, found %s [%s] taking %d bytes, %s", r1));
            Locale locale = Locale.US;
            Object[] objArr = new Object[6];
            objArr[0] = cls.getSimpleName();
            objArr[1] = Integer.valueOf(i3);
            Object obj = fakeEncodedItem.value;
            objArr[2] = obj == null ? "null" : obj.getClass().getSimpleName();
            objArr[3] = fakeEncodedItem.value;
            objArr[4] = Integer.valueOf(fakeEncodedItem.sizeBytes);
            objArr[5] = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, cls, Integer.valueOf(i3), fakeEncodedItem, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f365896a = new LinkedHashMap();
            f365897b = 1L;
        }
    }

    public static Number a(long j3) {
        return Long.valueOf(j3);
    }

    public static synchronized Number b() {
        Number a16;
        synchronized (ShadowParcel.class) {
            long j3 = f365897b;
            f365897b = 1 + j3;
            f365896a.put(Long.valueOf(j3), new ByteBuffer());
            a16 = a(j3);
        }
        return a16;
    }

    public static byte[] c(int i3) {
        return d(i3);
    }

    protected static byte[] d(long j3) {
        return f365896a.get(Long.valueOf(j3)).j();
    }

    public static void e(int i3, int i16) {
        f(i3, i16);
    }

    protected static void f(long j3, int i3) {
        f365896a.get(Long.valueOf(j3)).i(i3);
    }

    public static void g(long j3, byte[] bArr, int i3, int i16) {
        i(j3, bArr, i3, i16);
    }

    public static void h(int i3, byte[] bArr, int i16, int i17) {
        i(i3, bArr, i16, i17);
    }

    protected static void i(long j3, byte[] bArr, int i3, int i16) {
        f365896a.get(Long.valueOf(j3)).k(bArr, i3, i16);
    }

    public static void j(int i3, double d16) {
        k(i3, d16);
    }

    protected static void k(long j3, double d16) {
        f365896a.get(Long.valueOf(j3)).l(d16);
    }

    public static void l(int i3, float f16) {
        m(i3, f16);
    }

    protected static void m(long j3, float f16) {
        f365896a.get(Long.valueOf(j3)).m(f16);
    }

    public static void n(int i3, int i16) {
        o(i3, i16);
    }

    protected static void o(long j3, int i3) {
        f365896a.get(Long.valueOf(j3)).n(i3);
    }

    public static void p(int i3, long j3) {
        q(i3, j3);
    }

    protected static void q(long j3, long j16) {
        f365896a.get(Long.valueOf(j3)).p(j16);
    }

    public static void r(int i3, String str) {
        s(i3, str);
    }

    protected static void s(long j3, String str) {
        f365896a.get(Long.valueOf(j3)).q(str);
    }
}
