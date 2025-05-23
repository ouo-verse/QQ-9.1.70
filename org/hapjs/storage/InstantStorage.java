package org.hapjs.storage;

import com.tencent.luggage.wxa.ig.m;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lorg/hapjs/storage/InstantStorage;", "", "()V", "Companion", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class InstantStorage {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "InstantStorage";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/hapjs/storage/InstantStorage$Companion;", "", "()V", "TAG", "", m.NAME, "Lorg/hapjs/storage/IStorage;", "rpk", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final IStorage getStorage(@NotNull String rpk) {
            Intrinsics.checkNotNullParameter(rpk, "rpk");
            return StorageFactory.INSTANCE.getInstance().create(rpk);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
