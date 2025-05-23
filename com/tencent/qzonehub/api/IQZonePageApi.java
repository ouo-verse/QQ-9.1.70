package com.tencent.qzonehub.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZonePageApi extends QRouteApi {
    void checkExceptionWhetherCauseByFeedx(String str);

    Intent checkIntentRedirect(Context context, String str, Intent intent);

    Boolean getCangLanConfig(String str, boolean z16);

    String getCangLanConfig(String str, String str2);

    String getLebaEntranceText();

    boolean isQZonePage(Context context);

    boolean isQZonePage(String str);

    boolean isQzoneFeedProPage();

    void jumpQZMomentPublishPage(@NonNull Bundle bundle);

    void openDebugPage(Context context);

    void preloadQzoneResource(Intent intent);
}
