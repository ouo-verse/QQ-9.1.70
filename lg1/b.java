package lg1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a {
    public static void b(@NonNull Bundle bundle, @NonNull Uri uri) {
        bundle.putString("roomtype", uri.getQueryParameter("roomtype"));
        bundle.putString("entryscene", uri.getQueryParameter("entryscene"));
        bundle.putString(CGNonAgeReport.EVENT_CHANNEL, uri.getQueryParameter(CGNonAgeReport.EVENT_CHANNEL));
        bundle.putString("jump_info", uri.getQueryParameter("jump_info"));
        bundle.putString("jumpsecret", uri.getQueryParameter("jumpsecret"));
    }

    @Override // lg1.a
    public boolean a(QBaseActivity qBaseActivity, GuildClientParams guildClientParams) {
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatPieAppChannelAction open, param = ", guildClientParams);
        Uri parse = Uri.parse(guildClientParams.V().toLowerCase());
        b(guildClientParams.F(), parse);
        if (TextUtils.isEmpty(guildClientParams.F().getString("jump_source"))) {
            guildClientParams.F().putString("jump_source", parse.getQueryParameter("jump_source"));
        }
        int i3 = guildClientParams.F().getInt("openGuildAioFrom", 3);
        Intent intent = qBaseActivity.getIntent();
        if (intent != null && intent.getBooleanExtra(PeakConstants.SEND_FLAG, false)) {
            intent.putExtra(AppConstants.Key.GUILD_EXTRA, guildClientParams.F());
            i3 = 6;
        }
        LaunchGuildChatPieParam a16 = new LaunchGuildChatPieParam().l(guildClientParams.G()).b(guildClientParams.u()).q(guildClientParams.v()).c(guildClientParams.q()).k(guildClientParams.F()).r(false).o(1).e(guildClientParams.F().getBoolean("openGuildAioDisableReuse")).g(i3).a();
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatPieAppChannelAction open, guildChatPieParam = ", a16);
        GuildMainFrameUtils.r(qBaseActivity, 1, a16);
        return true;
    }
}
