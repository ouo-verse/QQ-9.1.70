package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001'BQ\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JS\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\t\u0010\u0015\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b!\u0010 R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010 R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b#\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildQUIProfileConfig;", "Lcom/tencent/freesia/IConfigData;", "Landroidx/fragment/app/Fragment;", "f", "", "vasThemeContains", "contains", "blackContains", "component1", "", "", "component2", "component3", "component4", "component5", "enable", "fragmentPackageNames", "fragmentNames", "supportVasThemeFragmentNames", "blackFragmentNames", "copy", "toString", "", "hashCode", "", "other", "equals", "Z", "getEnable", "()Z", "Ljava/util/Set;", "getFragmentPackageNames", "()Ljava/util/Set;", "getFragmentNames", "getSupportVasThemeFragmentNames", "getBlackFragmentNames", "<init>", "(ZLjava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuildQUIProfileConfig implements IConfigData {

    @NotNull
    public static final String AIO_CLASS_NAME = "com.tencent.aio.main.fragment.ChatFragment";

    @NotNull
    public static final String AIO_PARAM_KEY = "AIOParamKey";

    @NotNull
    private static final String CONFIG_ID = "105835";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Set<String> blackFragmentNames;
    private final boolean enable;

    @NotNull
    private final Set<String> fragmentNames;

    @NotNull
    private final Set<String> fragmentPackageNames;

    @NotNull
    private final Set<String> supportVasThemeFragmentNames;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildQUIProfileConfig$a;", "", "Lcom/tencent/mobileqq/guild/config/GuildQUIProfileConfig;", "a", "", "AIO_CLASS_NAME", "Ljava/lang/String;", "AIO_PARAM_KEY", "CONFIG_ID", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildQUIProfileConfig$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildQUIProfileConfig a() {
            GuildQUIProfileConfig guildQUIProfileConfig;
            GuildQUIProfileConfig guildQUIProfileConfig2 = (GuildQUIProfileConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(GuildQUIProfileConfig.CONFIG_ID);
            if (guildQUIProfileConfig2 == null) {
                guildQUIProfileConfig = o.f216156a;
                return guildQUIProfileConfig;
            }
            return guildQUIProfileConfig2;
        }

        Companion() {
        }
    }

    public GuildQUIProfileConfig() {
        this(false, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GuildQUIProfileConfig copy$default(GuildQUIProfileConfig guildQUIProfileConfig, boolean z16, Set set, Set set2, Set set3, Set set4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = guildQUIProfileConfig.enable;
        }
        if ((i3 & 2) != 0) {
            set = guildQUIProfileConfig.fragmentPackageNames;
        }
        Set set5 = set;
        if ((i3 & 4) != 0) {
            set2 = guildQUIProfileConfig.fragmentNames;
        }
        Set set6 = set2;
        if ((i3 & 8) != 0) {
            set3 = guildQUIProfileConfig.supportVasThemeFragmentNames;
        }
        Set set7 = set3;
        if ((i3 & 16) != 0) {
            set4 = guildQUIProfileConfig.blackFragmentNames;
        }
        return guildQUIProfileConfig.copy(z16, set5, set6, set7, set4);
    }

    @JvmStatic
    @NotNull
    public static final GuildQUIProfileConfig get() {
        return INSTANCE.a();
    }

    public final boolean blackContains(@NotNull Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return this.blackFragmentNames.contains(f16.getClass().getName());
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final Set<String> component2() {
        return this.fragmentPackageNames;
    }

    @NotNull
    public final Set<String> component3() {
        return this.fragmentNames;
    }

    @NotNull
    public final Set<String> component4() {
        return this.supportVasThemeFragmentNames;
    }

    @NotNull
    public final Set<String> component5() {
        return this.blackFragmentNames;
    }

    public final boolean contains(@NotNull Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return this.fragmentNames.contains(f16.getClass().getName());
    }

    @NotNull
    public final GuildQUIProfileConfig copy(boolean enable, @NotNull Set<String> fragmentPackageNames, @NotNull Set<String> fragmentNames, @NotNull Set<String> supportVasThemeFragmentNames, @NotNull Set<String> blackFragmentNames) {
        Intrinsics.checkNotNullParameter(fragmentPackageNames, "fragmentPackageNames");
        Intrinsics.checkNotNullParameter(fragmentNames, "fragmentNames");
        Intrinsics.checkNotNullParameter(supportVasThemeFragmentNames, "supportVasThemeFragmentNames");
        Intrinsics.checkNotNullParameter(blackFragmentNames, "blackFragmentNames");
        return new GuildQUIProfileConfig(enable, fragmentPackageNames, fragmentNames, supportVasThemeFragmentNames, blackFragmentNames);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildQUIProfileConfig)) {
            return false;
        }
        GuildQUIProfileConfig guildQUIProfileConfig = (GuildQUIProfileConfig) other;
        if (this.enable == guildQUIProfileConfig.enable && Intrinsics.areEqual(this.fragmentPackageNames, guildQUIProfileConfig.fragmentPackageNames) && Intrinsics.areEqual(this.fragmentNames, guildQUIProfileConfig.fragmentNames) && Intrinsics.areEqual(this.supportVasThemeFragmentNames, guildQUIProfileConfig.supportVasThemeFragmentNames) && Intrinsics.areEqual(this.blackFragmentNames, guildQUIProfileConfig.blackFragmentNames)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Set<String> getBlackFragmentNames() {
        return this.blackFragmentNames;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final Set<String> getFragmentNames() {
        return this.fragmentNames;
    }

    @NotNull
    public final Set<String> getFragmentPackageNames() {
        return this.fragmentPackageNames;
    }

    @NotNull
    public final Set<String> getSupportVasThemeFragmentNames() {
        return this.supportVasThemeFragmentNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.fragmentPackageNames.hashCode()) * 31) + this.fragmentNames.hashCode()) * 31) + this.supportVasThemeFragmentNames.hashCode()) * 31) + this.blackFragmentNames.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildQUIProfileConfig(enable=" + this.enable + ", fragmentPackageNames=" + this.fragmentPackageNames + ", fragmentNames=" + this.fragmentNames + ", supportVasThemeFragmentNames=" + this.supportVasThemeFragmentNames + ", blackFragmentNames=" + this.blackFragmentNames + ")";
    }

    public final boolean vasThemeContains(@NotNull Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return this.supportVasThemeFragmentNames.contains(f16.getClass().getName());
    }

    public GuildQUIProfileConfig(boolean z16, @NotNull Set<String> fragmentPackageNames, @NotNull Set<String> fragmentNames, @NotNull Set<String> supportVasThemeFragmentNames, @NotNull Set<String> blackFragmentNames) {
        Intrinsics.checkNotNullParameter(fragmentPackageNames, "fragmentPackageNames");
        Intrinsics.checkNotNullParameter(fragmentNames, "fragmentNames");
        Intrinsics.checkNotNullParameter(supportVasThemeFragmentNames, "supportVasThemeFragmentNames");
        Intrinsics.checkNotNullParameter(blackFragmentNames, "blackFragmentNames");
        this.enable = z16;
        this.fragmentPackageNames = fragmentPackageNames;
        this.fragmentNames = fragmentNames;
        this.supportVasThemeFragmentNames = supportVasThemeFragmentNames;
        this.blackFragmentNames = blackFragmentNames;
    }

    public /* synthetic */ GuildQUIProfileConfig(boolean z16, Set set, Set set2, Set set3, Set set4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? SetsKt__SetsKt.setOf((Object[]) new String[]{"com.tencent.guild.", "com.tencent.guildlive.", "com.tencent.guildmedia.", "com.tencent.troopguild.", "com.tencent.mobileqq.guild."}) : set, (i3 & 4) != 0 ? SetsKt__SetsKt.setOf((Object[]) new String[]{AIO_CLASS_NAME, "com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment", "com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment", "com.tencent.mobileqq.guild.homev2.views.channellist.GuildChannelListFragment", "com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment", "com.tencent.mobileqq.guild.homev2.live.GuildLiveListFragment", "com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment", "com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment", "com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment", "com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment", "com.tencent.mobileqq.guild.feed.fragment.GuildFeedNoticeFragment", "com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment"}) : set2, (i3 & 8) != 0 ? SetsKt__SetsKt.setOf((Object[]) new String[]{AIO_CLASS_NAME, "com.tencent.mobileqq.guild.discoveryv2.fragment.GuildFrameFragment"}) : set3, (i3 & 16) != 0 ? SetsKt__SetsKt.setOf((Object[]) new String[]{"com.tencent.mobileqq.guild.feed.debug.GuildDebugFragment", "com.tencent.mobileqq.guild.GuildContactFragment"}) : set4);
    }
}
