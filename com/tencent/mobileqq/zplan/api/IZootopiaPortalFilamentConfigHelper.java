package com.tencent.mobileqq.zplan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZootopiaPortalFilamentConfigHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "refreshConfig", "Lcom/tencent/mobileqq/zplan/api/a;", "configData", "loadConfig", "", "enableFilament", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaPortalFilamentConfigHelper extends QRouteApi {
    boolean enableFilament();

    void loadConfig(@Nullable a configData);

    void refreshConfig();
}
