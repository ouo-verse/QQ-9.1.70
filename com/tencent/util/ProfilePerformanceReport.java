package com.tencent.util;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes27.dex */
public class ProfilePerformanceReport {
    static IPatchRedirector $redirector_ = null;
    public static final int CLICK2CREATE = 0;
    public static final int FETCH_DATA = 6;
    public static final int FIRST_DRAW = 1;
    public static final int FIRST_SHOW = 2;
    public static final int INDEX_END = 9;
    public static final int INDEX_START = 0;
    public static final int INIT_DATA = 5;
    private static final long MIN_REPORT_INTERVAL = 60000;
    private static final long MIN_VALID_MARKING_DU = 20000;
    public static final int OPEN = 3;
    private static final String[] PARAMS;
    public static final int PREPARE_RES = 7;
    public static final int REFRESH_FROM_CACHE = 8;
    public static final int REFRESH_FROM_NET = 9;
    private static final boolean REPORT_PERFORMANCE = false;
    public static final int RUN_DELAY = 4;
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_FINISH_FIRST_DRAW = 3;
    private static final int STATE_REPORTED = 1;
    private static final int STATE_START_MARKING = 2;
    private static final int STATE_TO_REPORT = 4;
    public static final String TAG = "ProfilePerformanceReport";
    public static ProfilePerformanceReport sFriendProfileReport;
    public static ProfilePerformanceReport sNearbyProfileReport;
    private final long[] mEndTimes;
    private long mLastReportTime;
    private final long[] mStartTimes;
    private int mState;
    private final String mTag;
    private StringBuilder mTempBuilder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            PARAMS = new String[]{"param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net"};
        }
    }

    public ProfilePerformanceReport(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mTempBuilder = new StringBuilder(100);
        this.mTag = str;
        this.mStartTimes = new long[10];
        this.mEndTimes = new long[10];
        reset();
    }

    public boolean isMarking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        int i3 = this.mState;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean isTagEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        if (i3 < 0 || i3 > 9 || this.mStartTimes[i3] == 0 || this.mEndTimes[i3] == 0) {
            return false;
        }
        return true;
    }

    public boolean isTagStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        if (i3 < 0 || i3 > 9 || this.mStartTimes[i3] == 0) {
            return false;
        }
        return true;
    }

    public boolean isToReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        int i3 = this.mState;
        if (i3 < 3) {
            return false;
        }
        if (i3 != 4 && !z16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - r7.mLastReportTime) < 60000) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - r7.mStartTimes[0]) < com.tencent.util.ProfilePerformanceReport.MIN_VALID_MARKING_DU) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isValidMarking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = this.mState;
        boolean z16 = true;
        if (i3 != 4) {
            if (i3 != 2) {
                return false;
            }
        }
    }

    public void markEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 <= 9 && this.mStartTimes[i3] != 0) {
            long[] jArr = this.mEndTimes;
            if (jArr[i3] == 0) {
                jArr[i3] = SystemClock.elapsedRealtime();
                if (i3 == 1) {
                    long[] jArr2 = this.mEndTimes;
                    jArr2[3] = jArr2[i3];
                    this.mState = 3;
                } else if (i3 == 9) {
                    this.mState = 4;
                }
                if (QLog.isDevelopLevel()) {
                    this.mTempBuilder.setLength(0);
                    StringBuilder sb5 = this.mTempBuilder;
                    sb5.append("markEnd, [");
                    sb5.append(PARAMS[i3]);
                    sb5.append(",");
                    sb5.append(this.mEndTimes[i3]);
                    sb5.append(",");
                    sb5.append(this.mEndTimes[i3] - this.mStartTimes[i3]);
                    sb5.append(",");
                    sb5.append(this.mState);
                    sb5.append("]");
                    QLog.i(TAG, 4, this.mTempBuilder.toString());
                }
            }
        }
    }

    public void markStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 <= 9) {
            long[] jArr = this.mStartTimes;
            if (jArr[i3] == 0) {
                jArr[i3] = SystemClock.elapsedRealtime();
                if (i3 == 0) {
                    this.mState = 2;
                    long[] jArr2 = this.mStartTimes;
                    jArr2[3] = jArr2[i3];
                }
                if (QLog.isDevelopLevel()) {
                    this.mTempBuilder.setLength(0);
                    StringBuilder sb5 = this.mTempBuilder;
                    sb5.append("markStart, [");
                    sb5.append(PARAMS[i3]);
                    sb5.append(",");
                    sb5.append(this.mStartTimes[i3]);
                    sb5.append(",");
                    sb5.append(this.mState);
                    sb5.append("]");
                    QLog.i(TAG, 4, this.mTempBuilder.toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportPerformance(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        HashMap hashMap = new HashMap();
        long j16 = 0;
        long j17 = 0;
        for (int i3 = 0; i3 <= 9; i3++) {
            long j18 = this.mEndTimes[i3];
            if (j18 != 0) {
                long j19 = this.mStartTimes[i3];
                if (j19 != 0) {
                    j16 = j18 - j19;
                    if (i3 == 3) {
                        j17 = j16;
                    }
                    String str2 = PARAMS[i3];
                    if (j16 <= 0) {
                        j3 = j16;
                    } else {
                        j3 = 0;
                    }
                    hashMap.put(str2, String.valueOf(j3));
                }
            }
            j16 = 0;
            if (i3 == 3) {
            }
            String str22 = PARAMS[i3];
            if (j16 <= 0) {
            }
            hashMap.put(str22, String.valueOf(j3));
        }
        this.mLastReportTime = SystemClock.elapsedRealtime();
        this.mState = 1;
        if (QLog.isDevelopLevel()) {
            this.mTempBuilder.setLength(0);
            StringBuilder sb5 = this.mTempBuilder;
            sb5.append("reportPerformance, [");
            sb5.append(j16);
            sb5.append(",");
            sb5.append(hashMap.toString());
            sb5.append("]");
            QLog.i(TAG, 4, this.mTempBuilder.toString());
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(str, j17, hashMap) { // from class: com.tencent.util.ProfilePerformanceReport.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f383961d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f383962e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ HashMap f383963f;

            {
                this.f383961d = str;
                this.f383962e = j17;
                this.f383963f = hashMap;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfilePerformanceReport.this, str, Long.valueOf(j17), hashMap);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f383961d, ProfilePerformanceReport.this.mTag, true, this.f383962e, 0L, this.f383963f, "");
                if (QLog.isDevelopLevel()) {
                    QLog.i(ProfilePerformanceReport.TAG, 4, "end of report");
                }
            }
        });
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mLastReportTime = 0L;
        this.mState = 0;
        for (int i3 = 0; i3 <= 9; i3++) {
            long[] jArr = this.mStartTimes;
            this.mEndTimes[i3] = 0;
            jArr[i3] = 0;
        }
    }

    public static void markFriendProfile() {
    }

    public static void markNearbyProfile() {
    }
}
