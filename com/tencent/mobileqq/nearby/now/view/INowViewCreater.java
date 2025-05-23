package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INowViewCreater extends QRouteApi {
    IShortVideoCommentsView createShortVideoCommentsView(Context context);
}
