package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.util.x;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthorityAccountView extends BaseAuthorityAccountView {
    private TextView M;
    private ImageView N;
    private TextView P;
    private d Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AuthorityAccountView.u(AuthorityAccountView.this);
            AuthorityAccountView authorityAccountView = AuthorityAccountView.this;
            if (!authorityAccountView.L) {
                authorityAccountView.s();
                AuthorityAccountView.this.L = true;
            }
            AuthorityAccountView.this.o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f339533d;

        b(View view) {
            this.f339533d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View findViewById = AuthorityAccountView.this.F.findViewById(R.id.f163852ae);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = ((this.f339533d.getHeight() / 2) + this.f339533d.getTop()) - (findViewById.getHeight() / 2);
            findViewById.setLayoutParams(layoutParams);
            this.f339533d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void b();
    }

    public AuthorityAccountView(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ c u(AuthorityAccountView authorityAccountView) {
        authorityAccountView.getClass();
        return null;
    }

    private void v() {
        View findViewById = this.F.findViewById(R.id.a0s);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new b(findViewById));
    }

    private void x() {
        t.b("AuthorityAccountView", "-->initUI");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(1);
        this.F = LayoutInflater.from(this.f339579f).inflate(R.layout.f168452wj, (ViewGroup) null);
        layoutParams.topMargin = x.c(this.f339579f, 37.0f);
        layoutParams.bottomMargin = x.c(this.f339579f, 37.0f);
        addView(this.F, layoutParams);
        this.N = (ImageView) this.F.findViewById(R.id.f163880b2);
        this.P = (TextView) this.F.findViewById(R.id.f163851ad);
        this.M = (TextView) this.F.findViewById(R.id.f163864ao);
        int f16 = BaseAIOUtils.f(10.0f, getResources());
        BaseAIOUtils.h(this.M, f16, f16, f16, f16);
        this.M.setOnClickListener(new a());
        i();
        Context context = this.f339579f;
        if (context instanceof AuthorityActivity) {
            this.H.setOnClickListener((AuthorityActivity) context);
        } else if (context instanceof QuickLoginAuthorityActivity) {
            this.H.setOnClickListener((QuickLoginAuthorityActivity) context);
        }
        v();
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean l(String str, boolean z16) {
        Context context = this.f339579f;
        if (!(context instanceof AuthorityActivity)) {
            return false;
        }
        ((AuthorityActivity) context).H2(str, z16);
        return true;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean m() {
        d dVar = this.Q;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    public void setAppInfo(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str)) {
            this.P.setText(com.tencent.open.base.j.i(str, 12, true));
        }
        if (bitmap != null) {
            t.f("AuthorityAccountView", "setAppInfo appIcon=" + bitmap);
            this.N.setImageBitmap(bitmap);
        }
    }

    public void setAppType(String str) {
        View view = this.F;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.f163849ab);
            String string = this.f339579f.getResources().getString(R.string.ivb);
            if ("web".equals(str)) {
                string = this.f339579f.getResources().getString(R.string.ivc);
            } else if ("android".equals(str)) {
                string = this.f339579f.getResources().getString(R.string.ivb);
            }
            textView.setText(string);
            t.f("AuthorityAccountView", "setAppType=" + string);
        }
    }

    public void setDeleteLastAccountListener(d dVar) {
        this.Q = dVar;
    }

    public void w() {
        this.M.setVisibility(8);
    }

    public AuthorityAccountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AuthorityAccountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = null;
        x();
    }

    public void setChangeAccountListener(c cVar) {
    }
}
