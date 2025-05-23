package com.tencent.qqnt.qwallet.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.qzone.album.data.model.AlbumCacheData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH'J\b\u0010\u000e\u001a\u00020\rH'\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/g;", "", "", AlbumCacheData.LOGINUIN, "paymentId", "msgOwnerUin", "", "paymentType", "Lcom/tencent/qqnt/qwallet/db/i;", "c", "entity", "", "b", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface g {
    @Query("DELETE FROM aio_payment_state_table")
    void a();

    @Insert(onConflict = 1)
    long b(@NotNull PaymentStateEntity entity);

    @Query("SELECT * FROM aio_payment_state_table WHERE loginUin = :loginUin AND paymentId = :paymentId AND msgOwnerUin = :msgOwnerUin AND paymentType = :paymentType")
    @Nullable
    PaymentStateEntity c(@NotNull String loginUin, @NotNull String paymentId, @NotNull String msgOwnerUin, int paymentType);
}
