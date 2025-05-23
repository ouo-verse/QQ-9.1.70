package com.tencent.mobileqq.weiyun.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IOpenWeiyunVipHelper extends QRouteApi {
    public static final int REQUEST_CODE_OPEN_VIP = 2000;

    void closeLimitDialog();

    boolean isNonVipFlowOverErrorCode(int i3);

    boolean isNonVipSpaceOverErrorCode(int i3);

    boolean needShowLimitDialog(int i3);

    void showLimitDialog(Activity activity, int i3);

    void showWeiYunSpaceOrFlowLimitDialog(Activity activity, int i3);

    void startOpenQQVipH5(Activity activity, String str, boolean z16);

    void startOpenWeiyunVipCompareH5(Activity activity, String str, boolean z16);
}
