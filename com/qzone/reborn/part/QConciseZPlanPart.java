package com.qzone.reborn.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.qzone.reborn.widget.ZPlanRefreshHeaderView;
import com.qzone.zplan.view.ZPlanGuideFrameLayout;
import com.qzone.zplan.view.ZPlanMaintainingFrameLayout;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.p;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.bubble.api.IZPlanAvatarBubbleControllerFactory;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.ag;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.common.model.AppTheme;
import cooperation.qzone.QZoneTopGestureLayout;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import cooperation.qzone.api.OnRefreshStateListener;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import sj3.ZPlanReportEndTaskInfo;
import sj3.ZPlanReportStartTaskInfo;

/* loaded from: classes37.dex */
public class QConciseZPlanPart extends com.qzone.reborn.base.k implements com.qzone.feed.ui.activity.f {
    private AbsZPlanStaticFrameLayout C;
    private ZPlanMaintainingFrameLayout D;
    private ZPlanGuideFrameLayout E;
    private com.tencent.mobileqq.zplan.bubble.b G;
    private com.tencent.mobileqq.zplan.meme.frameanim.a I;
    private com.tencent.mobileqq.zplan.meme.frameanim.e J;
    private boolean N;
    private com.tencent.mobileqq.zplan.view.b P;
    private qj3.b Q;
    private BroadcastReceiver R;

    /* renamed from: d, reason: collision with root package name */
    private QZoneTopGestureLayout f58465d;

    /* renamed from: e, reason: collision with root package name */
    private BasePartFragment f58466e;

    /* renamed from: f, reason: collision with root package name */
    private uh.a f58467f;

    /* renamed from: i, reason: collision with root package name */
    private ZPlanRefreshHeaderView f58469i;

    /* renamed from: m, reason: collision with root package name */
    private gf.o f58470m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f58468h = true;
    private boolean F = false;
    private boolean H = false;
    private boolean K = false;
    private boolean L = true;
    private IZPlanRefreshMoveListener M = null;
    private AtomicBoolean S = new AtomicBoolean(false);
    private final com.tencent.mobileqq.zplan.servlet.b T = new h();
    private b.a U = new a();

    /* loaded from: classes37.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void gotoPortal(int i3) {
            QConciseZPlanPart.this.Ea(false, i3);
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void gotoSmallHome() {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(QConciseZPlanPart.this.getContext(), ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("recommend", null, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), false, null));
            QConciseZPlanPart.this.Sa();
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void showMaintain() {
            QConciseZPlanPart.this.Wa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements RefreshHeaderView.b {
        b() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.b
        public boolean a() {
            return QConciseZPlanPart.this.Ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements RefreshHeaderView.c {
        c() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.c
        public void onRefresh() {
            if (QConciseZPlanPart.this.f58466e != null) {
                if (QConciseZPlanPart.this.f58469i != null) {
                    QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onRefresh] isRefreshing=" + QConciseZPlanPart.this.f58469i.getIsRefreshing());
                }
                QConciseZPlanPart.this.f58470m.onRefresh();
                QConciseZPlanPart.this.f58470m.stopAllAudio();
            }
        }
    }

    /* loaded from: classes37.dex */
    class d implements QZoneTopGestureLayout.INestScrollListener {
        d() {
        }

        @Override // cooperation.qzone.QZoneTopGestureLayout.INestScrollListener
        public boolean isParentConsume(int i3, View view) {
            if (QConciseZPlanPart.this.f58469i != null && QConciseZPlanPart.this.f58469i.e()) {
                return true;
            }
            if (!QConciseZPlanPart.this.H) {
                return false;
            }
            QConciseZPlanPart.this.H = false;
            return true;
        }

