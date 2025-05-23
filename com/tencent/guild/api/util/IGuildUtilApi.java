package com.tencent.guild.api.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import hr0.b;
import hr0.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH&J&\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH&J4\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH&J@\u0010\u001f\u001a\u00020\u000b2&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH&J@\u0010!\u001a\u00020\u000b2&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0016H&J*\u0010'\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006H&J\b\u0010(\u001a\u00020\u0002H&J\b\u0010)\u001a\u00020\u0002H&J\b\u0010*\u001a\u00020\u0006H&J\b\u0010,\u001a\u00020+H&J\b\u0010-\u001a\u00020\u0006H&J\b\u0010.\u001a\u00020\u0002H&J\u0010\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H&J\n\u00104\u001a\u0004\u0018\u000103H&JT\u0010:\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010\u00062\u0006\u00107\u001a\u00020\u00022&\u00108\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001a2\u0006\u00109\u001a\u00020\u0002H&J \u0010>\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\bH&J\b\u0010?\u001a\u00020\u000bH&J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@H&J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0002H&J\u0010\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0006H&J\b\u0010G\u001a\u00020\u0002H&J\u001a\u0010I\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006J"}, d2 = {"Lcom/tencent/guild/api/util/IGuildUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isSimpleUIMode", "Landroid/content/Context;", "context", "", "libName", "", "version", "includePrivateLib", "", "loadNativeLibrary", "isNowThemeIsNight", QQBrowserActivity.KEY_MSG_TYPE, "isGuildWalletMsgType", "isMyPersonalGuildWalletMsgType", "Ljava/util/ArrayList;", "names", "pubPolicy", "grayPolicy", "onRegisterCountInstruments", "", "boundaries", "onRegisterValueInstrumentsWithBoundary", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "label", "name", "", "count", "onReportCountIndicators", "value", "onReportValueIndicators", "Landroid/content/Intent;", "intent", "channelId", "msgCount", "msgs", "fillJubaoIntent", "isSdkEnable", "isColorUser", "getAppVersion", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "getNetworkType", "getNetworkName", "isApplicationForeground", "Lhr0/b;", "cb", "Lhr0/c;", "createGuardManagerDelegate", "", DeviceInfoPlugin.API_GET_GUID, "uid", "eventCode", "isSuc", "params", "isHighPriority", "beaconReport", "", "msg", "duration", UIJsPlugin.EVENT_SHOW_TOAST, "onThemeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "guildTab", "onTabChanged", "factoryName", "needCheckSourceChannelIsValid", "isGuildUser", "url", "openNormalUrl", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildUtilApi extends QRouteApi {
    void beaconReport(@Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isHighPriority);

    @NotNull
    c createGuardManagerDelegate(@NotNull b cb5);

    void fillJubaoIntent(@Nullable Intent intent, @NotNull String channelId, int msgCount, @NotNull String msgs);

    @NotNull
    String getAppVersion();

    @Nullable
    byte[] getGUID();

    @NotNull
    String getNetworkName();

    @NotNull
    NetStatusType getNetworkType();

    boolean isApplicationForeground();

    boolean isColorUser();

    boolean isGuildUser();

    boolean isGuildWalletMsgType(int msgType);

    boolean isMyPersonalGuildWalletMsgType(int msgType);

    boolean isNowThemeIsNight();

    boolean isSdkEnable();

    boolean isSimpleUIMode();

    void loadNativeLibrary(@NotNull Context context, @NotNull String libName, int version, boolean includePrivateLib);

    boolean needCheckSourceChannelIsValid(@NotNull String factoryName);

    void onConfigurationChanged(@NotNull Configuration newConfig);

    void onRegisterCountInstruments(@NotNull ArrayList<String> names, int pubPolicy, int grayPolicy);

    void onRegisterValueInstrumentsWithBoundary(@NotNull ArrayList<String> names, @NotNull ArrayList<Double> boundaries, int pubPolicy, int grayPolicy);

    void onReportCountIndicators(@Nullable HashMap<String, String> label, @NotNull String name, long count);

    void onReportValueIndicators(@Nullable HashMap<String, String> label, @NotNull String name, double value);

    void onTabChanged(boolean guildTab);

    void onThemeChanged();

    void openNormalUrl(@NotNull Context context, @Nullable String url);

    void showToast(@NotNull Context context, @NotNull CharSequence msg2, int duration);
}
