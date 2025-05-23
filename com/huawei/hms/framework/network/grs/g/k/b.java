package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f37030a;

    /* renamed from: b, reason: collision with root package name */
    private final long f37031b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f37030a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f37030a;
    }

    public boolean b() {
        if (SystemClock.elapsedRealtime() - this.f37031b <= MiniBoxNoticeInfo.MIN_5) {
            return true;
        }
        return false;
    }
}
