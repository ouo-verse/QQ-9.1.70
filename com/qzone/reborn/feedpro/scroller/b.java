package com.qzone.reborn.feedpro.scroller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.misc.network.ttt.h;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOperation;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends hh.b {
    private int C;
    private boolean D = true;
    private int E;

    /* renamed from: m, reason: collision with root package name */
    private int f54162m;

    public static Map<Integer, String> s(List<CommonEntry> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                CommonEntry commonEntry = list.get(i3);
                hashMap.put(Integer.valueOf(commonEntry.getNumberKey()), commonEntry.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        int i3;
        int i16;
        int[] b16 = b();
        if (b16 == null || b16.length < 2 || (i3 = b16[1]) < (i16 = b16[0])) {
            return;
        }
        u(this.f404911e, i16, i3, hh.c.I);
        this.f54162m = b16[0];
        this.C = b16[1];
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneFeedProReportScroller";
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
                u(recyclerView, i27 + 1, i18, hh.c.I);
            }
            this.C = i18;
            return;
        }
        int i28 = this.f54162m;
        if (i17 < i28) {
            u(recyclerView, i17 + 1, i28, hh.c.J);
        }
        this.f54162m = i17;
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
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.scroller.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.t();
                }
            }, 300L);
        }
    }

    @Override // hh.b
    public void onStop() {
        super.onStop();
        h.g().e();
    }

    private void u(RecyclerView recyclerView, int i3, int i16, int i17) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null || i3 < 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if (findViewByPosition instanceof QzoneBaseFeedProItemView) {
                QzoneBaseFeedProItemView qzoneBaseFeedProItemView = (QzoneBaseFeedProItemView) findViewByPosition;
                CommonFeed data = qzoneBaseFeedProItemView.getData();
                if (data != null && data.getCellCommon() != null && data.getCellOperation() != null) {
                    CommonCellOperation cellOperation = data.getCellOperation();
                    CommonCellCommon cellCommon = data.getCellCommon();
                    String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(data);
                    h.g().l(feedUniqueKey, s(cellOperation.getFeedReportCookie()), i17, qzoneBaseFeedProItemView.getDataPosInList());
                    eo.b.f396876a.c(qzoneBaseFeedProItemView.getContext(), feedUniqueKey);
                    QLog.i("QZoneFeedProReportScroller", 1, "onTTTReportFeedExposure | i = " + i3 + " | pos = " + qzoneBaseFeedProItemView.getDataPosInList() + " | scrollDirection = " + i17 + " | feedKey = " + feedUniqueKey + " | cellId = " + cellCommon.getCellId());
                } else {
                    QLog.i("QZoneFeedProReportScroller", 1, "onTTTReportFeedExposure data is null");
                    return;
                }
            }
            i3++;
        }
    }
}
