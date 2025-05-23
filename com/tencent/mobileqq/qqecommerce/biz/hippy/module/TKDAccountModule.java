package com.tencent.mobileqq.qqecommerce.biz.hippy.module;

import com.tencent.common.config.AppSetting;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@HippyNativeModule(name = "TKDAccountModule")
/* loaded from: classes35.dex */
public class TKDAccountModule extends HippyNativeModuleBase {
    private static final int LOGIN_TYPE_QQ = 1;
    private static final String TAG = "AccountModule";

    public TKDAccountModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    public static HippyMap convertAccountInfo2HippyMap(mf2.a aVar) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("type", 1);
        hippyMap.pushString("qbid", aVar.f416665a);
        hippyMap.pushString("uin", aVar.f416665a);
        hippyMap.pushString("token", aVar.f416665a);
        hippyMap.pushString("nickname", aVar.f416666b);
        hippyMap.pushString("head", aVar.f416667c);
        hippyMap.pushString("appid", aVar.f416668d);
        return hippyMap;
    }

    public static mf2.a getCurAccountInfo() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            str = "";
        } else {
            str = peekAppRuntime.getAccount();
        }
        mf2.a aVar = new mf2.a();
        aVar.f416665a = str;
        aVar.f416668d = AppSetting.f() + "";
        return aVar;
    }

    @HippyMethod(name = "getAccountInfo")
    public void getAccountInfo(Promise promise) {
        promise.resolve(convertAccountInfo2HippyMap(getCurAccountInfo()));
    }
}
