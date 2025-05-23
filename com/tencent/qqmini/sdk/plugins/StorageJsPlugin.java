package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.g;
import com.tencent.luggage.wxa.ig.h;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.luggage.wxa.ig.m;
import com.tencent.luggage.wxa.ig.n;
import com.tencent.luggage.wxa.ig.o;
import com.tencent.luggage.wxa.ig.q;
import com.tencent.luggage.wxa.ig.t;
import com.tencent.luggage.wxa.ig.u;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.luggage.wxa.ig.x;
import com.tencent.luggage.wxa.ig.y;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.cache.DiskLruCacheUtil;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class StorageJsPlugin extends BaseJsPlugin {
    private static final String DEFAULT_DATA_TPYE = "String";
    private static final String TAG = "StorageJsPlugin";
    private SharedPreferences mSharedPref;
    private Storage mStorage;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public interface StorageTask {
        String run();
    }

    /* loaded from: classes23.dex */
    class a implements StorageTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f348249a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348250b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348251c;

        a(String str, String str2, RequestEvent requestEvent) {
            this.f348249a = str;
            this.f348250b = str2;
            this.f348251c = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
        public String run() {
            if (!TextUtils.isEmpty(this.f348249a)) {
                StorageJsPlugin.this.mSharedPref.edit().putString(this.f348249a, this.f348250b).apply();
                return this.f348251c.ok();
            }
            return this.f348251c.fail("key is null");
        }
    }

    public static String execStorageTask(String str, final StorageTask storageTask) {
        if (str.endsWith("Sync")) {
            return storageTask.run();
        }
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                StorageTask.this.run();
            }
        });
        return "";
    }

    @JsEvent({"clearStorageForContainer", "clearStorageForContainerSync"})
    public String handleClearContainerStorageForBusiness(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            jSONObject = new JSONObject();
        }
        final String encodeUrl = URLUtil.encodeUrl("${" + jSONObject.optString("bid") + "}_");
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.4
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet(StorageJsPlugin.this.mStorage.keys());
                ArrayList arrayList = new ArrayList();
                for (String str : copyOnWriteArraySet) {
                    if (str.startsWith(encodeUrl) && StorageJsPlugin.this.mStorage.removeStorage(str)) {
                        arrayList.add(str);
                    }
                }
                if (QMLog.isColorLevel()) {
                    QMLog.d(StorageJsPlugin.TAG, "removed size:" + arrayList.size());
                }
                return requestEvent.ok();
            }
        });
    }

    @JsEvent({g.NAME, h.NAME})
    public String handleClearStorage(final RequestEvent requestEvent) {
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.7
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                if (StorageJsPlugin.this.mStorage.clearStorage()) {
                    return requestEvent.ok();
                }
                return requestEvent.fail("clear failed");
            }
        });
    }

    @JsEvent({k.NAME})
    public String handleGetGlobalStorage(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            jSONObject = new JSONObject();
        }
        final String encodeUrl = URLUtil.encodeUrl(jSONObject.optString("key"));
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.8
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                String string = StorageJsPlugin.this.mSharedPref.getString(encodeUrl, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", string);
                        return requestEvent.ok(jSONObject2);
                    } catch (Exception e16) {
                        QMLog.e(StorageJsPlugin.TAG, requestEvent.event + " result error." + e16);
                        return requestEvent.fail("json error");
                    }
                }
                return requestEvent.fail("result is null");
            }
        });
    }

    @JsEvent({m.NAME, q.NAME})
    public String handleGetStorage(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            jSONObject = new JSONObject();
        }
        final String encodeUrl = URLUtil.encodeUrl(jSONObject.optString("key"));
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.3
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                String str;
                String[] read = StorageJsPlugin.this.mStorage.read(encodeUrl);
                JSONObject jSONObject2 = new JSONObject();
                if (read != null) {
                    try {
                        if (read.length == 2) {
                            jSONObject2.put("data", read[0]);
                            jSONObject2.put("dataType", read[1]);
                            return requestEvent.ok(jSONObject2);
                        }
                    } catch (Exception e16) {
                        QMLog.e(StorageJsPlugin.TAG, requestEvent.event + " result error." + e16);
                        return requestEvent.fail("json error");
                    }
                }
                RequestEvent requestEvent2 = requestEvent;
                if (read == null) {
                    str = "data is null";
                } else {
                    str = "data error";
                }
                return requestEvent2.fail(str);
            }
        });
    }

    @JsEvent({n.NAME, o.NAME})
    public String handleGetStorageInfo(final RequestEvent requestEvent) {
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.5
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("limitSize", StorageJsPlugin.this.mStorage.getLimitSize());
                    jSONObject.put("currentSize", StorageJsPlugin.this.mStorage.getCurrentSize());
                    Set<String> keys = StorageJsPlugin.this.mStorage.keys();
                    HashSet hashSet = new HashSet();
                    if (keys != null) {
                        Iterator<String> it = keys.iterator();
                        while (it.hasNext()) {
                            hashSet.add(URLUtil.decodeUrl(it.next()));
                        }
                    }
                    jSONObject.put("keys", DiskLruCacheUtil.setToJSONArray(hashSet));
                    return requestEvent.ok(jSONObject);
                } catch (Exception e16) {
                    QMLog.e(StorageJsPlugin.TAG, requestEvent.event + " result error." + e16);
                    return requestEvent.fail("json error");
                }
            }
        });
    }

    @JsEvent({t.NAME, u.NAME})
    public String handleRemoveStorage(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            jSONObject = new JSONObject();
        }
        final String encodeUrl = URLUtil.encodeUrl(jSONObject.optString("key"));
        return execStorageTask(requestEvent.event, new StorageTask() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.6
            @Override // com.tencent.qqmini.sdk.plugins.StorageJsPlugin.StorageTask
            public String run() {
                if (StorageJsPlugin.this.mStorage.removeStorage(encodeUrl)) {
                    return requestEvent.ok();
                }
                return requestEvent.fail("remove failed");
            }
        });
    }

    @JsEvent({w.NAME})
    public String handleSetGlobalStorage(RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            th5.printStackTrace();
            jSONObject = new JSONObject();
        }
        return execStorageTask(requestEvent.event, new a(URLUtil.encodeUrl(jSONObject.optString("key")), jSONObject.optString("data"), requestEvent));
    }

    @JsEvent({x.NAME, y.NAME})
    public String handleSetStorage(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("key");
            if (TextUtils.isEmpty(optString)) {
                return requestEvent.fail("key is empty");
            }
            final String encodeUrl = URLUtil.encodeUrl(optString);
            final String optString2 = jSONObject.optString("data");
            final String optString3 = jSONObject.optString("dataType", "String");
            if (x.NAME.equals(requestEvent.event)) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StorageJsPlugin.this.mStorage.write(encodeUrl, optString2, optString3, new Storage.StorageCallback() { // from class: com.tencent.qqmini.sdk.plugins.StorageJsPlugin.2.1
                            @Override // com.tencent.qqmini.sdk.cache.Storage.StorageCallback
                            public void onFailed(String str, String str2) {
                                requestEvent.fail(str2);
                            }

                            @Override // com.tencent.qqmini.sdk.cache.Storage.StorageCallback
                            public void onSuccess(String str, String str2) {
                                requestEvent.ok();
                            }
                        });
                    }
                });
            }
            if (y.NAME.equals(requestEvent.event)) {
                if (this.mStorage.writeSync(encodeUrl, optString3, optString2)) {
                    return requestEvent.ok();
                }
                return requestEvent.fail("size limit reached");
            }
            return "";
        } catch (Exception e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        String str;
        super.onCreate(iMiniAppContext);
        this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
        if (LoginManager.getInstance().getAccount() != null) {
            str = LoginManager.getInstance().getAccount();
        } else {
            str = "";
        }
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo == null) {
            QMLog.d(TAG, "onCreate mApkgInfo is null ");
            return;
        }
        String str2 = apkgInfo.appId;
        if (iMiniAppContext.isContainer()) {
            int maxContainerStorageSize = ((ConfigProxy) ProxyManager.get(ConfigProxy.class)).getMaxContainerStorageSize();
            QMLog.d(TAG, "set container max size:" + maxContainerStorageSize);
            this.mStorage = Storage.openContainerStorage(this.mContext, str, str2, maxContainerStorageSize * 1024 * 1024);
            return;
        }
        this.mStorage = Storage.open(this.mContext, str, str2);
    }
}
