package com.tencent.biz.pubaccount.weishi.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IWSMinePanel extends QRouteApi {
    void downloadWeishiWithDialog(Activity activity, boolean z16);

    void reportProfileCardExposure(boolean z16, String str);

    void reportProfilePageVisitEnter(String str, boolean z16);

    void reportProfilePageVisitExit(String str, boolean z16);

    void reportProfileSettingBtnClick(boolean z16);

    void reportProfileSettingExposure(boolean z16);

    void reportProfileSettingPageVisitEnter();

    void reportProfileSettingPageVisitExit();

    void reportWeiShiProfileClick(boolean z16, String str, boolean z17, boolean z18);
}
