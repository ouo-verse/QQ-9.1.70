package com.tencent.mobileqq.vasgift.business.dt;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.GridView;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.vasgift.mvvm.business.f;
import com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasGiftDtReportHelper implements com.tencent.mobileqq.vasgift.business.dt.a {

    /* renamed from: a, reason: collision with root package name */
    private final QQGiftPanelViewModel f311606a;

    /* renamed from: e, reason: collision with root package name */
    private View f311610e;

    /* renamed from: f, reason: collision with root package name */
    private View f311611f;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<Integer> f311607b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<Integer> f311608c = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<Integer> f311609d = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray<GridView> f311612g = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, View> f311613h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Map<Integer, View> f311614i = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f311624a;

        a(Map map) {
            this.f311624a = map;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            this.f311624a.put("qq_receiver_id", VasGiftDtReportHelper.this.L());
            return this.f311624a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f311626a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f311627b;

        b(d dVar, int i3) {
            this.f311626a = dVar;
            this.f311627b = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                i3 = 10;
            } else {
                i3 = 8;
            }
            HashMap hashMap = new HashMap();
            VasGiftDtReportHelper.this.B(hashMap);
            hashMap.put("qq_gift_id", String.valueOf(this.f311626a.f264874d));
            hashMap.put("qq_gift_name", this.f311626a.f264876e);
            hashMap.put("qq_gift_price", String.valueOf(this.f311626a.f264878f));
            hashMap.put("qq_receiver_id", String.valueOf(this.f311626a.K));
            hashMap.put("qq_page_num", String.valueOf((this.f311627b / i3) + 1));
            hashMap.put("qq_gift_type", VasGiftDtReportHelper.this.I(this.f311626a));
            hashMap.putAll(VasGiftDtReportHelper.this.K());
            return hashMap;
        }
    }

    public VasGiftDtReportHelper(QQGiftPanelViewModel qQGiftPanelViewModel) {
        this.f311606a = qQGiftPanelViewModel;
    }

    private void A(Map<String, Object> map) {
        E(map, "sgrp_channel_id", this.f311606a.D2().f264944k);
        E(map, "sgrp_sub_channel_id", this.f311606a.D2().f264945l);
    }

    private void C(Map<String, Object> map) {
        com.tencent.mobileqq.qqgift.mvvm.business.data.a D2 = this.f311606a.D2();
        if (D2 == null) {
            return;
        }
        E(map, "qqlive_user_id", D2.f264935b);
        E(map, "qqlive_anchor_id", D2.f264936c);
        E(map, "qqlive_room_id", D2.f264937d);
        E(map, "qqlive_programme_id", D2.f264938e);
        E(map, "qqlive_zhibo_type", D2.f264939f);
        E(map, "qqlive_zhibo_content", D2.f264940g);
        E(map, "qqlive_start_source", D2.f264941h);
        E(map, "qqlive_scene_id", D2.f264942i);
        E(map, "qqlive_subscene_id", D2.f264943j);
        E(map, "qqlive_enter_id", D2.f264949p);
        E(map, "qqlive_coming_way", D2.f264948o);
        E(map, QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, D2.f264950q);
    }

    private void D(Map<String, Object> map) {
        E(map, "qq_group_id", this.f311606a.D2().f264951r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Map<String, Object> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        } else {
            map.put(str, "");
        }
    }

    private void F(final d dVar, final int i3, final View view, final String str) {
        ThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGiftDtReportHelper.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VasGiftDtReportHelper.this.O(dVar, i3, view, str);
                } catch (Exception e16) {
                    QLog.e("VasGiftDtReportHelper", 1, e16.toString());
                }
            }
        }, 200L);
    }

    private String G(com.tencent.mobileqq.qqgift.sdk.config.a aVar) {
        String str = aVar.f264976e;
        if (TextUtils.isEmpty(str)) {
            str = aVar.f264977f;
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.f264972a + "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0040, code lost:
    
        if (r4 != 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, Object> H(d dVar) {
        long j3;
        HashMap hashMap = new HashMap();
        B(hashMap);
        if (dVar != null) {
            hashMap.put("qq_gift_id", String.valueOf(dVar.f264874d));
            hashMap.put("qq_gift_name", dVar.f264876e);
            hashMap.put("qq_gift_price", String.valueOf(dVar.f264878f));
        }
        com.tencent.mobileqq.qqgift.data.service.c x16 = this.f311606a.H2().a().x();
        if (x16 != null) {
            j3 = x16.f264861b;
        }
        j3 = 0;
        if (j3 == 0) {
            com.tencent.mobileqq.qqgift.mvvm.business.data.a D2 = this.f311606a.D2();
            if (D2 != null && !TextUtils.isEmpty(D2.f264936c)) {
                hashMap.put("qq_receiver_id", D2.f264936c);
            }
        } else {
            hashMap.put("qq_receiver_id", String.valueOf(j3));
        }
        hashMap.put("qq_gift_type", I(dVar));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I(d dVar) {
        if (dVar == null) {
            return "gold";
        }
        if (dVar.F == 1) {
            return "free";
        }
        if (dVar.f264881h != 2) {
            return "gold";
        }
        return "active";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> J() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("dt_pgid", "pg_qq_gift_panel");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Map<String, Object> K() {
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig = this.f311606a.H2().getSDKConfig();
        hashMap.put("qq_gift_appid", G(sDKConfig));
        hashMap.put("qq_scene_id", sDKConfig.f264977f);
        hashMap.put("qq_scene_name", sDKConfig.f264976e);
        hashMap.put("qq_user_id", this.f311606a.H2().getAppRuntime().getCurrentAccountUin());
        B(hashMap);
        z(hashMap);
        if (sDKConfig.f264976e.equals(WadlProxyConsts.CHANNEL)) {
            A(hashMap);
        } else if (sDKConfig.f264976e.equals("10012")) {
            D(hashMap);
        } else {
            C(hashMap);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.a D2;
        String valueOf = String.valueOf(this.f311606a.H2().a().x().f264861b);
        if ((TextUtils.isEmpty(valueOf) || valueOf.equals("0")) && (D2 = this.f311606a.D2()) != null) {
            return D2.f264936c;
        }
        return valueOf;
    }

    private void M(View view) {
        this.f311610e = view;
        VideoReport.setElementId(view, "em_qq_gift_panel_gift_multiplegive");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private void N(View view) {
        VideoReport.setPageId(view, "pg_qq_gift_panel");
        VideoReport.reportEvent("pgin", view, P(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(d dVar, int i3, View view, String str) {
        try {
            VideoReport.setElementId(view, str);
            VideoReport.setElementReuseIdentifier(view, String.valueOf(dVar.f264874d));
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setEventDynamicParams(view, new b(dVar, i3));
            VideoReport.reportEvent("imp", view, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @NonNull
    private Map<String, Object> P(View view) {
        Map<String, Object> K = K();
        VideoReport.setEventDynamicParams(view, new a(K));
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) K));
        return K;
    }

    private void Q(View view) {
        VideoReport.setElementId(view, "em_qq_gift_panel_recharge");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private void R() {
        f<List<List<d>>> value = this.f311606a.G2().getValue();
        if (value != null && value.a() != null) {
            Iterator<List<d>> it = value.a().iterator();
            while (it.hasNext()) {
                Iterator<d> it5 = it.next().iterator();
                while (it5.hasNext()) {
                    it5.next().L = false;
                }
            }
        }
        HashSet<GridView> hashSet = new HashSet();
        for (int i3 = 0; i3 < this.f311612g.size(); i3++) {
            hashSet.add(this.f311612g.valueAt(i3));
        }
        for (GridView gridView : hashSet) {
            for (int i16 = 0; i16 < gridView.getChildCount(); i16++) {
                View childAt = gridView.getChildAt(i16);
                if (childAt != null) {
                    VideoReport.reportEvent("imp_end", childAt, J());
                }
            }
        }
        this.f311612g.clear();
    }

    private void z(Map<String, Object> map) {
        if (this.f311606a.C2() != null) {
            map.putAll(this.f311606a.C2());
        }
    }

    public void B(Map<String, Object> map) {
        map.put("dt_pgid", "pg_qq_gift_panel");
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void a(d dVar) {
        VideoReport.setElementParams(this.f311610e, H(dVar));
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void b(View view, View view2, View view3) {
        try {
            this.f311611f = view;
            N(view);
            M(view2);
            Q(view3);
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void c(boolean z16, d dVar, String str) {
        try {
            Map<String, Object> H = H(dVar);
            H.putAll(K());
            if (z16) {
                VideoReport.reportEvent("ev_qq_gift_success", this.f311610e, H);
            } else {
                H.put("qq_gift_fail_reason", str);
                VideoReport.reportEvent("ev_qq_gift_failure", this.f311610e, H);
            }
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void d(View view, View view2, View view3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pgid", "pg_qq_gift_panel");
            B(hashMap);
            VideoReport.reportEvent("pgout", view, hashMap);
            VideoReport.reportEvent("imp_end", view2, J());
            VideoReport.reportEvent("imp_end", view3, J());
            R();
            this.f311614i.clear();
            this.f311613h.clear();
            this.f311607b.clear();
            this.f311609d.clear();
            this.f311608c.clear();
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void f(View view) {
        try {
            VideoReport.setElementId(view, "em_qq_gift_panel_describe");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            B(hashMap);
            hashMap.put("qq_gift_id", String.valueOf(this.f311606a.Q2()));
            VideoReport.setElementParams(view, hashMap);
            if (view.getVisibility() == 0) {
                VideoReport.reportEvent("imp", view, J());
            }
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void g(CustomTabLayoutCompat customTabLayoutCompat, int i3, String str, String str2) {
        try {
            View childAt = customTabLayoutCompat.getChildAt(i3);
            VideoReport.setElementId(childAt, "em_qq_gift_panel_tab");
            HashMap hashMap = new HashMap();
            E(hashMap, "qq_tab_name", str2);
            E(hashMap, "qq_tab_id", str);
            B(hashMap);
            VideoReport.setElementReuseIdentifier(childAt, str);
            VideoReport.setElementParams(childAt, hashMap);
            VideoReport.reportEvent("clck", childAt, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public Map<String, String> h() {
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void i(final View view, final String str, final String str2, final int i3) {
        ThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGiftDtReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VasGiftDtReportHelper.this.f311607b.contains(Integer.valueOf(i3))) {
                        return;
                    }
                    VasGiftDtReportHelper.this.f311607b.add(Integer.valueOf(i3));
                    VideoReport.setElementId(view, "em_qq_gift_panel_gift");
                    HashMap hashMap = new HashMap();
                    VasGiftDtReportHelper.this.B(hashMap);
                    hashMap.put("qq_moduleid", "pg_qq_gift_panel");
                    hashMap.put("qq_tab_id", str);
                    hashMap.put("qq_tab_name", str2);
                    hashMap.putAll(VasGiftDtReportHelper.this.K());
                    VideoReport.setElementParams(view, hashMap);
                    VideoReport.reportEvent("imp", view, VasGiftDtReportHelper.this.J());
                } catch (Exception e16) {
                    QLog.e("VasGiftDtReportHelper", 1, e16.toString());
                }
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void j(View view, long j3) {
        try {
            HashMap hashMap = new HashMap();
            B(hashMap);
            hashMap.put("qq_balance_amt", Long.valueOf(j3));
            VideoReport.setElementParams(view, hashMap);
            VideoReport.reportEvent("clck", view, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void k(View view, long j3) {
        try {
            VideoReport.setElementId(view, "em_qq_gift_panel_active_coin");
            HashMap hashMap = new HashMap();
            B(hashMap);
            hashMap.put("qq_balance_amt", Long.valueOf(j3));
            VideoReport.setElementParams(view, hashMap);
            VideoReport.reportEvent("imp", view, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void l(Object obj, Long l3) {
        try {
            HashMap hashMap = new HashMap();
            B(hashMap);
            if (l3 != null) {
                hashMap.put("qq_balance_amt", String.valueOf(l3));
            }
            VideoReport.setElementParams(obj, hashMap);
            VideoReport.reportEvent("imp", obj, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void m(View view) {
        try {
            VideoReport.setElementId(view, "em_qq_gift_panel_set");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            hashMap.put("qq_moduleid", "em_qq_gift_panel_set_choose");
            B(hashMap);
            VideoReport.setElementParams(view, hashMap);
            VideoReport.reportEvent("imp", view, J());
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void n(d dVar, int i3) {
        int i16;
        try {
            if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                i16 = 10;
            } else {
                i16 = 8;
            }
            HashMap hashMap = new HashMap();
            B(hashMap);
            hashMap.put("qq_gift_id", Integer.valueOf(dVar.f264874d));
            hashMap.put("qq_gift_name", dVar.f264876e);
            hashMap.put("qq_gift_price", Integer.valueOf(dVar.f264878f));
            hashMap.put("qq_receiver_id", Long.valueOf(dVar.K));
            hashMap.put("qq_page_num", String.valueOf((i3 / i16) + 1));
            hashMap.put("qq_gift_type", I(dVar));
            hashMap.putAll(K());
            if (dVar.E) {
                VideoReport.setElementParams(this.f311614i.get(Integer.valueOf(dVar.f264874d)), hashMap);
                VideoReport.reportEvent("clck", this.f311614i.get(Integer.valueOf(dVar.f264874d)), J());
            } else {
                VideoReport.setElementParams(this.f311613h.get(Integer.valueOf(dVar.f264874d)), hashMap);
                VideoReport.reportEvent("clck", this.f311613h.get(Integer.valueOf(dVar.f264874d)), J());
                VideoReport.reportEvent("imp", this.f311614i.get(Integer.valueOf(dVar.f264874d)), J());
            }
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void o(View view) {
        View view2 = this.f311611f;
        if (view2 == null) {
            return;
        }
        VideoReport.setLogicParent(view, view2);
        VideoReport.setElementId(view, "em_qq_gift_panel_package_go_get_gift");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("imp", view, J());
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void p(Object obj, int i3, int i16) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("qq_gift_combo_click", String.valueOf(i16));
            hashMap.put("qq_gift_combo_real", String.valueOf(i3));
            B(hashMap);
            hashMap.putAll(K());
            VideoReport.reportEvent("ev_qq_gift_combo", obj, hashMap);
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void q(final CustomTabLayoutCompat customTabLayoutCompat) {
        ThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGiftDtReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < customTabLayoutCompat.z(); i3++) {
                    try {
                        View childAt = customTabLayoutCompat.getChildAt(i3);
                        CustomTabLayoutCompat.f y16 = customTabLayoutCompat.y(i3);
                        if (y16 != null && y16.f() != null) {
                            VideoReport.setElementId(childAt, "em_qq_gift_panel_tab");
                            HashMap hashMap = new HashMap();
                            VasGiftDtReportHelper.this.E(hashMap, "qq_tab_name", y16.f().toString());
                            VasGiftDtReportHelper.this.B(hashMap);
                            Object e16 = y16.e();
                            if (e16 instanceof String) {
                                VideoReport.setElementReuseIdentifier(childAt, (String) e16);
                                hashMap.put("qq_tab_id", (String) e16);
                            }
                            VideoReport.setElementParams(childAt, hashMap);
                            VideoReport.reportEvent("imp", childAt, VasGiftDtReportHelper.this.J());
                        }
                    } catch (Exception e17) {
                        QLog.e("VasGiftDtReportHelper", 1, e17.toString());
                        return;
                    }
                }
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void r(d dVar, int i3, View view, View view2) {
        try {
            this.f311613h.put(Integer.valueOf(dVar.f264874d), view);
            this.f311614i.put(Integer.valueOf(dVar.f264874d), view2);
            if (!this.f311608c.contains(Integer.valueOf(dVar.f264874d))) {
                this.f311608c.add(Integer.valueOf(dVar.f264874d));
                F(dVar, i3, view, "em_qq_gift_panel_gift_item");
            }
            if (dVar.E) {
                if (!this.f311609d.contains(Integer.valueOf(dVar.f264874d))) {
                    this.f311609d.add(Integer.valueOf(dVar.f264874d));
                    F(dVar, i3, view2, "em_qq_gift_panel_gift_give");
                    return;
                }
                return;
            }
            this.f311609d.remove(Integer.valueOf(dVar.f264874d));
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void traversePage(View view) {
        try {
            VideoReport.traversePage(view);
        } catch (Exception e16) {
            QLog.e("VasGiftDtReportHelper", 1, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.vasgift.business.dt.a
    public void e(d dVar, View view) {
    }
}
