package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.qq.e.comm.managers.plugin.PM;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {

    /* renamed from: d, reason: collision with root package name */
    private static final Unsafe f34812d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f34813e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f34814f;
    volatile transient long base;
    volatile transient int busy;

    @NullableDecl
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class b {

        /* renamed from: b, reason: collision with root package name */
        private static final Unsafe f34815b;

        /* renamed from: c, reason: collision with root package name */
        private static final long f34816c;

        /* renamed from: a, reason: collision with root package name */
        volatile long f34817a;

        static {
            try {
                Unsafe access$000 = Striped64.access$000();
                f34815b = access$000;
                f34816c = access$000.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e16) {
                throw new Error(e16);
            }
        }

        b(long j3) {
            this.f34817a = j3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j3, long j16) {
            return f34815b.compareAndSwapLong(this, f34816c, j3, j16);
        }
    }

    static {
        try {
            Unsafe a16 = a();
            f34812d = a16;
            f34813e = a16.objectFieldOffset(Striped64.class.getDeclaredField(PM.BASE));
            f34814f = a16.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e16) {
            throw new Error(e16);
        }
    }

    private static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new a());
            }
        } catch (PrivilegedActionException e16) {
            throw new RuntimeException("Could not initialize intrinsics", e16.getCause());
        }
    }

    static /* synthetic */ Unsafe access$000() {
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casBase(long j3, long j16) {
        return f34812d.compareAndSwapLong(this, f34813e, j3, j16);
    }

    final boolean casBusy() {
        return f34812d.compareAndSwapInt(this, f34814f, 0, 1);
    }

    abstract long fn(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalReset(long j3) {
        b[] bVarArr = this.cells;
        this.base = j3;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f34817a = j3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void retryUpdate(long j3, int[] iArr, boolean z16) {
        int i3;
        int[] iArr2;
        boolean z17;
        int length;
        boolean z18;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i3 = rng.nextInt();
            if (i3 == 0) {
                i3 = 1;
            }
            iArr2[0] = i3;
        } else {
            i3 = iArr[0];
            iArr2 = iArr;
        }
        boolean z19 = false;
        int i16 = i3;
        boolean z26 = z16;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i16];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j3);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 != null && (length2 = bVarArr2.length) > 0) {
                                    int i17 = (length2 - 1) & i16;
                                    if (bVarArr2[i17] == null) {
                                        bVarArr2[i17] = bVar2;
                                        z18 = true;
                                        if (!z18) {
                                            return;
                                        }
                                    }
                                }
                                z18 = false;
                                if (!z18) {
                                }
                            } finally {
                            }
                        }
                    }
                    z19 = false;
                } else if (!z26) {
                    z26 = true;
                } else {
                    long j16 = bVar.f34817a;
                    if (!bVar.a(j16, fn(j16, j3))) {
                        if (length < NCPU && this.cells == bVarArr) {
                            if (!z19) {
                                z19 = true;
                            } else if (this.busy == 0 && casBusy()) {
                                try {
                                    if (this.cells == bVarArr) {
                                        b[] bVarArr3 = new b[length << 1];
                                        for (int i18 = 0; i18 < length; i18++) {
                                            bVarArr3[i18] = bVarArr[i18];
                                        }
                                        this.cells = bVarArr3;
                                    }
                                    this.busy = 0;
                                    z19 = false;
                                } finally {
                                }
                            }
                        }
                        z19 = false;
                    } else {
                        return;
                    }
                }
                int i19 = i16 ^ (i16 << 13);
                int i26 = i19 ^ (i19 >>> 17);
                i16 = i26 ^ (i26 << 5);
                iArr2[0] = i16;
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i16 & 1] = new b(j3);
                        this.cells = bVarArr4;
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return;
                    }
                } finally {
                }
            } else {
                long j17 = this.base;
                if (casBase(j17, fn(j17, j3))) {
                    return;
                }
            }
        }
    }
}
