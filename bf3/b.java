package bf3;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lbf3/b;", "", "", "cacheKey", "b", "Landroid/content/Context;", "ctx", "", "c", "", "bytes", "f", "a", "e", "d", "g", "Lcom/tencent/mmkv/MMKV;", "Lcom/tencent/mmkv/MMKV;", "mInstance", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f28358a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static MMKV mInstance;

    static {
        b bVar = new b();
        f28358a = bVar;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bVar.c(context);
    }

    b() {
    }

    private final String b(String cacheKey) {
        return "zplan_ue_cahce_" + cacheKey;
    }

    private final void c(Context ctx) {
        try {
            String T = MMKV.T(ctx);
            Intrinsics.checkNotNullExpressionValue(T, "initialize(ctx)");
            QLog.d("UECacheMMKVHelper_", 1, "initMMKV at: " + T);
            mInstance = MMKV.a0("zplan_ue_native_cache_mmkv", 2);
        } catch (Exception e16) {
            QLog.e("UECacheMMKVHelper_", 1, "initMMKV error ", e16);
        }
    }

    public final byte[] a(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        MMKV mmkv = mInstance;
        if (mmkv != null) {
            return mmkv.f(b(cacheKey));
        }
        return null;
    }

    public final void d() {
        MMKV mmkv = mInstance;
        if (mmkv == null || mmkv.totalSize() <= 0) {
            return;
        }
        mmkv.clearAll();
    }

    public final void e(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        MMKV mmkv = mInstance;
        if (mmkv != null) {
            mmkv.remove(b(cacheKey));
        }
    }

    public final void f(String cacheKey, byte[] bytes) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        MMKV mmkv = mInstance;
        if (mmkv != null) {
            mmkv.P(b(cacheKey), bytes);
        }
    }

    public final void g() {
        MMKV mmkv = mInstance;
        if (mmkv != null) {
            mmkv.i0();
        }
    }
}
