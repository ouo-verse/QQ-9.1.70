package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.richtext.annotation.JSMethod;
import com.tencent.hippy.qq.api.impl.HippyDomNodeManagerImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends gk0.a {
    public static final String MODULE_NAME = "cache";
    public static final String TAG = "CacheModule";
    public static final String VIOLA_CACHE_FILE_NAME = "viola_cache_file_";

    /* JADX INFO: Access modifiers changed from: protected */
    public static void handleBody(JSONObject jSONObject) {
        try {
            if (jSONObject.get(Node.CHILDREN_ATTR) != null) {
                JSONArray jSONArray = jSONObject.getJSONArray(Node.CHILDREN_ATTR);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if ("image".equals(jSONObject2.optString("type"))) {
                        jSONObject2.optJSONObject("attr").put("src", "");
                    }
                    handleBody(jSONObject2);
                }
            }
        } catch (JSONException unused) {
        }
    }

    @JSMethod(uiThread = false)
    public void cacheBody(@NonNull String str) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("module", HippyDomNodeManagerImpl.FILE_TYPE);
            jSONObject.put("method", "createBody");
            JSONObject jSONObject2 = new JSONObject(str);
            handleBody(jSONObject2);
            jSONObject.put("args", jSONObject2);
            jSONArray.mo162put(jSONObject);
            setItem(getViolaInstance().d(), jSONArray.toString());
        } catch (JSONException unused) {
        }
    }

    @JSMethod(uiThread = false)
    public void getItem(@NonNull String str, String str2) {
        String str3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to getItem");
            TextUtils.isEmpty(str2);
            return;
        }
        Object readObject = FileUtils.readObject(VIOLA_CACHE_FILE_NAME + str + "_" + peekAppRuntime.getAccount());
        if (readObject instanceof String) {
            str3 = (String) readObject;
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            new JSONObject().toString();
        }
        TextUtils.isEmpty(str2);
    }

    @JSMethod(uiThread = false)
    public void multiGet(@NonNull JSONObject jSONObject, String str) {
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to getItem");
            TextUtils.isEmpty(str);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                Object readObject = FileUtils.readObject(VIOLA_CACHE_FILE_NAME + string + "_" + peekAppRuntime.getAccount());
                if (readObject instanceof String) {
                    str2 = (String) readObject;
                } else {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                jSONObject3.put(string, str2);
            }
            jSONObject2.put("data", jSONObject3);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "CacheModule multiGet:", e16);
        }
        TextUtils.isEmpty(str);
    }

    @JSMethod(uiThread = false)
    public void multiRemove(@NonNull JSONObject jSONObject, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to remove");
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                FileUtils.deleteFile(BaseApplication.getContext().getFilesDir() + "/" + VIOLA_CACHE_FILE_NAME + jSONArray.getString(i3) + "_" + peekAppRuntime.getAccount());
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "CacheModule multiRemove:", e16);
        }
    }

    @JSMethod(uiThread = false)
    public void multiSet(@NonNull JSONObject jSONObject, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to setItem");
            return;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str2 = (String) keys.next();
                FileUtils.writeObject(VIOLA_CACHE_FILE_NAME + str2 + "_" + peekAppRuntime.getAccount(), (String) jSONObject.get(str2));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "CacheModule multiSet:", e16);
                return;
            }
        }
    }

    @JSMethod(uiThread = false)
    public void remove(@NonNull String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to remove");
            return;
        }
        FileUtils.deleteFile(BaseApplication.getContext().getFilesDir() + "/" + VIOLA_CACHE_FILE_NAME + str + "_" + peekAppRuntime.getAccount());
    }

    @JSMethod(uiThread = false)
    public void setItem(@NonNull String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "failed to setItem");
            return;
        }
        FileUtils.writeObject(VIOLA_CACHE_FILE_NAME + str + "_" + peekAppRuntime.getAccount(), str2);
    }

    public void destroy() {
    }
}
