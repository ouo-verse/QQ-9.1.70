package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SettingView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private e E;

    /* renamed from: d, reason: collision with root package name */
    private View f271801d;

    /* renamed from: e, reason: collision with root package name */
    private View f271802e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f271803f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f271804h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f271805i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f271806m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (SettingView.this.E != null) {
                SettingView.this.E.onBack();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(SettingView.this.f271803f, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(0, SettingView.this.f271806m));
                SettingView.this.p(!r0.f271806m);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(SettingView.this.f271804h, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(1, SettingView.this.C));
                SettingView.this.m(!r0.C);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(SettingView.this.f271805i, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(2, SettingView.this.D));
                SettingView.this.n(!r0.D);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface e {
        void onBack();
    }

    public SettingView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f271806m = false;
        this.C = false;
        this.D = false;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        o(z16, this.f271804h);
        this.C = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z16) {
        o(z16, this.f271805i);
        this.D = z16;
    }

    private void o(boolean z16, ImageView imageView) {
        int i3;
        if (z16) {
            i3 = R.drawable.n2h;
        } else {
            i3 = R.drawable.n2g;
        }
        imageView.setImageResource(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        o(z16, this.f271803f);
        this.f271806m = z16;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindPageParamsToRootView(this.f271801d, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271803f, IMultiAvChatReporter.ELEMENT_SETTINGS, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(0, this.f271806m));
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271804h, IMultiAvChatReporter.ELEMENT_SETTINGS, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(1, this.C));
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271805i, IMultiAvChatReporter.ELEMENT_SETTINGS, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateSettingsElementParam(2, this.D));
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fm_, (ViewGroup) this, true);
        this.f271801d = inflate;
        View findViewById = inflate.findViewById(R.id.snl);
        this.f271802e = findViewById;
        findViewById.setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f271801d.findViewById(R.id.snh);
        this.f271803f = imageView;
        imageView.setOnClickListener(new b());
        ImageView imageView2 = (ImageView) this.f271801d.findViewById(R.id.sn6);
        this.f271804h = imageView2;
        imageView2.setOnClickListener(new c());
        ImageView imageView3 = (ImageView) this.f271801d.findViewById(R.id.sn8);
        this.f271805i = imageView3;
        imageView3.setOnClickListener(new d());
    }

    public void setSettingParam(boolean z16, boolean z17, boolean z18, qi2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), cVar);
            return;
        }
        this.f271806m = z16;
        o(z16, this.f271803f);
        this.C = z17;
        o(z17, this.f271804h);
        this.D = z18;
        o(z18, this.f271805i);
    }

    public void setUiCallback(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        } else {
            this.E = eVar;
        }
    }

    public SettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271806m = false;
        this.C = false;
        this.D = false;
        l();
    }

    public SettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f271806m = false;
        this.C = false;
        this.D = false;
        l();
    }
}
