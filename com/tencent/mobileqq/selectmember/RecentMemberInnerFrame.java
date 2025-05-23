package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RecentMemberInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private List<RecentUser> D;
    private XListView E;
    private b F;
    private EditText G;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class b extends com.tencent.mobileqq.selectmember.adapter.c {
        static IPatchRedirector $redirector_;

        public b() {
            super(RecentMemberInnerFrame.this.f285782h, RecentMemberInnerFrame.this.f285784m, RecentMemberInnerFrame.this.E, 1, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentMemberInnerFrame.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (RecentMemberInnerFrame.this.D == null) {
                return 0;
            }
            return RecentMemberInnerFrame.this.D.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < RecentMemberInnerFrame.this.D.size()) {
                return RecentMemberInnerFrame.this.D.get(i3);
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
            c cVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view != null && view.getTag() != null) {
                    cVar = (c) view.getTag();
                } else {
                    cVar = new c(RecentMemberInnerFrame.this, null);
                    view = RecentMemberInnerFrame.this.f285782h.getLayoutInflater().inflate(R.layout.byd, viewGroup, false);
                    cVar.f285692i = (CheckBox) view.findViewById(R.id.axa);
                    cVar.f187212f = (ImageView) view.findViewById(R.id.icon);
                    cVar.f285693m = (TextView) view.findViewById(R.id.f5e);
                    view.setTag(cVar);
                }
                RecentUser recentUser = (RecentUser) getItem(i3);
                if (recentUser != null) {
                    if (RecentMemberInnerFrame.this.f285782h.isResultListContainFriend(recentUser.uin)) {
                        cVar.f285692i.setChecked(true);
                    } else {
                        cVar.f285692i.setChecked(false);
                    }
                    cVar.f187212f.setImageBitmap(c(1, recentUser.uin));
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin);
                    com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                    aVar.d(uidFromUin);
                    String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                    cVar.f285693m.setText(nameWithConfig);
                    String str = recentUser.uin;
                    cVar.f187210d = str;
                    ArrayList<String> arrayList = RecentMemberInnerFrame.this.f285782h.mUinsSelectedDefault;
                    if (arrayList != null && arrayList.contains(str)) {
                        cVar.f285692i.setEnabled(false);
                    } else {
                        cVar.f285692i.setEnabled(true);
                    }
                    if (AppSetting.f99565y) {
                        if (cVar.f285692i.isChecked() && cVar.f285692i.isEnabled()) {
                            view.setContentDescription(nameWithConfig + HardCodeUtil.qqStr(R.string.sv5));
                        } else {
                            view.setContentDescription(nameWithConfig + HardCodeUtil.qqStr(R.string.f172626sv2));
                        }
                    }
                    view.setOnClickListener(RecentMemberInnerFrame.this);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class c extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public CheckBox f285692i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f285693m;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentMemberInnerFrame.this);
        }

        /* synthetic */ c(RecentMemberInnerFrame recentMemberInnerFrame, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentMemberInnerFrame, (Object) aVar);
        }
    }

    public RecentMemberInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.D = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void t() {
        List<RecentUser> recentList;
        this.D.clear();
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f285784m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (recentUserCache != null && (recentList = recentUserCache.getRecentList(true)) != null) {
            String currentAccountUin = this.f285784m.getCurrentAccountUin();
            for (RecentUser recentUser : recentList) {
                if (recentUser != null) {
                    try {
                        if (recentUser.getType() == 0 && Long.parseLong(recentUser.uin) >= 10000 && !recentUser.uin.equals(currentAccountUin) && !this.f285782h.mUinsToHide.contains(recentUser.uin)) {
                            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin), "RecentMemberInnerFrame")) {
                                this.D.add(recentUser);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        setContentView(R.layout.byn);
        XListView xListView = (XListView) findViewById(R.id.f167137l64);
        this.E = xListView;
        xListView.setSelector(R.color.ajr);
        RelativeLayout relativeLayout = (RelativeLayout) this.f285782h.getLayoutInflater().inflate(R.layout.search_box, (ViewGroup) this.E, false);
        this.G = (EditText) relativeLayout.findViewById(R.id.et_search_keyword);
        ((Button) relativeLayout.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        this.E.addHeaderView(relativeLayout);
        t();
        b bVar = new b();
        this.F = bVar;
        this.E.setAdapter((ListAdapter) bVar);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(true, selectMemberActivity.getString(R.string.hdd), HardCodeUtil.qqStr(R.string.f172627sv3));
        b bVar = this.F;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, com.tencent.mobileqq.search.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), kVar);
        }
        return ((SelectMemberInnerFrame) this.f285783i.getChildAt(1)).n(z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "-1";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CheckBox checkBox;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            c cVar = (c) view.getTag();
            if (cVar != null && cVar.f187210d != null && (checkBox = cVar.f285692i) != null && cVar.f285693m != null && checkBox.isEnabled()) {
                cVar.f285692i.setChecked(this.f285782h.onListViewItemClick(cVar.f187210d, cVar.f285693m.getText().toString(), 0, "-1"));
                if (AppSetting.f99565y) {
                    if (cVar.f285692i.isChecked()) {
                        view.setContentDescription(cVar.f285693m.getText().toString() + HardCodeUtil.qqStr(R.string.f172625sv1));
                    } else {
                        view.setContentDescription(cVar.f285693m.getText().toString() + HardCodeUtil.qqStr(R.string.f172628sv4));
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        b bVar = this.F;
        if (bVar != null) {
            bVar.a();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.F.notifyDataSetChanged();
        }
    }

    public RecentMemberInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.D = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public RecentMemberInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.D = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
