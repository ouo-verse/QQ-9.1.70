package com.tencent.gdtad.api.halfscreen;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Bundle f108564a;

    /* renamed from: b, reason: collision with root package name */
    public GdtAd f108565b;

    /* renamed from: c, reason: collision with root package name */
    public AdClickLocationParams f108566c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f108567d;

    /* renamed from: e, reason: collision with root package name */
    public long f108568e;

    public boolean a() {
        WeakReference<Activity> weakReference;
        if (this.f108565b != null && (weakReference = this.f108567d) != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }
}
