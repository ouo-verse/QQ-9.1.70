package com.tencent.mobileqq.selectmember.troop;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.TroopListBaseAdapter;
import com.tencent.mobileqq.selectmember.troop.SelectTroopListItemView;
import com.tencent.mobileqq.selectmember.troop.repo.f;
import com.tencent.mobileqq.troop.adapter.contact.d;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends TroopListBaseAdapter implements ExpandableListView.OnGroupClickListener {
    static IPatchRedirector $redirector_;
    private f N;
    private c P;
    private View.OnClickListener Q;
    private View.OnClickListener R;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.selectmember.troop.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class ViewOnClickListenerC8571a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC8571a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.G((com.tencent.mobileqq.troop.adapter.contact.a) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.P.b(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        boolean a(String str, int i3);

        void b(View view);

        void c(int i3, int i16);

        void d(List<String> list);
    }

    public a(Context context, AppInterface appInterface, ExpandableListView expandableListView, Bundle bundle, c cVar) {
        super(context, appInterface, expandableListView, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, expandableListView, bundle, cVar);
            return;
        }
        this.Q = new ViewOnClickListenerC8571a();
        this.R = new b();
        this.P = cVar;
    }

    private boolean C(f fVar, String str) {
        if (fVar == null) {
            return true;
        }
        if (!J(fVar, str) && !I(fVar, str)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D(com.tencent.mobileqq.troop.adapter.contact.a aVar, int i3, boolean z16) {
        String str;
        int i16;
        if (aVar != null) {
            if (i3 >= 0 && i3 < this.E.size()) {
                int intValue = this.E.get(i3).intValue();
                if (intValue != 2) {
                    if (intValue != 4) {
                        if (intValue != 6) {
                            if (intValue == 13) {
                                str = HardCodeUtil.qqStr(R.string.uds);
                                i16 = this.I.size();
                            }
                        } else {
                            str = HardCodeUtil.qqStr(R.string.udo);
                            i16 = this.G.size();
                        }
                    } else {
                        str = HardCodeUtil.qqStr(R.string.udr);
                        i16 = this.F.size();
                    }
                } else {
                    str = HardCodeUtil.qqStr(R.string.udp);
                    i16 = this.H.size();
                }
                if (H(this.N)) {
                    str = str + HardCodeUtil.qqStr(R.string.f214585ta);
                }
                StringBuilder sb5 = aVar.f293803g;
                if (AppSetting.f99565y) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder(24);
                    } else {
                        sb5.delete(0, sb5.length());
                    }
                    sb5.append(str + " \u5206\u7ec4");
                }
                aVar.f293797a = i3;
                aVar.f293800d.setText(str);
                aVar.f293801e.setVisibility(8);
                aVar.f293799c.setVisibility(8);
                aVar.f293802f.setText(String.valueOf(i16));
                aVar.f293798b.setVisibility(0);
                aVar.f293798b.setChecked(z16);
            }
            str = "";
            i16 = 0;
            if (H(this.N)) {
            }
            StringBuilder sb52 = aVar.f293803g;
            if (AppSetting.f99565y) {
            }
            aVar.f293797a = i3;
            aVar.f293800d.setText(str);
            aVar.f293801e.setVisibility(8);
            aVar.f293799c.setVisibility(8);
            aVar.f293802f.setText(String.valueOf(i16));
            aVar.f293798b.setVisibility(0);
            aVar.f293798b.setChecked(z16);
        }
    }

    private String F(f fVar, String str) {
        if (fVar == null) {
            return "";
        }
        if (I(fVar, str)) {
            return String.format(this.C.getResources().getString(R.string.f224936k_), fVar.a().get(str));
        }
        if (J(fVar, str)) {
            return this.C.getResources().getString(R.string.f224956kb);
        }
        if (!K(fVar, str)) {
            return "";
        }
        return this.C.getResources().getString(R.string.f224976kd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.tencent.mobileqq.troop.adapter.contact.a aVar) {
        int i3;
        if (this.E.size() == 1) {
            i3 = 0;
        } else {
            i3 = aVar.f293797a;
        }
        if (this.f285924f.isGroupExpanded(i3)) {
            this.f285924f.collapseGroup(i3);
            this.J.remove(this.E.get(i3));
        } else {
            this.f285924f.expandGroup(i3);
            this.J.add(this.E.get(i3));
        }
    }

    private boolean H(f fVar) {
        if (fVar != null) {
            return !fVar.f().isEmpty();
        }
        return false;
    }

    private boolean I(f fVar, String str) {
        return !TextUtils.isEmpty(fVar.a().get(str));
    }

    private boolean J(f fVar, String str) {
        return Boolean.TRUE.equals(fVar.c().get(str));
    }

    private boolean K(f fVar, String str) {
        return Boolean.TRUE.equals(fVar.e().get(str));
    }

    public ArrayList<String> E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f fVar = this.N;
        if (fVar == null) {
            return arrayList;
        }
        arrayList.addAll(fVar.d());
        return arrayList;
    }

    public void L(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        this.N = fVar;
        y(this.F, new com.tencent.mobileqq.troop.adapter.contact.b());
        z();
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        if (!(view.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f285881m, false)) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.C.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        }
        Resources resources = view.getResources();
        if (resources != null) {
            view.setBackground(resources.getDrawable(R.drawable.jis, null));
        }
        D(aVar, i3, this.f285924f.isGroupExpanded(i3));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        SelectTroopListItemView selectTroopListItemView;
        k kVar;
        Object obj;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            selectTroopListItemView = new SelectTroopListItemView(this.C);
            kVar = new k();
            selectTroopListItemView.setTag(kVar);
        } else {
            selectTroopListItemView = (SelectTroopListItemView) view;
            kVar = (k) view.getTag();
        }
        kVar.f187212f = selectTroopListItemView.f286010m;
        ResultRecord resultRecord = selectTroopListItemView.K;
        if (resultRecord == null) {
            resultRecord = new ResultRecord();
        }
        TroopListBaseAdapter.b t16 = t(i3, i16);
        if (t16 != null && (obj = t16.f285887a) != null) {
            if (obj instanceof TroopInfo) {
                TroopInfo troopInfo = (TroopInfo) obj;
                kVar.f187210d = troopInfo.troopuin;
                kVar.f187211e = 4;
                if (!TextUtils.isEmpty(troopInfo.getTroopDisplayName())) {
                    str = troopInfo.getTroopDisplayName();
                } else {
                    str = troopInfo.troopuin;
                }
                resultRecord.init(troopInfo.troopuin, str, 1, "", "");
                boolean a16 = this.P.a(troopInfo.troopuin, 1);
                SelectTroopListItemView.a aVar = new SelectTroopListItemView.a();
                aVar.f286011a = str;
                aVar.f286012b = String.valueOf(troopInfo.getMemberNumClient());
                aVar.f286013c = null;
                aVar.f286014d = resultRecord;
                aVar.f286015e = true;
                aVar.f286016f = a16;
                aVar.f286017g = false;
                aVar.f286018h = C(this.N, troopInfo.troopuin);
                aVar.f286019i = F(this.N, troopInfo.troopuin);
                selectTroopListItemView.a(aVar);
                c(kVar, null);
                if (aVar.f286018h) {
                    selectTroopListItemView.setOnClickListener(this.R);
                } else {
                    selectTroopListItemView.setOnClickListener(null);
                }
            } else if (obj instanceof DiscussionInfo) {
                DiscussionInfo discussionInfo = (DiscussionInfo) obj;
                String str2 = discussionInfo.uin;
                kVar.f187210d = str2;
                kVar.f187211e = 101;
                resultRecord.init(str2, discussionInfo.discussionName, 3000, "", "");
                boolean a17 = this.P.a(discussionInfo.uin, 3000);
                int discussionMemberNum = ((IDiscussionService) this.f285881m.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin);
                SelectTroopListItemView.a aVar2 = new SelectTroopListItemView.a();
                aVar2.f286011a = discussionInfo.discussionName;
                aVar2.f286012b = String.valueOf(discussionMemberNum);
                aVar2.f286013c = null;
                aVar2.f286014d = resultRecord;
                aVar2.f286015e = true;
                aVar2.f286016f = a17;
                aVar2.f286017g = false;
                aVar2.f286018h = true;
                aVar2.f286019i = "";
                selectTroopListItemView.a(aVar2);
                c(kVar, null);
                selectTroopListItemView.setOnClickListener(this.R);
            } else if (QLog.isColorLevel()) {
                QLog.d("SelectTroopListAdapter", 2, "getChildView data:" + t16.f285887a + " groupPosition:" + i3 + " childPosition:" + i16);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("SelectTroopListAdapter", 2, "getChildView itemInfo data null" + i3 + " childPosition:" + i16);
        }
        return selectTroopListItemView;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(this.C).inflate(R.layout.e3z, viewGroup, false);
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.K));
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f285881m, false)) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.C.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        }
        D(aVar, i3, z16);
        view.setOnClickListener(this.Q);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.e3z;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, expandableListView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            G((com.tencent.mobileqq.troop.adapter.contact.a) tag);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.selectmember.TroopListBaseAdapter
    protected void r(List<d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        if (this.N == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                Object obj = it.next().f293809b;
                if (obj instanceof TroopInfo) {
                    arrayList.add(((TroopInfo) obj).troopuin);
                }
            }
            c cVar = this.P;
            if (cVar != null) {
                cVar.d(arrayList);
            }
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopListBaseAdapter
    protected void v(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        c cVar = this.P;
        if (cVar != null) {
            cVar.c(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopListBaseAdapter
    protected void y(List<d> list, com.tencent.mobileqq.troop.adapter.contact.b bVar) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list, (Object) bVar);
            return;
        }
        if (this.N == null) {
            return;
        }
        for (d dVar : this.F) {
            if (dVar != null && (obj = dVar.f293809b) != null && (obj instanceof TroopInfo)) {
                TroopInfo troopInfo = (TroopInfo) obj;
                if (K(this.N, troopInfo.troopuin)) {
                    dVar.f293808a++;
                } else if (I(this.N, troopInfo.troopuin)) {
                    dVar.f293808a += 2;
                } else if (J(this.N, troopInfo.troopuin)) {
                    dVar.f293808a += 3;
                }
            }
        }
        Collections.sort(this.F, new com.tencent.mobileqq.troop.adapter.contact.b());
    }
}
