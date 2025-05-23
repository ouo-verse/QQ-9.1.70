package com.tencent.mobileqq.qqecommerce.biz.hippy.module;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
@HippyNativeModule(name = TKDDebugModule.TAG)
/* loaded from: classes35.dex */
public class TKDDebugModule extends HippyNativeModuleBase {
    private static final String TAG = "TKDDebugModule";

    public TKDDebugModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "eventLog")
    public void eventLog(HippyMap hippyMap) {
        String string = hippyMap.getString("bussiness");
        String string2 = hippyMap.getString(VipFunCallConstants.KEY_GROUP);
        String string3 = hippyMap.getString("massage");
        String string4 = hippyMap.getString("detail");
        String string5 = hippyMap.getString("owner");
        int i3 = hippyMap.getInt("result");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format(Locale.CHINESE, "business=%s group=%s message=%s detail=%s owner=%s result=%d", string, string2, string3, string4, string5, Integer.valueOf(i3)));
        }
    }
}
