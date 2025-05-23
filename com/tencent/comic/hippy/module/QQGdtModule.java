package com.tencent.comic.hippy.module;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.tencent.comic.utils.a;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.bigbrother.b;
import com.tencent.mobileqq.bigbrother.d;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQGdtModule.TAG)
/* loaded from: classes32.dex */
public class QQGdtModule extends QQBaseModule {
    static final String TAG = "QQGdtModule";
    private ArraySet<Integer> jumpCallbackIds;

    public QQGdtModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.jumpCallbackIds = new ArraySet<>();
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        ArraySet<Integer> arraySet = this.jumpCallbackIds;
        if (arraySet == null || arraySet.size() <= 0) {
            return;
        }
        Iterator<Integer> it = this.jumpCallbackIds.iterator();
        while (it.hasNext()) {
            d.b().d(it.next().intValue());
        }
        this.jumpCallbackIds.clear();
    }

    @HippyMethod(name = "Openlink")
    public void openLink(HippyMap hippyMap, final Promise promise) {
        JSONObject jSONObject;
        try {
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("businessId");
            String optString2 = jSONObject.optString("openlink");
            String optString3 = jSONObject.optString("packageName");
            int a16 = d.b().a(new b() { // from class: com.tencent.comic.hippy.module.QQGdtModule.1
                @Override // com.tencent.mobileqq.bigbrother.b
                public void onJump(int i3, int i16) {
                    d.b().d(i3);
                    QQGdtModule.this.jumpCallbackIds.remove(Integer.valueOf(i3));
                    promise.resolve("{\"openresult\":" + i16 + " }");
                }
            });
            this.jumpCallbackIds.add(Integer.valueOf(a16));
            try {
                if (!TextUtils.isEmpty(optString2)) {
                    a.c(getActivity(), optString2, optString, a16);
                } else if (!TextUtils.isEmpty(optString3)) {
                    PackageUtil.startAppWithPkgName(getActivity(), optString3, null, optString, a16);
                }
            } catch (ActivityNotFoundException unused) {
                promise.resolve("{\"openresult\":-3}");
                d.b().d(a16);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
