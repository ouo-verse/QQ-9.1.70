package com.tencent.biz.richframework.video.rfw.player.spr;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qfsmonet.api.IMonetLogListener;
import com.tencent.qfsmonet.api.MonetSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.abtest.a;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWSprManger {
    private static volatile RFWSprManger sInstance;
    private String mDeviceModel = null;
    private String mHardware = null;
    private volatile int mInitStatus;

    RFWSprManger() {
    }

    public static RFWSprManger g() {
        if (sInstance == null) {
            synchronized (RFWSprManger.class) {
                if (sInstance == null) {
                    sInstance = new RFWSprManger();
                }
            }
        }
        return sInstance;
    }

    private boolean hitSprExp() {
        String expName = a.a("exp_qcircle_video_spr_8923").getExpName();
        if (TextUtils.isEmpty(expName)) {
            RFWLog.d("QFSSprManger", RFWLog.DEV, "not hit spr exp ");
            return false;
        }
        if ("exp_qcircle_video_spr_8923_B".equals(expName)) {
            RFWLog.d("QFSSprManger", RFWLog.DEV, " hit spr exp_B ");
            return true;
        }
        RFWLog.d("QFSSprManger", RFWLog.DEV, " hit spr exp_A ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectLog() {
        MonetSDK.setLogListener(new IMonetLogListener() { // from class: com.tencent.biz.richframework.video.rfw.player.spr.RFWSprManger.2
            @Override // com.tencent.qfsmonet.api.IMonetLogListener
            public void d(String str, String str2) {
                RFWLog.d(str, RFWLog.DEV, str2);
            }

            @Override // com.tencent.qfsmonet.api.IMonetLogListener
            public void e(String str, String str2) {
                RFWLog.d(str, RFWLog.USR, str2);
            }

            @Override // com.tencent.qfsmonet.api.IMonetLogListener
            public void i(String str, String str2) {
                RFWLog.i(str, RFWLog.CLR, str2);
            }

            @Override // com.tencent.qfsmonet.api.IMonetLogListener
            public void v(String str, String str2) {
                RFWLog.d(str, RFWLog.DEV, str2);
            }

            @Override // com.tencent.qfsmonet.api.IMonetLogListener
            public void w(String str, String str2) {
                RFWLog.w(str, RFWLog.CLR, str2);
            }
        });
    }

    private boolean isEnableHardware() {
        try {
        } catch (Exception e16) {
            QLog.e("QFSSprManger", RFWLog.USR, "exception:", e16);
        }
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape()) {
            RFWLog.d("QFSSprManger", RFWLog.USR, "isEnableHardware,pad not enable");
            return false;
        }
        if (this.mHardware == null) {
            this.mHardware = Build.HARDWARE;
        }
        String str = this.mHardware;
        RFWLog.d("QFSSprManger", RFWLog.USR, "currentHardware:" + str);
        String o16 = c.o1();
        if (TextUtils.isEmpty(o16)) {
            return false;
        }
        for (String str2 : o16.split(";")) {
            if (str.toLowerCase().contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnableModel() {
        try {
            String[] split = c.G2().split(";");
            if (this.mDeviceModel == null) {
                this.mDeviceModel = DeviceInfoMonitor.getModel();
            }
            String str = this.mDeviceModel;
            for (String str2 : split) {
                if (TextUtils.equals(str, str2)) {
                    return false;
                }
            }
        } catch (Exception e16) {
            QLog.w("QFSSprManger", 1, "[isEnableModel] ", e16);
        }
        return true;
    }

    public boolean enableExpose() {
        boolean z16;
        boolean t56 = c.t5();
        boolean isHighDevice = QCircleDeviceInfoUtils.isHighDevice();
        boolean isEnableHardware = isEnableHardware();
        boolean isEnableModel = isEnableModel();
        if (t56 && isHighDevice && isEnableHardware && isEnableModel) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d("QFSSprManger", RFWLog.USR, "enableExposeResult:" + z16 + " |wnsOpen:" + t56 + " |isHighDevice:" + isHighDevice + " |isEnableHardware:" + isEnableHardware + " |isEnableModel:" + isEnableModel);
        return z16;
    }

    public boolean enableSpr() {
        boolean z16;
        boolean t56 = c.t5();
        boolean hitSprExp = hitSprExp();
        boolean isHighDevice = QCircleDeviceInfoUtils.isHighDevice();
        boolean h16 = com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_SPR, 0);
        boolean isEnableHardware = isEnableHardware();
        boolean isEnableModel = isEnableModel();
        if (((t56 && hitSprExp && isHighDevice) || h16) && isEnableHardware && isEnableModel) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d("QFSSprManger", RFWLog.USR, "enableSprResult:" + z16 + " |wnsOpen:" + t56 + " |experimentHit:" + hitSprExp + " |isHighDevice:" + isHighDevice + " |isEnableHardware:" + isEnableHardware + " |isEnableSprDebug:" + h16 + " |isEnableModel:" + isEnableModel);
        return z16;
    }

    public boolean isLoadSuccess() {
        RFWLog.d("QFSSprManger", RFWLog.USR, "isLoadSuccess:" + this.mInitStatus);
        if (this.mInitStatus == 2) {
            return true;
        }
        return false;
    }

    public void loadNeedSo() {
        if (!enableSpr()) {
            RFWLog.d("QFSSprManger", RFWLog.USR, "load so return,not enable ");
            return;
        }
        if (this.mInitStatus == 1) {
            RFWLog.d("QFSSprManger", RFWLog.USR, "isONLoading:" + this.mInitStatus);
            return;
        }
        SoLoadManager.getInstance().loadSequentially(new String[]{SoLoadConstants.SONAME_AV_LIGHT_SR, "qfsSDR"}, new OnLoadListener() { // from class: com.tencent.biz.richframework.video.rfw.player.spr.RFWSprManger.1
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public void onLoadResult(int i3, LoadExtResult loadExtResult) {
                boolean z16;
                Object[] objArr = new Object[4];
                boolean z17 = false;
                objArr[0] = "retCode:";
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = ",load result:";
                if (loadExtResult != null && loadExtResult.isSucc()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[3] = Boolean.valueOf(z16);
                QLog.d("QFSSprManger", 1, objArr);
                if (i3 == 0) {
                    z17 = true;
                }
                if (!z17 || loadExtResult == null || !loadExtResult.isSucc()) {
                    RFWSprManger.this.mInitStatus = 3;
                } else {
                    RFWSprManger.this.mInitStatus = 2;
                    RFWSprManger.this.injectLog();
                }
            }
        });
    }
}
