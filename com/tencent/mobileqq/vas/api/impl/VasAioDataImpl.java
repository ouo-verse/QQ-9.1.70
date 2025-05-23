package com.tencent.mobileqq.vas.api.impl;

import QQService.EVIPSPEC;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\"\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u00182\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J \u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasAioDataImpl;", "Lcom/tencent/mobileqq/vas/api/IVasAioData;", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "data", "", "troopUin", "friendUin", "", "buildVASPersonalTroopColorNameId", "getCacheKey", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioMsgData;", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "friends", "buildVipIconData", "uin", "buildBubbleAndFont", "", "hideMagicFont", "info", "", "generateFontValue", "sendUin", "buildVASPersonalAvatarPendant", "buildVASMsgAvatarPendant", "Lkotlin/Triple;", "", "getAvatarPendantInfoFromExtension", "chatType", "getAioVasPersonalData", "getAioVasMsgData", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAioDataImpl implements IVasAioData {

    @NotNull
    private static final Object LOCK_OBJ;

    @NotNull
    private static final String SVIP_HANDLER;

    @NotNull
    private static final String TAG = "VasAioDataImpl";

    @NotNull
    private static final LruCache<String, Integer> TROOP_COLOR_NAME_ID_CACHE;
    private static final boolean bugfix;
    private static final boolean isEnable;

    static {
        String implClassName = ((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName();
        Intrinsics.checkNotNullExpressionValue(implClassName, "api(ISVIPHandlerProxy::class.java).implClassName");
        SVIP_HANDLER = implClassName;
        TROOP_COLOR_NAME_ID_CACHE = new LruCache<>(48);
        LOCK_OBJ = new Object();
        ar.Companion companion = com.tencent.mobileqq.vas.ar.INSTANCE;
        isEnable = companion.b("anzaihuang", "2024-05-13", "vas_font_513_123708924").isEnable(true);
        bugfix = companion.b("kenaiyu", "2024-08-05", "vas_bug_128426447").isEnable(false);
    }

    private final void buildBubbleAndFont(String uin, IVasAioData.VasAioMsgData data) {
        AppInterface appInterface;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ISVIPHandler iSVIPHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(SVIP_HANDLER);
        if (businessHandler instanceof ISVIPHandler) {
            iSVIPHandler = (ISVIPHandler) businessHandler;
        }
        if (iSVIPHandler == null) {
            return;
        }
        data.setBubbleId(iSVIPHandler.getSelfBubbleId());
        data.setBubbleDiyTextId(iSVIPHandler.getSelfBubbleDiyTextId());
        data.setBubbleVoiceId(iSVIPHandler.getSelfBubbleVoicePrintId());
        data.setSubBubbleId(iSVIPHandler.getSubBubbleId());
        NTVasSimpleInfo selfFontInfo = iSVIPHandler.getSelfFontInfo();
        if (selfFontInfo != null) {
            QRouteApi api = QRoute.api(IVasMagicFontManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasMagicFontManager::class.java)");
            IVasMagicFontManager iVasMagicFontManager = (IVasMagicFontManager) api;
            boolean isDisableMagicFontType = iVasMagicFontManager.isDisableMagicFontType();
            boolean equals = TextUtils.equals(appInterface.getCurrentAccountUin(), uin);
            boolean z17 = true;
            if (!equals && iVasMagicFontManager.hideGuestMagicFont()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!isDisableMagicFontType && !z16) {
                z17 = false;
            }
            if (z17) {
                data.setMagicFontType(0);
            } else {
                data.setMagicFontType(selfFontInfo.fontEffect);
            }
            data.setFontId(generateFontValue(z17, selfFontInfo));
        }
    }

    private final void buildVASMsgAvatarPendant(IVasAioData.VasAioMsgData data, String sendUin) {
        Triple<Integer, Long, Integer> avatarPendantInfoFromExtension = getAvatarPendantInfoFromExtension(sendUin);
        data.setAvatarId(avatarPendantInfoFromExtension.getFirst().intValue());
        data.setPendantId(avatarPendantInfoFromExtension.getSecond().longValue());
        data.setPendantDiyInfoId(avatarPendantInfoFromExtension.getThird().intValue());
    }

    private final void buildVASPersonalAvatarPendant(IVasAioData.VasAioPersonalData data, String sendUin) {
        Triple<Integer, Long, Integer> avatarPendantInfoFromExtension = getAvatarPendantInfoFromExtension(sendUin);
        data.setAvatarId(avatarPendantInfoFromExtension.getFirst().intValue());
        data.setPendantId(avatarPendantInfoFromExtension.getSecond().longValue());
        data.setPendantDiyInfoId(avatarPendantInfoFromExtension.getThird().intValue());
    }

    private final void buildVASPersonalTroopColorNameId(IVasAioData.VasAioPersonalData data, final String troopUin, final String friendUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        int i3 = 0;
        if (Intrinsics.areEqual(friendUin, "0")) {
            data.setTroopColorNameId(0);
            return;
        }
        final String cacheKey = getCacheKey(troopUin, friendUin);
        TroopMemberInfo troopMemberFromCacheOrFetchAsync = ((ITroopMemberInfoService) peekAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberFromCacheOrFetchAsync(troopUin, friendUin, "VasAioDataImpl-ColorNameId", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.vas.api.impl.y
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                VasAioDataImpl.buildVASPersonalTroopColorNameId$lambda$1(cacheKey, friendUin, troopUin, troopMemberInfo);
            }
        });
        if (troopMemberFromCacheOrFetchAsync != null) {
            data.setTroopColorNameId(troopMemberFromCacheOrFetchAsync.troopColorNickId);
            return;
        }
        Integer num = TROOP_COLOR_NAME_ID_CACHE.get(cacheKey);
        if (num != null) {
            i3 = num.intValue();
        }
        data.setTroopColorNameId(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildVASPersonalTroopColorNameId$lambda$1(String cacheKey, String friendUin, String troopUin, TroopMemberInfo troopMemberInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        Intrinsics.checkNotNullParameter(friendUin, "$friendUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (troopMemberInfo != null) {
            i3 = troopMemberInfo.troopColorNickId;
        } else {
            i3 = 0;
        }
        LruCache<String, Integer> lruCache = TROOP_COLOR_NAME_ID_CACHE;
        Integer num = lruCache.get(cacheKey);
        if (num == null) {
            num = 0;
        }
        if (i3 != num.intValue()) {
            synchronized (LOCK_OBJ) {
                if (i3 == 0) {
                    lruCache.remove(cacheKey);
                } else {
                    lruCache.put(cacheKey, Integer.valueOf(i3));
                }
            }
            new i.n(troopMemberInfo.troopColorNickId).e(true, Long.parseLong(friendUin), troopUin);
        }
    }

    private final void buildVipIconData(IVasAioData.VasAioMsgData data, NTVasSimpleInfo friends) {
        if (friends == null) {
            return;
        }
        IVipInfoUtils.Companion companion = IVipInfoUtils.INSTANCE;
        com.tencent.mobileqq.vip.api.f highestVipTypeWithoutBig = companion.a().getHighestVipTypeWithoutBig(friends);
        data.setMsgVipType(highestVipTypeWithoutBig.f312805a);
        if (highestVipTypeWithoutBig.e()) {
            data.setMsgVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_SUPERVIP));
        } else if (highestVipTypeWithoutBig.d()) {
            data.setMsgVipLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_QQVIP));
        }
        boolean z16 = true;
        if (companion.a().getHighestVipType(friends).c()) {
            data.setMsgBigClubFlag(1);
            data.setMsgBigClubLevel(com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_BIGCLUB));
        }
        data.setGrayNamePlate(friends.grayNameplateFlag);
        data.setNamePlateType(friends.nameplateVipType);
        data.setVipStarFlag(friends.vipStartFlag);
        data.setNamePlateId(friends.superVipTemplateId);
        String str = friends.vipIcons;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            for (int i3 : companion.a().getVipIconsArray(friends.vipIcons)) {
                data.getCarouselNamePlateIds().add(Integer.valueOf(i3));
            }
        }
        data.setExtendNamePlateId(friends.bigClubExtTemplateId);
        data.setGameNamePlateId(friends.gameCardId);
    }

    private final int generateFontValue(boolean hideMagicFont, NTVasSimpleInfo info) {
        int i3 = 0;
        if (hideMagicFont && info != null) {
            info.magicFont = 0;
        }
        if (info != null) {
            long j3 = info.uVipFont;
            int i16 = info.vipFontType;
            int i17 = info.magicFont;
            int i18 = ((int) (((j3 & 255) << 8) + (255 & (j3 >> 8)))) + (i16 << 16) + (i17 << 24);
            if (isEnable) {
                try {
                    QLog.i(TAG, 1, "fontid: " + j3 + ", fontType: " + i16 + ", magicFont: " + i17);
                } catch (Exception unused) {
                }
            }
            i3 = i18;
        }
        if (FontManagerConstants.isTest && info != null) {
            Map<Long, Integer> testFontId = FontManagerConstants.testFontId;
            Intrinsics.checkNotNullExpressionValue(testFontId, "testFontId");
            testFontId.put(Long.valueOf(i3), Integer.valueOf((int) info.uVipFont));
        }
        return i3;
    }

    private final Triple<Integer, Long, Integer> getAvatarPendantInfoFromExtension(String sendUin) {
        long j3;
        int i3;
        int i16 = 0;
        NTVasSimpleInfo queryExtensionInfo = ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).queryExtensionInfo(sendUin, false);
        if (queryExtensionInfo != null) {
            i16 = queryExtensionInfo.faceId;
            j3 = queryExtensionInfo.pendantId;
            i3 = queryExtensionInfo.pendantDiyId;
        } else {
            j3 = 0;
            i3 = 0;
        }
        if (queryExtensionInfo == null) {
            String str = sendUin + System.currentTimeMillis();
            ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).requestFaceId(str, sendUin, TAG, null);
        }
        return new Triple<>(Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i3));
    }

    private final String getCacheKey(String troopUin, String friendUin) {
        return troopUin + "-" + friendUin;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAioData
    @NotNull
    public IVasAioData.VasAioMsgData getAioVasMsgData(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasAioData.VasAioMsgData vasAioMsgData = new IVasAioData.VasAioMsgData();
        buildVASMsgAvatarPendant(vasAioMsgData, uin);
        buildBubbleAndFont(uin, vasAioMsgData);
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        buildVipIconData(vasAioMsgData, iVasInfoService.getVasSimpleInfoWithUid(uid, TAG));
        return vasAioMsgData;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAioData
    @NotNull
    public IVasAioData.VasAioPersonalData getAioVasPersonalData(@NotNull String troopUin, @NotNull String sendUin, int chatType) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(sendUin, "sendUin");
        IVasAioData.VasAioPersonalData vasAioPersonalData = new IVasAioData.VasAioPersonalData();
        if (chatType == 2 || bugfix) {
            buildVASPersonalTroopColorNameId(vasAioPersonalData, troopUin, sendUin);
        }
        buildVASPersonalAvatarPendant(vasAioPersonalData, sendUin);
        return vasAioPersonalData;
    }
}
