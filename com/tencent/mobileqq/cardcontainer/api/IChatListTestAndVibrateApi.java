package com.tencent.mobileqq.cardcontainer.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/IChatListTestAndVibrateApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "changeTestAndVibrateValue", "", "isSwitch", "", "getPublicAccountPluginSwitch", "getTestAndVibrateValue", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IChatListTestAndVibrateApi extends QRouteApi {
    void changeTestAndVibrateValue(boolean isSwitch);

    boolean getPublicAccountPluginSwitch();

    boolean getTestAndVibrateValue();
}
