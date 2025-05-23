package com.tencent.robot.profile.data;

import android.os.Bundle;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p64.RobotStoryBoardCardData;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0002&'B=\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\u0004\b#\u0010$J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/profile/data/n;", "Lcom/tencent/robot/profile/data/g;", "", "other", "", "equals", "", "toString", "", "hashCode", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "getName", "name", "j", "getRobotUid", "robotUid", "", "Lcom/tencent/robot/profile/data/n$b;", "k", "Ljava/util/List;", "()Ljava/util/List;", "storyCards", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "l", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.n, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileStoryInfoData extends g {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileColor color;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUid;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<RobotProfileStoryItemCardData> storyCards;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/profile/data/n$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/robot/profile/data/h;", "color", "robotCallName", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Landroid/os/Bundle;", "aioBundle", "Lcom/tencent/robot/profile/data/n;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.n$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RobotProfileStoryInfoData b(Companion companion, String str, String str2, RobotProfileColor robotProfileColor, String str3, GroupRobotProfile groupRobotProfile, Bundle bundle, int i3, Object obj) {
            if ((i3 & 32) != 0) {
                bundle = null;
            }
            return companion.a(str, str2, robotProfileColor, str3, groupRobotProfile, bundle);
        }

        @NotNull
        public final RobotProfileStoryInfoData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String robotCallName, @NotNull GroupRobotProfile robotProfile, @Nullable Bundle aioBundle) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(robotCallName, "robotCallName");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            String str = robotProfile.robotData.robotUid;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.robotData.robotUid");
            return new RobotProfileStoryInfoData(robotUin, troopUin, color, robotCallName, str, com.tencent.robot.profile.utils.a.o(robotProfile, aioBundle));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0011\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/data/n$b;", "", "other", "", "equals", "b", "a", "", "toString", "", "hashCode", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "nick", "g", "robotUin", "c", "f", "robotUid", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "()Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", tl.h.F, "()Lcom/tencent/android/androidbypass/richui/viewdata/k;", "viewNode", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "aioBundle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;Lcom/tencent/android/androidbypass/richui/viewdata/k;Landroid/os/Bundle;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.n$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotProfileStoryItemCardData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String nick;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotUin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotUid;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final HalfViewCardNode card;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.android.androidbypass.richui.viewdata.k viewNode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Bundle aioBundle;

        public RobotProfileStoryItemCardData(@NotNull String nick, @NotNull String robotUin, @NotNull String robotUid, @NotNull HalfViewCardNode card, @NotNull com.tencent.android.androidbypass.richui.viewdata.k viewNode, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(nick, "nick");
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(robotUid, "robotUid");
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(viewNode, "viewNode");
            this.nick = nick;
            this.robotUin = robotUin;
            this.robotUid = robotUid;
            this.card = card;
            this.viewNode = viewNode;
            this.aioBundle = bundle;
        }

        public final boolean a(@NotNull RobotProfileStoryItemCardData other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return q64.a.a(this.card, other.card);
        }

        public final boolean b(@NotNull RobotProfileStoryItemCardData other) {
            StoryBaseInfo storyBaseInfo;
            Intrinsics.checkNotNullParameter(other, "other");
            StoryBaseInfo storyBaseInfo2 = this.card.storyBaseInfo;
            if (storyBaseInfo2 == null || (storyBaseInfo = other.card.storyBaseInfo) == null || storyBaseInfo2.storyId != storyBaseInfo.storyId) {
                return false;
            }
            return true;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Bundle getAioBundle() {
            return this.aioBundle;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final HalfViewCardNode getCard() {
            return this.card;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RobotStoryBoardCardData) || !super.equals(other)) {
                return false;
            }
            RobotStoryBoardCardData robotStoryBoardCardData = (RobotStoryBoardCardData) other;
            if (Intrinsics.areEqual(this.viewNode, robotStoryBoardCardData.getViewNode()) && Intrinsics.areEqual(this.card, robotStoryBoardCardData.getCard()) && q64.a.a(this.card, robotStoryBoardCardData.getCard())) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getRobotUid() {
            return this.robotUid;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getRobotUin() {
            return this.robotUin;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final com.tencent.android.androidbypass.richui.viewdata.k getViewNode() {
            return this.viewNode;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((this.nick.hashCode() * 31) + this.robotUin.hashCode()) * 31) + this.robotUid.hashCode()) * 31) + this.card.hashCode()) * 31) + this.viewNode.hashCode()) * 31;
            Bundle bundle = this.aioBundle;
            if (bundle == null) {
                hashCode = 0;
            } else {
                hashCode = bundle.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "RobotProfileStoryItemCardData(nick=" + this.nick + ", robotUin=" + this.robotUin + ", robotUid=" + this.robotUid + ", card=" + this.card + ", viewNode=" + this.viewNode + ", aioBundle=" + this.aioBundle + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileStoryInfoData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String name, @NotNull String robotUid, @NotNull List<RobotProfileStoryItemCardData> storyCards) {
        super("Story", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(storyCards, "storyCards");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.name = name;
        this.robotUid = robotUid;
        this.storyCards = storyCards;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: c, reason: from getter */
    public RobotProfileColor getColor() {
        return this.color;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    @Override // com.tencent.robot.profile.data.g
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileStoryInfoData) || !super.equals(other)) {
            return false;
        }
        RobotProfileStoryInfoData robotProfileStoryInfoData = (RobotProfileStoryInfoData) other;
        if (Intrinsics.areEqual(this.robotUid, robotProfileStoryInfoData.robotUid) && com.tencent.robot.profile.utils.a.z(this.storyCards, robotProfileStoryInfoData.storyCards)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    public final List<RobotProfileStoryItemCardData> h() {
        return this.storyCards;
    }

    public int hashCode() {
        return (((((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.name.hashCode()) * 31) + this.robotUid.hashCode()) * 31) + this.storyCards.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotProfileStoryInfoData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", name=" + this.name + ", robotUid=" + this.robotUid + ", storyCards=" + this.storyCards + ")";
    }
}
