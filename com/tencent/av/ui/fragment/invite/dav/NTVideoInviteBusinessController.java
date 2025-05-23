package com.tencent.av.ui.fragment.invite.dav;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTVideoInviteBusinessController {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<VideoInviteBaseFragment> f75693a;

    public NTVideoInviteBusinessController(VideoInviteBaseFragment videoInviteBaseFragment) {
        this.f75693a = new WeakReference<>(videoInviteBaseFragment);
    }

    private VideoInviteBaseFragment d() {
        WeakReference<VideoInviteBaseFragment> weakReference = this.f75693a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f75693a.get();
    }

    public void a() {
        VideoInviteBaseFragment d16 = d();
        if (d16 instanceof NTVideoInviteFullFragment) {
            ((NTVideoInviteFullFragment) d16).fi(false);
        }
    }

    public void b() {
        if (d() == null) {
            return;
        }
        n.e().f().F1 = true;
    }

    public int c() {
        if (d() == null) {
            return 0;
        }
        return d().f75717d0;
    }

    public boolean e() {
        if (d() == null) {
            return false;
        }
        return d().I;
    }

    public boolean f() {
        if (d() == null) {
            return false;
        }
        return d().f75715b0;
    }

    public int g() {
        if (d() == null) {
            return 0;
        }
        return d().L;
    }

    public String h() {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return "";
        }
        return d16.T;
    }

    public String i() {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return "";
        }
        return d16.S;
    }

    public SessionInfo j() {
        if (d() == null) {
            return null;
        }
        return d().G;
    }

    public void k(final long j3, boolean z16) {
        String str;
        final VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        d16.V.L1();
        zv.b.a().f453512l0 = SystemClock.elapsedRealtime();
        boolean Gh = d16.Gh();
        if (z16) {
            d16.H = true;
            if (Gh) {
                str = "0X8004207";
            } else {
                str = "0X80043F7";
            }
            o(str);
            p("0X800C443");
        } else if (!Gh) {
            if (d16.f75715b0) {
                o("0X80051FE");
            } else if (d16.I) {
                o("0X8004397");
            } else {
                o("0X80043F5");
            }
        } else if (d16.f75715b0) {
            o("0X80051FE");
        } else if (d16.I) {
            o("0X8004201");
        } else {
            o("0X8004205");
        }
        if (!Gh) {
            p("0X800C441");
        }
        QLog.i("NTVideoInviteBusinessController", 1, "AVAvatarRes. click ACCEPT2. mIsAvatarVideo: " + d16.J);
        if (d16.J) {
            if (AVAvatarResMgr.v().k()) {
                d16.wh(j3);
                return;
            } else {
                AVAvatarResMgr.v().F(new AVAvatarResMgr.c() { // from class: com.tencent.av.ui.fragment.invite.dav.NTVideoInviteBusinessController.1
                    @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                    public void onRequestFinish(final boolean z17) {
                        QLog.i("NTVideoInviteBusinessController", 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z17);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.ui.fragment.invite.dav.NTVideoInviteBusinessController.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z17) {
                                    VideoInviteBaseFragment videoInviteBaseFragment = d16;
                                    SessionInfo sessionInfo = videoInviteBaseFragment.G;
                                    if (sessionInfo != null) {
                                        sessionInfo.f73102y2 = false;
                                        QQToast.makeText(videoInviteBaseFragment.getContext(), R.string.f1786837b, 0).show();
                                        return;
                                    }
                                    return;
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                d16.wh(j3);
                            }
                        });
                    }
                }, 3000);
                return;
            }
        }
        d16.wh(j3);
    }

    public void l(long j3, String str) {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            d16.f75720g0 = true;
        }
        d16.Sh(j3, true);
        r.h0().A2(d16.M, d16.S, d16.T, d16.U, str, d16.f75720g0);
    }

    public void m(long j3) {
        String str;
        String str2;
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        d16.V.O1();
        d16.Sh(j3, true);
        if (d16.f75715b0) {
            o("0X80051FF");
        } else if (d16.I) {
            if (d16.C) {
                str2 = "0X8004202";
            } else {
                str2 = "0X8004398";
            }
            o(str2);
        } else {
            if (d16.C) {
                str = "0X8004206";
            } else {
                str = "0X80043F6";
            }
            o(str);
        }
        p("0X800C442");
    }

    public void n() {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        d16.Mh();
    }

    protected void o(String str) {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        ReportController.o(null, "CliOper", "", "", str, str, 0, 0, Integer.toString(d16.L), Integer.toString(d16.f75716c0), Integer.toString(d16.f75717d0), "");
    }

    protected void p(String str) {
        VideoInviteBaseFragment d16 = d();
        if (d16 != null && d16.J && ax.a.c(d16.E)) {
            ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    public void q(int i3) {
        VideoInviteBaseFragment d16 = d();
        if (d16 == null) {
            return;
        }
        d16.f75717d0 = i3;
    }
}
