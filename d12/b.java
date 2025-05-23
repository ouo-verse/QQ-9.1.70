package d12;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Ld12/b;", "", "Landroid/content/Context;", "context", "", "guildId", "channelId", "from", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f392650a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(from, "from");
        Logger.f235387a.d().d("GuildJumpApi", 1, "openChannel " + guildId + " " + channelId + " " + from);
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        if (l3 instanceof BaseQQAppInterface) {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(l3, context, "mqqguild://guild/openchannel?from=" + from + "&guildid=" + guildId + "&channelid=" + channelId);
            return;
        }
        throw new IllegalStateException("\u65b9\u6cd5\u5fc5\u987b\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528!".toString());
    }
}
