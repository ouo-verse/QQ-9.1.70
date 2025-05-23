package com.tencent.mobileqq.soso.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationLogListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.r.a;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.soso.location.inject.LbsGdtUtils;
import com.tencent.mobileqq.soso.location.inject.LbsInfoReportManagerUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.bo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.lcation.LocationInputFragment;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s4.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SosoInterface {
    static IPatchRedirector $redirector_ = null;
    public static final int ERR_APP_BACKGROUND = -10004;
    public static final int ERR_SCREEN_OF = -10001;
    public static final int ERR_TIMEOUT = -10000;
    public static final int ERR_TOO_EARLY = -10003;
    private static final String KEY_MMKV_MIGRATE_FLAG = "soso_lbs_migrate_flag_";
    private static final Object LOCK;
    public static final int MAX_LONG_TIME = 30000;
    public static final int MSG_RESET_TIMEOUT = 1002;
    public static final int MSG_STOP_LOCATION = 1001;
    public static final String PRE = "qq_";
    public static final int REQ_LOCATION = 2;
    public static final int REQ_RAW = 1;
    private static final SosoInterfaceOnLocationListener REQ_RAW_LOCATION_LISTENER;
    private static final AtomicInteger REQ_STATUS;
    public static final int REQ_STOP = 0;
    public static final String SP_NAME = "soso_lbs";
    public static final String TAG = "SOSO.LBS";
    private static IGuardInterface appStatusCallBack;
    private static int consecutiveFailCount;
    private static int consumeOffset;
    public static volatile boolean hasGetOaid;
    private static boolean hasLocationManagerInit;
    private static long lastUpdateTime;
    private static int level3NoCityCodeCount;
    private static TencentLocationListener locListener;
    private static final LocationListenerManager locationListenerManager;
    private static SosoLbsInfo logSoso;
    private static TencentLocationManager mLocationManager;
    public static volatile String mOaid;
    private static long reqLocationTime;
    public static long reqRawTime;
    public static int sContinuousLocationInterval;
    private static boolean sInLaunchTime;
    private static HashSet<String> sRegisteredCallers;
    public static long sResumeFlagFromConversation;
    private static boolean sScreenOn;
    private static Handler subHandler;
    private static TencentLog tencentLog;
    private static long time;
    private static long[] timeUpdate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sContinuousLocationInterval = 2000;
        LOCK = new Object();
        mOaid = "";
        sResumeFlagFromConversation = -1L;
        level3NoCityCodeCount = 0;
        hasLocationManagerInit = false;
        locationListenerManager = new LocationListenerManager();
        subHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                int i3 = message.what;
                if (i3 != 1001) {
                    if (i3 == 1002 && SosoInterface.subHandler.hasMessages(1001)) {
                        SosoInterface.subHandler.removeMessages(1001);
                        SosoInterface.subHandler.sendEmptyMessageDelayed(1001, 3000L);
                        return false;
                    }
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(SosoInterface.TAG, 2, "msg_stop_location.");
                }
                SosoInterface.notifyLocationError();
                SosoInterface.stopLocation();
                return false;
            }
        });
        REQ_STATUS = new AtomicInteger(0);
        timeUpdate = new long[]{0, 0, 0, 0, 0};
        sScreenOn = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        try {
            MobileQQ.sMobileQQ.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent == null) {
                        return;
                    }
                    if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                        boolean unused = SosoInterface.sScreenOn = true;
                        if (QLog.isColorLevel()) {
                            QLog.i(SosoInterface.TAG, 2, "onReceive action is screen on.");
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                        boolean unused2 = SosoInterface.sScreenOn = false;
                        SosoInterface.subHandler.sendEmptyMessage(1002);
                        if (QLog.isColorLevel()) {
                            QLog.i(SosoInterface.TAG, 2, "onReceive action is screen off.");
                        }
                    }
                }
            }, intentFilter);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "registerReceiver is error.");
            }
        }
        consecutiveFailCount = 0;
        consumeOffset = 0;
        locListener = new TencentLocationListener() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.map.geolocation.TencentLocationListener
            public void onLocationChanged(TencentLocation tencentLocation, int i3, String str) {
                boolean z16;
                SosoInterfaceOnLocationListener access$1300;
                SosoInterfaceOnLocationListener access$1400;
                SosoInterfaceOnLocationListener access$1500;
                SosoInterfaceOnLocationListener access$1600;
                boolean z17;
                String str2;
                int length;
                int length2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, tencentLocation, Integer.valueOf(i3), str);
                    return;
                }
                if (tencentLocation == null) {
                    return;
                }
                int i16 = tencentLocation.getExtra().getInt("qq_level");
                if (SosoInterface.checkLevel3NoCityCodeCount(tencentLocation, i3, i16)) {
                    return;
                }
                SosoInterface.subHandler.removeMessages(1001);
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                long elapsedRealtime = (SystemClock.elapsedRealtime() - SosoInterface.time) - SosoInterface.consumeOffset;
                long unused2 = SosoInterface.time = SystemClock.elapsedRealtime();
                int unused3 = SosoInterface.consumeOffset = SosoInterface.sContinuousLocationInterval;
                String string = tencentLocation.getExtra().getString("qq_caller");
                String string2 = tencentLocation.getExtra().getString("qq_caller_route");
                boolean z18 = tencentLocation.getExtra().getBoolean("qq_goonListener");
                boolean z19 = tencentLocation.getExtra().getBoolean("qq_reqLocation");
                byte[] rawData = TencentExtraKeys.getRawData(tencentLocation);
                SosoInterface.saveLastLocationErrCode(i3);
                if (z19) {
                    if (z16) {
                        int unused4 = SosoInterface.consecutiveFailCount = 0;
                    } else {
                        SosoInterface.access$1008();
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onLocationChanged() err=");
                    sb5.append(i3);
                    if (str != null && str.length() != 0) {
                        str2 = " reason=" + str;
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append(" caller=");
                    sb5.append(string);
                    sb5.append(" level=");
                    sb5.append(i16);
                    sb5.append(" reqLocation=");
                    sb5.append(z19);
                    sb5.append(" consume=");
                    sb5.append(elapsedRealtime);
                    sb5.append(" rawData=");
                    if (rawData == null) {
                        length = 0;
                    } else {
                        length = rawData.length;
                    }
                    sb5.append(length);
                    sb5.append(" isGoonCallback=");
                    sb5.append(z18);
                    sb5.append(" failInt=");
                    sb5.append(SosoInterface.consecutiveFailCount);
                    sb5.append(" caller rote: ");
                    sb5.append(string2);
                    sb5.append(" verify key length:");
                    if (tencentLocation.getVerifyKey() == null) {
                        length2 = 0;
                    } else {
                        length2 = tencentLocation.getVerifyKey().length();
                    }
                    sb5.append(length2);
                    sb5.append(" source:");
                    sb5.append(tencentLocation.getSourceProvider());
                    sb5.append(" adcode :");
                    sb5.append(tencentLocation.getCityCode());
                    sb5.append(" lon*lat :");
                    sb5.append((int) (tencentLocation.getLongitude() * tencentLocation.getLatitude()));
                    sb5.append(" time:");
                    sb5.append(tencentLocation.getTime());
                    QLog.d(SosoInterface.TAG, 2, sb5.toString());
                }
                synchronized (SosoInterface.LOCK) {
                    if (i3 == 0) {
                        if (z19) {
                            SosoInterface.updateLocation(i16, tencentLocation, string);
                        }
                        if (rawData != null && rawData.length > 0) {
                            SosoInterface.updateRawData(tencentLocation.getProvider(), rawData);
                        }
                    }
                    SosoInterface.notifyLocationFinish(tencentLocation, i3, str, elapsedRealtime);
                    access$1300 = SosoInterface.access$1300();
                    access$1400 = SosoInterface.access$1400();
                    access$1500 = SosoInterface.access$1500();
                    access$1600 = SosoInterface.access$1600();
                    if (access$1300 != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                if (!SosoInterface.locationListenerManager.c().isEmpty()) {
                    SosoInterface.startNextLocation(z17, access$1300, access$1400, access$1500, access$1600);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SosoInterface.TAG, 4, "listener is empty.");
                }
                SosoInterface.stopLocation();
            }

            @Override // com.tencent.map.geolocation.TencentLocationListener
            public void onStatusUpdate(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SosoInterface.TAG, 2, "onStatusUpdate name: " + str + " status: " + i3 + " desc: " + str2);
                }
                synchronized (SosoInterface.LOCK) {
                    for (int size = SosoInterface.locationListenerManager.c().size() - 1; size >= 0; size--) {
                        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = SosoInterface.locationListenerManager.c().get(size);
                        if (sosoInterfaceOnLocationListener != null) {
                            if (sosoInterfaceOnLocationListener.uiThread) {
                                ThreadManager.getUIHandler().post(new Runnable(sosoInterfaceOnLocationListener, str, i3, str2) { // from class: com.tencent.mobileqq.soso.location.SosoInterface.3.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ String val$desc;
                                    final /* synthetic */ SosoInterfaceOnLocationListener val$lis;
                                    final /* synthetic */ String val$name;
                                    final /* synthetic */ int val$status;

                                    {
                                        this.val$lis = sosoInterfaceOnLocationListener;
                                        this.val$name = str;
                                        this.val$status = i3;
                                        this.val$desc = str2;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, sosoInterfaceOnLocationListener, str, Integer.valueOf(i3), str2);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            this.val$lis.onStatusUpdate(this.val$name, this.val$status, this.val$desc);
                                        }
                                    }
                                });
                            } else {
                                sosoInterfaceOnLocationListener.onStatusUpdate(str, i3, str2);
                            }
                        }
                    }
                }
            }
        };
        REQ_RAW_LOCATION_LISTENER = new SosoInterfaceOnLocationListener(0, false, false, 0L, false, false, "reqRawData") { // from class: com.tencent.mobileqq.soso.location.SosoInterface.5
            static IPatchRedirector $redirector_;

            {
                super(r5, r6, r7, r8, r10, r11, r12);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(r5), Boolean.valueOf(r6), Boolean.valueOf(r7), Long.valueOf(r8), Boolean.valueOf(r10), Boolean.valueOf(r11), r12);
                }
            }

            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SosoInterface.TAG, 2, "onLocationFinish() lock.notifyAll()");
                }
                synchronized (SosoInterface.LOCK) {
                    SosoInterface.LOCK.notifyAll();
                }
            }
        };
        if (!bo.d()) {
            initRegisteredCallers();
        }
        sInLaunchTime = true;
        appStatusCallBack = new IGuardInterface() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.14
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onApplicationBackground() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    SosoInterface.locationListenerManager.e(false);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onApplicationForeground() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SosoInterface.locationListenerManager.e(true);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onBackgroundTimeTick(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, j3);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onBackgroundUnguardTimeTick(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, j3);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onLiteTimeTick(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, j3);
                }
            }

            @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
            public void onScreensStateChanged(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, z16);
                }
            }
        };
    }

    public SosoInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* synthetic */ int access$1008() {
        int i3 = consecutiveFailCount;
        consecutiveFailCount = i3 + 1;
        return i3;
    }

    static /* synthetic */ SosoInterfaceOnLocationListener access$1300() {
        return getRawLocationListener();
    }

    static /* synthetic */ SosoInterfaceOnLocationListener access$1400() {
        return getTopCommonListener();
    }

    static /* synthetic */ SosoInterfaceOnLocationListener access$1500() {
        return getTopGoonListener();
    }

    static /* synthetic */ SosoInterfaceOnLocationListener access$1600() {
        return getRequestingGoonListener();
    }

    static /* synthetic */ SharedPreferences access$2200() {
        return getConfigSp();
    }

    private static void addOnLocationListener(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        if (sosoInterfaceOnLocationListener == null) {
            return;
        }
        synchronized (LOCK) {
            locationListenerManager.a(sosoInterfaceOnLocationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkLevel3NoCityCodeCount(TencentLocation tencentLocation, int i3, int i16) {
        if (3 == i16 && i3 == 0) {
            if (TextUtils.isEmpty(tencentLocation.getCityCode())) {
                int i17 = level3NoCityCodeCount + 1;
                level3NoCityCodeCount = i17;
                if (i17 >= 12) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("level_3_no_citycode", String.valueOf(level3NoCityCodeCount));
                    StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(getCurrentUin(), "actSoSoNoCityCodeTimeout", true, 0L, 0L, hashMap, "");
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onLocationChanged level is 3, adcode is null");
                }
                return true;
            }
            if (level3NoCityCodeCount > 0) {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("level_3_no_citycode", String.valueOf(level3NoCityCodeCount));
                StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(getCurrentUin(), "actSoSoNoCityCode", true, 0L, 0L, hashMap2, "");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onLocationChanged level is 3, adcode is null, count : " + level3NoCityCodeCount);
                }
            }
        }
        level3NoCityCodeCount = 0;
        return false;
    }

    public static SosoLbsInfo getCanUsedLbsInfoCache(long j3, boolean z16, int i3, boolean z17) {
        int i16;
        SosoLbsInfo rawSosoInfo;
        boolean z18 = true;
        if (isMainProcess()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (j3 <= 0 || z16) {
                return null;
            }
            if (z17) {
                long j16 = timeUpdate[i3];
                if (j16 <= 0 || elapsedRealtime >= j16 + j3) {
                    return null;
                }
                rawSosoInfo = getSosoInfo(i3, true);
            } else {
                long j17 = reqRawTime;
                if (j17 <= 0 || elapsedRealtime >= j17 + j3 || logSoso == null) {
                    return null;
                }
                rawSosoInfo = getRawSosoInfo(true);
            }
            return rawSosoInfo;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("max_cache_interval", j3);
        bundle.putBoolean("goon", z16);
        bundle.putInt("level", i3);
        bundle.putBoolean("req_location", z17);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SosoInterfaceModule.NAME, SosoInterfaceModule.ACTION_GET_LBS_INFO, bundle);
        if (callServer != null && callServer.isSuccess()) {
            callServer.data.setClassLoader(SosoInterface.class.getClassLoader());
            SosoLbsInfo sosoLbsInfo = (SosoLbsInfo) callServer.data.getParcelable("soso_lbs_info");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getCanUsedLbsInfoCache result is ok ,info is null: ");
            if (sosoLbsInfo != null) {
                z18 = false;
            }
            sb5.append(z18);
            QLog.i(TAG, 2, sb5.toString());
            return sosoLbsInfo;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("getCanUsedLbsInfoCache result is not ok. code: ");
        if (callServer == null) {
            i16 = -1;
        } else {
            i16 = callServer.code;
        }
        sb6.append(i16);
        QLog.i(TAG, 2, sb6.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCity() {
        SosoLocation sosoLocation;
        SosoLbsInfo sosoInfo = getSosoInfo();
        if (sosoInfo != null && (sosoLocation = sosoInfo.mLocation) != null && !TextUtils.isEmpty(sosoLocation.city)) {
            return sosoInfo.mLocation.city;
        }
        return getConfigSp().getString("city", "");
    }

    public static String getCityCode() {
        SosoLocation sosoLocation;
        SosoLbsInfo sosoInfo = getSosoInfo();
        if (sosoInfo != null && (sosoLocation = sosoInfo.mLocation) != null && !TextUtils.isEmpty(sosoLocation.cityCode)) {
            return sosoInfo.mLocation.cityCode;
        }
        return getConfigSp().getString("adcode", "");
    }

    private static SharedPreferences getConfigSp() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "sosoConfig", "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean(KEY_MMKV_MIGRATE_FLAG, false)) {
            try {
                QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "sosoConfig", "common_mmkv_configurations");
                fromSpAdapter.edit().putBoolean(KEY_MMKV_MIGRATE_FLAG, true).apply();
                return fromSpAdapter;
            } catch (Exception unused) {
                QLog.e(TAG, 2, "[Migrate Error]. ");
                return MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("sosoConfig", 4);
            }
        }
        return fromSpAdapter;
    }

    public static String getCurrentUin() {
        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
        if (lastLoginUin != null && lastLoginUin.length() > 0) {
            return lastLoginUin;
        }
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    private static long getNormalEnterConversationTime() {
        return getConfigSp().getLong("normal_enter_conversation_time", 0L);
    }

    private static synchronized String getOaid() {
        synchronized (SosoInterface.class) {
            if (hasGetOaid) {
                return mOaid;
            }
            hasGetOaid = true;
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SosoInterface.mOaid = LbsGdtUtils.getOaid();
                    if (!TextUtils.isEmpty(SosoInterface.mOaid)) {
                        if (SosoInterface.mLocationManager == null) {
                            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).initLocationManager();
                            TencentLocationManager unused = SosoInterface.mLocationManager = TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext());
                        }
                        try {
                            SosoInterface.mLocationManager.setDeviceID(new Pair<>("oaId", SosoInterface.mOaid));
                        } catch (Exception e16) {
                            QLog.d(SosoInterface.TAG, 1, "setDeviceId\uff08\uff09 has exception = " + e16);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(SosoInterface.TAG, 2, "mLocationManager.setDeviceId\uff08\uff09 mOaid = " + SosoInterface.mOaid);
                            return;
                        }
                        return;
                    }
                    QLog.d(SosoInterface.TAG, 1, "getOaid\uff08\uff09 mOaid is empty ");
                }
            });
            return mOaid;
        }
    }

    public static String getProvince() {
        SosoLocation sosoLocation;
        SosoLbsInfo sosoInfo = getSosoInfo();
        if (sosoInfo != null && (sosoLocation = sosoInfo.mLocation) != null && !TextUtils.isEmpty(sosoLocation.province)) {
            return sosoInfo.mLocation.province;
        }
        return getConfigSp().getString("province", "");
    }

    private static SosoInterfaceOnLocationListener getRawLocationListener() {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = null;
        for (int size = locationListenerManager.c().size() - 1; size >= 0; size--) {
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2 = locationListenerManager.c().get(size);
            if (!sosoInterfaceOnLocationListener2.isRemoved && !sosoInterfaceOnLocationListener2.goonListener && !sosoInterfaceOnLocationListener2.reqLocation) {
                sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
            }
        }
        return sosoInterfaceOnLocationListener;
    }

    @Deprecated
    public static SosoLbsInfo getRawSosoInfo() {
        return getRawSosoInfo(true);
    }

    private static SosoInterfaceOnLocationListener getRequestingGoonListener() {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = null;
        for (int size = locationListenerManager.c().size() - 1; size >= 0; size--) {
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2 = locationListenerManager.c().get(size);
            if (!sosoInterfaceOnLocationListener2.isRemoved && sosoInterfaceOnLocationListener2.goonListener && sosoInterfaceOnLocationListener2.requesting) {
                sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
            }
        }
        return sosoInterfaceOnLocationListener;
    }

    @Deprecated
    public static SosoLbsInfo getSosoInfo() {
        SosoLbsInfo sosoLbsInfo = logSoso;
        if (sosoLbsInfo == null || sosoLbsInfo.mLocation == null) {
            return null;
        }
        SosoLbsInfo sosoLbsInfo2 = new SosoLbsInfo();
        sosoLbsInfo2.mLocation = logSoso.mLocation.clone(4, true);
        return sosoLbsInfo2;
    }

    private static SosoInterfaceOnLocationListener getTopCommonListener() {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = null;
        for (int size = locationListenerManager.c().size() - 1; size >= 0; size--) {
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2 = locationListenerManager.c().get(size);
            if (!sosoInterfaceOnLocationListener2.isRemoved && !sosoInterfaceOnLocationListener2.goonListener && sosoInterfaceOnLocationListener2.reqLocation && (sosoInterfaceOnLocationListener == null || sosoInterfaceOnLocationListener.level < sosoInterfaceOnLocationListener2.level)) {
                sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
            }
        }
        return sosoInterfaceOnLocationListener;
    }

    private static SosoInterfaceOnLocationListener getTopGoonListener() {
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = null;
        for (int size = locationListenerManager.c().size() - 1; size >= 0; size--) {
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2 = locationListenerManager.c().get(size);
            if (!sosoInterfaceOnLocationListener2.isRemoved && sosoInterfaceOnLocationListener2.goonListener && (sosoInterfaceOnLocationListener == null || sosoInterfaceOnLocationListener.level < sosoInterfaceOnLocationListener2.level)) {
                sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
            }
        }
        return sosoInterfaceOnLocationListener;
    }

    public static void initLocationManager() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null || hasLocationManagerInit) {
            return;
        }
        locationListenerManager.e(guardManager.isApplicationForeground());
        GuardManager.sInstance.registerCallBack(appStatusCallBack);
        hasLocationManagerInit = true;
    }

    private static void initRegisteredCallers() {
        HashSet<String> hashSet = new HashSet<>(128, 1.0f);
        sRegisteredCallers = hashSet;
        hashSet.add("pathtrace");
        sRegisteredCallers.add("ecshop");
        sRegisteredCallers.add("AbsPublish");
        sRegisteredCallers.add("QQYPHomePageActivity");
        sRegisteredCallers.add("vas_red_point");
        sRegisteredCallers.add("HotSpotNodeUtil");
        sRegisteredCallers.add("HYNearbyHelper");
        sRegisteredCallers.add("AbsPublishIphoneTitleBarActivity");
        sRegisteredCallers.add("LBSService");
        sRegisteredCallers.add("LBSService.Encounter");
        sRegisteredCallers.add("LBSService.Point");
        sRegisteredCallers.add("NearbyHandler");
        sRegisteredCallers.add("AccountConfigReq");
        sRegisteredCallers.add("recommend_troop");
        sRegisteredCallers.add("AddFriendVerifyActivity");
        sRegisteredCallers.add("AutoLocationMapView");
        sRegisteredCallers.add("BaseProtocolCoder.Point");
        sRegisteredCallers.add("BusinessCmrTmpChatPie");
        sRegisteredCallers.add("BusinessHandler");
        sRegisteredCallers.add("c2blbs");
        sRegisteredCallers.add("CardHandler");
        sRegisteredCallers.add(CreateFaceToFaceDiscussionActivity.TAG);
        sRegisteredCallers.add("CrmIvr");
        sRegisteredCallers.add("EnterpriseQQManager");
        sRegisteredCallers.add("FlowCameraActivity2");
        sRegisteredCallers.add("IphoneTitleBarActivity");
        sRegisteredCallers.add("LBSHandler");
        sRegisteredCallers.add("LBSService.Groups");
        sRegisteredCallers.add(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK);
        sRegisteredCallers.add("NearbyCmdHelper.Point");
        sRegisteredCallers.add("NearbyTroopsView");
        sRegisteredCallers.add("PersonalInfoReq");
        sRegisteredCallers.add("PublicAccountChatPie");
        sRegisteredCallers.add(IPublicAccountManager.TAG);
        sRegisteredCallers.add("PublicView");
        sRegisteredCallers.add("QLifeCommentActivity");
        sRegisteredCallers.add("QQCardService");
        sRegisteredCallers.add(QQMapActivity.TAG);
        sRegisteredCallers.add("QQSettingRedesign");
        sRegisteredCallers.add("QQYPCityActivity");
        sRegisteredCallers.add("Qwallet");
        sRegisteredCallers.add("RealEventReq");
        sRegisteredCallers.add("TroopNotifyAndRecommendView");
        sRegisteredCallers.add("reqRawData");
        sRegisteredCallers.add("SearchProtocol");
        sRegisteredCallers.add("StatusServlet");
        sRegisteredCallers.add("TroopFileHandler");
        sRegisteredCallers.add("TroopNearByBigMapView");
        sRegisteredCallers.add("VipMapRoamActivity");
        sRegisteredCallers.add("webview");
        sRegisteredCallers.add("qq_weather");
        sRegisteredCallers.add("NearbyProtocolCoder.Encounter");
        sRegisteredCallers.add("BizTroopHandler");
        sRegisteredCallers.add("troop_handler");
        sRegisteredCallers.add("NearbyCardHandler");
        sRegisteredCallers.add("LbsMngLocationListener");
        sRegisteredCallers.add("QWalletBaseProtocol");
        sRegisteredCallers.add("buscardLocation");
        sRegisteredCallers.add("NewFlowCameraActivity");
        sRegisteredCallers.add("NewStoryTakeVideoActivity");
        sRegisteredCallers.add("NearbyNowliveTab");
        sRegisteredCallers.add("ArkAppLocationManager");
        sRegisteredCallers.add("ArkAppEventObserverManager");
        sRegisteredCallers.add("vfuchong_bus_card");
        sRegisteredCallers.add("ARMapDataPreload");
        sRegisteredCallers.add("armap_web_plugin");
        sRegisteredCallers.add("LebaPlugin");
        sRegisteredCallers.add(GdtLocationUtil.TAG);
        sRegisteredCallers.add("FlashCarGame");
        sRegisteredCallers.add("QQARScan");
        sRegisteredCallers.add("BKEngineLocationManager");
        sRegisteredCallers.add("Doraemon");
        sRegisteredCallers.add("GalleryReportedUtils");
        sRegisteredCallers.add("official_location");
        sRegisteredCallers.add("readinjoy_anti_cheating");
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_WEATHER);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_LIVE);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_SAY);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_UPLOAD_PIC_VIDEO);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_PHOTO_RECOMMEND);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_LITTLE_VIDEO_ENTER);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_REQUEST_SERVER);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_H5);
        sRegisteredCallers.add(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER);
        sRegisteredCallers.add("readinjoy_feed_ad_distance");
        sRegisteredCallers.add("gdt_tangram");
        sRegisteredCallers.add("nearby_readinjoy");
        sRegisteredCallers.add("troop_member_distance");
        sRegisteredCallers.add("qq_story_water_mark");
        sRegisteredCallers.add("miniApp");
        sRegisteredCallers.add("readinjoy_weather");
        sRegisteredCallers.add("PublicAccountHandler");
        sRegisteredCallers.add("readinjoy_position");
        sRegisteredCallers.add("Face2FaceAddContactPresenter");
        sRegisteredCallers.add("qqcircle");
        sRegisteredCallers.add("extend_friend");
        sRegisteredCallers.add("QQLive");
        sRegisteredCallers.add(LocationInputFragment.LBS_BIZ_QWALLET_ID_VERIFY);
        sRegisteredCallers.add("ECommerce");
        sRegisteredCallers.add("NearByPro");
        sRegisteredCallers.add("QQSearch");
    }

    private static boolean isCallerRegistered(String str) {
        HashSet<String> hashSet;
        if (!TextUtils.isEmpty(str) && (hashSet = sRegisteredCallers) != null) {
            return hashSet.contains(str);
        }
        return false;
    }

    public static boolean isLastLocationSuccess() {
        if (getConfigSp().getInt("last_location_err_code", -1) == 0) {
            return true;
        }
        return false;
    }

    private static boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyLocationError() {
        SosoLbsInfo rawSosoInfo;
        synchronized (LOCK) {
            for (int size = locationListenerManager.c().size() - 1; size >= 0; size--) {
                LocationListenerManager locationListenerManager2 = locationListenerManager;
                SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = locationListenerManager2.c().get(size);
                if (sosoInterfaceOnLocationListener != null) {
                    if (sosoInterfaceOnLocationListener.reqLocation) {
                        rawSosoInfo = getSosoInfo(sosoInterfaceOnLocationListener.level, true);
                    } else {
                        rawSosoInfo = getRawSosoInfo(true);
                    }
                    locationListenerManager2.f(sosoInterfaceOnLocationListener, -10000, rawSosoInfo);
                }
            }
            locationListenerManager.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyLocationFinish(TencentLocation tencentLocation, int i3, String str, long j3) {
        boolean z16;
        SosoLbsInfo rawSosoInfo;
        String str2;
        int i16;
        SosoLbsInfo sosoLbsInfo;
        int i17;
        String str3;
        boolean z17;
        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener;
        LocationListenerManager locationListenerManager2;
        boolean z18;
        int i18;
        int i19;
        int i26;
        SosoLbsInfo rawSosoInfo2;
        int i27;
        boolean z19;
        int i28 = i3;
        int i29 = tencentLocation.getExtra().getInt("qq_level");
        String string = tencentLocation.getExtra().getString("qq_caller");
        boolean z26 = tencentLocation.getExtra().getBoolean("qq_reqLocation");
        boolean z27 = tencentLocation.getExtra().getBoolean("qq_allowGps");
        boolean z28 = true;
        if (i28 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        LocationListenerManager locationListenerManager3 = locationListenerManager;
        if (!locationListenerManager3.c().isEmpty()) {
            if (z26) {
                rawSosoInfo = getSosoInfo(i29, true);
            } else {
                rawSosoInfo = getRawSosoInfo(true);
            }
            SosoLbsInfo sosoLbsInfo2 = rawSosoInfo;
            int size = locationListenerManager3.c().size() - 1;
            while (size >= 0) {
                LocationListenerManager locationListenerManager4 = locationListenerManager;
                SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2 = locationListenerManager4.c().get(size);
                boolean z29 = sosoInterfaceOnLocationListener2.reqLocation;
                if (z29 == z26 && (!z29 || sosoInterfaceOnLocationListener2.level <= i29)) {
                    locationListenerManager4.f(sosoInterfaceOnLocationListener2, i28, sosoLbsInfo2);
                    if (TextUtils.isEmpty(string) || string.equals(sosoInterfaceOnLocationListener2.tag)) {
                        z19 = false;
                    } else {
                        z19 = z28;
                    }
                    boolean z36 = z26;
                    str2 = TAG;
                    z17 = z26;
                    sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
                    String str4 = string;
                    str3 = string;
                    locationListenerManager2 = locationListenerManager4;
                    i16 = size;
                    sosoLbsInfo = sosoLbsInfo2;
                    int i36 = i29;
                    i17 = i29;
                    z18 = z28;
                    uploadSummaryData(z16, z36, j3, i3, str4, str, z27, i36, z19);
                    if (sosoInterfaceOnLocationListener.goonListener) {
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, 2, "onLocationChanged() lis=" + sosoInterfaceOnLocationListener.tag + " goon...");
                        }
                    } else {
                        locationListenerManager2.j(i16);
                        sosoInterfaceOnLocationListener.isRemoved = z18;
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, 2, "onLocationChanged() lis=" + sosoInterfaceOnLocationListener.tag + " removed normally.");
                        }
                    }
                } else {
                    str2 = TAG;
                    i16 = size;
                    sosoLbsInfo = sosoLbsInfo2;
                    i17 = i29;
                    str3 = string;
                    z17 = z26;
                    sosoInterfaceOnLocationListener = sosoInterfaceOnLocationListener2;
                    locationListenerManager2 = locationListenerManager4;
                    z18 = z28;
                }
                if (!sosoInterfaceOnLocationListener.isRemoved) {
                    if (sosoInterfaceOnLocationListener.goonListener) {
                        int i37 = consecutiveFailCount;
                        if (i37 > 0) {
                            i18 = i3;
                            i19 = i16;
                            sosoInterfaceOnLocationListener.onConsecutiveFailure(i18, i37);
                        }
                    } else {
                        i18 = i3;
                        i19 = i16;
                        long elapsedRealtime = SystemClock.elapsedRealtime() - sosoInterfaceOnLocationListener.sTime;
                        if (bo.c()) {
                            i26 = 300000;
                        } else {
                            i26 = 30000;
                        }
                        if (elapsedRealtime > i26) {
                            locationListenerManager2.j(i19);
                            sosoInterfaceOnLocationListener.isRemoved = z18;
                            if (sosoInterfaceOnLocationListener.reqLocation) {
                                rawSosoInfo2 = getSosoInfo(sosoInterfaceOnLocationListener.level, z18);
                            } else {
                                rawSosoInfo2 = getRawSosoInfo(z18);
                            }
                            if (rawSosoInfo2 == null) {
                                i27 = -10000;
                            } else {
                                i27 = 0;
                            }
                            locationListenerManager2.f(sosoInterfaceOnLocationListener, i27, rawSosoInfo2);
                            if (QLog.isColorLevel()) {
                                QLog.d(str2, 2, "lis=" + sosoInterfaceOnLocationListener.tag + " err_timeout.reqRaw=" + sosoInterfaceOnLocationListener.reqLocation + ". Force 2 remove it.");
                            }
                        }
                    }
                    size = i19 - 1;
                    i28 = i18;
                    z28 = z18;
                    z26 = z17;
                    string = str3;
                    sosoLbsInfo2 = sosoLbsInfo;
                    i29 = i17;
                }
                i18 = i3;
                i19 = i16;
                size = i19 - 1;
                i28 = i18;
                z28 = z18;
                z26 = z17;
                string = str3;
                sosoLbsInfo2 = sosoLbsInfo;
                i29 = i17;
            }
        }
    }

    public static void onDestroy() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SosoInterface.stopLocation();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        synchronized (LOCK) {
            locationListenerManager.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realLocateReq(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        String str;
        String str2;
        SosoLbsInfo canUsedLbsInfoCache = getCanUsedLbsInfoCache(sosoInterfaceOnLocationListener.maxCacheInterval, sosoInterfaceOnLocationListener.goonListener, sosoInterfaceOnLocationListener.level, sosoInterfaceOnLocationListener.reqLocation);
        if (canUsedLbsInfoCache != null) {
            locationListenerManager.f(sosoInterfaceOnLocationListener, 0, canUsedLbsInfoCache);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startLocation() lis=" + sosoInterfaceOnLocationListener.tag + " use cache and callback now");
            }
            uploadSummaryData(true, sosoInterfaceOnLocationListener.reqLocation, 0L, 0, sosoInterfaceOnLocationListener.tag, "ERROR_OK", sosoInterfaceOnLocationListener.askGPS, sosoInterfaceOnLocationListener.level, true);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startLocation() reqLoc=");
        sb5.append(sosoInterfaceOnLocationListener.reqLocation);
        sb5.append(" askGPS=");
        sb5.append(sosoInterfaceOnLocationListener.askGPS);
        sb5.append(" level=");
        sb5.append(sosoInterfaceOnLocationListener.level);
        sb5.append(" caller=");
        sb5.append(sosoInterfaceOnLocationListener.tag);
        sb5.append(" ui=");
        sb5.append(sosoInterfaceOnLocationListener.uiThread);
        sb5.append(" goon=");
        sb5.append(sosoInterfaceOnLocationListener.goonListener);
        sb5.append(" maxCacheInterval= ");
        sb5.append(sosoInterfaceOnLocationListener.maxCacheInterval);
        AtomicInteger atomicInteger = REQ_STATUS;
        if (atomicInteger.get() == 0) {
            str = " do startLocation";
        } else {
            str = " waitting...";
        }
        sb5.append(str);
        sb5.append(" now is foreground or background: ");
        if (BGLocateMonitor.isAppOnForeground()) {
            str2 = a.f248963o;
        } else {
            str2 = "background";
        }
        sb5.append(str2);
        QLog.d(TAG, 2, sb5.toString());
        addOnLocationListener(sosoInterfaceOnLocationListener);
        if (atomicInteger.get() == 0) {
            if (sosoInterfaceOnLocationListener == REQ_RAW_LOCATION_LISTENER) {
                atomicInteger.set(1);
            } else {
                atomicInteger.set(2);
            }
            sosoInterfaceOnLocationListener.sTime = SystemClock.elapsedRealtime();
            TencentLocationRequest create = TencentLocationRequest.create();
            create.setInterval(sContinuousLocationInterval);
            create.setRequestLevel(sosoInterfaceOnLocationListener.level);
            create.setAllowCache(true);
            create.setAllowGPS(sosoInterfaceOnLocationListener.askGPS);
            create.setCheckInterval(30000L);
            TencentExtraKeys.setRequestRawData(create, !sosoInterfaceOnLocationListener.reqLocation);
            create.getExtras().putInt("qq_level", sosoInterfaceOnLocationListener.level);
            create.getExtras().putBoolean("qq_reqLocation", sosoInterfaceOnLocationListener.reqLocation);
            create.getExtras().putString("qq_caller", sosoInterfaceOnLocationListener.tag);
            create.getExtras().putBoolean("qq_goonListener", sosoInterfaceOnLocationListener.goonListener);
            consumeOffset = 0;
            time = SystemClock.elapsedRealtime();
            consecutiveFailCount = 0;
            sosoInterfaceOnLocationListener.requesting = true;
            if (mLocationManager == null) {
                ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).initLocationManager();
                mLocationManager = TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext());
            }
            if (subHandler.hasMessages(1001)) {
                subHandler.removeMessages(1001);
            }
            subHandler.sendEmptyMessageDelayed(1001, 35000L);
            level3NoCityCodeCount = 0;
            TencentLocationManager.setTencentLocationLogListener(new TencentLocationLogListener() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.map.geolocation.TencentLocationLogListener
                public void onTencentLogChanged(String str3, String str4) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3, (Object) str4);
                        return;
                    }
                    QLog.i(SosoInterface.TAG, 1, str3 + "," + str4);
                }
            });
            QLog.i(TAG, 1, "location manager requestLocationUpdates result is: " + mLocationManager.requestLocationUpdates(create, locListener, ThreadManagerV2.getSubThreadLooper()));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "status != REQ_STOP");
        }
    }

    public static void removeOnLocationListener(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        LocationListenerManager locationListenerManager2;
        synchronized (LOCK) {
            locationListenerManager2 = locationListenerManager;
            locationListenerManager2.i(sosoInterfaceOnLocationListener);
            sosoInterfaceOnLocationListener.isRemoved = true;
            sosoInterfaceOnLocationListener.requesting = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeOnLocationListener() lis=" + sosoInterfaceOnLocationListener.tag + " removed.");
        }
        if (locationListenerManager2.c().isEmpty()) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (SosoInterface.locationListenerManager.c().isEmpty()) {
                        SosoInterface.stopLocation();
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
            }
        }
    }

    @Deprecated
    public static void reqRawLbsData(long j3, String str) {
        boolean z16;
        long elapsedRealtime;
        if (ThreadManagerV2.getSubThread() != Thread.currentThread() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str2 = "";
            if (stackTrace != null && stackTrace.length >= 4) {
                StackTraceElement stackTraceElement = stackTrace[3];
                str2 = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "reqRawData caller route: " + str2);
                }
            }
            z16 = true;
            if (j3 > 0 && SystemClock.elapsedRealtime() < reqRawTime + j3) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reqRawLbsData() use cache and callback now.caller=" + str);
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (str != null && str.length() > 0) {
                    hashMap.put("param_caller", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("param_caller_route", str2);
                }
                hashMap.put("param_useCache", Boolean.toString(true));
                StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(getCurrentUin(), "actSosoRawDataCache", true, 0L, 0L, hashMap, "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reqRawLbsData() caller=" + str + " interval=" + j3);
            }
            SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener = REQ_RAW_LOCATION_LISTENER;
            sosoInterfaceOnLocationListener.tag = str;
            startLocation(sosoInterfaceOnLocationListener);
            elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z17 = false;
            try {
                Object obj = LOCK;
                synchronized (obj) {
                    try {
                        if (SystemClock.elapsedRealtime() >= reqRawTime + 2000) {
                            obj.wait(20000L);
                            z16 = false;
                        }
                        try {
                        } catch (Throwable th5) {
                            th = th5;
                            z17 = z16;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                throw th;
            } catch (InterruptedException unused) {
                z16 = z17;
            }
        } else {
            throw new AndroidRuntimeException("reqRawLbsData() can't be invoked by SubThread or UIThread.caller=" + str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reqSosoLbsRawData() caller=" + str + " less2s=" + z16 + " cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public static void saveGeogInfo(String str, String str2) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_SAVE_GEOG_INFO);
        newIntent.putExtra("longitude", str);
        newIntent.putExtra("latitude", str2);
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
        } else {
            QLog.e(TAG, 1, "MobileQQ.sMobileQQ.peekAppRuntime() == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLastLocationErrCode(int i3) {
        getConfigSp().edit().putInt("last_location_err_code", i3).commit();
    }

    public static void saveNormalEnterConversationTime(long j3) {
        getConfigSp().edit().putLong("normal_enter_conversation_time", j3).commit();
    }

    public static boolean saveSosoInterfaceConfig(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveSosoInterfaceConfig: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        getConfigSp().edit().putString(DownloadInfo.spKey_Config, str).commit();
        return true;
    }

    public static synchronized void startLocation(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        synchronized (SosoInterface.class) {
            if (sosoInterfaceOnLocationListener == null) {
                return;
            }
            int i3 = 0;
            if (sosoInterfaceOnLocationListener.isRemoved) {
                sosoInterfaceOnLocationListener.isRemoved = false;
            }
            if (!bo.d() && !isCallerRegistered(sosoInterfaceOnLocationListener.tag)) {
                String format = String.format(HardCodeUtil.qqStr(R.string.f199894qn), sosoInterfaceOnLocationListener.tag);
                toastSomethingWrong(format);
                QLog.d(TAG, 2, format);
                return;
            }
            boolean isNetSupport = NetworkUtil.isNetSupport(MobileQQ.sMobileQQ.getApplicationContext());
            if (!isNetSupport) {
                i3 = 1;
            } else if (!sScreenOn && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101714", true)) {
                i3 = -10001;
            }
            if (TextUtils.isEmpty(mOaid)) {
                mOaid = getOaid();
            }
            BGLocateMonitor.checkTencentLocateReport(i3);
            if (i3 == 0 && !BGLocateMonitor.isAppOnForeground()) {
                i3 = -10004;
            }
            if (i3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "startLocation() return. perCheckCode=" + i3 + " hasNet=" + isNetSupport);
                }
                locationListenerManager.f(sosoInterfaceOnLocationListener, i3, getSosoInfo(sosoInterfaceOnLocationListener.level, true));
                return;
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SosoInterfaceOnLocationListener.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (SosoInterface.tencentLog == null && !bo.d()) {
                        try {
                            TencentLog unused = SosoInterface.tencentLog = new TencentLogImpl(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.getApplicationContext().getExternalCacheDir());
                            TencentExtraKeys.addTencentLog(SosoInterface.tencentLog);
                        } catch (Exception e16) {
                            if (QLog.isDevelopLevel()) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    SosoInterface.realLocateReq(SosoInterfaceOnLocationListener.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startNextLocation(boolean z16, SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener, SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener2, SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener3, SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener4) {
        String str = "";
        if (z16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onLocationChanged()");
                if (sosoInterfaceOnLocationListener3 != null) {
                    str = " goonLis been truncated:" + sosoInterfaceOnLocationListener3.tag;
                }
                sb5.append(str);
                sb5.append(" start:reqRawData");
                QLog.d(TAG, 2, sb5.toString());
            }
            if (sosoInterfaceOnLocationListener4 != null) {
                sosoInterfaceOnLocationListener4.requesting = false;
            }
            if (sosoInterfaceOnLocationListener != null) {
                SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener5 = REQ_RAW_LOCATION_LISTENER;
                sosoInterfaceOnLocationListener5.tag = sosoInterfaceOnLocationListener.tag;
                sosoInterfaceOnLocationListener5.askGPS = sosoInterfaceOnLocationListener.askGPS;
            }
            stopLocation();
            startLocation(REQ_RAW_LOCATION_LISTENER);
            return;
        }
        if (sosoInterfaceOnLocationListener2 != null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onLocationChanged()");
                if (sosoInterfaceOnLocationListener3 != null) {
                    str = " goonLis been truncated:" + sosoInterfaceOnLocationListener3.tag;
                }
                sb6.append(str);
                sb6.append(" start:");
                sb6.append(sosoInterfaceOnLocationListener2.tag);
                QLog.d(TAG, 2, sb6.toString());
            }
            if (sosoInterfaceOnLocationListener4 != null) {
                sosoInterfaceOnLocationListener4.requesting = false;
            }
            stopLocation();
            sosoInterfaceOnLocationListener2.maxCacheInterval = 0L;
            startLocation(sosoInterfaceOnLocationListener2);
            return;
        }
        if (sosoInterfaceOnLocationListener3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onLocationChanged() goonLis goon after 1000ms:" + sosoInterfaceOnLocationListener3.tag);
            }
            if (sosoInterfaceOnLocationListener4 != null && sosoInterfaceOnLocationListener4 != sosoInterfaceOnLocationListener3) {
                sosoInterfaceOnLocationListener4.requesting = false;
            }
            if (!sosoInterfaceOnLocationListener3.requesting && !sosoInterfaceOnLocationListener3.isRemoved) {
                stopLocation();
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SosoInterfaceOnLocationListener.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener6 = SosoInterfaceOnLocationListener.this;
                        if (!sosoInterfaceOnLocationListener6.isRemoved) {
                            SosoInterface.startLocation(sosoInterfaceOnLocationListener6);
                        }
                    }
                }, 2000L);
            }
        }
    }

    public static void startOfficialLocation() {
        SharedPreferences configSp = getConfigSp();
        String string = configSp.getString(DownloadInfo.spKey_Config, "");
        long j3 = configSp.getLong("lastLocationTime", 0L);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startOfficialLocation. config is: " + string + " lastLocationTime: " + j3);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int i3 = jSONObject.getInt("isLoginLBSOpen");
            int i16 = jSONObject.getInt("loginLBSInterval");
            if (i3 != 1 || NetConnInfoCenter.getServerTime() - j3 < i16) {
                return;
            }
            if (TextUtils.isEmpty(mOaid)) {
                mOaid = getOaid();
            }
            LbsManagerService.startLocation(new LbsManagerServiceOnLocationChangeListener("official_location", false) { // from class: com.tencent.mobileqq.soso.location.SosoInterface.13
                static IPatchRedirector $redirector_;

                {
                    super(r5, r6);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, r5, Boolean.valueOf(r6));
                    }
                }

                @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
                public void onLocationFinish(int i17, SosoLbsInfo sosoLbsInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i17, (Object) sosoLbsInfo);
                    }
                }

                @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
                public void onStatusUpdate(String str, int i17, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i17), str2);
                    }
                }
            });
            configSp.edit().putLong("lastLocationTime", NetConnInfoCenter.getServerTime()).commit();
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopLocation() {
        TencentLocationManager tencentLocationManager;
        REQ_STATUS.set(0);
        TencentLocationListener tencentLocationListener = locListener;
        if (tencentLocationListener != null && (tencentLocationManager = mLocationManager) != null) {
            tencentLocationManager.removeUpdates(tencentLocationListener);
            mLocationManager = null;
        }
        try {
            TencentLocationManager.setTencentLocationLogListener(null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.toString());
        }
        level3NoCityCodeCount = 0;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "stopLocation() stop LBS");
        }
    }

    private static void toastSomethingWrong(String str) {
        ThreadManager.getUIHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.soso.location.SosoInterface.12
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$content;

            {
                this.val$content = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (!TextUtils.isEmpty(this.val$content)) {
                    QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), this.val$content, 1).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void updateLocation(int i3, TencentLocation tencentLocation, String str) {
        long elapsedRealtime;
        int i16;
        if (tencentLocation == null) {
            return;
        }
        if (logSoso == null) {
            SosoLbsInfo sosoLbsInfo = new SosoLbsInfo();
            logSoso = sosoLbsInfo;
            sosoLbsInfo.mLocation = new SosoLocation();
        }
        logSoso.mLocation.mLon02 = tencentLocation.getLongitude();
        logSoso.mLocation.mLat02 = tencentLocation.getLatitude();
        logSoso.mLocation.mVerifyKey = tencentLocation.getVerifyKey();
        logSoso.mLocation.fakeReason = tencentLocation.getFakeReason();
        logSoso.mLocation.locationTime = tencentLocation.getTime();
        logSoso.mLocation.speed = tencentLocation.getSpeed();
        logSoso.mLocation.mProviderSource = tencentLocation.getSourceProvider();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        logSoso.mLocation.poi = tencentLocation.getPoiList();
                        timeUpdate[4] = SystemClock.elapsedRealtime();
                    }
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    reqLocationTime = elapsedRealtime;
                    if (elapsedRealtime - lastUpdateTime > 3000) {
                        saveGeogInfo(String.valueOf(tencentLocation.getLongitude()), String.valueOf(tencentLocation.getLatitude()));
                        lastUpdateTime = reqLocationTime;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - lastUpdateTime));
                        }
                    }
                    if (!isMainProcess()) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("level", i3);
                        bundle.putBoolean("req_location", true);
                        bundle.putParcelable("soso_lbs_info", logSoso);
                        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SosoInterfaceModule.NAME, SosoInterfaceModule.ACTION_SET_LBS_INFO, bundle);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("update location ipc result code: ");
                            if (callServer == null) {
                                i16 = -1;
                            } else {
                                i16 = callServer.code;
                            }
                            sb5.append(i16);
                            QLog.i(TAG, 2, sb5.toString());
                        }
                    }
                    LbsInfoReportManagerUtils.reportLbsInfo2DC(logSoso.mLocation, str);
                }
                logSoso.mLocation.nation = tencentLocation.getNation();
                logSoso.mLocation.province = tencentLocation.getProvince();
                logSoso.mLocation.city = tencentLocation.getCity();
                String cityCode = tencentLocation.getCityCode();
                if (!TextUtils.isEmpty(cityCode) && !cityCode.equalsIgnoreCase("unknown")) {
                    logSoso.mLocation.cityCode = cityCode;
                }
                logSoso.mLocation.district = tencentLocation.getDistrict();
                logSoso.mLocation.town = tencentLocation.getTown();
                logSoso.mLocation.village = tencentLocation.getVillage();
                logSoso.mLocation.street = tencentLocation.getStreet();
                logSoso.mLocation.streetNo = tencentLocation.getStreetNo();
                timeUpdate[3] = SystemClock.elapsedRealtime();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.soso.location.SosoInterface.11
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SosoInterface.access$2200().edit().putString("province", SosoInterface.logSoso.mLocation.province).apply();
                        SosoInterface.access$2200().edit().putString("adcode", SosoInterface.logSoso.mLocation.cityCode).apply();
                        SosoInterface.access$2200().edit().putString("city", SosoInterface.logSoso.mLocation.city).apply();
                    }
                }, 16, null, true);
            }
            logSoso.mLocation.name = tencentLocation.getName();
            logSoso.mLocation.address = tencentLocation.getAddress();
            timeUpdate[1] = SystemClock.elapsedRealtime();
        }
        logSoso.mLocation.altitude = tencentLocation.getAltitude();
        logSoso.mLocation.accuracy = tencentLocation.getAccuracy();
        timeUpdate[0] = SystemClock.elapsedRealtime();
        elapsedRealtime = SystemClock.elapsedRealtime();
        reqLocationTime = elapsedRealtime;
        if (elapsedRealtime - lastUpdateTime > 3000) {
        }
        if (!isMainProcess()) {
        }
        LbsInfoReportManagerUtils.reportLbsInfo2DC(logSoso.mLocation, str);
    }

    public static void updateMainProcessCachedLocation(int i3, SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo == null) {
            return;
        }
        if (logSoso == null) {
            SosoLbsInfo sosoLbsInfo2 = new SosoLbsInfo();
            logSoso = sosoLbsInfo2;
            sosoLbsInfo2.mLocation = new SosoLocation();
        }
        SosoLocation sosoLocation = logSoso.mLocation;
        SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
        sosoLocation.speed = sosoLocation2.speed;
        sosoLocation.mLon02 = sosoLocation2.mLon02;
        sosoLocation.mLat02 = sosoLocation2.mLat02;
        sosoLocation.mVerifyKey = sosoLocation2.mVerifyKey;
        sosoLocation.fakeReason = sosoLocation2.fakeReason;
        sosoLocation.locationTime = sosoLocation2.locationTime;
        sosoLocation.mProviderSource = sosoLocation2.mProviderSource;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 3) {
                    sosoLocation.nation = sosoLocation2.nation;
                    sosoLocation.province = sosoLocation2.province;
                    sosoLocation.city = sosoLocation2.city;
                    String str = sosoLocation2.cityCode;
                    if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("unknown")) {
                        logSoso.mLocation.cityCode = str;
                    }
                    SosoLocation sosoLocation3 = logSoso.mLocation;
                    SosoLocation sosoLocation4 = sosoLbsInfo.mLocation;
                    sosoLocation3.district = sosoLocation4.district;
                    sosoLocation3.town = sosoLocation4.town;
                    sosoLocation3.village = sosoLocation4.village;
                    sosoLocation3.street = sosoLocation4.street;
                    sosoLocation3.streetNo = sosoLocation4.streetNo;
                    timeUpdate[3] = SystemClock.elapsedRealtime();
                } else {
                    return;
                }
            }
            SosoLocation sosoLocation5 = logSoso.mLocation;
            SosoLocation sosoLocation6 = sosoLbsInfo.mLocation;
            sosoLocation5.name = sosoLocation6.name;
            sosoLocation5.address = sosoLocation6.address;
            timeUpdate[1] = SystemClock.elapsedRealtime();
        }
        SosoLocation sosoLocation7 = logSoso.mLocation;
        SosoLocation sosoLocation8 = sosoLbsInfo.mLocation;
        sosoLocation7.altitude = sosoLocation8.altitude;
        sosoLocation7.accuracy = sosoLocation8.accuracy;
        timeUpdate[0] = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:5|(1:7)|(4:8|9|10|11)|(2:12|13)|15|16|17|(3:19|(2:21|22)(2:24|25)|23)|26|27|(1:29)|30|31|32|33|34|(1:36)|37|(1:39)|40|41|(2:43|(4:45|(1:47)(1:50)|48|49)(1:51))(1:52)) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011b, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0075, code lost:
    
        r3 = new com.tencent.mobileqq.soso.location.data.SosoAttribute("", "", "", "", false);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d A[Catch: Exception -> 0x0149, TryCatch #2 {Exception -> 0x0149, blocks: (B:9:0x0019, B:11:0x002a, B:13:0x0038, B:16:0x0044, B:57:0x0075, B:17:0x008a, B:19:0x009d, B:23:0x00ce, B:27:0x00d9, B:29:0x00ec, B:33:0x010c, B:36:0x0123, B:39:0x012f, B:40:0x0135), top: B:8:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec A[Catch: Exception -> 0x0149, LOOP:1: B:28:0x00ea->B:29:0x00ec, LOOP_END, TryCatch #2 {Exception -> 0x0149, blocks: (B:9:0x0019, B:11:0x002a, B:13:0x0038, B:16:0x0044, B:57:0x0075, B:17:0x008a, B:19:0x009d, B:23:0x00ce, B:27:0x00d9, B:29:0x00ec, B:33:0x010c, B:36:0x0123, B:39:0x012f, B:40:0x0135), top: B:8:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0123 A[Catch: Exception -> 0x0149, TRY_ENTER, TryCatch #2 {Exception -> 0x0149, blocks: (B:9:0x0019, B:11:0x002a, B:13:0x0038, B:16:0x0044, B:57:0x0075, B:17:0x008a, B:19:0x009d, B:23:0x00ce, B:27:0x00d9, B:29:0x00ec, B:33:0x010c, B:36:0x0123, B:39:0x012f, B:40:0x0135), top: B:8:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012f A[Catch: Exception -> 0x0149, TryCatch #2 {Exception -> 0x0149, blocks: (B:9:0x0019, B:11:0x002a, B:13:0x0038, B:16:0x0044, B:57:0x0075, B:17:0x008a, B:19:0x009d, B:23:0x00ce, B:27:0x00d9, B:29:0x00ec, B:33:0x010c, B:36:0x0123, B:39:0x012f, B:40:0x0135), top: B:8:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void updateRawData(String str, byte[] bArr) {
        int i3;
        JSONObject jSONObject;
        double d16;
        double d17;
        int length;
        int i16;
        int length2;
        int i17;
        boolean z16;
        JSONObject jSONObject2;
        if (bArr == null) {
            return;
        }
        if (logSoso == null) {
            SosoLbsInfo sosoLbsInfo = new SosoLbsInfo();
            logSoso = sosoLbsInfo;
            sosoLbsInfo.mLocation = new SosoLocation();
        }
        try {
            logSoso.rawData = bArr;
            jSONObject = new JSONObject(new String(bArr, "UTF-8"));
            try {
                jSONObject2 = jSONObject.getJSONObject("location");
                d16 = jSONObject2.getDouble("latitude");
            } catch (JSONException unused) {
                d16 = 0.0d;
            }
        } catch (Exception unused2) {
        }
        try {
            d17 = jSONObject2.getDouble("longitude");
        } catch (JSONException unused3) {
            d17 = 0.0d;
            JSONObject jSONObject3 = jSONObject.getJSONObject("attribute");
            SosoAttribute sosoAttribute = new SosoAttribute(jSONObject3.getString("imei"), jSONObject3.getString(MobileInfoUtil.IMSI), jSONObject3.getString(AppConstants.Key.PHONENUM), jSONObject3.getString("qq"), jSONObject3.getBoolean("roaming"));
            ArrayList<SosoCell> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("cells");
            length = jSONArray.length();
            while (i16 < length) {
            }
            ArrayList<SosoWifi> arrayList2 = new ArrayList<>();
            JSONArray jSONArray2 = jSONObject.getJSONArray("wifis");
            length2 = jSONArray2.length();
            while (i17 < length2) {
            }
            String str2 = "";
            str2 = jSONObject.getString("version");
            long j3 = jSONObject.getLong("source");
            if (d16 != 0.0d) {
            }
            if (d17 != 0.0d) {
            }
            SosoLbsInfo sosoLbsInfo2 = logSoso;
            sosoLbsInfo2.mAttr = sosoAttribute;
            sosoLbsInfo2.mCells = arrayList;
            sosoLbsInfo2.mWifis = arrayList2;
            sosoLbsInfo2.mSource = j3;
            sosoLbsInfo2.mVersion = str2;
            sosoLbsInfo2.provider = str;
            reqRawTime = SystemClock.elapsedRealtime();
            if (isMainProcess()) {
            }
        }
        JSONObject jSONObject32 = jSONObject.getJSONObject("attribute");
        SosoAttribute sosoAttribute2 = new SosoAttribute(jSONObject32.getString("imei"), jSONObject32.getString(MobileInfoUtil.IMSI), jSONObject32.getString(AppConstants.Key.PHONENUM), jSONObject32.getString("qq"), jSONObject32.getBoolean("roaming"));
        ArrayList<SosoCell> arrayList3 = new ArrayList<>();
        JSONArray jSONArray3 = jSONObject.getJSONArray("cells");
        length = jSONArray3.length();
        for (i16 = 0; i16 < length; i16++) {
            JSONObject jSONObject4 = jSONArray3.getJSONObject(i16);
            int i18 = jSONObject4.getInt("mcc");
            int i19 = jSONObject4.getInt("mnc");
            int i26 = jSONObject4.getInt("lac");
            int i27 = jSONObject4.getInt(c.CELLID);
            int i28 = jSONObject4.getInt("rss");
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList3.add(new SosoCell(i18, i19, i26, i27, i28, z16));
        }
        ArrayList<SosoWifi> arrayList22 = new ArrayList<>();
        JSONArray jSONArray22 = jSONObject.getJSONArray("wifis");
        length2 = jSONArray22.length();
        for (i17 = 0; i17 < length2; i17++) {
            JSONObject jSONObject5 = jSONArray22.getJSONObject(i17);
            arrayList22.add(new SosoWifi(jSONObject5.getString("mac"), jSONObject5.getInt("rssi")));
        }
        String str22 = "";
        str22 = jSONObject.getString("version");
        long j36 = jSONObject.getLong("source");
        if (d16 != 0.0d) {
            logSoso.mLocation.mLat84 = d16;
        }
        if (d17 != 0.0d) {
            logSoso.mLocation.mLon84 = d17;
        }
        SosoLbsInfo sosoLbsInfo22 = logSoso;
        sosoLbsInfo22.mAttr = sosoAttribute2;
        sosoLbsInfo22.mCells = arrayList3;
        sosoLbsInfo22.mWifis = arrayList22;
        sosoLbsInfo22.mSource = j36;
        sosoLbsInfo22.mVersion = str22;
        sosoLbsInfo22.provider = str;
        reqRawTime = SystemClock.elapsedRealtime();
        if (isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("provider", str);
            bundle.putByteArray("raw_data", bArr);
            bundle.putBoolean("req_location", false);
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SosoInterfaceModule.NAME, SosoInterfaceModule.ACTION_SET_LBS_INFO, bundle);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("update raw data, ipc result code: ");
                if (callServer == null) {
                    i3 = -1;
                } else {
                    i3 = callServer.code;
                }
                sb5.append(i3);
                QLog.i(TAG, 2, sb5.toString());
            }
        }
    }

    private static void uploadSummaryData(boolean z16, boolean z17, long j3, int i3, String str, String str2, boolean z18, int i16, boolean z19) {
        String str3;
        if (String.valueOf(str2).equals("ERROR_NETWORK") && (i3 == -4 || i3 == -17)) {
            return;
        }
        if ((!z16 && HwNetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ.getApplicationContext())) || z16) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", Integer.toString(i3));
            if (str != null && str.length() > 0) {
                hashMap.put("param_caller", str);
            }
            if (str2 != null && str2.length() > 0) {
                hashMap.put(ReportConstant.KEY_REASON, str2);
            }
            hashMap.put("param_useCache", Boolean.toString(z19));
            hashMap.put("param_askGps", Boolean.toString(z18));
            hashMap.put("param_costTime", Long.toString(j3));
            hashMap.put("param_level", String.valueOf(i16));
            String currentUin = getCurrentUin();
            if (z19) {
                if (z17) {
                    str3 = "actSosoLocationCache";
                } else {
                    str3 = "actSosoRawDataCache";
                }
            } else if (z17) {
                str3 = "actSosoLocation";
            } else {
                str3 = "actSosoRawData";
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(currentUin, str3, z16, j3, 0L, hashMap, "");
        }
    }

    public static SosoLbsInfo getRawSosoInfo(boolean z16) {
        if (logSoso == null) {
            return null;
        }
        SosoLbsInfo sosoLbsInfo = new SosoLbsInfo();
        SosoLbsInfo sosoLbsInfo2 = logSoso;
        sosoLbsInfo.rawData = sosoLbsInfo2.rawData;
        SosoLocation sosoLocation = sosoLbsInfo2.mLocation;
        if (sosoLocation != null) {
            sosoLbsInfo.mLocation = sosoLocation.clone(0, z16);
        }
        SosoAttribute sosoAttribute = logSoso.mAttr;
        if (sosoAttribute != null) {
            sosoLbsInfo.mAttr = sosoAttribute.m221clone();
        }
        ArrayList<SosoCell> arrayList = new ArrayList<>();
        ArrayList<SosoCell> arrayList2 = logSoso.mCells;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        sosoLbsInfo.mCells = arrayList;
        ArrayList<SosoWifi> arrayList3 = new ArrayList<>();
        ArrayList<SosoWifi> arrayList4 = logSoso.mWifis;
        if (arrayList4 != null) {
            arrayList3.addAll(arrayList4);
        }
        sosoLbsInfo.mWifis = arrayList3;
        SosoLbsInfo sosoLbsInfo3 = logSoso;
        sosoLbsInfo.mSource = sosoLbsInfo3.mSource;
        sosoLbsInfo.mVersion = sosoLbsInfo3.mVersion;
        sosoLbsInfo.provider = sosoLbsInfo3.provider;
        return sosoLbsInfo;
    }

    public static SosoLbsInfo getSosoInfo(int i3, boolean z16) {
        SosoLbsInfo sosoLbsInfo = logSoso;
        if (sosoLbsInfo == null || sosoLbsInfo.mLocation == null) {
            return null;
        }
        SosoLbsInfo sosoLbsInfo2 = new SosoLbsInfo();
        sosoLbsInfo2.mLocation = logSoso.mLocation.clone(i3, z16);
        return sosoLbsInfo2;
    }
}
