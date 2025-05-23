package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildAudioChannelActivityAction;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildLiveChannelOpenLiveAction;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildSpeakRuleUnlimitedAction;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildWhoCanSeeAction;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildWhoCanSpeakAction;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory;", "", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "fetchType", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "a", "<init>", "()V", "FetchType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBindPermissionActionFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildBindPermissionActionFactory f232346a = new GuildBindPermissionActionFactory();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "", "(Ljava/lang/String;I)V", "FETCH_WHO_CAN_SEE", "FETCH_WHO_CAN_SPEAK", "FETCH_SPEAK_RULE_UNLIMITED", "FETCH_LIVE_CHANNEL_OPEN_LIVE", "FETCH_AUDIO_CHANNEL_ACTIVITY", "FETCH_WORD_CHANNEL_EDIT_MAP", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum FetchType {
        FETCH_WHO_CAN_SEE,
        FETCH_WHO_CAN_SPEAK,
        FETCH_SPEAK_RULE_UNLIMITED,
        FETCH_LIVE_CHANNEL_OPEN_LIVE,
        FETCH_AUDIO_CHANNEL_ACTIVITY,
        FETCH_WORD_CHANNEL_EDIT_MAP
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232347a;

        static {
            int[] iArr = new int[FetchType.values().length];
            try {
                iArr[FetchType.FETCH_WHO_CAN_SEE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FetchType.FETCH_WHO_CAN_SPEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FetchType.FETCH_SPEAK_RULE_UNLIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FetchType.FETCH_AUDIO_CHANNEL_ACTIVITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f232347a = iArr;
        }
    }

    GuildBindPermissionActionFactory() {
    }

    @JvmStatic
    @NotNull
    public static final z a(@NotNull String guildId, @NotNull String channelId, @NotNull FetchType fetchType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        int i3 = a.f232347a[fetchType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return new GuildAudioChannelActivityAction(guildId, channelId);
                        }
                        throw new IllegalArgumentException("Unknown fetchType=" + fetchType + "!");
                    }
                    return new GuildLiveChannelOpenLiveAction(guildId, channelId);
                }
                return new GuildSpeakRuleUnlimitedAction(guildId);
            }
            return new GuildWhoCanSpeakAction(guildId, channelId);
        }
        return new GuildWhoCanSeeAction(guildId, channelId);
    }
}
