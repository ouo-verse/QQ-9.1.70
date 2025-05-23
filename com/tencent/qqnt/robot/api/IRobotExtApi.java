package com.tencent.qqnt.robot.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H&J$\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH&J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u000fH&J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000fH&J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH&J\f\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H&J \u0010&\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\nH&\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotExtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getRobotBaseHelpers", "Lmqq/app/AppRuntime;", "appRuntime", "uin", "", "fetchIfNotExist", "getBuddyName", "Landroid/content/Context;", "context", "", "status", "promptType", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "promptIcon", "", "handleOnBackendReply", "isNetWorkAvailable", "getSkinAIOPanelIconBgResId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "uinType", "shareRobotLocalPicToFriend", "shareRobotLocalPicToGuild", "", "createRobotSettingGroup", "Ljava/lang/Class;", "getRobotSettingGroupClass", PanoramaConfig.KEY_CURRENT_UIN, "currentUid", "isChecked", "setMsgNotDisturb", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotExtApi extends QRouteApi {
    @NotNull
    Object createRobotSettingGroup(@NotNull Context context);

    @Nullable
    String getBuddyName(@NotNull AppRuntime appRuntime, @Nullable String uin, boolean fetchIfNotExist);

    @NotNull
    Map<String, Function0<h>> getRobotBaseHelpers();

    @NotNull
    Class<?> getRobotSettingGroupClass();

    int getSkinAIOPanelIconBgResId();

    void handleOnBackendReply(@NotNull Context context, int status, int promptType, @NotNull String promptText, int promptIcon);

    boolean isNetWorkAvailable();

    void setMsgNotDisturb(@NotNull String currentUin, @NotNull String currentUid, boolean isChecked);

    void shareRobotLocalPicToFriend(@NotNull Activity activity, @NotNull Bundle bundle, @NotNull String uin, int uinType);

    void shareRobotLocalPicToGuild(@NotNull Activity activity, @NotNull Bundle bundle);
}
