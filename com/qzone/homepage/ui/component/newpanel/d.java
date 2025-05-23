package com.qzone.homepage.ui.component.newpanel;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.qzone.homepage.ui.component.newpanel.PanelPopupAdapter;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends l {
    protected View C;
    protected ListView D;
    protected PanelPopupAdapter E;
    protected Activity F;
    protected ArrayList<HomePanelItem> G;
    private int H;
    protected i I;
    private final RedpointObserver J;

    /* renamed from: i, reason: collision with root package name */
    protected Activity f47757i;

    /* renamed from: m, reason: collision with root package name */
    protected View f47758m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends RedpointObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("HomeShowPanel", 2, "[redPointObserver] onChange\uff1a", Boolean.valueOf(z16));
            }
            if (z16) {
                d.this.r();
            }
        }
    }

    public d(Activity activity, long j3, ArrayList<HomePanelItem> arrayList) {
        super(activity, j3);
        this.H = 255;
        this.I = new a();
        this.J = new b();
        this.f47757i = activity;
        this.G = arrayList;
        this.F = activity;
    }

    private void f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("HomeShowPanel", 1, "[addRedPointObserver] failed");
        } else {
            ((QQAppInterface) peekAppRuntime).addObserver(this.J);
        }
    }

    private void l() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("HomeShowPanel", 1, "[removeRedPointObserver] failed");
        } else {
            ((QQAppInterface) peekAppRuntime).removeObserver(this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ListView listView = this.D;
        if (listView != null && listView.getChildCount() > 0) {
            PanelPopupAdapter panelPopupAdapter = this.E;
            if (panelPopupAdapter != null && panelPopupAdapter.getCount() > 0) {
                for (int i3 = 0; i3 < this.D.getChildCount(); i3++) {
                    View childAt = this.D.getChildAt(i3);
                    if (childAt != null && (childAt.getTag() instanceof PanelPopupAdapter.d)) {
                        PanelPopupAdapter.d dVar = (PanelPopupAdapter.d) childAt.getTag();
                        if (this.E.getCount() > i3 && (this.E.getItem(i3) instanceof HomePanelItem)) {
                            HomePanelItem homePanelItem = (HomePanelItem) this.E.getItem(i3);
                            if (homePanelItem.tabId == 17) {
                                this.E.v(dVar, homePanelItem);
                            }
                        }
                    }
                }
                return;
            }
            QLog.e("HomeShowPanel", 1, "[updateGameEntranceRedPoint] adapter count <= 0");
            return;
        }
        QLog.e("HomeShowPanel", 1, "[updateGameEntranceRedPoint] listView child view is empty");
    }

    public View i() {
        return this.C;
    }

    public void j(View view, Activity activity) {
        this.f47758m = view;
        this.F = activity;
        View findViewById = view.findViewById(R.id.f4m);
        this.C = findViewById;
        findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        this.D = (ListView) view.findViewById(R.id.f4p);
        ArrayList<HomePanelItem> d16 = e.b().d(this.f47754e);
        g(d16);
        PanelPopupAdapter panelPopupAdapter = new PanelPopupAdapter(activity, d16, this.f47754e);
        this.E = panelPopupAdapter;
        panelPopupAdapter.r(this.H);
        this.E.o(this.I);
        this.E.q(0);
        ListView listView = this.D;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.E);
            this.D.setDivider(new InsetDrawable((Drawable) new ColorDrawable(d().getColor(R.color.qui_common_border_light)), ar.e(12.0f), 0, ar.e(12.0f), 0));
            this.D.setDividerHeight(ar.d(0.5f));
        }
        f();
    }

    public void k() {
        h();
    }

    public void m(int i3) {
        PanelPopupAdapter panelPopupAdapter = this.E;
        if (panelPopupAdapter != null) {
            panelPopupAdapter.n(i3);
        }
    }

    public void n(int i3) {
        this.H = i3;
        PanelPopupAdapter panelPopupAdapter = this.E;
        if (panelPopupAdapter != null) {
            panelPopupAdapter.r(i3);
            this.E.notifyDataSetChanged();
        }
        if (i() != null && i().getBackground() != null) {
            i().getBackground().setAlpha(this.H);
        }
        ListView listView = this.D;
        if (listView == null || listView.getBackground() == null) {
            return;
        }
        this.D.getBackground().setAlpha(this.H);
    }

    public void o(int i3) {
        View view = this.C;
        if (view != null) {
            view.setVisibility(i3);
        }
        ListView listView = this.D;
        if (listView != null) {
            listView.setVisibility(i3);
        }
    }

    public void p(ArrayList<HomePanelItem> arrayList) {
        if (this.E == null || arrayList == null) {
            return;
        }
        this.G = arrayList;
        g(arrayList);
        this.E.t(this.G);
        this.E.notifyDataSetChanged();
    }

    public void q(x6.a aVar) {
        if (this.E == null || aVar == null) {
            return;
        }
        int i3 = aVar.relationShip;
        boolean z16 = true;
        if (i3 == 0 ? aVar.uin != this.f47755f : i3 != 1 && i3 != 2) {
            z16 = false;
        }
        if (aVar.needShowHomePanel() && z16) {
            o(0);
            this.E.s(aVar);
            p(aVar.mPanelShowList);
            if (NetworkUtil.isNetworkAvailable(this.f47757i)) {
                e.b().e(aVar.uin, new HomePanelList(aVar.uin, aVar.mPanelShowList, aVar.mPanelHideList));
                return;
            }
            return;
        }
        o(8);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements i {
        a() {
        }

        @Override // com.qzone.homepage.ui.component.newpanel.i
        public void a(PanelPopupAdapter panelPopupAdapter, int i3, int i16) {
            if (panelPopupAdapter == null || panelPopupAdapter.getCount() <= i3) {
                return;
            }
            d dVar = d.this;
            k.b(dVar.F, dVar.f47754e, (HomePanelItem) panelPopupAdapter.getItem(i3), panelPopupAdapter.k(), 0);
            panelPopupAdapter.d(i3);
        }
    }

    @Deprecated
    public void h() {
        o(8);
        this.f47758m = null;
        this.F = null;
        PanelPopupAdapter panelPopupAdapter = this.E;
        if (panelPopupAdapter != null) {
            panelPopupAdapter.e();
            this.E = null;
        }
        this.G = null;
        l();
    }

    private void g(ArrayList<HomePanelItem> arrayList) {
        if (arrayList == null) {
            return;
        }
        int decodeInt = VipMMKV.getLoveZone(String.valueOf(this.f47754e)).decodeInt(AppConstants.Preferences.LOVE_STATE_FOR_CURRENT_UIN, 0);
        if (!StudyModeManager.t() || decodeInt == 1) {
            return;
        }
        Iterator<HomePanelItem> it = arrayList.iterator();
        while (it.hasNext()) {
            HomePanelItem next = it.next();
            if (QzoneConfig.DefaultValue.USERHOME_BAR_LOVER_ZONE_NAME.equals(next.text)) {
                arrayList.remove(next);
                return;
            }
        }
    }
}
