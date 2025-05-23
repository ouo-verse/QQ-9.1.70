package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ar extends d {

    /* renamed from: f, reason: collision with root package name */
    private final ProgressBar f56207f;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            RFWLog.d(ar.this.j(), RFWLog.USR, "onFeedRefreshFinish: ");
            if (ar.this.f56207f != null) {
                ar.this.f56207f.setVisibility(8);
            }
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void p4() {
            RFWLog.d(ar.this.j(), RFWLog.USR, "onFeedRefreshStart: ");
            if (ar.this.f56207f != null) {
                ar.this.f56207f.setVisibility(0);
            }
        }
    }

    public ar(View view) {
        super(view);
        this.f56207f = (ProgressBar) view.findViewById(R.id.f162855n01);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public View e() {
        return this.f56207f;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeProgressElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        if (this.f56207f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f56207f.getLayoutParams()).topMargin = QZoneFeedxViewUtils.e(g());
        }
        ((com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class)).k2(new a());
    }
}
