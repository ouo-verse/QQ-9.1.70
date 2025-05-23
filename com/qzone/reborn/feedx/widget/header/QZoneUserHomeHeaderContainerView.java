package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.event.QZoneUserHomeUpdateBackgroundEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUserHomeHeaderContainerView extends QZoneBaseFeedxHeaderContainerView {
    private ao C;
    private com.qzone.reborn.feedx.viewmodel.w D;
    protected mo.i E;
    private aq F;
    private aj G;
    private al H;
    private at I;

    /* renamed from: m, reason: collision with root package name */
    private bh f56154m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneUserHomeHeaderContainerView.this.delayShow();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message message) {
            QZoneUserHomeHeaderContainerView.this.onHandleMessage(message);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            QZoneUserHomeHeaderContainerView.this.a0(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements IPicLoadStateListener {
        b() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess() || option == null) {
                QZoneUserHomeHeaderContainerView.this.x0(false);
                return;
            }
            try {
                if (QZoneUserHomeHeaderContainerView.this.f56123i != null) {
                    QZoneUserHomeHeaderContainerView.this.f56123i.setBackground(new BitmapDrawable(option.getResultBitMap()));
                }
                QZoneUserHomeHeaderContainerView.this.x0(true);
            } catch (Exception e16) {
                QLog.e("QZoneUserHomeHeaderContainerView", 1, "exception is " + e16);
                QZoneUserHomeHeaderContainerView.this.x0(false);
            }
        }
    }

    public QZoneUserHomeHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneUserHomeUpdateBackgroundEvent(z16));
        mo.i iVar = this.E;
        if (iVar != null) {
            iVar.n(z16);
        }
        RecyclerView recyclerView = this.f56123i;
        if (recyclerView != null && !z16) {
            recyclerView.setBackground(null);
        }
        w0(this.E, z16 ? 4 : 0);
        w0(this.f56154m, z16 ? 4 : 0);
        if (z16) {
            w0(this.I, 8);
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.D.getMHandler();
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView, com.qzone.reborn.feedx.widget.header.a
    public int e() {
        ViewGroup viewGroup;
        mo.i iVar;
        int measuredHeight;
        bh bhVar = this.f56154m;
        if (bhVar == null || (viewGroup = bhVar.f56217f) == null || (iVar = this.E) == null || iVar.f417077f == null || (measuredHeight = viewGroup.getMeasuredHeight() - this.E.f417077f.getMeasuredHeight()) < 0) {
            return 0;
        }
        return measuredHeight;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.coa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0 */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        super.bindData(businessFeedData, i3);
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        bh bhVar = new bh(this);
        this.f56154m = bhVar;
        r0(bhVar);
        ao aoVar = new ao(this, true);
        this.C = aoVar;
        r0(aoVar);
        mo.i iVar = new mo.i(this);
        this.E = iVar;
        r0(iVar);
        aq aqVar = new aq(this, true);
        this.F = aqVar;
        r0(aqVar);
        at atVar = new at(this);
        this.I = atVar;
        r0(atVar);
        r0(new ar(this));
        if (!SimpleUIUtil.isNowElderMode()) {
            aj ajVar = new aj(this);
            this.G = ajVar;
            r0(ajVar);
        }
        if (this.D.K2()) {
            al alVar = new al(this, false);
            this.H = alVar;
            r0(alVar);
            r0(new av(this));
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) this.f56121f.W(com.qzone.reborn.feedx.viewmodel.w.class);
        this.D = wVar;
        wVar.k2(new a());
        this.D.C2().observe(getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUserHomeHeaderContainerView.this.u0((x6.a) obj);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void p0() {
        ao aoVar = this.C;
        if (aoVar != null) {
            aoVar.A();
            this.F.p();
        }
    }

    private void v0(x6.a aVar) {
        if (aVar == null || aVar.strangerDecorate == null || this.D.M2()) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(aVar.strangerDecorate.f447267b).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true), new b());
    }

    private void w0(d dVar, int i3) {
        if (dVar == null) {
            return;
        }
        dVar.m(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(x6.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!com.qzone.reborn.feedx.util.k.G(aVar) && com.qzone.reborn.feedx.util.k.E(aVar)) {
            v0(aVar);
        } else {
            x0(false);
        }
    }
}
