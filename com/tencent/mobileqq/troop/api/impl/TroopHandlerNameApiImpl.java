package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.association.handler.TroopAssociationHandler;
import com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler;
import com.tencent.mobileqq.troop.clockin.handler.TroopClockInHandler;
import com.tencent.mobileqq.troop.essence.handler.TroopEssenceMsgHandler;
import com.tencent.mobileqq.troop.fans.handler.TroopFansHandler;
import com.tencent.mobileqq.troop.handler.TroopAddFriendHandler;
import com.tencent.mobileqq.troop.handler.TroopAvatarHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberCardHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberMngHandler;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.handler.TroopNotificationHandler;
import com.tencent.mobileqq.troop.handler.TroopPushHandler;
import com.tencent.mobileqq.troop.handler.TroopTokenHandler;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.impl.TroopLuckyCharacterHandler;
import com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler;
import com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler;
import com.tencent.mobileqq.troop.recommend.TroopSearchRecommendHandler;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler;
import com.tencent.mobileqq.troop.robot.api.impl.TroopRobotHandler;
import com.tencent.mobileqq.troop.troopanonymous.TroopAnonymousHandler;
import com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppHandler;
import com.tencent.mobileqq.troop.troopbindguild.handler.TroopBindGuildHandler;
import com.tencent.mobileqq.troop.troopconfig.api.impl.TroopConfigHandler;
import com.tencent.mobileqq.troop.troopfee.handler.TroopFeeHandler;
import com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmessage.handler.TroopMessageHandler;
import com.tencent.mobileqq.troop.troopnotification.handler.TroopAioNotifyHandler;
import com.tencent.mobileqq.troop.troopphoto.api.impl.TroopPhotoHandler;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.mobileqq.troop.troopsetting.api.impl.TroopSettingHandler;
import com.tencent.mobileqq.troop.troopsurvey.handler.TroopSurveyHandler;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHandlerNameApiImpl implements ITroopHandlerNameApi {
    static IPatchRedirector $redirector_;

    public TroopHandlerNameApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAddFriendHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return TroopAddFriendHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAioNotifyHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return TroopAioNotifyHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAnnouncementHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return TroopAnnouncementHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAnonymousHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return TroopAnonymousHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAppHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return TroopAppHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAssociationHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return TroopAssociationHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopAvatarHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return TroopAvatarHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopBindGuildHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return TroopBindGuildHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopClockInHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return TroopClockInHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopConfigHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return TroopConfigHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopEssenceHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TroopEssenceMsgHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopFansHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return TroopFansHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopFeeHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return TroopFeeHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopGagHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return TroopGagHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopGameHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return TroopGameHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopHomeworkHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return HomeworkHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopHonorHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return TroopHonorHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopInfoHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TroopInfoHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopListHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TroopListHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopLuckyCharacterHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return TroopLuckyCharacterHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopManagerBizHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return TroopManagerBizHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMemberCardHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return TroopMemberCardHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMemberInfoHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return TroopMemberInfoHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMemberListHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return TroopMemberListHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMemberMngHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return TroopMemberMngHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMessageHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return TroopMessageHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopMngHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TroopMngHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopModifyHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TroopModifyHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopNavigateMessageHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return TroopAioMessageNavigateBusinessHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopNotificationHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return TroopNotificationHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopOnlineMemberHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return TroopOnlineMemberHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopOnlinePushHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return TroopOnlinePushHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopPhotoHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return TroopPhotoHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopPushHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return TroopPushHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopRedDotHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return TroopRedDotHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopRoamSettingHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return RoamSettingHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopRobotHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return TroopRobotHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopSearchRecommendHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return TroopSearchRecommendHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopSettingHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return TroopSettingHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopSurveyHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return TroopSurveyHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopTokenHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return TroopTokenHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
    public String getTroopTrpcHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return TroopTrpcHandler.class.getName();
    }
}
