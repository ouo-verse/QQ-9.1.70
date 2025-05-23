package com.tencent.mobileqq.guild.rolegroup.levelrole;

import android.app.Activity;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "from", "", "a", "<init>", "()V", "OpenLevelRoleH5FromType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLevelRoleUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLevelRoleUtils f232617a = new GuildLevelRoleUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleUtils$OpenLevelRoleH5FromType;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes14.dex */
    public @interface OpenLevelRoleH5FromType {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f232618a;
        public static final int fromAIO = 4;
        public static final int fromChannelMember = 6;
        public static final int fromDirectMessage = 2;
        public static final int fromGuildMember = 5;
        public static final int fromGuildProfile = 1;
        public static final int fromOther = 3;
        public static final int fromPersonalProfile = 7;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleUtils$OpenLevelRoleH5FromType$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils$OpenLevelRoleH5FromType$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f232618a = new Companion();

            Companion() {
            }
        }
    }

    GuildLevelRoleUtils() {
    }

    @JvmStatic
    public static final void a(@NotNull Activity activity, @NotNull String guildId, int from) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ch.j1(activity, "https://qun.qq.com/guild/h5/guild-level/index.html?guild_id=" + guildId + "&from=" + from + "&user_type=" + v.c(guildId), guildId);
    }
}