        @Override // cooperation.qzone.QZoneTopGestureLayout.INestScrollListener
        public void onTouchEvent(MotionEvent motionEvent) {
            if (QConciseZPlanPart.this.f58469i != null) {
                QConciseZPlanPart.this.f58469i.handleRefreshGesture(motionEvent);
                QConciseZPlanPart.this.ma();
            }
            if (QConciseZPlanPart.this.f58469i == null || QConciseZPlanPart.this.f58469i.e() || QConciseZPlanPart.this.G == null || QConciseZPlanPart.this.f58469i.x() == -1 || !QConciseZPlanPart.this.G.onTouch(motionEvent)) {
                return;
            }
            QConciseZPlanPart.this.H = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e extends nk3.i {
        e() {
        }

        @Override // nk3.i
        public void onResultForSelectImage(com.tencent.mobileqq.zplan.model.g gVar) {
            QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "tryRequestBackground success, dayUrl=" + gVar.i() + ", darkUrl=" + gVar.b());
            if (QConciseZPlanPart.this.I != null) {
                QConciseZPlanPart.this.I.t();
            }
        }

        @Override // nk3.i
        public void onResultFailed() {
            QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "tryRequestBackground failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "qqAccountReceiver onReceive= " + action + " " + Thread.currentThread());
            if (QConciseZPlanPart.this.I != null) {
                QConciseZPlanPart.this.I.f();
            }
            QConciseZPlanPart.this.fb();
        }
    }

