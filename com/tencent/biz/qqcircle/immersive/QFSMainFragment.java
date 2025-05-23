package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.ad;
import com.tencent.biz.qqcircle.bizparts.bb;
import com.tencent.biz.qqcircle.bizparts.bq;
import com.tencent.biz.qqcircle.bizparts.bv;
import com.tencent.biz.qqcircle.bizparts.bz;
import com.tencent.biz.qqcircle.bizparts.de;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.part.QFSActivityDialogPart;
import com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerAlbumPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushBoxSharePart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart;
import com.tencent.biz.qqcircle.immersive.part.QFSSpringFestivalActivityDialogPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTeenModePopWindowPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTopPopShareBannerPart;
import com.tencent.biz.qqcircle.immersive.part.ak;
import com.tencent.biz.qqcircle.immersive.part.au;
import com.tencent.biz.qqcircle.immersive.part.bm;
import com.tencent.biz.qqcircle.immersive.part.cn;
import com.tencent.biz.qqcircle.immersive.part.co;
import com.tencent.biz.qqcircle.immersive.part.cp;
import com.tencent.biz.qqcircle.immersive.part.cs;
import com.tencent.biz.qqcircle.immersive.part.fa;
import com.tencent.biz.qqcircle.immersive.part.fg;
import com.tencent.biz.qqcircle.immersive.part.fk;
import com.tencent.biz.qqcircle.immersive.part.ge;
import com.tencent.biz.qqcircle.immersive.part.p;
import com.tencent.biz.qqcircle.immersive.part.publishprogress.r;
import com.tencent.biz.qqcircle.immersive.part.push.QFSPushRocketChargeTipsPart;
import com.tencent.biz.qqcircle.immersive.part.s;
import com.tencent.biz.qqcircle.immersive.part.t;
import com.tencent.biz.qqcircle.immersive.part.teenmode.QFSTeenModeAntiAddictionTipsPart;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.immersive.utils.al;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.tip.AnchorRelativePopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMainFragment extends QFSBaseFragment implements t40.d {
    private List<Part> E;
    private QFSMainMultiTabFragmentPart F;
    private x50.g G;
    private x50.e H;
    private QFSSharePart I;
    private QFSTopPopBannerPart J;
    private QCircleLightInteractListPart K;
    private QCircleRichMediaDownLoadPart L;
    private au M;
    private r N;
    private s P;
    private QFSTopPopShareBannerPart Q;
    private QFSMainShoppingCartPart R;
    private QFSPushBoxSharePart S;
    private fg T;
    private t U;
    private int V = 3;
    private final QCircleToast.a W = new QCircleToast.a() { // from class: com.tencent.biz.qqcircle.immersive.e
        @Override // com.tencent.biz.qqcircle.proxy.delegate.QCircleToast.a
        public final void a(Toast toast, long j3) {
            QFSMainFragment.this.uh(toast, j3);
        }
    };
    private final AnchorRelativePopupWindow.a X = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements AnchorRelativePopupWindow.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.tip.AnchorRelativePopupWindow.a
        public void dismiss(PopupWindow popupWindow) {
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSMainFragment.this.getContext());
            if (x16 != null) {
                x16.j(popupWindow);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.AnchorRelativePopupWindow.a
        public void show(PopupWindow popupWindow) {
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSMainFragment.this.getContext());
            if (x16 != null) {
                x16.c(popupWindow);
            }
        }
    }

    private void sh(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        String str;
        String contextHashCode;
        String group;
        if (!ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey())) {
            return;
        }
        if (this.G == null && this.H == null) {
            return;
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            QLog.d(getTAG(), 1, "qcircle onTabSelect");
            x50.g gVar = this.G;
            if (gVar != null) {
                contextHashCode = gVar.getContextHashCode();
            } else {
                contextHashCode = this.H.getContextHashCode();
            }
            x50.g gVar2 = this.G;
            if (gVar2 != null) {
                group = gVar2.getGroup();
            } else {
                group = this.H.getGroup();
            }
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(contextHashCode, group);
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            str = "_begin_business";
        } else {
            str = "_end_business";
        }
        QFSHodorCollectManager.f84689a.b("qfs_qcircle" + str);
    }

    private void th() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(new z70.b(getContext(), "folder_pendant", 105));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(Toast toast, long j3) {
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
        if (x16 != null) {
            x16.d(toast, j3);
        }
    }

    private void vh() {
        if (!QCirclePluginUtil.isTabMode()) {
            QLog.e("QFSMainFragment", 4, "preInflateViews pass,is not tab mode");
            return;
        }
        if (!l30.a.a().b()) {
            QLog.e("QFSMainFragment", 4, "preInflateViews pass,don't support async inflate");
            return;
        }
        if (getContext() == null) {
            return;
        }
        RFWLayoutPreLoader layoutLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
        layoutLoader.preloadView(getContext(), R.layout.glh, 3);
        layoutLoader.preloadView(getContext(), R.layout.gj7, 1);
        layoutLoader.preloadView(getContext(), R.layout.g4l, 1);
        layoutLoader.preloadView(getContext(), R.layout.gj9, 1);
        layoutLoader.preloadView(getContext(), R.layout.gj8, 1);
        layoutLoader.preloadView(getContext(), R.layout.g4m, 1);
        layoutLoader.preloadView(getContext(), R.layout.gjd, 1);
        layoutLoader.preloadView(getContext(), R.layout.g4p, 1);
        layoutLoader.preloadView(getContext(), R.layout.g4o, 1);
        layoutLoader.preloadView(getContext(), R.layout.f168689ge4, 1);
        QLog.d("QFSMainFragment", 1, "preInflateFolderFragments done");
    }

    @Override // t40.d
    public void Te(boolean z16) {
        QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = this.F;
        if (qFSMainMultiTabFragmentPart != null) {
            qFSMainMultiTabFragmentPart.Te(z16);
        }
    }

    @Override // t40.d
    public boolean Uf() {
        QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = this.F;
        if (qFSMainMultiTabFragmentPart != null) {
            return qFSMainMultiTabFragmentPart.Uf();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        if (this.E == null) {
            ArrayList arrayList = new ArrayList();
            this.E = arrayList;
            arrayList.add(new cn());
            this.E.add(new cs());
            this.E.add(new fa(this.V));
            QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = new QFSMainMultiTabFragmentPart();
            this.F = qFSMainMultiTabFragmentPart;
            this.E.add(qFSMainMultiTabFragmentPart);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_apng_anime_adpart", true)) {
                x50.e eVar = new x50.e();
                this.H = eVar;
                this.E.add(eVar);
            } else {
                x50.g gVar = new x50.g();
                this.G = gVar;
                this.E.add(gVar);
            }
            QFSSharePart qFSSharePart = new QFSSharePart();
            this.I = qFSSharePart;
            this.E.add(qFSSharePart);
            t tVar = new t();
            this.U = tVar;
            this.E.add(tVar);
            this.E.add(new QFSPersonalPanelPart());
            this.E.add(new bq());
            this.E.add(new bv());
            this.E.add(new bz());
            this.E.add(new QFSReportBottomSheetPart());
            com.tencent.biz.qqcircle.helpers.f.f84618a.a(this.E, this, true);
            this.E.add(new QFSLayerAlbumPanelPart());
            this.E.add(new ad());
            this.E.add(new QFSEmojiCommentPanelPart());
            this.E.add(new cp());
            this.E.add(new de());
            this.E.add(new bb());
            QLog.d("QFSMainFragment", 1, "assembleParts, mUIType: " + this.V);
            fg fgVar = new fg();
            this.T = fgVar;
            this.E.add(fgVar);
            this.E.add(new ak());
            au auVar = new au();
            this.M = auVar;
            this.E.add(auVar);
            if (this.V == 3) {
                r rVar = new r(0);
                this.N = rVar;
                this.E.add(rVar);
            }
            QFSTopPopBannerPart qFSTopPopBannerPart = new QFSTopPopBannerPart();
            this.J = qFSTopPopBannerPart;
            this.E.add(qFSTopPopBannerPart);
            if (!"".equals(uq3.c.U3())) {
                QFSTopPopShareBannerPart qFSTopPopShareBannerPart = new QFSTopPopShareBannerPart();
                this.Q = qFSTopPopShareBannerPart;
                this.E.add(qFSTopPopShareBannerPart);
            }
            QFSPushBoxSharePart qFSPushBoxSharePart = new QFSPushBoxSharePart();
            this.S = qFSPushBoxSharePart;
            this.E.add(qFSPushBoxSharePart);
            QFSMainShoppingCartPart qFSMainShoppingCartPart = new QFSMainShoppingCartPart();
            this.R = qFSMainShoppingCartPart;
            this.E.add(qFSMainShoppingCartPart);
            QCircleLightInteractListPart qCircleLightInteractListPart = new QCircleLightInteractListPart();
            this.K = qCircleLightInteractListPart;
            qCircleLightInteractListPart.setReportBeanAgent(this);
            this.E.add(this.K);
            QCircleRichMediaDownLoadPart qCircleRichMediaDownLoadPart = new QCircleRichMediaDownLoadPart();
            this.L = qCircleRichMediaDownLoadPart;
            this.E.add(qCircleRichMediaDownLoadPart);
            s sVar = new s();
            this.P = sVar;
            this.E.add(sVar);
            this.E.add(new QFSPushRocketProgressPart());
            this.E.add(new com.tencent.biz.qqcircle.immersive.part.push.a());
            this.E.add(new QFSPushRocketChargeTipsPart());
            this.E.add(new com.tencent.biz.qqcircle.immersive.part.teenmode.b());
            this.E.add(new QFSTeenModeAntiAddictionTipsPart());
            this.E.add(new QFSTeenModePopWindowPart());
            this.E.add(new QFSActivityDialogPart(new Supplier() { // from class: com.tencent.biz.qqcircle.immersive.f
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    return Integer.valueOf(QFSMainFragment.this.getPageId());
                }
            }, new Supplier() { // from class: com.tencent.biz.qqcircle.immersive.g
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    return QFSMainFragment.this.getDaTongPageId();
                }
            }));
            this.E.add(new p(new Supplier() { // from class: com.tencent.biz.qqcircle.immersive.f
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    return Integer.valueOf(QFSMainFragment.this.getPageId());
                }
            }, new Supplier() { // from class: com.tencent.biz.qqcircle.immersive.g
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    return QFSMainFragment.this.getDaTongPageId();
                }
            }));
            this.E.add(new ge());
            this.E.add(new QFSTagPolymerizationTaskDoneDialogPart());
            com.tencent.biz.qqcircle.immersive.layer.base.b.a(this.E);
            this.E.add(new QFSSpringFestivalActivityDialogPart(new Supplier() { // from class: com.tencent.biz.qqcircle.immersive.g
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    return QFSMainFragment.this.getDaTongPageId();
                }
            }));
            this.E.add(new co());
            this.E.add(new fk());
            this.E.add(new bm());
        }
        return this.E;
    }

    @Override // t40.d
    public int getActivityHashCode() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.hashCode();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gho;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        if (this.F != null && uq3.c.d0()) {
            return this.F.Ma();
        }
        if (getPageId() == 501) {
            return QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE;
        }
        if (getPageId() == 503) {
            return "pg_xsj_explore_page";
        }
        if (getPageId() == 504) {
            return "pg_xsj_friendtab_explore_page";
        }
        if (getPageId() == 591) {
            return QCircleDaTongConstant.PageId.PG_XSJ_NEARBY_PAGE;
        }
        if (getPageId() == Integer.MAX_VALUE) {
            return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_SELECTED_PAGE;
        }
        return super.getDaTongPageId();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = this.F;
        if (qFSMainMultiTabFragmentPart != null) {
            return qFSMainMultiTabFragmentPart.Na();
        }
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // t40.d
    public int lc() {
        QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = this.F;
        if (qFSMainMultiTabFragmentPart == null) {
            return 0;
        }
        return qFSMainMultiTabFragmentPart.Oa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QCircleEeveeMananger.getInstance().onSend(5, null, null);
        vh();
        th();
        QFSHodorCollectManager.f84689a.b("qfs_qcircle_begin_business");
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        QLog.d(getTAG(), 1, "onHiddenChanged " + z16);
        if (z16) {
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_HIDDEN);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d(getTAG(), 1, "fs_lifecycle onPause");
        QCircleToast.x(this.W);
        AnchorRelativePopupWindow.j(this.X);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_PAGE_ON_PAUSE);
        super.onPause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            sh((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d(getTAG(), 1, "fs_lifecycle onResume");
        QCircleToast.q(this.W);
        AnchorRelativePopupWindow.g(this.X);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        registerIoc(view, this, t40.d.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QCircleHostGlobalInfo.setFolderUIType(this.V);
        al.b(((QCircleBaseFragment) this).mContentView);
    }

    public void wh(int i3) {
        this.V = i3;
        QCircleHostGlobalInfo.setFolderUIType(i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        this.mReportBean.setPageId(getPageId());
        this.mReportBean.setDtPageId(getDaTongPageId());
        return this.mReportBean;
    }
}
