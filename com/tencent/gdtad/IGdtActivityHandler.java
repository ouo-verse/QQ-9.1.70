package com.tencent.gdtad;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtActivityHandler extends QRouteApi {
    void onActivityResult(WeakReference<Activity> weakReference, int i3, int i16, Intent intent);

    void onTopResumedActivityChanged(WeakReference<Activity> weakReference, boolean z16);
}
