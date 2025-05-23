package com.tencent.mobileqq.simpleui.api;

import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISimpleUIUtil extends QRouteApi {
    void adjustSimpleStatusBar(ImmersiveTitleBar2 immersiveTitleBar2, Window window);

    void adjustSimpleStatusBar(SystemBarCompact systemBarCompact, Window window);

    boolean getSimpleUISwitch();
}
