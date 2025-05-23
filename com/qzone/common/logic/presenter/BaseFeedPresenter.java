package com.qzone.common.logic.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneBaseFeedAdapter;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor;
import com.qzone.common.logic.observer.BaseFeedObserver;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.ui.activity.QZoneMyFeedFragment;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.module.feedcomponent.ui.RecomFollowVerticalFeedView;
import com.qzone.personalize.ArchiveMemorySettingGuide;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.util.l;
import com.qzone.widget.EditPositionBag;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.qzone.widget.util.b;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import d5.k;
import d5.u;
import e8.e;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes39.dex */
public class BaseFeedPresenter implements b6.a, com.qzone.feed.utils.e, ArchiveMemorySettingGuide.c {
    public static int Q = 256;
    public static int R = 257;
    public static int S = 258;
    public static int T = 259;
    public static int U = 260;
    public static int V = 261;
    public static int W = 262;
    public static int X = 263;
    public static int Y = 264;
    public static int Z = 150;

    /* renamed from: a0, reason: collision with root package name */
    public static int f46081a0 = 151;

    /* renamed from: b0, reason: collision with root package name */
    public static int f46082b0 = 152;

    /* renamed from: c0, reason: collision with root package name */
    public static int f46083c0 = 153;

    /* renamed from: d0, reason: collision with root package name */
    public static String f46084d0 = "BaseFeedPresenter";

    @Deprecated
    final QZoneBaseFeedFragment C;
    private final u D;
    RedPocketHideLoadingRunnable E;
    private b.c F;
    private long G;
    private g H;
    protected b6.b I;
    private boolean J;
    private boolean K;
    private boolean L;
    boolean M;
    private int N;
    protected ClickedComment P;

    /* renamed from: d, reason: collision with root package name */
    public String f46085d;

    /* renamed from: e, reason: collision with root package name */
    protected BusinessFeedData f46086e;

    /* renamed from: f, reason: collision with root package name */
    protected BaseFeedObserver f46087f;

    /* renamed from: h, reason: collision with root package name */
    protected BaseFeedClickProcessor f46088h;

    /* renamed from: i, reason: collision with root package name */
    protected Dialog f46089i;

    /* renamed from: m, reason: collision with root package name */
    protected int f46090m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class RedPocketHideLoadingRunnable implements Runnable {
        RedPocketHideLoadingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseFeedPresenter.this.g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46094d;

        a(BusinessFeedData businessFeedData) {
            this.f46094d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (BaseFeedPresenter.this.k()) {
                BaseFeedPresenter.this.t(this.f46094d);
                LpReportInfo_pf00064.allReport(611, 1);
            } else {
                c6.a.h(R.string.ghi);
            }
        }
    }

    /* loaded from: classes39.dex */
    class b implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f46096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f46097b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f46098c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f46099d;

