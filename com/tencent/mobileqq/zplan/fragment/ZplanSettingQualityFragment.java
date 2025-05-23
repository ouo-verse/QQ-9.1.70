package com.tencent.mobileqq.zplan.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.setting.QualitySelectorView;
import com.tencent.mobileqq.zplan.setting.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.RangeButtonView;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanSettingQualityFragment extends QIphoneTitleBarFragment {
    private AppInterface C;
    private QualitySelectorView D;
    private RangeButtonView E;
    private RangeButtonView F;
    private RangeButtonView G;
    private RangeButtonView H;
    private LinearLayout I;
    private boolean J = false;
    private List<com.tencent.mobileqq.zplan.setting.a> K = null;
    private int L = -1;
    private int M = -1;
    private QualitySelectorView.b N = new a();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements QualitySelectorView.b {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.setting.QualitySelectorView.b
        public void t0(View view, int i3, int i16) {
            if (ZplanSettingQualityFragment.this.D != null && ZplanSettingQualityFragment.this.D.g(i16) != null) {
                com.tencent.mobileqq.zplan.setting.a g16 = ZplanSettingQualityFragment.this.D.g(i16);
                ZplanSettingQualityFragment.this.J = true;
                ZplanSettingQualityFragment.this.Lh(g16.f335440a);
                int i17 = g16.f335440a;
                if (i17 != 4) {
                    ZplanSettingQualityFragment.this.L = i17;
                } else {
                    ZplanSettingQualityFragment zplanSettingQualityFragment = ZplanSettingQualityFragment.this;
                    com.tencent.mobileqq.zplan.setting.a zh5 = zplanSettingQualityFragment.zh(zplanSettingQualityFragment.L);
                    if (zh5 != null) {
                        g16.f335442c.a(zh5.f335442c);
                    } else {
                        a.C9199a c9199a = g16.f335442c;
                        c9199a.f335444a = 2;
                        c9199a.f335445b = 2;
                        c9199a.f335447d = 2;
                        c9199a.f335446c = 2;
                    }
                    ZplanSettingQualityFragment.this.Kh(g16);
                }
                if (ZplanSettingQualityFragment.this.M != -1 && ZplanSettingQualityFragment.this.M > g16.f335440a) {
                    QQToast.makeText(ZplanSettingQualityFragment.this.getContext(), 0, ZplanSettingQualityFragment.this.getString(R.string.xue), 0).show();
                }
            }
            ZplanSettingQualityFragment.this.Eh(view, i3);
        }
    }

    private String Ah(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!z16) {
            return str;
        }
        return str + getString(R.string.xub);
    }

    private void Bh(int i3, int i16) {
        if (this.E == null || this.F == null || this.G == null || this.H == null) {
            return;
        }
        com.tencent.mobileqq.zplan.setting.a zh5 = zh(i16);
        Hh(this.E, zh5 == null ? -1 : zh5.f335442c.f335444a);
        Hh(this.F, zh5 == null ? -1 : zh5.f335442c.f335445b);
        Hh(this.G, zh5 == null ? -1 : zh5.f335442c.f335447d);
        Hh(this.H, zh5 != null ? zh5.f335442c.f335446c : -1);
        com.tencent.mobileqq.zplan.setting.a b16 = com.tencent.mobileqq.zplan.setting.b.b(getContext());
        Kh(b16);
        QualitySelectorView qualitySelectorView = this.D;
        if (qualitySelectorView != null && qualitySelectorView.h(4) != null && i3 == 4 && b16 != null) {
            this.D.h(4).f335442c.a(b16.f335442c);
        }
        this.E.setOnChangerListener(new b(zh5));
        this.F.setOnChangerListener(new c(zh5));
        this.G.setOnChangerListener(new d(zh5));
        this.H.setOnChangerListener(new e(zh5));
    }

    private void Ch(int i3, int i16) {
        QualitySelectorView qualitySelectorView = this.D;
        if (qualitySelectorView == null) {
            return;
        }
        qualitySelectorView.j(0, i3 == 0, i16 == 0);
        this.D.j(1, i3 == 1 || i3 == -1, i16 == 1);
        this.D.j(2, i3 == 2, i16 == 2);
        this.D.j(3, i3 == 3, i16 == 3);
        this.D.j(4, i3 == 4, false);
        this.D.setItemOnClickListener(this.N);
        this.D.m();
    }

    private void Fh(boolean z16) {
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        if (zPlanServiceHelper.l0()) {
            String a16 = com.tencent.mobileqq.zplan.setting.b.a(getContext(), z16);
            if (TextUtils.isEmpty(a16)) {
                QLog.d("ZplanSettingQualityFragment", 1, "sendLuaMsg:null");
                return;
            }
            com.tencent.zplan.luabridge.a S = zPlanServiceHelper.S();
            if (S != null) {
                S.callLua("N2L_SetGraphicsQuality", a16, (a.b) null);
            }
            QLog.d("ZplanSettingQualityFragment", 4, "EngineReady Status sendLuaMsg:" + a16);
        }
    }

    private void Gh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_zplan_qq_setting_quality");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(com.tencent.mobileqq.zplan.setting.a aVar) {
        RangeButtonView rangeButtonView = this.E;
        if (rangeButtonView == null || this.F == null || this.G == null || this.H == null) {
            return;
        }
        if (aVar == null) {
            rangeButtonView.setThumbPosition(2);
            this.F.setThumbPosition(2);
            this.G.setThumbPosition(2);
            this.H.setThumbPosition(2);
            return;
        }
        rangeButtonView.setThumbPosition(aVar.f335442c.f335444a);
        this.F.setThumbPosition(aVar.f335442c.f335445b);
        this.G.setThumbPosition(aVar.f335442c.f335447d);
        this.H.setThumbPosition(aVar.f335442c.f335446c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(int i3) {
        LinearLayout linearLayout = this.I;
        if (linearLayout == null) {
            return;
        }
        if (i3 == 4) {
            Jh(linearLayout, true);
        } else {
            Jh(linearLayout, false);
        }
    }

    private void initData() {
        int c16 = com.tencent.mobileqq.zplan.setting.c.c(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -1);
        this.M = com.tencent.mobileqq.zplan.setting.c.c("key_quality_recommended_type", -1);
        this.K = com.tencent.mobileqq.zplan.setting.b.c(getContext());
        if (c16 != 4) {
            this.L = c16;
        }
        yh();
        Ch(c16, this.M);
        Lh(c16);
        Bh(c16, this.M);
    }

    private void initViews() {
        this.D = (QualitySelectorView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qf8);
        this.I = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qmf);
        this.E = (RangeButtonView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.paj);
        this.F = (RangeButtonView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qqp);
        this.G = (RangeButtonView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pre);
        this.H = (RangeButtonView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qkt);
        com.tencent.mobileqq.widget.o.m(this.I, 0, false);
    }

    private void yh() {
        if (QQTheme.isNowThemeIsNight()) {
            Ih(this.E, getResources().getColor(R.color.f158017al3));
            Ih(this.F, getResources().getColor(R.color.f158017al3));
            Ih(this.G, getResources().getColor(R.color.f158017al3));
            Ih(this.H, getResources().getColor(R.color.f158017al3));
            LinearLayout linearLayout = this.I;
            if (linearLayout != null) {
                linearLayout.setBackground(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.zplan.setting.a zh(int i3) {
        List<com.tencent.mobileqq.zplan.setting.a> list = this.K;
        if (list == null) {
            return null;
        }
        for (com.tencent.mobileqq.zplan.setting.a aVar : list) {
            if (i3 == aVar.f335440a) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (AppInterface) getQBaseActivity().getAppRuntime();
        setTitle(getString(R.string.xtz));
        initViews();
        initData();
        Gh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d2p;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("ZplanSettingQualityFragment", 1, "onDestroyView");
        QualitySelectorView qualitySelectorView = this.D;
        if (qualitySelectorView != null) {
            qualitySelectorView.k();
        }
        List<com.tencent.mobileqq.zplan.setting.a> list = this.K;
        if (list != null) {
            list.clear();
            this.K = null;
        }
        this.L = -1;
        Dh(this.E);
        Dh(this.G);
        Dh(this.H);
        Dh(this.F);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (!this.J || this.D == null) {
            return;
        }
        com.tencent.mobileqq.zplan.setting.b.f(getContext(), this.D.f());
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QLog.d("ZplanSettingQualityFragment", 1, "onBackEvent");
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.d("ZplanSettingQualityFragment", 2, DKHippyEvent.EVENT_STOP);
        super.onStop();
        if (this.J) {
            Fh(false);
            this.J = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements RangeButtonView.OnChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.setting.a f333573d;

        b(com.tencent.mobileqq.zplan.setting.a aVar) {
            this.f333573d = aVar;
        }

        @Override // com.tencent.widget.RangeButtonView.OnChangeListener
        public void onChange(int i3, int i16) {
            if (i3 == i16) {
                return;
            }
            if (ZplanSettingQualityFragment.this.D != null && ZplanSettingQualityFragment.this.D.h(4) != null) {
                ZplanSettingQualityFragment.this.J = true;
                ZplanSettingQualityFragment.this.D.h(4).f335442c.f335444a = i16;
            }
            com.tencent.mobileqq.zplan.setting.a aVar = this.f333573d;
            if (aVar == null || i16 <= aVar.f335442c.f335444a) {
                return;
            }
            QQToast.makeText(ZplanSettingQualityFragment.this.getContext(), 0, ZplanSettingQualityFragment.this.getString(R.string.xue), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements RangeButtonView.OnChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.setting.a f333575d;

        c(com.tencent.mobileqq.zplan.setting.a aVar) {
            this.f333575d = aVar;
        }

        @Override // com.tencent.widget.RangeButtonView.OnChangeListener
        public void onChange(int i3, int i16) {
            if (i3 == i16) {
                return;
            }
            if (ZplanSettingQualityFragment.this.D != null && ZplanSettingQualityFragment.this.D.h(4) != null) {
                ZplanSettingQualityFragment.this.J = true;
                ZplanSettingQualityFragment.this.D.h(4).f335442c.f335445b = i16;
            }
            com.tencent.mobileqq.zplan.setting.a aVar = this.f333575d;
            if (aVar == null || i16 <= aVar.f335442c.f335445b) {
                return;
            }
            QQToast.makeText(ZplanSettingQualityFragment.this.getContext(), 0, ZplanSettingQualityFragment.this.getString(R.string.xue), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements RangeButtonView.OnChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.setting.a f333577d;

        d(com.tencent.mobileqq.zplan.setting.a aVar) {
            this.f333577d = aVar;
        }

        @Override // com.tencent.widget.RangeButtonView.OnChangeListener
        public void onChange(int i3, int i16) {
            if (i3 == i16) {
                return;
            }
            if (ZplanSettingQualityFragment.this.D != null && ZplanSettingQualityFragment.this.D.h(4) != null) {
                ZplanSettingQualityFragment.this.J = true;
                ZplanSettingQualityFragment.this.D.h(4).f335442c.f335447d = i16;
            }
            com.tencent.mobileqq.zplan.setting.a aVar = this.f333577d;
            if (aVar == null || i16 <= aVar.f335442c.f335447d) {
                return;
            }
            QQToast.makeText(ZplanSettingQualityFragment.this.getContext(), 0, ZplanSettingQualityFragment.this.getString(R.string.xue), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class e implements RangeButtonView.OnChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.setting.a f333579d;

        e(com.tencent.mobileqq.zplan.setting.a aVar) {
            this.f333579d = aVar;
        }

        @Override // com.tencent.widget.RangeButtonView.OnChangeListener
        public void onChange(int i3, int i16) {
            if (i3 == i16) {
                return;
            }
            if (ZplanSettingQualityFragment.this.D != null && ZplanSettingQualityFragment.this.D.h(4) != null) {
                ZplanSettingQualityFragment.this.J = true;
                ZplanSettingQualityFragment.this.D.h(4).f335442c.f335446c = i16;
            }
            com.tencent.mobileqq.zplan.setting.a aVar = this.f333579d;
            if (aVar == null || i16 <= aVar.f335442c.f335446c) {
                return;
            }
            QQToast.makeText(ZplanSettingQualityFragment.this.getContext(), 0, ZplanSettingQualityFragment.this.getString(R.string.xue), 0).show();
        }
    }

    private void Dh(RangeButtonView rangeButtonView) {
        if (rangeButtonView != null) {
            rangeButtonView.setOnChangerListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(View view, int i3) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_setting_visual_quality", Integer.valueOf(i3));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        com.tencent.mobileqq.zplan.utils.y.f(view, "em_zplan_qq_setting_visual_quality", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    private void Ih(RangeButtonView rangeButtonView, int i3) {
        if (rangeButtonView == null) {
            return;
        }
        rangeButtonView.setTitleColor(i3);
        rangeButtonView.setBackground(null);
    }

    private void Hh(RangeButtonView rangeButtonView, int i3) {
        if (rangeButtonView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RangeButtonView.Title(Ah(getString(R.string.f169832xu4), i3 == 0), ViewUtils.dip2px(9.0f)));
        arrayList.add(new RangeButtonView.Title(Ah(getString(R.string.xu5), i3 == 1), ViewUtils.dip2px(9.0f)));
        arrayList.add(new RangeButtonView.Title(Ah(getString(R.string.f169831xu3), i3 == 2), ViewUtils.dip2px(9.0f)));
        arrayList.add(new RangeButtonView.Title(Ah(getString(R.string.f169830xu2), i3 == 3), ViewUtils.dip2px(9.0f)));
        arrayList.add(new RangeButtonView.Title(Ah(getString(R.string.f169829xu1), i3 == 4), ViewUtils.dip2px(9.0f)));
        rangeButtonView.setTitleData(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Ah(getString(R.string.f169832xu4), i3 == 0));
        arrayList2.add(Ah(getString(R.string.xu5), i3 == 1));
        arrayList2.add(Ah(getString(R.string.f169831xu3), i3 == 2));
        arrayList2.add(Ah(getString(R.string.f169830xu2), i3 == 3));
        arrayList2.add(Ah(getString(R.string.f169829xu1), i3 == 4));
        rangeButtonView.setContentDescList(arrayList2);
        rangeButtonView.setTitleUp2Line(false);
    }

    private void Jh(LinearLayout linearLayout, boolean z16) {
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(z16 ? 0 : 8);
    }
}
