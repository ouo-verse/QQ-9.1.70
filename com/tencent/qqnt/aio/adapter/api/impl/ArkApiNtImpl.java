package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkAppConfig;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ArkApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IArkApi;", "()V", "getApplicationCallback", "Lcom/tencent/ark/ark$ApplicationCallback;", "getArkExtendInfo", "", "", "appName", ark.APP_SPECIFIC_BIZSRC, "getArkReplyConfig", "arkMsgJson", "Lorg/json/JSONObject;", "getArkReplyIcon", "getCurrentAppConfig", "getPlayerStubFactory", "Lcom/tencent/ark/ark$PlayerStubFactory;", "handleArkQuoteOpenUrl", "", "mAppType", "", "initArkEnv", "", "isEngineDisableHardwareRendering", "isSupportReply", QQCustomArkDialogUtil.APP_VIEW, "onThemeChange", "setScriptLeakCheckEnabled", NodeProps.ENABLED, "stopArkSilkAudio", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ArkApiNtImpl implements IArkApi {
    static IPatchRedirector $redirector_;

    public ArkApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @NotNull
    public ark.ApplicationCallback getApplicationCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ark.ApplicationCallback) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.ark.base.d();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @NotNull
    public Map<String, String> getArkExtendInfo(@NotNull String appName, @NotNull String bizSrc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Map) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appName, (Object) bizSrc);
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        Map<String, String> arkExtendInfo = ((IArkHelper) api).getArkExtendInfo(appName, bizSrc);
        if (arkExtendInfo == null) {
            return new HashMap();
        }
        return arkExtendInfo;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @NotNull
    public Map<String, String> getArkReplyConfig(@NotNull JSONObject arkMsgJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this, (Object) arkMsgJson);
        }
        Intrinsics.checkNotNullParameter(arkMsgJson, "arkMsgJson");
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        Map<String, String> arkReplyConfig = ((IArkHelper) api).getArkReplyConfig(arkMsgJson);
        if (arkReplyConfig == null) {
            return new HashMap();
        }
        return arkReplyConfig;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @NotNull
    public String getArkReplyIcon(@NotNull JSONObject arkMsgJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) arkMsgJson);
        }
        Intrinsics.checkNotNullParameter(arkMsgJson, "arkMsgJson");
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        String arkReplyIcon = ((IArkHelper) api).getArkReplyIcon(arkMsgJson);
        if (arkReplyIcon == null) {
            return "";
        }
        return arkReplyIcon;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @Nullable
    public String getCurrentAppConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QRouteApi api = QRoute.api(IArkAppConfig.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkAppConfig>(IArkAppConfig::class.java)");
        return ((IArkAppConfig) api).getCurrentAppConfig();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    @NotNull
    public ark.PlayerStubFactory getPlayerStubFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ark.PlayerStubFactory) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ark.PlayerStubFactory sFactory = ArkMediaPlayer.F;
        Intrinsics.checkNotNullExpressionValue(sFactory, "sFactory");
        return sFactory;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public boolean handleArkQuoteOpenUrl(int mAppType, @NotNull JSONObject arkMsgJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, mAppType, (Object) arkMsgJson)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(arkMsgJson, "arkMsgJson");
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        return ((IArkHelper) api).handleArkQuoteOpenUrl(mAppType, arkMsgJson);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public void initArkEnv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IArkEnvironment.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkEnvironment>(IArkEnvironment::class.java)");
        ((IArkEnvironment) api).initMultiProcEnv((IArkEnvDelegate) QRoute.api(IArkEnvDelegate.class), false);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public boolean isEngineDisableHardwareRendering() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public boolean isSupportReply(@NotNull String appName, @NotNull String appView, @NotNull String bizSrc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, appName, appView, bizSrc)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appView, "appView");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        return ((IArkHelper) api).isSupportReply(appName, appView, bizSrc);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public void onThemeChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        ((IArkHelper) api).onThemeChange();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public void setScriptLeakCheckEnabled(boolean enabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, enabled);
            return;
        }
        QRouteApi api = QRoute.api(IArkEnvironment.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkEnvironment>(IArkEnvironment::class.java)");
        ((IArkEnvironment) api).setScriptLeakCheckEnabled(enabled);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IArkApi
    public void stopArkSilkAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IArkHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IArkHelper>(IArkHelper::class.java)");
        ((IArkHelper) api).stopArkSilkAudio();
    }
}
