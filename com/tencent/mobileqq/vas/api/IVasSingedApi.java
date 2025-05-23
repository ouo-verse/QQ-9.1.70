package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vip.IVipStatusManager;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = true, process = {"all"})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasSingedApi;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "getVipStatus", "()Lcom/tencent/mobileqq/vip/IVipStatusManager;", "vipStatus", "Lcom/tencent/mobileqq/floatscr/b;", "getColorScreen", "()Lcom/tencent/mobileqq/floatscr/b;", ColorScreenJsPlugin.BUSINESS_NAME, "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IVasSingedApi extends IRuntimeService {
    @NotNull
    com.tencent.mobileqq.floatscr.b getColorScreen();

    @NotNull
    IVipStatusManager getVipStatus();
}
