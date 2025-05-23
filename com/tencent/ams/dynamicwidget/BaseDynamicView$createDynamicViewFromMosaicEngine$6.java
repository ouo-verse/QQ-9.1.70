package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class BaseDynamicView$createDynamicViewFromMosaicEngine$6 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DKMosaicEngine f70134d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ DKEngine.CreateViewInfo f70135e;
    final /* synthetic */ BaseDynamicView this$0;

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70134d.createView(this.f70135e);
        com.tencent.ams.dynamicwidget.utils.b bVar = com.tencent.ams.dynamicwidget.utils.b.f70218a;
        String z16 = this.this$0.z();
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        str = this.this$0.hashCode;
        sb5.append(str);
        sb5.append("] mosaicEngine.createView");
        bVar.c(z16, sb5.toString());
    }
}
