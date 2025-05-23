package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "QQOfflineModule")
/* loaded from: classes7.dex */
public class QQOfflineModule extends QQBaseModule {
    public static final String TAG = "QQOfflineModule";

    public QQOfflineModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPromiseCallback(Promise promise, JSONObject jSONObject) {
        if (promise == null || !promise.isCallback() || jSONObject == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(jSONObject);
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "batchCheckUpdate")
    public void batchCheckUpdate(HippyMap hippyMap, final Promise promise) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "batchCheckUpdate:" + hippyMap + ",promise:" + promise);
        }
        final JSONObject jSONObject2 = new JSONObject();
        try {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            HtmlOffline.C(arrayList, MobileQQ.sMobileQQ.waitAppRuntime(null), new com.tencent.biz.common.offline.a() { // from class: com.tencent.hippy.qq.module.QQOfflineModule.1
                @Override // com.tencent.biz.common.offline.a
                public void loaded(String str, int i16) {
                    if (TextUtils.isEmpty(str)) {
                        try {
                            jSONObject2.put("retcode", -1);
                            jSONObject2.put("msg", "error");
                            return;
                        } catch (JSONException e16) {
                            QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException1 :" + e16);
                            return;
                        }
                    }
                    try {
                        jSONObject2.put("retcode", 0);
                        jSONObject2.put("data", s.l(str));
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }

                @Override // com.tencent.biz.common.offline.a
                public void progress(int i16) {
                }
            }, true, true);
        } catch (Throwable th5) {
            QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException :" + th5);
            try {
                jSONObject2.put("retcode", -1);
                jSONObject2.put("msg", "error");
                doPromiseCallback(promise, jSONObject2);
            } catch (Throwable th6) {
                QLog.d("QQOfflineModule", 1, th6, new Object[0]);
            }
        }
    }

    @HippyMethod(name = HippyReporter.RemoveEngineReason.CLEAR_CACHE)
    public void clearCache(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "clearCache:" + hippyMap + ",promise:" + promise);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            HtmlOffline.P(MobileQQ.sMobileQQ, jSONObject.optString("bid"), 1);
            jSONObject2.put("retcode", 0);
            jSONObject2.put("msg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        } catch (Throwable th5) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("QQOfflineModule", 2, "OfflinePlugin, clearCache, JSONException :" + th5);
                }
                try {
                    jSONObject2.put("retcode", -1);
                    jSONObject2.put("msg", "error");
                } catch (Throwable th6) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQOfflineModule", 2, "OfflinePlugin, clearCache, JSONException :" + th6);
                    }
                }
            } finally {
                doPromiseCallback(promise, jSONObject2);
            }
        }
    }

    @HippyMethod(name = "isCached")
    public void isCached(HippyMap hippyMap, Promise promise) {
        String str = "-1";
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "isCached:" + hippyMap + ",promise:" + promise);
        }
        try {
            try {
                String z16 = HtmlOffline.z(hippyMap.toJSONObject().optString("bid"));
                if (!TextUtils.isEmpty(z16)) {
                    str = z16;
                }
            } catch (Exception e16) {
                QLog.d("QQOfflineModule", 1, "isCached, Exception :" + e16);
                if (!TextUtils.isEmpty(null)) {
                    str = null;
                }
            }
            doPromiseCallback(promise, str);
        } catch (Throwable th5) {
            if (!TextUtils.isEmpty(null)) {
                str = null;
            }
            doPromiseCallback(promise, str);
            throw th5;
        }
    }

    private void doPromiseCallback(Promise promise, Object obj) {
        if (promise == null || !promise.isCallback() || obj == null) {
            return;
        }
        promise.resolve(obj);
    }
}
