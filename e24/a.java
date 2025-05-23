package e24;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\n\u001a\u00020\u0004H'\u00a8\u0006\u000b"}, d2 = {"Le24/a;", "", "Le24/c;", "data", "", "b", "", "key", "a", "c", "deleteAll", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    @Query("SELECT * FROM kuikly_data WHERE dataKey is :key")
    @Nullable
    KuiklyData a(@NotNull String key);

    @Insert(onConflict = 1)
    void b(@NotNull KuiklyData data);

    @Query("DELETE FROM kuikly_data WHERE dataKey is :key")
    void c(@NotNull String key);

    @Query("DELETE FROM kuikly_data")
    void deleteAll();
}
