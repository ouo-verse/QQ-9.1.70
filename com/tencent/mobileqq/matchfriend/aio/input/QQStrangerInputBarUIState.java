package com.tencent.mobileqq.matchfriend.aio.input;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "DisplayInputBar", "UpdateIconState", "UpdateSendBtnState", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$DisplayInputBar;", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$UpdateIconState;", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$UpdateSendBtnState;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class QQStrangerInputBarUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$DisplayInputBar;", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "showAssistedChat", "<init>", "(Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class DisplayInputBar extends QQStrangerInputBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showAssistedChat;

        /* renamed from: a, reason: from getter */
        public final boolean getShowAssistedChat() {
            return this.showAssistedChat;
        }

        public int hashCode() {
            boolean z16 = this.showAssistedChat;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "DisplayInputBar(showAssistedChat=" + this.showAssistedChat + ")";
        }

        public DisplayInputBar(boolean z16) {
            super(null);
            this.showAssistedChat = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayInputBar) && this.showAssistedChat == ((DisplayInputBar) other).showAssistedChat;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$UpdateIconState;", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", "emoticonSelected", "e", "a", "assistedChatSelected", "<init>", "(ZZ)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final /* data */ class UpdateIconState extends QQStrangerInputBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean emoticonSelected;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean assistedChatSelected;

        /* renamed from: a, reason: from getter */
        public final boolean getAssistedChatSelected() {
            return this.assistedChatSelected;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getEmoticonSelected() {
            return this.emoticonSelected;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.emoticonSelected;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.assistedChatSelected;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "UpdateIconState(emoticonSelected=" + this.emoticonSelected + ", assistedChatSelected=" + this.assistedChatSelected + ")";
        }

        public UpdateIconState(boolean z16, boolean z17) {
            super(null);
            this.emoticonSelected = z16;
            this.assistedChatSelected = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateIconState)) {
                return false;
            }
            UpdateIconState updateIconState = (UpdateIconState) other;
            return this.emoticonSelected == updateIconState.emoticonSelected && this.assistedChatSelected == updateIconState.assistedChatSelected;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState$UpdateSendBtnState;", "Lcom/tencent/mobileqq/matchfriend/aio/input/QQStrangerInputBarUIState;", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class UpdateSendBtnState extends QQStrangerInputBarUIState {

        /* renamed from: d, reason: collision with root package name */
        public static final UpdateSendBtnState f243903d = new UpdateSendBtnState();

        UpdateSendBtnState() {
            super(null);
        }
    }

    public /* synthetic */ QQStrangerInputBarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    QQStrangerInputBarUIState() {
    }
}
