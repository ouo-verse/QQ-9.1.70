package com.qzone.reborn.feedx.widget.header.famous;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFamousUserHomeHeaderContainerView extends QZoneBaseFeedxHeaderContainerView {
    private w C;

    /* renamed from: m, reason: collision with root package name */
    private l f56268m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneFamousUserHomeHeaderContainerView.this.delayShow();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message message) {
            QZoneFamousUserHomeHeaderContainerView.this.onHandleMessage(message);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            QZoneFamousUserHomeHeaderContainerView.this.a0(qZoneResult);
        }
    }

    public QZoneFamousUserHomeHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.C.getMHandler();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129636l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0 */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        super.bindData(businessFeedData, i3);
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        l lVar = new l(this);
        this.f56268m = lVar;
        r0(lVar);
        r0(new com.qzone.reborn.feedx.widget.header.famous.a(this, true));
        r0(new k(this));
        r0(new QZoneFamousUserHomeHeaderButtonElement(this));
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        w wVar = (w) this.f56121f.W(w.class);
        this.C = wVar;
        wVar.k2(new a());
    }
}
