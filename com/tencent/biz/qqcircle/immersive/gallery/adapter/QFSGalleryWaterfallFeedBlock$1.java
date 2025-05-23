package com.tencent.biz.qqcircle.immersive.gallery.adapter;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes4.dex */
class QFSGalleryWaterfallFeedBlock$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f86433d;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        for (e30.b bVar : c.t0(null)) {
            if (!((Boolean) this.f86433d.invoke(bVar)).booleanValue()) {
                arrayList.add(bVar);
            }
        }
        throw null;
    }
}
