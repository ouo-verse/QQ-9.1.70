package com.tencent.liteav.videobase.utils;

import android.content.Intent;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.liteav.base.b.a f119399a = new com.tencent.liteav.base.b.a(1000);

    public static byte[] a(int i3) {
        try {
            return new byte[i3];
        } catch (OutOfMemoryError e16) {
            a(e16.getMessage());
            return null;
        }
    }

    public static ByteBuffer b(int i3) {
        try {
            return ByteBuffer.allocateDirect(i3);
        } catch (OutOfMemoryError e16) {
            a(e16.getMessage());
            return null;
        }
    }

    private static synchronized void a(String str) {
        synchronized (d.class) {
            if (f119399a.a()) {
                LiteavLog.e("MemoryAllocator", "allocate buffer failed with oom error, msg:".concat(String.valueOf(str)));
                c.a().a(new Intent("com.tencent.liteav.video.action.OUT_OF_MEMORY"));
            }
        }
    }
}
