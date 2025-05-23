package com.tencent.mobileqq.z1.mod.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/z1/mod/api/impl/ZPlanPublicAccountLauncherApiImpl;", "Lcom/tencent/mobileqq/z1/mod/api/IZPlanPublicAccountLauncherApi;", "()V", "launchSmallHomeMainPageFromPublicAccount", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "extendInfo", "", "openSmallHomePublicAccountInfoPage", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanPublicAccountLauncherApiImpl implements IZPlanPublicAccountLauncherApi {
    @Override // com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi
    public void launchSmallHomeMainPageFromPublicAccount(BaseQQAppInterface app, Context context, String extendInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        QLog.i("ZPlanPublicAccount", 1, "launchSmallHomeMainPageFromPublicAccount, " + extendInfo);
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, "mqqapi://hippy/open?bundleName=QQSmallHouseCenter&domain=vip.qq.com&isAnimated=true&pathPluginType=3&url=https%3A%2F%2Ftq-act.vip.qq.com%2Findex.bundle%2Fhippyurl%3D%252F%253Ffrom%253Dzplan_entrance_gzh_xiaowo");
    }

    @Override // com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi
    public void openSmallHomePublicAccountInfoPage() {
        QLog.i("ZPlanPublicAccount", 1, "openSmallHomePublicAccountInfoPage");
        QRoute.createNavigator(BaseApplication.context, IPublicAccountDetailActivity.ROUTE_NAME).withString("uin", AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN).withInt("uintype", 1008).withInt("source", 116).request();
    }
}
