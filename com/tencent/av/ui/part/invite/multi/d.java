package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends Part {

    /* renamed from: d, reason: collision with root package name */
    private QAVNotification f76538d;

    /* renamed from: e, reason: collision with root package name */
    private String f76539e;

    /* renamed from: f, reason: collision with root package name */
    private SessionInfo f76540f;

    public d(SessionInfo sessionInfo) {
        this.f76540f = sessionInfo;
    }

    public void A9(int i3, long j3, int i16, long j16, String str, String str2, String str3, boolean z16, boolean z17) {
        QLog.d("GaNotificationPart", 1, DKHippyEvent.EVENT_STOP);
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        x9(i3, j3, i16, j16, str, str2, str3, z16, z17);
        VideoAppInterface b16 = nw.b.b();
        if (b16 != null) {
            b16.v0(true, null);
        }
    }

    public void onDestroy() {
        String str;
        if (this.f76538d != null) {
            SessionInfo f16 = n.e().f();
            SessionInfo sessionInfo = this.f76540f;
            if (sessionInfo != f16) {
                this.f76538d.f(sessionInfo.f73030h);
            }
            if (f16 != null) {
                this.f76538d.u(f16.f73030h);
            }
            if (f16 != null && (str = f16.f73030h) != null && !str.equals(this.f76539e)) {
                this.f76538d.f(this.f76539e);
            }
            this.f76538d = null;
            if (QLog.isColorLevel()) {
                QLog.i("GaNotificationPart", 2, "onDestroy main[" + f16 + "], cur[" + this.f76540f + "], id[" + this.f76539e + "]");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        this.f76540f = null;
    }

    void x9(int i3, long j3, int i16, long j16, String str, String str2, String str3, boolean z16, boolean z17) {
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            return;
        }
        if (this.f76538d == null) {
            this.f76538d = QAVNotification.l(b16);
        }
        if (NTGaInviteBaseFragment.xh(i3)) {
            if (this.f76540f != null) {
                String valueOf = String.valueOf(j3);
                Bitmap J = b16.J(i3, valueOf, null, true, true);
                this.f76538d.c(this.f76540f.f73030h, b16.G(AVUtil.f(i16), Long.toString(j16), valueOf), J, valueOf, 57, i3, 3);
                return;
            }
            return;
        }
        Bitmap J2 = b16.J(i3, str, str2, true, true);
        if (!z16 && !z17) {
            this.f76538d.c(this.f76540f.f73030h, str3, J2, null, 56, i3, 2);
        } else {
            this.f76538d.c(this.f76540f.f73030h, str3, J2, null, 55, i3, 1);
        }
    }

    public void z9() {
        QAVNotification qAVNotification = this.f76538d;
        if (qAVNotification != null) {
            qAVNotification.f(this.f76540f.f73030h);
        }
    }

    public void onStart() {
        QLog.d("GaNotificationPart", 1, "onStart");
        VideoAppInterface b16 = nw.b.b();
        if (this.f76540f == null || b16 == null) {
            return;
        }
        if (this.f76538d == null) {
            this.f76538d = QAVNotification.l(b16);
        }
        this.f76538d.f(this.f76540f.f73030h);
        SessionInfo f16 = n.e().f();
        if (f16 == null || this.f76540f.f73030h.equals(f16.f73030h)) {
            return;
        }
        b16.v0(false, null);
        this.f76538d.m(f16.f73030h);
        this.f76539e = f16.f73030h;
    }
}
