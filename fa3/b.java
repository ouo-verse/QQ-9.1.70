package fa3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes21.dex */
public interface b {
    @Query("SELECT a.* FROM wink_publish_content_table a INNER JOIN (SELECT uin, max(createTime) date FROM wink_publish_content_table WHERE uin=:uin) b ON a.createTime = b.date AND a.uin = b.uin")
    ha3.b a(long j3);

    @Insert(onConflict = 1)
    void b(ha3.b bVar);

    @Query("SELECT * FROM wink_publish_content_table WHERE uin = :uin ORDER BY createTime DESC")
    LiveData<List<ha3.b>> c(long j3);

    @Query("SELECT missionId FROM wink_publish_content_table WHERE uin = :uin ORDER BY createTime DESC")
    List<String> d(long j3);

    @Query("DELETE FROM wink_publish_content_table WHERE uin = :uin AND missionId IN (:missionIds)")
    void delete(long j3, List<String> list);

    @Query("DELETE FROM wink_publish_content_table")
    void deleteAll();

    @Query("DELETE FROM wink_publish_content_table WHERE uin = :uin")
    void deleteAll(long j3);

    @Query("DELETE FROM wink_publish_content_table WHERE uin = :uin AND missionId = :missionId")
    void deleteByMissionId(long j3, String str);

    @Query("DELETE FROM wink_publish_content_table WHERE uin = :uin AND missionId IN (:missionIds)")
    void e(long j3, String[] strArr);

    @Query("SELECT * FROM wink_publish_content_table WHERE uin = :uin AND missionId = :missionId")
    List<ha3.b> f(long j3, String str);

    @Query("SELECT * FROM wink_publish_content_table WHERE uin = :uin AND missionId = :missionId")
    LiveData<List<ha3.b>> g(long j3, String str);

    @Query("SELECT * FROM wink_publish_content_table ORDER BY createTime DESC")
    List<ha3.b> getAllDataSync();

    @Query("SELECT * FROM wink_publish_content_table WHERE uin = :uin AND uploadStatus IN (:uploadStatus)")
    List<ha3.b> getDataByUploadStatusSync(long j3, int[] iArr);

    @Query("UPDATE wink_publish_content_table SET toastStatus = :toastStatus WHERE uin = :uin AND missionId = :missionId")
    void updateToastStatus(long j3, String str, int i3);

    @Query("UPDATE wink_publish_content_table SET uploadStatus = :uploadStatus WHERE uin = :uin AND missionId = :missionId")
    void updateUploadStatus(long j3, String str, int i3);
}
