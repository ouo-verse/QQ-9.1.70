package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSplitBlock;
import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.presenter.WSFollowPlayerStatusListenerImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends BaseAdapter<stFeed, BaseViewHolder<stFeed>> {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    public WSFollowFragment f80705d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.holder.f f80706e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.holder.f f80707f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.holder.f f80708h;

    /* renamed from: i, reason: collision with root package name */
    private WSPlayerManager f80709i;

    /* renamed from: m, reason: collision with root package name */
    private HashSet<BaseViewHolder> f80710m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WSVideoPreDownloadManager.b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public List<WSVideoPreDownloadManager.c> a(int i3, boolean z16) {
            return com.tencent.biz.pubaccount.weishi.util.r.n(f.this.getDataList(), i3, z16);
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public boolean b() {
            return AppNetConnInfo.isWifiConn();
        }
    }

    public f(WSFollowFragment wSFollowFragment) {
        super(wSFollowFragment.getBaseActivity());
        this.f80710m = new HashSet<>();
        this.f80705d = wSFollowFragment;
        this.C = wSFollowFragment.di();
    }

    private void v(BaseViewHolder<stFeed> baseViewHolder, int i3, stFeed stfeed) {
        baseViewHolder.bindData(stfeed);
        WSFollowFeedHolder wSFollowFeedHolder = (WSFollowFeedHolder) baseViewHolder;
        wSFollowFeedHolder.f80801d = x10.a.a(stfeed.feed);
        jz.f.d().j(wSFollowFeedHolder);
        wSFollowFeedHolder.f80803f = jz.f.d().h(wSFollowFeedHolder);
        wSFollowFeedHolder.f80802e = jz.f.d().q(wSFollowFeedHolder, 0L, i3);
        WSPlayerManager wSPlayerManager = this.f80709i;
        if (wSPlayerManager != null && wSPlayerManager.p0().equals(stfeed.feed.f25129id)) {
            wSFollowFeedHolder.H(8, 0);
        } else {
            wSFollowFeedHolder.H(0, 0);
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + i3 + ", title:" + wSFollowFeedHolder.f80801d.f81175j + ", feedHolder:" + wSFollowFeedHolder + ", feedHolder.mVideoInfo:" + wSFollowFeedHolder.f80801d);
        x(wSFollowFeedHolder);
        this.f80705d.ii(wSFollowFeedHolder);
    }

    private void w() {
        WSVideoPreDownloadManager wSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
        wSVideoPreDownloadManager.x(new a());
        this.f80709i.U0(wSVideoPreDownloadManager);
    }

    private void x(WSFollowFeedHolder wSFollowFeedHolder) {
        if (this.f80708h == null && this.f80705d.ei() && this.f80709i != null) {
            this.f80708h = wSFollowFeedHolder;
            C(wSFollowFeedHolder);
            com.tencent.biz.pubaccount.weishi.util.x.j("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.f80708h.f80802e + ", mFistPlayableHolder:" + this.f80708h + ", mFistPlayableHolder.mVideoInfo:" + this.f80708h.f80801d);
            this.f80709i.M0(this.f80708h.f80802e);
            this.f80705d.ti(false);
        }
    }

    public void A(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        this.f80709i.Y0();
        this.f80706e = fVar;
        this.f80709i.L0(fVar.f80802e, false);
        this.f80709i.V0(true);
        this.f80709i.S0(this.C);
        jz.f.d().p(fVar.f80802e);
    }

    public void B(WSPlayerManager wSPlayerManager) {
        this.f80709i = wSPlayerManager;
        this.f80709i.X(new WSFollowPlayerStatusListenerImpl(this));
        w();
    }

    public void C(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        this.f80707f = fVar;
        com.tencent.biz.pubaccount.weishi.util.x.j("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + u(this.f80706e) + "\nprePlayTitle:" + u(this.f80707f) + "\nPlayingHolder:" + this.f80706e + "\nPrePlayHolder:" + this.f80707f);
    }

    public void D(boolean z16) {
        this.C = z16;
        WSPlayerManager wSPlayerManager = this.f80709i;
        if (wSPlayerManager == null || !this.f80705d.K) {
            return;
        }
        wSPlayerManager.S0(z16);
        com.tencent.biz.pubaccount.weishi.player.b.d().f(!z16);
    }

    public boolean E() {
        return this.C;
    }

    public void F() {
        com.tencent.biz.pubaccount.weishi.holder.f fVar;
        com.tencent.biz.pubaccount.weishi.player.e eVar;
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.holder.f fVar2 = this.f80707f;
        if (fVar2 == null || fVar2 == (fVar = this.f80706e)) {
            com.tencent.biz.pubaccount.weishi.util.x.f("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + fVar2);
            return;
        }
        if (fVar == null || (eVar = fVar.f80802e) == null || (wSPlayerWrapper = eVar.f81129e) == null) {
            return;
        }
        int B = wSPlayerWrapper.B();
        com.tencent.biz.pubaccount.weishi.util.x.j("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + B + ", prePlayVideoHolder:" + fVar2);
        if (B == 0 || B == 1 || B == 2) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + fVar2);
        this.f80709i.M0(fVar2.f80802e);
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        stFeed stfeed;
        List<stFeed> dataList = getDataList();
        if (dataList == null || dataList.size() <= 0 || (stfeed = dataList.get(i3)) == null) {
            return 2;
        }
        stSplitBlock stsplitblock = stfeed.recommend_splitter;
        if (stsplitblock != null && stfeed.feed_type == 3) {
            int i16 = stsplitblock.style;
            if (i16 == 1) {
                return 101;
            }
            if (i16 == 2) {
                return 102;
            }
        }
        return stfeed.feed_type;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<stFeed> baseViewHolder, int i3) {
        stFeed item = getItem(i3);
        if (item == null) {
            return;
        }
        if (baseViewHolder instanceof WSFollowFeedHolder) {
            v(baseViewHolder, i3, item);
            return;
        }
        if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.c) {
            ((com.tencent.biz.pubaccount.weishi.holder.c) baseViewHolder).bindData(item);
            return;
        }
        if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.d) {
            ((com.tencent.biz.pubaccount.weishi.holder.d) baseViewHolder).bindData(item);
        } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.e) {
            ((com.tencent.biz.pubaccount.weishi.holder.e) baseViewHolder).bindData(item);
        } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
            ((com.tencent.biz.pubaccount.weishi.holder.a) baseViewHolder).bindData(item);
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<stFeed> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        BaseViewHolder<stFeed> a16 = com.tencent.biz.pubaccount.weishi.holder.b.a(i3, viewGroup, this);
        this.f80710m.add(a16);
        com.tencent.biz.pubaccount.weishi.util.x.i("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + a16);
        return a16;
    }

    public Activity p() {
        return this.f80705d.getBaseActivity();
    }

    public HashSet<BaseViewHolder> q() {
        return this.f80710m;
    }

    public stSimpleMetaFeed r() {
        List<stFeed> dataList = getDataList();
        if (dataList != null && dataList.size() != 0) {
            for (stFeed stfeed : dataList) {
                stSimpleMetaFeed stsimplemetafeed = stfeed.feed;
                if (stsimplemetafeed != null && !TextUtils.isEmpty(stsimplemetafeed.f25129id)) {
                    return stfeed.feed;
                }
            }
        }
        return null;
    }

    public WSFollowFragment s() {
        return this.f80705d;
    }

    public WSPlayerManager t() {
        return this.f80709i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<stFeed> baseViewHolder) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSFollowAdapter", "[**********************************]onViewAttachedToWindow holder = " + baseViewHolder);
        if (this.f80705d.getUserVisibleHint()) {
            if (baseViewHolder instanceof WSFollowFeedHolder) {
                ((WSFollowFeedHolder) baseViewHolder).r0();
            } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.d) {
                ((com.tencent.biz.pubaccount.weishi.holder.d) baseViewHolder).e();
            } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.e) {
                ((com.tencent.biz.pubaccount.weishi.holder.e) baseViewHolder).e();
            } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
                ((com.tencent.biz.pubaccount.weishi.holder.a) baseViewHolder).i();
            }
        }
        if (baseViewHolder instanceof WSFollowFeedHolder) {
            ((WSFollowFeedHolder) baseViewHolder).j0();
        } else if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
            ((com.tencent.biz.pubaccount.weishi.holder.a) baseViewHolder).h();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder<stFeed> baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSFollowAdapter", "[**********************************]onViewDetachedFromWindow holder = " + baseViewHolder);
        if (baseViewHolder instanceof WSFollowFeedHolder) {
            ((WSFollowFeedHolder) baseViewHolder).onViewDetachedFromWindow();
        }
    }

    private String u(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        if (fVar == null) {
            return "WSPlayableHolder is null.";
        }
        com.tencent.biz.pubaccount.weishi.player.e eVar = fVar.f80802e;
        if (eVar == null) {
            return "WSPlayableHolder.mPlayerParam is null.";
        }
        com.tencent.biz.pubaccount.weishi.player.l lVar = eVar.f81127c;
        if (lVar == null) {
            return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
        }
        return lVar.f81175j;
    }
}
