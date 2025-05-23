package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* compiled from: P */
/* loaded from: classes2.dex */
public class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f36457a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z.a f36458b;

    public y(z.a aVar, int i3) {
        this.f36458b = aVar;
        this.f36457a = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f36458b.a(HonorPushErrorEnum.fromCode(this.f36457a));
    }
}
