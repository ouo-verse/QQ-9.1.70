package com.tencent.qmethod.monitor.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qmethod/monitor/utils/b;", "Lcom/tencent/qmethod/monitor/utils/d;", "", "key", "", "g", "", "newVal", "j", "", h.F, "f", "i", "", "limitCount", "b", "a", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "concurrentHashMap", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b implements d {

    /* renamed from: c, reason: collision with root package name */
    public static final b f343873c = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(ThreadManager.f343506c.a(), a.f343874d);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "msg", "Landroid/os/Message;", "handleMessage"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    static final class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        public static final a f343874d = new a();

        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(@NotNull Message msg2) {
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    b bVar = b.f343873c;
                    Object obj = msg2.obj;
                    if (obj != null) {
                        bVar.h((String) obj);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            } else {
                b bVar2 = b.f343873c;
                Object obj2 = msg2.obj;
                if (obj2 != null) {
                    bVar2.g((String) obj2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            }
            return true;
        }
    }

    b() {
    }

    private final String f(String key) {
        return key + "_24hours_count";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String key) {
        if (DateUtilKt.b(f.b(i(key)))) {
            long b16 = f.b(f(key)) + 1;
            f.f(f(key), b16);
            j(key, b16);
        } else {
            f.f(f(key), 1L);
            f.f(i(key), System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(String key) {
        if (DateUtilKt.b(f.b(i(key)))) {
            long b16 = f.b(f(key)) - 1;
            j(key, b16);
            String f16 = f(key);
            if (b16 <= 0) {
                b16 = 0;
            }
            f.f(f16, b16);
            return true;
        }
        return false;
    }

    private final String i(String key) {
        return key + "_24hours_time";
    }

    private final void j(String key, long newVal) {
        ConcurrentHashMap<String, Long> concurrentHashMap2 = concurrentHashMap;
        Long l3 = concurrentHashMap2.get(key);
        if (l3 == null) {
            concurrentHashMap2.put(key, Long.valueOf(newVal));
        } else if (newVal > l3.longValue()) {
            concurrentHashMap2.put(key, Long.valueOf(newVal));
        }
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean a(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        ConcurrentHashMap<String, Long> concurrentHashMap2 = concurrentHashMap;
        Long l3 = concurrentHashMap2.get(key);
        if (l3 == null) {
            g(key);
        } else {
            concurrentHashMap2.put(key, Long.valueOf(l3.longValue() + 1));
            Message.obtain(handler, 1, 0, 0, key).sendToTarget();
        }
        return true;
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean b(@NotNull String key, int limitCount) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        ConcurrentHashMap<String, Long> concurrentHashMap2 = concurrentHashMap;
        Long l3 = concurrentHashMap2.get(key);
        if (l3 == null) {
            if (DateUtilKt.b(f.b(i(key)))) {
                long b16 = f.b(f(key));
                concurrentHashMap2.put(key, Long.valueOf(b16));
                if (b16 >= limitCount) {
                    return true;
                }
            } else {
                concurrentHashMap2.put(key, 0L);
                if (limitCount <= 0) {
                    return true;
                }
            }
        } else if (l3.longValue() >= limitCount) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean c(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        ConcurrentHashMap<String, Long> concurrentHashMap2 = concurrentHashMap;
        if (concurrentHashMap2.get(key) == null) {
            h(key);
        } else {
            concurrentHashMap2.put(key, Long.valueOf(r1.longValue() - 1));
        }
        Message.obtain(handler, 2, 0, 0, key).sendToTarget();
        return true;
    }
}
