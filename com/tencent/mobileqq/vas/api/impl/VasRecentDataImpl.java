package com.tencent.mobileqq.vas.api.impl;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.inject.IVasInject;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.lovechat.api.ILoveStateData;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasRecentDataImpl;", "Lcom/tencent/mobileqq/vas/api/IVasRecentData;", "()V", "TAG", "", "bugfix", "", "needRequestLoveState", "getFriendsVipData", "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "uin", "needDb", "updateFriendsVipData", "", "friends", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "data", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasRecentDataImpl implements IVasRecentData {

    @NotNull
    private final String TAG = "VasRecentDataImpl";
    private boolean needRequestLoveState = true;
    private final boolean bugfix = com.tencent.mobileqq.vas.ar.INSTANCE.b("kenaiyu", "2024-02-20", "vas_bug_vip_icon_123").isEnable(true);

    private final void updateFriendsVipData(NTVasSimpleInfo friends, IVasRecentData.FriendsVipData data) {
        boolean z16;
        boolean areEqual;
        boolean areEqual2;
        boolean areEqual3;
        boolean areEqual4;
        boolean areEqual5;
        boolean areEqual6;
        if (QLog.isDebugVersion()) {
            z16 = true;
            QLog.e(this.TAG, 1, "updateFriendsVipData " + friends.getUin() + "  qqVipInfo " + friends.qqVipInfo + " superQqInfo" + friends.superQqInfo + " superVipInfo" + friends.superVipInfo + " bigClubInfo" + friends.bigClubInfo + " gameCardId" + friends.gameCardId + " bigClubExtTemplateId" + friends.bigClubExtTemplateId + " nameplateVipType" + friends.nameplateVipType + " grayNameplateFlag" + friends.grayNameplateFlag + " bigClubTemplateId" + friends.bigClubTemplateId + " vipicons" + friends.vipIcons + " superVipTemplateId" + friends.superVipTemplateId + " ");
        } else {
            z16 = true;
        }
        IVipInfoUtils.Companion companion = IVipInfoUtils.INSTANCE;
        com.tencent.mobileqq.vip.api.f highestVipType = companion.a().getHighestVipType(friends);
        data.setSuperVip(highestVipType.a());
        data.setGameCardId(friends.gameCardId);
        data.setVipIconEx(friends.bigClubExtTemplateId);
        int i3 = friends.nameplateVipType;
        int i16 = 0;
        if (i3 > 0) {
            data.setVipType(i3);
            data.setGrayNameplateFlag(friends.grayNameplateFlag);
            com.tencent.mobileqq.vip.api.f b16 = com.tencent.mobileqq.vip.api.f.b(data.getVipType());
            if (Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312803g)) {
                areEqual4 = z16;
            } else {
                areEqual4 = Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312804h);
            }
            if (areEqual4) {
                data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_BIGCLUB));
                data.setNamePlateId(friends.bigClubTemplateId);
                if (this.bugfix) {
                    String str = friends.vipIcons;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        int[] vipIconsArray = companion.a().getVipIconsArray(friends.vipIcons);
                        int length = vipIconsArray.length;
                        while (i16 < length) {
                            data.getCarouselNamePlateIds().add(Integer.valueOf(vipIconsArray[i16]));
                            i16++;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312801e)) {
                areEqual5 = z16;
            } else {
                areEqual5 = Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312802f);
            }
            if (areEqual5) {
                data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_SUPERVIP));
                data.setNamePlateId(friends.superVipTemplateId);
                String str2 = friends.vipIcons;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    int[] vipIconsArray2 = companion.a().getVipIconsArray(friends.vipIcons);
                    int length2 = vipIconsArray2.length;
                    while (i16 < length2) {
                        data.getCarouselNamePlateIds().add(Integer.valueOf(vipIconsArray2[i16]));
                        i16++;
                    }
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312799c)) {
                areEqual6 = z16;
            } else {
                areEqual6 = Intrinsics.areEqual(b16, com.tencent.mobileqq.vip.api.f.f312800d);
            }
            if (areEqual6) {
                data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_QQVIP));
                data.setNamePlateId(0);
                return;
            }
            return;
        }
        data.setVipType(highestVipType.f312805a);
        if (Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312803g)) {
            areEqual = z16;
        } else {
            areEqual = Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312804h);
        }
        if (areEqual) {
            data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_BIGCLUB));
            data.setNamePlateId(friends.bigClubTemplateId);
            return;
        }
        if (Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312801e)) {
            areEqual2 = z16;
        } else {
            areEqual2 = Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312802f);
        }
        if (areEqual2) {
            data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_SUPERVIP));
            data.setNamePlateId(friends.superVipTemplateId);
            return;
        }
        if (Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312799c)) {
            areEqual3 = z16;
        } else {
            areEqual3 = Intrinsics.areEqual(highestVipType, com.tencent.mobileqq.vip.api.f.f312800d);
        }
        if (areEqual3) {
            data.setVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_QQVIP));
            data.setNamePlateId(0);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRecentData
    @NotNull
    public IVasRecentData.FriendsVipData getFriendsVipData(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return getFriendsVipData(uin, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRecentData
    @NotNull
    public IVasRecentData.FriendsVipData getFriendsVipData(@NotNull String uin, boolean needDb) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        if (QQTheme.isNowThemeIsSuperTheme()) {
            friendsVipData.setThemePendantId(ThemeUtil.getSuperThemePendant());
        }
        friendsVipData.setFontId(0);
        if (((ILoveStateData) QRoute.api(ILoveStateData.class)).getLoveState() == 1) {
            if (this.needRequestLoveState) {
                this.needRequestLoveState = true;
                IVasInject vasInjectApi = VasInjectApi.getInstance();
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                vasInjectApi.requestCheckLoveState(peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null);
            }
            friendsVipData.setLove(Intrinsics.areEqual(uin, ((ILoveStateData) QRoute.api(ILoveStateData.class)).getLoveUin()));
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uid, "VasRecentDataImpl");
        if (vasSimpleInfoWithUid == null) {
            return friendsVipData;
        }
        updateFriendsVipData(vasSimpleInfoWithUid, friendsVipData);
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getVipIcon().reportDebug("FriendsVipData[" + uin + "] vipDataFlag:" + vasSimpleInfoWithUid.vipDataFlag + " vipStartFlag:" + vasSimpleInfoWithUid.vipStartFlag + " vipType:" + friendsVipData.getVipType() + " vipLevel:" + friendsVipData.getVipLevel() + " namePlateId:" + friendsVipData.getNamePlateId() + " carouselNamePlateIds:" + friendsVipData.getCarouselNamePlateIds() + " diyNamePlateItemId:" + friendsVipData.getDiyNamePlateItemId() + " vipIconEx:" + friendsVipData.getVipIconEx());
        }
        return friendsVipData;
    }
}
