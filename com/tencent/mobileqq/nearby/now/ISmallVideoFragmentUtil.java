package com.tencent.mobileqq.nearby.now;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ISmallVideoFragmentUtil extends QRouteApi {
    void launch(Context context, Bundle bundle);

    void launch(Context context, String str);
}
