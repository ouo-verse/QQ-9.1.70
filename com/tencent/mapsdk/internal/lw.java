package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.DownloadPriority;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lw {

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f149268b;

    /* renamed from: c, reason: collision with root package name */
    ExecutorService f149269c;

    /* renamed from: e, reason: collision with root package name */
    private lu f149271e;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f149267a = new Hashtable();

    /* renamed from: d, reason: collision with root package name */
    final Set<lv> f149270d = new CopyOnWriteArraySet();

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.lw$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f149280a;

        static {
            int[] iArr = new int[lx.values().length];
            f149280a = iArr;
            try {
                iArr[lx.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f149280a[lx.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f149280a[lx.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f149280a[lx.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f149280a[lx.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f149281a;

        /* renamed from: b, reason: collision with root package name */
        Future f149282b;

        /* renamed from: c, reason: collision with root package name */
        lu f149283c;

        /* renamed from: d, reason: collision with root package name */
        lx f149284d;

        a() {
        }

        public final boolean a() {
            return this.f149284d == lx.CANCEL;
        }

        public final synchronized void b() {
            if (this.f149284d == lx.START) {
                this.f149284d = lx.RUNNING;
            }
        }

        public final synchronized void c() {
            if (this.f149284d == null) {
                return;
            }
            Future future = this.f149282b;
            if (future != null) {
                future.cancel(true);
            }
            lu luVar = this.f149283c;
            if (luVar != null) {
                luVar.a();
            }
            this.f149284d = lx.CANCEL;
        }

        public final synchronized void d() {
            lx lxVar = this.f149284d;
            if (lxVar != null && lxVar != lx.RUNNING) {
                c();
            }
        }

        public final synchronized void e() {
            lx lxVar = this.f149284d;
            if (lxVar == lx.RUNNING || lxVar == lx.FINISH) {
                this.f149284d = lx.FINISH;
            }
        }

        public final synchronized void f() {
            lx lxVar = this.f149284d;
            if (lxVar != lx.FINISH && lxVar != lx.CANCEL) {
                this.f149284d = lx.ERROR;
            }
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("RequestBody{");
            stringBuffer.append("runnable=");
            stringBuffer.append(this.f149281a);
            stringBuffer.append(", requestFuture=");
            stringBuffer.append(this.f149282b);
            stringBuffer.append(", executor=");
            stringBuffer.append(this.f149283c);
            stringBuffer.append(", status=");
            stringBuffer.append(this.f149284d);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        /* synthetic */ a(byte b16) {
            this();
        }

        public final synchronized void a(ExecutorService executorService) {
            if (this.f149284d == null && this.f149281a != null && executorService != null && !hu.a(executorService)) {
                this.f149284d = lx.START;
                this.f149282b = executorService.submit(this.f149281a);
            }
        }
    }

    private Runnable c(String str) {
        a aVar = this.f149267a.get(str);
        if (aVar != null) {
            return aVar.f149281a;
        }
        return null;
    }

    private void a(ExecutorService executorService) {
        this.f149268b = executorService;
    }

    public final void b(lv lvVar) {
        this.f149270d.remove(lvVar);
    }

    private synchronized void b() {
        this.f149271e = null;
        ExecutorService executorService = this.f149268b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f149268b = null;
        }
        ExecutorService executorService2 = this.f149269c;
        if (executorService2 != null) {
            executorService2.shutdownNow();
            this.f149269c = null;
        }
        this.f149270d.clear();
    }

    public final void a(lv lvVar) {
        if (lvVar != null) {
            this.f149270d.remove(lvVar);
            this.f149270d.add(lvVar);
        }
    }

    public final synchronized void a() {
        b();
    }

    public final synchronized void a(String str, lu luVar) {
        a(str, luVar, DownloadPriority.NONE.getValue());
    }

    public final synchronized void a(final String str, final lu luVar, final int i3) {
        if (luVar == null) {
            return;
        }
        ExecutorService executorService = this.f149268b;
        if (executorService == null || hu.a(executorService)) {
            this.f149268b = hu.c();
        }
        try {
            if (!hu.a(this.f149268b)) {
                a aVar = new a((byte) 0);
                this.f149267a.put(str, aVar);
                aVar.f149281a = new Runnable() { // from class: com.tencent.mapsdk.internal.lw.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a aVar2;
                        lx lxVar;
                        a aVar3;
                        byte[] f16;
                        lw lwVar = lw.this;
                        String str2 = str;
                        lu luVar2 = luVar;
                        int i16 = i3;
                        try {
                            try {
                                if (DownloadPriority.get(i16) != DownloadPriority.NONE) {
                                    Thread.currentThread().setPriority(DownloadPriority.getThreadPriority(i16));
                                }
                                aVar3 = lwVar.f149267a.get(str2);
                            } catch (Exception e16) {
                                e = e16;
                                aVar2 = null;
                            }
                            try {
                                if (aVar3 == null) {
                                    lwVar.a(str2, (byte[]) null, lx.ERROR);
                                    return;
                                }
                                if (aVar3.a()) {
                                    lwVar.a(str2, (byte[]) null, lx.CANCEL);
                                    return;
                                }
                                InputStream e17 = luVar2.e(str2);
                                lwVar.a(str2, (byte[]) null, aVar3.f149284d);
                                aVar3.b();
                                lx lxVar2 = aVar3.f149284d;
                                if (e17 != null) {
                                    f16 = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                                    while (f16.length != 0) {
                                        f16 = ku.a(e17);
                                        if (f16 != null) {
                                            lwVar.a(str2, f16, lxVar2);
                                            if (aVar3.a()) {
                                                lwVar.a(str2, (byte[]) null, lx.CANCEL);
                                                return;
                                            }
                                        } else {
                                            throw new IllegalStateException("\u4e0b\u8f7d\u8fc7\u7a0b\u8bfb\u53d6\u5931\u8d25");
                                        }
                                    }
                                    ku.a((Closeable) e17);
                                } else {
                                    f16 = luVar2.f(str2);
                                    if (f16 != null && f16.length == 0) {
                                        f16 = null;
                                    }
                                }
                                if (aVar3.a()) {
                                    lwVar.a(str2, (byte[]) null, lx.CANCEL);
                                } else {
                                    aVar3.e();
                                    lwVar.a(str2, f16, aVar3.f149284d);
                                }
                            } catch (Exception e18) {
                                aVar2 = aVar3;
                                e = e18;
                                e.printStackTrace();
                                if (aVar2 != null) {
                                    aVar2.f();
                                }
                                if (aVar2 != null) {
                                    lxVar = aVar2.f149284d;
                                } else {
                                    lxVar = lx.ERROR;
                                }
                                lwVar.a(str2, (byte[]) null, lxVar);
                            }
                        } finally {
                            luVar2.b();
                        }
                    }
                };
                aVar.f149283c = luVar;
                aVar.a(this.f149268b);
            }
        } catch (IllegalMonitorStateException e16) {
            e16.printStackTrace();
        }
    }

    public final synchronized void b(String str) {
        a remove = this.f149267a.remove(str);
        if (remove != null) {
            remove.c();
        }
    }

    private void b(String str, lu luVar, int i3) {
        a aVar;
        byte[] f16;
        try {
            try {
                if (DownloadPriority.get(i3) != DownloadPriority.NONE) {
                    Thread.currentThread().setPriority(DownloadPriority.getThreadPriority(i3));
                }
                a aVar2 = this.f149267a.get(str);
                try {
                    if (aVar2 == null) {
                        a(str, (byte[]) null, lx.ERROR);
                        return;
                    }
                    if (aVar2.a()) {
                        a(str, (byte[]) null, lx.CANCEL);
                        return;
                    }
                    InputStream e16 = luVar.e(str);
                    a(str, (byte[]) null, aVar2.f149284d);
                    aVar2.b();
                    lx lxVar = aVar2.f149284d;
                    if (e16 != null) {
                        f16 = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                        while (f16.length != 0) {
                            f16 = ku.a(e16);
                            if (f16 != null) {
                                a(str, f16, lxVar);
                                if (aVar2.a()) {
                                    a(str, (byte[]) null, lx.CANCEL);
                                    return;
                                }
                            } else {
                                throw new IllegalStateException("\u4e0b\u8f7d\u8fc7\u7a0b\u8bfb\u53d6\u5931\u8d25");
                            }
                        }
                        ku.a((Closeable) e16);
                    } else {
                        f16 = luVar.f(str);
                        if (f16 != null && f16.length == 0) {
                            f16 = null;
                        }
                    }
                    if (aVar2.a()) {
                        a(str, (byte[]) null, lx.CANCEL);
                    } else {
                        aVar2.e();
                        a(str, f16, aVar2.f149284d);
                    }
                } catch (Exception e17) {
                    aVar = aVar2;
                    e = e17;
                    e.printStackTrace();
                    if (aVar != null) {
                        aVar.f();
                    }
                    a(str, (byte[]) null, aVar != null ? aVar.f149284d : lx.ERROR);
                }
            } finally {
                luVar.b();
            }
        } catch (Exception e18) {
            e = e18;
            aVar = null;
        }
    }

    public final synchronized void a(String str) {
        a remove = this.f149267a.remove(str);
        if (remove != null) {
            remove.d();
        }
    }

    final void a(final String str, final byte[] bArr, final lx lxVar) {
        if (this.f149270d.isEmpty() || lxVar == null) {
            return;
        }
        ExecutorService executorService = this.f149269c;
        if (executorService == null || hu.a(executorService)) {
            this.f149269c = hu.b();
        }
        if (this.f149269c.isShutdown()) {
            return;
        }
        this.f149269c.execute(new Runnable() { // from class: com.tencent.mapsdk.internal.lw.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (lv lvVar : lw.this.f149270d) {
                        if (!lw.this.f149269c.isShutdown() && !lw.this.f149269c.isTerminated()) {
                            lvVar.a(str, lxVar);
                            int i3 = AnonymousClass3.f149280a[lxVar.ordinal()];
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 != 3 && i3 != 4) {
                                        if (i3 == 5) {
                                            if (bArr == null) {
                                                lvVar.d(str);
                                            }
                                            lvVar.a(str, bArr);
                                            lvVar.c(str);
                                        }
                                    } else {
                                        if (bArr == null) {
                                            lvVar.d(str);
                                        }
                                        lvVar.a(str, bArr);
                                    }
                                } else {
                                    lvVar.b(str);
                                    lvVar.a(str, bArr);
                                }
                            } else {
                                lvVar.a(str);
                            }
                        }
                        return;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    private static /* synthetic */ void a(lw lwVar, String str, lu luVar, int i3) {
        a aVar;
        byte[] f16;
        try {
            try {
                if (DownloadPriority.get(i3) != DownloadPriority.NONE) {
                    Thread.currentThread().setPriority(DownloadPriority.getThreadPriority(i3));
                }
                a aVar2 = lwVar.f149267a.get(str);
                try {
                    if (aVar2 == null) {
                        lwVar.a(str, (byte[]) null, lx.ERROR);
                        return;
                    }
                    if (aVar2.a()) {
                        lwVar.a(str, (byte[]) null, lx.CANCEL);
                        return;
                    }
                    InputStream e16 = luVar.e(str);
                    lwVar.a(str, (byte[]) null, aVar2.f149284d);
                    aVar2.b();
                    lx lxVar = aVar2.f149284d;
                    if (e16 != null) {
                        f16 = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                        while (f16.length != 0) {
                            f16 = ku.a(e16);
                            if (f16 != null) {
                                lwVar.a(str, f16, lxVar);
                                if (aVar2.a()) {
                                    lwVar.a(str, (byte[]) null, lx.CANCEL);
                                    return;
                                }
                            } else {
                                throw new IllegalStateException("\u4e0b\u8f7d\u8fc7\u7a0b\u8bfb\u53d6\u5931\u8d25");
                            }
                        }
                        ku.a((Closeable) e16);
                    } else {
                        f16 = luVar.f(str);
                        if (f16 != null && f16.length == 0) {
                            f16 = null;
                        }
                    }
                    if (aVar2.a()) {
                        lwVar.a(str, (byte[]) null, lx.CANCEL);
                    } else {
                        aVar2.e();
                        lwVar.a(str, f16, aVar2.f149284d);
                    }
                } catch (Exception e17) {
                    aVar = aVar2;
                    e = e17;
                    e.printStackTrace();
                    if (aVar != null) {
                        aVar.f();
                    }
                    lwVar.a(str, (byte[]) null, aVar != null ? aVar.f149284d : lx.ERROR);
                }
            } finally {
                luVar.b();
            }
        } catch (Exception e18) {
            e = e18;
            aVar = null;
        }
    }
}
