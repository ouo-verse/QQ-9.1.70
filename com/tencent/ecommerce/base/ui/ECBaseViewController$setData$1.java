package com.tencent.ecommerce.base.ui;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
final class ECBaseViewController$setData$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f101021d;
    final /* synthetic */ ECBaseViewController this$0;

    @Override // java.lang.Runnable
    public final void run() {
        PTSComposer pTSComposer;
        pTSComposer = this.this$0.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.setData(this.f101021d);
        }
    }
}
