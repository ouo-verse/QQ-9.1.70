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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconExFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "data", "Lcom/tencent/mobileqq/vas/image/c;", "getIcon", "", "scene", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "getIconForAIO", "getIconForRecent", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipIconExFactory extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\bJ\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\b\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconExFactory$Companion;", "", "()V", "getIconHeight", "", "res", "Landroid/content/res/Resources;", "getIconWidth", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @JvmStatic
        public final float getIconHeight(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            return IVipIconFactory.INSTANCE.getIconHeight(res);
        }

        @JvmStatic
        public final float getIconWidth(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            return IVipIconFactory.INSTANCE.getIconHeight(res);
        }
    }

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull IVasRecentData.FriendsVipData data);

    @Nullable
    c getIcon(@NotNull Resources res, @NotNull IVasRecentData.FriendsVipData data, @NotNull String scene);

    @Nullable
    c getIconForAIO(@NotNull Resources res, @NotNull VASPersonalNamePlate data);

    @Nullable
    c getIconForRecent(@NotNull Resources res, @NotNull VASPersonalNamePlate data);
}
