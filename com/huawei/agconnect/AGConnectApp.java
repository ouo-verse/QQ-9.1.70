package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.a;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public abstract class AGConnectApp {
    public static AGConnectApp getInstance() {
        return a.a();
    }

    public static AGConnectApp initialize(Context context) {
        return a.a(context);
    }

    public abstract void setApiKey(String str);

    public abstract void setAppId(String str);

    public abstract void setClientId(String str);

    public abstract void setClientSecret(String str);

    public abstract void setCpId(String str);

    public abstract void setCustomAuthProvider(CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(String str, String str2);

    public abstract void setProductId(String str);

    private static AGConnectApp getInstance(String str) {
        return a.a(str);
    }

    private static AGConnectApp initialize(Context context, String str) {
        return a.a(context, str);
    }
}
