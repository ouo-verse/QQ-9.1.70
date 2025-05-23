package com.tencent.mobileqq.leba.business;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaRichApi extends QRouteApi {
    void applyThemeBg(AppRuntime appRuntime, View view, int i3, String str);

    boolean isShowQCircleEnter();
}
