package com.tencent.guild.aio.article.title.userinfo;

import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "LayoutVisibilityUIState", "UserAvatarUIState", "UserIdentityIdUIState", "UserNickNameUIState", "UserPublishTimeUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildArticleTitleUserInfoUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState$LayoutVisibilityUIState;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class LayoutVisibilityUIState extends GuildArticleTitleUserInfoUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public LayoutVisibilityUIState(int i3) {
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState$UserAvatarUIState;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "userTinyId", "e", "a", "guildId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UserAvatarUIState extends GuildArticleTitleUserInfoUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String userTinyId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        public UserAvatarUIState(@NotNull String userTinyId, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(userTinyId, "userTinyId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.userTinyId = userTinyId;
            this.guildId = guildId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUserTinyId() {
            return this.userTinyId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState$UserIdentityIdUIState;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "a", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "userIdentityInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UserIdentityIdUIState extends GuildArticleTitleUserInfoUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IGProClientIdentityInfo userIdentityInfo;

        public UserIdentityIdUIState(@NotNull IGProClientIdentityInfo userIdentityInfo) {
            Intrinsics.checkNotNullParameter(userIdentityInfo, "userIdentityInfo");
            this.userIdentityInfo = userIdentityInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final IGProClientIdentityInfo getUserIdentityInfo() {
            return this.userIdentityInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState$UserNickNameUIState;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "userNickName", "", "e", "I", "a", "()I", "nickNameColor", "<init>", "(Ljava/lang/String;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UserNickNameUIState extends GuildArticleTitleUserInfoUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String userNickName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int nickNameColor;

        public UserNickNameUIState(@NotNull String userNickName, int i3) {
            Intrinsics.checkNotNullParameter(userNickName, "userNickName");
            this.userNickName = userNickName;
            this.nickNameColor = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getNickNameColor() {
            return this.nickNameColor;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUserNickName() {
            return this.userNickName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState$UserPublishTimeUIState;", "Lcom/tencent/guild/aio/article/title/userinfo/GuildArticleTitleUserInfoUIState;", "", "d", "J", "a", "()J", "publishTime", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UserPublishTimeUIState extends GuildArticleTitleUserInfoUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long publishTime;

        public UserPublishTimeUIState(long j3) {
            this.publishTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getPublishTime() {
            return this.publishTime;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
