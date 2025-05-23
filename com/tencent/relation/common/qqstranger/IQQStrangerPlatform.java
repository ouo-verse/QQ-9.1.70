package com.tencent.relation.common.qqstranger;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.relation.common.qqstranger.component.a;
import org.jetbrains.annotations.NotNull;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQQStrangerPlatform extends QRouteApi {
    void checkRealName(Context context, @NotNull a aVar, int i3);
}
