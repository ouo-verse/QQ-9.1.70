package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import b40.c;
import com.tencent.biz.qqcircle.beans.QCircleAlbumListBean;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalAlbumListFragment extends QFSBaseFragment implements ILazyLoader {
    public static final String K = "com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumListFragment";
    private z30.e E;
    private QFSBaseBlockPart F;
    protected QFSSharePart G;
    private QCircleAlbumListBean H;
    private b40.c I;
    private List<b40.a> J;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(c.a aVar) {
        if (this.E != null) {
            int currentState = aVar.getCurrentState();
            if (currentState == 4) {
                this.E.getLoadInfo().setFinish(aVar.isFinish());
                this.E.notifyLoadingComplete(aVar.f27862a, aVar.isFinish());
            } else {
                this.E.getLoadInfo().setCurrentState(currentState);
                this.E.getLoadInfo().setFinish(aVar.isFinish());
            }
        }
    }

    private List<MultiViewBlock> Bh() {
        ArrayList arrayList = new ArrayList();
        vh();
        arrayList.add(this.E);
        return arrayList;
    }

    private void initIntentData() {
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            QCircleAlbumListBean qCircleAlbumListBean = (QCircleAlbumListBean) intent.getSerializableExtra("key_bundle_common_init_bean");
            this.H = qCircleAlbumListBean;
            if (qCircleAlbumListBean != null) {
                try {
                    List<byte[]> feedAlbumInfoBytes = qCircleAlbumListBean.getFeedAlbumInfoBytes();
                    this.J = new ArrayList();
                    Iterator<byte[]> it = feedAlbumInfoBytes.iterator();
                    while (it.hasNext()) {
                        this.J.add(new b40.a(new FeedCloudMeta$FeedAlbumInfo().mergeFrom(it.next())));
                    }
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e(K, 4, "invalid album feed data", e16);
                    return;
                }
            }
            return;
        }
        QLog.i(K, 1, "InitBean is null");
    }

    private void initViewModel() {
        b40.c cVar = (b40.c) getViewModel(b40.c.class);
        this.I = cVar;
        cVar.P1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalAlbumListFragment.this.yh((b40.d) obj);
            }
        });
        this.I.P1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalAlbumListFragment.this.zh((b40.d) obj);
            }
        });
        this.I.O1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.album.view.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalAlbumListFragment.this.Ah((c.a) obj);
            }
        });
    }

    private void vh() {
        z30.e eVar = new z30.e(new Bundle());
        this.E = eVar;
        eVar.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.album.view.v
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSPersonalAlbumListFragment.this.xh(loadInfo, obj);
            }
        });
    }

    private void wh() {
        BlockContainer blockContainer = this.F.getBlockContainer();
        blockContainer.setEnableLoadMore(true);
        blockContainer.setParentFragment(this);
        blockContainer.setEnableRefresh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(LoadInfo loadInfo, Object obj) {
        if (!loadInfo.isFinish()) {
            this.I.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(b40.d dVar) {
        this.E.m0(dVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(b40.d dVar) {
        z30.e eVar = this.E;
        if (eVar != null) {
            eVar.m0(dVar.a());
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        initIntentData();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new y50.b(0));
        QFSBaseBlockPart qFSBaseBlockPart = new QFSBaseBlockPart(R.id.vft, Bh(), 3, 1);
        this.F = qFSBaseBlockPart;
        arrayList.add(qFSBaseBlockPart);
        QFSSharePart qFSSharePart = new QFSSharePart();
        this.G = qFSSharePart;
        qFSSharePart.setReportBeanAgent(this);
        arrayList.add(this.G);
        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.part.a());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        List<b40.a> list = this.J;
        if (list != null && list.size() > 0 && this.J.get(0).f() != null) {
            String str2 = this.J.get(0).f().album.owner.get().f398463id.get();
            if (com.tencent.biz.qqcircle.immersive.utils.r.v0(str2)) {
                str = "host";
            } else {
                str = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gkn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_ALBUM_LIST_PAGE;
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
        return null;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        b40.d dVar = new b40.d(this.H.getUin(), this.H.getAttachInfo(), this.H.getHasMore(), this.J);
        initViewModel();
        this.I.R1(dVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        b40.c cVar;
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleAlbumEvent) {
            QCircleAlbumEvent qCircleAlbumEvent = (QCircleAlbumEvent) simpleBaseEvent;
            if (qCircleAlbumEvent.state == 1 && (cVar = this.I) != null) {
                cVar.N1(qCircleAlbumEvent.albumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        wh();
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
