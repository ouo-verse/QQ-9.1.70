package com.squareup.wire;

import com.tencent.mobileqq.msf.core.auth.k;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/MessageSink;", "T", "", "Ljava/io/Closeable;", "cancel", "", k.f247492f, "message", "(Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface MessageSink<T> extends Closeable {
    void cancel() throws IOException;

    void write(@NotNull T message) throws IOException;
}
