package com.tencent.mobileqq.activity.history.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View f182729a;

    /* renamed from: b, reason: collision with root package name */
    private View f182730b;

    /* renamed from: c, reason: collision with root package name */
    private View f182731c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f182732d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f182733e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f182734f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f182735g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f182736h;

    /* renamed from: i, reason: collision with root package name */
    private QQBlurView f182737i;

    /* renamed from: j, reason: collision with root package name */
    private Context f182738j;

    /* renamed from: k, reason: collision with root package name */
    private c f182739k;

    /* renamed from: l, reason: collision with root package name */
    private d f182740l;

    /* renamed from: m, reason: collision with root package name */
    private View f182741m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.widget.b f182742n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.history.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C7168a implements QQBlur.c {
        static IPatchRedirector $redirector_;

        C7168a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void b(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.filemanager.widget.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.b
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            if (a.this.c() && a.this.f182739k != null) {
                if (view.getId() == R.id.brq) {
                    a.this.f182739k.c(1);
                    return;
                }
                if (view.getId() == R.id.brw) {
                    a.this.f182739k.c(3);
                    return;
                }
                if (view.getId() == R.id.brr) {
                    a.this.f182739k.c(2);
                } else if (view.getId() == R.id.brp) {
                    a.this.f182739k.c(4);
                } else if (view.getId() == R.id.upm) {
                    a.this.f182739k.c(5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void c(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(boolean z16);
    }

    public a(Context context, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) viewGroup);
            return;
        }
        this.f182742n = new b();
        this.f182738j = context;
        this.f182729a = viewGroup;
        this.f182730b = LayoutInflater.from(context).inflate(R.layout.ald, (ViewGroup) null, false);
        if (!(viewGroup instanceof RelativeLayout)) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            viewGroup.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
            viewGroup = relativeLayout;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        viewGroup.addView(this.f182730b, layoutParams);
        this.f182732d = (ImageView) this.f182730b.findViewById(R.id.upm);
        this.f182733e = (ImageView) this.f182730b.findViewById(R.id.brq);
        this.f182734f = (ImageView) this.f182730b.findViewById(R.id.brw);
        this.f182735g = (ImageView) this.f182730b.findViewById(R.id.brr);
        this.f182736h = (ImageView) this.f182730b.findViewById(R.id.brp);
        this.f182731c = this.f182730b.findViewById(R.id.brm);
        this.f182732d.setVisibility(8);
        this.f182733e.setVisibility(8);
        this.f182734f.setVisibility(8);
        this.f182735g.setVisibility(8);
        this.f182736h.setVisibility(8);
        this.f182732d.setOnClickListener(this.f182742n);
        this.f182733e.setOnClickListener(this.f182742n);
        this.f182734f.setOnClickListener(this.f182742n);
        this.f182735g.setOnClickListener(this.f182742n);
        this.f182736h.setOnClickListener(this.f182742n);
        this.f182732d.setImageResource(R.drawable.qui_collection_light_selector);
        this.f182733e.setImageResource(R.drawable.qui_download_light_selector);
        this.f182735g.setImageResource(R.drawable.qui_share_light_selector);
        this.f182736h.setImageResource(R.drawable.qui_delete_light_selector);
        this.f182734f.setImageResource(R.drawable.qui_weiyun_light_selector);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (!NetworkUtil.isNetSupport(this.f182738j)) {
            FileManagerUtil.dealWithErrCode(this.f182738j.getString(R.string.bqf));
            return false;
        }
        return true;
    }

    private void e(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ListView) {
                this.f182741m = view2;
                return;
            } else if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    arrayList.add(viewGroup.getChildAt(i3));
                }
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f182730b.setVisibility(8);
        d dVar = this.f182740l;
        if (dVar != null) {
            dVar.a(false);
        }
        QQBlurView qQBlurView = this.f182737i;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
            this.f182737i = null;
        }
    }

    @TargetApi(19)
    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QQBlurView qQBlurView = this.f182737i;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
            this.f182737i = null;
        }
        if (this.f182741m == null) {
            return;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.f182731c.setBackgroundResource(R.drawable.qfile_file_activity_div);
            return;
        }
        QQBlurView qQBlurView2 = (QQBlurView) this.f182730b.findViewById(R.id.kmg);
        this.f182737i = qQBlurView2;
        qQBlurView2.setVisibility(0);
        this.f182737i.j(this.f182741m);
        QQBlurView qQBlurView3 = this.f182737i;
        qQBlurView3.m(qQBlurView3);
        this.f182737i.z(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
        this.f182737i.k(0);
        this.f182737i.p(-1);
        this.f182737i.A(8.0f);
        this.f182737i.l(8);
        this.f182737i.q(new C7168a());
        this.f182737i.x();
        this.f182737i.onResume();
    }

    public void g(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 4) {
                            if (intValue == 5) {
                                this.f182732d.setVisibility(0);
                            }
                        } else {
                            this.f182736h.setVisibility(0);
                        }
                    } else {
                        this.f182734f.setVisibility(0);
                    }
                } else {
                    this.f182735g.setVisibility(0);
                }
            } else {
                this.f182733e.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList(5);
        if (list.contains(1)) {
            arrayList.add(this.f182733e);
        }
        if (list.contains(2)) {
            arrayList.add(this.f182735g);
        }
        if (list.contains(5)) {
            arrayList.add(this.f182732d);
        }
        if (list.contains(3)) {
            arrayList.add(this.f182734f);
        }
        if (list.contains(4)) {
            arrayList.add(this.f182736h);
        }
        av.a((ViewGroup) this.f182731c, (View[]) arrayList.toArray(new View[0]));
    }

    public void h(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            this.f182732d.setEnabled(z16);
                            return;
                        }
                        return;
                    }
                    this.f182736h.setEnabled(z16);
                    return;
                }
                this.f182734f.setEnabled(z16);
                return;
            }
            this.f182735g.setEnabled(z16);
            return;
        }
        this.f182733e.setEnabled(z16);
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        h(1, z16);
        h(2, z16);
        h(3, z16);
        h(4, z16);
        h(5, z16);
    }

    public void j(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.f182739k = cVar;
        }
    }

    public void k(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            this.f182740l = dVar;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f182741m == null) {
            e(this.f182729a);
            if (this.f182741m == null) {
                this.f182741m = this.f182730b;
            }
        }
        this.f182730b.setVisibility(0);
        d dVar = this.f182740l;
        if (dVar != null) {
            dVar.a(true);
        }
        f();
    }
}
