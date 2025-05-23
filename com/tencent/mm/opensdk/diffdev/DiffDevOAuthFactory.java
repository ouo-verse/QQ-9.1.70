package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i3) {
        Log.v(TAG, "getDiffDevOAuth, version = " + i3);
        if (i3 > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + i3);
            return null;
        }
        if (i3 != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new a();
        }
        return v1Instance;
    }
}
