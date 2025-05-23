package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends BaseAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public a f181200d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<Context> f181201e;

    /* renamed from: f, reason: collision with root package name */
    List<ReadInJoySearchHistoryEntity> f181202f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void D2(ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity);

        void k1();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f181203a;

        /* renamed from: b, reason: collision with root package name */
        public LinearLayout f181204b;

        /* renamed from: c, reason: collision with root package name */
        public RelativeLayout f181205c;

        /* renamed from: d, reason: collision with root package name */
        public int f181206d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }
    }

    public i(Context context, List<ReadInJoySearchHistoryEntity> list, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, aVar);
            return;
        }
        this.f181200d = null;
        this.f181201e = new WeakReference<>(context);
        a(list);
        this.f181200d = aVar;
    }

    private void a(List<ReadInJoySearchHistoryEntity> list) {
        if (list != null && list.size() != 0) {
            if (list.size() < 6) {
                this.f181202f = list;
                return;
            } else {
                this.f181202f = list.subList(0, 5);
                return;
            }
        }
        this.f181202f = null;
    }

    public void b(List<ReadInJoySearchHistoryEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            a(list);
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        List<ReadInJoySearchHistoryEntity> list = this.f181202f;
        if (list != null && list.size() != 0) {
            return this.f181202f.size() + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 < this.f181202f.size()) {
            return this.f181202f.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            Context context = this.f181201e.get();
            if (context == null) {
                view3 = view;
                view2 = null;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.f168533zz, (ViewGroup) null);
                    bVar = new b();
                    bVar.f181203a = (TextView) view.findViewById(R.id.f165696d62);
                    bVar.f181204b = (LinearLayout) view.findViewById(R.id.e0x);
                    bVar.f181205c = (RelativeLayout) view.findViewById(R.id.ayi);
                    view.setTag(bVar);
                    view.setOnClickListener(this);
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.f181206d = i3;
                if (i3 < this.f181202f.size()) {
                    bVar.f181205c.setVisibility(8);
                    bVar.f181204b.setVisibility(0);
                    bVar.f181203a.setText(this.f181202f.get(i3).keyWord);
                } else if (i3 == this.f181202f.size()) {
                    bVar.f181205c.setVisibility(0);
                    bVar.f181204b.setVisibility(8);
                }
                view2 = view;
                view3 = view2;
            }
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            if (bVar.f181206d < this.f181202f.size()) {
                if (this.f181200d != null) {
                    this.f181200d.D2(this.f181202f.get(bVar.f181206d));
                }
            } else if (bVar.f181206d == this.f181202f.size() && (aVar = this.f181200d) != null) {
                aVar.k1();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
