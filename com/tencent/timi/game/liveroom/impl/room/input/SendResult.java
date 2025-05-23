package com.tencent.timi.game.liveroom.impl.room.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/timi/game/liveroom/impl/room/input/StatusEnum;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/input/StatusEnum;", "b", "()Lcom/tencent/timi/game/liveroom/impl/room/input/StatusEnum;", "status", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/input/StatusEnum;Ljava/lang/String;)V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.y, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class SendResult {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final StatusEnum status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/y$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/input/y;", "e", "", "msg", "f", "b", "c", "d", "errorMsg", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.input.y$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SendResult a(@Nullable String errorMsg) {
            StatusEnum statusEnum = StatusEnum.FAILED;
            if (errorMsg == null) {
                errorMsg = "\u53d1\u9001\u5931\u8d25";
            }
            return new SendResult(statusEnum, errorMsg);
        }

        @NotNull
        public final SendResult b() {
            return new SendResult(StatusEnum.FINISH, "\u53d1\u9001\u5b8c\u6210");
        }

        @NotNull
        public final SendResult c() {
            return new SendResult(StatusEnum.NEED_PAY, "\u9700\u8981\u652f\u4ed8");
        }

        @NotNull
        public final SendResult d() {
            return new SendResult(StatusEnum.NEED_REAL_NAME_AUTH, "\u9700\u8981\u5b9e\u540d\u8ba4\u8bc1");
        }

        @NotNull
        public final SendResult e() {
            return new SendResult(StatusEnum.SUCCESS, "\u53d1\u9001\u6210\u529f");
        }

        @NotNull
        public final SendResult f(@NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            return new SendResult(StatusEnum.SUCCESS, msg2);
        }

        Companion() {
        }
    }

    public SendResult(@NotNull StatusEnum status, @NotNull String message) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = status;
        this.message = message;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final StatusEnum getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendResult)) {
            return false;
        }
        SendResult sendResult = (SendResult) other;
        if (this.status == sendResult.status && Intrinsics.areEqual(this.message, sendResult.message)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "SendResult(status=" + this.status + ", message=" + this.message + ")";
    }
}
