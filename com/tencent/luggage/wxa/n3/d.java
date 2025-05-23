package com.tencent.luggage.wxa.n3;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f135156a;

    /* renamed from: b, reason: collision with root package name */
    public final String f135157b;

    /* renamed from: c, reason: collision with root package name */
    public final String f135158c;

    /* renamed from: d, reason: collision with root package name */
    public final String f135159d;

    public d(int i3, String fileUrl, String thumbUrl, String taskIdent) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(taskIdent, "taskIdent");
        this.f135156a = i3;
        this.f135157b = fileUrl;
        this.f135158c = thumbUrl;
        this.f135159d = taskIdent;
    }

    public final int a() {
        return this.f135156a;
    }

    public final String b() {
        return this.f135157b;
    }

    public final String c() {
        return this.f135159d;
    }

    public final String d() {
        return this.f135158c;
    }
}
