package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.VasHippyUtils;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQTreasureCardModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQTreasureCardModule extends QQBaseModule {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CLASSNAME = "QQTreasureCardModule";
    private static final String METHOD_FREE_TRAFFIC_CARD_MODEL = "freeTrafficCardModel";

    public QQTreasureCardModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = METHOD_FREE_TRAFFIC_CARD_MODEL)
    public void freeTrafficCardModel(HippyMap hippyMap, Promise promise) {
        String string = hippyMap.getString("from");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && !TextUtils.isEmpty(string)) {
            try {
                IVasFTManager vasFtManager = VasUtil.getService(waitAppRuntime).getVasFtManager();
                JSONObject json = vasFtManager.obtainCardInfo(string).toJson();
                json.put("cardStates", vasFtManager.obtainCardState(string));
                promise.resolve(VasHippyUtils.newRspObj(0, "success", json).get("data"));
                return;
            } catch (Exception unused) {
                promise.reject(VasHippyUtils.newRspObj(-1, "handle json Exception", null));
                return;
            }
        }
        promise.reject(VasHippyUtils.newRspObj(-1, "appRuntime is null", null));
    }
}
