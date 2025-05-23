package com.tencent.liteav.base.system;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class j implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final j f118993a = new j();

    j() {
    }

    public static Callable a() {
        return f118993a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String model;
        model = DeviceInfoMonitor.getModel();
        return model;
    }
}
