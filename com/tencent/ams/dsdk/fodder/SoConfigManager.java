package com.tencent.ams.dsdk.fodder;

import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.SoConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.SoConfig;
import com.tencent.ams.dsdk.data.SoInfo;
import com.tencent.ams.dsdk.data.SoPlatform;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.HttpUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SoConfigManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SoConfigManager";
    private final List<OnSoConfigUpdateListener> mOnSoConfigUpdateListeners;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final SoConfigManager instance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18459);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                instance = new SoConfigManager(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnSoConfigUpdateListener {
        void onUpdated(List<SoConfig> list);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnSoDownloadListener {
        void onDownloadFailure(@SoConfig.EngineType int i3, String str, String str2, SoInfo soInfo, int i16);

        void onDownloadStart(@SoConfig.EngineType int i3, String str, String str2, SoInfo soInfo);

        void onDownloadSuccess(@SoConfig.EngineType int i3, String str, String str2, SoInfo soInfo);
    }

    /* synthetic */ SoConfigManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    public static SoConfigManager getInstance() {
        return Holder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSoConfig$0() {
        List<SoConfig> requestSoConfig = requestSoConfig();
        if (requestSoConfig != null) {
            ArrayList arrayList = new ArrayList();
            for (SoConfig soConfig : requestSoConfig) {
                if (soConfig != null && soConfig.isForceUpdate) {
                    arrayList.add(soConfig);
                }
            }
            if (!arrayList.isEmpty()) {
                SoConfigCache.getInstance().updateSoConfig(requestSoConfig);
            }
            notifySoConfigUpdate(requestSoConfig);
        }
    }

    private void notifySoConfigUpdate(List<SoConfig> list) {
        for (OnSoConfigUpdateListener onSoConfigUpdateListener : this.mOnSoConfigUpdateListeners) {
            if (onSoConfigUpdateListener != null) {
                onSoConfigUpdateListener.onUpdated(list);
            }
        }
    }

    private SoConfig parseSoConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SoConfig soConfig = new SoConfig();
        soConfig.engineType = jSONObject.optInt(TagName.ENGINE_TYPE, -1);
        soConfig.version = jSONObject.optString("version");
        JSONArray optJSONArray = jSONObject.optJSONArray("platforms");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                SoPlatform parseSoPlatform = parseSoPlatform(optJSONArray.optJSONObject(i3));
                if (parseSoPlatform != null) {
                    arrayList.add(parseSoPlatform);
                }
            }
            soConfig.platforms = arrayList;
        }
        return soConfig;
    }

    private List<SoConfig> parseSoConfigs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("libs");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    SoConfig parseSoConfig = parseSoConfig(optJSONArray.optJSONObject(i3));
                    if (parseSoConfig != null) {
                        arrayList.add(parseSoConfig);
                    }
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            DLog.e(TAG, "parse so configs error.", e16);
            return null;
        }
    }

    private SoInfo parseSoInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SoInfo soInfo = new SoInfo();
        soInfo.name = jSONObject.optString("name");
        soInfo.url = jSONObject.optString("url");
        soInfo.md5 = jSONObject.optString("md5");
        soInfo.priority = jSONObject.optInt("priority", 0);
        return soInfo;
    }

    private SoPlatform parseSoPlatform(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SoPlatform soPlatform = new SoPlatform();
        soPlatform.abi = jSONObject.optString("abi");
        JSONArray optJSONArray = jSONObject.optJSONArray("soList");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                SoInfo parseSoInfo = parseSoInfo(optJSONArray.optJSONObject(i3));
                if (parseSoInfo != null) {
                    arrayList.add(parseSoInfo);
                }
            }
            soPlatform.soList = arrayList;
        }
        return soPlatform;
    }

    private List<SoConfig> requestSoConfig() {
        String jSONObject;
        DLog.i(TAG, "requestSoConfig");
        String soConfigServiceUrl = DKConfiguration.getSoConfigServiceUrl();
        byte[] bArr = null;
        if (TextUtils.isEmpty(soConfigServiceUrl)) {
            DLog.w(TAG, "get so config url is empty.");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject createRequestBody = HttpUtils.createRequestBody();
        if (createRequestBody == null) {
            jSONObject = null;
        } else {
            jSONObject = createRequestBody.toString();
        }
        if (jSONObject != null) {
            bArr = jSONObject.getBytes();
        }
        String postHttpJson = HttpUtils.postHttpJson(soConfigServiceUrl, bArr, 3000, 3);
        DLog.i(TAG, "requestSoConfig finis, timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", response: " + postHttpJson);
        return parseSoConfigs(postHttpJson);
    }

    public void registerOnSoConfigUpdateListener(OnSoConfigUpdateListener onSoConfigUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onSoConfigUpdateListener);
        } else if (onSoConfigUpdateListener != null) {
            this.mOnSoConfigUpdateListeners.add(onSoConfigUpdateListener);
        }
    }

    public void unregisterOnSoConfigUpdateListener(OnSoConfigUpdateListener onSoConfigUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onSoConfigUpdateListener);
        } else if (onSoConfigUpdateListener != null) {
            this.mOnSoConfigUpdateListeners.remove(onSoConfigUpdateListener);
        }
    }

    public void updateSoConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        DLog.i(TAG, "updateSoConfig");
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.fodder.c
            @Override // java.lang.Runnable
            public final void run() {
                SoConfigManager.this.lambda$updateSoConfig$0();
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            WorkThreadManager.getInstance().getBackgroundThreadPool().execute(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    SoConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mOnSoConfigUpdateListeners = new CopyOnWriteArrayList();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