        b(long j3, String str, long j16, long j17) {
            this.f46096a = j3;
            this.f46097b = str;
            this.f46098c = j16;
            this.f46099d = j17;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QzoneFavoriteService.M().I(this.f46096a, str, this.f46097b, this.f46098c, this.f46099d, BaseFeedPresenter.this.E());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46101d;

        c(BusinessFeedData businessFeedData) {
            this.f46101d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (BaseFeedPresenter.this.k()) {
                BaseFeedPresenter.this.p(this.f46101d, false);
            } else {
                c6.a.h(R.string.ghi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BaseFeedPresenter.this.M = i3 == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46104d;

        e(BusinessFeedData businessFeedData) {
            this.f46104d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!BaseFeedPresenter.this.k()) {
                c6.a.h(R.string.ghi);
                return;
            }
            BaseFeedPresenter baseFeedPresenter = BaseFeedPresenter.this;
            baseFeedPresenter.p(this.f46104d, baseFeedPresenter.M);
            u5.b.p0("key_last_checked_state_del_media_file", BaseFeedPresenter.this.M, LoginData.getInstance().getUin());
        }
    }

    public BaseFeedPresenter(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        this(qZoneBaseFeedFragment, qZoneBaseFeedFragment);
    }

    private static int I(int i3) {
        if (i3 == 2) {
            return 2;
        }
        return 1;
    }

    public static int J(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData.isGDTAdvFeed()) {
            switch (i3) {
                case 1:
                    return A(businessFeedData.getCellUserInfo().actionType, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 2:
                    return A(businessFeedData.getCellSummaryV2().actionType, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 3:
                    return A(businessFeedData.getPictureInfo().actiontype, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 4:
                    return A(businessFeedData.getRecommAction().actionType, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 5:
                default:
                    return I(businessFeedData.getOperationInfo().actionType);
                case 6:
                    return A(businessFeedData.getCellAdvContainerAttach().actiontype, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 7:
                    return A(businessFeedData.getVideoInfo().actionType, businessFeedData.getOperationInfo().actionType, businessFeedData);
                case 8:
                    break;
                case 9:
                    return 2;
                case 10:
                    return 1;
            }
        }
        return -1;
    }

    public static int M(BusinessFeedData businessFeedData, int i3, int i16) {
        if ((businessFeedData.getCellAdvContainerAttach() != null && businessFeedData.getCellAdvContainerAttach().actiontype == 2) || l0(businessFeedData, i16)) {
            return 5000;
        }
        if (J(businessFeedData, i16) != -1) {
            return 5001;
        }
        return i3;
    }

    private void M0() {
        if (this.I == null) {
            return;
        }
        L0();
        D0();
    }

    private void R0(BusinessFeedData businessFeedData) {
        this.M = QZoneFeedUtil.z();
        this.I.j(230, null, BaseApplication.getContext().getString(R.string.gey), QZoneFeedUtil.A(businessFeedData), this.M, BaseApplication.getContext().getString(R.string.gd5), BaseApplication.getContext().getString(R.string.a8j), new d(), new e(businessFeedData), new f());
    }

    private void S0(e.a aVar, Serializable serializable, Parcelable parcelable, EditPositionBag editPositionBag, Map<String, Object> map) {
        Intent I = QZoneFeedUtil.I(x(), aVar, serializable, parcelable, editPositionBag, true, 1, map);
        I.putExtra("show_barrage_effect_icon", aVar.f47473f);
        I.putExtra("from_ttt_page_id", ap.a());
        if (this.I != null && QZoneMyFeedFragment.class.getSimpleName().equals(this.I.getClass().getSimpleName())) {
            I.putExtra("extra_key_from_scene", 6);
        }
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
            QzonePluginProxyActivity.setActivityNameToIntent(I, QZoneHelper.QZONE_FEEDACTIONPANELACTIVITY);
        }
        if (com.qzone.feed.utils.b.b(I)) {
            return;
        }
        this.C.getContainerInf().startActivityForResult(I, aVar.f47476i);
    }

    private void T(QZoneResult qZoneResult) {
        String string;
        boolean z16 = qZoneResult.getBundle().getBoolean("isLongClick", false);
        if (qZoneResult.getSucceed()) {
            int intValue = ((Integer) qZoneResult.getData()).intValue();
            if (intValue == 1) {
                string = N().getString(R.string.akw);
            } else if (intValue != 2) {
                string = intValue != 7 ? null : N().getString(R.string.f170824al0);
            } else {
                string = N().getString(R.string.f170825al1);
            }
            c6.a.j(string, 5);
            if (z16) {
                LpReportInfo_pf00064.allReport(85, 6, 1);
                return;
            }
            return;
        }
        c6.a.i(qZoneResult.getMessage());
        if (z16) {
            LpReportInfo_pf00064.allReport(85, 6, 2);
        }
    }

    private void T0(Activity activity) {
        if (this.f46089i == null) {
            this.f46089i = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (activity.isFinishing()) {
            return;
        }
        this.f46089i.show();
    }

    private void U(QZoneResult qZoneResult) {
        if (qZoneResult.getReturnCode() == 0) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShieldSuccess", "\u5c4f\u853d\u6210\u529f"));
        } else {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShieldFail", "\u5c4f\u853d\u5931\u8d25"));
        }
    }

    private void X(QZoneResult qZoneResult) {
        if (!qZoneResult.getSucceed()) {
            if (!TextUtils.isEmpty(qZoneResult.getMessage())) {
                c6.a.i(qZoneResult.getMessage());
                return;
            } else {
                c6.a.h(R.string.gds);
                return;
            }
        }
        J0();
    }

    private void a0(QZoneResult qZoneResult) {
        if (qZoneResult.getReturnCode() == 0) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportSuccess", "\u4e3e\u62a5\u6210\u529f"));
            return;
        }
        if (qZoneResult.getReturnCode() == -10108) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportYet", "\u5df2\u4e3e\u62a5\u8fc7"));
            return;
        }
        c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportFail", "\u4e3e\u62a5\u5931\u8d25 code:") + qZoneResult.getReturnCode());
    }

    private void b0(QZoneResult qZoneResult) {
        int i3 = qZoneResult.what;
        if (i3 == 1000106) {
            if (qZoneResult.getSucceed()) {
                c6.a.j(P(R.string.gny), 5);
                X0(qZoneResult.getFeedId());
                M0();
                return;
            }
            c6.a.j(P(R.string.gnx), 5);
            return;
        }
        if (i3 == 1000107) {
            if (qZoneResult.getSucceed()) {
                c6.a.j(P(R.string.gd8), 5);
                V0();
                M0();
                return;
            }
            c6.a.j(P(R.string.gd7), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Dialog dialog = this.f46089i;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f46089i.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        try {
            E().removeCallbacks(this.E);
            b.c cVar = this.F;
            if (cVar == null || !cVar.isShowing()) {
                return;
            }
            this.F.dismiss();
        } catch (Exception unused) {
        }
    }

    private void j(BusinessFeedData businessFeedData) {
        if (LoginData.getInstance().getUin() != businessFeedData.getHostUin()) {
            return;
        }
        un.c.e().m(businessFeedData.getFeedCommInfo().clientkey);
    }

    private boolean m0(BusinessFeedData businessFeedData) {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_SING_ALBUM_FEED_USE_CMD_DELIC, 0) == 0) {
            return false;
        }
        return (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().uploadnum == 1) || (businessFeedData.getOriginalInfoSafe().getPictureInfo() != null && businessFeedData.getOriginalInfoSafe().getPictureInfo().uploadnum == 1) || QZoneFeedUtil.w(businessFeedData);
    }

    public void A0(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        switch (message.what) {
            case 66303:
                p0();
                return;
            case 70146:
                U0();
                return;
            case 70147:
                f0();
                return;
            case 999905:
            case 999907:
                V(unpack);
                return;
            case 999906:
                d0(unpack);
                return;
            case 999908:
                T(unpack);
                return;
            case 999909:
                X(unpack);
                return;
            case 999927:
                Z(unpack);
                return;
            case 999978:
                W(unpack);
                return;
            case 999984:
                if (unpack.getSucceed()) {
                    I0(0L);
                    return;
                } else {
                    c6.a.i(unpack.getMessage());
                    return;
                }
            case 1000028:
                unpack.getSucceed();
                c6.a.i(unpack.getMessage());
                return;
            case 1000029:
                unpack.getSucceed();
                c6.a.i(unpack.getMessage());
                return;
            case 1000083:
                this.I.b4(unpack != null && unpack.getSucceed(), unpack == null ? null : unpack.getBundle());
                return;
            case 1000106:
            case 1000107:
                b0(unpack);
                return;
            case 1000112:
                Y(unpack);
                return;
            case 1000130:
                c0(unpack);
                return;
            case 1000176:
                a0(unpack);
                return;
            case 1000178:
                U(unpack);
                return;
            case 1000185:
                if (unpack.getSucceed()) {
                    return;
                }
                c6.a.i(unpack.getMessage());
                return;
            default:
                return;
        }
    }

    EditPositionBag B() {
        if (this.f46088h != null) {
            return C().b0();
        }
        return null;
    }

    public void B0(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        if (this.L) {
            return;
        }
        com.qzone.feed.utils.c.e();
        if (x() != null) {
            T0(x());
            this.L = true;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<PictureItem> it = businessFeedData.getPictureInfo().pics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().bigUrl.url);
        }
        com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.common.logic.presenter.BaseFeedPresenter.2

            /* renamed from: com.qzone.common.logic.presenter.BaseFeedPresenter$2$a */
            /* loaded from: classes39.dex */
            class a implements u4.f {
                a() {
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void a(String str, ArrayList<String> arrayList) {
                    if (BaseFeedPresenter.this.x() == null) {
                        return;
                    }
                    BaseFeedPresenter.this.e0();
                    BaseFeedPresenter.this.L = false;
                    com.qzone.util.image.c.j(arrayList);
                    qo.c.e(BaseFeedPresenter.this.x(), com.qzone.util.image.c.p(BaseFeedPresenter.this.x(), arrayList));
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void onDownloadFailed(String str) {
                    BaseFeedPresenter.this.e0();
                    BaseFeedPresenter.this.L = false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                u4.a.z().t(BaseFeedPresenter.this.x(), System.currentTimeMillis() + "", arrayList, new a());
            }
        });
    }

    public final BaseFeedClickProcessor C() {
        if (this.f46088h == null) {
            this.f46088h = l();
        }
        return this.f46088h;
    }

    public void C0() {
        BaseFeedClickProcessor baseFeedClickProcessor = this.f46088h;
        if (baseFeedClickProcessor != null) {
            baseFeedClickProcessor.k1();
        }
    }

    public b6.b D() {
        return this.I;
    }

    @Deprecated
    public void D0() {
        this.C.onRefresh();
    }

    @Override // com.qzone.personalize.ArchiveMemorySettingGuide.c
    public void D4(CharSequence charSequence) {
        this.I.r5(charSequence);
    }

    @Deprecated
    public Handler E() {
        return this.C.getHandler();
    }

    public Object F(int i3, boolean z16) {
        QZonePullToRefreshListView Q2 = Q();
        ListAdapter adapter = Q2 == null ? null : Q2.j0().getAdapter();
        if (adapter == null) {
            return null;
        }
        if (z16 && (adapter instanceof HeaderViewListAdapter)) {
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter.getCount() > i3) {
            return Q2.j0().getItemAtPosition(i3);
        }
        return null;
    }

    public final BaseFeedObserver G() {
        if (this.f46087f == null) {
            this.f46087f = m();
        }
        return this.f46087f;
    }

    public void G0(BusinessFeedData businessFeedData) {
        new com.qzone.component.e().g(x(), null, BaseApplication.getContext().getString(R.string.gno), new a(businessFeedData), null);
        LpReportInfo_pf00064.allReport(302, 80);
    }

    @Deprecated
    public Activity H() {
        return this.D.getActivity();
    }

    @Deprecated
    public void I0(long j3) {
        this.C.mj(j3);
    }

    public void J0() {
        this.I.ab();
    }

    public QZoneBaseFeedFragment K() {
        return this.C;
    }

    public void L0() {
        this.I.scrollToTop();
    }

    @Override // d5.n
    public boolean Lc() {
        return true;
    }

    public Resources N() {
        return BaseApplication.getContext().getResources();
    }

    public void N0(ClickedComment clickedComment) {
        this.P = clickedComment;
    }

    public final BusinessFeedData O(boolean z16) {
        QZonePullToRefreshListView Q2 = Q();
        BusinessFeedData businessFeedData = null;
        ListAdapter adapter = Q2 == null ? null : Q2.j0().getAdapter();
        if (adapter != null) {
            if (z16 && (adapter instanceof HeaderViewListAdapter)) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                businessFeedData = (BusinessFeedData) Q2.j0().getItemAtPosition(i3);
                if (businessFeedData != null && businessFeedData.isSecretFeed()) {
                    return businessFeedData;
                }
            }
        }
        return businessFeedData;
    }

    public void O0(boolean z16) {
        this.K = z16;
    }

    public String P(int i3) {
        return N().getString(i3);
    }

    public void P0(int i3) {
        this.f46090m = i3;
    }

    @Deprecated
    public QZonePullToRefreshListView Q() {
        return this.C.zi();
    }

    public void Q0(int i3) {
        this.N = i3;
    }

    public int R() {
        return this.f46090m;
    }

    public int S() {
        return this.N;
    }

    public void U0() {
        try {
            if (this.F == null) {
                b.c d16 = com.qzone.widget.util.b.d(H());
                this.F = d16;
                d16.setTitle("");
            }
            if (this.F.isShowing()) {
                return;
            }
            this.F.show();
        } catch (Exception unused) {
        }
    }

    public void W0(long j3, boolean z16) {
        QZonePullToRefreshListView Q2 = Q();
        for (int i3 = 0; i3 < Q2.getCount(); i3++) {
            View childAt = Q2.getChildAt(i3);
            if (childAt != null && (childAt instanceof AbsFeedView)) {
                AbsFeedView absFeedView = (AbsFeedView) childAt;
                if (absFeedView instanceof NormalAbsFeedView) {
                    BusinessFeedData businessFeedData = absFeedView.mFeedData;
                    if (businessFeedData != null && businessFeedData.getUser().uin == j3) {
                        businessFeedData.getFeedCommInfo().isFollowed = z16;
                        if (businessFeedData.getRecommAction() != null) {
                            businessFeedData.getRecommAction().hasFollowed = z16 ? 1 : 0;
                        }
                        Z0(businessFeedData, z16);
                        absFeedView.updateFollowInfo(businessFeedData, j3, z16);
                    } else if (businessFeedData != null && businessFeedData.getOriginalInfoSafe().getUser().uin == j3) {
                        businessFeedData.getOriginalInfoSafe().getFeedCommInfo().isFollowed = z16;
                        if (businessFeedData.getOriginalInfoSafe().getRecommAction() != null) {
                            businessFeedData.getRecommAction().hasFollowed = z16 ? 1 : 0;
                        }
                        Z0(businessFeedData, z16);
                        absFeedView.updateFollowInfo(businessFeedData, j3, z16);
                    }
                } else if (absFeedView instanceof FeedAdvContainer) {
                    absFeedView.updateFollowInfo(null, j3, z16);
                } else if (absFeedView instanceof RecomFollowVerticalFeedView) {
                    absFeedView.updateFollowInfo(null, j3, z16);
                }
            }
        }
    }

    public void Y0(long j3, boolean z16) {
        QZonePullToRefreshListView Q2 = Q();
        for (int i3 = 0; i3 < Q2.getCount(); i3++) {
            View childAt = Q2.getChildAt(i3);
            if (childAt != null && (childAt instanceof AbsFeedView)) {
                AbsFeedView absFeedView = (AbsFeedView) childAt;
                if (absFeedView instanceof NormalAbsFeedView) {
                    BusinessFeedData businessFeedData = absFeedView.mFeedData;
                    if (businessFeedData != null && businessFeedData.getUser().uin == j3) {
                        businessFeedData.getFeedCommInfo().isSpecialFollowed = z16;
                        a1(businessFeedData, z16);
                        absFeedView.updateSpecialFollowInfo(businessFeedData, j3, z16);
                    } else if (businessFeedData != null && businessFeedData.getOriginalInfoSafe().getUser().uin == j3) {
                        businessFeedData.getOriginalInfoSafe().getFeedCommInfo().isSpecialFollowed = z16;
                        a1(businessFeedData, z16);
                        absFeedView.updateSpecialFollowInfo(businessFeedData, j3, z16);
                    }
                } else if (absFeedView instanceof FeedAdvContainer) {
                    absFeedView.updateSpecialFollowInfo(null, j3, z16);
                } else if (absFeedView instanceof RecomFollowVerticalFeedView) {
                    absFeedView.updateSpecialFollowInfo(null, j3, z16);
                }
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public final boolean a(FeedElement feedElement, Object obj, View view, CellTextView.OnTextOperater onTextOperater) {
        C().a(feedElement, obj, view, onTextOperater);
        return false;
    }

    @Override // d5.n
    public void b9(k<BusinessFeedData> kVar) {
        long a16 = kVar.a();
        String d16 = kVar.d();
        QzoneFavoriteService.M().Q(new b(a16, d16, kVar.getAppId(), kVar.c()), d16);
    }

    public void f0() {
        E().postDelayed(this.E, 0L);
    }

    public void i() {
        G().a();
    }

    public void i0(com.qzone.proxy.feedcomponent.widget.d dVar) {
        if (this.H == null) {
            this.H = new g();
        }
        this.H.b(dVar);
        e8.f.a().b().g(this.H);
    }

    boolean k() {
        return NetworkState.isNetSupport();
    }

    public void k0(BusinessFeedData businessFeedData, int i3, boolean z16, int i16) {
        this.f46086e = businessFeedData;
        if (businessFeedData.getLeftThumb() != null || (businessFeedData.getOriginalInfoSafe() != null && businessFeedData.getOriginalInfoSafe().getLeftThumb() != null)) {
            if (businessFeedData.getLeftThumb() != null && !TextUtils.isEmpty(businessFeedData.getLeftThumb().remark)) {
                if (businessFeedData.getLeftThumb().isUsePost()) {
                    this.I.la(businessFeedData.getLeftThumb().getActionUrl(), businessFeedData.getLeftThumb().getPostDatas(), null);
                    return;
                } else {
                    this.I.la(businessFeedData.getLeftThumb().getActionUrl(), null, null);
                    return;
                }
            }
            if (businessFeedData.getOriginalInfoSafe().getLeftThumb() != null && !TextUtils.isEmpty(businessFeedData.getOriginalInfoSafe().getLeftThumb().remark)) {
                if (businessFeedData.getOriginalInfoSafe().getLeftThumb().isUsePost()) {
                    this.I.la(businessFeedData.getOriginalInfoSafe().getLeftThumb().getActionUrl(), businessFeedData.getOriginalInfoSafe().getLeftThumb().getPostDatas(), null);
                    return;
                } else {
                    this.I.la(businessFeedData.getOriginalInfoSafe().getLeftThumb().getActionUrl(), null, null);
                    return;
                }
            }
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            ClickReport.c(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER, 1, "", true, new String[0]);
        }
        this.I.Wa(businessFeedData, i3, 0L, i16);
    }

    protected BaseFeedClickProcessor l() {
        return new BaseFeedClickProcessor(this, this.I);
    }

    protected BaseFeedObserver m() {
        return new BaseFeedObserver(this);
    }

    @Deprecated
    public boolean n0() {
        return this.C.isResumed(32);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public void onClick(View view, FeedElement feedElement, int i3, Object obj) {
        try {
            C().onClick(view, feedElement, i3, obj);
        } catch (Exception e16) {
            QLog.e(f46084d0, 1, "onClick error", e16);
        }
    }

    public void p0() {
        this.I.H8();
    }

    public void t0() {
        if (this.H != null) {
            e8.f.a().b().o(this.H);
        }
        EditPositionBag B = B();
        if (B != null) {
            EditPositionBag.q(B.j());
        }
        BaseFeedClickProcessor baseFeedClickProcessor = this.f46088h;
        if (baseFeedClickProcessor != null) {
            baseFeedClickProcessor.Q0();
            this.f46088h = null;
        }
    }

    public void u0(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        this.I.og(view, businessFeedData, i3, obj);
    }

    @Deprecated
    public Activity x() {
        return this.D.getActivity();
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
        S0(aVar, serializable, parcelable, B(), map);
    }

    public Context y() {
        return BaseApplication.getContext();
    }

    public ClickedComment z() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class g implements e8.e {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<com.qzone.proxy.feedcomponent.widget.d> f46107d;

        g() {
        }

        public void b(com.qzone.proxy.feedcomponent.widget.d dVar) {
            WeakReference<com.qzone.proxy.feedcomponent.widget.d> weakReference = this.f46107d;
            com.qzone.proxy.feedcomponent.widget.d dVar2 = weakReference != null ? weakReference.get() : null;
            if (dVar2 != null) {
                dVar2.stop();
            }
            this.f46107d = dVar != null ? new WeakReference<>(dVar) : null;
        }

        @Override // e8.e
        public void a(e.a aVar) {
            if (aVar == null || aVar.f395852b == null) {
                return;
            }
            WeakReference<com.qzone.proxy.feedcomponent.widget.d> weakReference = this.f46107d;
            com.qzone.proxy.feedcomponent.widget.d dVar = weakReference != null ? weakReference.get() : null;
            int i3 = aVar.f395854d;
            if (i3 != 1 && i3 != 2) {
                if ((i3 == 3 || i3 == 4) && dVar != null && dVar.getUniKey() != null && dVar.getUniKey().equals(aVar.f395852b.f251870h)) {
                    dVar.stop();
                }
                BaseFeedPresenter.this.G = -1L;
                BaseFeedPresenter baseFeedPresenter = BaseFeedPresenter.this;
                baseFeedPresenter.f46085d = "";
                baseFeedPresenter.p0();
                return;
            }
            if (dVar != null && dVar.getUniKey() != null && dVar.getUniKey().equals(aVar.f395852b.f251870h)) {
                dVar.play();
            }
            if (aVar.f395851a != 5) {
                long j3 = BaseFeedPresenter.this.G;
                long j16 = aVar.f395852b.f251867d;
                if (j3 != j16) {
                    BaseFeedPresenter.this.G = j16;
                    BaseFeedPresenter baseFeedPresenter2 = BaseFeedPresenter.this;
                    baseFeedPresenter2.f46085d = "";
                    baseFeedPresenter2.p0();
                    return;
                }
                return;
            }
            if (BaseFeedPresenter.this.f46085d.equals(aVar.f395852b.f251870h)) {
                return;
            }
            BaseFeedPresenter baseFeedPresenter3 = BaseFeedPresenter.this;
            String str = aVar.f395852b.f251870h;
            baseFeedPresenter3.f46085d = str;
            if (str == null) {
                baseFeedPresenter3.f46085d = "";
            }
            baseFeedPresenter3.G = -1L;
            BaseFeedPresenter.this.p0();
        }
    }

    public BaseFeedPresenter(QZoneBaseFeedFragment qZoneBaseFeedFragment, b6.b bVar) {
        this.f46085d = "";
        this.f46090m = -1;
        this.E = new RedPocketHideLoadingRunnable();
        this.G = -1L;
        this.H = null;
        this.J = false;
        this.K = false;
        this.N = -1;
        this.P = null;
        this.C = qZoneBaseFeedFragment;
        this.I = bVar;
        this.D = qZoneBaseFeedFragment.getContainerInf();
    }

    public void h0() {
        i0(null);
    }

    public void j0(BusinessFeedData businessFeedData, int i3, boolean z16) {
        k0(businessFeedData, i3, z16, -1);
    }

    public void s0(BusinessFeedData businessFeedData) {
        p(businessFeedData, false);
    }

    private void V(QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            boolean succeed = qZoneResult.getSucceed();
            if (succeed) {
                return;
            }
            c6.a.i(qZoneResult.getMessage());
        }
    }

    private void W(QZoneResult qZoneResult) {
        if (qZoneResult == null || qZoneResult.getSucceed()) {
            return;
        }
        c6.a.i(qZoneResult.getMessage());
    }

    private void Z(QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            if (!qZoneResult.getSucceed()) {
                ToastUtil.r(l.a(R.string.f171640jy4) + qZoneResult.getReturnCode() + ")");
            }
            Bundle bundle = (Bundle) qZoneResult.getData();
            if (bundle != null) {
                BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
                businessFeedData.getCommentInfo().moreCommentHasLoaded = (byte) 1;
                businessFeedData.getCommentInfo().commentState = CellCommentInfo.CommentState.UNFOLD;
                businessFeedData.getCommentInfo().preCalculate();
            }
            p0();
        }
    }

    private void Z0(BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null || !businessFeedData.isSingleAdvContainerFeed()) {
            return;
        }
        for (BusinessFeedData businessFeedData2 : businessFeedData.getRecBusinessFeedDatas()) {
            if (businessFeedData2.getRecommAction() != null) {
                businessFeedData2.getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
            if (businessFeedData2.getFeedCommInfo() != null) {
                businessFeedData2.getFeedCommInfo().isFollowed = z16;
            }
        }
    }

    private void a1(BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null || !businessFeedData.isSingleAdvContainerFeed()) {
            return;
        }
        for (BusinessFeedData businessFeedData2 : businessFeedData.getRecBusinessFeedDatas()) {
            if (businessFeedData2.getFeedCommInfo() != null) {
                businessFeedData2.getFeedCommInfo().isFollowed = z16;
            }
        }
    }

    private void d0(QZoneResult qZoneResult) {
        if (qZoneResult != null && !qZoneResult.getSucceed()) {
            c6.a.i(qZoneResult.getMessage());
        }
        J0();
    }

    public void F0(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
            String stringExtra2 = intent.getStringExtra("contentIntentKey");
            BusinessFeedData businessFeedData = QZoneFeedUtil.f47421a.get("activity_result_ahare_to_qzone_key");
            if (businessFeedData != null && businessFeedData.getFeedCommInfo().recomtype == 7) {
                i H = i.H();
                int S2 = S();
                i.H();
                H.U1(S2, "2");
            }
            QZoneFeedUtil.t(businessFeedData, stringExtra2, 2, null, stringExtra, E(), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, false), 0, false, intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, false));
            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            i.H();
            uiInterface.doCommentActionReport(3);
        }
    }

