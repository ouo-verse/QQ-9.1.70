package com.tencent.cache.core.manager.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public a f98755a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f98756b;

    /* renamed from: c, reason: collision with root package name */
    public float f98757c;

    /* renamed from: d, reason: collision with root package name */
    public final int f98758d;

    /* renamed from: e, reason: collision with root package name */
    public final long f98759e;

    /* renamed from: f, reason: collision with root package name */
    public final int f98760f;

    public b(int i3, long j3, int i16, int i17) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f98758d = i3;
        this.f98759e = j3;
        this.f98760f = i17;
        if (i17 == 0) {
            f16 = 0.0f;
        } else {
            f16 = i16 / i17;
        }
        this.f98757c = f16;
    }
}
