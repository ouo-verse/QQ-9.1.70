package com.tencent.now.linkpkanchorplay.event;

import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import g55.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0007\u0005\u0004\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "Lcom/tencent/now/linkpkanchorplay/event/a;", "<init>", "()V", "b", "a", "PKType", "c", "d", "e", "f", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$a;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$c;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$d;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$e;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$f;", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class UIEvent extends com.tencent.now.linkpkanchorplay.event.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "", "(Ljava/lang/String;I)V", "LinkPK", "Rank_Normal_PK", "Rank_Link_PK", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public enum PKType {
        LinkPK,
        Rank_Normal_PK,
        Rank_Link_PK
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$a;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends UIEvent {
        public a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$c;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c extends UIEvent {
        public c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$d;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "c", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "a", "()Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "selectedPKType", "<init>", "(Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.UIEvent$d, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ShowPKRandomMatchPanel extends UIEvent {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final PKType selectedPKType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPKRandomMatchPanel(@NotNull PKType selectedPKType) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedPKType, "selectedPKType");
            this.selectedPKType = selectedPKType;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final PKType getSelectedPKType() {
            return this.selectedPKType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowPKRandomMatchPanel) && this.selectedPKType == ((ShowPKRandomMatchPanel) other).selectedPKType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.selectedPKType.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowPKRandomMatchPanel(selectedPKType=" + this.selectedPKType + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$e;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lg55/ag;", "c", "Lg55/ag;", "a", "()Lg55/ag;", "inviteMsg", "<init>", "(Lg55/ag;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.UIEvent$e, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ShowReceiveInviteUI extends UIEvent {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ag inviteMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowReceiveInviteUI(@NotNull ag inviteMsg) {
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
            if ((other instanceof ShowReceiveInviteUI) && Intrinsics.areEqual(this.inviteMsg, ((ShowReceiveInviteUI) other).inviteMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inviteMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowReceiveInviteUI(inviteMsg=" + this.inviteMsg + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/UIEvent$f;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", "b", "()I", "pageType", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "d", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "a", "()Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "<init>", "(ILcom/tencent/now/linkpkanchorplay/invite/model/a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.event.UIEvent$f, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ShowSecondaryPageEvent extends UIEvent {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pageType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final AnchorTabPageContext pageContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSecondaryPageEvent(int i3, @NotNull AnchorTabPageContext pageContext) {
            super(null);
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            this.pageType = i3;
            this.pageContext = pageContext;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AnchorTabPageContext getPageContext() {
            return this.pageContext;
        }

        /* renamed from: b, reason: from getter */
        public final int getPageType() {
            return this.pageType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowSecondaryPageEvent)) {
                return false;
            }
            ShowSecondaryPageEvent showSecondaryPageEvent = (ShowSecondaryPageEvent) other;
            if (this.pageType == showSecondaryPageEvent.pageType && Intrinsics.areEqual(this.pageContext, showSecondaryPageEvent.pageContext)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.pageType * 31) + this.pageContext.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowSecondaryPageEvent(pageType=" + this.pageType + ", pageContext=" + this.pageContext + ')';
        }
    }

    public /* synthetic */ UIEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    UIEvent() {
    }
}
