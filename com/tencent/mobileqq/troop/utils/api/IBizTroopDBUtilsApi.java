package com.tencent.mobileqq.troop.utils.api;

import GeneralSettings.Setting;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IBizTroopDBUtilsApi extends QRouteApi {
    void saveGeneralSettings(ArrayList<Setting> arrayList, AppInterface appInterface);

    void saveGeneralSettingsRevision(int i3, AppInterface appInterface);
}
