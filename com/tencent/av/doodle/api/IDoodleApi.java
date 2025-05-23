package com.tencent.av.doodle.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IDoodleApi extends QRouteApi {
    View createDoodleSurfaceView(Context context);

    String getUnableTip(Context context);

    int getUnableTipResId();

    void hideDoodle(long j3, Activity activity);

    boolean isDoodleShow(long j3, Activity activity);

    boolean isDoodleUsable();

    void notifyAddDoodleSurfaceView();

    void restoreDoodle(long j3, Activity activity);

    int sendAVFunChatMsg(int i3, byte[] bArr);

    void showDoodle(long j3, Activity activity);
}
