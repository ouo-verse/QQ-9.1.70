package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected List<String> f293734d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f293735e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f293736f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f293737h;

    /* renamed from: i, reason: collision with root package name */
    public a f293738i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(View view, int i3, b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f293739d;

        /* renamed from: e, reason: collision with root package name */
        TextView f293740e;

        /* renamed from: f, reason: collision with root package name */
        TextView f293741f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a aVar = g.this.f293738i;
                if (aVar != null) {
                    aVar.a(view, this.f293739d, this);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293734d = new ArrayList();
        this.f293735e = false;
        this.f293736f = false;
        this.f293737h = false;
    }

    private void g(int i3, b bVar, String str, ViewGroup viewGroup) {
        if (i3 == 0) {
            if (str.equals(viewGroup.getContext().getString(R.string.f235517bv))) {
                bVar.f293741f.setVisibility(8);
                bVar.f293740e.setTextColor(com.tencent.mobileqq.util.n.a("#4D94FF"));
                bVar.f293740e.setTag(TroopNickRuleFragment.V);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.f293740e.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.rightMargin = ViewUtils.dpToPx(12.0f);
                    bVar.f293740e.setLayoutParams(layoutParams);
                }
                bVar.f293740e.setClickable(true);
                bVar.f293740e.setOnClickListener(bVar);
                return;
            }
            bVar.f293741f.setVisibility(0);
            bVar.f293741f.setOnClickListener(bVar);
            if (this.f293736f) {
                bVar.f293740e.setTextColor(-1);
            } else {
                bVar.f293740e.setTextColor(-16777216);
            }
            bVar.f293740e.setTag(TroopNickRuleFragment.W);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.f293740e.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = ViewUtils.dpToPx(7.0f);
                bVar.f293740e.setLayoutParams(layoutParams2);
            }
            bVar.f293740e.setOnClickListener(null);
            bVar.f293740e.setClickable(false);
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f293734d.add(str);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f293734d.clear();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f293734d.size()) {
            return this.f293734d.get(i3);
        }
        return "";
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f293735e;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f293736f = true;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f293737h = true;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f293734d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            String item = getItem(i3);
            if (!TextUtils.isEmpty(item)) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g1f, (ViewGroup) null, false);
                    if (this.f293736f) {
                        view.setBackgroundDrawable(viewGroup.getContext().getResources().getDrawable(R.drawable.kzp));
                    }
                    bVar = new b();
                    bVar.f293740e = (TextView) view.findViewById(R.id.f26950ex);
                    TextView textView = (TextView) view.findViewById(R.id.f26960ey);
                    bVar.f293741f = textView;
                    textView.setTag(TroopNickRuleFragment.U);
                    if (this.f293736f) {
                        bVar.f293740e.setTextColor(-1);
                    } else {
                        bVar.f293740e.setTextColor(-16777216);
                    }
                    view.setTag(bVar);
                    if (this.f293737h) {
                        ((LinearLayout.LayoutParams) bVar.f293740e.getLayoutParams()).setMargins(30, 15, 30, 15);
                        bVar.f293740e.setOnClickListener(bVar);
                        bVar.f293741f.setVisibility(8);
                    } else {
                        bVar.f293741f.setOnClickListener(bVar);
                        g(i3, bVar, item, viewGroup);
                    }
                } else {
                    bVar = (b) view.getTag();
                    if (!this.f293737h) {
                        g(i3, bVar, item, viewGroup);
                    }
                }
                bVar.f293740e.setText(item);
                bVar.f293739d = i3;
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }
}
