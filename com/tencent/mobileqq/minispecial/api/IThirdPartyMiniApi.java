package com.tencent.mobileqq.minispecial.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import g92.a;
import org.jetbrains.annotations.Nullable;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IThirdPartyMiniApi extends QRouteApi {
    @Nullable
    String getKuiklyConfigByExtInfo(String str);

    @Nullable
    a getMiniThirdPartyView(Activity activity, Object obj, int i3);

    int getThirdPartyEngineType(Object obj);

    boolean isExtInfoContainsMiniGameThirdPartyParams(Object obj);

    boolean isMiniHippy(Object obj);

    boolean isMiniKuikly(Object obj);

    boolean isMiniThirdPartyEngine(Object obj);
}
