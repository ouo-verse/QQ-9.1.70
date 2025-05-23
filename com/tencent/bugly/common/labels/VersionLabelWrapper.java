package com.tencent.bugly.common.labels;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.rmonitor.custom.a;
import com.tencent.rmonitor.custom.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VersionLabelWrapper {
    public static final String SHIPLY_VERSION_LABEL_KEY = "RDelivery";

    public static String getCaseLabels() {
        return join(b.a().l("a13"));
    }

    private static String getShiplyVersionLabelFromSp() {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(ContextUtil.getGlobalContext(), Constants.BUGLY_SHARED_PREFERENCES, true);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(Constants.SP_SHIPLY_VERSION_INFO, "");
    }

    public static String getTestLabels() {
        return join(b.a().l("a12"));
    }

    public static String initShiplyVersionLabel() {
        String shiplyVersionLabelFromSp = getShiplyVersionLabelFromSp();
        setLabels("a11", shiplyVersionLabelFromSp);
        return shiplyVersionLabelFromSp;
    }

    private static String join(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            for (String str : list) {
                if (i3 > 0) {
                    sb5.append("|");
                }
                sb5.append(str);
                i3++;
            }
            return sb5.toString();
        }
        return "";
    }

    public static void setCaseLabels(String str) {
        setLabels("a13", str);
    }

    private static void setLabels(String str, String str2) {
        a a16 = b.a();
        a16.f(str);
        if (!TextUtils.isEmpty(str2)) {
            for (String str3 : str2.split("\\|")) {
                a16.e(str, str3);
            }
        }
    }

    public static void setShiplyVersionLabel(String str) {
        setShiplyVersionLabelToSp(str);
        setLabels("a11", str);
    }

    private static void setShiplyVersionLabelToSp(String str) {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(ContextUtil.getGlobalContext(), Constants.BUGLY_SHARED_PREFERENCES, true);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(Constants.SP_SHIPLY_VERSION_INFO, str);
            edit.apply();
        }
    }

    public static void setTestLabels(String str) {
        setLabels("a12", str);
    }
}
