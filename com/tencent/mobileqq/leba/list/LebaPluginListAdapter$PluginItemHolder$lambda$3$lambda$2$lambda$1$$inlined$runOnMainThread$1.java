package com.tencent.mobileqq.leba.list;

import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.list.LebaPluginListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/leba/util/ThreadUtil$runOnMainThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class LebaPluginListAdapter$PluginItemHolder$lambda$3$lambda$2$lambda$1$$inlined$runOnMainThread$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f240615d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ n f240616e;
    final /* synthetic */ LebaPluginListAdapter.PluginItemHolder this$0;

    public LebaPluginListAdapter$PluginItemHolder$lambda$3$lambda$2$lambda$1$$inlined$runOnMainThread$1(LebaPluginListAdapter.PluginItemHolder pluginItemHolder, View view, n nVar) {
        this.this$0 = pluginItemHolder;
        this.f240615d = view;
        this.f240616e = nVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pluginItemHolder, view, nVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.this$0.l(this.f240615d, this.f240616e);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
