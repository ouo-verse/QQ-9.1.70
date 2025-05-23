package com.tencent.mobileqq.automator.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IAutomatorApi extends QRouteApi {
    int getInActionLoginB();

    boolean isFirstLaunchNew();

    boolean isInRealActionLoginB();

    boolean isLogining();

    boolean isSyncNormalMsgFinish();

    boolean isSyncingMsg();
}
