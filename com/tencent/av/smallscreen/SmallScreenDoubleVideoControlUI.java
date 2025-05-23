package com.tencent.av.smallscreen;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenDoubleVideoControlUI extends SmallScreenVideoControlUI {
    boolean K;
    Runnable L;

    public SmallScreenDoubleVideoControlUI(VideoAppInterface videoAppInterface, SmallScreenService smallScreenService, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, smallScreenService, controlUIObserver);
        this.K = false;
        this.L = new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenDoubleVideoControlUI", 2, "2s has past, startTimer now!");
                }
                SmallScreenDoubleVideoControlUI.this.x();
            }
        };
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void d() {
        super.d();
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(R.string.djz);
        }
        String str = n.e().f().f73091w;
        int t06 = r.h0().t0(str);
        int s06 = r.h0().s0(str);
        if (t06 == 5) {
            if (n.e().f().f73101y1) {
                x();
                return;
            } else {
                this.E.M().postDelayed(this.L, 5000L);
                this.K = true;
                return;
            }
        }
        if (!r.h0().i1()) {
            if (n.e().f().f73101y1) {
                x();
                return;
            } else {
                this.E.M().postDelayed(this.L, 5000L);
                this.K = true;
                return;
            }
        }
        if (!n.e().f().z()) {
            this.E.M().postDelayed(this.L, 5000L);
            this.K = true;
            return;
        }
        if (s06 > 18) {
            if (n.e().f().f73101y1 && n.e().f().f73105z1) {
                x();
                return;
            } else {
                this.E.M().postDelayed(this.L, 5000L);
                this.K = true;
                return;
            }
        }
        if (n.e().f().f73101y1) {
            x();
        } else {
            this.E.M().postDelayed(this.L, 5000L);
            this.K = true;
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void e(boolean z16) {
        TextView textView;
        int i3;
        super.e(z16);
        SessionInfo f16 = n.e().f();
        final long d16 = com.tencent.av.utils.e.d();
        if (f16.A()) {
            int i16 = f16.M0 ? R.string.db6 : R.string.iel;
            TextView textView2 = this.G;
            if (textView2 != null) {
                textView2.setText(i16);
                return;
            }
            return;
        }
        boolean K = f16.K();
        int i17 = R.string.dmu;
        if (K) {
            boolean z17 = f16.f73081t1;
            int i18 = R.string.djz;
            if (z17) {
                i17 = R.string.djz;
            }
            if (f16.f73067q != 1011) {
                i18 = i17;
            }
            TextView textView3 = this.G;
            if (textView3 != null) {
                textView3.setText(i18);
                return;
            }
            return;
        }
        if (f16.u()) {
            if (f16.f73035i != 0 || !f16.G || ((i3 = f16.f73039j) != 1 && i3 != 2)) {
                i17 = R.string.dfx;
            }
            TextView textView4 = this.G;
            if (textView4 != null) {
                textView4.setText(i17);
                return;
            }
            return;
        }
        if (f16.w() || f16.x()) {
            if (f16.f73067q == 1011 && (textView = this.G) != null) {
                textView.setText(R.string.dke);
            }
            this.E.M().postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
                @Override // java.lang.Runnable
                public void run() {
                    if (r.h0() != null) {
                        SmallScreenDoubleVideoControlUI smallScreenDoubleVideoControlUI = SmallScreenDoubleVideoControlUI.this;
                        if (smallScreenDoubleVideoControlUI.J || smallScreenDoubleVideoControlUI.E == null) {
                            return;
                        }
                        SessionInfo f17 = n.e().f();
                        r.h0().r(f17.f73091w, 225);
                        r.h0().j2(225);
                        r.h0().q(f17.f73091w, 9);
                        SmallScreenDoubleVideoControlUI.this.E.k0(new Object[]{28, f17.f73091w, Boolean.TRUE});
                        QLog.w("SmallScreenDoubleVideoControlUI", 1, "exit when onCreate fail, seq[" + d16 + "]");
                        SmallScreenDoubleVideoControlUI.this.E.u(d16, 1008);
                    }
                }
            }, 150L);
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void f(long j3) {
        VideoAppInterface videoAppInterface;
        if (this.K && (videoAppInterface = this.E) != null) {
            videoAppInterface.M().removeCallbacks(this.L);
        }
        super.f(j3);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void h(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + n.e().f().f73008c0 + " # remoteTerminal = " + n.e().f().Q + " # phoneOnLine = " + n.e().f().f73000a0 + " # pcOnLine = " + n.e().f().Z + " # subState = " + n.e().f().f73076s0 + " # isPeerNetworkWell = " + n.e().f().V);
        }
        if (r.h0() == null || this.J || !n.e().f().K() || n.e().f().f73081t1 || n.e().f().f73067q == 1011 || !n.e().f().f73091w.contains(str) || n.e().f().f73008c0 < 0 || this.G == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.G.setText(R.string.dmu);
        } else {
            this.G.setText(str2);
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void i(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenDoubleVideoControlUI", 2, "onNotRecvAudioData bNotRecv = " + z16);
        }
        if (z16) {
            return;
        }
        if (this.K) {
            this.E.M().removeCallbacks(this.L);
        }
        if (n.e().f().f73076s0 != 1) {
            x();
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void j() {
        String str = n.e().f().f73091w;
        int t06 = r.h0().t0(str);
        int s06 = r.h0().s0(str);
        if (t06 == 5 || t06 == 0 || !r.h0().i1() || !n.e().f().z() || s06 <= 18 || !n.e().f().f73101y1) {
            return;
        }
        if (this.K) {
            this.E.M().removeCallbacks(this.L);
        }
        x();
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void m(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + z16);
        }
        DoodleLogic b16 = DoodleLogic.b();
        if (z16) {
            b16.f73593l = false;
            b16.f73594m = 0;
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenDoubleVideoControlUI", 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + b16.f73594m + ", mIsPeerSupport = " + b16.f73593l);
            }
            SmallScreenUtils.m();
            this.E.k0(new Object[]{127});
            return;
        }
        b16.k();
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void o() {
        super.o();
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
        }
        if (r.h0() != null && !this.J && n.e().f().z() && n.e().f().f73076s0 != 1) {
            x();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + currentTimeMillis2);
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void q() {
        String str = n.e().f().f73091w;
        int t06 = r.h0().t0(str);
        int s06 = r.h0().s0(str);
        if (t06 != 5 && t06 != 0) {
            if (!r.h0().i1()) {
                if (this.K) {
                    this.E.M().removeCallbacks(this.L);
                }
                if (n.e().f().f73076s0 != 1) {
                    x();
                    return;
                }
                return;
            }
            if (n.e().f().z()) {
                if (s06 > 18) {
                    if (n.e().f().f73105z1) {
                        if (this.K) {
                            this.E.M().removeCallbacks(this.L);
                        }
                        if (n.e().f().f73076s0 != 1) {
                            x();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.K) {
                    this.E.M().removeCallbacks(this.L);
                }
                if (n.e().f().f73076s0 != 1) {
                    x();
                    return;
                }
                return;
            }
            return;
        }
        if (this.K) {
            this.E.M().removeCallbacks(this.L);
        }
        if (n.e().f().f73076s0 != 1) {
            x();
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void r() {
        super.r();
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + currentTimeMillis);
        }
        if (r.h0() != null && !this.J && n.e().f().K() && n.e().f().f73008c0 >= 0 && this.G != null) {
            if (n.e().f().f73067q == 1011) {
                this.G.setText(R.string.djz);
            } else {
                this.G.setText(R.string.dmu);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onStart(), ts=" + currentTimeMillis2);
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    protected void t(int i3) {
        TextView textView;
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<setInvitingState(), resId =" + i3);
        }
        if ((n.e().f().f73067q != 1011 || i3 == R.string.djz || i3 == R.string.icq) && (textView = this.G) != null && i3 > 0) {
            textView.setText(i3);
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void n(boolean z16, boolean z17) {
        if (z16 || r.h0() == null || this.J) {
            return;
        }
        String str = n.e().f().f73091w;
        if (z17) {
            if (n.e().f().K) {
                return;
            }
            r.h0().I2(true, str);
        } else {
            if (n.e().f().K) {
                return;
            }
            r.h0().I2(false, str);
        }
    }
}
