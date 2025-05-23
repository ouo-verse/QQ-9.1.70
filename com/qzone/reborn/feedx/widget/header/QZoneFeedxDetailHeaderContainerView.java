package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxDetailHeaderContainerView extends QZoneBaseFeedxHeaderContainerView {
    private com.qzone.reborn.feedx.viewmodel.h C;

    /* renamed from: m, reason: collision with root package name */
    private be f56126m;

    public QZoneFeedxDetailHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.C.g2();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.qzone_feedx_detail_header;
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        if (this.C.C2()) {
            be beVar = new be(this);
            this.f56126m = beVar;
            r0(beVar);
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        this.C = (com.qzone.reborn.feedx.viewmodel.h) this.f56121f.W(com.qzone.reborn.feedx.viewmodel.h.class);
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void p0() {
    }
}
