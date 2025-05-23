package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.QAVNotification;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends Part implements mw.g {

    /* renamed from: d, reason: collision with root package name */
    QAVNotification f76265d = null;

    public void A9() {
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.i("AVNotificationPart", 2, "showNotification inMeetingRoom[" + f16.f73064p0 + "]");
        }
        if (!f16.f73064p0 || n.e().m()) {
            return;
        }
        this.f76265d.c(f16.f73030h, f16.f73099y, nw.b.b().J(0, f16.f73091w, null, true, true), String.valueOf(f16.P0), 48, 0, f16.f73035i);
        r.h0().w3();
    }

    @Override // mw.g
    public void l5(String str, String str2, Bitmap bitmap, String str3, int i3, int i16, int i17) {
        QAVNotification qAVNotification = this.f76265d;
        if (qAVNotification != null) {
            qAVNotification.c(str, str2, bitmap, str3, i3, i16, i17);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76265d = QAVNotification.l(nw.b.b());
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.g.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.g.class);
    }

    public void x9() {
        if (r.h0() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVNotificationPart", 2, "cancelNotification");
        }
        QAVNotification qAVNotification = this.f76265d;
        if (qAVNotification != null) {
            qAVNotification.f(n.e().f().f73030h);
        }
        r.h0().A3();
    }

    public void z9() {
        Bitmap bitmap;
        String str;
        int i3;
        String G;
        Bitmap J;
        if (r.h0() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVNotificationPart", 2, "showNotification inRoom[" + r.h0().W0() + "]");
        }
        if (r.h0().W0()) {
            VideoAppInterface b16 = nw.b.b();
            int i16 = n.e().f().f73067q;
            if (this.f76265d != null) {
                SessionInfo f16 = n.e().f();
                String valueOf = String.valueOf(f16.P0);
                String G2 = b16.G(i16, valueOf, null);
                Bitmap J2 = b16.J(i16, valueOf, null, true, true);
                if (f16.f73063p == 17) {
                    if (!TextUtils.isEmpty(f16.Y0)) {
                        G = b16.G(0, f16.Y0, null);
                        J = b16.J(0, f16.Y0, null, true, true);
                    } else {
                        G = b16.G(0, b16.getCurrentAccountUin(), null);
                        J = b16.J(0, b16.getCurrentAccountUin(), null, true, true);
                    }
                    bitmap = J;
                    str = G;
                } else {
                    bitmap = J2;
                    str = G2;
                }
                if (f16.N()) {
                    i3 = f16.f73035i == 3 ? 62 : 63;
                } else {
                    i3 = 44;
                }
                this.f76265d.c(n.e().f().f73030h, str, bitmap, valueOf, i3, i16, n.e().f().f73035i);
            }
            r.h0().w3();
        }
    }
}
