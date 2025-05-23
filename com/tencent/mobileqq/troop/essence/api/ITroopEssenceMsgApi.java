package com.tencent.mobileqq.troop.essence.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.handler.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/essence/api/ITroopEssenceMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getEssenceMsgHandlerClz", "", "troopUin", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/qqnt/graytips/action/f;", "getGrayTipsToDetailsWebActionInfo", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopEssenceMsgApi extends QRouteApi {
    @NotNull
    Class<? extends b> getEssenceMsgHandlerClz();

    @NotNull
    f getGrayTipsToDetailsWebActionInfo(long troopUin, @NotNull String jumpUrl);
}
