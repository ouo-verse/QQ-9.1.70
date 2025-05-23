package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "AddQuoteView", "ChangeQuoteViewState", "RemoveQuoteView", "UpdateBottomMargin", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$AddQuoteView;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$ChangeQuoteViewState;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$RemoveQuoteView;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$UpdateBottomMargin;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class QQStrangerQuoteUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$ChangeQuoteViewState;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", "show", "e", "a", "needAnim", "<init>", "(ZZ)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class ChangeQuoteViewState extends QQStrangerQuoteUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needAnim;

        /* renamed from: a, reason: from getter */
        public final boolean getNeedAnim() {
            return this.needAnim;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.show;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.needAnim;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "ChangeQuoteViewState(show=" + this.show + ", needAnim=" + this.needAnim + ")";
        }

        public ChangeQuoteViewState(boolean z16, boolean z17) {
            super(null);
            this.show = z16;
            this.needAnim = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeQuoteViewState)) {
                return false;
            }
            ChangeQuoteViewState changeQuoteViewState = (ChangeQuoteViewState) other;
            return this.show == changeQuoteViewState.show && this.needAnim == changeQuoteViewState.needAnim;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$RemoveQuoteView;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "needAnim", "<init>", "(Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class RemoveQuoteView extends QQStrangerQuoteUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needAnim;

        /* renamed from: a, reason: from getter */
        public final boolean getNeedAnim() {
            return this.needAnim;
        }

        public int hashCode() {
            boolean z16 = this.needAnim;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "RemoveQuoteView(needAnim=" + this.needAnim + ")";
        }

        public RemoveQuoteView(boolean z16) {
            super(null);
            this.needAnim = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RemoveQuoteView) && this.needAnim == ((RemoveQuoteView) other).needAnim;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$UpdateBottomMargin;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "margin", "<init>", "(I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class UpdateBottomMargin extends QQStrangerQuoteUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int margin;

        /* renamed from: a, reason: from getter */
        public final int getMargin() {
            return this.margin;
        }

        public int hashCode() {
            return this.margin;
        }

        public String toString() {
            return "UpdateBottomMargin(margin=" + this.margin + ")";
        }

        public UpdateBottomMargin(int i3) {
            super(null);
            this.margin = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateBottomMargin) && this.margin == ((UpdateBottomMargin) other).margin;
        }
    }

    public /* synthetic */ QQStrangerQuoteUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    QQStrangerQuoteUIState() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState$AddQuoteView;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "d", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "a", "()Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "data", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/quote/c;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class AddQuoteView extends QQStrangerQuoteUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerQuoteData data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddQuoteView(QQStrangerQuoteData data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerQuoteData getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "AddQuoteView(data=" + this.data + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AddQuoteView) && Intrinsics.areEqual(this.data, ((AddQuoteView) other).data);
        }
    }
}
