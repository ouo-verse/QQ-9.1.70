package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vip.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HippyPredownloadManager extends f {
    public static final long DEFAULT_PRELOAD_HIPPY_INTERVAL = 600;
    public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120;
    public static final String GAME_CENTER_SHARED_PREFERECE_NAME = "game_center_sp";
    public static final String PREFIX = "hippyUpdateAction-";
    public static final String TAG = "hippyUpdateAction-PreDownload";
    private static int mCurRequestId;
    private static volatile HippyPredownloadManager sHippyPredownloadManager;
    private String mCurrentUin;
    private HippyConfig mHippyConfig;
    TabPreloadConfigManager mTabPreloadConfigManager;
    private final List<WeakReference<IUpdateListener>> mListeners = new ArrayList();
    private long mLastPreloadTimeStamp = 0;
    private long mPreloadInterval = 600;

    HippyPredownloadManager() {
        initData();
    }

    private boolean checkPreDownloadInterval() {
        boolean z16;
        this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
        if (NetConnInfoCenter.getServerTime() - (this.mLastPreloadTimeStamp / 1000) < this.mPreloadInterval) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[checkPreloadInterval] ret=", Boolean.valueOf(z16), ",mLastPreloadTimeStamploc = ", Long.valueOf(this.mLastPreloadTimeStamp / 1000), ",interval = ", Long.valueOf(this.mPreloadInterval));
        }
        return z16;
    }

    public static HippyPredownloadManager getInstance() {
        if (sHippyPredownloadManager == null) {
            synchronized (HippyPredownloadManager.class) {
                if (sHippyPredownloadManager == null) {
                    sHippyPredownloadManager = new HippyPredownloadManager();
                }
            }
        }
        return sHippyPredownloadManager;
    }

    public static SharedPreferences getSharedPreferences() {
        String str = MobileQQ.QQ_PACKAGE_NAME;
        return BaseApplication.getContext().getSharedPreferences("game_center_sp", 4);
    }

    private void initData() {
        this.mCurrentUin = HippyAccessHelper.getCurrentUin();
        this.mHippyConfig = getHippyConfig();
        this.mPreloadInterval = getPreloadHippyInterval();
        this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
        this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
    }

    private CommonMobileConfQueryRsp parseAllConfigResp(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (intent == null) {
            QLog.e(TAG, 1, "handleUpdateJsBundle request is null or bundleName is empty");
            return null;
        }
        QLog.i(TAG, 1, "handleUpdateJsBundle retCode:" + j3);
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
            try {
                CommonMobileConfQueryRsp commonMobileConfQueryRsp = new CommonMobileConfQueryRsp();
                commonMobileConfQueryRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                return commonMobileConfQueryRsp;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[handleHippyConfig] error ", th5);
                return null;
            }
        }
        QLog.e(TAG, 1, "[handleHippyConfig] server ret error. return.");
        return null;
    }

    private void saveLastPreDownloadTime(long j3) {
        String currentUin = HippyAccessHelper.getCurrentUin();
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(MMKVCommonFileKeys.LAST_PRE_DOWNLOAD_TIME_PREFIX + currentUin, j3);
    }

    private void savePreloadHippyInterval(long j3) {
        String currentUin = HippyAccessHelper.getCurrentUin();
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(MMKVCommonFileKeys.PRE_DOWNLOAD_INTERVAL_PREFIX + currentUin, j3);
        this.mPreloadInterval = j3;
    }

    public synchronized void addListener(IUpdateListener iUpdateListener) {
        Iterator<WeakReference<IUpdateListener>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            IUpdateListener iUpdateListener2 = it.next().get();
            if (iUpdateListener2 == null) {
                it.remove();
            } else if (iUpdateListener2 == iUpdateListener) {
                return;
            }
        }
        this.mListeners.add(new WeakReference<>(iUpdateListener));
    }

    public HippyConfig getHippyConfig() {
        String currentUin = HippyAccessHelper.getCurrentUin();
        if (!TextUtils.equals(currentUin, this.mCurrentUin)) {
            initData();
        } else if (this.mHippyConfig == null) {
            try {
                this.mHippyConfig = parseHippyConfigJson(QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(MMKVCommonFileKeys.HIPPY_CONFIG_PREFIX + currentUin, ""));
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.toString());
            }
        }
        if (this.mHippyConfig == null) {
            this.mHippyConfig = new HippyConfig();
        }
        return this.mHippyConfig;
    }

    public long getLastPreloadDownTimeStamp() {
        String currentUin = HippyAccessHelper.getCurrentUin();
        if (!TextUtils.equals(currentUin, this.mCurrentUin)) {
            initData();
        } else {
            this.mLastPreloadTimeStamp = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(MMKVCommonFileKeys.LAST_PRE_DOWNLOAD_TIME_PREFIX + currentUin, 0L);
        }
        return this.mLastPreloadTimeStamp;
    }

    public long getPreloadHippyInterval() {
        String currentUin = HippyAccessHelper.getCurrentUin();
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(MMKVCommonFileKeys.PRE_DOWNLOAD_INTERVAL_PREFIX + currentUin, 600L);
    }

    public TabPreloadConfigManager getTabPreloadConfigManager() {
        if (!TextUtils.equals(HippyAccessHelper.getCurrentUin(), this.mCurrentUin)) {
            initData();
        }
        if (this.mTabPreloadConfigManager == null) {
            this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
        }
        this.mTabPreloadConfigManager.initData();
        return this.mTabPreloadConfigManager;
    }

    public void handleAllConfigResponses(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp, String str) {
        long j16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleHippyConfig] retCode:" + j3);
        }
        if (intent != null) {
            intent.getIntExtra("source", -1);
        }
        CommonMobileConfQueryRsp parseAllConfigResp = parseAllConfigResp(intent, j3, trpcInovkeRsp);
        if (parseAllConfigResp == null) {
            return;
        }
        if (parseAllConfigResp.updatePreDownloadGap.has()) {
            j16 = parseAllConfigResp.updatePreDownloadGap.get();
        } else {
            j16 = 600;
        }
        savePreloadHippyInterval(j16);
        if (!parseAllConfigResp.confList.has()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleHippyConfig] config size:" + parseAllConfigResp.confList.size());
        }
        for (MobileConfRsp mobileConfRsp : parseAllConfigResp.confList.get()) {
            int i3 = mobileConfRsp.ret.get();
            String str2 = mobileConfRsp.conf.get();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[handleHippyConfig] config:" + str2);
            }
            if (i3 == 1 && !TextUtils.isEmpty(str2)) {
                int i16 = mobileConfRsp.configType.get();
                if (i16 != 1) {
                    if (i16 != 3) {
                        if (i16 != 5) {
                            if (i16 == 9) {
                                getTabPreloadConfigManager().handleAdsPreloadResponse(i3, str2, str);
                            }
                        } else {
                            getTabPreloadConfigManager().handleTabPreloadResponse(i3, str2, str);
                        }
                    } else {
                        HippyTabConfigManager.handleTabConfigResponse(i3, str2, str);
                    }
                } else {
                    handleHippyConfigResponse(i3, str2, str);
                }
            } else {
                QLog.i(TAG, 1, "[handleHippyConfig] no need update. ret = " + i3 + ", type = " + mobileConfRsp.configType.get());
            }
        }
    }

    public void handleHippyConfigResponse(int i3, String str, String str2) {
        if (i3 == 1 && !TextUtils.isEmpty(str)) {
            try {
                HippyConfig parseHippyConfigJson = parseHippyConfigJson(str);
                if (parseHippyConfigJson != null) {
                    QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(MMKVCommonFileKeys.HIPPY_CONFIG_PREFIX + str2, str);
                    this.mHippyConfig = parseHippyConfigJson;
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "handleHippyConfigResponse e:" + th5);
            }
        }
    }

    public HippyConfig parseHippyConfigJson(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 2, "[parseHippyConfigJson] str is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HippyConfig hippyConfig = new HippyConfig();
            hippyConfig.isGameCenterPredrawHippy = jSONObject.optInt("isPredrawHippy", 0);
            hippyConfig.isGameCenterLoadHippyInToolProcess = jSONObject.optInt("isLoadHippyInToolProcess", 0);
            hippyConfig.isGameCenterPreloadHippy = jSONObject.optInt("isPreloadHippy", 0);
            hippyConfig.checkUpdateGap = jSONObject.optLong("checkUpdateGap", 120L);
            return hippyConfig;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.toString());
            throw e16;
        }
    }

    public synchronized void removeListener(IUpdateListener iUpdateListener) {
        if (iUpdateListener == null) {
            return;
        }
        Iterator<WeakReference<IUpdateListener>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            IUpdateListener iUpdateListener2 = it.next().get();
            if (iUpdateListener2 == null) {
                it.remove();
            } else if (iUpdateListener2 == iUpdateListener) {
                it.remove();
                return;
            }
        }
    }

    public void requestHippyConfig(int i3) {
        QLog.i(TAG, 1, "[requestHippyConfig] source:" + i3);
        if (!checkPreDownloadInterval() && i3 != 2) {
            QLog.i(TAG, 1, "[preloadHippy] check preloadInterval failed, stop action.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("source", i3);
        bundle.putInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, mCurRequestId);
        bundle.putString("uin", this.mCurrentUin);
        HippyUnissoHandler hippyUnissoHandler = HippyUnissoHandler.getInstance();
        if (hippyUnissoHandler != null) {
            hippyUnissoHandler.preRequestHippyConfig(this.mLastPreloadTimeStamp, bundle);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            this.mLastPreloadTimeStamp = serverTimeMillis;
            saveLastPreDownloadTime(serverTimeMillis);
            return;
        }
        QLog.i(TAG, 1, "[preloadHippy] hippyHandler is null.");
    }
}
