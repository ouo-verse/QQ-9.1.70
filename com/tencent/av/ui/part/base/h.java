package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.DataReport;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mw.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    cw.a f76298e;

    /* renamed from: f, reason: collision with root package name */
    private k f76299f;

    /* renamed from: h, reason: collision with root package name */
    protected WeakReference<VideoAppInterface> f76300h;

    /* renamed from: i, reason: collision with root package name */
    private c f76301i;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QLog.d("AVTipsPart", 1, "onClick com.tencent.mobileqq.R.id.qav_btn_accept_video");
            if (h.this.f76299f != null) {
                h.this.f76299f.i();
            }
            n.e().f().C1 = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.getActivity().isDestroyed()) {
                return;
            }
            QLog.d("AVTipsPart", 1, "onClick com.tencent.mobileqq.R.id.qav_btn_accept_video");
            DataReport.H(NetworkUtil.isWifiConnected(h.this.getContext()), n.e().f().f73063p);
            if (h.this.f76299f != null) {
                h.this.f76299f.h();
            }
            n.e().f().C1 = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = (String) message.obj;
            int i3 = message.what;
            if (i3 == 256) {
                cw.e.p(h.this.f76300h.get(), 1037, str);
            } else {
                if (i3 != 257) {
                    return;
                }
                cw.e.p(h.this.f76300h.get(), 1036, str);
            }
        }
    }

    public void B9() {
        c cVar = this.f76301i;
        if (cVar != null) {
            cVar.removeMessages(256);
            this.f76301i.removeMessages(257);
        }
    }

    public void D9(long j3) {
        WeakReference<VideoAppInterface> weakReference;
        if (r.h0() == null || (weakReference = this.f76300h) == null) {
            return;
        }
        cw.a aVar = this.f76298e;
        if (aVar != null) {
            aVar.w(weakReference.get());
        }
        SessionInfo f16 = n.e().f();
        if (!f16.K() || f16.G || f16.z() || !f16.P()) {
            return;
        }
        if (!NetworkUtil.isWifiConnected(null) || com.tencent.av.utils.e.e(0) == 1) {
            cw.e.n(this.f76300h.get(), 1050);
        }
    }

    public void E9(long j3, float f16) {
        cw.a aVar = this.f76298e;
        if (aVar != null) {
            aVar.A(j3, f16);
        }
    }

    public void F9(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AVTipsPart", 2, "showOrHideAcceptBtn-->isShow = " + z16);
        }
        cw.a aVar = this.f76298e;
        if (aVar != null) {
            aVar.C(z16, new a());
        }
        if (z16) {
            cw.e.n(this.f76300h.get(), 1030);
        } else {
            cw.e.d(this.f76300h.get(), 1030);
        }
    }

    public void G9(boolean z16, boolean z17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.d("AVTipsPart", 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + z16 + " , needNoticeWiFiTips = " + z17 + " , needShowGLView = " + z18);
        }
        n.e().f().f0(z16);
        cw.a aVar = this.f76298e;
        if (aVar != null) {
            aVar.C(z16, new b());
        }
        if (z16) {
            DataReport.F(NetworkUtil.isWifiConnected(getContext()), n.e().f().f73063p);
            if (z17) {
                cw.e.n(this.f76300h.get(), 3015);
                return;
            } else {
                cw.e.d(this.f76300h.get(), 3015);
                return;
            }
        }
        cw.e.d(this.f76300h.get(), 3015);
        cw.e.d(this.f76300h.get(), 1030);
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f76301i;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
            this.f76301i = null;
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        super.onInitView(view);
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(R.id.g6f);
        cw.a aVar = new cw.a();
        this.f76298e = aVar;
        aVar.u(this.f76300h.get(), viewGroup);
        this.f76299f = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, view, null);
        this.f76301i = new c(Looper.getMainLooper());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        cw.a aVar = this.f76298e;
        if (aVar != null) {
            aVar.v();
            this.f76298e = null;
        }
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76300h = new WeakReference<>((VideoAppInterface) appInterface);
    }

    public void C9(int i3) {
        int i16 = i3 == 1037 ? 256 : 257;
        c cVar = this.f76301i;
        if (cVar != null) {
            cVar.removeMessages(i16);
        }
    }

    public void H9(int i3, String str) {
        int i16 = i3 == 1037 ? 256 : 257;
        c cVar = this.f76301i;
        if (cVar != null) {
            cVar.removeMessages(i16);
            this.f76301i.sendMessageDelayed(this.f76301i.obtainMessage(i16, str), 1500L);
        }
    }
}
