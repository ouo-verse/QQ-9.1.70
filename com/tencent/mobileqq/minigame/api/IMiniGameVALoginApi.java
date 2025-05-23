package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.minigame.va.GameLoginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVALoginApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLoginInfo", "", PushClientConstants.TAG_PKG_NAME, "", "forceUpdate", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/minigame/va/GameLoginInfo;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVALoginApi extends QRouteApi {
    void getLoginInfo(@NotNull String pkgName, boolean forceUpdate, @NotNull Function1<? super GameLoginInfo, Unit> callback);
}
