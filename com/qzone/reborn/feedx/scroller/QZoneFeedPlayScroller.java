package com.qzone.reborn.feedx.scroller;

import android.view.KeyEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.reborn.feedx.event.QZoneVideoOnPlayEvent;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import gf.r;
import gf.s;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneFeedPlayScroller extends hh.b implements SimpleEventReceiver, lh.i {
    private long C;
    private Runnable D;
    private boolean E = QZoneConfigHelper.c();

    /* renamed from: m, reason: collision with root package name */
    private r f55677m;

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int[] b16 = b();
        if (b16 == null || b16.length < 2) {
            return;
        }
        t(this.f404911e.getLayoutManager(), b16[0], b16[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.C < 2000) {
            return;
        }
        u();
        this.C = currentTimeMillis;
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "onTimerCallback");
    }

    private void x() {
        if (this.f55677m == null) {
            return;
        }
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "[pauseCurrentPlayer]  mCurrentPlayController = " + this.f55677m);
        this.f55677m.pause();
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "PSLink-QZoneFeedPlayScroller";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneVideoOnPlayEvent.class);
        return arrayList;
    }

    @Override // hh.b
    public void j() {
        super.j();
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "pause player onPause");
        x();
    }

    @Override // hh.b
    public void k() {
        super.k();
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "onRefreshData ");
        y(this.f55677m);
        SimpleEventBus.getInstance().registerReceiver(this);
        mh.e.d().i(this);
    }

    @Override // hh.b
    public void o(RecyclerView.ViewHolder viewHolder) {
        super.o(viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof r) {
            y((r) callback);
        }
    }

    @Override // hh.b
    public void onDestroy() {
        super.onDestroy();
        y(this.f55677m);
        mh.e.d().j(this);
        if (this.D != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.D);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneVideoOnPlayEvent) {
            mh.e.d().j(this);
        }
    }

    @Override // hh.b
    public void onResume() {
        super.onResume();
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "onResume ,computeWhichToPlay");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller.1
            @Override // java.lang.Runnable
            public void run() {
                BaseFeedFragmentFeedImp.y();
                QZoneFeedPlayScroller.this.u();
            }
        }, 800L);
    }

    @Override // hh.b
    public void onStop() {
        super.onStop();
        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "pausePlayer onStop");
        x();
        mh.e.d().j(this);
    }

    @Override // lh.i
    public void onTimerCallback() {
        if (this.D == null) {
            this.D = new Runnable() { // from class: com.qzone.reborn.feedx.scroller.h
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedPlayScroller.this.w();
                }
            };
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.D);
        RFWThreadManager.getUIHandler().post(this.D);
    }

    @Override // hh.b
    public void q(int i3, int i16, int i17, int i18, boolean z16) {
        t(this.f404911e.getLayoutManager(), i3, i16);
    }

    private void t(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        boolean z16 = false;
        while (i3 <= i16) {
            Object findViewByPosition = layoutManager.findViewByPosition(i3);
            if (findViewByPosition instanceof s) {
                findViewByPosition = ((s) findViewByPosition).R();
            }
            if (findViewByPosition instanceof r) {
                if (z16) {
                    ((r) findViewByPosition).pause();
                } else {
                    r rVar = (r) findViewByPosition;
                    QZoneVideoItemWidgetView d16 = rVar.d();
                    if (d16 != null && d(d16, 1.0f)) {
                        QLog.d("PSLink-QZoneFeedPlayScroller", 1, "checkPlayStatus , trigger play   | pos = " + i3 + " | view = " + findViewByPosition + " | videoItemView = " + d16);
                        if (RFWLifecycleHelper.getInstance().isRunningInBackground()) {
                            QLog.d("PSLink-QZoneFeedPlayScroller", 1, "checkPlayStatus , isRunningInBackground  return");
                        } else {
                            v(rVar);
                            z16 = true;
                        }
                    } else {
                        rVar.pause();
                    }
                }
            }
            i3++;
        }
        if (!this.E || z16) {
            return;
        }
        x();
    }

    private void v(r rVar) {
        if (rVar == null) {
            return;
        }
        rVar.play();
        this.f55677m = rVar;
    }

    private void y(r rVar) {
        if (rVar == null) {
            return;
        }
        rVar.a();
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 == 0 && g()) {
            t(layoutManager, i16, i17);
        }
    }
}
