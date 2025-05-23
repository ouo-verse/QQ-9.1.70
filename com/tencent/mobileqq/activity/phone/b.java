package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends ReportDialog {
    static IPatchRedirector $redirector_;
    private AppRuntime C;
    private QUSHalfScreenFloatingView D;
    private View.OnClickListener E;
    private View.OnClickListener F;
    private String G;
    private String H;
    private TextView I;
    private TextView J;
    private Button K;
    private Button L;
    private View M;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.this.M;
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.phone.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ViewOnClickListenerC7187b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC7187b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (b.this.F != null) {
                b.this.F.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (b.this.E != null) {
                b.this.E.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(@NonNull Context context, AppRuntime appRuntime) {
        super(context, R.style.f173448dl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appRuntime);
        } else {
            this.C = appRuntime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        dismiss();
    }

    private void initView() {
        View inflate = getLayoutInflater().inflate(R.layout.edd, (ViewGroup) null);
        this.M = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.vvi);
        this.I = textView;
        textView.setText(this.G);
        TextView textView2 = (TextView) this.M.findViewById(R.id.vvh);
        this.J = textView2;
        textView2.setText(this.H);
        Button button = (Button) this.M.findViewById(R.id.aou);
        this.K = button;
        button.setOnClickListener(new ViewOnClickListenerC7187b());
        Button button2 = (Button) this.M.findViewById(R.id.b7p);
        this.L = button2;
        button2.setOnClickListener(new c());
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.D.t();
        }
    }

    public void U(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener, (Object) onClickListener2);
        } else {
            this.F = onClickListener;
            this.E = onClickListener2;
        }
    }

    public void W(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            this.G = str;
            this.H = str2;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        setContentView(R.layout.e3i);
        this.D = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        ImmersiveUtils.setStatusTextColor(false, getWindow());
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        initView();
        this.D.setQUSDragFloatController(new a());
        this.D.setIsHeightWrapContent(true);
        this.D.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.activity.phone.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                b.this.S();
            }
        });
        ReportController.y(this.C, "0X800C105");
    }
}
