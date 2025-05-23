package com.tencent.guild.api.ark;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/ark/IGuildArkApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "canReply", "", "appName", "", QQCustomArkDialogUtil.APP_VIEW, ark.APP_SPECIFIC_BIZSRC, "getAioConfigMaxHeight", "", "getApplicationCallback", "Lcom/tencent/ark/ark$ApplicationCallback;", "getCurrentAppConfig", "getMaxWidth", "getPlayerStubFactory", "Lcom/tencent/ark/ark$PlayerStubFactory;", "isEngineDisableHardwareRendering", "isOptimizeEnable", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildArkApi extends QRouteApi {
    boolean canReply(@Nullable String appName, @Nullable String appView, @Nullable String bizSrc);

    int getAioConfigMaxHeight();

    @NotNull
    ark.ApplicationCallback getApplicationCallback();

    @NotNull
    String getCurrentAppConfig();

    int getMaxWidth();

    @NotNull
    ark.PlayerStubFactory getPlayerStubFactory();

    boolean isEngineDisableHardwareRendering();

    boolean isOptimizeEnable();
}
