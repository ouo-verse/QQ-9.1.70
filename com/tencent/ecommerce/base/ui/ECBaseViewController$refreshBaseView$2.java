package com.tencent.ecommerce.base.ui;

import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
final class ECBaseViewController$refreshBaseView$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ PTSComposer f101020d;
    final /* synthetic */ ECBaseViewController this$0;

    @Override // java.lang.Runnable
    public final void run() {
        ECBasePtsView eCBasePtsView;
        ECBaseViewController.b bVar;
        eCBasePtsView = this.this$0.basePtsView;
        PTSComposer pTSComposer = this.f101020d;
        bVar = this.this$0.ptsLiteEventListener;
        eCBasePtsView.b(pTSComposer, bVar);
        this.this$0.ptsComposer = this.f101020d;
    }
}
