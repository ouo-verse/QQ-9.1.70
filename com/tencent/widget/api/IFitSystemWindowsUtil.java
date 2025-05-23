package com.tencent.widget.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes27.dex */
public interface IFitSystemWindowsUtil extends QRouteApi {
    int getTopInset(View view);
}
