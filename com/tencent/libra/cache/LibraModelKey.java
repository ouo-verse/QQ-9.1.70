package com.tencent.libra.cache;

import com.tencent.libra.base.model.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/libra/cache/e;", "Lcom/tencent/libra/cache/Key;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/libra/base/model/Model;", "a", "Lcom/tencent/libra/base/model/Model;", "model", "<init>", "(Lcom/tencent/libra/base/model/Model;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.libra.cache.e, reason: from toString */
/* loaded from: classes7.dex */
public final class LibraModelKey implements Key {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Model<?> model;

    public LibraModelKey(@NotNull Model<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
    }

    @Override // com.tencent.libra.cache.Key
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && !(true ^ Intrinsics.areEqual(LibraModelKey.class, other.getClass()))) {
            return Intrinsics.areEqual(this.model.a(), ((LibraModelKey) other).model.a());
        }
        return false;
    }

    @Override // com.tencent.libra.cache.Key
    public int hashCode() {
        Object a16 = this.model.a();
        if (a16 != null) {
            return a16.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "LibraModelKey(model=" + this.model + ')';
    }
}
