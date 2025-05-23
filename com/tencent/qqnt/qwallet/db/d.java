package com.tencent.qqnt.qwallet.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H'J \u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/d;", "", "", "listId", "toUin", "Lcom/tencent/qqnt/qwallet/db/f;", "a", "entity", "", "c", "newText", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface d {
    @Query("SELECT * FROM hb_state_table WHERE listId = :listId AND toUin= :toUin")
    @Nullable
    HbStateEntity a(@NotNull String listId, @NotNull String toUin);

    @Query("UPDATE hb_state_table SET text =:newText WHERE listId= :listId AND toUin= :toUin")
    void b(@NotNull String newText, @NotNull String listId, @NotNull String toUin);

    @Insert(onConflict = 1)
    void c(@NotNull HbStateEntity entity);
}
