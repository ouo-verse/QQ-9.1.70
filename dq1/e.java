package dq1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0003B!\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Ldq1/e;", "Ldq1/c;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Landroid/content/Context;", "context", "", "jump", "", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "extras", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Landroid/os/Bundle;)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle extras;

    public e(@NotNull String guildId, @NotNull IGProChannelInfo channelInfo, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        this.guildId = guildId;
        this.channelInfo = channelInfo;
        this.extras = bundle;
    }

    private final JumpGuildParam a() {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.guildId, this.channelInfo.getChannelUin());
        jumpGuildParam.extras.putAll(this.extras);
        jumpGuildParam.setDetailPageJumpInfo(JumpGuildParam.ChannelDetailPageJumpInfo.loadFrom(jumpGuildParam.extras));
        JumpGuildParam.JoinInfoParam loadFrom = JumpGuildParam.JoinInfoParam.loadFrom(jumpGuildParam.extras);
        if (loadFrom != null) {
            jumpGuildParam.setJoinInfoParam(loadFrom);
        }
        return jumpGuildParam;
    }

    @Override // dq1.c
    public void jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam a16 = a();
        Logger.f235387a.d().d("Guild.jump.FeedChannelStrategy", 1, "jump " + a16);
        d12.a.d(context, a16);
    }
}
