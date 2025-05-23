package com.tencent.mobileqq.microapp.widget;

import android.view.View;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class f implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f246126a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k.a f246127b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TabBarView f246128c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TabBarView tabBarView, int i3, k.a aVar) {
        this.f246128c = tabBarView;
        this.f246126a = i3;
        this.f246127b = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tabBarView, Integer.valueOf(i3), aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabBarView.b bVar;
        TabBarView.b bVar2;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            bVar = this.f246128c.f246086c;
            if (bVar != null) {
                bVar2 = this.f246128c.f246086c;
                bVar2.onTabItemClick(this.f246126a, this.f246127b.f245870a);
            }
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
