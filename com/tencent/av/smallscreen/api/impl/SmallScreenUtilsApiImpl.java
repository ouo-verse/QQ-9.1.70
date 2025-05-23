package com.tencent.av.smallscreen.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.api.ISmallScreenUtilsApi;
import com.tencent.av.utils.at;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import pu.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenUtilsApiImpl implements ISmallScreenUtilsApi {
    private static final String TAG = "SmallScreenUtilsApiImpl";

    static bw.a getSmallScreenConfigParser() {
        IConfigParser b16 = du.a.b(BaseApplication.getContext());
        if (b16 != null && !b16.isEmpty()) {
            bw.a aVar = new bw.a();
            if (!aVar.a(b16)) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getSmallScreenConfigParser --> parseConfig fail");
            }
            return aVar;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d(TAG, 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
        return null;
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public void actionOn(long j3, int i3, Context context, boolean z16, String str, boolean z17, boolean z18) {
        try {
            context.startService(new Intent(context, (Class<?>) SmallScreenService.class));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "actionOn e = " + e16);
            }
        }
        QLog.w(TAG, 1, "avideo actionOn isFloatWindowOpAllowed, isVideo[" + z17 + "], isNeedStartDialog[" + z16 + "], actionOnFrom[" + i3 + "], seq[" + j3 + "]", new Throwable("bug-check"));
        if (z18 || !SmallScreenUtils.F(context, z16, str, z17)) {
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public int getFinishAnimId(int i3) {
        switch (i3) {
            case 1:
                return R.anim.f154844ds;
            case 2:
                return R.anim.f154845dt;
            case 3:
                return R.anim.f154843dr;
            case 4:
                return R.anim.f154842dq;
            case 5:
                return R.anim.f154841dp;
            case 6:
                return R.anim.f154849dx;
            case 7:
                return R.anim.f154850dy;
            case 8:
                return R.anim.f154848dw;
            case 9:
            default:
                return R.anim.f154847dv;
            case 10:
                return R.anim.f154846du;
        }
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean isLock(Context context) {
        return r.g1(context) && !((Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equals("HM NOTE 1TD")) || DeviceInfoMonitor.getModel().equals("MI 3C") || DeviceInfoMonitor.getModel().equals("HM NOTE 1S"));
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean isShareToastShow() {
        return SmallScreenService.f74516c0;
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean isSupportSmallScreen() {
        boolean z16 = false;
        if (!c.o()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
            }
        } else {
            bw.a smallScreenConfigParser = getSmallScreenConfigParser();
            if (smallScreenConfigParser == null || smallScreenConfigParser.f29285b <= 0) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSupportSmallScreen result = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean isSupportSmallScreenAudio() {
        boolean z16 = false;
        if (!c.o()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
            }
        } else {
            bw.a smallScreenConfigParser = getSmallScreenConfigParser();
            if (smallScreenConfigParser == null || smallScreenConfigParser.f29288e <= 0) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSupportSmallScreenAudio result = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean isSupportSmallScreenVideo() {
        boolean z16 = false;
        if (!c.o()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
            }
        } else {
            bw.a smallScreenConfigParser = getSmallScreenConfigParser();
            if (smallScreenConfigParser == null || smallScreenConfigParser.f29287d <= 0) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSupportSmallScreenVideo result = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public boolean sendSmallScreenStateBroadcast(long j3, BaseVideoAppInterface baseVideoAppInterface, int i3) {
        if (baseVideoAppInterface instanceof VideoAppInterface) {
            final VideoAppInterface videoAppInterface = (VideoAppInterface) baseVideoAppInterface;
            SmallScreenService.f74515b0 = false;
            if (videoAppInterface == null || videoAppInterface.getApplication() == null || videoAppInterface.getApp() == null || r.h0() == null || n.e().f() == null) {
                return false;
            }
            SessionInfo f16 = n.e().f();
            String str = f16.f73091w;
            int i16 = f16.f73035i;
            if (i16 == 3 || i16 == 4) {
                str = String.valueOf(f16.P0);
            }
            final Intent intent = new Intent("tencent.video.v2q.SmallScreenState");
            intent.setPackage(videoAppInterface.getApplication().getPackageName());
            intent.putExtra("SmallScreenState", i3);
            at.f(intent, j3);
            intent.putExtra("uin", str);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.api.impl.SmallScreenUtilsApiImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    videoAppInterface.getApp().sendBroadcast(intent);
                }
            }, 16, null, true);
            if (QLog.isDevelopLevel()) {
                QLog.w(TAG, 1, "sendSmallScreenStateBroadcast, state[" + i3 + "], seq[" + j3 + "]");
            }
            return true;
        }
        QLog.e(TAG, 1, "invalid BaseVideoAppInterface");
        return false;
    }

    public static void reportActionOn(Context context, SessionInfo sessionInfo) {
        int i3 = sessionInfo.f73035i;
        int i16 = sessionInfo.S0;
        int i17 = sessionInfo.f73043k;
        if (QLog.isColorLevel()) {
            String str = TAG;
            QLog.d(str, 2, "reportActionOn sessionType = " + i3);
            QLog.d(str, 2, "reportActionOn relationType = " + i16);
            QLog.d(str, 2, "reportActionOn state = " + i17);
        }
        String str2 = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (i16 == 1) {
                            str2 = "0X80057E0";
                        } else if (i16 == 2) {
                            str2 = "0X80057DF";
                        }
                    }
                } else if (i16 == 1) {
                    str2 = "0X8005A46";
                } else if (i16 == 2) {
                    str2 = "0X8005A45";
                }
            } else if (i17 == 1) {
                str2 = "0X80057DE";
            } else if (i17 == 4) {
                str2 = "0X80057DD";
            }
        } else if (i17 == 1) {
            str2 = "0X8005A44";
        } else if (i17 == 4) {
            str2 = "0X8005A43";
        }
        String str3 = str2;
        if (str3 == null || !SmallScreenUtils.r(context)) {
            return;
        }
        ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public void actionOff(long j3, int i3, Context context) {
        boolean z16 = false;
        if (i3 == 2 && r.h0().k()) {
            z16 = true;
        }
        QLog.w(TAG, 1, "avideo actionOff, seq[" + j3 + "], isNeedBlock[" + z16 + "], actionOffFrom[" + i3 + "]");
        if (z16) {
            return;
        }
        try {
            context.stopService(new Intent(context, (Class<?>) SmallScreenService.class));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "actionOff e = " + e16);
            }
        }
    }

    @Override // com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
    public void startSetVisibleAnimation(View view, boolean z16, boolean z17) {
        AlphaAnimation alphaAnimation;
        if (view != null) {
            Object tag = view.getTag(R.id.g6g);
            boolean booleanValue = tag == null ? false : ((Boolean) tag).booleanValue();
            if (z17 && booleanValue) {
                Object tag2 = view.getTag(R.id.g6h);
                if ((view.getVisibility() == 0 && (tag2 == null ? false : ((Boolean) tag2).booleanValue())) != z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "startSetVisibleAnimation isVisible = " + z16);
                    }
                    AnimationSet animationSet = new AnimationSet(true);
                    if (z16) {
                        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    }
                    alphaAnimation.setDuration(400L);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setAnimationListener(new a(view, z16));
                    view.startAnimation(animationSet);
                    view.setVisibility(0);
                }
            } else {
                view.clearAnimation();
                view.setVisibility(z16 ? 0 : 8);
            }
            view.setTag(R.id.g6h, Boolean.valueOf(z16));
            view.setTag(R.id.g6g, Boolean.valueOf(z17));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f74588d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f74589e;

        a(View view, boolean z16) {
            this.f74588d = view;
            this.f74589e = z16;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f74588d.setVisibility(this.f74589e ? 0 : 8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f74588d.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
