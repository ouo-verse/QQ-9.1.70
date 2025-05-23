package com.tencent.mobileqq.newfriend.ui.builder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends d implements TabLayoutCompat.c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ThemeTabLayout f254126a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void J8(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fVar);
        }
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void c(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
            return;
        }
        if (this.f254109f != null && fVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + fVar.d());
            }
            this.f254109f.f(((Integer) fVar.f()).intValue(), fVar.d());
            ReportController.o(this.f254108e, "dc00898", "", "", "frd_recom", "frd_tab_clk", this.f254109f.a(), 0, "0", "3", "", "");
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        a aVar;
        ThemeTabLayout themeTabLayout;
        com.tencent.mobileqq.newfriend.msg.i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
        }
        int b16 = this.f254109f.b();
        int a16 = this.f254109f.a();
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.cb_, (ViewGroup) null);
            ThemeTabLayout themeTabLayout2 = (ThemeTabLayout) view.findViewById(R.id.j_o);
            aVar.f254126a = themeTabLayout2;
            themeTabLayout2.d(this);
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + b16 + ", tabId =" + a16);
            }
            com.tencent.mobileqq.newfriend.msg.i iVar2 = this.f254111i;
            if (iVar2 != null || (iVar2 instanceof com.tencent.mobileqq.newfriend.msg.k)) {
                aVar.f254126a.a(((com.tencent.mobileqq.newfriend.msg.k) iVar2).f254039d, a16);
            }
            aVar.f254126a.setOnTabSelectedListener(this);
            view.setTag(aVar);
        }
        o(view);
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + b16 + ", tabId =" + a16);
        }
        if (aVar != null && (themeTabLayout = aVar.f254126a) != null && ((iVar = this.f254111i) != null || (iVar instanceof com.tencent.mobileqq.newfriend.msg.k))) {
            themeTabLayout.f(((com.tencent.mobileqq.newfriend.msg.k) iVar).f254039d, a16);
        }
        return view;
    }

    @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
    public void l3(TabLayoutCompat.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fVar);
        }
    }

    public ArrayList<com.tencent.mobileqq.activity.contact.connections.a> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        if (iVar == null && !(iVar instanceof com.tencent.mobileqq.newfriend.msg.k)) {
            return null;
        }
        return ((com.tencent.mobileqq.newfriend.msg.k) iVar).f254039d;
    }

    public void o(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            if (ThemeUtil.isDefaultTheme()) {
                view.setBackgroundResource(R.drawable.f160540jm);
            } else {
                view.setBackgroundResource(R.drawable.skin_list_item_normal);
            }
        }
    }
}
