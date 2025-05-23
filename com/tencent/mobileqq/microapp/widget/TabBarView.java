package com.tencent.mobileqq.microapp.widget;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TabBarView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f246084a;

    /* renamed from: b, reason: collision with root package name */
    private k f246085b;

    /* renamed from: c, reason: collision with root package name */
    private b f246086c;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void onTabItemClick(int i3, String str);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator it = this.f246084a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.f246095i.f245870a.equals(str)) {
                a(aVar);
            }
        }
    }

    public void a(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            return;
        }
        this.f246085b = kVar;
        if (kVar != null) {
            k clone = kVar.clone();
            this.f246085b = clone;
            a(clone.f245869f);
            if (this.f246084a.size() > 0) {
                ((a) this.f246084a.getFirst()).a(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f246087a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f246088b;

        /* renamed from: c, reason: collision with root package name */
        public View f246089c;

        /* renamed from: d, reason: collision with root package name */
        public View f246090d;

        /* renamed from: e, reason: collision with root package name */
        public View f246091e;

        /* renamed from: f, reason: collision with root package name */
        public View f246092f;

        /* renamed from: g, reason: collision with root package name */
        public Drawable f246093g;

        /* renamed from: h, reason: collision with root package name */
        public Drawable f246094h;

        /* renamed from: i, reason: collision with root package name */
        public k.a f246095i;

        /* renamed from: j, reason: collision with root package name */
        public k f246096j;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static a a(View view, k.a aVar, k kVar) {
            a aVar2 = new a();
            aVar2.f246087a = (TextView) view.findViewById(R.id.m);
            aVar2.f246088b = (ImageView) view.findViewById(R.id.i);
            aVar2.f246089c = view.findViewById(R.id.p);
            aVar2.f246090d = view.findViewById(R.id.b);
            aVar2.f246091e = view.findViewById(R.id.c);
            view.findViewById(R.id.l);
            view.findViewById(R.id.a);
            aVar2.f246092f = view;
            aVar2.f246096j = kVar;
            aVar2.f246095i = aVar;
            return aVar2;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if ("top".equals(this.f246096j.f245868e)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f246087a.getLayoutParams();
                layoutParams.bottomMargin = DisplayUtil.dip2px(this.f246092f.getContext(), 15.0f);
                layoutParams.topMargin = DisplayUtil.dip2px(this.f246092f.getContext(), 15.0f);
                this.f246087a.setLayoutParams(layoutParams);
                this.f246087a.setTextSize(1, 15.0f);
                this.f246088b.setVisibility(8);
                this.f246089c.setVisibility(8);
                this.f246090d.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f246087a.getLayoutParams();
                layoutParams2.bottomMargin = DisplayUtil.dip2px(this.f246092f.getContext(), 5.0f);
                layoutParams2.topMargin = DisplayUtil.dip2px(this.f246092f.getContext(), 0.0f);
                this.f246087a.setLayoutParams(layoutParams2);
                this.f246087a.setTextSize(1, 12.0f);
                this.f246090d.setVisibility(8);
                this.f246089c.setVisibility(0);
                this.f246088b.setVisibility(0);
            }
            this.f246087a.setText(this.f246095i.f245871b);
            if (!"top".equals(this.f246096j.f245868e)) {
                this.f246093g = new BitmapDrawable(this.f246092f.getContext().getResources(), this.f246095i.f245872c);
                this.f246094h = new BitmapDrawable(this.f246092f.getContext().getResources(), this.f246095i.f245873d);
            }
            a(false);
        }

        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            this.f246092f.setBackgroundColor(this.f246096j.f245866c);
            if (!z16) {
                this.f246087a.setTextColor(this.f246096j.f245864a);
                if ("top".equals(this.f246096j.f245868e)) {
                    this.f246091e.setVisibility(8);
                } else {
                    this.f246088b.setImageDrawable(this.f246093g);
                }
            } else {
                this.f246087a.setTextColor(this.f246096j.f245865b);
                if ("top".equals(this.f246096j.f245868e)) {
                    this.f246091e.setVisibility(0);
                } else {
                    this.f246088b.setImageDrawable(this.f246094h);
                }
            }
            if ("top".equals(this.f246096j.f245868e)) {
                this.f246090d.setBackgroundColor("black".equals(this.f246096j.f245867d) ? 855638016 : 872415231);
                this.f246091e.setBackgroundColor(this.f246096j.f245865b);
            } else {
                this.f246089c.setBackgroundColor("black".equals(this.f246096j.f245867d) ? 855638016 : 872415231);
            }
        }
    }

    private void a(List list) {
        removeAllViews();
        this.f246084a.clear();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                View a16 = a((k.a) list.get(i3), i3);
                if (a16 != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                    addView(a16, layoutParams);
                }
            }
        }
    }

    public View a(k.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
        }
        if (aVar == null || TextUtils.isEmpty(aVar.f245871b)) {
            return null;
        }
        View a16 = a();
        a a17 = a.a(a16, aVar, this.f246085b);
        a17.a();
        this.f246084a.add(a17);
        a16.setOnClickListener(new f(this, i3, aVar));
        return a16;
    }

    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        View view = new View(getContext());
        view.setId(R.id.p);
        relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5f)));
        View imageView = new ImageView(getContext());
        imageView.setId(R.id.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0f), DisplayUtil.dip2px(getContext(), 30.0f));
        layoutParams.addRule(3, R.id.p);
        layoutParams.topMargin = DisplayUtil.dip2px(getContext(), 2.0f);
        layoutParams.addRule(14, -1);
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setId(R.id.a);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setPadding(DisplayUtil.dip2px(getContext(), 1.0f), 0, DisplayUtil.dip2px(getContext(), 1.0f), 0);
        textView.setBackgroundResource(R.drawable.h);
        textView.setVisibility(4);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = DisplayUtil.dip2px(getContext(), -10.0f);
        layoutParams2.addRule(6, R.id.i);
        layoutParams2.addRule(1, R.id.i);
        relativeLayout.addView(textView, layoutParams2);
        View view2 = new View(getContext());
        view2.setId(R.id.l);
        view2.setBackgroundResource(R.drawable.g);
        view2.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0f), DisplayUtil.dip2px(getContext(), 10.0f));
        layoutParams3.leftMargin = DisplayUtil.dip2px(getContext(), -4.0f);
        layoutParams3.addRule(6, R.id.i);
        layoutParams3.addRule(1, R.id.i);
        relativeLayout.addView(view2, layoutParams3);
        TextView textView2 = new TextView(getContext());
        textView2.setId(R.id.m);
        textView2.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(3, R.id.i);
        layoutParams4.bottomMargin = DisplayUtil.dip2px(getContext(), 5.0f);
        relativeLayout.addView(textView2, layoutParams4);
        View view3 = new View(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams5.addRule(3, R.id.m);
        relativeLayout.addView(view3, layoutParams5);
        View view4 = new View(getContext());
        view4.setId(R.id.b);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5f));
        layoutParams6.addRule(3, R.id.m);
        relativeLayout.addView(view4, layoutParams6);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(8, R.id.b);
        relativeLayout.addView(linearLayout, layoutParams7);
        View view5 = new View(getContext());
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams8.weight = 1.0f;
        linearLayout.addView(view5, layoutParams8);
        View view6 = new View(getContext());
        view6.setId(R.id.c);
        view6.setVisibility(8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams9.weight = 3.0f;
        linearLayout.addView(view6, layoutParams9);
        View view7 = new View(getContext());
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams10.weight = 1.0f;
        linearLayout.addView(view7, layoutParams10);
        return relativeLayout;
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            aVar.a(true);
            Iterator it = this.f246084a.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2 != aVar) {
                    aVar2.a(false);
                }
            }
        }
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f246086c = bVar;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        }
    }
}
