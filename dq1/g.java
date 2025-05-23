package dq1;

import android.content.Context;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Ldq1/g;", "Ldq1/c;", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    public g(@NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // dq1.c
    public void jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("Guild.jump.GuildHomeJumpStrategy", 1, "jump home " + this.param.guildId);
        GuildHomeV2Fragment.INSTANCE.c(context, this.param);
    }
}
