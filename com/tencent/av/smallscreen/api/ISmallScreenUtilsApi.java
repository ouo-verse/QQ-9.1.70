package com.tencent.av.smallscreen.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ISmallScreenUtilsApi extends QRouteApi {
    void actionOff(long j3, int i3, Context context);

    void actionOn(long j3, int i3, Context context, boolean z16, String str, boolean z17, boolean z18);

    int getFinishAnimId(int i3);

    boolean isLock(Context context);

    boolean isShareToastShow();

    boolean isSupportSmallScreen();

    boolean isSupportSmallScreenAudio();

    boolean isSupportSmallScreenVideo();

    boolean sendSmallScreenStateBroadcast(long j3, BaseVideoAppInterface baseVideoAppInterface, int i3);

    void startSetVisibleAnimation(View view, boolean z16, boolean z17);
}
