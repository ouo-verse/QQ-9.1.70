package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    private static final int f252367r;

    /* renamed from: a, reason: collision with root package name */
    public final View f252368a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f252369b;

    /* renamed from: c, reason: collision with root package name */
    public final QUIButton f252370c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f252371d;

    /* renamed from: e, reason: collision with root package name */
    public final QUIButton f252372e;

    /* renamed from: f, reason: collision with root package name */
    public final QUIButton f252373f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f252374g;

    /* renamed from: h, reason: collision with root package name */
    private int f252375h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f252376i;

    /* renamed from: j, reason: collision with root package name */
    private int f252377j;

    /* renamed from: k, reason: collision with root package name */
    private int f252378k;

    /* renamed from: l, reason: collision with root package name */
    private String f252379l;

    /* renamed from: m, reason: collision with root package name */
    private String f252380m;

    /* renamed from: n, reason: collision with root package name */
    private String f252381n;

    /* renamed from: o, reason: collision with root package name */
    private String f252382o;

    /* renamed from: p, reason: collision with root package name */
    private String f252383p;

    /* renamed from: q, reason: collision with root package name */
    private List<MutualMarkModel.Button> f252384q;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f252385d;

        a(d dVar) {
            this.f252385d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!com.tencent.mobileqq.mutualmark.widget.util.e.a("singleButton") && this.f252385d != null) {
                b bVar = b.this;
                if (bVar.f252370c != null) {
                    if (TextUtils.isEmpty(bVar.f252380m)) {
                        this.f252385d.b(view, b.this.f252381n, (MutualMarkModel.Button) b.this.f252370c.getTag(), 0);
                    } else if (((String) b.this.f252370c.getText()).equals(b.this.f252379l)) {
                        this.f252385d.b(view, b.this.f252381n, (MutualMarkModel.Button) b.this.f252370c.getTag(), 0);
                    } else {
                        this.f252385d.b(view, b.this.f252382o, (MutualMarkModel.Button) b.this.f252370c.getTag(), 0);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.widget.detailcard.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class ViewOnClickListenerC8133b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f252387d;

        ViewOnClickListenerC8133b(d dVar) {
            this.f252387d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!com.tencent.mobileqq.mutualmark.widget.util.e.a("coupleButtonLeft")) {
                b bVar = b.this;
                if (bVar.f252372e != null && (dVar = this.f252387d) != null) {
                    dVar.a(view, bVar.f252383p, (MutualMarkModel.Button) b.this.f252372e.getTag(), 0);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f252389d;

        c(d dVar) {
            this.f252389d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!com.tencent.mobileqq.mutualmark.widget.util.e.a("coupleButtonRight") && this.f252389d != null) {
                b bVar = b.this;
                if (bVar.f252373f != null) {
                    if (TextUtils.isEmpty(bVar.f252380m)) {
                        this.f252389d.b(view, b.this.f252381n, (MutualMarkModel.Button) b.this.f252373f.getTag(), 1);
                    } else if (((String) b.this.f252373f.getText()).equals(b.this.f252379l)) {
                        this.f252389d.b(view, b.this.f252381n, (MutualMarkModel.Button) b.this.f252373f.getTag(), 1);
                    } else {
                        this.f252389d.b(view, b.this.f252382o, (MutualMarkModel.Button) b.this.f252373f.getTag(), 1);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        boolean a(View view, String str, MutualMarkModel.Button button, int i3);

        boolean b(View view, String str, MutualMarkModel.Button button, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f252391a;

        /* renamed from: b, reason: collision with root package name */
        String f252392b;

        /* renamed from: c, reason: collision with root package name */
        String f252393c;

        /* renamed from: d, reason: collision with root package name */
        String f252394d;

        /* renamed from: e, reason: collision with root package name */
        String f252395e;

        /* renamed from: f, reason: collision with root package name */
        String f252396f;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            this.f252391a = "";
            this.f252392b = "";
            this.f252393c = "";
            this.f252394d = "";
            this.f252395e = "";
            this.f252396f = "";
        }

        public e a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            }
            this.f252391a = str;
            this.f252392b = str2;
            return this;
        }

        public e b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            }
            this.f252393c = str;
            this.f252394d = str2;
            return this;
        }

        public e c(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            }
            this.f252395e = str;
            this.f252396f = str2;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f252367r = ViewUtils.dip2px(4.0f);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.f252375h = 2;
        this.f252376i = false;
        this.f252379l = "";
        this.f252380m = "";
        this.f252381n = "";
        this.f252382o = "";
        this.f252383p = "";
        this.f252368a = view;
        this.f252369b = (RelativeLayout) view.findViewById(R.id.f164687th4);
        this.f252370c = (QUIButton) view.findViewById(R.id.f164686th3);
        this.f252371d = (RelativeLayout) view.findViewById(R.id.tds);
        this.f252372e = (QUIButton) view.findViewById(R.id.tdt);
        this.f252373f = (QUIButton) view.findViewById(R.id.tdu);
        this.f252374g = (ImageView) view.findViewById(R.id.zro);
        s();
    }

    private void f(List<MutualMarkModel.Button> list, List<MutualMarkModel.Button> list2) {
        for (MutualMarkModel.Button button : list2) {
            if (!button.f252166i) {
                list.add(list.size(), button);
            }
        }
    }

    private void j(QUIButton qUIButton, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                qUIButton.setType(1);
                return;
            }
            return;
        }
        qUIButton.setType(0);
    }

    private void m(QUIButton qUIButton, int i3, @ColorInt int i16, @ColorInt int i17, float f16) {
        if (i3 != 0) {
            if (i3 == 1) {
                t(qUIButton, i17, f16);
                qUIButton.setTextColor(i16);
                return;
            }
            return;
        }
        r(qUIButton, i17, f16);
        qUIButton.setTextColor(i16);
    }

    private void r(QUIButton qUIButton, @ColorInt int i3, float f16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setAlpha(127);
        if (f16 > 0.0f) {
            gradientDrawable.setCornerRadius(f16);
        }
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i3);
        gradientDrawable2.setColor(i3);
        if (f16 > 0.0f) {
            gradientDrawable2.setCornerRadius(f16);
        }
        stateListDrawable.addState(new int[0], gradientDrawable2);
        qUIButton.setBackground(stateListDrawable);
    }

    private void s() {
        Resources resources;
        View view = this.f252368a;
        if (view == null || (resources = view.getResources()) == null) {
            return;
        }
        this.f252374g.setImageDrawable(resources.getDrawable(R.drawable.ksq));
    }

    private void t(QUIButton qUIButton, @ColorInt int i3, float f16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(ViewUtils.dip2px(1.0f), i3);
        gradientDrawable.setColor(0);
        gradientDrawable.setAlpha(127);
        if (f16 > 0.0f) {
            gradientDrawable.setCornerRadius(f16);
        }
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(ViewUtils.dip2px(1.0f), i3);
        gradientDrawable2.setColor(0);
        if (f16 > 0.0f) {
            gradientDrawable2.setCornerRadius(f16);
        }
        stateListDrawable.addState(new int[0], gradientDrawable2);
        qUIButton.setBackground(stateListDrawable);
    }

    public QUIButton g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUIButton) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int i3 = this.f252375h;
        if (i3 == 0) {
            return this.f252370c;
        }
        if (i3 == 1) {
            return this.f252373f;
        }
        return null;
    }

    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.f252375h;
        if (i3 == 0) {
            return this.f252369b;
        }
        if (i3 == 1) {
            return this.f252373f;
        }
        return null;
    }

    public b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        this.f252376i = false;
        this.f252377j = 0;
        this.f252378k = 0;
        MutualMarkModel.Button button = (MutualMarkModel.Button) this.f252370c.getTag();
        if (button != null) {
            j(this.f252370c, button.f252167m);
        }
        MutualMarkModel.Button button2 = (MutualMarkModel.Button) this.f252372e.getTag();
        if (button2 != null) {
            j(this.f252372e, button2.f252167m);
        }
        MutualMarkModel.Button button3 = (MutualMarkModel.Button) this.f252373f.getTag();
        if (button3 != null) {
            j(this.f252373f, button3.f252167m);
        }
        s();
        return this;
    }

    public b k(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
        }
        this.f252370c.setOnClickListener(new a(dVar));
        this.f252372e.setOnClickListener(new ViewOnClickListenerC8133b(dVar));
        this.f252373f.setOnClickListener(new c(dVar));
        return this;
    }

    public b l(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
        this.f252376i = true;
        this.f252377j = i3;
        this.f252378k = i16;
        if (this.f252370c != null && this.f252372e != null && this.f252373f != null) {
            u(str);
            MutualMarkModel.Button button = (MutualMarkModel.Button) this.f252370c.getTag();
            if (button != null) {
                m(this.f252370c, button.f252167m, i3, i16, f252367r);
            }
            MutualMarkModel.Button button2 = (MutualMarkModel.Button) this.f252372e.getTag();
            if (button2 != null) {
                m(this.f252372e, button2.f252167m, i3, i16, f252367r);
            }
            MutualMarkModel.Button button3 = (MutualMarkModel.Button) this.f252373f.getTag();
            if (button3 != null) {
                m(this.f252373f, button3.f252167m, i3, i16, f252367r);
            }
        }
        return this;
    }

    public b n(List<MutualMarkModel.Button> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        }
        if (list == null) {
            return this;
        }
        this.f252384q = list;
        ArrayList arrayList = new ArrayList();
        f(arrayList, list);
        int size = arrayList.size();
        if (size != 1) {
            if (size == 2) {
                p(new e().a(arrayList.get(1).f252163e, arrayList.get(1).f252164f).b(arrayList.get(0).f252163e, arrayList.get(0).f252164f).c(null, ""));
                this.f252370c.setTag(arrayList.get(1));
                this.f252373f.setTag(arrayList.get(1));
                this.f252372e.setTag(arrayList.get(0));
                o(this.f252373f, arrayList.get(1).f252167m);
                o(this.f252372e, arrayList.get(0).f252167m);
            }
        } else {
            p(new e().a(arrayList.get(0).f252163e, arrayList.get(0).f252164f).b(null, "").c(null, ""));
            this.f252370c.setTag(arrayList.get(0));
            this.f252373f.setTag(arrayList.get(0));
            this.f252372e.setTag(null);
            o(this.f252370c, arrayList.get(0).f252167m);
        }
        return this;
    }

    public void o(QUIButton qUIButton, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qUIButton, i3);
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                qUIButton.setType(1);
                if (this.f252376i) {
                    qUIButton.setTextColor(this.f252377j);
                    t(qUIButton, this.f252378k, f252367r);
                    return;
                }
                return;
            }
            return;
        }
        qUIButton.setType(0);
        if (this.f252376i) {
            qUIButton.setTextColor(this.f252377j);
            r(qUIButton, this.f252378k, f252367r);
        }
    }

    public b p(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
        }
        String str = eVar.f252391a;
        this.f252379l = str;
        this.f252381n = eVar.f252392b;
        this.f252383p = eVar.f252394d;
        this.f252370c.setText(str);
        this.f252373f.setText(eVar.f252391a);
        if (!TextUtils.isEmpty(eVar.f252393c)) {
            this.f252372e.setText(eVar.f252393c);
            q(1);
        } else {
            q(0);
        }
        return this;
    }

    public b q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f252375h = 2;
                    this.f252374g.setVisibility(0);
                    this.f252369b.setVisibility(8);
                    this.f252371d.setVisibility(8);
                }
            } else {
                this.f252375h = 1;
                this.f252374g.setVisibility(8);
                this.f252369b.setVisibility(8);
                this.f252371d.setVisibility(0);
            }
        } else {
            this.f252375h = 0;
            this.f252374g.setVisibility(8);
            this.f252369b.setVisibility(0);
            this.f252371d.setVisibility(8);
        }
        return this;
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            this.f252374g.setImageDrawable(com.tencent.mobileqq.mutualmark.widget.util.f.a(str));
        }
    }
}
