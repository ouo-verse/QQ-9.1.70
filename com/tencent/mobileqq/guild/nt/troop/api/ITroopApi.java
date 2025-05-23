package com.tencent.mobileqq.guild.nt.troop.api;

import android.os.Bundle;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ITroopApi extends QRouteApi {
    void enterTroop(String str, QQGuildOpenData qQGuildOpenData);

    String extractPackageId(Bundle bundle);

    boolean isFromThirdApp(Bundle bundle);
}
