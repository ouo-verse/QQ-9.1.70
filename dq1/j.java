package dq1;

import android.content.Context;
import com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ldq1/j;", "Ldq1/c;", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "b", "I", "state", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;I)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int state;

    public j(@NotNull JumpGuildParam param, int i3) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.state = i3;
    }

    @Override // dq1.c
    public void jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("Guild.jump.GuildInvalidStateJumpStrategy", 1, "jump invalid " + this.state);
        int i3 = this.state;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            GuildVisitorExceptionFragment.Companion.b(GuildVisitorExceptionFragment.INSTANCE, context, this.param, 4, null, 8, null);
                            return;
                        }
                        return;
                    }
                    GuildVisitorExceptionFragment.Companion.b(GuildVisitorExceptionFragment.INSTANCE, context, this.param, 1, null, 8, null);
                    return;
                }
                GuildVisitorExceptionFragment.Companion.b(GuildVisitorExceptionFragment.INSTANCE, context, this.param, 3, null, 8, null);
                return;
            }
            GuildVisitorExceptionFragment.Companion.b(GuildVisitorExceptionFragment.INSTANCE, context, this.param, 0, null, 12, null);
            return;
        }
        JumpGuildParam jumpGuildParam = this.param;
        ch.L0(context, jumpGuildParam.guildId, jumpGuildParam.getChannelId(), this.param.businessType, "Guild.jump.GuildInvalidStateJumpStrategy", this.state);
    }
}
