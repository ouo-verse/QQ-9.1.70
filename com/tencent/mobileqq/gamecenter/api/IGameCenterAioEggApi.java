package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameCenterAioEggApi extends QRouteApi {
    void jumpWeb(Context context, String str, int i3, String str2, Bundle bundle);

    void triggerEggReq(boolean z16, int i3, int i16, String str, String str2, String str3, String str4);
}
