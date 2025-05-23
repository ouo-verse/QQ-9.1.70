package com.tencent.aelight.camera.aioeditor.share;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"peak"})
/* loaded from: classes32.dex */
public interface IAIOShareHelper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(boolean z16, int i3, String str, pr.a aVar);
    }

    void dismissLoading();

    void shareToQQ(Activity activity, int i3, String str, pr.a aVar);

    void shareToQZone(Activity activity, pr.a aVar);

    void shareToWX(Activity activity, int i3, String str, pr.a aVar, a aVar2);

    void showLoading(Activity activity);
}
