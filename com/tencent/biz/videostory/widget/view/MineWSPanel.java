package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI$stGetPersonalPageRsp;
import WEISHI_USER_GROWTH.WEISHI$stMetaFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.g;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.pubaccount.weishi.api.IWSMinePanel;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.GetMineWSPersonalRequest;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.IEventReceiver;
import if0.a;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public class MineWSPanel implements IEventReceiver {
    private RecyclerView C;
    private if0.a D;
    private ImageView E;
    private View F;
    private boolean G;
    private String H;
    private String I;
    private GetMineWSPersonalRequest J;
    private e K;

    /* renamed from: d, reason: collision with root package name */
    private QBaseActivity f97232d;

    /* renamed from: e, reason: collision with root package name */
    private ProfileWeishiComponent f97233e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f97234f;

    /* renamed from: h, reason: collision with root package name */
    private View f97235h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f97236i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f97237m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MineWSPanel.this.f97232d != null) {
                if (!hf0.a.a(MineWSPanel.class.getName() + "clickPanel")) {
                    MineWSPanel.this.m(false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements c {
        b() {
        }

        @Override // com.tencent.biz.videostory.widget.view.MineWSPanel.c
        public void a(a.c cVar) {
            int a16 = cVar.a();
            if (!MineWSPanel.this.G || a16 != 100) {
                MineWSPanel.this.m(false);
            } else {
                MineWSPanel.this.m(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(a.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d implements VSDispatchObserver.OnVSRspCallBack<WEISHI$stGetPersonalPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<MineWSPanel> f97243a;

        public d(MineWSPanel mineWSPanel) {
            this.f97243a = new WeakReference<>(mineWSPanel);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, WEISHI$stGetPersonalPageRsp wEISHI$stGetPersonalPageRsp) {
            MineWSPanel mineWSPanel = this.f97243a.get();
            if (mineWSPanel == null) {
                return;
            }
            mineWSPanel.p(wEISHI$stGetPersonalPageRsp, false);
            if (wEISHI$stGetPersonalPageRsp != null) {
                mineWSPanel.o(wEISHI$stGetPersonalPageRsp.toByteArray());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void processClickEvent();
    }

    public MineWSPanel(ProfileWeishiComponent profileWeishiComponent) {
        this.f97233e = profileWeishiComponent;
        QBaseActivity activity = profileWeishiComponent.getActivity();
        this.f97232d = activity;
        this.D = new if0.a(activity);
    }

    private void i() {
        ((IWSManager) QRoute.api(IWSManager.class)).openWeishi(this.f97232d, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
    }

    private void j() {
        String str;
        String str2 = "weishi://profile?person_id=";
        if (!TextUtils.isEmpty(this.I)) {
            str2 = "weishi://profile?person_id=" + this.I;
        }
        if (this.G) {
            str = str2 + "&logsour=2020020031";
        } else {
            str = str2 + "&logsour=2020020029";
        }
        ((IWSManager) QRoute.api(IWSManager.class)).openWeishi(this.f97232d, "biz_src_jc_gxl", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        int i3;
        if (this.f97232d == null) {
            return;
        }
        if (this.G) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        VSReporter.m("weishi_share_prof", "entry_clk", i3, 0, new String[0]);
        boolean c16 = l.c(this.f97232d);
        ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportWeiShiProfileClick(this.G, this.H, c16, z16);
        if (!c16) {
            VSReporter.m("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
            QQToast.makeText(this.f97232d, HardCodeUtil.qqStr(R.string.o6c), 0).show();
            ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).downloadWeishiWithDialog(this.f97232d, this.G);
        } else if (this.G && z16) {
            i();
            VSReporter.m("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
        } else {
            j();
            VSReporter.m("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
        }
        e eVar = this.K;
        if (eVar != null) {
            eVar.processClickEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final byte[] bArr) {
        if (bArr == null) {
            QLog.i("MineWSPanel", 2, "response is null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.videostory.widget.view.MineWSPanel.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MineWSPanel.this.f97232d == null) {
                        QLog.i("MineWSPanel", 2, "mBaseActivity is null");
                        return;
                    }
                    EntityManager createEntityManager = MineWSPanel.this.f97232d.getAppRuntime().getEntityManagerFactory().createEntityManager();
                    WSPersonalEntity wSPersonalEntity = (WSPersonalEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) WSPersonalEntity.class, MineWSPanel.this.H);
                    if (wSPersonalEntity == null) {
                        wSPersonalEntity = new WSPersonalEntity();
                    }
                    wSPersonalEntity.updateWeiShiFeedListEntity(MineWSPanel.this.H, bArr);
                    if (wSPersonalEntity.getStatus() == 1000) {
                        createEntityManager.persist(wSPersonalEntity);
                    } else {
                        createEntityManager.update(wSPersonalEntity);
                    }
                    createEntityManager.close();
                }
            }, 32, null, true);
        }
    }

    private void r(boolean z16) {
        boolean isProfileCardActivity = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardActivity(this.f97232d);
        if (this.f97233e != null && isProfileCardActivity) {
            QLog.i("MineWSPanel", 2, "setWeiShiPanelState isShow:" + z16);
            this.f97233e.initOrRefreshWeiShiPanel(z16);
        }
    }

    public ImageView f() {
        return this.E;
    }

    public void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.videostory.widget.view.MineWSPanel.4
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(MineWSPanel.this.H)) {
                    QLog.i("MineWSPanel", 2, "mUin is invalid");
                    return;
                }
                if (MineWSPanel.this.f97232d == null) {
                    QLog.i("MineWSPanel", 2, "mBaseActivity is null");
                    return;
                }
                EntityManager createEntityManager = MineWSPanel.this.f97232d.getAppRuntime().getEntityManagerFactory().createEntityManager();
                WSPersonalEntity wSPersonalEntity = (WSPersonalEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) WSPersonalEntity.class, MineWSPanel.this.H);
                createEntityManager.close();
                if (wSPersonalEntity != null) {
                    final WEISHI$stGetPersonalPageRsp wEISHI$stGetPersonalPageRsp = new WEISHI$stGetPersonalPageRsp();
                    try {
                        wEISHI$stGetPersonalPageRsp.mergeFrom(wSPersonalEntity.weiShiPersonalRsp);
                        if (MineWSPanel.this.f97232d != null) {
                            MineWSPanel.this.f97232d.runOnUiThread(new Runnable() { // from class: com.tencent.biz.videostory.widget.view.MineWSPanel.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MineWSPanel.this.p(wEISHI$stGetPersonalPageRsp, true);
                                }
                            });
                        }
                        MineWSPanel.this.n();
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("MineWSPanel", 2, "getWeiShiPersonalDataFromDB, ex= " + e16.getMessage());
                            return;
                        }
                        return;
                    }
                }
                MineWSPanel.this.n();
            }
        }, 32, null, true);
    }

    public TextView h() {
        return this.f97236i;
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return true;
    }

    public void k(boolean z16, String str) {
        this.G = z16;
        this.H = str;
    }

    public void l(View view) {
        this.F = view;
        this.f97234f = (LinearLayout) view.findViewById(R.id.ew_);
        this.f97235h = view.findViewById(R.id.icon);
        this.f97236i = (TextView) view.findViewById(R.id.ewa);
        this.f97237m = (TextView) view.findViewById(R.id.ewb);
        this.C = (RecyclerView) view.findViewById(R.id.l5e);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f97232d);
        linearLayoutManager.setOrientation(0);
        this.C.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        this.C.setHasFixedSize(true);
        this.C.setAdapter(this.D);
        this.E = (ImageView) view.findViewById(R.id.ezw);
        this.f97234f.setOnClickListener(new a());
        this.D.t(new b());
        ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfileCardExposure(this.G, this.H);
        QLog.i("MineWSPanel", 2, "[MineWSPanel.java][initUI] mIsCurrentUser:" + this.G + ", mUin:" + this.H);
    }

    public void n() {
        QLog.i("MineWSPanel", 2, "requestWeiShiFeedListDataFromServer mUin=" + this.H);
        if (!g.b(this.f97232d.getAppRuntime().getApplication().getApplicationContext())) {
            return;
        }
        this.J = new GetMineWSPersonalRequest(this.H + "", 1);
        VSNetworkHelper.getInstance().sendRequest(this.f97232d, this.J, new d(this));
    }

    public void p(WEISHI$stGetPersonalPageRsp wEISHI$stGetPersonalPageRsp, boolean z16) {
        int i3;
        if (wEISHI$stGetPersonalPageRsp == null) {
            QLog.i("MineWSPanel", 2, "rsp is null");
            return;
        }
        int i16 = wEISHI$stGetPersonalPageRsp.feed_num.get();
        this.I = wEISHI$stGetPersonalPageRsp.personid.get();
        QLog.i("MineWSPanel", 2, "[MineWSPanel.java][setData] feedNum:" + i16 + ", isFromDb:" + z16);
        if (i16 > 0) {
            if (!z16) {
                if (this.G) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                VSReporter.m("weishi_share_prof", "entry_exp", i3, 0, new String[0]);
            }
            r(true);
            TextView textView = this.f97237m;
            if (textView != null) {
                textView.setText(i16 + HardCodeUtil.qqStr(R.string.o6d));
            }
        } else {
            r(false);
            TextView textView2 = this.f97237m;
            if (textView2 != null) {
                textView2.setText("");
            }
        }
        if (this.C != null) {
            List<WEISHI$stMetaFeed> list = wEISHI$stGetPersonalPageRsp.feeds.get();
            if (list != null && list.size() != 0) {
                this.C.setVisibility(0);
                QLog.i("MineWSPanel", 2, "setData(),mIsCurrentUser=" + this.G);
                this.D.s(list, this.G);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public void q(e eVar) {
        this.K = eVar;
    }

    public void s() {
        if (this.f97235h == null) {
            QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
        } else if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            this.f97235h.setBackgroundResource(R.drawable.gyq);
        } else {
            this.f97235h.setBackgroundResource(R.drawable.qq_profilecard_item_mine_weishi);
        }
    }
}
