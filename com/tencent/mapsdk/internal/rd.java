package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rd extends lu {

    /* renamed from: a, reason: collision with root package name */
    private re f150011a;

    public rd(re reVar) {
        this.f150011a = reVar;
    }

    @Override // com.tencent.mapsdk.internal.lu
    public final byte[] f(String str) {
        re reVar;
        if (!hs.a(str) && str.startsWith(re.f150012a) && (reVar = this.f150011a) != null) {
            return reVar.a(str);
        }
        return null;
    }
}
