package ms1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0001\u0003B)\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lms1/c;", "Lls1/a;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Landroid/content/Context;", "context", "", "jump", "", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "extras", "d", "Z", "getFromClick", "()Z", "fromClick", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Landroid/os/Bundle;Z)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements ls1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extras;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean fromClick;

    public c(@NotNull String guildId, @NotNull IGProChannelInfo channelInfo, @NotNull Bundle extras, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.guildId = guildId;
        this.channelInfo = channelInfo;
        this.extras = extras;
        this.fromClick = z16;
    }

    private final JumpGuildParam a() {
        GuildAppReportSourceInfo.ExtraInfo extraInfo;
        String channelUin = this.channelInfo.getChannelUin();
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.guildId, channelUin);
        jumpGuildParam.extras.putAll(this.extras);
        if (!jumpGuildParam.extras.containsKey(AppConstants.Key.COLUMN_MSG_SENDER_UIN)) {
            jumpGuildParam.extras.putString(AppConstants.Key.COLUMN_MSG_SENDER_UIN, "");
        }
        if (!jumpGuildParam.extras.containsKey(JumpGuildParam.EXTRA_KEY_OPEN_FROM)) {
            jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 1);
        }
        JumpGuildParam.JoinInfoParam loadFrom = JumpGuildParam.JoinInfoParam.loadFrom(jumpGuildParam.extras);
        if (loadFrom != null) {
            jumpGuildParam.setJoinInfoParam(loadFrom);
        } else {
            jumpGuildParam.getJoinInfoParam().setAfterJoinJumpChannelId(channelUin);
        }
        if (this.fromClick) {
            GuildAppReportSourceInfo fromBundle = GuildAppReportSourceInfo.fromBundle(jumpGuildParam.extras);
            if (fromBundle != null) {
                extraInfo = fromBundle.extraInfo;
            } else {
                extraInfo = null;
            }
            if (extraInfo != null) {
                extraInfo.channelOpenSourceForOnlineReport = 1;
            }
            jumpGuildParam.getReportSourceInfo().extraInfo.channelOpenSourceForOnlineReport = 1;
        }
        return jumpGuildParam;
    }

    @Override // ls1.a
    public boolean jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam a16 = a();
        GuildJumpDebugUtils.a("Guild.jump.ChatList.CommonChannelJumpStrategy", "jump: jumpParam = ", a16);
        GuildBlankActivity.b.a(context, a16);
        return true;
    }
}
