package com.tencent.mobileqq.guild.robot.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import mqq.app.AppRuntime;
import uw1.a;
import vw1.d;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotPageApi extends QRouteApi {
    a createGuildRobotAtManager(Activity activity, ViewGroup viewGroup, AIOParam aIOParam, EditText editText, com.tencent.aio.api.runtime.a aVar);

    void handleSlashOnCommandItemClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull CommonBotInfo commonBotInfo, @NonNull CommonBotFeatureInfo commonBotFeatureInfo);

    void handleSlashOnServiceItemClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull CommonBotInfo commonBotInfo, @NonNull CommonBotFeatureInfo commonBotFeatureInfo);

    void handleSlashOnTitleClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull String str);

    boolean isDirectRobotAIO(@NonNull com.tencent.aio.api.runtime.a aVar);

    boolean isInlineSearchEnable(Context context);

    void jumpPermissionSettingPage(AppRuntime appRuntime, Context context, String str, String str2);

    void jumpRobotPushSettingPage(Context context, String str, String str2, int i3, int i16);

    void openRobotActiveMsgControlDialogFragment(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4);

    void openRobotAuthorizeFragment(@NonNull FragmentActivity fragmentActivity, @NonNull long j3, @NonNull long j16, @NonNull long j17, @NonNull String str, @NonNull d dVar, @NonNull int i3);

    void openRobotAuthorizeFragment(@NonNull FragmentActivity fragmentActivity, @NonNull long j3, @NonNull long j16, @NonNull long j17, @NonNull String str, @NonNull d dVar, @NonNull String str2);

    void openRobotFaqPage(Context context, String str);

    void reportRobotCommandJump(@NonNull View view);

    void reportSlashPageIn(@NonNull View view, @NonNull com.tencent.aio.api.runtime.a aVar);

    void reportSlashPageOut(@NonNull View view, @NonNull com.tencent.aio.api.runtime.a aVar);
}
