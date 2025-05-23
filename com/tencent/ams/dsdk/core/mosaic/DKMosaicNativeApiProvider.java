package com.tencent.ams.dsdk.core.mosaic;

import android.text.TextUtils;
import com.tencent.ams.dsdk.event.DKMethodDispatcher;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.mosaic.jsengine.c;
import com.tencent.ams.mosaic.jsengine.common.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DKMosaicNativeApiProvider implements com.tencent.ams.mosaic.jsengine.c {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_KEY = "default_mosaic_key";
    private static final String TAG = "DKMosaicNativeApiProvider";
    private final DKMethodDispatcher mMethodDispatcher;

    public DKMosaicNativeApiProvider(DKMethodDispatcher dKMethodDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dKMethodDispatcher);
        } else {
            this.mMethodDispatcher = dKMethodDispatcher;
        }
    }

    private void handleDispatcher(String str, String str2, c.C0687c c0687c, c.a aVar, boolean z16) {
        JSONObject map2Json;
        if (c0687c == null) {
            map2Json = null;
        } else {
            try {
                map2Json = DynamicUtils.map2Json(c0687c.a());
            } catch (Throwable th5) {
                DLog.e(TAG, "invoke error.", th5);
                notifyFailure(-3, th5.getMessage(), aVar);
                return;
            }
        }
        DKMethodDispatcher dKMethodDispatcher = this.mMethodDispatcher;
        if (dKMethodDispatcher == null || !dKMethodDispatcher.dispatcher(str, str2, map2Json, new DKMethodHandler.Callback(aVar, z16) { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicNativeApiProvider.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isToMap;
            final /* synthetic */ c.a val$resultCallBack;

            {
                this.val$resultCallBack = aVar;
                this.val$isToMap = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DKMosaicNativeApiProvider.this, aVar, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
            public void onFailure(int i3, String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    DKMosaicNativeApiProvider.this.notifyFailure(i3, str3, this.val$resultCallBack);
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str3);
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
            public void onResult(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    return;
                }
                c.a aVar2 = this.val$resultCallBack;
                if (aVar2 != null) {
                    if (this.val$isToMap) {
                        obj = DKMosaicNativeApiProvider.this.toMap(obj);
                    }
                    aVar2.a(obj, 0);
                }
            }
        })) {
            notifyFailure(-2, "can not find " + str + "." + str2 + " method handler.", aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailure(int i3, String str, c.a aVar) {
        if (aVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            aVar.a(hashMap, i3);
        }
    }

    private Object parseJSON(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            HashMap hashMap = new HashMap();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                hashMap.put(obj2, parseJSON(map.get(obj2)));
            }
            return hashMap;
        }
        if (obj instanceof JSONObject) {
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap2.put(str, parseJSON(jSONObject.opt(str)));
            }
            return hashMap2;
        }
        if (obj instanceof JSONArray) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(parseJSON(jSONArray.opt(i3)));
            }
            return arrayList;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map toMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Object parseJSON = parseJSON(obj);
        if (parseJSON instanceof Map) {
            return (Map) parseJSON;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DEFAULT_KEY, parseJSON);
        return hashMap;
    }

    @Override // com.tencent.ams.mosaic.jsengine.c
    public void invoke(String str, String str2, c.C0687c c0687c, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, c0687c, aVar);
            return;
        }
        DLog.i(TAG, "invoke, nameSpace: " + str + ", methodName: " + str2 + ", params: " + c0687c);
        if (this.mMethodDispatcher == null) {
            DLog.w(TAG, "method dispatcher is null.");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            handleDispatcher(str, str2, c0687c, aVar, true);
        } else {
            notifyFailure(-1, "moduleId or methodName is empty.", aVar);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.c
    public void invokeApi(String str, String str2, c.C0687c c0687c, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, c0687c, aVar);
            return;
        }
        DLog.i(TAG, "invokeApi, nameSpace: " + str + ", methodName: " + str2 + ", params: " + c0687c);
        if (this.mMethodDispatcher == null) {
            DLog.w(TAG, "method dispatcher is null.");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            handleDispatcher(str, str2, c0687c, aVar, false);
        } else {
            notifyFailure(-1, "moduleId or methodName is empty.", aVar);
        }
    }
}
