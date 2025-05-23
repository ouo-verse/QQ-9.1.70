package mqq.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleActivityUtils {
    private static final String CLASS_NAME = "com.tencent.biz.qqcircle.QCirclePluginUtil";
    private static final String METHOD_NAME_IS_TAB_MODE = "isTabMode";
    private static final String METHOD_NAME_IS_TAB_MODE_FOR_PAD = "isTabModeForPad";
    public static final CharSequence QCIRCLE_FOLDER_ACTIVITY_CLASS_NAME = "com.tencent.biz.qqcircle.activity.QCircleFolderActivity";
    private static final String TAG = "QCircleActivityUtils";

    public static boolean isLifecycleBlackListActivity(Activity activity) {
        if (activity == null || !TextUtils.equals(QCIRCLE_FOLDER_ACTIVITY_CLASS_NAME, activity.getClass().getName())) {
            return false;
        }
        return isQCircleTabMode();
    }

    private static boolean isQCircleTabMode() {
        try {
            boolean z16 = QCirclePluginUtil.TOUCH_DEBUG_OPEN;
            Method declaredMethod = QCirclePluginUtil.class.getDeclaredMethod(METHOD_NAME_IS_TAB_MODE, null);
            if (((Boolean) QCirclePluginUtil.class.getDeclaredMethod(METHOD_NAME_IS_TAB_MODE_FOR_PAD, null).invoke(null, new Object[0])).booleanValue()) {
                return true;
            }
            return ((Boolean) declaredMethod.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isQCircleTabMode error:" + e16.toString());
            return false;
        }
    }
}
