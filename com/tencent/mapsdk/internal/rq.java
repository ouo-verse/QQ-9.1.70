package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rq implements Comparable<rq> {

    /* renamed from: a, reason: collision with root package name */
    public final int f150117a;

    /* renamed from: b, reason: collision with root package name */
    public final int f150118b;

    /* renamed from: c, reason: collision with root package name */
    public final int f150119c;

    public rq(int i3, int i16, int i17) {
        this.f150117a = i3;
        this.f150118b = i16;
        this.f150119c = i17;
    }

    private int a(@NonNull rq rqVar) {
        return this.f150117a - rqVar.f150117a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull rq rqVar) {
        return this.f150117a - rqVar.f150117a;
    }
}
