package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cc extends TroopListBaseAdapter implements ExpandableListView.OnGroupClickListener {
    static IPatchRedirector $redirector_;
    private c N;
    private View.OnClickListener P;
    private View.OnClickListener Q;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                cc.this.z((com.tencent.mobileqq.troop.adapter.contact.a) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                cc.this.N.b(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        boolean a(String str, int i3);

        void b(View view);
    }

    public cc(Context context, QQAppInterface qQAppInterface, ExpandableListView expandableListView, c cVar) {
        super(context, qQAppInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, expandableListView, cVar);
            return;
        }
        this.P = new a();
        this.Q = new b();
        this.N = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(com.tencent.mobileqq.troop.adapter.contact.a aVar, int i3, boolean z16) {
        String str;
        int i16;
        if (aVar != null) {
            if (i3 >= 0 && i3 < this.D.size()) {
                int intValue = this.D.get(i3).intValue();
                if (intValue != 2) {
                    if (intValue != 4) {
                        if (intValue != 6) {
                            if (intValue == 13) {
                                str = HardCodeUtil.qqStr(R.string.mra);
                                i16 = this.I.size();
                            }
                        } else {
                            str = HardCodeUtil.qqStr(R.string.mre);
                            i16 = this.F.size();
                        }
                    } else {
                        str = HardCodeUtil.qqStr(R.string.mr_);
                        i16 = this.E.size();
                    }
                } else {
                    str = HardCodeUtil.qqStr(R.string.mrk);
                    i16 = this.G.size();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.tencent.mobileqq.troop.adapter.contact.a aVar) {
        int i3;
        if (this.D.size() == 1) {
            i3 = 0;
        } else {
            i3 = aVar.f293797a;
        }
        if (this.f187153f.isGroupExpanded(i3)) {
            this.f187153f.collapseGroup(i3);
            this.J.remove(this.D.get(i3));
        } else {
            this.f187153f.expandGroup(i3);
            this.J.add(this.D.get(i3));
        }
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null || this.D.size() == 1) {
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
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f186177i, false)) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f186178m.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        }
        Resources resources = view.getResources();
        if (resources != null) {
            view.setBackground(resources.getDrawable(R.drawable.jis, null));
        }
        y(aVar, i3, this.f187153f.isGroupExpanded(i3));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ForwardRecentItemView forwardRecentItemView;
        com.tencent.mobileqq.adapter.k kVar;
        Object obj;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            forwardRecentItemView = new ForwardRecentItemView(this.f186178m);
            kVar = new com.tencent.mobileqq.adapter.k();
            forwardRecentItemView.setTag(kVar);
        } else {
            forwardRecentItemView = (ForwardRecentItemView) view;
            kVar = (com.tencent.mobileqq.adapter.k) view.getTag();
        }
        kVar.f187212f = forwardRecentItemView.f187013m;
        ResultRecord resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
            resultRecord = new ResultRecord();
        }
        ResultRecord resultRecord2 = resultRecord;
        TroopListBaseAdapter.b r16 = r(i3, i16);
        if (r16 != null && (obj = r16.f186184a) != null) {
            if (obj instanceof TroopInfo) {
                TroopInfo troopInfo = (TroopInfo) obj;
                kVar.f187210d = troopInfo.troopuin;
                kVar.f187211e = 4;
                if (!TextUtils.isEmpty(troopInfo.getTroopDisplayName())) {
                    str = troopInfo.getTroopDisplayName();
                } else {
                    str = troopInfo.troopuin;
                }
                resultRecord2.init(troopInfo.troopuin, str, 1, "", "");
                forwardRecentItemView.a(str, String.valueOf(troopInfo.getMemberNumClient()), null, resultRecord2, true, this.N.a(troopInfo.troopuin, 1));
                c(kVar, null);
                forwardRecentItemView.setOnClickListener(this.Q);
            } else if (obj instanceof DiscussionInfo) {
                DiscussionInfo discussionInfo = (DiscussionInfo) obj;
                String str2 = discussionInfo.uin;
                kVar.f187210d = str2;
                kVar.f187211e = 101;
                resultRecord2.init(str2, discussionInfo.discussionName, 3000, "", "");
                forwardRecentItemView.a(discussionInfo.discussionName, String.valueOf(((IDiscussionService) this.f186177i.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin)), null, resultRecord2, true, this.N.a(discussionInfo.uin, 3000));
                c(kVar, null);
                forwardRecentItemView.setOnClickListener(this.Q);
            } else if (QLog.isColorLevel()) {
                QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + r16.f186184a + " groupPosition:" + i3 + " childPosition:" + i16);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "getChildView itemInfo data null" + i3 + " childPosition:" + i16);
        }
        return forwardRecentItemView;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(this.f186178m).inflate(R.layout.e3z, viewGroup, false);
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
        if (this.D.size() == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            return view;
        }
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.K));
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f186177i, false)) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f186178m.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        }
        y(aVar, i3, z16);
        view.setOnClickListener(this.P);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e3z;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, expandableListView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            z((com.tencent.mobileqq.troop.adapter.contact.a) tag);
        }
        return true;
    }
}
