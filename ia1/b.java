package ia1;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static int a() {
        int i3;
        boolean e16 = e();
        int i16 = 5;
        if (e16) {
            i3 = 5;
        } else {
            i3 = 9;
        }
        String b16 = b("color_note_revision_v2_switch", "itemMaxCount", String.valueOf(i3));
        QLog.i("ColorNoteToggle", 2, "colorNoteItemMaxCount feature switch:" + e16 + " maxCount:" + b16);
        if (!e16) {
            i16 = 9;
        }
        try {
            return Integer.parseInt(b16);
        } catch (NumberFormatException e17) {
            QLog.i("ColorNoteToggle", 1, "colorNoteItemMaxCount err:" + e17.getMessage());
            return i16;
        }
    }

    public static String b(String str, String str2, String str3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return str3;
        }
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet(str, "");
        if (isEnabledWithDataSet == null) {
            return str3;
        }
        if (isEnabledWithDataSet.containsKey(str2)) {
            return isEnabledWithDataSet.get(str2);
        }
        return str3;
    }

    public static boolean c(String str, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return z16;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(str, z16);
    }

    public static boolean d() {
        boolean equals = "1".equals(b("color_note_revision_v2_switch", "isLongClickDelete", "0"));
        QLog.i("ColorNoteToggle", 2, "isOpenLongClickDelete  isOpenLongClickDelete:" + equals);
        return equals;
    }

    public static boolean e() {
        boolean c16 = c("color_note_revision_v2_switch", false);
        QLog.i("ColorNoteToggle", 2, "useNewColorNoteStyle feature switch:" + c16);
        return c16;
    }
}
