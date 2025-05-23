package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.event.QFSSearchVideoSelectFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m implements e80.g, SimpleEventReceiver, e80.c {

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f91272d;

    /* renamed from: e, reason: collision with root package name */
    private final BaseListViewAdapter<FeedCloudMeta$StFeed> f91273e;

    /* renamed from: f, reason: collision with root package name */
    private final n80.a f91274f;

    /* renamed from: h, reason: collision with root package name */
    private final int f91275h;

    public m(RecyclerView recyclerView, BaseListViewAdapter<FeedCloudMeta$StFeed> baseListViewAdapter, n80.a aVar, int i3) {
        this.f91272d = recyclerView;
        this.f91273e = baseListViewAdapter;
        this.f91274f = aVar;
        this.f91275h = i3;
    }

    private void b(LinearLayoutManager linearLayoutManager) {
        int f16 = this.f91274f.f();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        e80.g gVar = null;
        e80.g gVar2 = null;
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            KeyEvent.Callback findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof e80.g) {
                e80.g gVar3 = (e80.g) findViewByPosition;
                if (findFirstVisibleItemPosition == f16) {
                    if (!gVar3.isPlaying()) {
                        gVar2 = gVar3;
                    }
                } else if (gVar3.isPlaying()) {
                    gVar = gVar3;
                }
            }
        }
        if (gVar != null) {
            gVar.stop();
        }
        if (gVar2 != null) {
            gVar2.play();
        }
    }

    private void d(QFSSearchVideoSelectFeedEvent qFSSearchVideoSelectFeedEvent) {
        BaseListViewAdapter<FeedCloudMeta$StFeed> baseListViewAdapter = this.f91273e;
        if (baseListViewAdapter != null && this.f91274f != null && qFSSearchVideoSelectFeedEvent.parentHash == this.f91275h && baseListViewAdapter.getNUM_BACKGOURND_ICON() > qFSSearchVideoSelectFeedEvent.position && this.f91274f.f() != qFSSearchVideoSelectFeedEvent.position) {
            QLog.d("QFSSearchScrollCardContainerHelper", 1, "#handleSelectPos pos: " + qFSSearchVideoSelectFeedEvent.position);
            this.f91274f.n(qFSSearchVideoSelectFeedEvent.position);
            return;
        }
        QLog.w("QFSSearchScrollCardContainerHelper", 1, "#handleSelectPos fail");
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        com.tencent.biz.qqcircle.immersive.scrollers.a c16 = c();
        if (c16 == null) {
            return;
        }
        c16.a();
    }

    @Nullable
    public com.tencent.biz.qqcircle.immersive.scrollers.a c() {
        n80.a aVar = this.f91274f;
        if (aVar == null) {
            return null;
        }
        int f16 = aVar.f();
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f91272d.findViewHolderForLayoutPosition(f16);
        if (findViewHolderForLayoutPosition != null) {
            KeyEvent.Callback callback = findViewHolderForLayoutPosition.itemView;
            if (callback instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                return (com.tencent.biz.qqcircle.immersive.scrollers.a) callback;
            }
        }
        QLog.d("QFSSearchScrollCardContainerHelper", 1, "can not find view controller:" + f16);
        return null;
    }

    public boolean e() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(this.f91272d.getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            return false;
        }
        return ((QFSSearchBean) qCircleInitBean).isMute();
    }

    public void f() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void g() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchVideoSelectFeedEvent.class);
        return arrayList;
    }

    @Override // e80.g
    public boolean isPlaying() {
        com.tencent.biz.qqcircle.immersive.scrollers.a c16 = c();
        if (c16 instanceof e80.g) {
            return ((e80.g) c16).isPlaying();
        }
        return false;
    }

    @Override // e80.c
    public boolean l() {
        com.tencent.biz.qqcircle.immersive.scrollers.a c16 = c();
        if (c16 instanceof e80.c) {
            return ((e80.c) c16).l();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchVideoSelectFeedEvent) {
            d((QFSSearchVideoSelectFeedEvent) simpleBaseEvent);
        }
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        com.tencent.biz.qqcircle.immersive.scrollers.a c16 = c();
        if (c16 == null) {
            return;
        }
        c16.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (this.f91274f == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.f91272d.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        }
        b((LinearLayoutManager) layoutManager);
    }

    @Override // e80.g
    public void stop() {
        com.tencent.biz.qqcircle.immersive.scrollers.a c16 = c();
        if (c16 instanceof e80.g) {
            ((e80.g) c16).stop();
        }
    }
}
