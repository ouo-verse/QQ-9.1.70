package gq1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.fragment.QQGuildLivePadRoomFragment;
import com.tencent.mobileqq.guild.live.fragment.QQGuildLiveRoomFragment;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.performance.report.k;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.guild.window.o;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import e12.d;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {
    private static void a(Intent intent, @NonNull GLiveChannelStartParams gLiveChannelStartParams) {
        intent.setFlags(335544320);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        String channelId = gLiveChannelStartParams.getChannelId();
        String channelName = gLiveChannelStartParams.getChannelName();
        String guildName = gLiveChannelStartParams.getGuildName();
        intent.putExtra("uin", channelId);
        intent.putExtra("uintype", 10014);
        intent.putExtra("uinname", guildName);
        intent.putExtra("channel_name", channelName);
        intent.putExtra("guild_id", gLiveChannelStartParams.getGuildId());
        intent.putExtra("channel_type", 5);
    }

    public static Intent b(@NonNull GLiveChannelStartParams gLiveChannelStartParams) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", QQGuildLiveRoomFragment.class.getName());
        intent.putExtras(new Bundle());
        a(intent, gLiveChannelStartParams);
        return intent;
    }

    private static boolean c(String str) {
        return TextUtils.equals(str, GLiveChannelCore.f226698a.s().getChannelId());
    }

    private static void d(@NonNull GLiveChannelStartParams gLiveChannelStartParams, boolean z16, Context context) {
        Intent b16 = b(gLiveChannelStartParams);
        b16.putExtra(AppConstants.Key.GUILD_EXTRA, gLiveChannelStartParams.getBundle());
        b16.putExtra("arg_from_float", z16);
        b16.putExtra("arg_key", gLiveChannelStartParams.getKey());
        GuildFloatWindowUtils.p();
        if (QQGuildUIUtil.A(context) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity((Activity) context)) {
            if (GLiveChannelStartParams.fromLittleWorld()) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).startGuildLiveActivity(QQGuildLivePadRoomFragment.class, b16);
                return;
            }
            if (context == null) {
                QLog.e("QGL.QQGuildLiveLauncher", 1, "isPadModel context == null");
                return;
            }
            com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).g(false).b(R.anim.f154637p9, R.anim.f154634p6).h(LaunchMode.singleTop);
            if (gLiveChannelStartParams.getBundle().getBoolean("jumpGuildFromLoadingPage", false)) {
                h16.b(0, R.anim.f154634p6);
            }
            i.e(context, b16.getExtras(), QQGuildLivePadRoomFragment.class, h16.a());
            return;
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).startGuildLiveActivity(QQGuildLiveRoomFragment.class, b16);
    }

    public static boolean e(@NonNull GLiveChannelStartParams gLiveChannelStartParams) {
        if (!TextUtils.isEmpty(gLiveChannelStartParams.getGuildId()) && !TextUtils.isEmpty(gLiveChannelStartParams.getChannelId())) {
            o.a().c("splashActivity", QBaseActivity.sTopActivity);
            if (!GuildFloatWindowUtils.l()) {
                int g16 = h.g(Constants.Business.QQ_GUILD_LIVE_VIEWER);
                if (g16 != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QGL.QQGuildLiveLauncher", 1, "checkAvFocusState == true, return.");
                    }
                    aa.a(g16);
                    return false;
                }
            } else {
                QLog.i("QGL.QQGuildLiveLauncher", 1, "skipAvFocusCheck");
            }
            h.j(1, Constants.Business.QQ_GUILD_LIVE_VIEWER);
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLiveLauncher", 2, String.format("guildId:%s, channelId:%s, roomId:%s", gLiveChannelStartParams.getGuildId(), gLiveChannelStartParams.getChannelId(), Long.valueOf(gLiveChannelStartParams.getRoomId())));
            }
            Activity currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
            if (c(gLiveChannelStartParams.getChannelId())) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildLiveLauncher", 2, "isEnterTheSameChannel.");
                }
                GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
                gLiveChannelCore.s().updateFromNewInfo(gLiveChannelStartParams);
                d(gLiveChannelCore.s(), true, currentTopActivity);
                return true;
            }
            if (f()) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildLiveLauncher", 2, "selfIsAnchorLiving, return.");
                }
                aa.a(R.string.f148520zt);
                return false;
            }
            if (!NetworkState.isNetSupport()) {
                aa.d(R.string.f1512817_);
                return false;
            }
            if (w02.a.f444141a.a(currentTopActivity)) {
                QLog.e("QGL.QQGuildLiveLauncher", 1, "[launchGuildLiveChannelByCheck] isRoomMutualExclusion true");
                return false;
            }
            l.l();
            g(gLiveChannelStartParams);
            GLiveChannelCore.f226698a.w(gLiveChannelStartParams);
            com.tencent.mobileqq.guild.live.helper.c.j(gLiveChannelStartParams);
            d(gLiveChannelStartParams, false, currentTopActivity);
            return true;
        }
        aa.a(R.string.f147920y7);
        QLog.e("QGL.QQGuildLiveLauncher", 1, "start params err.");
        return false;
    }

    private static boolean f() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (((Boolean) d.b(gLiveChannelCore.t().D(), Boolean.FALSE)).booleanValue() && gLiveChannelCore.r().d()) {
            return true;
        }
        return false;
    }

    private static void g(GLiveChannelStartParams gLiveChannelStartParams) {
        GuildTimeRecHelper.g(GuildLiveTimeEvent.LAUNCH_BETWEEN_PAGE_SHOW);
        if (gLiveChannelStartParams.isLiving()) {
            GuildTimeRecHelper.g(GuildLiveTimeEvent.LAUNCH_BETWEEN_SHOW_FIRST_FRAME);
            k.e(gLiveChannelStartParams.getGuildId(), gLiveChannelStartParams.getChannelId());
        }
    }
}
