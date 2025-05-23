package com.tencent.mobileqq.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.mobileqq.utils.confighandler.GestureConfigHandler;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.mobileqq.utils.confighandler.QAVSoConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BusinessCommonConfig implements Manager {
    public static final String BusinessNotify_QQ_to_SubProcess = "tencent.businessnotify.qq.to.subprocess";
    public static final String BusinessNotify_SubProcess_to_QQ = "tencent.businessnotify.subprocess.to.qq";
    final String TAG;
    QQAppInterface mApp;
    GestureConfigHandler mGestureConfigHandler = null;
    QAVSoConfigHandler mQAVSoConfigHandler = null;
    ARPromotionConfigHandler.ARPromotionEntryHandler mARPromotionEntryHandler = null;
    ARPromotionConfigHandler.ARPromotionResHandler mARPromotionResHandler = null;
    QAVFunCallHandler mQAVFunCallHandler = null;
    BroadcastReceiver mBroadcastReceiver = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306892a;

        a(QQAppInterface qQAppInterface) {
            this.f306892a = qQAppInterface;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !BusinessCommonConfig.BusinessNotify_SubProcess_to_QQ.equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra("event", 0);
            QLog.w(BusinessCommonConfig.this.TAG, 1, "\u6536\u5230\u5176\u4ed6\u8fdb\u7a0b\u7684\u901a\u77e5, event[" + intExtra + "]");
            if (intExtra == 1) {
                BusinessCommonConfig.onDownloadRequest(this.f306892a, intent);
            }
        }
    }

    public BusinessCommonConfig(QQAppInterface qQAppInterface) {
        String str = "BusinessCommonConfig_" + QQAudioHelper.b();
        this.TAG = str;
        QLog.w(str, 1, "BusinessCommonConfig, mApp[" + this.mApp + "]");
        this.mApp = qQAppInterface;
        registReceiverToReceSubProcessNotify(qQAppInterface);
    }

    public static BusinessCommonConfig getInstance(AppRuntime appRuntime) {
        return (BusinessCommonConfig) appRuntime.getManager(QQManagerFactory.BUSINESS_COMMON_CONFIG_MANAGER);
    }

    public static boolean isResReady(String str, SharedPreferences sharedPreferences, String str2, String str3, String str4) {
        boolean z16 = false;
        if (sharedPreferences == null) {
            return false;
        }
        String str5 = null;
        String string = sharedPreferences.getString(str2, null);
        if (!TextUtils.isEmpty(string) && string.equals(str3)) {
            if (!FileUtils.fileExists(str4)) {
                if (QQAudioHelper.j()) {
                    str5 = HardCodeUtil.qqStr(R.string.k5j) + str4 + "]";
                }
            } else {
                z16 = true;
            }
        } else if (QQAudioHelper.j()) {
            str5 = "md5\u4e0d\u4e00\u6837\uff0csp_md5[" + string + "], configMd5[" + str3 + "]";
        }
        if (QQAudioHelper.j()) {
            QLog.w(str, 1, "isResReady, md5Key[" + str2 + "], ready[" + z16 + "], " + str5);
        }
        return z16;
    }

    public static void notifyQQDownload(int i3, String str, int i16) {
        QLog.w("BusinessCommonConfig", 1, "notifyQQDownload, bussinessType[" + i3 + "], bussinessSubName[" + str + "], itemIndxe[" + i16 + "]");
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent(BusinessNotify_SubProcess_to_QQ);
        intent.putExtra("event", 1);
        intent.putExtra("bussinessType", i3);
        intent.putExtra("bussinessSubName", str);
        intent.putExtra("download_Index", i16);
        application.sendBroadcast(intent);
    }

    public static void onDownloadRequest(QQAppInterface qQAppInterface, Intent intent) {
        int intExtra = intent.getIntExtra("bussinessType", 0);
        String stringExtra = intent.getStringExtra("bussinessSubName");
        QLog.w("BusinessCommonConfig", 1, "onDownloadRequest, bussinessType[" + intExtra + "], bussinessSubName[" + stringExtra + "], download_Index[" + intent.getIntExtra("download_Index", 0) + "]");
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra == 3) {
                    com.tencent.av.so.a.e().d(stringExtra);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.ar.ARPromotionMgr.f.a(qQAppInterface).m(qQAppInterface, stringExtra);
            return;
        }
        com.tencent.mobileqq.shortvideo.gesture.a.g();
    }

    public static void saveMd5(String str, SharedPreferences sharedPreferences, String str2, String str3) {
        if (sharedPreferences == null) {
            return;
        }
        QLog.w(str, 1, "saveMd5, ret[" + sharedPreferences.edit().putString(str2, str3).commit() + "], spMd5Key[" + str2 + "], md5[" + str3 + "]");
    }

    public static void sendConfigUpdateNotify(int i3, String str) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent(BusinessNotify_QQ_to_SubProcess);
        intent.setPackage(application.getPackageName());
        intent.putExtra("bussinessType", i3);
        intent.putExtra("event", 2);
        intent.putExtra("config_Content", str);
        application.sendBroadcast(intent);
        QLog.w("BusinessCommonConfig", 1, "sendConfigUpdateNotify, bussinessType[" + i3 + "]");
    }

    public static void sendDownloadResultNotify(int i3, String str, int i16, int i17) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent(BusinessNotify_QQ_to_SubProcess);
        intent.setPackage(application.getPackageName());
        intent.putExtra("bussinessType", i3);
        intent.putExtra("bussinessSubName", str);
        intent.putExtra("event", 1);
        intent.putExtra("download_Index", i16);
        intent.putExtra("download_Progress", i17);
        application.sendBroadcast(intent);
        QLog.w("BusinessCommonConfig", 1, "sendDownloadResultNotify, bussinessType[" + i3 + "], bussinessSubName[" + str + "], index[" + i16 + "], process[" + i17 + "]");
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0240 A[Catch: Exception -> 0x031e, TryCatch #2 {Exception -> 0x031e, blocks: (B:3:0x0015, B:9:0x0021, B:13:0x0034, B:17:0x0043, B:22:0x007c, B:48:0x00ea, B:50:0x00f6, B:52:0x0104, B:54:0x0110, B:58:0x019c, B:73:0x020a, B:75:0x0240, B:80:0x030d, B:82:0x0313, B:63:0x02fc, B:89:0x01e8, B:93:0x024c, B:94:0x0266, B:60:0x0267, B:56:0x0188, B:107:0x0122, B:113:0x014c, B:105:0x016a, B:114:0x0191, B:115:0x029d, B:116:0x02d1, B:109:0x0142, B:102:0x011a), top: B:2:0x0015, inners: #6, #7, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface qQAppInterface, int i3, Intent intent, ConfigurationService$Config configurationService$Config) {
        ConfigHandler configHandler;
        ConfigHandler configHandler2;
        T t16;
        String str;
        String stringUtf8;
        Exception exc;
        String str2;
        String str3;
        T t17;
        BusinessCommonConfig businessCommonConfig = this;
        ConfigurationService$Config configurationService$Config2 = configurationService$Config;
        try {
            configHandler = businessCommonConfig.getConfigHandler(i3);
        } catch (Exception e16) {
            e = e16;
            businessCommonConfig = this;
        }
        try {
        } catch (Exception e17) {
            e = e17;
            QLog.w(businessCommonConfig.TAG, 1, "decodeConfig, Exception", e);
            if (QQAudioHelper.f()) {
                throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.k58));
            }
            return Boolean.TRUE;
        }
        if (configHandler == null) {
            return Boolean.FALSE;
        }
        String tag = configHandler.getTag();
        if (configurationService$Config2 == null) {
            QLog.d(configHandler.getTag(), 1, "handleResp_Config, config is null");
            return Boolean.FALSE;
        }
        int configVer = configHandler.getConfigVer();
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config2.msg_content_list;
        int size = pBRepeatMessageField != null ? pBRepeatMessageField.size() : -1;
        int i16 = configurationService$Config2.version.get();
        QLog.w(tag, 1, "handleResp_Config, serverVersion[" + i16 + "], localVersion[" + configVer + "], size[" + size + "]");
        if (i16 == configVer) {
            configHandler.onGetConfigFinish(qQAppInterface, null, null);
            return Boolean.TRUE;
        }
        Class<T> configInfoClass = configHandler.getConfigInfoClass();
        if (size <= 0 && i16 != 0) {
            configHandler.saveConfig(null, i16);
            try {
                str3 = configInfoClass.getName();
                try {
                    t17 = configInfoClass.newInstance();
                    try {
                        t17.setUin(qQAppInterface.getAccount());
                        t17.serverVer = i16;
                    } catch (Exception e18) {
                        e = e18;
                        QLog.w(tag, 1, "new \u5b9e\u4f8b\u5931\u8d251, cls[" + str3 + "]", e);
                        if (QQAudioHelper.f()) {
                            throw new IllegalArgumentException(tag + "new \u5b9e\u4f8b\u5931\u8d251, cls[" + str3 + "]");
                        }
                        configHandler.onGetConfigFinish(qQAppInterface, null, t17);
                        return Boolean.TRUE;
                    }
                } catch (Exception e19) {
                    e = e19;
                    t17 = null;
                }
            } catch (Exception e26) {
                e = e26;
                str3 = null;
                t17 = null;
            }
            configHandler.onGetConfigFinish(qQAppInterface, null, t17);
            return Boolean.TRUE;
        }
        String str4 = null;
        T t18 = null;
        String str5 = null;
        int i17 = 0;
        while (true) {
            if (i17 >= size) {
                configHandler2 = configHandler;
                t16 = t18;
                str = str5;
                break;
            }
            ConfigurationService$Content configurationService$Content = configurationService$Config2.msg_content_list.get(i17);
            if (configurationService$Content != null) {
                int i18 = configurationService$Content.task_id.get();
                ByteStringMicro byteStringMicro = configurationService$Content.content.get();
                if (byteStringMicro != null) {
                    String str6 = "";
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(byteStringMicro.toByteArray());
                        if (d16 != null) {
                            try {
                                try {
                                    stringUtf8 = new String(d16, "UTF-8");
                                } catch (OutOfMemoryError e27) {
                                    e27.printStackTrace();
                                    String str7 = HardCodeUtil.qqStr(R.string.k4u) + e27.getMessage();
                                    System.gc();
                                    try {
                                        str6 = str7;
                                        stringUtf8 = new String(d16, "UTF-8");
                                    } catch (Throwable th5) {
                                        str6 = HardCodeUtil.qqStr(R.string.k4p) + th5.getMessage();
                                    }
                                }
                            } catch (UnsupportedEncodingException e28) {
                                e28.printStackTrace();
                                str6 = HardCodeUtil.qqStr(R.string.k4r) + e28.getMessage();
                            }
                        } else {
                            str6 = HardCodeUtil.qqStr(R.string.k5c);
                        }
                        stringUtf8 = null;
                    } else {
                        stringUtf8 = byteStringMicro.toStringUtf8();
                        str6 = HardCodeUtil.qqStr(R.string.k59);
                    }
                    str = stringUtf8;
                    QLog.i(tag, 1, "decodeConfig. jsonContent = " + str);
                    if (TextUtils.isEmpty(str)) {
                        configHandler2 = configHandler;
                        QLog.d(tag, 2, String.format("handleResp_Config, err, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], %s", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i16), Integer.valueOf(configVer), Integer.valueOf(size), str6));
                    } else {
                        try {
                            str4 = configInfoClass.getName();
                            t16 = configInfoClass.newInstance();
                            try {
                                t16.setUin(qQAppInterface.getAccount());
                                configHandler2 = configHandler;
                                try {
                                    t16.serverVer = i16;
                                    if (!t16.tryParse(tag, str)) {
                                        t16 = null;
                                    }
                                } catch (Exception e29) {
                                    e = e29;
                                    exc = e;
                                    str2 = str4;
                                    T t19 = t16;
                                    QLog.w(tag, 1, "new \u5b9e\u4f8b\u5931\u8d252, cls[" + str2 + "]", exc);
                                    if (!QQAudioHelper.f()) {
                                        t16 = t19;
                                        str4 = str2;
                                        QLog.w(tag, 1, "handleResp_Config, index[" + i17 + "], task_id[" + i18 + "], downloadInfo[" + t16 + "], jsonContent[" + str + "]");
                                        if (t16 != null) {
                                        }
                                        i17++;
                                        configurationService$Config2 = configurationService$Config;
                                        configHandler = configHandler2;
                                    } else {
                                        throw new IllegalArgumentException(tag + "new \u5b9e\u4f8b\u5931\u8d252, cls[" + str2 + "]");
                                    }
                                }
                            } catch (Exception e36) {
                                e = e36;
                                configHandler2 = configHandler;
                            }
                        } catch (Exception e37) {
                            configHandler2 = configHandler;
                            exc = e37;
                            str2 = str4;
                            t16 = null;
                        }
                        QLog.w(tag, 1, "handleResp_Config, index[" + i17 + "], task_id[" + i18 + "], downloadInfo[" + t16 + "], jsonContent[" + str + "]");
                        if (t16 != null) {
                            if (i18 == t16.taskId) {
                                break;
                            }
                            str5 = str;
                            t18 = t16;
                        }
                    }
                } else {
                    configHandler2 = configHandler;
                    QLog.d(tag, 1, String.format("handleResp_Config, sub_content\u4e3a\u7a7a, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i16), Integer.valueOf(configVer), Integer.valueOf(size)));
                }
            } else {
                configHandler2 = configHandler;
                QLog.d(tag, 1, String.format("handleResp_Config, content\u4e3a\u7a7a, index[%s], serverVersion[%s], localVersion[%s], size[%s]", Integer.valueOf(i17), Integer.valueOf(i16), Integer.valueOf(configVer), Integer.valueOf(size)));
            }
            i17++;
            configurationService$Config2 = configurationService$Config;
            configHandler = configHandler2;
        }
        if (!TextUtils.isEmpty(str)) {
            ConfigHandler configHandler3 = configHandler2;
            configHandler3.saveConfig(str, i16);
            configHandler3.onGetConfigFinish(qQAppInterface, str, t16);
        }
        return Boolean.TRUE;
    }

    public void doOnReconnect() {
        getConfigHandler(382).doOnReconnect(this.mApp);
    }

    public void fillConfigVersion(int i3, ConfigurationService$ConfigSeq configurationService$ConfigSeq) {
        ConfigHandler configHandler = getConfigHandler(i3);
        if (configHandler == null) {
            return;
        }
        String tag = configHandler.getTag();
        int configVer = configHandler.getConfigVer();
        if (QQAudioHelper.c(9) == 1) {
            QLog.w(tag, 1, "\u5f3a\u5236\u62c9\u53d6\u914d\u7f6e, \u539flocalVersion[" + configVer + "]");
            configHandler.saveConfig(null, 0);
            configVer = 0;
        }
        configurationService$ConfigSeq.version.set(configVer);
        configurationService$ConfigSeq.compress.set(1);
        if (QLog.isDevelopLevel()) {
            QLog.w(tag, 1, "fillVersion, configType[" + i3 + "], localVersion[" + configVer + "]");
        }
    }

    public synchronized ConfigHandler getConfigHandler(int i3) {
        if (i3 != 223) {
            if (i3 != 367) {
                if (i3 != 382) {
                    if (i3 != 364) {
                        if (i3 != 365) {
                            return null;
                        }
                        if (this.mARPromotionEntryHandler == null) {
                            QLog.w(this.TAG, 1, "ARPromotionEntryHandler, mApp[" + this.mApp + "]");
                            this.mARPromotionEntryHandler = new ARPromotionConfigHandler.ARPromotionEntryHandler(this.mApp.getAccount());
                        }
                        return this.mARPromotionEntryHandler;
                    }
                    if (this.mARPromotionResHandler == null) {
                        QLog.w(this.TAG, 1, "ARPromotionResHandler, mApp[" + this.mApp + "]");
                        this.mARPromotionResHandler = new ARPromotionConfigHandler.ARPromotionResHandler(this.mApp.getAccount());
                    }
                    return this.mARPromotionResHandler;
                }
                if (this.mQAVFunCallHandler == null) {
                    QLog.w(this.TAG, 1, "QAVFunCallHandler, mApp[" + this.mApp + "]");
                    this.mQAVFunCallHandler = new QAVFunCallHandler(this.mApp.getAccount());
                }
                return this.mQAVFunCallHandler;
            }
            if (this.mQAVSoConfigHandler == null) {
                this.mQAVSoConfigHandler = new QAVSoConfigHandler();
            }
            return this.mQAVSoConfigHandler;
        }
        if (this.mGestureConfigHandler == null) {
            this.mGestureConfigHandler = new GestureConfigHandler();
        }
        return this.mGestureConfigHandler;
    }

    public void handleResp_Config_Fail(QQAppInterface qQAppInterface, int i3, boolean z16, ConfigurationService$RespGetConfig configurationService$RespGetConfig) {
        String str;
        ConfigHandler configHandler = getConfigHandler(i3);
        if (configHandler != null) {
            str = configHandler.getTag();
        } else {
            str = "BusinessCommonConfig." + i3;
        }
        if (!z16) {
            QLog.d(str, 2, "handleResp_Config_Fail");
            return;
        }
        if (configurationService$RespGetConfig.result.get() != 0) {
            QLog.d(str, 2, "handleResp_Config_Fail, result[" + configurationService$RespGetConfig.result.get() + "]");
            return;
        }
        PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField = configurationService$RespGetConfig.config_list;
        if (pBRepeatMessageField == null || pBRepeatMessageField.size() == 0) {
            QLog.d(str, 2, "handleResp_Config_Fail, config_list is null");
        }
    }

    public void handleResp_Config_NoResp(QQAppInterface qQAppInterface, int i3) {
        String str;
        ConfigHandler configHandler = getConfigHandler(i3);
        if (QLog.isDevelopLevel()) {
            if (configHandler != null) {
                str = configHandler.getTag();
            } else {
                str = "BusinessCommonConfig." + i3;
            }
            QLog.w(str, 1, "handleResp_Config_NoResp");
        }
        if (configHandler != null) {
            configHandler.onGetConfigFinish(qQAppInterface, null, null);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.w(this.TAG, 1, "onDestroy, mBroadcastReceiver[" + this.mBroadcastReceiver + "]");
        try {
            if (this.mBroadcastReceiver != null) {
                this.mApp.getApp().unregisterReceiver(this.mBroadcastReceiver);
                this.mBroadcastReceiver = null;
            }
        } catch (IllegalArgumentException e16) {
            QLog.e(this.TAG, 1, "unregisterReceiver error: " + e16);
        }
        this.mGestureConfigHandler = null;
        this.mQAVSoConfigHandler = null;
        this.mARPromotionEntryHandler = null;
        this.mARPromotionResHandler = null;
        this.mQAVFunCallHandler = null;
    }

    boolean registReceiverToReceSubProcessNotify(QQAppInterface qQAppInterface) {
        this.mBroadcastReceiver = new a(qQAppInterface);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BusinessNotify_SubProcess_to_QQ);
        if (qQAppInterface.getApp().registerReceiver(this.mBroadcastReceiver, intentFilter) != null) {
            return true;
        }
        return false;
    }

    public <T extends ConfigInfo> Boolean decodeConfig(QQAppInterface qQAppInterface, int i3, String str) {
        ConfigHandler configHandler;
        try {
            configHandler = getConfigHandler(i3);
        } catch (Exception e16) {
            QLog.w(this.TAG, 1, "decodeConfig, Exception", e16);
            if (QQAudioHelper.f()) {
                throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.k5h));
            }
        }
        if (configHandler == null) {
            return Boolean.FALSE;
        }
        String tag = configHandler.getTag();
        T t16 = null;
        if (!TextUtils.isEmpty(str)) {
            Class<T> configInfoClass = configHandler.getConfigInfoClass();
            String name = configInfoClass.getName();
            try {
                T newInstance = configInfoClass.newInstance();
                newInstance.setUin(qQAppInterface.getAccount());
                newInstance.serverVer = QAVConfig.d(i3);
                if (newInstance.tryParse(tag, str)) {
                    t16 = newInstance;
                }
            } catch (Exception e17) {
                QLog.w(tag, 1, "new \u5b9e\u4f8b\u5931\u8d252, cls[" + name + "]", e17);
                if (QQAudioHelper.f()) {
                    throw new IllegalArgumentException(tag + "new \u5b9e\u4f8b\u5931\u8d252, cls[" + name + "]");
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.w(tag, 1, "handleResp_Config, downloadInfo[" + t16 + "], jsonContent[" + str + "]");
            }
        }
        configHandler.onGetConfigFinish(qQAppInterface, str, t16);
        return Boolean.TRUE;
    }
}
