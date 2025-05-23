package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.reborn.feedx.itemview.QZoneEmptyOrForbiddenView;
import com.qzone.reborn.feedx.itemview.QZoneFeedxEmptyPageView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k extends com.qzone.reborn.base.m {
    private x6.a C;
    private boolean D;
    private boolean E;
    private boolean F;
    private QZoneFeedxEmptyPageView.a G;
    private com.qzone.reborn.feedx.viewmodel.w H;
    private com.qzone.reborn.feedx.viewmodel.t I;

    /* renamed from: m, reason: collision with root package name */
    private QZoneEmptyOrForbiddenView f54777m;

    public k(Bundle bundle) {
        super(bundle);
    }

    private void n0() {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setEmptyPageViewVisibility(false, null);
    }

    private void o0() {
        x6.a aVar;
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null || (aVar = this.C) == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setEmptyPageViewVisibility(true, com.qzone.reborn.feedx.util.k.u(aVar.relationShipMsg));
    }

    private void p0() {
        x6.a aVar;
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null || (aVar = this.C) == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setEmptyPageViewVisibility(true, com.qzone.reborn.feedx.util.k.v(aVar.gender == 1));
    }

    private void q0() {
        if (this.f54777m == null || this.C == null) {
            return;
        }
        com.qzone.reborn.feedx.viewmodel.w wVar = this.H;
        if (wVar != null && wVar.M2()) {
            n0();
        } else {
            this.f54777m.setEmptyPageViewVisibility(true, com.qzone.reborn.feedx.util.k.v(this.C.gender == 1));
        }
    }

    private void r0() {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setEmptyPageViewVisibility(true, com.qzone.reborn.feedx.util.k.x());
    }

    private void s0() {
        if (this.f54777m == null || this.C == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionUserReleaseQzone", "\u7528\u6237\u5df2\u6ce8\u9500\u7a7a\u95f4");
        if (!TextUtils.isEmpty(this.C.relationShipMsg)) {
            config = this.C.relationShipMsg;
        }
        this.f54777m.setEmptyPageViewVisibility(true, com.qzone.reborn.feedx.util.k.w(config));
    }

    private void t0(com.qzone.reborn.feedx.viewmodel.w wVar, com.qzone.reborn.feedx.viewmodel.t tVar) {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setQuestionPageViewVisibility(true, this.C, wVar, tVar);
    }

    private void u0() {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.setVisibility(8);
    }

    private void y0() {
        fo.c.n(this.f54777m, "em_qz_blocked_space");
    }

    private void z0() {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null || this.E) {
            return;
        }
        qZoneEmptyOrForbiddenView.setEmptyPageViewVisibility(this.D, this.G);
        B0(this.F);
        this.f54777m.setVisibility(0);
        y0();
    }

    public void A0() {
        x6.a aVar = this.C;
        if (aVar == null) {
            return;
        }
        switch (aVar.relationShip) {
            case 0:
                q0();
                break;
            case 1:
            case 2:
                n0();
                break;
            case 3:
            case 5:
                p0();
                break;
            case 4:
            case 6:
                t0(this.H, this.I);
                break;
            case 7:
            case 8:
                r0();
                break;
            case 9:
                o0();
                break;
            case 10:
                s0();
                break;
        }
        com.qzone.misc.network.report.c.b("380", "1");
        B0(this.F);
        QZoneLoginReportHelper.reportLoginFromUserHomeForbiddenPage();
        y0();
    }

    public void B0(boolean z16) {
        this.F = z16;
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView == null) {
            return;
        }
        qZoneEmptyOrForbiddenView.o0(z16);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        this.f54777m = new QZoneEmptyOrForbiddenView(getContext());
        if (this.E) {
            A0();
        } else if (this.D) {
            z0();
        } else {
            u0();
        }
        return this.f54777m;
    }

    public void m0(x6.a aVar) {
        this.C = aVar;
        this.E = !com.qzone.reborn.feedx.util.k.G(aVar);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QZoneEmptyOrForbiddenView qZoneEmptyOrForbiddenView = this.f54777m;
        if (qZoneEmptyOrForbiddenView != null) {
            qZoneEmptyOrForbiddenView.onDestroy();
        }
    }

    public void v0(com.qzone.reborn.feedx.viewmodel.w wVar, com.qzone.reborn.feedx.viewmodel.t tVar) {
        this.H = wVar;
        this.I = tVar;
    }

    public boolean w0() {
        return this.D;
    }

    public boolean x0() {
        return this.E;
    }

    public void l0(boolean z16, QZoneFeedxEmptyPageView.a aVar) {
        if (aVar == null) {
            return;
        }
        this.D = z16;
        this.G = aVar;
        if (this.f54777m != null) {
            z0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
