package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.common.business.result.QZoneResult;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneDIYUserHomeHeaderContainerView extends QZoneBaseFeedxHeaderContainerView {
    private ax C;
    private com.qzone.reborn.feedx.viewmodel.w D;

    /* renamed from: m, reason: collision with root package name */
    private mo.b f56124m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneDIYUserHomeHeaderContainerView.this.delayShow();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message message) {
            QZoneDIYUserHomeHeaderContainerView.this.onHandleMessage(message);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            QZoneDIYUserHomeHeaderContainerView.this.a0(qZoneResult);
        }
    }

    public QZoneDIYUserHomeHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.D.getMHandler();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129606i;
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        mo.b bVar = new mo.b(this);
        this.f56124m = bVar;
        r0(bVar);
        ax axVar = new ax(this);
        this.C = axVar;
        r0(axVar);
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) this.f56121f.W(com.qzone.reborn.feedx.viewmodel.w.class);
        this.D = wVar;
        wVar.k2(new a());
    }
}
