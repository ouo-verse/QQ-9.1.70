package com.tencent.mobileqq.guild.ipc.methods;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ab extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        QLog.i("NavigateToForwardFriendListMethod", 4, "QQGuildJsPlugin NavigateToForwardFriendListMethod doInvoke");
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        int intValue = ((Integer) objArr[0]).intValue();
        String str2 = (String) objArr[1];
        int intValue2 = ((Integer) objArr[2]).intValue();
        String str3 = (String) objArr[3];
        String str4 = (String) objArr[4];
        String str5 = (String) objArr[5];
        String str6 = (String) objArr[6];
        int intValue3 = ((Integer) objArr[7]).intValue();
        int intValue4 = ((Integer) objArr[8]).intValue();
        if (QLog.isColorLevel()) {
            QLog.i("NavigateToForwardFriendListMethod", 2, "NavigateToForwardFriendOrTroopMethod guildId: " + str2 + " passCode: " + intValue2 + " passNum: " + intValue3);
        }
        Bundle bundle = new Bundle();
        bundle.putString("appName", str3);
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, str4);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, str5);
        bundle.putFloat("scale", ViewUtils.getDensity());
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "1.0.0.0");
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\"autosize\": 1}");
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1004).putExtra("is_ark_display_share", true).putExtra("call_by_forward", true).putExtra("forward_ark_app_name", str3).putExtra("forward_ark_app_view", str4).putExtra("forward_ark_app_ver", "1.0.0.0").putExtra("forward_ark_app_prompt", str6).putExtra(ForwardRecentActivity.SELECTION_MODE, 2).putExtra("forward_ark_app_meta", str5).putExtra("guild_id", str2).putExtra(AppConstants.Key.GUILD_PASS_CHECK_CODE, intValue2).putExtra(AppConstants.Key.GUILD_PASS_CHECK_NUMBER, intValue3).putExtra(AppConstants.Key.GUILD_PASS_CHECK_SOURCE_TYPE, intValue4).putExtra(AppConstants.Key.GUILD_PASS_CHECK_SHARE_TYPE, intValue).putExtras(bundle);
        if (!ca.a()) {
            return EIPCResult.createResult(-204, new Bundle());
        }
        if (intValue == 1) {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startForwardFriendListActivity(context, intent);
        } else if (intValue == 2) {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startForwardTroopListFragment(context, intent);
        } else {
            return EIPCResult.createResult(-90, new Bundle());
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
