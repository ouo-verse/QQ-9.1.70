package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f194257d;

    /* renamed from: e, reason: collision with root package name */
    private final List<Boolean> f194258e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f194259f;

    /* renamed from: h, reason: collision with root package name */
    private int f194260h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public SquareImageView f194261a;

        /* renamed from: b, reason: collision with root package name */
        public View f194262b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f194263c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public m(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.f194257d = new ArrayList();
        this.f194258e = new ArrayList();
        this.f194259f = context;
        this.f194260h = i3;
    }

    private boolean e(int i3) {
        if (i3 >= 0 && i3 < this.f194258e.size()) {
            return !this.f194258e.get(i3).booleanValue();
        }
        return false;
    }

    private void g(a aVar, String str) {
        if (aVar != null && aVar.f194261a != null) {
            ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.b(IAIOTofuApi.class)).loadDrawableByUrl(aVar.f194261a, str);
        }
    }

    public void a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            this.f194257d.addAll(list);
        }
    }

    public void b(List<Boolean> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f194258e.addAll(list);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f194257d.clear();
            this.f194258e.clear();
        }
    }

    public boolean d(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list)).booleanValue();
        }
        return this.f194257d.equals(list);
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("video=1");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return Math.min(this.f194257d.size(), 4);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 < this.f194257d.size() && i3 < 4) {
            return this.f194257d.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        if (i3 < this.f194257d.size() && i3 < 4) {
            return i3;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        int i16;
        View view3;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view2 = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                aVar = new a();
                view2 = LayoutInflater.from(this.f194259f).inflate(R.layout.dud, (ViewGroup) null);
                aVar.f194261a = (SquareImageView) view2.findViewById(R.id.f85694pn);
                aVar.f194262b = view2.findViewById(R.id.f165805dl0);
                aVar.f194263c = (TextView) view2.findViewById(R.id.xmm);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            String str = this.f194257d.get(i3);
            g(aVar, str);
            int i18 = this.f194260h;
            if (i18 != 2) {
                if (i18 != 3) {
                    aVar.f194262b.setVisibility(8);
                } else {
                    View view4 = aVar.f194262b;
                    if (e(i3)) {
                        i17 = 0;
                    } else {
                        i17 = 8;
                    }
                    view4.setVisibility(i17);
                }
            } else {
                View view5 = aVar.f194262b;
                if (f(str)) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                view5.setVisibility(i16);
            }
            aVar.f194263c.setVisibility(8);
            if (i3 == 3 && this.f194260h == 3) {
                aVar.f194262b.setVisibility(8);
                aVar.f194263c.setVisibility(0);
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f194260h = i3;
        }
    }
}
