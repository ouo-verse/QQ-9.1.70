package com.tencent.mobileqq.avatar.api;

import android.content.Context;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQNonMainProcAvatarLoaderApi extends QRouteApi {
    f getNonMainAppHeadLoader(Context context, int i3);
}
