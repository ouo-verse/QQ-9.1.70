package com.tencent.bugly.common.sp;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class SharedPreferencesProvider implements ISharedPreferencesProvider {
    private static final String TAG = "SPProvider";
    private static SharedPreferencesProvider instance;
    private ISharedPreferencesProvider proxy = null;
    private SharedPreferences multiProcessSP = null;

    SharedPreferencesProvider() {
    }

    public static SharedPreferencesProvider getInstance() {
        if (instance == null) {
            synchronized (SharedPreferencesProvider.class) {
                if (instance == null) {
                    instance = new SharedPreferencesProvider();
                }
            }
        }
        return instance;
    }

    public SharedPreferences getMultiProcessSP(Context context) {
        if (this.multiProcessSP == null) {
            this.multiProcessSP = getSharedPreferences(context, SPKey.SP_NAME, true);
        }
        return this.multiProcessSP;
    }

    @Override // com.tencent.bugly.common.sp.ISharedPreferencesProvider
    public SharedPreferences getSharedPreferences(Context context, String str, boolean z16) {
        int i3;
        ISharedPreferencesProvider iSharedPreferencesProvider = this.proxy;
        if (iSharedPreferencesProvider != null) {
            return iSharedPreferencesProvider.getSharedPreferences(context, str, z16);
        }
        if (context != null) {
            if (z16) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            return context.getSharedPreferences(str, i3);
        }
        return null;
    }

    public void setProvider(ISharedPreferencesProvider iSharedPreferencesProvider) {
        if (iSharedPreferencesProvider == this) {
            Logger.f365497g.e(TAG, "setProvider fail , can't set SharedPreferencesProvider self.");
        } else {
            this.proxy = iSharedPreferencesProvider;
        }
    }
}
