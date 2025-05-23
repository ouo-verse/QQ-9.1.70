package com.tencent.now.linkpkanchorplay.event;

import g55.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "Lcom/tencent/now/linkpkanchorplay/event/d$a;", "Lcom/tencent/now/linkpkanchorplay/event/d$b;", "Lcom/tencent/now/linkpkanchorplay/event/d$c;", "Lcom/tencent/now/linkpkanchorplay/event/d$d;", "Lcom/tencent/now/linkpkanchorplay/event/d$e;", "Lcom/tencent/now/linkpkanchorplay/event/d$f;", "Lcom/tencent/now/linkpkanchorplay/event/d$g;", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$a;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f338180a = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$b;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lg55/ag;", "a", "Lg55/ag;", "getInviteMsg", "()Lg55/ag;", "inviteMsg", "<init>", "(Lg55/ag;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.d$b, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class InviteReceiveReplyEvent extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ag inviteMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InviteReceiveReplyEvent(@NotNull ag inviteMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
            this.inviteMsg = inviteMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InviteReceiveReplyEvent) && Intrinsics.areEqual(this.inviteMsg, ((InviteReceiveReplyEvent) other).inviteMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inviteMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "InviteReceiveReplyEvent(inviteMsg=" + this.inviteMsg + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$c;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "disabled", "Lom3/d;", "Lom3/d;", "()Lom3/d;", "curState", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.d$c, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class LinkScreenDisabled extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean disabled;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final om3.d curState;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final om3.d getCurState() {
            return this.curState;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDisabled() {
            return this.disabled;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkScreenDisabled)) {
                return false;
            }
            LinkScreenDisabled linkScreenDisabled = (LinkScreenDisabled) other;
            if (this.disabled == linkScreenDisabled.disabled && Intrinsics.areEqual(this.curState, linkScreenDisabled.curState)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.disabled;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.curState.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkScreenDisabled(disabled=" + this.disabled + ", curState=" + this.curState + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$d;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lg55/ag;", "a", "Lg55/ag;", "()Lg55/ag;", "inviteMsg", "<init>", "(Lg55/ag;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.d$d, reason: collision with other inner class name and from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ReceiveInviteEvent extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ag inviteMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveInviteEvent(@NotNull ag inviteMsg) {
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
            if ((other instanceof ReceiveInviteEvent) && Intrinsics.areEqual(this.inviteMsg, ((ReceiveInviteEvent) other).inviteMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inviteMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReceiveInviteEvent(inviteMsg=" + this.inviteMsg + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$e;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "opType", "Lg55/ag;", "Lg55/ag;", "()Lg55/ag;", "inviteMsg", "<init>", "(ILg55/ag;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.d$e, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ResponseInviteEvent extends d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int opType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ag inviteMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseInviteEvent(int i3, @NotNull ag inviteMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
            this.opType = i3;
            this.inviteMsg = inviteMsg;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ag getInviteMsg() {
            return this.inviteMsg;
        }

        /* renamed from: b, reason: from getter */
        public final int getOpType() {
            return this.opType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseInviteEvent)) {
                return false;
            }
            ResponseInviteEvent responseInviteEvent = (ResponseInviteEvent) other;
            if (this.opType == responseInviteEvent.opType && Intrinsics.areEqual(this.inviteMsg, responseInviteEvent.inviteMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.opType * 31) + this.inviteMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResponseInviteEvent(opType=" + this.opType + ", inviteMsg=" + this.inviteMsg + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$f;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final f f338187a = new f();

        f() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$g;", "Lcom/tencent/now/linkpkanchorplay/event/d;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class g extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final g f338188a = new g();

        g() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/d$h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lom3/d;", "a", "Lom3/d;", "()Lom3/d;", "curState", "b", "oldState", "c", "Z", "isLinking", "()Z", "d", "isPking", "<init>", "(Lom3/d;Lom3/d;ZZ)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.d$h, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class StateChangeEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final om3.d curState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final om3.d oldState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isLinking;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPking;

        public StateChangeEvent(@NotNull om3.d curState, @NotNull om3.d oldState, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(curState, "curState");
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            this.curState = curState;
            this.oldState = oldState;
            this.isLinking = z16;
            this.isPking = z17;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final om3.d getCurState() {
            return this.curState;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final om3.d getOldState() {
            return this.oldState;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateChangeEvent)) {
                return false;
            }
            StateChangeEvent stateChangeEvent = (StateChangeEvent) other;
            if (Intrinsics.areEqual(this.curState, stateChangeEvent.curState) && Intrinsics.areEqual(this.oldState, stateChangeEvent.oldState) && this.isLinking == stateChangeEvent.isLinking && this.isPking == stateChangeEvent.isPking) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.curState.hashCode() * 31) + this.oldState.hashCode()) * 31;
            boolean z16 = this.isLinking;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isPking;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "StateChangeEvent(curState=" + this.curState + ", oldState=" + this.oldState + ", isLinking=" + this.isLinking + ", isPking=" + this.isPking + ')';
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    d() {
    }
}
