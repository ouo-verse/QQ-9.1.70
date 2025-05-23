package com.tencent.mobileqq.stt.sub.api;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IVideoSubtitleDialog extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onDismiss(boolean z16);
    }

    void showEnableSubtitleDialog(Activity activity, a aVar);

    void showGuideBalloon(@NonNull View view, String str, int i3);
}
