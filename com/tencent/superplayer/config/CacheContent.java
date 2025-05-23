package com.tencent.superplayer.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CacheContent {
    private static final String TAG = "CacheContent";
    private static final String TRUE_REG = "^(1|true)$";
    public String originGroupName;
    private SharedPreferences sharedPreferences;

    CacheContent() {
    }

    private boolean serverConfigEnable() {
        if (SuperPlayerSDKMgr.getSdkOption() != null) {
            return SuperPlayerSDKMgr.getSdkOption().serverConfigEnable;
        }
        return false;
    }

    public boolean getBoolean(String str, boolean z16) {
        if (!serverConfigEnable()) {
            return z16;
        }
        String string = this.sharedPreferences.getString(str, String.valueOf(z16));
        if (TextUtils.isEmpty(string)) {
            return z16;
        }
        return string.matches(TRUE_REG);
    }

    public int getInt(String str, int i3) {
        if (!serverConfigEnable()) {
            return i3;
        }
        try {
            return Integer.parseInt(this.sharedPreferences.getString(str, String.valueOf(i3)));
        } catch (Exception e16) {
            LogUtil.e(TAG, "getInt error,", e16);
            return i3;
        }
    }

    public String getString(String str, String str2) {
        if (!serverConfigEnable()) {
            return str2;
        }
        return this.sharedPreferences.getString(str, str2);
    }

    public boolean isValidate() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null && !(sharedPreferences instanceof EmptySharedPreferences)) {
            return true;
        }
        return false;
    }

    public void save(String str) {
        try {
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    edit.putString(jSONObject.optString("key"), jSONObject.optString("value"));
                }
            }
            edit.apply();
        } catch (JSONException e16) {
            LogUtil.e(TAG, "save error", e16);
        }
    }

    public CacheContent(String str) {
        this.originGroupName = str;
        if (SuperPlayerSDKMgr.getContext() != null) {
            this.sharedPreferences = SuperPlayerSDKMgr.getContext().getSharedPreferences(str, 0);
        }
        if (this.sharedPreferences == null) {
            this.sharedPreferences = new EmptySharedPreferences();
            LogUtil.w(TAG, "sharedPreferences is null, init EmptySharedPreferences");
        }
    }
}
