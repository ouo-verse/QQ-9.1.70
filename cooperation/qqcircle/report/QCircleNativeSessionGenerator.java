package cooperation.qqcircle.report;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleNativeSessionGenerator {
    private static final String DEFAULT_PREFIX = "android_session_";
    private static final String SHOT_PREFIX = "android_short_session_";
    private static final String TAG = "QCircleNativeSessionGenerator";

    public static String generateDefaultSession() {
        return generateSession(DEFAULT_PREFIX);
    }

    private static String generateSession(String str) {
        String str2 = str + QCircleHostStubUtil.getCurrentAccount() + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(100);
        QLog.i(TAG, 1, "generateSession  session = " + str2);
        return str2;
    }

    public static String generateShortSession() {
        return generateSession(SHOT_PREFIX);
    }

    public static boolean isShortSession(@NonNull String str) {
        return str.startsWith(SHOT_PREFIX);
    }
}
