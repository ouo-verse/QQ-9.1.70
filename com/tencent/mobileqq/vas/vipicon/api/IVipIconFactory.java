package com.tencent.mobileqq.vas.vipicon.api;

import android.content.res.Resources;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J*\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/res/Resources;", "res", "", "uin", "Lcom/tencent/mobileqq/vas/image/c;", "getIcon", "scene", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "data", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "getIconForAIO", "getIconForRecent", "", "id", "getMedalIcon", "getIconHeight", "getIconWidth", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipIconFactory extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconFactory$Companion;", "", "()V", "FIX_HEIGHT_BY_DP_FOR_AIO", "", "getIconHeight", "", "res", "Landroid/content/res/Resources;", "getIconWidth", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int FIX_HEIGHT_BY_DP_FOR_AIO = 14;

        Companion() {
        }

        @JvmStatic
        public final float getIconHeight(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            return (14 * res.getDisplayMetrics().density) + 0.5f;
        }

        @JvmStatic
        public final float getIconWidth(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            return (getIconHeight(res) / 30) * 100;
        }
    }

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull String uin);

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull IVasRecentData.FriendsVipData data);

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull IVasRecentData.FriendsVipData data, @NotNull String scene);

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull String scene);

    @Nullable
    c getIconForAIO(@NotNull Resources res, @NotNull VASPersonalNamePlate data);

    @Nullable
    c getIconForRecent(@NotNull Resources res, @NotNull VASPersonalNamePlate data);

    int getIconHeight(@NotNull Resources res, @NotNull String uin);

    int getIconWidth(@NotNull Resources res, @NotNull String uin);

    @NotNull
    c getMedalIcon(@NotNull Resources res, int id5);
}
