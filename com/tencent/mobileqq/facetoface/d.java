package com.tencent.mobileqq.facetoface;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends j {
    static IPatchRedirector $redirector_;
    private List<e> F;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class a extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        TextView f205752i;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public d(BaseActivity baseActivity, XListView xListView) {
        super(baseActivity, baseActivity.app, xListView, 1, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity, (Object) xListView);
        } else {
            this.F = null;
            xListView.setAdapter((ListAdapter) this);
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<e> list = this.F;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (view == null) {
                view = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.f167953nw, (ViewGroup) null);
                aVar = new a();
                aVar.f187212f = (ImageView) view.findViewById(R.id.cnp);
                aVar.f205752i = (TextView) view.findViewById(R.id.coa);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            f item = getItem(i3);
            if (item != null) {
                String str = item.f205754b;
                aVar.f187210d = str;
                aVar.f187212f.setImageBitmap(c(1, str));
                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                String str2 = item.f205755c;
                if (str2 == null) {
                    str2 = item.f205754b;
                } else if (TextUtils.isEmpty(str2.trim())) {
                    str2 = item.f205754b;
                }
                aVar.f205752i.setText(str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, i3 + ": totalTime = " + (System.currentTimeMillis() - currentTimeMillis) + ", faceBitmap = " + currentTimeMillis2);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void h(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
            return;
        }
        if (getCount() == 0) {
            this.F = new ArrayList();
        }
        this.F.add(0, fVar);
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public f getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        List<e> list = this.F;
        if (list != null && list.size() > i3) {
            return (f) this.F.get(i3);
        }
        return null;
    }

    public void j(List<e> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.F = new ArrayList(list);
            notifyDataSetChanged();
        }
    }
}
