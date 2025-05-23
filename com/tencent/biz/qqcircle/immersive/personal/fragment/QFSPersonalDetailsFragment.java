package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSPersonalDetailRefreshEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.personal.model.QFSPersonalTabIndexManager;
import com.tencent.biz.qqcircle.immersive.personal.model.b;
import com.tencent.biz.qqcircle.immersive.personal.part.ad;
import com.tencent.biz.qqcircle.immersive.personal.part.ao;
import com.tencent.biz.qqcircle.immersive.personal.part.aq;
import com.tencent.biz.qqcircle.immersive.personal.part.ar;
import com.tencent.biz.qqcircle.immersive.personal.part.as;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalDetailRefreshHeaderView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleBase$UserCircleInfo;
import qqcircle.QQCircleProfile$QQGroup;
import qqcircle.QQCircleProfile$StProfileBizData;

/* loaded from: classes4.dex */
public class QFSPersonalDetailsFragment extends QFSBaseFragment implements ILazyLoader {

    /* renamed from: f0, reason: collision with root package name */
    private static final int f88619f0 = -cx.a(100.0f);

    /* renamed from: g0, reason: collision with root package name */
    private static boolean f88620g0 = false;
    protected NestScrollRecyclerView E;
    private QFSBaseBlockPart F;
    private ad G;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.j H;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.b I;
    protected QFSPersonalDetailRefreshHeaderView J;
    protected FeedCloudMeta$StFeed K;
    protected FeedCloudMeta$StUser L;
    protected as M;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.r N;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.t P;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.c Q;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.s R;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.e S;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.d T;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.d U;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.j V;
    private QFSDraftViewModel W;
    protected QFSPersonalEditViewModel X;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private QCircleLoadingDialog f88621a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f88622b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f88623c0;

