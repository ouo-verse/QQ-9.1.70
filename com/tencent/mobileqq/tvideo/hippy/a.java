package com.tencent.mobileqq.tvideo.hippy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.hippy.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8862a implements IUpdateListener {
        C8862a() {
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap) {
            QLog.i("TVideoHippyHelper", 1, "onUpdateFailed: " + str2 + " ,retCode:" + i16 + " ,errMsg:" + str);
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap) {
            QLog.i("TVideoHippyHelper", 1, "onUpdateSuccess: " + str);
        }
    }

    public static Bundle a(String str, HashMap<String, String> hashMap) {
        SerializableMap serializableMap = new SerializableMap();
        if (hashMap != null) {
            serializableMap.wrapMap(new HashMap<>(hashMap));
        }
        Bundle bundle = new Bundle();
        bundle.putString("bundleName", str);
        bundle.putString("framework", HippyQQConstants.HIPPY_VUE);
        bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, serializableMap);
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        bundle.putString("domain", "v.qq.com");
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        bundle.putString("url", "https://fuli.v.qq.com/vg-hippy/");
        bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, true);
        return bundle;
    }

    public static void b(String str) {
        QLog.i("TVideoHippyHelper", 1, "preloadJsBundle: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(str, "updateApiHippy", new C8862a());
    }
}
