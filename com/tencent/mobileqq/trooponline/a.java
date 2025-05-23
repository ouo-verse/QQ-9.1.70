package com.tencent.mobileqq.trooponline;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.text.c;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected List<com.tencent.mobileqq.troop.onlinemember.data.b> f303248d;

    /* renamed from: e, reason: collision with root package name */
    protected List<String> f303249e;

    /* renamed from: f, reason: collision with root package name */
    protected QQAppInterface f303250f;

    /* renamed from: h, reason: collision with root package name */
    protected String f303251h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.trooponline.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private class C8846a implements TroopManager.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public b f303252a;

        C8846a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
        public void a(TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                return;
            }
            b bVar = this.f303252a;
            if (bVar != null && troopMemberInfo != null && TextUtils.equals(bVar.f303255b, troopMemberInfo.memberuin)) {
                this.f303252a.f303258e.setText(new c(troopMemberInfo.nickInfo.getShowName(), 13).j());
                if (AppSetting.f99565y) {
                    a.this.c(this.f303252a);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f303254a;

        /* renamed from: b, reason: collision with root package name */
        public String f303255b;

        /* renamed from: c, reason: collision with root package name */
        public QQProAvatarView f303256c;

        /* renamed from: d, reason: collision with root package name */
        public RoundTextView f303257d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f303258e;

        /* renamed from: f, reason: collision with root package name */
        public com.tencent.mobileqq.troop.onlinemember.data.b f303259f;

        /* renamed from: g, reason: collision with root package name */
        public StringBuilder f303260g;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    public a(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        this.f303248d = new ArrayList(15);
        this.f303249e = new ArrayList(15);
        this.f303250f = qQAppInterface;
        this.f303251h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (bVar.f303260g.length() > 0) {
            StringBuilder sb5 = bVar.f303260g;
            sb5.delete(0, sb5.length());
        }
        StringBuilder sb6 = bVar.f303260g;
        sb6.append(bVar.f303258e.getText().toString());
        sb6.append(",");
        sb6.append(bVar.f303257d.getText().toString());
        bVar.f303254a.setContentDescription(bVar.f303260g.toString());
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f303248d.clear();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f303248d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f303248d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ajo, viewGroup, false);
                b bVar = new b();
                bVar.f303254a = view;
                bVar.f303256c = (QQProAvatarView) view.findViewById(R.id.dv9);
                bVar.f303257d = (RoundTextView) view.findViewById(R.id.kbj);
                bVar.f303258e = (TextView) view.findViewById(R.id.tv_name);
                view.setTag(bVar);
                if (AppSetting.f99565y) {
                    view.setFocusable(true);
                    bVar.f303260g = new StringBuilder();
                }
            }
            b bVar2 = (b) view.getTag();
            com.tencent.mobileqq.troop.onlinemember.data.b bVar3 = this.f303248d.get(i3);
            bVar2.f303259f = bVar3;
            QQProAvatarView qQProAvatarView = bVar2.f303256c;
            String str = bVar3.f298044b;
            qQProAvatarView.x(1, str, e.a(1, str));
            String str2 = bVar3.f298045c;
            if (str2 != null && str2.startsWith("LV")) {
                bVar2.f303257d.setVisibility(8);
            } else {
                bVar2.f303257d.setVisibility(0);
                bVar2.f303257d.setText(bVar3.f298045c);
                bVar2.f303257d.setRoundBgColor(bVar3.f298046d);
            }
            bVar2.f303255b = bVar3.f298044b;
            C8846a c8846a = (C8846a) bVar2.f303258e.getTag();
            bVar2.f303258e.setText(bVar3.f298047e);
            if (c8846a == null) {
                c8846a = new C8846a();
                bVar2.f303258e.setTag(c8846a);
            }
            if (AppSetting.f99565y) {
                c(bVar2);
            }
            c8846a.f303252a = bVar2;
            ((TroopManager) this.f303250f.getManager(QQManagerFactory.TROOP_MANAGER)).D(this.f303251h, bVar2.f303255b, "TroopOnlineMemberListAd", c8846a);
            if (!this.f303249e.contains(bVar2.f303255b)) {
                new q(this.f303250f).i("dc00899").a("Grp_online").f("online_box").d("exp_mberHead").b(this.f303251h, bVar3.f298045c).g();
                this.f303249e.add(bVar2.f303255b);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<com.tencent.mobileqq.troop.onlinemember.data.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.f303248d.clear();
            this.f303248d.addAll(list);
        }
    }
}
