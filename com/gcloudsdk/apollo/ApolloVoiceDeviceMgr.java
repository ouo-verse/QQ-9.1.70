package com.gcloudsdk.apollo;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.gcloudsdk.apollo.apollovoice.httpclient.AudioDeviceListener;
import com.gcloudsdk.apollo.apollovoice.httpclient.HttpsUtils;
import com.gcloudsdk.gcloud.voice.GCloudVoiceVersion;
import com.gcloudsdk.gcloud.voice.IGCloudVoiceNotify;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceDeviceMgr {
    private static final int MODE_RESET = -2;
    private static final int MODE_SET_AUTO = -1;
    private static final int MODE_SET_ONLY = -3;
    private static final int SCO_CHECK_INTERL = 2000;
    private static final int SCO_CHECK_TIME_MAX = 2;
    private static String appname = "";
    private static boolean bAudioFocus = false;
    private static boolean bFocusPause = false;
    private static boolean bGvoiceDsp = false;
    private static boolean bNeedSetFocus = true;
    private static boolean bPermissionOK = false;
    private static String checkDsp = null;
    private static String dataPath = null;
    private static Activity mActivity = null;
    private static AudioDeviceListener mAudioDeviceListener = null;
    private static AudioFocusChangeListener mAudioFocusChangeListener = null;
    private static AudioManager mAudioManager = null;
    private static int mAudioStatusEvent = 0;
    private static BluetoothAdapter mBluetoothAdapter = null;
    private static boolean mBluetoothSCO = false;
    private static boolean mBluetoothSCOEnable = false;
    private static int mBluetoothState = -100;
    private static boolean mCheckDeviceFlag = false;
    private static Context mContext = null;
    private static boolean mCurrVoipState = false;
    private static IGCloudVoiceNotify mGCloudVoiceNotify = null;
    private static BroadcastReceiver mHeadSetReceiver = null;
    private static boolean mIsBluetoothConnected = false;
    private static boolean mIsHeadsetConnected = false;
    private static boolean mIsMicOpen = false;
    private static boolean mIsMultiDeviceConnected = false;
    private static int mMode = -1;
    private static int mSCOReConnecteTimes = 0;
    private static boolean mScoThreadRunning = false;
    protected static boolean mSpeakerphoneOn = true;
    private static int maxVolCall = 0;
    private static int maxVolMusic = 0;
    private static int nGvoiceDspApiVersion = -1;
    private static int nGvoiceDspSet;
    private static int nLangType;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class AudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
        AudioFocusChangeListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            ApolloVoiceLog.LogI("mAudioStatusEvent focusChange:" + i3);
            boolean isBackground = ApolloVoiceDeviceMgr.isBackground();
            ApolloVoiceEngine.APITrace("AudioFocusChange", "focusChange:" + i3 + ",background:" + isBackground);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("is background  ");
            sb5.append(isBackground);
            ApolloVoiceLog.LogI(sb5.toString());
            if (i3 != -2 && i3 != -3) {
                if (i3 == 1 && ApolloVoiceDeviceMgr.bFocusPause) {
                    if (!ApolloVoiceDeviceMgr.isBackground()) {
                        boolean unused = ApolloVoiceDeviceMgr.bNeedSetFocus = false;
                        ApolloVoiceEngine.Resume();
                        boolean unused2 = ApolloVoiceDeviceMgr.bNeedSetFocus = true;
                    }
                    boolean unused3 = ApolloVoiceDeviceMgr.bFocusPause = false;
                    return;
                }
                return;
            }
            if (ApolloVoiceEngine.IsPause()) {
                boolean unused4 = ApolloVoiceDeviceMgr.bFocusPause = false;
            } else if (!ApolloVoiceDeviceMgr.isBackground()) {
                boolean unused5 = ApolloVoiceDeviceMgr.bNeedSetFocus = false;
                ApolloVoiceEngine.Pause();
                boolean unused6 = ApolloVoiceDeviceMgr.bFocusPause = true;
                boolean unused7 = ApolloVoiceDeviceMgr.bNeedSetFocus = true;
            }
        }
    }

    static {
        try {
            System.loadLibrary("GVoice");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("load library GVoice failed!!!");
        }
        mHeadSetReceiver = new BroadcastReceiver() { // from class: com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    String str = "";
                    if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                        if (intExtra == 2) {
                            ApolloVoiceLog.LogI("bluetooth connect ,cur state is " + intExtra);
                            if (ApolloVoiceDeviceMgr.mAudioManager.isBluetoothScoAvailableOffCall()) {
                                boolean unused2 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = true;
                                str = "bluetooth headset connect";
                                ApolloVoiceEngine.SetBluetoothState(true);
                                int unused3 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 21;
                            } else {
                                ApolloVoiceLog.LogI("bluetooth connect, isBluetoothScoAvailableOffCall is " + ApolloVoiceDeviceMgr.mAudioManager.isBluetoothScoAvailableOffCall());
                                return;
                            }
                        } else {
                            if (intExtra == 0) {
                                ApolloVoiceLog.LogI("bluetooth disconnect,cur state is " + intExtra);
                                int audioDeviceConnectionState = ApolloVoiceDeviceMgr.getAudioDeviceConnectionState();
                                if (audioDeviceConnectionState != 2 && audioDeviceConnectionState != 3) {
                                    boolean unused4 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = false;
                                    str = "bluetooth headset disconnect";
                                    ApolloVoiceEngine.SetBluetoothState(false);
                                    if (ApolloVoiceDeviceMgr.mIsHeadsetConnected) {
                                        int unused5 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 11;
                                    } else {
                                        int unused6 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 20;
                                    }
                                }
                                ApolloVoiceLog.LogI("bluetooth disconnect but still have other connections, cur state is " + audioDeviceConnectionState);
                                return;
                            }
                            if (intExtra == 1) {
                                ApolloVoiceLog.LogI("bluetoothHeadset connecting...");
                                return;
                            }
                        }
                    } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                        if (intent.hasExtra("state")) {
                            int intExtra2 = intent.getIntExtra("state", -1);
                            if (intExtra2 != 0) {
                                if (intExtra2 == 1) {
                                    ApolloVoiceLog.LogI("headset connect ,cur state is " + intExtra2);
                                    boolean unused7 = ApolloVoiceDeviceMgr.mIsHeadsetConnected = true;
                                    boolean unused8 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = false;
                                    int unused9 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 11;
                                    str = "headset connect";
                                    ApolloVoiceEngine.SetHeadSetState(true);
                                }
                            } else {
                                ApolloVoiceLog.LogI("headset disconnect ,cur state is " + intExtra2);
                                boolean unused10 = ApolloVoiceDeviceMgr.mIsHeadsetConnected = false;
                                ApolloVoiceEngine.SetHeadSetState(false);
                                if (ApolloVoiceDeviceMgr.mIsBluetoothConnected) {
                                    int unused11 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 21;
                                } else {
                                    int unused12 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 10;
                                }
                            }
                            ApolloVoiceLog.LogE("BroadcastReceiver ACTION_HEADSET_PLUG onReceive bSetValue=" + ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                        }
                    } else if (intent.getAction().equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                        int intExtra3 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                        ApolloVoiceLog.LogI("ApolloVoiceDeviceManager ::SCO cur state is " + intExtra3);
                        int unused13 = ApolloVoiceDeviceMgr.mBluetoothState = intExtra3;
                        if (intExtra3 == 1) {
                            boolean unused14 = ApolloVoiceDeviceMgr.mBluetoothSCO = true;
                            ApolloVoiceDeviceMgr.mAudioManager.setBluetoothScoOn(true);
                        } else if (intExtra3 == 0) {
                            boolean unused15 = ApolloVoiceDeviceMgr.mBluetoothSCO = false;
                            ApolloVoiceDeviceMgr.mAudioManager.setBluetoothScoOn(false);
                            ApolloVoiceDeviceMgr.ApolloVoiceDeviceSetMode(0);
                        }
                    }
                    if (ApolloVoiceDeviceMgr.mAudioStatusEvent != 0) {
                        ApolloVoiceDeviceMgr.mAudioDeviceListener.onStatus(ApolloVoiceDeviceMgr.mAudioStatusEvent, str);
                        int unused16 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 0;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        mAudioDeviceListener = new AudioDeviceListener() { // from class: com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.2
            @Override // com.gcloudsdk.apollo.apollovoice.httpclient.AudioDeviceListener
            public synchronized void onStatus(int i3, String str) {
                ApolloVoiceLog.LogI("--mAudioStatusEvent---:" + i3);
                ApolloVoiceEngine.OnEvent(i3, str);
                if (ApolloVoiceDeviceMgr.mGCloudVoiceNotify != null) {
                    ApolloVoiceDeviceMgr.mGCloudVoiceNotify.OnEvent(i3, str);
                }
            }
        };
    }

    public static void ApolloVoiceDeviceInit(Context context, Activity activity) {
        ApolloVoiceLog.LogI("GVoice Version in java code: " + GCloudVoiceVersion.Version());
        ApolloVoiceLog.LogI("ApolloVoiceDeviceInit");
        if (mContext != null) {
            return;
        }
        mContext = context;
        if (!CheckManifestPermission()) {
            ApolloVoiceLog.LogE("Check the permissions GVoice needed!");
            return;
        }
        mActivity = activity;
        NetInterfaceHelper.init(activity);
        if (!checkAudioManagerIsInit()) {
            return;
        }
        CheckSysLang();
        ApolloVoiceLog.LogI("GVOICE_DSP:getParameters begin");
        try {
            ApolloVoiceLog.LogI("GVOICE_DSP:try getParameters version 1");
            String parameters = mAudioManager.getParameters("vivo_adsp_support_gvoice");
            checkDsp = parameters;
            ApolloVoiceLog.LogI(parameters);
            if (checkDsp.equals("vivo_adsp_support_gvoice=true")) {
                ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp api(v1). NS will run on adsp");
                nGvoiceDspApiVersion = 1;
                nGvoiceDspSet = 1;
                bGvoiceDsp = true;
            } else if (checkDsp.equals("vivo_adsp_support_gvoice=false")) {
                ApolloVoiceLog.LogI("GVOICE_DSP:APP does not support gvoice dsp(v1).No gvoice module runs on adsp");
                nGvoiceDspApiVersion = 1;
                nGvoiceDspSet = 0;
                bGvoiceDsp = false;
            } else {
                ApolloVoiceLog.LogI("GVOICE_DSP:try getParameters version 2");
                String parameters2 = mAudioManager.getParameters("adsp_support_gvoice");
                checkDsp = parameters2;
                ApolloVoiceLog.LogI(parameters2);
                String str = checkDsp;
                if (str != null) {
                    if (str.equals("adsp_support_gvoice=0001")) {
                        nGvoiceDspSet = 1;
                        bGvoiceDsp = true;
                        nGvoiceDspApiVersion = 2;
                        ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                    } else if (checkDsp.equals("adsp_support_gvoice=0010")) {
                        nGvoiceDspSet = 2;
                        bGvoiceDsp = true;
                        nGvoiceDspApiVersion = 2;
                        ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                    } else if (checkDsp.equals("adsp_support_gvoice=0011")) {
                        nGvoiceDspSet = 3;
                        bGvoiceDsp = true;
                        nGvoiceDspApiVersion = 2;
                        ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                    } else {
                        ApolloVoiceLog.LogI("GVOICE_DSP:reset nGvoiceDspSet to 0,reset bGvoiceDsp to false");
                        nGvoiceDspSet = 0;
                        bGvoiceDsp = false;
                    }
                } else {
                    ApolloVoiceLog.LogE("GVOICE_DSP:getParameters(adsp_support_gvoice)  returns null");
                }
            }
            SetGVoiceDsp(false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ApolloVoiceLog.LogI("GVOICE_DSP:getParameters done");
        try {
            mAudioManager.setMode(0);
        } catch (IllegalArgumentException e17) {
            ApolloVoiceLog.LogE(e17.getMessage());
        }
        int audioDeviceConnectionState = getAudioDeviceConnectionState();
        if (audioDeviceConnectionState != 2 && audioDeviceConnectionState != 3) {
            mIsBluetoothConnected = false;
        } else {
            ApolloVoiceEngine.SetBluetoothState(true);
            mIsBluetoothConnected = true;
        }
        ApolloVoiceLog.LogI("apollovoicemanager:: getMode: " + mAudioManager.getMode());
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            if (audioDeviceConnectionState == 0) {
                try {
                    audioManager.setSpeakerphoneOn(true);
                    mSpeakerphoneOn = true;
                } catch (Exception e18) {
                    ApolloVoiceLog.LogI("Init failed!!! The exception is " + e18.toString());
                }
            }
            maxVolMusic = mAudioManager.getStreamMaxVolume(3);
            maxVolCall = mAudioManager.getStreamMaxVolume(0);
            ApolloVoiceLog.LogI("GCloudVoice::max music " + maxVolMusic + "max call =  " + maxVolCall);
        }
        registerHeadsetPlugReceiver();
        ApolloVoiceConfig.SetContext(context);
        ApolloVoiceUDID.SetContext(context);
        ApolloVoiceNetStatus.SetContext(context);
        HttpsUtils.setContext(context);
        mAudioFocusChangeListener = new AudioFocusChangeListener();
        EnableAudioFocus(true);
    }

    public static boolean ApolloVoiceDeviceSetMode(int i3) {
        ApolloVoiceLog.LogI("ApolloVoiceDeviceSetMode mode:" + i3);
        if (!checkAudioManagerIsInit()) {
            return false;
        }
        mMode = i3;
        try {
            if (mAudioManager.getMode() != i3) {
                mAudioManager.setMode(i3);
            }
            ApolloVoiceSetSpeakerOn(true);
            if (mAudioManager.getMode() != i3) {
                ApolloVoiceLog.LogI("cur mode:" + mAudioManager.getMode() + " ,want mode:" + i3);
                return false;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return true;
    }

    public static void ApolloVoiceDeviceUninit() {
        mActivity = null;
        if (mContext != null) {
            unregisterHeadsetPlugReceiver();
            mAudioManager.setMode(0);
            mAudioManager = null;
            mContext = null;
        }
    }

    public static int ApolloVoiceGetCurrMode() {
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            return audioManager.getMode();
        }
        return -2;
    }

    public static void ApolloVoiceSetSpeakerOn(boolean z16) {
        ApolloVoiceLog.LogI("apolloVoiceDevice::SetSpeakerOn is " + z16);
        if (!checkAudioManagerIsInit()) {
            return;
        }
        try {
            if (!mIsBluetoothConnected && !mIsHeadsetConnected) {
                mAudioManager.setSpeakerphoneOn(true);
            } else {
                mAudioManager.setSpeakerphoneOn(false);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        mSpeakerphoneOn = z16;
    }

    public static boolean CheckManifestPermission() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        try {
            for (String str : InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), mContext.getPackageName(), 4096).requestedPermissions) {
                if (str.equals("android.permission.MODIFY_AUDIO_SETTINGS")) {
                    ApolloVoiceLog.LogI("Check permission ok.");
                    bPermissionOK = true;
                    return true;
                }
                ApolloVoiceLog.LogE(str);
            }
            return false;
        } catch (Exception unused) {
            ApolloVoiceLog.LogE("getPackageName throw an exception!");
            return true;
        }
    }

    public static boolean CheckPermiss() {
        try {
            if (PermissionChecker.checkSelfPermission(mContext, QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            ApolloVoiceLog.LogW("CheckPermiss get an exception !");
            return false;
        }
    }

    public static int CheckSysLang() {
        try {
            Locale locale = Locale.getDefault();
            if (locale.getLanguage().equals(new Locale(OcrConfig.CHINESE).getLanguage())) {
                if (locale.getCountry().equals(LocaleManager.MOBILE_COUNTRY_CODE_CN_STR)) {
                    nLangType = 0;
                } else {
                    nLangType = 15;
                }
            } else if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
                nLangType = 1;
            } else if (locale.getLanguage().equals(new Locale(LocaleUtils.L_JAPANESE).getLanguage())) {
                nLangType = 2;
            } else if (locale.getLanguage().equals(new Locale(LocaleUtils.L_KOREAN).getLanguage())) {
                nLangType = 3;
            } else if (locale.getLanguage().equals(new Locale("de").getLanguage())) {
                nLangType = 4;
            } else if (locale.getLanguage().equals(new Locale("fr").getLanguage())) {
                nLangType = 5;
            } else if (locale.getLanguage().equals(new Locale("es").getLanguage())) {
                nLangType = 6;
            } else if (locale.getLanguage().equals(new Locale("it").getLanguage())) {
                nLangType = 7;
            } else if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
                nLangType = 8;
            } else if (locale.getLanguage().equals(new Locale("ru").getLanguage())) {
                nLangType = 9;
            } else if (locale.getLanguage().equals(new Locale("pt").getLanguage())) {
                nLangType = 10;
            } else if (locale.getLanguage().equals(new Locale("vi").getLanguage())) {
                nLangType = 11;
            } else if (locale.getLanguage().equals(new Locale("id").getLanguage())) {
                nLangType = 12;
            } else if (locale.getLanguage().equals(new Locale("ms").getLanguage())) {
                nLangType = 13;
            } else if (locale.getLanguage().equals(new Locale("th").getLanguage())) {
                nLangType = 14;
            }
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("CheckSysLang fail.\n");
            nLangType = -1;
        }
        return nLangType;
    }

    public static int EnableAudioFocus(boolean z16) {
        if (z16 == bAudioFocus) {
            return 0;
        }
        ApolloVoiceLog.LogI("EnableAudioFocus: " + z16);
        if (z16) {
            try {
                if (mAudioManager.requestAudioFocus(mAudioFocusChangeListener, 3, 1) == 1) {
                    ApolloVoiceLog.LogI("own requestAudioFocus  successfully.");
                    bAudioFocus = true;
                } else {
                    bAudioFocus = false;
                    ApolloVoiceLog.LogE("own requestAudioFocus  failed.");
                }
            } catch (Exception unused) {
                ApolloVoiceLog.LogE("requestAudioFocus exception.");
            }
        } else {
            try {
                if (mAudioManager.abandonAudioFocus(mAudioFocusChangeListener) == 1) {
                    ApolloVoiceLog.LogI("own abandonAudioFocus  successfully.");
                    bAudioFocus = false;
                } else {
                    bAudioFocus = true;
                    ApolloVoiceLog.LogE("own abandonAudioFocus  failed.");
                }
            } catch (Exception unused2) {
                ApolloVoiceLog.LogE("requestAudioFocus exception.");
            }
        }
        return 0;
    }

    public static int GetLangType() {
        return nLangType;
    }

    public static int GetSupportGVoiceDspSet() {
        ApolloVoiceLog.LogI("GVOICE_DSP:GetSupportGVoiceDspSet return nGvoiceDspSet=" + nGvoiceDspSet);
        return nGvoiceDspSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean HaveMicrophonePermission(boolean z16) {
        String str;
        int i3;
        Context context = mContext;
        if (context != null && bPermissionOK) {
            try {
                i3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), mContext.getPackageName(), 0).applicationInfo.targetSdkVersion;
            } catch (PackageManager.NameNotFoundException unused) {
                i3 = 23;
            }
            try {
                ApolloVoiceLog.LogI("targetSdkVersion = " + i3);
            } catch (PackageManager.NameNotFoundException unused2) {
                ApolloVoiceLog.LogE("Can't find package : " + mContext.getPackageName());
                if (i3 >= 23) {
                }
                ApolloVoiceLog.LogI("buildVersion = " + Build.VERSION.SDK_INT);
                if (ContextCompat.checkSelfPermission(mContext, QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
                }
            }
            if (i3 >= 23 && !CheckPermiss()) {
                ApolloVoiceLog.LogE("Don't have microphone permission");
                return false;
            }
            ApolloVoiceLog.LogI("buildVersion = " + Build.VERSION.SDK_INT);
            if (ContextCompat.checkSelfPermission(mContext, QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
                ApolloVoiceLog.LogE("Don't have microphone permission");
                if (z16) {
                    ActivityCompat.requestPermissions(mActivity, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 100);
                }
                return false;
            }
            ApolloVoiceLog.LogI("Have microphone permission");
            return true;
        }
        if (bPermissionOK) {
            str = "bPermissionOK";
        } else {
            str = "not bPermissionOK";
        }
        ApolloVoiceLog.LogE(str);
        return false;
    }

    private static boolean IsHeadSet() {
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            return audioManager.isWiredHeadsetOn();
        }
        return false;
    }

    public static boolean IsSupportGVoiceDsp() {
        return bGvoiceDsp;
    }

    public static void SetBluetoothSCOEnable(boolean z16) {
        ApolloVoiceLog.LogI("bluetoothSCOEnable:" + z16);
        if (!checkAudioManagerIsInit()) {
            return;
        }
        try {
            if (z16) {
                if (mAudioManager.isBluetoothScoAvailableOffCall()) {
                    if (ApolloVoiceGetCurrMode() != 3) {
                        ApolloVoiceDeviceSetMode(3);
                    }
                    mAudioManager.startBluetoothSco();
                    return;
                }
                return;
            }
            if (mAudioManager.isBluetoothScoOn()) {
                mAudioManager.stopBluetoothSco();
            }
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("SetBluetoothSCOEnable set fail.\n");
        }
    }

    public static void SetGVoiceDsp(boolean z16) {
        if (mAudioManager == null) {
            return;
        }
        try {
            ApolloVoiceLog.LogI("GVOICE_DSP:SetGVoiceDsp(bGvoiceDsp=" + bGvoiceDsp + ",nGvoiceDspApiVersion=" + nGvoiceDspApiVersion + ")");
            if (bGvoiceDsp) {
                if (1 == nGvoiceDspApiVersion) {
                    if (z16) {
                        ApolloVoiceLog.LogI("GVOICE_DSP:enable gvoice dsp.");
                        mAudioManager.setParameters("vivo_adsp_gvoice_mode=true");
                    } else {
                        ApolloVoiceLog.LogI("GVOICE_DSP:disable gvoice dsp.");
                        mAudioManager.setParameters("vivo_adsp_gvoice_mode=false");
                    }
                } else if (z16) {
                    ApolloVoiceLog.LogI("GVOICE_DSP:enable gvoice dsp.");
                    mAudioManager.setParameters("adsp_gvoice_mode=true");
                } else {
                    ApolloVoiceLog.LogI("GVOICE_DSP:disable gvoice dsp.");
                    mAudioManager.setParameters("adsp_gvoice_mode=false");
                }
            }
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("GVOICE_DSP:SetGVoiceDsp set fail.\n");
        }
    }

    public static void SetpreVoipMode(int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        mCurrVoipState = z16;
    }

    public static boolean checkAudioManagerIsInit() {
        if (mAudioManager != null) {
            return true;
        }
        Context context = mContext;
        if (context != null) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            mAudioManager = audioManager;
            if (audioManager != null) {
                return true;
            }
            ApolloVoiceLog.LogI("apolloVoiceDevice::get AudioManager null....\n");
            return false;
        }
        ApolloVoiceLog.LogI("apolloVoiceDevice::context is null....\n");
        return false;
    }

    public static int getAudioDeviceConnectionState() {
        int i3;
        boolean z16;
        if (!checkAudioManagerIsInit()) {
            return 0;
        }
        int i16 = 1;
        if (mAudioManager.isWiredHeadsetOn()) {
            mIsHeadsetConnected = true;
            i3 = 1;
        } else {
            mIsHeadsetConnected = false;
            i3 = 0;
        }
        int i17 = i3;
        if (mBluetoothAdapter == null) {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            int profileConnectionState = mBluetoothAdapter.getProfileConnectionState(2);
            int profileConnectionState2 = mBluetoothAdapter.getProfileConnectionState(1);
            int profileConnectionState3 = mBluetoothAdapter.getProfileConnectionState(3);
            if (profileConnectionState2 == 2) {
                z16 = true;
                i17 = 2;
            } else {
                z16 = false;
            }
            if (i3 != 0 && z16) {
                mIsMultiDeviceConnected = true;
                boolean z17 = mIsHeadsetConnected;
                if (z17 && !mIsBluetoothConnected) {
                    ApolloVoiceLog.LogW("getHeadsetDeviceStatus: wiredheadset actually!");
                } else if (!z17 && mIsBluetoothConnected) {
                    ApolloVoiceLog.LogW("getHeadsetDeviceStatus: bluetooth actually!");
                    i16 = 2;
                } else {
                    i16 = 3;
                }
            } else {
                mIsMultiDeviceConnected = false;
                i16 = i17;
            }
            ApolloVoiceLog.LogI("getHeadsetDeviceStatus state:" + i16 + " a2dp:" + profileConnectionState + " headset:" + profileConnectionState2 + " health:" + profileConnectionState3 + " mIsHeadsetConnected:" + mIsHeadsetConnected + " mIsBluetoothConnected:" + mIsBluetoothConnected);
            return i16;
        }
        return i17;
    }

    public static boolean hasRecordPermission() {
        AudioRecord audioRecord;
        byte[] bArr = new byte[512];
        AudioRecord audioRecord2 = null;
        try {
            try {
                audioRecord = new AudioRecord(0, 44100, 16, 2, AudioRecord.getMinBufferSize(44100, 16, 2));
            } catch (IllegalArgumentException unused) {
                ApolloVoiceLog.LogW("IllegalArgumentException when create AudioRecord");
                return false;
            }
        } catch (IllegalStateException unused2) {
        }
        try {
            AudioMonitor.startRecording(audioRecord);
            if (audioRecord.getRecordingState() != 3) {
                ApolloVoiceLog.LogI("startRecording but not in recording state");
                audioRecord.stop();
                audioRecord.release();
                return false;
            }
            int read = audioRecord.read(bArr, 0, 512);
            ApolloVoiceLog.LogI("hasRecordPermission is recording readsize " + read);
            if (read < 0) {
                audioRecord.stop();
                audioRecord.release();
                return false;
            }
            audioRecord.stop();
            audioRecord.release();
            return true;
        } catch (IllegalStateException unused3) {
            audioRecord2 = audioRecord;
            ApolloVoiceLog.LogE("IllegalStateException when startRecording, which maybe do not have RECORD_AUDIO permission in actual");
            if (audioRecord2 != null) {
                audioRecord2.release();
            }
            return false;
        }
    }

    public static boolean isBackground() {
        ApolloVoiceLog.LogI("is background call.\n");
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            int i3 = runningAppProcessInfo.importance;
            if (i3 == 100 || i3 == 200) {
                ApolloVoiceLog.LogI("is not background .\n");
                return false;
            }
            return true;
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("getMyMemoryState fail.\n");
            return true;
        }
    }

    private static boolean isEnableFocus() {
        ApolloVoiceLog.LogI("Need EnableAudioFocus: " + bNeedSetFocus);
        return bNeedSetFocus;
    }

    private static void registerHeadsetPlugReceiver() {
        if (mContext == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            if ("EVA-AL00".equals(ApolloVoiceUDID.Model()) || "Nexus 6P".equals(ApolloVoiceUDID.Model())) {
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            }
            mContext.registerReceiver(mHeadSetReceiver, intentFilter);
        } catch (Exception e16) {
            ApolloVoiceLog.LogI("Registe headset failed!!! The exception is " + e16.toString());
        }
    }

    public static void setGCloudVoiceNotify(IGCloudVoiceNotify iGCloudVoiceNotify) {
        mGCloudVoiceNotify = iGCloudVoiceNotify;
    }

    private static void unregisterHeadsetPlugReceiver() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(mHeadSetReceiver);
        } catch (Exception e16) {
            ApolloVoiceLog.LogI("Registe headset failed!!! The exception is " + e16.toString());
        }
    }
}
