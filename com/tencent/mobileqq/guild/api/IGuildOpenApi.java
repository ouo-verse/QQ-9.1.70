package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes12.dex */
public interface IGuildOpenApi extends IRuntimeService {
    QQGuildOpenData getGuildOpenDataFromApp(String str);

    void gotoGuildOpenCreateAction(Activity activity, String str, String str2, QQGuildOpenData qQGuildOpenData);

    void handleBackToAppDialog(Activity activity, String str, Bundle bundle);

    void handleEnterToTroop(String str, String str2);

    void handleGuildOpenResult(String str, String str2);

    void handleGuildOpenResult(String str, String str2, long j3, String str3);

    void handleTroopBackToAppDialog(Activity activity, Bundle bundle);

    void setPackageSchemeData(String str, String str2, QQGuildOpenData qQGuildOpenData);
}
