package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.subscript.f;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.b;
import com.tencent.mobileqq.qrscan.d;
import com.tencent.sharpP.SharpPUtils;
import cr2.a;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRScanAbilityApiImpl implements IQRScanAbilityApi {
    static IPatchRedirector $redirector_;
    private static ArrayList<d> sAppProcessorList;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QRScanImpl/Inject_QRQQAppInterfaceProcessor.yml", version = 1)
    private static ArrayList<Class<? extends d>> sInjectProcessorClasses;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        sInjectProcessorClasses = new ArrayList<>();
        sAppProcessorList = new ArrayList<>();
        Iterator<Class<? extends d>> it = sInjectProcessorClasses.iterator();
        while (it.hasNext()) {
            try {
                sAppProcessorList.add(it.next().newInstance());
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            }
        }
    }

    public QRScanAbilityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean isNoHistoryActivity(Context context) {
        try {
            String str = SplashActivity.TAG;
            if (SplashActivity.class.isInstance(context)) {
                return true;
            }
            int i3 = ChatActivity.f175053a0;
            if (ChatActivity.class.isInstance(context)) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public Bitmap decodeSharpP(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return SharpPUtils.decodeSharpP(str);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public int getEarlyDownBusId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 101) {
                            return 0;
                        }
                        return 10040;
                    }
                    return 10090;
                }
                return 10085;
            }
            return 10084;
        }
        return 10083;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public String getFriendDisplayNameJustCache(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime, (Object) str);
        }
        Iterator<d> it = sAppProcessorList.iterator();
        if (it.hasNext()) {
            return it.next().getFriendDisplayNameJustCache(appRuntime, str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public int getQmcfGpuSupportType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return a.b();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public int getQmcfGpuSupportTypeWithoutGPURule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return a.d();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public String getUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return f.a(str);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isMiniCodeDecodeSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return y.a().f198850j;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isMiniCodeDetectSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return y.a().f198851k;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isQmcfSupport(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isQmcfSupportGLElseCL(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (i3 == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isRingEqualsZero(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Iterator<d> it = sAppProcessorList.iterator();
        if (it.hasNext()) {
            return it.next().isRingEqualsZero(appRuntime);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isRingerSilent(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Iterator<d> it = sAppProcessorList.iterator();
        if (it.hasNext()) {
            return it.next().isRingerSilent(appRuntime);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isRingerVibrate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Iterator<d> it = sAppProcessorList.iterator();
        if (it.hasNext()) {
            return it.next().isRingerVibrate(appRuntime);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public boolean isVideoChatting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Iterator<d> it = sAppProcessorList.iterator();
        if (it.hasNext()) {
            return it.next().isVideoChatting(appRuntime);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public void launchAR(Activity activity, AppRuntime appRuntime, String str, long j3, boolean z16, boolean z17, long j16, boolean z18, boolean z19, JSONObject jSONObject, ScannerParams scannerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, appRuntime, str, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j16), Boolean.valueOf(z18), Boolean.valueOf(z19), jSONObject, scannerParams);
        } else {
            new b(activity, appRuntime, str, j3, z16, z17, j16, z18, z19, jSONObject, scannerParams).a();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public void reportQBarSoLoadFail(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            ScanEntranceReport.c().h(z16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public void setTalkbackSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Iterator<d> it = sAppProcessorList.iterator();
        while (it.hasNext()) {
            it.next().a(waitAppRuntime);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public void speak(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        Iterator<d> it = sAppProcessorList.iterator();
        while (it.hasNext()) {
            it.next().speak(str);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi
    public void startActivity(Context context, boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, context, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_ADD_FRIEND_ACTIVITY);
        activityURIRequest.extra().putBoolean("btroop", z16);
        activityURIRequest.extra().putBoolean("performAutoAction", z17);
        if (isNoHistoryActivity(context)) {
            activityURIRequest.setFlags(1073741824);
            activityURIRequest.extra().putBoolean("needFinish", true);
        }
        if (str != null) {
            if (z16) {
                activityURIRequest.extra().putString("troopuin", str);
            } else {
                activityURIRequest.extra().putString("uin", str);
            }
        }
        QRoute.startUri(activityURIRequest, (o) null);
    }
}
