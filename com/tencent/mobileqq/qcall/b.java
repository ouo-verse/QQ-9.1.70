package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f261552d;

    /* renamed from: e, reason: collision with root package name */
    private List<PhoneContact> f261553e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f261554a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f261555b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b(Context context, List<PhoneContact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) list);
        } else {
            this.f261552d = context;
            this.f261553e = list;
        }
    }

    private void a(int i3, View view, ViewGroup viewGroup) {
        String str;
        a aVar = (a) view.getTag();
        PhoneContact phoneContact = this.f261553e.get(i3);
        int i16 = phoneContact.type;
        if (i16 == 0) {
            str = phoneContact.label;
        } else {
            str = null;
        }
        aVar.f261554a.setText((String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.f261552d.getResources(), i16, str));
        aVar.f261555b.setText(phoneContact.mobileNo);
    }

    private View b(int i3, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f261552d).inflate(R.layout.asi, (ViewGroup) null);
        a aVar = new a();
        aVar.f261554a = (TextView) inflate.findViewById(R.id.gq8);
        aVar.f261555b = (TextView) inflate.findViewById(R.id.gq7);
        inflate.setTag(aVar);
        return inflate;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int size = this.f261553e.size();
        if (size > 20) {
            return 20;
        }
        return size;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                view2 = b(i3, viewGroup);
            } else {
                view2 = view;
            }
            a(i3, view2, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }
}
