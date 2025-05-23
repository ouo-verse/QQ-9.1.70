package com.qzone.reborn.feedx.widget.navigator;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.business.tianshu.l;
import com.qzone.common.account.LoginData;
import com.qzone.feed.ui.navigationbar.NavigatorItem;
import com.qzone.feed.ui.navigationbar.NavigatorTianShuManager;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.reborn.feedx.util.j;
import com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.reborn.util.k;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.qzone.widget.util.QzonePreloadHtmlResourcesHelper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxNavigatorBar extends FrameLayout {
    public static boolean U = false;
    public static String[] V = {QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE, "\u8bf4\u8bf4", "\u88c5\u626e", "\u5c0f\u6e38\u620f", "\u5c0f\u89c6\u9891"};
    public static int[] W = {19, 20, 13, 12, 48};

    /* renamed from: a0, reason: collision with root package name */
    public static String[] f56414a0 = {"mqzone://arouse/albumlist", "mqzone://arouse/moodlist", "mqzone://arouse/persionsetting", "mqzone://arouse/gamebar", "mqzone://arouse/weishivideolayer"};

    /* renamed from: b0, reason: collision with root package name */
    public static int[] f56415b0 = y();
    private NavigatorItem C;
    private NavigatorItem D;
    private CustomFriendNaviData E;
    private boolean F;
    private IRedTouchManager G;
    public ArrayList<entrance_cfg> H;
    private boolean I;
    private List<String> J;
    private List<Long> K;
    private boolean L;
    private QzoneZipCacheHelperCallBack M;
    public NavigatorTianShuManager N;
    private final RedpointObserver P;
    private ContentObserver Q;
    boolean R;
    public com.qzone.feed.ui.navigationbar.b S;
    private Handler T;

    /* renamed from: d, reason: collision with root package name */
    private Context f56416d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f56417e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f56418f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f56419h;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList<NavigatorItem> f56420i;

    /* renamed from: m, reason: collision with root package name */
    private NavigatorItem f56421m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar$15, reason: invalid class name */
    /* loaded from: classes37.dex */
    public class AnonymousClass15 implements Runnable {
        AnonymousClass15() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Drawable drawable) {
            if (drawable != null && QZoneFeedxNavigatorBar.this.f56418f != null) {
                QZoneFeedxNavigatorBar.this.f56418f.setBackgroundColor(0);
                QZoneFeedxNavigatorBar.this.f56418f.setBackground(drawable);
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneFeedxNavigatorBar", "@newnavi mCustombackgroundView  setpersonalnavi");
                    return;
                }
                return;
            }
            QZLog.i("QZoneFeedxNavigatorBar", "@newnavi bgdrawable  is null");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.qzone.personalize.business.b.r(QZoneFeedxNavigatorBar.this.E)) {
                final Drawable k3 = QzoneZipAnimateUtil.k("business_frineds_navideco", QZoneFeedxNavigatorBar.this.E.iItemId + "", "bg_1242.png", -1, -1);
                QZoneFeedxNavigatorBar.this.o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneFeedxNavigatorBar.AnonymousClass15.this.b(k3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar$2, reason: invalid class name */
    /* loaded from: classes37.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f56425d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f56426e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f56427f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ NavigatorItem f56428h;

        AnonymousClass2(String str, int i3, int i16, NavigatorItem navigatorItem) {
            this.f56425d = str;
            this.f56426e = i3;
            this.f56427f = i16;
            this.f56428h = navigatorItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(NavigatorItem navigatorItem) {
            if (com.qzone.personalize.business.b.r(QZoneFeedxNavigatorBar.this.E) || navigatorItem == null) {
                return;
            }
            navigatorItem.setYellowVipDrawableIcon(null);
            if (QQTheme.isNowThemeIsNightForQzone()) {
                navigatorItem.setTextColor("#FFFFFF");
            } else {
                navigatorItem.setTextColor("#000000");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.qzone.personalize.business.b.r(QZoneFeedxNavigatorBar.this.E)) {
                final Drawable k3 = QzoneZipAnimateUtil.k("business_frineds_navideco", QZoneFeedxNavigatorBar.this.E.iItemId + "", this.f56425d, this.f56426e, this.f56427f);
                if (this.f56428h == null || k3 == null) {
                    return;
                }
                QZoneFeedxNavigatorBar.this.o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NavigatorItem navigatorItem = AnonymousClass2.this.f56428h;
                        if (navigatorItem != null) {
                            navigatorItem.setYellowVipDrawableIcon(k3);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            anonymousClass2.f56428h.setTextColor(QZoneFeedxNavigatorBar.this.E.stTextColor);
                        }
                    }
                });
                return;
            }
            QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = QZoneFeedxNavigatorBar.this;
            final NavigatorItem navigatorItem = this.f56428h;
            qZoneFeedxNavigatorBar.o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.d
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxNavigatorBar.AnonymousClass2.this.b(navigatorItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigatorItem f56438a;

        d(NavigatorItem navigatorItem) {
            this.f56438a = navigatorItem;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            if (!QZoneFeedxNavigatorBar.this.L) {
                QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = QZoneFeedxNavigatorBar.this;
                qZoneFeedxNavigatorBar.L = qZoneFeedxNavigatorBar.V();
            }
            HashMap hashMap = new HashMap();
            String str2 = "0";
            if (this.f56438a.G == 72) {
                if (QZoneFeedxNavigatorBar.this.L) {
                    str2 = "1";
                }
                hashMap.put("is_friend_profile_picture", str2);
            } else {
                hashMap.put("is_friend_profile_picture", "0");
            }
            QZoneFeedxNavigatorBar.this.L = false;
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class e extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QZoneFeedxNavigatorBar> f56440a;

        public e(QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar) {
            super(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler());
            this.f56440a = new WeakReference<>(null);
            this.f56440a = new WeakReference<>(qZoneFeedxNavigatorBar);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            QLog.d("QZoneFeedxNavigatorBar", 1, "onChange");
            if (this.f56440a.get() != null) {
                this.f56440a.get().X();
            }
        }
    }

    public QZoneFeedxNavigatorBar(Context context) {
        super(context);
        this.f56420i = new CopyOnWriteArrayList<>();
        this.E = new CustomFriendNaviData();
        this.H = new ArrayList<>();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.M = new b();
        this.P = new c();
        this.R = true;
        this.f56416d = context;
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        return getResources().getColor(R.color.qui_common_fill_light_primary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(QZoneCountInfo qZoneCountInfo, boolean z16) {
        ArrayList<QZoneCountUserInfo> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (qZoneCountInfo != null && (arrayList = qZoneCountInfo.friendList) != null) {
            Iterator<QZoneCountUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                QZoneCountUserInfo next = it.next();
                if (next != null) {
                    long j3 = next.uin;
                    if (j3 > 0) {
                        arrayList2.add(Long.valueOf(j3));
                    }
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateIntimateAvatarLoop] unCount: ");
        sb5.append(qZoneCountInfo == null ? -1L : qZoneCountInfo.uCount);
        sb5.append(", uinList = ");
        sb5.append(arrayList2.toString());
        QZLog.d("QZoneFeedxNavigatorBar", 1, sb5.toString());
        for (int i3 = 0; i3 < this.f56420i.size(); i3++) {
            NavigatorItem navigatorItem = this.f56420i.get(i3);
            if (navigatorItem != null && navigatorItem.G == 72) {
                if (z16) {
                    navigatorItem.H();
                }
                v();
                s0(arrayList2);
                B0();
                q(arrayList2, z16);
                navigatorItem.R(arrayList2);
            }
        }
    }

    private IRedTouchManager B() {
        if (this.G == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("QZoneFeedxNavigatorBar", 1, "[minigame newNavBar] initMiniGameRedTouchManager failed");
                return null;
            }
            this.G = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        }
        return this.G;
    }

    private void E() {
        boolean o16 = dh.a.f393805d.o();
        QLog.i("QZ_QFS_QZoneFeedxNavigatorBar", 1, "handleClickClearQcircleRedDot, showAlbumEntranceRedDot=" + o16);
        if (o16) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxNavigatorBar.W();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        ArrayList<entrance_cfg> loadNavigatorEntryListFromMem;
        QZoneCountInfo singleUnReadItem;
        CopyOnWriteArrayList<NavigatorItem> copyOnWriteArrayList = this.f56420i;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<NavigatorItem> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            NavigatorItem next = it.next();
            if (next != null) {
                if (next.G == 12) {
                    g0();
                } else {
                    QZoneCountInfo singleUnReadItem2 = QZoneFeedAlertService.getInstance().getSingleUnReadItem(next.G);
                    if (next.G == 28) {
                        if (singleUnReadItem2 == null) {
                            singleUnReadItem2 = new QZoneCountInfo();
                        }
                        if (singleUnReadItem2.uCount <= 0 && (loadNavigatorEntryListFromMem = QZoneFeedAlertService.getInstance().loadNavigatorEntryListFromMem(1)) != null && loadNavigatorEntryListFromMem.size() > 0) {
                            Iterator<entrance_cfg> it5 = loadNavigatorEntryListFromMem.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                if (it5.next() != null && (singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(next.G)) != null) {
                                    long j3 = singleUnReadItem.uCount;
                                    if (j3 > 0) {
                                        singleUnReadItem2.iControl = 2;
                                        singleUnReadItem2.uCount = j3;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (singleUnReadItem2 == null) {
                        G0(0L, 2, next.G);
                    } else {
                        next.H = singleUnReadItem2.trace_info;
                        G0(singleUnReadItem2.uCount, 2, next.G);
                    }
                    if (next.G == 72) {
                        A0(singleUnReadItem2, false);
                    }
                }
            }
        }
    }

    private void G(View view, boolean z16, QZoneClickReport.ReportInfo reportInfo, int i3, String str) {
        if (view instanceof NavigatorItem) {
            H((NavigatorItem) view, false);
        }
        F(reportInfo, i3, str + "&from=1");
    }

    private void H(NavigatorItem navigatorItem, boolean z16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 1400;
        lpReportInfo_pf00064.subactionType = 1;
        lpReportInfo_pf00064.reserves = z16 ? 1 : 2;
        lpReportInfo_pf00064.reserves3 = String.valueOf(navigatorItem.s());
        lpReportInfo_pf00064.reserves4 = String.valueOf(navigatorItem.r());
        lpReportInfo_pf00064.reserves5 = navigatorItem.w();
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void J(QZoneClickReport.ReportInfo reportInfo, int i3, String str) {
        reportInfo.reserves = String.valueOf(i3);
        ClickReport.l(reportInfo, true);
        if (this.f56416d == null) {
            QLog.e("QZoneFeedxNavigatorBar", 1, "[handleIntimateSpaceClick] context is null");
            return;
        }
        QLog.d("QZoneFeedxNavigatorBar", 1, "[handleIntimateSpaceClick] schema= " + str);
        yo.d.d(str, this.f56416d, null);
        this.L = V();
        List<String> list = this.J;
        if (list != null) {
            list.clear();
        }
        u();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.10
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(72);
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(74);
                QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZLog.d("QZoneFeedxNavigatorBar", 1, "[handleIntimateSpaceClick] clear red dot and avatar loop");
                        QZoneFeedxNavigatorBar.this.G0(0L, 2, 72);
                        QZoneFeedxNavigatorBar.this.A0(null, true);
                    }
                });
            }
        });
    }

    private void L(QZoneClickReport.ReportInfo reportInfo, int i3) {
        if (this.f56416d != null) {
            i.u().a(this.f56416d, "getActiveFeeds", 1);
        }
        if (i3 == 0) {
            i3 = 1;
        }
        reportInfo.reserves = String.valueOf(i3);
        reportInfo.reservesExt = new ArrayList<>(1);
        G0(0L, 2, 1);
    }

    private void Q(Context context) {
        try {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("inflateItem itemList:");
                sb5.append(this.f56420i);
                sb5.append(" size:");
                CopyOnWriteArrayList<NavigatorItem> copyOnWriteArrayList = this.f56420i;
                sb5.append(copyOnWriteArrayList != null ? copyOnWriteArrayList.size() : 0);
                QLog.d("QZoneFeedxNavigatorBar", 2, sb5.toString());
            }
            CopyOnWriteArrayList<NavigatorItem> copyOnWriteArrayList2 = this.f56420i;
            if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0 && context != null) {
                removeAllViews();
                LayoutInflater.from(context).inflate(R.layout.f167277cg1, this);
                this.f56417e = (LinearLayout) findViewById(R.id.f162864n14);
                ImageView imageView = (ImageView) findViewById(R.id.f162863n13);
                this.f56418f = imageView;
                imageView.setMaxHeight(x.c(this.f56416d, 75.0f));
                int s16 = s(this.f56420i.size());
                Iterator<NavigatorItem> it = this.f56420i.iterator();
                while (it.hasNext()) {
                    NavigatorItem next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.v())) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s16, -1);
                        layoutParams.gravity = 16;
                        this.f56417e.addView(next, layoutParams);
                    }
                }
                D0(null);
            }
        } catch (Exception e16) {
            QZLog.e("QZoneFeedxNavigatorBar", "", e16);
        }
    }

    private void R() {
        if (this.Q == null) {
            this.Q = new e(this);
        }
    }

    private void U() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("QZoneFeedxNavigatorBar", 1, "[minigame newNavBar] initRedTouchObserver failed");
        } else {
            ((QQAppInterface) peekAppRuntime).addObserver(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        return (ArrayUtils.isOutOfArrayIndex(0, this.J) && ArrayUtils.isOutOfArrayIndex(0, this.K)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W() {
        dh.a.f393805d.j(false);
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(View view, String str, int i3) {
        String str2;
        NavigatorItem navigatorItem = this.C;
        if (view == navigatorItem) {
            boolean E = navigatorItem.E();
            Object q16 = navigatorItem.q();
            if (E) {
                if (B() != null && (q16 instanceof BusinessInfoCheckUpdate.AppInfo)) {
                    B().onRedTouchItemClick((BusinessInfoCheckUpdate.AppInfo) q16, null);
                }
                navigatorItem.L(0, 0);
            }
            RFWLog.d("QZoneFeedxNavigatorBar", RFWLog.USR, "click intimate item,dotVisible:" + E + ",ext:" + q16);
        }
        if (this.R) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.appId = String.valueOf(1);
        reportInfo.referId = "getActiveFeeds";
        reportInfo.actionType = String.valueOf(302);
        reportInfo.subactionType = String.valueOf(32);
        reportInfo.readSource = str2;
        reportInfo.reserves9 = str;
        reportInfo.toUin = LoginData.getInstance().getUin();
        String trim = str.trim();
        if (!trim.startsWith("mqzone://arouse/myfeed") && !trim.startsWith("mqzone://arouse/passive")) {
            if (trim.startsWith("mqzone://arouse/moodlist")) {
                K(reportInfo, i3);
                eo.a.f396875a.c(5);
                return;
            }
            if (trim.startsWith("mqzone://arouse/albumlist")) {
                C(reportInfo, i3);
                eo.a.f396875a.c(4);
                E();
                return;
            }
            if (!trim.startsWith("mqzone://arouse/gamebar") && i3 != 12) {
                if (trim.startsWith("mqzone://arouse/bloglist")) {
                    D(reportInfo, i3);
                    return;
                }
                if (trim.startsWith("mqzone://arouse/persionsetting")) {
                    M(reportInfo, i3);
                    eo.a.f396875a.c(6);
                    return;
                }
                if (trim.startsWith("https://get.photo.qq.com/get/page/home?_bid=359&_wv=2098179&sid={sid}&uin={uin}")) {
                    P(reportInfo, i3);
                    return;
                }
                if (!trim.startsWith("https://h5.qzone.qq.com/topicGroup/homev3?_proxy=1&_wv=1027") && i3 != 32) {
                    if (trim.startsWith("mqqapi://qcircle/opengallerymainpage")) {
                        G(view, false, reportInfo, i3, trim);
                        return;
                    } else if (i3 == 72) {
                        J(reportInfo, i3, trim);
                        return;
                    } else {
                        F(reportInfo, i3, trim);
                        return;
                    }
                }
                O(reportInfo, i3, view);
                eo.a.f396875a.c(8);
                return;
            }
            I(reportInfo, i3, trim, view);
            eo.a.f396875a.c(7);
            return;
        }
        L(reportInfo, i3);
    }

    private void d0() {
        ArrayList<entrance_cfg> arrayList = this.H;
        if (arrayList == null) {
            return;
        }
        Iterator<entrance_cfg> it = arrayList.iterator();
        while (it.hasNext()) {
            entrance_cfg next = it.next();
            if (next != null && 12 == next.iEntranceId) {
                QzonePreloadHtmlResourcesHelper.m();
                return;
            }
        }
    }

    private void e0(Context context) {
        ArrayList<entrance_cfg> arrayList = this.H;
        if (arrayList == null || context == null) {
            return;
        }
        if (arrayList.size() > 5) {
            this.H.remove(0);
        }
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            entrance_cfg entrance_cfgVar = this.H.get(i3);
            if (entrance_cfgVar != null && !TextUtils.isEmpty(entrance_cfgVar.sEntranceName) && !TextUtils.isEmpty(entrance_cfgVar.sEntranceAction)) {
                NavigatorItem navigatorItem = new NavigatorItem(context, this.E);
                navigatorItem.setElementClickListener(this.S);
                navigatorItem.setText(entrance_cfgVar.sEntranceName);
                p0(navigatorItem, entrance_cfgVar.sEntranceName, i3 + 1, "");
                navigatorItem.setReportValue(entrance_cfgVar.iEntranceId);
                navigatorItem.setIconUrl(N(entrance_cfgVar));
                navigatorItem.setIconRes(x(i3, entrance_cfgVar));
                int i16 = entrance_cfgVar.iEntranceId;
                if (i16 == 65) {
                    this.f56421m = navigatorItem;
                    navigatorItem.G();
                    navigatorItem.t();
                    r0();
                    H(navigatorItem, true);
                } else if (i16 == 72) {
                    this.C = navigatorItem;
                } else if (i16 == 19) {
                    this.D = navigatorItem;
                }
                navigatorItem.setDrawableIcon(null);
                navigatorItem.setSchema(entrance_cfgVar.sEntranceAction);
                t(entrance_cfgVar);
                navigatorItem.setQbossIcon(entrance_cfgVar.sQbossEntranceIcon);
                navigatorItem.setQbossIconTraceinfo(entrance_cfgVar.sQbossTraceInfo);
                f6.a.c(navigatorItem);
                this.f56420i.add(navigatorItem);
                if (entrance_cfgVar.iEntranceId == 12 && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(entrance_cfgVar.sEntranceAction)) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportNavigatorbarExpose();
                }
                m0(entrance_cfgVar);
                n0(entrance_cfgVar);
                w(navigatorItem);
            }
        }
    }

    private void f0() {
        if (this.f56420i.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < this.f56420i.size(); i3++) {
            if (this.f56420i.get(i3) != null) {
                NavigatorItem navigatorItem = this.f56420i.get(i3);
                if (navigatorItem.G == 65) {
                    navigatorItem.G();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        NavigatorItem navigatorItem;
        if (this.f56420i == null || B() == null) {
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = B().getAppInfo(2, "140112");
        if (appInfo == null) {
            QLog.e("QZoneFeedxNavigatorBar", 1, "[minigame newNavBar] get red app info is null");
            return;
        }
        if (l.b(appInfo)) {
            for (int i3 = 0; i3 < this.f56420i.size() && (navigatorItem = this.f56420i.get(i3)) != null; i3++) {
                if (navigatorItem.G == 12) {
                    navigatorItem.setExt(appInfo);
                    G0(1L, 2, 12);
                    B().onRedTouchItemExposure(appInfo, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        NavigatorItem navigatorItem;
        IRedTouchManager B = B();
        if (this.f56420i == null || B == null) {
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = B.getAppInfo(2, "140118");
        if (appInfo == null) {
            QLog.e("QZoneFeedxNavigatorBar", 1, "[refreshIntimateEntranceRedPoint] get red app info is null");
            return;
        }
        boolean hasRedTouch = RedTouch.hasRedTouch(appInfo);
        QLog.e("QZoneFeedxNavigatorBar", 1, "[refreshIntimateEntranceRedPoint] need show red point: ", Boolean.valueOf(hasRedTouch));
        if (hasRedTouch) {
            for (int i3 = 0; i3 < this.f56420i.size() && (navigatorItem = this.f56420i.get(i3)) != null; i3++) {
                if (navigatorItem.G == 72) {
                    QLog.e("QZoneFeedxNavigatorBar", 1, "[refreshIntimateEntranceRedPoint] real show red point");
                    navigatorItem.setExt(appInfo);
                    G0(1L, 2, 72);
                    B.onRedTouchItemExposure(appInfo, null);
                }
            }
        }
    }

    private void j0() {
        CopyOnWriteArrayList<NavigatorItem> copyOnWriteArrayList = this.f56420i;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < this.f56420i.size(); i3++) {
            if (this.f56420i.get(i3) != null) {
                this.f56420i.get(i3).onDestroy();
            }
        }
    }

    private void k0() {
        if (this.P == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("QZoneFeedxNavigatorBar", 1, "[minigame newNavBar] removeRedPointObserver failed");
        } else {
            ((QQAppInterface) peekAppRuntime).removeObserver(this.P);
        }
    }

    private void l0(NavigatorItem navigatorItem) {
        String str;
        if (!this.R) {
            str = "1";
        } else {
            str = "2";
        }
        if (navigatorItem.G == 19) {
            QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
            reportInfo.appId = String.valueOf(1);
            reportInfo.referId = "getActiveFeeds";
            reportInfo.actionType = String.valueOf(302);
            reportInfo.subactionType = String.valueOf(32);
            reportInfo.readSource = str;
            reportInfo.toUin = LoginData.getInstance().getUin();
            reportInfo.reserves = String.valueOf(34);
            ArrayList<String> arrayList = new ArrayList<>(1);
            reportInfo.reservesExt = arrayList;
            arrayList.add("1");
            ClickReport.l(reportInfo, true);
        }
    }

    private void q(List<Long> list, boolean z16) {
        if (list.isEmpty() && !z16) {
            if (ArrayUtils.isOutOfArrayIndex(0, this.J)) {
                return;
            }
            try {
                for (String str : this.J) {
                    if (!TextUtils.isEmpty(str)) {
                        list.add(Long.valueOf(Long.parseLong(str)));
                    }
                }
                return;
            } catch (Exception e16) {
                QLog.e("QZoneFeedxNavigatorBar", 1, "exception is " + e16);
                return;
            }
        }
        QLog.i("QZoneFeedxNavigatorBar", 1, "need to show update avatar");
    }

    private void r0() {
        if (this.F || !((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isNeedToShowGalleryNewUserGuideVideo()) {
            return;
        }
        QLog.d("QZoneFeedxNavigatorBar", 1, "start download gallery user guide video");
        this.F = true;
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.6
            @Override // java.lang.Runnable
            public void run() {
                ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).tryGetNewUserGuideVideoAsync();
            }
        });
    }

    private int s(int i3) {
        return pl.a.f426446a.o(getContext()) / i3;
    }

    private void s0(List<Long> list) {
        List<Long> list2 = this.K;
        if (list2 == null) {
            return;
        }
        list2.clear();
        this.K.addAll(list);
    }

    private void t(final entrance_cfg entrance_cfgVar) {
        if (QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_MINI_APP_PRELOAD_APP_STORE_FROM_QZONE_NAVIGATOR_BAR, true) && entrance_cfgVar != null && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(entrance_cfgVar.sEntranceAction)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.7
                @Override // java.lang.Runnable
                public void run() {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(entrance_cfgVar.sEntranceAction, true, null);
                    QLog.d("QZoneFeedxNavigatorBar", 1, "prePullAppinfoByLink: " + entrance_cfgVar.sEntranceAction);
                }
            });
        }
    }

    private void t0() {
        dh.a aVar = dh.a.f393805d;
        boolean o16 = aVar.o();
        QLog.i("QZ_QFS_QZoneFeedxNavigatorBar", 1, "initQcircleRedDotData, showAlbumEntranceRedDot=" + o16 + " | mAlbumItem=" + this.D);
        if (!o16 || this.D == null) {
            return;
        }
        final QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
        qZoneCountInfo.uCount = 1L;
        qZoneCountInfo.iControl = 2;
        qZoneCountInfo.trace_info = "";
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().setSingleUnReadItem(19, qZoneCountInfo);
            }
        });
        aVar.n(this.D, false);
    }

    private void u() {
        List<Long> list = this.K;
        if (list == null) {
            return;
        }
        list.clear();
    }

    private void v() {
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(74);
        if (singleUnReadItem == null) {
            return;
        }
        j.f55760a.p(74, singleUnReadItem);
        if (this.I) {
            return;
        }
        QLog.i("QZoneFeedxNavigatorBar", 1, "clear intimate count when not on paused");
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(74);
    }

    private int x(int i3, entrance_cfg entrance_cfgVar) {
        int[] iArr = f56415b0;
        if (iArr == null || i3 < 0 || i3 >= iArr.length) {
            return 0;
        }
        return iArr[i3 % iArr.length];
    }

    private void z0(NavigatorItem navigatorItem, String str, int i3, int i16) {
        VasQzoneYellowThread.INSTANCE.execJob(new AnonymousClass2(str, i3, i16, navigatorItem));
    }

    public void C0() {
        LinearLayout linearLayout = this.f56417e;
        if (linearLayout == null) {
            return;
        }
        int s16 = s(linearLayout.getChildCount());
        for (int i3 = 0; i3 < this.f56417e.getChildCount(); i3++) {
            View childAt = this.f56417e.getChildAt(i3);
            if (childAt != null && childAt.getLayoutParams() != null) {
                childAt.getLayoutParams().width = s16;
            }
        }
    }

    public void D0(CoverCacheData coverCacheData) {
        if (com.qzone.personalize.business.b.r(this.E)) {
            VasQzoneYellowThread.INSTANCE.execJob(new AnonymousClass15());
            return;
        }
        RFWLog.i("QZoneFeedxNavigatorBar", RFWLog.USR, "updateNaviBg: " + coverCacheData);
        u0(coverCacheData);
    }

    public void F0() {
        if (this.f56420i != null) {
            for (int i3 = 0; i3 < this.f56420i.size(); i3++) {
                NavigatorItem navigatorItem = this.f56420i.get(i3);
                if (isShown()) {
                    navigatorItem.P();
                } else {
                    navigatorItem.C();
                }
            }
        }
    }

    public void S() {
        T();
        if (this.H == null) {
            this.H = new ArrayList<>();
        }
        ArrayList<entrance_cfg> arrayList = this.H;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        for (int i3 = 0; i3 < V.length; i3++) {
            entrance_cfg entrance_cfgVar = new entrance_cfg();
            entrance_cfgVar.iEntranceId = W[i3];
            entrance_cfgVar.sEntranceName = V[i3];
            entrance_cfgVar.sEntranceIcon = "";
            entrance_cfgVar.sEntranceAction = f56414a0[i3];
            this.H.add(entrance_cfgVar);
        }
    }

    public void T() {
        if (this.S == null) {
            this.S = new a();
        }
    }

    public void X() {
        QZoneFeedAlertService.getInstance().ensureLoadUnread();
        QZoneFeedAlertService.getInstance().clearAllNavigatorConfigs();
        final boolean X = QZoneConfigHelper.X();
        QZoneFeedAlertService.getInstance().loadNavigatorEntryListFromDB();
        o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.9
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxNavigatorBar.this.setBarStyle(X);
                QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar = QZoneFeedxNavigatorBar.this;
                qZoneFeedxNavigatorBar.r(qZoneFeedxNavigatorBar.f56416d);
                QZoneFeedxNavigatorBar.this.y0();
                QZoneFeedxNavigatorBar qZoneFeedxNavigatorBar2 = QZoneFeedxNavigatorBar.this;
                qZoneFeedxNavigatorBar2.w0(qZoneFeedxNavigatorBar2.E, true);
                QZoneFeedxNavigatorBar.this.F0();
                QZoneFeedxNavigatorBar.this.g0();
            }
        });
    }

    public void Y() {
        if (this.Q != null) {
            BaseApplication.getContext().getContentResolver().unregisterContentObserver(this.Q);
            RFWLog.e("QZoneFeedxNavigatorBar", 1, "unregisterContentObserver success");
        }
        NavigatorTianShuManager navigatorTianShuManager = this.N;
        if (navigatorTianShuManager != null) {
            navigatorTianShuManager.i();
        }
        k0();
        j0();
        removeAllViews();
        this.f56416d = null;
    }

    public void c0() {
        x0();
    }

    public void i0() {
        if (BaseApplication.getContext() == null || BaseApplication.getContext().getContentResolver() == null) {
            return;
        }
        try {
            R();
            BaseApplication.getContext().getContentResolver().registerContentObserver(com.tencent.common.config.provider.d.D3, true, this.Q);
            U();
            RFWLog.d("QZoneFeedxNavigatorBar", 1, "registerContentObserver success");
        } catch (Exception e16) {
            RFWLog.fatal("QZoneFeedxNavigatorBar", 1, e16);
        }
    }

    public void q0(Activity activity) {
        NavigatorTianShuManager navigatorTianShuManager = new NavigatorTianShuManager(activity, this.f56420i);
        this.N = navigatorTianShuManager;
        navigatorTianShuManager.h();
    }

    public void setBarStyle(boolean z16) {
        this.R = z16;
    }

    public void setContext(Context context) {
        this.f56416d = context;
    }

    public void u0(final CoverCacheData coverCacheData) {
        o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.8
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneFeedxNavigatorBar.this.f56418f != null) {
                    int superCoverTrans = QZoneCoverUtils.getSuperCoverTrans(coverCacheData);
                    ImageView imageView = QZoneFeedxNavigatorBar.this.f56419h;
                    if (imageView != null) {
                        imageView.setAlpha(superCoverTrans);
                    }
                    if (com.qzone.personalize.business.b.r(QZoneFeedxNavigatorBar.this.E)) {
                        return;
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.i("QZoneFeedxNavigatorBar", "@newnavi mCustombackgroundView  setdefualtcolor");
                    }
                    ColorDrawable colorDrawable = new ColorDrawable(QZoneFeedxNavigatorBar.this.A());
                    colorDrawable.setAlpha(superCoverTrans);
                    QZoneFeedxNavigatorBar.this.f56418f.setBackground(colorDrawable);
                }
            }
        });
    }

    public void w0(CustomFriendNaviData customFriendNaviData, boolean z16) {
        if (!z16 && com.qzone.personalize.business.b.b(this.E, customFriendNaviData)) {
            QZLog.i("QZoneFeedxNavigatorBar", "updateCustomDressUp @newnavi cacheData do not update");
            return;
        }
        if (!com.qzone.personalize.business.b.r(customFriendNaviData)) {
            QZLog.i("QZoneFeedxNavigatorBar", "updateCustomDressUp @newnavi cancel data");
            this.E = customFriendNaviData;
            x0();
        } else {
            this.E = customFriendNaviData;
            QzoneZipAnimateUtil.d(customFriendNaviData.strFriendNaviDecoUrl, "business_frineds_navideco", this.E.iItemId + "", this.M);
        }
    }

    public void x0() {
        if (this.f56420i != null) {
            int i3 = 0;
            while (i3 < this.f56420i.size()) {
                NavigatorItem navigatorItem = this.f56420i.get(i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("00");
                i3++;
                sb5.append(i3);
                sb5.append(".png");
                z0(navigatorItem, sb5.toString(), ViewUtils.dip2px(32.0f), ViewUtils.dip2px(32.0f));
            }
            D0(null);
        }
    }

    public void y0() {
        o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.a
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxNavigatorBar.this.E0();
            }
        });
    }

    public NavigatorItem z() {
        return this.f56421m;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements QzoneZipCacheHelperCallBack {
        b() {
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            if (!z16) {
                QZoneFeedxNavigatorBar.this.E = null;
                QZLog.e("QZoneFeedxNavigatorBar", "download url fail");
            } else {
                QZoneFeedxNavigatorBar.this.x0();
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c extends RedpointObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            if (z16) {
                QZoneFeedxNavigatorBar.this.g0();
                QZoneFeedxNavigatorBar.this.h0();
            }
        }
    }

    private void B0() {
        List<String> list;
        ArrayList<String> g16 = QZoneIntimateEntranceManager.g(3);
        if (ArrayUtils.isOutOfArrayIndex(0, g16) || (list = this.J) == null) {
            return;
        }
        list.clear();
        this.J.addAll(g16);
    }

    private static int[] y() {
        return new int[]{R.drawable.qui_image_aio_oversized, R.drawable.qui_shuoshuo, R.drawable.qui_skin, R.drawable.qui_game, R.drawable.qui_play};
    }

    public void a0() {
        this.I = true;
    }

    public void b0() {
        this.I = false;
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_NEW_ENTRY_RED_DOT_SWITCH, 1) != 1 || QZoneFeedAlertService.getInstance().getSingleUnreadCount(19) == -1) {
            G0(0L, 2, 19);
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(19);
        }
        f0();
        B0();
        if (U) {
            t0();
        }
    }

    public void r(Context context) {
        U = false;
        this.f56420i.clear();
        ArrayList<entrance_cfg> loadNavigatorEntryListFromMem = QZoneFeedAlertService.getInstance().loadNavigatorEntryListFromMem(0);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("buildView cfgs size:");
            sb5.append(loadNavigatorEntryListFromMem != null ? loadNavigatorEntryListFromMem.size() : 0);
            QLog.d("QZoneFeedxNavigatorBar", 2, sb5.toString());
        }
        if (loadNavigatorEntryListFromMem != null && loadNavigatorEntryListFromMem.size() > 0) {
            this.H.clear();
            boolean t16 = StudyModeManager.t();
            Iterator<entrance_cfg> it = loadNavigatorEntryListFromMem.iterator();
            while (it.hasNext()) {
                entrance_cfg next = it.next();
                if (next.isCanNotShowOnTeenagerMod == 0 || !t16) {
                    this.H.add(next);
                }
            }
        }
        if (context != null) {
            e0(context);
            Q(context);
        }
        d0();
        U = true;
        t0();
    }

    public void v0(CustomFriendNaviData customFriendNaviData) {
        w0(customFriendNaviData, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements com.qzone.feed.ui.navigationbar.b {
        a() {
        }

        @Override // com.qzone.feed.ui.navigationbar.b
        public void a(int i3, Object obj, View view, Object... objArr) {
            if (i3 == 1) {
                String str = (String) obj;
                int i16 = 0;
                if (objArr != null && objArr.length > 0) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof Integer) {
                        try {
                            i16 = ((Integer) obj2).intValue();
                        } catch (Exception unused) {
                        }
                    }
                }
                QZoneFeedxNavigatorBar.this.Z(view, str, i16);
            }
        }
    }

    private void F(QZoneClickReport.ReportInfo reportInfo, int i3, String str) {
        if (i3 != 0) {
            reportInfo.reserves = String.valueOf(i3);
            ClickReport.l(reportInfo, true);
        }
        Context context = this.f56416d;
        if (context != null) {
            yo.d.d(str, context, null);
        }
    }

    private String N(entrance_cfg entrance_cfgVar) {
        if (entrance_cfgVar == null || TextUtils.isEmpty(entrance_cfgVar.sEntranceIcon)) {
            return null;
        }
        String str = entrance_cfgVar.sEntranceIcon;
        return k.f59549a.f() ? str.replace("/day/", "/night/") : str;
    }

    private void m0(entrance_cfg entrance_cfgVar) {
        if (entrance_cfgVar == null || entrance_cfgVar.iEntranceId != 48) {
            return;
        }
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(302, 32, 63);
        lpReportInfo_pf00064.reserves9 = entrance_cfgVar.sEntranceAction;
        lpReportInfo_pf00064.reserves3 = String.valueOf(2);
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void p0(View view, String str, int i3, String str2) {
        if (view == null || this.H == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            AccessibilityUtil.p(view, str);
            return;
        }
        AccessibilityUtil.p(view, str + "," + str2);
    }

    private void n0(entrance_cfg entrance_cfgVar) {
        if (entrance_cfgVar == null) {
            return;
        }
        int i3 = entrance_cfgVar.iEntranceId;
        if (i3 == 12) {
            eo.a.f396875a.d(7);
            return;
        }
        if (i3 == 13) {
            eo.a.f396875a.d(6);
            return;
        }
        if (i3 == 19) {
            eo.a.f396875a.d(4);
            return;
        }
        if (i3 == 20) {
            eo.a.f396875a.d(5);
        } else if (i3 == 32 || i3 == 48) {
            eo.a.f396875a.d(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.T == null) {
            this.T = new Handler(Looper.getMainLooper());
        }
        this.T.postAtFrontOfQueue(runnable);
    }

    private void w(NavigatorItem navigatorItem) {
        ArrayList<QZoneCountUserInfo> arrayList;
        if (navigatorItem == null) {
            return;
        }
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(navigatorItem.G);
        int i3 = (navigatorItem.G != 72 || singleUnReadItem == null || (arrayList = singleUnReadItem.friendList) == null || arrayList.size() <= 0) ? (singleUnReadItem == null || singleUnReadItem.uCount <= 0) ? 0 : 1 : 1;
        HashMap hashMap = new HashMap();
        hashMap.put("channellist_alert", Integer.valueOf(i3));
        hashMap.put("column_type", Integer.valueOf(navigatorItem.G));
        fo.c.o(navigatorItem, "em_qz_space_entry_column", new fo.b().i("entrance_id=" + navigatorItem.G).l(hashMap).h(new d(navigatorItem)));
    }

    private void D(QZoneClickReport.ReportInfo reportInfo, int i3) {
        if (i3 == 0) {
            i3 = 27;
        }
        reportInfo.reserves = String.valueOf(i3);
        ClickReport.l(reportInfo, true);
        Context context = this.f56416d;
        if (context != null) {
            vo.b.g(context, LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""), "getActiveFeeds");
        }
    }

    private void I(QZoneClickReport.ReportInfo reportInfo, int i3, String str, View view) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        if (i3 == 0) {
            i3 = 12;
        }
        reportInfo.reserves = String.valueOf(i3);
        ClickReport.l(reportInfo, true);
        int i16 = 0;
        while (true) {
            if (i16 >= this.f56420i.size()) {
                appInfo = null;
                break;
            }
            NavigatorItem navigatorItem = this.f56420i.get(i16);
            if (navigatorItem != null && navigatorItem.G == i3) {
                Object q16 = navigatorItem.q();
                appInfo = q16 instanceof BusinessInfoCheckUpdate.AppInfo ? (BusinessInfoCheckUpdate.AppInfo) q16 : null;
                navigatorItem.setExt(null);
            } else {
                i16++;
            }
        }
        Context context = this.f56416d;
        if (context != null) {
            if (appInfo != null) {
                l.a(context, appInfo);
            } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", EntryConstants.LEBA_ENTRY);
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGameCenter(this.f56416d, EntryConstants.LEBA_ENTRY);
            } else {
                vo.c.l(this.f56416d, str);
            }
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.16
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().cleanNewGameCount();
                QZoneFeedxNavigatorBar.this.o0(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneFeedxNavigatorBar.this.G0(0L, 2, 12);
                    }
                });
            }
        }, 3000L);
        if ((view instanceof NavigatorItem) && ((NavigatorItem) view).E() && B() != null) {
            B().onRedTouchItemClick(appInfo, null);
        }
    }

    private void M(QZoneClickReport.ReportInfo reportInfo, int i3) {
        if (i3 == 0) {
            i3 = 13;
        }
        reportInfo.reserves = String.valueOf(i3);
        ClickReport.l(reportInfo, true);
        com.qzone.misc.network.report.a.l();
        Context context = this.f56416d;
        if (context != null) {
            vo.c.M(context, IVipTraceDetailReport.FROM.QZONE_DRESS_UP_FRIENDS);
        }
        ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).updateCTime(0, Long.valueOf(LoginData.getInstance().getUin()));
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.14
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(13);
                QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneFeedxNavigatorBar.this.G0(0L, 2, 13);
                    }
                });
            }
        }, 3000L);
    }

    private void C(QZoneClickReport.ReportInfo reportInfo, int i3) {
        String str;
        if (i3 == 0) {
            i3 = 19;
        }
        reportInfo.reserves = String.valueOf(i3);
        reportInfo.reservesExt = new ArrayList<>(1);
        if (QZoneFeedAlertService.getInstance().getSingleUnreadCount(19) > 0) {
            str = "1";
        } else {
            str = "2";
        }
        reportInfo.reservesExt.add(str);
        ClickReport.l(reportInfo, true);
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_ALBUM_BANNER);
        QZLog.d("[PhotoAlbum]AlbumPerformance", 1, "Album item click");
        Context context = this.f56416d;
        if (context != null) {
            vo.b.f(context, LoginData.getInstance().getUin(), "getActiveFeeds");
        }
    }

    private void K(QZoneClickReport.ReportInfo reportInfo, int i3) {
        String str;
        if (i3 == 0) {
            i3 = 20;
        }
        reportInfo.reserves = String.valueOf(i3);
        NavigatorTianShuManager navigatorTianShuManager = this.N;
        if (navigatorTianShuManager != null && navigatorTianShuManager.f47387h == 20) {
            str = "1";
        } else {
            str = "2";
        }
        if (reportInfo.reservesExt == null) {
            reportInfo.reservesExt = new ArrayList<>(1);
        }
        reportInfo.reservesExt.add(str);
        ClickReport.l(reportInfo, true);
        if (this.f56416d != null) {
            i.j().b(this.f56416d, new QZoneMoodListInitBean(LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""), "getActiveFeeds"));
        }
    }

    private void O(QZoneClickReport.ReportInfo reportInfo, int i3, View view) {
        int i16;
        if (i3 == 0) {
            i3 = 32;
        }
        if (view instanceof NavigatorItem) {
            NavigatorItem navigatorItem = (NavigatorItem) view;
            if (navigatorItem.E()) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(navigatorItem.H, null);
                i16 = 1;
            } else {
                i16 = 2;
            }
        } else {
            i16 = 0;
        }
        reportInfo.reserves = String.valueOf(i3);
        ArrayList<String> arrayList = new ArrayList<>(1);
        reportInfo.reservesExt = arrayList;
        arrayList.add(String.valueOf(i16));
        ClickReport.l(reportInfo, true);
        G0(0L, 2, 32);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.12
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(32);
            }
        });
    }

    private void P(QZoneClickReport.ReportInfo reportInfo, int i3) {
        if (i3 == 0) {
            i3 = 17;
        }
        reportInfo.reserves = String.valueOf(i3);
        ClickReport.l(reportInfo, true);
        G0(0L, 2, 17);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.QZoneFeedxNavigatorBar.13
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(long j3, int i3, int i16) {
        NavigatorItem navigatorItem;
        if (i16 == 1) {
            j3 = 0;
        }
        for (int i17 = 0; i17 < this.f56420i.size() && (navigatorItem = this.f56420i.get(i17)) != null; i17++) {
            int i18 = navigatorItem.G;
            if (i18 == i16) {
                if (j3 <= 0) {
                    navigatorItem.z();
                    p0(navigatorItem, navigatorItem.v(), i17 + 1, "");
                } else if (i3 == 2) {
                    navigatorItem.Q(R.drawable.g0f, i18);
                    p0(navigatorItem, navigatorItem.v(), i17 + 1, com.qzone.util.l.a(R.string.ody));
                    l0(navigatorItem);
                } else if (i3 == QZoneFeedAlertService.CONTROL_SHOW_NEW) {
                    navigatorItem.Q(R.drawable.g_w, i18);
                    p0(navigatorItem, navigatorItem.v(), i17 + 1, com.qzone.util.l.a(R.string.f172217oe0));
                }
            }
        }
    }

    public QZoneFeedxNavigatorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56420i = new CopyOnWriteArrayList<>();
        this.E = new CustomFriendNaviData();
        this.H = new ArrayList<>();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.M = new b();
        this.P = new c();
        this.R = true;
        this.f56416d = context;
        S();
    }
}
