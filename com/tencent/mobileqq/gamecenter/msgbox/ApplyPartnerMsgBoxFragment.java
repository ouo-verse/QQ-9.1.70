package com.tencent.mobileqq.gamecenter.msgbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.activity.recent.gamemsgbox.af;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneShareManager;
import ie1.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class ApplyPartnerMsgBoxFragment extends IphoneTitleBarFragment {
    protected BaseActivity C;
    private af D;
    private DragFrameLayout E;
    private NTChatRecyclerViewWithHeaderFooter F;
    private DragFrameLayout G;
    private b H = new a(hashCode());

    /* loaded from: classes33.dex */
    class a extends b {
        a(int i3) {
            super(i3);
        }

        @Override // ie1.b
        public void d(Object obj) {
            super.d(obj);
            QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, " game usr info change notify.");
            ApplyPartnerMsgBoxFragment.this.uh();
        }

        @Override // ie1.b
        public void t() {
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, " onSetSwitchCallback ");
            }
            ApplyPartnerMsgBoxFragment.this.uh();
            ApplyPartnerMsgBoxFragment.this.vh();
        }
    }

    private void initTitleBar() {
        setTitle(this.C.getString(R.string.f199264oy));
    }

    private void sh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((IphoneTitleBarFragment) this).mContentView, "pg_gb_company_message");
    }

    private void th() {
        if (QLog.isColorLevel()) {
            QLog.e("ApplyPartnerMsgBoxFragment", 2, "initListView");
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17550l);
        this.E = dragFrameLayout;
        dragFrameLayout.setId(R.id.evx);
        this.E.setVisibility(0);
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter = (NTChatRecyclerViewWithHeaderFooter) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f17440a);
        this.F = nTChatRecyclerViewWithHeaderFooter;
        nTChatRecyclerViewWithHeaderFooter.setId(R.id.tug);
        this.F.C(View.inflate(this.C, R.layout.f167783hc, null));
        VideoReport.setElementId(this.E, "pg_gb_company_item_message");
        if (this.G == null) {
            this.G = DragFrameLayout.e(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        this.D.B9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        DragFrameLayout dragFrameLayout = this.E;
        if (dragFrameLayout != null) {
            dragFrameLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        af afVar = new af(getQBaseActivity(), ((IphoneTitleBarFragment) this).mContentView, 3);
        this.D = afVar;
        arrayList.add(afVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        sh();
        ((IGameReportApi) QRoute.api(IGameReportApi.class)).clearLastReportApplyPartnerData();
        th();
        initTitleBar();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        qQAppInterface.addObserver(this.H);
        ((IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class)).addUserInfoChangedObserver(this.H);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(QZoneShareManager.GLORY_OF_KINGS, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92050", "928868", "", "", "7", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127168;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = getBaseActivity();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ((IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class)).removeUserInfoChangedObserver(this.H);
        qQAppInterface.removeObserver(this.H);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        uh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (AppSetting.t(getContext())) {
            View findViewById = view.findViewById(R.id.rlCommenTitle);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            layoutParams.height += statusBarHeight;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setPadding(0, statusBarHeight, 0, 0);
        }
    }
}
