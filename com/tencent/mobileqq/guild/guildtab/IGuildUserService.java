package com.tencent.mobileqq.guild.guildtab;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.raft.codegenmeta.utils.Constants;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\rH&R\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildMsgAbFlag;", "guildMode", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$GuildUser;", "guildUser", "guildUserCached", "", "getGuildUDCFlag", "()Ljava/lang/Integer;", "getGroupGuildFlag", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$c;", "listener", "", "addListener", "removeListener", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$b;", "isGuildTabSetting", "isGuildUser", "()Z", "isGuildUserCached", "b", "c", "GuildUser", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface IGuildUserService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$GuildUser;", "", "(Ljava/lang/String;I)V", "UNDEFINED", Constants.KEY_OPTION_TRUE, Constants.KEY_OPTION_FALSE, "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum GuildUser {
        UNDEFINED,
        TRUE,
        FALSE
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull IGuildUserService iGuildUserService) {
            if (iGuildUserService.guildUser() == GuildUser.TRUE) {
                return true;
            }
            return false;
        }

        public static boolean b(@NotNull IGuildUserService iGuildUserService) {
            if (iGuildUserService.guildUserCached() == GuildUser.TRUE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$b;", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$c;", "", "", "isGuildUser", "", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
        void b(boolean isGuildUser);
    }

    boolean addListener(@NotNull b listener);

    boolean addListener(@NotNull c listener);

    @Nullable
    Integer getGroupGuildFlag();

    @Nullable
    Integer getGuildUDCFlag();

    @NotNull
    GuildMsgAbFlag guildMode();

    @NotNull
    GuildUser guildUser();

    @NotNull
    GuildUser guildUserCached();

    boolean isGuildTabSetting();

    boolean isGuildUser();

    boolean isGuildUserCached();

    boolean removeListener(@NotNull b listener);

    boolean removeListener(@NotNull c listener);
}
