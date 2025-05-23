package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pad.LaunchMode;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g {
    public static void a(Context context, JumpGuildParam jumpGuildParam, String str, String str2, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Intent ai5 = GuildScheduleDetailFragment.ai(context, null, jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId(), str, jumpGuildParam);
        ai5.putExtra(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, str2);
        ai5.getExtras().putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        o02.a.g(11);
        ty1.a.g("gpro_quality#event#schedule_channel_detail");
        GuildSplitViewUtils.f235370a.o(context, ai5, GuildScheduleDetailFragment.class, LaunchMode.standard);
    }
}
