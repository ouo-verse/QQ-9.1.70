package com.squareup.wire;

import com.tencent.mobileqq.msf.core.auth.k;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/squareup/wire/MessageSource;", "T", "", "Ljava/io/Closeable;", k.f247491e, "()Ljava/lang/Object;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface MessageSource<T> extends Closeable {
    @Nullable
    T read() throws IOException;
}
