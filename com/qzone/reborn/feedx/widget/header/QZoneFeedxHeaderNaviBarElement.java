package com.qzone.reborn.feedx.widget.header;

import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.business.tianshu.QZoneGalleryEntranceGuideBubbleController;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxHeaderNaviBarElement extends d implements IObserver.main, Observer<CoverCacheData> {

    /* renamed from: f, reason: collision with root package name */
    public QZoneFeedxNavigatorBar f56127f;

    /* renamed from: h, reason: collision with root package name */
    private QZoneGalleryEntranceGuideBubbleController f56128h;

    public QZoneFeedxHeaderNaviBarElement(View view) {
        super(view);
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = (QZoneFeedxNavigatorBar) view.findViewById(R.id.mzz);
        this.f56127f = qZoneFeedxNavigatorBar;
        qZoneFeedxNavigatorBar.f56419h = (ImageView) view.findViewById(R.id.f162854n00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        final CustomFriendNaviData l3 = com.qzone.personalize.business.b.n().l(LoginData.getInstance().getUin());
        f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.i
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHeaderNaviBarElement.this.z(l3);
            }
        });
    }

    private void C(boolean z16, CustomFriendNaviData customFriendNaviData) {
        this.f56127f.setBarStyle(z16);
        this.f56127f.removeAllViews();
        this.f56127f.r(g());
        this.f56127f.y0();
        this.f56127f.v0(customFriendNaviData);
        t().c(g(), this.f56127f.z(), 0);
        this.f56127f.F0();
    }

    private void s() {
        EventCenter.getInstance().addUIObserver(this, "Personalize", 22);
        EventCenter.getInstance().addUIObserver(this, "Feed", 36);
        EventCenter.getInstance().addUIObserver(this, "UnRead", 1);
    }

    private void u(Event event, Object[] objArr) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar;
        if (event.what != 22 || objArr == null || objArr.length <= 0) {
            return;
        }
        Object obj = objArr[0];
        if (!(obj instanceof CustomFriendNaviData) || (qZoneFeedxNavigatorBar = this.f56127f) == null) {
            return;
        }
        qZoneFeedxNavigatorBar.v0((CustomFriendNaviData) obj);
    }

    private void v(Event event) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar;
        if (event.what != 1 || (qZoneFeedxNavigatorBar = this.f56127f) == null) {
            return;
        }
        qZoneFeedxNavigatorBar.y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        QZoneFeedAlertService.getInstance().ensureLoadUnread();
        QZoneFeedAlertService.getInstance().loadNavigatorEntryListFromDB();
        final boolean X = QZoneConfigHelper.X();
        final CustomFriendNaviData l3 = com.qzone.personalize.business.b.n().l(LoginData.getInstance().getUin());
        f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.h
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHeaderNaviBarElement.this.y(X, l3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(boolean z16, CustomFriendNaviData customFriendNaviData) {
        jo.h hVar = jo.h.f410717a;
        hVar.g("widget_view_inflate").f(this.f56127f);
        C(z16, customFriendNaviData);
        hVar.g("widget_view_inflate").a(this.f56127f);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onChanged(CoverCacheData coverCacheData) {
        RFWLog.i("QZoneFeedxNavigatorBar", RFWLog.USR, "onChanged: " + coverCacheData);
        this.f56127f.u0(coverCacheData);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.b0();
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHeaderNaviBarElement.this.A();
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderNaviBarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.i0();
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.QZoneFeedxHeaderNaviBarElement.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxHeaderNaviBarElement.this.w();
            }
        });
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar2 = this.f56127f;
        if (qZoneFeedxNavigatorBar2 != null) {
            qZoneFeedxNavigatorBar2.D0(null);
        }
        ((com.qzone.reborn.feedx.viewmodel.f) k(com.qzone.reborn.feedx.viewmodel.f.class)).N1().observe(i(), this);
        s();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onConfigurationChanged(Configuration configuration) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.C0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.Y();
        }
        QZoneGalleryEntranceGuideBubbleController qZoneGalleryEntranceGuideBubbleController = this.f56128h;
        if (qZoneGalleryEntranceGuideBubbleController != null) {
            qZoneGalleryEntranceGuideBubbleController.d();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object[] objArr = (Object[]) event.params;
        String name = event.source.getName();
        name.hashCode();
        if (!name.equals("UnRead")) {
            if (name.equals("Personalize")) {
                u(event, objArr);
                return;
            }
            return;
        }
        v(event);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.a0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPostThemeChanged() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.c0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.b0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onWindowFocusChanged(boolean z16) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        if (qZoneFeedxNavigatorBar != null) {
            qZoneFeedxNavigatorBar.F0();
            this.f56127f.q0(g());
        }
    }

    public QZoneGalleryEntranceGuideBubbleController t() {
        if (this.f56128h == null) {
            this.f56128h = new QZoneGalleryEntranceGuideBubbleController(f());
        }
        return this.f56128h;
    }

    public boolean x() {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = this.f56127f;
        return qZoneFeedxNavigatorBar != null && qZoneFeedxNavigatorBar.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(CustomFriendNaviData customFriendNaviData) {
        QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar;
        if (customFriendNaviData == null || (qZoneFeedxNavigatorBar = this.f56127f) == null) {
            return;
        }
        qZoneFeedxNavigatorBar.v0(customFriendNaviData);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
    }
}
