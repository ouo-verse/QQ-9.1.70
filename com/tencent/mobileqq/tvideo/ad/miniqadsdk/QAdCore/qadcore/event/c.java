package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ListenerMgr<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a> f303879a = new ListenerMgr<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ListenerMgr.a<com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f303880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f303881b;

        a(int i3, b bVar) {
            this.f303880a = i3;
            this.f303881b = bVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a aVar) {
            aVar.d(this.f303880a, this.f303881b);
        }
    }

    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a aVar) {
        this.f303879a.a(aVar);
    }

    public void b(int i3, b bVar) {
        this.f303879a.b(new a(i3, bVar));
    }
}
