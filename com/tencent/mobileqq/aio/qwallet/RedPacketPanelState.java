package com.tencent.mobileqq.aio.qwallet;

import com.tencent.aio.api.runtime.a;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "InitCompletedState", "VisibilityChangeState", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState$InitCompletedState;", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState$VisibilityChangeState;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class RedPacketPanelState implements MviUIState {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState$InitCompletedState;", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "c", "()I", "chatType", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "chatId", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(ILjava/lang/String;Lcom/tencent/aio/api/runtime/a;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class InitCompletedState extends RedPacketPanelState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int chatType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String chatId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final a aioContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitCompletedState(int i3, @NotNull String chatId, @NotNull a aioContext) {
            super(null);
            Intrinsics.checkNotNullParameter(chatId, "chatId");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            this.chatType = i3;
            this.chatId = chatId;
            this.aioContext = aioContext;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getAioContext() {
            return this.aioContext;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getChatId() {
            return this.chatId;
        }

        /* renamed from: c, reason: from getter */
        public final int getChatType() {
            return this.chatType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitCompletedState)) {
                return false;
            }
            InitCompletedState initCompletedState = (InitCompletedState) other;
            if (this.chatType == initCompletedState.chatType && Intrinsics.areEqual(this.chatId, initCompletedState.chatId) && Intrinsics.areEqual(this.aioContext, initCompletedState.aioContext)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.chatType * 31) + this.chatId.hashCode()) * 31) + this.aioContext.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitCompletedState(chatType=" + this.chatType + ", chatId=" + this.chatId + ", aioContext=" + this.aioContext + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState$VisibilityChangeState;", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isVisible", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class VisibilityChangeState extends RedPacketPanelState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isVisible;

        public VisibilityChangeState(boolean z16) {
            super(null);
            this.isVisible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof VisibilityChangeState) && this.isVisible == ((VisibilityChangeState) other).isVisible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isVisible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "VisibilityChangeState(isVisible=" + this.isVisible + ")";
        }
    }

    public /* synthetic */ RedPacketPanelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RedPacketPanelState() {
    }
}
