package com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.a;
import com.tencent.mobileqq.aio.widget.AioMiniProfileLabelFlowLayout;
import com.tencent.mobileqq.aio.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.aio.widget.i;
import com.tencent.mobileqq.aio.widget.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f192093m;

    /* renamed from: d, reason: collision with root package name */
    private Context f192094d;

    /* renamed from: e, reason: collision with root package name */
    private int f192095e;

    /* renamed from: f, reason: collision with root package name */
    private String f192096f;

    /* renamed from: h, reason: collision with root package name */
    private String f192097h;

    /* renamed from: i, reason: collision with root package name */
    private f f192098i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).gotoQZoneUserHome(e.this.f192094d, e.this.f192097h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f192100d;

        b(List list) {
            this.f192100d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) list);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).gotoBigImagePreview(e.this.f192094d, i3, new ArrayList<>(this.f192100d));
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).gotoSignatureHistory(e.this.f192094d, e.this.f192097h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C7323e f192103d;

        d(C7323e c7323e) {
            this.f192103d = c7323e;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) c7323e);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).jumpToQuestionListAndAnswer(view.getContext(), this.f192103d.f192106b);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.e$e, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7323e {
        static IPatchRedirector $redirector_;
        private ImageView A;
        private ImageView B;
        private ImageView C;
        private TextView D;
        private RoundRectImageView E;
        private ImageView F;
        private TextView G;

        /* renamed from: a, reason: collision with root package name */
        public String f192105a;

        /* renamed from: b, reason: collision with root package name */
        public String f192106b;

        /* renamed from: c, reason: collision with root package name */
        private RoundCorneredRelativeLayout f192107c;

        /* renamed from: d, reason: collision with root package name */
        private ViewGroup f192108d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f192109e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f192110f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f192111g;

        /* renamed from: h, reason: collision with root package name */
        private ViewGroup f192112h;

        /* renamed from: i, reason: collision with root package name */
        private View f192113i;

        /* renamed from: j, reason: collision with root package name */
        private View f192114j;

        /* renamed from: k, reason: collision with root package name */
        private TextView f192115k;

        /* renamed from: l, reason: collision with root package name */
        private TextView f192116l;

        /* renamed from: m, reason: collision with root package name */
        private View f192117m;

        /* renamed from: n, reason: collision with root package name */
        private ViewGroup f192118n;

        /* renamed from: o, reason: collision with root package name */
        private FrameLayout f192119o;

        /* renamed from: p, reason: collision with root package name */
        private RoundRectImageView f192120p;

        /* renamed from: q, reason: collision with root package name */
        private AioMiniProfileLabelFlowLayout f192121q;

        /* renamed from: r, reason: collision with root package name */
        private i f192122r;

        /* renamed from: s, reason: collision with root package name */
        private View f192123s;

        /* renamed from: t, reason: collision with root package name */
        private FrameLayout f192124t;

        /* renamed from: u, reason: collision with root package name */
        private TextView f192125u;

        /* renamed from: v, reason: collision with root package name */
        private GridView f192126v;

        /* renamed from: w, reason: collision with root package name */
        private m f192127w;

        /* renamed from: x, reason: collision with root package name */
        private ViewGroup f192128x;

        /* renamed from: y, reason: collision with root package name */
        private TextView f192129y;

        /* renamed from: z, reason: collision with root package name */
        private ViewGroup f192130z;

        C7323e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface f {
        void onClick(View view);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f192093m = new int[]{Color.parseColor("#FFFFDB00"), Color.parseColor("#FF32C5FF"), Color.parseColor("#FFFF7979"), Color.parseColor("#FF64F0BD"), Color.parseColor("#FF9266FF"), Color.parseColor("#FF8FF56F"), Color.parseColor("#FFFFC1A4"), Color.parseColor("#FFFF8C5D"), Color.parseColor("#FF49B3FF"), Color.parseColor("#FFC362FF"), Color.parseColor("#FF629BFF"), Color.parseColor("#FFFE89E1"), Color.parseColor("#FFFFD957"), Color.parseColor("#FF6776FF"), Color.parseColor("#FFEB5FFF"), Color.parseColor("#FFFF63B4"), Color.parseColor("#FF76E4FF"), Color.parseColor("#FFB4E019"), Color.parseColor("#FFFFA967"), Color.parseColor("#FFFF6767")};
        }
    }

    public e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f192096f = str;
            this.f192097h = str2;
        }
    }

    private void e(C7323e c7323e, boolean z16) {
        ViewGroup.LayoutParams layoutParams = c7323e.f192118n.getLayoutParams();
        if (z16) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = ViewUtils.dip2px(60.0f);
        }
    }

    private void f(C7323e c7323e, a.C7322a c7322a) {
        c7323e.f192123s.setVisibility(0);
        c7323e.f192124t.setVisibility(0);
        c7323e.f192130z.setVisibility(0);
        c7323e.D.setText(c7322a.f192065b);
        new com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.b().a(c7323e.f192105a, c7323e.f192106b, c7323e.E, AvatarSizeType.SMALL);
        c7323e.G.setText(c7322a.f192068e);
        c7323e.f192128x.setVisibility(8);
        c7323e.f192129y.setVisibility(8);
        c7323e.f192130z.setOnClickListener(new d(c7323e));
    }

    private void g(C7323e c7323e, a.b bVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        if (bVar == null) {
            c7323e.f192118n.setVisibility(8);
            return;
        }
        c7323e.f192118n.setVisibility(0);
        int i19 = bVar.f192070b;
        boolean z17 = true;
        if (i19 != 1 && i19 != 2) {
            c7323e.f192109e.setVisibility(8);
            i16 = 0;
        } else {
            c7323e.f192109e.setVisibility(0);
            TextView textView = c7323e.f192109e;
            if (bVar.f192070b == 1) {
                i3 = R.string.c7_;
            } else {
                i3 = R.string.b5e;
            }
            textView.setText(i3);
            i16 = 1;
        }
        if (bVar.f192069a > 0) {
            c7323e.f192110f.setVisibility(0);
            c7323e.f192110f.setText(bVar.f192069a + "\u5c81");
            i17 = 1;
        } else {
            c7323e.f192110f.setVisibility(8);
            i17 = 0;
        }
        if (!TextUtils.isEmpty(bVar.f192071c)) {
            c7323e.f192111g.setVisibility(0);
            c7323e.f192111g.setText(bVar.f192071c);
            i18 = 1;
        } else {
            c7323e.f192111g.setVisibility(8);
            i18 = 0;
        }
        int i26 = i16 + i17 + i18;
        if (i26 == 3) {
            c7323e.f192113i.setVisibility(0);
            c7323e.f192114j.setVisibility(0);
        } else if (i26 == 2) {
            if (i17 == 1 && i18 == 1) {
                c7323e.f192113i.setVisibility(8);
                c7323e.f192114j.setVisibility(0);
            } else {
                c7323e.f192113i.setVisibility(0);
                c7323e.f192114j.setVisibility(8);
            }
        } else if (i26 == 1) {
            c7323e.f192113i.setVisibility(8);
            c7323e.f192114j.setVisibility(8);
        } else {
            c7323e.f192113i.setVisibility(8);
            c7323e.f192114j.setVisibility(8);
            c7323e.f192112h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bVar.f192072d)) {
            c7323e.f192115k.setText("\u6765\u81ea\"" + bVar.f192072d + "\"");
            z16 = true;
        } else {
            c7323e.f192115k.setVisibility(8);
            z16 = false;
        }
        if (bVar.f192073e > 0) {
            c7323e.f192116l.setText(bVar.f192073e + "\u4f4d\u5171\u540c\u597d\u53cb");
        } else {
            c7323e.f192116l.setVisibility(8);
            z17 = false;
        }
        if (z17 && z16) {
            c7323e.f192117m.setVisibility(0);
        } else {
            c7323e.f192117m.setVisibility(8);
        }
    }

    private void h(C7323e c7323e, List<String> list) {
        if (list != null && list.size() != 0) {
            c7323e.f192121q.setVisibility(0);
            if (c7323e.f192122r == null) {
                c7323e.f192122r = new i(this.f192094d);
            } else {
                c7323e.f192122r.b();
            }
            c7323e.f192122r.a(list);
            c7323e.f192121q.setAdapter(c7323e.f192122r);
            e(c7323e, true);
            return;
        }
        c7323e.f192121q.setVisibility(8);
        e(c7323e, false);
    }

    private void i(final C7323e c7323e, ah ahVar, final a.d dVar, a.b bVar) {
        int i3;
        Resources resources;
        String str;
        if (c7323e != null && dVar != null && bVar != null) {
            c7323e.f192123s.setVisibility(0);
            c7323e.f192124t.setVisibility(0);
            c7323e.f192128x.setVisibility(0);
            if (bVar.f192070b == 2) {
                i3 = R.string.f183233im;
            } else {
                i3 = R.string.f183733jz;
            }
            Context context = this.f192094d;
            if (context == null) {
                resources = null;
            } else {
                resources = context.getResources();
            }
            if (resources != null) {
                str = resources.getString(i3);
            } else {
                str = "";
            }
            c7323e.f192125u.setText(((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).getResourceText(this.f192094d, 3, i3, str));
            if (c7323e.f192127w == null) {
                c7323e.f192127w = new m(this.f192094d, 3);
            } else {
                if (c7323e.f192127w.d(dVar.f192076a)) {
                    return;
                }
                c7323e.f192127w.h(3);
                c7323e.f192127w.c();
            }
            c7323e.f192127w.a(dVar.f192076a);
            c7323e.f192127w.b(dVar.f192078c);
            c7323e.f192126v.setAdapter((ListAdapter) c7323e.f192127w);
            c7323e.f192126v.setClickable(true);
            c7323e.f192126v.setEnabled(true);
            c7323e.f192124t.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.r(c7323e, dVar, view);
                }
            });
            c7323e.f192126v.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.d
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i16, long j3) {
                    e.this.s(c7323e, dVar, adapterView, view, i16, j3);
                }
            });
            c7323e.f192129y.setVisibility(8);
            c7323e.f192130z.setVisibility(8);
        }
    }

    private void j(C7323e c7323e, a.e eVar) {
        String str;
        c7323e.f192123s.setVisibility(0);
        c7323e.f192124t.setVisibility(0);
        c7323e.f192128x.setVisibility(0);
        TextView textView = c7323e.f192125u;
        if (TextUtils.isEmpty(eVar.f192080a)) {
            str = this.f192094d.getResources().getString(R.string.fyg);
        } else {
            str = eVar.f192080a;
        }
        textView.setText(str);
        if (c7323e.f192127w == null) {
            c7323e.f192127w = new m(this.f192094d, 2);
        } else {
            if (c7323e.f192127w.d(eVar.f192082c)) {
                return;
            }
            c7323e.f192127w.h(2);
            c7323e.f192127w.c();
        }
        c7323e.f192127w.a(eVar.f192082c);
        c7323e.f192126v.setAdapter((ListAdapter) c7323e.f192127w);
        c7323e.f192126v.setClickable(false);
        c7323e.f192126v.setEnabled(false);
        ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).setUIAlphaOnTouchListener(c7323e.f192124t);
        c7323e.f192124t.setOnClickListener(new a());
        c7323e.f192129y.setVisibility(8);
        c7323e.f192130z.setVisibility(8);
    }

    private void l(C7323e c7323e, a.f fVar) {
        BitmapDrawable bitmapDrawable;
        c7323e.f192123s.setVisibility(0);
        c7323e.f192124t.setVisibility(0);
        c7323e.f192129y.setVisibility(0);
        if (fVar.f192083a != 0) {
            bitmapDrawable = ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).getSignActionEmoji(this.f192094d, fVar.f192083a);
        } else {
            bitmapDrawable = null;
        }
        c7323e.f192129y.setCompoundDrawables(bitmapDrawable, null, null, null);
        c7323e.f192129y.setText(fVar.f192084b + " " + fVar.f192085c);
        ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).setUIAlphaOnTouchListener(c7323e.f192124t);
        c7323e.f192124t.setOnClickListener(new c());
        c7323e.f192128x.setVisibility(8);
        c7323e.f192130z.setVisibility(8);
    }

    private boolean m(com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.a aVar) {
        a.d dVar;
        List<String> list;
        if (aVar != null && (dVar = aVar.f192063g) != null && (list = dVar.f192076a) != null && list.size() > 0 && (!aVar.f192063g.f192079d || !n(aVar.f192059c))) {
            return true;
        }
        return false;
    }

    private boolean n(a.e eVar) {
        List<String> list;
        if (eVar != null && (list = eVar.f192082c) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    private String o(List<String> list, int i3) {
        if (list != null && i3 >= 0 && i3 < list.size()) {
            if (i3 == 3) {
                return "mqqapi://qcircle/openmainpage?uin=" + this.f192097h;
            }
            return list.get(i3);
        }
        return "";
    }

    private void p(View view, C7323e c7323e) {
        c7323e.f192107c = (RoundCorneredRelativeLayout) view.findViewById(R.id.f166798ic2);
        c7323e.f192108d = (ViewGroup) view.findViewById(R.id.f760640n);
        c7323e.f192109e = (TextView) view.findViewById(R.id.f108226cj);
        c7323e.f192110f = (TextView) view.findViewById(R.id.k5a);
        c7323e.f192111g = (TextView) view.findViewById(R.id.k9e);
        c7323e.f192112h = (ViewGroup) view.findViewById(R.id.ynd);
        c7323e.f192113i = view.findViewById(R.id.bmu);
        c7323e.f192114j = view.findViewById(R.id.bmv);
        c7323e.f192115k = (TextView) view.findViewById(R.id.f111426l7);
        c7323e.f192116l = (TextView) view.findViewById(R.id.f106976_6);
        c7323e.f192117m = view.findViewById(R.id.ujq);
        c7323e.f192118n = (ViewGroup) view.findViewById(R.id.ynf);
        c7323e.f192119o = (FrameLayout) view.findViewById(R.id.skc);
        c7323e.f192120p = (RoundRectImageView) view.findViewById(R.id.ue_);
        c7323e.f192121q = (AioMiniProfileLabelFlowLayout) view.findViewById(R.id.v87);
        c7323e.f192123s = view.findViewById(R.id.ujy);
        c7323e.f192124t = (FrameLayout) view.findViewById(R.id.v7f);
        c7323e.f192128x = (ViewGroup) view.findViewById(R.id.yqp);
        c7323e.f192125u = (TextView) view.findViewById(R.id.kbs);
        c7323e.f192126v = (GridView) view.findViewById(R.id.x5f);
        c7323e.f192129y = (TextView) view.findViewById(R.id.f111316kw);
        c7323e.f192130z = (ViewGroup) view.findViewById(R.id.yq5);
        c7323e.C = (ImageView) view.findViewById(R.id.f58982rh);
        c7323e.B = (ImageView) view.findViewById(R.id.f58962rf);
        c7323e.A = (ImageView) view.findViewById(R.id.f58972rg);
        c7323e.D = (TextView) view.findViewById(R.id.f59112ru);
        c7323e.E = (RoundRectImageView) view.findViewById(R.id.f58912ra);
        c7323e.F = (ImageView) view.findViewById(R.id.f58922rb);
        c7323e.G = (TextView) view.findViewById(R.id.f59072rq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(C7323e c7323e, a.d dVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("MiniCardBeancurdHelper", 1, "[bindQCircleInfo] container click.");
        VideoReport.reportEvent("dt_clck", c7323e.f192124t, null);
        ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.b(IAIOJumpAction.class)).doUrlAction(this.f192094d, o(dVar.f192077b, 0));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(C7323e c7323e, a.d dVar, AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        QLog.d("MiniCardBeancurdHelper", 1, "[bindQCircleInfo] container item click. position: " + i3);
        VideoReport.reportEvent("dt_clck", c7323e.f192124t, null);
        ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.b(IAIOJumpAction.class)).doUrlAction(this.f192094d, o(dVar.f192077b, i3));
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void t(C7323e c7323e) {
        if (c7323e == null) {
            return;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            c7323e.B.setImageResource(R.drawable.mk5);
            c7323e.A.setImageResource(R.drawable.j5w);
            c7323e.C.setImageResource(R.drawable.j5y);
            c7323e.F.setImageResource(R.drawable.j5u);
        } else {
            c7323e.B.setImageResource(R.drawable.f160092mk4);
            c7323e.A.setImageResource(R.drawable.j5v);
            c7323e.C.setImageResource(R.drawable.j5x);
            c7323e.F.setImageResource(R.drawable.j5t);
        }
        int i3 = this.f192095e;
        int[] iArr = f192093m;
        int length = i3 % iArr.length;
        c7323e.A.clearColorFilter();
        c7323e.A.setColorFilter(iArr[length]);
    }

    public void k(C7323e c7323e, List<a.c> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) c7323e, (Object) list);
            return;
        }
        c7323e.f192123s.setVisibility(0);
        c7323e.f192124t.setVisibility(0);
        c7323e.f192128x.setVisibility(0);
        c7323e.f192125u.setText(this.f192094d.getResources().getString(R.string.d4p));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.c cVar : list) {
            if (!TextUtils.isEmpty(cVar.f192074a) && !TextUtils.isEmpty(cVar.f192075b)) {
                arrayList.add(cVar.f192074a);
                if (!TextUtils.isEmpty(cVar.f192075b)) {
                    str = cVar.f192075b;
                } else {
                    str = cVar.f192074a;
                }
                arrayList2.add(str);
            }
        }
        if (c7323e.f192127w == null) {
            c7323e.f192127w = new m(this.f192094d, 1);
        } else {
            if (c7323e.f192127w.d(arrayList2)) {
                return;
            }
            c7323e.f192127w.c();
            c7323e.f192127w.h(1);
        }
        c7323e.f192127w.a(arrayList2);
        c7323e.f192126v.setAdapter((ListAdapter) c7323e.f192127w);
        c7323e.f192126v.setClickable(true);
        c7323e.f192126v.setEnabled(true);
        c7323e.f192124t.setOnTouchListener(null);
        c7323e.f192124t.setOnClickListener(null);
        c7323e.f192126v.setOnItemClickListener(new b(arrayList));
        c7323e.f192129y.setVisibility(8);
        c7323e.f192130z.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            f fVar = this.f192098i;
            if (fVar != null) {
                fVar.onClick(view);
            }
            VideoReport.reportEvent("dt_clck", view, null);
            ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).gotoProfileCard(view.getContext(), this.f192097h);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q(ah ahVar, com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.a aVar, View view, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ahVar, aVar, view, fVar);
            return;
        }
        if (aVar != null && view != null) {
            this.f192098i = fVar;
            this.f192095e = (int) (Math.random() * f192093m.length);
            this.f192094d = view.getContext();
            C7323e c7323e = new C7323e();
            p(view, c7323e);
            c7323e.f192105a = this.f192096f;
            c7323e.f192106b = this.f192097h;
            int dip2px = ViewUtils.dip2px(16.0f);
            c7323e.f192107c.a(true);
            float f16 = dip2px;
            c7323e.f192107c.setRadius(f16, f16, f16, f16);
            c7323e.f192107c.setOnClickListener(this);
            ((IMiniCardBeancurd) com.tencent.qqnt.aio.adapter.a.b(IMiniCardBeancurd.class)).setUIAlphaOnTouchListener(c7323e.f192107c);
            view.setVisibility(0);
            new com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.b().a(c7323e.f192105a, c7323e.f192106b, c7323e.f192120p, AvatarSizeType.BIG);
            g(c7323e, aVar.f192057a);
            h(c7323e, aVar.f192058b);
            if (m(aVar)) {
                i(c7323e, ahVar, aVar.f192063g, aVar.f192057a);
                g.b(c7323e.f192124t, "em_bas_hot_zone", ahVar);
            } else if (n(aVar.f192059c)) {
                j(c7323e, aVar.f192059c);
            } else {
                a.C7322a c7322a = aVar.f192062f;
                if (c7322a != null) {
                    f(c7323e, c7322a);
                } else {
                    List<a.c> list = aVar.f192060d;
                    if (list != null && list.size() > 0) {
                        k(c7323e, aVar.f192060d);
                    } else {
                        a.f fVar2 = aVar.f192061e;
                        if (fVar2 != null) {
                            l(c7323e, fVar2);
                        } else {
                            c7323e.f192123s.setVisibility(8);
                            c7323e.f192124t.setVisibility(8);
                        }
                    }
                }
            }
            t(c7323e);
        }
    }
}
