package com.hihonor.push.sdk;

import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f36364a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public volatile IPushInvoke f36365b;

    /* renamed from: c, reason: collision with root package name */
    public final b0.a f36366c;

    /* renamed from: d, reason: collision with root package name */
    public f0 f36367d;

    public d0(b0.a aVar) {
        this.f36366c = aVar;
    }

    public boolean a() {
        return this.f36364a.get() == 3 || this.f36364a.get() == 4;
    }

    public final void a(int i3) {
        Log.i("PushConnectionClient", "notifyFailed result: " + i3);
        b0.a aVar = this.f36366c;
        if (aVar != null) {
            z.a aVar2 = (z.a) aVar;
            if (Looper.myLooper() == z.this.f36461a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i3));
            } else {
                z.this.f36461a.post(new y(aVar2, i3));
            }
        }
    }
}
