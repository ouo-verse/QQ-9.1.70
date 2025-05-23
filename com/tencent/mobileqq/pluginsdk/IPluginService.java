package com.tencent.mobileqq.pluginsdk;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;

/* loaded from: classes16.dex */
public interface IPluginService {
    void IInit(String str, String str2, String str3, Service service, ClassLoader classLoader, PackageInfo packageInfo, int i3);

    IBinder IOnBind(Intent intent);

    void IOnCreate();

    void IOnDestroy();

    void IOnStart(Intent intent, int i3);

    int IOnStartCommand(Intent intent, int i3, int i16);

    boolean IOnUnbind(Intent intent);
}
