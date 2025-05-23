package com.tencent.mobileqq.mvvm.api;

import android.app.Activity;
import com.tencent.mobileqq.mvvm.d;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILifeCycleFragmentInjectApi extends QRouteApi {
    d checkAndAddLifeCycleFragment(Activity activity);
}
