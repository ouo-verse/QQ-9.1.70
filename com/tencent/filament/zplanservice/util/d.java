package com.tencent.filament.zplanservice.util;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a)\u0010\u0006\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "b", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "msg", "a", "([BLcom/tencent/mobileqq/pb/MessageMicro;)Lcom/tencent/mobileqq/pb/MessageMicro;", "zplan-service_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d {
    @NotNull
    public static final <T extends MessageMicro<T>> T a(@NotNull byte[] mergeTo, @NotNull T msg2) {
        Intrinsics.checkNotNullParameter(mergeTo, "$this$mergeTo");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        msg2.mergeFrom(mergeTo);
        return msg2;
    }

    @NotNull
    public static final ByteStringMicro b(@NotNull byte[] toByteStringMacro) {
        Intrinsics.checkNotNullParameter(toByteStringMacro, "$this$toByteStringMacro");
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(toByteStringMacro);
        Intrinsics.checkNotNullExpressionValue(copyFrom, "ByteStringMicro.copyFrom(this)");
        return copyFrom;
    }
}
