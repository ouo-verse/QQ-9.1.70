package com.tencent.mobileqq.qmcf;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QmcfSwitchStrategy {
    static IPatchRedirector $redirector_ = null;
    public static final int QMCF_ENTRANCE_DEFAULT = -1;
    public static final int QMCF_ENTRANCE_DPC_OFF = 4;
    public static final int QMCF_ENTRANCE_GPU_NOTSUPPORT = 2;
    public static final int QMCF_ENTRANCE_INIT_FAILED_NATIVE = 5;
    public static final int QMCF_ENTRANCE_INIT_FAILED_NONATIVE = 6;
    public static final int QMCF_ENTRANCE_LOADSO_FAILED = 7;
    public static final int QMCF_ENTRANCE_MAIN_SWITCHOFF = 3;
    public static final int QMCF_ENTRANCE_SUPPORT = 0;
    public static final int QMCF_ENTRANCE_VERSION_TOOLOW = 1;
    public static final String QMCF_EXCEPTION_CURR_COUNT_ART = "qmcf_exception_curr_count_art";
    public static final String QMCF_EXCEPTION_CURR_COUNT_BIGHEAD = "qmcf_exception_curr_count_bighead";
    public static final String QMCF_EXCEPTION_CURR_COUNT_DANCE = "qmcf_exception_curr_count_dance";
    public static final String QMCF_EXCEPTION_MAX_COUNT = "qmcf_exception_max_count";
    public static final String QMCF_MAIN_SWITCH = "qmcf_main_switch";
    public static final String QMCF_MOBILEQ_SUPPORT = "qmcf_mobile_support";
    public static final String SP_TAG = "QmcfConfig";
    public static final int SVAF_SWITCH_ON = 1;
    private static final String TAG = "QmcfSwitchStrategy";
    private int artCurrExcpCount;
    private boolean artFilterDpcSwitch;
    private int artFrameExcpCount;
    private int bigHeadCurrExcpCount;
    private int bigHeadFrameExcpCount;
    private int currEntranceState;
    private int danceCurrExcpCount;
    private int danceFrameExcpCount;
    private boolean initSuccess;
    private int qmcfMainSwitch;
    private int qmcfMaxExcpCount;
    private int qmcfMobileSupport;

    public QmcfSwitchStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.qmcfMainSwitch = -1;
        this.qmcfMobileSupport = -1;
        this.artFilterDpcSwitch = false;
        this.artFrameExcpCount = 0;
        this.artCurrExcpCount = -1;
        this.qmcfMaxExcpCount = -1;
        this.danceFrameExcpCount = 0;
        this.danceCurrExcpCount = -1;
        this.bigHeadFrameExcpCount = 0;
        this.bigHeadCurrExcpCount = -1;
        this.initSuccess = true;
        this.currEntranceState = -1;
    }

    public int getEntranceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        int i3 = this.currEntranceState;
        if (i3 > -1) {
            return i3;
        }
        if (DeviceInstance.getSDKVersion() < 21) {
            this.currEntranceState = 1;
        } else if (this.qmcfMobileSupport == 0) {
            this.currEntranceState = 2;
        } else if (this.qmcfMainSwitch == 0) {
            this.currEntranceState = 3;
        } else if (this.danceCurrExcpCount >= this.qmcfMaxExcpCount) {
            this.currEntranceState = 5;
        } else if (!this.initSuccess) {
            this.currEntranceState = 6;
        } else if (!SoLoader.isLoadArtFilterSuccess()) {
            this.currEntranceState = 7;
        } else {
            this.currEntranceState = 0;
        }
        return this.currEntranceState;
    }

    public boolean isArtFilterSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.qmcfMainSwitch == -1) {
            this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MAIN_SWITCH, 1);
        }
        if (this.qmcfMobileSupport == -1) {
            if (SdkContext.getInstance().getApplication() == null) {
                return true;
            }
            this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MOBILEQ_SUPPORT, 1);
        }
        this.artFilterDpcSwitch = SdkContext.getInstance().getDpcSwitcher().isSvafSwitchOpen();
        if (this.artCurrExcpCount == -1 || this.qmcfMaxExcpCount == -1) {
            SharedPreferences sharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4);
            this.artCurrExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_CURR_COUNT_ART, 0);
            this.qmcfMaxExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_MAX_COUNT, 2);
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("ArtMode: MainSwitch[%s], MobileSupport[%s], DPCSwitch[%s], currCount[%s], maxCount[%s]", Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Boolean.valueOf(this.artFilterDpcSwitch), Integer.valueOf(this.artCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount)));
        }
        if (this.qmcfMainSwitch == 1 && this.qmcfMobileSupport == 1 && this.artFilterDpcSwitch && this.artCurrExcpCount < this.qmcfMaxExcpCount) {
            return true;
        }
        return false;
    }

    public boolean isBigHeadSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.qmcfMainSwitch == -1) {
            this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MAIN_SWITCH, 1);
        }
        if (this.qmcfMobileSupport == -1) {
            if (SdkContext.getInstance().getApplication() == null) {
                return true;
            }
            this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MOBILEQ_SUPPORT, 1);
        }
        if (this.bigHeadCurrExcpCount == -1 || this.qmcfMaxExcpCount == -1) {
            SharedPreferences sharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4);
            this.bigHeadCurrExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_CURR_COUNT_BIGHEAD, 0);
            this.qmcfMaxExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_MAX_COUNT, 2);
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("BigheadMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.bigHeadCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount)));
        }
        if (this.qmcfMainSwitch == 1 && this.qmcfMobileSupport == 1 && this.bigHeadCurrExcpCount < this.qmcfMaxExcpCount) {
            return true;
        }
        return false;
    }

    public boolean isDanceGameSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.qmcfMainSwitch == -1) {
            this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MAIN_SWITCH, 1);
        }
        if (this.qmcfMobileSupport == -1) {
            if (SdkContext.getInstance().getApplication() == null) {
                return true;
            }
            this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MOBILEQ_SUPPORT, 1);
        }
        if (this.danceCurrExcpCount == -1 || this.qmcfMaxExcpCount == -1) {
            SharedPreferences sharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4);
            this.danceCurrExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_CURR_COUNT_DANCE, 0);
            this.qmcfMaxExcpCount = sharedPreferences.getInt(QMCF_EXCEPTION_MAX_COUNT, 2);
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("DanceMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.danceCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount)));
        }
        if (this.qmcfMainSwitch == 1 && this.qmcfMobileSupport == 1 && this.danceCurrExcpCount < this.qmcfMaxExcpCount) {
            return true;
        }
        return false;
    }

    public boolean isMobileSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.qmcfMobileSupport == -1) {
            if (SdkContext.getInstance().getApplication() == null) {
                return true;
            }
            this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).getInt(QMCF_MOBILEQ_SUPPORT, 1);
        }
        if (this.qmcfMobileSupport == 1) {
            return true;
        }
        return false;
    }

    public boolean isModeSupported(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    SLog.d(TAG, "unknown mode:" + i3);
                    return false;
                }
                return isBigHeadSupported();
            }
            return isDanceGameSupported();
        }
        return isArtFilterSupported();
    }

    public void setArtFilterRunSupport(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            if (!z16) {
                int i3 = this.artFrameExcpCount + 1;
                this.artFrameExcpCount = i3;
                if (i3 <= 5) {
                    return;
                }
            } else {
                return;
            }
        }
        if (z16) {
            this.artCurrExcpCount = 0;
        } else {
            this.artCurrExcpCount++;
            this.artFrameExcpCount = 0;
        }
        SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).edit();
        edit.putInt(QMCF_EXCEPTION_CURR_COUNT_ART, this.artCurrExcpCount);
        edit.commit();
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("ArtMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(this.artCurrExcpCount)));
        }
    }

    public void setBigHeadRunSupport(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            if (!z16) {
                int i3 = this.bigHeadFrameExcpCount + 1;
                this.bigHeadFrameExcpCount = i3;
                if (i3 <= 5) {
                    return;
                }
            } else {
                return;
            }
        }
        if (z16) {
            this.bigHeadCurrExcpCount = 0;
        } else {
            this.bigHeadCurrExcpCount++;
            this.bigHeadFrameExcpCount = 0;
        }
        SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).edit();
        edit.putInt(QMCF_EXCEPTION_CURR_COUNT_BIGHEAD, this.bigHeadCurrExcpCount);
        edit.commit();
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("BigHeadMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(this.bigHeadCurrExcpCount)));
        }
    }

    public void setDanceGameRunSupport(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            if (!z16) {
                int i3 = this.danceFrameExcpCount + 1;
                this.danceFrameExcpCount = i3;
                if (i3 <= 5) {
                    return;
                }
            } else {
                return;
            }
        }
        if (z16) {
            this.danceCurrExcpCount = 0;
        } else {
            this.danceCurrExcpCount++;
            this.danceFrameExcpCount = 0;
        }
        SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).edit();
        edit.putInt(QMCF_EXCEPTION_CURR_COUNT_DANCE, this.danceCurrExcpCount);
        edit.commit();
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("DanceMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(this.danceCurrExcpCount)));
        }
    }

    public void setInitSuccess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.initSuccess = z16;
        }
    }

    public void setMobileSupport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        this.qmcfMobileSupport = z16 ? 1 : 0;
        SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).edit();
        edit.putInt(QMCF_MOBILEQ_SUPPORT, this.qmcfMobileSupport);
        edit.commit();
        if (SLog.isEnable()) {
            SLog.d(TAG, "setMobileSupport :" + this.qmcfMobileSupport);
        }
    }

    public void setQmcfRunSupported(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    setBigHeadRunSupport(z16, z17);
                    return;
                }
                return;
            }
            setDanceGameRunSupport(z16, z17);
            return;
        }
        setArtFilterRunSupport(z16, z17);
    }

    public void updateMainSwitch(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("svaf_switch", 1);
            int optInt2 = jSONObject.optInt("svaf_maxCount", -1);
            SharedPreferences.Editor edit = SdkContext.getInstance().getApplication().getSharedPreferences(SP_TAG, 4).edit();
            edit.putInt(QMCF_MAIN_SWITCH, optInt);
            if (optInt2 != -1) {
                this.qmcfMaxExcpCount = optInt2;
                edit.putInt(QMCF_EXCEPTION_MAX_COUNT, optInt2);
            }
            edit.commit();
            if (SLog.isEnable()) {
                SLog.d(TAG, String.format("updateMainSwitch, mainSwitch[%s], maxCount[%s]", Integer.valueOf(optInt), Integer.valueOf(optInt2)));
            }
        }
    }
}
