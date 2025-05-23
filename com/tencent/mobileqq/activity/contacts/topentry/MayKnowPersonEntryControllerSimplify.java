package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.b;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKTotalData;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.pymk.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes10.dex */
public class MayKnowPersonEntryControllerSimplify extends com.tencent.mobileqq.activity.contacts.topentry.b implements Handler.Callback, com.tencent.mobileqq.activity.contacts.topentry.c, View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected MayknowRecommendsAdapter G;
    protected CTEntryMng H;
    protected boolean I;
    protected boolean J;
    protected final WeakReferenceHandler K;
    protected RelativeLayout L;
    protected TextView M;
    protected ImageView N;
    private long P;
    private List<MayKnowRecommend> Q;
    private final StudyModeChangeListener R;
    private final ar S;
    private final com.tencent.mobileqq.pymk.api.d T;
    protected i U;

    /* loaded from: classes10.dex */
    class a implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MayKnowPersonEntryControllerSimplify.this.K();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onMayKnowEntryStateChanged(boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            super.onMayKnowEntryStateChanged(z16, bundle);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("do network checkUpdate, rsp ");
                if (z16) {
                    str = "success";
                } else {
                    str = "false";
                }
                sb5.append(str);
                sb5.append(". msg: \"send network respond done\"");
                QLog.d("MayKnowPersonEntryControllerSimplify", 2, sb5.toString());
            }
            if (!z16) {
                MayKnowPersonEntryControllerSimplify.this.P = System.currentTimeMillis();
            } else {
                CTEntryMng cTEntryMng = MayKnowPersonEntryControllerSimplify.this.H;
                if (cTEntryMng != null) {
                    cTEntryMng.w().k();
                }
            }
            MayKnowPersonEntryControllerSimplify.this.K();
        }
    }

    /* loaded from: classes10.dex */
    class c extends com.tencent.mobileqq.pymk.api.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void a(@NonNull PYMKTotalData pYMKTotalData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pYMKTotalData);
            } else {
                super.a(pYMKTotalData);
                MayKnowPersonEntryControllerSimplify.this.K();
            }
        }
    }

    /* loaded from: classes10.dex */
    class d implements i {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.i
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QLog.i("MayKnowPersonEntryControllerSimplify", 1, "onSetPYMKSwitchChange " + z16);
        }
    }

    /* loaded from: classes10.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!u.a().b()) {
                ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).reqOpenPYMKSetting();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).recordGuideClose();
                MayKnowPersonEntryControllerSimplify.this.K();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MayKnowPersonEntryControllerSimplify(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.I = true;
        this.J = false;
        this.P = 0L;
        this.Q = new ArrayList();
        this.R = new a();
        this.S = new b();
        this.T = new c();
        this.U = new d();
        this.K = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ArrayList<MayKnowRecommend> A() {
        List<MayKnowRecommend> localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData(4);
        CTEntryMng cTEntryMng = this.H;
        if (cTEntryMng == null) {
            return null;
        }
        com.tencent.mobileqq.activity.contacts.topentry.e w3 = cTEntryMng.w();
        int h16 = w3.h();
        int size = localRecommendData.size();
        ArrayList<MayKnowRecommend> arrayList = new ArrayList<>(h16);
        for (int i3 = 0; i3 < size && arrayList.size() < h16; i3++) {
            MayKnowRecommend mayKnowRecommend = localRecommendData.get(i3);
            if (w3.a(mayKnowRecommend)) {
                arrayList.add(mayKnowRecommend);
            }
        }
        return arrayList;
    }

    private void B(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void C() {
        this.D.setVisibility(0);
        MayknowRecommendsAdapter mayknowRecommendsAdapter = new MayknowRecommendsAdapter(f(), this.f181771e, this.D, 1, true);
        this.G = mayknowRecommendsAdapter;
        this.D.setAdapter((ListAdapter) mayknowRecommendsAdapter);
    }

    private void E() {
        QQAppInterface qQAppInterface = this.f181771e;
        if (qQAppInterface != null) {
            CTEntryMng cTEntryMng = (CTEntryMng) qQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG);
            this.H = cTEntryMng;
            cTEntryMng.k(this);
            this.H.J(true);
            this.f181771e.addObserver(this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        TextView textView = this.f181775m;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.nyi));
        }
    }

    private boolean G() {
        MayknowRecommendManager mayknowRecommendManager = (MayknowRecommendManager) this.f181771e.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (mayknowRecommendManager == null || !mayknowRecommendManager.i("sp_mayknow_entry_list_head") || !((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getPYMKSetting() || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        return true;
    }

    private void H() {
        if (QLog.isColorLevel()) {
            QLog.d("MayKnowPersonEntryControllerSimplify", 2, "onMayknowEntryClosed");
        }
        ContactReportUtils.j(this.f181771e, "", "banner_recomlist_dlt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i3, int i16) {
        boolean z16 = false;
        if (i16 > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f181772f.getLayoutParams();
            layoutParams.height = BaseAIOUtils.f((i16 * 60) + 28 + 7.1f, this.f181772f.getResources());
            this.f181772f.setLayoutParams(layoutParams);
            if (!ac.C0(this.f181771e)) {
                this.f181772f.setVisibility(0);
                N();
                z16 = true;
            } else {
                this.f181772f.setVisibility(8);
            }
        } else {
            MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
            if (mayknowRecommendsAdapter != null) {
                mayknowRecommendsAdapter.s(null);
            }
            this.f181772f.setVisibility(8);
            if (i3 > 0) {
                H();
            }
        }
        if (!this.I) {
            this.I = true;
            ReportController.o(this.f181771e, "dc00898", "", "", "0X800979E", "0X800979E", 3, 0, "", "", "", "");
            if (z16) {
                ContactReportUtils.j(this.f181771e, "", "banner_recomlist_exp");
            }
        }
        b.InterfaceC7159b interfaceC7159b = this.E;
        if (interfaceC7159b != null) {
            interfaceC7159b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        SimpleModeHelper.u(ThemeUtil.isNowThemeIsSimple(this.f181771e, false, null), BaseAIOUtils.f(12.0f, this.f181772f.getResources()), this.f181772f);
        if (x()) {
            return;
        }
        this.f181773h.setVisibility(0);
        this.L.setVisibility(8);
        boolean G = G();
        QLog.i("MayKnowPersonEntryControllerSimplify", 1, "MSG_UPDATE_ENTRY_LIST isAbleToShowPYMK" + G);
        L(G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            J();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryControllerSimplify.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayKnowPersonEntryControllerSimplify.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        MayKnowPersonEntryControllerSimplify.this.J();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private void L(boolean z16) {
        this.D.setVisibility(0);
        ThreadManagerV2.excute(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryControllerSimplify.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f181739d;

            {
                this.f181739d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MayKnowPersonEntryControllerSimplify.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ArrayList A = MayKnowPersonEntryControllerSimplify.this.A();
                    if (A == null) {
                        return;
                    }
                    if (!this.f181739d) {
                        A = new ArrayList();
                    }
                    int size = A.size();
                    QLog.i("MayKnowPersonEntryControllerSimplify", 1, "MSG_UPDATE_ENTRY_LIST recSize " + size + " entrySize 0");
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(size, A, 0) { // from class: com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryControllerSimplify.8.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f181740d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ List f181741e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f181742f;

                        {
                            this.f181740d = size;
                            this.f181741e = A;
                            this.f181742f = r8;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass8.this, Integer.valueOf(size), A, Integer.valueOf(r8));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                MayKnowPersonEntryControllerSimplify.this.F();
                                MayknowRecommendsAdapter mayknowRecommendsAdapter = MayKnowPersonEntryControllerSimplify.this.G;
                                int i16 = 0;
                                if (mayknowRecommendsAdapter != null) {
                                    i3 = mayknowRecommendsAdapter.getCount();
                                } else {
                                    i3 = 0;
                                }
                                if (this.f181740d > 0) {
                                    MayknowRecommendsAdapter mayknowRecommendsAdapter2 = MayKnowPersonEntryControllerSimplify.this.G;
                                    if (mayknowRecommendsAdapter2 != null) {
                                        mayknowRecommendsAdapter2.s(this.f181741e);
                                    }
                                    i16 = this.f181740d;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("MayKnowPersonEntryControllerSimplify", 2, "MSG_UPDATE_ENTRY_LIST preCount:" + i3 + " size:" + i16 + " entrySize " + this.f181742f);
                                }
                                MayKnowPersonEntryControllerSimplify.this.I(i3, i16);
                                return;
                            }
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 16, null, true);
    }

    private void M() {
        CTEntryMng cTEntryMng = this.H;
        if (cTEntryMng != null) {
            cTEntryMng.G(this);
        }
        QQAppInterface qQAppInterface = this.f181771e;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.S);
        }
        StudyModeManager.U(this.R);
        this.H = null;
    }

    private void w() {
        boolean z16;
        if (!y().booleanValue()) {
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchRecommendDataRemote(4);
        }
        MayknowRecommendManager mayknowRecommendManager = (MayknowRecommendManager) this.f181771e.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (mayknowRecommendManager == null) {
            return;
        }
        if (!mayknowRecommendManager.n(2)) {
            K();
            return;
        }
        if (System.currentTimeMillis() - this.P > 1800000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putString("from", "fetch");
            if (!z(mayknowRecommendManager, bundle)) {
                QLog.e("MayKnowPersonEntryControllerSimplify", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed or network error [1]\"");
                K();
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MayKnowPersonEntryControllerSimplify", 2, "do network checkUpdate. msg: \"send network request done\"");
                    return;
                }
                return;
            }
        }
        QLog.e("MayKnowPersonEntryControllerSimplify", 2, "do local checkUpdate. msg: \"Update too frequently, network update is not allowed\"");
        K();
    }

    private boolean x() {
        if (!((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).isAbleToShowPYMKGuide()) {
            return false;
        }
        this.f181772f.setVisibility(0);
        this.L.setVisibility(0);
        this.f181773h.setVisibility(8);
        this.D.setVisibility(8);
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            mayknowRecommendsAdapter.s(null);
        }
        ((LinearLayout.LayoutParams) this.f181772f.getLayoutParams()).height = -2;
        return true;
    }

    private Boolean y() {
        boolean pYMKSetting = ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getPYMKSetting();
        boolean isFirstTimeUpTo9025 = ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getIsFirstTimeUpTo9025();
        List<MayKnowRecommend> localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData(4);
        QLog.i("MayKnowPersonEntryControllerSimplify", 1, "checkTop2Top4DataUpdate isPymkSwtichOpen " + pYMKSetting + " isFristTime " + isFirstTimeUpTo9025 + " data_size " + localRecommendData.size());
        if (!pYMKSetting && isFirstTimeUpTo9025 && localRecommendData.isEmpty()) {
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchTop2RecommendDataRemoteForce();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private boolean z(MayknowRecommendManager mayknowRecommendManager, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("MayKnowPersonEntryControllerSimplify", 2, "getMKRDataFromNetwork");
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("MayKnowPersonEntryControllerSimplify", 2, "getMKRDataFromNetwork when network error, abort");
                return false;
            }
            return false;
        }
        return mayknowRecommendManager.h(2, bundle);
    }

    public void D() {
        String i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AlphaClickableRelativeLayout alphaClickableRelativeLayout = this.f181774i;
        if (alphaClickableRelativeLayout == null) {
            return;
        }
        VideoReport.setElementId(alphaClickableRelativeLayout, "em_kl_contact_youmayknow_more");
        VideoReport.setElementExposePolicy(this.f181774i, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f181774i, ClickPolicy.REPORT_ALL);
        HashMap hashMap = new HashMap(2);
        hashMap.put("kl_youmayknow_entrance_type", 0);
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        String str = "";
        if (mayknowRecommendsAdapter == null) {
            i3 = "";
        } else {
            i3 = mayknowRecommendsAdapter.i();
        }
        hashMap.put("trace_id", i3);
        MayknowRecommendsAdapter mayknowRecommendsAdapter2 = this.G;
        if (mayknowRecommendsAdapter2 != null) {
            str = mayknowRecommendsAdapter2.j();
        }
        hashMap.put("trans_info", str);
        VideoReport.setElementParams(this.f181774i, hashMap);
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            String i3 = mayknowRecommendsAdapter.i();
            String j3 = this.G.j();
            VideoReport.setElementId(this.D, "em_kl_contact_youmayknow_view");
            VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
            HashMap hashMap = new HashMap(2);
            hashMap.put("kl_youmayknow_entrance_type", 0);
            hashMap.put("trace_id", i3);
            hashMap.put("trans_info", j3);
            VideoReport.reportEvent("dt_imp", this.D, hashMap);
        }
        D();
    }

    @Override // com.tencent.mobileqq.activity.contacts.topentry.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface);
            return;
        }
        super.e(qQAppInterface);
        super.e(qQAppInterface);
        if (this.f181771e != qQAppInterface) {
            this.f181771e = qQAppInterface;
        }
        C();
        E();
    }

    @Override // com.tencent.mobileqq.activity.contacts.topentry.b, com.tencent.mobileqq.activity.contacts.base.a
    public void g(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        super.g(view);
        C();
        if (SimpleUIUtil.isNowElderMode()) {
            this.f181775m.setTextSize(0, ViewUtils.dpToPx(18.0f));
        }
        this.f181774i.setOnClickListener(this);
        O();
        this.L = (RelativeLayout) view.findViewById(R.id.f29480lr);
        this.M = (TextView) view.findViewById(R.id.f29460lp);
        this.N = (ImageView) view.findViewById(R.id.f29470lq);
        this.M.setOnClickListener(new e());
        this.N.setOnClickListener(new f());
        B(this.L, "em_pmyk_guide_bar");
        B(this.M, "em_pymk_open_btn");
        B(this.N, "em_bas_close");
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.h();
        M();
        XListView xListView = this.D;
        if (xListView != null) {
            xListView.setAdapter((ListAdapter) null);
        }
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            mayknowRecommendsAdapter.onDestroy();
        }
        this.G = null;
        this.f181772f.setVisibility(8);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.contacts.topentry.b, com.tencent.mobileqq.activity.contacts.base.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.i();
            E();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.topentry.b, com.tencent.mobileqq.activity.contacts.base.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.j();
        if (QLog.isColorLevel()) {
            QLog.i("MayKnowPersonEntryControllerSimplify", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        WeakReferenceHandler weakReferenceHandler = this.K;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
        }
        M();
        this.E = null;
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            mayknowRecommendsAdapter.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void k(boolean z16) {
        CTEntryMng cTEntryMng;
        int d16;
        MayknowRecommendsAdapter mayknowRecommendsAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.k(z16);
        if (QLog.isColorLevel()) {
            QLog.i("MayKnowPersonEntryControllerSimplify", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).removePYMKSwitchChangeListener(this.U, "MayKnowPersonEntryControllerSimplify");
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeListener(this.T, 4);
        this.J = true;
        if (z16 && (cTEntryMng = this.H) != null && cTEntryMng.w() != null) {
            com.tencent.mobileqq.activity.contacts.topentry.e w3 = this.H.w();
            if (!G() || (d16 = w3.d()) <= 0) {
                return;
            }
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).setTimeStampAndResort(d16, 4);
            List<MayKnowRecommend> localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData(4);
            int min = Math.min(localRecommendData.size(), d16);
            if (min != 0 && (mayknowRecommendsAdapter = this.G) != null) {
                mayknowRecommendsAdapter.s(localRecommendData.subList(0, min));
                this.G.o();
                return;
            }
            return;
        }
        QLog.i("MayKnowPersonEntryControllerSimplify", 1, "onPause tabChanged " + z16 + " " + this.H);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.l(z16);
        ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).addPYMKSwitchChangeListener(this.U, "MayKnowPersonEntryControllerSimplify");
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).addListener(this.T, 4);
        StudyModeManager.H(this.R);
        if (QLog.isColorLevel()) {
            QLog.i("MayKnowPersonEntryControllerSimplify", 2, "onResume");
        }
        w();
        this.I = false;
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            mayknowRecommendsAdapter.p();
        }
        this.J = false;
    }

    @Override // com.tencent.mobileqq.activity.contacts.topentry.b
    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
        if (mayknowRecommendsAdapter != null) {
            mayknowRecommendsAdapter.q(z16);
        }
        FrameLayout frameLayout = this.f181772f;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
        this.f181773h.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<MayKnowRecommend> h16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f166766i32) {
            Intent intent = new Intent(this.f181499d, (Class<?>) RecommendFriendActivity.class);
            intent.putExtra("EntranceId", 8);
            intent.putExtra("key_add_friend_sub_id", 65);
            MayknowRecommendsAdapter mayknowRecommendsAdapter = this.G;
            if (mayknowRecommendsAdapter != null && (h16 = mayknowRecommendsAdapter.h()) != null && !h16.isEmpty()) {
                intent.putExtra("may_know_recmmds", h16);
            }
            this.f181499d.startActivity(intent);
            ContactReportUtils.j(this.f181771e, "", "banner_recomlist_clk");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void O() {
    }
}
