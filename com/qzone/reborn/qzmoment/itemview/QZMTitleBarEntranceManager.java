package com.qzone.reborn.qzmoment.itemview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.qzmoment.comment.event.QZoneFeedUnreadUpdateEvent;
import com.qzone.util.ak;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import rn.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMTitleBarEntranceManager implements SimpleEventReceiver {
    private QZoneUserAvatarView C;
    private QZoneUserAvatarView D;
    private ImageView E;
    private TextView F;
    private QZoneCountInfo G;
    private boolean H;
    private ViewGroup I;
    private rn.e J;
    private rn.f K;

    /* renamed from: d, reason: collision with root package name */
    private Context f58889d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f58890e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f58891f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f58892h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f58893i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f58894m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.J.j();
    }

    private void F() {
        ViewGroup viewGroup = this.f58891f;
        if (viewGroup == null) {
            return;
        }
        fo.c.b("dt_clck", viewGroup, "em_bas_entrancemoment_toptitle", s());
        I(false);
    }

    private void G() {
        ViewGroup viewGroup = this.f58891f;
        if (viewGroup == null) {
            return;
        }
        fo.c.b("dt_imp_end", viewGroup, "em_bas_entrancemoment_toptitle", s());
    }

    private void H() {
        ViewGroup viewGroup = this.f58891f;
        if (viewGroup == null) {
            return;
        }
        fo.c.b("dt_imp", viewGroup, "em_bas_entrancemoment_toptitle", s());
        I(true);
    }

    private void I(boolean z16) {
        if (com.tencent.mobileqq.service.qzone.b.e() == 0 || TextUtils.isEmpty(com.tencent.mobileqq.service.qzone.b.f())) {
            return;
        }
        ak.a(z16 ? 101 : 102, com.tencent.mobileqq.service.qzone.b.e(), com.tencent.mobileqq.service.qzone.b.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z16) {
        rn.b.n(this.f58894m, z16);
        rn.b.n(this.E, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(QZoneCountInfo qZoneCountInfo) {
        rn.f fVar = this.K;
        if (fVar == null) {
            return;
        }
        fVar.h(qZoneCountInfo);
    }

    private void o() {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ViewGroup viewGroup = this.f58890e;
        if (viewGroup == null) {
            return;
        }
        this.f58891f = (ViewGroup) viewGroup.findViewById(R.id.f67943ep);
        this.f58893i = (TextView) this.f58890e.findViewById(R.id.f67953eq);
        this.f58894m = (FrameLayout) this.f58890e.findViewById(R.id.f67863eh);
        this.C = (QZoneUserAvatarView) this.f58890e.findViewById(R.id.f67963er);
        this.D = (QZoneUserAvatarView) this.f58890e.findViewById(R.id.f67973es);
        this.f58891f.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.itemview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZMTitleBarEntranceManager.this.x(view);
            }
        });
        this.f58892h.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.itemview.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZMTitleBarEntranceManager.this.y(view);
            }
        });
    }

    private int r() {
        QZoneCountInfo qZoneCountInfo = this.G;
        if (qZoneCountInfo == null) {
            return 0;
        }
        return qZoneCountInfo.countId == 66 ? 1 : 2;
    }

    private fo.b s() {
        HashMap hashMap = new HashMap();
        hashMap.put("point_type", Integer.valueOf(r()));
        hashMap.put("dt_pgid", "pg_bas_social_updates");
        return new fo.b().l(hashMap).k(ExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
    }

    private void t() {
        F();
        G();
        QZoneCountInfo qZoneCountInfo = this.G;
        ((jn.b) i.t(jn.b.class)).b(this.f58889d, rn.b.a(qZoneCountInfo != null && qZoneCountInfo.countId == 66));
        o();
    }

    private void u() {
        if (this.J == null) {
            this.J = new rn.e();
        }
        if (this.K == null) {
            this.K = new rn.f(this.I);
        }
        this.J.p(new e.c() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.4
            @Override // rn.e.c
            public void a() {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        rn.b.n(QZMTitleBarEntranceManager.this.f58891f, false);
                    }
                });
            }

            @Override // rn.e.c
            public void b() {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        rn.b.n(QZMTitleBarEntranceManager.this.f58891f, true);
                    }
                });
            }

            @Override // rn.e.c
            public void c() {
                QZMTitleBarEntranceManager.this.P(false);
            }

            @Override // rn.e.c
            public void d(long j3) {
            }
        });
        this.J.o(this.f58891f);
        this.J.n(this.K);
        N(null);
    }

    private void v() {
        ImageView imageView = this.f58892h;
        if (imageView == null) {
            return;
        }
        imageView.getLayoutParams().width = ViewUtils.dip2px(28.0f);
        this.f58892h.getLayoutParams().height = ViewUtils.dip2px(28.0f);
    }

    private void w() {
        rn.b.d();
        q();
        v();
        u();
        P(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        this.J.i();
    }

    public void B() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        rn.e eVar = this.J;
        if (eVar != null) {
            eVar.f();
        }
        this.f58889d = null;
        G();
    }

    public void D() {
        ViewGroup viewGroup;
        if (this.J == null || (viewGroup = this.f58891f) == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.g
            @Override // java.lang.Runnable
            public final void run() {
                QZMTitleBarEntranceManager.this.z();
            }
        });
    }

    public void E() {
        ViewGroup viewGroup;
        if (this.J == null || (viewGroup = this.f58891f) == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.h
            @Override // java.lang.Runnable
            public final void run() {
                QZMTitleBarEntranceManager.this.A();
            }
        });
    }

    public void L(Context context, ViewGroup viewGroup, ImageView imageView, ImageView imageView2, TextView textView) {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f58889d = context;
        this.f58890e = viewGroup;
        this.f58892h = imageView;
        this.E = imageView2;
        this.F = textView;
        w();
    }

    public void M(QZoneCountInfo qZoneCountInfo) {
        rn.b.n(this.f58891f, false);
        if (this.H) {
            return;
        }
        this.H = true;
        if (rn.b.i(qZoneCountInfo)) {
            return;
        }
        D();
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.2
            @Override // java.lang.Runnable
            public void run() {
                QZMTitleBarEntranceManager.this.E();
            }
        }, 5000L);
    }

    public void P(final boolean z16) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.1
            @Override // java.lang.Runnable
            public void run() {
                Object valueOf;
                if (rn.b.b(QZMTitleBarEntranceManager.this.f58893i)) {
                    QZMTitleBarEntranceManager.this.q();
                }
                QZoneCountInfo f16 = rn.b.f();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("red touch info id is ");
                String str = "";
                if (f16 == null) {
                    valueOf = "";
                } else {
                    valueOf = Integer.valueOf(f16.countId);
                }
                sb5.append(valueOf);
                sb5.append("text is ");
                if (f16 != null) {
                    str = f16.strShowMsg;
                }
                sb5.append(str);
                QLog.d("QZMTitleBarEntranceManager", 1, sb5.toString());
                if (f16 != null) {
                    QZMTitleBarEntranceManager.this.G = f16;
                    com.tencent.mobileqq.service.qzone.b.x(f16.countId, f16.cTime);
                    com.tencent.mobileqq.service.qzone.b.y(f16.countId, f16.uCount);
                } else {
                    QZMTitleBarEntranceManager.this.G = null;
                }
                if (QZMTitleBarEntranceManager.this.J != null && QZMTitleBarEntranceManager.this.J.h()) {
                    QZMTitleBarEntranceManager.this.N(f16);
                } else {
                    rn.b.s(QZMTitleBarEntranceManager.this.f58893i, f16);
                    QZMTitleBarEntranceManager.this.J(f16 != null);
                    QZMTitleBarEntranceManager.this.O(f16);
                }
                rn.b.p(QZMTitleBarEntranceManager.this.E, QZMTitleBarEntranceManager.this.F, f16);
                QZMTitleBarEntranceManager.this.N(f16);
                if (z16) {
                    QZMTitleBarEntranceManager.this.M(f16);
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedUnreadUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedUnreadUpdateEvent) {
            QLog.d("QZMTitleBarEntranceManager", 2, "receive event, update unread info");
            P(true);
        }
    }

    public void onResume() {
        H();
    }

    private void p() {
        this.G = null;
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.qzmoment.itemview.QZMTitleBarEntranceManager.3
            @Override // java.lang.Runnable
            public void run() {
                QZMTitleBarEntranceManager.this.J(false);
                if (QZMTitleBarEntranceManager.this.J == null || !QZMTitleBarEntranceManager.this.J.h()) {
                    rn.b.s(QZMTitleBarEntranceManager.this.f58893i, null);
                }
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            J(false);
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                QZoneCountUserInfo qZoneCountUserInfo = arrayList.get(i3);
                if (qZoneCountUserInfo != null) {
                    arrayList2.add(Long.valueOf(qZoneCountUserInfo.uin));
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.e("QZMTitleBarEntranceManager", 1, "invalidate uin list");
                J(false);
                return;
            }
            if (arrayList2.size() == 1) {
                rn.b.k(this.C, ((Long) arrayList2.get(0)).longValue());
                rn.b.n(this.D, false);
            } else {
                rn.b.k(this.C, ((Long) arrayList2.get(0)).longValue());
                rn.b.k(this.D, ((Long) arrayList2.get(1)).longValue());
            }
            J(true);
            return;
        }
        QLog.e("QZMTitleBarEntranceManager", 1, "invalidate list");
        J(false);
    }

    public void K(View view) {
        if (view == null) {
            QLog.e("QZMTitleBarEntranceManager", 1, "copy cotainer is null");
        } else {
            this.I = (ViewGroup) view.findViewById(R.id.f67943ep);
        }
    }

    public void C() {
    }
}
