package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f345426a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<m> f345427b = new ArrayList<>(1);

    /* renamed from: c, reason: collision with root package name */
    private int f345428c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private DataSpec f345429d;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(boolean z16) {
        this.f345426a = z16;
    }

    public final void b(m mVar) {
        if (!this.f345427b.contains(mVar)) {
            this.f345427b.add(mVar);
            this.f345428c++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i3) {
        DataSpec dataSpec = (DataSpec) a.a(this.f345429d);
        for (int i16 = 0; i16 < this.f345428c; i16++) {
            this.f345427b.get(i16).c(this, dataSpec, this.f345426a, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        DataSpec dataSpec = (DataSpec) a.a(this.f345429d);
        for (int i3 = 0; i3 < this.f345428c; i3++) {
            this.f345427b.get(i3).d(this, dataSpec, this.f345426a);
        }
        this.f345429d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(DataSpec dataSpec) {
        for (int i3 = 0; i3 < this.f345428c; i3++) {
            this.f345427b.get(i3).b(this, dataSpec, this.f345426a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(DataSpec dataSpec) {
        this.f345429d = dataSpec;
        for (int i3 = 0; i3 < this.f345428c; i3++) {
            this.f345427b.get(i3).a(this, dataSpec, this.f345426a);
        }
    }
}
