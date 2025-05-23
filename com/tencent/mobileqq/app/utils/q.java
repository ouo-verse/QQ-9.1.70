package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.Cdo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bq;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final long[] f196672h;

    /* renamed from: i, reason: collision with root package name */
    public static final long[] f196673i;

    /* renamed from: j, reason: collision with root package name */
    public static final long[] f196674j;

    /* renamed from: a, reason: collision with root package name */
    private long f196675a;

    /* renamed from: b, reason: collision with root package name */
    protected MobileQQ f196676b;

    /* renamed from: c, reason: collision with root package name */
    protected QQAppInterface f196677c;

    /* renamed from: d, reason: collision with root package name */
    Cdo f196678d;

    /* renamed from: e, reason: collision with root package name */
    bq f196679e;

    /* renamed from: f, reason: collision with root package name */
    private volatile byte[] f196680f;

    /* renamed from: g, reason: collision with root package name */
    private volatile long[] f196681g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70772);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        f196672h = new long[]{100, 200, 200, 100};
        f196673i = new long[]{100, 400, 100, 400, 100, 400};
        f196674j = new long[]{10, 50};
    }

    public q(MobileQQ mobileQQ, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) qQAppInterface);
            return;
        }
        this.f196675a = -1L;
        this.f196680f = new byte[2];
        this.f196681g = new long[2];
        this.f196676b = mobileQQ;
        this.f196677c = qQAppInterface;
    }

    private static long f(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return 0L;
        }
        return messageRecord.uniseq;
    }

    private static boolean g(Context context) {
        if (ContextCompat.checkSelfPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        try {
            BaseApplication baseApplication = BaseApplication.context;
            if (baseApplication == null) {
                QLog.w("QQAppInterface_SoundAndVibrateUtils", 1, "[isCallIdle] context is null");
                return true;
            }
            if (Build.VERSION.SDK_INT >= 31 && !g(baseApplication)) {
                QLog.w("QQAppInterface_SoundAndVibrateUtils", 1, "[isCallIdle] no permission");
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) baseApplication.getSystemService("phone");
            if (telephonyManager != null && SystemMethodProxy.getCallState(telephonyManager) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            QLog.w("QQAppInterface_SoundAndVibrateUtils", 1, "[isCallIdle] error: " + th5.getMessage());
            return true;
        }
    }

    private boolean l(MessageRecord messageRecord, boolean z16) {
        this.f196677c.unitTestLog("vibratorAndAudio_check_time_start", new Object[0]);
        if (this.f196675a == -1) {
            this.f196677c.unitTestLog("vibratorAndAudio_check_time_not_valid", new Object[0]);
        } else if (Math.abs(System.currentTimeMillis() - this.f196675a) <= 2000) {
            this.f196677c.unitTestLog("vibratorAndAudio_check_time_in_time_space", new Object[0]);
            if (messageRecord == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("SpecialCare", 2, "message = null");
                }
                return true;
            }
            if (messageRecord.msgtype != -2020) {
                if (QLog.isColorLevel()) {
                    QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
                }
                return true;
            }
            if (!z16 || this.f196677c.getOnlineStauts() != 11) {
                if (QLog.isColorLevel()) {
                    QLog.e("SpecialCare", 2, "isOnline = " + z16 + " getOnlineStatus = " + this.f196677c.getOnlineStauts());
                }
                return true;
            }
        }
        this.f196675a = System.currentTimeMillis();
        this.f196677c.unitTestLog("vibratorAndAudio_check_time_end", new Object[0]);
        return false;
    }

    private boolean n(String str) {
        if (!AppConstants.SYSTEM_MSG_UIN.equals(str) && !AppConstants.QQBROADCAST_MSG_UIN.equals(str) && !AppConstants.LBS_HELLO_UIN.equals(str)) {
            return false;
        }
        return true;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (c() != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (d() != 0) {
            return true;
        }
        return false;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return ((IRoamSettingService) this.f196677c.getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.ALL_RING, 1);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return ((IRoamSettingService) this.f196677c.getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.ALL_VIBRATE, 1);
    }

    public BaseApplication e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f196676b;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        AudioManager audioManager = (AudioManager) e().getSystemService("audio");
        if (audioManager != null && SystemMethodProxy.getStreamVolume(audioManager, 2) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean j() {
        int ringerMode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        AudioManager audioManager = (AudioManager) this.f196676b.getSystemService("audio");
        if (audioManager != null) {
            try {
                ringerMode = audioManager.getRingerMode();
            } catch (Throwable unused) {
            }
            if (ringerMode != 0) {
                return true;
            }
            return false;
        }
        ringerMode = 2;
        if (ringerMode != 0) {
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        try {
            AudioManager audioManager = (AudioManager) e().getSystemService("audio");
            if (audioManager == null) {
                return false;
            }
            if (audioManager.getRingerMode() != 1) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.i("QQAppInterface_SoundAndVibrateUtils", 1, "isRingerVibrate error: " + th5.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m(boolean z16, boolean z17, Message message, bq bqVar) {
        byte b16;
        byte b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), message, bqVar)).booleanValue();
        }
        this.f196679e = bqVar;
        if (bqVar.q(message)) {
            QLog.i("QQAppInterface_SoundAndVibrateUtils", 1, "soundVibrateWhenNoNotification, isNoSoundMessageType");
            return true;
        }
        if (bqVar.p(message)) {
            QLog.i("QQAppInterface_SoundAndVibrateUtils", 1, "soundVibrateWhenNoNotification, isNoNeedSoundWhenNoNotification");
            return true;
        }
        if (message.istroop == 1008 && AppConstants.REMINDER_UIN.equals(message.senderuin)) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            QLog.i("QQAppInterface_SoundAndVibrateUtils", 1, "soundVibrateWhenNoNotification, reminderMessage");
            r(message, z17);
            return true;
        }
        if (z16) {
            boolean o16 = bqVar.o(message);
            QQAppInterface qQAppInterface = this.f196677c;
            if (qQAppInterface.userActiveStatus == 0 || o16) {
                if (!qQAppInterface.mainActivityIsForeground) {
                    r(message, z17);
                } else {
                    if (this.f196681g[0] == message.uniseq && this.f196681g[1] == 1) {
                        b17 = true;
                    } else {
                        b17 = false;
                    }
                    if (b17 != false) {
                        r(message, z17);
                    } else {
                        this.f196680f[0] = 1;
                        this.f196680f[1] = z17 ? (byte) 1 : (byte) 0;
                    }
                }
            }
        }
        if (z16 && bqVar.r(message)) {
            bqVar.c(message);
        }
        return false;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.f196677c) != 0) {
            return true;
        }
        return false;
    }

    public void p() {
        Message v16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.f196680f));
        }
        QQMessageFacade messageFacade = this.f196677c.getMessageFacade();
        if (messageFacade == null || (v16 = messageFacade.v1()) == null) {
            return;
        }
        this.f196681g[0] = v16.uniseq;
        boolean z16 = true;
        this.f196681g[1] = 1;
        if (this.f196680f[0] == 1) {
            if (this.f196680f[1] != 1) {
                z16 = false;
            }
            r(v16, z16);
            this.f196680f[0] = 0;
        }
    }

    public void q(MessageRecord messageRecord, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Cdo cdo = new Cdo(this.f196677c, messageRecord);
        this.f196678d = cdo;
        cdo.r(messageRecord, z16);
        QLog.d("QQAppInterface_SoundAndVibrateUtils", 1, "previous vibrate time is:" + this.f196675a + ",curr time is:" + System.currentTimeMillis());
        if (this.f196678d.e(messageRecord) || l(messageRecord, z16) || this.f196678d.f(messageRecord)) {
            return;
        }
        if (this.f196678d.h(messageRecord)) {
            this.f196678d.n(z17);
            return;
        }
        this.f196677c.unitTestLog("vibratorAndAudio_check_public_account_end", new Object[0]);
        boolean c16 = this.f196678d.c();
        QLog.d("Notification.Sound", 1, "vibratorAndAudio, deviceSoundOn=", Boolean.valueOf(c16), " msgId:" + f(messageRecord));
        if (c16) {
            this.f196678d.q(messageRecord, z16, z17);
        }
    }

    public void r(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, messageRecord, Boolean.valueOf(z16));
            return;
        }
        if (Build.VERSION.SDK_INT <= 28) {
            z17 = true;
        }
        q(messageRecord, z16, z17);
    }

    public void s(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f196675a = System.currentTimeMillis();
        boolean j3 = j();
        boolean a16 = az.a(this.f196676b.getApplicationContext(), this.f196677c);
        boolean c16 = az.c(this.f196676b.getApplicationContext(), this.f196677c);
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "isRingerSilent is:" + j3 + ",canDisturb is:" + a16, " isMute:", Boolean.valueOf(c16));
        }
        if (!j3 && a16 && !c16) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(e());
            Vibrator vibrator = (Vibrator) e().getSystemService("vibrator");
            boolean isVideoChatting = this.f196677c.isVideoChatting();
            boolean canPlaySound = this.f196677c.canPlaySound();
            boolean canVibrator = this.f196677c.canVibrator();
            boolean isCallIdle = this.f196677c.isCallIdle();
            boolean recordingPttStopped = this.f196677c.recordingPttStopped();
            if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "canVibrator is:" + canVibrator + ",isVideoing is:" + isVideoChatting + ",isCallIdle is:" + isCallIdle + ",notRecordingPtt is:" + recordingPttStopped);
            }
            if (canVibrator && isCallIdle && !isVideoChatting && recordingPttStopped) {
                vibrator.vibrate(f196673i, -1);
            }
            if (z16 && canPlaySound && !isVideoChatting && !k() && !i() && h() && this.f196677c.recordingPttStopped()) {
                int i3 = defaultSharedPreferences.getInt(AppConstants.Preferences.SOUND_TYPE + this.f196677c.getCurrentAccountUin(), R.raw.f169398k);
                if (n(str)) {
                    i3 = R.raw.f169478ac;
                }
                AudioUtil.n(i3, false);
            }
        }
    }
}