    public final void K0(BusinessFeedData businessFeedData) {
        QZonePullToRefreshListView Q2;
        if (businessFeedData == null || "1".equals(GdtFeedUtilForQZone.g(businessFeedData)) || (Q2 = Q()) == null) {
            return;
        }
        Q2.j0().getAdapter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BusinessFeedData L(String str, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && !TextUtils.isEmpty(str) && businessFeedData.getFeedCommInfo() != null && !str.equals(businessFeedData.getFeedCommInfo().feedskey)) {
            QZoneBaseFeedFragment qZoneBaseFeedFragment = this.C;
            BusinessFeedData businessFeedData2 = null;
            if (qZoneBaseFeedFragment != null && (qZoneBaseFeedFragment.ri() instanceof QZoneBaseFeedAdapter)) {
                QZoneBaseFeedAdapter qZoneBaseFeedAdapter = (QZoneBaseFeedAdapter) this.C.ri();
                for (int i3 = 0; i3 < qZoneBaseFeedAdapter.getCount(); i3++) {
                    if (str.equals(qZoneBaseFeedAdapter.g(i3))) {
                        businessFeedData2 = qZoneBaseFeedAdapter.getItem(i3);
                    }
                }
            }
            businessFeedData = businessFeedData2;
            if (businessFeedData == null) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
            }
        }
        return businessFeedData;
    }

    public void r0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || this.I == null) {
            return;
        }
        if (QZoneFeedUtil.U(businessFeedData)) {
            R0(businessFeedData);
        } else {
            this.I.Gc(null, QZoneFeedUtil.D(businessFeedData), new c(businessFeedData));
        }
    }

    public void z0(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
            QZoneFeedUtil.t(QZoneFeedUtil.f47421a.get("current_forward_key"), intent.getStringExtra("contentIntentKey"), 1, null, stringExtra, E(), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, false), 0, false, intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, false));
            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            i.H();
            uiInterface.doCommentActionReport(3);
        }
    }

    private void Y(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (!qZoneResult.getSucceed()) {
            if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
                c6.a.i(qZoneResult.getMessage());
                return;
            } else {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastConcernFail", "\u5173\u6ce8\u5931\u8d25"));
                return;
            }
        }
        W0(qZoneResult.getBundle().getLong("uin", 0L), qZoneResult.getBundle().getBoolean("isFollow", false));
    }

    private void c0(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (!qZoneResult.getSucceed()) {
            if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
                c6.a.i(qZoneResult.getMessage());
                return;
            } else {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastConcernFail", "\u5173\u6ce8\u5931\u8d25"));
                return;
            }
        }
        Y0(qZoneResult.getBundle().getLong("uin", 0L), qZoneResult.getBundle().getBoolean("iSpecialFollow", false));
    }

    public static boolean l0(BusinessFeedData businessFeedData, int i3) {
        return i3 == 6 || J(businessFeedData, i3) == 2;
    }

    public static void q0(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, BusinessFeedData businessFeedData, int i26, int i27, int i28, int i29, boolean z27) {
        if (z27) {
            return;
        }
        QZoneWriteOperationService.v0().L(map, i3, i16, i17, i18, i19, z16, z17, str, str2, j3, z18, z19, str3, z26, businessFeedData);
        QZLog.i(f46084d0, "sdkTest reportTest not in video1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        QZoneWriteOperationService.v0().k2(E(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().clientkey);
    }

    public static int w(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return i3;
        }
        if (com.qzone.misc.network.report.f.h(businessFeedData).equals("app")) {
            return 4;
        }
        if (com.qzone.misc.network.report.f.h(businessFeedData).equals("certify_page") || com.qzone.misc.network.report.f.h(businessFeedData).equals("certify_page_outlink")) {
            return 9;
        }
        if (com.qzone.misc.network.report.f.h(businessFeedData).equals("outlink")) {
            return 33;
        }
        return i3;
    }

    public void E0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if ((i3 == 311 || i3 == 6100) && com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask2, 27)) {
            QZoneWriteOperationService.v0().i2(E(), businessFeedData.getIdInfo().cellId, businessFeedData.getFeedCommInfo().ugckey);
        } else {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToEdit", "\u8be5\u8bf4\u8bf4\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u7f16\u8f91"));
        }
    }

    public int n(BusinessFeedData businessFeedData, int i3, int i16, String str, Object... objArr) {
        QZonePullToRefreshListView Q2;
        String str2;
        Object obj;
        BusinessFeedData businessFeedData2;
        boolean z16 = false;
        if (businessFeedData == null || businessFeedData.getOperationInfo().actionType == 0 || (Q2 = Q()) == null) {
            return 0;
        }
        int headerViewsCount = (i3 - Q2.j0().getHeaderViewsCount()) + 1;
        if (businessFeedData.getOperationInfo().actionType == 5) {
            long j3 = businessFeedData.getUser().uin;
            if (j3 <= 0 && (businessFeedData2 = businessFeedData.parentFeedData) != null) {
                j3 = businessFeedData2.getUser().uin;
            }
            this.I.mh(j3, 0, str);
            z16 = true;
        } else if (businessFeedData.getOperationInfo().actionType == 21) {
            q(null, businessFeedData, headerViewsCount, false, false, false);
        } else {
            String str3 = null;
            if (businessFeedData.getOperationInfo().actionType == 23) {
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str3 = businessFeedData.getOperationInfo().postParams;
                }
                yo.g gVar = new yo.g(businessFeedData.getOperationInfo().schemaPageUrl, str3);
                HashMap hashMap = new HashMap();
                hashMap.put("key1", businessFeedData.getOperationInfo().downloadUrl);
                hashMap.put("key2", businessFeedData.getOperationInfo().click_stream_report);
                hashMap.put("key3", businessFeedData);
                gVar.f450714g = hashMap;
                this.I.la(businessFeedData.getOperationInfo().schemaPageUrl, str3, hashMap);
            } else if (businessFeedData.getOperationInfo().actionType == 2) {
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str3 = businessFeedData.getOperationInfo().postParams;
                }
                if (businessFeedData.getFeedCommInfo().needAdvReport() && businessFeedData.getOperationInfo().downloadUrl != null && objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && (obj instanceof View)) {
                    str2 = c6.a.d((View) obj);
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = "&s=" + str2;
                    }
                } else {
                    str2 = "";
                }
                String str4 = businessFeedData.getOperationInfo().downloadUrl;
                if (str4 != null && !str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str4 = str4 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("businessFeedData", businessFeedData);
                if (!businessFeedData.isGDTAdvFeed()) {
                    this.I.la(str4 + str2, str3, hashMap2);
                }
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=" + headerViewsCount + " url=" + businessFeedData.getOperationInfo().downloadUrl + str2);
            }
        }
        if (!z16) {
            com.qzone.misc.network.ttt.a.c().f(str);
        }
        return businessFeedData.getOperationInfo().actionType;
    }

    public void o0(BusinessFeedData businessFeedData, int i3, boolean z16, Object... objArr) {
        if (businessFeedData == null || businessFeedData.getLocalInfo().isFake()) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().actiontype == 20 || (businessFeedData.getCellSummaryV2() != null && businessFeedData.getCellSummaryV2().actionType == 20)) {
            o(businessFeedData, i3, T, objArr, null);
        }
        if (z16) {
            j0(businessFeedData, 0, z16);
        } else if (businessFeedData.getFeedCommInfo().actiontype != 6) {
            if (this.K && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getFeedCommInfo() != null && businessFeedData.getOriginalInfo().getFeedCommInfo().appid != 202) {
                O0(false);
                this.f46086e = businessFeedData;
                this.I.Ka(businessFeedData, 0, 0L);
            } else {
                k0(businessFeedData, 0, z16, i3);
            }
        }
        com.qzone.misc.network.report.d.f(businessFeedData);
        if (businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().actiontype == 6 || !businessFeedData.getFeedCommInfo().needQBossReport()) {
            return;
        }
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(businessFeedData.getOperationInfo().qbossTrace, null);
    }

    public void s(Intent intent) {
        if (intent == null) {
            QLog.e(f46084d0, 1, "[doneReply] data is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e(f46084d0, 1, "[doneReply] bean is not instanceof");
        } else {
            QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
            v(qZoneCommentPanelResultBean.getInputContent(), R(), z(), "", qZoneCommentPanelResultBean.getCacheUniKey(), qZoneCommentPanelResultBean.getIsCheckedPrivateIcon(), false, null, null, qZoneCommentPanelResultBean.getCacheFeedsKey(), qZoneCommentPanelResultBean.a());
        }
    }

    public void u(Intent intent) {
        if (intent == null) {
            QLog.e(f46084d0, 1, "[doneCommentNew] data is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e(f46084d0, 1, "[doneCommentNew] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        v(qZoneCommentPanelResultBean.getInputContent(), R(), null, "", qZoneCommentPanelResultBean.getCacheUniKey(), qZoneCommentPanelResultBean.getIsCheckedPrivateIcon(), qZoneCommentPanelResultBean.getIsEmoRapidComment(), qZoneCommentPanelResultBean.getRapidCommentInfo(), qZoneCommentPanelResultBean.g(), qZoneCommentPanelResultBean.getCacheFeedsKey(), qZoneCommentPanelResultBean.a());
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        i.H();
        uiInterface.doCommentActionReport(3);
    }

    public void r(View view, BusinessFeedData businessFeedData, int i3, boolean z16, boolean z17, boolean z18, boolean z19) {
        int c16;
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        String str2 = "3";
        if (businessFeedData.isQzoneCardFeed()) {
            if (businessFeedData.getFeedCommInfo().isFollowed) {
                str = "3";
            } else {
                str = "4";
            }
            ClickReport.p("644", str, "", null, true);
        }
        QZonePullToRefreshListView Q2 = Q();
        if (Q2 == null) {
            return;
        }
        if (view != null && view.getTag() != null && (view.getTag() instanceof Integer)) {
            c16 = ((Integer) view.getTag(R.id.jam)).intValue();
        } else if (businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            c16 = z18 ? 3 : c6.a.c(businessFeedData);
        } else {
            c16 = z18 ? 16 : 12;
        }
        int i16 = c16;
        int headerViewsCount = z16 ? i3 - Q2.j0().getHeaderViewsCount() : i3;
        if (z17) {
            BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
            QZoneWriteOperationService.v0().p0(originalInfo.getUser().uin, !originalInfo.getFeedCommInfo().isFollowed, 10, E(), originalInfo.getFeedCommInfo().feedskey, headerViewsCount, originalInfo.getFeedCommInfo().needAdvReport(), originalInfo.getOperationInfo().cookie, originalInfo.getFeedCommInfo().isInstalled, businessFeedData, !z19 && z17, 0);
            if (!originalInfo.getFeedCommInfo().isFollowed) {
                str2 = "2";
            }
            ClickReport.q("462", str2, "2", true);
            return;
        }
        QZoneWriteOperationService.v0().p0(businessFeedData.getUser().uin, !businessFeedData.getFeedCommInfo().isFollowed, i16, E(), businessFeedData.getFeedCommInfo().feedskey, headerViewsCount, businessFeedData.getFeedCommInfo().needAdvReport(), businessFeedData.getOperationInfo().cookie, businessFeedData.getFeedCommInfo().isInstalled, businessFeedData, z17, 0);
    }

    public void w0(View view, BusinessFeedData businessFeedData, int i3, int i16, int i17, int i18, String str) {
        QZonePullToRefreshListView Q2;
        String str2;
        int i19;
        if (businessFeedData != null && (Q2 = Q()) != null && businessFeedData.getFeedCommInfo().needAdvReport() && k()) {
            int headerViewsCount = (i3 - Q2.j0().getHeaderViewsCount()) + 1;
            int i26 = (i17 != 22 || businessFeedData.getOperationInfo().actionType == 0) ? i18 : 0;
            String d16 = c6.a.d(view);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=" + headerViewsCount + " antispam=" + d16);
            int l3 = com.qzone.misc.network.report.f.l(i16);
            if (businessFeedData.feedType == 4097 || (businessFeedData.isSubFeed && businessFeedData.parentFeedData.feedType == 4097)) {
                str2 = str;
                i19 = l3;
            } else {
                i19 = com.qzone.misc.network.report.f.l(i16);
                str2 = com.qzone.misc.network.report.f.k(i16, str);
            }
            QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, i19, 0, headerViewsCount, i17, i26, true, businessFeedData.getFeedCommInfo().isInstalled, d16, null, 0L, false, false, str2, false, businessFeedData);
        }
    }

    public void y0(View view, BusinessFeedData businessFeedData, int i3, int i16, int i17, int i18, String str, int i19, int i26) {
        QZonePullToRefreshListView Q2;
        if (businessFeedData == null || (Q2 = Q()) == null) {
            return;
        }
        if ((i26 == 8 || !businessFeedData.isGDTAdvFeed()) && businessFeedData.getFeedCommInfo().needAdvReport() && k()) {
            int headerViewsCount = (i3 - Q2.j0().getHeaderViewsCount()) + 1;
            int i27 = (i17 != 22 || businessFeedData.getOperationInfo().actionType == 0) ? i18 : 0;
            String d16 = c6.a.d(view);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=" + headerViewsCount + " antispam=" + d16);
            int l3 = com.qzone.misc.network.report.f.l(i16);
            String k3 = (businessFeedData.feedType == 4097 || (businessFeedData.isSubFeed && businessFeedData.parentFeedData.feedType == 4097)) ? str : com.qzone.misc.network.report.f.k(i16, str);
            QZLog.i(f46084d0, "sdkTest reportTest not in sdk1");
            QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, l3, 0, headerViewsCount, i17, i27, true, businessFeedData.getFeedCommInfo().isInstalled, d16, null, 0L, false, false, k3, false, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(BusinessFeedData businessFeedData, boolean z16) {
        int i3;
        Object valueOf;
        String str;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        j(businessFeedData);
        if (ArchiveMemorySettingGuide.o().y(businessFeedData, this)) {
            return;
        }
        int i16 = businessFeedData.getFeedCommInfo().appid;
        String str2 = businessFeedData.getIdInfo().cellId;
        String str3 = businessFeedData.getIdInfo().subId;
        String str4 = businessFeedData.getFeedCommInfo().clientkey;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        String str5 = "1";
        if (i16 == 4) {
            str3 = "2";
        } else if ((i16 == 311 || i16 == 6100) && map != null) {
            map.put(10, "1");
        }
        String str6 = str3;
        HashMap hashMap = new HashMap();
        if (!z16) {
            str5 = "0";
        }
        hashMap.put("del_all_media_file", str5);
        if (i16 == 4 && m0(businessFeedData)) {
            i3 = 4;
            QZoneWriteOperationService.v0().Z(E(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().feedskey, str4, businessFeedData.getFeedCommInfo().appid, businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().feedsType, businessFeedData.getFeedCommInfo().getTime(), businessFeedData.getOperationInfo().busiParam, 25, str2, "");
        } else {
            i3 = 4;
            if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 330) {
                QZoneWriteOperationService.v0().e0(E(), businessFeedData.getFeedCommInfo().ugckey, str4);
            } else {
                QZoneWriteOperationService.v0().V(0, E(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().feedskey, str4, businessFeedData.getFeedCommInfo().appid, LoginData.getInstance().getUin(), str2, str6, 0, map, 25, "", hashMap);
            }
        }
        businessFeedData.getFeedCommInfoV2();
        if (businessFeedData.getLocalInfoV2() != null) {
            final String str7 = businessFeedData.getFeedCommInfoV2().clientkey;
            List<IQueueTask> B = QZonePublishQueue.w().B(str7);
            String str8 = f46084d0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("remove task clientKey = ");
            sb5.append(str7);
            sb5.append(", taskList size = ");
            if (B == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(B.size());
            }
            sb5.append(valueOf);
            QZLog.i(str8, sb5.toString());
            if (B != null) {
                for (IQueueTask iQueueTask : B) {
                    if (iQueueTask != null) {
                        boolean f16 = QZonePublishQueue.w().f(iQueueTask);
                        String str9 = f46084d0;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("remove task task'cacheKey = ");
                        sb6.append(iQueueTask.getCommentUniKey());
                        sb6.append(" ");
                        if (f16) {
                            str = "success";
                        } else {
                            str = "failed";
                        }
                        sb6.append(str);
                        QZLog.i(str9, sb6.toString());
                    }
                }
            }
            if (z16 && i16 == i3) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.logic.presenter.BaseFeedPresenter.8
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(BaseFeedPresenter.f46084d0, 1, "start delete fake photo data");
                        AlbumCacheDataManager.J().k0(str7);
                        AlbumCacheDataManager.J().m0(str7);
                        AlbumCacheDataManager.J().n0(str7);
                        QLog.d(BaseFeedPresenter.f46084d0, 1, "finish delete fake photo data");
                    }
                });
            }
        }
    }

    public int o(BusinessFeedData businessFeedData, int i3, int i16, Object... objArr) {
        return n(businessFeedData, i3, i16, null, objArr);
    }

    public void q(View view, BusinessFeedData businessFeedData, int i3, boolean z16, boolean z17, boolean z18) {
        r(view, businessFeedData, i3, z16, z17, z18, false);
    }

    public void v0(View view, BusinessFeedData businessFeedData, int i3, int i16, int i17, int i18) {
        w0(view, businessFeedData, i3, i16, i17, i18, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(String str, int i3, ClickedComment clickedComment, String str2, String str3, boolean z16, boolean z17, RapidCommentExpressionInfo rapidCommentExpressionInfo, ArrayList<String> arrayList, String str4, Map<String, String> map) {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        User user;
        EditPositionBag B = B();
        if (B != null) {
            B.f60233p = true;
            B.f();
            B.onHide();
        }
        try {
            businessFeedData = (BusinessFeedData) F(i3, true);
            try {
                businessFeedData2 = L(str4, businessFeedData);
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                businessFeedData2 = businessFeedData;
                if (businessFeedData2 != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            businessFeedData = null;
        }
        if (businessFeedData2 != null) {
            return;
        }
        MiscReportUtils.l(businessFeedData2, false);
        Map<Integer, String> map2 = businessFeedData2.getOperationInfo().busiParam;
        if (clickedComment != null) {
            if (TextUtils.isEmpty(clickedComment.getComment().commentid)) {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastServerBusy", "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5"));
                return;
            }
            if (clickedComment.getReply() != null) {
                user = clickedComment.getReply().user;
            } else {
                user = clickedComment.getComment().user;
            }
            User user2 = user;
            if (businessFeedData2.getFeedCommInfo().appid == 334 && businessFeedData2.getUser().uin != LoginData.getInstance().getUin() && user2.uin != LoginData.getInstance().getUin()) {
                QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
                lVar.f45712e = businessFeedData2.getFeedCommInfo().appid;
                lVar.f45718k = map2;
                lVar.f45715h = com.qzone.util.u.a(user2.uin, user2.nickName) + str;
                lVar.f45716i = str3;
                lVar.f45709b = businessFeedData2.getFeedCommInfo().feedskey;
                lVar.f45710c = UUID.randomUUID().toString();
                lVar.f45711d = businessFeedData2.getFeedCommInfo().clientkey;
                lVar.f45725r = z16;
                lVar.f45724q = businessFeedData2.getFeedCommInfo().isTodayInHistoryFeed();
                lVar.f45713f = businessFeedData2.getUser().uin;
                lVar.f45719l = str2;
                lVar.f45714g = businessFeedData2.getIdInfo().cellId;
                lVar.f45708a = businessFeedData2.getFeedCommInfo().ugckey;
                lVar.f45727t = 0;
                QZoneWriteOperationService.v0().Q(E(), lVar);
            } else {
                QZoneWriteOperationService.v0().b2(0, E(), businessFeedData2.getFeedCommInfo().ugckey, businessFeedData2.getFeedCommInfo().feedskey, UUID.randomUUID().toString(), businessFeedData2.getFeedCommInfo().appid, businessFeedData2.getUser().uin, clickedComment.getComment().user.uin, user2, businessFeedData2.getIdInfo().cellId, "", clickedComment.getComment().commentid, com.qzone.util.u.a(user2.uin, user2.nickName) + str, str, str3, 0, map2, str2, businessFeedData2.getFeedCommInfo().isTodayInHistoryFeed(), i3, 0, map);
            }
        } else {
            QZoneWriteOperationService.l lVar2 = new QZoneWriteOperationService.l();
            lVar2.f45712e = businessFeedData2.getFeedCommInfo().appid;
            lVar2.f45718k = map2;
            lVar2.f45715h = str;
            lVar2.f45716i = str3;
            lVar2.f45710c = UUID.randomUUID().toString();
            lVar2.f45709b = businessFeedData2.getFeedCommInfo().feedskey;
            lVar2.f45711d = businessFeedData2.getFeedCommInfo().clientkey;
            lVar2.f45725r = z16;
            lVar2.f45724q = businessFeedData2.getFeedCommInfo().isTodayInHistoryFeed();
            lVar2.f45717j = 0;
            lVar2.f45713f = businessFeedData2.getUser().uin;
            lVar2.f45723p = 0;
            lVar2.f45719l = str2;
            lVar2.f45722o = null;
            lVar2.f45714g = businessFeedData2.getIdInfo().cellId;
            lVar2.f45721n = 1;
            lVar2.f45708a = businessFeedData2.getFeedCommInfo().ugckey;
            lVar2.f45726s = arrayList;
            lVar2.f45730w = map;
            lVar2.f45731x = businessFeedData2.isSubFeed;
            lVar2.f45732y = businessFeedData2;
            lVar2.f45733z = businessFeedData2.feedType;
            if (!z17) {
                QZoneWriteOperationService.v0().Q(E(), lVar2);
            } else {
                QZoneWriteOperationService.v0().X1(E(), lVar2, rapidCommentExpressionInfo);
            }
        }
        p0();
    }

    private static int A(int i3, int i16, BusinessFeedData businessFeedData) {
        return (businessFeedData != null && i3 == 20 && i16 == 2 && !GdtFeedUtilForQZone.q(GdtFeedUtilForQZone.i(businessFeedData))) ? 2 : 1;
    }

    private void V0() {
    }

    private void X0(String str) {
    }

    @Override // d5.n
    public void F7() {
    }

    public void H0(BusinessFeedData businessFeedData, int i3, int i16) {
        if (businessFeedData == null) {
            return;
        }
        if (i3 == 0) {
            this.I.e4(businessFeedData, i16, 0L);
            ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 2);
            return;
        }
        if (i3 == 1) {
            QZoneFeedUtil.W(businessFeedData, 1, this);
            ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 3);
            return;
        }
        if (i3 == 10) {
            if (!k()) {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"));
                return;
            } else {
                r0(businessFeedData);
                ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 6);
                return;
            }
        }
        if (i3 == 17) {
            QZoneFeedUtil.f0(3585, businessFeedData, E(), this);
            ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 4);
        } else if (i3 == 21) {
            QZoneFeedUtil.u(businessFeedData);
            ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 7);
        } else {
            if (i3 != 34) {
                return;
            }
            QZoneFeedUtil.f0(3586, businessFeedData, E(), this);
            ClickReport.i(businessFeedData.getUser().uin, Integer.toString(businessFeedData.getFeedCommInfo().appid), "", "", false, 302, 22, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
