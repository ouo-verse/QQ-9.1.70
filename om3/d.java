package om3;

import com.tencent.now.linkpkanchorplay.event.UIEvent;
import g55.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lom3/d;", "", "<init>", "()V", "a", "b", "c", "d", "e", "Lom3/d$a;", "Lom3/d$b;", "Lom3/d$c;", "Lom3/d$d;", "Lom3/d$e;", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0005\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lom3/d$a;", "Lom3/d;", "", "toString", "Le55/a;", "a", "Le55/a;", "b", "()Le55/a;", "anchorInfo", "", "Z", "d", "()Z", "isInPK", "", "c", "I", "()I", "pkType", "allowStartPK", "<init>", "(Le55/a;ZIZ)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: om3.d$a, reason: from toString */
    /* loaded from: classes22.dex */
    public static final class InLinkScreen extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final e55.a anchorInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isInPK;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pkType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean allowStartPK;

        public /* synthetic */ InLinkScreen(e55.a aVar, boolean z16, int i3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, z16, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? true : z17);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAllowStartPK() {
            return this.allowStartPK;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final e55.a getAnchorInfo() {
            return this.anchorInfo;
        }

        /* renamed from: c, reason: from getter */
        public final int getPkType() {
            return this.pkType;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsInPK() {
            return this.isInPK;
        }

        @NotNull
        public String toString() {
            return "InLinkScreen(isInPK=" + this.isInPK + ", pkType=" + this.pkType + ", allowStartPK=" + this.allowStartPK + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InLinkScreen(@NotNull e55.a anchorInfo, boolean z16, int i3, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
            this.anchorInfo = anchorInfo;
            this.isInPK = z16;
            this.pkType = i3;
            this.allowStartPK = z17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lom3/d$b;", "Lom3/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "a", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "()Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "pkType", "<init>", "(Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: om3.d$b, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class InMatch extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final UIEvent.PKType pkType;

        public InMatch() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final UIEvent.PKType getPkType() {
            return this.pkType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InMatch) && this.pkType == ((InMatch) other).pkType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.pkType.hashCode();
        }

        @NotNull
        public String toString() {
            return "InMatch(pkType=" + this.pkType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InMatch(@NotNull UIEvent.PKType pkType) {
            super(null);
            Intrinsics.checkNotNullParameter(pkType, "pkType");
            this.pkType = pkType;
        }

        public /* synthetic */ InMatch(UIEvent.PKType pKType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? UIEvent.PKType.LinkPK : pKType);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lom3/d$c;", "Lom3/d;", "", "toString", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c extends d {
        public c() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Init()";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lom3/d$d;", "Lom3/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lg55/ag;", "a", "Lg55/ag;", "()Lg55/ag;", "inviteMsg", "<init>", "(Lg55/ag;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: om3.d$d, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final /* data */ class C10927d extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ag inviteMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10927d(@NotNull ag inviteMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
            this.inviteMsg = inviteMsg;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ag getInviteMsg() {
            return this.inviteMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof C10927d) && Intrinsics.areEqual(this.inviteMsg, ((C10927d) other).inviteMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inviteMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "InvitationReceived()";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lom3/d$e;", "Lom3/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Le55/a;", "a", "Le55/a;", "()Le55/a;", "anchorInfo", "b", "I", "getInviteType", "()I", "inviteType", "c", "Ljava/lang/String;", "getInviteID", "()Ljava/lang/String;", "inviteID", "<init>", "(Le55/a;ILjava/lang/String;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: om3.d$e, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class InvitationSent extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final e55.a anchorInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int inviteType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inviteID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvitationSent(@NotNull e55.a anchorInfo, int i3, @NotNull String inviteID) {
            super(null);
            Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
            Intrinsics.checkNotNullParameter(inviteID, "inviteID");
            this.anchorInfo = anchorInfo;
            this.inviteType = i3;
            this.inviteID = inviteID;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final e55.a getAnchorInfo() {
            return this.anchorInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvitationSent)) {
                return false;
            }
            InvitationSent invitationSent = (InvitationSent) other;
            if (Intrinsics.areEqual(this.anchorInfo, invitationSent.anchorInfo) && this.inviteType == invitationSent.inviteType && Intrinsics.areEqual(this.inviteID, invitationSent.inviteID)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.anchorInfo.hashCode() * 31) + this.inviteType) * 31) + this.inviteID.hashCode();
        }

        @NotNull
        public String toString() {
            return "InvitationSent(inviteType:" + this.inviteType + ", inviteID:" + this.inviteID + ')';
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
