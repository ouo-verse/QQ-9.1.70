package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.utils.PopupDialog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.aio.VasZplanAIOData;
import com.tencent.mobileqq.vas.aio.VasZplanAvatarIcon;
import com.tencent.mobileqq.vas.aio.VasZplanInfo;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOZplanEntranceHelper implements u {
    private final c E;

    /* renamed from: d, reason: collision with root package name */
    private ApngDrawable.OnPlayRepeatListener f178683d;

    /* renamed from: e, reason: collision with root package name */
    private GifDrawable.OnGIFPlayOnceListener f178684e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.vas.aio.a f178685f;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f178686h = Boolean.FALSE;

    /* renamed from: i, reason: collision with root package name */
    private boolean f178687i = false;

    /* renamed from: m, reason: collision with root package name */
    private int f178688m = -1;
    private final RedpointObserver C = new a();
    private final TimerTaskManager.TimerTaskRunnable D = new AnonymousClass2();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 extends TimerTaskManager.TimerTaskRunnable {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Boolean bool) {
            if (bool.booleanValue()) {
                AIOZplanEntranceHelper.this.P(Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit i(final Boolean bool) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.o
                @Override // java.lang.Runnable
                public final void run() {
                    AIOZplanEntranceHelper.AnonymousClass2.this.h(bool);
                }
            });
            return null;
        }

        @Override // com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable
        public void e() {
            if (QLog.isColorLevel()) {
                QLog.d("AIOZplanEntranceHelper", 1, "execute timer task");
            }
            ((IVasZplanAIOSmallHomeService) QRoute.api(IVasZplanAIOSmallHomeService.class)).requestEntranceInfo(AIOZplanEntranceHelper.this.x(), new Function1() { // from class: com.tencent.mobileqq.activity.aio.helper.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i3;
                    i3 = AIOZplanEntranceHelper.AnonymousClass2.this.i((Boolean) obj);
                    return i3;
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends RedpointObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            AIOZplanEntranceHelper.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("AIOZplanEntranceHelper", 800L)) {
                AIOZplanEntranceHelper.this.z(view);
                AIOZplanEntranceHelper.this.N("click");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(int i3, Object obj);

        boolean b(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16);

        String c();

        boolean d(View view);

        String e();

        Context getContext();
    }

    public AIOZplanEntranceHelper(c cVar) {
        this.E = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Boolean bool) {
        if (bool.booleanValue()) {
            this.f178685f.h(this.D);
        }
        this.f178687i = bool.booleanValue();
        P(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit B(final Boolean bool) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                AIOZplanEntranceHelper.this.A(bool);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        R(this.f178685f.c(x()), x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(int i3) {
        if (i3 == 1) {
            QLog.i("AIOZplanEntranceHelper", 1, "apng play once");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.m
                @Override // java.lang.Runnable
                public final void run() {
                    AIOZplanEntranceHelper.this.D();
                }
            });
            this.f178683d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        R(this.f178685f.c(x()), x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        QLog.i("AIOZplanEntranceHelper", 1, "gif play once");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.d
            @Override // java.lang.Runnable
            public final void run() {
                AIOZplanEntranceHelper.this.F();
            }
        });
        this.f178684e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        H("\u5feb\u6765\u6211\u5bb6\u770b\u770b\u5427", 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(Boolean bool) {
        if (bool.booleanValue()) {
            MMKVOptionEntity from = QMMKV.from(this.E.getContext(), "vas_mmkv_configurations");
            if (from.decodeInt("sp_key_aio_zplan_btn_status", 0) == 0) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOZplanEntranceHelper.this.I();
                    }
                }, 500L);
                from.encodeInt("sp_key_aio_zplan_btn_status", 1);
                from.encodeLong("sp_key_aio_vas_zplan_btn_bubble_show_time", NetConnInfoCenter.getServerTime());
                from.encodeInt("sp_key_aio_vas_zplan_btn_bubble_nums", 1);
                this.f178685f.d(1);
            }
            y();
            return;
        }
        this.E.a(3, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(final Boolean bool) {
        QLog.i("AIOZplanEntranceHelper", 1, "getZplanSmallHomeAccessableFromCache success! isRegistered:" + bool);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                AIOZplanEntranceHelper.this.J(bool);
            }
        });
    }

    private void L() {
        this.E.a(1, null);
        com.tencent.mobileqq.vas.aio.a aVar = this.f178685f;
        if (aVar != null) {
            aVar.b();
            this.f178685f.d(4);
        }
        this.f178684e = null;
        this.f178683d = null;
        AppInterface v3 = v();
        QLog.i("AIOZplanEntranceHelper", 1, "removeObserver, appInterface= " + v3 + ", mRedPointObserver= " + this.C);
        if (v3 != null) {
            v().removeObserver(this.C);
        }
        this.f178686h = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        IRedTouchManager iRedTouchManager = (IRedTouchManager) v().getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(15, "130223");
        if (this.E.b(appInfo, r().booleanValue())) {
            iRedTouchManager.onRedTouchItemExposure(appInfo, null);
            this.f178685f.d(7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str) {
        IRedTouchManager iRedTouchManager = (IRedTouchManager) v().getRuntimeService(IRedTouchManager.class, "");
        Map<String, Object> u16 = u();
        u16.put("zplan_action_type", str);
        if (this.f178685f.e(x())) {
            u16.put("zplan_entrance_icon", "1");
        }
        int hasShowStatus = this.f178685f.getHasShowStatus();
        if (hasShowStatus != 1) {
            if (hasShowStatus != 2) {
                if (hasShowStatus != 3) {
                    if (hasShowStatus == 7) {
                        u16.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, "1");
                        BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(15, "130223");
                        if (appInfo != null && appInfo.type.get() == 0) {
                            u16.put("reddot_num", "1");
                        }
                    }
                } else {
                    u16.put("zplan_entrance_ads", "2");
                }
            } else {
                u16.put("zplan_entrance_ads", "1");
            }
        } else {
            u16.put(SquareReportConst.Key.KEY_MSG_BOX_HAS_BUBBLE, "1");
        }
        ((IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class)).reportEvent("ev_zplan_external_entrance_action", u16);
    }

    private void O(String str, int i3, Boolean bool) {
        if (!bool.booleanValue() && i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener = new GifDrawable.OnGIFPlayOnceListener() { // from class: com.tencent.mobileqq.activity.aio.helper.k
                        @Override // com.tencent.image.GifDrawable.OnGIFPlayOnceListener
                        public final void onPlayOnce() {
                            AIOZplanEntranceHelper.this.G();
                        }
                    };
                    this.f178684e = onGIFPlayOnceListener;
                    this.E.a(5, this.f178685f.j(null, str, onGIFPlayOnceListener));
                    return;
                }
                return;
            }
            ApngDrawable.OnPlayRepeatListener onPlayRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.activity.aio.helper.j
                @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                public final void onPlayRepeat(int i16) {
                    AIOZplanEntranceHelper.this.E(i16);
                }
            };
            this.f178683d = onPlayRepeatListener;
            this.E.a(5, this.f178685f.k(null, str, onPlayRepeatListener));
            return;
        }
        this.E.a(5, this.f178685f.getDrawable(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Boolean bool) {
        this.f178686h = Boolean.FALSE;
        VasZplanAIOData aioData = this.f178685f.getAioData();
        if (aioData == null) {
            this.f178685f.o(null, this.f178685f.m());
        } else if (this.f178685f.a() && aioData.getBubble() != null) {
            final int exposureDuration = aioData.getBubble().getExposureDuration();
            final String text = aioData.getBubble().getText();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.f
                @Override // java.lang.Runnable
                public final void run() {
                    AIOZplanEntranceHelper.this.H(text, exposureDuration);
                }
            }, 500L);
            this.f178685f.q();
        }
        if (!bool.booleanValue() && !this.f178685f.n(x())) {
            return;
        }
        AppInterface v3 = v();
        QLog.i("AIOZplanEntranceHelper", 1, "addObserver, appInterface= " + v3 + ", mRedPointObserver=" + this.C + ", " + this.f178688m);
        if (v3 != null && this.f178688m == 5) {
            v3.addObserver(this.C);
        }
        R(this.f178685f.c(x()), x());
        if (this.f178685f.getHasShowStatus() == 4) {
            M();
        }
        N("imp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void H(String str, int i3) {
        int color;
        CalloutPopupWindow.Builder lifetime = CalloutPopupWindow.builder(this.E.getContext()).setText(str).setTextSize(14.0f).setTextColor(-1).setLifetime(i3);
        lifetime.setPosition(50);
        if (ThemeUtil.isNowThemeIsNight(v(), false, null)) {
            color = this.E.getContext().getResources().getColor(R.color.c4t);
        } else {
            color = this.E.getContext().getResources().getColor(R.color.c4v);
        }
        CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(lifetime).setBackgroundColor(color).setBackgroundRadius(8).build().build();
        if (build != null) {
            build.setFocusable(true);
            this.E.a(9, build);
        }
    }

    private void R(int i3, long j3) {
        VasZplanInfo info;
        VasZplanAIOData aioData = this.f178685f.getAioData();
        c cVar = this.E;
        Boolean bool = Boolean.FALSE;
        cVar.a(7, bool);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 == 6 && aioData != null && (info = aioData.getInfo()) != null && !TextUtils.isEmpty(info.getBackgroundIconUrl())) {
                            O(aioData.getInfo().getBackgroundIconUrl(), 0, bool);
                            return;
                        }
                        return;
                    }
                    if (this.f178685f.getHasShowStatus() == 7) {
                        this.E.a(8, null);
                    }
                    VasZplanAvatarIcon g16 = this.f178685f.g(j3, w());
                    if (g16 != null && !TextUtils.isEmpty(g16.getUrl()) && !this.f178686h.booleanValue()) {
                        O(g16.getUrl(), g16.getType(), bool);
                        this.f178686h = Boolean.TRUE;
                        return;
                    } else {
                        this.E.a(4, new int[]{R.drawable.qui_xiaowo_icon_nav_secondary, R.drawable.qui_xiaowo_icon_nav_secondary});
                        this.E.a(7, bool);
                        return;
                    }
                }
                this.E.a(4, new int[]{R.drawable.qui_xiaowo_icon_nav_secondary, R.drawable.qui_xiaowo_icon_nav_secondary});
                return;
            }
            if (aioData != null && aioData.getCycleIcon() != null && !TextUtils.isEmpty(aioData.getCycleIcon().getUrl())) {
                O(aioData.getCycleIcon().getUrl(), aioData.getCycleIcon().getType(), Boolean.TRUE);
                this.f178685f.d(i3);
                return;
            }
            return;
        }
        if (aioData != null && aioData.getAdvIcon() != null && !TextUtils.isEmpty(aioData.getAdvIcon().getUrl())) {
            O(aioData.getAdvIcon().getUrl(), aioData.getAdvIcon().getType(), bool);
            this.f178685f.d(i3);
            this.f178685f.i(i3);
        }
    }

    private Boolean r() {
        return Boolean.valueOf(this.f178685f.l(x()));
    }

    private void s() {
        com.tencent.mobileqq.vas.aio.a aVar = this.f178685f;
        if (aVar != null && this.f178687i) {
            aVar.h(this.D);
        }
        S();
    }

    private void t() {
        com.tencent.mobileqq.vas.aio.a aVar = this.f178685f;
        if (aVar != null) {
            aVar.b();
        }
    }

    private Map<String, Object> u() {
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_aiotop");
        hashMap.put("zplan_other_user_qq", this.E.e());
        hashMap.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, "0");
        hashMap.put(SquareReportConst.Key.KEY_MSG_BOX_HAS_BUBBLE, "0");
        hashMap.put("reddot_num", "0");
        hashMap.put("zplan_entrance_icon", "0");
        hashMap.put("zplan_entrance_ads", "0");
        return hashMap;
    }

    private AppInterface v() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private int w() {
        if (ThemeUtil.isNowThemeIsNight(v(), false, null)) {
            return 3;
        }
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long x() {
        return StringUtil.stringToLong("AIOZplanEntranceHelper", this.E.e());
    }

    private void y() {
        this.E.a(3, 0);
        long x16 = x();
        if (this.f178685f.r(x16)) {
            ((IVasZplanAIOSmallHomeService) QRoute.api(IVasZplanAIOSmallHomeService.class)).requestEntranceInfo(x16, new Function1() { // from class: com.tencent.mobileqq.activity.aio.helper.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = AIOZplanEntranceHelper.this.B((Boolean) obj);
                    return B;
                }
            });
        } else {
            P(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        if (com.tencent.mobileqq.relationx.onewayfriend.a.a(v(), 0, this.E.e())) {
            PopupDialog.o0(this.E.getContext(), 230, null, "\u6682\u65e0\u5bf9\u65b9\u5c0f\u7a9d\u8bbf\u95ee\u6743\u9650", R.string.cancel, R.string.dcl, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.helper.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIOZplanEntranceHelper.C(dialogInterface, i3);
                }
            }, null);
            return;
        }
        this.E.a(6, null);
        MasterInfo masterInfo = new MasterInfo();
        masterInfo.setUin(this.E.e());
        masterInfo.setNickName(this.E.c());
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setUin(v().getCurrentUin());
        ((IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class)).openSmallHomeTransitPage(this.E.getContext(), new TransitPageInfo(masterInfo, visitorInfo, new TransitPageConfig(), new ExtInfo()), ZootopiaSource.create(Source.AIOEntry, "em_zplan_entrance_qq_aiotop"));
        IRedTouchManager iRedTouchManager = (IRedTouchManager) v().getRuntimeService(IRedTouchManager.class, "");
        if (this.E.d(view)) {
            iRedTouchManager.onRedTouchItemClick(iRedTouchManager.getAppInfo(15, "130223"), null);
            QLog.i("AIOZplanEntranceHelper", 1, "mTitleBtnZplan onRedTouchItemClick");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.h
            @Override // java.lang.Runnable
            public final void run() {
                AIOZplanEntranceHelper.this.M();
            }
        }, 500L);
    }

    public void S() {
        this.f178685f = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getAIOSmallHomeControl();
        this.E.a(4, new int[]{R.drawable.qui_xiaowo_icon_nav_secondary, R.drawable.qui_xiaowo_icon_nav_secondary});
        if (v() != null && v().getCurrentUin().equals(this.E.e())) {
            return;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(2001L, v().getLongAccountUin())) {
            QLog.e("AIOZplanEntranceHelper", 1, "updateTitleBtnZplan  isInWhiteList: false");
        } else if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).shouldHideSmallHomeEntry()) {
            QLog.e("AIOZplanEntranceHelper", 1, "study mode hide small home entry");
        } else {
            ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanSmallHomeAccessible(x(), new nk3.o() { // from class: com.tencent.mobileqq.activity.aio.helper.b
                @Override // nk3.o
                public final void a(Boolean bool) {
                    AIOZplanEntranceHelper.this.K(bool);
                }
            });
            this.E.a(2, new b());
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
        QLog.i("AIOZplanEntranceHelper", 1, "onMoveToState - " + i3 + ", old= " + this.f178688m);
        this.f178688m = i3;
        if (i3 != 5) {
            if (i3 != 12) {
                if (i3 == 15) {
                    L();
                    return;
                }
                return;
            }
            t();
            return;
        }
        s();
    }
}
