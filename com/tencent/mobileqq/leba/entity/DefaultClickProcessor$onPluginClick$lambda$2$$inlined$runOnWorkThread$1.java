package com.tencent.mobileqq.leba.entity;

import android.app.Activity;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/leba/util/ThreadUtil$runOnWorkThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class DefaultClickProcessor$onPluginClick$lambda$2$$inlined$runOnWorkThread$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f240442d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ n f240443e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ f f240444f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Activity f240445h;
    final /* synthetic */ DefaultClickProcessor this$0;

    public DefaultClickProcessor$onPluginClick$lambda$2$$inlined$runOnWorkThread$1(DefaultClickProcessor defaultClickProcessor, View view, n nVar, f fVar, Activity activity) {
        this.this$0 = defaultClickProcessor;
        this.f240442d = view;
        this.f240443e = nVar;
        this.f240444f = fVar;
        this.f240445h = activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, defaultClickProcessor, view, nVar, fVar, activity);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DefaultClickProcessor.a c16 = this.this$0.c(this.f240442d, this.f240443e, this.f240444f);
        this.this$0.j(this.f240443e, this.f240444f);
        this.this$0.g(this.f240445h, c16);
    }
}
