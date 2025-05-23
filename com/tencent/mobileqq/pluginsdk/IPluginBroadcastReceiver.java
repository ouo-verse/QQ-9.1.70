package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;

/* loaded from: classes16.dex */
public interface IPluginBroadcastReceiver {
    void IInit(String str, String str2, String str3, BroadcastReceiver broadcastReceiver, ClassLoader classLoader, PackageInfo packageInfo, int i3);

    void IOnReceive(Context context, Intent intent);
}
