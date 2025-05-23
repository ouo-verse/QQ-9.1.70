package com.tencent.mobileqq.vas.vipicon.api.impl;

import android.content.res.Resources;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\fH\u0016J*\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipIconFactoryImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconFactory;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "data", "Landroid/content/res/Resources;", "res", "", "scene", "Lcom/tencent/mobileqq/vas/image/c;", "getIcoinFromNamePlateData", "uin", "getIcon", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "getIconForAIO", "getIconForRecent", "", "id", "getMedalIcon", "getIconHeight", "getIconWidth", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipIconFactoryImpl implements IVipIconFactory {
    private final com.tencent.mobileqq.vas.image.c getIcoinFromNamePlateData(VASPersonalNamePlate data, Resources res, String scene) {
        Integer num = data.vipLevel;
        if (num != null && num.intValue() == 0) {
            VasLogNtReporter.INSTANCE.getVipIcon().reportLow("invalid in aio : level = 0");
            return null;
        }
        Integer id5 = data.diyNamePlateItemId;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        if (id5.intValue() > 0) {
            IVipIconFactory.Companion companion = IVipIconFactory.INSTANCE;
            int iconWidth = (int) companion.getIconWidth(res);
            int iconHeight = (int) companion.getIconHeight(res);
            int intValue = id5.intValue();
            Integer num2 = data.vipLevel;
            Intrinsics.checkNotNullExpressionValue(num2, "data.vipLevel");
            int intValue2 = num2.intValue();
            Integer num3 = data.diyNamePlateContentIds.get(0);
            Intrinsics.checkNotNullExpressionValue(num3, "data.diyNamePlateContentIds[0]");
            int intValue3 = num3.intValue();
            int size = data.diyNamePlateContentIds.size() - 1;
            int[] iArr = new int[size];
            int i3 = 0;
            while (i3 < size) {
                int i16 = i3 + 1;
                Integer num4 = data.diyNamePlateContentIds.get(i16);
                Intrinsics.checkNotNullExpressionValue(num4, "data.diyNamePlateContentIds[it + 1]");
                iArr[i3] = num4.intValue();
                i3 = i16;
            }
            com.tencent.mobileqq.vas.vipicon.c cVar = new com.tencent.mobileqq.vas.vipicon.c(iconWidth, iconHeight, intValue, intValue2, intValue3, iArr, null, scene);
            cVar.F(false);
            return cVar;
        }
        Intrinsics.checkNotNullExpressionValue(data.carouselNamePlateIds, "data.carouselNamePlateIds");
        if (!r0.isEmpty()) {
            IVipIconFactory.Companion companion2 = IVipIconFactory.INSTANCE;
            return new VipIcon((int) companion2.getIconWidth(res), (int) companion2.getIconHeight(res), new VipIconFactoryImpl$getIcoinFromNamePlateData$3(data), null, scene, data.carouselNamePlateIds + "_" + data.vipType + "_" + data.vipLevel + "_false");
        }
        Integer num5 = data.vipType;
        Intrinsics.checkNotNullExpressionValue(num5, "data.vipType");
        if (num5.intValue() <= 0) {
            return null;
        }
        IVipIconFactory.Companion companion3 = IVipIconFactory.INSTANCE;
        return new VipIcon((int) companion3.getIconWidth(res), (int) companion3.getIconHeight(res), new VipIconFactoryImpl$getIcoinFromNamePlateData$4(data), null, scene, data.namePlateId + "_" + data.vipType + "_" + data.vipLevel + "_false");
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return getIcon(res, uin, "");
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIconForAIO(@NotNull Resources res, @NotNull VASPersonalNamePlate data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        return getIcoinFromNamePlateData(data, res, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIconForRecent(@NotNull Resources res, @NotNull VASPersonalNamePlate data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.vas.image.c icoinFromNamePlateData = getIcoinFromNamePlateData(data, res, "RECENT");
        if (icoinFromNamePlateData != null) {
            icoinFromNamePlateData.setLoop(false);
        }
        return icoinFromNamePlateData;
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    public int getIconHeight(@NotNull Resources res, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin);
        if (friendsVipData.getNamePlateId() != 0 && friendsVipData.getNamePlateId() < 20712) {
            return Utils.n(15.0f, res);
        }
        return Utils.n(18.0f, res);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r8.getVipLevel() == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        if (r8.getVipLevel() == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        if (r8.getVipLevel() == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r8.getVipLevel() >= 10) goto L37;
     */
    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getIconWidth(@NotNull Resources res, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin);
        if (friendsVipData.getNamePlateId() != 0 && friendsVipData.getNamePlateId() < 20712) {
            return Utils.n(50.0f, res);
        }
        int vipType = friendsVipData.getVipType();
        int i3 = 48;
        if (vipType != 1) {
            if (vipType != 2) {
                if (vipType != 3) {
                    switch (vipType) {
                        case 258:
                            if (friendsVipData.getVipLevel() != 0) {
                                if (friendsVipData.getVipLevel() >= 10) {
                                    i3 = 65;
                                    break;
                                }
                                i3 = 61;
                                break;
                            }
                            i3 = 56;
                            break;
                    }
                }
            } else if (friendsVipData.getVipLevel() != 0) {
            }
        } else if (friendsVipData.getVipLevel() == 0) {
            i3 = 40;
        }
        return Utils.n(i3, res);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @NotNull
    public com.tencent.mobileqq.vas.image.c getMedalIcon(@NotNull Resources res, int id5) {
        Intrinsics.checkNotNullParameter(res, "res");
        return new VipIcon(80, 40, new VipIconFactoryImpl$getMedalIcon$1(id5), null, "", "medal_" + id5);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        return getIcon(res, uin, ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin), scene);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull IVasRecentData.FriendsVipData data) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(data, "data");
        return getIcon(res, uin, data, "");
    }

    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory
    @Nullable
    public com.tencent.mobileqq.vas.image.c getIcon(@NotNull Resources res, @NotNull String uin, @NotNull IVasRecentData.FriendsVipData data, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (data.getDiyNamePlateItemId() == 0 && data.getDiyNamePlateContentIds().isEmpty()) {
            VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin);
            if (vipDataForFriends.getNameplateItemId() > 0) {
                data.setDiyNamePlateItemId(vipDataForFriends.getNameplateItemId());
                data.getDiyNamePlateContentIds().add(Integer.valueOf(vipDataForFriends.getNameplateFgId()));
                for (int i3 : vipDataForFriends.getNameplateLetters()) {
                    data.getDiyNamePlateContentIds().add(Integer.valueOf(i3));
                }
            }
        }
        int diyNamePlateItemId = data.getDiyNamePlateItemId();
        if (data.getGrayNameplateFlag() != 0) {
            if (data.getVipType() == 0) {
                VasLogNtReporter.INSTANCE.getVipIcon().reportLow("invalid gray : vipType = 0");
                return null;
            }
            IVipIconFactory.Companion companion = IVipIconFactory.INSTANCE;
            return new VipIcon((int) companion.getIconWidth(res), (int) companion.getIconHeight(res), new VipIconFactoryImpl$getIcon$2(data), null, scene, "0_" + data.getVipType() + "_" + data.getVipLevel() + "_true");
        }
        if (diyNamePlateItemId > 0) {
            if (data.getVipLevel() == 0) {
                VasLogNtReporter.INSTANCE.getVipIcon().reportLow("invalid diy : level = 0");
                return null;
            }
            IVipIconFactory.Companion companion2 = IVipIconFactory.INSTANCE;
            int iconWidth = (int) companion2.getIconWidth(res);
            int iconHeight = (int) companion2.getIconHeight(res);
            int vipLevel = data.getVipLevel();
            Integer num = data.getDiyNamePlateContentIds().get(0);
            Intrinsics.checkNotNullExpressionValue(num, "data.diyNamePlateContentIds[0]");
            int intValue = num.intValue();
            int size = data.getDiyNamePlateContentIds().size() - 1;
            int[] iArr = new int[size];
            int i16 = 0;
            while (i16 < size) {
                int i17 = i16 + 1;
                Integer num2 = data.getDiyNamePlateContentIds().get(i17);
                Intrinsics.checkNotNullExpressionValue(num2, "data.diyNamePlateContentIds[it + 1]");
                iArr[i16] = num2.intValue();
                i16 = i17;
            }
            com.tencent.mobileqq.vas.vipicon.c cVar = new com.tencent.mobileqq.vas.vipicon.c(iconWidth, iconHeight, diyNamePlateItemId, vipLevel, intValue, iArr, null, scene);
            cVar.F(false);
            return cVar;
        }
        if (!data.getCarouselNamePlateIds().isEmpty()) {
            if (data.getVipLevel() == 0) {
                VasLogNtReporter.INSTANCE.getVipIcon().reportLow("invalid carousel : level = 0");
                return null;
            }
            IVipIconFactory.Companion companion3 = IVipIconFactory.INSTANCE;
            return new VipIcon((int) companion3.getIconWidth(res), (int) companion3.getIconHeight(res), new VipIconFactoryImpl$getIcon$5(data), null, scene, data.getCarouselNamePlateIds() + "_" + data.getVipType() + "_" + data.getVipLevel() + "_false");
        }
        if (data.getVipType() <= 0) {
            return null;
        }
        if (data.getVipLevel() == 0) {
            VasLogNtReporter.INSTANCE.getVipIcon().reportLow("invalid normal : level = 0");
            return null;
        }
        IVipIconFactory.Companion companion4 = IVipIconFactory.INSTANCE;
        return new VipIcon((int) companion4.getIconWidth(res), (int) companion4.getIconHeight(res), new VipIconFactoryImpl$getIcon$6(data), null, scene, data.getNamePlateId() + "_" + data.getVipType() + "_" + data.getVipLevel() + "_false");
    }
}
