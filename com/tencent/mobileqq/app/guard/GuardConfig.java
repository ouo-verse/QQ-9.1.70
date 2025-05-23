package com.tencent.mobileqq.app.guard;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int ACTIVE_HI = 0;
    public static final int ACTIVE_LOW = 2;
    public static final int ACTIVE_NOR = 1;
    private static final String ARRAY_SEPERATOR = ";";
    private static final String CONFIG_NAME = "qq_process_gm";
    static final int COUNT_ACTIVE_LEVEL = 3;
    public static final int MAX_ACTIVE_MINUTE = 15;
    private static final float MAX_FRACTION = 15.0f;
    private static final int MAX_MEMORY_BARRIER = 200;
    private static final int MAX_TIMEOUT = 100;
    private static final int MAX_WAKE_MINS = 120;
    public static final int MEM_HIGH = 2;
    public static final int MEM_LOW = 0;
    public static final int MEM_NOR = 1;
    private static final float MIN_FRACTION = 0.0f;
    private static final int MIN_MEMORY_BARRIER = 20;
    private static final int MIN_TIMEOUT = 5;
    private static final int MIN_WAKE_MINS = 1;
    private static final String SEPERATOR_AB_TEST = "__";
    private static final String SUB_SEPERATOR = "\\|";
    public static final float SUCIDE_HEAP_LEVEL = 0.95f;
    public static final long SUCIDE_HEAP_LEVEL_TICK = 50;
    private static GuardConfig sInstance;
    float[] activeFraction;
    public String configId;
    boolean disableForeground;
    private int mLastLevel;
    private int mLastMinute;
    private int mMemoryMode;
    int maxRecordCount;
    int maxStartCount;
    int[] memoryBarriers;
    long minLiteInterval;
    int tellWeakend;
    public int[] timeouts;

    GuardConfig() {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.memoryBarriers = new int[]{47185920, 68157440, 89128960, 120586240};
        this.timeouts = new int[]{3840000, 1920000, P2VGlobalConfig.OUTPUT_VIDEO_BIT_RATE, 720000, 600000};
        this.activeFraction = new float[]{0.94f, 0.6f, 0.0f};
        this.maxRecordCount = 12;
        this.maxStartCount = 3;
        this.minLiteInterval = 720000L;
        this.tellWeakend = 0;
        this.configId = "";
        this.mMemoryMode = 1;
        this.mLastMinute = -1;
        this.mLastLevel = 1;
        String[] loadConfigFromDpc = loadConfigFromDpc();
        if (loadConfigFromDpc == null) {
            return;
        }
        try {
            parseMemoryBarrier(loadConfigFromDpc);
            parseActiveFraction(loadConfigFromDpc[2]);
            parseMinLiteInterval(loadConfigFromDpc[3]);
            if (loadConfigFromDpc.length > 4) {
                parseMaxRecordAndStartCount(loadConfigFromDpc[4]);
                if (loadConfigFromDpc.length > 6) {
                    this.tellWeakend = Integer.parseInt(loadConfigFromDpc[5]);
                    this.configId = loadConfigFromDpc[6];
                }
                if (loadConfigFromDpc.length > 7 && (parseInt = Integer.parseInt(loadConfigFromDpc[7])) >= 1 && parseInt < 10) {
                    GuardManager.SUICIDE_FACTOR = parseInt;
                }
                parseTickKill(loadConfigFromDpc);
                parseMiuiForeground(loadConfigFromDpc);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(GuardManager.TAG, 2, "Exception: ", th5);
            }
        }
    }

    public static GuardConfig instance() {
        if (sInstance == null) {
            synchronized (GuardConfig.class) {
                if (sInstance == null) {
                    sInstance = new GuardConfig();
                }
            }
        }
        return sInstance;
    }

    private String[] loadConfigFromDpc() {
        return GuardManager.sInstance.injector.e(CONFIG_NAME, SEPERATOR_AB_TEST, ";");
    }

    private void parseActiveFraction(String str) {
        int length;
        String[] split = str.split(SUB_SEPERATOR);
        float[] fArr = this.activeFraction;
        if (fArr.length < split.length) {
            length = fArr.length;
        } else {
            length = split.length;
        }
        for (int i3 = 0; i3 < length; i3++) {
            float parseFloat = Float.parseFloat(split[i3]);
            if (parseFloat >= 0.0f && parseFloat <= 15.0f) {
                this.activeFraction[i3] = parseFloat;
            } else {
                throw new IllegalArgumentException("Illegal fraction value " + parseFloat);
            }
        }
    }

    private void parseMaxRecordAndStartCount(String str) {
        String[] split = str.split(SUB_SEPERATOR);
        int i3 = 0;
        int parseInt = Integer.parseInt(split[0]);
        if (parseInt < 1) {
            parseInt = 1;
        } else if (parseInt > 24) {
            parseInt = 24;
        }
        if (24 % parseInt == 0) {
            this.maxRecordCount = parseInt;
        }
        int parseInt2 = Integer.parseInt(split[1]);
        if (parseInt2 >= 0 && parseInt2 <= (i3 = this.maxRecordCount)) {
            i3 = parseInt2;
        }
        this.maxStartCount = i3;
    }

    private void parseMemoryBarrier(String[] strArr) {
        String[] split = strArr[0].split(SUB_SEPERATOR);
        for (int i3 = 0; i3 < this.memoryBarriers.length; i3++) {
            int parseInt = Integer.parseInt(split[i3]);
            if (parseInt > 20 && parseInt < 200) {
                this.memoryBarriers[i3] = parseInt * 1024 * 1024;
            } else {
                throw new IllegalArgumentException("Illegal memory size " + parseInt);
            }
        }
        String[] split2 = strArr[1].split(SUB_SEPERATOR);
        for (int i16 = 0; i16 < this.timeouts.length; i16++) {
            int parseInt2 = Integer.parseInt(split2[i16]);
            if (parseInt2 > 5 && parseInt2 < 100) {
                this.timeouts[i16] = parseInt2 * 60 * 1000;
            } else {
                throw new IllegalArgumentException("Illegal timeout value " + parseInt2);
            }
        }
    }

    private void parseMinLiteInterval(String str) {
        int parseInt = Integer.parseInt(str.split(SUB_SEPERATOR)[0]);
        if (parseInt > 1 && parseInt < 120) {
            this.minLiteInterval = parseInt * 60 * 1000;
            return;
        }
        throw new IllegalArgumentException("Illegal wake interval " + parseInt);
    }

    private void parseMiuiForeground(String[] strArr) {
        if (strArr.length > 9) {
            if (Integer.parseInt(strArr[9]) == 1) {
                try {
                    String property = System.getProperty("ro.miui.ui.version.name");
                    if (!TextUtils.isEmpty(property) && property.length() == 2 && Integer.parseInt(property.substring(1)) >= 7) {
                        this.disableForeground = true;
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e("GuardConfig", 1, "parseMiuiForeground t:", th5);
                    return;
                }
            }
            return;
        }
        try {
            String property2 = System.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property2) && property2.length() == 2 && Integer.parseInt(property2.substring(1)) >= 7) {
                this.disableForeground = true;
            }
        } catch (Throwable th6) {
            QLog.e("GuardConfig", 1, "parseMiuiForeground 2 t:", th6);
        }
    }

    private void parseTickKill(String[] strArr) {
        if (strArr.length > 8) {
            String[] split = strArr[8].split(SUB_SEPERATOR);
            if (split.length > 0) {
                GuardManager.sTickToolBgFgKill = Integer.parseInt(split[0]);
            }
            if (split.length > 1) {
                GuardManager.sTickQZoneBgKill = Integer.parseInt(split[1]);
            }
        }
    }

    public int getActiveLevel(long[][] jArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, jArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i16 != this.mLastMinute) {
            float f16 = 0.0f;
            for (int i18 = 0; i18 < 3; i18++) {
                float f17 = 0.0f;
                for (int i19 = 0; i19 < 15; i19++) {
                    f17 += (float) jArr[i18][i19];
                }
                f16 += ((f17 * this.activeFraction[i18]) * 5.0f) / 15.0f;
            }
            int i26 = (int) (3.0f - f16);
            if (i26 < 0) {
                i17 = 0;
            } else if (i26 <= 2) {
                i17 = i26;
            }
            this.mLastMinute = i16;
            this.mLastLevel = i17;
            return i17;
        }
        return this.mLastLevel;
    }

    public String getConfigId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.configId;
    }

    public int getMemoryLevel(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, j3)).intValue();
        }
        int binarySearch = Arrays.binarySearch(this.memoryBarriers, (int) j3);
        if (binarySearch < 0) {
            binarySearch = (-1) - binarySearch;
        }
        int i3 = binarySearch - this.mMemoryMode;
        if (i3 > 2) {
            return 2;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public long getTimeout(long[][] jArr, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, jArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).longValue();
        }
        return this.timeouts[getMemoryLevel(j3) + getActiveLevel(jArr, i3, i16)];
    }
}
