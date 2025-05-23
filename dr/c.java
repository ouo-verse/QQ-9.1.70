package dr;

import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import org.light.device.LightDeviceUtils;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f394665a;

    static {
        ArrayList arrayList = new ArrayList();
        f394665a = arrayList;
        arrayList.add("pbem00");
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals("very_low")) {
            return 1;
        }
        if (str.equals(HippyImageInfo.QUALITY_LOW)) {
            return 2;
        }
        if (str.equals("middle")) {
            return 3;
        }
        if (str.equals("middle_high")) {
            return 4;
        }
        return str.equals("high") ? 5 : 0;
    }

    public static int b() {
        return OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
    }

    public static String c() {
        return DeviceInfoMonitor.getModel();
    }

    public static <T> T d(T t16, T t17, T t18) {
        return OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) <= 2 ? t16 : ((OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) <= 2 || OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) > 3) && !f394665a.contains(DeviceInfoMonitor.getModel().toLowerCase())) ? t18 : t17;
    }

    public static <T> T e(T t16, T t17, T t18) {
        long totalRamMemory = LightDeviceUtils.getTotalRamMemory(BaseApplication.getContext());
        return totalRamMemory <= 2147483648L ? t16 : totalRamMemory <= 4294967296L ? t17 : t18;
    }

    public static int f(double d16) {
        double floor = Math.floor(d16);
        return floor % 2.0d == 0.0d ? (int) floor : (int) Math.ceil(d16);
    }
}
