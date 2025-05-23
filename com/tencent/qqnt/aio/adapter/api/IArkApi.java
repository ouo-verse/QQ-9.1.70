package com.tencent.qqnt.aio.adapter.api;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0011H&J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\u0019\u001a\u00020\u0015H&J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0011H&J\b\u0010\u001c\u001a\u00020\u0015H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IArkApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getApplicationCallback", "Lcom/tencent/ark/ark$ApplicationCallback;", "getArkExtendInfo", "", "", "appName", ark.APP_SPECIFIC_BIZSRC, "getArkReplyConfig", "arkMsgJson", "Lorg/json/JSONObject;", "getArkReplyIcon", "getCurrentAppConfig", "getPlayerStubFactory", "Lcom/tencent/ark/ark$PlayerStubFactory;", "handleArkQuoteOpenUrl", "", "mAppType", "", "initArkEnv", "", "isEngineDisableHardwareRendering", "isSupportReply", QQCustomArkDialogUtil.APP_VIEW, "onThemeChange", "setScriptLeakCheckEnabled", NodeProps.ENABLED, "stopArkSilkAudio", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IArkApi extends QRouteApi {
    @NotNull
    ark.ApplicationCallback getApplicationCallback();

    @NotNull
    Map<String, String> getArkExtendInfo(@NotNull String appName, @NotNull String bizSrc);

    @NotNull
    Map<String, String> getArkReplyConfig(@NotNull JSONObject arkMsgJson);

    @NotNull
    String getArkReplyIcon(@NotNull JSONObject arkMsgJson);

    @Nullable
    String getCurrentAppConfig();

    @NotNull
    ark.PlayerStubFactory getPlayerStubFactory();

    boolean handleArkQuoteOpenUrl(int mAppType, @NotNull JSONObject arkMsgJson);

    void initArkEnv();

    boolean isEngineDisableHardwareRendering();

    boolean isSupportReply(@NotNull String appName, @NotNull String appView, @NotNull String bizSrc);

    void onThemeChange();

    void setScriptLeakCheckEnabled(boolean enabled);

    void stopArkSilkAudio();
}
