package com.tencent.mobileqq.troop.addsource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import com.tencent.mobileqq.widget.selectorview.h;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private List<QunSourceSvrPB$SourceItem> f293829g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f293830h;

    /* renamed from: i, reason: collision with root package name */
    private final QPickerView.e f293831i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.addsource.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8669a implements QPickerView.e {
        static IPatchRedirector $redirector_;

        C8669a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            if (a.this.f293829g != null) {
                return a.this.f293829g.size();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (a.this.f293829g != null && i16 >= 0 && i16 < a.this.f293829g.size()) {
                return ((QunSourceSvrPB$SourceItem) a.this.f293829g.get(i16)).desc.get();
            }
            return null;
        }
    }

    public a(Context context, boolean z16) {
        super(context, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
            return;
        }
        this.f293829g = new ArrayList();
        C8669a c8669a = new C8669a();
        this.f293831i = c8669a;
        k("\u5207\u6362\u4e8c\u7ef4\u7801");
        this.f317413c.k(c8669a, z16);
    }

    @Override // com.tencent.mobileqq.widget.selectorview.h
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            this.f317412b.onBackPressed();
        } catch (Exception e16) {
            QLog.e("TroopQRSourceSelector", 1, "TroopQRSourceSelector dismiss error", e16);
        }
    }

    @Override // com.tencent.mobileqq.widget.selectorview.h
    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            super.h(i3);
        }
    }

    @Override // com.tencent.mobileqq.widget.selectorview.h
    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            super.k(str);
        }
    }

    public QunSourceSvrPB$SourceItem p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QunSourceSvrPB$SourceItem) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int h16 = this.f317413c.h(0);
        List<QunSourceSvrPB$SourceItem> list = this.f293829g;
        if (list != null && h16 >= 0 && h16 < list.size()) {
            return this.f293829g.get(h16);
        }
        return null;
    }

    public void q(Context context, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) onClickListener);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fvh, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) this.f317412b.findViewById(R.id.f61952zi);
        this.f293830h = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.f293830h.addView(inflate, new RelativeLayout.LayoutParams(-1, -2));
            this.f293830h.setOnClickListener(onClickListener);
            h(0);
        }
    }

    public void r(List<QunSourceSvrPB$SourceItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else if (list != null) {
            this.f293829g = list;
            this.f317413c.m(0);
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f317413c.setSelection(0, i3);
            this.f317413c.m(0);
        }
    }
}
