package org.hapjs.storage;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lorg/hapjs/storage/Request;", "", "key", "", "sourceRpk", "(Ljava/lang/String;Ljava/lang/String;)V", "mCaller", "getMCaller", "()Ljava/lang/String;", "mKey", "getMKey", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class Request {

    @Nullable
    private final String mCaller;

    @Nullable
    private final String mKey;

    public Request(@Nullable String str, @Nullable String str2) {
        this.mKey = str;
        this.mCaller = str2;
    }

    @Nullable
    public final String getMCaller() {
        return this.mCaller;
    }

    @Nullable
    public final String getMKey() {
        return this.mKey;
    }
}
