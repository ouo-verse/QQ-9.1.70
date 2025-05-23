package com.tencent.mobileqq.qqshop.message.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.mobileqq.app.AppConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH'J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH'J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH'J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH'\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/db/b;", "", "Lcom/tencent/mobileqq/qqshop/message/db/a;", AppConstants.Key.COLUMN_MSG_DATA, "", "c", "", "msgCount", "", "uid", "", "b", "msgTime", "a", "position", "", "d", "delete", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    @Query("SELECT * FROM qq_shop_msg_table WHERE msgTime < :msgTime AND uid is :uid ORDER BY msgTime DESC LIMIT :msgCount")
    @NotNull
    List<a> a(long msgTime, int msgCount, @NotNull String uid);

    @Query("SELECT * FROM qq_shop_msg_table WHERE uid is :uid ORDER BY msgTime DESC LIMIT :msgCount")
    @NotNull
    List<a> b(int msgCount, @NotNull String uid);

    @Insert(onConflict = 1)
    long c(@NotNull a msgData);

    @Query("DELETE FROM qq_shop_msg_table WHERE uid is :uid AND msgTime <= (SELECT msgTime FROM qq_shop_msg_table WHERE uid is :uid ORDER BY msgTime DESC LIMIT 1 OFFSET :position)")
    void d(int position, @NotNull String uid);

    @Query("DELETE FROM qq_shop_msg_table WHERE uid is :uid")
    void delete(@NotNull String uid);
}
