package com.tencent.mm.appbrand.commonjni.buffer;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.a9.f;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BufferURLManager {

    /* renamed from: a, reason: collision with root package name */
    public volatile long f151683a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f151684b = new LinkedHashSet();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(String str);
    }

    public BufferURLManager() {
        this.f151683a = 0L;
        this.f151683a = nativeCreate();
        f.b("BufferURLManager", "BufferURLManager created %d", Long.valueOf(this.f151683a));
    }

    public static void a(String str, Object... objArr) {
    }

    private static native void nativeBindTo(long j3, long j16, long j17);

    private native long nativeCreate();

    private static native void nativeDestroy(long j3);

    private static native ByteBuffer nativeGetBuffer(long j3, String str);

    @Keep
    public void onJSRevoked(@Nullable String str) {
        LinkedList linkedList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f151684b) {
            linkedList = new LinkedList(this.f151684b);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(str);
        }
    }

    public void a() {
        f.b("BufferURLManager", "BufferURLManager destroying %d", Long.valueOf(this.f151683a));
        nativeDestroy(this.f151683a);
        this.f151683a = 0L;
        synchronized (this.f151684b) {
            this.f151684b.clear();
        }
        f.b("BufferURLManager", "BufferURLManager destroyed %d", Long.valueOf(this.f151683a));
    }

    public void a(long j3, long j16) {
        f.b("BufferURLManager", "BufferURLManager %d %d %d", Long.valueOf(this.f151683a), Long.valueOf(j3), Long.valueOf(j16));
        nativeBindTo(this.f151683a, j3, j16);
    }

    public ByteBuffer a(String str) {
        if (str == null) {
            f.a("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
            return null;
        }
        ByteBuffer nativeGetBuffer = nativeGetBuffer(this.f151683a, str);
        a("BufferURLManager createBufferURL with %s", nativeGetBuffer);
        return nativeGetBuffer;
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f151684b) {
            this.f151684b.add(aVar);
        }
    }
}
