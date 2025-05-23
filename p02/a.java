package p02;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lp02/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "channelId", "", "b", "account", "", "onAccountChanged", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "e", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "a", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f424868d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ServiceCache$LazyHolder serviceHolder;

    static {
        a aVar = new a();
        f424868d = aVar;
        serviceHolder = new ServiceCache$LazyHolder("GuildSpeakLimitRepository");
        AccountChangedNotifier.f214789d.a(aVar);
    }

    a() {
    }

    private final IGPSService a() {
        return serviceHolder.b();
    }

    @JvmStatic
    public static final int b(@NotNull String guildId, @Nullable String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return f424868d.a().getSpeakLimit(guildId, channelId);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        serviceHolder = new ServiceCache$LazyHolder("GuildSpeakLimitRepository");
    }
}
