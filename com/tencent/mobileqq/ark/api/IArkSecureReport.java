package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkSecureReport extends QRouteApi {
    public static final int RESULT_CHECK = 2;
    public static final int RESULT_INVALID = 1;
    public static final int RESULT_VALID = 0;

    void reportAccumulatedValidURL(String str);

    void reportArkOpenUrl(String str, String str2, String str3);

    void reportNavigateURLAccess(String str, String str2, int i3, int i16, String str3);

    void reportOpenURLAccess(String str, String str2, int i3, int i16, String str3);

    void reportResourceURLAccess(String str, String str2, int i3, int i16, String str3);
}
