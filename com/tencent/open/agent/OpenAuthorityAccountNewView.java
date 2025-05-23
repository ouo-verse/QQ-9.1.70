package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.dialog.SlideBottomDialog;
import com.tencent.open.agent.OpenCardNewContainer;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenAuthorityAccountNewView extends BaseAuthorityAccountView {
    boolean M;
    private OpenCardNewContainer.d N;
    private SlideBottomDialog P;
    private boolean Q;
    private View R;
    private TextView S;
    public TextView T;
    private ImageView U;
    private long V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (OpenAuthorityAccountNewView.this.N != null) {
                OpenAuthorityAccountNewView.this.N.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public OpenAuthorityAccountNewView(Context context) {
        this(context, null);
    }

    private void x() {
        t.b("OpenAuthorityAccountView", "-->initUI");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(1);
        View inflate = LayoutInflater.from(this.f339579f).inflate(R.layout.ftn, (ViewGroup) null);
        this.F = inflate;
        addView(inflate, layoutParams);
        this.R = this.F.findViewById(R.id.s85);
        TextView textView = (TextView) this.F.findViewById(R.id.f11994788);
        this.S = textView;
        textView.setVisibility(4);
        i();
        this.H.setOnClickListener(new a());
        this.T = (TextView) this.F.findViewById(R.id.tr8);
        this.U = (ImageView) findViewById(R.id.im7);
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void c() {
        SlideBottomDialog slideBottomDialog;
        if (this.Q && (slideBottomDialog = this.P) != null && slideBottomDialog.isShowing()) {
            this.P.R();
        } else {
            super.c();
        }
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected int e() {
        if (this.Q) {
            return R.layout.ftq;
        }
        return super.e();
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected int f() {
        if (this.Q) {
            return R.layout.ftm;
        }
        return super.f();
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean l(String str, boolean z16) {
        OpenCardNewContainer.d dVar;
        if ((this.f339579f instanceof PublicFragmentActivityForOpenSDK) && (dVar = this.N) != null) {
            dVar.c(str, z16);
            return true;
        }
        return false;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean m() {
        Context context = this.f339579f;
        if (context != null && (context instanceof PublicFragmentActivityForOpenSDK)) {
            OpenCardNewContainer.d dVar = this.N;
            if (dVar != null) {
                dVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    public void setAccountEventListener(OpenCardNewContainer.d dVar) {
        this.N = dVar;
    }

    public void setMainAccountSelect(boolean z16) {
        if (this.M) {
            return;
        }
        int i3 = 0;
        t.b("OpenAuthorityAccountView", "setMainAccountSelect select=" + z16);
        ImageView imageView = this.U;
        if (!z16) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void setPermissionListMode(boolean z16) {
        this.M = z16;
        if (z16) {
            this.U.setVisibility(8);
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
            this.U.setVisibility(0);
        }
    }

    public long v() {
        return this.V;
    }

    public boolean w() {
        return this.M;
    }

    public OpenAuthorityAccountNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OpenAuthorityAccountNewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = false;
        this.N = null;
        this.V = 0L;
        this.Q = lq3.a.a();
        x();
    }
}
