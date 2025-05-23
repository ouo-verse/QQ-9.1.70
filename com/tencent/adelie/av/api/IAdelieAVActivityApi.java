package com.tencent.adelie.av.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAdelieAVActivityApi extends QRouteApi {
    boolean isInAdelieAVRoom();

    boolean isOpenEntrance();

    void setClickTime(long j3);

    void startActivity(Context context, Intent intent);

    void startAudioCall(long j3, AppRuntime appRuntime, Context context, int i3, String str);
}
