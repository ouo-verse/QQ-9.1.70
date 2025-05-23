package nb4;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lnb4/c;", "", "", "c", "a", "", "connected", "b", "", "J", "mBindServiceCallTime", "mServiceConnectTime", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f419781a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mBindServiceCallTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mServiceConnectTime;

    c() {
    }

    public final void a() {
        QLog.i("ZPlanServiceLifeCycleMonitor_", 1, "onStartServiceCall mStartServiceCallTime:" + mBindServiceCallTime);
        if (h.c("ZPlanServiceLifeCycleMonitor_", 2000L)) {
            return;
        }
        mBindServiceCallTime = NetConnInfoCenter.getServerTimeMillis();
    }

    public final void b(boolean connected) {
        QLog.i("ZPlanServiceLifeCycleMonitor_", 1, "onServiceConnected " + connected);
        if (connected) {
            mServiceConnectTime = NetConnInfoCenter.getServerTimeMillis();
        } else {
            c();
        }
    }

    private final void c() {
        mBindServiceCallTime = 0L;
        mServiceConnectTime = 0L;
    }
}
