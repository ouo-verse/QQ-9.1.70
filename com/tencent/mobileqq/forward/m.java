package com.tencent.mobileqq.forward;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MaxHeightRelativelayout;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected View f211029a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f211030b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f211031c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f211032d;

    /* renamed from: e, reason: collision with root package name */
    protected MaxHeightRelativelayout f211033e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f211034f;

    /* renamed from: g, reason: collision with root package name */
    protected QQCustomDialog f211035g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                m.this.f();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public m(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQCustomDialog);
            return;
        }
        this.f211035g = qQCustomDialog;
        this.f211030b = qQCustomDialog.getContext();
        e();
        this.f211033e.setMaxHeight(Math.max(qQCustomDialog.getRootViewHeight() - this.f211030b.getResources().getDimensionPixelSize(R.dimen.f158884rk), BaseAIOUtils.f(b(), this.f211030b.getResources())));
    }

    protected abstract View a();

    protected abstract int b();

    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f211029a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f211032d.setVisibility(8);
        }
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(this.f211030b).inflate(R.layout.f167836j6, (ViewGroup) null);
        this.f211029a = inflate;
        this.f211031c = (TextView) inflate.findViewById(R.id.kfu);
        this.f211033e = (MaxHeightRelativelayout) this.f211029a.findViewById(R.id.f166799ic3);
        this.f211034f = (ImageView) this.f211029a.findViewById(R.id.did);
        this.f211032d = (RelativeLayout) this.f211029a.findViewById(R.id.icw);
        View a16 = a();
        if (a16 != null) {
            this.f211033e.addView(a16);
        }
        this.f211034f.setOnClickListener(new a());
        int dip2px = ViewUtils.dip2px(15.0f);
        BaseAIOUtils.h(this.f211034f, dip2px, dip2px, dip2px, dip2px);
        this.f211034f.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        SimpleModeHelper.p(this.f211029a);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            g();
            this.f211035g.removePreviewView();
        }
    }

    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f211031c.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f211032d.setVisibility(0);
        }
    }
}
