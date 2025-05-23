package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.v8rt.anno.NotNull;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQGuildUtilApi extends QRouteApi {
    @NonNull
    String accountUin();

    Context appContext();

    @NonNull
    AppInterface appInterface();

    @NonNull
    AppRuntime appRuntime();

    boolean canSpeakInChannel(IGProChannelInfo iGProChannelInfo);

    boolean checkSecurityValid(IGProSecurityResult iGProSecurityResult);

    long generateMsgUniqueId();

    @NotNull
    Fragment getGProWaitLogicFragment();

    String getGuildAvatarUrlIPC(String str, int i3);

    Drawable getGuildFaceIcon(String str, int i3, Drawable drawable, boolean z16);

    @Nullable
    IGProChannelInfo getSubChannel(String str);

    void gotoChannelDirectly(String str, String str2, Bundle bundle);

    void handleJoinGuildError(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult);

    Boolean hasTargetSecondaryPermission(int i3, String str, String str2);

    boolean isAdminUser(IGProUserInfo iGProUserInfo);

    boolean isChannelLevelAdmin(String str);

    boolean isEnableMarkdown();

    boolean isGProNotReady();

    boolean isGuildAIOVisible();

    boolean isGuildOrChannelManager(String str, String str2);

    boolean isInNightTheme();

    boolean isManageReportEnabled();

    boolean isPerformanceReportEnabled();

    boolean isQQGuildManager(IGProGuildInfo iGProGuildInfo);

    boolean isRecentChannelHeadExperiment();

    boolean isShowSetGlobalTop();

    boolean isTroopGuildUpgradeSwitchOn();

    void loadBackgroundImage(String str, View view);

    void loadImage(String str, ImageView imageView);

    void loadImageWithLoading(String str, ImageView imageView, Drawable drawable);

    void noteTextChannelStatus(boolean z16);

    void notifyDirectMsgSwitchStatus(boolean z16);

    void notifyForwardFinish();

    void preloadWebProcess();

    <T extends IRuntimeService> T runtimeService(@NonNull Class<T> cls);

    <T extends IRuntimeService> T runtimeService(@NonNull Class<T> cls, String str);

    void setMetricDefaultAttributes(Map<String, String> map);

    void startH5Activity(Activity activity, String str);

    void telemetryReport(GuildTelemetryTask guildTelemetryTask, Map<GuildTelemetryAttributes, String> map);

    void toastError(@NonNull Activity activity, int i3, String str);
}
