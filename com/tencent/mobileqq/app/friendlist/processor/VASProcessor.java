package com.tencent.mobileqq.app.friendlist.processor;

import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vip.api.b;
import com.tencent.mobileqq.vip.api.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import friendlist.FriendInfo;
import gxh_message.Dialogue;
import hx3.c;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class VASProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    /* loaded from: classes11.dex */
    class a implements c<NTVasSimpleInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VASProcessor.this);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<NTVasSimpleInfo> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            }
        }
    }

    public VASProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        for (Pair<ExtensionInfo, FriendInfo> pair : list) {
            ExtensionInfo extensionInfo = (ExtensionInfo) pair.first;
            FriendInfo friendInfo = (FriendInfo) pair.second;
            extensionInfo.pendantId = friendInfo.ulFaceAddonId;
            extensionInfo.uVipFont = FontManagerConstants.parseFontId(friendInfo.uFounderFont);
            extensionInfo.vipFontType = FontManagerConstants.parseFontType(friendInfo.uFounderFont);
            extensionInfo.magicFont = (friendInfo.cSpecialFlag >> 3) & 1;
            extensionInfo.colorRingId = friendInfo.uColorRing;
            extensionInfo.timestamp = j3;
            extensionInfo.fontEffect = (int) friendInfo.uFontEffect;
            extensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
            extensionInfo.latestPLUpdateTimestamp = friendInfo.uTagUpdateTime;
            long j16 = extensionInfo.faceId;
            long j17 = friendInfo.uFaceStoreId;
            if (j16 != j17) {
                extensionInfo.faceId = (int) j17;
                extensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        boolean z17;
        int i3;
        int i16;
        int i17;
        int i18;
        Map<Integer, VipOpenInfo> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.VASFriendProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        IFriendDataService iFriendDataService = (IFriendDataService) appRuntime.getRuntimeService(IFriendDataService.class, "all");
        for (Pair<Friends, FriendInfo> pair : list) {
            Friends friends = (Friends) pair.first;
            FriendInfo friendInfo = (FriendInfo) pair.second;
            friends.namePlateOfKingGameId = friendInfo.uGameAppid;
            friends.namePlateOfKingLoginTime = friendInfo.uGameLastLoginTime;
            friends.namePlateOfKingDan = (int) friendInfo.ulKingOfGloryRank;
            if (friendInfo.cKingOfGloryFlag == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            friends.namePlateOfKingDanDisplatSwitch = z17;
            if (!TextUtils.isEmpty(friends.uin) && this.mApp.getCurrentUin().equals(friends.uin)) {
                this.mApp.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit().putBoolean("plate_of_king_display_switch_" + this.mApp.getCurrentUin(), friends.namePlateOfKingDanDisplatSwitch).apply();
            }
            Friends friend = iFriendDataService.getFriend(friends.uin);
            VipBaseInfo vipBaseInfo = friendInfo.oVipInfo;
            int value = EVIPSPEC.E_SP_QQVIP.value();
            if (friend != null) {
                i3 = friend.qqVipInfo;
            } else {
                i3 = 0;
            }
            friends.qqVipInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo, value, i3);
            VipBaseInfo vipBaseInfo2 = friendInfo.oVipInfo;
            int value2 = EVIPSPEC.E_SP_SUPERQQ.value();
            if (friend != null) {
                i16 = friend.superQqInfo;
            } else {
                i16 = 0;
            }
            friends.superQqInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo2, value2, i16);
            VipBaseInfo vipBaseInfo3 = friendInfo.oVipInfo;
            EVIPSPEC evipspec = EVIPSPEC.E_SP_SUPERVIP;
            int value3 = evipspec.value();
            if (friend != null) {
                i17 = friend.superVipInfo;
            } else {
                i17 = 0;
            }
            friends.superVipInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo3, value3, i17);
            VipBaseInfo vipBaseInfo4 = friendInfo.oVipInfo;
            EVIPSPEC evipspec2 = EVIPSPEC.E_SP_BIGCLUB;
            int value4 = evipspec2.value();
            if (friend != null) {
                i18 = friend.bigClubInfo;
            } else {
                i18 = 0;
            }
            friends.bigClubInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo4, value4, i18);
            friends.cNewLoverDiamondFlag = friendInfo.cNewLoverDiamondFlag;
            VipBaseInfo vipBaseInfo5 = friendInfo.oVipInfo;
            if (vipBaseInfo5 != null && (map = vipBaseInfo5.mOpenInfo) != null) {
                VipOpenInfo vipOpenInfo = map.get(Integer.valueOf(evipspec.value()));
                if (vipOpenInfo != null) {
                    friends.superVipTemplateId = (int) vipOpenInfo.lNameplateId;
                }
                VipOpenInfo vipOpenInfo2 = friendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(evipspec2.value()));
                if (vipOpenInfo2 != null) {
                    friends.bigClubTemplateId = (int) vipOpenInfo2.lNameplateId;
                }
                VipBaseInfo vipBaseInfo6 = friendInfo.oVipInfo;
                friends.nameplateVipType = vipBaseInfo6.iNameplateVipType;
                friends.grayNameplateFlag = vipBaseInfo6.iGrayNameplateFlag;
                Dialogue P = ff.P(vipBaseInfo6);
                if (P != null) {
                    friends.bigClubExtTemplateId = P.nameplate_pendant_itemid.get();
                    friends.gameCardId = P.game_nameplate.get();
                    friends.vipStartFlag = P.vipstar_flag.get();
                    String vipIconsString = d.a().getVipIconsString(P.diy_nameplate_ids.get());
                    if (vipIconsString != null) {
                        friends.vipIcons = vipIconsString;
                    } else if (friend != null) {
                        friends.vipIcons = friend.vipIcons;
                    }
                    friends.vipDataFlag = P.qqvadata_changerand.get();
                    b.a().updateFlagData(friends.uin, friends.vipDataFlag);
                }
            }
            if (friend != null) {
                friends.showLoginClient = friend.showLoginClient;
                friends.lastLoginType = friend.lastLoginType;
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, extensionInfo, friendInfo, aVar);
            return;
        }
        extensionInfo.pendantId = friendInfo.ulFaceAddonId;
        extensionInfo.uVipFont = FontManagerConstants.parseFontId(friendInfo.uFounderFont);
        extensionInfo.vipFontType = FontManagerConstants.parseFontType(friendInfo.uFounderFont);
        extensionInfo.colorRingId = friendInfo.uColorRing;
        extensionInfo.magicFont = (friendInfo.cSpecialFlag >> 3) & 1;
        extensionInfo.faceId = (int) friendInfo.uFaceStoreId;
        extensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        extensionInfo.timestamp = System.currentTimeMillis();
        extensionInfo.latestPLUpdateTimestamp = friendInfo.uTagUpdateTime;
        extensionInfo.fontEffect = (int) friendInfo.uFontEffect;
        extensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        int i3;
        int i16;
        int i17;
        int i18;
        Map<Integer, VipOpenInfo> map;
        String str;
        int i19;
        int i26;
        int i27;
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) friends, (Object) friendInfo);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        boolean z16 = true;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.VASFriendProcessor", 1, "onUpdateFriendInfo| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Friends friend = ((IFriendDataService) appRuntime.getRuntimeService(IFriendDataService.class, "all")).getFriend(friends.uin);
        VipBaseInfo vipBaseInfo = friendInfo.oVipInfo;
        int value = EVIPSPEC.E_SP_QQVIP.value();
        if (friend != null) {
            i3 = friend.qqVipInfo;
        } else {
            i3 = 0;
        }
        friends.qqVipInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo, value, i3);
        VipBaseInfo vipBaseInfo2 = friendInfo.oVipInfo;
        int value2 = EVIPSPEC.E_SP_SUPERQQ.value();
        if (friend != null) {
            i16 = friend.superQqInfo;
        } else {
            i16 = 0;
        }
        friends.superQqInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo2, value2, i16);
        VipBaseInfo vipBaseInfo3 = friendInfo.oVipInfo;
        EVIPSPEC evipspec = EVIPSPEC.E_SP_SUPERVIP;
        int value3 = evipspec.value();
        if (friend != null) {
            i17 = friend.superVipInfo;
        } else {
            i17 = 0;
        }
        friends.superVipInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo3, value3, i17);
        VipBaseInfo vipBaseInfo4 = friendInfo.oVipInfo;
        EVIPSPEC evipspec2 = EVIPSPEC.E_SP_BIGCLUB;
        int value4 = evipspec2.value();
        if (friend != null) {
            i18 = friend.bigClubInfo;
        } else {
            i18 = 0;
        }
        friends.bigClubInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo4, value4, i18);
        friends.cNewLoverDiamondFlag = friendInfo.cNewLoverDiamondFlag;
        VipBaseInfo vipBaseInfo5 = friendInfo.oVipInfo;
        if (vipBaseInfo5 != null && (map = vipBaseInfo5.mOpenInfo) != null) {
            VipOpenInfo vipOpenInfo = map.get(Integer.valueOf(evipspec.value()));
            if (vipOpenInfo != null) {
                friends.superVipTemplateId = (int) vipOpenInfo.lNameplateId;
            }
            VipOpenInfo vipOpenInfo2 = friendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(evipspec2.value()));
            Dialogue P = ff.P(friendInfo.oVipInfo);
            if (P != null) {
                i26 = P.nameplate_pendant_itemid.get();
                i27 = P.game_nameplate.get();
                i28 = P.vipstar_flag.get();
                str = d.a().getVipIconsString(P.diy_nameplate_ids.get());
                i19 = P.qqvadata_changerand.get();
                MobileQQ.sMobileQQ.peekAppRuntime();
            } else {
                str = "";
                i19 = 0;
                i26 = 0;
                i27 = 0;
                i28 = 0;
            }
            if (vipOpenInfo2 != null) {
                friends.bigClubTemplateId = (int) vipOpenInfo2.lNameplateId;
                friends.bigClubExtTemplateId = i26;
                friends.gameCardId = i27;
                friends.vipStartFlag = i28;
                if (str != null) {
                    friends.vipIcons = str;
                }
                friends.vipDataFlag = i19;
                b.a().updateFlagData(friends.uin, i19);
            }
            if (friend != null) {
                VipBaseInfo vipBaseInfo6 = friendInfo.oVipInfo;
                friend.nameplateVipType = vipBaseInfo6.iNameplateVipType;
                friend.grayNameplateFlag = vipBaseInfo6.iGrayNameplateFlag;
                friend.bigClubExtTemplateId = i26;
                friend.gameCardId = i27;
                friend.vipStartFlag = i28;
                friend.vipDataFlag = i19;
                b.a().updateFlagData(friend.uin, i19);
                if (str != null) {
                    friend.vipIcons = str;
                }
            }
        }
        friends.namePlateOfKingGameId = friendInfo.uGameAppid;
        friends.namePlateOfKingLoginTime = friendInfo.uGameLastLoginTime;
        friends.namePlateOfKingDan = (int) friendInfo.ulKingOfGloryRank;
        if (friendInfo.cKingOfGloryFlag != 1) {
            z16 = false;
        }
        friends.namePlateOfKingDanDisplatSwitch = z16;
        if (!TextUtils.isEmpty(friends.uin) && qQAppInterface.getCurrentUin().equals(friends.uin)) {
            qQAppInterface.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit().putBoolean("plate_of_king_display_switch_" + qQAppInterface.getCurrentUin(), friends.namePlateOfKingDanDisplatSwitch).apply();
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateSelfInfo(Friends friends, FriendInfo friendInfo) {
        Map<Integer, VipOpenInfo> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) friends, (Object) friendInfo);
            return;
        }
        VasLogNtReporter.getVipIcon().reportDebug("on self friendlist change");
        friends.qqVipInfo = com.tencent.mobileqq.app.friendlist.a.m(friendInfo.oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), friends.qqVipInfo);
        friends.superQqInfo = com.tencent.mobileqq.app.friendlist.a.m(friendInfo.oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), friends.superQqInfo);
        VipBaseInfo vipBaseInfo = friendInfo.oVipInfo;
        EVIPSPEC evipspec = EVIPSPEC.E_SP_SUPERVIP;
        friends.superVipInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo, evipspec.value(), friends.superVipInfo);
        VipBaseInfo vipBaseInfo2 = friendInfo.oVipInfo;
        EVIPSPEC evipspec2 = EVIPSPEC.E_SP_BIGCLUB;
        friends.bigClubInfo = com.tencent.mobileqq.app.friendlist.a.m(vipBaseInfo2, evipspec2.value(), friends.bigClubInfo);
        friends.cNewLoverDiamondFlag = friendInfo.cNewLoverDiamondFlag;
        VipBaseInfo vipBaseInfo3 = friendInfo.oVipInfo;
        boolean z16 = true;
        if (vipBaseInfo3 != null && (map = vipBaseInfo3.mOpenInfo) != null) {
            VipOpenInfo vipOpenInfo = map.get(Integer.valueOf(evipspec.value()));
            if (vipOpenInfo != null) {
                friends.superVipTemplateId = (int) vipOpenInfo.lNameplateId;
            }
            VipOpenInfo vipOpenInfo2 = friendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(evipspec2.value()));
            if (vipOpenInfo2 != null) {
                friends.bigClubTemplateId = (int) vipOpenInfo2.lNameplateId;
            }
            VipBaseInfo vipBaseInfo4 = friendInfo.oVipInfo;
            friends.nameplateVipType = vipBaseInfo4.iNameplateVipType;
            friends.grayNameplateFlag = vipBaseInfo4.iGrayNameplateFlag;
            Dialogue P = ff.P(vipBaseInfo4);
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friends.uin), friends.uin);
            if (P != null) {
                friends.bigClubExtTemplateId = P.nameplate_pendant_itemid.get();
                friends.gameCardId = P.game_nameplate.get();
                friends.vipStartFlag = P.vipstar_flag.get();
                String vipIconsString = d.a().getVipIconsString(P.diy_nameplate_ids.get());
                if (vipIconsString != null) {
                    friends.vipIcons = vipIconsString;
                    nTVasSimpleInfo.vipIcons = vipIconsString;
                }
                friends.vipDataFlag = P.qqvadata_changerand.get();
                b.a().updateFlagData(friends.uin, friends.vipDataFlag);
                nTVasSimpleInfo.c();
                nTVasSimpleInfo.bigClubExtTemplateId = friends.bigClubExtTemplateId;
                nTVasSimpleInfo.diyFontId = friends.diyFontId;
                nTVasSimpleInfo.vipStartFlag = friends.vipStartFlag;
                nTVasSimpleInfo.vipDataFlag = friends.vipDataFlag;
                nTVasSimpleInfo.gameCardId = friends.gameCardId;
                nTVasSimpleInfo.nameplateVipType = friends.nameplateVipType;
                ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "IMCore.friend.VASFriendProcessor", new a());
                VipNtMMKV.getCommon(friends.uin).encodeInt("aioBadgeShowSwitch", P.aio_badge_show_switch.get());
            }
            if (QLog.isColorLevel()) {
                VasLogNtReporter.getVipIcon().reportDebug("on self friendlist change:nameplateVipType=" + friends.nameplateVipType + "superVipTemplateId=" + friends.superVipTemplateId + "bigClubTemplateId=" + friends.bigClubTemplateId + "qqVipInfo=" + friends.qqVipInfo + "superVipInfo=" + friends.superVipInfo + "bigClubInfo=" + friends.bigClubInfo);
            }
            QLog.i("IMCore.friend.VASFriendProcessor", 1, "onUpdateSelfInfo: nameplateVipType = " + friends.nameplateVipType);
        }
        friends.namePlateOfKingGameId = friendInfo.uGameAppid;
        friends.namePlateOfKingLoginTime = friendInfo.uGameLastLoginTime;
        friends.namePlateOfKingDan = (int) friendInfo.ulKingOfGloryRank;
        if (friendInfo.cKingOfGloryFlag != 1) {
            z16 = false;
        }
        friends.namePlateOfKingDanDisplatSwitch = z16;
        ((ao) this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f.i(friends.uin, (int) friendInfo.uFaceStoreId);
        ((IFontManagerService) this.mApp.getRuntimeService(IFontManagerService.class, "")).updateSelfFontEffectId(friends.uin, (int) friendInfo.uFontEffect);
        this.mApp.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit().putBoolean("plate_of_king_display_switch_" + this.mApp.getCurrentUin(), friends.namePlateOfKingDanDisplatSwitch).apply();
        if (QLog.isColorLevel()) {
            QLog.i("IMCore.friend.VASFriendProcessor.selfFontEffect", 2, "self fontEffect: " + ((int) friendInfo.uFontEffect));
        }
    }
}
