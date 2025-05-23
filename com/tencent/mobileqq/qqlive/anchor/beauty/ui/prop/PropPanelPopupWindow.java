package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropHorizontalTitleBar;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.IconTextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class PropPanelPopupWindow extends com.tencent.mobileqq.qqlive.room.multichat.audience.a implements com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a, PropHorizontalTitleBar.d {
    static IPatchRedirector $redirector_;
    private final List<PropCategoryView> C;
    private c D;
    private PropHorizontalTitleBar E;
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.c F;
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a G;
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b H;
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.a I;
    private Handler J;
    private com.tencent.mobileqq.qqlive.room.multichat.utils.a K;
    private int L;
    private final IAegisLogApi M;
    private final PropHorizontalTitleBar.b N;

    /* renamed from: e, reason: collision with root package name */
    private Context f270478e;

    /* renamed from: f, reason: collision with root package name */
    private View f270479f;

    /* renamed from: h, reason: collision with root package name */
    private IconTextView f270480h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f270481i;

    /* renamed from: m, reason: collision with root package name */
    private int f270482m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropPanelPopupWindow.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            PropPanelPopupWindow.this.E.setCurrentPosition(i3);
            if (PropPanelPopupWindow.this.G != null) {
                PropPanelPopupWindow propPanelPopupWindow = PropPanelPopupWindow.this;
                propPanelPopupWindow.q(propPanelPopupWindow.G.f270503m);
            }
            PropPanelPopupWindow.this.D();
            PropCategoryView propCategoryView = (PropCategoryView) PropPanelPopupWindow.this.C.get(i3);
            if (propCategoryView != null) {
                propCategoryView.d();
            }
        }
    }

    /* loaded from: classes17.dex */
    class b implements PropHorizontalTitleBar.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropPanelPopupWindow.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropHorizontalTitleBar.b
        public void onItemSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                PropPanelPopupWindow.this.f270481i.setCurrentItem(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends PagerAdapter {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropPanelPopupWindow.this);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
            } else {
                viewGroup.removeView((View) PropPanelPopupWindow.this.C.get(i3));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return PropPanelPopupWindow.this.C.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
            }
            viewGroup.addView((View) PropPanelPopupWindow.this.C.get(i3));
            return PropPanelPopupWindow.this.C.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    public PropPanelPopupWindow(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f270482m = -1;
        this.C = new ArrayList();
        this.L = -1;
        this.M = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.N = new b();
        this.J = new Handler(Looper.getMainLooper());
        this.f270478e = activity;
        this.I = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.a();
        v();
        z(this.f270478e);
        w();
    }

    private void A(Context context, View view) {
        this.f270479f = view;
        PropHorizontalTitleBar propHorizontalTitleBar = (PropHorizontalTitleBar) view.findViewById(R.id.yve);
        this.E = propHorizontalTitleBar;
        propHorizontalTitleBar.setCallback(this.N);
        this.E.setResetCallback(this);
        this.f270481i = (ViewPager) this.f270479f.findViewById(R.id.f28720jp);
        c cVar = new c();
        this.D = cVar;
        this.f270481i.setAdapter(cVar);
        this.f270481i.addOnPageChangeListener(new a());
        x();
    }

    private boolean B() {
        if (this.f270482m == 0) {
            return true;
        }
        return false;
    }

    private boolean C() {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar = this.G;
        if (aVar != null && "video_zplan_filament_ar_live".equals(aVar.f270492b)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.G == null) {
            r(false);
        } else if (B()) {
            o();
        } else {
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q(!this.f270480h.isSelected());
        if (this.f270480h.isSelected()) {
            com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.b.a(this.G);
        } else {
            p();
        }
        G();
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar = this.G;
        if (aVar != null) {
            aVar.f270503m = this.f270480h.isSelected();
        }
        H(this.f270480h.isSelected(), this.G);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u();
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(this.f270478e, "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&sceneType=1&referer=1001");
        EventCollector.getInstance().onViewClicked(view);
    }

    private void G() {
        Iterator<PropCategoryView> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void I(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b bVar = this.H;
        if (bVar != null) {
            bVar.d2(aVar);
        }
    }

    private void K() {
        r(true);
        q(this.G.f270503m);
    }

    private void L(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        r(true);
        q(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.b.b(aVar));
    }

    private void M(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.e();
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.f(aVar, true);
    }

    private void N() {
        String str;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long p16 = cVar.p();
        long k3 = cVar.k(p16, 1);
        if (p16 > 0 && k3 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_anchor_id", k3 + "");
            hashMap.put("qqlive_room_id", p16 + "");
            if (C()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("qqlive_switch_status", str);
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_avatar", hashMap);
        }
    }

    private void P(int i3) {
        this.f270482m = i3;
        this.I.e("LOCAL_SELECTED_TAB_KEY", i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a b16 = com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.b();
        this.G = b16;
        if (b16 == null && this.C.size() > 1) {
            this.f270482m = 1;
        }
        int i3 = this.L;
        if (i3 != -1) {
            this.f270481i.setCurrentItem(i3);
            this.L = -1;
        } else {
            this.f270481i.setCurrentItem(this.f270482m);
        }
        D();
    }

    private void o() {
        if (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.b.e() != null) {
            r(true);
            q(true);
        } else {
            r(false);
        }
    }

    private void p() {
        if (B()) {
            r(false);
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.b.c(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16) {
        IconTextView iconTextView = this.f270480h;
        if (iconTextView != null) {
            iconTextView.setSelected(z16);
        }
    }

    private void r(boolean z16) {
        int i3;
        IconTextView iconTextView = this.f270480h;
        if (iconTextView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            iconTextView.setVisibility(i3);
        }
    }

    private int s() {
        int b16 = this.I.b("LOCAL_SELECTED_TAB_KEY", 0);
        this.f270482m = b16;
        return b16;
    }

    public static int t() {
        List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> a16 = com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.a();
        if (a16 != null) {
            int i3 = 0;
            for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : a16) {
                if (bVar != null && "\u865a\u62df\u5f62\u8c61".equals(bVar.f270508b)) {
                    return i3;
                }
                i3++;
            }
        }
        return 0;
    }

    private void v() {
        this.f270482m = s();
    }

    private void w() {
        y();
        this.F = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.c();
    }

    private void x() {
        this.f270480h = (IconTextView) this.f270479f.findViewById(R.id.yvc);
        r(false);
        this.f270480h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PropPanelPopupWindow.this.E(view);
            }
        });
    }

    private void y() {
        List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> a16 = com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.a();
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : a16) {
            PropCategoryView propCategoryView = new PropCategoryView(this.f270478e);
            propCategoryView.setTag(bVar.f270507a);
            propCategoryView.setData(bVar);
            propCategoryView.setPropItemClickListener(this);
            if ("\u865a\u62df\u5f62\u8c61".equals(bVar.f270508b)) {
                propCategoryView.setVirtualAnchorTextVisibility(true);
                propCategoryView.findViewById(R.id.f11991785).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PropPanelPopupWindow.this.F(view);
                    }
                });
            } else {
                propCategoryView.setVirtualAnchorTextVisibility(false);
            }
            this.C.add(propCategoryView);
        }
        this.D.notifyDataSetChanged();
        this.E.setData(a16);
    }

    private void z(Context context) {
        A(context, View.inflate(context, R.layout.hb9, null));
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f270479f = null;
        this.f270478e = null;
        this.H = null;
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.L = i3;
        }
    }

    public void Q(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.H = bVar;
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.K == null) {
            this.K = new com.tencent.mobileqq.qqlive.room.multichat.utils.a(this.f271659d, this.f270479f, c(400.0f), true);
        }
        this.K.b(null);
        this.J.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropPanelPopupWindow.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PropPanelPopupWindow.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PropPanelPopupWindow.this.n();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    public void S(List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : list) {
            PropCategoryView propCategoryView = new PropCategoryView(this.f270478e);
            propCategoryView.setTag(bVar.f270507a);
            propCategoryView.setData(bVar);
            propCategoryView.setPropItemClickListener(this);
            this.C.add(propCategoryView);
        }
        this.D.notifyDataSetChanged();
        this.E.setData(list);
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropHorizontalTitleBar.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.G = null;
        r(false);
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.e();
        I(null);
        G();
        this.F.L1();
        N();
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a
    public void b(PropItemView propItemView, com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) propItemView, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        this.G = aVar;
        aVar.g(true);
        P(this.f270481i.getCurrentItem());
        I(this.G);
        M(this.G);
        L(this.G);
        G();
        N();
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.room.multichat.utils.a aVar = this.K;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private void H(boolean z16, com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
    }
}
