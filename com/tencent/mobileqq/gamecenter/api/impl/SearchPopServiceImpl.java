package com.tencent.mobileqq.gamecenter.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadRsp;

@Service(process = {"all"})
/* loaded from: classes12.dex */
public class SearchPopServiceImpl implements ISearchPopService {
    private static final long DEFAULT_INTERVAL_MILLIS = 600000;
    private static final int ERR_CODE_CONFIG_EMPTY = 8;
    private static final long ONE_HOUR_MILLISECOND = 3600000;
    private static final String TAG = "SearchPopService";
    private volatile int mCurSearchPopConfigHashCode;
    private volatile long mLastUpdatePopConfigTime;
    private he1.c mPreloadConfigProcessor;
    private int mReqPopConfigVersion;
    private volatile he1.b mSearchPopConfig;
    private long sLastReqPopConfigTime;
    private volatile boolean mIsEnterSearch = false;
    private boolean mIsDestroyed = false;

    private boolean hasSearchPopConfig() {
        Map<String, he1.a> map;
        he1.b bVar = this.mSearchPopConfig;
        if (bVar != null && (map = bVar.f404799b) != null && map.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPopConfig$1() {
        if (this.mIsDestroyed) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("103007");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).fetch(arrayList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPreloadConfig$0() {
        if (!this.mIsDestroyed) {
            GameCenterUnissoHandler.N2().v3(this.mPreloadConfigProcessor.d(), hashCode());
        }
    }

    private void loadLocalPopConfig() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync("103007", "", new py2.a() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ai
            @Override // py2.a
            public final void a(Object obj) {
                SearchPopServiceImpl.this.lambda$loadLocalPopConfig$2((String) obj);
            }
        });
    }

    private boolean needReqPopConfig() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (Math.abs(serverTimeMillis - this.sLastReqPopConfigTime) <= 3600000 || Math.abs(serverTimeMillis - this.mLastUpdatePopConfigTime) <= 3600000) {
            return false;
        }
        this.sLastReqPopConfigTime = serverTimeMillis;
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public int getRequestPopConfigVersion() {
        return this.mReqPopConfigVersion;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public he1.a getSearchPopAnimationData(String str) {
        he1.b bVar = this.mSearchPopConfig;
        if (bVar == null) {
            return null;
        }
        return bVar.g(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public void handlePreloadConfig(int i3, Object obj) {
        if (i3 != hashCode() || this.mIsDestroyed || !(obj instanceof Preload$SsoNYGetPreloadRsp)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 2, "handlePreloadConfig appRuntime is null");
            return;
        }
        Preload$SsoNYGetPreloadRsp preload$SsoNYGetPreloadRsp = (Preload$SsoNYGetPreloadRsp) obj;
        int i16 = preload$SsoNYGetPreloadRsp.retCode.get();
        if (i16 != 0) {
            if (i16 == 8) {
                this.mPreloadConfigProcessor.e();
            }
            QLog.d(TAG, 1, "handlePreloadConfig error code:", Integer.valueOf(i16));
        } else {
            String str = preload$SsoNYGetPreloadRsp.conf.get();
            int i17 = preload$SsoNYGetPreloadRsp.interval.get();
            int i18 = preload$SsoNYGetPreloadRsp.newestVer.get();
            QLog.d(TAG, 2, "handlePreloadConfig interval=", Integer.valueOf(i17), " version=", Integer.valueOf(i18));
            this.mPreloadConfigProcessor.m(peekAppRuntime, i18, str);
            com.tencent.mobileqq.gamecenter.utils.c.u(peekAppRuntime, "search_pop_preload_config_inteval", i17 * 1000);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "onCreate");
        this.mPreloadConfigProcessor = new he1.c();
        loadLocalPopConfig();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mIsDestroyed = true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public void onEnterSearch() {
        this.mIsEnterSearch = true;
        loadLocalPopConfig();
        requestPopConfig();
        requestPreloadConfig(false);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public void onExitSearch() {
        this.mIsEnterSearch = false;
    }

    /* renamed from: onGetEntryConfig, reason: merged with bridge method [inline-methods] */
    public void lambda$loadLocalPopConfig$2(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetEntryConfig config:", str);
        }
        if (TextUtils.isEmpty(str)) {
            this.mSearchPopConfig = null;
            this.mCurSearchPopConfigHashCode = 0;
            return;
        }
        if (this.mSearchPopConfig != null && this.mCurSearchPopConfigHashCode == str.hashCode()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            he1.b bVar = new he1.b();
            bVar.i(jSONObject);
            this.mSearchPopConfig = bVar;
            this.mCurSearchPopConfigHashCode = str.hashCode();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleGetEntryConfig json error:", e16);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "handleGetEntryConfig e:", e17);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public void onRequestPopConfigFinished(boolean z16) {
        this.mLastUpdatePopConfigTime = NetConnInfoCenter.getServerTimeMillis();
        QLog.d(TAG, 1, "onReqPopConfigFinished isSuccess=", Boolean.valueOf(z16), " mIsEnterSearch:", Boolean.valueOf(this.mIsEnterSearch), " reqVersion", Integer.valueOf(this.mReqPopConfigVersion), " newVersion:", Integer.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("103007")));
        loadLocalPopConfig();
    }

    public void requestPopConfig() {
        QLog.d(TAG, 1, "requestPopConfig");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.d(TAG, 1, "requestPopConfig AppRuntime is null");
            return;
        }
        if (!needReqPopConfig()) {
            QLog.i(TAG, 1, "requestPopConfig don't need req");
            return;
        }
        int configVersion = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("103007");
        this.mReqPopConfigVersion = configVersion;
        QLog.d(TAG, 1, "requestPopConfig reqVersion", Integer.valueOf(configVersion));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ag
            @Override // java.lang.Runnable
            public final void run() {
                SearchPopServiceImpl.this.lambda$requestPopConfig$1();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.ISearchPopService
    public void requestPreloadConfig(boolean z16) {
        QLog.d(TAG, 2, "requestPreloadConfig force=", Boolean.valueOf(z16));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 2, "requestPreloadConfig appRuntime is null");
            return;
        }
        if (!hasSearchPopConfig()) {
            QLog.e(TAG, 2, "requestPreloadConfig no pop config");
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long j3 = com.tencent.mobileqq.gamecenter.utils.c.j(peekAppRuntime, "search_pop_preload_config_inteval", 600000L);
        long abs = Math.abs(serverTimeMillis - com.tencent.mobileqq.gamecenter.utils.c.j(peekAppRuntime, "search_pop_preload_config_last_request_time_sys", 0L));
        if (abs <= j3 && !z16) {
            QLog.d(TAG, 1, "requestPreloadConfig skip interval=", Long.valueOf(j3), " reqInterval=", Long.valueOf(abs));
        } else {
            com.tencent.mobileqq.gamecenter.utils.c.u(peekAppRuntime, "search_pop_preload_config_last_request_time_sys", serverTimeMillis);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ah
                @Override // java.lang.Runnable
                public final void run() {
                    SearchPopServiceImpl.this.lambda$requestPreloadConfig$0();
                }
            }, 16, null, false);
        }
    }
}
