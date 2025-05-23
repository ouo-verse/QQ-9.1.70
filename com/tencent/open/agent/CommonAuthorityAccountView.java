package com.tencent.open.agent;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.dialog.SlideBottomDialog;
import com.tencent.open.agent.CommonCardContainer;
import com.tencent.open.agent.util.t;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CommonAuthorityAccountView extends BaseAuthorityAccountView {
    private View M;
    private CommonCardContainer.e N;
    private SlideBottomDialog P;
    private boolean Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommonAuthorityAccountView.this.N != null) {
                CommonAuthorityAccountView.this.N.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CommonAuthorityAccountView(Context context) {
        this(context, null);
    }

    private void w() {
        SlideBottomDialog slideBottomDialog = new SlideBottomDialog(getContext());
        this.P = slideBottomDialog;
        slideBottomDialog.X(this.G);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cxj) + (getResources().getDimensionPixelSize(R.dimen.cxl) * 2);
        this.P.W((dimensionPixelSize * 6) + getResources().getDimensionPixelSize(R.dimen.cxk));
    }

    private void x() {
        t.b("OpenAuthorityAccountView", "-->initUI");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(1);
        View inflate = LayoutInflater.from(this.f339579f).inflate(R.layout.fto, (ViewGroup) null);
        this.F = inflate;
        addView(inflate, layoutParams);
        i();
        this.H.setOnClickListener(new a());
        this.M = findViewById(R.id.im7);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public int e() {
        if (this.Q) {
            return R.layout.ftq;
        }
        return super.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public int f() {
        if (this.Q) {
            return R.layout.ftm;
        }
        return super.f();
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean l(String str, boolean z16) {
        CommonCardContainer.e eVar;
        if ((this.f339579f instanceof PublicFragmentActivityForOpenSDK) && (eVar = this.N) != null) {
            eVar.c(str, z16);
            return true;
        }
        return false;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean m() {
        Context context = this.f339579f;
        if (context != null && (context instanceof PublicFragmentActivityForOpenSDK)) {
            CommonCardContainer.e eVar = this.N;
            if (eVar != null) {
                eVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void o() {
        if (!this.L) {
            s();
            this.L = true;
        }
        if (this.Q) {
            if (this.P == null) {
                w();
            }
            SlideBottomDialog slideBottomDialog = this.P;
            if (slideBottomDialog != null && !slideBottomDialog.isShowing()) {
                this.P.Y();
                return;
            }
            return;
        }
        super.o();
    }

    public void setAccountEventListener(CommonCardContainer.e eVar) {
        this.N = eVar;
    }

    public void setMainAccountSelect(boolean z16) {
        int i3 = 0;
        t.b("OpenAuthorityAccountView", "setMainAccountSelect select=" + z16);
        View view = this.M;
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void t(String str) {
        int i3;
        super.t(str);
        if (this.F != null && OpenConfig.o()) {
            boolean isNowThemeIsNight = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
            TextView textView = (TextView) this.F.findViewById(R.id.a0t);
            if (isNowThemeIsNight) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            textView.setTextColor(i3);
        }
    }

    public String v(String str) {
        String c16 = com.tencent.mobileqq.login.account.b.c(str);
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        return str;
    }

    public CommonAuthorityAccountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonAuthorityAccountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = null;
        this.Q = lq3.a.a();
        x();
    }
}
