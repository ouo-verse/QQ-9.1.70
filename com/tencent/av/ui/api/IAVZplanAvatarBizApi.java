package com.tencent.av.ui.api;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface IAVZplanAvatarBizApi extends QRouteApi {
    void changeAvatarLayout(boolean z16, boolean z17);

    void init(Context context);

    void onConnect();

    void onDestroy();

    void onNotifyPeerZplanAvatarSupport(boolean z16);

    void onNotifyPeerZplanAvatarSupportTips();

    void onNotifyPeerZplanAvatarSwitch(String str, boolean z16, String str2);

    void onNotifySelfZplanAvatarSwitch(boolean z16);

    void onNotifyUpdateZplanAvatarFakeBackground(boolean z16);

    void onNotifyUpdateZplanAvatarLoadingProgress(int i3);

    void onNotifyUpdateZplanAvatarLoadingView(boolean z16, boolean z17);

    void onNotifyZplanAvatarSwitchLayoutBtn();

    void onNotifyZplanAvatarTryTips();

    boolean onReopenCamera(int i3, int i16);

    void switchFilamentViewMode(SessionInfo sessionInfo, boolean z16);
}
