package el1;

import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.setting.mute.c;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lel1/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "d", "c", "", "e", h.F, "f", "g", "a", "b", "Lel1/a$a$a;", "Lel1/a$a$a;", "args", "<init>", "(Lel1/a$a$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.Args args;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f396555a;

        static {
            int[] iArr = new int[SpeakPermissionType.values().length];
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_GUILD_BANNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f396555a = iArr;
        }
    }

    public a(@NotNull Companion.Args args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.args = args;
    }

    private final SpeakPermissionType c(IGProGuildInfo guildInfo) {
        if (e(guildInfo)) {
            return SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN;
        }
        if (ch.r(guildInfo.getGuildID())) {
            return SpeakPermissionType.PERMISSION_TYPE_REAL_NAME;
        }
        if (f(guildInfo)) {
            return SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED;
        }
        if (g(guildInfo)) {
            return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
        }
        return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
    }

    private final SpeakPermissionType d(IGProGuildInfo guildInfo) {
        SpeakPermissionType h16 = h(guildInfo);
        SpeakPermissionType speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        if (h16 != speakPermissionType) {
            return h16;
        }
        return speakPermissionType;
    }

    private final boolean e(IGProGuildInfo guildInfo) {
        return !((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getIsVisitorOperate(guildInfo, this.args.getVisitorCheckType());
    }

    private final boolean f(IGProGuildInfo guildInfo) {
        if (guildInfo.getShutUpExpireTime() > NetConnInfoCenter.getServerTime()) {
            return true;
        }
        return false;
    }

    private final boolean g(IGProGuildInfo guildInfo) {
        if (guildInfo.getMyShutUpExpireTime() > NetConnInfoCenter.getServerTime()) {
            return true;
        }
        return false;
    }

    private final SpeakPermissionType h(IGProGuildInfo guildInfo) {
        if (c.M(this.args.getGuildId())) {
            return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        }
        if (f(guildInfo)) {
            return SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED;
        }
        if (g(guildInfo)) {
            return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
        }
        return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
    }

    @NotNull
    public final SpeakPermissionType a() {
        IGProGuildInfo guildInfo = this.args.getGuildInfo();
        if (guildInfo == null) {
            guildInfo = ch.L(this.args.getGuildId());
        }
        if (guildInfo == null) {
            return SpeakPermissionType.PERMISSION_TYPE_INVALID;
        }
        return b(guildInfo);
    }

    @NotNull
    public final SpeakPermissionType b(@NotNull IGProGuildInfo guildInfo) {
        SpeakPermissionType c16;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        if (guildInfo.isMember()) {
            c16 = d(guildInfo);
        } else {
            c16 = c(guildInfo);
        }
        if (c16 != SpeakPermissionType.PERMISSION_TYPE_NORMAL) {
            return c16;
        }
        for (SpeakPermissionType speakPermissionType : this.args.getExtendedCheckTypes()) {
            if (b.f396555a[speakPermissionType.ordinal()] == 1 && guildInfo.getIsBanned()) {
                return SpeakPermissionType.PERMISSION_TYPE_GUILD_BANNED;
            }
        }
        return c16;
    }
}
