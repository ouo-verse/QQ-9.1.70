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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.LinkMicListView;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.setting.SettingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes17.dex */
public class MicSequenceEmptyManagerPanel extends FrameLayout {
    static IPatchRedirector $redirector_;
    private View C;
    private View D;
    private TextView E;
    private EditText F;
    private TextView G;
    private View H;
    private SettingView I;
    private int J;
    private String K;

    /* renamed from: d, reason: collision with root package name */
    private TextView f271723d;

    /* renamed from: e, reason: collision with root package name */
    private LinkMicListView f271724e;

    /* renamed from: f, reason: collision with root package name */
    private View f271725f;

    /* renamed from: h, reason: collision with root package name */
    private View f271726h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f271727i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f271728m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MicSequenceEmptyManagerPanel.this.I.setVisibility(0);
                MicSequenceEmptyManagerPanel.this.I.k();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements SettingView.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.multichat.view.mananger.setting.SettingView.e
        public void onBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MicSequenceEmptyManagerPanel.this.I.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (!TextUtils.isEmpty(MicSequenceEmptyManagerPanel.this.K)) {
                    MicSequenceEmptyManagerPanel.this.F.setText(MicSequenceEmptyManagerPanel.this.K);
                }
                MicSequenceEmptyManagerPanel.this.f271728m.setVisibility(0);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceEmptyManagerPanel.this.f271725f, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateWheatRenameElementParam());
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(MicSequenceEmptyManagerPanel.this.C, IMultiAvChatReporter.ELEMENT_NAME_CANCEL_BUTTON, new ConcurrentHashMap<>());
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(MicSequenceEmptyManagerPanel.this.D, IMultiAvChatReporter.ELEMENT_NAME_OK_BUTTON, new ConcurrentHashMap<>());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MicSequenceEmptyManagerPanel.g(MicSequenceEmptyManagerPanel.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MicSequenceEmptyManagerPanel.this.F.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                View view = MicSequenceEmptyManagerPanel.this.H;
                if (editable.length() > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
                if (editable.length() >= 4) {
                    MicSequenceEmptyManagerPanel.this.G.setTextColor(-47803);
                    MicSequenceEmptyManagerPanel.this.G.setText("\u5df2\u8fbe\u52304\u4e2a\u6700\u5927\u5b57\u7b26\u9650\u5236\uff01");
                    return;
                } else {
                    MicSequenceEmptyManagerPanel.this.G.setTextColor(2063597567);
                    MicSequenceEmptyManagerPanel.this.G.setText("*\u6700\u591a\u53ef\u8f93\u51654\u4e2a\u5b57\u7b26");
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
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceEmptyManagerPanel.this.l();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceEmptyManagerPanel.this.l();
                MicSequenceEmptyManagerPanel.this.f271728m.setVisibility(8);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceEmptyManagerPanel.this.C, new ConcurrentHashMap<>());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MicSequenceEmptyManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MicSequenceEmptyManagerPanel.this.l();
                MicSequenceEmptyManagerPanel.this.F.getText().toString();
                MicSequenceEmptyManagerPanel.g(MicSequenceEmptyManagerPanel.this);
                MicSequenceEmptyManagerPanel.this.f271728m.setVisibility(8);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(MicSequenceEmptyManagerPanel.this.D, new ConcurrentHashMap<>());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MicSequenceEmptyManagerPanel(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            r();
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
    }

    static /* bridge */ /* synthetic */ qi2.b g(MicSequenceEmptyManagerPanel micSequenceEmptyManagerPanel) {
        micSequenceEmptyManagerPanel.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Activity activity = (Activity) getContext();
        this.F.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            if (Build.BRAND.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.F.getWindowToken(), 0);
            }
        }
    }

    private void m(View view) {
        this.f271728m = (ViewGroup) view.findViewById(R.id.upn);
        this.C = view.findViewById(R.id.tle);
        this.D = view.findViewById(R.id.zwj);
        this.E = (TextView) view.findViewById(R.id.f98085m5);
        this.F = (EditText) view.findViewById(R.id.upo);
        this.G = (TextView) view.findViewById(R.id.f95465f2);
        View findViewById = view.findViewById(R.id.txk);
        this.H = findViewById;
        findViewById.setOnClickListener(new e());
        this.F.addTextChangedListener(new f());
        this.f271728m.setOnClickListener(new g());
        this.C.setOnClickListener(new h());
        this.D.setOnClickListener(new i());
    }

    private void n(View view) {
        this.f271724e = (LinkMicListView) view.findViewById(R.id.yiy);
    }

    private void o(View view) {
        View findViewById = view.findViewById(R.id.zd5);
        this.f271725f = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = view.findViewById(R.id.zfd);
        this.f271726h = findViewById2;
        findViewById2.setOnClickListener(new d());
    }

    private void p(View view) {
        TextView textView = (TextView) view.findViewById(R.id.f780245y);
        this.f271723d = textView;
        textView.setOnClickListener(new a());
    }

    private void q(View view) {
        SettingView settingView = (SettingView) view.findViewById(R.id.f83714ka);
        this.I = settingView;
        settingView.setUiCallback(new b());
    }

    private void r() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fmh, (ViewGroup) this, true);
        this.f271727i = (TextView) inflate.findViewById(R.id.f98175md);
        p(inflate);
        n(inflate);
        o(inflate);
        m(inflate);
        q(inflate);
    }

    public void setInviteList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.f271724e.setInviteList(list);
        }
    }

    public void setLinkCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f271724e.setCallBack(null);
        }
    }

    public void setMicSeqParam(int i3, String str, qi2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bVar);
            return;
        }
        this.J = i3;
        this.K = str;
        TextView textView = this.f271727i;
        if (textView != null) {
            textView.setText("\u7ba1\u7406" + (this.J + 1) + "\u53f7\u9ea6\u4f4d");
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setText("\u9ea6\u4f4d\u547d\u540d (" + (this.J + 1) + "\u53f7\u4f4d)");
        }
    }

    public void setSettingParam(boolean z16, boolean z17, boolean z18, qi2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), cVar);
        } else {
            this.I.setSettingParam(z16, z17, z18, cVar);
        }
    }

    public void setWaitingList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f271724e.setWaitingList(list);
        }
    }

    public MicSequenceEmptyManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            r();
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public MicSequenceEmptyManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            r();
        } else {
            iPatchRedirector.redirect((short) 9, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
