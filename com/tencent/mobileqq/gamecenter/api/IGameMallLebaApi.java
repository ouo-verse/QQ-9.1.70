package com.tencent.mobileqq.gamecenter.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMallLebaApi extends QRouteApi {
    void reportLebaItemClick(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16);

    void reportLebaItemExpose(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16);
}
