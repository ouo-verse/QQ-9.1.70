package com.tencent.mobileqq.gamecenter.preload.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import pd1.b;
import pd1.c;

/* loaded from: classes12.dex */
public class PreloadRequestManagerImpl implements IPreloadRequestManager {
    private static final String EMPTY_RESPONSE = "{}";
    private static final String FUN_DEF_SCRIPT = " function callbackPreloadData(requestKey, response) {\n  try {\n    if (global) {\n      if (!global.preloadMap) {\n        global.preloadMap = new Map();\n      }\n      global.preloadMap.set(requestKey, response);\n    }\n  } catch (err) {\n    console.log(`callbackPreloadData:`, err);\n  }\n} ";
    private static final String FUN_REMOVE_PRELOAD_MAP_SCRIPT = " try {\n    if (global && global.preloadMap) {\n      global.preloadMap.clear();\n    }\n  } catch (err) {\n    console.log('clear preload map', err);\n  } ";
    private static final int RESULT_CODE_LOADING = 2;
    private static final int RESULT_CODE_NO_SSO_CMD = 1;
    private static final int RESULT_CODE_OK = 0;
    private static final String TAG = "PreloadRequestManagerImpl";
    private final HashMap<Integer, b> mOpenIdToDataConfigs = new HashMap<>();

    /* loaded from: classes12.dex */
    class a implements pd1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pd1.a f212277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f212278b;

        a(pd1.a aVar, String str) {
            this.f212277a = aVar;
            this.f212278b = str;
        }

        @Override // pd1.a
        public void a(int i3, String str, String str2) {
            this.f212277a.a(0, this.f212278b, PreloadRequestManagerImpl.makeCallbackJson(0, str2).toString());
        }
    }

    private b.C11004b findPreloadItem(int i3, String str) {
        b bVar;
        synchronized (this.mOpenIdToDataConfigs) {
            bVar = this.mOpenIdToDataConfigs.get(Integer.valueOf(i3));
        }
        if (bVar == null) {
            return null;
        }
        for (int i16 = 0; i16 < bVar.f425914c.size(); i16++) {
            b.C11004b c11004b = bVar.f425914c.get(i16);
            if (TextUtils.equals(str, c11004b.f425920c)) {
                return c11004b;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject makeCallbackJson(int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", i3);
            jSONObject.put("result", str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "normalCallback result:", jSONObject);
            }
            return jSONObject;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "normalCallback e:" + th5);
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadFirstScreenDataInner(int i3, String str, String str2, pd1.a aVar) {
        b bVar;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preloadFirstScreenDataInner bundleName:", str);
        }
        synchronized (this.mOpenIdToDataConfigs) {
            bVar = this.mOpenIdToDataConfigs.get(Integer.valueOf(i3));
        }
        if (bVar == null && (bVar = b.a(str)) != null && bVar.f425912a) {
            synchronized (this.mOpenIdToDataConfigs) {
                this.mOpenIdToDataConfigs.put(Integer.valueOf(i3), bVar);
            }
        }
        if (bVar != null && bVar.f425912a) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preloadFirstScreenDataInner dataConfig:", bVar);
            }
            c cVar = new c();
            cVar.d(bVar, 0, str2, aVar);
            cVar.d(bVar, 1, str2, aVar);
        }
    }

    private void preloadSSORequest(int i3, String str, String str2, String str3, pd1.a aVar) {
        b bVar;
        synchronized (this.mOpenIdToDataConfigs) {
            bVar = this.mOpenIdToDataConfigs.get(Integer.valueOf(i3));
        }
        if (bVar != null) {
            for (int i16 = 0; i16 < bVar.f425914c.size(); i16++) {
                b.C11004b c11004b = bVar.f425914c.get(i16);
                if (TextUtils.equals(str2, c11004b.f425920c)) {
                    new c().e(c11004b, str3, aVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager
    public String getPreloadRequest(int i3, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return "{}";
        }
        try {
            String optString = new JSONObject(str2).optString("uniqueSSOCmd");
            if (TextUtils.isEmpty(optString)) {
                return "{}";
            }
            b.C11004b findPreloadItem = findPreloadItem(i3, optString);
            if (findPreloadItem != null) {
                if (!TextUtils.isEmpty(findPreloadItem.f425925h)) {
                    return makeCallbackJson(0, findPreloadItem.f425925h).toString();
                }
                return makeCallbackJson(2, "sso cmd loading").toString();
            }
            QLog.e(TAG, 1, "getPreloadRequest no found dataKey bundleName:", str, " openId:", Integer.valueOf(i3));
            return makeCallbackJson(1, "no sso cmd").toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "{}";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager
    public void getPreloadRequestAsync(int i3, String str, String str2, String str3, pd1.a aVar) {
        if (aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            aVar.a(0, str2, makeCallbackJson(0, "promise is null").toString());
            return;
        }
        try {
            String optString = new JSONObject(str2).optString("uniqueSSOCmd");
            if (TextUtils.isEmpty(optString)) {
                aVar.a(0, str2, makeCallbackJson(0, "sso cmd is null").toString());
                return;
            }
            b.C11004b findPreloadItem = findPreloadItem(i3, optString);
            if (findPreloadItem != null) {
                if (!TextUtils.isEmpty(findPreloadItem.f425925h)) {
                    aVar.a(0, str2, makeCallbackJson(0, findPreloadItem.f425925h).toString());
                    return;
                } else {
                    preloadSSORequest(i3, str, optString, str3, new a(aVar, str2));
                    return;
                }
            }
            aVar.a(0, str2, makeCallbackJson(1, "no sso cmd").toString());
        } catch (JSONException e16) {
            aVar.a(0, str2, makeCallbackJson(0, "param error").toString());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager
    public void onBundleDownloaded(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.preload.impl.PreloadRequestManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                b bVar;
                if (QLog.isColorLevel()) {
                    QLog.d(PreloadRequestManagerImpl.TAG, 2, "onBundleDownloaded bundleName:", str);
                }
                synchronized (PreloadRequestManagerImpl.this.mOpenIdToDataConfigs) {
                    bVar = null;
                    for (b bVar2 : PreloadRequestManagerImpl.this.mOpenIdToDataConfigs.values()) {
                        if (TextUtils.equals(str, bVar2.f425913b)) {
                            bVar = bVar2;
                        }
                    }
                }
                if (bVar == null) {
                    bVar = b.a(str);
                }
                if (bVar != null && bVar.f425912a) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PreloadRequestManagerImpl.TAG, 2, "onBundleDownloaded dataConfig:", bVar);
                    }
                    new c().d(bVar, 1, "", null);
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager
    public void onHippyDestroy(int i3, String str) {
        if (!this.mOpenIdToDataConfigs.isEmpty()) {
            synchronized (this.mOpenIdToDataConfigs) {
                this.mOpenIdToDataConfigs.remove(Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.preload.IPreloadRequestManager
    public void onOpenHippyStart(final int i3, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.preload.impl.PreloadRequestManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PreloadRequestManagerImpl.this.preloadFirstScreenDataInner(i3, str, str2, null);
            }
        }, 16, null, false);
    }
}
