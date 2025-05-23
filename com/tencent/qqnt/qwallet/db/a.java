package com.tencent.qqnt.qwallet.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/a;", "", "", "listId", "Lcom/tencent/qqnt/qwallet/db/c;", "b", "cmd", "c", "entity", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    @Insert(onConflict = 1)
    void a(@NotNull HbCommandEntity entity);

    @Query("SELECT * FROM hb_command_table WHERE listId =:listId")
    @Nullable
    HbCommandEntity b(@NotNull String listId);

    @Query("SELECT * FROM hb_command_table WHERE command=:cmd ORDER BY expireTime DESC LIMIT 1")
    @Nullable
    HbCommandEntity c(@NotNull String cmd);
}
