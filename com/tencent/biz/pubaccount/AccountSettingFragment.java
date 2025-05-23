package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.handler.PublicAccountSettingHandler;
import com.tencent.biz.pubaccount.setting.EnumSettingGroupId;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.pb.oac.OACProfilePb$ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountSettingFragment extends QIphoneTitleBarFragment {
    private MqqHandler C;
    private QQAppInterface D;
    private String E;
    private String F;
    private Integer G;
    private PublicAccountDetailImpl H;
    private Checkable I;
    private Checkable J;
    private com.tencent.biz.pubaccount.setting.a K;
    private View.OnClickListener L = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountSettingFragment.this.Sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountSettingFragment.this.Rh();
        }
    }

    private Group Dh() {
        x.c.f fVar = new x.c.f(false, null);
        fVar.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.biz.pubaccount.c
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountSettingFragment.this.Lh(view);
            }
        });
        return new Group("", "", new com.tencent.biz.pubaccount.setting.b(EnumSettingGroupId.FOLD.ordinal(), new x.b.d("\u6536\u6298\u516c\u4f17\u53f7"), fVar));
    }

    private Group Eh() {
        x.c.f fVar = new x.c.f(false, null);
        fVar.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.biz.pubaccount.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountSettingFragment.this.Mh(view);
            }
        });
        return new Group("", ((QIphoneTitleBarFragment) this).mContentView.getResources().getText(R.string.z5m), new com.tencent.biz.pubaccount.setting.b(EnumSettingGroupId.ACCEPT_MSG.ordinal(), new x.b.d(((QIphoneTitleBarFragment) this).mContentView.getResources().getText(R.string.z5n)), fVar));
    }

    private Group Fh() {
        com.tencent.biz.pubaccount.setting.b bVar = new com.tencent.biz.pubaccount.setting.b(EnumSettingGroupId.MARKET_NOTIFICATION.ordinal(), new x.b.d(((QIphoneTitleBarFragment) this).mContentView.getResources().getText(R.string.z5o)), new x.c.g("", true, false));
        bVar.x(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSettingFragment.this.Nh(view);
            }
        });
        return new Group("", "", bVar);
    }

    private Group[] Gh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Eh());
        if (Kh()) {
            arrayList.add(Dh());
        }
        if ("3593944551".equals(this.E)) {
            arrayList.add(Fh());
        }
        return (Group[]) arrayList.toArray(new Group[arrayList.size()]);
    }

    private void Hh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    private void Ih() {
        if (IPublicAccountUtil.UIN_FOR_SHOP.equals(this.E)) {
            this.K = ((IQQShopApi) QRoute.api(IQQShopApi.class)).getQQShopSettingDelegate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view == null) {
            return;
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) view.findViewById(R.id.s8h);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        com.tencent.biz.pubaccount.setting.a aVar = this.K;
        if (aVar != null) {
            aVar.a(qUIListItemAdapter, Gh());
        } else {
            qUIListItemAdapter.t0(Gh());
        }
    }

    private boolean Kh() {
        return this.H != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isPublicAccountFolderSettingShow(this.H.accountFlag2) && com.tencent.biz.pubaccount.util.j.INSTANCE.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void Lh(View view) {
        if (view instanceof Checkable) {
            view.setOnClickListener(new c());
            this.J = (Checkable) view;
            Wh();
            Uh("dt_imp", this.J.isChecked() ? 1 : 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void Mh(View view) {
        if (view instanceof Checkable) {
            view.setOnClickListener(this.L);
            this.I = (Checkable) view;
            Wh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(View view) {
        Hh("https://speed.gamecenter.qq.com/pushgame/v1/ark-notification-switch?_wv=134&_wwv=2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(boolean z16) {
        Checkable checkable = this.J;
        if (checkable != null) {
            checkable.setChecked(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(boolean z16, boolean z17, int i3, String str, Object obj) {
        if (z17) {
            this.H.accountFlag2 = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).setInPublicAccountFolder(this.H.accountFlag2, z16);
            Vh(this.H);
        }
        final boolean isInPublicAccountFolder = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isInPublicAccountFolder(this.H.accountFlag2);
        if (z17) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.g
            @Override // java.lang.Runnable
            public final void run() {
                AccountSettingFragment.this.Oh(isInPublicAccountFolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Qh(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        if (this.G.intValue() == 1) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageOpenReceiveMessage(this.D, qCirclePublicAccountMessageInfo);
            return null;
        }
        ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageCloseReceiveMessage(this.D, qCirclePublicAccountMessageInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        Checkable checkable;
        if (this.H == null) {
            return;
        }
        PublicAccountSettingHandler publicAccountSettingHandler = (PublicAccountSettingHandler) this.D.getBusinessHandler(PublicAccountSettingHandler.class.getName());
        if (publicAccountSettingHandler != null && (checkable = this.J) != null) {
            final boolean isChecked = checkable.isChecked();
            publicAccountSettingHandler.L2(Long.parseLong(this.E), isChecked ? 2L : 3L, new ey.a() { // from class: com.tencent.biz.pubaccount.f
                @Override // ey.a
                public final void i(boolean z16, int i3, String str, Object obj) {
                    AccountSettingFragment.this.Ph(isChecked, z16, i3, str, obj);
                }
            });
            Uh("dt_clck", isChecked ? 1 : 2);
            return;
        }
        QLog.w("AccountSettingFragment", 1, "onFoldSettingChanged: settingHandler or mFoldSettingSwitch is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        AppletsHandler appletsHandler;
        Checkable checkable;
        if (this.H == null || (appletsHandler = (AppletsHandler) this.D.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)) == null || (checkable = this.I) == null) {
            return;
        }
        boolean isChecked = checkable.isChecked();
        QLog.d("AccountSettingFragment", 1, "onMessageSettingChanged check:" + isChecked);
        this.G = Integer.valueOf(isChecked ? 1 : 3);
        appletsHandler.T2(this.E, this.F, this.I.isChecked() ? 1 : 0);
        PublicAccountUtilImpl.setMessageSetting(this.H, this.G.intValue());
        PublicAccountDetailImpl publicAccountDetailImpl = this.H;
        publicAccountDetailImpl.isRecvPush = isChecked;
        publicAccountDetailImpl.isRecvMsg = isChecked;
        Vh(publicAccountDetailImpl);
        if (this.G.intValue() == 1) {
            xx.b.INSTANCE.t(this.E);
        } else {
            xx.b.INSTANCE.u(this.E);
        }
        if (TextUtils.equals(this.E, AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN)) {
            ((IQCirclePublicAccountMessageService) this.D.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1() { // from class: com.tencent.biz.pubaccount.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Qh;
                    Qh = AccountSettingFragment.this.Qh((QCirclePublicAccountMessageInfo) obj);
                    return Qh;
                }
            });
        }
    }

    private void Th() {
        if (((QIphoneTitleBarFragment) this).mContentView == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_official_accounts_setting");
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
    }

    private void Uh(String str, int i3) {
        Checkable checkable = this.J;
        if (checkable == null) {
            return;
        }
        VideoReport.setElementId(checkable, "em_bas_folding_public_account_assistant_switch");
        VideoReport.setElementClickPolicy(this.J, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.J, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_official_accounts_setting");
        hashMap.put("after_click_state", Integer.valueOf(i3));
        VideoReport.reportEvent(str, this.J, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(PublicAccountDetailImpl publicAccountDetailImpl) {
        EntityManager createEntityManager = this.D.getEntityManagerFactory().createEntityManager();
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.H;
        if (publicAccountDetailImpl2 != null && publicAccountDetailImpl2.getId() != -1) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountSettingFragment", 2, publicAccountDetailImpl.name);
            }
            this.H.clone(publicAccountDetailImpl);
            if (!createEntityManager.update(this.H)) {
                createEntityManager.drop(PublicAccountDetailImpl.class);
            }
        } else {
            this.H = publicAccountDetailImpl;
            createEntityManager.persist(publicAccountDetailImpl);
        }
        createEntityManager.close();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.D.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            iPublicAccountDataManager.saveAccountDetailInfoCache(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.H;
        if (publicAccountDetailImpl == null) {
            return;
        }
        this.G = PublicAccountUtilImpl.getMessageSetting(publicAccountDetailImpl);
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.H;
        boolean z16 = publicAccountDetailImpl2.isRecvMsg && publicAccountDetailImpl2.isRecvPush;
        Checkable checkable = this.I;
        if (checkable != null) {
            checkable.setChecked(z16);
        }
        if (this.J != null) {
            this.J.setChecked(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isInPublicAccountFolder(this.H.accountFlag2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.C.post(new Runnable() { // from class: com.tencent.biz.pubaccount.AccountSettingFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    AccountSettingFragment.this.Jh();
                    AccountSettingFragment.this.Wh();
                }
            });
        } else {
            Jh();
            Wh();
        }
    }

    private void loadData() {
        com.tencent.biz.pubaccount.setting.a aVar = this.K;
        if (aVar != null) {
            aVar.b(this.E, this.F);
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.D.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            this.H = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfoCache(this.E);
            Xh();
        }
        if (this.H == null) {
            PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(this.E)), null, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getQBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            this.D = (QQAppInterface) getQBaseActivity().getAppRuntime();
        }
        Bundle arguments = getArguments();
        this.E = arguments.getString("uin");
        this.F = arguments.getString("name");
        this.C = new MqqHandler(Looper.getMainLooper());
        Ih();
        loadData();
        Th();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fsd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public View onCreateCenterView() {
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getString(R.string.f1764931e));
        return onCreateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements PublicAccountStQWebServletWrapper.b<OACProfilePb$ProfileDataRsp> {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i3, boolean z16, OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp, Bundle bundle) {
            if (z16) {
                AccountSettingFragment.this.H = new PublicAccountDetailImpl(oACProfilePb$ProfileDataRsp);
                AccountSettingFragment accountSettingFragment = AccountSettingFragment.this;
                accountSettingFragment.Vh(accountSettingFragment.H);
                AccountSettingFragment.this.Xh();
            }
        }
    }
}
