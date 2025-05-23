package ac0;

import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static boolean a(QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo != null && qCircleTabInfo.getType() == 6) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_loacl_refresh_exp", true);
        }
        return false;
    }

    public static String b() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_local_refresh_guide_words", "\u4e0a\u6ed1\u53ef\u627e\u56de\u5df2\u770b\u89c6\u9891");
        if (TextUtils.equals(loadAsString, PatternUtils.NO_MATCH)) {
            return null;
        }
        return loadAsString;
    }
}
