package com.tencent.mobileqq.nearby.now.utils;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IStorageCenter extends QRouteApi {
    boolean getBoolean(String str, boolean z16);

    float getFloat(String str, float f16);

    int getInt(String str, int i3);

    long getLong(String str, long j3);

    String getString(String str, String str2);

    void init(Context context, String str);

    void putBoolean(String str, boolean z16);

    void putFloat(String str, float f16);

    void putInt(String str, int i3);

    void putLong(String str, long j3);

    void putString(String str, String str2);

    void remove(String str);
}
