package com.tencent.mobileqq.guild.robot.components.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInGuildParams;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.QQCustomArkDialogUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {
    public static void a(Activity activity, RobotInfo robotInfo) {
        RobotShareInGuildParams robotShareInGuildParams = new RobotShareInGuildParams(String.valueOf(robotInfo.k()), String.valueOf(robotInfo.l()), robotInfo.j(), robotInfo.g(), robotInfo.f(), String.valueOf(robotInfo.a()));
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1052);
        intent.putExtra("call_by_forward", true);
        intent.putExtra("forward_ark_app_name", "com.tencent.guild.robot.share");
        intent.putExtra("forward_ark_app_view", "index");
        intent.putExtra("forward_ark_app_ver", "1.0.0.0");
        intent.putExtra("forward_ark_app_prompt", "\u3010\u5206\u4eab\u3011" + robotInfo.j());
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, "QQ\u673a\u5668\u4eba\u5206\u4eab");
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("forward_ark_app_meta", robotShareInGuildParams.e());
        Bundle bundle = new Bundle();
        bundle.putLong("req_share_id", 101979740L);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putString("appName", "com.tencent.guild.robot.share");
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "1.0.0.0");
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, "index");
        bundle.putString(QQCustomArkDialogUtil.META_DATA, robotShareInGuildParams.e());
        bundle.putFloat("scale", ViewUtils.getDensity());
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\"autosize\": 1, \"forward\": 1}");
        bundle.putLong("robot_id", robotInfo.k());
        bundle.putLong("robot_uin", robotInfo.l());
        bundle.putString("robot_name", robotInfo.j());
        bundle.putString("robot_desc", robotInfo.g());
        bundle.putString("robot_avatar", robotInfo.f());
        bundle.putLong("robot_appid", robotInfo.a());
        intent.putExtras(bundle);
        intent.putExtra("ROBOT_SHARE_PARAMS", robotShareInGuildParams);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass(), -1);
    }
}
