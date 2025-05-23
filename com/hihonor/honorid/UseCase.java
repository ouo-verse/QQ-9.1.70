package com.hihonor.honorid;

import android.os.Parcelable;
import com.hihonor.honorid.UseCase.RequestValues;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class UseCase<Q extends RequestValues> {

    /* renamed from: a, reason: collision with root package name */
    private Q f36250a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class RequestValues implements Parcelable {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        b(this.f36250a);
    }

    protected abstract void b(Q q16);

    public void d(Q q16) {
        this.f36250a = q16;
    }

    public void c(a aVar) {
    }
}
