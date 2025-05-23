package com.tencent.mobileqq.guild.media.core.data;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberInfoInGame;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00132\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0002\u001a\u00020\u0000H\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u0004R\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u0017\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/n;", "", "b", TtmlNode.ATTR_TTS_ORIGIN, "", "c", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "", "d", "J", "()J", "i", "(J)V", "sortKey", "Lcom/tencent/mobileqq/guild/media/core/data/q;", "e", "Lcom/tencent/mobileqq/guild/media/core/data/q;", "f", "()Lcom/tencent/mobileqq/guild/media/core/data/q;", "setUserInfoInGame", "(Lcom/tencent/mobileqq/guild/media/core/data/q;)V", "userInfoInGame", "Lcom/tencent/mobileqq/guild/media/core/data/m;", "Lcom/tencent/mobileqq/guild/media/core/data/m;", "()Lcom/tencent/mobileqq/guild/media/core/data/m;", "setUserAVInfo", "(Lcom/tencent/mobileqq/guild/media/core/data/m;)V", "userAVInfo", tl.h.F, "Ljava/lang/String;", "getTipsMsg", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "tipsMsg", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.data.n, reason: from toString */
/* loaded from: classes14.dex */
public final class UserBusinessInfo implements Cloneable {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long sortKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private q userInfoInGame = new q();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private UserAVInfo userAVInfo = new UserAVInfo();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String tipsMsg = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/n$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserAVData;", "sInfo", "Lcom/tencent/mobileqq/guild/media/core/data/m;", "userAVInfo", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMemberInfoInGame;", "Lcom/tencent/mobileqq/guild/media/core/data/q;", "userInfoInGame", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProBusinessData;", "Lcom/tencent/mobileqq/guild/media/core/data/n;", "userBusinessInfo", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.data.n$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final UserAVInfo a(IGProUserAVData sInfo, UserAVInfo userAVInfo) {
            userAVInfo.f(sInfo.getUserAVState());
            o userDevState = userAVInfo.getUserDevState();
            userDevState.e(sInfo.getUserDevState().getMicState());
            userDevState.d(sInfo.getUserDevState().getCameraState());
            userDevState.h(sInfo.getUserDevState().getScreenState());
            userDevState.f(sInfo.getUserDevState().getNetworkQuality());
            userDevState.i(sInfo.getUserDevState().getSysMicBusy());
            return userAVInfo;
        }

        private final q b(IGProMemberInfoInGame sInfo, q userInfoInGame) {
            userInfoInGame.G(sInfo.getTinyId());
            userInfoInGame.E(sInfo.getRoomId());
            String nickName = sInfo.getNickName();
            Intrinsics.checkNotNullExpressionValue(nickName, "sInfo.nickName");
            userInfoInGame.C(nickName);
            String heroName = sInfo.getHeroName();
            Intrinsics.checkNotNullExpressionValue(heroName, "sInfo.heroName");
            userInfoInGame.w(heroName);
            String heroPic = sInfo.getHeroPic();
            Intrinsics.checkNotNullExpressionValue(heroPic, "sInfo.heroPic");
            userInfoInGame.x(heroPic);
            userInfoInGame.s(sInfo.getGameStatus());
            String record = sInfo.getRecord();
            Intrinsics.checkNotNullExpressionValue(record, "sInfo.record");
            userInfoInGame.D(record);
            userInfoInGame.B(sInfo.getJoinTimestampMs());
            userInfoInGame.r(sInfo.getGameIdentity());
            userInfoInGame.t(sInfo.getGameStatusUpdateTimestampMs());
            String schema = sInfo.getSchema();
            Intrinsics.checkNotNullExpressionValue(schema, "sInfo.schema");
            userInfoInGame.F(schema);
            userInfoInGame.h().clear();
            userInfoInGame.h().addAll(sInfo.getGoodHeroIconList());
            String honorIcon = sInfo.getHonorIcon();
            Intrinsics.checkNotNullExpressionValue(honorIcon, "sInfo.honorIcon");
            userInfoInGame.z(honorIcon);
            String honorDesc = sInfo.getHonorDesc();
            Intrinsics.checkNotNullExpressionValue(honorDesc, "sInfo.honorDesc");
            userInfoInGame.y(honorDesc);
            String identityDesc = sInfo.getIdentityDesc();
            Intrinsics.checkNotNullExpressionValue(identityDesc, "sInfo.identityDesc");
            userInfoInGame.A(identityDesc);
            userInfoInGame.u(sInfo.getGradeLevel());
            String backgroundPic = sInfo.getBackgroundPic();
            Intrinsics.checkNotNullExpressionValue(backgroundPic, "sInfo.backgroundPic");
            userInfoInGame.q(backgroundPic);
            String gradeLevelIcon = sInfo.getGradeLevelIcon();
            Intrinsics.checkNotNullExpressionValue(gradeLevelIcon, "sInfo.gradeLevelIcon");
            userInfoInGame.v(gradeLevelIcon);
            return userInfoInGame;
        }

        @JvmStatic
        @NotNull
        public final UserBusinessInfo c(@NotNull IGProBusinessData sInfo, @NotNull UserBusinessInfo userBusinessInfo) {
            Intrinsics.checkNotNullParameter(sInfo, "sInfo");
            Intrinsics.checkNotNullParameter(userBusinessInfo, "userBusinessInfo");
            userBusinessInfo.i(sInfo.getSortKey());
            String tipsMsg = sInfo.getTipsMsg();
            Intrinsics.checkNotNullExpressionValue(tipsMsg, "sInfo.tipsMsg");
            userBusinessInfo.j(tipsMsg);
            Companion companion = UserBusinessInfo.INSTANCE;
            IGProMemberInfoInGame memberInfoInGame = sInfo.getMemberInfoInGame();
            Intrinsics.checkNotNullExpressionValue(memberInfoInGame, "sInfo.memberInfoInGame");
            companion.b(memberInfoInGame, userBusinessInfo.getUserInfoInGame());
            IGProUserAVData userAVInfo = sInfo.getUserAVInfo();
            Intrinsics.checkNotNullExpressionValue(userAVInfo, "sInfo.userAVInfo");
            companion.a(userAVInfo, userBusinessInfo.getUserAVInfo());
            return userBusinessInfo;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final UserBusinessInfo h(@NotNull IGProBusinessData iGProBusinessData, @NotNull UserBusinessInfo userBusinessInfo) {
        return INSTANCE.c(iGProBusinessData, userBusinessInfo);
    }

    public final void a() {
        this.sortKey = 0L;
        this.userInfoInGame.a();
        this.userAVInfo.a();
        this.tipsMsg = "";
    }

    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UserBusinessInfo clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo");
        UserBusinessInfo userBusinessInfo = (UserBusinessInfo) clone;
        userBusinessInfo.userInfoInGame = this.userInfoInGame.clone();
        userBusinessInfo.userAVInfo = this.userAVInfo.clone();
        return userBusinessInfo;
    }

    public final void c(@NotNull UserBusinessInfo origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.sortKey = origin.sortKey;
        this.userInfoInGame.c(origin.userInfoInGame);
        this.userAVInfo.c(origin.userAVInfo);
        this.tipsMsg = origin.tipsMsg;
    }

    /* renamed from: d, reason: from getter */
    public final long getSortKey() {
        return this.sortKey;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final UserAVInfo getUserAVInfo() {
        return this.userAVInfo;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(UserBusinessInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo");
        UserBusinessInfo userBusinessInfo = (UserBusinessInfo) other;
        if (Intrinsics.areEqual(this.userInfoInGame, userBusinessInfo.userInfoInGame) && Intrinsics.areEqual(this.userAVInfo, userBusinessInfo.userAVInfo) && Intrinsics.areEqual(this.tipsMsg, userBusinessInfo.tipsMsg)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final q getUserInfoInGame() {
        return this.userInfoInGame;
    }

    public int hashCode() {
        return (((this.userInfoInGame.hashCode() * 31) + this.userAVInfo.hashCode()) * 31) + this.tipsMsg.hashCode();
    }

    public final void i(long j3) {
        this.sortKey = j3;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tipsMsg = str;
    }

    @NotNull
    public String toString() {
        return "UserBusinessInfo(sortKey=" + this.sortKey + ", userInfoInGame=" + this.userInfoInGame + ", userAVInfo=" + this.userAVInfo + ", tipsMsg='" + this.tipsMsg + "')";
    }
}
