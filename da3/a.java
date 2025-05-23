package da3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import ha3.PhotoFace;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes21.dex */
public interface a {
    @Query("SELECT * FROM photo_face")
    LiveData<List<PhotoFace>> a();

    @Insert(onConflict = 1)
    void insertAll(List<PhotoFace> list);
}
