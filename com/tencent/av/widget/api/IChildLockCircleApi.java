package com.tencent.av.widget.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IChildLockCircleApi extends QRouteApi {
    void handleAnimSuccessMsg(Context context);

    void onAnimationEnd();

    void onAnimationFailed(Context context);

    boolean onLockSuccess(Context context);

    void startChildLockAnimation();

    boolean updateText(Context context);
}