    /* renamed from: e0, reason: collision with root package name */
    private QCircleInitBean f88625e0;
    private final com.tencent.biz.qqcircle.immersive.personal.model.b Y = new com.tencent.biz.qqcircle.immersive.personal.model.b();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f88624d0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSPersonalDetailsFragment.this.f88621a0 != null && QFSPersonalDetailsFragment.this.f88621a0.isShowing()) {
                QFSPersonalDetailsFragment.this.f88621a0.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSDraftViewModel.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f88627a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f88628b;

        b(boolean z16, HashMap hashMap) {
            this.f88627a = z16;
            this.f88628b = hashMap;
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel.a
        public void a(int i3) {
            QLog.d("QFSPersonalDetailsFragment", 1, "refreshData, end draft count: " + i3);
            QFSPersonalDetailsFragment.this.N.U2(this.f88627a, i3, this.f88628b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Observer<FeedCloudMeta$StFeed> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            String str;
            byte[] bArr;
            if (feedCloudMeta$StFeed != null) {
                str = feedCloudMeta$StFeed.f398449id.get();
                bArr = feedCloudMeta$StFeed.busiReport.get().toByteArray();
                QFSPersonalDetailsFragment.this.L = feedCloudMeta$StFeed.poster.get();
            } else {
                str = "";
                bArr = null;
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = QFSPersonalDetailsFragment.this.P;
            if (tVar != null) {
                tVar.P1(str);
                QFSPersonalDetailsFragment.this.P.Q1(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (!bool.booleanValue()) {
                return;
            }
            QFSPersonalDetailsFragment qFSPersonalDetailsFragment = QFSPersonalDetailsFragment.this;
            NestScrollRecyclerView nestScrollRecyclerView = qFSPersonalDetailsFragment.E;
            if (nestScrollRecyclerView != null) {
                nestScrollRecyclerView.scrollBy(0, -qFSPersonalDetailsFragment.Z);
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.e eVar = QFSPersonalDetailsFragment.this.S;
            if (eVar != null) {
                eVar.Q1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Observer<Integer> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() == 1) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1925047o), 0);
            }
            QFSPersonalDetailsFragment.this.Eh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements MultiViewBlock.OnLoadDataDelegate<com.tencent.biz.qqcircle.immersive.personal.adapter.j> {
        f() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadData(LoadInfo loadInfo, com.tencent.biz.qqcircle.immersive.personal.adapter.j jVar) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar;
            char c16;
            if (loadInfo.isRefreshState()) {
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.e eVar = QFSPersonalDetailsFragment.this.S;
                if (eVar != null) {
                    eVar.Q1();
                }
                QFSPersonalDetailsFragment.this.gi(false);
                QFSPersonalDetailsFragment qFSPersonalDetailsFragment = QFSPersonalDetailsFragment.this;
                if (qFSPersonalDetailsFragment.N != null && (tVar = qFSPersonalDetailsFragment.P) != null && tVar.N1() != null && !QFSPersonalDetailsFragment.this.P.N1().x()) {
                    com.tencent.biz.qqcircle.immersive.personal.data.w N1 = QFSPersonalDetailsFragment.this.P.N1();
                    String t26 = QFSPersonalDetailsFragment.this.N.t2();
                    t26.hashCode();
                    switch (t26.hashCode()) {
                        case -1779135652:
                            if (t26.equals("qfs_personal_tab_collected_feed")) {
                                c16 = 0;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -1397131327:
                            if (t26.equals("qfs_personal_tab_pushed")) {
                                c16 = 1;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -463865632:
                            if (t26.equals("qfs_personal_tab_praised")) {
                                c16 = 2;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case -195942323:
                            if (t26.equals("qfs_personal_tab_collected_box")) {
                                c16 = 3;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 676958321:
                            if (t26.equals("qfs_personal_tab_collected_album")) {
                                c16 = 4;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1712873144:
                            if (t26.equals("qfs_personal_tab_private_prods")) {
                                c16 = 5;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        default:
                            c16 = '\uffff';
                            break;
                    }
                    switch (c16) {
                        case 0:
                            if (QFSPersonalDetailsFragment.this.V != null) {
                                if (N1.z() || !N1.u(19)) {
                                    QFSPersonalDetailsFragment.this.V.U1(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 1:
                            if (QFSPersonalDetailsFragment.this.U != null) {
                                if (N1.z() || !N1.u(8)) {
                                    QFSPersonalDetailsFragment.this.U.U1(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 2:
                            if (QFSPersonalDetailsFragment.this.T != null) {
                                if (N1.z() || !N1.u(6)) {
                                    QFSPersonalDetailsFragment.this.T.U1(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 3:
                            if (QFSPersonalDetailsFragment.this.N != null) {
                                if (N1.z() || !N1.u(19)) {
                                    QFSPersonalDetailsFragment.this.N.Y2(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 4:
                            if (QFSPersonalDetailsFragment.this.N != null) {
                                if (N1.z() || !N1.u(19)) {
                                    QFSPersonalDetailsFragment.this.N.W2(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 5:
                            if (QFSPersonalDetailsFragment.this.N != null && N1.z()) {
                                QFSPersonalDetailsFragment.this.N.c3(false, -1);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g extends RecyclerView.ItemDecoration {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (QFSPersonalDetailsFragment.this.li() && recyclerView.getChildPosition(view) == 1) {
                rect.top = QFSPersonalDetailsFragment.f88619f0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends RecyclerView.OnScrollListener {
        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            Activity hostActivity;
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && (hostActivity = QFSPersonalDetailsFragment.this.getHostActivity()) != null && hostActivity.getParent() != null) {
                QUIImmersiveHelper.s(hostActivity.getParent(), true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements NestScrollRecyclerView.TransDispatchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private int f88636a;

        /* renamed from: b, reason: collision with root package name */
        private int f88637b;

        /* renamed from: c, reason: collision with root package name */
        private final int f88638c = ViewConfiguration.get(RFWApplication.getApplication()).getScaledTouchSlop();

        i() {
        }

        @Override // com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.TransDispatchDelegate
        public boolean needTransDispatch(MotionEvent motionEvent, RecyclerView recyclerView) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int x16 = (int) (motionEvent.getX() + 0.5f);
                    int y16 = (int) (motionEvent.getY() + 0.5f);
                    int i3 = x16 - this.f88636a;
                    int i16 = y16 - this.f88637b;
                    if (Math.abs(i16) > this.f88638c && Math.abs(i16) >= Math.abs(i3)) {
                        return true;
                    }
                }
            } else {
                this.f88636a = (int) (motionEvent.getX() + 0.5f);
                this.f88637b = (int) (motionEvent.getY() + 0.5f);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    class j implements b.c {
        j() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.model.b.c
        public void a(@NonNull String str, @NonNull List<String> list) {
            QFSPersonalDetailsFragment.this.Lh(str, list);
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.model.b.c
        public void b(@NonNull String str) {
            QFSPersonalDetailsFragment.this.Mh(str);
        }
    }

    private void Dh(ArrayList<Part> arrayList) {
        ao aoVar = new ao();
        arrayList.add(aoVar);
        if (getQCircleInitBean() != null && getQCircleInitBean().getSchemeAttrs() != null && getQCircleInitBean().getSchemeAttrs().containsKey(QCircleSchemeAttr.Detail.AUTO_EXPAND_QRCODE)) {
            aoVar.za("1".equals(getQCircleInitBean().getSchemeAttrs().get(QCircleSchemeAttr.Detail.AUTO_EXPAND_QRCODE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        QCircleLoadingDialog qCircleLoadingDialog = this.f88621a0;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.f88621a0.dismiss();
        }
    }

    private void Gh() {
        if (this.K == null) {
            return;
        }
        Gson gson = new Gson();
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(this.K));
        HashMap hashMap = new HashMap();
        hashMap.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, this.K.f398449id.get());
        hashMap.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, Ih());
        dataBuilder.setActionType(133).setSubActionType(1).setExt9(String.valueOf(this.f88623c0)).setExt10(gson.toJson(hashMap));
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void Kh(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3 && this.P != null) {
            RFWLog.i("QFSPersonalDetailsFragment", RFWLog.USR, "[handleFeedEvent] delete feed = " + qCircleFeedEvent.mTargetId);
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.P.N1();
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.d dVar = this.T;
            if (dVar != null && dVar.W1(qCircleFeedEvent.mTargetId)) {
                N1.S(N1.d().c() - 1);
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.d dVar2 = this.U;
            if (dVar2 != null && dVar2.W1(qCircleFeedEvent.mTargetId)) {
                N1.U(N1.d().f() - 1);
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
            if (rVar != null && rVar.L2()) {
                if (this.N.X1(qCircleFeedEvent.mTargetId)) {
                    N1.O(N1.d().b() - 1);
                }
                if (this.N.Z1(qCircleFeedEvent.mTargetId)) {
                    QLog.d("QFSPersonalDetailsFragment", 1, "delete private suc.");
                }
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar = this.V;
            if (jVar != null && jVar.W1(qCircleFeedEvent.mTargetId)) {
                N1.N(false);
            }
            N1.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(String str, @NonNull List<String> list) {
        if ("qfs_personal_tab_private_prods".equals(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.N.Z1(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(String str) {
        if ("qfs_personal_tab_private_prods".equals(str)) {
            this.N.c3(false, 0);
        }
    }

    private void Oh(QFSPersonalDetailRefreshEvent qFSPersonalDetailRefreshEvent) {
        if (!TextUtils.isEmpty(qFSPersonalDetailRefreshEvent.getUin()) && this.N != null && qFSPersonalDetailRefreshEvent.getUin().equals(this.N.i2())) {
            this.N.T2(false);
        }
    }

    private void Ph() {
        if (com.tencent.biz.qqcircle.f.g()) {
            QLog.d("QFSPersonalDetailsFragment", 1, "handleTransDispatchRecycleViewEvent");
            this.E.setTransDispatchDelegate(new i());
        }
    }

    private void Qh(SimpleBaseEvent simpleBaseEvent) {
        String str;
        int i3;
        if (simpleBaseEvent instanceof QFSFeedPermissionChangeEvent) {
            QFSFeedPermissionChangeEvent qFSFeedPermissionChangeEvent = (QFSFeedPermissionChangeEvent) simpleBaseEvent;
            str = qFSFeedPermissionChangeEvent.getFeedId();
            i3 = qFSFeedPermissionChangeEvent.getRightFlag();
        } else if (simpleBaseEvent instanceof QCircleFeedJSPermissionChangeEvent) {
            QCircleFeedJSPermissionChangeEvent qCircleFeedJSPermissionChangeEvent = (QCircleFeedJSPermissionChangeEvent) simpleBaseEvent;
            str = qCircleFeedJSPermissionChangeEvent.getFeedId();
            i3 = qCircleFeedJSPermissionChangeEvent.getRightFlag();
        } else {
            str = "";
            i3 = -1;
        }
        if (!TextUtils.isEmpty(str)) {
            this.Y.b(simpleBaseEvent, str, i3);
        }
    }

    private void Rh() {
        this.J = new QFSPersonalDetailRefreshHeaderView(getContext());
        BlockContainer blockContainer = this.F.getBlockContainer();
        blockContainer.setEnableLoadMore(false);
        blockContainer.setParentFragment(this);
        blockContainer.setRefreshHeader(this.J);
        blockContainer.setEnableRefresh(li());
        NestScrollRecyclerView recyclerView = blockContainer.getRecyclerView();
        this.E = recyclerView;
        recyclerView.addItemDecoration(new g());
        this.E.addOnScrollListener(new h());
        Ph();
    }

    private void Uh(Bundle bundle) {
        com.tencent.biz.qqcircle.immersive.personal.adapter.b bVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.b(bundle);
        this.I = bVar;
        bVar.setReportBean(getReportBean());
    }

    private void Vh(Bundle bundle) {
        com.tencent.biz.qqcircle.immersive.personal.adapter.j Fh = Fh(bundle);
        this.H = Fh;
        Fh.setReportBean(getReportBean());
        this.H.setOnLoadDataDelegate(new f());
    }

    private boolean Yh() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
        if (rVar != null && rVar.L2() && getClass().equals(QFSPersonalDetailsFragment.class)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.L;
        if (feedCloudMeta$StUser != null) {
            String str = feedCloudMeta$StUser.f398463id.get();
            String str2 = wVar.c().f398463id.get();
            if (com.tencent.biz.qqcircle.immersive.utils.r.e0(str) && !TextUtils.equals(str, str2)) {
                this.L.f398463id.set(str2);
                Xh();
            }
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.P;
        if (tVar != null) {
            tVar.O1().setValue(wVar);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar = this.Q;
        if (cVar != null) {
            cVar.P1().setValue(wVar);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.s sVar = this.R;
        if (sVar != null) {
            sVar.M1().setValue(wVar);
        }
        QFSPersonalDetailRefreshHeaderView qFSPersonalDetailRefreshHeaderView = this.J;
        if (qFSPersonalDetailRefreshHeaderView != null) {
            qFSPersonalDetailRefreshHeaderView.d(wVar);
        }
        QFSPersonalEditViewModel qFSPersonalEditViewModel = this.X;
        if (qFSPersonalEditViewModel != null) {
            qFSPersonalEditViewModel.g2(wVar);
        }
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(UIStateData uIStateData) {
        boolean z16 = true;
        if (uIStateData == null || (uIStateData.getState() != 1 && uIStateData.getState() != 2)) {
            this.H.notifyLoadingComplete(true);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar = this.Q;
        if (cVar == null) {
            return;
        }
        if (uIStateData == null || uIStateData.getData() == null || ((List) uIStateData.getData()).size() < 3) {
            z16 = false;
        }
        cVar.Q1(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ci(String str) {
        f88620g0 = ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).preloadWebView(str, !f88620g0);
    }

    private boolean di() {
        QCircleInitBean qCircleInitBean = this.f88625e0;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || !this.f88625e0.getSchemeAttrs().containsKey(QCircleSchemeAttr.MainPage.IS_SCROLL_TOP)) {
            return false;
        }
        return "1".equals(this.f88625e0.getSchemeAttrs().get(QCircleSchemeAttr.MainPage.IS_SCROLL_TOP));
    }

    private List<MultiViewBlock> fi() {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        Vh(bundle);
        Uh(bundle);
        arrayList.add(this.H);
        arrayList.add(this.I);
        return arrayList;
    }

    private void ji() {
        if (this.f88624d0) {
            return;
        }
        if (!di()) {
            this.f88624d0 = true;
            return;
        }
        NestScrollRecyclerView nestScrollRecyclerView = this.E;
        if (nestScrollRecyclerView == null) {
            QLog.e(getTAG(), 1, "[scrollTop] recycler view is null");
            this.f88624d0 = true;
        } else {
            nestScrollRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalBottomWidget qFSPersonalBottomWidget;
                    if (QFSPersonalDetailsFragment.this.I != null) {
                        qFSPersonalBottomWidget = QFSPersonalDetailsFragment.this.I.j0();
                    } else {
                        qFSPersonalBottomWidget = null;
                    }
                    if (qFSPersonalBottomWidget == null) {
                        QLog.e(QFSPersonalDetailsFragment.this.getTAG(), 1, "[scrollTop] bottom view is null");
                        return;
                    }
                    Context context = QFSPersonalDetailsFragment.this.getContext();
                    if (context == null) {
                        QLog.e(QFSPersonalDetailsFragment.this.getTAG(), 1, "[scrollTop] context is null");
                        return;
                    }
                    qFSPersonalBottomWidget.getLocationOnScreen(new int[2]);
                    int dimension = ((int) ((r4[1] - context.getResources().getDimension(R.dimen.f159414d43)) - ImmersiveUtils.getStatusBarHeight())) * 2;
                    QFSPersonalDetailsFragment qFSPersonalDetailsFragment = QFSPersonalDetailsFragment.this;
                    if (qFSPersonalDetailsFragment.E != null && !qFSPersonalDetailsFragment.f88624d0) {
                        QFSPersonalDetailsFragment.this.E.smoothScrollBy(0, dimension, new AccelerateDecelerateInterpolator(), 400);
                    }
                    QFSPersonalDetailsFragment.this.f88624d0 = true;
                }
            }, 600L);
        }
    }

    private List<QQCircleProfile$QQGroup> ni(QFSPersonalEditViewModel.Group group) {
        ArrayList<Long> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (group != null && !TextUtils.isEmpty(group.showText)) {
            String[] split = group.showText.split("\uff0c");
            if (split != null && (arrayList = group.idList) != null) {
                for (int i3 = 0; i3 < split.length; i3++) {
                    QQCircleProfile$QQGroup qQCircleProfile$QQGroup = new QQCircleProfile$QQGroup();
                    qQCircleProfile$QQGroup.name.set(split[i3]);
                    if (i3 < arrayList.size()) {
                        qQCircleProfile$QQGroup.f429310id.set(arrayList.get(i3).longValue());
                    }
                    arrayList2.add(qQCircleProfile$QQGroup);
                }
                return arrayList2;
            }
            QLog.e("QFSPersonalDetailsFragment", 1, "[updateLocalGroupList] array is null");
        }
        return arrayList2;
    }

    private void oi(QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.P;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.P.N1();
            if (!N1.z()) {
                return;
            }
            try {
                if (qCirclePersonEditUpdateEvent.getGuild() != null) {
                    if (!TextUtils.equals(String.valueOf(qCirclePersonEditUpdateEvent.getGuild().f89125c), N1.b().guildInfo.guildId.get() + "")) {
                        gi(false);
                        RFWLog.i("QFSPersonalDetailsFragment", RFWLog.USR, "oldGuildId = " + N1.b().guildInfo.guildId.get() + " , newId" + qCirclePersonEditUpdateEvent.getGuild().f89125c);
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.e("QFSPersonalDetailsFragment", 1, e16, new Object[0]);
            }
            FeedCloudMeta$StUser c16 = N1.c();
            if (qCirclePersonEditUpdateEvent.getAvatar() != null) {
                c16.icon.iconUrl.set(qCirclePersonEditUpdateEvent.getAvatar().showText);
                QFSPersonalEditViewModel.h2(10025, N1.g(), qCirclePersonEditUpdateEvent.getAvatar());
            }
            if (qCirclePersonEditUpdateEvent.getNick() != null) {
                c16.nick.set(qCirclePersonEditUpdateEvent.getNick().showText);
                QFSPersonalEditViewModel.h2(10001, N1.g(), qCirclePersonEditUpdateEvent.getNick());
            }
            if (qCirclePersonEditUpdateEvent.getGender() != 0) {
                c16.sex.set(qCirclePersonEditUpdateEvent.getGender());
            }
            if (qCirclePersonEditUpdateEvent.getConstellation() != 0) {
                c16.constellation.set(qCirclePersonEditUpdateEvent.getConstellation());
            }
            if (qCirclePersonEditUpdateEvent.getLocation() != null) {
                c16.location.set(qCirclePersonEditUpdateEvent.getLocation().f89126a);
                if (qCirclePersonEditUpdateEvent.getLocation().f89127b != null) {
                    c16.locationCode.set(qCirclePersonEditUpdateEvent.getLocation().f89127b);
                }
            }
            if (qCirclePersonEditUpdateEvent.getDesc() != null) {
                c16.desc.set(qCirclePersonEditUpdateEvent.getDesc().showText);
                QFSPersonalEditViewModel.h2(10008, N1.g(), qCirclePersonEditUpdateEvent.getDesc());
            }
            N1.j("update_version_user_base_info");
            QQCircleBase$StUserBusiData a16 = N1.a();
            if (qCirclePersonEditUpdateEvent.getSchool() != null && a16 != null) {
                if (a16.schoolInfos.size() > 0) {
                    a16.schoolInfos.get(0).name.set(qCirclePersonEditUpdateEvent.getSchool());
                } else {
                    QQCircleBase$UserCircleInfo qQCircleBase$UserCircleInfo = new QQCircleBase$UserCircleInfo();
                    qQCircleBase$UserCircleInfo.name.set(qCirclePersonEditUpdateEvent.getSchool());
                    a16.schoolInfos.add(qQCircleBase$UserCircleInfo);
                }
                N1.p();
            }
            if (qCirclePersonEditUpdateEvent.getCompany() != null && a16 != null) {
                if (a16.companyInfos.size() > 0) {
                    a16.companyInfos.get(0).name.set(qCirclePersonEditUpdateEvent.getCompany());
                } else {
                    QQCircleBase$UserCircleInfo qQCircleBase$UserCircleInfo2 = new QQCircleBase$UserCircleInfo();
                    qQCircleBase$UserCircleInfo2.name.set(qCirclePersonEditUpdateEvent.getCompany());
                    a16.companyInfos.add(qQCircleBase$UserCircleInfo2);
                }
            }
            N1.j("update_version_base_user_busi_data");
            QQCircleProfile$StProfileBizData g16 = N1.g();
            if (qCirclePersonEditUpdateEvent.getGroupInfoList() != null) {
                g16.bind_groups.set(ni(qCirclePersonEditUpdateEvent.getGroupInfoList()));
            }
            if (qCirclePersonEditUpdateEvent.isUpdateShowSchool()) {
                g16.hideSchool.set(!qCirclePersonEditUpdateEvent.getShowSchool() ? 1 : 0);
            }
            N1.j("update_version_profile_biz");
            this.P.O1().setValue(N1);
            this.L = N1.c();
            QFSPersonalEditViewModel qFSPersonalEditViewModel = this.X;
            if (qFSPersonalEditViewModel != null) {
                qFSPersonalEditViewModel.g2(N1);
            }
        }
    }

    private void showLoading(String str) {
        if (this.f88621a0 == null) {
            this.f88621a0 = new QCircleLoadingDialog(getContext());
        }
        this.f88621a0.S(str);
        ImageView U = this.f88621a0.U();
        U.setVisibility(0);
        U.setOnClickListener(new a());
        if (!getActivity().isFinishing()) {
            this.f88621a0.showDialog();
        }
    }

    protected com.tencent.biz.qqcircle.immersive.personal.adapter.j Fh(Bundle bundle) {
        return new com.tencent.biz.qqcircle.immersive.personal.adapter.j(bundle);
    }

    public String Hh() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return null;
    }

    public String Ih() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null) {
            return bh.d(feedCloudMeta$StFeed.extInfo.get(), "feed_trans_recom_traceid");
        }
        return null;
    }

    public NestScrollRecyclerView Jh() {
        return this.E;
    }

    protected void Nh(int i3) {
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean != null && qCircleInitBean.getFromReportBean() != null && qCircleInitBean.getFeed() != null && "pg_xsj_explore_page".equals(qCircleInitBean.getFromReportBean().getDtPageId())) {
            QFSPersonalConsumeTimeManager.e().d(qCircleInitBean.getFeed(), qCircleInitBean.getUin(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sh(Intent intent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (!(serializableExtra instanceof QCircleInitBean)) {
                QLog.i("QFSPersonalDetailsFragment", 1, "InitBean is not FSPersonalDetailBean");
                return;
            }
            QCircleInitBean qCircleInitBean = (QCircleInitBean) serializableExtra;
            if (qCircleInitBean.getFeed().has()) {
                feedCloudMeta$StFeed = qCircleInitBean.getFeed();
            } else {
                feedCloudMeta$StFeed = this.K;
            }
            this.K = feedCloudMeta$StFeed;
            if (qCircleInitBean.getUser().has()) {
                feedCloudMeta$StUser = qCircleInitBean.getUser();
            } else {
                feedCloudMeta$StUser = this.L;
            }
            this.L = feedCloudMeta$StUser;
            this.f88625e0 = qCircleInitBean;
            return;
        }
        QLog.i("QFSPersonalDetailsFragment", 1, "InitBean is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Th() {
        this.N.w2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalDetailsFragment.this.ai((com.tencent.biz.qqcircle.immersive.personal.data.w) obj);
            }
        });
        this.N.k2().observe(this, new c());
        this.N.o2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalDetailsFragment.this.bi((UIStateData) obj);
            }
        });
        this.N.h2().observe(this, new d());
        this.X.N1().observe(this, new e());
    }

    protected void Wh() {
        new HashMap().put(QFSGetMainPageBasicDataRequest.NEED_TC_RED_DOT, "1");
        hi(true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xh() {
        int i3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null && (this.L == null || TextUtils.equals(feedCloudMeta$StFeed.poster.f398463id.get(), this.L.f398463id.get()))) {
            this.N.h3(this.K);
        } else {
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.L;
            if (feedCloudMeta$StUser != null) {
                this.N.i3(feedCloudMeta$StUser, true);
            }
        }
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null) {
            i3 = qCircleInitBean.getClientFromType();
        } else {
            i3 = 0;
        }
        this.f88622b0 = i3;
        this.T.X1(this.N.i2(), ErrorCode.ERROR_APPID_NOT_FOUND);
        this.U.X1(this.N.i2(), ErrorCode.ERROR_VERIFY_FAILED);
        this.V.setUin(this.N.i2());
    }

    public boolean Zh() {
        return false;
    }

    public List<Part> assembleParts() {
        ArrayList<Part> arrayList = new ArrayList<>();
        QFSBaseBlockPart qFSBaseBlockPart = new QFSBaseBlockPart(R.id.vg8, fi(), 3, 1);
        this.F = qFSBaseBlockPart;
        arrayList.add(qFSBaseBlockPart);
        arrayList.add(new br());
        if (li()) {
            Dh(arrayList);
            arrayList.add(new ar());
            arrayList.add(new aq());
            as asVar = new as();
            this.M = asVar;
            arrayList.add(asVar);
            ad adVar = new ad();
            this.G = adVar;
            arrayList.add(adVar);
        }
        return arrayList;
    }

    public void ei(final String str) {
        if (uq3.c.v2()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalDetailsFragment.ci(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        int i3;
        String str;
        HashMap hashMap = new HashMap();
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.L;
        if (feedCloudMeta$StUser != null) {
            if (com.tencent.biz.qqcircle.immersive.utils.r.u0(feedCloudMeta$StUser)) {
                str = "host";
            } else {
                str = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.L;
        if (feedCloudMeta$StUser2 != null && !TextUtils.isEmpty(feedCloudMeta$StUser2.f398463id.get())) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST, this.L.f398463id.get());
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_WHETHER_IMMERSE_VERSION, "yes");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_ENTRYMODE, 2);
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
        if (rVar != null && rVar.v2() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w v26 = this.N.v2();
            int i16 = 0;
            if (v26.a().fuelRedPointCount.get() > 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOTNUM_ENTER_IF_REDDOT, Integer.valueOf(i3));
            if (com.tencent.biz.qqcircle.immersive.utils.r.b0() && v26.e().pushBoxInfo.unopendPushBoxCount.get() > 0) {
                i16 = 1;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSHED_TAB_IF_REDDOT, Integer.valueOf(i16));
        }
        if (Zh()) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_HALFPAGE, 1);
        }
        mi(hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gln;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "pg_xsj_profile_page";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCirclePersonEditUpdateEvent.class);
        eventClass.add(QCircleFeedEvent.class);
        eventClass.add(QFSDoTopProfileEvent.class);
        eventClass.add(QFSPersonalDetailRefreshEvent.class);
        eventClass.add(QFSFeedPermissionChangeEvent.class);
        eventClass.add(QCircleFeedJSPermissionChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalDetailsFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED;
    }

    protected void gi(boolean z16) {
        hi(z16, null);
    }

    protected void hi(boolean z16, HashMap<String, String> hashMap) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
        if (rVar != null && this.W != null) {
            rVar.f3(this.f88622b0);
            if (this.N.L2()) {
                QLog.d("QFSPersonalDetailsFragment", 1, "refreshData, start ");
                this.W.P1(new b(z16, hashMap));
            } else {
                this.N.T2(z16);
            }
        }
        if (Yh()) {
            QFSHodorCollectManager.f84689a.b("qfs_personal_page_begin_business");
        }
    }

    protected void ii() {
        if (this.N == null) {
            return;
        }
        w20.a.j().registerDisplaySurface(this.N.y2(), this.N);
    }

    protected void initViewModel() {
        this.N = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.P = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.Q = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.c) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.c.class);
        this.R = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.s) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.s.class);
        this.S = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.e) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.e.class);
        this.T = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.d) getViewModel("key_prefix_praised", com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
        this.U = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.d) getViewModel("key_prefix_pushed", com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
        this.V = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.j) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.j.class);
        this.W = (QFSDraftViewModel) getViewModel(QFSDraftViewModel.class);
        this.X = (QFSPersonalEditViewModel) getViewModel(QFSPersonalEditViewModel.class);
        WinkPublishHelper2.INSTANCE.bindService(1, null);
    }

    public boolean isLazyLoad() {
        return false;
    }

    public void ki(int i3) {
        this.f88622b0 = i3;
    }

    protected boolean li() {
        return true;
    }

    public void load() {
        initViewModel();
        Th();
        Xh();
        ii();
        Wh();
    }

    public void mi(@NonNull Map<String, Object> map) {
        String Ih = Ih();
        if (!TextUtils.isEmpty(Ih)) {
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_TRANS_TRACEID, Ih);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent != null && i3 == 10000 && i16 == -1) {
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            QLog.d("QFSPersonalDetailsFragment", 1, "onActivityResult... path:" + stringExtra);
            QFSPersonalEditViewModel qFSPersonalEditViewModel = this.X;
            if (qFSPersonalEditViewModel != null) {
                qFSPersonalEditViewModel.c2(stringExtra);
                showLoading(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
            } else {
                QLog.w("QFSPersonalDetailsFragment", 1, "mPersonalEditViewModel == null");
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Sh(getActivity().getIntent());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.biz.qqcircle.immersive.personal.adapter.b bVar = this.I;
        if (bVar != null) {
            bVar.i0();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Y.i(new j());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.Z = DisplayUtil.getScreenHeight();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.qqcircle.immersive.personal.adapter.b bVar = this.I;
        if (bVar != null) {
            bVar.release();
        }
        QFSPersonalEditViewModel qFSPersonalEditViewModel = this.X;
        if (qFSPersonalEditViewModel != null) {
            qFSPersonalEditViewModel.d2();
        }
        Nh(2);
        this.Y.j();
        QFSPersonalTabIndexManager.f88726a.i();
        if (Yh()) {
            QFSHodorCollectManager.f84689a.b("qfs_personal_page_end_business");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.d("QFSPersonalDetailsFragment", 1, "fs_lifecycle onPause");
        Nh(1);
        Gh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSDoTopProfileEvent) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
            if (rVar != null) {
                rVar.C = true;
            }
            QFSDoTopProfileEvent qFSDoTopProfileEvent = (QFSDoTopProfileEvent) simpleBaseEvent;
            this.Y.a(qFSDoTopProfileEvent.mTargetFeedId, qFSDoTopProfileEvent.isDoProfile);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePersonEditUpdateEvent) {
            oi((QCirclePersonEditUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            Kh((QCircleFeedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSPersonalDetailRefreshEvent) {
            Oh((QFSPersonalDetailRefreshEvent) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSFeedPermissionChangeEvent) || (simpleBaseEvent instanceof QCircleFeedJSPermissionChangeEvent)) {
            Qh(simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @RFWTestDataSource(key = "personal_recycler_view", objName = "mRecyclerView")
    public void onResume() {
        super.onResume();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.N;
        if (rVar != null && rVar.C) {
            rVar.C = false;
            gi(false);
        }
        if (QFSPersonalTabIndexManager.f88726a.h() && com.tencent.biz.qqcircle.immersive.utils.r.u0(this.L)) {
            this.Y.c();
        }
        QLog.d("QFSPersonalDetailsFragment", 1, "fs_lifecycle onResume");
        Nh(0);
        ei(uq3.c.T2());
        this.f88623c0 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Rh();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        this.mReportBean.setPageId(getPageId());
        this.mReportBean.setDtPageId(getDaTongPageId());
        if (getQCircleInitBean() != null && getQCircleInitBean().getFromReportBean() != null) {
            this.mReportBean.setFromPageId(getQCircleInitBean().getFromReportBean().getPageId());
        }
        return this.mReportBean;
    }
}
