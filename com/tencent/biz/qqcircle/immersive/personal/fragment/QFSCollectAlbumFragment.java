package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSCollectAlbumAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$FeedAlbum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectAlbumFragment extends QFSPersonalBaseNestScrollFragment {
    protected BlockPart E;
    protected com.tencent.biz.qqcircle.immersive.personal.part.y F;
    protected QFSCollectAlbumAdapter G;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r H;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (QFSCollectAlbumFragment.this.H != null && loadInfo.isLoadMoreState()) {
                QFSCollectAlbumFragment.this.H.W2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Observer<UIStateData<List<FeedCloudMeta$FeedAlbum>>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<FeedCloudMeta$FeedAlbum>> uIStateData) {
            boolean z16;
            QFSCollectAlbumAdapter qFSCollectAlbumAdapter;
            if (uIStateData == null) {
                return;
            }
            boolean isFinish = uIStateData.getIsFinish();
            int state = uIStateData.getState();
            if (state == 0) {
                QFSCollectAlbumFragment.this.Ch();
            } else {
                z16 = false;
                if (state != 1) {
                    if (state != 2) {
                        if (state != 3) {
                            if (state == 4) {
                                QFSCollectAlbumFragment.this.Dh(uIStateData.getMsg());
                            }
                        } else {
                            z16 = true;
                        }
                    }
                    QFSCollectAlbumFragment.this.Ih();
                    QFSCollectAlbumFragment.this.Eh(uIStateData);
                }
                if (!z16 && (qFSCollectAlbumAdapter = QFSCollectAlbumFragment.this.G) != null) {
                    qFSCollectAlbumAdapter.getLoadInfo().setFinish(isFinish);
                    QFSCollectAlbumFragment.this.G.notifyLoadingComplete(true, isFinish);
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends v.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("key_version_extend_base_info", "update_version_op_mask", "update_versionP_user_black");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            if (!wVar.z() && QFSCollectAlbumFragment.this.F != null) {
                if (wVar.x()) {
                    QFSCollectAlbumFragment.this.F.Q9();
                    return;
                }
                if (wVar.v()) {
                    QFSCollectAlbumFragment.this.F.M9(uq3.c.c2(), uq3.c.b2());
                } else if (wVar.w()) {
                    QFSCollectAlbumFragment.this.F.M9(uq3.c.c2(), uq3.c.a2());
                } else if (wVar.u(19)) {
                    QFSCollectAlbumFragment.this.F.L9();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        String v16;
        String t16;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.H;
        if (rVar != null && this.F != null) {
            boolean z16 = rVar.v2().z();
            if (z16) {
                v16 = uq3.c.w1();
            } else {
                v16 = uq3.c.v1();
            }
            if (z16) {
                t16 = uq3.c.u1();
            } else {
                t16 = uq3.c.t1();
            }
            if (TextUtils.isEmpty(t16)) {
                String[] f16 = cu.f(v16, "\n");
                if (f16.length >= 2) {
                    t16 = f16[1];
                    v16 = f16[0];
                }
            }
            this.F.M9(v16, t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str) {
        String v16;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.H;
        if (rVar != null && this.F != null) {
            if (rVar.v2().z()) {
                v16 = uq3.c.w1();
            } else {
                v16 = uq3.c.v1();
            }
            if (TextUtils.isEmpty(str)) {
                String[] f16 = cu.f(v16, "\n");
                if (f16.length >= 2) {
                    str = f16[1];
                    v16 = f16[0];
                }
            }
            this.F.M9(v16, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(UIStateData<List<FeedCloudMeta$FeedAlbum>> uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.H;
        if (rVar != null && !rVar.K2() && this.G != null && uIStateData != null && uIStateData.getData() != null) {
            this.G.setDatas(uIStateData.getData());
            this.F.E9();
        }
    }

    private void Fh() {
        this.E.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.E.getBlockContainer().setEnableRefresh(false);
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        if (this.E.getBlockContainer().getBlockMerger() != null) {
            this.E.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(int i3, FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum, QCircleBaseWidgetView qCircleBaseWidgetView) {
        QCircleAlbumDetailBean qCircleAlbumDetailBean = new QCircleAlbumDetailBean();
        qCircleAlbumDetailBean.setFeedAlbum(feedCloudMeta$FeedAlbum);
        com.tencent.biz.qqcircle.launcher.c.Z(getContext(), qCircleAlbumDetailBean);
    }

    private List<MultiViewBlock> Hh() {
        ArrayList arrayList = new ArrayList();
        QFSCollectAlbumAdapter qFSCollectAlbumAdapter = new QFSCollectAlbumAdapter(getArguments());
        this.G = qFSCollectAlbumAdapter;
        qFSCollectAlbumAdapter.setOnLoadDataDelegate(new a());
        this.G.m0(new QFSCollectAlbumAdapter.c() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.a
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSCollectAlbumAdapter.c
            public final void a(int i3, FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSCollectAlbumFragment.this.Gh(i3, feedCloudMeta$FeedAlbum, qCircleBaseWidgetView);
            }
        });
        arrayList.add(this.G);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        BlockPart blockPart = this.E;
        if (blockPart != null) {
            blockPart.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
            this.E.getBlockContainer().getBlockMerger().resetTryToLoadMoreCount();
        }
    }

    private void initViewModel() {
        QLog.i(getTAG(), 1, "[initViewModel] getParentFragment() = " + getParentFragment());
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel((IPartHost) getParentFragment(), null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.H = rVar;
        rVar.d2().observe(this, new b());
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel((IPartHost) getParentFragment(), null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.I = tVar;
        tVar.O1().c(this, new c());
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.f34240ym, Hh(), 3, 1);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        arrayList.add(yVar);
        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.part.c((IPartHost) getParentFragment()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gka;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Fh();
        initViewModel();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment
    protected NestScrollRecyclerView sh() {
        QFSCollectAlbumAdapter qFSCollectAlbumAdapter = this.G;
        if (qFSCollectAlbumAdapter == null) {
            return null;
        }
        return qFSCollectAlbumAdapter.getParentRecyclerView();
    }
}
