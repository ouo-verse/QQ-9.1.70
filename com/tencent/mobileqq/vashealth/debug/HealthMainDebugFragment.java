package com.tencent.mobileqq.vashealth.debug;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.vashealth.debug.HealthMainDebugFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HealthMainDebugFragment extends QIphoneTitleBarFragment {
    private FormSwitchItem C;
    private FormSwitchItem D;
    private QUISingleLineInputView E;
    private TextView F;
    private QUISingleLineInputView G;
    private QUISingleLineInputView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private QUISingleLineInputView N;
    private TextView P;
    private TextView Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private h43.a U = null;
    private h43.a V = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).jumpToMainPage(HealthMainDebugFragment.this.E.d().toString());
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
            String charSequence = HealthMainDebugFragment.this.G.d().toString();
            if (TextUtils.isEmpty(charSequence)) {
                HealthMainDebugFragment.this.I.setText("[debug]\u8bbe\u7f6e\u5931\u8d25: \u6b65\u6570\u4e3a\u7a7a");
            } else {
                try {
                    int parseInt = Integer.parseInt(charSequence);
                    i43.b.f407199a.h(parseInt);
                    HealthMainDebugFragment.this.I.setText("[debug]\u5df2\u8bbe\u7f6e\u6211\u7684\u6b65\u6570\u4e3a:" + parseInt);
                } catch (NumberFormatException e16) {
                    QLog.e("HealthMainDebugFragment", 1, "set my step error:", e16);
                    HealthMainDebugFragment.this.I.setText("[debug]\u8bbe\u7f6e\u5931\u8d25: " + charSequence + "\u65e0\u6548");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String charSequence = HealthMainDebugFragment.this.H.d().toString();
            if (TextUtils.isEmpty(charSequence)) {
                HealthMainDebugFragment.this.J.setText("[debug]\u8bbe\u7f6e\u5931\u8d25: \u6b65\u6570\u4e3a\u7a7a");
            } else {
                try {
                    int parseInt = Integer.parseInt(charSequence);
                    i43.b.f407199a.f(parseInt);
                    HealthMainDebugFragment.this.J.setText("[debug]\u5df2\u8bbe\u7f6e\u597d\u53cb\u7684\u6b65\u6570\u4e3a:" + parseInt);
                } catch (NumberFormatException e16) {
                    QLog.e("HealthMainDebugFragment", 1, "set friend step error:", e16);
                    HealthMainDebugFragment.this.J.setText("[debug]\u8bbe\u7f6e\u5931\u8d25: " + charSequence + "\u65e0\u6548");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo("", Boolean.TRUE, HealthMainDebugFragment.this.V);
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
            boolean stepPermission = ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission();
            QLog.d("HealthMainDebugFragment", 1, "onGetStepPermission:", Boolean.valueOf(stepPermission));
            HealthMainDebugFragment.this.S.setText("\u67e5\u770b\u662f\u5426\u6709\u6388\u6743:" + stepPermission);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements h43.e {
            a() {
            }

            @Override // h43.e
            public void a() {
                QLog.d("HealthMainDebugFragment", 1, "onPermissionDenied");
            }

            @Override // h43.e
            public void b() {
                QLog.d("HealthMainDebugFragment", 1, "onPermissionAllowed");
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new a(), null);
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
            String charSequence = HealthMainDebugFragment.this.N.d().toString();
            if (TextUtils.isEmpty(charSequence)) {
                HealthMainDebugFragment.this.N.setPromptText("\u8bf7\u8f93\u5165\u6b63\u786e\u7684uin");
            }
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(charSequence, Boolean.FALSE, HealthMainDebugFragment.this.U);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Eh() {
        this.E.setPromptText("\u8bf7\u8f93\u5165\u597d\u53cbuin(\u53ef\u9009)");
        this.E.setShowWordCount(false);
        this.G.setPromptText("\u8bf7\u8f93\u5165\u6211\u7684\u6b65\u6570");
        this.G.setShowWordCount(false);
        this.H.setPromptText("\u8bf7\u8f93\u5165\u597d\u53cb\u7684\u6b65\u6570");
        this.H.setShowWordCount(false);
        this.N.setPromptText("\u8bf7\u8f93\u5165uin");
        this.N.setShowWordCount(false);
    }

    private void Fh() {
        this.F.setOnClickListener(new a());
        this.I.setOnClickListener(new b());
        this.J.setOnClickListener(new c());
        this.V = new h43.a() { // from class: i43.c
            @Override // h43.a
            public final void a(h43.f fVar) {
                HealthMainDebugFragment.this.Hh(fVar);
            }
        };
        this.K.setOnClickListener(new d());
        this.S.setOnClickListener(new e());
        this.T.setOnClickListener(new f());
        FormSwitchItem formSwitchItem = this.D;
        i43.b bVar = i43.b.f407199a;
        formSwitchItem.setChecked(bVar.c());
        this.D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i43.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                HealthMainDebugFragment.Ih(compoundButton, z16);
            }
        });
        this.C.setChecked(bVar.e());
        this.C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i43.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                HealthMainDebugFragment.Jh(compoundButton, z16);
            }
        });
        this.U = new h43.a() { // from class: i43.f
            @Override // h43.a
            public final void a(h43.f fVar) {
                HealthMainDebugFragment.this.Lh(fVar);
            }
        };
        this.P.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(h43.f fVar) {
        this.K.setText("\u83b7\u53d6\u6211\u7684\u6b65\u6570:" + fVar.f404302a);
        this.L.setText(fVar.f404304c);
        this.M.setImageDrawable(GdtUIUtils.getUrlDrawable(fVar.f404303b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(final h43.f fVar) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: i43.h
            @Override // java.lang.Runnable
            public final void run() {
                HealthMainDebugFragment.this.Gh(fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ih(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        i43.b.f407199a.g(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Jh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        i43.b.f407199a.i(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(h43.f fVar) {
        this.P.setText("\u83b7\u53d6\u597d\u53cb\u6b65\u6570:" + fVar.f404302a);
        this.Q.setText(fVar.f404304c);
        this.R.setImageDrawable(GdtUIUtils.getUrlDrawable(fVar.f404303b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(final h43.f fVar) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: i43.g
            @Override // java.lang.Runnable
            public final void run() {
                HealthMainDebugFragment.this.Kh(fVar);
            }
        });
    }

    public static void Mh(Activity activity) {
        if (activity == null) {
            QLog.e("HealthMainDebugFragment", 1, "start error");
        } else {
            QPublicFragmentActivity.start(activity, HealthMainDebugFragment.class);
        }
    }

    private void initViews(View view) {
        this.C = (FormSwitchItem) view.findViewById(R.id.x95);
        this.D = (FormSwitchItem) view.findViewById(R.id.x9_);
        this.E = (QUISingleLineInputView) view.findViewById(R.id.x8w);
        this.F = (TextView) view.findViewById(R.id.x8v);
        this.G = (QUISingleLineInputView) view.findViewById(R.id.f165687x94);
        this.I = (TextView) view.findViewById(R.id.f165686x93);
        this.H = (QUISingleLineInputView) view.findViewById(R.id.f165685x92);
        this.J = (TextView) view.findViewById(R.id.f165684x91);
        this.N = (QUISingleLineInputView) view.findViewById(R.id.x99);
        this.P = (TextView) view.findViewById(R.id.x98);
        this.Q = (TextView) view.findViewById(R.id.x97);
        this.R = (ImageView) view.findViewById(R.id.x96);
        this.K = (TextView) view.findViewById(R.id.x8z);
        this.L = (TextView) view.findViewById(R.id.x8y);
        this.M = (ImageView) view.findViewById(R.id.x8x);
        this.S = (TextView) view.findViewById(R.id.x8u);
        this.T = (TextView) view.findViewById(R.id.f165683x90);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h4y;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle("QQ\u8fd0\u52a8\u6d4b\u8bd5");
        initViews(view);
        Fh();
        Eh();
    }
}
