package com.qzone.reborn.feedx.scroller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends hh.b {
    private int C;
    private boolean D = true;
    private int E;

    /* renamed from: m, reason: collision with root package name */
    private int f55687m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        int i3;
        int i16;
        int[] b16 = b();
        if (b16 == null || b16.length < 2 || (i3 = b16[1]) < (i16 = b16[0])) {
            return;
        }
        t(this.f404911e, i16, i3, hh.c.I);
        this.f55687m = b16[0];
        this.C = b16[1];
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneFeedReportScroller";
    }

    @Override // hh.b
    public void j() {
        super.j();
        com.qzone.misc.network.ttt.h.g().e();
    }

    @Override // hh.b
    public void l(RecyclerView recyclerView, int i3, int i16, boolean z16, int i17, int i18, int i19, int i26) {
        super.l(recyclerView, i3, i16, z16, i17, i18, i19, i26);
        if (this.E == 0) {
            return;
        }
        if (z16) {
            int i27 = this.C;
            if (i18 > i27) {
                t(recyclerView, i27 + 1, i18, hh.c.I);
            }
            this.C = i18;
            return;
        }
        int i28 = this.f55687m;
        if (i17 < i28) {
            t(recyclerView, i17 + 1, i28, hh.c.J);
        }
        this.f55687m = i17;
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        super.m(recyclerView, i3, layoutManager, i16, i17, i18, i19, z16);
        this.E = i3;
    }

    @Override // hh.b
    public void onResume() {
        super.onResume();
        if (this.D) {
            this.D = false;
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.scroller.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.s();
                }
            }, 300L);
        }
    }

    @Override // hh.b
    public void onStop() {
        super.onStop();
        com.qzone.misc.network.ttt.h.g().e();
    }

    private void t(RecyclerView recyclerView, int i3, int i16, int i17) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null || i3 < 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if (findViewByPosition instanceof QZoneBaseFeedItemView) {
                QZoneBaseFeedItemView qZoneBaseFeedItemView = (QZoneBaseFeedItemView) findViewByPosition;
                BusinessFeedData data = qZoneBaseFeedItemView.getData();
                com.qzone.misc.network.ttt.h.g().k(data, i17, qZoneBaseFeedItemView.getDataPosInList());
                eo.b.f396876a.c(qZoneBaseFeedItemView.getContext(), data.getFeedCommInfo().feedskey);
                QLog.i("QZoneFeedReportScroller", 1, "onTTTReportFeedExposure | i = " + i3 + " | pos = " + qZoneBaseFeedItemView.getDataPosInList() + " | scrollDirection = " + i17 + " | feedKey = " + data.getFeedCommInfo().feedskey + " | cellId = " + data.getIdInfo().cellId);
            }
            i3++;
        }
    }
}
