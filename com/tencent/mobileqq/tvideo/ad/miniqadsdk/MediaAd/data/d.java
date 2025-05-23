package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data;

import com.tencent.qqlive.ona.protocol.jce.AdVideoItem;
import kt3.j;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public AdVideoItem f303594a;

    /* renamed from: b, reason: collision with root package name */
    public long f303595b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f303596c;

    /* renamed from: d, reason: collision with root package name */
    public j f303597d;

    /* renamed from: e, reason: collision with root package name */
    public long f303598e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private AdVideoItem f303599a;

        /* renamed from: b, reason: collision with root package name */
        private long f303600b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f303601c;

        /* renamed from: d, reason: collision with root package name */
        private j f303602d;

        /* renamed from: e, reason: collision with root package name */
        private long f303603e = -1;

        public b f(long j3) {
            this.f303600b = j3;
            return this;
        }

        public d g() {
            return new d(this);
        }

        public b h(boolean z16) {
            this.f303601c = z16;
            return this;
        }

        public b i(long j3) {
            this.f303603e = j3;
            return this;
        }

        public b j(j jVar) {
            this.f303602d = jVar;
            return this;
        }

        public b k(AdVideoItem adVideoItem) {
            this.f303599a = adVideoItem;
            return this;
        }
    }

    d(b bVar) {
        this.f303594a = bVar.f303599a;
        this.f303595b = bVar.f303600b;
        this.f303596c = bVar.f303601c;
        this.f303597d = bVar.f303602d;
        this.f303598e = bVar.f303603e;
    }
}
