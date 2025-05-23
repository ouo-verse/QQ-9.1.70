package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes17.dex */
public class MicSequenceFullManagerPanel extends FrameLayout {
    static IPatchRedirector $redirector_;
    private View C;
    private ViewGroup D;
    private View E;
    private View F;
    private TextView G;
    private EditText H;
    private TextView I;
    private View J;
    private View K;
    private boolean L;
    private boolean M;
    private boolean N;
    private long P;
    private int Q;
    private String R;
    private long S;
    private String T;
    private String U;

    /* renamed from: d, reason: collision with root package name */
    private TextView f271738d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f271739e;

    /* renamed from: f, reason: collision with root package name */
    private View f271740f;

    /* renamed from: h, reason: collision with root package name */
    private View f271741h;

    /* renamed from: i, reason: collision with root package name */
    private View f271742i;

    /* renamed from: m, reason: collision with root package name */
    private View f271743m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.mobileqq.qqlive.room.multichat.view.minicard.a.a(MicSequenceFullManagerPanel.this.P, MicSequenceFullManagerPanel.this.S, MicSequenceFullManagerPanel.this.T, MicSequenceFullManagerPanel.this.U, MicSequenceFullManagerPanel.this.getContext());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceFullManagerPanel.this.f271742i, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateCapabilityElementParam(2, MicSequenceFullManagerPanel.this.S));
                if (!TextUtils.isEmpty(MicSequenceFullManagerPanel.this.R)) {
                    MicSequenceFullManagerPanel.this.H.setText(MicSequenceFullManagerPanel.this.R);
                }
                MicSequenceFullManagerPanel.this.D.setVisibility(0);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(MicSequenceFullManagerPanel.this.E, IMultiAvChatReporter.ELEMENT_NAME_CANCEL_BUTTON, new ConcurrentHashMap<>());
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(MicSequenceFullManagerPanel.this.F, IMultiAvChatReporter.ELEMENT_NAME_OK_BUTTON, new ConcurrentHashMap<>());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MicSequenceFullManagerPanel.this.H.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                View view = MicSequenceFullManagerPanel.this.K;
                if (editable.length() > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
                if (editable.length() >= 4) {
                    MicSequenceFullManagerPanel.this.I.setTextColor(-47803);
                    MicSequenceFullManagerPanel.this.I.setText("\u5df2\u8fbe\u52304\u4e2a\u6700\u5927\u5b57\u7b26\u9650\u5236\uff01");
                    return;
                } else {
                    MicSequenceFullManagerPanel.this.I.setTextColor(2063597567);
                    MicSequenceFullManagerPanel.this.I.setText("*\u6700\u591a\u53ef\u8f93\u51654\u4e2a\u5b57\u7b26");
                    return;
                }
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceFullManagerPanel.this.r();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceFullManagerPanel.this.r();
                MicSequenceFullManagerPanel.this.D.setVisibility(8);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceFullManagerPanel.this.E, new ConcurrentHashMap<>());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceFullManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceFullManagerPanel.this.r();
                MicSequenceFullManagerPanel.this.H.getText().toString();
                MicSequenceFullManagerPanel.k(MicSequenceFullManagerPanel.this);
                MicSequenceFullManagerPanel.this.D.setVisibility(8);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceFullManagerPanel.this.F, new ConcurrentHashMap<>());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MicSequenceFullManagerPanel(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.L = true;
        this.M = true;
        this.N = true;
        this.S = 0L;
        v();
    }

    private void A() {
        int i3;
        String str;
        View view = this.f271740f;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.zkj);
        TextView textView = (TextView) this.f271740f.findViewById(R.id.zkk);
        Context context = getContext();
        if (this.L) {
            i3 = R.mipmap.f169236k;
        } else {
            i3 = R.mipmap.f169235j;
        }
        imageView.setImageDrawable(context.getDrawable(i3));
        if (this.L) {
            str = " \u9759\u97f3 ";
        } else {
            str = "\u89e3\u9664\u9759\u97f3";
        }
        textView.setText(str);
    }

    static /* bridge */ /* synthetic */ qi2.b k(MicSequenceFullManagerPanel micSequenceFullManagerPanel) {
        micSequenceFullManagerPanel.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Activity activity = (Activity) getContext();
        this.H.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            if (Build.BRAND.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.H.getWindowToken(), 0);
            }
        }
    }

    private void s(View view) {
        this.D = (ViewGroup) view.findViewById(R.id.upn);
        this.E = view.findViewById(R.id.tle);
        this.F = view.findViewById(R.id.zwj);
        this.G = (TextView) view.findViewById(R.id.f98085m5);
        this.H = (EditText) view.findViewById(R.id.upo);
        this.I = (TextView) view.findViewById(R.id.f95465f2);
        View findViewById = view.findViewById(R.id.txk);
        this.K = findViewById;
        findViewById.setOnClickListener(new c());
        this.H.addTextChangedListener(new d());
        this.D.setOnClickListener(new e());
        this.E.setOnClickListener(new f());
        this.F.setOnClickListener(new g());
    }

    private void t(View view) {
        View findViewById = view.findViewById(R.id.zki);
        this.f271740f = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MicSequenceFullManagerPanel.this.w(view2);
            }
        });
        A();
        View findViewById2 = view.findViewById(R.id.tl7);
        this.f271741h = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MicSequenceFullManagerPanel.this.x(view2);
            }
        });
        z();
        View findViewById3 = view.findViewById(R.id.zd5);
        this.f271742i = findViewById3;
        findViewById3.setOnClickListener(new b());
        View findViewById4 = view.findViewById(R.id.yiz);
        this.f271743m = findViewById4;
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MicSequenceFullManagerPanel.this.y(view2);
            }
        });
    }

    private void u(View view) {
        View findViewById = view.findViewById(R.id.f81314du);
        this.J = findViewById;
        findViewById.setOnClickListener(new a());
    }

    private void v() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fmi, (ViewGroup) this, true);
        this.C = inflate;
        this.f271738d = (TextView) inflate.findViewById(R.id.f98125m9);
        this.f271739e = (TextView) this.C.findViewById(R.id.f98135m_);
        t(this.C);
        s(this.C);
        u(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(this.f271740f, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateCapabilityElementParam(0, this.S));
        this.L = !this.L;
        A();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(this.f271741h, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateCapabilityElementParam(1, this.S));
        this.M = !this.M;
        z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(this.f271743m, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateCapabilityElementParam(3, this.S));
        EventCollector.getInstance().onViewClicked(view);
    }

    private void z() {
        int i3;
        View view = this.f271741h;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.tl8);
        TextView textView = (TextView) this.f271741h.findViewById(R.id.tl9);
        String str = "\u5f00\u542f\u6444\u50cf\u5934";
        if (!this.N) {
            imageView.setImageDrawable(getContext().getDrawable(R.mipmap.f169227b));
            textView.setTextColor(2063597567);
            textView.setText("\u5f00\u542f\u6444\u50cf\u5934");
            return;
        }
        Context context = getContext();
        if (this.M) {
            i3 = R.mipmap.f169228c;
        } else {
            i3 = R.mipmap.f169226a;
        }
        imageView.setImageDrawable(context.getDrawable(i3));
        textView.setTextColor(-1);
        if (this.M) {
            str = "\u5173\u95ed\u6444\u50cf\u5934";
        }
        textView.setText(str);
    }

    public void setAvPermission(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.L = z16;
        this.M = z17;
        this.N = z18;
        A();
        z();
    }

    public void setMicSeqParam(com.tencent.mobileqq.qqlive.room.multichat.store.d dVar, qi2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) bVar);
            return;
        }
        this.Q = dVar.f271671c;
        this.R = dVar.f271675g;
        this.P = dVar.f271669a;
        this.S = dVar.f271670b;
        this.U = dVar.f271672d;
        String str = dVar.f271673e;
        this.T = str;
        TextView textView = this.f271738d;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f271739e;
        if (textView2 != null) {
            textView2.setText(String.format(Locale.getDefault(), " (%d\u53f7\u4f4d)", Integer.valueOf(dVar.f271671c + 1)));
        }
        TextView textView3 = this.G;
        if (textView3 != null) {
            textView3.setText(String.format(Locale.getDefault(), "\u9ea6\u4f4d\u547d\u540d (%d\u53f7\u4f4d)", Integer.valueOf(dVar.f271671c + 1)));
        }
    }

    public MicSequenceFullManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.L = true;
        this.M = true;
        this.N = true;
        this.S = 0L;
        v();
    }

    public MicSequenceFullManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.L = true;
        this.M = true;
        this.N = true;
        this.S = 0L;
        v();
    }
}
