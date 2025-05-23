package com.tencent.adelie.av.ui;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.av.utils.e;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVChatStatusManager {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f61386k = false;

    /* renamed from: l, reason: collision with root package name */
    private static long f61387l = 5000;

    /* renamed from: m, reason: collision with root package name */
    private static long f61388m = 3000;

    /* renamed from: n, reason: collision with root package name */
    private static int[] f61389n = {2, 1};

    /* renamed from: o, reason: collision with root package name */
    private static int[] f61390o = {10000, 60000};

    /* renamed from: p, reason: collision with root package name */
    private static int f61391p = 3000;

    /* renamed from: q, reason: collision with root package name */
    private static long f61392q = 0;

    /* renamed from: b, reason: collision with root package name */
    private AdelieAVStatusTipsCtrl f61394b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f61395c;

    /* renamed from: d, reason: collision with root package name */
    private b f61396d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Runnable> f61397e;

    /* renamed from: g, reason: collision with root package name */
    private CountDownTimer f61399g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f61400h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f61401i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f61402j;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f61398f = null;

    /* renamed from: a, reason: collision with root package name */
    private long f61393a = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getLongAccountUin();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class ChatStatusTimeoutRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f61405d;

        public ChatStatusTimeoutRunnable(int i3) {
            this.f61405d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("AdelieAVChatStatusManager", 1, "[ChatStatusTimeoutRunnable] run : " + this.f61405d);
            int i3 = this.f61405d;
            if (i3 == 2) {
                AdelieAVChatStatusManager.this.t(3);
                AdelieAVChatStatusManager adelieAVChatStatusManager = AdelieAVChatStatusManager.this;
                adelieAVChatStatusManager.f61398f = new ChatStatusTimeoutRunnable(3);
                ThreadManagerV2.getUIHandlerV2().postDelayed(AdelieAVChatStatusManager.this.f61398f, AdelieAVChatStatusManager.f61391p);
                return;
            }
            if (i3 == 1) {
                AdelieAVChatStatusManager.this.t(2);
            } else if (i3 == 3) {
                AdelieAVChatStatusManager.this.t(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void onChange(int i3);
    }

    public AdelieAVChatStatusManager(Activity activity, boolean z16, View.OnClickListener onClickListener, b bVar) {
        this.f61395c = true;
        this.f61399g = null;
        this.f61400h = null;
        this.f61401i = null;
        this.f61402j = null;
        this.f61395c = z16;
        if (activity != null) {
            AdelieAVStatusTipsCtrl adelieAVStatusTipsCtrl = new AdelieAVStatusTipsCtrl(activity);
            this.f61394b = adelieAVStatusTipsCtrl;
            adelieAVStatusTipsCtrl.i(onClickListener);
            up.a o16 = o();
            this.f61394b.o(this.f61395c, o16 != null ? o16.f439402u : -1);
            if (o16 != null && o16.f439403v) {
                this.f61394b.k(true);
            }
        }
        this.f61396d = bVar;
        this.f61397e = new HashMap();
        for (int i3 : f61389n) {
            this.f61397e.put(Integer.valueOf(i3), new ChatStatusTimeoutRunnable(i3));
        }
        this.f61400h = new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVChatStatusManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean J = AdelieAVController.J();
                QLog.d("AdelieAVChatStatusManager", 1, "run [mHelloStatusTimeoutRunnable]. isControllerInit=" + J);
                if (J) {
                    AdelieAVChatStatusManager.f61392q = 0L;
                    AdelieAVChatStatusManager.this.t(0);
                    up.a o17 = AdelieAVChatStatusManager.this.o();
                    if (o17 == null || o17.f439393l) {
                        return;
                    }
                    AdelieAVController.D().y(true);
                }
            }
        };
        this.f61399g = new a(r9 * 20, AdelieAVController.L);
        this.f61402j = new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVChatStatusManager.3
            @Override // java.lang.Runnable
            public void run() {
                boolean J = AdelieAVController.J();
                QLog.d("AdelieAVChatStatusManager", 1, "InterruptTimeoutRunnable isInit=" + J);
                if (J) {
                    up.a o17 = AdelieAVChatStatusManager.this.o();
                    if (o17 != null) {
                        o17.f439403v = true;
                    }
                    if (AdelieAVChatStatusManager.this.f61394b != null) {
                        AdelieAVChatStatusManager.this.f61394b.k(true);
                    }
                }
            }
        };
        if (p()) {
            long currentTimeMillis = f61388m - (System.currentTimeMillis() - f61392q);
            Runnable runnable = this.f61400h;
            if (runnable != null) {
                this.f61401i = ThreadManagerV2.executeDelay(runnable, 16, null, false, currentTimeMillis);
            }
            QLog.d("AdelieAVChatStatusManager", 1, "init waitFor Hello delay=" + currentTimeMillis);
        }
    }

    public static int l(int i3) {
        if (i3 > 0 && i3 < 20) {
            return 1;
        }
        if (i3 > 19 && i3 < 30) {
            return 1;
        }
        if (i3 > 29 && i3 < 40) {
            if (32 == i3) {
                return 3;
            }
            return 2;
        }
        if (i3 > 49 && i3 <= 59) {
            return 4;
        }
        return 0;
    }

    private int m() {
        up.a o16 = o();
        if (o16 != null) {
            return o16.f439402u;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public up.a o() {
        if (AdelieAVController.J()) {
            return AdelieAVController.D().E();
        }
        return null;
    }

    private boolean p() {
        if (f61392q <= 0) {
            return false;
        }
        if (System.currentTimeMillis() - f61392q < f61388m) {
            return true;
        }
        f61392q = 0L;
        return false;
    }

    public void k(boolean z16) {
        this.f61395c = z16;
        AdelieAVStatusTipsCtrl adelieAVStatusTipsCtrl = this.f61394b;
        if (adelieAVStatusTipsCtrl != null) {
            adelieAVStatusTipsCtrl.o(z16, m());
        }
    }

    public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
        int m3 = m();
        QLog.d("AdelieAVChatStatusManager", 1, "onUserSpeaking uin=" + qavDef$MultiUserInfo.mUin + " isSpeaking=" + z16 + " chatStatus=" + m3 + " audioEnergy=" + i3);
        if (qavDef$MultiUserInfo.mUin == this.f61393a) {
            if (z16 && m3 == 0) {
                t(1);
                return;
            }
            return;
        }
        if (z16) {
            t(3);
        } else if (m3 == 3) {
            t(1);
        }
    }

    public void s() {
        QLog.d("AdelieAVChatStatusManager", 1, "release sStartHelloStatusTimeoutMs=" + f61392q);
        AdelieAVStatusTipsCtrl adelieAVStatusTipsCtrl = this.f61394b;
        if (adelieAVStatusTipsCtrl != null) {
            adelieAVStatusTipsCtrl.i(null);
            this.f61394b.h();
            this.f61394b = null;
        }
        CountDownTimer countDownTimer = this.f61399g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f61399g = null;
        }
        this.f61396d = null;
        for (int i3 : f61389n) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f61397e.get(Integer.valueOf(i3)));
        }
        this.f61397e.clear();
        this.f61398f = null;
        if (f61392q > 0 && System.currentTimeMillis() - f61392q > f61388m) {
            f61392q = 0L;
        }
        Runnable runnable = this.f61401i;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.f61401i = null;
        }
        this.f61400h = null;
        Runnable runnable2 = this.f61402j;
        if (runnable2 != null) {
            ThreadManagerV2.removeJob(runnable2, 16);
            this.f61402j = null;
        }
    }

    public void t(final int i3) {
        if (AdelieAVController.J()) {
            if (i3 == 3 && this.f61398f != null) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f61398f);
                this.f61398f = null;
                QLog.d("AdelieAVChatStatusManager", 1, "remove listen timeout runnable");
            }
            if (f61392q > 0 && i3 != -1) {
                ThreadManagerV2.removeJob(this.f61400h, 16);
            }
            final up.a o16 = o();
            if (o16 != null && o16.f439402u != i3) {
                QLog.d("AdelieAVChatStatusManager", 1, "updateChatStatusUI chatStatus", new Throwable());
                if (i3 == 0 || i3 == 1) {
                    AdelieAVController.D().V((int) e.d(), 20);
                    CountDownTimer countDownTimer = this.f61399g;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                } else if (i3 == 3) {
                    AdelieAVController.D().V((int) e.d(), 32);
                    CountDownTimer countDownTimer2 = this.f61399g;
                    if (countDownTimer2 != null) {
                        countDownTimer2.start();
                    }
                } else {
                    CountDownTimer countDownTimer3 = this.f61399g;
                    if (countDownTimer3 != null) {
                        countDownTimer3.cancel();
                    }
                }
                if (i3 != 2 && i3 != 3) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f61402j);
                } else {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this.f61402j, f61387l);
                }
                o16.f439402u = i3;
                u(i3);
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVChatStatusManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16;
                        QLog.d("AdelieAVChatStatusManager", 1, "updateChatStatusUI chatStatus=" + i3 + " mLocalMute=" + o16.f439392k + " sHasShowStartSpeakTips=" + AdelieAVChatStatusManager.f61386k);
                        up.a aVar = o16;
                        if (aVar.f439403v && (i16 = i3) != 2 && i16 != 3) {
                            aVar.f439403v = false;
                            if (AdelieAVChatStatusManager.this.f61394b != null) {
                                AdelieAVChatStatusManager.this.f61394b.k(false);
                            }
                        }
                        if (AdelieAVChatStatusManager.this.f61394b != null) {
                            int i17 = i3;
                            if (!AdelieAVChatStatusManager.f61386k) {
                                int i18 = i3 != 1 ? i17 : 0;
                                if (i18 == 0) {
                                    AdelieAVChatStatusManager.f61386k = true;
                                }
                                i17 = i18;
                            } else if (i3 == 0) {
                                i17 = 1;
                            }
                            QLog.d("AdelieAVChatStatusManager", 1, "updateChatStatusUI finalStatus=" + i17);
                            AdelieAVChatStatusManager.this.f61394b.o(AdelieAVChatStatusManager.this.f61395c, i17);
                        }
                        if (AdelieAVChatStatusManager.this.f61396d != null) {
                            AdelieAVChatStatusManager.this.f61396d.onChange(i3);
                        }
                    }
                });
                return;
            }
            QLog.d("AdelieAVChatStatusManager", 1, "same status: " + i3);
        }
    }

    private void u(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = f61389n;
            if (i16 >= iArr.length) {
                return;
            }
            if (i3 == iArr[i16]) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.f61397e.get(Integer.valueOf(i3)), f61390o[i16]);
                QLog.d("AdelieAVChatStatusManager", 1, "post runnable status:" + i3 + " timeout:" + f61390o[i16]);
            } else {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f61397e.get(Integer.valueOf(f61389n[i16])));
                QLog.d("AdelieAVChatStatusManager", 1, "remove runnable status:" + f61389n[i16] + " timeout:" + f61390o[i16]);
            }
            i16++;
        }
    }

    public void q() {
        f61386k = false;
        f61392q = System.currentTimeMillis();
        Runnable runnable = this.f61400h;
        if (runnable != null) {
            this.f61401i = ThreadManagerV2.executeDelay(runnable, 16, null, false, f61388m);
        }
    }

    public static String n(int i3) {
        if (i3 == 1) {
            return "\u7528\u6237\u8fde\u63a5\u6210\u529f";
        }
        if (i3 >= 10 && i3 < 20) {
            return "\u7528\u6237\u53ef\u4ee5\u8bb2\u8bdd";
        }
        if (i3 > 19 && i3 < 30) {
            return "\u7528\u6237\u6b63\u5728\u8bb2\u8bdd";
        }
        if (i3 <= 29 || i3 >= 40) {
            if (i3 > 39 && i3 < 50) {
                return "\u7528\u6237\u5f3a\u5236\u6253\u65ad";
            }
            if (i3 > 49 && i3 < 59) {
                return "\u540e\u53f0\u5f02\u5e38";
            }
            return "\u72b6\u6001\u672a\u5b9a\u4e49-" + i3;
        }
        if (30 == i3) {
            return "\u7528\u6237\u4e0d\u80fd\u8bb2\u8bdd-\u540e\u53f0\u901a\u77e5\u8bc6\u522b\u5230\u65ad\u53e5";
        }
        if (31 == i3) {
            return "\u7528\u6237\u4e0d\u80fd\u8bb2\u8bdd-\u6a21\u578b\u751f\u6210\u4e2d";
        }
        if (32 == i3) {
            return "\u7528\u6237\u4e0d\u80fd\u8bb2\u8bdd-\u58f0\u97f3\u64ad\u653e\u4e2d";
        }
        return "\u7528\u6237\u4e0d\u80fd\u8bb2\u8bdd-" + i3;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends CountDownTimer {
        a(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            up.a o16;
            boolean J = AdelieAVController.J();
            QLog.d("AdelieAVChatStatusManager", 1, "SyncListenStatusTimer isInit=" + J);
            if (J && (o16 = AdelieAVChatStatusManager.this.o()) != null && o16.f439402u == 3) {
                AdelieAVController.D().V((int) e.d(), 32);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }
    }
}
