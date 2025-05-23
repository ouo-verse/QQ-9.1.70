package com.tencent.mobileqq.troop.api;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isNewShareLinkSwitchOn", "", "parseArkJson", "Landroid/content/Intent;", "rspArkMessage", "", "useNewSharePanel", WadlProxyConsts.SCENE_ID, "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopShareApi extends QRouteApi {
    boolean isNewShareLinkSwitchOn();

    @NotNull
    Intent parseArkJson(@Nullable String rspArkMessage);

    boolean useNewSharePanel(@NotNull String sceneId);
}
