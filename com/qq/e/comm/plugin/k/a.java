package com.qq.e.comm.plugin.k;

import android.annotation.SuppressLint;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;

/* compiled from: P */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f39612a = new Random(System.currentTimeMillis());

    public static String a(String str, String str2, String str3) {
        try {
            String format = String.format("%s@%s#%d#%s", str2, str, Long.valueOf(System.currentTimeMillis()), str3);
            int nextDouble = (int) (f39612a.nextDouble() * 100.0d);
            StringBuilder sb5 = new StringBuilder();
            String str4 = "1";
            sb5.append(nextDouble < a(Constants.KEYS.SDK_SERVER_GET_AD_REPORT_SAMPLING_RATE, 1) ? "1" : "0");
            sb5.append(nextDouble < a(Constants.KEYS.SDK_SERVER_EXP_REPORT_SAMPLING_RATE, 1) ? "1" : "0");
            if (nextDouble >= a(Constants.KEYS.SDK_SERVER_CLICK_REPORT_SAMPLING_RATE, 100)) {
                str4 = "0";
            }
            sb5.append(str4);
            sb5.append(format);
            return sb5.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "100";
        }
    }

    private static int a(String str, int i3) {
        SM sm5 = GDTADManager.getInstance().getSM();
        if (sm5 != null) {
            return sm5.getInteger(str, i3);
        }
        return 0;
    }
}
