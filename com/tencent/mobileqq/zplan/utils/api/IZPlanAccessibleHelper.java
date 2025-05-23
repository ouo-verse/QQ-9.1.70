package com.tencent.mobileqq.zplan.utils.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import nk3.c;
import nk3.m;
import nk3.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J.\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH'J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0015H&J0\u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u001bH&J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0002H&J\u0012\u0010!\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0010H&J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0010H&J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH&\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/IZPlanAccessibleHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isZPlanEnable", "", "", "uins", "appids", "Lnk3/m;", "callback", "", "getZPlanWhiteListFromNet", "scene", "uin", "", "getZplanAccessible", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "getZplanAccessibleDetail", "getZplanAccessibleDetailFromCacheOnly", "isZPlanAccessible", "isZplanAccessibleWithoutSetting", "Lnk3/o;", "getZplanSmallHomeAccessible", "", "appIds", "", "fromScene", "Lnk3/c;", "addZPlanWhiteList", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "forceUpload", "uploadPhoneType", "refreshAccessibleRegularly", "updateAllSceneAccessible", "detailResult", "updateCache", "enableZPlanNativeAppFilament", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAccessibleHelper extends QRouteApi {
    void addZPlanWhiteList(long uin, @NotNull List<Long> appIds, @NotNull String fromScene, @Nullable c callback);

    boolean enableZPlanNativeAppFilament(int scene);

    @Deprecated(message = "\u8001\u63a5\u53e3\uff0c\u65b0\u4e1a\u52a1\u5efa\u8bae\u4e0d\u518d\u4f7f\u7528")
    void getZPlanWhiteListFromNet(@NotNull List<Long> uins, @NotNull List<Long> appids, @Nullable m callback);

    int getZplanAccessible(long scene, long uin);

    @Nullable
    AccessibleDetail getZplanAccessibleDetail(long scene, long uin);

    @Nullable
    AccessibleDetail getZplanAccessibleDetailFromCacheOnly(long scene, long uin);

    void getZplanSmallHomeAccessible(long uin, @NotNull o callback);

    boolean isZPlanAccessible(long scene, long uin);

    boolean isZPlanEnable();

    boolean isZplanAccessibleWithoutSetting(long scene, long uin);

    void refreshAccessibleRegularly(@Nullable AppInterface appRuntime);

    void updateAllSceneAccessible(@NotNull AppInterface appRuntime);

    void updateCache(long uin, @NotNull AccessibleDetail detailResult);

    void updateCache(@NotNull AccessibleDetail detailResult);

    void uploadPhoneType(@NotNull AppInterface appRuntime, boolean forceUpload);
}
