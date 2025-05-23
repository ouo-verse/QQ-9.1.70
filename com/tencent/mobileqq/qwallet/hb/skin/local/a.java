package com.tencent.mobileqq.qwallet.hb.skin.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH'J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H'J$\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u000fH'JI\u0010\u0018\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0014H\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/a;", "", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "skinData", "", "c", "", IQWalletPreferenceApi.KEY_SKIN_LIST, "", "insertAll", "", "version", "a", "currentTimeMs", "b", "", "skinId", "outerSkinId", "skinFrom", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "d", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.local.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8465a {
        @Transaction
        public static void a(@NotNull a aVar, @NotNull List<HbSkinData> skinList, @NotNull String version, long j3, @NotNull Function1<? super String, Unit> onSuccess) {
            Intrinsics.checkNotNullParameter(skinList, "skinList");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            aVar.a(version);
            aVar.b(j3);
            aVar.insertAll(skinList);
            onSuccess.invoke(version);
        }
    }

    @Query("DELETE FROM hb_skin_table WHERE skinFrom = 0 AND version is not :version")
    void a(@NotNull String version);

    @Query("DELETE FROM hb_skin_table WHERE skinFrom != 0 AND expireTimeMs < :currentTimeMs")
    void b(long currentTimeMs);

    @Insert(onConflict = 1)
    long c(@NotNull HbSkinData skinData);

    @Transaction
    void d(@NotNull List<HbSkinData> skinList, @NotNull String version, long currentTimeMs, @NotNull Function1<? super String, Unit> onSuccess);

    @Query("SELECT * FROM hb_skin_table WHERE skinId is :skinId AND outerSkinId is :outerSkinId AND skinFrom is :skinFrom")
    @Nullable
    HbSkinData e(int skinId, @Nullable String outerSkinId, int skinFrom);

    @Insert(onConflict = 1)
    void insertAll(@NotNull List<HbSkinData> skinList);
}
