package com.tencent.av.ui.part.mav;

import android.app.Activity;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cw.e;
import java.util.ArrayList;
import mw.f;

/* loaded from: classes32.dex */
public class AudioSuspectNoisyPart extends Part {

    /* renamed from: d, reason: collision with root package name */
    Runnable f76571d = null;

    /* loaded from: classes32.dex */
    class RefreshNoiseStateRunnable implements Runnable {
        RefreshNoiseStateRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0().d2()) {
                r.h0().C1(0L, false, 0L);
                if (QLog.isColorLevel()) {
                    QLog.e("AudioSuspectNoisyPart", 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
                }
            }
            AudioSuspectNoisyPart audioSuspectNoisyPart = AudioSuspectNoisyPart.this;
            if (audioSuspectNoisyPart.f76571d != null) {
                audioSuspectNoisyPart.getMainHandler().postDelayed(AudioSuspectNoisyPart.this.f76571d, r.h0().n0() >= 2000 ? r.h0().n0() : 2000L);
            }
        }
    }

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.h0() != null) {
                r.h0().o3();
            }
            ReportController.o(null, "CliOper", "", "", "0X8005DF1", "0X8005DF1", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.h0() != null) {
                r.h0().o3();
            }
            ReportController.o(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.h0() != null) {
                r.h0().o3();
            }
            ReportController.o(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f76571d != null) {
            getMainHandler().removeCallbacks(this.f76571d);
            this.f76571d = null;
        }
    }

    public void x9(ArrayList<Long> arrayList, int i3) {
        VideoAppInterface b16 = nw.b.b();
        if (i3 == 0) {
            e.d(b16, 1034);
            e.d(b16, 1035);
            if (this.f76571d != null) {
                b16.M().removeCallbacks(this.f76571d);
                this.f76571d = null;
                return;
            }
            return;
        }
        if (i3 == 1 && arrayList.get(0).longValue() == b16.getLongAccountUin()) {
            e.l(b16, 1035, b16.getApp().getString(R.string.dbx), b16.getApp().getString(R.string.dkh), new a());
            return;
        }
        if (this.f76571d == null) {
            this.f76571d = new RefreshNoiseStateRunnable();
            b16.M().postDelayed(this.f76571d, r.h0().n0() >= 2000 ? r.h0().n0() : 2000L);
        }
        SessionInfo f16 = n.e().f();
        String U = r.h0().U(String.valueOf(arrayList.get(0)), String.valueOf(f16.P0), f16.S0);
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f158932sr);
        StringBuilder sb5 = new StringBuilder();
        com.tencent.av.utils.n.a(sb5, U, ((f) RFWIocAbilityProvider.g().getIocInterface(f.class, getPartRootView(), null)).j(), dimensionPixelSize);
        if (i3 == 1) {
            e.l(b16, 1035, b16.getApp().getString(R.string.dby), b16.getApp().getString(R.string.dki), new b());
            return;
        }
        sb5.append(b16.getApp().getString(R.string.dbz));
        sb5.append(i3);
        sb5.append(b16.getApp().getString(R.string.f171225dc0));
        e.l(b16, 1035, sb5.toString(), b16.getApp().getString(R.string.dkj), new c());
    }
}
