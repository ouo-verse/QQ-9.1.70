package com.tencent.mobileqq.zootopia.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaSpaceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ltb3/a;", "l", "", "registerZootopiaSpaceOccupyListener", "unRegisterZootopiaSpaceOccupyListener", "calculateZootopiaSpaceOccupy", "Ltb3/b;", "setZootopiaTaskDeleteListener", "", "id", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "onTaskDelete", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaSpaceApi extends QRouteApi {
    void calculateZootopiaSpaceOccupy();

    void onTaskDelete(@NotNull String id5, @NotNull ZootopiaSource source);

    void registerZootopiaSpaceOccupyListener(@NotNull tb3.a l3);

    void setZootopiaTaskDeleteListener(@Nullable tb3.b l3);

    void unRegisterZootopiaSpaceOccupyListener(@NotNull tb3.a l3);
}
