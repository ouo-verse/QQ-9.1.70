package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* renamed from: com.tencent.mobileqq.app.do, reason: invalid class name */
/* loaded from: classes11.dex */
public class Cdo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final MessageRecord f195497a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f195498b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f195499c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f195500d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f195501e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f195502f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f195503g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f195504h;

    /* renamed from: i, reason: collision with root package name */
    QQAppInterface f195505i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f195506j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f195507k;

    public Cdo(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        this.f195505i = qQAppInterface;
        this.f195497a = messageRecord;
        boolean isRingerSilent = qQAppInterface.isRingerSilent();
        this.f195498b = isRingerSilent;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("msg_notification_mute_when_no_disturb_on_8985_115300367", true)) {
            this.f195499c = !com.tencent.mobileqq.util.az.b(qQAppInterface.getApp().getApplicationContext());
        } else {
            this.f195499c = com.tencent.mobileqq.util.az.a(qQAppInterface.getApp().getApplicationContext(), qQAppInterface);
        }
        boolean g16 = g(messageRecord);
        this.f195500d = g16;
        boolean c16 = com.tencent.mobileqq.util.az.c(qQAppInterface.getApp().getApplicationContext(), qQAppInterface);
        this.f195501e = c16;
        boolean isCallIdle = qQAppInterface.isCallIdle();
        this.f195502f = isCallIdle;
        boolean recordingPttStopped = qQAppInterface.recordingPttStopped();
        this.f195503g = recordingPttStopped;
        this.f195506j = qQAppInterface.canPlaySound();
        this.f195507k = qQAppInterface.canVibrator();
        this.f195504h = qQAppInterface.isVideoChatting();
        QLog.d("VibrateSoundHelper", 1, "isRingerSilent is:" + isRingerSilent + " canDisturb is:" + this.f195499c + " isMute:", c16 + " newMsgNotificationEnabled: ", g16 + " isCallIdle: ", isCallIdle + " notRecordingPtt: ", recordingPttStopped + " canPlaySoundInGeneralSetting: ", this.f195506j + " canVibratorInGeneralSetting: ", Boolean.valueOf(this.f195507k));
    }

    private String d(MessageRecord messageRecord) {
        int i3 = messageRecord.istroop;
        if (i3 != 1000 && i3 != 1004) {
            if (com.tencent.imcore.message.ao.c(i3) == 1032) {
                return AppConstants.CONFESS_UIN;
            }
            return messageRecord.senderuin;
        }
        return messageRecord.frienduin;
    }

    public static boolean i(int i3, Message message, boolean z16) {
        boolean z17;
        String str;
        boolean z18 = true;
        if (i3 == 0 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i16 = message.istroop;
        if ((i16 == 1001 || i16 == 10002) && message.msgtype == -3001) {
            z17 = true;
        }
        if (i16 == 1008 && ((((str = message.extStr) != null && (message.extLong & 1) == 0 && str.contains("lockDisplay")) || (message.extStr != null && (message.extLong & 1) == 1 && message.getExtInfoFromExtStr("lockDisplay").equals("true"))) && z16)) {
            z17 = true;
        }
        if (message.istroop == 1008 && AppConstants.REMINDER_UIN.equals(message.senderuin)) {
            z17 = true;
        }
        int i17 = message.istroop;
        if (i17 != 9002) {
            z18 = z17;
        }
        if (i17 == 1044 && SdkInfoUtil.isOreo()) {
            z18 = false;
        }
        if (message.istroop == 1045 && SdkInfoUtil.isOreo()) {
            return false;
        }
        return z18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(MessageRecord messageRecord, boolean z16, boolean z17, boolean z18, com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar;
        if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
            aVar = (com.tencent.qqnt.ntrelation.otherinfo.bean.a) eVar.b().get(0);
        } else {
            aVar = null;
        }
        m(messageRecord, z16, z17, aVar);
        l(messageRecord, z18, aVar);
    }

    private void k(int i3) {
        int size = this.f195505i.vibrateListenerList.size();
        for (int i16 = 0; i16 < size; i16++) {
            this.f195505i.vibrateListenerList.get(i16).a(i3);
        }
    }

    private void o(MessageRecord messageRecord, boolean z16, boolean z17, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        boolean z18;
        boolean z19;
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f195505i);
        if (messageRecord != null && l3 != null) {
            z18 = l3.j(messageRecord.frienduin, messageRecord.istroop, aVar);
            z19 = l3.z(messageRecord.senderuin);
            if (QLog.isColorLevel()) {
                QLog.d(QQAppInterface.TAG, 2, "vibratorAndAudio: invoked. ", " message: ", messageRecord, " message.senderuin: ", messageRecord.senderuin, " message.frienduin: ", messageRecord.frienduin, " message.istroop: ", Integer.valueOf(messageRecord.istroop));
            }
        } else {
            z18 = false;
            z19 = false;
        }
        QLog.d("Notification.Sound", 1, "vibratorAndAudio: invoked. ", " enableSeparateSoundWhenGlobalOff: ", Boolean.valueOf(z18), " spCareFriendRingEnable: ", Boolean.valueOf(z19), " canPlaySpecialFriendSound: ", Boolean.valueOf(z16));
        this.f195505i.unitTestLog("vibratorAndAudio_play_sound_for_sp_message", Boolean.valueOf(z17));
        if (((z16 && z18 && z19) || TroopKeywordManager.i(messageRecord)) && l3 != null) {
            l3.M(messageRecord);
        }
    }

    private void p(MessageRecord messageRecord) {
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f195505i);
        int i3 = 0;
        this.f195505i.unitTestLog("vibratorAndAudio_check_sound_for_message_enableSeparateSound", new Object[0]);
        int readValueForInt = SettingCloneUtil.readValueForInt(BaseApplication.context, this.f195505i.getCurrentAccountUin(), AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.H0);
        if (QLog.isColorLevel()) {
            AudioManager audioManager = (AudioManager) this.f195505i.getApp().getSystemService("audio");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("StreamVolume=");
            if (audioManager != null) {
                i3 = SystemMethodProxy.getStreamVolume(audioManager, 2);
            }
            sb5.append(i3);
            sb5.append(",SoundRid=");
            sb5.append(readValueForInt);
            QLog.d("VibrateSoundHelper", 2, sb5.toString());
        }
        if (l3 != null) {
            if (MessageNotificationSettingManager.J(messageRecord)) {
                l3.M(messageRecord);
            } else {
                l3.L();
            }
        }
    }

    boolean b(int i3) {
        boolean z16;
        if (i3 == 0) {
            if (this.f195505i.getALLGeneralSettingRing() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f195505i.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", Boolean.valueOf(z16));
        } else {
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f195505i.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", Boolean.valueOf(z16));
        }
        return z16;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!this.f195498b && this.f195499c && !this.f195501e) {
            return true;
        }
        return false;
    }

    public boolean e(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord == null || messageRecord.istroop != 1001 || com.tencent.mobileqq.dating.i.j(messageRecord) || this.f195505i.isBackgroundPause) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SpecialCare", 2, "message.istroop = " + messageRecord.istroop + " MsgBoxUtil.shouldInMsgBox(message) = " + com.tencent.mobileqq.dating.i.j(messageRecord));
        }
        this.f195505i.unitTestLog("vibratorAndAudio_UIN_TYPE_LBS_FRIEND", new Object[0]);
        return true;
    }

    public boolean f(MessageRecord messageRecord) {
        GameSwitchConfig findGameSwitchConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord != null && messageRecord.istroop == 10007) {
            this.f195505i.unitTestLog("vibratorAndAudio_UIN_TYPE_GAME_MSG", new Object[0]);
            IGameMsgBoxRuntimeService iGameMsgBoxRuntimeService = (IGameMsgBoxRuntimeService) this.f195505i.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
            if (iGameMsgBoxRuntimeService != null) {
                String gameAppIdFromMessage = iGameMsgBoxRuntimeService.getGameAppIdFromMessage(messageRecord);
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f195505i.getRuntimeService(IGameMsgManagerService.class, "");
                if (iGameMsgManagerService != null && (findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(gameAppIdFromMessage)) != null && findGameSwitchConfig.mMuteSwitch == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean g(MessageRecord messageRecord) {
        com.tencent.mobileqq.message.newmsg.a aVar = (com.tencent.mobileqq.message.newmsg.a) this.f195505i.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
        if (aVar != null) {
            return aVar.m(messageRecord);
        }
        return true;
    }

    public boolean h(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord != null && messageRecord.istroop == 1008 && AppConstants.REMINDER_UIN.equals(messageRecord.senderuin)) {
            return true;
        }
        return false;
    }

    void l(MessageRecord messageRecord, boolean z16, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        boolean z17;
        boolean z18;
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f195505i);
        boolean z19 = this.f195506j;
        if (l3 != null && messageRecord != null) {
            z19 = l3.i(z19, messageRecord.frienduin, messageRecord.istroop, aVar);
        }
        this.f195505i.unitTestLog("vibratorAndAudio_check_sound_for_message", new Object[0]);
        if (this.f195506j && !this.f195504h && !this.f195505i.isRingerVibrate() && !this.f195505i.isRingEqualsZero() && this.f195502f && this.f195503g) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!this.f195506j && !this.f195504h && !this.f195505i.isRingerVibrate() && !this.f195505i.isRingEqualsZero() && this.f195502f && this.f195503g) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d("Notification.Sound", 1, "vibratorAndAudio: invoked. ", " needPlaySound: ", Boolean.valueOf(z17), " spFriendOverrideSoundSetting: ", Boolean.valueOf(z18), " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.f195506j), " isVideoing: ", Boolean.valueOf(this.f195504h), " isRingerVibrate(): ", Boolean.valueOf(this.f195505i.isRingerVibrate()), " isRingEqualsZero(): ", Boolean.valueOf(this.f195505i.isRingEqualsZero()), " isCallIdle: ", Boolean.valueOf(this.f195502f), " notRecordingPtt: ", Boolean.valueOf(this.f195503g), " enableSeparateSound: ", Boolean.valueOf(z19));
        if (z17 && z19) {
            p(messageRecord);
            this.f195505i.unitTestLog("vibratorAndAudio_play_sound_for_message", Boolean.valueOf(z19));
        } else if (z18) {
            this.f195505i.unitTestLog("vibratorAndAudio_play_sound_for_message", Boolean.valueOf(z19));
            try {
                o(messageRecord, z16, z19, aVar);
            } catch (Throwable unused) {
            }
        } else {
            this.f195505i.unitTestLog("vibratorAndAudio_no_need_play_sound_for_message", "\u72ec\u7acb\u4f1a\u8bdd\u652f\u6301\u7684\u4f1a\u8bdd\u7c7b\u578b\uff0c\u5e76\u4e14\u72ec\u7acb\u4f1a\u8bdd\u58f0\u97f3\u5f00\u5173\u5173\u95ed\uff0c\u8fd9\u79cd\u573a\u666f\u4e0d\u7528\u64ad\u653e\u94c3\u58f0\uff08\u5373\u4f7f\u5168\u5c40\u94c3\u58f0\u5f00\u5173\u6253\u5f00\uff09");
            QLog.i("VibrateSoundHelper", 1, "vibratorAndAudio_no_need_play_sound_for_message");
        }
    }

    void m(MessageRecord messageRecord, boolean z16, boolean z17, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar) {
        boolean z18;
        boolean z19;
        boolean z26;
        String str;
        BaseApplication context = BaseApplication.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f195505i);
        boolean z27 = this.f195507k;
        if (l3 != null && messageRecord != null) {
            z27 = l3.k(z27, messageRecord.frienduin, messageRecord.istroop, aVar);
        }
        int i3 = 1;
        this.f195505i.unitTestLog("vibratorAndAudio_enableSeparateVibrate", Boolean.valueOf(z27));
        if (this.f195507k && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f195507k = z18;
        if (z18 && this.f195502f && !this.f195504h && this.f195503g && z27) {
            z19 = true;
        } else {
            z19 = false;
        }
        QLog.i("VibrateSoundHelper", 1, "playMessageVibrate, no need vibrate, needPlayVibrate:" + z19 + ", isCallIdle:" + this.f195502f + ", isVideoingChat:" + this.f195504h + ", notRecordingPtt:" + this.f195503g + ", enableSeparateVibrate:" + z27);
        if (z19) {
            if (messageRecord != null && z16 && messageRecord.msgtype == -2020 && this.f195505i.getOnlineStauts() == 11) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                vibrator.vibrate(com.tencent.mobileqq.app.utils.q.f196673i, -1);
                i3 = 2;
                this.f195505i.unitTestLog("vibratorAndAudio_shake_window_type", 2);
            } else {
                if (messageRecord != null) {
                    str = AppConstants.Preferences.SPECIAL_SOUND_TYPE + this.f195505i.getCurrentAccountUin() + d(messageRecord);
                } else {
                    str = "";
                }
                if (sharedPreferences.contains(str)) {
                    vibrator.vibrate(1000L);
                    i3 = 3;
                    this.f195505i.unitTestLog("vibratorAndAudio_message", 3);
                } else {
                    vibrator.vibrate(com.tencent.mobileqq.app.utils.q.f196672h, -1);
                    this.f195505i.unitTestLog("vibratorAndAudio_message", 1);
                }
            }
            k(i3);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void n(boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.f195505i.unitTestLog("vibratorAndAudio_check_public_account_start", new Object[0]);
        QQAppInterface qQAppInterface = this.f195505i;
        Boolean bool = Boolean.FALSE;
        qQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", bool, bool);
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f195505i.getApp(), 2);
        Vibrator vibrator = (Vibrator) this.f195505i.getApp().getSystemService("vibrator");
        if (this.f195505i.isRingerVibrate() && this.f195499c && !this.f195501e) {
            this.f195505i.unitTestLog("vibratorAndAudio_check_sound_vibrate", bool, Boolean.TRUE);
            z18 = false;
            z17 = true;
        } else {
            if (this.f195505i.isRingerNormal() && this.f195505i.isRingerNormalVibrate() && this.f195499c && !this.f195501e) {
                QQAppInterface qQAppInterface2 = this.f195505i;
                Boolean bool2 = Boolean.TRUE;
                qQAppInterface2.unitTestLog("vibratorAndAudio_check_sound_vibrate", bool2, bool2);
                z17 = true;
            } else if (this.f195505i.isRingerNormal() && !this.f195505i.isRingerNormalVibrate() && this.f195499c && !this.f195501e) {
                this.f195505i.unitTestLog("vibratorAndAudio_check_sound_vibrate", Boolean.TRUE, bool);
                z17 = false;
                z18 = true;
            } else {
                z17 = false;
            }
            z18 = z17;
        }
        if (z17 && z16) {
            z19 = true;
        } else {
            z19 = false;
        }
        QLog.d("VibrateSoundHelper", 1, "play public account sound, canVibrator: " + z19 + " canPlaySound: " + z18 + " uri: " + actualDefaultRingtoneUri);
        if (z19 && vibrator != null) {
            vibrator.vibrate(com.tencent.mobileqq.app.utils.q.f196672h, -1);
            this.f195505i.unitTestLog("vibratorAndAudio_vibrate_invoked", new Object[0]);
        }
        if (z18 && actualDefaultRingtoneUri != null) {
            AudioUtil.p(actualDefaultRingtoneUri, false, false);
            this.f195505i.unitTestLog("vibratorAndAudio_sound_invoked", actualDefaultRingtoneUri);
        }
    }

    public void q(final MessageRecord messageRecord, final boolean z16, final boolean z17) {
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f195505i.unitTestLog("vibratorAndAudio_check_silent_start", new Object[0]);
        int specialCareRingRoamingSetting = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.f195505i);
        final boolean b16 = b(specialCareRingRoamingSetting);
        if (messageRecord == null) {
            m(null, z16, z17, null);
            l(null, b16, null);
        } else {
            int i3 = messageRecord.istroop;
            if (i3 == 1) {
                if (this.f195506j && this.f195505i.troopCanPlaySound()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                this.f195506j = z18;
                if (this.f195507k && this.f195505i.troopCanVibrator()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                this.f195507k = z19;
                this.f195505i.unitTestLog("vibratorAndAudio_troop_sound_vibrator", Boolean.valueOf(this.f195506j), Boolean.valueOf(this.f195507k));
                m(messageRecord, z16, z17, null);
                l(messageRecord, b16, null);
            } else if (i3 == 0 && !TextUtils.isEmpty(messageRecord.frienduin)) {
                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(messageRecord.frienduin), "VibrateSoundHelper", new hx3.b() { // from class: com.tencent.mobileqq.app.dn
                    @Override // hx3.b
                    public final void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                        Cdo.this.j(messageRecord, z16, z17, b16, eVar);
                    }
                });
            } else {
                m(messageRecord, z16, z17, null);
                l(messageRecord, b16, null);
            }
        }
        QLog.d("Notification.Sound", 1, "playVibrateAndSoundOfMessage, specialCareState=" + specialCareRingRoamingSetting + ", canPlaySpecialFriendSound=" + b16 + ", canPlaySoundInGeneralSetting:" + this.f195506j + ", canVibratorInGeneralSetting:" + this.f195507k + ", isVideoing is:" + this.f195504h + ", isCallIdle is:" + this.f195502f);
    }

    public void r(MessageRecord messageRecord, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, messageRecord, Boolean.valueOf(z16));
            return;
        }
        this.f195505i.unitTestLog("vibratorAndAudio_invoked", new Object[0]);
        if (QLog.isColorLevel()) {
            if (messageRecord != null) {
                if (messageRecord.msgtype == -2020) {
                    str = messageRecord.getBaseInfoString();
                } else {
                    str = "not shake msg,uinSeq is:" + messageRecord.uniseq;
                }
            } else {
                str = null;
            }
            QLog.d("VibrateSoundHelper", 2, "message is:" + str + ",isOnline is:" + z16);
        }
    }
}
