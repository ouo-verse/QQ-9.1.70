package com.tencent.mobileqq.springhb.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISpringLoongCardApi extends QRouteApi {
    View getLoadingView(@NonNull Context context);
}
