package com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f87178d;

    /* renamed from: e, reason: collision with root package name */
    private QFSLayerSubscribeViewModel f87179e;

    /* renamed from: f, reason: collision with root package name */
    private String f87180f;

    /* renamed from: h, reason: collision with root package name */
    private List<FeedCloudMeta$StFeed> f87181h = new ArrayList();

    public e(QCircleLayerBean qCircleLayerBean) {
        this.f87178d = qCircleLayerBean;
    }

    private void N9() {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null) {
            for (e30.b bVar : this.mLayerPageAdapter.getDataList()) {
                if (bVar.g() != null && bVar.g().type.get() == 2) {
                    w20.a.j().t(bVar.g().f398449id.get(), 0);
                }
            }
        }
    }

    private void O9() {
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.b
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean R9;
                R9 = e.this.R9();
                return R9;
            }
        });
    }

    private void P9(QCircleLayerBean qCircleLayerBean) {
        if (qCircleLayerBean == null) {
            return;
        }
        HashMap<String, String> schemeAttrs = qCircleLayerBean.getSchemeAttrs();
        final HashMap<String, byte[]> schemeBytes = qCircleLayerBean.getSchemeBytes();
        final String str = schemeAttrs.get(QCircleSchemeAttr.Detail.FEED_LIST_BYTE_ID);
        final String str2 = schemeAttrs.get("feedid");
        this.f87180f = schemeAttrs.get(QCircleSchemeAttr.Detail.FEED_ATTACH_INFO);
        if (str == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.S9(str, str2, schemeBytes);
            }
        });
    }

    private IDataDisplaySurface<e30.b> Q9() {
        QFSLayerSubscribeViewModel qFSLayerSubscribeViewModel = (QFSLayerSubscribeViewModel) getViewModel(QFSLayerSubscribeViewModel.class);
        this.f87179e = qFSLayerSubscribeViewModel;
        if (qFSLayerSubscribeViewModel == null) {
            return null;
        }
        qFSLayerSubscribeViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.T9((UIStateData) obj);
            }
        });
        P9(this.f87178d);
        I9();
        return this.f87179e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean R9() {
        broadcastMessage("layer_notify_part_action_down", null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(String str, String str2, HashMap hashMap) {
        String[] U9 = U9(str);
        int i3 = 0;
        for (int i16 = 0; i16 < U9.length; i16++) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            if (U9[i16].equals(str2)) {
                i3 = i16;
            }
            try {
                feedCloudMeta$StFeed.mergeFrom((byte[]) hashMap.get(U9[i16]));
                this.f87181h.add(feedCloudMeta$StFeed);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        this.f87179e.q2(this.f87181h, this.f87178d, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(UIStateData uIStateData) {
        Z9(uIStateData);
    }

    private String[] U9(String str) {
        return str.replace("\"", "").replace("[", "").replace("]", "").trim().split(",");
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        return this.f87179e;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f87178d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSubscribeListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return Q9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.mLayerPageContainer.setRefreshEnable(false);
        this.mLayerPageContainer.setLoadMoreEnable(true);
        O9();
        E9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        N9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        if (this.f87179e != null) {
            QLog.d(getTAG(), 1, "requestData  refresh, , attachInfo: " + this.f87179e.P1().getStringAttachInfo());
            if (this.f87179e.P1().getStringAttachInfo() == null) {
                this.f87179e.P1().setStringAttachInfo(this.f87180f);
            }
            this.f87179e.v2(this.f87178d.getExtraTypeInfo().sourceType);
        }
    }
}
