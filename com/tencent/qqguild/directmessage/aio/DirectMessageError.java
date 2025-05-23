package com.tencent.qqguild.directmessage.aio;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/DirectMessageError;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "errorCode", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "errorMessage", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class DirectMessageError implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMessage;

    public DirectMessageError(int i3, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.errorCode = i3;
        this.errorMessage = errorMessage;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectMessageError)) {
            return false;
        }
        DirectMessageError directMessageError = (DirectMessageError) other;
        if (this.errorCode == directMessageError.errorCode && Intrinsics.areEqual(this.errorMessage, directMessageError.errorMessage)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    public int hashCode() {
        return (this.errorCode * 31) + this.errorMessage.hashCode();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    @NotNull
    public String toString() {
        return "DirectMessageError(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}
