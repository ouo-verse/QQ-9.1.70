package cooperation.vip.ad.impl;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.IQQVASGuideHippyApi;
import cooperation.vip.ad.f;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QQVASGuideHippyApiImpl implements IQQVASGuideHippyApi {
    private static final String TAG = "QQVASGuideHippyApiImpl";
    public static String preModuleName = "VasGuide";
    private String[] vasModuleList = {"VAS_CARD", "VAS_TEMPLATE", "_VAS_DEBUG_DEMO_"};

    @Override // cooperation.vip.ad.IQQVASGuideHippyApi
    public HippyAPIProvider getQQIvLiveHallHippyAPIProvider() {
        return new f();
    }

    @Override // cooperation.vip.ad.IQQVASGuideHippyApi
    public boolean isVASGuideModule(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (!Arrays.asList(this.vasModuleList).contains(str)) {
                if (!str.startsWith(preModuleName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(TAG, 1, "register module error.");
            return false;
        }
    }
}
