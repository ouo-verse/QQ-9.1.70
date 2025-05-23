package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Context> f254833d;

    /* renamed from: e, reason: collision with root package name */
    List<C8175b> f254834e;

    /* renamed from: f, reason: collision with root package name */
    c f254835f;

    /* renamed from: h, reason: collision with root package name */
    f f254836h;

    /* renamed from: i, reason: collision with root package name */
    View.OnClickListener f254837i;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (b.this.f254835f != null && (view.getTag() instanceof C8175b)) {
                b.this.f254835f.a((C8175b) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ocr.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8175b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f254839a;

        /* renamed from: b, reason: collision with root package name */
        public Object f254840b;

        /* renamed from: c, reason: collision with root package name */
        public String f254841c;

        /* renamed from: d, reason: collision with root package name */
        public String f254842d;

        /* renamed from: e, reason: collision with root package name */
        public String f254843e;

        /* renamed from: f, reason: collision with root package name */
        public int f254844f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f254845g;

        /* renamed from: h, reason: collision with root package name */
        public int f254846h;

        public C8175b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface c {
        void a(C8175b c8175b);
    }

    public b(Context context, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) cVar);
            return;
        }
        this.f254834e = new ArrayList();
        this.f254836h = new f();
        this.f254837i = new a();
        this.f254833d = new WeakReference<>(context);
        this.f254835f = cVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f254834e.clear();
            super.notifyDataSetChanged();
        }
    }

    public void b(com.tencent.mobileqq.ocr.f fVar, List<OCRTextSearchInfo.a> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fVar, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            c(fVar, list, z16, z17, false);
        }
    }

    public void c(com.tencent.mobileqq.ocr.f fVar, List<OCRTextSearchInfo.a> list, boolean z16, boolean z17, boolean z18) {
        C8175b c8175b;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, fVar, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if (z16) {
            if (this.f254834e.size() > 0) {
                List<C8175b> list2 = this.f254834e;
                C8175b c8175b2 = list2.get(list2.size() - 1);
                if (c8175b2.f254839a == 5) {
                    this.f254834e.remove(c8175b2);
                }
            }
        } else {
            this.f254834e.clear();
        }
        C8175b c8175b3 = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            OCRTextSearchInfo.a aVar = list.get(i3);
            if (fVar.f254759a == 0) {
                c8175b3 = new C8175b();
                c8175b3.f254839a = 3;
                if (!TextUtils.isEmpty(aVar.f254547a)) {
                    String str = aVar.f254547a;
                    c8175b3.f254840b = str;
                    c8175b3.f254841c = str;
                }
                c8175b = c8175b3;
            } else {
                c8175b = null;
            }
            if (aVar.f254551e.size() != 0) {
                if (fVar.f254759a == 0 && z18) {
                    if (i3 != 0) {
                        C8175b c8175b4 = new C8175b();
                        c8175b4.f254839a = 2;
                        this.f254834e.add(c8175b4);
                    }
                    this.f254834e.add(c8175b);
                    C8175b c8175b5 = new C8175b();
                    c8175b5.f254839a = 1;
                    this.f254834e.add(c8175b5);
                }
                for (int i16 = 0; i16 < aVar.f254551e.size(); i16++) {
                    OCRTextSearchInfo.b bVar = aVar.f254551e.get(i16);
                    C8175b c8175b6 = new C8175b();
                    c8175b6.f254839a = 0;
                    c8175b6.f254840b = bVar.f254552a;
                    c8175b6.f254841c = aVar.f254547a;
                    c8175b6.f254844f = aVar.f254548b;
                    c8175b6.f254846h = i16;
                    this.f254834e.add(c8175b6);
                    if (i16 != aVar.f254551e.size() - 1) {
                        C8175b c8175b7 = new C8175b();
                        c8175b7.f254839a = 1;
                        this.f254834e.add(c8175b7);
                    }
                }
            }
            if (!TextUtils.isEmpty(aVar.f254549c) && fVar.f254759a == 0 && !TextUtils.isEmpty(aVar.f254549c)) {
                C8175b c8175b8 = new C8175b();
                c8175b8.f254839a = 1;
                this.f254834e.add(c8175b8);
                C8175b c8175b9 = new C8175b();
                c8175b9.f254839a = 4;
                c8175b9.f254843e = aVar.f254549c;
                c8175b9.f254841c = aVar.f254547a;
                c8175b9.f254842d = aVar.f254550d;
                c8175b9.f254844f = aVar.f254548b;
                c8175b9.f254845g = true;
                this.f254834e.add(c8175b9);
                if (c8175b3 != null) {
                    c8175b3.f254842d = aVar.f254550d;
                    c8175b3.f254843e = aVar.f254549c;
                    c8175b3.f254844f = aVar.f254548b;
                    c8175b3.f254845g = true;
                }
            }
        }
        C8175b c8175b10 = new C8175b();
        c8175b10.f254839a = 1;
        this.f254834e.add(c8175b10);
        if (z17) {
            C8175b c8175b11 = new C8175b();
            c8175b11.f254839a = 5;
            this.f254834e.add(c8175b11);
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f254834e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < getCount()) {
            return this.f254834e.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return this.f254834e.get(i3).f254839a;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
        } else if (this.f254833d.get() == null) {
            view2 = null;
        } else {
            C8175b c8175b = this.f254834e.get(i3);
            int i16 = c8175b.f254839a;
            if (i16 == 0) {
                SearchSougouResultItemBuilder searchSougouResultItemBuilder = (SearchSougouResultItemBuilder) this.f254836h.a(0);
                searchSougouResultItemBuilder.b(viewGroup);
                view = searchSougouResultItemBuilder.a(i3, view, viewGroup, this, c8175b);
                view.setOnClickListener(this.f254837i);
            } else if (i16 == 1) {
                view = ((d) this.f254836h.a(1)).a(i3, view, viewGroup, this, c8175b);
            }
            view.setTag(c8175b);
            view2 = view;
            view3 = view2;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
        view3 = view;
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 2;
    }
}
