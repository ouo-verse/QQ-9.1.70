package com.tencent.av.ui.part.base.panel;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.m;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class AVChatTimePart extends e {
    private boolean C;
    private StartTimerRunnable D;
    int E;
    int F;

    /* renamed from: h, reason: collision with root package name */
    private int f76313h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76314i;

    /* renamed from: m, reason: collision with root package name */
    private TimmerRunnable f76315m;

    /* loaded from: classes32.dex */
    class StartTimerRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f76316d;

        StartTimerRunnable() {
        }

        void a(long j3) {
            this.f76316d = j3;
            AVChatTimePart.this.getMainHandler().postDelayed(AVChatTimePart.this.D, 5000L);
            AVChatTimePart.this.C = true;
        }

        void b(long j3) {
            if (QLog.isColorLevel()) {
                QLog.w(AVChatTimePart.this.f76368d, 1, "StartTimerRunnable.remove, mNeedRemoveAudioCallback[" + AVChatTimePart.this.C + "], seq[" + j3 + "], lastseq[" + this.f76316d + "]");
            }
            if (AVChatTimePart.this.C) {
                AVChatTimePart.this.getMainHandler().removeCallbacks(AVChatTimePart.this.D);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.w(AVChatTimePart.this.f76368d, 1, "StartTimerRunnable.Run, seq[" + this.f76316d + "]");
            }
            AVChatTimePart.this.O9(this.f76316d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class TimmerRunnable implements Runnable {
        TimmerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() == null || !AVChatTimePart.this.f76314i) {
                return;
            }
            String formatTime = ba.formatTime(r.h0().K());
            AVChatTimePart.this.f76313h++;
            AVChatTimePart.this.N9(formatTime);
            AVChatTimePart.this.getMainHandler().postDelayed(this, 1000L);
        }
    }

    public AVChatTimePart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76313h = 0;
        this.f76314i = false;
        this.f76315m = null;
        this.C = false;
        this.D = new StartTimerRunnable();
        this.E = 0;
        this.F = 0;
    }

    private boolean K9() {
        if (r.h0() == null) {
            return false;
        }
        int i3 = n.e().f().f73035i;
        return i3 == 4 || i3 == 2;
    }

    public boolean I9() {
        int i3 = this.f76313h;
        if (i3 - this.F > 2) {
            this.F = i3;
            this.E = 0;
        }
        int i16 = this.E + 1;
        this.E = i16;
        if (i16 <= 5) {
            return false;
        }
        this.E = 0;
        this.F = 0;
        return true;
    }

    public boolean J9() {
        if (r.h0() != null && (getPartHost() instanceof NTBaseVideoFragment)) {
            return ((NTBaseVideoFragment) getPartHost()).bi();
        }
        return false;
    }

    public void L9(long j3) {
        if (r.h0() == null || this.D == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        String str = f16.f73091w;
        int t06 = r.h0().t0(str);
        int s06 = r.h0().s0(str);
        if (t06 == 5) {
            if (f16.f73101y1) {
                O9(j3);
                return;
            } else {
                this.D.a(j3);
                return;
            }
        }
        if (!r.h0().i1()) {
            if (f16.f73101y1) {
                O9(j3);
                return;
            } else {
                this.D.a(j3);
                return;
            }
        }
        if (!f16.z()) {
            this.D.a(j3);
            return;
        }
        if (s06 > 18) {
            if (f16.f73101y1 && f16.f73105z1) {
                O9(j3);
                return;
            } else {
                this.D.a(j3);
                return;
            }
        }
        if (f16.f73101y1) {
            O9(j3);
        } else {
            this.D.a(j3);
        }
    }

    public void M9(long j3) {
        this.D.b(j3);
        if (r.h0() == null || n.e().f().f73076s0 == 1) {
            return;
        }
        O9(j3);
    }

    public void N9(String str) {
        if (this.f76370f == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f76368d, 1, "setChatTime, time[" + str + "]");
        }
        TextView textView = (TextView) this.f76370f.h1(m.l.f76077w);
        TextView textView2 = (TextView) this.f76370f.h1(m.l.f76078x);
        Q9();
        if (textView == null || textView2 == null) {
            return;
        }
        textView.setText(str);
        textView2.setText(str);
        if (ba.f77071e) {
            if (TextUtils.isEmpty(str)) {
                ba.setAccText(textView, "");
                ba.setAccText(textView2, "");
            } else {
                String timeDesc = ba.getTimeDesc(str);
                ba.setAccText(textView, timeDesc);
                ba.setAccText(textView2, timeDesc);
            }
        }
    }

    public void O9(long j3) {
        ((mw.f) RFWIocAbilityProvider.g().getIocInterface(mw.f.class, getPartRootView(), null)).c2(j3, 0);
        if (this.f76314i || r.h0() == null) {
            return;
        }
        if (!VideoLayerUIBase.O0(n.e().f()) || J9()) {
            if (QLog.isColorLevel()) {
                QLog.w(this.f76368d, 1, "startTimer, seq[" + j3 + "]");
            }
            this.f76314i = true;
            if (this.f76315m == null) {
                this.f76315m = new TimmerRunnable();
            }
            getMainHandler().postDelayed(this.f76315m, 0L);
        }
    }

    public void P9(long j3) {
        if (this.f76314i) {
            if (QLog.isColorLevel()) {
                QLog.w(this.f76368d, 1, "stopTimer, seq[" + j3 + "]");
            }
            this.f76314i = false;
            if (this.f76315m != null) {
                getMainHandler().removeCallbacks(this.f76315m);
                this.f76315m = null;
            }
            N9(null);
        }
    }

    public void Q9() {
        if (this.f76370f == null) {
            QLog.d(this.f76368d, 1, "updateChatTimeMutexStatus error : mQavPanel is null");
            return;
        }
        boolean K9 = K9();
        TextView textView = (TextView) this.f76370f.h1(m.l.f76077w);
        TextView textView2 = (TextView) this.f76370f.h1(m.l.f76078x);
        if (textView == null || textView2 == null) {
            return;
        }
        if (K9) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
        } else {
            textView.setVisibility(0);
            textView2.setVisibility(8);
        }
    }

    @Override // com.tencent.av.ui.part.base.panel.e
    public void onDestroy() {
        super.onDestroy();
        P9(com.tencent.av.utils.e.d());
        getMainHandler().removeCallbacks(this.f76315m);
        this.f76313h = 0;
        this.D.b(com.tencent.av.utils.e.d());
        this.D = null;
    }
}
