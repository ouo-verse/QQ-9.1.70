package com.tencent.mobileqq.profilecard.processor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.ay;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doc.g;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.nt.f;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.vas.qqmc.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.wholepeople.b;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.p;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.util.notification.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TempGetProfileDetailProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TempGetProfileDetailProcessor";
    private boolean careBarEnable;
    private short[] commonSwitchArray;
    private Map<Short, Short> commonSwitchMap;
    private boolean isActivateFriendSwitchOpen;
    private boolean isHelloLiveMessageEnable;
    private boolean pcActiveState;
    private ProfileHeaderInfo profileHeaderInfo;
    private BmqqAccountType qiDianExtAccountType;
    private BmqqAccountType qiDianMasterAccountType;
    private StudyModeManager.b studyModeFlag;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ProfileHeaderInfo {
        static IPatchRedirector $redirector_;
        short headSysId;
        short headType;
        short qq18Switch;

        ProfileHeaderInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.headSysId = (short) -1;
            this.headType = (short) -1;
            this.qq18Switch = (short) 0;
        }
    }

    public TempGetProfileDetailProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void handleGetDetailInfoInner3(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        int i3;
        boolean z16 = false;
        boolean z17 = true;
        if (s16 != -25217) {
            if (s16 != -25040) {
                if (s16 != -23723) {
                    if (s16 != -23549) {
                        if (s16 != -23538) {
                            if (s16 != -23502) {
                                if (s16 == -23488) {
                                    short s18 = byteBuffer.getShort();
                                    LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                                    if (localRedTouchManager != null) {
                                        localRedTouchManager.q(s18);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            short s19 = byteBuffer.getShort();
                            INearbySPUtil iNearbySPUtil = (INearbySPUtil) QRoute.api(INearbySPUtil.class);
                            String account = this.appRuntime.getAccount();
                            if (s19 == 1) {
                                z16 = true;
                            }
                            iNearbySPUtil.setValue(account, INearbySPUtil.SP_KEY_IS_NEARBY_NOVICE, Boolean.valueOf(z16));
                            return;
                        }
                        short s26 = byteBuffer.getShort();
                        INearbySPUtil iNearbySPUtil2 = (INearbySPUtil) QRoute.api(INearbySPUtil.class);
                        String account2 = this.appRuntime.getAccount();
                        if (s26 == 1) {
                            z16 = true;
                        }
                        iNearbySPUtil2.setValue(account2, INearbySPUtil.SP_KEY_IS_NEED_SHOW_GUID, Boolean.valueOf(z16));
                        return;
                    }
                    short s27 = byteBuffer.getShort();
                    int intValue = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), INearbySPUtil.SP_KEY_UPLOAD_AVATAR_OK, (Object) (-1))).intValue();
                    if (intValue != s27 && intValue != 1) {
                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.appRuntime.getAccount(), INearbySPUtil.SP_KEY_UPLOAD_AVATAR_OK, Integer.valueOf(s27));
                        return;
                    }
                    return;
                }
                byteBuffer.getShort();
                return;
            }
            short s28 = byteBuffer.getShort();
            int i16 = this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1);
            if (i16 != s28 && i16 != 1) {
                this.appRuntime.getPreferences().edit().putInt("nearby_people_profile_ok_new", s28).commit();
                return;
            }
            return;
        }
        if (byteBuffer.getShort() == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int readCallTabStateVal = ((QQAppInterface) this.appRuntime).readCallTabStateVal(4);
        int readCallTabStateVal2 = ((QQAppInterface) this.appRuntime).readCallTabStateVal(0);
        if (readCallTabStateVal2 == 0) {
            Integer[] numArr = new Integer[7];
            numArr[3] = Integer.valueOf(i3);
            ((QQAppInterface) this.appRuntime).writeCallTabStateVal(numArr);
        } else if (readCallTabStateVal2 == 1 && i3 != readCallTabStateVal) {
            CardHandler cardHandler = (CardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (readCallTabStateVal == 0) {
                z17 = false;
            }
            cardHandler.b5(z17, false);
        }
    }

    private void handleGetDetailInfoInner4(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        boolean z16;
        boolean z17 = false;
        if (s16 != -25188) {
            if (s16 != -25155) {
                if (s16 != -23753) {
                    if (s16 != -23461) {
                        if (s16 != -23282) {
                            if (s16 != 27034) {
                                if (s16 == 27055) {
                                    int i3 = byteBuffer.getInt();
                                    if (String.valueOf(j3).equals(this.appRuntime.getCurrentAccountUin())) {
                                        ((ISVIPHandler) ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfBubbleDiyTextId(i3, false);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            byte[] bArr = new byte[s17];
                            byteBuffer.get(bArr);
                            String str = new String(bArr);
                            if (!TextUtils.isEmpty(str) && String.valueOf(j3).equals(this.appRuntime.getCurrentAccountUin())) {
                                ((FriendsManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER)).q0(this.appRuntime.getCurrentAccountUin(), str, (byte) -1);
                                return;
                            }
                            return;
                        }
                        boolean z18 = card.strangerInviteMeGroupOpen;
                        if (byteBuffer.getShort() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        card.strangerInviteMeGroupOpen = z16;
                        if (z18 != z16) {
                            ((CardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(93, true, new Object[]{Boolean.valueOf(z16), Boolean.valueOf(z18)});
                            return;
                        }
                        return;
                    }
                    boolean checkMedalRedPointConfig = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig((QQAppInterface) this.appRuntime);
                    if (byteBuffer.getShort() != 0) {
                        z17 = true;
                    }
                    card.medalSwitchDisable = z17;
                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + j3, 4).edit();
                    edit.putBoolean("medal_switch_disable", card.medalSwitchDisable);
                    edit.commit();
                    boolean checkMedalRedPointConfig2 = ((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig((QQAppInterface) this.appRuntime);
                    if (checkMedalRedPointConfig != checkMedalRedPointConfig2) {
                        ((IUtil) QRoute.api(IUtil.class)).onMedalConfigChanged((QQAppInterface) this.appRuntime, checkMedalRedPointConfig2);
                        return;
                    }
                    return;
                }
                short s18 = byteBuffer.getShort();
                QQAppInterface qQAppInterface = (QQAppInterface) this.appRuntime;
                if (s18 > 0) {
                    z17 = true;
                }
                ay.b(qQAppInterface, z17);
                return;
            }
            boolean m3 = FriendIntimateRelationshipHelper.m(this.appRuntime.getCurrentUin());
            if (byteBuffer.getShort() == 1) {
                z17 = true;
            }
            if (m3 != z17) {
                FriendIntimateRelationshipHelper.s(this.appRuntime.getCurrentUin(), z17);
                return;
            }
            return;
        }
        if (byteBuffer.getShort() == 0) {
            z17 = true;
        }
        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setDisplayThirdQQChecked((QQAppInterface) this.appRuntime, z17);
    }

    private void handleGetDetailInfoInner6(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer, ProfileHeaderInfo profileHeaderInfo) {
        boolean z16;
        if (s16 != -24980) {
            boolean z17 = false;
            if (s16 != -23456) {
                if (s16 != -23437) {
                    if (s16 != -23322) {
                        if (s16 == 20015) {
                            profileHeaderInfo.headSysId = byteBuffer.getShort();
                            return;
                        }
                        return;
                    }
                    short s18 = byteBuffer.getShort();
                    card.extendFriendQuestion = s18;
                    IExpandQuestionUtils iExpandQuestionUtils = (IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class);
                    String currentAccountUin = this.appRuntime.getCurrentAccountUin();
                    if (s18 == 1) {
                        z17 = true;
                    }
                    iExpandQuestionUtils.setAnswerQuestionFlag(currentAccountUin, z17);
                    return;
                }
                profileHeaderInfo.qq18Switch = byteBuffer.getShort();
                return;
            }
            short s19 = byteBuffer.getShort();
            b bVar = new b((QQAppInterface) this.appRuntime);
            if (s19 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z18 = bVar.f315339f;
            if (z16 != z18) {
                bVar.a((QQAppInterface) this.appRuntime, z16);
                ((CardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(89, true, new Object[]{Boolean.valueOf(z16), Boolean.valueOf(z18)});
                return;
            }
            return;
        }
        profileHeaderInfo.headType = byteBuffer.getShort();
        if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != profileHeaderInfo.headType) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.appRuntime.getAccount(), INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, Integer.valueOf(profileHeaderInfo.headType));
        }
    }

    private void handleGetDetailInfoInner7(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        boolean z19 = true;
        if (s16 != -23370) {
            if (s16 != -23332) {
                if (s16 != -23312) {
                    if (s16 != -23249) {
                        if (s16 != -23168 && s16 != -23166) {
                            if (s16 != -23161) {
                                if (s16 != -23158) {
                                    if (s16 != -20457) {
                                        if (s16 != -20455) {
                                            if (s16 != -23326) {
                                                if (s16 == -23325) {
                                                    BaseApplication.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("contacts_invite_friend_entry", byteBuffer.getShort()).apply();
                                                    return;
                                                } else {
                                                    switch (s16) {
                                                        case -23310:
                                                        case -23309:
                                                        case -23308:
                                                            break;
                                                        default:
                                                            switch (s16) {
                                                                case -20461:
                                                                case -20460:
                                                                case -20459:
                                                                    break;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                                }
                                            } else {
                                                BaseApplication.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("invitation_friend_entry", byteBuffer.getShort()).apply();
                                                return;
                                            }
                                        }
                                        if (byteBuffer.getShort() == 1) {
                                            z18 = true;
                                        }
                                        ((TempMsgManager) this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).m(s16, z18);
                                        new e().b((AppInterface) this.appRuntime);
                                        ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary((AppInterface) this.appRuntime, true);
                                        return;
                                    }
                                    if (byteBuffer.getShort() == 1) {
                                        z19 = false;
                                    }
                                    ((TempMsgManager) this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).n(s16, z19, false);
                                    return;
                                }
                            } else {
                                if (byteBuffer.getShort() != 2) {
                                    z19 = false;
                                }
                                ((TempMsgManager) this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).n(s16, z19, false);
                                return;
                            }
                        }
                    } else {
                        short s18 = byteBuffer.getShort();
                        if (s18 == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).initAutoToTextSwitch((QQAppInterface) this.appRuntime);
                        long serverTime = NetConnInfoCenter.getServerTime();
                        String str = "businessinfo_ptt_auto_change_text_" + this.appRuntime.getCurrentAccountUin();
                        String str2 = "businessinfo_ptt_auto_change_time_" + this.appRuntime.getCurrentAccountUin();
                        String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + this.appRuntime.getCurrentAccountUin();
                        SharedPreferences.Editor edit = this.appRuntime.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).edit();
                        boolean z26 = m.f179515e;
                        long j16 = m.f179516f;
                        if (z17) {
                            if (!z26) {
                                edit.putLong(str2, serverTime);
                                m.f179516f = serverTime;
                            }
                            edit.putBoolean(str3, true);
                            m.f179517g = true;
                        } else {
                            edit.putLong(str2, Long.MAX_VALUE);
                        }
                        edit.putBoolean(str, z17);
                        edit.apply();
                        m.f179515e = z17;
                        QLog.e("vip_ptt.TempGetProfileDetailProcessor", 2, "handleGetDetailInfo autoToText onLine:" + z17 + " buffer:" + ((int) s18) + ", oldSwitch: " + z26 + ", time:" + serverTime + ", oldTime:" + j16 + " conf.stage:" + QVipAutoPttConfig.INSTANCE.getStage());
                        return;
                    }
                }
                if (byteBuffer.getShort() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ((TempMsgManager) this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).n(s16, !z16, false);
                return;
            }
            if (byteBuffer.getShort() == 0) {
                z18 = true;
            }
            SettingCloneUtil.writeValue(this.appRuntime.getApp(), this.appRuntime.getCurrentUin(), (String) null, AppConstants.QQSETTING_SHOW_PUSH_MESSAGE, z18);
            return;
        }
        short s19 = byteBuffer.getShort();
        BaseApplication app = this.appRuntime.getApp();
        String valueOf = String.valueOf(j3);
        if (s19 != 0) {
            z18 = true;
        }
        g.f(app, valueOf, z18);
    }

    private void handleGetDetailInfoInner8(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer, StudyModeManager.b bVar) {
        boolean z16;
        boolean z17 = false;
        if (s16 != -23251) {
            if (s16 != -23221) {
                if (s16 != -23174) {
                    if (s16 != -23172) {
                        if (s16 != -23143) {
                            if (s16 != -23046) {
                                if (s16 != -18314) {
                                    if (s16 != 27390) {
                                        switch (s16) {
                                            case -23108:
                                                if (byteBuffer.getShort() == 0) {
                                                    z17 = true;
                                                }
                                                StudyModeManager.W(16, z17);
                                                return;
                                            case -23107:
                                                if (byteBuffer.getShort() == 0) {
                                                    z17 = true;
                                                }
                                                StudyModeManager.W(32, z17);
                                                return;
                                            case -23106:
                                                if (byteBuffer.getShort() == 0) {
                                                    z17 = true;
                                                }
                                                StudyModeManager.W(8, z17);
                                                return;
                                            default:
                                                switch (s16) {
                                                    case -23104:
                                                        short s18 = byteBuffer.getShort();
                                                        bVar.f290971a = true;
                                                        if (s18 == 1) {
                                                            z17 = true;
                                                        }
                                                        bVar.f290972b = z17;
                                                        return;
                                                    case -23103:
                                                        ((z51.a) this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).d(byteBuffer.getShort());
                                                        return;
                                                    case -23102:
                                                        ((z51.a) this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(byteBuffer.getShort());
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                    }
                                    ((z51.a) this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(byteBuffer.getShort());
                                    return;
                                }
                                if (byteBuffer.getShort() != 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                StudyModeManager.W(80, z16);
                                if (byteBuffer.getShort() != 0) {
                                    z17 = true;
                                }
                                StudyModeManager.W(96, z17);
                                return;
                            }
                            StudyModeManager.L(byteBuffer.getShort());
                            return;
                        }
                        ((com.tencent.mobileqq.graytip.a) this.appRuntime.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).f(byteBuffer.getShort());
                        return;
                    }
                    if (byteBuffer.getShort() == 1) {
                        z17 = true;
                    }
                    StudyModeManager.P(z17);
                    ((l) this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).s(z17);
                    return;
                }
                short s19 = byteBuffer.getShort();
                bVar.f290971a = true;
                if (s19 == 1) {
                    z17 = true;
                }
                bVar.f290973c = z17;
                return;
            }
            if (byteBuffer.getShort() == 0) {
                z17 = true;
            }
            ((IStickerRecManager) this.appRuntime.getRuntimeService(IStickerRecManager.class, "")).updateEmotionRecSetting(z17);
            ((CardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(102, true, Boolean.valueOf(z17));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleGetDetailInfo emotionRec onLine:" + z17);
                return;
            }
            return;
        }
        short s26 = byteBuffer.getShort();
        bVar.f290971a = true;
        if (s26 == 1) {
            z17 = true;
        }
        bVar.f290974d = z17;
    }

    public void getActivateFriendSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getActivateFriendSwitch");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((short) -25031);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isGetActivateFriend", true);
        getDetailCardInfo(arrayList, bundle);
    }

    public void getBabyQSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBabyQSwitch");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_BABY_Q_SWITCH));
        Bundle bundle = new Bundle();
        bundle.putBoolean("isGetBabyQSwitch", true);
        getDetailCardInfo(arrayList, bundle);
    }

    public void getCalReactiveSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCalReactiveSwitch");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_CAL_REACTIVE_DAY_SWITCH));
        Bundle bundle = new Bundle();
        bundle.putBoolean("isGetCalReactive", true);
        getDetailCardInfo(arrayList, bundle);
    }

    public void getCommonSwitch(short[] sArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) sArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getCommonSwitch switchArray=%s", Arrays.toString(sArr)));
        }
        if (sArr != null && sArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (short s16 : sArr) {
                arrayList.add(Short.valueOf(s16));
            }
            Bundle bundle = new Bundle();
            bundle.putShortArray("switch_id_array", sArr);
            bundle.putBoolean("isGetCommonSwitchFromDetailInfo", true);
            getDetailCardInfo(arrayList, bundle);
        }
    }

    public void getDetailCardInfo(List<Short> list, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            getDetailCardInfo(list, bundle, this.appRuntime.getCurrentAccountUin());
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) bundle);
        }
    }

    public void getLoginDaysSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            getLoginDaysSwitch(this.appRuntime.getCurrentUin());
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void getPCActiveState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "getPCActiveState");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_PC_PUSH_PHONEQQ));
        Bundle bundle = new Bundle();
        bundle.putBoolean("pcActiveState", true);
        getDetailCardInfo(arrayList, bundle);
    }

    public void getQidianExt(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getQidianExt uin=%s isQidianSimple", str, Boolean.valueOf(z16)));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((short) -25126);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isQidianExt", true);
        bundle.putBoolean("isQidianSimple", z16);
        getDetailCardInfo(arrayList, bundle, str);
    }

    public void getQidianMaster(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "isQidianMaster");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((short) -25176);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isQidianMaster", true);
        getDetailCardInfo(arrayList, bundle, str, 160);
    }

    public void handleGetActivateFriendSwitch(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        } else if (s16 == -25031) {
            if (byteBuffer.getShort() != 0) {
                z16 = false;
            }
            this.isActivateFriendSwitchOpen = z16;
            ((ActivateFriendsManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).L(this.isActivateFriendSwitchOpen, false);
        }
    }

    public void handleGetBabyQSwitch(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        } else if (s16 == -25008) {
            if (byteBuffer.getShort() != 0) {
                z16 = false;
            }
            card.babyQSwitch = z16;
        }
    }

    public void handleGetCalReactiveSwitch(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        } else if (s16 == -25007) {
            if (byteBuffer.getShort() == 0) {
                z16 = false;
            }
            card.allowCalInteractive = z16;
        }
    }

    public void handleGetCareBarEnable(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -23234) {
            if (byteBuffer.getShort() != 0) {
                z16 = false;
            }
            this.careBarEnable = z16;
            boolean isContainValue = SettingCloneUtil.isContainValue(BaseApplication.context, this.appRuntime.getCurrentAccountUin(), null, AppConstants.QQSETTING_SPECIAL_CARE_BAR);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleGetCareBarEnable: invoked.  careBarPerfExist: " + isContainValue);
            }
            SettingCloneUtil.writeValue(this.appRuntime.getApplication(), String.valueOf(j3), (String) null, AppConstants.QQSETTING_SPECIAL_CARE_BAR, this.careBarEnable);
            d.s(this.careBarEnable);
        }
    }

    public void handleGetCommonSwitch(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (this.commonSwitchArray != null) {
            boolean z16 = false;
            while (true) {
                short[] sArr = this.commonSwitchArray;
                if (i3 >= sArr.length) {
                    break;
                }
                if (s16 == sArr[i3]) {
                    z16 = true;
                }
                i3++;
            }
            if (z16) {
                short s18 = byteBuffer.getShort();
                if (this.commonSwitchMap == null) {
                    this.commonSwitchMap = new HashMap();
                }
                this.commonSwitchMap.put(Short.valueOf(s16), Short.valueOf(s18));
            }
        }
    }

    public void handleGetHelloLiveMessageState(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -25181) {
            if (byteBuffer.getShort() != 0) {
                z16 = false;
            }
            this.isHelloLiveMessageEnable = z16;
            String valueOf = String.valueOf(j3);
            if (SettingCloneUtil.readValue((Context) this.appRuntime.getApplication(), valueOf, (String) null, AppConstants.QQSETTING_HELLO_LIVE_MESSAGE, false) != this.isHelloLiveMessageEnable) {
                SettingCloneUtil.writeValue(this.appRuntime.getApplication(), valueOf, (String) null, AppConstants.QQSETTING_HELLO_LIVE_MESSAGE, this.isHelloLiveMessageEnable);
                Intent intent = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
                intent.putExtra("isHelloLiveMessageEnable", this.isHelloLiveMessageEnable);
                intent.putExtra("uin", valueOf);
                this.appRuntime.getApp().sendBroadcast(intent);
            }
        }
    }

    public void handleGetIsQiDianExt(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -25126) {
            if (byteBuffer.getShort() != 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.qiDianExtAccountType = new BmqqAccountType(String.valueOf(j3), i3);
            QidianManager qidianManager = (QidianManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.QIDIAN_MANAGER);
            qidianManager.j0(this.qiDianExtAccountType);
            boolean z16 = bundle.getBoolean("isQidianSimple", false);
            if (i3 == 1 && z16) {
                qidianManager.x(this.appRuntime.getApp().getBaseContext(), this.qiDianExtAccountType);
            } else {
                qidianManager.z(this.appRuntime.getApp().getBaseContext(), this.qiDianExtAccountType);
            }
        }
    }

    public void handleGetIsQiDianMaster(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 6;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -25176) {
            short s18 = byteBuffer.getShort();
            if (s18 == 0) {
                i3 = 4;
            }
            this.qiDianMasterAccountType = new BmqqAccountType(String.valueOf(j3), i3);
            QidianManager qidianManager = (QidianManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.QIDIAN_MANAGER);
            qidianManager.j0(this.qiDianMasterAccountType);
            if (s18 != 0) {
                QLog.i(LogTag.PROFILE_CARD, 1, MsfSdkUtils.getShortUin(String.valueOf(j3)) + " handleGetIsQidianMaster is qidianmaster");
                QidianExternalInfo q16 = qidianManager.q(String.valueOf(j3));
                QidianProfileUiInfo u16 = qidianManager.u(String.valueOf(j3));
                if (q16 == null || u16 == null) {
                    qidianManager.z(this.appRuntime.getApp().getBaseContext(), this.qiDianMasterAccountType);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "handleGetIsQidianMaster sFieldValue: " + ((int) s18));
            }
        }
    }

    public void handleGetLoginDaysSwitch(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -25044) {
            short s18 = byteBuffer.getShort();
            String string = bundle.getString("switchUin");
            if (TextUtils.equals(string, String.valueOf(j3))) {
                if (s18 != 0) {
                    z16 = true;
                }
                card.allowPeopleSee = z16;
            } else {
                IProfileDataService iProfileDataService = (IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
                Card profileCard = iProfileDataService.getProfileCard(string, true);
                if (s18 != 0) {
                    z16 = true;
                }
                profileCard.allowPeopleSee = z16;
                iProfileDataService.saveProfileCard(profileCard);
            }
        }
    }

    public void handleGetOfficeUserFlag(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        } else if (s16 == -23449) {
            ((AppGuideTipsManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).k(byteBuffer.getShort());
        }
    }

    public void handleGetPCActiveState(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        if (s16 == -25042) {
            if (byteBuffer.getShort() == 0) {
                z16 = false;
            }
            this.pcActiveState = z16;
            String valueOf = String.valueOf(j3);
            if (SettingCloneUtil.readValue((Context) this.appRuntime.getApplication(), valueOf, (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false) != this.pcActiveState) {
                SettingCloneUtil.writeValue(this.appRuntime.getApplication(), valueOf, (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, this.pcActiveState);
                Intent intent = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                intent.putExtra("pcActive", this.pcActiveState);
                intent.putExtra("uin", valueOf);
                this.appRuntime.getApp().sendBroadcast(intent);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailRequestForLogin(List<Short> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            return;
        }
        list.add((short) -23308);
        list.add((short) -23309);
        list.add((short) -23310);
        list.add((short) -23166);
        list.add((short) -23312);
        list.add((short) -23168);
        list.add((short) -23158);
        list.add((short) -23161);
        list.add((short) -20461);
        list.add((short) -20460);
        list.add((short) -20459);
        list.add((short) -20457);
        list.add((short) -20455);
        if (this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
            list.add((short) -25040);
        }
        if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), INearbySPUtil.SP_KEY_UPLOAD_AVATAR_OK, (Object) (-1))).intValue() != 1) {
            list.add((short) -23549);
        }
        com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if (bVar != null && bVar.h()) {
            list.add((short) -23437);
            list.add((short) 20015);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseBegin(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        this.profileHeaderInfo = null;
        this.studyModeFlag = null;
        this.qiDianMasterAccountType = null;
        this.qiDianExtAccountType = null;
        this.pcActiveState = false;
        this.isHelloLiveMessageEnable = false;
        this.isActivateFriendSwitchOpen = false;
        this.commonSwitchArray = null;
        this.commonSwitchMap = null;
        this.careBarEnable = false;
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseEnd(Bundle bundle, boolean z16, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, bundle, Boolean.valueOf(z16), card);
            return;
        }
        try {
            CardHandler cardHandler = (CardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (bundle.getBoolean("isQidianMaster")) {
                cardHandler.notifyUI(87, false, this.qiDianMasterAccountType);
            }
            if (bundle.getBoolean("isQidianExt")) {
                cardHandler.notifyUI(68, z16, this.qiDianExtAccountType);
            }
            if (bundle.getBoolean("isGetLoginDays")) {
                cardHandler.notifyUI(44, z16, new Object[]{Boolean.valueOf(card.allowPeopleSee), card.uin});
            }
            if (bundle.getBoolean("pcActiveState")) {
                cardHandler.notifyUI(54, z16, Boolean.valueOf(this.pcActiveState));
            }
            if (bundle.getBoolean("helloLiveMessage")) {
                cardHandler.notifyUI(86, z16, Boolean.valueOf(this.isHelloLiveMessageEnable));
            }
            if (bundle.getBoolean("isGetActivateFriend")) {
                cardHandler.notifyUI(58, z16, Boolean.valueOf(this.isActivateFriendSwitchOpen));
            }
            if (bundle.getBoolean("isGetCalReactive")) {
                FriendsManager friendsManager = (FriendsManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (card.allowCalInteractive) {
                    friendsManager.Y = 1;
                } else {
                    friendsManager.Y = 0;
                }
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).writeDisableInteractiveSwitchLocal(card.allowCalInteractive);
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(p.f353239a);
                com.tencent.qqnt.lightbusinesskit.a.f();
                this.appRuntime.getApp().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("hotDisableInteractive", friendsManager.Y).commit();
                cardHandler.notifyUI(70, z16, Boolean.valueOf(card.allowCalInteractive));
                f.f252196a.t();
            }
            if (bundle.getBoolean("isGetBabyQSwitch")) {
                cardHandler.notifyUI(73, z16, Boolean.valueOf(card.babyQSwitch));
            }
            if (bundle.getBoolean("isGetCommonSwitchFromDetailInfo")) {
                cardHandler.notifyUI(83, z16, new Object[]{this.commonSwitchArray, this.commonSwitchMap});
            }
            if (bundle.getBoolean("isCareBarEnable")) {
                cardHandler.notifyUI(101, z16, Boolean.valueOf(this.careBarEnable));
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "onGetProfileDetailResponseEnd failed" + e16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLV(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
            return;
        }
        handleGetDetailInfoInner3(bundle, j3, card, s16, s17, byteBuffer);
        handleGetDetailInfoInner4(bundle, j3, card, s16, s17, byteBuffer);
        handleGetDetailInfoInner6(bundle, j3, card, s16, s17, byteBuffer, this.profileHeaderInfo);
        handleGetDetailInfoInner7(bundle, j3, card, s16, s17, byteBuffer);
        handleGetDetailInfoInner8(bundle, j3, card, s16, s17, byteBuffer, this.studyModeFlag);
        handleGetIsQiDianMaster(bundle, j3, card, s16, s17, byteBuffer);
        handleGetIsQiDianExt(bundle, j3, card, s16, s17, byteBuffer);
        handleGetLoginDaysSwitch(bundle, j3, card, s16, s17, byteBuffer);
        handleGetPCActiveState(bundle, j3, card, s16, s17, byteBuffer);
        handleGetHelloLiveMessageState(bundle, j3, card, s16, s17, byteBuffer);
        handleGetActivateFriendSwitch(bundle, j3, card, s16, s17, byteBuffer);
        handleGetCalReactiveSwitch(bundle, j3, card, s16, s17, byteBuffer);
        handleGetBabyQSwitch(bundle, j3, card, s16, s17, byteBuffer);
        handleGetCommonSwitch(bundle, j3, card, s16, s17, byteBuffer);
        handleGetOfficeUserFlag(bundle, j3, card, s16, s17, byteBuffer);
        handleGetCareBarEnable(bundle, j3, card, s16, s17, byteBuffer);
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVBegin(Bundle bundle, long j3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, bundle, Long.valueOf(j3), card);
            return;
        }
        this.profileHeaderInfo = new ProfileHeaderInfo();
        this.studyModeFlag = new StudyModeManager.b();
        this.isActivateFriendSwitchOpen = ((ActivateFriendsManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).t(false);
        this.commonSwitchArray = bundle.getShortArray("switch_id_array");
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVEnd(Bundle bundle, long j3, Card card) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, bundle, Long.valueOf(j3), card);
            return;
        }
        com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) this.appRuntime.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if (bVar != null && bVar.h()) {
            ProfileHeaderInfo profileHeaderInfo = this.profileHeaderInfo;
            bVar.e(profileHeaderInfo.headSysId, profileHeaderInfo.headType, profileHeaderInfo.qq18Switch);
        }
        StudyModeManager.b bVar2 = this.studyModeFlag;
        if (bVar2.f290971a) {
            boolean z17 = bVar2.f290973c;
            if (!z17 && !bVar2.f290972b) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.d(TAG, 1, "[KidMode]studyModeFlag:", Boolean.valueOf(z17), " kidModeFlag:", Boolean.valueOf(this.studyModeFlag.f290972b), " simpleUi:", Boolean.valueOf(this.studyModeFlag.f290974d));
            StudyModeManager.R(z16, (QQAppInterface) this.appRuntime);
            ((l) this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).t(z16);
            StudyModeManager.d((QQAppInterface) this.appRuntime, z16, this.studyModeFlag.f290974d);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void requestParseProfileLocation(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) card);
        } else {
            ((ConditionSearchManager) ((QQAppInterface) this.appRuntime).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).P(card);
        }
    }

    private void getDetailCardInfo(List<Short> list, Bundle bundle, String str) {
        getDetailCardInfo(list, bundle, str, 9);
    }

    public void getLoginDaysSwitch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getLoginDaysSwitch uin=%s", str));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_LOGIN_DAY_SWITCH));
        Bundle bundle = new Bundle();
        bundle.putString("switchUin", str);
        bundle.putBoolean("isGetLoginDays", true);
        getDetailCardInfo(arrayList, bundle, str);
    }

    private void getDetailCardInfo(List<Short> list, Bundle bundle, String str, int i3) {
        QLog.d(TAG, 2, String.format("getDetailCardInfo targetUin=%s reqFields=%s serviceType=%s params=%s stack=%s", str, Arrays.toString(list.toArray()), Integer.valueOf(i3), bundle, QLog.getStackTraceString(new Throwable())));
        ProfileServiceUtils.getIProfileProtocolService(this.appRuntime).getProfileDetail(str, list, i3, bundle);
    }
}
