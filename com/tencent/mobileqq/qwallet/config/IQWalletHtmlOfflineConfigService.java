package com.tencent.mobileqq.qwallet.config;

import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletHtmlOfflineConfigService extends QRouteApi {
    void setShengpiziTypeface(TextView textView);
}
