package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tdf.annotation.TDFMethod;
import com.tencent.tdf.annotation.TDFModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModulePromise;
import com.tencent.tdf.utils.TDFMapUtils;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@TDFModule(name = "QQOfflineModule")
/* loaded from: classes35.dex */
public class QQOfflineModule extends QQBaseModule {
    public static final String TAG = "QQOfflineModule";

    public QQOfflineModule(TDFModuleContext tDFModuleContext) {
        super(tDFModuleContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPromiseCallback(TDFModulePromise tDFModulePromise, JSONObject jSONObject) {
        if (tDFModulePromise == null || !tDFModulePromise.isCallback() || jSONObject == null) {
            return;
        }
        tDFModulePromise.resolve(TDFMapUtils.fromJsonObject(jSONObject));
    }

    @TDFMethod(name = "batchCheckUpdate")
    public void batchCheckUpdate(Map<String, Object> map, TDFModulePromise tDFModulePromise) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "batchCheckUpdate:" + map + ",promise:" + tDFModulePromise);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (map != null) {
                jSONObject = TDFMapUtils.toJSONObject(map);
            } else {
                jSONObject = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            HtmlOffline.C(arrayList, MobileQQ.sMobileQQ.peekAppRuntime(), new a(jSONObject2, tDFModulePromise), true, true);
        } catch (Throwable th5) {
            QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException :" + th5);
            try {
                jSONObject2.put("retcode", -1);
                jSONObject2.put("msg", "error");
                doPromiseCallback(tDFModulePromise, jSONObject2);
            } catch (Throwable th6) {
                QLog.d("QQOfflineModule", 1, th6, new Object[0]);
            }
        }
    }

    @TDFMethod(name = HippyReporter.RemoveEngineReason.CLEAR_CACHE)
    public void clearCache(Map<String, Object> map, TDFModulePromise tDFModulePromise) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "clearCache:" + map + ",promise:" + tDFModulePromise);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (map != null) {
                jSONObject = TDFMapUtils.toJSONObject(map);
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
                doPromiseCallback(tDFModulePromise, jSONObject2);
            }
        }
    }

    @TDFMethod(name = "isCached")
    public void isCached(Map<String, Object> map, TDFModulePromise tDFModulePromise) {
        String str;
        str = "-1";
        if (QLog.isColorLevel()) {
            QLog.i("QQOfflineModule", 2, "isCached:" + map + ",promise:" + tDFModulePromise);
        }
        try {
            try {
                String z16 = HtmlOffline.z(TDFMapUtils.toJSONObject(map).optString("bid"));
                if (!TextUtils.isEmpty(z16)) {
                    str = z16;
                }
            } catch (Exception e16) {
                QLog.d("QQOfflineModule", 1, "isCached, Exception :" + e16);
                if (!TextUtils.isEmpty(null)) {
                    str = null;
                }
            }
            doPromiseCallback(tDFModulePromise, str);
        } catch (Throwable th5) {
            doPromiseCallback(tDFModulePromise, TextUtils.isEmpty(null) ? "-1" : null);
            throw th5;
        }
    }

    private void doPromiseCallback(TDFModulePromise tDFModulePromise, Object obj) {
        if (tDFModulePromise == null || !tDFModulePromise.isCallback() || obj == null) {
            return;
        }
        tDFModulePromise.resolve(obj);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f263032d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TDFModulePromise f263033e;

        a(JSONObject jSONObject, TDFModulePromise tDFModulePromise) {
            this.f263032d = jSONObject;
            this.f263033e = tDFModulePromise;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (TextUtils.isEmpty(str)) {
                try {
                    this.f263032d.put("retcode", -1);
                    this.f263032d.put("msg", "error");
                    return;
                } catch (JSONException e16) {
                    QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException1 :" + e16);
                    return;
                }
            }
            try {
                this.f263032d.put("retcode", 0);
                this.f263032d.put("data", s.l(str));
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
