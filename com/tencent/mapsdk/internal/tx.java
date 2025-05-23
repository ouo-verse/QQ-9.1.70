package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tx implements oq {

    /* renamed from: a, reason: collision with root package name */
    private Context f151116a;

    /* renamed from: b, reason: collision with root package name */
    private final mz f151117b;

    /* renamed from: c, reason: collision with root package name */
    private String f151118c;

    public tx(Context context, String str) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f151116a = applicationContext;
            this.f151117b = mz.a(applicationContext, (TencentMapOptions) null);
            this.f151118c = str;
            return;
        }
        this.f151117b = null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String a() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            return mzVar.d();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String b() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            ku.a(mzVar.f149359b);
            return mzVar.f149359b;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String c() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            return mzVar.a(this.f151118c);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String d() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            return mzVar.c(this.f151118c);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String e() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            return mzVar.b(this.f151118c);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String f() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String g() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String h() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String i() {
        mz mzVar = this.f151117b;
        if (mzVar != null) {
            ku.a(mzVar.f149360c);
            return mzVar.f149360c;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.oq
    public final String j() {
        return null;
    }
}
