package com.tencent.mobileqq.apollo.game.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/apollo/game/api/ICmGameHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createGameAppInterface", "Lcom/tencent/common/app/AppInterface;", "app", "Lmqq/app/MobileQQ;", "processName", "", "getAppInterface", "cmshow_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ICmGameHelper extends QRouteApi {
    @NotNull
    AppInterface createGameAppInterface(@NotNull MobileQQ app, @NotNull String processName);

    @Nullable
    AppInterface getAppInterface();
}
