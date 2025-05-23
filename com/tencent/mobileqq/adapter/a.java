package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private CompoundButton.OnCheckedChangeListener C;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f187073d;

    /* renamed from: e, reason: collision with root package name */
    protected List<Object> f187074e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f187075f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f187076h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f187077i;

    /* renamed from: m, reason: collision with root package name */
    private AppletsSettingFragment.d f187078m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7221a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        C7221a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                a.this.f187078m.a(compoundButton, z16, (AppletItem) a.this.f187074e.get(((Integer) compoundButton.getTag()).intValue()));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        AppletItem f187080a;

        /* renamed from: b, reason: collision with root package name */
        RelativeLayout f187081b;

        /* renamed from: c, reason: collision with root package name */
        URLImageView f187082c;

        /* renamed from: d, reason: collision with root package name */
        TextView f187083d;

        /* renamed from: e, reason: collision with root package name */
        Switch f187084e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public a(QQAppInterface qQAppInterface, BaseActivity baseActivity, AppletsSettingFragment.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, baseActivity, dVar);
            return;
        }
        this.C = new C7221a();
        this.f187073d = qQAppInterface;
        this.f187075f = (LayoutInflater) baseActivity.getSystemService("layout_inflater");
        this.f187074e = new ArrayList();
        this.f187076h = baseActivity;
        this.f187077i = baseActivity.getResources().getDrawable(R.drawable.qui_cardlist_icon_default);
        this.f187078m = dVar;
    }

    public void b(List<AppletItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        this.f187074e.clear();
        if (list != null) {
            this.f187074e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f187074e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f187074e.size()) {
            return this.f187074e.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view3 = view;
            view = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            AppletItem appletItem = (AppletItem) getItem(i3);
            if (appletItem != null) {
                if (view == null) {
                    bVar = new b();
                    view2 = this.f187075f.inflate(R.layout.f168865b22, viewGroup, false);
                    bVar.f187081b = (RelativeLayout) view2.findViewById(R.id.f164405we);
                    bVar.f187082c = (URLImageView) view2.findViewById(R.id.f164404wd);
                    bVar.f187083d = (TextView) view2.findViewById(R.id.f164406wf);
                    bVar.f187084e = (Switch) view2.findViewById(R.id.f164407wg);
                    view2.setTag(bVar);
                } else {
                    view2 = view;
                    bVar = (b) view.getTag();
                }
                Switch r56 = bVar.f187084e;
                if (appletItem.e() != 1) {
                    z16 = false;
                }
                r56.setChecked(z16);
                bVar.f187084e.setOnCheckedChangeListener(this.C);
                bVar.f187084e.setTag(Integer.valueOf(i3));
                if (QLog.isColorLevel()) {
                    QLog.d("AppletsListAdapter", 2, appletItem.toString());
                }
                bVar.f187083d.setText(appletItem.c());
                bVar.f187080a = appletItem;
                if (!TextUtils.isEmpty(appletItem.a())) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    int f16 = BaseAIOUtils.f(bVar.f187082c.getMeasuredWidth(), this.f187076h.getResources());
                    obtain.mRequestWidth = f16;
                    obtain.mRequestHeight = f16;
                    Drawable drawable = this.f187077i;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    bVar.f187082c.setImageDrawable(URLDrawable.getDrawable(appletItem.a(), obtain));
                } else {
                    bVar.f187082c.setImageDrawable(this.f187077i);
                }
                view = view2;
            }
            view3 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view;
    }
}
