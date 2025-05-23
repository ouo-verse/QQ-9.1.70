package com.tencent.mobileqq.troop.teamup.member.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "ApplyTeamUpSuccess", "CreateTroopTeamUp", "DeleteTeamUp", "NewTeamUp", "StopTimeTeamUp", "UpdateJoinTeamUp", "UpdateTeamUp", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$ApplyTeamUpSuccess;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$CreateTroopTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$DeleteTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$NewTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$StopTimeTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$UpdateJoinTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$UpdateTeamUp;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class TroopTeamUpUpdateEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$ApplyTeamUpSuccess;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpId", "", "(Ljava/lang/String;)V", "getTeamUpId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class ApplyTeamUpSuccess extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String teamUpId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplyTeamUpSuccess(@NotNull String teamUpId) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpId);
            } else {
                this.teamUpId = teamUpId;
            }
        }

        public static /* synthetic */ ApplyTeamUpSuccess copy$default(ApplyTeamUpSuccess applyTeamUpSuccess, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = applyTeamUpSuccess.teamUpId;
            }
            return applyTeamUpSuccess.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.teamUpId;
        }

        @NotNull
        public final ApplyTeamUpSuccess copy(@NotNull String teamUpId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ApplyTeamUpSuccess) iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamUpId);
            }
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            return new ApplyTeamUpSuccess(teamUpId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ApplyTeamUpSuccess) && Intrinsics.areEqual(this.teamUpId, ((ApplyTeamUpSuccess) other).teamUpId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTeamUpId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.teamUpId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ApplyTeamUpSuccess(teamUpId=" + this.teamUpId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$CreateTroopTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpId", "", "troopId", "", "(Ljava/lang/String;J)V", "getTeamUpId", "()Ljava/lang/String;", "getTroopId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class CreateTroopTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String teamUpId;
        private final long troopId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateTroopTeamUp(@NotNull String teamUpId, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, teamUpId, Long.valueOf(j3));
            } else {
                this.teamUpId = teamUpId;
                this.troopId = j3;
            }
        }

        public static /* synthetic */ CreateTroopTeamUp copy$default(CreateTroopTeamUp createTroopTeamUp, String str, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = createTroopTeamUp.teamUpId;
            }
            if ((i3 & 2) != 0) {
                j3 = createTroopTeamUp.troopId;
            }
            return createTroopTeamUp.copy(str, j3);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.teamUpId;
        }

        public final long component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.troopId;
        }

        @NotNull
        public final CreateTroopTeamUp copy(@NotNull String teamUpId, long troopId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (CreateTroopTeamUp) iPatchRedirector.redirect((short) 6, this, teamUpId, Long.valueOf(troopId));
            }
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            return new CreateTroopTeamUp(teamUpId, troopId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateTroopTeamUp)) {
                return false;
            }
            CreateTroopTeamUp createTroopTeamUp = (CreateTroopTeamUp) other;
            if (Intrinsics.areEqual(this.teamUpId, createTroopTeamUp.teamUpId) && this.troopId == createTroopTeamUp.troopId) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTeamUpId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpId;
        }

        public final long getTroopId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.troopId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.teamUpId.hashCode() * 31) + a.a(this.troopId);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "CreateTroopTeamUp(teamUpId=" + this.teamUpId + ", troopId=" + this.troopId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$DeleteTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpId", "", "(Ljava/lang/String;)V", "getTeamUpId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class DeleteTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String teamUpId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteTeamUp(@NotNull String teamUpId) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpId);
            } else {
                this.teamUpId = teamUpId;
            }
        }

        public static /* synthetic */ DeleteTeamUp copy$default(DeleteTeamUp deleteTeamUp, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = deleteTeamUp.teamUpId;
            }
            return deleteTeamUp.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.teamUpId;
        }

        @NotNull
        public final DeleteTeamUp copy(@NotNull String teamUpId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DeleteTeamUp) iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamUpId);
            }
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            return new DeleteTeamUp(teamUpId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof DeleteTeamUp) && Intrinsics.areEqual(this.teamUpId, ((DeleteTeamUp) other).teamUpId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTeamUpId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.teamUpId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "DeleteTeamUp(teamUpId=" + this.teamUpId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$NewTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpId", "", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;)V", "getReq", "()Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;", "getTeamUpId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class NewTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final PostTeamUpReq req;

        @NotNull
        private final String teamUpId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewTeamUp(@NotNull String teamUpId, @NotNull PostTeamUpReq req) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            Intrinsics.checkNotNullParameter(req, "req");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpId, (Object) req);
            } else {
                this.teamUpId = teamUpId;
                this.req = req;
            }
        }

        public static /* synthetic */ NewTeamUp copy$default(NewTeamUp newTeamUp, String str, PostTeamUpReq postTeamUpReq, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = newTeamUp.teamUpId;
            }
            if ((i3 & 2) != 0) {
                postTeamUpReq = newTeamUp.req;
            }
            return newTeamUp.copy(str, postTeamUpReq);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.teamUpId;
        }

        @NotNull
        public final PostTeamUpReq component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PostTeamUpReq) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.req;
        }

        @NotNull
        public final NewTeamUp copy(@NotNull String teamUpId, @NotNull PostTeamUpReq req) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (NewTeamUp) iPatchRedirector.redirect((short) 6, (Object) this, (Object) teamUpId, (Object) req);
            }
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            Intrinsics.checkNotNullParameter(req, "req");
            return new NewTeamUp(teamUpId, req);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewTeamUp)) {
                return false;
            }
            NewTeamUp newTeamUp = (NewTeamUp) other;
            if (Intrinsics.areEqual(this.teamUpId, newTeamUp.teamUpId) && Intrinsics.areEqual(this.req, newTeamUp.req)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final PostTeamUpReq getReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PostTeamUpReq) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.req;
        }

        @NotNull
        public final String getTeamUpId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.teamUpId.hashCode() * 31) + this.req.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "NewTeamUp(teamUpId=" + this.teamUpId + ", req=" + this.req + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$StopTimeTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpId", "", "(Ljava/lang/String;)V", "getTeamUpId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class StopTimeTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String teamUpId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopTimeTeamUp(@NotNull String teamUpId) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpId);
            } else {
                this.teamUpId = teamUpId;
            }
        }

        public static /* synthetic */ StopTimeTeamUp copy$default(StopTimeTeamUp stopTimeTeamUp, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stopTimeTeamUp.teamUpId;
            }
            return stopTimeTeamUp.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.teamUpId;
        }

        @NotNull
        public final StopTimeTeamUp copy(@NotNull String teamUpId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (StopTimeTeamUp) iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamUpId);
            }
            Intrinsics.checkNotNullParameter(teamUpId, "teamUpId");
            return new StopTimeTeamUp(teamUpId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof StopTimeTeamUp) && Intrinsics.areEqual(this.teamUpId, ((StopTimeTeamUp) other).teamUpId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTeamUpId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.teamUpId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "StopTimeTeamUp(teamUpId=" + this.teamUpId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$UpdateJoinTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpTeamDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;)V", "getTeamUpTeamDetail", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class UpdateJoinTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final TeamUpTeamDetail teamUpTeamDetail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateJoinTeamUp(@NotNull TeamUpTeamDetail teamUpTeamDetail) {
            super(null);
            Intrinsics.checkNotNullParameter(teamUpTeamDetail, "teamUpTeamDetail");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpTeamDetail);
            } else {
                this.teamUpTeamDetail = teamUpTeamDetail;
            }
        }

        public static /* synthetic */ UpdateJoinTeamUp copy$default(UpdateJoinTeamUp updateJoinTeamUp, TeamUpTeamDetail teamUpTeamDetail, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                teamUpTeamDetail = updateJoinTeamUp.teamUpTeamDetail;
            }
            return updateJoinTeamUp.copy(teamUpTeamDetail);
        }

        @NotNull
        public final TeamUpTeamDetail component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.teamUpTeamDetail;
        }

        @NotNull
        public final UpdateJoinTeamUp copy(@NotNull TeamUpTeamDetail teamUpTeamDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (UpdateJoinTeamUp) iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamUpTeamDetail);
            }
            Intrinsics.checkNotNullParameter(teamUpTeamDetail, "teamUpTeamDetail");
            return new UpdateJoinTeamUp(teamUpTeamDetail);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateJoinTeamUp) && Intrinsics.areEqual(this.teamUpTeamDetail, ((UpdateJoinTeamUp) other).teamUpTeamDetail)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final TeamUpTeamDetail getTeamUpTeamDetail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpTeamDetail;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.teamUpTeamDetail.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "UpdateJoinTeamUp(teamUpTeamDetail=" + this.teamUpTeamDetail + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent$UpdateTeamUp;", "Lcom/tencent/mobileqq/troop/teamup/member/event/TroopTeamUpUpdateEvent;", "teamUpTeamDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;)V", "getTeamUpTeamDetail", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class UpdateTeamUp extends TroopTeamUpUpdateEvent {
        static IPatchRedirector $redirector_;

        @Nullable
        private final TeamUpTeamDetail teamUpTeamDetail;

        public UpdateTeamUp(@Nullable TeamUpTeamDetail teamUpTeamDetail) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpTeamDetail);
            } else {
                this.teamUpTeamDetail = teamUpTeamDetail;
            }
        }

        public static /* synthetic */ UpdateTeamUp copy$default(UpdateTeamUp updateTeamUp, TeamUpTeamDetail teamUpTeamDetail, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                teamUpTeamDetail = updateTeamUp.teamUpTeamDetail;
            }
            return updateTeamUp.copy(teamUpTeamDetail);
        }

        @Nullable
        public final TeamUpTeamDetail component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.teamUpTeamDetail;
        }

        @NotNull
        public final UpdateTeamUp copy(@Nullable TeamUpTeamDetail teamUpTeamDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (UpdateTeamUp) iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamUpTeamDetail);
            }
            return new UpdateTeamUp(teamUpTeamDetail);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateTeamUp) && Intrinsics.areEqual(this.teamUpTeamDetail, ((UpdateTeamUp) other).teamUpTeamDetail)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final TeamUpTeamDetail getTeamUpTeamDetail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TeamUpTeamDetail) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.teamUpTeamDetail;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            TeamUpTeamDetail teamUpTeamDetail = this.teamUpTeamDetail;
            if (teamUpTeamDetail == null) {
                return 0;
            }
            return teamUpTeamDetail.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "UpdateTeamUp(teamUpTeamDetail=" + this.teamUpTeamDetail + ")";
        }
    }

    public /* synthetic */ TroopTeamUpUpdateEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    TroopTeamUpUpdateEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
