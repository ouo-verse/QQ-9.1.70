package com.tencent.guild.api.util.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.configuration.GuildConfigurationManager;
import com.tencent.guild.api.tab.QQGuildTabManager;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import hr0.a;
import hr0.b;
import hr0.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vk2.QWalletMsgModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bL\u0010MJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0016J0\u0010\u0018\u001a\u00020\r2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0013j\b\u0012\u0004\u0012\u00020\u0003`\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016JH\u0010\u001b\u001a\u00020\r2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0013j\b\u0012\u0004\u0012\u00020\u0003`\u00142\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0013j\b\u0012\u0004\u0012\u00020\u0019`\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J@\u0010\"\u001a\u00020\r2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u001d2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016J.\u0010$\u001a\u00020\r2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0019H\u0016J*\u0010*\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0002H\u0016JT\u0010<\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u00032\b\u00108\u001a\u0004\u0018\u00010\u00032\u0006\u00109\u001a\u00020\u00052&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u001d2\u0006\u0010;\u001a\u00020\u0005H\u0016J \u0010@\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\r2\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0003H\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\u001a\u0010K\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006N"}, d2 = {"Lcom/tencent/guild/api/util/impl/GuildUtilApiImpl;", "Lcom/tencent/guild/api/util/IGuildUtilApi;", "", "", "toHexStr", "", "isSimpleUIMode", "Landroid/content/Context;", "context", "libName", "", "version", "includePrivateLib", "", "loadNativeLibrary", "isNowThemeIsNight", QQBrowserActivity.KEY_MSG_TYPE, "isGuildWalletMsgType", "isMyPersonalGuildWalletMsgType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "names", "pubPolicy", "grayPolicy", "onRegisterCountInstruments", "", "boundaries", "onRegisterValueInstrumentsWithBoundary", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "label", "name", "", "count", "onReportCountIndicators", "value", "onReportValueIndicators", "Landroid/content/Intent;", "intent", "channelId", "msgCount", "msgs", "fillJubaoIntent", "isSdkEnable", "isColorUser", "getAppVersion", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "getNetworkType", "getNetworkName", "isApplicationForeground", "Lhr0/b;", "cb", "Lhr0/c;", "createGuardManagerDelegate", DeviceInfoPlugin.API_GET_GUID, "uid", "eventCode", "isSuc", "params", "isHighPriority", "beaconReport", "", "msg", "duration", UIJsPlugin.EVENT_SHOW_TOAST, "onThemeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "guildTab", "onTabChanged", "factoryName", "needCheckSourceChannelIsValid", "isGuildUser", "url", "openNormalUrl", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildUtilApiImpl implements IGuildUtilApi {
    private final String toHexStr(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb5.append(hexString);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void beaconReport(@Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isHighPriority) {
        QQBeaconReport.report(uid, eventCode, isSuc, params, isHighPriority);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    @NotNull
    public c createGuardManagerDelegate(@NotNull b cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return new a(cb5);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void fillJubaoIntent(@Nullable Intent intent, @NotNull String channelId, int msgCount, @NotNull String msgs) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).fillJubaoIntent(intent, channelId, msgCount, msgs);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    @NotNull
    public String getAppVersion() {
        String subVersion = ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
        if (subVersion == null) {
            return "";
        }
        return subVersion;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    @Nullable
    public byte[] getGUID() {
        WtloginManager wtloginManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        Manager manager = peekAppRuntime.getManager(1);
        if (manager instanceof WtloginManager) {
            wtloginManager = (WtloginManager) manager;
        } else {
            wtloginManager = null;
        }
        if (wtloginManager == null) {
            return null;
        }
        return wtloginManager.getGUID();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    @NotNull
    public String getNetworkName() {
        String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
        Intrinsics.checkNotNullExpressionValue(c16, "getApnName(CommonDataAda\u2026er.getInstance().context)");
        return c16;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    @NotNull
    public NetStatusType getNetworkType() {
        int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
        if (networkType != 0) {
            if (networkType != 1) {
                if (networkType != 2) {
                    if (networkType != 3) {
                        if (networkType != 4) {
                            if (networkType != 6) {
                                return NetStatusType.KREACHABLEUNKNOWN;
                            }
                            return NetStatusType.KREACHABLEVIA5G;
                        }
                        return NetStatusType.KREACHABLEVIA4G;
                    }
                    return NetStatusType.KREACHABLEVIA3G;
                }
                return NetStatusType.KREACHABLEVIA2G;
            }
            return NetStatusType.KREACHABLEVIAWIFI;
        }
        return NetStatusType.KNOTREACHABLE;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isApplicationForeground() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return true;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isColorUser() {
        return ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).isColorUser();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isGuildUser() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((IGuildUserService) peekAppRuntime.getRuntimeService(IGuildUserService.class, "")).isGuildUser();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isGuildWalletMsgType(int msgType) {
        return QWalletMsgModel.INSTANCE.a().contains(Integer.valueOf(msgType));
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isMyPersonalGuildWalletMsgType(int msgType) {
        if (31 == msgType) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isNowThemeIsNight() {
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isSdkEnable() {
        return ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).isSdkEnable();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean isSimpleUIMode() {
        return QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void loadNativeLibrary(@NotNull Context context, @NotNull String libName, int version, boolean includePrivateLib) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(libName, "libName");
        SoLoadUtil.m(context, libName, 0, false);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public boolean needCheckSourceChannelIsValid(@NotNull String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        if (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(factoryName) == 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        GuildConfigurationManager.f112488a.b(newConfig);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onRegisterCountInstruments(@NotNull ArrayList<String> names, int pubPolicy, int grayPolicy) {
        Intrinsics.checkNotNullParameter(names, "names");
        ai2.b.f26109a.e(names, pubPolicy, grayPolicy);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onRegisterValueInstrumentsWithBoundary(@NotNull ArrayList<String> names, @NotNull ArrayList<Double> boundaries, int pubPolicy, int grayPolicy) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(boundaries, "boundaries");
        ai2.b.f26109a.g(names, boundaries, pubPolicy, grayPolicy);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onReportCountIndicators(@Nullable HashMap<String, String> label, @NotNull String name, long count) {
        Intrinsics.checkNotNullParameter(name, "name");
        ai2.b.f26109a.h(label, name, count);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onReportValueIndicators(@Nullable HashMap<String, String> label, @NotNull String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        ai2.b.f26109a.i(label, name, value);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onTabChanged(boolean guildTab) {
        QQGuildTabManager.f112651a.b(guildTab);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void onThemeChanged() {
        QQGuildThemeManager.f112656a.b();
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void openNormalUrl(@NotNull Context context, @Nullable String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).openNormalUrl(context, url);
    }

    @Override // com.tencent.guild.api.util.IGuildUtilApi
    public void showToast(@NotNull Context context, @NotNull CharSequence msg2, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (((IAppSetting) QRoute.api(IAppSetting.class)).debug()) {
            QQToast.makeText(context, msg2, duration).show();
        }
    }
}
