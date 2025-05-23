package com.tencent.av.utils.api.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.so.ResInfo;
import com.tencent.av.utils.api.IAudioHelperApi;
import com.tencent.av.utils.aw;
import com.tencent.av.utils.b;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqaudio.audioplayer.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.util.AudioHelperUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AudioHelperApiImpl implements IAudioHelperApi {
    static final String ACTION_DEBUG = "tencent.video.q2v.debug";
    private static final String CLASS_NAME_APPOPSMANAGER = "AppOpsManager";
    private static final long DEFAULT_AMPLITUDE = 2000;
    static final String EFFECT_FACE_EXPRESSION = "actAVFunChatExpression";
    private static final int MODE_ALLOWED = 0;
    private static final int OP_CEMARE_BEFORE_MEIZU_API19 = 35;
    private static final int OP_CEMARE_IN_ANDROID_SDK_API19 = 26;
    private static final int OP_RECORD_AUDIO_BEFORE_MEIZU_API19 = 36;
    private static final int OP_RECORD_AUDIO_IN_ANDROID_SDK_API19 = 27;
    private static final String TAG = "AudioHelper";
    static final String _debug_Event_index = "_debug_Event_index";
    static final String _debug_Event_value = "_debug_Event_value";
    private static boolean checkSegmentGreenLocalList = false;
    static final int index_max = 39;
    private static boolean isInSegmentGreenLocalList = false;
    private static boolean soLoaded = false;
    private static int tryLoadCount = 0;
    static final int value_unInit = -1000;
    private static final int[] OP_IN_ANDROID_SDK_BEFORE_API19 = {35, 36};
    private static final int[] OP_IN_ANDROID_SDK_API19 = {26, 27};
    static final int[] _debugValue = new int[39];
    private long mUin = 0;
    public boolean mEnablePrefTime = true;
    boolean enablePrintTime = false;
    String mDeviceDetailInfo = null;

    private boolean isLenovoA750() {
        return DeviceInfoMonitor.getModel().contains("Lenovo A750");
    }

    private boolean isOPPOX907() {
        return Build.MANUFACTURER.equalsIgnoreCase("OPPO") && DeviceInfoMonitor.getModel().contains("X907");
    }

    private boolean isRubbishMeizuPhone() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(Build.MANUFACTURER);
    }

    private boolean isRubbishXiaomiPhone() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void changButtonStyle(Resources resources, TextView textView, boolean z16, int i3) {
        if (z16) {
            changButtonStyle(resources, textView, i3, R.color.f157512rm, R.color.f157513rn);
        } else {
            changButtonStyle(resources, textView, i3, R.color.f157481qm, R.color.f157482qn);
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void changViewStyle(View view, boolean z16, int i3) {
        if (z16) {
            changViewStyle(view, i3, R.color.f157512rm);
        } else {
            changViewStyle(view, i3, R.color.f157481qm);
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public long elapsedRealtimeNanos() {
        if (this.mEnablePrefTime) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return 0L;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public synchronized long enlargeVolumWrapper(Context context, byte[] bArr, int i3, float f16) {
        int i16;
        if (!soLoaded && (i16 = tryLoadCount) < 3) {
            tryLoadCount = i16 + 1;
            soLoaded = SoLoadUtilNew.loadSoByName(context, "audiohelper");
        }
        if (soLoaded) {
            return AudioHelper.enlargeVolum(bArr, i3, f16);
        }
        return 2000L;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public synchronized long genDebugSeq() {
        return AudioHelperUtil.genDebugSeq();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public int getDebugValue(int i3) {
        if (!e.f77109a) {
            return -1;
        }
        int[] iArr = _debugValue;
        if (iArr[i3] == -1000) {
            if (this.mUin == 0) {
                QLog.w(TAG, 1, "getDebugValue, uin is empty, [" + i3 + "]");
                return -1;
            }
            iArr[i3] = BaseApplication.getContext().getSharedPreferences("debugconfig_" + this.mUin, 4).getInt("debugvalue" + i3, -1);
            QLog.w(TAG, 1, "getDebugValue, [" + i3 + "]=[" + iArr[i3] + "], mUin[" + this.mUin + "]");
        }
        return iArr[i3];
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public String getLogString(Object obj) {
        if (!isDev()) {
            if (obj == null) {
                return "null.";
            }
            if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return "*";
                }
                return "**";
            }
            return "***";
        }
        int i3 = 0;
        String str = "";
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i3 < length) {
                str = (str + strArr[i3]) + "|";
                i3++;
            }
            return str;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length2 = iArr.length;
            while (i3 < length2) {
                str = (str + iArr[i3]) + "|";
                i3++;
            }
            return str;
        }
        return "" + obj;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public String getResIDName(Resources resources, int i3) {
        String name;
        try {
            name = resources.getResourceEntryName(i3);
        } catch (Exception e16) {
            name = e16.getClass().getName();
        }
        return "[" + i3 + "][" + name + "]";
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public long getServerMSTime() {
        if (useLocalTime()) {
            return System.currentTimeMillis();
        }
        return com.tencent.mobileqq.service.message.e.K0() * 1000;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void initDebugValue() {
        if (!e.f77109a) {
            e.f77109a = isDev();
        }
        if (e.f77109a) {
            for (int i3 = 0; i3 < 39; i3++) {
                getDebugValue(i3);
            }
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isAccelerateSensorInsensitive() {
        return isOPPOX907() || isLenovoA750();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isBluetoothHeadsetA2dpOn() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled() && BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(2) == 2;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isBluetoothHeadsetOn(Context context) {
        if (isBluetoothHeadsetA2dpOn()) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.d("AudioPlayer", 2, "isBluetoothHeadsetOn(), isBluetoothA2dpOn = true");
            return true;
        }
        return isBluetoothScoOn(context);
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isBluetoothHeadsetScoOn(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isBluetoothScoOn();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isBluetoothScoOn(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        boolean isBluetoothScoOn = audioManager.isBluetoothScoOn();
        boolean h16 = c.h(audioManager);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "isBluetoothScoOn(), isSCOOn = " + isBluetoothScoOn + " | isNeedWaitOpenSCO = " + h16);
        }
        return isBluetoothScoOn || h16;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isBluetoothSupportA2dp(BluetoothDevice bluetoothDevice) {
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids == null) {
            return false;
        }
        ParcelUuid[] parcelUuidArr = {ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB"), ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB")};
        HashSet hashSet = new HashSet(Arrays.asList(uuids));
        for (int i3 = 0; i3 < 2; i3++) {
            if (hashSet.contains(parcelUuidArr[i3])) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isDev() {
        return AudioHelperUtil.isDev();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isForbidByRubbishMeizu(int i3) {
        return isForbidByRubbishMeizu(i3, BaseApplication.getContext());
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isForbidByRubbishXiaomi(int i3) {
        Object systemService;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "SDK_INT: " + Build.VERSION.SDK_INT + " Man: " + Build.MANUFACTURER);
        }
        if (isRubbishXiaomiPhone() && (systemService = BaseApplication.getContext().getSystemService("appops")) != null && systemService.getClass().getSimpleName().equals("AppOpsManager")) {
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                int i16 = OP_IN_ANDROID_SDK_API19[i3];
                ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
                int intValue = ((Integer) method.invoke(systemService, Integer.valueOf(i16), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(AudioHelperApiImpl.class.getSimpleName(), 2, "isForbidByRubbishXiaomi(), result = " + intValue);
                }
                return intValue != 0;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(AudioHelperApiImpl.class.getSimpleName(), 2, e16.toString());
                }
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isHuaweiGreen() {
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT;
        String d06 = ea.d0(BaseApplication.getContext());
        if (StringUtil.isEmpty(d06)) {
            d06 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isHuaweiGreen greenList: " + d06 + ", feature :" + str);
        }
        String[] split = d06.split("\\|");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (str2 != null && str2.equals(str)) {
                    if (!QLog.isColorLevel()) {
                        return true;
                    }
                    QLog.d(TAG, 2, "isHuaweiGreen true: " + str);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isHuaweiGreenForSegment() {
        if (!((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSegmentMediaCodecEncodeSwtichOpen()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isHuaweiGreenForSegment true");
            }
            return true;
        }
        if (checkSegmentGreenLocalList) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isHuaweiGreenForSegmentLocal " + isInSegmentGreenLocalList);
            }
            return isInSegmentGreenLocalList;
        }
        checkSegmentGreenLocalList = true;
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT;
        String[] split = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (str2 != null && str2.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "isHuaweiGreenForSegment true: " + str);
                    }
                    isInSegmentGreenLocalList = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isLogColorOrGary() {
        return AudioHelperUtil.isLogColorOrGary();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void print(String str, Intent intent) {
        if (intent != null) {
            print(str, intent.getExtras(), false);
            return;
        }
        QLog.w(TAG, 1, ("MapValue[" + str + "]:\n") + "intent\u4e3a\u7a7a");
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public String printBaseInfo(AppInterface appInterface) {
        return printBaseInfo(appInterface, -1);
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void printTime(String str) {
        if (this.mEnablePrefTime && this.enablePrintTime) {
            QLog.w(TAG, 1, "printTime[" + str + "], time[" + SystemClock.elapsedRealtimeNanos() + "]");
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean registDebugReceiver(BaseApplication baseApplication, long j3) {
        if (!e.f77109a) {
            e.f77109a = isDev();
        }
        setCurAccount(j3);
        if (baseApplication == null) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DEBUG);
        return baseApplication.registerReceiver(new a(baseApplication), intentFilter) != null;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void reportExp(String str, boolean z16) {
        String str2;
        HashMap hashMap = new HashMap();
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        hashMap.put("expID", str);
        hashMap.put("action", str2);
        UserAction.onUserAction(EFFECT_FACE_EXPRESSION, true, -1L, -1L, hashMap, true);
        if (getDebugValue(2) == 1) {
            QLog.d(EFFECT_FACE_EXPRESSION, 4, String.format("expID[%s], action[%s]", str, str2));
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void saveAudioPlayerParam(int i3, int i16, int i17, boolean z16) {
        String str = "!@$#_" + i3 + "_";
        PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putInt(str + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, i16).putInt(str + ReportConstant.COSTREPORT_PREFIX, i17).putBoolean(str + ResInfo.RES_TYPE_SO, z16).commit();
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void sendValueChanged(BaseApplication baseApplication, int i3) {
        Intent intent = new Intent(ACTION_DEBUG);
        intent.putExtra(_debug_Event_index, i3);
        intent.putExtra(_debug_Event_value, _debugValue[i3]);
        intent.setPackage(baseApplication.getPackageName());
        baseApplication.sendBroadcast(intent);
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void setBeaconDebug(Context context) {
        if (!e.f77109a) {
            e.f77109a = isDev();
        }
        if (getDebugValue(2) == 1) {
            QLog.d(TAG, 1, "setBeaconDebug begin");
            UserAction.setLogAble(!AppSetting.u(), true);
            if (context != null) {
                try {
                    UserAction.initUserAction(context);
                } catch (BeaconInitException e16) {
                    QLog.e(TAG, 1, "[initUserAction] error, ", e16);
                }
            }
            UserAction.setLogAble(!AppSetting.u(), true);
            QLog.d(TAG, 1, "setBeaconDebug end");
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void setCurAccount(long j3) {
        if (this.mUin != j3) {
            this.mUin = j3;
            for (int i3 = 0; i3 < 39; i3++) {
                _debugValue[i3] = -1000;
            }
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void setDebugValue(int i3, int i16) {
        int[] iArr = _debugValue;
        iArr[i3] = i16;
        BaseApplication.getContext().getSharedPreferences("debugconfig_" + this.mUin, 4).edit().putInt("debugvalue" + i3, i16).commit();
        QLog.w(TAG, 1, "setDebugValue, [" + i3 + "]=[" + iArr[i3] + "]");
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void showDebugToast(final String str) {
        if (isDev()) {
            QLog.w(TAG, 1, "showDebugToast, text[" + str + "]");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.utils.api.impl.AudioHelperApiImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast makeText = QQToast.makeText(BaseApplication.getContext(), "de:" + str, 1);
                    makeText.setAutoTextSize();
                    makeText.show();
                }
            });
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public long stringToLong(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void syncPrintBaseInfo(final AppInterface appInterface) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.av.utils.api.impl.AudioHelperApiImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AudioHelperApiImpl.this.isDev();
                AudioHelperApiImpl.this.printBaseInfo(appInterface, -1);
            }
        });
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public final void writeTestLog(String str) {
        QLog.w("\u6d4b\u8bd5\u5f00\u5173", 1, str);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseApplication f77001a;

        a(BaseApplication baseApplication) {
            this.f77001a = baseApplication;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !AudioHelperApiImpl.ACTION_DEBUG.equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra(AudioHelperApiImpl._debug_Event_index, -1);
            int intExtra2 = intent.getIntExtra(AudioHelperApiImpl._debug_Event_value, -1);
            if (intExtra >= 0 && intExtra < 39) {
                AudioHelperApiImpl._debugValue[intExtra] = intExtra2;
                QLog.w(AudioHelperApiImpl.TAG, 1, "ReceiverDebugValue, [" + intExtra + "]=[" + intExtra2 + "]");
            }
            if (intExtra == 2) {
                AudioHelperApiImpl.this.setBeaconDebug(this.f77001a.getApplicationContext());
            }
        }
    }

    static {
        for (int i3 = 0; i3 < 39; i3++) {
            _debugValue[i3] = -1000;
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public String printBaseInfo(AppInterface appInterface, int i3) {
        long l3;
        if (appInterface == null) {
            QLog.d(TAG, 1, "BaseInfo, AppInterface is empty");
            return "BaseInfo, AppInterface is empty";
        }
        try {
            if (this.mDeviceDetailInfo == null) {
                if (appInterface instanceof VideoAppInterface) {
                    l3 = AVCoreSystemInfo.getMaxCpuFreq();
                } else {
                    l3 = ah.l();
                }
                this.mDeviceDetailInfo = "BaseInfo, APPID[" + AppSetting.f() + "], \nisPublicVersion[true], \nisGrayVersion[false], \nisDebugVersion[false], \nquaMainVersion[" + AppSetting.f99558r + "], \nversionCode[" + com.tencent.mobileqq.cooperation.a.a(appInterface.getApp()) + "], \nrevision[" + AppSetting.l() + "], \nisSupporImmersive[" + ImmersiveUtils.isSupporImmersive() + "], \nStatusBarHeight[" + ImmersiveUtils.getStatusBarHeight(appInterface.getApp()) + "], \nhasSmartBar[" + ba.hasSmartBar() + "], \naboutSubVersionLog[" + AppSetting.c() + "], \ngetQUA[" + getLogString(AppSetting.k()) + "], \nTYPE[" + Build.TYPE + "], \nTAGS[" + Build.TAGS + "], \nMANUFACTURER[" + Build.MANUFACTURER + "], \nPRODUCT[" + Build.PRODUCT + "], \nRELEASE[" + Build.VERSION.RELEASE + "], \nDISPLAY[" + Build.DISPLAY + "], \nCODENAME[" + Build.VERSION.CODENAME + "], \nINCREMENTAL[" + Build.VERSION.INCREMENTAL + "], \nBRAND[" + Build.BRAND + "], \nMODEL[" + DeviceInfoMonitor.getModel() + "], \nCPU_ABI[" + Build.CPU_ABI + "], \nCPU_ABI2[" + Build.CPU_ABI2 + "], \nCPU[" + Build.HARDWARE + "], \nCPUModel[" + AVCoreSystemInfo.getCpuModel() + "], \nisExistSDCard[" + cu.e() + "], \nsdkVersion[" + Build.VERSION.SDK_INT + "], \ndevicesInfo[" + m.b() + "], \nVendorId[" + AVCoreSystemInfo.getVendorId() + "], \nIsMarvell[" + AVCoreSystemInfo.getIsMarvell() + "], \nOpenGLVersion[" + AVCoreSystemInfo.getOpenGLVersion() + "], \nGLVersion[" + tv.c.c(appInterface.getApp()) + "], \ncupReport[" + AVCoreSystemInfo.getCpuReport() + "], \nFeature[" + AVCoreSystemInfo.getFeature() + "], \nMaxCpuFreq[" + l3 + "], \nSystemTotalMemory[" + m.c() + "], \nCpuNum[" + ah.n() + "], \nuid[" + appInterface.getApp().getApplicationInfo().uid + "], \nPermission_PackageName[" + appInterface.getApp().getPackageName() + "], \n";
            }
            DisplayMetrics displayMetrics = appInterface.getApp().getResources().getDisplayMetrics();
            String str = this.mDeviceDetailInfo + "UIN[" + LogUtil.getSafePrintUin(appInterface.getAccount()) + "], \ndisplayMetrics[" + displayMetrics + "], \ndensity[" + displayMetrics.density + "], \ndensityDpi[" + displayMetrics.densityDpi + "], \nlogLevel[" + QLog.getUIN_REPORTLOG_LEVEL() + "], \nisDevelopLevel[" + QLog.isDevelopLevel() + "], \nisColorLevel[" + QLog.isColorLevel() + "], \nsProcessId[" + MobileQQ.sProcessId + "], \nprocessName[" + MobileQQ.processName + "], \nUIThread[" + ThreadManager.getUIHandler().getLooper().getThread().getId() + "], \nCurThread[" + Thread.currentThread().getId() + "], \nisTestEnvironment[" + i3 + "], \ntid[" + Process.myTid() + "], \nmyPid[" + Process.myPid() + "], \nmyUid[" + Process.myUid() + "]";
            QLog.d(TAG, 1, str);
            return str;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "printBaseInfo, Exception", e16);
            return e16.getMessage();
        }
    }

    private void changViewStyle(View view, int i3, int i16) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "changButtonStyle button is null");
            }
        } else if (i3 != 0) {
            aw.c(view, i3, i16);
        }
    }

    private boolean useLocalTime() {
        if (getDebugValue(15) != 1) {
            return false;
        }
        writeTestLog(HardCodeUtil.qqStr(R.string.jsl));
        return true;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void changButtonStyle(Resources resources, TextView textView, int i3, int i16, int i17) {
        if (textView == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "changButtonStyle button is null");
                return;
            }
            return;
        }
        if (i3 != 0) {
            Drawable drawable = resources.getDrawable(i3);
            aw a16 = aw.a(resources, i3, i16);
            a16.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, a16, null, null);
        }
        if (i17 != 0) {
            textView.setTextColor(b.a(resources, i17));
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public boolean isForbidByRubbishMeizu(int i3, Context context) {
        Object systemService;
        if (isRubbishMeizuPhone() && (systemService = context.getSystemService("appops")) != null && systemService.getClass().getSimpleName().equals("AppOpsManager")) {
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                int i16 = OP_IN_ANDROID_SDK_API19[i3];
                ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
                int intValue = ((Integer) method.invoke(systemService, Integer.valueOf(i16), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(AudioHelperApiImpl.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + intValue);
                }
                return intValue != 0;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(AudioHelperApiImpl.class.getSimpleName(), 2, e16.toString());
                }
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public String getResIDName(View view, int i3) {
        String name;
        try {
            name = view.getResources().getResourceEntryName(i3);
        } catch (Exception e16) {
            name = e16.getClass().getName();
        }
        return "[" + i3 + "][" + name + "]";
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void print(String str, Bundle bundle) {
        print(str, bundle, false);
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public <T1, T2> void print(String str, Map<T1, T2> map, boolean z16) {
        if (z16 || QLog.isDevelopLevel()) {
            String str2 = "MapValue[" + str + "]:\n";
            try {
                if (map != null) {
                    for (T1 t16 : map.keySet()) {
                        T2 t26 = map.get(t16);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append("    [");
                        sb5.append(t16);
                        sb5.append("]=[");
                        sb5.append("" + t26);
                        sb5.append("], [");
                        sb5.append(t26 == null ? null : t26.getClass().getSimpleName());
                        sb5.append("]\n");
                        str2 = sb5.toString();
                    }
                } else {
                    str2 = str2 + "bundle\u4e3a\u7a7a";
                }
                QLog.w(TAG, 1, str2);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(TAG, 1, "log", e16);
                }
            }
        }
    }

    @Override // com.tencent.av.utils.api.IAudioHelperApi
    public void print(String str, Bundle bundle, boolean z16) {
        String str2;
        if (z16 || QLog.isDevelopLevel()) {
            String str3 = "BundleValue[" + str + "]:\n";
            try {
                if (bundle != null) {
                    for (String str4 : bundle.keySet()) {
                        Object obj = bundle.get(str4);
                        String str5 = null;
                        if (obj == null || !(obj instanceof long[])) {
                            str2 = null;
                        } else {
                            long[] jArr = (long[]) obj;
                            str2 = "" + jArr.length;
                            for (int i3 = 0; i3 < jArr.length && i3 < 5; i3++) {
                                str2 = str2 + "[" + jArr[i3] + "]";
                            }
                        }
                        if (str2 == null) {
                            str2 = "" + obj;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str3);
                        sb5.append("    [");
                        sb5.append(str4);
                        sb5.append("]=[");
                        sb5.append(str2);
                        sb5.append("], [");
                        if (obj != null) {
                            str5 = obj.getClass().getSimpleName();
                        }
                        sb5.append(str5);
                        sb5.append("]\n");
                        str3 = sb5.toString();
                    }
                } else {
                    str3 = str3 + "bundle\u4e3a\u7a7a";
                }
                QLog.w(TAG, 1, str3);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(TAG, 1, "log", e16);
                }
            }
        }
    }
}
