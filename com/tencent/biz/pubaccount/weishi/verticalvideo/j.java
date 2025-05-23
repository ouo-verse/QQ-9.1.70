package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements e<au> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82163a;

        a(String str) {
            this.f82163a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.j.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handle(au auVar) {
            stSimpleMetaFeed b16 = j.this.b((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f);
            if (b16 == null || !TextUtils.equals(b16.f25129id, this.f82163a)) {
                return;
            }
            auVar.f82127d.e(0);
            if (b16.is_ding == 1) {
                auVar.f82127d.e(6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements e<au> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82165a;

        b(String str) {
            this.f82165a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.j.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handle(au auVar) {
            stSimpleMetaPerson stsimplemetaperson;
            stSimpleMetaFeed b16 = j.this.b((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f);
            if (b16 == null || (stsimplemetaperson = b16.poster) == null || !TextUtils.equals(stsimplemetaperson.f25130id, this.f82165a)) {
                return;
            }
            auVar.f82127d.e(1);
            auVar.f82127d.e(6);
            x.j("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][updateFollowUIStatus] status:" + b16.poster.followStatus + ", this:" + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements e<au> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82167a;

        c(String str) {
            this.f82167a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.j.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handle(au auVar) {
            stSimpleMetaFeed b16 = j.this.b((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f);
            if (b16 == null || !TextUtils.equals(b16.f25129id, this.f82167a)) {
                return;
            }
            auVar.f82127d.e(2);
            auVar.f82127d.e(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements e<au> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f82169a;

        d(boolean z16) {
            this.f82169a = z16;
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.j.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handle(au auVar) {
            if (auVar instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) {
                ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) auVar).x(this.f82169a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface e<T> {
        void handle(T t16);
    }

    private void l(String str, RecyclerView recyclerView) {
        a(recyclerView, new c(str));
    }

    private void n(String str, RecyclerView recyclerView) {
        a(recyclerView, new b(str));
    }

    private void p(String str, RecyclerView recyclerView) {
        a(recyclerView, new a(str));
    }

    public void d(WSSimpleBaseEvent wSSimpleBaseEvent, h hVar) {
        VideoFeedsRecyclerView x16;
        f adapter;
        x.j("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForClear]");
        if (hVar == null || (x16 = hVar.x()) == null || (adapter = hVar.getAdapter()) == null) {
            return;
        }
        boolean isClearMode = ((WSClearModeEvent) wSSimpleBaseEvent).isClearMode();
        adapter.S(isClearMode);
        a(x16, new d(isClearMode));
    }

    public void e(WSSimpleBaseEvent wSSimpleBaseEvent, h hVar) {
        f adapter;
        x.j("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForComment]");
        WSAddCommentEvent wSAddCommentEvent = (WSAddCommentEvent) wSSimpleBaseEvent;
        if (hVar == null || (adapter = hVar.getAdapter()) == null || adapter.getDataList() == null) {
            return;
        }
        k(wSAddCommentEvent, adapter.getDataList());
        l(wSAddCommentEvent.getFeedId(), hVar.x());
    }

    public void f(WSSimpleBaseEvent wSSimpleBaseEvent, h hVar) {
        f adapter;
        x.j("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForFollow]");
        FollowEvent followEvent = (FollowEvent) wSSimpleBaseEvent;
        if (hVar == null || (adapter = hVar.getAdapter()) == null || adapter.getDataList() == null) {
            return;
        }
        m(followEvent, adapter.getDataList());
        n(followEvent.getPersonId(), hVar.x());
    }

    public void g(WSSimpleBaseEvent wSSimpleBaseEvent, h hVar) {
        f adapter;
        x.j("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForLike]");
        LikeRspEvent likeRspEvent = (LikeRspEvent) wSSimpleBaseEvent;
        if (hVar == null || (adapter = hVar.getAdapter()) == null || adapter.getDataList() == null) {
            return;
        }
        o(likeRspEvent, adapter.getDataList());
        p(likeRspEvent.getFeedId(), hVar.x());
    }

    public void k(WSAddCommentEvent wSAddCommentEvent, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(i3);
            if (jVar != null && jVar.e() != null && TextUtils.equals(wSAddCommentEvent.getFeedId(), jVar.e().f25129id)) {
                x.m("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForComment] data.getItemInfo().total_comment_num:" + jVar.e().total_comment_num + ", wsAddCommentEvent.getCommentNum():" + wSAddCommentEvent.getCommentNum());
                jVar.e().total_comment_num = (int) wSAddCommentEvent.getCommentNum();
            }
        }
    }

    public void m(FollowEvent followEvent, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(i3);
            if (jVar != null && jVar.e() != null && jVar.e().poster != null) {
                stSimpleMetaPerson stsimplemetaperson = jVar.e().poster;
                if (TextUtils.equals(stsimplemetaperson.f25130id, followEvent.getPersonId())) {
                    stsimplemetaperson.followStatus = followEvent.getIsFollow();
                }
            }
        }
    }

    protected stSimpleMetaFeed b(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        stSimpleMetaFeed e16;
        if (jVar == null || (e16 = jVar.e()) == null) {
            return null;
        }
        return e16;
    }

    public void c(WSBottomBarRefreshEvent wSBottomBarRefreshEvent, h hVar, g gVar) {
        if (hVar != null && "monofeed_tab".equals(wSBottomBarRefreshEvent.getBarId()) && hVar.D()) {
            gVar.r(hVar.getFrom());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(WSSpeedChangeEvent wSSpeedChangeEvent, h hVar, AbsWSVerticalPagePresenter absWSVerticalPagePresenter) {
        if (hVar == null || wSSpeedChangeEvent.getSource() != absWSVerticalPagePresenter.hashCode()) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = (hVar.getAdapter() == null || hVar.getAdapter().z() == null) ? null : (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) hVar.getAdapter().z().f82129f;
        WSPlayerManager U0 = hVar.U0();
        U0.T0(wSSpeedChangeEvent.getSpeed());
        if (U0.D0()) {
            U0.O0();
        }
        u10.b.c(wSSpeedChangeEvent.getSpeed(), 1, hVar.getFrom(), hVar.getPlayScene(), jVar != null ? jVar.e() : null);
        if (hVar.getAdapter() == null || hVar.getAdapter().z() == null) {
            return;
        }
        ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) hVar.getAdapter().z().f82129f).s(wSSpeedChangeEvent.getSpeed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i(WSSpeedPlayEvent wSSpeedPlayEvent, h hVar, AbsWSVerticalPagePresenter absWSVerticalPagePresenter) {
        if (hVar == null || wSSpeedPlayEvent.getCode() != absWSVerticalPagePresenter.hashCode()) {
            return;
        }
        VideoFeedsRecyclerView x16 = hVar.x();
        x16.setScrollable(!wSSpeedPlayEvent.isActive());
        com.tencent.biz.pubaccount.weishi.verticalvideo.d dVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.d) hVar;
        WSSwipeRefreshLayout refreshLayout = hVar.getRefreshLayout();
        WSPlayerManager U0 = hVar.U0();
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = (hVar.getAdapter() == null || hVar.getAdapter().z() == null) ? null : (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) hVar.getAdapter().z().f82129f;
        if (wSSpeedPlayEvent.isActive()) {
            dVar.K1(3);
            u10.b.c(wSSpeedPlayEvent.getSpeed(), 2, hVar.getFrom(), hVar.getPlayScene(), jVar != null ? jVar.e() : null);
            U0.T0(wSSpeedPlayEvent.getSpeed());
            refreshLayout.setEnabled(false);
            if (U0.D0()) {
                U0.O0();
                return;
            }
            return;
        }
        dVar.H0(3);
        float g16 = jVar != null ? jVar.g() : 1.0f;
        u10.b.c(g16, 2, hVar.getFrom(), hVar.getPlayScene(), jVar != null ? jVar.e() : null);
        U0.T0(g16);
        refreshLayout.setEnabled((x16.getChildCount() == 0 ? 0 : x16.getChildAt(0).getTop()) >= 0 && absWSVerticalPagePresenter.J());
    }

    public void j(WSRefreshEvent wSRefreshEvent, h hVar, AbsWSVerticalPagePresenter absWSVerticalPagePresenter) {
        if (hVar == null || wSRefreshEvent.getPageType() != 3) {
            return;
        }
        absWSVerticalPagePresenter.r(hVar.getFrom());
    }

    public void o(LikeRspEvent likeRspEvent, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(i3);
            if (jVar != null && jVar.e() != null && TextUtils.equals(likeRspEvent.getFeedId(), jVar.e().f25129id)) {
                if (likeRspEvent.getRspIsDing() != jVar.e().is_ding) {
                    if (jVar.e().is_ding == 1) {
                        jVar.e().ding_count--;
                    } else {
                        jVar.e().ding_count++;
                    }
                }
                jVar.e().is_ding = likeRspEvent.getRspIsDing();
            }
        }
    }

    private void a(RecyclerView recyclerView, e<au> eVar) {
        if (recyclerView == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (eVar != null && (childViewHolder instanceof au)) {
                eVar.handle((au) childViewHolder);
            }
        }
    }
}
