package com.tencent.mobileqq.troop.redpoint.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.redpoint.c;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface IRedPointUtilsApi extends QRouteApi {
    void addRedPointListener(AppRuntime appRuntime, c cVar);

    void cleanRedPointInfoById(AppRuntime appRuntime, String str, String str2, int i3);

    void cleanRedPointInfoByIds(AppRuntime appRuntime, String str, String str2, List<Integer> list);

    void notifyRedPointViewClick(AppRuntime appRuntime, String str, String str2, View view);

    void removeRedPointListener(AppRuntime appRuntime, c cVar);

    void updateRedPointInfo(AppRuntime appRuntime, String str, String str2, int i3, int i16);
}
