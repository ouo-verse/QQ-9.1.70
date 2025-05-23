package com.tencent.ams.xsad.rewarded.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.xsad.rewarded.c;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends ReportDialog {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private TextView E;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.xsad.rewarded.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0707a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Context f71904a;

        /* renamed from: b, reason: collision with root package name */
        private String f71905b;

        /* renamed from: c, reason: collision with root package name */
        private String f71906c;

        /* renamed from: d, reason: collision with root package name */
        private DialogInterface.OnClickListener f71907d;

        /* renamed from: e, reason: collision with root package name */
        private String f71908e;

        /* renamed from: f, reason: collision with root package name */
        private DialogInterface.OnClickListener f71909f;

        /* renamed from: g, reason: collision with root package name */
        private DialogInterface.OnCancelListener f71910g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f71911h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.ams.xsad.rewarded.view.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class ViewOnClickListenerC0708a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f71912d;

            ViewOnClickListenerC0708a(a aVar) {
                this.f71912d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C0707a.this, (Object) aVar);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (C0707a.this.f71909f != null) {
                    C0707a.this.f71909f.onClick(this.f71912d, -2);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.ams.xsad.rewarded.view.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f71914d;

            b(a aVar) {
                this.f71914d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C0707a.this, (Object) aVar);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (C0707a.this.f71907d != null) {
                    C0707a.this.f71907d.onClick(this.f71914d, -1);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public C0707a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.f71904a = context;
            }
        }

        public a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            a aVar = new a(this.f71904a);
            aVar.setCancelable(this.f71911h);
            if (this.f71911h) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.f71910g);
            aVar.C.setText(this.f71905b);
            aVar.E.setText(this.f71908e);
            aVar.E.setOnClickListener(new ViewOnClickListenerC0708a(aVar));
            aVar.D.setText(this.f71906c);
            aVar.D.setOnClickListener(new b(aVar));
            return aVar;
        }

        public C0707a d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (C0707a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f71911h = z16;
            return this;
        }

        public C0707a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C0707a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f71905b = str;
            return this;
        }

        public C0707a f(String str, DialogInterface.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C0707a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) onClickListener);
            }
            this.f71908e = str;
            this.f71909f = onClickListener;
            return this;
        }

        public C0707a g(String str, DialogInterface.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C0707a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) onClickListener);
            }
            this.f71906c = str;
            this.f71907d = onClickListener;
            return this;
        }

        public a h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            a c16 = c();
            c16.show();
            return c16;
        }
    }

    public a(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
        setContentView(Q(context));
    }

    private View Q(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(g.b(context, 280.0f), g.b(context, 144.0f)));
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(g.b(context, 10.0f));
        gradientDrawable.setColor(-1);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        int b16 = g.b(context, 44.0f);
        layoutParams.rightMargin = b16;
        layoutParams.leftMargin = b16;
        int b17 = g.b(context, 24.0f);
        layoutParams.bottomMargin = b17;
        layoutParams.topMargin = b17;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.parseColor("#000028"));
        textView.setTextSize(1, 16.0f);
        textView.setLineSpacing(g.b(context, 2.0f), 1.0f);
        linearLayout.addView(textView);
        this.C = textView;
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, g.b(context, 0.5f)));
        int parseColor = Color.parseColor("#EBEBEB");
        view.setBackgroundColor(parseColor);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, g.b(context, 47.5f)));
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(1, 16.0f);
        textView2.setTextColor(Color.parseColor("#000028"));
        textView2.setGravity(17);
        linearLayout2.addView(textView2);
        this.E = textView2;
        View view2 = new View(context);
        view2.setLayoutParams(new LinearLayout.LayoutParams(g.b(context, 0.5f), g.b(context, 32.0f)));
        view2.setBackgroundColor(parseColor);
        linearLayout2.addView(view2);
        TextView textView3 = new TextView(context);
        new LinearLayout.LayoutParams(0, -1).weight = 1.0f;
        textView3.setLayoutParams(layoutParams2);
        textView3.setTextSize(1, 16.0f);
        textView3.setTextColor(Color.parseColor(c.f().i()));
        textView3.setGravity(17);
        linearLayout2.addView(textView3);
        this.D = textView3;
        return linearLayout;
    }
}
