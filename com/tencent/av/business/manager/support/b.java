package com.tencent.av.business.manager.support;

import android.os.Build;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.utils.m;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f73448a;

    /* renamed from: b, reason: collision with root package name */
    protected long f73449b;

    /* renamed from: c, reason: collision with root package name */
    protected int f73450c;

    /* renamed from: d, reason: collision with root package name */
    protected long f73451d;

    /* renamed from: e, reason: collision with root package name */
    protected VideoAppInterface f73452e;

    public b(VideoAppInterface videoAppInterface) {
        this.f73452e = videoAppInterface;
    }

    public abstract boolean a(String str);

    public void b() {
        this.f73448a = Build.VERSION.SDK_INT;
        this.f73449b = AVCoreSystemInfo.getMaxCpuFreq();
        this.f73450c = AVCoreSystemInfo.getNumCores();
        this.f73451d = m.c();
    }

    public abstract boolean c(int i3, String str);

    public abstract void d();

    public abstract void e();
}
