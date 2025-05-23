package com.tencent.bugly.common.hotpatch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;

/* loaded from: classes5.dex */
public class HotPatchWrapper {
    private static volatile HotPatchWrapper instance;
    private String hotPatchNumRFix = "";
    private String baseInHotfixRFix = "0";
    private String hotPatchNumCustom = "";

    HotPatchWrapper() {
    }

    public static HotPatchWrapper getInstance() {
        if (instance == null) {
            synchronized (HotPatchWrapper.class) {
                if (instance == null) {
                    instance = new HotPatchWrapper();
                }
            }
        }
        return instance;
    }

    public String getAppHotPatchNum() {
        if (!TextUtils.isEmpty(this.hotPatchNumRFix)) {
            return this.hotPatchNumRFix;
        }
        return this.hotPatchNumCustom;
    }

    public String getBaseInHotfixRFix() {
        return this.baseInHotfixRFix;
    }

    public void setHotPatchInfoFromSp(Context context) {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(context, Constants.BUGLY_SHARED_PREFERENCES, true);
        if (sharedPreferences != null) {
            this.hotPatchNumRFix = sharedPreferences.getString(Constants.HOT_PATCH_NUM, "");
            this.baseInHotfixRFix = sharedPreferences.getString(Constants.BASE_IN_HOTFIX, "0");
        }
    }

    public void setHotPatchNumCustom(String str) {
        this.hotPatchNumCustom = str;
    }
}
