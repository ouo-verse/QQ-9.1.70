package com.tencent.qqprotect.accountassistant.chat.data.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes25.dex */
public interface a {
    @Update
    void a(c cVar);

    @Query("SELECT * FROM assistant_robot_message_table WHERE conversation_id = :conversationID And msg_send_status = 1 ORDER BY row_id DESC LIMIT 1")
    c b(String str);

    @Query("SELECT * FROM assistant_robot_message_table WHERE (:rowID = 0 OR row_id < :rowID) AND conversation_id = :conversationID ORDER BY row_id DESC LIMIT :count")
    List<c> c(String str, long j3, int i3);

    @Query("SELECT * FROM assistant_robot_message_table WHERE msgId = :msgID")
    c d(String str);

    @Delete
    void e(c cVar);

    @Insert(onConflict = 1)
    void f(List<c> list);

    @Query("DELETE FROM assistant_robot_message_table")
    void g();

    @Query("SELECT COUNT(*) FROM assistant_robot_message_table")
    int getItemCount();
}
