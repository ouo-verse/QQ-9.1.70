package com.qzone.homepage.ui.component.newpanel;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.cn;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends l {
    private Activity C;
    private ShowMoreView D;
    private View E;
    private View F;
    private View G;
    private x6.a H;

    /* renamed from: i, reason: collision with root package name */
    private View f47785i;

    /* renamed from: m, reason: collision with root package name */
    private f f47786m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.D.c(2);
            h.this.p();
            h.this.g();
            LpReportInfo_pf00064.allReport(127, 7);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public h(Activity activity, long j3) {
        super(activity, j3);
        this.C = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.D.a();
        x6.a aVar = this.H;
        if (aVar != null) {
            aVar.moreNewCount = 0;
        }
    }

    public void h() {
        f fVar = this.f47786m;
        if (fVar != null) {
            fVar.n();
        }
    }

    public View i() {
        return this.f47785i;
    }

    public void j() {
        x6.a aVar = this.H;
        if (aVar == null || aVar.moreNewCount <= 0) {
            return;
        }
        this.D.d();
    }

    public void l(View view, View view2) {
        if (this.f47756h) {
            return;
        }
        k(view);
        this.F = view2;
    }

    public boolean m() {
        f fVar = this.f47786m;
        return fVar != null && fVar.t();
    }

    public void n(int i3) {
        o(this.D, i3);
        o(this.E, i3);
    }

    public void p() {
        f fVar = this.f47786m;
        if (fVar != null) {
            fVar.z();
        }
    }

    public void q(x6.a aVar) {
        if (this.f47786m != null) {
            this.H = aVar;
            if (aVar != null) {
                r(aVar.mPanelHideList);
                j();
                ShowMoreView showMoreView = this.D;
                if (showMoreView != null) {
                    showMoreView.c(1);
                }
            }
            this.f47786m.B(aVar);
        }
    }

    private void o(View view, int i3) {
        if (view == null || view.getBackground() == null) {
            return;
        }
        Drawable f16 = cn.f(view.getBackground());
        f16.setAlpha(i3);
        view.setBackground(f16);
    }

    public void k(View view) {
        View findViewById = view.findViewById(R.id.f4o);
        this.f47785i = findViewById;
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.D = (ShowMoreView) view.findViewById(R.id.it_);
        this.E = view.findViewById(R.id.uj_);
        this.G = view.findViewById(R.id.h9x);
        this.f47786m = new f(this.C, this.f47754e, e.b().d(this.f47754e), e.b().c(this.f47754e));
        this.D.setOnClickListener(new a());
        this.f47785i.setVisibility(0);
        this.D.setBackgroundStyle(a().getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg), a().getResources().getColor(R.color.qui_common_text_primary));
    }

    public void r(ArrayList<HomePanelItem> arrayList) {
        Drawable drawable;
        ArrayList<HomePanelItem> arrayList2;
        if (arrayList == null) {
            return;
        }
        boolean z16 = arrayList.size() > 0;
        this.D.f(d().getString(z16 ? R.string.cau : R.string.c7b));
        if (z16) {
            drawable = d().getDrawable(R.drawable.qui_chevron_down);
        } else {
            drawable = d().getDrawable(R.drawable.qui_setting_icon_primary);
        }
        this.D.e(drawable);
        View view = this.G;
        x6.a aVar = this.H;
        view.setVisibility((aVar == null || (arrayList2 = aVar.mPanelShowList) == null || arrayList2.isEmpty()) ? 8 : 0);
    }
}
