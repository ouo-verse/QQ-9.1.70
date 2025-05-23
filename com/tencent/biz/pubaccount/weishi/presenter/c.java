package com.tencent.biz.pubaccount.weishi.presenter;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.w;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jz.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends com.tencent.biz.pubaccount.weishi.presenter.a<v00.a> {

    /* renamed from: h, reason: collision with root package name */
    private stFollowFeedsGlobalConfig f81242h;

    /* renamed from: f, reason: collision with root package name */
    private int f81241f = 0;

    /* renamed from: i, reason: collision with root package name */
    private w f81243i = new w(WSPublicAccReport.SOP_NAME_FOCUS);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements f.c<stFeed> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81244a;

        a(boolean z16) {
            this.f81244a = z16;
        }

        @Override // jz.f.c
        public void a(boolean z16, List<stFeed> list, boolean z17) {
            c.this.x0().L9(this.f81244a, z16, list, z17);
            if (!z16) {
                c.this.x0().setData(list);
            } else {
                c.this.x0().nd(list, z17);
            }
        }

        @Override // jz.f.c
        public void b(boolean z16, boolean z17, boolean z18, Object obj) {
            c.this.x0().hideLoading();
            if (z17) {
                c.this.x0().Ca(z18);
            }
            if (!z18) {
                c.this.x0().cf(false, true);
                c.this.x0().Xd(z16, z17);
                return;
            }
            if (z16 && (obj instanceof stFollowFeedsRsp)) {
                c.this.f81242h = ((stFollowFeedsRsp) obj).config;
                if (c.this.x0() instanceof WSFollowFragment) {
                    ((WSFollowFragment) c.this.x0()).si(true);
                }
            }
            if (!(obj instanceof stFollowFeedsRsp) || r.q(((stFollowFeedsRsp) obj).feeds)) {
                c.this.x0().cf(true, true);
                if (z16) {
                    c.this.x0().Xd(true, z17);
                }
            }
            c.this.f81243i.b();
        }
    }

    private void A0(FollowEvent followEvent, stFeed stfeed) {
        ArrayList<stSimpleMetaFeed> arrayList;
        stFriendFeed stfriendfeed = stfeed.friendFeed;
        if (stfriendfeed == null || (arrayList = stfriendfeed.friendFeeds) == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            stSimpleMetaPerson stsimplemetaperson = arrayList.get(i3).poster;
            if (stsimplemetaperson != null && TextUtils.equals(stsimplemetaperson.f25130id, followEvent.getPersonId())) {
                stsimplemetaperson.followStatus = followEvent.getIsFollow();
                Q0(stsimplemetaperson.f25130id);
            }
        }
    }

    private int C0() {
        List<stFeed> dataList;
        if (x0() == null || x0().getAdapter() == null || (dataList = x0().getAdapter().getDataList()) == null) {
            return -1;
        }
        return dataList.size() - 1;
    }

    private void E0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        Object obj;
        com.tencent.biz.pubaccount.weishi.f adapter;
        XRecyclerView x16;
        WSItemExposeEvent wSItemExposeEvent = (WSItemExposeEvent) wSSimpleBaseEvent;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleItemExposeEvent event: ");
        if (wSItemExposeEvent == null) {
            obj = "null";
        } else {
            obj = wSItemExposeEvent.video;
        }
        sb5.append(obj);
        x.b("WSFollowPresenter", sb5.toString());
        if (wSItemExposeEvent == null || wSItemExposeEvent.video == null || (adapter = x0().getAdapter()) == null || adapter.getDataList() == null || (x16 = x0().x()) == null || x16.getRecyclerView() == null) {
            return;
        }
        stSimpleMetaFeed stsimplemetafeed = wSItemExposeEvent.video;
        List<stFeed> list = f.d().f411215b;
        if (adapter.getDataList().size() < list.size()) {
            x0().setData(list);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).feed == stsimplemetafeed) {
                x16.getRecyclerView().scrollToPosition(i3);
                this.f81241f = i3;
                x.b("WSFollowPresenter", "receive item expose event, position: " + i3 + ", feed: " + stsimplemetafeed.feed_desc);
                return;
            }
        }
    }

    private void F0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        LikeRspEvent likeRspEvent = (LikeRspEvent) wSSimpleBaseEvent;
        x.b("WSFollowPresenter", "handleLikeEvent feedId: " + likeRspEvent.getFeedId() + " isDing:" + likeRspEvent.getRspIsDing());
        com.tencent.biz.pubaccount.weishi.f adapter = x0().getAdapter();
        if (adapter == null || adapter.getDataList() == null) {
            return;
        }
        List<stFeed> dataList = adapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            stFeed stfeed = dataList.get(i3);
            if (stfeed != null && stfeed.feed != null && TextUtils.equals(likeRspEvent.getFeedId(), stfeed.feed.f25129id)) {
                int rspIsDing = likeRspEvent.getRspIsDing();
                stSimpleMetaFeed stsimplemetafeed = stfeed.feed;
                int i16 = stsimplemetafeed.is_ding;
                if (rspIsDing != i16) {
                    if (i16 == 1) {
                        stsimplemetafeed.ding_count--;
                    } else {
                        stsimplemetafeed.ding_count++;
                    }
                }
                stsimplemetafeed.is_ding = likeRspEvent.getRspIsDing();
                O0(likeRspEvent.getFeedId());
            }
        }
    }

    private void G0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        x.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
        WSAddCommentEvent wSAddCommentEvent = (WSAddCommentEvent) wSSimpleBaseEvent;
        com.tencent.biz.pubaccount.weishi.f adapter = x0().getAdapter();
        if (adapter == null || adapter.getDataList() == null) {
            return;
        }
        List<stFeed> dataList = adapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            stFeed stfeed = dataList.get(i3);
            if (stfeed != null && stfeed.feed != null && TextUtils.equals(wSAddCommentEvent.getFeedId(), stfeed.feed.f25129id)) {
                L0(wSAddCommentEvent.getFeedId());
            }
        }
    }

    private void H0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        ArrayList<stSimpleMetaPerson> arrayList;
        x.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
        FollowEvent followEvent = (FollowEvent) wSSimpleBaseEvent;
        com.tencent.biz.pubaccount.weishi.f adapter = x0().getAdapter();
        if (adapter == null || adapter.getDataList() == null) {
            return;
        }
        List<stFeed> dataList = adapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            stFeed stfeed = dataList.get(i3);
            if (stfeed != null && (stsimplemetafeed = stfeed.feed) != null && (stsimplemetaperson = stsimplemetafeed.poster) != null) {
                int i16 = stfeed.feed_type;
                if (i16 == 1 && (arrayList = stfeed.person_meta) != null) {
                    for (int i17 = 0; i17 < arrayList.size(); i17++) {
                        stSimpleMetaPerson stsimplemetaperson2 = arrayList.get(i17);
                        if (TextUtils.equals(stsimplemetaperson2.f25130id, followEvent.getPersonId())) {
                            stsimplemetaperson2.followStatus = followEvent.getIsFollow();
                            Q0(stsimplemetaperson2.f25130id);
                        }
                    }
                } else if (i16 != 2 || stsimplemetafeed == null) {
                    if (i16 == 4) {
                        A0(followEvent, stfeed);
                    }
                } else if (TextUtils.equals(stsimplemetaperson.f25130id, followEvent.getPersonId())) {
                    stsimplemetaperson.followStatus = followEvent.getIsFollow();
                    N0(followEvent.getPersonId());
                }
            }
        }
    }

    private void I0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        Object valueOf;
        com.tencent.biz.pubaccount.weishi.f adapter;
        XRecyclerView x16;
        WSFriendFeedExposureEvent wSFriendFeedExposureEvent = (WSFriendFeedExposureEvent) wSSimpleBaseEvent;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleOnReceiveEventForFriendFeed event: ");
        if (wSFriendFeedExposureEvent == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(wSFriendFeedExposureEvent.currentPosition);
        }
        sb5.append(valueOf);
        x.b("WSFollowPresenter", sb5.toString());
        if (wSFriendFeedExposureEvent == null || wSFriendFeedExposureEvent.video == null || (adapter = x0().getAdapter()) == null || adapter.getDataList() == null || (x16 = x0().x()) == null || x16.getRecyclerView() == null) {
            return;
        }
        RecyclerViewWithHeaderFooter recyclerView = x16.getRecyclerView();
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
                RecyclerView f16 = ((com.tencent.biz.pubaccount.weishi.holder.a) childViewHolder).f();
                f16.smoothScrollToPosition(wSFriendFeedExposureEvent.currentPosition);
                if (f16.getAdapter() != null) {
                    f16.getAdapter().notifyItemChanged(wSFriendFeedExposureEvent.currentPosition);
                    return;
                }
                return;
            }
        }
    }

    private void J0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        P0(((WSPlayerMuteEvent) wSSimpleBaseEvent).isPlayerMute());
    }

    private void K0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        x.b("WSFollowPresenter", "handleVideoPlayEvent mCurrentPosition: " + ((WSVideoPlayEvent) wSSimpleBaseEvent).mCurrentPosition);
    }

    private void L0(String str) {
        RecyclerViewWithHeaderFooter recyclerView;
        WSFollowFeedHolder wSFollowFeedHolder;
        stFeed L;
        stSimpleMetaFeed stsimplemetafeed;
        if (x0() == null || x0().x() == null || (recyclerView = x0().x().getRecyclerView()) == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if ((childViewHolder instanceof WSFollowFeedHolder) && (L = (wSFollowFeedHolder = (WSFollowFeedHolder) childViewHolder).L()) != null && (stsimplemetafeed = L.feed) != null && TextUtils.equals(stsimplemetafeed.f25129id, str)) {
                wSFollowFeedHolder.L0(L.feed);
            }
        }
    }

    private void M0(RecyclerView recyclerView, String str) {
        h10.b bVar;
        stSimpleMetaPerson p16;
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (childViewHolder instanceof h10.d) {
                h10.d dVar = (h10.d) childViewHolder;
                stSimpleMetaPerson k3 = dVar.k();
                if (k3 != null && TextUtils.equals(k3.f25130id, str)) {
                    dVar.s();
                }
            } else if ((childViewHolder instanceof h10.b) && (p16 = (bVar = (h10.b) childViewHolder).p()) != null && TextUtils.equals(p16.f25130id, str)) {
                bVar.w();
            }
        }
    }

    private void N0(String str) {
        RecyclerViewWithHeaderFooter recyclerView;
        WSFollowFeedHolder wSFollowFeedHolder;
        stFeed L;
        stSimpleMetaFeed stsimplemetafeed;
        stSimpleMetaPerson stsimplemetaperson;
        if (x0() == null || x0().x() == null || (recyclerView = x0().x().getRecyclerView()) == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if ((childViewHolder instanceof WSFollowFeedHolder) && (L = (wSFollowFeedHolder = (WSFollowFeedHolder) childViewHolder).L()) != null && (stsimplemetafeed = L.feed) != null && (stsimplemetaperson = stsimplemetafeed.poster) != null && TextUtils.equals(stsimplemetaperson.f25130id, str)) {
                wSFollowFeedHolder.M0();
            }
        }
    }

    private void O0(String str) {
        RecyclerViewWithHeaderFooter recyclerView;
        WSFollowFeedHolder wSFollowFeedHolder;
        stFeed L;
        stSimpleMetaFeed stsimplemetafeed;
        if (x0() == null || x0().x() == null || (recyclerView = x0().x().getRecyclerView()) == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if ((childViewHolder instanceof WSFollowFeedHolder) && (L = (wSFollowFeedHolder = (WSFollowFeedHolder) childViewHolder).L()) != null && (stsimplemetafeed = L.feed) != null && TextUtils.equals(stsimplemetafeed.f25129id, str)) {
                x.b("WSFollowPresenter", "updateLikeStatus");
                wSFollowFeedHolder.O0();
            }
        }
    }

    private void P0(boolean z16) {
        String str;
        if (x0() == null || x0().getAdapter() == null) {
            return;
        }
        Iterator<BaseViewHolder> it = x0().getAdapter().q().iterator();
        while (it.hasNext()) {
            BaseViewHolder next = it.next();
            if (next instanceof WSFollowFeedHolder) {
                WSFollowFeedHolder wSFollowFeedHolder = (WSFollowFeedHolder) next;
                wSFollowFeedHolder.R0(z16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateMuteStatus title:");
                l lVar = wSFollowFeedHolder.f80801d;
                if (lVar != null) {
                    str = lVar.f81175j;
                } else {
                    str = "videoInfo is null!";
                }
                sb5.append(str);
                x.j("WSFollowPresenter", sb5.toString());
            }
        }
    }

    private void Q0(String str) {
        RecyclerViewWithHeaderFooter recyclerView;
        if (x0() == null || x0().x() == null || (recyclerView = x0().x().getRecyclerView()) == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.c) {
                M0(((com.tencent.biz.pubaccount.weishi.holder.c) childViewHolder).d(), str);
            } else if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
                M0(((com.tencent.biz.pubaccount.weishi.holder.a) childViewHolder).f(), str);
            }
        }
    }

    private void Z0(WSRefreshEvent wSRefreshEvent) {
        v00.a x06 = x0();
        if (x06 != null && x06.D() && wSRefreshEvent.getPageType() == 1) {
            x06.C();
            x06.Z8();
        }
    }

    private void i1(WSBottomBarRefreshEvent wSBottomBarRefreshEvent) {
        String barId = wSBottomBarRefreshEvent.getBarId();
        v00.a x06 = x0();
        if (x06 == null || !x06.D()) {
            return;
        }
        if ("waterfall_tab".equals(barId) || "monofeed_tab".equals(barId)) {
            x06.C();
            x06.Z8();
        }
    }

    public void B0(boolean z16, boolean z17) {
        if (x0() == null) {
            return;
        }
        if (z16) {
            x0().showLoading();
        }
        f.d().c(z16, z17, "", 9, System.currentTimeMillis(), new a(z16));
    }

    public int D0() {
        return this.f81241f;
    }

    public void Z() {
        this.f81243i.d();
    }

    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof LikeRspEvent) {
            F0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSVideoPlayEvent) {
            K0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSItemExposeEvent) {
            E0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof FollowEvent) {
            H0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSAddCommentEvent) {
            G0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSFriendFeedExposureEvent) {
            I0(wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSPlayerMuteEvent) {
            J0(wSSimpleBaseEvent);
        } else if (wSSimpleBaseEvent instanceof WSBottomBarRefreshEvent) {
            i1((WSBottomBarRefreshEvent) wSSimpleBaseEvent);
        } else if (wSSimpleBaseEvent instanceof WSRefreshEvent) {
            Z0((WSRefreshEvent) wSSimpleBaseEvent);
        }
    }

    public void j() {
        this.f81243i.c(C0());
    }

    public void s() {
        this.f81243i.a();
    }
}
