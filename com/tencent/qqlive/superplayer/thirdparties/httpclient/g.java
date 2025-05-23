package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import androidx.annotation.Nullable;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class g extends HttpDataSource.a {

    /* renamed from: b, reason: collision with root package name */
    private final String f345453b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final m f345454c;

    /* renamed from: d, reason: collision with root package name */
    private final int f345455d;

    /* renamed from: e, reason: collision with root package name */
    private final int f345456e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f345457f;

    public g(String str) {
        this(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(int i3, HttpDataSource.c cVar) {
        f fVar = new f(this.f345453b, null, i3, i3, this.f345457f, cVar);
        m mVar = this.f345454c;
        if (mVar != null) {
            fVar.b(mVar);
        }
        return fVar;
    }

    public g(String str, @Nullable m mVar) {
        this(str, mVar, 8000, 8000, false);
    }

    public g(String str, @Nullable m mVar, int i3, int i16, boolean z16) {
        this.f345453b = a.c(str);
        this.f345454c = mVar;
        this.f345455d = i3;
        this.f345456e = i16;
        this.f345457f = z16;
    }
}
