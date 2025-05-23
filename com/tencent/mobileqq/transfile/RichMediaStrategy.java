package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RichMediaStrategy {
    static IPatchRedirector $redirector_ = null;
    public static final int EOF_EXTRA_RETRY_LIMIT = 5;
    public static final int FIX_SCHEDULE_TRY_COUNT = 3;
    private static int FixSchedulTryCount_dpc = 0;
    public static final int MOBLIE_CONCURRENT_LIMIT = 3;
    public static final int NETWORK_CHG_RETRY_LIMIT = 3;
    public static final int NO_MSF_SUGGEST_RETRY = 450000;
    public static final int POST_DATA_TIMEOUT = 89500;
    public static final int RESPONSE_TIMEOUT = 90000;
    public static final int RICH_BUSI_RETRY = 2;
    public static final int RICH_URL_DOWN_RETRY = 2;
    public static final int TIME_SPACE = 25;
    public static final int TRY_COUNT = 9;
    public static final int TRY_TIME = 480000;
    private static int TryCount_dpc;
    private static int TryTime_dpc;

    /* renamed from: g2, reason: collision with root package name */
    public static NetPolicy f293464g2;

    /* renamed from: g3, reason: collision with root package name */
    public static NetPolicy f293465g3;
    public static NetPolicy wifi;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface C2C {
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class G2 extends NetPolicy {
        static IPatchRedirector $redirector_;
        private int connectTimeout;
        private int maxTryTime;
        private int minTryTime;
        private int readTimeout;
        private int timeLimit;
        private int tryInterval;

        public G2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.timeLimit = 480000;
            this.maxTryTime = 9;
            this.minTryTime = 3;
            this.connectTimeout = 20000;
            this.readTimeout = 40000;
            this.tryInterval = 5000;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getConnectTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.connectTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMaxTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.maxTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMinTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.minTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getReadTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.readTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTimeLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.timeLimit;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTryInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.tryInterval;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class G3 extends NetPolicy {
        static IPatchRedirector $redirector_;
        private int connectTimeout;
        private int maxTryTime;
        private int minTryTime;
        private int readTimeout;
        private int timeLimit;
        private int tryInterval;

        public G3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.timeLimit = 420000;
            this.maxTryTime = 9;
            this.minTryTime = 3;
            this.connectTimeout = 15000;
            this.readTimeout = 30000;
            this.tryInterval = 4000;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getConnectTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.connectTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMaxTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.maxTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMinTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.minTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getReadTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.readTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTimeLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.timeLimit;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTryInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.tryInterval;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface Group {
        public static final int FLOW_LIMIT = 3;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class NetPolicy {
        static IPatchRedirector $redirector_;
        private int connectTimeout;
        private int maxTryTime;
        private int minTryTime;
        private int readTimeout;
        private int timeLimit;
        private int tryInterval;

        public NetPolicy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.timeLimit = 480000;
            this.maxTryTime = 9;
            this.minTryTime = 3;
            this.connectTimeout = 20000;
            this.readTimeout = 40000;
            this.tryInterval = 5000;
        }

        public int getConnectTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.connectTimeout;
        }

        public int getMaxTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.maxTryTime;
        }

        public int getMinTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.minTryTime;
        }

        public int getReadTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.readTimeout;
        }

        public int getTimeLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.timeLimit;
        }

        public int getTryInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.tryInterval;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class WIFI extends NetPolicy {
        static IPatchRedirector $redirector_;
        private int connectTimeout;
        private int maxTryTime;
        private int minTryTime;
        private int readTimeout;
        private int timeLimit;
        private int tryInterval;

        public WIFI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.timeLimit = 360000;
            this.maxTryTime = 9;
            this.minTryTime = 3;
            this.connectTimeout = 10000;
            this.readTimeout = 20000;
            this.tryInterval = 3000;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getConnectTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.connectTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMaxTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.maxTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getMinTryTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.minTryTime;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getReadTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.readTimeout;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTimeLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.timeLimit;
        }

        @Override // com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy
        public int getTryInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.tryInterval;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TryCount_dpc = 18;
        FixSchedulTryCount_dpc = 6;
        TryTime_dpc = 600000;
        f293464g2 = new G2();
        f293465g3 = new G3();
        wifi = new WIFI();
    }

    public RichMediaStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getDelayTIme(int i3) {
        if (i3 == 0) {
            i3 = 1;
        }
        return (int) (6000 * Math.pow(2.0d, (i3 - 1) / 2));
    }

    public static synchronized int getFixSchedulTryCount_dpc() {
        int i3;
        synchronized (RichMediaStrategy.class) {
            i3 = FixSchedulTryCount_dpc;
        }
        return i3;
    }

    public static NetPolicy getPolicy(int i3) {
        NetPolicy netPolicy = f293464g2;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4 && i3 != 5) {
                    return netPolicy;
                }
            } else {
                return f293465g3;
            }
        }
        return wifi;
    }

    public static int getSleepTime(NetPolicy netPolicy, int i3, int i16, long j3, boolean z16, int i17) {
        boolean z17;
        int i18 = i16;
        int i19 = 0;
        if (!permitRetryWithErrorCode(i3) || (i18 >= netPolicy.getMinTryTime() && (i18 >= netPolicy.getMaxTryTime() || (!z16 ? j3 >= netPolicy.getTimeLimit() : i17 >= 3 || j3 >= netPolicy.getTimeLimit())))) {
            z17 = false;
        } else {
            z17 = true;
        }
        int tryInterval = netPolicy.getTryInterval();
        if (i18 == 0) {
            i18 = 1;
        }
        int pow = (int) (tryInterval * Math.pow(2.0d, (i18 - 1) / 2));
        if (isNetworkError(i3)) {
            i19 = pow;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "policy:" + netPolicy.getClass().getSimpleName() + " errCode:" + i3 + " tryCount:" + i18 + " elapse:" + j3 + "isGroup:" + z16 + " flowTimes:" + i17 + " canRetry:" + z17 + " sleeptime:" + i19);
        }
        if (z17) {
            return i19;
        }
        return -1;
    }

    public static synchronized int getTryCount_dpc() {
        int i3;
        synchronized (RichMediaStrategy.class) {
            i3 = TryCount_dpc;
        }
        return i3;
    }

    public static synchronized int getTryTime_dpc() {
        int i3;
        synchronized (RichMediaStrategy.class) {
            i3 = TryTime_dpc;
        }
        return i3;
    }

    public static boolean isNetworkError(int i3) {
        if (i3 != 9052 && i3 != 9050 && i3 != 9051 && i3 != 9054 && i3 != 9053 && i3 != 9055 && i3 != 9014 && i3 != 9047) {
            return false;
        }
        return true;
    }

    public static boolean noReportByErrorCode(int i3) {
        if (i3 != 9361 && i3 != 9037) {
            return false;
        }
        return true;
    }

    private static boolean permitRetryWithErrorCode(int i3) {
        if (i3 != 9020 && i3 != 9048 && i3 != 9042 && i3 != 9070 && i3 != 9036 && i3 != 9063 && i3 != 9071 && i3 != 9302 && i3 != 9072 && i3 != 9041 && i3 != 9040 && i3 != 9037) {
            return true;
        }
        return false;
    }

    public static boolean shouldChangeIp(int i3) {
        if (i3 != 9052 && i3 != 9050 && i3 != 9055 && i3 != 9053 && i3 != 9054 && i3 != 9014 && i3 != 9051 && i3 != 9047 && i3 != 9360) {
            return false;
        }
        return true;
    }

    public static boolean testMsgUrlDownRetryAndDoSleep(NetPolicy netPolicy, int i3, int i16, long j3, boolean z16, int i17) {
        boolean z17;
        int i18 = i16;
        int i19 = 0;
        if (!permitRetryWithErrorCode(i3) || i18 >= 2) {
            z17 = false;
        } else {
            z17 = true;
        }
        int tryInterval = netPolicy.getTryInterval();
        if (i18 == 0) {
            i18 = 1;
        }
        int pow = (int) (tryInterval * Math.pow(2.0d, (i18 - 1) / 2));
        if (isNetworkError(i3)) {
            i19 = pow;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "msgDown policy:" + netPolicy.getClass().getSimpleName() + " errCode:" + i3 + " tryCount:" + i18 + " elapse:" + j3 + "isGroup:" + z16 + " flowTimes:" + i17 + " canRetry:" + z17 + " sleeptime:" + i19);
        }
        if (z17 && i19 > 0) {
            try {
                LockMethodProxy.sleep(i19);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        return z17;
    }

    public static boolean testRetryAndDoSleep(NetPolicy netPolicy, int i3, int i16, long j3, boolean z16, int i17) {
        boolean z17;
        int i18 = i16;
        int i19 = 0;
        if (!permitRetryWithErrorCode(i3) || (i18 >= netPolicy.getMinTryTime() && (i18 >= netPolicy.getMaxTryTime() || (!z16 ? j3 >= netPolicy.getTimeLimit() : i17 >= 3 || j3 >= netPolicy.getTimeLimit())))) {
            z17 = false;
        } else {
            z17 = true;
        }
        int tryInterval = netPolicy.getTryInterval();
        if (i18 == 0) {
            i18 = 1;
        }
        int pow = (int) (tryInterval * Math.pow(2.0d, (i18 - 1) / 2));
        if (isNetworkError(i3)) {
            i19 = pow;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "policy:" + netPolicy.getClass().getSimpleName() + " errCode:" + i3 + " tryCount:" + i18 + " elapse:" + j3 + "isGroup:" + z16 + " flowTimes:" + i17 + " canRetry:" + z17 + " sleeptime:" + i19);
        }
        if (z17 && i19 > 0) {
            try {
                LockMethodProxy.sleep(i19);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        return z17;
    }

    public static synchronized void updataFromDpc(String str) {
        synchronized (RichMediaStrategy.class) {
            if (str != null) {
                if (str.length() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString = " + str);
                    }
                    String[] split = str.split("\\|");
                    if (split != null && split.length == 3) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                if (Integer.valueOf(split[i3]).intValue() <= 0) {
                                    return;
                                }
                            } catch (NumberFormatException e16) {
                                QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", e16);
                            }
                        }
                        TryCount_dpc = Integer.valueOf(split[0]).intValue();
                        FixSchedulTryCount_dpc = Integer.valueOf(split[1]).intValue();
                        TryTime_dpc = Integer.valueOf(split[2]).intValue() * 1000;
                        if (QLog.isColorLevel()) {
                            QLog.d("RichMediaStrategy", 2, "updataFromDpc: TryCount_dpc = " + TryCount_dpc + " FixSchedulTryCount_dpc = " + FixSchedulTryCount_dpc + " TryTime_dpc = " + TryTime_dpc);
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
            }
        }
    }
}
