package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f182140d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f182141e;

    /* renamed from: f, reason: collision with root package name */
    private List<a> f182142f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f182143a;

        /* renamed from: b, reason: collision with root package name */
        Drawable f182144b;

        /* renamed from: c, reason: collision with root package name */
        String f182145c;

        /* renamed from: d, reason: collision with root package name */
        int f182146d;

        /* renamed from: e, reason: collision with root package name */
        boolean f182147e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ImageView f182148a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f182149b;

        /* renamed from: c, reason: collision with root package name */
        TextView f182150c;

        /* renamed from: d, reason: collision with root package name */
        TextView f182151d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }
    }

    public m(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f182140d = context;
            this.f182141e = LayoutInflater.from(context);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        List<a> list = this.f182142f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                bVar = new b();
                view2 = this.f182141e.inflate(R.layout.f168952bc0, (ViewGroup) null, false);
                bVar.f182148a = (ImageView) view2.findViewById(R.id.dgm);
                bVar.f182149b = (ImageView) view2.findViewById(R.id.dgl);
                bVar.f182150c = (TextView) view2.findViewById(R.id.kdq);
                bVar.f182151d = (TextView) view2.findViewById(R.id.kdr);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            a aVar = this.f182142f.get(i3);
            bVar.f182148a.setImageDrawable(aVar.f182144b);
            bVar.f182150c.setText(aVar.f182145c);
            bVar.f182151d.setText(aVar.f182146d + HardCodeUtil.qqStr(R.string.mkq));
            if (aVar.f182147e) {
                bVar.f182149b.setImageDrawable(this.f182140d.getResources().getDrawable(R.drawable.cm_blue_check_checked));
                bVar.f182149b.setContentDescription(HardCodeUtil.qqStr(R.string.ypk));
            } else {
                bVar.f182149b.setImageDrawable(this.f182140d.getResources().getDrawable(R.drawable.ceo));
                bVar.f182149b.setContentDescription(HardCodeUtil.qqStr(R.string.ypm));
            }
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.f182142f = list;
        }
    }
}
