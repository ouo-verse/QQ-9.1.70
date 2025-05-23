package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class DWMethodHandler$realtimeGetTemplateWithInfo$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f70145d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f70146e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f70147f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Runnable f70148h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ DKMethodHandler.Callback f70149i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f70150m;
    final /* synthetic */ DWMethodHandler this$0;

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            if (this.f70145d.await(this.f70146e, TimeUnit.MILLISECONDS)) {
                if (this.f70147f.element) {
                    this.f70148h.run();
                } else {
                    DWMethodHandler.e(null, this.f70149i, -32, "load template failed");
                }
            } else if (this.f70150m.element) {
                DWMethodHandler.e(null, this.f70149i, -33, "load template timeout");
            } else {
                DWMethodHandler.e(null, this.f70149i, -31, "load config failed");
            }
        } catch (InterruptedException e16) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.b("MWMethodHandler", "fillIntoBody wait error.", e16);
            if (this.f70150m.element) {
                DWMethodHandler.e(null, this.f70149i, -32, "load template interrupted");
            } else {
                DWMethodHandler.e(null, this.f70149i, -31, "load config interrupted");
            }
        }
    }
}
