package com.tencent.mobileqq.mini.entry;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniAppPrePullManager {
    private static final long DEFAULT_INTERVAL_TIME = 7200000;
    private static final long INTERVAL_TIME;
    private static final String QQ_PROCESS_NAME = "com.tencent.mobileqq";
    private static final String TAG = "MiniAppPrePullManager";
    private static boolean enablePrePull;
    private static volatile MiniAppPrePullManager instance;
    private static Runnable loadDataFromDBRunnable;
    private static final Object mLock;
    private static HashMap<String, MiniAppInfoPrePullWrapper> prePullAppInfoMapForId;
    private static HashMap<String, MiniAppInfoPrePullWrapper> prePullAppInfoMapForLink;

    /* loaded from: classes33.dex */
    public static class MiniAppInfoPrePullWrapper {
        public String appId;
        public String entryPath;
        public String link;
        public long pullTimeStamp;

        public String getAppId() {
            return this.appId;
        }

        public String getEntryPath() {
            return this.entryPath;
        }

        public String getLink() {
            return this.link;
        }

        public long getPullTimeStamp() {
            return this.pullTimeStamp;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setEntryPath(String str) {
            this.entryPath = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setPullTimeStamp(long j3) {
            this.pullTimeStamp = j3;
        }
    }

    static {
        enablePrePull = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_PRELOAD_SWITCHER, 1) == 1;
        INTERVAL_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_PRELOAD_INTERVAL_TIME, 7200000L);
        prePullAppInfoMapForId = new HashMap<>();
        prePullAppInfoMapForLink = new HashMap<>();
        mLock = new Object();
        loadDataFromDBRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MiniAppPrePullManager.enablePrePull) {
                    QLog.e(MiniAppPrePullManager.TAG, 1, "prePullAppinfo switcher is off!");
                    return;
                }
                QLog.d(MiniAppPrePullManager.TAG, 1, "initLocalPrePullDataRunnable start running");
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppPrePullManager.TAG, 1, "initLocalPrePullDataRunnable, app is null.");
                    return;
                }
                try {
                    MiniAppEntityManager miniAppEntityManager = (MiniAppEntityManager) appInterface.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                    if (miniAppEntityManager != null) {
                        List<? extends Entity> queryEntity = miniAppEntityManager.queryEntity(MiniAppByLinkEntity.class, false, null, null, null, null, null, null);
                        List<? extends Entity> queryEntity2 = miniAppEntityManager.queryEntity(MiniAppByIdEntity.class, false, null, null, null, null, null, null);
                        synchronized (MiniAppPrePullManager.mLock) {
                            if (queryEntity != null) {
                                try {
                                    if (queryEntity.size() > 0) {
                                        Iterator<? extends Entity> it = queryEntity.iterator();
                                        while (it.hasNext()) {
                                            MiniAppByLinkEntity miniAppByLinkEntity = (MiniAppByLinkEntity) it.next();
                                            if (miniAppByLinkEntity != null) {
                                                MiniAppInfoPrePullWrapper miniAppInfoPrePullWrapper = new MiniAppInfoPrePullWrapper();
                                                miniAppInfoPrePullWrapper.setAppId(miniAppByLinkEntity.appId);
                                                miniAppInfoPrePullWrapper.setLink(miniAppByLinkEntity.link);
                                                miniAppInfoPrePullWrapper.setPullTimeStamp(miniAppByLinkEntity.timeStamp);
                                                MiniAppPrePullManager.prePullAppInfoMapForLink.put(miniAppByLinkEntity.appId, miniAppInfoPrePullWrapper);
                                            }
                                        }
                                    }
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                            }
                            if (queryEntity2 != null && queryEntity2.size() > 0) {
                                Iterator<? extends Entity> it5 = queryEntity2.iterator();
                                while (it5.hasNext()) {
                                    MiniAppByIdEntity miniAppByIdEntity = (MiniAppByIdEntity) it5.next();
                                    if (miniAppByIdEntity != null) {
                                        MiniAppInfoPrePullWrapper miniAppInfoPrePullWrapper2 = new MiniAppInfoPrePullWrapper();
                                        miniAppInfoPrePullWrapper2.setAppId(miniAppByIdEntity.appId);
                                        miniAppInfoPrePullWrapper2.setEntryPath(miniAppByIdEntity.entryPath);
                                        miniAppInfoPrePullWrapper2.setPullTimeStamp(miniAppByIdEntity.timeStamp);
                                        MiniAppPrePullManager.prePullAppInfoMapForId.put(miniAppByIdEntity.appId, miniAppInfoPrePullWrapper2);
                                    }
                                }
                            }
                        }
                        QLog.d(MiniAppPrePullManager.TAG, 1, "loadDataFromDBRunnable done");
                    }
                } catch (Throwable th6) {
                    QLog.e(MiniAppPrePullManager.TAG, 1, "loadDataFromDBRunnable throw a Throwable", th6);
                }
            }
        };
    }

    public MiniAppPrePullManager() {
        ThreadManagerV2.excute(loadDataFromDBRunnable, 32, null, true);
    }

    public static MiniAppPrePullManager getInstance() {
        if (instance == null) {
            synchronized (MiniAppPrePullManager.class) {
                if (instance == null) {
                    instance = new MiniAppPrePullManager();
                }
            }
        }
        return instance;
    }

    private MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperById(String str, String str2) {
        MiniAppInfoPrePullWrapper miniAppInfoPrePullWrapper;
        HashMap<String, MiniAppInfoPrePullWrapper> hashMap = prePullAppInfoMapForId;
        if (hashMap == null || (miniAppInfoPrePullWrapper = hashMap.get(str)) == null) {
            return null;
        }
        if (str2 == null) {
            if (miniAppInfoPrePullWrapper.getEntryPath() == null) {
                return miniAppInfoPrePullWrapper;
            }
            return null;
        }
        if (str2.equals(miniAppInfoPrePullWrapper.getEntryPath())) {
            return miniAppInfoPrePullWrapper;
        }
        return null;
    }

    private MiniAppInfoPrePullWrapper getPrePullAppInfoWrapperByLink(String str) {
        HashMap<String, MiniAppInfoPrePullWrapper> hashMap = prePullAppInfoMapForLink;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void prePullAppinfoById(String str, String str2, IPrePullListener iPrePullListener) {
        prePullAppinfoById(str, str2, "release", iPrePullListener);
    }

    public void prePullAppinfoByLink(String str, boolean z16, IPrePullListener iPrePullListener) {
        if (str != null && str.startsWith("mqqapi://miniapp/")) {
            prePullAppinfoByLink(str, 2, z16, iPrePullListener);
            return;
        }
        if (str != null && str.contains("fakeUrl")) {
            prePullAppinfoByLink(str, 0, z16, iPrePullListener);
        } else if (str != null) {
            prePullAppinfoByLink(str, 1, z16, iPrePullListener);
        }
    }

    public void prePullAppinfoById(final String str, final String str2, String str3, final IPrePullListener iPrePullListener) {
        if (enablePrePull) {
            QLog.d(TAG, 1, "prePullAppinfoById, entryPath = " + str2 + ",envVersion = " + str3);
            MiniAppInfoPrePullWrapper prePullAppInfoWrapperById = getPrePullAppInfoWrapperById(str, str2);
            if (prePullAppInfoWrapperById != null && System.currentTimeMillis() - prePullAppInfoWrapperById.getPullTimeStamp() < INTERVAL_TIME) {
                QLog.d(TAG, 1, "prePullAppinfoById suc, has been preload, appInfo = " + prePullAppInfoWrapperById.appId);
                if (iPrePullListener != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("retCode", 0);
                        jSONObject.put("errMsg", "appid:" + str + ", has benn preloaded");
                        iPrePullListener.onPrePullCallback(true, jSONObject);
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str2, str3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.2
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject2) {
                    long optLong = jSONObject2.optLong("retCode");
                    String optString = jSONObject2.optString("errMsg");
                    if (z16) {
                        QLog.d(MiniAppPrePullManager.TAG, 1, "prePullAppinfoById suc");
                        synchronized (MiniAppPrePullManager.mLock) {
                            MiniAppInfoPrePullWrapper miniAppInfoPrePullWrapper = new MiniAppInfoPrePullWrapper();
                            miniAppInfoPrePullWrapper.setAppId(str);
                            miniAppInfoPrePullWrapper.setEntryPath(str2);
                            miniAppInfoPrePullWrapper.setPullTimeStamp(System.currentTimeMillis());
                            MiniAppPrePullManager.prePullAppInfoMapForId.put(str, miniAppInfoPrePullWrapper);
                        }
                        IPrePullListener iPrePullListener2 = iPrePullListener;
                        if (iPrePullListener2 != null) {
                            iPrePullListener2.onPrePullCallback(true, jSONObject2);
                            return;
                        }
                        return;
                    }
                    IPrePullListener iPrePullListener3 = iPrePullListener;
                    if (iPrePullListener3 != null) {
                        iPrePullListener3.onPrePullCallback(false, jSONObject2);
                    }
                    QLog.e(MiniAppPrePullManager.TAG, 1, "prePullAppinfoById failed. retCode=" + optLong + " errMsg=" + optString);
                }
            });
        }
    }

    public void prePullAppinfoByLink(final String str, int i3, final boolean z16, final IPrePullListener iPrePullListener) {
        if (enablePrePull) {
            String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
            if (qQProcessName != null && !qQProcessName.equals("com.tencent.mobileqq")) {
                QLog.d(TAG, 1, "prePullAppinfoByLink need to change process: " + qQProcessName + ", link = " + str + ",linkType = " + i3);
                Bundle bundle = new Bundle();
                bundle.putString(QzoneIPCModule.MINIAPP_PRELOAD_LINK, str);
                bundle.putInt(QzoneIPCModule.MINIAPP_PRELOAD_LINK_TYPE, i3);
                bundle.putBoolean(QzoneIPCModule.MINIAPP_PRELOAD_WITH_PACKAGE_AND_CACHE_PRELOAD, z16);
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_PRE_PULL_MINI_APP, bundle);
                return;
            }
            if (str.startsWith("mqqapi://microapp/open?")) {
                HashMap hashMap = new HashMap();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[miniapp-scheme-prepull], open microapp scheme=" + str);
                }
                String[] split = str.split("\\?");
                if (split.length < 2 || split[0].length() == 0) {
                    QLog.e(TAG, 1, "[miniapp-scheme-prepull], scheme format err, scheme=" + str);
                    return;
                }
                String[] split2 = str.substring(split[0].length() + 1).split(ContainerUtils.FIELD_DELIMITER);
                if (split2 != null) {
                    for (String str2 : split2) {
                        String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split3 != null && split3.length == 2) {
                            hashMap.put(split3[0], split3[1]);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "[miniapp-scheme-prepull], open microapp key=" + split3[0] + ", value=" + split3[1]);
                            }
                        }
                    }
                }
                try {
                    str = URLDecoder.decode((String) hashMap.get("url"), "UTF-8");
                    i3 = 0;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "prePullAppinfoByLink decode url get an Exception, " + e16);
                }
            }
            QLog.d(TAG, 1, "prePullAppinfoByLink, link = " + str + ",linkType = " + i3);
            MiniAppInfoPrePullWrapper prePullAppInfoWrapperByLink = getPrePullAppInfoWrapperByLink(str);
            if (prePullAppInfoWrapperByLink != null && System.currentTimeMillis() - prePullAppInfoWrapperByLink.getPullTimeStamp() < INTERVAL_TIME) {
                QLog.d(TAG, 1, "prePullAppinfoByLink suc, has been preload, appId = " + prePullAppInfoWrapperByLink.appId);
                if (iPrePullListener != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("retCode", 0);
                        jSONObject.put("errMsg", "link:" + str + ", has benn preloaded");
                        iPrePullListener.onPrePullCallback(true, jSONObject);
                        return;
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                        return;
                    }
                }
                return;
            }
            MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.3
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z17, JSONObject jSONObject2) {
                    MiniAppInfo miniAppInfo;
                    long optLong = jSONObject2.optLong("retCode");
                    String optString = jSONObject2.optString("errMsg");
                    if (z17) {
                        synchronized (MiniAppPrePullManager.mLock) {
                            MiniAppInfoPrePullWrapper miniAppInfoPrePullWrapper = new MiniAppInfoPrePullWrapper();
                            miniAppInfoPrePullWrapper.setLink(str);
                            miniAppInfoPrePullWrapper.setPullTimeStamp(System.currentTimeMillis());
                            MiniAppPrePullManager.prePullAppInfoMapForLink.put(str, miniAppInfoPrePullWrapper);
                        }
                        if (z16 && (miniAppInfo = (MiniAppInfo) jSONObject2.opt("appInfo")) != null) {
                            MiniAppUtils.preFetchAppCacheData(BaseApplicationImpl.getApplication(), miniAppInfo);
                        }
                        IPrePullListener iPrePullListener2 = iPrePullListener;
                        if (iPrePullListener2 != null) {
                            iPrePullListener2.onPrePullCallback(true, jSONObject2);
                        }
                        QLog.d(MiniAppPrePullManager.TAG, 1, "prePullAppinfoByLink suc");
                        return;
                    }
                    IPrePullListener iPrePullListener3 = iPrePullListener;
                    if (iPrePullListener3 != null) {
                        iPrePullListener3.onPrePullCallback(false, jSONObject2);
                    }
                    QLog.e(MiniAppPrePullManager.TAG, 1, "prePullAppinfoByLink failed. retCode=" + optLong + " errMsg=" + optString);
                }
            });
        }
    }
}
