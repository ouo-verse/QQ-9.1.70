package com.tencent.mobileqq.qqlivehall.iv.api.hall;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQIvLiveEntranceApi extends QRouteApi {
    void dealDynamicLiveRedTouch(Context context, BaseQQAppInterface baseQQAppInterface, BusinessInfoCheckUpdate.AppInfo appInfo);

    @Nullable
    String getLiveHallJumpUrl(@Nullable String str, BusinessInfoCheckUpdate.AppInfo appInfo);
}
