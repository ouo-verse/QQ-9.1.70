package com.tencent.av.so;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.af;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResMgr {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f74624d = {"so_and_ai_model_res", "qav_rtc_sdk_so", "qav_rtc_sdk_trae_so", "qav_rtc_sdk_audio_penguins_codec"};

    /* renamed from: e, reason: collision with root package name */
    private static volatile ResMgr f74625e;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<b> f74626a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ResInfo> f74627b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f74628c;

    /* compiled from: P */
    /* renamed from: com.tencent.av.so.ResMgr$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ResMgr.q().B(ResInfo.RES_ID_AV_AI_NS_MEDIALAB_MODEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                if ("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY".equals(action)) {
                    int intExtra = intent.getIntExtra("ACTION_FIELD_DOWNLOAD_STATE", 0);
                    int intExtra2 = intent.getIntExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", 0);
                    String stringExtra = intent.getStringExtra("ACTION_FIELD_RES_MD5");
                    if (intExtra == 2) {
                        ArrayList arrayList = new ArrayList();
                        synchronized (ResMgr.this.f74626a) {
                            arrayList.addAll(ResMgr.this.f74626a);
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).a(intExtra2, stringExtra);
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    synchronized (ResMgr.this.f74626a) {
                        arrayList2.addAll(ResMgr.this.f74626a);
                    }
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        ((b) it5.next()).b(intExtra, stringExtra);
                    }
                    return;
                }
                if ("ACTION_QAV_RES_NEW_CONFIG_NOTIFY".equals(action)) {
                    QLog.i("AVResMgr", 1, "new config has been downloaded.");
                    synchronized (ResMgr.this.f74628c) {
                        if (ResMgr.this.f74627b != null) {
                            ResMgr.this.f74627b.clear();
                        }
                        ArrayList<ResInfo> y16 = ResMgr.y(true);
                        if (y16 != null) {
                            ResMgr.this.f74627b = y16;
                            for (int i3 = 0; i3 < ResMgr.this.f74627b.size(); i3++) {
                                QLog.i("AVResMgr", 1, "new config. ResInfoList. i: " + i3 + ", ResInfo: " + ResMgr.this.f74627b.get(i3));
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i3, String str);

        void b(int i3, String str);
    }

    ResMgr() {
        boolean z16;
        this.f74627b = new ArrayList<>();
        Object obj = new Object();
        this.f74628c = obj;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        QLog.i("AVResMgr", 1, "ResMgr for " + mobileQQ.getQQProcessName());
        J(mobileQQ);
        synchronized (obj) {
            ArrayList<ResInfo> y16 = y(true);
            this.f74627b = y16;
            if (y16 == null) {
                this.f74627b = new ArrayList<>();
            }
            for (int i3 = 0; i3 < ResInfo.ALL_RES_ID_LIST.length; i3++) {
                if (this.f74627b.size() > 0) {
                    for (int i16 = 0; i16 < this.f74627b.size(); i16++) {
                        if (ResInfo.ALL_RES_ID_LIST[i3].equalsIgnoreCase(this.f74627b.get(i16).resId)) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AVResMgr", 1, "init. delete local old res. resId = " + ResInfo.ALL_RES_ID_LIST[i3]);
                    }
                    f(v(ResInfo.ALL_RES_ID_LIST[i3]), "");
                }
            }
            for (int i17 = 0; i17 < this.f74627b.size(); i17++) {
                QLog.i("AVResMgr", 1, "init. ResInfoList. i: " + i17 + ", ResInfo: " + this.f74627b.get(i17));
            }
        }
    }

    public static String A() {
        return new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("qav_rtc_sdk_video_config", new byte[0]), StandardCharsets.UTF_8);
    }

    public static void C() {
        String t16 = q().t(ResInfo.RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL);
        if (TextUtils.isEmpty(t16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAINSGruModelFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "gru_16k.bin");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAINSGruModelFinish failed. calc modelFileMd5 failed.");
            return;
        }
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        edit.putString("audioAINSGruModelFileMd5", fileMD5String);
        edit.putString("audioAINSGruModelDir", t16);
        edit.commit();
        QLog.i("AVResMgr", 1, "onDownloadAVAINSGruModelFinish. modelFileMd5 = " + fileMD5String + ", resDir = " + t16);
    }

    public static void D() {
        String t16 = q().t(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL);
        if (TextUtils.isEmpty(t16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "penguins_encoder.bin");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish failed. calc modelEncoderBinMd5 failed.");
            return;
        }
        String fileMD5String2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "penguins_encoder.json.en");
        if (TextUtils.isEmpty(fileMD5String2)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish failed. calc modelEncoderJsonEnMd5 failed.");
            return;
        }
        String fileMD5String3 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "penguins_decoder.bin");
        if (TextUtils.isEmpty(fileMD5String3)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish failed. calc modelDecoderBinMd5 failed.");
            return;
        }
        String fileMD5String4 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "penguins_decoder.json.en");
        if (TextUtils.isEmpty(fileMD5String4)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish failed. calc modelDecoderJsonEnMd5 failed.");
            return;
        }
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_ENCODER_BIN", fileMD5String);
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_ENCODER_JSON_EN", fileMD5String2);
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DECODER_BIN", fileMD5String3);
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DECODER_JSON_EN", fileMD5String4);
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DIR", t16);
        QLog.i("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecModelFinish. modelEncoderBinMd5 = " + fileMD5String + ", modelEncoderJsonEnMd5 = " + fileMD5String2 + ", modelDecoderBinMd5 = " + fileMD5String3 + ", modelDecoderJsonEnMd5 = " + fileMD5String4 + ", resDir = " + t16);
    }

    public static void E() {
        String t16 = q().t(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_SO);
        if (TextUtils.isEmpty(t16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecSoFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "libPenguins.so");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecSoFinish failed. calc soMd5 failed.");
            return;
        }
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_SO", fileMD5String);
        vu.a.c().n("SP_KEY_AV_AUDIO_PENGUINS_CODEC_SO_DIR", t16);
        QLog.i("AVResMgr", 1, "onDownloadAVAudioPenguinsCodecSoFinish. soMd5 = " + fileMD5String + ", resDir = " + t16);
    }

    public static void F() {
        String t16 = q().t(ResInfo.RES_ID_AV_QQ_AUDIO_AI_NS_MODEL);
        if (TextUtils.isEmpty(t16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "model_1.tnnmodel");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish failed. calc model1Md5 failed.");
            return;
        }
        String fileMD5String2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "model_2.tnnmodel");
        if (TextUtils.isEmpty(fileMD5String2)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish failed. calc model2Md5 failed.");
            return;
        }
        String fileMD5String3 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "model_1.tnnproto");
        if (TextUtils.isEmpty(fileMD5String3)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish failed. calc param1Md5 failed.");
            return;
        }
        String fileMD5String4 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "model_2.tnnproto");
        if (TextUtils.isEmpty(fileMD5String4)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish failed. calc param2Md5 failed.");
            return;
        }
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        edit.putString("qqAudioAINSModel1Md5", fileMD5String);
        edit.putString("qqAudioAINSModel2Md5", fileMD5String2);
        edit.putString("qqAudioAINSParam1Md5", fileMD5String3);
        edit.putString("qqAudioAINSParam2Md5", fileMD5String4);
        edit.putString("qqAudioAINSModelDir", t16);
        edit.commit();
        QLog.i("AVResMgr", 1, "onDownloadAVQQAudioAINSModelFinish. model1Md5 = " + fileMD5String + ", model2Md5 = " + fileMD5String2 + ", param1Md5 = " + fileMD5String3 + ", param2Md5 = " + fileMD5String4 + ", resDir = " + t16);
    }

    public static void G() {
        String t16 = q().t(ResInfo.RES_ID_AV_QQ_AUDIO_AI_SO);
        if (TextUtils.isEmpty(t16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAISoFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(t16 + "libaudio_ai.so");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVQQAudioAISoFinish failed. calc soFileMd5 failed.");
            return;
        }
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        edit.putString("qqAudioAISoFileMd5", fileMD5String);
        edit.putString("qqAudioAISoDir", t16);
        edit.commit();
        QLog.i("AVResMgr", 1, "onDownloadAVQQAudioAISoFinish. soFileMd5 = " + fileMD5String + ", resDir = " + t16);
    }

    public static void H() {
        ResInfo w3 = q().w(ResInfo.RES_ID_AV_TRAE_SO);
        if (w3 == null) {
            QLog.e("AVResMgr", 1, "onDownloadAVTraeSoFinish failed. resInfo == null.");
            return;
        }
        String s16 = s(w3);
        if (TextUtils.isEmpty(s16)) {
            QLog.e("AVResMgr", 1, "onDownloadAVTraeSoFinish failed. resDir is empty.");
            return;
        }
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(s16 + "libtraeimp-qq.so");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadAVTraeSoFinish failed. calc soFileMd5 failed.");
            return;
        }
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        edit.putString("AVTraeSoFileMd5", fileMD5String);
        edit.putString("AVTraeSoDir", s16);
        edit.putString("AVTraeSoVersion", w3.resVersion);
        edit.commit();
        QLog.i("AVResMgr", 1, "onDownloadAVTraeSoFinish. soFileMd5 = " + fileMD5String + ", resDir = " + s16 + ", resVersion = " + w3.resVersion);
    }

    public static void I() {
        ResInfo w3 = q().w(ResInfo.RES_ID_QAV_RTC_SDK_SO);
        if (w3 == null) {
            QLog.e("AVResMgr", 1, "onDownloadQAVRTCSDKSoFinish failed. resInfo == null.");
            return;
        }
        String s16 = s(w3);
        if (TextUtils.isEmpty(s16)) {
            QLog.e("AVResMgr", 1, "onDownloadQAVRTCSDKSoFinish failed. resDir is empty.");
            return;
        }
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(s16 + "libqav_rtc_sdk.so");
        if (TextUtils.isEmpty(fileMD5String)) {
            QLog.e("AVResMgr", 1, "onDownloadQAVRTCSDKSoFinish failed. calc soFileMd5 failed. so = libqav_rtc_sdk.so");
            return;
        }
        edit.putString("libqav_rtc_sdk.soQAVRTCSDKSoFileMd5", fileMD5String);
        edit.putString("QAVRTCSDKSoDir", s16);
        edit.putString("QAVRTCSDKSoVersion", w3.resVersion);
        edit.commit();
        File file = new File(s16 + AVSoUtils.s("qav_rtc_sdk"));
        if (file.exists()) {
            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.getContext(), file);
        }
        QLog.i("AVResMgr", 1, "onDownloadQAVRTCSDKSoFinish. resDir = " + s16 + ", resVersion = " + w3.resVersion);
    }

    private boolean J(MobileQQ mobileQQ) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
        intentFilter.addAction("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
        if (mobileQQ.registerReceiver(new a(), intentFilter) != null) {
            return true;
        }
        return false;
    }

    public static void K(String str) {
        QLog.i("AVResMgr", 1, "saveNewConfig.");
        SharedPreferences.Editor edit = af.d(367, af.f76962q).edit();
        edit.putString("SP_KEY_CONFIG_367", str);
        edit.commit();
    }

    public static boolean d(String str, String str2) {
        if (new File(str).exists()) {
            if (str2.equalsIgnoreCase(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(str))) {
                return true;
            }
            QLog.e("AVResMgr", 1, "checkFileValid failed. check md5 failed. fileName = " + str + ", md5FromConfig = " + str2);
            return false;
        }
        QLog.e("AVResMgr", 1, "checkFileValid failed. file is not exist. fileName = " + str + ", md5FromConfig = " + str2);
        return false;
    }

    @VisibleForTesting
    public static boolean e(InputStream inputStream, OutputStream outputStream) {
        boolean z16;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                z16 = false;
            }
        }
        z16 = true;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                return false;
            }
        }
        return z16;
    }

    public static boolean f(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.endsWith(File.separator)) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return g(str, str2);
    }

    private static boolean g(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("AVResMgr", 1, "deleteDir. dir = " + str + ", excludeSubDirOrFile = " + str2);
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z16 = false;
        for (File file : listFiles) {
            if (!file.getAbsolutePath().equalsIgnoreCase(str2)) {
                if (file.isDirectory()) {
                    z16 = g(file.getAbsolutePath(), str2);
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AVResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + file.getAbsolutePath());
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("AVResMgr", 1, "deleteDir. delete dir or file = " + file.getAbsolutePath());
                        }
                        file.delete();
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("AVResMgr", 1, "deleteDir. delete dir or file = " + file.getAbsolutePath());
                    }
                    file.delete();
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("AVResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + file.getAbsolutePath());
            }
            z16 = true;
        }
        return z16;
    }

    public static String h() {
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("audioAINSGruModelFileMd5", "");
        String string2 = d16.getString("audioAINSGruModelDir", "");
        String str = string2 + "gru_16k.bin";
        if (d(str, string)) {
            QLog.i("AVResMgr", 1, "getAVAINSGruModelDir sucessfully. modelDir = " + string2);
            return string2;
        }
        QLog.e("AVResMgr", 1, "getAVAINSGruModelDir failed. checkFileValid failed. modelFilename=" + str);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.so.ResMgr.3
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL);
            }
        });
        return "";
    }

    public static String i() {
        String i3 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DIR");
        String str = i3 + "penguins_encoder.bin";
        String str2 = i3 + "penguins_encoder.json.en";
        String str3 = i3 + "penguins_decoder.bin";
        String str4 = i3 + "penguins_decoder.json.en";
        String i16 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_ENCODER_BIN");
        String i17 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_ENCODER_JSON_EN");
        String i18 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DECODER_BIN");
        String i19 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_MODEL_DECODER_JSON_EN");
        if (d(str, i16) && d(str2, i17) && d(str3, i18) && d(str4, i19)) {
            QLog.i("AVResMgr", 1, "getAVAudioPenguinsCodecModelDir sucessfully. modelDir = " + i3);
            return i3;
        }
        QLog.e("AVResMgr", 1, "getAVAudioPenguinsCodecModelDir failed. checkFileValid failed.");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.so.ResMgr.11
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL);
            }
        });
        return "";
    }

    public static String j() {
        String i3 = vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_SO_DIR");
        if (d(i3 + "libPenguins.so", vu.a.c().i("SP_KEY_AV_AUDIO_PENGUINS_CODEC_SO"))) {
            QLog.i("AVResMgr", 1, "getAVAudioPenguinsCodecSolDir sucessfully. soDir = " + i3);
            return i3;
        }
        QLog.e("AVResMgr", 1, "getAVAudioPenguinsCodecSolDir failed. checkFileValid failed.");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.so.ResMgr.10
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_SO);
            }
        });
        return "";
    }

    public static String k() {
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("qqAudioAINSModel1Md5", "");
        String string2 = d16.getString("qqAudioAINSModel2Md5", "");
        String string3 = d16.getString("qqAudioAINSParam1Md5", "");
        String string4 = d16.getString("qqAudioAINSParam2Md5", "");
        String string5 = d16.getString("qqAudioAINSModelDir", "");
        String str = string5 + "model_2.tnnmodel";
        String str2 = string5 + "model_1.tnnproto";
        String str3 = string5 + "model_2.tnnproto";
        if (d(string5 + "model_1.tnnmodel", string) && d(str, string2) && d(str2, string3) && d(str3, string4)) {
            QLog.i("AVResMgr", 1, "getAVQQAudioAINSModelDir sucessfully. modelDir = " + string5);
            return string5;
        }
        QLog.e("AVResMgr", 1, "getAVQQAudioAINSModelDir failed. checkFileValid failed.");
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.av.so.ResMgr.4
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_QQ_AUDIO_AI_NS_MODEL);
            }
        });
        return "";
    }

    public static String l() {
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("qqAudioAISoFileMd5", "");
        String string2 = d16.getString("qqAudioAISoDir", "");
        String str = string2 + "libaudio_ai.so";
        if (d(str, string)) {
            QLog.i("AVResMgr", 1, "getAVQQAudioAISoDir sucessfully. modelDir = " + string2);
            return string2;
        }
        QLog.e("AVResMgr", 1, "getAVQQAudioAISoDir failed. checkFileValid failed. soFilename = " + str);
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.av.so.ResMgr.5
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_QQ_AUDIO_AI_SO);
            }
        });
        return "";
    }

    public static String m() {
        ResInfo w3 = q().w(ResInfo.RES_ID_AV_TRAE_SO);
        if (w3 == null) {
            QLog.e("AVResMgr", 1, "getAVTraeSoDir failed. resInfo == null.");
            return "";
        }
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("AVTraeSoFileMd5", "");
        String string2 = d16.getString("AVTraeSoDir", "");
        String str = string2 + "libtraeimp-qq.so";
        String string3 = d16.getString("AVTraeSoVersion", "");
        if (w3.resVersion.equalsIgnoreCase(string3) && w3.resMd5.equalsIgnoreCase(string)) {
            if (d(str, string)) {
                QLog.i("AVResMgr", 1, "getAVTraeSoDir sucessfully. soDir = " + string2);
                return string2;
            }
            QLog.e("AVResMgr", 1, "getAVTraeSoDir failed. checkFileValid failed.");
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.so.ResMgr.7
                @Override // java.lang.Runnable
                public void run() {
                    ResMgr.q().B(ResInfo.RES_ID_AV_TRAE_SO);
                }
            });
            return "";
        }
        QLog.e("AVResMgr", 1, "getAVTraeSoDir failed, version or md5 don't match, config verison[" + w3.resVersion + "], sp version[" + string3 + "], resMd5FromConfig[" + w3.resMd5 + "], soFileMd5FromStorage[" + string + "]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.so.ResMgr.6
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_AV_TRAE_SO);
            }
        }, 128, null, true);
        return "";
    }

    public static String n() {
        FileOutputStream fileOutputStream;
        InputStream open;
        String str = BaseApplication.getContext().getFilesDir().getParent() + "/txlib/3ALicense/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + "medialab_audio_3a_license.txt";
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("audio3ALicenseFileMd5", "");
        if (d(str2, string)) {
            QLog.i("AVResMgr", 1, "getAudio3ALicenseFilename successfully. licenseFullFilename = " + str2 + ", licenseFileMd5FromStorage = " + string);
            return str2;
        }
        InputStream inputStream = null;
        try {
            open = BaseApplication.getContext().getAssets().open("medialab_audio_3a_license.txt");
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Exception e17) {
            e = e17;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            String fileMD5String = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(str2);
            if (TextUtils.isEmpty(fileMD5String)) {
                QLog.e("AVResMgr", 1, "getAudio3ALicenseFilename failed. calc md5 failed.");
                e(open, fileOutputStream);
                return "";
            }
            SharedPreferences.Editor edit = d16.edit();
            edit.putString("audio3ALicenseFileMd5", fileMD5String);
            edit.commit();
            QLog.i("AVResMgr", 1, "getAudio3ALicenseFilename successfully. licenseFullFilename = " + str2 + ", licenseFileMd5FromCalc = " + fileMD5String);
            e(open, fileOutputStream);
            return str2;
        } catch (Exception e18) {
            e = e18;
            inputStream = open;
            try {
                QLog.e("AVResMgr", 1, "getAudio3ALicenseFilename failed. decompress failed. error msg = " + e.getMessage());
                e(inputStream, fileOutputStream);
                return "";
            } catch (Throwable th7) {
                th = th7;
                e(inputStream, fileOutputStream);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = open;
            e(inputStream, fileOutputStream);
            throw th;
        }
    }

    public static String o() {
        return new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("qav_rtc_sdk_audio_config", new byte[0]), StandardCharsets.UTF_8);
    }

    public static String p() {
        return new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("qav_rtc_sdk_common_config", new byte[0]), StandardCharsets.UTF_8);
    }

    public static ResMgr q() {
        if (f74625e == null) {
            synchronized (ResMgr.class) {
                if (f74625e == null) {
                    f74625e = new ResMgr();
                }
            }
        }
        return f74625e;
    }

    public static String r() {
        ResInfo w3 = q().w(ResInfo.RES_ID_QAV_RTC_SDK_SO);
        if (w3 == null) {
            QLog.e("AVResMgr", 1, "getQAVRTCSDKSoDir failed. resInfo == null.");
            return "";
        }
        SharedPreferences d16 = af.d(367, af.f76962q);
        String string = d16.getString("libqav_rtc_sdk.soQAVRTCSDKSoFileMd5", "");
        String string2 = d16.getString("QAVRTCSDKSoDir", "");
        String string3 = d16.getString("QAVRTCSDKSoVersion", "");
        if (w3.resVersion.equalsIgnoreCase(string3) && w3.resMd5.equalsIgnoreCase(string)) {
            if (!d(string2 + "libqav_rtc_sdk.so", string)) {
                QLog.e("AVResMgr", 1, "getQAVRTCSDKSoDir failed. checkFileValid failed. so = libqav_rtc_sdk.so");
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.so.ResMgr.9
                    @Override // java.lang.Runnable
                    public void run() {
                        ResMgr.q().B(ResInfo.RES_ID_QAV_RTC_SDK_SO);
                    }
                });
                return "";
            }
            QLog.i("AVResMgr", 1, "getQAVRTCSDKSoDir sucessfully. soDir = " + string2);
            return string2;
        }
        QLog.e("AVResMgr", 1, "getQAVRTCSDKSoDir failed, version don't match, config verison[" + w3.resVersion + "], sp version[" + string3 + "], resMd5FromConfig[" + w3.resMd5 + "], soFileMd5FromStorage[" + string + "]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.so.ResMgr.8
            @Override // java.lang.Runnable
            public void run() {
                ResMgr.q().B(ResInfo.RES_ID_QAV_RTC_SDK_SO);
            }
        }, 128, null, true);
        return "";
    }

    public static String s(ResInfo resInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AVSoUtils.y());
        sb5.append("qavRes");
        String str = File.separator;
        sb5.append(str);
        sb5.append(resInfo.resType);
        sb5.append(str);
        sb5.append(resInfo.resId);
        sb5.append(str);
        sb5.append(resInfo.resVersion);
        sb5.append(str);
        sb5.append(resInfo.resMd5);
        sb5.append(str);
        return sb5.toString();
    }

    public static String u(ResInfo resInfo) {
        if (resInfo == null) {
            QLog.e("AVResMgr", 1, "getResIdRootDir failed. resInfo == null.");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AVSoUtils.y());
        sb5.append("qavRes");
        String str = File.separator;
        sb5.append(str);
        sb5.append(resInfo.resType);
        sb5.append(str);
        sb5.append(resInfo.resId);
        sb5.append(str);
        return sb5.toString();
    }

    public static String v(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("AVResMgr", 1, "getResIdRootDir failed. resId is empty.");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AVSoUtils.y());
        sb5.append("qavRes");
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(ResInfo.getResType(str));
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        return sb5.toString();
    }

    private static ArrayList<ResInfo> x(String str, boolean z16) {
        try {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList<>();
            }
            return ResInfo.parseConfig(new JSONObject(str));
        } catch (Exception e16) {
            QLog.e("AVResMgr", 1, "updateResInfoList failed. exception = " + e16);
            return new ArrayList<>();
        }
    }

    public static ArrayList<ResInfo> y(boolean z16) {
        ArrayList<ResInfo> x16 = x(af.d(367, af.f76962q).getString("SP_KEY_CONFIG_367", ""), z16);
        int i3 = 0;
        while (true) {
            String[] strArr = f74624d;
            if (i3 < strArr.length) {
                ArrayList<ResInfo> x17 = x(new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(strArr[i3], new byte[0]), StandardCharsets.UTF_8), z16);
                for (int i16 = 0; i16 < x17.size(); i16++) {
                    int i17 = 0;
                    while (true) {
                        if (i17 >= x16.size()) {
                            break;
                        }
                        if (x16.get(i17).resId.equalsIgnoreCase(x17.get(i16).resId)) {
                            x16.remove(i17);
                            break;
                        }
                        i17++;
                    }
                }
                x16.addAll(x17);
                i3++;
            } else {
                return x16;
            }
        }
    }

    public static String z(ResInfo resInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AVSoUtils.y());
        sb5.append("qavRes");
        String str = File.separator;
        sb5.append(str);
        sb5.append(resInfo.resType);
        sb5.append(str);
        sb5.append(resInfo.resId);
        sb5.append(str);
        sb5.append(resInfo.resVersion);
        sb5.append(str);
        return sb5.toString();
    }

    public boolean B(String str) {
        ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).notifyQQDownload(str);
        return true;
    }

    public String t(String str) {
        ResInfo w3 = w(str);
        if (w3 == null) {
            QLog.e("AVResMgr", 1, "getResDirByResId failed. resInfo == null.");
            return "";
        }
        return s(w3);
    }

    public ResInfo w(String str) {
        synchronized (this.f74628c) {
            if (this.f74627b == null) {
                return null;
            }
            for (int i3 = 0; i3 < this.f74627b.size(); i3++) {
                if (this.f74627b.get(i3).resId.equalsIgnoreCase(str)) {
                    return this.f74627b.get(i3);
                }
            }
            return null;
        }
    }
}
