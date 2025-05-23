package com.tencent.biz.qqcircle.immersive.scrollers;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener;
import com.tencent.biz.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import e30.b;
import java.util.ArrayList;
import mqq.util.WeakReference;

/* loaded from: classes4.dex */
public class QFSMixFeedPlayScroller extends com.tencent.biz.qqcircle.scrollers.a implements IRFWVideoTimerListener {
    private a G;
    private String H;
    private long I;
    private Runnable J;

    /* loaded from: classes4.dex */
    private static class StartCheckRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSMixFeedPlayScroller> f89848d;

        StartCheckRunnable(QFSMixFeedPlayScroller qFSMixFeedPlayScroller) {
            this.f89848d = new WeakReference<>(qFSMixFeedPlayScroller);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSMixFeedPlayScroller qFSMixFeedPlayScroller = this.f89848d.get();
            if (qFSMixFeedPlayScroller == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - qFSMixFeedPlayScroller.I >= 2000) {
                qFSMixFeedPlayScroller.C();
                qFSMixFeedPlayScroller.I = currentTimeMillis;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if (findViewByPosition instanceof a) {
                if (!i(findViewByPosition)) {
                    ((a) findViewByPosition).pause();
                } else {
                    D((a) findViewByPosition);
                    return;
                }
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        int[] f16 = f();
        if (f16 != null && f16.length >= 2) {
            B(this.f92280e.getLayoutManager(), f16[0], f16[1]);
        }
    }

    private void D(a aVar) {
        if (aVar == null) {
            return;
        }
        QLog.d(E(), 2, "doPlay");
        aVar.play();
        this.G = aVar;
    }

    private String E() {
        String str;
        if (!TextUtils.isEmpty(this.H)) {
            return this.H;
        }
        if (this.f92284m.getDataList() != null && this.f92284m.getDataList().size() > 0) {
            str = ((b) this.f92284m.getDataList().get(0)).g().content.get();
        } else {
            str = "";
        }
        String str2 = "QFSMixFeedPlayScroller" + hashCode() + str;
        this.H = str2;
        return str2;
    }

    private void F() {
        a aVar = this.G;
        if (aVar == null) {
            return;
        }
        aVar.pause();
    }

    private void G(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a();
        QLog.d(E(), 1, "releasePlay");
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoOnPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        super.o();
        QLog.d(E(), 2, "pause player onPause");
        F();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        super.onDestroy();
        G(this.G);
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
        if (this.J != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.J);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            RFWVideoTimerManager.g().unRegisterTimerListener(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onResume() {
        super.onResume();
        QLog.d(E(), 1, "onResume ,computeWhichToPlay");
        C();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onStop() {
        super.onStop();
        QLog.d(E(), 2, "pausePlayer onStop");
        F();
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    @Override // com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener
    public void onTimerCallback() {
        if (this.J == null) {
            this.J = new StartCheckRunnable(this);
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.J);
        RFWThreadManager.getUIHandler().post(this.J);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void p() {
        super.p();
        QLog.d(E(), 1, "onRefreshData ,computeWhichToPlay");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.scrollers.QFSMixFeedPlayScroller.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().registerReceiver(QFSMixFeedPlayScroller.this);
                RFWVideoTimerManager.g().registerTimerListener(QFSMixFeedPlayScroller.this);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 != 0 || !l()) {
            return;
        }
        B(layoutManager, i16, i17);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void t(RecyclerView.ViewHolder viewHolder) {
        super.t(viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (!(callback instanceof a)) {
            return;
        }
        G((a) callback);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void x(int i3, int i16, int i17, int i18, boolean z16) {
        B(this.f92280e.getLayoutManager(), i3, i16);
    }
}
