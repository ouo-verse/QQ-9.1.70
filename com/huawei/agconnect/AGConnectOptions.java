package com.huawei.agconnect;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AGConnectOptions {
    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z16);

    Context getContext();

    String getIdentifier();

    int getInt(String str);

    int getInt(String str, int i3);

    String getPackageName();

    AGCRoutePolicy getRoutePolicy();

    String getString(String str);

    String getString(String str, String str2);
}
