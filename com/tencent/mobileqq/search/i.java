package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jn2.b;
import mqq.app.MobileQQ;
import yx3.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends BaseSearchEntryModel<View> implements View.OnClickListener, a.InterfaceC11637a {
    private View F;
    private ImageView G;
    private ImageView H;
    private Button I;
    private Button J;
    private TextView K;
    private jn2.f L;
    private yx3.a M;
    private TextView N;
    private TextView P;
    private ViewGroup Q;
    private View R;
    private c S;
    private b T;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IDynamicParams {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            boolean s06;
            String str2;
            HashMap hashMap = new HashMap();
            if (i.this.Q != null) {
                if ("clck".equals(str)) {
                    s06 = !i.this.L.s0();
                } else {
                    s06 = i.this.L.s0();
                }
                if (s06) {
                    str2 = "\u5c55\u5f00";
                } else {
                    str2 = "\u6536\u8d77";
                }
                hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, str2);
            }
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void onClear();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(j jVar);
    }

    public i(int i3, int i16) {
        super(i3, i16);
        com.tencent.mobileqq.search.util.aa.f284983a = com.tencent.mobileqq.search.util.aa.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, j jVar, int i3) {
        InputMethodUtil.hide(this.F);
        yx3.a aVar = this.M;
        if (aVar != null && jVar != null) {
            aVar.doSearchHistoryAction(view.getContext(), this.mTabType, i3, jVar);
            com.tencent.mobileqq.search.util.aa.e("0X800C2C3", jVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view, j jVar, int i3) {
        if (this.M != null && jVar != null) {
            QLog.d("QQSearch.Local.entry.HistorySearchEntryModelExpD", 1, "onItemDelClickListener: item = " + com.tencent.mobileqq.search.util.af.a(jVar.f(), 2) + ", pos = " + i3);
            this.M.deleteHistory(jVar);
            com.tencent.mobileqq.search.util.aa.e("0X800C2C4", jVar, i3);
        }
    }

    private void J() {
        VideoReport.setElementId(this.Q, "em_bas_unfold_packup");
        VideoReport.setEventDynamicParams(this.Q, new a());
        VideoReport.setElementExposePolicy(this.Q, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.Q, ClickPolicy.REPORT_ALL);
    }

    private void M() {
        if (this.L.t0()) {
            com.tencent.mobileqq.search.util.aa.h("0X800C2C7", true);
            AccessibilityUtil.m(this.I);
            this.G.setVisibility(8);
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            N(8);
            return;
        }
        com.tencent.mobileqq.search.util.aa.h("0X800C2C5", false);
        AccessibilityUtil.m(this.G);
        this.G.setVisibility(0);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        if (this.L.p0() > 6) {
            N(0);
        }
    }

    private void N(int i3) {
        this.Q.setVisibility(i3);
    }

    public View D() {
        return this.G;
    }

    public View E() {
        return this.I;
    }

    public View F() {
        return this.N;
    }

    public boolean G() {
        ac acVar = (ac) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
        if (acVar == null) {
            QLog.d("QQSearch.Local.entry.HistorySearchEntryModelExpD", 1, "isLocalHistoryDataEmpty()   syncGetSearchHistoryData fail. not found manager");
            return true;
        }
        return acVar.g().isEmpty();
    }

    public void K(c cVar) {
        this.S = cVar;
        jn2.f fVar = this.L;
        if (fVar != null) {
            fVar.B0(cVar);
        }
    }

    public void L(b bVar) {
        this.T = bVar;
    }

    @Override // yx3.a.InterfaceC11637a
    public void a(List<j> list) {
        if (this.F != null && this.L != null) {
            com.tencent.mobileqq.search.util.aa.i();
            jn2.f fVar = this.L;
            fVar.z0(fVar.t0());
            M();
            this.L.updateData(list);
            int i3 = 8;
            this.K.setVisibility(8);
            if (list != null && !list.isEmpty()) {
                this.F.setVisibility(0);
                if (!this.L.t0()) {
                    if (list.size() > 6) {
                        i3 = 0;
                    }
                    N(i3);
                }
                com.tencent.mobileqq.search.util.u.l(this.F, list.size());
                com.tencent.mobileqq.search.util.u.h(this.J, list.size());
                return;
            }
            this.F.setVisibility(8);
        }
    }

    @Override // yx3.a.InterfaceC11637a
    public void j(boolean z16, j jVar) {
        if (jVar != null) {
            QLog.d("QQSearch.Local.entry.HistorySearchEntryModelExpD", 1, z16 + " item = " + jVar.f());
        } else {
            QLog.d("QQSearch.Local.entry.HistorySearchEntryModelExpD", 1, z16 + " item = null");
        }
        if (z16) {
            this.L.j0(this.L.r0(jVar));
            com.tencent.mobileqq.search.util.u.h(this.J, this.L.getItemCount());
            this.L.C0(0);
            if (this.L.isEmpty()) {
                this.L.z0(false);
                M();
                this.K.setVisibility(0);
                this.I.setVisibility(8);
                this.G.setVisibility(8);
                this.J.setVisibility(8);
                return;
            }
            return;
        }
        QQToastUtil.showQQToast(1, R.string.f224366iq);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void o() {
        super.o();
        if (this.N != null && !TextUtils.isEmpty(getModelName())) {
            this.N.setText(getModelName());
        }
        yx3.a aVar = this.M;
        if (aVar != null) {
            aVar.asyncGetSearchHistoryData(new kp2.l(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        InputMethodUtil.hide(this.F);
        if (id5 == R.id.y1y) {
            this.L.z0(true);
            M();
            com.tencent.mobileqq.search.util.aa.d("0X800C2C6");
        } else if (id5 == R.id.tdz) {
            this.L.z0(false);
            M();
            com.tencent.mobileqq.search.util.aa.d("0X800C2C8");
        } else if (id5 == R.id.td_) {
            EventCollector.getInstance().onViewClicked(view);
            b bVar = this.T;
            if (bVar != null) {
                bVar.onClear();
            }
            this.L.o0();
        } else if (id5 == R.id.vcd) {
            this.L.D0();
            TextView textView = this.P;
            Resources resources = textView.getResources();
            if (this.L.s0()) {
                i3 = R.string.f224346io;
            } else {
                i3 = R.string.f224356ip;
            }
            textView.setText(resources.getString(i3));
            ImageView imageView = this.H;
            if (this.L.s0()) {
                i16 = R.drawable.qui_chevron_down_icon_secondary_01;
            } else {
                i16 = R.drawable.qui_chevron_up_icon_secondary_01;
            }
            imageView.setImageResource(i16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void onResume() {
        super.onResume();
        jn2.f fVar = this.L;
        if (fVar != null && fVar.isEmpty()) {
            this.F.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void r(Configuration configuration) {
        super.r(configuration);
        jn2.f fVar = this.L;
        if (fVar != null && configuration != null) {
            fVar.w0(ViewUtils.dpToPx(configuration.screenWidthDp), ViewUtils.dpToPx(configuration.screenHeightDp));
            this.L.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void refresh() {
        super.refresh();
        yx3.a aVar = this.M;
        if (aVar != null) {
            aVar.asyncGetSearchHistoryData(new kp2.l(this));
        }
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public View s(Context context, QQAppInterface qQAppInterface, ViewGroup viewGroup, Bundle bundle) {
        View view = this.F;
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                View view2 = this.F;
                ((ViewGroup) view2).removeView(view2);
            }
        } else {
            this.F = LayoutInflater.from(context).inflate(R.layout.i2v, viewGroup, false);
        }
        if (this.showDivider) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = ViewUtils.dip2px(8.0f);
            this.F.setLayoutParams(marginLayoutParams);
        }
        this.F.setVisibility(8);
        Button button = (Button) this.F.findViewById(R.id.td_);
        this.J = button;
        button.setOnClickListener(this);
        ImageView imageView = (ImageView) this.F.findViewById(R.id.y1y);
        this.G = imageView;
        imageView.setOnClickListener(this);
        Button button2 = (Button) this.F.findViewById(R.id.tdz);
        this.I = button2;
        button2.setOnClickListener(this);
        TextView textView = (TextView) this.F.findViewById(R.id.f107716b6);
        this.K = textView;
        textView.setVisibility(8);
        this.N = (TextView) this.F.findViewById(R.id.kbs);
        this.R = this.F.findViewById(R.id.f116146xy);
        this.H = (ImageView) this.F.findViewById(R.id.y3d);
        this.P = (TextView) this.F.findViewById(R.id.f108056c3);
        ViewGroup viewGroup2 = (ViewGroup) this.F.findViewById(R.id.vcd);
        this.Q = viewGroup2;
        viewGroup2.setOnClickListener(this);
        J();
        RecyclerView recyclerView = (RecyclerView) this.F.findViewById(R.id.f790048l);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2, 1, false));
        recyclerView.setItemAnimator(null);
        jn2.f fVar = new jn2.f(qQAppInterface);
        this.L = fVar;
        fVar.B0(this.S);
        recyclerView.setAdapter(this.L);
        this.L.l0(new b.a() { // from class: com.tencent.mobileqq.search.g
            @Override // jn2.b.a
            public final void a(View view3, Object obj, int i3) {
                i.this.H(view3, (j) obj, i3);
            }
        });
        this.L.A0(new b.a() { // from class: com.tencent.mobileqq.search.h
            @Override // jn2.b.a
            public final void a(View view3, Object obj, int i3) {
                i.this.I(view3, (j) obj, i3);
            }
        });
        if (this.M == null) {
            this.M = new kp2.i();
        }
        this.M.init(qQAppInterface, context);
        this.L.y0(this.M);
        return this.F;
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void t() {
        super.t();
        yx3.a aVar = this.M;
        if (aVar != null) {
            aVar.destroy();
        }
        jn2.f fVar = this.L;
        if (fVar != null) {
            fVar.release();
        }
        com.tencent.mobileqq.search.util.aa.a();
    }

    @Override // com.tencent.mobileqq.search.BaseSearchEntryModel
    public void v(boolean z16) {
        jn2.f fVar;
        super.v(z16);
        if (!z16 && (fVar = this.L) != null && fVar.isEmpty()) {
            this.F.setVisibility(8);
        }
    }

    public i(int i3, int i16, yx3.a aVar) {
        this(i3, i16);
        this.M = aVar;
    }
}
