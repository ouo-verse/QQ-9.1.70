package com.tencent.comic.hippy.module;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicModule extends ComicModule {
    public void getChapterList(String str, Promise promise) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", "");
        } catch (Exception e16) {
            QLog.e(ComicModule.TAG, 1, "ComicModule getChapterList:", e16);
            try {
                jSONObject.put("error_code", e16.getMessage());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        doPromiseCallback(promise, jSONObject);
    }

    public void getPictureList(String str, String str2, Promise promise) {
        JSONObject jSONObject = new JSONObject();
        new ArrayList().add(str2);
        try {
            jSONObject.put("data", "");
        } catch (Exception e16) {
            QLog.e(ComicModule.TAG, 1, "ComicModule getPictureList:", e16);
            try {
                jSONObject.put("error_code", e16.getMessage());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        doPromiseCallback(promise, jSONObject);
    }

    private void doPromiseCallback(Promise promise, JSONObject jSONObject) {
        if (promise == null || !promise.isCallback()) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(jSONObject);
        promise.resolve(hippyMap);
    }

    @Override // com.tencent.comic.hippy.module.ComicModule
    public void destroy() {
    }
}
