package com.tencent.mtt.hippy.adapter.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes20.dex */
public class DefaultSharedPreferencesAdapter implements HippySharedPreferencesAdapter {
    private final Context mContext;

    public DefaultSharedPreferencesAdapter(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter
    public SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences("hippy_sdk_configs", 0);
    }
}
