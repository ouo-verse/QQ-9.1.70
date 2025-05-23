package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientArchive;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class z implements dj {

    /* renamed from: a, reason: collision with root package name */
    private final GProClientArchive f266754a;

    public z(GProClientArchive gProClientArchive) {
        this.f266754a = gProClientArchive;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dj
    public en a() {
        return new ca(this.f266754a.getTemplate1());
    }

    @NotNull
    public String toString() {
        return "GProClientArchiveInfo{archive=" + this.f266754a + "}";
    }
}
