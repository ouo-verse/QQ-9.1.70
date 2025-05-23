package com.tencent.mobileqq.vas.vipicon.api.impl;

import android.content.res.Resources;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipIconExFactoryImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconExFactory;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "data", "Landroid/content/res/Resources;", "res", "", "scene", "Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "getIconFromNamePlateData", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "Lcom/tencent/mobileqq/vas/image/c;", "getIcon", "getIconForAIO", "getIconForRecent", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipIconExFactoryImpl implements IVipIconExFactory {
    private final VipIcon getIconFromNamePlateData(VASPersonalNamePlate data, Resources res, String scene) {
        Integer num = data.extendNamePlateId;
        Intrinsics.checkNotNullExpressionValue(num, "data.extendNamePlateId");
        if (num.intValue() < 1) {
            return null;
        }
        IVipIconFactory.Companion companion = IVipIconFactory.INSTANCE;
        return new VipIcon((int) companion.getIconHeight(res), (int) companion.getIconHeight(res), new VipIconExFactoryImpl$getIconFromNamePlateData$1(data), null, scene, "ex_" + data.extendNamePlateId);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull IVasRecentData.FriendsVipData data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        return getIcon(res, data, "");
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIconForAIO(@NotNull Resources res, @NotNull VASPersonalNamePlate data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        return getIconFromNamePlateData(data, res, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIconForRecent(@NotNull Resources res, @NotNull VASPersonalNamePlate data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        VipIcon iconFromNamePlateData = getIconFromNamePlateData(data, res, "RECENT");
        if (iconFromNamePlateData != null) {
            iconFromNamePlateData.setLoop(false);
        }
        return iconFromNamePlateData;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull IVasRecentData.FriendsVipData data, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (data.getVipIconEx() < 1) {
            return null;
        }
        IVipIconFactory.Companion companion = IVipIconFactory.INSTANCE;
        return new VipIcon((int) companion.getIconHeight(res), (int) companion.getIconHeight(res), new VipIconExFactoryImpl$getIcon$1(data), null, scene, "ex_" + data.getVipIconEx());
    }
}
