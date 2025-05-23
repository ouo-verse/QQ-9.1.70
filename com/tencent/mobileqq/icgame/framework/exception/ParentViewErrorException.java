package com.tencent.mobileqq.icgame.framework.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/exception/ParentViewErrorException;", "Lcom/tencent/mobileqq/icgame/framework/exception/QQLiveException;", "msg", "", "(Ljava/lang/String;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ParentViewErrorException extends QQLiveException {
    public ParentViewErrorException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentViewErrorException(@NotNull String msg2) {
        super(msg2);
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    public /* synthetic */ ParentViewErrorException(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
