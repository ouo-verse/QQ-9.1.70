package com.tencent.now.linkpkanchorplay.AcceptInvite.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.base.AnchorDetailInfoView;
import com.tencent.now.linkpkanchorplay.base.CommonToggleButton;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AcceptInviteView extends LinearLayout implements ThreadCenter.HandlerKeyable {
    LinkPKHeadImageView C;
    TextView D;
    private gm3.a E;
    LifecycleOwner F;
    private boolean G;
    private int H;
    private d I;
    private Runnable J;

    /* renamed from: d, reason: collision with root package name */
    private View f338109d;

    /* renamed from: e, reason: collision with root package name */
    private AnchorDetailInfoView f338110e;

    /* renamed from: f, reason: collision with root package name */
    private Button f338111f;

    /* renamed from: h, reason: collision with root package name */
    private Button f338112h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f338113i;

    /* renamed from: m, reason: collision with root package name */
    private CommonToggleButton f338114m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AcceptInviteView.this.k();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AcceptInviteView.this.j();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            AcceptInviteView.this.G = z16;
            AcceptInviteView.this.H = 1;
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void onHide();
    }

    public AcceptInviteView(@NonNull Context context) {
        super(context);
        this.H = 15;
        this.J = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteView.4
            @Override // java.lang.Runnable
            public void run() {
                if (AcceptInviteView.this.f338111f != null && AcceptInviteView.this.f338111f.getContext() != null) {
                    AcceptInviteView acceptInviteView = AcceptInviteView.this;
                    acceptInviteView.H--;
                    if (AcceptInviteView.this.H > 0) {
                        AcceptInviteView.this.f338111f.setText("\u62d2\u7edd\uff08" + AcceptInviteView.this.H + "\u79d2\uff09");
                        AcceptInviteView acceptInviteView2 = AcceptInviteView.this;
                        ThreadCenter.postDelayedUITask(acceptInviteView2, acceptInviteView2.J, 1000L);
                        return;
                    }
                    AcceptInviteView.this.f338111f.setText("\u62d2\u7edd");
                    AcceptInviteView.this.k();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.E.M1();
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.E.Q1(this.G);
        u();
    }

    private void m(int i3) {
        this.f338111f = (Button) this.f338109d.findViewById(R.id.f72433qu);
        this.f338112h = (Button) this.f338109d.findViewById(R.id.s6r);
        x(i3);
        this.f338111f.setOnClickListener(new a());
        this.f338112h.setOnClickListener(new b());
    }

    private void n(String str, e55.a aVar) {
        gm3.a aVar2 = this.E;
        if (aVar2 != null && aVar != null) {
            aVar2.S1(str, aVar);
        }
    }

    private void o(int i3) {
        TextView textView = (TextView) this.f338109d.findViewById(R.id.f166992jq2);
        this.f338113i = textView;
        textView.setText(fn3.c.f(getContext(), i3));
    }

    private void p() {
        CommonToggleButton commonToggleButton = (CommonToggleButton) this.f338109d.findViewById(R.id.zsg);
        this.f338114m = commonToggleButton;
        commonToggleButton.setChecked(false);
        this.f338114m.setOnCheckedChangeListener(new c());
    }

    private void q(int i3, e55.a aVar) {
        if (i3 != 2 && i3 != 4) {
            this.f338109d = LayoutInflater.from(getContext()).inflate(R.layout.fdn, (ViewGroup) this, true);
            p();
            AnchorDetailInfoView anchorDetailInfoView = (AnchorDetailInfoView) this.f338109d.findViewById(R.id.so9);
            this.f338110e = anchorDetailInfoView;
            anchorDetailInfoView.setAnchorInfo(aVar);
        } else {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fdo, (ViewGroup) this, true);
            this.f338109d = inflate;
            this.C = (LinkPKHeadImageView) inflate.findViewById(R.id.a2o);
            this.D = (TextView) this.f338109d.findViewById(R.id.f9d);
            ImageLoader.getInstance().displayImage(aVar.f395729a.f395738d, this.C, hm3.a.a());
            this.D.setText(aVar.f395729a.f395737c);
        }
        o(i3);
        m(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(String str) {
        if (!TextUtils.isEmpty(str)) {
            UIUtil.h(str, false, 1);
        }
    }

    private void u() {
        ThreadCenter.clear(this);
        d dVar = this.I;
        if (dVar != null) {
            dVar.onHide();
        }
        this.f338111f = null;
        this.f338112h = null;
        this.E.O1().removeObservers(this.F);
        this.E.P1().removeObservers(this.F);
    }

    private void v(LifecycleOwner lifecycleOwner) {
        this.E.P1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AcceptInviteView.s((Boolean) obj);
            }
        });
        this.E.O1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.view.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AcceptInviteView.t((String) obj);
            }
        });
    }

    private void x(int i3) {
        this.f338112h.setText(fn3.c.a(getContext(), i3));
    }

    public int l() {
        return this.H;
    }

    public void r(int i3, String str, e55.a aVar) {
        q(i3, aVar);
        n(str, aVar);
        ThreadCenter.postDelayedUITask(this, this.J, 1000L);
    }

    public void setCallback(d dVar) {
        this.I = dVar;
    }

    public void setRemainRefuseTime(int i3) {
        this.H = i3;
        this.f338111f.setText("\u62d2\u7edd\uff08" + this.H + "\u79d2\uff09");
    }

    public void setViewModelContext(ViewModelStoreOwner viewModelStoreOwner, LifecycleOwner lifecycleOwner) {
        if (this.E == null && viewModelStoreOwner != null) {
            this.F = lifecycleOwner;
            gm3.a aVar = (gm3.a) new ViewModelProvider(viewModelStoreOwner).get(gm3.a.class);
            this.E = aVar;
            aVar.R1();
            v(lifecycleOwner);
        }
    }

    public void w() {
        u();
    }

    public AcceptInviteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 15;
        this.J = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteView.4
            @Override // java.lang.Runnable
            public void run() {
                if (AcceptInviteView.this.f338111f != null && AcceptInviteView.this.f338111f.getContext() != null) {
                    AcceptInviteView acceptInviteView = AcceptInviteView.this;
                    acceptInviteView.H--;
                    if (AcceptInviteView.this.H > 0) {
                        AcceptInviteView.this.f338111f.setText("\u62d2\u7edd\uff08" + AcceptInviteView.this.H + "\u79d2\uff09");
                        AcceptInviteView acceptInviteView2 = AcceptInviteView.this;
                        ThreadCenter.postDelayedUITask(acceptInviteView2, acceptInviteView2.J, 1000L);
                        return;
                    }
                    AcceptInviteView.this.f338111f.setText("\u62d2\u7edd");
                    AcceptInviteView.this.k();
                }
            }
        };
    }

    public AcceptInviteView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = 15;
        this.J = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.AcceptInvite.view.AcceptInviteView.4
            @Override // java.lang.Runnable
            public void run() {
                if (AcceptInviteView.this.f338111f != null && AcceptInviteView.this.f338111f.getContext() != null) {
                    AcceptInviteView acceptInviteView = AcceptInviteView.this;
                    acceptInviteView.H--;
                    if (AcceptInviteView.this.H > 0) {
                        AcceptInviteView.this.f338111f.setText("\u62d2\u7edd\uff08" + AcceptInviteView.this.H + "\u79d2\uff09");
                        AcceptInviteView acceptInviteView2 = AcceptInviteView.this;
                        ThreadCenter.postDelayedUITask(acceptInviteView2, acceptInviteView2.J, 1000L);
                        return;
                    }
                    AcceptInviteView.this.f338111f.setText("\u62d2\u7edd");
                    AcceptInviteView.this.k();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Boolean bool) {
    }
}
