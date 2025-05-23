package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.QCircleServiceDiscoverHeadView;
import com.tencent.biz.subscribe.widget.relativevideo.QCircleServiceDiscoverView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import mqq.util.WeakReference;
import oy.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class FolderRecommendQCircleTabFragment extends FolderBaseTabFragment {
    private BlockContainer I;
    private QCircleServiceDiscoverHeadView J;
    private a K;
    private boolean L;
    private View M;
    private oy.a N;
    private b P;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements a.InterfaceC10968a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<FolderRecommendQCircleTabFragment> f79988a;

        public b(FolderRecommendQCircleTabFragment folderRecommendQCircleTabFragment) {
            this.f79988a = new WeakReference<>(folderRecommendQCircleTabFragment);
        }

        @Override // oy.a.InterfaceC10968a
        public void a(boolean z16, long j3, String str) {
            FolderRecommendQCircleTabFragment folderRecommendQCircleTabFragment;
            WeakReference<FolderRecommendQCircleTabFragment> weakReference = this.f79988a;
            if (weakReference == null) {
                folderRecommendQCircleTabFragment = null;
            } else {
                folderRecommendQCircleTabFragment = weakReference.get();
            }
            if (folderRecommendQCircleTabFragment != null) {
                folderRecommendQCircleTabFragment.zh(z16, j3, str);
            } else {
                QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[onLoadDataFail] fragment should not be null.");
            }
        }

        @Override // oy.a.InterfaceC10968a
        public void b(boolean z16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            FolderRecommendQCircleTabFragment folderRecommendQCircleTabFragment;
            WeakReference<FolderRecommendQCircleTabFragment> weakReference = this.f79988a;
            if (weakReference == null) {
                folderRecommendQCircleTabFragment = null;
            } else {
                folderRecommendQCircleTabFragment = weakReference.get();
            }
            if (folderRecommendQCircleTabFragment == null) {
                QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[onLoadDataFinish] fragment should not be null.");
                return;
            }
            if (!z16 || feedCloudRead$StGetFeedListRsp == null || !feedCloudRead$StGetFeedListRsp.vecFeed.isEmpty()) {
                folderRecommendQCircleTabFragment.xh(z16, feedCloudRead$StGetFeedListRsp);
            } else {
                QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[onLoadDataFinish] current refresh data is empty.");
                folderRecommendQCircleTabFragment.Bh(true);
            }
        }
    }

    private void Ah() {
        this.P = new b(this);
        oy.b bVar = new oy.b();
        this.N = bVar;
        bVar.b(this.P);
        this.N.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(boolean z16) {
        a aVar = this.K;
        if (aVar != null) {
            aVar.j0(null, 46, z16);
        } else {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyRequestFail] folder block should not be null.");
        }
        View view = this.M;
        if (view != null) {
            view.setVisibility(0);
        } else {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyRequestFail] error title should not be null.");
        }
        Ch(false);
        yh(false);
    }

    private void Ch(boolean z16) {
        BlockContainer blockContainer = this.I;
        if (blockContainer == null) {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[cancelLoadMoreAction] block container should not be null.");
        } else {
            blockContainer.setEnableLoadMore(z16);
        }
    }

    private void initView() {
        View view = this.C;
        if (view == null) {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[initView] root view should not be null.");
            return;
        }
        this.J = (QCircleServiceDiscoverHeadView) view.findViewById(R.id.f905552s);
        this.I = (BlockContainer) this.C.findViewById(R.id.f905452r);
        this.M = this.C.findViewById(R.id.uwx);
        a aVar = new a(null, this);
        this.K = aVar;
        this.I.n(aVar);
        this.I.setParentFragment(this);
        this.I.setEnableLoadMore(true);
        this.I.setEnableRefresh(true);
        this.I.c().p0(1);
        this.I.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(com.tencent.biz.subscribe.part.block.base.b bVar) {
        oy.a aVar = this.N;
        if (aVar == null) {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[loadData] feed list model should not be null.");
        } else {
            aVar.a(bVar.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(boolean z16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        a aVar = this.K;
        boolean z17 = true;
        if (aVar != null) {
            aVar.j0(feedCloudRead$StGetFeedListRsp, 46, z16);
        } else {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyLoadDataFinish] folder recommend qcircle block should not be null");
        }
        QCircleServiceDiscoverHeadView qCircleServiceDiscoverHeadView = this.J;
        if (qCircleServiceDiscoverHeadView != null) {
            qCircleServiceDiscoverHeadView.setData(feedCloudRead$StGetFeedListRsp, 46, z16);
        } else {
            QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyLoadDataFinish] head widget view should not be null.");
        }
        if (z16) {
            Ch(true);
        }
        if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.isFinish.get() != 1) {
            z17 = false;
        }
        yh(z17);
    }

    private void yh(boolean z16) {
        this.I.setRefreshing(false);
        com.tencent.biz.subscribe.part.block.a c16 = this.I.c();
        if (c16 != null) {
            c16.I(true, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z16, long j3, String str) {
        QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyRequestFail] errorCode: " + j3 + " | errorMsg: " + str);
        BaseApplication context = BaseApplication.getContext();
        if (!TextUtils.isEmpty(str) && context != null) {
            QQToast.makeText(context, 1, str, 0).show();
        }
        Bh(z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.C == null) {
            this.C = LayoutInflater.from(getBaseActivity()).inflate(R.layout.e1g, (ViewGroup) null);
        }
        boolean m3 = SubscribeUtils.m();
        this.L = m3;
        if (m3) {
            this.C.setBackgroundColor(-16777216);
        } else {
            this.C.setBackgroundColor(-657670);
        }
        initView();
        QLog.d(FolderBaseTabFragment.F, 4, "onCreateView:" + vh());
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    protected void ph() {
        Ah();
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    public void qh(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew, int i3) {
        if (i3 == vh()) {
            serviceAccountFolderActivityNew.b3(false);
        }
    }

    public int vh() {
        return FolderBaseTabFragment.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends we0.a {
        private QCircleServiceDiscoverView L;
        private WeakReference<FolderRecommendQCircleTabFragment> M;
        private com.tencent.biz.subscribe.part.block.base.b N;

        public a(Bundle bundle, FolderRecommendQCircleTabFragment folderRecommendQCircleTabFragment) {
            this(bundle);
            this.M = new WeakReference<>(folderRecommendQCircleTabFragment);
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
            FolderRecommendQCircleTabFragment folderRecommendQCircleTabFragment;
            WeakReference<FolderRecommendQCircleTabFragment> weakReference = this.M;
            if (weakReference == null) {
                folderRecommendQCircleTabFragment = null;
            } else {
                folderRecommendQCircleTabFragment = weakReference.get();
            }
            if (folderRecommendQCircleTabFragment == null) {
                QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[loadData] fragment should not be null.");
            } else {
                this.N = bVar;
                folderRecommendQCircleTabFragment.wh(bVar);
            }
        }

        @Override // we0.a
        protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
            QCircleServiceDiscoverView qCircleServiceDiscoverView = new QCircleServiceDiscoverView(viewGroup.getContext());
            this.L = qCircleServiceDiscoverView;
            return qCircleServiceDiscoverView;
        }

        public void j0(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3, boolean z16) {
            boolean z17;
            if (this.L == null) {
                QLog.e("SCF-FolderRecommendQCircleTabFragment", 1, "[setData] folder view should not be null.");
                return;
            }
            com.tencent.biz.subscribe.part.block.base.b bVar = this.N;
            if (bVar != null && feedCloudRead$StGetFeedListRsp != null) {
                bVar.l(4);
                com.tencent.biz.subscribe.part.block.base.b bVar2 = this.N;
                PBUInt32Field pBUInt32Field = feedCloudRead$StGetFeedListRsp.isFinish;
                if (pBUInt32Field != null && pBUInt32Field.get() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bVar2.m(z17);
            }
            QLog.d("SCF-FolderRecommendQCircleTabFragment", 1, "[notifyLoadDataFinish] sourceType: " + i3 + " | isRefresh: " + z16);
            this.L.setData(feedCloudRead$StGetFeedListRsp, i3, z16);
        }

        public a(Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void a0(Bundle bundle) {
        }
    }
}
