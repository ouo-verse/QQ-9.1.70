package com.tencent.mobileqq.troop.teamup.home.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001:\u00011BU\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002Jc\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001e\u0010%R\u0017\u0010\r\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b&\u0010%R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b#\u0010,R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010'\u001a\u0004\b*\u0010)\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "", "", "k", "", "id", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;", "state", "title", "Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "content", "", "appliedCount", "maxApplyCount", "isCreator", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "shouldFoldView", "a", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "b", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;", "i", "()Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;", "c", "j", "d", "Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "()Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "e", "I", "()I", "g", "Z", "l", "()Z", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;Ljava/lang/String;Lcom/tencent/mobileqq/troop/teamup/home/data/a;IIZLcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;Z)V", "TroopTeamUpState", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopTeamUpData {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopTeamUpState state;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a content;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int appliedCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int maxApplyCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isCreator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TeamUpTeamDetail detail;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean shouldFoldView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;", "", "isActive", "", "(Ljava/lang/String;IZ)V", "()Z", "INVALID", "CAN_APPLY", "CAN_APPLY_WITH_IMG", "ALREADY_APPLIED", "ALREADY_UPLOAD", "CLOSED", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TroopTeamUpState {
        private static final /* synthetic */ TroopTeamUpState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TroopTeamUpState ALREADY_APPLIED;
        public static final TroopTeamUpState ALREADY_UPLOAD;
        public static final TroopTeamUpState CAN_APPLY;
        public static final TroopTeamUpState CAN_APPLY_WITH_IMG;
        public static final TroopTeamUpState CLOSED;
        public static final TroopTeamUpState INVALID;
        private final boolean isActive;

        private static final /* synthetic */ TroopTeamUpState[] $values() {
            return new TroopTeamUpState[]{INVALID, CAN_APPLY, CAN_APPLY_WITH_IMG, ALREADY_APPLIED, ALREADY_UPLOAD, CLOSED};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55827);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            INVALID = new TroopTeamUpState("INVALID", 0, false);
            CAN_APPLY = new TroopTeamUpState("CAN_APPLY", 1, true);
            CAN_APPLY_WITH_IMG = new TroopTeamUpState("CAN_APPLY_WITH_IMG", 2, true);
            ALREADY_APPLIED = new TroopTeamUpState("ALREADY_APPLIED", 3, true);
            ALREADY_UPLOAD = new TroopTeamUpState("ALREADY_UPLOAD", 4, true);
            CLOSED = new TroopTeamUpState("CLOSED", 5, false);
            $VALUES = $values();
        }

        TroopTeamUpState(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.isActive = z16;
            }
        }

        public static TroopTeamUpState valueOf(String str) {
            return (TroopTeamUpState) Enum.valueOf(TroopTeamUpState.class, str);
        }

        public static TroopTeamUpState[] values() {
            return (TroopTeamUpState[]) $VALUES.clone();
        }

        public final boolean isActive() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isActive;
        }
    }

    public TroopTeamUpData(@NotNull String id5, @NotNull TroopTeamUpState state, @NotNull String title, @NotNull a content, int i3, int i16, boolean z16, @NotNull TeamUpTeamDetail detail, boolean z17) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(detail, "detail");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, state, title, content, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), detail, Boolean.valueOf(z17));
            return;
        }
        this.id = id5;
        this.state = state;
        this.title = title;
        this.content = content;
        this.appliedCount = i3;
        this.maxApplyCount = i16;
        this.isCreator = z16;
        this.detail = detail;
        this.shouldFoldView = z17;
    }

    public static /* synthetic */ TroopTeamUpData b(TroopTeamUpData troopTeamUpData, String str, TroopTeamUpState troopTeamUpState, String str2, a aVar, int i3, int i16, boolean z16, TeamUpTeamDetail teamUpTeamDetail, boolean z17, int i17, Object obj) {
        String str3;
        TroopTeamUpState troopTeamUpState2;
        String str4;
        a aVar2;
        int i18;
        int i19;
        boolean z18;
        TeamUpTeamDetail teamUpTeamDetail2;
        boolean z19;
        if ((i17 & 1) != 0) {
            str3 = troopTeamUpData.id;
        } else {
            str3 = str;
        }
        if ((i17 & 2) != 0) {
            troopTeamUpState2 = troopTeamUpData.state;
        } else {
            troopTeamUpState2 = troopTeamUpState;
        }
        if ((i17 & 4) != 0) {
            str4 = troopTeamUpData.title;
        } else {
            str4 = str2;
        }
        if ((i17 & 8) != 0) {
            aVar2 = troopTeamUpData.content;
        } else {
            aVar2 = aVar;
        }
        if ((i17 & 16) != 0) {
            i18 = troopTeamUpData.appliedCount;
        } else {
            i18 = i3;
        }
        if ((i17 & 32) != 0) {
            i19 = troopTeamUpData.maxApplyCount;
        } else {
            i19 = i16;
        }
        if ((i17 & 64) != 0) {
            z18 = troopTeamUpData.isCreator;
        } else {
            z18 = z16;
        }
        if ((i17 & 128) != 0) {
            teamUpTeamDetail2 = troopTeamUpData.detail;
        } else {
            teamUpTeamDetail2 = teamUpTeamDetail;
        }
        if ((i17 & 256) != 0) {
            z19 = troopTeamUpData.shouldFoldView;
        } else {
            z19 = z17;
        }
        return troopTeamUpData.a(str3, troopTeamUpState2, str4, aVar2, i18, i19, z18, teamUpTeamDetail2, z19);
    }

    @NotNull
    public final TroopTeamUpData a(@NotNull String id5, @NotNull TroopTeamUpState state, @NotNull String title, @NotNull a content, int appliedCount, int maxApplyCount, boolean isCreator, @NotNull TeamUpTeamDetail detail, boolean shouldFoldView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (TroopTeamUpData) iPatchRedirector.redirect((short) 23, this, id5, state, title, content, Integer.valueOf(appliedCount), Integer.valueOf(maxApplyCount), Boolean.valueOf(isCreator), detail, Boolean.valueOf(shouldFoldView));
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return new TroopTeamUpData(id5, state, title, content, appliedCount, maxApplyCount, isCreator, detail, shouldFoldView);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.appliedCount;
    }

    @NotNull
    public final a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final TeamUpTeamDetail e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.detail;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopTeamUpData)) {
            return false;
        }
        TroopTeamUpData troopTeamUpData = (TroopTeamUpData) other;
        if (Intrinsics.areEqual(this.id, troopTeamUpData.id) && this.state == troopTeamUpData.state && Intrinsics.areEqual(this.title, troopTeamUpData.title) && Intrinsics.areEqual(this.content, troopTeamUpData.content) && this.appliedCount == troopTeamUpData.appliedCount && this.maxApplyCount == troopTeamUpData.maxApplyCount && this.isCreator == troopTeamUpData.isCreator && Intrinsics.areEqual(this.detail, troopTeamUpData.detail) && this.shouldFoldView == troopTeamUpData.shouldFoldView) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.id;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.maxApplyCount;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.shouldFoldView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.appliedCount) * 31) + this.maxApplyCount) * 31;
        boolean z16 = this.isCreator;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.detail.hashCode()) * 31;
        boolean z17 = this.shouldFoldView;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public final TroopTeamUpState i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopTeamUpState) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.state;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.title;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.appliedCount >= this.maxApplyCount) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isCreator;
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.shouldFoldView = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "TroopTeamUpData(id=" + this.id + ", state=" + this.state + ", title=" + this.title + ", content=" + this.content + ", appliedCount=" + this.appliedCount + ", maxApplyCount=" + this.maxApplyCount + ", isCreator=" + this.isCreator + ", detail=" + this.detail + ", shouldFoldView=" + this.shouldFoldView + ")";
    }

    public /* synthetic */ TroopTeamUpData(String str, TroopTeamUpState troopTeamUpState, String str2, a aVar, int i3, int i16, boolean z16, TeamUpTeamDetail teamUpTeamDetail, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, troopTeamUpState, str2, aVar, i3, (i17 & 32) != 0 ? 200 : i16, (i17 & 64) != 0 ? false : z16, teamUpTeamDetail, (i17 & 256) != 0 ? true : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, troopTeamUpState, str2, aVar, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), teamUpTeamDetail, Boolean.valueOf(z17), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
