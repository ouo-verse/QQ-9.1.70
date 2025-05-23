package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.util.pm.PackageUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SimpleFileBrowserView extends FileBrowserViewBase {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private AsyncImageView f206105k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f206106l;

    /* renamed from: m, reason: collision with root package name */
    private View f206107m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f206108n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f206109o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f206110p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f206111q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f206112r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f206113s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f206114t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f206115u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f206116v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f206117w;

    /* renamed from: x, reason: collision with root package name */
    protected String f206118x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ae.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleFileBrowserView.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.ae.b
        public void a(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) exc);
            } else {
                SimpleFileBrowserView.this.f206113s.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.ae.b
        public void b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                SimpleFileBrowserView.this.f206113s.setText(SimpleFileBrowserView.this.f206085b.getString(R.string.f170948zz1, str, str2));
            }
        }
    }

    public SimpleFileBrowserView(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f206118x = "";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        }
    }

    private void G(boolean z16, boolean z17) {
        LinearLayout linearLayout;
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f206118x)) {
            QLog.i("SimpleFileBrowserView", 1, "setQQBrowserApkInfoViewState not need set new view!");
            return;
        }
        if (this.f206110p != null && (linearLayout = this.f206111q) != null) {
            if (z16 && linearLayout.getVisibility() != 0) {
                this.f206111q.setVisibility(0);
            } else if (!z16 && this.f206111q.getVisibility() == 0) {
                this.f206111q.setVisibility(8);
            }
            if (z17 && this.f206110p.getVisibility() != 0) {
                this.f206110p.setVisibility(0);
                return;
            } else {
                if (!z16 && this.f206110p.getVisibility() == 0) {
                    this.f206110p.setVisibility(8);
                    return;
                }
                return;
            }
        }
        QLog.i("SimpleFileBrowserView", 1, "mQQBrowserApkInfoLl or mQQBrowserApkDescLl is null!");
    }

    private void u() {
        ViewGroup viewGroup;
        View view = this.f206084a;
        if (view == null || (viewGroup = (ViewGroup) view.findViewById(R.id.f27540gi)) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.bottomMargin = ViewUtils.dpToPx(71.0f);
        viewGroup.setLayoutParams(layoutParams);
    }

    public void A(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f206105k.setDefaultImage(i3);
        }
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.f206109o.setText(str);
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f206105k.setImageResource(i3);
        }
    }

    public void D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f206105k.setUrlIconAsyncImage(str);
        }
    }

    public void E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (this.f206108n.getMeasuredWidth() <= 0) {
            this.f206108n.post(new Runnable(str) { // from class: com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206119d;

                {
                    this.f206119d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SimpleFileBrowserView.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SimpleFileBrowserView.this.f206108n.setText(ah.M0(this.f206119d, false, SimpleFileBrowserView.this.f206108n.getMeasuredWidth(), SimpleFileBrowserView.this.f206108n.getPaint(), 2));
                    }
                }
            });
        } else {
            TextView textView = this.f206108n;
            textView.setText(ah.M0(str, false, textView.getMeasuredWidth(), this.f206108n.getPaint(), 2));
        }
    }

    public void F(String str, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) onClickListener);
            return;
        }
        TextView textView = this.f206116v;
        if (textView != null) {
            textView.setText(str);
            this.f206116v.setOnClickListener(onClickListener);
            L(true);
        }
    }

    public void H(String str, int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), onClickListener);
            return;
        }
        View view = this.f206084a;
        if (view == null) {
            return;
        }
        if (this.f206115u == null) {
            this.f206115u = (TextView) view.findViewById(R.id.f793149f);
        }
        TextView textView = this.f206115u;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        if (i3 != 0) {
            this.f206115u.setTextColor(this.f206085b.getResources().getColor(i3));
        }
        this.f206115u.setOnClickListener(onClickListener);
        this.f206115u.setVisibility(0);
        G(false, false);
    }

    public void I(SpannableString spannableString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) spannableString);
            return;
        }
        this.f206106l.setMovementMethod(LinkMovementMethod.getInstance());
        this.f206106l.setText(spannableString);
        this.f206106l.setHighlightColor(17170445);
    }

    public void J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.f206106l;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void K(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        TextView textView = this.f206109o;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        TextView textView = this.f206116v;
        if (textView != null) {
            RelativeLayout relativeLayout = this.f206086c;
            int i3 = 8;
            if (relativeLayout != null) {
                if (z16 && relativeLayout.getVisibility() != 0) {
                    this.f206116v.setVisibility(0);
                } else {
                    this.f206116v.setVisibility(8);
                }
            } else {
                if (z16) {
                    i3 = 0;
                }
                textView.setVisibility(i3);
            }
            if (this.f206116v.getVisibility() == 0) {
                G(false, false);
                u();
            }
        }
    }

    public void M(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        TextView textView = this.f206117w;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        TextView textView = this.f206106l;
        if (textView == null) {
            return;
        }
        if (z16 && !TextUtils.isEmpty(textView.getText())) {
            this.f206106l.setVisibility(0);
        } else {
            this.f206106l.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f206084a;
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void d(String str, int i3, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), onClickListener);
            return;
        }
        super.e(str, onClickListener);
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f206118x)) {
            QLog.i("SimpleFileBrowserView", 1, "initActionButton not need show new view!");
            return;
        }
        if (i3 != 2) {
            G(false, false);
            QLog.i("SimpleFileBrowserView", 1, "initActionButton transStatus is flag exist!");
        } else if (PackageUtil.isPackageInstalled(BaseApplication.getContext(), TbsConfig.APP_QB)) {
            G(true, false);
        } else {
            G(true, true);
            x();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void g() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("SimpleFileBrowserView", 1, "initFileView()");
        if (this.f206084a == null) {
            com.tencent.mobileqq.tbstool.gray.b bVar = com.tencent.mobileqq.tbstool.gray.b.f291450a;
            if (bVar.g(this.f206118x)) {
                i3 = R.layout.f168653g74;
            } else {
                i3 = R.layout.amn;
            }
            View inflate = this.f206085b.getLayoutInflater().inflate(i3, (ViewGroup) null, false);
            this.f206084a = inflate;
            this.f206106l = (TextView) inflate.findViewById(R.id.c_m);
            this.f206105k = (AsyncImageView) this.f206084a.findViewById(R.id.ap5);
            this.f206108n = (TextView) this.f206084a.findViewById(R.id.c_g);
            this.f206109o = (TextView) this.f206084a.findViewById(R.id.c_c);
            this.f206091h = (TextView) this.f206084a.findViewById(R.id.fdn);
            this.f206116v = (TextView) this.f206084a.findViewById(R.id.s8z);
            if (bVar.g(this.f206118x)) {
                this.f206110p = (LinearLayout) this.f206084a.findViewById(R.id.f59182s1);
                this.f206111q = (LinearLayout) this.f206084a.findViewById(R.id.f59172s0);
                this.f206112r = (TextView) this.f206084a.findViewById(R.id.f59202s3);
                this.f206113s = (TextView) this.f206084a.findViewById(R.id.f59192s2);
            }
            this.f206107m = this.f206084a;
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        super.q(z16);
        if (z16) {
            L(false);
        }
    }

    public void v(String str, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Boolean.valueOf(z16));
            return;
        }
        View view = this.f206084a;
        if (view == null) {
            return;
        }
        if (this.f206114t == null) {
            this.f206114t = (TextView) view.findViewById(R.id.azh);
        }
        TextView textView = this.f206114t;
        if (textView == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        this.f206114t.setText(str);
        G(false, false);
    }

    public void w(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onClickListener);
            return;
        }
        View view = this.f206084a;
        if (view == null) {
            return;
        }
        if (this.f206117w == null) {
            this.f206117w = (TextView) view.findViewById(R.id.lk7);
        }
        this.f206117w.setOnClickListener(onClickListener);
        G(false, false);
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.f206113s != null && this.f206112r != null) {
            SpannableString spannableString = new SpannableString(this.f206085b.getString(R.string.f170950zz3));
            ae.q(this.f206085b, spannableString, "https://upage.imtt.qq.com/m_imtt/app_authority_page/real/app_authority_page.html", spannableString.length() - 8, spannableString.length() - 6);
            ae.q(this.f206085b, spannableString, "https://privacy.tencent.com/document/priview/2491347092a64d7fa00cbc2bf68fbbbb?addressbar=hide", spannableString.length() - 5, spannableString.length() - 3);
            ae.q(this.f206085b, spannableString, "https://rule.tencent.com/rule/preview/d7b6c1cb-d5b7-4c31-916a-35b4e48ec40f", spannableString.length() - 2, spannableString.length());
            this.f206112r.setText(spannableString);
            this.f206112r.setMovementMethod(LinkMovementMethod.getInstance());
            ae.p(this.f206085b, new a());
            return;
        }
        QLog.i("SimpleFileBrowserView", 1, "initQQBrowserDeveloperDesc mAppDescTv or mDeveloperDescTv is null!");
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SimpleFileBrowserView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SimpleFileBrowserView simpleFileBrowserView = SimpleFileBrowserView.this;
                    if (simpleFileBrowserView.f206084a != simpleFileBrowserView.f206107m) {
                        SimpleFileBrowserView simpleFileBrowserView2 = SimpleFileBrowserView.this;
                        simpleFileBrowserView2.f206084a = simpleFileBrowserView2.f206107m;
                    }
                }
            });
        }
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.f206105k.setApkIconAsyncImage(str);
        }
    }

    public SimpleFileBrowserView(Activity activity, String str) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f206118x = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str);
        }
    }
}
