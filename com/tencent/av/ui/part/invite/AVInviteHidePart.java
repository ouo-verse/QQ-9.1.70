package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* loaded from: classes32.dex */
public class AVInviteHidePart extends Part {

    /* renamed from: i, reason: collision with root package name */
    public static int f76394i = 60000;

    /* renamed from: m, reason: collision with root package name */
    public static int f76395m = 50000;

    /* renamed from: e, reason: collision with root package name */
    private m f76397e;

    /* renamed from: d, reason: collision with root package name */
    private View f76396d = null;

    /* renamed from: f, reason: collision with root package name */
    Runnable f76398f = new Runnable() { // from class: com.tencent.av.ui.part.invite.AVInviteHidePart.2
        @Override // java.lang.Runnable
        public void run() {
            AVInviteHidePart.this.B9();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    Runnable f76399h = new Runnable() { // from class: com.tencent.av.ui.part.invite.AVInviteHidePart.3
        @Override // java.lang.Runnable
        public void run() {
            if (AVInviteHidePart.this.f76397e != null) {
                AVInviteHidePart.this.f76397e.d();
            }
        }
    };

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AVInviteHidePart.this.f76397e != null) {
                AVInviteHidePart.this.f76397e.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9() {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.part.invite.AVInviteHidePart.4
            @Override // java.lang.Runnable
            public void run() {
                if (AVInviteHidePart.this.f76396d != null) {
                    AVInviteHidePart.this.f76396d.setVisibility(4);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C9() {
        long currentTimeMillis = System.currentTimeMillis();
        m mVar = this.f76397e;
        if (mVar == null || mVar.getSessionInfo() == null) {
            return;
        }
        long j3 = this.f76397e.getSessionInfo().f73014d2;
        QLog.d("AVInviteHidePart", 1, "setHiddenTimeoutRunnable startTime=" + currentTimeMillis + " tempTime=" + j3);
        boolean z16 = false;
        if (j3 > 0) {
            long j16 = currentTimeMillis - j3;
            if (j16 < f76394i) {
                z16 = j16 >= ((long) f76395m);
                VideoAppInterface b16 = nw.b.b();
                b16.M().postDelayed(this.f76399h, (f76394i + j3) - currentTimeMillis);
                if (!z16) {
                    B9();
                    return;
                } else {
                    b16.M().postDelayed(this.f76398f, (j3 + f76395m) - currentTimeMillis);
                    return;
                }
            }
        }
        j3 = currentTimeMillis;
        VideoAppInterface b162 = nw.b.b();
        b162.M().postDelayed(this.f76399h, (f76394i + j3) - currentTimeMillis);
        if (!z16) {
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteHidePart", 1, "onInitView rootView is null");
            return;
        }
        View findViewById = view.findViewById(m.l.f76080z);
        this.f76396d = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new a());
        }
        this.f76397e = (mw.m) RFWIocAbilityProvider.g().getIocInterface(mw.m.class, getPartRootView(), null);
        QavPanel.s0((ImageButton) this.f76396d, R.drawable.d_z);
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        VideoAppInterface b16 = nw.b.b();
        b16.M().removeCallbacks(this.f76399h);
        b16.M().removeCallbacks(this.f76398f);
        View view = this.f76396d;
        if (view != null) {
            ((ImageButton) view).setImageDrawable(null);
            this.f76396d = null;
        }
    }
}
