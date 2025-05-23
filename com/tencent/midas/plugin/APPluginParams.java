package com.tencent.midas.plugin;

import android.app.Dialog;
import android.content.Intent;

/* loaded from: classes9.dex */
public class APPluginParams {
    public String mApkFilePath;
    public String mConponentName;
    public Dialog mDialog;
    public Intent mIntent;
    public String mPluginName;
    int mPluginType;
    public String mProgressTips;
    public Class<?> mProxyActivityClass;
    public int mRequestCode = -1;
    public boolean mDialogDismissBySDK = true;
    public int mTimeOut = 10000;

    public APPluginParams(int i3) {
        this.mPluginType = i3;
    }
}
