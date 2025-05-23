package com.tencent.qqnt.qwallet.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Database(entities = {PaymentStateEntity.class, HbCommandEntity.class, HbStateEntity.class}, exportSchema = false, version = 3)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/QWalletDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/tencent/qqnt/qwallet/db/g;", "e", "Lcom/tencent/qqnt/qwallet/db/a;", "c", "Lcom/tencent/qqnt/qwallet/db/d;", "d", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class QWalletDatabase extends RoomDatabase {
    @NotNull
    public abstract a c();

    @NotNull
    public abstract d d();

    @NotNull
    public abstract g e();
}
