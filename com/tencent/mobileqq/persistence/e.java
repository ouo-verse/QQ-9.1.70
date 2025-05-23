package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/persistence/e;", "Lcom/tencent/mobileqq/persistence/d;", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/mobileqq/persistence/Entity;", "a", "Ljava/lang/Class;", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends Entity> clazz;

    public e(@NotNull Class<? extends Entity> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.clazz = clazz;
    }

    @Override // com.tencent.mobileqq.persistence.d
    @Nullable
    public Entity a(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        return this.clazz.newInstance();
    }
}
