package com.tencent.mobileqq.nearby.widget.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyUtilsDelegate extends QRouteApi {
    public static final boolean DEBUG = true;

    boolean equalsWithNullCheck(Object obj, Object obj2);

    boolean isNearbyModule();

    boolean isNetworkConnected(Context context);

    void printColorLevelLog(String str, Object... objArr);

    void printLog(String str, String str2, Object... objArr);

    void startBindPhonePageForResult(Activity activity, int i3);
}
