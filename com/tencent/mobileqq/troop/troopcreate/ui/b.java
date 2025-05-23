package com.tencent.mobileqq.troop.troopcreate.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.o;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends ActionSheet implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    XListView C;
    AppInterface D;
    ImageView E;
    ITroopCreateService F;
    ITroopCreateInfoService.a G;
    Activity H;
    int I;
    private ArrayList<ITroopSearchService.a> J;
    long K;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<ITroopSearchService.a> f300151d;

        a(List<ITroopSearchService.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) list);
            } else {
                this.f300151d = list;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f300151d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f300151d.get(i3);
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
        @SuppressLint({"SetTextI18n"})
        public View getView(int i3, View view, ViewGroup viewGroup) {
            C8804b c8804b;
            int i16;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(b.this.getContext()).inflate(R.layout.fzj, viewGroup, false);
                    c8804b = new C8804b();
                    c8804b.f300154b = (SingleLineTextView) view.findViewById(R.id.f5e);
                    c8804b.f300156d = (ImageView) view.findViewById(R.id.d3z);
                    c8804b.f300155c = (TextView) view.findViewById(R.id.lastMsgTime);
                    view.setOnClickListener(b.this);
                    view.setTag(c8804b);
                } else {
                    c8804b = (C8804b) view.getTag();
                }
                ITroopSearchService.a aVar = (ITroopSearchService.a) getItem(i3);
                c8804b.f300154b.setText(aVar.f299977d.getTroopDisplayName());
                view.setContentDescription(c8804b.f300154b.getText());
                TroopInfo troopInfo = aVar.f299977d;
                if (troopInfo.lastMsgTime != 0) {
                    c8804b.f300155c.setVisibility(0);
                    o c16 = o.c();
                    TroopInfo troopInfo2 = aVar.f299977d;
                    String d16 = c16.d(troopInfo2.troopuin, troopInfo2.lastMsgTime);
                    String qqStr = HardCodeUtil.qqStr(R.string.f2328075j);
                    c8804b.f300155c.setText(qqStr + d16);
                } else if (troopInfo.troopCreateTime != 0) {
                    c8804b.f300155c.setVisibility(0);
                    o c17 = o.c();
                    TroopInfo troopInfo3 = aVar.f299977d;
                    String d17 = c17.d(troopInfo3.troopuin, troopInfo3.troopCreateTime);
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f2327975i);
                    c8804b.f300155c.setText(qqStr2 + d17);
                } else {
                    c8804b.f300155c.setVisibility(8);
                }
                if (aVar.f299977d.hasSetTroopHead()) {
                    i16 = 4;
                } else {
                    i16 = 113;
                }
                c8804b.f300156d.setImageDrawable(FaceDrawable.getFaceDrawable(b.this.D, i16, aVar.f299977d.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3)));
                c8804b.f300153a = aVar.f299977d.troopuin;
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8804b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f300153a;

        /* renamed from: b, reason: collision with root package name */
        SingleLineTextView f300154b;

        /* renamed from: c, reason: collision with root package name */
        TextView f300155c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f300156d;

        C8804b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    public b(Activity activity, ITroopCreateInfoService.a aVar) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) aVar);
            return;
        }
        this.I = 0;
        this.K = 0L;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.D = appInterface;
        this.F = (ITroopCreateService) appInterface.getRuntimeService(ITroopCreateService.class, "");
        this.H = activity;
        this.G = aVar;
    }

    public void n0(ArrayList<ITroopSearchService.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            this.J = arrayList;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int i3 = ((ITroopCreateInfoService) this.D.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().createFrom;
            if (view.getTag() != null) {
                this.F.onReuseTroop(((C8804b) view.getTag()).f300153a);
                ReportController.o(this.D, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + i3, "" + this.I, "", "");
                this.F.terminateLogic();
            } else if (R.id.f81154de == view.getId()) {
                if (System.currentTimeMillis() - this.K > 1500) {
                    this.K = System.currentTimeMillis();
                    this.F.createTroop(this.H, this.G);
                }
                ReportController.o(this.D, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + i3, "" + this.I, "", "");
            } else if (R.id.az7 == view.getId()) {
                this.F.terminateLogic();
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.ActionSheet, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.fzi, (ViewGroup) null);
        if ("1103".equals(ThemeUtil.curThemeId)) {
            linearLayout.setBackgroundColor(-15921907);
        }
        addView(linearLayout);
        this.C = (XListView) linearLayout.findViewById(R.id.search_result_list);
        ArrayList<ITroopSearchService.a> arrayList = this.J;
        if (arrayList != null && arrayList.size() != 0) {
            this.C.setAdapter((ListAdapter) new a(this.J));
            this.C.setMaxHeight(Utils.n(200.0f, getContext().getResources()));
            ((TextView) linearLayout.findViewById(R.id.i9l)).setText(String.format(HardCodeUtil.qqStr(R.string.oqz), Integer.valueOf(this.J.size())));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.az7);
            this.E = imageView;
            imageView.setOnClickListener(this);
            TroopCreateInfo troopCreateInfo = ((ITroopCreateInfoService) this.D.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo();
            linearLayout.findViewById(R.id.f81154de).setOnClickListener(this);
            super.show();
            ReportController.o(this.D, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + troopCreateInfo.createFrom, "" + this.I, "", "");
            return;
        }
        dismiss();
        this.F.terminateLogic();
        this.H.finish();
    }
}
