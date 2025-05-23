package n43;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0004R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ln43/c;", "", "", "step", "", "f", "b", "", "d", "", "uin", "g", "e", "c", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mUserStepMap", "mUserStepGetTimeMap", "J", "mGetCurrentStepTime", "I", "mGetCurrentStepValue", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f418310a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Integer> mUserStepMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Long> mUserStepGetTimeMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long mGetCurrentStepTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile int mGetCurrentStepValue;

    c() {
    }

    public final void a() {
        QLog.d("UserStepCacheHelper", 1, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        mUserStepMap.clear();
        mUserStepGetTimeMap.clear();
    }

    public final int b() {
        return mGetCurrentStepValue;
    }

    public final int c(long uin) {
        Integer num;
        ConcurrentHashMap<Long, Integer> concurrentHashMap = mUserStepMap;
        if (!concurrentHashMap.containsKey(Long.valueOf(uin)) || (num = concurrentHashMap.get(Long.valueOf(uin))) == null) {
            return -1;
        }
        return num.intValue();
    }

    public final boolean d() {
        if (System.currentTimeMillis() - mGetCurrentStepTime > 30000) {
            return true;
        }
        return false;
    }

    public final boolean e(long uin) {
        Long l3;
        if (!mUserStepMap.containsKey(Long.valueOf(uin))) {
            return true;
        }
        ConcurrentHashMap<Long, Long> concurrentHashMap = mUserStepGetTimeMap;
        if (concurrentHashMap.containsKey(Long.valueOf(uin))) {
            l3 = concurrentHashMap.get(Long.valueOf(uin));
        } else {
            l3 = 0L;
        }
        if (l3 != null && System.currentTimeMillis() - l3.longValue() > MiniBoxNoticeInfo.MIN_5) {
            return true;
        }
        return false;
    }

    public final void f(int step) {
        mGetCurrentStepValue = step;
        mGetCurrentStepTime = System.currentTimeMillis();
    }

    public final void g(long uin, int step) {
        ConcurrentHashMap<Long, Integer> concurrentHashMap = mUserStepMap;
        if (concurrentHashMap.size() > 1000 || mUserStepGetTimeMap.size() > 1000) {
            a();
        }
        concurrentHashMap.put(Long.valueOf(uin), Integer.valueOf(step));
        mUserStepGetTimeMap.put(Long.valueOf(uin), Long.valueOf(System.currentTimeMillis()));
    }
}
