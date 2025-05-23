package com.tencent.av.smallscreen;

import android.content.Context;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends e {

    /* renamed from: g, reason: collision with root package name */
    protected static int f74618g = 3;

    public h(Context context) {
        this.f74601a = "SmallScreenShare";
        this.f74604d = R.layout.di8;
        this.f74605e = context.getResources().getDimensionPixelSize(R.dimen.f159372cz3);
        this.f74606f = context.getResources().getDimensionPixelSize(R.dimen.f159371cz2);
    }

    @Override // com.tencent.av.smallscreen.e
    public void c() {
        f74618g = this.f74602b.b();
        super.c();
    }

    @Override // com.tencent.av.smallscreen.e
    public void e(boolean z16, int i3) {
        super.e(z16, f74618g);
    }
}
