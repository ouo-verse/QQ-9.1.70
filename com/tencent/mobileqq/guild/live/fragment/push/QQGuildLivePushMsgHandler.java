package com.tencent.mobileqq.guild.live.fragment.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gq1.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import o02.a;

/* loaded from: classes14.dex */
public class QQGuildLivePushMsgHandler extends QPublicBaseFragment {
    public static Intent ph(@NonNull String str, LaunchGuildChatPieParam launchGuildChatPieParam) {
        Intent intent = new Intent();
        intent.setClass(BaseApplication.getContext(), QPublicTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", QQGuildLivePushMsgHandler.class.getName());
        intent.putExtra("guild_live_channel_uin", str);
        intent.addFlags(268435456);
        Bundle bundle = launchGuildChatPieParam.G;
        if (bundle != null && bundle.getBoolean(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, false)) {
            long j3 = launchGuildChatPieParam.G.getLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, 0L);
            intent.putExtra(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, true);
            intent.putExtra(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, j3);
        }
        return intent;
    }

    private void qh(@NonNull String str) {
        IGPSService iGPSService = (IGPSService) getAppRuntime().getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channelInfo == null, ignore.");
            }
            finishActivity();
        } else {
            if (channelInfo.getType() != 5) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channel type != IChannelType.CHANNEL_TYPE_LIVE, ignore.");
                }
                finishActivity();
                return;
            }
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(channelInfo.getGuildId());
            if (guildInfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "guildInfo == null, ignore.");
                }
                finishActivity();
                return;
            }
            rh(channelInfo, guildInfo);
        }
    }

    private void rh(@NonNull IGProChannelInfo iGProChannelInfo, @NonNull IGProGuildInfo iGProGuildInfo) {
        Intent intent;
        GLiveChannelStartParams create = GLiveChannelStartParams.create(iGProChannelInfo);
        Bundle a16 = a.a(11);
        if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            boolean booleanExtra = intent.getBooleanExtra(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, false);
            long longExtra = intent.getLongExtra(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, 0L);
            a16.putBoolean(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, booleanExtra);
            a16.putLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, longExtra);
        }
        create.setBundle(a16);
        c.e(create);
        finishActivity();
    }

    public void finishActivity() {
        if (getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
    }

    public AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "arguments == null, ignore.");
            }
            finishActivity();
            return;
        }
        String string = arguments.getString("guild_live_channel_uin", null);
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLivePushMsgHandler", 1, "channelUin == null, ignore.");
            }
            finishActivity();
            return;
        }
        qh(string);
    }
}
