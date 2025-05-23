package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.impl.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes16.dex */
public class PreloadFlowControlConfig implements Serializable {
    public static final String CONFIG_NAME = "flow_config";

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, PreloadFlowControlConfig> f279014d = new HashMap();
    private static final long serialVersionUID = 1;
    private String mConfigPath;
    public int mDownloadStatus = -1;
    public long mNextCanReqTime;
    public long mNextRetryReqTime;
    public int mRetryDownloadTimes;
    public int mRetryReqTimes;
    public long mValidDownloadTime;

    public PreloadFlowControlConfig(String str) {
        this.mConfigPath = str;
    }

    public static String getConfigPath(String str) {
        return com.tencent.mobileqq.qwallet.preload.a.d() + str + CONFIG_NAME;
    }

    public static synchronized PreloadFlowControlConfig getFlowControlConfig(String str) {
        synchronized (PreloadFlowControlConfig.class) {
            String str2 = str + com.tencent.mobileqq.base.a.c();
            PreloadFlowControlConfig preloadFlowControlConfig = f279014d.get(str2);
            if (preloadFlowControlConfig != null) {
                return preloadFlowControlConfig;
            }
            String configPath = getConfigPath(str);
            try {
                preloadFlowControlConfig = (PreloadFlowControlConfig) d.v(configPath);
            } catch (Exception unused) {
            }
            if (preloadFlowControlConfig == null) {
                preloadFlowControlConfig = new PreloadFlowControlConfig(configPath);
            }
            f279014d.put(str2, preloadFlowControlConfig);
            return preloadFlowControlConfig;
        }
    }

    public void saveConfig() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadFlowControlConfig.1
            @Override // java.lang.Runnable
            public void run() {
                PreloadFlowControlConfig preloadFlowControlConfig = PreloadFlowControlConfig.this;
                d.x(preloadFlowControlConfig, preloadFlowControlConfig.mConfigPath);
            }
        });
    }
}
