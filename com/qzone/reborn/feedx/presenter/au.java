package com.qzone.reborn.feedx.presenter;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.reborn.feedx.presenter.springfestival.QZoneDragonAnimEvent;
import com.qzone.reborn.feedx.util.QZoneClickAreaUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class au extends vg.a implements Observer<af.c>, View.OnClickListener {
    SuperLikeView F;
    private ImageView G;
    private ImageView H;
    private xg.e I;
    private gf.a J;
    private long K;
    private List<ug.a> L = new ArrayList();
    private View M;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements SuperLikeView.OnEventBack {
        a() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
        public void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
            if (superLikeAnimator$Event == SuperLikeAnimator$Event.CLICK) {
                view.performClick();
            }
        }
    }

    private void J() {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        final String a16 = ef.b.a(businessFeedData);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.as
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                au.this.S(a16, (gf.e) obj);
            }
        }).run();
    }

    private void L() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.F);
            arrayList.add(this.G);
            arrayList.add(this.H);
            Rect rect = new Rect();
            rect.left = com.qzone.util.ar.d(20.0f);
            rect.top = com.qzone.util.ar.d(20.0f);
            rect.right = com.qzone.util.ar.d(10.0f);
            rect.bottom = com.qzone.util.ar.d(20.0f);
            QZoneClickAreaUtils.c(this.M, arrayList, rect);
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneFeedOperatePresenter", RFWLog.USR, th5);
        }
    }

    private void M() {
        CellDecorateInfo.CellPolymorphicPraise cellPolymorphicPraise;
        if (this.f441565h.getLikeInfo().isLiked) {
            CellDecorateInfo cellDecorateInfo = this.f441565h.getCellDecorateInfo();
            if (cellDecorateInfo != null && (cellPolymorphicPraise = cellDecorateInfo.cellPolymorphicPraise) != null && cellPolymorphicPraise.iItemId > -1) {
                com.qzone.util.ap.f59791b.e(216, 1, this.f441567m, this.f441565h);
                return;
            } else {
                com.qzone.util.ap.f59791b.e(3, 1, this.f441567m, this.f441565h);
                return;
            }
        }
        com.qzone.util.ap.f59791b.e(1, 1, this.f441567m, this.f441565h);
    }

    private void N() {
        if (this.J == null) {
            this.J = (gf.a) j(gf.a.class);
        }
        if (this.J != null) {
            com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(this.f441565h);
            bVar.f54740a = this.f441567m;
            bVar.f54741b = 4;
            bVar.f54742c = 1;
            this.J.f6(bVar);
            this.J.c1(this.f441565h, null, this.f441567m);
        }
        com.qzone.util.ap.f59791b.e(4, 1, this.f441567m, this.f441565h);
    }

    private void O() {
        gf.b bVar = (gf.b) j(gf.b.class);
        if (bVar != null) {
            bVar.P4(this.f441565h);
        }
    }

    private void P() {
        if (this.f441565h == null) {
            return;
        }
        if (this.I == null) {
            this.I = new xg.e();
        }
        if (K(this.f441565h)) {
            for (int i3 = 0; i3 < this.L.size(); i3++) {
                ug.a aVar = this.L.get(i3);
                if (aVar != null && aVar.d(this.F, this.f441565h)) {
                    this.F.setSelected(true);
                    this.I.a(this.f441565h, this.C);
                    if (this.f441565h.getLikeInfo() != null && this.f441565h.getLikeInfo().isLiked) {
                        SimpleEventBus.getInstance().dispatchEvent(new QZoneDragonAnimEvent(ef.b.a(this.f441565h), true, i()));
                    }
                    if (i3 < this.L.size() - 1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("special_like_type", Integer.valueOf(i3));
                        fo.c.c("ev_qz_special_like_click", hashMap);
                    }
                    M();
                    AccessibilityUtil.s(this.F, com.qzone.util.l.a(R.string.f2202368k));
                    return;
                }
            }
        }
    }

    private void Q() {
        gf.b bVar = (gf.b) j(gf.b.class);
        if (bVar != null) {
            bVar.O3(this.f441565h);
        }
    }

    private void R(View view) {
        this.L.add(new ug.c());
        this.L.add(new ug.g(this.C));
        this.L.add(new ug.f(this.C));
        this.L.add(new ug.d(this.C));
        this.L.add(new ug.e(this.C));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(String str, gf.e eVar) {
        eVar.k5(this.G, "em_qz_comment_icon", str, this.f441565h);
        eVar.k5(this.H, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, str, this.f441565h);
        eVar.k5(this.F, "em_qz_like_icon", str, this.f441565h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean T(View view) {
        Q();
        return true;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData.isFakeFeed()) {
            this.F.setAlpha(0.3f);
            this.G.setAlpha(0.3f);
            this.H.setAlpha(0.3f);
            this.F.setEnabled(false);
            this.F.setSelected(false);
            this.G.setEnabled(false);
            this.H.setEnabled(false);
            if (i() != null) {
                this.F.setImageDrawable(i().getDrawable(R.drawable.f153142));
                return;
            }
            return;
        }
        this.F.setEnabled(true);
        this.G.setEnabled(true);
        this.H.setEnabled(true);
        this.F.setAlpha(1.0f);
        this.G.setAlpha(1.0f);
        this.H.setAlpha(1.0f);
        V(businessFeedData);
        if (!TextUtils.isEmpty(ef.b.a(businessFeedData))) {
            ze.a.a().observerGlobalState(new af.c(ef.b.a(businessFeedData), businessFeedData.cellLikeInfo), this);
        } else {
            QLog.e("QZoneFeedOperatePresenter", 1, "ugcKey is empty");
        }
        J();
    }

    public boolean K(BusinessFeedData businessFeedData) {
        Iterator<ug.a> it = this.L.iterator();
        while (it.hasNext()) {
            if (it.next().c(businessFeedData)) {
                this.K = SystemClock.uptimeMillis() + 500;
                return true;
            }
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.K <= 1000) {
            return false;
        }
        this.K = uptimeMillis;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedOperatePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mt7) {
            N();
        } else if (id5 == R.id.n2a) {
            O();
        } else if (id5 == R.id.n9l) {
            P();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnt;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void V(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getLikeInfo() == null) {
            return;
        }
        boolean z16 = businessFeedData.getLikeInfo().isLiked;
        this.F.setVisibility(0);
        this.F.setSelected(z16);
        AccessibilityUtil.s(this.F, com.qzone.util.l.a(R.string.f2202368k));
        for (ug.a aVar : this.L) {
            if (aVar.b(z16, businessFeedData)) {
                aVar.a(z16, this.F, businessFeedData);
                return;
            }
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.c cVar) {
        if (cVar == null || !TextUtils.equals(cVar.a(), ef.b.a(this.f441565h))) {
            return;
        }
        this.f441565h.cellLikeInfo = cVar.b();
        V(this.f441565h);
    }

    @Override // vg.a
    protected void C(View view) {
        this.M = view.findViewById(R.id.n17);
        this.F = (SuperLikeView) view.findViewById(R.id.n9l);
        this.G = (ImageView) view.findViewById(R.id.mt7);
        this.H = (ImageView) view.findViewById(R.id.n2a);
        this.G.setOnClickListener(this);
        this.H.setVisibility(0);
        this.H.setOnClickListener(this);
        this.H.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedx.presenter.at
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean T;
                T = au.this.T(view2);
                return T;
            }
        });
        this.F.setOnClickListener(this);
        this.F.setOnEventBack(new a());
        R(view);
        L();
        AccessibilityUtil.s(this.G, com.qzone.util.l.a(R.string.f2201868f));
        AccessibilityUtil.s(this.H, com.qzone.util.l.a(R.string.f2202068h));
    }
}
