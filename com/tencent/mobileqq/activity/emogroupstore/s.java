package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class s extends ReportDialog {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private ProgressBar I;
    private ImageView J;
    private RecyclerView K;
    private LinearLayout L;
    private LinearLayout M;
    private ValueAnimator N;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f182179d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f182179d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DialogInterface.OnClickListener onClickListener = this.f182179d;
                if (onClickListener != null) {
                    onClickListener.onClick(s.this, 0);
                }
                try {
                    if (s.this.isShowing()) {
                        s.this.dismiss();
                    }
                } catch (Exception unused) {
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f182181d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f182181d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DialogInterface.OnClickListener onClickListener = this.f182181d;
                if (onClickListener != null) {
                    onClickListener.onClick(s.this, 1);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f182183d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f182183d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DialogInterface.OnClickListener onClickListener = this.f182183d;
                if (onClickListener != null) {
                    onClickListener.onClick(s.this, 2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public s(Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        getWindow().setDimAmount(0.5f);
        setContentView(R.layout.f167854jl);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        this.D = (TextView) findViewById(R.id.dialogText);
        this.E = (TextView) findViewById(R.id.dialogLeftBtn);
        this.F = (TextView) findViewById(R.id.dialogRightBtn);
        this.G = (TextView) findViewById(R.id.bie);
        this.J = (ImageView) findViewById(R.id.cla);
        this.K = (RecyclerView) findViewById(R.id.imq);
        this.H = (TextView) findViewById(R.id.g27);
        this.I = (ProgressBar) findViewById(R.id.bvy);
        this.L = (LinearLayout) findViewById(R.id.bjl);
        this.M = (LinearLayout) findViewById(R.id.bkd);
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            this.L.setVisibility(8);
            this.M.setVisibility(0);
        } else if (i3 == 1) {
            this.L.setVisibility(0);
            this.M.setVisibility(8);
        }
    }

    public s O(int i3, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (s) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.E.setVisibility(8);
            return this;
        }
        this.E.setText(i3);
        this.E.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.E.setVisibility(0);
        this.E.setOnClickListener(new a(onClickListener));
        return this;
    }

    public s P(int i3, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (s) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new c(onClickListener));
        return this;
    }

    public void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        ProgressBar progressBar = this.I;
        if (progressBar == null) {
            return;
        }
        ValueAnimator a16 = t.a(progressBar, i3);
        this.N = a16;
        a16.start();
    }

    public s R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (s) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (this.H != null && this.I != null) {
            if (!TextUtils.isEmpty(str)) {
                this.H.setVisibility(0);
                this.H.setText(str);
            } else {
                this.H.setVisibility(4);
            }
        }
        return this;
    }

    public s S(List<String> list, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (s) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) onClickListener);
        }
        if (list != null && onClickListener != null) {
            this.K.setVisibility(0);
            this.K.setAdapter(new u(list));
            this.K.setItemAnimator(new DefaultItemAnimator());
            this.K.setLayoutManager(new com.tencent.mobileqq.emosm.view.a(onClickListener));
        }
        return this;
    }

    public s U(int i3, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (s) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.G.setVisibility(8);
            return this;
        }
        this.G.setText(i3);
        this.G.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.G.setVisibility(0);
        this.G.setOnClickListener(new b(onClickListener));
        return this;
    }

    public s W(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (s) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (str != null) {
            this.C.setText(str);
            this.C.setContentDescription(str);
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        return this;
    }

    public void X(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null && i3 > 0) {
            valueAnimator.cancel();
        }
        if (this.H != null && this.I != null) {
            if (!TextUtils.isEmpty(str)) {
                this.H.setVisibility(0);
                this.H.setText(str);
            }
            if (i3 >= 0 && i3 <= 100) {
                this.I.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 24) {
                    this.I.setProgress(i3, true);
                } else {
                    this.I.setProgress(i3);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            ValueAnimator valueAnimator = this.N;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }
}
