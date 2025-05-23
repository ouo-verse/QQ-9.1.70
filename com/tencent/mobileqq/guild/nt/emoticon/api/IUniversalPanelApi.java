package com.tencent.mobileqq.guild.nt.emoticon.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IUniversalPanelApi extends QRouteApi {

    /* loaded from: classes14.dex */
    public static class a {
    }

    View createPanel(a aVar, av1.a aVar2);
}
