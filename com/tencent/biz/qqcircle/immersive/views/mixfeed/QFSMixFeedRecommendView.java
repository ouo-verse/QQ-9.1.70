package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.events.QFSMixFeedSelectFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import nb0.b;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedRecommendView extends QFSMixFeedBaseWidgetView<e30.b> implements com.tencent.biz.qqcircle.immersive.scrollers.a, SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f90875e;

    /* renamed from: f, reason: collision with root package name */
    private w70.a f90876f;

    /* renamed from: h, reason: collision with root package name */
    private nb0.b f90877h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                QFSMixFeedRecommendView.this.r0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements b.c {
        b() {
        }

        @Override // nb0.b.c
        public void b(int i3) {
            QFSMixFeedRecommendView.this.f90876f.i0(i3);
            QLog.d("QFSMixFeedRecommendView", 1, "onSnap pos:" + i3);
            QFSMixFeedRecommendView.this.r0();
            QFSMixFeedRecommendView.this.play();
        }
    }

    public QFSMixFeedRecommendView(@NonNull @NotNull Context context) {
        super(context);
        q0(this);
    }

    private com.tencent.biz.qqcircle.immersive.scrollers.a n0() {
        nb0.b bVar = this.f90877h;
        if (bVar == null) {
            return null;
        }
        int f16 = bVar.f();
        VideoReport.traverseExposure();
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f90875e.findViewHolderForLayoutPosition(f16);
        if (findViewHolderForLayoutPosition != null) {
            KeyEvent.Callback callback = findViewHolderForLayoutPosition.itemView;
            if (callback instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                return (com.tencent.biz.qqcircle.immersive.scrollers.a) callback;
            }
        }
        QLog.d("QFSMixFeedRecommendView", 1, "can not find view controller:" + f16);
        return null;
    }

    @NotNull
    private b.c o0() {
        return new b();
    }

    private void p0(QFSMixFeedSelectFeedEvent qFSMixFeedSelectFeedEvent) {
        w70.a aVar = this.f90876f;
        if (aVar != null && this.f90877h != null && aVar.getItemCount() > qFSMixFeedSelectFeedEvent.getPos() && this.f90877h.f() != qFSMixFeedSelectFeedEvent.getPos()) {
            this.f90877h.n(qFSMixFeedSelectFeedEvent.getPos());
        }
    }

    private void q0(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f43781ne);
        this.f90875e = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
        this.f90875e.addOnScrollListener(new a());
        w70.a aVar = new w70.a();
        this.f90876f = aVar;
        this.f90875e.setAdapter(aVar);
        nb0.b bVar = new nb0.b(8388611, o0());
        this.f90877h = bVar;
        bVar.attachToRecyclerView(this.f90875e);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedRecommendView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QFSMixFeedRecommendView", 1, " |triggerDTTraversePage after data change!");
                VideoReport.traversePage(QFSMixFeedRecommendView.this.f90875e);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        com.tencent.biz.qqcircle.immersive.scrollers.a n06 = n0();
        if (n06 == null) {
            return;
        }
        n06.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSMixFeedSelectFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gbl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedRecommendView";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSMixFeedSelectFeedEvent) {
            p0((QFSMixFeedSelectFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        com.tencent.biz.qqcircle.immersive.scrollers.a n06 = n0();
        if (n06 == null) {
            return;
        }
        n06.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        com.tencent.biz.qqcircle.immersive.scrollers.a n06 = n0();
        if (n06 == null) {
            return;
        }
        n06.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        w70.a aVar;
        QQCircleDitto$StItemContainer i16 = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
        if (i16 == null || i16.items.size() < 1 || (aVar = this.f90876f) == null || this.f90877h == null) {
            return;
        }
        aVar.j0(getQCircleExtraTypeInfo());
        this.f90876f.setDatas(i16.items.get());
        r0();
        this.f90877h.l(0);
    }
}
