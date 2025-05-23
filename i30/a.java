package i30;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f407131b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f407132c = Arrays.asList(new String[0]);

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f407133d = Arrays.asList(new String[0]);

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Boolean> f407134a = new HashMap<>();

    a() {
        c();
        d();
    }

    public static a b() {
        if (f407131b == null) {
            synchronized (a.class) {
                if (f407131b == null) {
                    f407131b = new a();
                }
            }
        }
        return f407131b;
    }

    private void d() {
        Iterator<String> it = f407132c.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    private void f(String str) {
        if (!l.e(str)) {
            QLog.d("QFSFastModeABTestManager", 1, "[loadExpValToSwitchMap] expName: " + str + ", load fail.");
            return;
        }
        l.i(str);
        Map<String, String> c16 = l.c(str);
        if (c16 == null) {
            QLog.d("QFSFastModeABTestManager", 1, "[loadExpValToSwitchMap] expParams should not be null.");
        } else {
            h(c16);
        }
    }

    public static void g() {
        if (f407131b != null) {
            synchronized (a.class) {
                if (f407131b != null) {
                    f407131b = null;
                }
            }
        }
    }

    private void h(@NonNull Map<String, String> map) {
        for (String str : f407133d) {
            if (map.containsKey(str) && !TextUtils.isEmpty(map.get(str))) {
                this.f407134a.put(str, Boolean.valueOf(map.get(str)));
            }
        }
        String deviceLevelFlag = QCircleDeviceInfoUtils.getDeviceLevelFlag();
        QLog.d("QFSFastModeABTestManager", 1, "updateSwitchMap: " + this.f407134a.toString() + " | deviceLevelFlag: " + deviceLevelFlag);
    }

    public boolean a() {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return true;
        }
        return e();
    }

    public boolean e() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_middle_or_high_lazy_load_switch", 1) == 1) {
            return true;
        }
        return false;
    }

    private void c() {
    }
}
