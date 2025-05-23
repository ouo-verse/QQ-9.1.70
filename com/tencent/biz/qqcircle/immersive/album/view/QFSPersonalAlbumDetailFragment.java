package com.tencent.biz.qqcircle.immersive.album.view;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.album.AlbumDetailPageFakeWriterLayer;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* loaded from: classes4.dex */
public class QFSPersonalAlbumDetailFragment extends QFSBaseFragment implements ILazyLoader {
    public static final String L = "com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumDetailFragment";
    private static final HashMap<Integer, Integer> M;
    private QFSBaseBlockPart E;
    protected QFSSharePart F;
    private z30.c G;
    private AlbumDetailPageFakeWriterLayer H;
    protected QFSLayerAlbumViewModel I;
    private FeedCloudMeta$FeedAlbum J;
    private boolean K = false;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        M = hashMap;
        hashMap.put(52, 57);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        uh();
        VideoReport.traverseExposure();
    }

    private void Bh() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.I;
        if (qFSLayerAlbumViewModel != null) {
            qFSLayerAlbumViewModel.h3(0);
        }
    }

    private List<MultiViewBlock> Ch() {
        ArrayList arrayList = new ArrayList();
        wh(new Bundle());
        arrayList.add(this.G);
        return arrayList;
    }

    private void Dh() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.I;
        if (qFSLayerAlbumViewModel != null) {
            qFSLayerAlbumViewModel.h3(2);
        }
    }

    private void Eh(UIStateData<List<e30.b>> uIStateData) {
        this.G.i0(uIStateData);
    }

    private void initIntentData() {
        if (getActivity() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            QCircleAlbumDetailBean qCircleAlbumDetailBean = (QCircleAlbumDetailBean) intent.getSerializableExtra("key_bundle_common_init_bean");
            if (qCircleAlbumDetailBean == null) {
                QLog.e(L, 1, "InitBean is null");
                return;
            }
            if (qCircleAlbumDetailBean.getFeedAlbumByte() != null) {
                try {
                    this.J = new FeedCloudMeta$FeedAlbum().mergeFrom(qCircleAlbumDetailBean.getFeedAlbumByte());
                } catch (Exception e16) {
                    QLog.e(L, 1, "invalid feedAlbum bytes", e16);
                }
            } else {
                FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = new FeedCloudMeta$FeedAlbum();
                this.J = feedCloudMeta$FeedAlbum;
                feedCloudMeta$FeedAlbum.f398441id.set(qCircleAlbumDetailBean.getAlbumId());
            }
            this.K = qCircleAlbumDetailBean.isMiddlePage();
            return;
        }
        QLog.i(L, 1, "InitBean is null");
    }

    private void registerReceiver() {
        this.H = new AlbumDetailPageFakeWriterLayer(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_fake_write_album_detail_edit");
        intentFilter.addAction("action_fake_write_album_works_add");
        intentFilter.addAction("action_fake_write_album_works_edit");
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().registerReceiver(this.H, intentFilter);
        }
    }

    private void uh() {
        String str;
        if (((QCircleBaseFragment) this).mContentView == null) {
            QLog.i(L, 1, "reportDaTongRegister  mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        if (!TextUtils.isEmpty(getDaTongPageId())) {
            str = getDaTongPageId();
        } else {
            str = QCircleDaTongConstant.PageId.BASE;
        }
        VideoReport.setPageId(((QCircleBaseFragment) this).mContentView, str);
        VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, new QCircleDTParamBuilder().buildPageParams(getTAG(), getChildDaTongPageParams()));
        VideoReport.setElementDynamicParams(((QCircleBaseFragment) this).mContentView, new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(((QCircleBaseFragment) this).mContentView, new QCircleDTParamBuilder().buildDynamicParams());
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str);
    }

    private void vh() {
        BlockContainer blockContainer = this.E.getBlockContainer();
        blockContainer.setEnableLoadMore(true);
        blockContainer.setParentFragment(this);
        blockContainer.setEnableRefresh(false);
        if (blockContainer.getBlockMerger() != null) {
            blockContainer.getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(getContext()));
        }
    }

    private void wh(Bundle bundle) {
        z30.c cVar = new z30.c(bundle);
        this.G = cVar;
        cVar.setReportBean(getReportBean());
        this.G.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.album.view.j
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSPersonalAlbumDetailFragment.this.yh(loadInfo, obj);
            }
        });
    }

    private void xh() {
        int i3;
        Integer num;
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean != null) {
            QCircleExtraTypeInfo extraTypeInfo = qCircleInitBean.getExtraTypeInfo();
            if (extraTypeInfo != null && (num = M.get(Integer.valueOf(extraTypeInfo.sourceType))) != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            setReportBean(new QCircleReportBean().setPageId(57).setFromPageId(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(LoadInfo loadInfo, Object obj) {
        if (loadInfo.isLoadMoreState()) {
            Bh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(UIStateData uIStateData) {
        this.G.setDatas((List) uIStateData.getData());
        Eh(uIStateData);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new y50.b(1));
        QFSBaseBlockPart qFSBaseBlockPart = new QFSBaseBlockPart(R.id.vfu, Ch(), 3, 1);
        this.E = qFSBaseBlockPart;
        arrayList.add(qFSBaseBlockPart);
        QFSSharePart qFSSharePart = new QFSSharePart();
        this.F = qFSSharePart;
        qFSSharePart.setReportBeanAgent(this);
        arrayList.add(this.F);
        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.part.a());
        arrayList.add(new br());
        arrayList.add(new g());
        arrayList.add(new d());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(this.J.f398441id.get()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.J.owner.f398463id.get());
        if (com.tencent.biz.qqcircle.immersive.utils.r.v0(this.J.owner.get().f398463id.get())) {
            str = "host";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MIDDLE_PAGE, Integer.valueOf(this.K ? 1 : 0));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_SOURCE, c40.b.b(this.I.R2()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_NUM, Integer.valueOf(this.I.O2().getValue().album.feed_count.get()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gl8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_ALBUM_DETAIL_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        super.getEventClass();
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleAlbumEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return L;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 57;
    }

    protected void initViewModel() {
        boolean z16;
        this.I = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        String str = this.J.owner.f398463id.get();
        long j3 = this.J.f398441id.get();
        String str2 = this.J.title.get();
        String str3 = this.J.description.get();
        String str4 = this.J.cover_url.get();
        boolean z17 = true;
        if (this.J.collection_info.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.J.status.get() != 2) {
            z17 = false;
        }
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(str, j3, str2, str3, str4, z16, z17);
        this.I.k3(new QCircleAlbumBean(qCircleFeedAlbumInfo));
        this.I.j().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalAlbumDetailFragment.this.zh((UIStateData) obj);
            }
        });
        this.I.S2().setValue(Boolean.valueOf(qCircleFeedAlbumInfo.isDraft));
        this.I.O2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalAlbumDetailFragment.this.Ah((QQCircleFeedBase$AlbumPageData) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        initIntentData();
        initViewModel();
        Dh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        xh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null && this.H != null) {
            getActivity().unregisterReceiver(this.H);
        }
        z30.c cVar = this.G;
        if (cVar != null) {
            cVar.release();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QCircleAlbumEvent) && ((QCircleAlbumEvent) simpleBaseEvent).state == 1 && getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        vh();
        SimpleEventBus.getInstance().registerReceiver(this);
        registerReceiver();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        this.mReportBean.setPageId(getPageId());
        assembleFromReportData();
        return this.mReportBean;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
