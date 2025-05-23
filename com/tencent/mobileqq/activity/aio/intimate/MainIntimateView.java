package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView;
import com.tencent.mobileqq.activity.aio.intimate.header.n;
import com.tencent.mobileqq.activity.aio.intimate.k;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantGiftView;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantLoveEntranceView;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantNovelSpeciesView;
import com.tencent.mobileqq.activity.aio.intimate.view.ElegantSpecialWordView;
import com.tencent.mobileqq.activity.aio.intimate.view.GenericCardGroupView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView;
import com.tencent.mobileqq.activity.aio.zplan.IntimateUpgradeBannerView;
import com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateContentItemFriendInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MainIntimateView implements Handler.Callback {

    /* renamed from: h0, reason: collision with root package name */
    private static com.tencent.mobileqq.friends.intimate.e f178894h0 = new b();
    protected Handler C;
    protected int D;
    protected View H;
    protected View I;
    protected MainIntimateTitlePart J;
    private QQProgressDialog K;
    public IntimateHeaderView L;
    public ZPlanIntimateContentItemFriendInfoView M;
    public IntimateElegantCardView N;
    private GenericCardGroupView P;
    private ElegantSpecialWordView Q;
    private IntimateContentItemClueView R;
    private ElegantLoveEntranceView S;
    private ElegantNovelSpeciesView T;
    private ElegantGiftView U;
    private IntimateContentItemNewDnaView V;
    private IntimateContentItemLoverAchievementView W;
    private k X;
    private RelativeLayout Y;

    /* renamed from: e, reason: collision with root package name */
    public QBaseActivity f178900e;

    /* renamed from: f, reason: collision with root package name */
    public Context f178902f;

    /* renamed from: g0, reason: collision with root package name */
    public IntimateUpgradeBannerView f178904g0;

    /* renamed from: h, reason: collision with root package name */
    public String f178905h;

    /* renamed from: i, reason: collision with root package name */
    public long f178906i;

    /* renamed from: m, reason: collision with root package name */
    protected IntimateInfo f178907m;
    protected int E = 1;
    protected boolean F = false;
    public boolean G = false;
    private ArrayList<IntimateContentItemBaseView> Z = new ArrayList<>();

    /* renamed from: a0, reason: collision with root package name */
    private boolean f178895a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f178896b0 = true;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f178897c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f178899d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f178901e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f178903f0 = false;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f178898d = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements k.d {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.k.d
        public void a(IntimateInfo.MemoryDayInfo memoryDayInfo) {
            MainIntimateView.this.H();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.friends.intimate.e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onBandIntimateRelationship(boolean z16, String str) {
            MainIntimateView mainIntimateView = this.f211784d.get();
            if (mainIntimateView != null) {
                mainIntimateView.f(z16, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onDisbandIntimateRelationship(boolean z16, String str, boolean z17) {
            MainIntimateView mainIntimateView = this.f211784d.get();
            if (mainIntimateView != null) {
                mainIntimateView.g(z16, str, z17);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onGetUpgradeIntimateInfo(boolean z16, String str, IntimateInfo intimateInfo) {
            MainIntimateView mainIntimateView = this.f211784d.get();
            if (mainIntimateView != null) {
                mainIntimateView.h(z16, str, intimateInfo);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onHandleGetLoverIntimateInfo(boolean z16, Object[] objArr) {
            MainIntimateView mainIntimateView = this.f211784d.get();
            if (mainIntimateView == null) {
                return;
            }
            mainIntimateView.i(z16, objArr);
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onMutualMarkCardUpdate(long j3, boolean z16) {
            IntimateElegantCardView intimateElegantCardView;
            MainIntimateView mainIntimateView = this.f211784d.get();
            if (mainIntimateView != null && (intimateElegantCardView = mainIntimateView.N) != null) {
                intimateElegantCardView.R(j3, z16);
            }
        }
    }

    public MainIntimateView(QBaseActivity qBaseActivity, Context context, String str) {
        this.f178904g0 = null;
        if (qBaseActivity != null) {
            this.f178900e = qBaseActivity;
        } else if (context instanceof BaseActivity) {
            this.f178900e = (BaseActivity) context;
        }
        this.f178902f = context;
        this.f178905h = str;
        View A = A();
        this.H = A;
        MainIntimateTitlePart mainIntimateTitlePart = new MainIntimateTitlePart(this.f178902f, A);
        this.J = mainIntimateTitlePart;
        mainIntimateTitlePart.za(this.f178905h);
        com.tencent.mobileqq.activity.aio.intimate.b.f178912a.f(str);
        View l3 = l();
        this.I = l3;
        IntimateHeaderView intimateHeaderView = (IntimateHeaderView) l3.findViewById(R.id.vf6);
        this.L = intimateHeaderView;
        if (intimateHeaderView != null) {
            intimateHeaderView.setPartnerListener(new IntimateHeaderView.b() { // from class: com.tencent.mobileqq.activity.aio.intimate.j
                @Override // com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView.b
                public final void a(boolean z16) {
                    MainIntimateView.this.x(z16);
                }
            });
        }
        this.M = (ZPlanIntimateContentItemFriendInfoView) this.I.findViewById(R.id.f126587p6);
        this.N = (IntimateElegantCardView) this.I.findViewById(R.id.vfh);
        this.P = (GenericCardGroupView) this.I.findViewById(R.id.f165288vf3);
        this.Q = (ElegantSpecialWordView) this.I.findViewById(R.id.f87234tt);
        this.U = (ElegantGiftView) this.I.findViewById(R.id.f165289vf4);
        this.R = (IntimateContentItemClueView) this.I.findViewById(R.id.veq);
        this.S = (ElegantLoveEntranceView) this.I.findViewById(R.id.yv7);
        this.T = (ElegantNovelSpeciesView) this.I.findViewById(R.id.zv7);
        this.V = (IntimateContentItemNewDnaView) this.I.findViewById(R.id.vew);
        this.W = (IntimateContentItemLoverAchievementView) this.I.findViewById(R.id.u_e);
        this.f178904g0 = (IntimateUpgradeBannerView) this.I.findViewById(R.id.xrd);
        if (this.L != null && n.a()) {
            this.Z.add(this.L);
        }
        ZPlanIntimateContentItemFriendInfoView zPlanIntimateContentItemFriendInfoView = this.M;
        if (zPlanIntimateContentItemFriendInfoView != null) {
            this.Z.add(zPlanIntimateContentItemFriendInfoView);
        }
        this.Z.add(this.U);
        this.Z.add(this.N);
        this.Z.add(this.P);
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().setFriendUin(str);
        }
        if (this.L != null && n.a()) {
            this.L.l();
        }
        ZPlanIntimateContentItemFriendInfoView zPlanIntimateContentItemFriendInfoView2 = this.M;
        if (zPlanIntimateContentItemFriendInfoView2 != null) {
            zPlanIntimateContentItemFriendInfoView2.l();
        }
        this.Y = (RelativeLayout) this.I.findViewById(R.id.f166235ls4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IntimateInfo intimateInfo = this.f178907m;
        String f16 = FriendIntimateRelationshipHelper.f(intimateInfo.maskType, intimateInfo.maskLevel);
        if (!TextUtils.isEmpty(f16)) {
            S(f16);
        } else {
            QQToast.makeText(this.f178900e, 1, HardCodeUtil.qqStr(R.string.ngg), 1).show();
        }
    }

    private void I() {
        QBaseActivity qBaseActivity = this.f178900e;
        if (qBaseActivity != null && qBaseActivity.getAppRuntime() != null) {
            ((IWebProcessManagerService) this.f178900e.getAppRuntime().getRuntimeService(IWebProcessManagerService.class, "")).startWebProcessUnderStrategy(21, null);
        }
    }

    private void K() {
        HashMap<String, Object> q16 = q();
        q16.put("touin", this.f178905h);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportPageEvent("dt_pgout", "pg_aio_swipleft", q16);
    }

    private void S(String str) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ja(str);
        }
    }

    private void T(String str) {
        if (this.K == null) {
            QBaseActivity qBaseActivity = this.f178900e;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            this.K = qQProgressDialog;
            qQProgressDialog.setBackAndSearchFilter(true);
        }
        this.K.setMessage(str);
        QQProgressDialog qQProgressDialog2 = this.K;
        if (qQProgressDialog2 != null && !qQProgressDialog2.isShowing() && !this.f178900e.isFinishing()) {
            this.K.show();
        }
    }

    private void U() {
        if (this.f178904g0 == null || !((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
            return;
        }
        int i3 = 8;
        if (((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(this.f178905h)) {
            this.f178904g0.setVisibility(8);
            return;
        }
        IntimateUpgradeBannerView intimateUpgradeBannerView = this.f178904g0;
        if (!AppSetting.t(this.f178902f)) {
            i3 = 0;
        }
        intimateUpgradeBannerView.setVisibility(i3);
        if (this.f178904g0.getVisibility() == 0) {
            L("dt_imp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.f178905h) && z16) {
            M();
        } else {
            QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, String str, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.f178905h)) {
            Message obtainMessage = this.C.obtainMessage();
            if (!z16) {
                obtainMessage.what = 5;
                this.C.sendMessage(obtainMessage);
                return;
            } else {
                if (z17) {
                    M();
                    return;
                }
                obtainMessage.what = 6;
                obtainMessage.obj = str;
                this.C.sendMessage(obtainMessage);
                return;
            }
        }
        QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16, String str, IntimateInfo intimateInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.f178905h)) {
            if (z16) {
                Message obtainMessage = this.C.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.obj = intimateInfo;
                this.C.removeMessages(0);
                this.C.sendMessage(obtainMessage);
                return;
            }
            Message obtainMessage2 = this.C.obtainMessage();
            obtainMessage2.what = 1;
            obtainMessage2.obj = this.f178902f.getResources().getString(R.string.byt);
            this.C.sendMessage(obtainMessage2);
            return;
        }
        QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", str));
    }

    private void j() {
        ElegantLoveEntranceView elegantLoveEntranceView = this.S;
        if (elegantLoveEntranceView != null && elegantLoveEntranceView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_couplearea", q(), null);
        }
        ElegantNovelSpeciesView elegantNovelSpeciesView = this.T;
        if (elegantNovelSpeciesView != null && elegantNovelSpeciesView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_newelement", q(), null);
        }
        if (this.X != null && !this.f178901e0) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_special_day_entry", q(), null);
            this.f178901e0 = true;
            QLog.d("MainIntimateView", 1, "reportEM_BAS_SPECIAL_DAY_ENTRY");
        }
        ElegantGiftView elegantGiftView = this.U;
        if (elegantGiftView != null && elegantGiftView.isShown() && !this.f178899d0) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_gift_entry", q(), null);
            this.f178899d0 = true;
            QLog.d("MainIntimateView", 1, "reportEM_BAS_GIFT_ENTRY");
        }
        View view = this.H;
        if (view != null && view.findViewById(R.id.lix) != null && this.H.findViewById(R.id.lix).getVisibility() == 0) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_mini_game_entry", q(), null);
        }
        ElegantSpecialWordView elegantSpecialWordView = this.Q;
        if (elegantSpecialWordView != null && elegantSpecialWordView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_luckynumber", q(), null);
        }
        IntimateContentItemNewDnaView intimateContentItemNewDnaView = this.V;
        if (intimateContentItemNewDnaView != null && intimateContentItemNewDnaView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_friend_dna", q(), null);
        }
        IntimateContentItemClueView intimateContentItemClueView = this.R;
        if (intimateContentItemClueView != null && intimateContentItemClueView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_friend_clue", q(), null);
        }
        IntimateContentItemLoverAchievementView intimateContentItemLoverAchievementView = this.W;
        if (intimateContentItemLoverAchievementView != null && intimateContentItemLoverAchievementView.isShown()) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_couple_achievement", q(), null);
        }
    }

    private void t(IntimateInfo intimateInfo) {
        RelativeLayout relativeLayout;
        if (this.f178902f == null) {
            QLog.e("MainIntimateView", 1, "handleMemoryDays fail, context is null");
            return;
        }
        if (intimateInfo.memoryDayInfoList != null) {
            AbstractGifImage.resumeAll();
            if (this.X == null) {
                k kVar = new k(this.f178902f, this.f178905h);
                this.X = kVar;
                kVar.k(new a());
            }
            this.X.i(this.f178902f, new ArrayList<>(intimateInfo.memoryDayInfoList));
            if (this.X.g() != null && (relativeLayout = this.Y) != null) {
                relativeLayout.removeAllViews();
                this.Y.addView(this.X.g());
                this.Y.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.Y;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    private void u() {
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.K.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void v() {
        HashMap<String, Object> q16 = q();
        q16.put("touin", this.f178905h);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportPageEvent("dt_pgin", "pg_aio_swipleft", q16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(boolean z16) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Da(z16);
        }
    }

    protected View A() {
        return null;
    }

    public void B() {
        k kVar = this.X;
        if (kVar != null) {
            kVar.e();
            this.X = null;
        }
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onDestroy();
        }
        if (this.f178904g0 != null) {
            L("dt_imp_end");
            this.f178904g0.setCallback(null);
        }
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
        QQAppInterface qQAppInterface = this.f178898d;
        if (qQAppInterface != null && (qQAppInterface instanceof AppInterface)) {
            qQAppInterface.removeObserver(f178894h0);
            f178894h0.a(null);
            this.f178903f0 = false;
        }
        this.f178900e = null;
        this.f178902f = null;
    }

    public void C() {
        this.f178895a0 = false;
        this.f178896b0 = true;
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
        QQAppInterface qQAppInterface = this.f178898d;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(f178894h0);
            f178894h0.a(null);
            this.f178903f0 = false;
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                ((AppInterface) peekAppRuntime).removeObserver(f178894h0);
                f178894h0.a(null);
                this.f178903f0 = false;
            }
        }
        com.tencent.mobileqq.activity.aio.intimate.b.f178912a.c();
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.oa();
        }
        K();
    }

    public void D() {
        if (this.f178898d != null && !this.f178903f0) {
            f178894h0.a(this);
            this.f178898d.addObserver(f178894h0);
            this.f178903f0 = true;
        }
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
        U();
        v();
    }

    public void E() {
        w();
        this.G = true;
        if (!this.f178896b0) {
            return;
        }
        this.f178896b0 = false;
        com.tencent.mobileqq.activity.aio.intimate.b.f178912a.d();
        M();
        O();
        N();
        p();
        this.f178899d0 = false;
        this.f178901e0 = false;
    }

    public void F() {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onPause();
        }
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    public void G() {
        M();
        N();
        p();
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onResume();
        }
        Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public void J() {
        this.f178898d = null;
    }

    public void L(String str) {
        try {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent(str, "pg_aio_swipleft", "em_zplan_friend_time_banner", q(), null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void M() {
        if (!TextUtils.isEmpty(this.f178905h)) {
            if (NetworkUtil.isNetworkAvailable(this.f178900e)) {
                IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) this.f178898d.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                if (intimateInfoHandler == null) {
                    QLog.e("MainIntimateView", 1, "requestIntimateInfo fail, IntimateInfoHandler is null");
                    return;
                }
                boolean z16 = FriendIntimateRelationshipConfProcessor.a().f202727w0;
                if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
                    intimateInfoHandler.I2(this.f178905h, z16);
                } else {
                    intimateInfoHandler.G2(this.f178905h, z16);
                }
            } else {
                Handler handler = this.C;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.obj = this.f178902f.getResources().getString(R.string.hpk);
                    this.C.sendMessage(obtainMessage);
                    QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", this.f178905h));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", this.f178905h));
        }
    }

    public void O() {
        long j3;
        if (!TextUtils.isEmpty(this.f178905h)) {
            if (NetworkUtil.isNetworkAvailable(this.f178900e)) {
                try {
                    j3 = Long.parseLong(this.f178905h);
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", this.f178905h));
                    }
                    j3 = 0;
                }
                com.tencent.mobileqq.activity.contact.troop.h.f(j3, 1, this.f178898d);
            } else {
                Handler handler = this.C;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.obj = this.f178902f.getResources().getString(R.string.hpk);
                    this.C.sendMessage(obtainMessage);
                    QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", this.f178905h));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", this.f178905h));
        }
    }

    public void P(boolean z16, MainIntimateTitlePart.g gVar) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ba(z16, gVar);
        }
    }

    public void Q(boolean z16) {
        this.G = z16;
    }

    public void R(boolean z16) {
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ea(z16);
        }
        IntimateElegantCardView intimateElegantCardView = this.N;
        if (intimateElegantCardView != null) {
            intimateElegantCardView.setIsZplanMode(Boolean.valueOf(z16));
        }
        IntimateContentItemNewDnaView intimateContentItemNewDnaView = this.V;
        if (intimateContentItemNewDnaView != null) {
            intimateContentItemNewDnaView.setIsZplanMode(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RequiresApi(api = 17)
    public void V(IntimateInfo intimateInfo) {
        QLog.i("intimate_relationship", 1, "updateUpgradeIntimateInfo: " + intimateInfo);
        if (intimateInfo != null && this.f178898d != null) {
            this.f178907m = intimateInfo;
            MainIntimateTitlePart mainIntimateTitlePart = this.J;
            if (mainIntimateTitlePart != null) {
                mainIntimateTitlePart.Aa(intimateInfo);
            }
            int i3 = intimateInfo.maskType;
            this.D = i3;
            MainIntimateTitlePart mainIntimateTitlePart2 = this.J;
            if (mainIntimateTitlePart2 != null) {
                mainIntimateTitlePart2.xa(i3);
            }
            if (intimateInfo.beFriendDays >= -1) {
                int i16 = this.D;
                if (i16 == 3) {
                    this.E = 4;
                    this.F = true;
                } else if (i16 == 2) {
                    this.E = 3;
                    this.F = true;
                } else if (i16 == 1) {
                    s(intimateInfo);
                } else if (i16 == 26) {
                    this.E = 5;
                    this.S.setVisibility(8);
                    this.F = true;
                } else {
                    this.E = 1;
                    this.F = false;
                }
                MainIntimateTitlePart mainIntimateTitlePart3 = this.J;
                if (mainIntimateTitlePart3 != null) {
                    mainIntimateTitlePart3.Ca(this.F);
                    this.J.Fa(true);
                }
            } else {
                this.D = 0;
                MainIntimateTitlePart mainIntimateTitlePart4 = this.J;
                if (mainIntimateTitlePart4 != null) {
                    mainIntimateTitlePart4.xa(0);
                }
            }
            MainIntimateTitlePart mainIntimateTitlePart5 = this.J;
            if (mainIntimateTitlePart5 != null) {
                mainIntimateTitlePart5.Ha(this.E);
                this.J.Ua(intimateInfo, false);
            }
            Iterator<IntimateContentItemBaseView> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().r(intimateInfo, this.D);
            }
            this.U.setReportType(this.E);
            if (this.G) {
                this.S.t();
            }
            t(intimateInfo);
            IntimatePlayTogetherMiniGameCardView.h(this.H, this.f178907m);
            ReportController.o(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.E, 0, "", "", "", "");
            if (this.E == 2) {
                ReportController.o(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
            }
            j();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(@NonNull Message message) {
        switch (message.what) {
            case 0:
                V((IntimateInfo) message.obj);
                break;
            case 1:
                QQToast.makeText(this.f178900e, 1, (String) message.obj, 1).show();
                break;
            case 2:
                QQToast.makeText(this.f178900e, 2, (String) message.obj, 1).show();
                break;
            case 3:
                Object obj = message.obj;
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 2) {
                        this.S.w((String) objArr[0], (String) objArr[1], (String) objArr[2]);
                        break;
                    }
                } else {
                    this.S.v();
                    break;
                }
                break;
            case 4:
                this.S.v();
                break;
            case 5:
                u();
                QQToast.makeText(this.f178900e, 2, R.string.byo, 1).show();
                break;
            case 6:
                M();
                N();
                QQToast.makeText(this.f178900e, 2, R.string.byp, 1).show();
                break;
            case 7:
                T((String) message.obj);
                break;
            case 8:
                u();
                break;
            case 9:
                N();
                break;
        }
    }

    protected void i(boolean z16, Object[] objArr) {
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "onHandleGetLoverIntimateInfo isSuccess = " + z16 + " data = " + objArr);
        }
        if (z16) {
            Message obtainMessage = this.C.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = objArr;
            this.C.removeMessages(3);
            this.C.sendMessage(obtainMessage);
            return;
        }
        Message obtainMessage2 = this.C.obtainMessage();
        obtainMessage2.what = 4;
        obtainMessage2.obj = null;
        this.C.sendMessage(obtainMessage2);
    }

    public void k() {
        this.S.u();
    }

    protected View l() {
        return null;
    }

    public MainIntimateTitlePart m() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> n() {
        IntimateHeaderView intimateHeaderView = this.L;
        if (intimateHeaderView == null) {
            return new ArrayList<>();
        }
        return intimateHeaderView.E();
    }

    public void o() {
        this.T.t(this.f178905h);
    }

    public void p() {
        k();
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public HashMap<String, Object> q() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("is_close_relation", String.valueOf(this.E - 1));
        hashMap.put("aio_swipleft_version", "2");
        hashMap.put("interaction_lab_id", "3");
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restorePgSwipLeftData(hashMap);
        return hashMap;
    }

    public View r() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(IntimateInfo intimateInfo) {
        if (this.f178898d == null) {
            QLog.e("MainIntimateView", 1, "handleLoverIntimateInfo fail, app is null");
            return;
        }
        this.E = 2;
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Fa(true);
        }
        com.tencent.mobileqq.loverzone.a.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.f178898d));
        this.F = true;
        MainIntimateTitlePart mainIntimateTitlePart2 = this.J;
        if (mainIntimateTitlePart2 != null) {
            mainIntimateTitlePart2.Ca(true);
            this.J.Ha(this.E);
        }
        if (!this.f178897c0 && this.G) {
            this.f178897c0 = true;
            I();
        }
    }

    public void w() {
        this.f178895a0 = true;
        if (this.C == null) {
            this.C = new Handler(this);
        }
        MainIntimateTitlePart mainIntimateTitlePart = this.J;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ia(this.C);
        }
        if (this.f178898d != null && !this.f178903f0) {
            f178894h0.a(this);
            this.f178898d.addObserver(f178894h0);
            this.f178903f0 = true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.MainIntimateView.3
            @Override // java.lang.Runnable
            public void run() {
                MainIntimateView mainIntimateView = MainIntimateView.this;
                if (mainIntimateView.f178898d != null && !TextUtils.isEmpty(mainIntimateView.f178905h)) {
                    com.tencent.mobileqq.friends.intimate.c cVar = (com.tencent.mobileqq.friends.intimate.c) MainIntimateView.this.f178898d.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
                    IntimateInfo m3 = cVar.m(MainIntimateView.this.f178905h);
                    if (m3 != null) {
                        Message obtainMessage = MainIntimateView.this.C.obtainMessage();
                        MainIntimateView mainIntimateView2 = MainIntimateView.this;
                        mainIntimateView2.f178907m = m3;
                        MainIntimateTitlePart mainIntimateTitlePart2 = mainIntimateView2.J;
                        if (mainIntimateTitlePart2 != null) {
                            mainIntimateTitlePart2.Aa(m3);
                        }
                        obtainMessage.what = 0;
                        obtainMessage.obj = m3;
                        MainIntimateView.this.C.sendMessage(obtainMessage);
                    }
                    cVar.h(FriendIntimateRelationshipConfProcessor.a().f202719o0, FriendIntimateRelationshipConfProcessor.a().f202720p0);
                    if (QLog.isColorLevel()) {
                        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", MainIntimateView.this.f178905h, m3));
                    }
                }
            }
        }, 16, null, false);
    }

    public void y() {
        QBaseActivity qBaseActivity = this.f178900e;
        if (qBaseActivity != null) {
            qBaseActivity.finish();
        }
    }

    public boolean z() {
        IntimateElegantCardView intimateElegantCardView = this.N;
        if (intimateElegantCardView != null) {
            return intimateElegantCardView.Q();
        }
        return false;
    }

    public void N() {
    }
}