    /* loaded from: classes37.dex */
    class h implements com.tencent.mobileqq.zplan.servlet.b {
        h() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            List emptyList;
            if (i3 != 5) {
                if (i3 == 27405) {
                    try {
                        emptyList = (List) obj;
                    } catch (Throwable th5) {
                        QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                        emptyList = Collections.emptyList();
                    }
                    QConciseZPlanPart.this.sa(emptyList);
                    return;
                }
                if (i3 == 6) {
                    if (z16) {
                        if (QConciseZPlanPart.this.N) {
                            QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "no need to update avatar now, activity paused.");
                            return;
                        }
                        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_UPDATE_AVATAR_IMAGE_WITH_NEW_APPEARANCE");
                        if (QConciseZPlanPart.this.I != null) {
                            QConciseZPlanPart.this.I.j();
                            return;
                        }
                        return;
                    }
                    QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_UPDATE_AVATAR_IMAGE_WITH_NEW_APPEARANCE result:" + z16);
                    return;
                }
                return;
            }
            if (z16 && (obj instanceof HashMap)) {
                if (QConciseZPlanPart.this.f58466e == null) {
                    QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "mZPlanRequestObserver mFragment is null");
                    return;
                }
                HashMap hashMap = (HashMap) obj;
                if (!hashMap.containsKey(Long.valueOf(MobileQQ.sMobileQQ.waitAppRuntime().getLongAccountUin()))) {
                    QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_TYPE_ZPLAN_USER_INFO_1127 result:" + z16 + ", not current uin response");
                    return;
                }
                if (hashMap.containsKey(27510L) && hashMap.containsKey(3L)) {
                    QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_TYPE_ZPLAN_USER_INFO_1127 dayAvatarUrl:" + ((String) hashMap.get(27510L)) + " nightAvatarUrl:" + ((String) hashMap.get(3L)));
                    return;
                }
                QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_TYPE_ZPLAN_USER_INFO_1127 result:" + z16 + ", without deserve key");
                return;
            }
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "NOTIFY_TYPE_ZPLAN_USER_INFO_1127 result:" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QConciseZPlanPart.this.f58467f.setTitleBarTranslate(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QConciseZPlanPart.this.f58470m.setupCorner(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class k implements com.tencent.mobileqq.zplan.meme.frameanim.f {
        k() {
        }

        @Override // com.tencent.mobileqq.zplan.meme.frameanim.f
        public void onManagerResume() {
            if (QConciseZPlanPart.this.S.getAndSet(true)) {
                return;
            }
            QConciseZPlanPart qConciseZPlanPart = QConciseZPlanPart.this;
            qConciseZPlanPart.Ya(qConciseZPlanPart.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "mRefreshView onClick");
            QConciseZPlanPart.this.P.d(QConciseZPlanPart.this.U);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class o implements ZPlanRefreshHeaderView.b {
        o() {
        }

        @Override // com.qzone.reborn.widget.ZPlanRefreshHeaderView.b
        public boolean a() {
            return QConciseZPlanPart.this.Ca();
        }
    }

    public QConciseZPlanPart(gf.o oVar) {
        this.f58470m = oVar;
        cb();
    }

    private void Aa() {
        if (this.I != null) {
            QLog.w("QZoneConciseZPlan QConciseZPlanPart", 1, "initZPlanAvatarBannerManager already init");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ZPlanAvatarBannerParams zPlanAvatarBannerParams = new ZPlanAvatarBannerParams(peekAppRuntime.getCurrentAccountUin(), com.tencent.mobileqq.zplan.meme.frameanim.h.INSTANCE.a(), 3, 0);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication baseApplication = BaseApplication.context;
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.C;
        com.tencent.mobileqq.zplan.meme.frameanim.a createZPlanAvatarBannerManager = iZPlanApi.createZPlanAvatarBannerManager(baseApplication, absZPlanStaticFrameLayout, absZPlanStaticFrameLayout.getAvatarIv(), this.C.getBackgroundContainer(), zPlanAvatarBannerParams);
        this.I = createZPlanAvatarBannerManager;
        if (this.f58469i != null) {
            ArrayList arrayList = (ArrayList) createZPlanAvatarBannerManager.d();
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f58469i.C((OnRefreshStateListener) it.next());
                }
            }
            ArrayList arrayList2 = (ArrayList) this.I.c();
            if (arrayList2.size() > 0) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    this.f58469i.B((IZPlanRefreshMoveListener) it5.next());
                }
            }
        }
        this.I.r(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ba() {
        return this.f58470m.isFeedViewListOnTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ca() {
        return !Da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea(boolean z16, final int i3) {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "jumpZPlanPortalActivity " + z16);
        final Bundle bundle = new Bundle();
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        bundle.putInt(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, aVar == null ? 0 : aVar.b());
        if (z16) {
            this.f58466e.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.part.QConciseZPlanPart.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QConciseZPlanPart.this.I != null) {
                        QConciseZPlanPart.this.I.h(i3);
                    }
                    ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(QConciseZPlanPart.this.getActivity(), ZootopiaSource.create(Source.DynamicEntry), bundle);
                    QConciseZPlanPart.this.Qa(i3);
                }
            }, 100L);
            return;
        }
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar2 = this.I;
        if (aVar2 != null) {
            aVar2.h(i3);
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(getActivity(), ZootopiaSource.create(Source.DynamicEntry), bundle);
        Qa(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Fa(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.P.c(null);
            return false;
        }
        if (motionEvent.getActionMasked() != 1) {
            return false;
        }
        this.P.c(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ga(Boolean bool) {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "avatar loading overlay isShowingLoading changed, new value: " + bool);
        if (bool.booleanValue()) {
            va();
        } else {
            Ua();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ha() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestAddDCBackImage(peekAppRuntime.getLongAccountUin(), 5, null, new e());
    }

    private void Ma() {
        if (this.f58466e == null) {
            QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "registerQQAccountReceiver fail, fragment null");
        } else if (this.R == null) {
            this.R = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            getActivity().registerReceiver(this.R, intentFilter);
        }
    }

    private void Na() {
        if (((Integer) p.b(getContext(), MobileQQ.sMobileQQ.waitAppRuntime().getCurrentAccountUin(), "sp_key_qzone_zplan_guide", 0)).intValue() != 0 || Da()) {
            return;
        }
        l lVar = new l();
        this.M = lVar;
        this.f58469i.B(lVar);
    }

    private void Oa() {
        com.tencent.mobileqq.zplan.meme.frameanim.e eVar = this.J;
        if (eVar != null) {
            if (eVar.c() != null && this.f58466e != null) {
                this.J.c().removeObservers(this.f58466e);
            }
            this.J.release();
            this.J = null;
        }
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar == null) {
            return;
        }
        if (this.f58469i != null) {
            ArrayList arrayList = (ArrayList) aVar.d();
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f58469i.G((OnRefreshStateListener) it.next());
                }
            }
            ArrayList arrayList2 = (ArrayList) this.I.c();
            if (arrayList2.size() > 0) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    this.f58469i.F((IZPlanRefreshMoveListener) it5.next());
                }
            }
        }
        this.I.n();
        this.I = null;
    }

    private void Pa() {
        if (this.f58466e == null) {
            QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "removeZplanRequestObserver fail, fragment null");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "removeZplanRequestObserver");
            ((QQAppInterface) peekAppRuntime).removeObserver(this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qa(int i3) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (i3 == 3) {
            str = "em_zplan_portal_entrance_dongtai_actionsheet";
        } else {
            str = "em_zplan_entrance_qq_active";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_entrance_status", ra());
        hashMap.put("zplan_ziliaodongtai_portal_entrance_split", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private void Ra() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_active");
        hashMap.put("zplan_action_type", "imp");
        hashMap.put("zplan_entrance_status", ra());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sa() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_xiaowo_entrance_dongtai_actionsheet");
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_entrance_status", ra());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private void Ta() {
        eb();
        fb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va(int i3) {
        RelativeLayout.LayoutParams layoutParams;
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.E;
        if (zPlanGuideFrameLayout == null || zPlanGuideFrameLayout.getVisibility() == 8 || (layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams()) == null) {
            return;
        }
        layoutParams.topMargin = i3 - ViewUtils.dip2px(45.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa(long j3, int i3) {
        ValueAnimator ofInt;
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[showTitleBarAlphaByAnimator] destAlpha = " + i3);
        uh.a aVar = this.f58467f;
        if (aVar == null || aVar.a() == i3) {
            return;
        }
        if (i3 == 0) {
            this.f58467f.b(-1);
            this.f58467f.setConciseLeftTitleVisibility(4);
        }
        if (i3 == 255) {
            this.f58467f.setAdaptToConcise(QQTheme.getCurrentThemeId());
            this.f58467f.setConciseLeftTitleVisibility(0);
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f58467f.a(), i3);
        ofInt2.setDuration(j3);
        ofInt2.addUpdateListener(new i());
        ofInt2.start();
        int dpToPx = ViewUtils.dpToPx(16.0f);
        if (i3 == 0) {
            ofInt = ValueAnimator.ofInt(0, dpToPx);
        } else {
            ofInt = ValueAnimator.ofInt(dpToPx, 0);
        }
        ofInt.addUpdateListener(new j());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ya(FrameLayout frameLayout) {
        oa(frameLayout);
        this.G.g(0L);
    }

    private void ab() {
        if (this.D != null) {
            if (this.C != null) {
                QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "mZPlanStaticLayout should be null!");
            }
            if (qa() != this.D.getMShowedGender()) {
                this.D.i();
                return;
            }
            return;
        }
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "[showZPlanMaintainingView]");
        Oa();
        this.f58465d.removeView(this.C);
        this.C = null;
        this.D = new ZPlanMaintainingFrameLayout(getContext());
        this.f58465d.addView(this.D, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void bb() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.o();
            com.tencent.mobileqq.zplan.meme.frameanim.e eVar = this.J;
            if (eVar != null) {
                eVar.b(this.I.a());
            }
        }
    }

    private void cb() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "start zplan openTelemetry report failed, app null.");
            return;
        }
        qj3.b zPlanTracer = ((IZPlanReportHelper) peekAppRuntime.getRuntimeService(IZPlanReportHelper.class, "all")).getZPlanTracer();
        this.Q = zPlanTracer;
        if (zPlanTracer == null) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "startZPlanOpenTelemetryReport failed, reportTracer null.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TAG", "QConciseZPlanPart");
        this.Q.d(new ZPlanReportStartTaskInfo("zplan_qzone", String.valueOf(3), null, null, hashMap, Long.valueOf(ShortVideoConstants.VIDEO_MAX_DURATION)));
    }

    private void eb() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.part.QConciseZPlanPart.14
            @Override // java.lang.Runnable
            public void run() {
                AppTheme appTheme;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                if (QQTheme.isNowThemeIsNight()) {
                    appTheme = AppTheme.NIGHT;
                } else {
                    appTheme = AppTheme.DAY;
                }
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                String zPlanAvatarImagePath = iZPlanApi.getZPlanAvatarImagePath(appTheme.toString());
                String avatarLocalUrlWithUin = iZPlanApi.getAvatarLocalUrlWithUin(appTheme.toString(), currentAccountUin);
                if (TextUtils.isEmpty(zPlanAvatarImagePath) && TextUtils.isEmpty(avatarLocalUrlWithUin)) {
                    iZPlanApi.requestStaticImageUrl();
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.part.e
            @Override // java.lang.Runnable
            public final void run() {
                QConciseZPlanPart.this.Ha();
            }
        }, 16, null, true);
    }

    private void gb() {
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        if (zPlanRefreshHeaderView == null && this.M == null) {
            return;
        }
        if (zPlanRefreshHeaderView != null) {
            zPlanRefreshHeaderView.F(this.M);
        }
        this.M = null;
    }

    private void hb() {
        if (this.f58466e == null) {
            QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "unregisterQQAccountReceiver fail, fragment null");
        } else if (this.R != null) {
            getActivity().unregisterReceiver(this.R);
            this.R = null;
        }
    }

    private void ja() {
        if (this.C != null) {
            if (this.D != null) {
                QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "mZPlanMaintainingLayout should be null!");
                return;
            }
            return;
        }
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "[showZPlanStaticView]");
        this.f58465d.removeView(this.D);
        this.D = null;
        this.C = ag.f335760a.c(getContext());
        this.f58465d.addView(this.C, 0, new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.mobileqq.qui.b.f276860a.a(this.C, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        qj3.b bVar = this.Q;
        if (bVar != null) {
            bVar.e("zplan_qzone_init", String.valueOf(3), "zplan_qzone_static_view", null);
        }
        Aa();
        wa();
    }

    private void la() {
        if (this.f58466e == null) {
            QZLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "addZplanRequestObserver fail, fragment null");
            return;
        }
        Pa();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime instanceof QQAppInterface) {
            QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "addZplanRequestObserver");
            ((QQAppInterface) waitAppRuntime).addObserver(this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        boolean g16;
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        if (zPlanRefreshHeaderView == null || this.f58470m == null || (g16 = zPlanRefreshHeaderView.g()) == this.f58468h) {
            return;
        }
        this.f58468h = g16;
        this.f58470m.setSupportPullDown(!g16);
    }

    private void na(String str) {
        if (this.Q == null) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "endAllReports failed, reportTracer null.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TAG", "QConciseZPlanPart");
        hashMap.put("endFrom", str);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo = new ZPlanReportEndTaskInfo("zplan_qzone", String.valueOf(3), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo2 = new ZPlanReportEndTaskInfo("zplan_qzone_init", String.valueOf(3), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo3 = new ZPlanReportEndTaskInfo("zplan_qzone_avatar_manager", String.valueOf(3), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo4 = new ZPlanReportEndTaskInfo("zplan_qzone_resource", String.valueOf(3), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo5 = new ZPlanReportEndTaskInfo("zplan_qzone_player", String.valueOf(3), 0, hashMap);
        this.Q.c(zPlanReportEndTaskInfo2);
        this.Q.c(zPlanReportEndTaskInfo3);
        this.Q.c(zPlanReportEndTaskInfo4);
        this.Q.c(zPlanReportEndTaskInfo5);
        this.Q.c(zPlanReportEndTaskInfo);
    }

    private void oa(FrameLayout frameLayout) {
        com.tencent.mobileqq.zplan.bubble.b bVar = this.G;
        if (bVar != null) {
            bVar.a(frameLayout);
        } else {
            this.G = ((IZPlanAvatarBubbleControllerFactory) QRoute.api(IZPlanAvatarBubbleControllerFactory.class)).generateController(frameLayout, this.f58469i.getWidth(), this.f58469i.getHeight(), "em_zplan_entrance_qq_active");
        }
    }

    private short qa() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Card t16 = ((FriendsManager) waitAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).t(waitAppRuntime.getCurrentAccountUin());
        if (t16 == null) {
            return (short) -1;
        }
        return t16.shGender;
    }

    private String ra() {
        if (Da()) {
            return "maintaining";
        }
        return "serviceable";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(List<String> list) {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && list.contains(((QQAppInterface) peekAppRuntime).getCurrentUin()) && (aVar = this.I) != null) {
            aVar.g();
        }
    }

    private void ta() {
        com.tencent.mobileqq.zplan.bubble.b bVar = this.G;
        if (bVar == null) {
            return;
        }
        bVar.e();
    }

    private void wa() {
        if (!this.I.e()) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "no dynamic avatar, initAvatarLoadingOverlay return");
            return;
        }
        if (!((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableQzoneRecordLoadingAnim()) {
            QLog.w("QZoneConciseZPlan QConciseZPlanPart", 1, "record loading overlay is disable by FeatureSwitch.");
            return;
        }
        if (this.J != null) {
            QLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "already init overlay helper.");
            return;
        }
        oa(this.C);
        this.J = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createAvatarLoadingViewHelper(LayoutInflater.from(getContext()), this.f58466e, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanDynamicAvatarOverlayViewModelClass());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.J.e(this.G);
        this.C.addView(this.J.f(), layoutParams);
        this.I.q(this.J);
        this.J.c().observe(this.f58466e, new Observer() { // from class: com.qzone.reborn.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QConciseZPlanPart.this.Ga((Boolean) obj);
            }
        });
    }

    private void xa() {
        this.f58469i.setBackgroundColor(Color.parseColor("#00000000"));
        this.f58469i.findViewById(R.id.f110596iy).setVisibility(8);
        Integer g16 = ni3.a.f420201a.g();
        if (g16 != null) {
            this.f58469i.setMeasuredHeight(g16.intValue());
        }
        ((ImageView) this.f58469i.findViewById(R.id.y4_)).setImageDrawable(null);
        this.f58469i.setCanRefreshDelegate(new b());
        this.f58469i.setOnRefreshListener(new c());
    }

    private void za() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "init report tracer failed, app null.");
        } else {
            this.Q = ((IZPlanReportHelper) runtime.getRuntimeService(IZPlanReportHelper.class, "all")).getZPlanTracer();
        }
    }

    public boolean Da() {
        return com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
    }

    public void Ia() {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", "[onTabChangeInQzone]");
        this.K = true;
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.k(true);
        }
    }

    public void Ja() {
        ta();
        this.K = false;
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.k(false);
        }
    }

    public void La() {
        gf.o oVar = this.f58470m;
        if (oVar != null) {
            oVar.setNestedScrollingEnabled(true);
            this.f58470m.setSupportPullDown(false);
            QZoneTopGestureLayout qZoneTopGestureLayout = this.f58465d;
            if (qZoneTopGestureLayout != null) {
                qZoneTopGestureLayout.setNestScrollListener(new d());
            }
        }
        gf.o oVar2 = this.f58470m;
        if (oVar2 != null) {
            oVar2.setQZoneRefreshIndicatorInterface(this);
        }
    }

    public void Wa() {
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(maintenanceInfo.f());
        createCustomDialog.setMessage(maintenanceInfo.g());
        createCustomDialog.setPositiveButton(R.string.f172538rr3, (DialogInterface.OnClickListener) new f(), true);
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneConciseZPlan QConciseZPlanPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals(str, "z_plan_head_view_visible")) {
            if (this.f58469i != null && this.f58467f != null) {
                QLog.d("QZoneConciseZPlan QConciseZPlanPart", 1, "broadcastGetMessage  z_plan_head_view_visible | mRefreshView.getState() = " + this.f58469i.x() + " | mTitleBar.getTitleAlpha() = " + this.f58467f.a());
                if (this.f58469i.x() != -1 || this.f58467f.a() < 255) {
                    return Boolean.TRUE;
                }
            } else {
                QLog.d("QZoneConciseZPlan QConciseZPlanPart", 1, "broadcastGetMessage  z_plan_head_view_visible params error | mRefreshView = " + this.f58469i + " | titleBar = " + this.f58467f);
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    @Override // com.qzone.feed.ui.activity.f
    public boolean isRefreshing() {
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        boolean isRefreshing = zPlanRefreshHeaderView != null ? zPlanRefreshHeaderView.getIsRefreshing() : false;
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[isRefreshing] isRefreshing=" + isRefreshing);
        return isRefreshing;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.i(configuration);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onInitView] | " + toString());
        super.onInitView(view);
        this.f58466e = (BasePartFragment) getPartHost();
        this.f58467f = this.f58470m.getZPlanTitleHost();
        if (view != null) {
            this.f58465d = this.f58470m.getTopGestureLayout(view);
        }
        za();
        ia(view);
        Za();
        Na();
        ja();
        bb();
        Ta();
        la();
        Ma();
        Ra();
        if (this.Q != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("TAG", "QConciseZPlanPart");
            this.Q.c(new ZPlanReportEndTaskInfo("zplan_qzone_init", String.valueOf(3), 0, hashMap));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onPartCreate] | " + toString());
        this.N = false;
        super.onPartCreate(activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onPartDestroy] | " + toString());
        super.onPartDestroy(activity);
        Pa();
        hb();
        Oa();
        gb();
        na("onPartDestroy");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.m();
        }
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onPartPause] | " + toString());
        this.N = true;
        this.S.getAndSet(false);
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onPartResume] | " + toString());
        this.N = false;
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[onPartStop] | " + toString());
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.I;
        if (aVar != null) {
            aVar.s();
        }
    }

    public void onResume() {
        Object obj;
        if (this.f58465d == null) {
            QZLog.w("QZoneConciseZPlan QConciseZPlanPart", 1, "[onResume] rootContainer is null");
            return;
        }
        if (Da()) {
            ab();
        } else {
            bb();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onResume] curState=");
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        if (zPlanRefreshHeaderView != null) {
            obj = Integer.valueOf(zPlanRefreshHeaderView.x());
        } else {
            obj = "";
        }
        sb5.append(obj);
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, sb5.toString());
        ZPlanRefreshHeaderView zPlanRefreshHeaderView2 = this.f58469i;
        if (zPlanRefreshHeaderView2 == null || zPlanRefreshHeaderView2.x() != 17) {
            return;
        }
        this.f58469i.p();
    }

    @Override // com.qzone.feed.ui.activity.f
    public void t() {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[showProgressBar]");
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        if (zPlanRefreshHeaderView != null) {
            zPlanRefreshHeaderView.setState(2);
            this.f58469i.setRefreshing(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class l implements IZPlanRefreshMoveListener {
        l() {
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onMove(int i3) {
            QConciseZPlanPart.this.L = false;
            QConciseZPlanPart.this.Va(i3);
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onStateChange(int i3) {
            if (i3 == 13 || i3 == 14) {
                Integer e16 = ni3.a.f420201a.e();
                if (e16 != null) {
                    QConciseZPlanPart.this.Va(e16.intValue());
                } else {
                    QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "onRelease failed, initHeight null.");
                    return;
                }
            } else if (i3 == 15) {
                Integer g16 = ni3.a.f420201a.g();
                if (g16 != null) {
                    QConciseZPlanPart.this.Va(g16.intValue());
                } else {
                    QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "onRelease failed, refreshHeight null.");
                    return;
                }
            }
            QConciseZPlanPart.this.L = true;
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onRelease() {
        }
    }

    private void Ua() {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "resume temporally hide guide view");
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.E;
        if (zPlanGuideFrameLayout == null) {
            QLog.w("QZoneConciseZPlan QConciseZPlanPart", 1, "zplan guide layout haven't initialized when resume!");
            Za();
        } else if (this.F && zPlanGuideFrameLayout.getVisibility() == 8) {
            this.E.setVisibility(0);
        }
    }

    private void Za() {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "[showZPlanGuideView]");
        Integer e16 = ni3.a.f420201a.e();
        if (e16 == null) {
            QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "showZPlanGuideView failed, initHeight null.");
            return;
        }
        this.F = ((Integer) p.b(getContext(), MobileQQ.sMobileQQ.waitAppRuntime().getCurrentAccountUin(), "sp_key_qzone_zplan_guide", 0)).intValue() == 0;
        this.E = new ZPlanGuideFrameLayout(getContext());
        if (this.F && !Da()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(65.0f));
            layoutParams.topMargin = e16.intValue() - ViewUtils.dip2px(45.0f);
            this.f58465d.addView(this.E, 0, layoutParams);
            this.E.setVisibility(0);
            qj3.b bVar = this.Q;
            if (bVar != null) {
                bVar.e("zplan_qzone_init", String.valueOf(3), "zplan_qzone_guide_view", null);
                return;
            }
            return;
        }
        this.E.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua() {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "[hideZPlanGuideView]");
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.E;
        if (zPlanGuideFrameLayout == null || zPlanGuideFrameLayout.getVisibility() == 8) {
            return;
        }
        this.E.setVisibility(8);
        this.F = false;
        p.g(getContext(), MobileQQ.sMobileQQ.waitAppRuntime().getCurrentAccountUin(), false, "sp_key_qzone_zplan_guide", 1);
        gb();
    }

    private void va() {
        QLog.i("QZoneConciseZPlan QConciseZPlanPart", 2, "hide guide view temporally");
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.E;
        if (zPlanGuideFrameLayout == null || zPlanGuideFrameLayout.getVisibility() == 8) {
            return;
        }
        this.E.setVisibility(8);
    }

    public void Ka() {
        gf.o oVar;
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[refreshComplete]");
        if (this.f58469i != null) {
            if (!Ba() && (oVar = this.f58470m) != null && oVar.shouldScrollTopWhenRefreshComplete()) {
                this.f58470m.scrollToTop();
            }
            this.f58469i.setRefreshing(false);
        }
    }

    @Override // com.qzone.feed.ui.activity.f
    public void y() {
        QZLog.i("QZoneConciseZPlan QConciseZPlanPart", 1, "[hideProgressBar]");
        ZPlanRefreshHeaderView zPlanRefreshHeaderView = this.f58469i;
        if (zPlanRefreshHeaderView != null) {
            zPlanRefreshHeaderView.setRefreshing(false);
        }
    }

    private int pa(ViewGroup viewGroup, View view) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            if (view == viewGroup.getChildAt(i3)) {
                return i3;
            }
        }
        return 0;
    }

    public void ia(View view) {
        if (view != null) {
            Context context = getContext();
            if (context == null) {
                QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "[addRefreshView] context is null");
                return;
            }
            this.f58469i = new ZPlanRefreshHeaderView(context);
            View feedListView = this.f58470m.getFeedListView(view);
            int pa5 = pa(this.f58465d, feedListView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.f58469i.setId(View.generateViewId());
            this.f58465d.addView(this.f58469i, pa5, layoutParams);
            com.tencent.mobileqq.zplan.view.b b16 = ag.f335760a.b(this.f58469i, ZPlanAvatarSource.QZONE, true, -1L);
            this.P = b16;
            b16.b("em_zplan_xiaowo_entrance_dongtai_background");
            this.f58469i.setMaxVisibilityHeight(com.tencent.mobileqq.zplan.meme.frameanim.c.INSTANCE.a() - ImmersiveUtils.dpToPx(16.0f));
            ((RelativeLayout.LayoutParams) feedListView.getLayoutParams()).addRule(3, this.f58469i.getId());
            xa();
            qj3.b bVar = this.Q;
            if (bVar != null) {
                bVar.e("zplan_qzone_init", String.valueOf(3), "zplan_qzone_add_refresh_view", null);
            }
        }
        this.f58469i.C(new m());
        this.f58469i.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.part.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Fa;
                Fa = QConciseZPlanPart.this.Fa(view2, motionEvent);
                return Fa;
            }
        });
        this.f58469i.setOnClickListener(new n());
        this.f58469i.setZPlanEnableEnterFullScreen(new o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class m implements OnRefreshStateListener {
        m() {
        }

        @Override // cooperation.qzone.api.OnRefreshStateListener
        public void onRefreshStateChange(int i3, Object obj) {
            if (i3 == 17) {
                if (QConciseZPlanPart.this.C != null) {
                    if (QConciseZPlanPart.this.Q != null) {
                        QConciseZPlanPart.this.Q.e("zplan_qzone_avatar_manager", String.valueOf(3), "zplan_qzone_jump_to_portal", null);
                    }
                    QConciseZPlanPart.this.Ea(true, 2);
                }
                QConciseZPlanPart.this.ua();
            } else if (i3 == 13) {
                if (QConciseZPlanPart.this.L) {
                    Integer e16 = ni3.a.f420201a.e();
                    if (e16 != null) {
                        QConciseZPlanPart.this.Va(e16.intValue());
                    } else {
                        QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "onRefreshStateChange failed, initHeight null.");
                        return;
                    }
                }
                if (!QConciseZPlanPart.this.Ba() && QConciseZPlanPart.this.f58470m != null) {
                    QConciseZPlanPart.this.f58470m.scrollToTop();
                }
                QConciseZPlanPart.this.Xa(200L, 0);
                if (QConciseZPlanPart.this.I != null) {
                    QConciseZPlanPart.this.I.p();
                }
            } else if (i3 == -1) {
                QConciseZPlanPart.this.Xa(200L, 255);
                if (QConciseZPlanPart.this.I != null) {
                    QConciseZPlanPart.this.I.m();
                }
            } else if (i3 == 15) {
                if (QConciseZPlanPart.this.L) {
                    Integer g16 = ni3.a.f420201a.g();
                    if (g16 != null) {
                        QConciseZPlanPart.this.Va(g16.intValue());
                    } else {
                        QLog.e("QZoneConciseZPlan QConciseZPlanPart", 1, "refresh failed, refreshHeight null.");
                        return;
                    }
                }
                QConciseZPlanPart.this.Xa(0L, 0);
            }
            QConciseZPlanPart.this.f58469i.setClickable(i3 == 13);
        }
    }
}
