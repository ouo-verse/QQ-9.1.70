package com.tencent.mobileqq.vashealth.debug;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.vashealth.v;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import i43.i;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CrossDayDebugFragment extends QIphoneTitleBarFragment {
    private i43.a C;
    private i D;
    private i E;
    private TextView F;
    private TextView G;
    private TextView H;
    private EditText I;
    private EditText J;
    private TextView K;
    private TextView L;
    private long M = 0;
    private long N = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CrossDayDebugFragment.this.C != null) {
                CrossDayDebugFragment.this.C.m();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CrossDayDebugFragment.this.D != null) {
                CrossDayDebugFragment.this.D.m();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CrossDayDebugFragment.this.E != null) {
                CrossDayDebugFragment.this.E.m();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CrossDayDebugFragment.this.Ih();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private long Fh() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.R, this.S - 1, this.T, this.U, this.V, this.W);
        return calendar.getTimeInMillis();
    }

    private long Gh(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        calendar.set(11, i3);
        calendar.set(12, i16);
        calendar.set(13, i17);
        return calendar.getTimeInMillis();
    }

    private void Hh() {
        this.F.setOnClickListener(new a());
        this.G.setOnClickListener(new b());
        this.C.i(new c());
        this.D.i(new d());
        this.H.setOnClickListener(new e());
        this.E.i(new f());
        this.K.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        int i3;
        int intValue;
        int intValue2;
        this.P = Mh(this.I.getText(), 0);
        int Mh = Mh(this.J.getText(), 0);
        this.Q = Mh;
        long j3 = this.M;
        if (j3 != 0 && (i3 = this.P) != 0) {
            long j16 = this.N;
            if (j16 != 0 && Mh != 0) {
                Pair<Integer, Integer> a16 = v.a(j3, i3, j16, Mh);
                if (a16.first.intValue() < 0) {
                    intValue = this.P;
                } else {
                    intValue = a16.first.intValue();
                }
                if (a16.second.intValue() < 0) {
                    intValue2 = this.Q;
                } else {
                    intValue2 = a16.second.intValue();
                }
                this.L.setText("yesterday:" + intValue + ", today:" + intValue2);
                return;
            }
        }
        this.L.setText("\u8bf7\u68c0\u67e5\u6570\u636e\u662f\u5426\u8bbe\u7f6e\u6b63\u786e");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        this.E.y();
        int u16 = this.E.u();
        int v3 = this.E.v();
        int w3 = this.E.w();
        long Gh = Gh(u16, v3, w3);
        long g16 = k.f312340a.g();
        this.M = g16;
        if (Gh < g16) {
            QLog.e("CrossDayDebugFragment", 1, "onSelectTimeConfirm error: currentTime < LastTime");
            QQToast.makeText(getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25: \u5f53\u524d\u4e0a\u62a5\u65f6\u95f4\u9700\u5927\u4e8e\u4e0a\u6b21\u4e0a\u62a5\u65f6\u95f4", 1).show();
            return;
        }
        this.N = Gh;
        this.H.setText(u16 + " \u65f6 " + v3 + " \u5206 " + w3 + " \u79d2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        long Fh = Fh();
        this.M = Fh;
        if (Fh == 0) {
            QLog.e("CrossDayDebugFragment", 1, "onSelectTimeConfirm error: mLastReportTimeMs:0");
            QQToast.makeText(getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25: \u65f6\u95f4\u4e3a0", 1).show();
            return;
        }
        long j3 = this.N;
        if (j3 <= 0) {
            j3 = NetConnInfoCenter.getServerTimeMillis();
        }
        long j16 = this.M;
        if (j16 > j3) {
            QLog.e("CrossDayDebugFragment", 1, "onSelectTimeConfirm error: mLastReportTimeMs < currentTime:", Long.valueOf(j16));
            QQToast.makeText(getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25: \u65f6\u95f4\u665a\u4e8e\u5f53\u524d\u65f6\u95f4", 1).show();
            return;
        }
        this.G.setText(this.U + " \u65f6 " + this.V + " \u5206 " + this.W + " \u79d2");
        QLog.d("CrossDayDebugFragment", 1, "timeMs selected success:", Long.valueOf(this.M));
        k.f312340a.r(this.M);
        QQToast.makeText(getContext(), 2, "\u8bbe\u7f6e\u6210\u529f", 1).show();
    }

    public static void Lh(Activity activity) {
        if (activity == null) {
            QLog.e("CrossDayDebugFragment", 1, "start error");
        } else {
            QPublicFragmentActivity.start(activity, CrossDayDebugFragment.class);
        }
    }

    public static int Mh(Object obj, int i3) {
        String str = obj + "";
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (Exception e16) {
                QLog.e("CrossDayDebugFragment", 1, "str2int error", e16);
            }
        }
        return i3;
    }

    private void initViews(View view) {
        this.F = (TextView) view.findViewById(R.id.f6255315);
        this.G = (TextView) view.findViewById(R.id.f6256316);
        this.H = (TextView) view.findViewById(R.id.f6254314);
        this.I = (EditText) view.findViewById(R.id.f6252312);
        this.J = (EditText) view.findViewById(R.id.f624930z);
        this.K = (TextView) view.findViewById(R.id.f6258318);
        this.L = (TextView) view.findViewById(R.id.f6257317);
        this.C = new i43.a(getContext());
        this.D = new i(getContext());
        this.E = new i(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h4x;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle("\u8fd0\u52a8\u8de8\u5929\u6b65\u6570\u65b9\u6848\u6d4b\u8bd5");
        initViews(view);
        Hh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements QActionSheet.f {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            CrossDayDebugFragment.this.C.D();
            CrossDayDebugFragment crossDayDebugFragment = CrossDayDebugFragment.this;
            crossDayDebugFragment.R = crossDayDebugFragment.C.A();
            CrossDayDebugFragment crossDayDebugFragment2 = CrossDayDebugFragment.this;
            crossDayDebugFragment2.S = crossDayDebugFragment2.C.z();
            CrossDayDebugFragment crossDayDebugFragment3 = CrossDayDebugFragment.this;
            crossDayDebugFragment3.T = crossDayDebugFragment3.C.y();
            CrossDayDebugFragment.this.F.setText(CrossDayDebugFragment.this.R + " \u5e74 " + CrossDayDebugFragment.this.S + " \u6708 " + CrossDayDebugFragment.this.T + " \u65e5");
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            CrossDayDebugFragment.this.C.c();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements QActionSheet.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            if (CrossDayDebugFragment.this.R != 0 && CrossDayDebugFragment.this.S != 0 && CrossDayDebugFragment.this.T != 0) {
                CrossDayDebugFragment.this.D.y();
                CrossDayDebugFragment crossDayDebugFragment = CrossDayDebugFragment.this;
                crossDayDebugFragment.U = crossDayDebugFragment.D.u();
                CrossDayDebugFragment crossDayDebugFragment2 = CrossDayDebugFragment.this;
                crossDayDebugFragment2.V = crossDayDebugFragment2.D.v();
                CrossDayDebugFragment crossDayDebugFragment3 = CrossDayDebugFragment.this;
                crossDayDebugFragment3.W = crossDayDebugFragment3.D.w();
                CrossDayDebugFragment.this.Kh();
                return;
            }
            QLog.d("CrossDayDebugFragment", 1, "data has not selected");
            QQToast.makeText(CrossDayDebugFragment.this.getContext(), 1, "\u8bbe\u7f6e\u5931\u8d25: \u672a\u9009\u65e5\u671f", 1).show();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            CrossDayDebugFragment.this.D.c();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements QActionSheet.f {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            CrossDayDebugFragment.this.Jh();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            CrossDayDebugFragment.this.E.c();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
