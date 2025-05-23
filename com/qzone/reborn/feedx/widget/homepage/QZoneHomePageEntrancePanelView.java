package com.qzone.reborn.feedx.widget.homepage;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.homepage.ui.component.newpanel.HomePanelList;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;

/* loaded from: classes37.dex */
public class QZoneHomePageEntrancePanelView extends QZoneBaseWidgetView implements IObserver.main {
    private com.qzone.homepage.ui.component.newpanel.d C;
    private com.qzone.homepage.ui.component.newpanel.h D;

    /* renamed from: e, reason: collision with root package name */
    private final LifecycleOwner f56350e;

    /* renamed from: f, reason: collision with root package name */
    private final com.qzone.reborn.feedx.viewmodel.c f56351f;

    /* renamed from: h, reason: collision with root package name */
    private final w f56352h;

    /* renamed from: i, reason: collision with root package name */
    private final com.qzone.reborn.feedx.viewmodel.f f56353i;

    /* renamed from: m, reason: collision with root package name */
    private final long f56354m;

    public QZoneHomePageEntrancePanelView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context);
        this.f56350e = lifecycleOwner;
        this.f56351f = cVar;
        w wVar = (w) cVar.W(w.class);
        this.f56352h = wVar;
        this.f56353i = (com.qzone.reborn.feedx.viewmodel.f) cVar.W(com.qzone.reborn.feedx.viewmodel.f.class);
        this.f56354m = wVar.getMUin();
        s0();
        r0();
        y0();
    }

    private void r0() {
        this.f56352h.C2().observe(this.f56350e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageEntrancePanelView.this.v0((x6.a) obj);
            }
        });
        this.f56352h.A2().observe(this.f56350e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageEntrancePanelView.this.w0((CustomNaviCacheData) obj);
            }
        });
        this.f56353i.M1().observe(this.f56350e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageEntrancePanelView.this.x0((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(x6.a aVar) {
        com.qzone.homepage.ui.component.newpanel.d dVar = this.C;
        if (dVar != null) {
            dVar.q(aVar);
        }
        com.qzone.homepage.ui.component.newpanel.h hVar = this.D;
        if (hVar != null) {
            hVar.q(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(final CustomNaviCacheData customNaviCacheData) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.homepage.QZoneHomePageEntrancePanelView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.qzone.personalize.business.b.q(customNaviCacheData)) {
                    if (QZoneHomePageEntrancePanelView.this.C != null) {
                        QZoneHomePageEntrancePanelView.this.C.m(0);
                    }
                } else {
                    int i3 = (int) customNaviCacheData.profileCrossBarBgColor;
                    if (QZoneHomePageEntrancePanelView.this.C != null) {
                        QZoneHomePageEntrancePanelView.this.C.m(i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Integer num) {
        com.qzone.homepage.ui.component.newpanel.d dVar = this.C;
        if (dVar != null) {
            dVar.n(num.intValue());
        }
        com.qzone.homepage.ui.component.newpanel.h hVar = this.D;
        if (hVar == null || hVar.i() == null || this.D.i().getBackground() == null) {
            return;
        }
        com.qzone.reborn.feedx.widget.i.a(this.D.i(), num.intValue());
        this.D.n(num.intValue());
    }

    private void y0() {
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 75);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.hma;
    }

    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        com.qzone.homepage.ui.component.newpanel.d dVar = this.C;
        if (dVar != null) {
            dVar.k();
        }
    }

    public void q0() {
        com.qzone.homepage.ui.component.newpanel.h hVar = this.D;
        if (hVar != null) {
            hVar.h();
        }
    }

    public void s0() {
        Activity activity = (Activity) getContext();
        if (activity == null) {
            return;
        }
        com.qzone.homepage.ui.component.newpanel.d dVar = new com.qzone.homepage.ui.component.newpanel.d(activity, this.f56354m, com.qzone.homepage.ui.component.newpanel.e.b().d(this.f56354m));
        this.C = dVar;
        dVar.j(this, activity);
        if (this.f56352h.M2()) {
            com.qzone.homepage.ui.component.newpanel.h hVar = new com.qzone.homepage.ui.component.newpanel.h((Activity) getContext(), this.f56354m);
            this.D = hVar;
            hVar.l(this, activity.getWindow().getDecorView());
        }
    }

    public boolean u0() {
        com.qzone.homepage.ui.component.newpanel.h hVar = this.D;
        return hVar != null && hVar.m();
    }

    private void z0(HomePanelList homePanelList) {
        if (homePanelList == null || homePanelList.ownerUin != this.f56354m) {
            return;
        }
        com.qzone.homepage.ui.component.newpanel.h hVar = this.D;
        if (hVar != null) {
            hVar.r(homePanelList.lst_hide);
        }
        this.C.p(homePanelList.lst_show);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event != null) {
            Object obj = event.params;
            if (obj instanceof HomePanelList) {
                z0((HomePanelList) obj);
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
