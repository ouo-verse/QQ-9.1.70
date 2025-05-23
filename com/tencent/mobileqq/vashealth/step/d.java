package com.tencent.mobileqq.vashealth.step;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\rJ\u0006\u0010\u000f\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/d;", "", "", "timestamp", "", "d", "now", "f", "", "sensorValue", "e", "Landroid/util/Pair;", "b", "Ljava/util/HashMap;", "c", "g", "I", "mLastSensorValue", "J", "mLastSensorTime", "mLastRecordTime", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f312333a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile int mLastSensorValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile long mLastSensorTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long mLastRecordTime;

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        e eVar = e.f312337a;
        if (mLastSensorTime <= eVar.a().getFirst().longValue()) {
            return;
        }
        k kVar = k.f312340a;
        if (!kVar.i()) {
            eVar.e(mLastSensorTime, mLastSensorValue);
            return;
        }
        long g16 = kVar.g();
        if (v.e(g16, mLastSensorTime)) {
            eVar.e(mLastSensorTime, mLastSensorValue);
            QLog.d("SportDataManager", 1, "is same day");
            return;
        }
        Pair<Integer, Integer> a16 = v.a(g16, eVar.b(String.valueOf(v.c(g16))), mLastSensorTime, mLastSensorValue);
        Integer num = a16.first;
        Intrinsics.checkNotNullExpressionValue(num, "crossDaySensorResult.first");
        if (num.intValue() > 0) {
            Integer num2 = a16.first;
            Intrinsics.checkNotNullExpressionValue(num2, "crossDaySensorResult.first");
            eVar.h(g16, num2.intValue());
        }
        Integer num3 = a16.second;
        Intrinsics.checkNotNullExpressionValue(num3, "crossDaySensorResult.second");
        if (num3.intValue() > 0) {
            long j3 = mLastSensorTime;
            Integer num4 = a16.second;
            Intrinsics.checkNotNullExpressionValue(num4, "crossDaySensorResult.second");
            eVar.e(j3, num4.intValue());
        }
    }

    @NotNull
    public final android.util.Pair<Long, Integer> b() {
        android.util.Pair<Long, Integer> create = android.util.Pair.create(Long.valueOf(mLastRecordTime), Integer.valueOf(mLastSensorValue));
        Intrinsics.checkNotNullExpressionValue(create, "create(mLastRecordTime, mLastSensorValue)");
        return create;
    }

    @NotNull
    public final HashMap<Long, Integer> c() {
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i3 = -6; i3 < 1; i3++) {
            long a16 = l.f312344a.a(i3);
            int b16 = e.f312337a.b(String.valueOf(a16));
            if (b16 != 0) {
                hashMap.put(Long.valueOf(a16), Integer.valueOf(b16));
            }
        }
        return hashMap;
    }

    public final void d(long timestamp) {
        e.f312337a.e(timestamp, mLastSensorValue);
    }

    public final void e(int sensorValue, long timestamp) {
        if (QLog.isDevelopLevel()) {
            QLog.d("SportDataManager", 1, "recordLastEvent, sensorValue:" + sensorValue + " , timestamp:" + timestamp + ", recordTime:" + NetConnInfoCenter.getServerTimeMillis());
        }
        mLastSensorValue = sensorValue;
        mLastSensorTime = NetConnInfoCenter.getServerTimeMillis();
        mLastRecordTime = timestamp;
        g();
    }

    public final void f(long now) {
        QLog.d("SportDataManager", 1, "shutdown flag is set, timestamp " + now);
        g();
        e.f312337a.g(now);
    }

    public final void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.step.c
            @Override // java.lang.Runnable
            public final void run() {
                d.h();
            }
        }, 32, null, false);
    }
}
