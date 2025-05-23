package com.tencent.av.ui.part.base.panel;

import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends e {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f76371h;

    public f(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3) {
        rw.a x95 = x9(m.e.f76030q, j3);
        if (x95 != null && x95.f()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            boolean e16 = vu.a.e(peekAppRuntime, "KEY_SHARE_MIRROR_SWITCH_IS_OPEN", false);
            f76371h = e16;
            vu.a.o(peekAppRuntime, "KEY_SHARE_MIRROR_SWITCH_IS_OPEN", !e16);
            f76371h = !f76371h;
            D9();
        }
        E9(j3);
    }

    public void D9() {
        cw.e.g(nw.b.b(), f76371h ? 1077 : 1078, 3000L);
    }

    public void E9(long j3) {
        String str;
        f76371h = vu.a.e(MobileQQ.sMobileQQ.peekAppRuntime(), "KEY_SHARE_MIRROR_SWITCH_IS_OPEN", false);
        if (r.h0() == null || this.f76370f == null) {
            return;
        }
        int i3 = 8;
        if (!n.e().f().N) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_ShareMirror, !localHasVideo, seq[" + j3 + "]");
            }
        } else if (((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isFilterProcessRenderUseSurface() && ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isFilterProcessPostRenderUserShader()) {
            i3 = 0;
        } else if (com.tencent.av.utils.e.j()) {
            QLog.w(this.f76368d, 1, "updateBtn_ShareMirror,pull config failed, seq[" + j3 + "]");
        }
        rw.a M = this.f76370f.M(m.e.f76030q);
        if (M != null) {
            M.n(i3 == 0);
            if (f76371h) {
                M.l(R.drawable.n6i);
            } else {
                M.l(R.drawable.n6h);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5bf9\u65b9\u770b\u6211\u955c\u50cf ");
            if (f76371h) {
                str = "\u5df2\u5f00\u542f";
            } else {
                str = "\u5df2\u5173\u95ed";
            }
            sb5.append(str);
            M.j(sb5.toString());
            this.f76370f.E0();
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "updateBtn_ShareMirror, show[" + i3 + "], seq[" + j3 + "]");
        }
    }
}
