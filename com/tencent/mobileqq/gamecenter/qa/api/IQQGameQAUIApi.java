package com.tencent.mobileqq.gamecenter.qa.api;

import com.tencent.aio.api.factory.g;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import sd1.e;
import vd1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGameQAUIApi extends QRouteApi {
    void bindQAUI(int i3);

    g createGameQAAioFactory();

    String getAioFactoryName();

    int getAppid(int i3);

    int getChatListTopMargin(int i3);

    Class getJumpParserClass();

    void onCreate(int i3, e eVar);

    void onDestroy(int i3);

    void onInputPanelChanged(int i3, boolean z16);

    void onPause(int i3);

    void onResume(int i3);

    void updateSession(int i3, b bVar);
}
