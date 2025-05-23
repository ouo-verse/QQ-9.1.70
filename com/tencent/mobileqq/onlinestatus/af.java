package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.widget.OnlineBatteryProducer;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.onlinestatus.OnlineStatusExtInfo$WeatherBizInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class af {

    /* renamed from: d, reason: collision with root package name */
    private static int f255381d;

    /* renamed from: a, reason: collision with root package name */
    private int f255382a = 0;

    /* renamed from: b, reason: collision with root package name */
    private OnlineBatteryProducer f255383b = new OnlineBatteryProducer();

    /* renamed from: c, reason: collision with root package name */
    private pc2.a f255384c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final af f255385a = new af();
    }

    af() {
    }

    private int B(int i3) {
        int i16 = 12;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    i16 = 32;
                }
            } else {
                i16 = 24;
            }
        }
        return Utils.n(i16, MobileQQ.sMobileQQ.getResources());
    }

    public static af C() {
        return a.f255385a;
    }

    public static int D() {
        int intProperty = SystemMethodProxy.getIntProperty((BatteryManager) BaseApplication.getContext().getSystemService("batterymanager"), 4);
        if (QLog.isColorLevel() && intProperty != f255381d) {
            QLog.d("OnLineStatusHelper", 2, "BatterManager ", Integer.valueOf(intProperty));
            f255381d = intProperty;
        }
        if (intProperty <= 0) {
            return com.tencent.mobileqq.onlinestatus.utils.aa.b(MobileQQ.sMobileQQ);
        }
        return intProperty;
    }

    public static int E() {
        int i3;
        Throwable th5;
        boolean isCharging;
        int intProperty;
        try {
            BatteryManager batteryManager = (BatteryManager) BaseApplication.getContext().getSystemService("batterymanager");
            isCharging = batteryManager.isCharging();
            intProperty = SystemMethodProxy.getIntProperty(batteryManager, 6);
            if (intProperty != 2 && intProperty != 5 && !isCharging) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        } catch (Throwable th6) {
            i3 = 0;
            th5 = th6;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("OnLineStatusHelper", 2, "getLocalPowerConnectStatus isCharging:", Boolean.valueOf(isCharging), " chargeStatus:", Integer.valueOf(intProperty));
            }
        } catch (Throwable th7) {
            th5 = th7;
            QLog.e("OnLineStatusHelper", 1, "getLocalPower t:", th5);
            return i3;
        }
        return i3;
    }

    public static int R(int i3, int i16) {
        int i17;
        if (i16 == 1) {
            i17 = i3 | 128;
        } else {
            i17 = i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 2, "OnlineStatusHelper ret:", Integer.valueOf(i17), " batteryCapacity:", Integer.valueOf(i3), " powerConectStatus:", Integer.valueOf(i16));
        }
        return i17;
    }

    private Drawable U(au auVar, @Nullable com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3, int i16) {
        String str;
        Drawable drawable = null;
        if (auVar == null) {
            return null;
        }
        int B = B(i3);
        if (auVar.f255493f == 2) {
            return ar.d(auVar.f255494g, B);
        }
        if (e0(auVar)) {
            if (cVar != null && !k0(cVar.f0())) {
                int t16 = t(cVar);
                if (t16 > 0) {
                    drawable = this.f255383b.createBatteryDrawable(t16, i3);
                }
                return drawable;
            }
            return this.f255383b.getSelfBatteryDrawable(BaseApplication.getContext(), i3);
        }
        long j3 = auVar.f255489b;
        if (j3 == 1030) {
            com.tencent.mobileqq.config.business.af a16 = com.tencent.mobileqq.config.business.ah.f202497a.a();
            if (cVar != null) {
                str = a0(cVar, BaseApplication.getContext(), i16, a16);
            } else {
                str = "";
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("OnLineStatusHelper", 4, "WeatherUrl=", str);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = B;
            obtain.mRequestHeight = B;
            if (!TextUtils.isEmpty(str)) {
                URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                drawable2.setBounds(0, 0, B, B);
                return drawable2;
            }
            Drawable A = A(auVar, i16);
            A.setBounds(0, 0, B, B);
            return A;
        }
        if (j3 == 1080) {
            Drawable G = G(auVar, B, i16);
            if (G != null) {
                G.setBounds(0, 0, B, B);
                return G;
            }
            return G;
        }
        if (j3 == 2000) {
            return z(auVar, B, i16, cVar);
        }
        Drawable A2 = A(auVar, i16);
        A2.setBounds(0, 0, B, B);
        return A2;
    }

    private String W(@NonNull au auVar, @NonNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3) {
        h43.f c16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return auVar.f255490c;
        }
        Context applicationContext = peekAppRuntime.getApplicationContext();
        if (applicationContext == null) {
            return auVar.f255490c;
        }
        if (peekAppRuntime.getCurrentUin().equals(cVar.f0()) && i3 != 2) {
            c16 = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getStepStatusInfo();
        } else if (i3 != 5 && i3 != 1) {
            c16 = null;
        } else {
            c16 = com.tencent.mobileqq.onlinestatus.utils.ag.f256338a.c(cVar.f0());
        }
        if (c16 != null) {
            if (!((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission() && peekAppRuntime.getCurrentUin().equals(cVar.f0())) {
                return applicationContext.getResources().getString(R.string.f2054155j);
            }
            return applicationContext.getResources().getString(R.string.f2054255k, String.valueOf(c16.f404302a));
        }
        return auVar.f255490c;
    }

    private String Z(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        String str;
        if (cVar != null && k0(cVar.f0())) {
            str = ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).getOwnerOnlineStatus();
        } else if (cVar != null && !TextUtils.isEmpty(cVar.c0())) {
            str = cVar.c0();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.contains("\u5728\u7ebf")) {
            String substring = str.substring(0, str.length() - 2);
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            return "\u624b\u673a";
        }
        return "\u624b\u673a";
    }

    private String a0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, Context context, int i3, com.tencent.mobileqq.config.business.af afVar) {
        boolean z16;
        jc2.c b16;
        String str;
        boolean k06 = k0(cVar.f0());
        if (k06) {
            z16 = com.tencent.mobileqq.weather.util.i.b(context, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE);
        } else {
            z16 = true;
        }
        if (!z16 && k06) {
            b16 = afVar.b(ThemeReporter.FROM_NIGHT);
        } else {
            b16 = afVar.b(cVar.p0());
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 2, "weatherTypeId=", cVar.p0(), ",isSelfUin=", Boolean.valueOf(k06));
        }
        if (b16 != null) {
            str = b16.f409787d;
            if (i3 == 5) {
                str = b16.f409788e;
            }
        } else {
            str = "";
        }
        if (OnlineStatusToggleUtils.B() && !TextUtils.isEmpty(cVar.l0())) {
            String a16 = afVar.a(cVar.l0());
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
            return str;
        }
        return str;
    }

    private boolean g0(int i3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if ((i3 == 4 && cVar.e0() == 0) || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 7) {
            return true;
        }
        return false;
    }

    public static boolean i0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
        long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
        if (onlineStatus != AppRuntime.Status.online || extOnlineStatus != 2017) {
            return false;
        }
        return true;
    }

    public static boolean j0(AppRuntime.Status status, long j3) {
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        if (a16 == null) {
            return false;
        }
        return a16.n(status, j3);
    }

    public static void n0(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        BaseApplication.context.startActivity(intent);
    }

    private int t(@Nullable com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (cVar != null && !k0(cVar.f0())) {
            return Math.max(0, Math.min(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.d.a(cVar), 100));
        }
        return D();
    }

    private String u(AppRuntime appRuntime, @NonNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, @NonNull IOnlineStatusService iOnlineStatusService) {
        if (appRuntime.getCurrentAccountUin().equals(cVar.f0())) {
            if (iOnlineStatusService.getPowerConnect() == 1) {
                return iOnlineStatusService.getBatteryCapacity() + "% " + Z(cVar) + "\u5145\u7535\u4e2d";
            }
            return iOnlineStatusService.getBatteryCapacity() + "% " + Z(cVar) + "\u7535\u91cf";
        }
        if (t(cVar) > 0) {
            if (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.d.b(cVar)) {
                return t(cVar) + "% " + Z(cVar) + "\u5145\u7535\u4e2d";
            }
            return t(cVar) + "% " + Z(cVar) + "\u7535\u91cf";
        }
        return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getStatusName(cVar);
    }

    Drawable A(au auVar, int i3) {
        if (i3 == 5) {
            return URLDrawable.getDrawable(auVar.f255492e, URLDrawable.URLDrawableOptions.obtain());
        }
        return URLDrawable.getDrawable(auVar.f255491d, URLDrawable.URLDrawableOptions.obtain());
    }

    public String F() {
        pc2.a aVar = this.f255384c;
        if (aVar == null) {
            return "";
        }
        return aVar.c();
    }

    public Drawable G(au auVar, int i3, int i16) {
        if (f0()) {
            return r(auVar.f255500m, i3);
        }
        if (i16 == 6) {
            return A(auVar, i16);
        }
        return A(auVar, i16);
    }

    public au H() {
        Iterator<au> it = q().iterator();
        while (it.hasNext()) {
            au next = it.next();
            if (next.f255489b == 1080) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public au I(AppRuntime.Status status, long j3) {
        return J(status, j3, false);
    }

    @NonNull
    public au J(AppRuntime.Status status, long j3, boolean z16) {
        au b16;
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        if (a16 != null && status == AppRuntime.Status.online) {
            au i3 = a16.i(status, j3);
            if (i3.e().booleanValue() && (b16 = com.tencent.mobileqq.config.square.a.f202944a.b(j3)) != null) {
                return b16;
            }
            return i3;
        }
        if (a16 != null) {
            return a16.i(status, 0L);
        }
        return new au(AppRuntime.Status.online);
    }

    public ArrayList<au> K() {
        return q();
    }

    public ArrayList<au> L(AppRuntime.Status status, long j3, boolean z16) {
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        if (a16 != null) {
            return a16.e(status, j3, z16);
        }
        return null;
    }

    public long M(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return -1L;
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
        if (extOnlineStatus == -1) {
            extOnlineStatus = iOnlineStatusService.getExtOnlineStatusFromSP();
            if (extOnlineStatus != -1) {
                iOnlineStatusService.setExtOnlineStatus(extOnlineStatus);
            }
        }
        return extOnlineStatus;
    }

    public au N() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return I(((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), M(peekAppRuntime));
    }

    public Drawable O(long j3, AppRuntime.Status status, int i3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i16) {
        au I;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2 && (I = I(status2, j3)) != null) {
            return U(I, cVar, i3, i16);
        }
        return ar.d(status, B(i3));
    }

    public String P(long j3, AppRuntime.Status status) {
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2) {
            if (j3 == 1000) {
                return "\u6211\u7684\u7535\u91cf";
            }
            au I = I(status2, j3);
            if (I != null && !TextUtils.isEmpty(I.f255490c)) {
                return I.f255490c;
            }
        }
        return ar.f(status);
    }

    public String Q(long j3, AppRuntime.Status status) {
        return P(j3, status);
    }

    public Drawable S() {
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary);
        int dip2px = ViewUtils.dip2px(9.0f);
        drawable.setBounds(0, 0, dip2px, dip2px);
        return drawable;
    }

    public Drawable T(au auVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        return U(auVar, cVar, 0, 1);
    }

    public Drawable V(au auVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3) {
        if (i3 != 5 && i3 != 6) {
            return T(auVar, cVar);
        }
        return U(auVar, cVar, 2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable[] X(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, boolean z16, boolean z17) {
        boolean z18;
        Drawable drawable;
        Drawable drawable2 = null;
        if (cVar != null) {
            au J = J(bs.z(cVar), cVar.e0(), !appRuntime.getCurrentUin().equals(cVar.f0()));
            if (z16 && h(cVar, J)) {
                drawable = T(J, cVar);
                if (drawable != null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                Drawable[] drawableArr = new Drawable[2];
                if (!z18) {
                    drawable = null;
                }
                drawableArr[0] = drawable;
                if (z17) {
                    drawable2 = S();
                }
                drawableArr[1] = drawable2;
                return drawableArr;
            }
        }
        z18 = false;
        drawable = null;
        Drawable[] drawableArr2 = new Drawable[2];
        if (!z18) {
        }
        drawableArr2[0] = drawable;
        if (z17) {
        }
        drawableArr2[1] = drawable2;
        return drawableArr2;
    }

    public String Y(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, au auVar) {
        String str = auVar.f255490c;
        if (!TextUtils.isEmpty(cVar.g0()) && !TextUtils.isEmpty(cVar.i0())) {
            if (!TextUtils.isEmpty(cVar.h0())) {
                return MobileQQ.sMobileQQ.getResources().getString(R.string.f23078703) + " " + cVar.h0();
            }
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            ((TencentVideoNameHandler) appInterface.getBusinessHandler(TencentVideoNameHandler.class.getName())).D2(1, cVar.g0(), appInterface.getCurrentAccountUin());
        }
        return str;
    }

    public boolean b0(AppRuntime appRuntime, Activity activity, String str, View view) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A;
        jc2.b bVar;
        if (!m(appRuntime, str) || (A = bs.A(str, "handleAIOSubTitleClicked")) == null) {
            return false;
        }
        au J = J(AppRuntime.Status.online, A.e0(), !appRuntime.getCurrentUin().equals(str));
        long j3 = J.f255489b;
        if (j3 == 1028) {
            if (!TextUtils.isEmpty(A.V())) {
                com.tencent.mobileqq.onlinestatus.manager.k kVar = (com.tencent.mobileqq.onlinestatus.manager.k) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
                if (str.equals(appRuntime.getCurrentUin())) {
                    kVar.I(activity, A.V());
                } else {
                    kVar.E(activity, A.V());
                }
            }
        } else if (j3 == 1030) {
            com.tencent.mobileqq.config.business.af a16 = com.tencent.mobileqq.config.business.ah.f202497a.a();
            if (a16 != null && (bVar = a16.f202496d) != null && !TextUtils.isEmpty(bVar.f409781a)) {
                String str2 = a16.f202496d.f409781a;
                if (!str.equals(appRuntime.getCurrentUin())) {
                    str2 = str2.replaceAll("(isFromShare=[^&]*)", "isFromShare=1") + "&adcode=" + A.c();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("OnLineStatusHelper", 2, "handleAIOSubTitleClicked weather url = " + str2);
                }
                n0(activity, str2);
                bv.b("0X800AF4C", 2);
            }
        } else if (OnlineStatusToggleUtils.A() && J.f255489b == 2017) {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).jumpToMainPage(str);
        } else {
            long j16 = J.f255489b;
            if (j16 == 1040) {
                kc2.a.f412010a.a(activity, A.m(), 4014);
                bv.b("0X800AF4C", 1);
            } else if (j16 == 1080) {
                if (!TextUtils.isEmpty(J.f255501n)) {
                    ((com.tencent.mobileqq.onlinestatus.manager.u) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.h.class)).O(activity, J.f255501n + "&from=2");
                }
                bv.b("0X800BD1E", 0);
            } else if (j16 == 1021) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(activity, "1109840991", A.i0(), null, 4014, null);
            } else if (!TextUtils.isEmpty(J.f255501n)) {
                bs.s0(J.f255501n, activity);
            }
        }
        return true;
    }

    public Bundle c(AppRuntime appRuntime, boolean z16) {
        Bundle bundle = new Bundle();
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        int batteryCapacity = iOnlineStatusService.getBatteryCapacity();
        int powerConnect = iOnlineStatusService.getPowerConnect();
        int R = R(batteryCapacity, powerConnect);
        bundle.putInt("BatteryInfo", R);
        bundle.putBoolean("from_register", z16);
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 2, "buildSetBatteryData batteryCapacity:", Integer.valueOf(batteryCapacity), " powerConnect:", Integer.valueOf(powerConnect), " sendBattery:", Integer.valueOf(R), " fromRegister:", Boolean.valueOf(z16));
        }
        return bundle;
    }

    boolean c0(au auVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (auVar.f255489b == 1030 && !bs.d0(cVar)) {
            return true;
        }
        return false;
    }

    public Bundle d(AppRuntime appRuntime) {
        Bundle bundle = new Bundle();
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        int batteryCapacity = iOnlineStatusService.getBatteryCapacity();
        int powerConnect = iOnlineStatusService.getPowerConnect();
        int R = R(batteryCapacity, powerConnect);
        bundle.putInt("BatteryInfo", R);
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 2, "OnlineStatusHelper batteryCapacity:", Integer.valueOf(batteryCapacity), " powerConnect:", Integer.valueOf(powerConnect), " sendBattery:", Integer.valueOf(R));
        }
        return bundle;
    }

    public Boolean d0() {
        boolean z16;
        if (com.tencent.mobileqq.config.business.ak.f202506a.c() && com.tencent.mobileqq.config.square.a.f202944a.d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public Bundle e(OnlineStatusWeatherModel onlineStatusWeatherModel) {
        Bundle bundle = new Bundle();
        if (onlineStatusWeatherModel == null) {
            return bundle;
        }
        OnlineStatusExtInfo$WeatherBizInfo onlineStatusExtInfo$WeatherBizInfo = new OnlineStatusExtInfo$WeatherBizInfo();
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getCity())) {
            onlineStatusExtInfo$WeatherBizInfo.string_city.set(onlineStatusWeatherModel.getCity());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getCom.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.KEY_AREA java.lang.String())) {
            onlineStatusExtInfo$WeatherBizInfo.string_area.set(onlineStatusWeatherModel.getCom.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.KEY_AREA java.lang.String());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getTemper())) {
            onlineStatusExtInfo$WeatherBizInfo.string_temper.set(onlineStatusWeatherModel.getTemper());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getWeatherType())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_type.set(onlineStatusWeatherModel.getWeatherType());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getWeatherTypeId())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_type_id.set(onlineStatusWeatherModel.getWeatherTypeId());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getWeatherDesc())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.set(onlineStatusWeatherModel.getWeatherDesc());
        }
        if (!TextUtils.isEmpty(onlineStatusWeatherModel.getWeatherPrompt()) && !TextUtils.isEmpty(onlineStatusWeatherModel.getWeatherIconKey())) {
            onlineStatusExtInfo$WeatherBizInfo.prompt.set(onlineStatusWeatherModel.getWeatherPrompt());
            onlineStatusExtInfo$WeatherBizInfo.icon_key.set(onlineStatusWeatherModel.getWeatherIconKey());
        }
        int i3 = 0;
        try {
            if (!TextUtils.isEmpty(onlineStatusWeatherModel.getAdCode())) {
                i3 = Integer.parseInt(onlineStatusWeatherModel.getAdCode());
            }
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OnLineStatusHelper", 4, "number error", e16);
            }
        }
        onlineStatusExtInfo$WeatherBizInfo.uint32_adcode.set(i3);
        onlineStatusExtInfo$WeatherBizInfo.uint64_update_time.set(onlineStatusWeatherModel.getWeatherUpdateTime());
        onlineStatusExtInfo$WeatherBizInfo.uint32_flag.set(onlineStatusWeatherModel.getWeatherFlag());
        bundle.putByteArray("ExtInfo", onlineStatusExtInfo$WeatherBizInfo.toByteArray());
        bundle.putInt("StatusId", 1030);
        return bundle;
    }

    public boolean e0(au auVar) {
        if (auVar != null && auVar.f255489b == 1000) {
            return true;
        }
        return false;
    }

    public Bundle f(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        Bundle bundle = new Bundle();
        if (cVar == null) {
            return bundle;
        }
        OnlineStatusExtInfo$WeatherBizInfo onlineStatusExtInfo$WeatherBizInfo = new OnlineStatusExtInfo$WeatherBizInfo();
        if (!TextUtils.isEmpty(cVar.f())) {
            onlineStatusExtInfo$WeatherBizInfo.string_city.set(cVar.f());
        }
        if (!TextUtils.isEmpty(cVar.e())) {
            onlineStatusExtInfo$WeatherBizInfo.string_area.set(cVar.e());
        }
        if (!TextUtils.isEmpty(cVar.d0())) {
            onlineStatusExtInfo$WeatherBizInfo.string_temper.set(cVar.d0());
        }
        if (!TextUtils.isEmpty(cVar.o0())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_type.set(cVar.o0());
        }
        if (!TextUtils.isEmpty(cVar.p0())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_type_id.set(cVar.p0());
        }
        if (!TextUtils.isEmpty(cVar.j0())) {
            onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.set(cVar.j0());
        }
        if (!TextUtils.isEmpty(cVar.m0()) && !TextUtils.isEmpty(cVar.l0())) {
            onlineStatusExtInfo$WeatherBizInfo.prompt.set(cVar.m0());
            onlineStatusExtInfo$WeatherBizInfo.icon_key.set(cVar.l0());
        }
        int i3 = 0;
        try {
            if (!TextUtils.isEmpty(cVar.c())) {
                i3 = Integer.valueOf(cVar.c()).intValue();
            }
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OnLineStatusHelper", 4, "number error", e16);
            }
        }
        onlineStatusExtInfo$WeatherBizInfo.uint32_adcode.set(i3);
        onlineStatusExtInfo$WeatherBizInfo.uint64_update_time.set(cVar.q0());
        onlineStatusExtInfo$WeatherBizInfo.uint32_flag.set(cVar.k0());
        bundle.putByteArray("ExtInfo", onlineStatusExtInfo$WeatherBizInfo.toByteArray());
        bundle.putInt("StatusId", 1030);
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusHelper", 2, "buildWeatherData weatherBizInfo.string_city " + onlineStatusExtInfo$WeatherBizInfo.string_city.get() + " weatherBizInfo.string_weather_type " + onlineStatusExtInfo$WeatherBizInfo.string_weather_type.get() + " weatherBizInfo.prompt " + onlineStatusExtInfo$WeatherBizInfo.prompt + " weatherBizInfo.icon_key " + onlineStatusExtInfo$WeatherBizInfo.icon_key + " weatherBizInfo.uint32_adcode" + onlineStatusExtInfo$WeatherBizInfo.uint32_adcode);
        }
        return bundle;
    }

    public boolean f0() {
        pc2.a aVar = this.f255384c;
        if (aVar != null && aVar.d() > System.currentTimeMillis() / 1000) {
            return true;
        }
        return false;
    }

    public double g(String str) {
        double d16;
        double d17 = 0.0d;
        for (char c16 : str.toCharArray()) {
            if (c16 == ' ') {
                d16 = 0.5d;
            } else {
                d16 = 1.0d;
            }
            d17 += d16;
        }
        return d17;
    }

    protected boolean h(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, au auVar) {
        if (cVar == null) {
            QLog.d("OnLineStatusHelper", 1, "checkStatusToSetDrawable simpleInfo is null");
            return false;
        }
        if (auVar == null) {
            QLog.d("OnLineStatusHelper", 1, "checkStatusToSetDrawable item is null");
            return false;
        }
        int a16 = com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z());
        if (a16 == 4 && cVar.e0() > 0) {
            if (e0(auVar)) {
                if (t(cVar) <= 0) {
                    return false;
                }
            } else {
                if (cVar.e0() == 1040) {
                    return bs.V(cVar);
                }
                return !c0(auVar, cVar);
            }
        } else if (!g0(a16, cVar)) {
            return false;
        }
        return true;
    }

    public boolean h0(au auVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, boolean z16) {
        if (z16 && au.d(auVar.f255489b)) {
            if (C().t(cVar) > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (auVar.f255489b == 1040 && !bs.V(cVar)) {
            return false;
        }
        return z16;
    }

    public AppRuntime.Status i(au auVar) {
        if (auVar != null) {
            return auVar.f255494g;
        }
        return null;
    }

    public com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c j(OnlineStatusWeatherModel onlineStatusWeatherModel) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c("", "");
        if (onlineStatusWeatherModel != null) {
            cVar.Z0(onlineStatusWeatherModel.getTemper());
            cVar.l1(onlineStatusWeatherModel.getWeatherType());
            cVar.m1(onlineStatusWeatherModel.getWeatherTypeId());
            cVar.n1(onlineStatusWeatherModel.getWeatherUpdateTime());
            cVar.k1(onlineStatusWeatherModel.getWeatherTip());
            cVar.g1(onlineStatusWeatherModel.getWeatherDesc());
            cVar.h1(onlineStatusWeatherModel.getWeatherFlag());
            cVar.u0(onlineStatusWeatherModel.getCity());
            cVar.t0(onlineStatusWeatherModel.getCom.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.KEY_AREA java.lang.String());
            cVar.s0(onlineStatusWeatherModel.getAdCode());
            cVar.i1(onlineStatusWeatherModel.getWeatherIconKey());
            cVar.j1(onlineStatusWeatherModel.getWeatherPrompt());
        }
        return cVar;
    }

    public Bitmap k(int i3, int i16) {
        String str = i3 + "-" + i16;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            Drawable createBatteryDrawable = this.f255383b.createBatteryDrawable(i3, i16);
            if (createBatteryDrawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) createBatteryDrawable).getBitmap();
                imageCacheHelper.i(str, bitmap, Business.Default);
                return bitmap;
            }
            return f16;
        }
        return f16;
    }

    protected boolean k0(String str) {
        if (MobileQQ.sProcessId != 1) {
            return false;
        }
        return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin().equals(str);
    }

    @RequiresApi(api = 16)
    public DIYStatusDialogFragment l(final QBaseActivity qBaseActivity, final AppRuntime.Status status, final AccountPanelViewModel accountPanelViewModel, final y.c cVar, final long j3, final v.a aVar, int i3) {
        DIYStatusDialogFragment dIYStatusDialogFragment = new DIYStatusDialogFragment(aVar, i3);
        dIYStatusDialogFragment.Sh(new DIYStatusDialogFragment.d(qBaseActivity, status, accountPanelViewModel, cVar, j3, aVar) { // from class: com.tencent.mobileqq.onlinestatus.ad

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QBaseActivity f255376b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AppRuntime.Status f255377c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AccountPanelViewModel f255378d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f255379e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ v.a f255380f;

            {
                this.f255379e = j3;
                this.f255380f = aVar;
            }

            @Override // com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment.d
            public final void a(DiyStatusEmoInfo diyStatusEmoInfo) {
                af.this.l0(this.f255376b, this.f255377c, this.f255378d, null, this.f255379e, this.f255380f, diyStatusEmoInfo);
            }
        });
        r0(qBaseActivity, dIYStatusDialogFragment, i3);
        return dIYStatusDialogFragment;
    }

    public boolean m(AppRuntime appRuntime, String str) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(str, "enableAIOSubTitleClicked");
        boolean z16 = !appRuntime.getCurrentUin().equals(str);
        if (A != null) {
            au J = J(AppRuntime.Status.online, A.e0(), z16);
            long j3 = J.f255489b;
            if (j3 == 1028) {
                return true;
            }
            if (j3 == 1030) {
                return bs.d0(A);
            }
            if (j3 == 1040) {
                return bs.V(A);
            }
            if (j3 == 2000) {
                return bs.c0(A);
            }
            if (j3 == 1080) {
                return true;
            }
            if (j3 == 1021) {
                return bs.P(A);
            }
            if (OnlineStatusToggleUtils.A() && J.f255489b == 2017) {
                return true;
            }
            return !TextUtils.isEmpty(J.f255501n);
        }
        return false;
    }

    public ArrayList<au> n(ArrayList<au> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        Iterator<au> it = arrayList.iterator();
        au auVar = null;
        while (it.hasNext()) {
            au next = it.next();
            if (next.f255489b == 2000) {
                it.remove();
                auVar = next;
            }
        }
        if (auVar != null) {
            arrayList.add(0, auVar);
        }
        return arrayList;
    }

    public String o(AppRuntime appRuntime, au auVar, AppRuntime.Status status, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, TextView textView, int i3) {
        if (cVar == null) {
            return ar.f(status);
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        if (status == AppRuntime.Status.online && auVar != null) {
            long j3 = auVar.f255489b;
            if (j3 == 1000) {
                return u(appRuntime, cVar, iOnlineStatusService);
            }
            if (j3 == 1028) {
                return com.tencent.mobileqq.onlinestatus.manager.k.z(appRuntime, cVar, textView, i3);
            }
            if (j3 == 1030) {
                return bs.N(appRuntime, textView, cVar, i3);
            }
            if (OnlineStatusToggleUtils.A() && auVar.f255489b == 2017) {
                return W(auVar, cVar, i3);
            }
            long j16 = auVar.f255489b;
            if (j16 == 1040) {
                String u16 = kc2.c.u(cVar);
                if (QLog.isColorLevel()) {
                    QLog.d("OnLineStatusHelper", 2, "getAIOStatusName: invoked. ", " suitableTrend: ", u16);
                }
                if (!bs.V(cVar)) {
                    return "";
                }
                return u16;
            }
            if (j16 == 1080) {
                return auVar.f255490c;
            }
            if (j16 == 2000) {
                return y(cVar, auVar.f255490c);
            }
            if (j16 == 1021) {
                return Y(cVar, auVar);
            }
            if (!TextUtils.isEmpty(auVar.f255490c)) {
                return auVar.f255490c;
            }
        }
        return ar.f(status);
    }

    public void o0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, au auVar, AppRuntime appRuntime) {
        DiyStatusEmoInfo d16 = com.tencent.mobileqq.onlinestatus.utils.aa.d();
        if (auVar.f255489b == 2000 && d16 != null) {
            if (cVar != null) {
                cVar.H0(d16.getDesc());
                cVar.I0(d16.getId());
                cVar.J0(d16.getType());
            }
            ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setDiyInfo(d16);
            if (QLog.isColorLevel()) {
                QLog.i("OnLineStatusHelper", 2, "saveDiyInfo: desc: " + d16.getDesc() + " id: " + d16.getId() + " type: " + d16.getType());
            }
        }
    }

    public ArrayList<DiyStatusEmoInfo> p() {
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        if (a16 == null) {
            return null;
        }
        return a16.c();
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void l0(QBaseActivity qBaseActivity, AppRuntime.Status status, AccountPanelViewModel accountPanelViewModel, y.c cVar, long j3, DiyStatusEmoInfo diyStatusEmoInfo, v.a aVar) {
        String P = P(j3, status);
        if (!NetworkUtil.isNetworkAvailable(qBaseActivity)) {
            accountPanelViewModel.A2().setValue(Boolean.TRUE);
            QQToast.makeText(qBaseActivity, 1, R.string.hpk, 1).show();
            return;
        }
        accountPanelViewModel.j3(status, j3, true, diyStatusEmoInfo);
        aVar.G0(AppRuntime.Status.online, 2000L);
        if (cVar != null) {
            cVar.a(P);
        }
    }

    public ArrayList<au> q() {
        ArrayList<au> a16 = com.tencent.mobileqq.config.business.ak.f202506a.a().a();
        a16.addAll(com.tencent.mobileqq.config.square.a.f202944a.a());
        return a16;
    }

    public void q0() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String str = "";
        au I = C().I(((IOnlineStatusService) waitAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), C().M(waitAppRuntime));
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        if (waitAppRuntime.getCurrentUid() != null) {
            str = waitAppRuntime.getCurrentUid();
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(str, "OnLineStatusHelper_setSelfFriendInfoBySP");
        o0(onlineStatusSimpleInfoWithUid, I, waitAppRuntime);
        if (onlineStatusSimpleInfoWithUid != null) {
            iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(onlineStatusSimpleInfoWithUid, "OnLineStatusHelper_setSelfFriendInfoBySP", new hx3.c() { // from class: com.tencent.mobileqq.onlinestatus.ae
                @Override // hx3.c
                public final void onUpdateResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                    QLog.d("OnLineStatusHelper", 1, "updateOnlineStatusSimpleInfo");
                }
            });
        }
    }

    URLDrawable r(String str, int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        obtain.mUseApngImage = true;
        return URLDrawable.getDrawable(str, obtain);
    }

    public void r0(QBaseActivity qBaseActivity, DIYStatusDialogFragment dIYStatusDialogFragment, int i3) {
        dIYStatusDialogFragment.show(qBaseActivity.getSupportFragmentManager(), "diyStatusDialogFragment");
        QLog.d("OnLineStatusHelper", 1, "show showDiyDialog, from: " + i3);
    }

    public int s(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        int t16 = t(cVar);
        if (t16 <= 9) {
            return 0;
        }
        if (t16 >= 10 && t16 <= 20) {
            return 1;
        }
        if (t16 >= 21 && t16 <= 79) {
            return 2;
        }
        if (t16 >= 80 && t16 <= 100) {
            return 3;
        }
        return -1;
    }

    public void s0(pc2.a aVar) {
        this.f255384c = aVar;
    }

    public int v(AppRuntime appRuntime) {
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
        long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
        AppRuntime.Status status = AppRuntime.Status.online;
        if (onlineStatus == status && extOnlineStatus == 1000) {
            return 1;
        }
        if (onlineStatus == status && extOnlineStatus == 1030) {
            return 4;
        }
        if (onlineStatus == status && extOnlineStatus == 1040) {
            return 3;
        }
        return 0;
    }

    public String w(AppRuntime appRuntime, au auVar, AppRuntime.Status status, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, TextView textView, int i3) {
        boolean z16;
        if (status == AppRuntime.Status.online) {
            if (auVar.f255489b > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return x(appRuntime, cVar, textView, 4, auVar, Boolean.valueOf(z16));
        }
        return o(appRuntime, auVar, status, cVar, textView, i3);
    }

    public String x(AppRuntime appRuntime, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, TextView textView, int i3, au auVar, Boolean bool) {
        String statusName;
        AppRuntime.Status i16 = C().i(auVar);
        if (!Boolean.valueOf(h0(auVar, cVar, bool.booleanValue())).booleanValue() && i16 == AppRuntime.Status.online) {
            if (i3 != 5 && i3 != 1) {
                statusName = bs.J(cVar);
            } else {
                statusName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getStatusName(cVar);
            }
            if (TextUtils.isEmpty(statusName)) {
                return MobileQQ.sMobileQQ.getResources().getString(R.string.hpt);
            }
            return statusName;
        }
        return C().o(appRuntime, auVar, i16, cVar, textView, i3);
    }

    public String y(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, String str) {
        AppRuntime peekAppRuntime;
        DiyStatusEmoInfo diyInfo;
        if (cVar == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return "";
        }
        if (peekAppRuntime.getCurrentUin().equals(cVar.f0()) && (diyInfo = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getDiyInfo()) != null) {
            if (!TextUtils.isEmpty(diyInfo.getDesc())) {
                return diyInfo.getDesc();
            }
            return str;
        }
        if (!TextUtils.isEmpty(cVar.v())) {
            return cVar.v();
        }
        return str;
    }

    public Drawable z(au auVar, int i3, int i16, @Nullable com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        AppRuntime peekAppRuntime;
        DiyStatusEmoInfo diyInfo;
        Drawable drawable = null;
        if (cVar == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return null;
        }
        if (TextUtils.equals(cVar.f0(), peekAppRuntime.getCurrentAccountUin()) && (diyInfo = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getDiyInfo()) != null) {
            cVar.H0(diyInfo.getDesc());
            cVar.J0(diyInfo.getType());
            cVar.I0(diyInfo.getId());
        }
        if (cVar.x() > 0 && cVar.w() > 0) {
            try {
                QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(cVar.x());
                drawable = resImpl.getDrawable(resImpl.getLocalId((int) cVar.w()));
            } catch (Exception e16) {
                QLog.d("OnLineStatusHelper", 1, "getDiyStatusDrawable: ", e16);
            }
        }
        if (drawable == null || TextUtils.isEmpty(cVar.v()) || i16 == 7) {
            drawable = A(auVar, i16);
        }
        if (i3 != 0) {
            drawable.setBounds(0, 0, i3, i3);
        }
        return drawable;
    }
}
