package l51;

import android.text.TextUtils;
import com.tencent.minibox.common.log.LogUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f413853a;

    public static String a() {
        if (TextUtils.isEmpty(f413853a)) {
            return "0.5.2.1";
        }
        return f413853a;
    }

    public static void b(String str) {
        f413853a = str;
        LogUtils.d("AbsReportBuilder", "updateMiniBoxVersion: version=" + str);
    }
}
