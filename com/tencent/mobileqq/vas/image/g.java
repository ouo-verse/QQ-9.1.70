package com.tencent.mobileqq.vas.image;

import com.tencent.mobileqq.vas.image.j;
import com.tencent.mobileqq.vas.inject.VasInjectApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g implements j {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements x91.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j.a f309591a;

        a(j.a aVar) {
            this.f309591a = aVar;
        }

        @Override // x91.a
        public void onAvifLibraryLoadResult(boolean z16) {
            this.f309591a.onResult(z16);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.j
    public void a(j.a aVar) {
        VasInjectApi.getInstance().loadApngSo(aVar);
    }

    @Override // com.tencent.mobileqq.vas.image.j
    public boolean b() {
        return com.tencent.mobileqq.avifcodec.b.b().d();
    }

    @Override // com.tencent.mobileqq.vas.image.j
    public void c(j.a aVar) {
        com.tencent.mobileqq.avifcodec.b.b().f(new a(aVar));
    }

    @Override // com.tencent.mobileqq.vas.image.j
    public boolean isApngSoLoaded() {
        return VasInjectApi.getInstance().isApngSoLoaded();
    }
}
