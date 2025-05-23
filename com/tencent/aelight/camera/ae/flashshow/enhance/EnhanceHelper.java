package com.tencent.aelight.camera.ae.flashshow.enhance;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.flashshow.enhance.SEVideoEnhanceConfig;
import com.tencent.aelight.camera.ae.flashshow.util.r;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import u53.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EnhanceHelper {
    private static final String DOWNLOAD_PATH_ONLINE = b.f438374e + File.separator + QQWinkConstants.HDR_CONFIG_DOWNLOAD_JSON_NAME;
    private static final String LOCAL_ENHANCE_CONFIG_JSON_NAME = "enhanceDownload.json";
    private static final int MUSIC_DOWNLOAD_TIMEOUT = 30000;
    public static String TAG = "EnhanceHelper";
    private static EnhanceHelper instance;
    private SEVideoEnhanceConfig mAssetConfig;
    private SEVideoEnhanceConfig mConfig;
    private String mLastUrl = "";
    private boolean alreadyUpdate = false;

    EnhanceHelper() {
    }

    private void downloadEnhanceConfig(String str, String str2) {
        ms.a.f(TAG, "downloadEnhanceConfig");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str2;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.aelight.camera.ae.flashshow.enhance.EnhanceHelper.2
            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(NetResp netResp) {
                boolean z16 = netResp != null && netResp.mResult == 0;
                ms.a.f(EnhanceHelper.TAG, "download :" + z16);
                if (z16) {
                    EnhanceHelper.this.loadLocalConfigJson();
                }
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            }
        };
        try {
            ((IHttpEngineService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c(TAG, "[downloadEnhance], error=" + e16);
        }
    }

    private EnhanceConfig getDefaultConfig() {
        return new EnhanceConfig(0, 0, 0, 0, 50, 58, 5.0f, new ArrayList());
    }

    public static synchronized EnhanceHelper getInstance() {
        EnhanceHelper enhanceHelper;
        synchronized (EnhanceHelper.class) {
            if (instance == null) {
                instance = new EnhanceHelper();
            }
            enhanceHelper = instance;
        }
        return enhanceHelper;
    }

    private String getJson(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            bufferedReader.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    private boolean isNeedDownLoad(String str) {
        return !this.mLastUrl.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$findSuitableConfig$0(EnhanceConfig.SharpenStrength sharpenStrength, EnhanceConfig.SharpenStrength sharpenStrength2) {
        return sharpenStrength.getSeq() - sharpenStrength2.getSeq();
    }

    private void loadConfigFromAsset() {
        if (this.mAssetConfig != null) {
            return;
        }
        String json = getJson(BaseApplication.context, LOCAL_ENHANCE_CONFIG_JSON_NAME);
        ms.a.a(TAG, "loadConfigFromAsset json" + json);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        this.mAssetConfig = (SEVideoEnhanceConfig) new Gson().fromJson(json, SEVideoEnhanceConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLocalConfigJson() {
        String str = DOWNLOAD_PATH_ONLINE;
        if (FileUtils.fileExists(str)) {
            String z16 = QIMPtvTemplateManager.z(new File(str));
            if (TextUtils.isEmpty(z16)) {
                loadConfigFromAsset();
                return;
            }
            this.mConfig = (SEVideoEnhanceConfig) new Gson().fromJson(z16, SEVideoEnhanceConfig.class);
        }
        loadConfigFromAsset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnhanceConfig() {
        if (this.alreadyUpdate) {
            ms.a.f(TAG, "alreadyUpdate :" + this.alreadyUpdate);
            return;
        }
        String winkEnhanceConfig = QzoneConfig.getWinkEnhanceConfig();
        ms.a.a(TAG, "enhance config url: " + winkEnhanceConfig);
        if (isNeedDownLoad(winkEnhanceConfig)) {
            q.d(DOWNLOAD_PATH_ONLINE);
            downloadEnhanceConfig(winkEnhanceConfig, b.f438374e + File.separator + QQWinkConstants.HDR_CONFIG_DOWNLOAD_JSON_NAME);
        }
        this.mLastUrl = winkEnhanceConfig;
        loadLocalConfigJson();
        this.alreadyUpdate = true;
    }

    public EnhanceConfig getEnhanceConfig() {
        String model = DeviceInfoMonitor.getModel();
        int a16 = r.a();
        ms.a.a(TAG, "device config :" + model + " level :" + a16);
        if (this.mConfig != null) {
            ms.a.f(TAG, "config from download ");
            return findSuitableConfig(model, a16, this.mConfig);
        }
        if (this.mAssetConfig != null) {
            ms.a.f(TAG, "config from asset ");
            return findSuitableConfig(model, a16, this.mAssetConfig);
        }
        return getDefaultConfig();
    }

    public void updateEnhanceConfigInSubThread() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.enhance.EnhanceHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f(EnhanceHelper.TAG, "updateEnhanceConfig");
                EnhanceHelper.getInstance().updateEnhanceConfig();
            }
        }, 16, null, false);
    }

    private EnhanceConfig findSuitableConfig(String str, int i3, SEVideoEnhanceConfig sEVideoEnhanceConfig) {
        List<EnhanceConfig.SharpenStrength> list = sEVideoEnhanceConfig.sharpenStrengths;
        if (list != null) {
            try {
                Collections.sort(list, new Comparator() { // from class: com.tencent.aelight.camera.ae.flashshow.enhance.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int lambda$findSuitableConfig$0;
                        lambda$findSuitableConfig$0 = EnhanceHelper.lambda$findSuitableConfig$0((EnhanceConfig.SharpenStrength) obj, (EnhanceConfig.SharpenStrength) obj2);
                        return lambda$findSuitableConfig$0;
                    }
                });
            } catch (ConcurrentModificationException unused) {
                ms.a.c(TAG, "findSuitableConfig sort error");
                return getDefaultConfig();
            }
        }
        List<SEVideoEnhanceConfig.Devices> list2 = sEVideoEnhanceConfig.devices;
        if (list2 != null) {
            for (SEVideoEnhanceConfig.Devices devices : list2) {
                if (devices != null && str.equals(devices.deviceModel)) {
                    ms.a.a(TAG, "config from devices ");
                    ms.a.f(TAG, "return suitable :enable hdr : " + devices.enableDelogo + " delogo: " + devices.enableDelogo + " maxDuration: " + devices.extraMaxDuration + ", enableHDR: " + devices.enableHDR + ", type:" + devices.hdrType);
                    return new EnhanceConfig(devices.enableHDR, devices.hdrType, devices.enableDelogo, devices.extraMaxDuration, sEVideoEnhanceConfig.maxDelogoFrameRate, sEVideoEnhanceConfig.deblurAverageScore, sEVideoEnhanceConfig.blurBias, sEVideoEnhanceConfig.sharpenStrengths);
                }
            }
        }
        List<SEVideoEnhanceConfig.Levels> list3 = sEVideoEnhanceConfig.levels;
        if (list3 != null) {
            for (SEVideoEnhanceConfig.Levels levels : list3) {
                if (levels.deviceLevel == i3) {
                    ms.a.a(TAG, "config from levels ");
                    ms.a.f(TAG, "return suitable :enable hdr : " + levels.enableDelogo + " delogo: " + levels.enableDelogo + " maxDuration: " + levels.extraMaxDuration + ", level:" + i3 + "enableHDR: " + levels.enableHDR + ", type:" + levels.hdrType);
                    return new EnhanceConfig(levels.enableHDR, levels.hdrType, levels.enableDelogo, levels.extraMaxDuration, sEVideoEnhanceConfig.maxDelogoFrameRate, sEVideoEnhanceConfig.deblurAverageScore, sEVideoEnhanceConfig.blurBias, sEVideoEnhanceConfig.sharpenStrengths);
                }
            }
        }
        return getDefaultConfig();
    }
}
