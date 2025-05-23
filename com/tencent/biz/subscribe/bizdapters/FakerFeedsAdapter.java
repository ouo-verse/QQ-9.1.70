package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class FakerFeedsAdapter extends MultiViewBlock<CertifiedAccountMeta$StFeed> implements SimpleEventReceiver, RelativeAdFeedItemView.a {
    private boolean J;
    private boolean K;
    protected RecyclerView.LayoutManager L;

    public FakerFeedsAdapter(Bundle bundle) {
        super(bundle);
        this.J = true;
    }

    private int k0(String str) {
        for (int i3 = 0; i3 < r().size(); i3++) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = r().get(i3);
            if (str.startsWith("fakeid_") && !certifiedAccountMeta$StFeed.f24925id.get().startsWith("fakeid_")) {
                QLog.d("FakerFeedsAdapter", 2, "has none fakeFeeds");
                return -1;
            }
            if (str.equals(certifiedAccountMeta$StFeed.f24925id.get())) {
                QLog.d("FakerFeedsAdapter", 2, "find fakeid:" + str);
                return i3;
            }
        }
        return -1;
    }

    private void l0(final SubscribeFeedsEvent subscribeFeedsEvent) {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fakeFeed state:");
        sb5.append(subscribeFeedsEvent.mState);
        sb5.append(",fakeId:");
        sb5.append(subscribeFeedsEvent.mTargetId);
        sb5.append(",fake listSize:");
        List<CertifiedAccountMeta$StFeed> list = subscribeFeedsEvent.mFakeFeedDataList;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        QLog.d("FakerFeedsAdapter", 2, sb5.toString());
        if (M("share_key_subscribe_user") == null) {
            return;
        }
        int i3 = subscribeFeedsEvent.mState;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4 || !this.J) {
                        return;
                    }
                    this.J = false;
                    List<CertifiedAccountMeta$StFeed> list2 = subscribeFeedsEvent.mFakeFeedDataList;
                    if (list2 != null && list2.size() > 0) {
                        if (com.tencent.biz.subscribe.c.c() != null) {
                            for (CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed : subscribeFeedsEvent.mFakeFeedDataList) {
                                CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountMeta$StFeed.poster;
                                if (certifiedAccountMeta$StUser != null) {
                                    certifiedAccountMeta$StUser.icon.set(com.tencent.biz.subscribe.c.c().icon.get());
                                    certifiedAccountMeta$StFeed.poster.nick.set(com.tencent.biz.subscribe.c.c().nick.get());
                                }
                            }
                        }
                        s().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4
                            @Override // java.lang.Runnable
                            public void run() {
                                FakerFeedsAdapter.this.r().addAll(0, subscribeFeedsEvent.mFakeFeedDataList);
                                FakerFeedsAdapter.this.notifyDataSetChanged();
                            }
                        });
                        return;
                    }
                    return;
                }
                final int k06 = k0(subscribeFeedsEvent.mTargetId);
                if (k06 != -1) {
                    s().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FakerFeedsAdapter.this.o0(k06);
                            FakerFeedsAdapter.this.q0();
                        }
                    });
                    return;
                }
                return;
            }
            final int k07 = k0(subscribeFeedsEvent.mTargetId);
            if (k07 != -1) {
                final CertifiedAccountMeta$StFeed f16 = SubscribeUtils.f(r().get(k07));
                f16.f24925id.set(subscribeFeedsEvent.mSingleFakeFeed.f24925id.get());
                f16.createTime.set(subscribeFeedsEvent.mSingleFakeFeed.createTime.get());
                f16.cover.url.set(subscribeFeedsEvent.mSingleFakeFeed.cover.url.get());
                s().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FakerFeedsAdapter.this.u(f16, k07);
                        FakerFeedsAdapter.this.notifyItemChanged(k07);
                        if (FakerFeedsAdapter.this.C() != null) {
                            QQToast.makeText(FakerFeedsAdapter.this.C(), 0, R.string.d7r, 0).show();
                        }
                    }
                });
                return;
            }
            return;
        }
        if (com.tencent.biz.subscribe.c.c() != null) {
            subscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(com.tencent.biz.subscribe.c.c().icon.get());
            subscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(com.tencent.biz.subscribe.c.c().nick.get());
        }
        s().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                FakerFeedsAdapter.this.r().add(0, subscribeFeedsEvent.mSingleFakeFeed);
                FakerFeedsAdapter.this.notifyDataSetChanged();
                FakerFeedsAdapter.this.q0();
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(SubscribeFeedsEvent.class);
        arrayList.add(PublishBoxStatusEvent.class);
        return arrayList;
    }

    public boolean m0() {
        return this.K;
    }

    public void n0() {
        if (m0()) {
            this.J = true;
            QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
        }
    }

    protected void o0(int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, r())) {
            return;
        }
        r().remove(i3);
        notifyItemRemoved(i3);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.L = recyclerView.getLayoutManager();
        if (this.K) {
            SimpleEventBus.getInstance().registerReceiver(this);
            QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.K) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof SubscribeFeedsEvent) {
            l0((SubscribeFeedsEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (r() != null) {
            o0(r().indexOf(certifiedAccountMeta$StFeed));
        }
    }

    protected void q0() {
        RecyclerView.LayoutManager layoutManager = this.L;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).invalidateSpanAssignments();
        }
    }

    public void r0(boolean z16) {
        this.K = z16;
    }
}
