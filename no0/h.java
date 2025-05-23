package no0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.tencent.guild.aio.input.at.quickAt.dialogui.business.GuildAtDialogGestureLayout;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi;
import com.tencent.mobileqq.guild.widget.qqui.QQViewPager;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lo0.b;
import oo0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h extends com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a implements GuildDialogGestureLayout.a {
    private k K;
    private ro0.a L;
    private xe1.b M;
    private l N;
    private j P;
    private boolean Q;
    private List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> R;
    private ObjectAnimator S;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements c.d {
        a() {
        }

        @Override // oo0.c.d
        public void onPageSelected(int i3) {
            h hVar = h.this;
            boolean h16 = hVar.N.h().h();
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            hVar.C0(h16, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h hVar = h.this;
            hVar.N(hVar.L.i());
            h.this.n(false);
            animator.removeAllListeners();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final xe1.b f420563a;

        /* renamed from: b, reason: collision with root package name */
        private i f420564b;

        public d(xe1.b bVar) {
            this.f420563a = bVar;
            i iVar = new i();
            this.f420564b = iVar;
            b(bVar, iVar);
        }

        private void b(xe1.b bVar, i iVar) {
            if (bVar.i() == 1) {
                iVar.d(true).e(true).b(false);
            }
            iVar.f(false).c(true);
        }

        public h a() {
            h hVar = new h(this.f420563a, this.f420564b);
            hVar.z();
            return hVar;
        }
    }

    h(xe1.b bVar, i iVar) {
        super(bVar.c(), new GuildAtDialogGestureLayout(bVar.c()), iVar, new Object[]{bVar});
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(boolean z16, boolean z17) {
        Resources resources;
        int i3;
        TextView textView = (TextView) ((oo0.b) l(oo0.b.class)).c().findViewById(R.id.l__);
        if (textView != null) {
            int size = this.N.h().d().size();
            if (z16) {
                resources = this.f110977d.getResources();
                i3 = R.string.f145870sn;
            } else {
                resources = this.f110977d.getResources();
                i3 = R.string.f1505715c;
            }
            StringBuilder sb5 = new StringBuilder(resources.getString(i3));
            if (z16 && size > 0) {
                sb5.append('(');
                sb5.append(size);
                sb5.append(')');
            }
            textView.setText(sb5.toString());
            textView.setEnabled(!z17);
        }
    }

    private void d0() {
        if (this.G == 1) {
            this.f110980h.g(true);
            u(true);
            this.f110980h.g(false);
        }
    }

    private int e0() {
        return ((oo0.b) l(oo0.b.class)).d() + ((po0.h) l(po0.h.class)).d();
    }

    static int j0(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 5;
            if (i3 != 2) {
                if (i3 == 3) {
                    return 4;
                }
                if (i3 == 4) {
                    return 2;
                }
                if (i3 == 5) {
                    return 3;
                }
                return 0;
            }
        }
        return i16;
    }

    private vo0.b k0() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m0(MotionEvent motionEvent, int i3) {
        return so0.d.d(((po0.h) l(po0.h.class)).c(), motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        t0(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(View view, boolean z16) {
        if (!z16) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_search_box");
        VideoReport.reportEvent("dt_clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float p0(float f16) {
        return ((float) (Math.cos((f16 + 1.0f) * 3.141592653589793d) / 2.0d)) + 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(ValueAnimator valueAnimator) {
        N(this.L.i() * (1.0f - valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(WeakReference weakReference, ey eyVar) {
        View view;
        if (eyVar == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        VideoReport.setPageParams(view, "sgrp_surplus_num", Integer.valueOf(eyVar.getRemainingAtNotifyTimes()));
    }

    private void t0(TextView textView) {
        IGProGuildRoleInfo i3;
        if (textView == null) {
            return;
        }
        boolean h16 = this.N.h().h();
        if (h16) {
            this.Q = true;
            this.R = new ArrayList(this.N.h().d());
            n(true);
            zo0.a a16 = ap0.f.a();
            if (a16 != null) {
                a16.k();
            }
            VideoReport.setElementId(textView, "em_sgrp_complete_btn");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar : this.R) {
                arrayList.add(j0(aVar.a()) + "");
                if (aVar.a() == 5 && (aVar instanceof com.tencent.guild.aio.input.at.quickAt.selectmember.data.f) && (i3 = ((com.tencent.guild.aio.input.at.quickAt.selectmember.data.f) aVar).i()) != null) {
                    arrayList2.add(i3.getRoleId());
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_at_type", no0.a.a(",", arrayList));
            hashMap.put("sgrp_identity_group_id", no0.a.a(",", arrayList2));
            VideoReport.reportEvent("clck", textView, hashMap);
        } else {
            VideoReport.setElementId(textView, "em_sgrp_more_btn");
            VideoReport.reportEvent("clck", textView, null);
        }
        x0(!h16);
    }

    private void w0() {
        boolean z16;
        int j3 = this.M.j();
        String g16 = this.M.g();
        if (!TextUtils.isEmpty(g16)) {
            VideoReport.setPageId(this.F, "pg_sgrp_at_panel");
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_channel_id", this.M.d());
            hashMap.put("sgrp_sub_channel_id", this.M.a());
            if (j3 != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            hashMap.put("sgrp_user_type", Integer.valueOf(v.d(z16, j3)));
            if (!TextUtils.isEmpty(this.M.f())) {
                hashMap.put("sgrp_content_id", this.M.f());
                hashMap.put("sgrp_feed_id", this.M.f());
            }
            hashMap.put("sgrp_re_page_id", g16);
            final WeakReference weakReference = new WeakReference(this.F);
            new lo0.b(this.M.e(), this.M.d()).c(new b.a() { // from class: no0.g
                @Override // lo0.b.a
                public final void a(ey eyVar) {
                    h.r0(weakReference, eyVar);
                }
            });
            VideoReport.setPageParams(this.F, new PageParams(hashMap));
            return;
        }
        ((IRobotDaTongApi) QRoute.api(IRobotDaTongApi.class)).setAtPanelShowFunc(this.F, j3);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    protected oo0.a[] A(Context context) {
        po0.h hVar = new po0.h(context, this.K);
        hVar.f426590k = new View.OnFocusChangeListener() { // from class: no0.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                h.o0(view, z16);
            }
        };
        this.P.b(hVar.f426593n);
        oo0.c cVar = new oo0.c(context);
        cVar.t(this.N);
        return new oo0.a[]{new oo0.b(context, this.K), hVar, cVar};
    }

    public void A0(IGProUserInfo iGProUserInfo) {
        long parseLong;
        if (iGProUserInfo == null) {
            return;
        }
        if (iGProUserInfo instanceof AtUserWithRoleInfo) {
            AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
            int atType = atUserWithRoleInfo.getAtType();
            if (atType == 8) {
                AtRoleInfo atRole = atUserWithRoleInfo.getAtRole();
                if (atRole != null) {
                    parseLong = Long.parseLong(atRole.getRoleId()) << 1;
                } else {
                    parseLong = -1;
                }
            } else if (atType == 64) {
                parseLong = 1;
            } else {
                parseLong = 0;
            }
        } else {
            parseLong = Long.parseLong(iGProUserInfo.getTinyId());
        }
        this.N.h().l(parseLong, 1);
    }

    public void B0(ze1.c cVar, List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        y0(cVar);
        this.N.h().setMemberDataList(list);
        d0();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void H() {
        super.H();
        this.P.i();
        this.M = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void I() {
        super.I();
        ObjectAnimator objectAnimator = this.S;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.S.cancel();
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    protected void J() {
        float height = getHeight() - this.E.getTop();
        LinearLayout linearLayout = this.E;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", linearLayout.getTranslationY(), height);
        this.S = ofFloat;
        ofFloat.setDuration(this.f110978e.f429117g / 2).setInterpolator(new TimeInterpolator() { // from class: no0.c
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float p06;
                p06 = h.p0(f16);
                return p06;
            }
        });
        this.S.addListener(new b());
        this.S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: no0.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.q0(valueAnimator);
            }
        });
        this.S.start();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void Q(View view) {
        if (view == null) {
            QLog.e("GuildAtDialog2", 1, "showOn() called, anchor is null");
        } else {
            if (B()) {
                return;
            }
            if (this.f110978e instanceof i) {
                this.N.h().setEnableMultiSelectMode(((i) this.f110978e).f420568n);
            }
            super.Q(view);
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.a
    public boolean a(int i3) {
        return this.N.g(i3, ((oo0.c) l(oo0.c.class)).q());
    }

    public void f0() {
        VideoReport.reportPgIn(this.F);
    }

    public void g0() {
        VideoReport.reportPgOut(this.F);
    }

    public i h0() {
        return (i) this.f110978e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void i(qo0.e eVar) {
        super.i(eVar);
        this.F.setNestVerticalChild(this);
        this.F.setOnInterceptTouchListener(new GuildDialogGestureLayout.b() { // from class: no0.e
            @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.b
            public final boolean a(MotionEvent motionEvent, int i3) {
                boolean m06;
                m06 = h.this.m0(motionEvent, i3);
                return m06;
            }
        });
        this.F.setTargetView(((oo0.b) l(oo0.b.class)).c());
        final TextView textView = (TextView) ((oo0.b) l(oo0.b.class)).c().findViewById(R.id.l__);
        VideoReport.setElementId(textView, "em_sgrp_more_btn");
        VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_NONE);
        textView.setOnClickListener(new View.OnClickListener() { // from class: no0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.n0(textView, view);
            }
        });
        ((oo0.c) l(oo0.c.class)).n(new a());
        if (eVar instanceof i) {
            i iVar = (i) eVar;
            int i3 = 8;
            if (iVar.f420565k) {
                this.N.k(1);
                ((oo0.c) l(oo0.c.class)).u(8);
            } else {
                this.N.k(2);
            }
            View c16 = ((po0.h) l(po0.h.class)).c();
            if (iVar.f420566l) {
                i3 = 0;
            }
            c16.setVisibility(i3);
            setFocusable(iVar.f420567m);
        }
        this.D.setBackgroundColor(this.K.f420572b.f420585l);
        w0();
    }

    @NonNull
    public j i0() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void j(Object[] objArr) {
        this.M = (xe1.b) objArr[0];
        k kVar = new k();
        this.K = kVar;
        kVar.b(this.f110977d, this.M.l());
        this.N = new l(this.M, k0(), this.K);
        this.P = new j();
    }

    public boolean l0() {
        return this.N.h().h();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    protected ro0.c m(qo0.e eVar) {
        ro0.a aVar = new ro0.a(eVar, this.K);
        this.L = aVar;
        return aVar;
    }

    public void s0(int i3) {
        List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list = this.R;
        if (list == null) {
            list = this.N.h().d();
        }
        this.P.f(this.Q, i3, xo0.d.c(list));
        this.N.h().i();
        this.R = null;
        this.Q = false;
    }

    public void u0() {
        if (!QLog.isDevelopLevel()) {
            return;
        }
        int height = this.F.getHeight();
        int height2 = this.E.getHeight();
        int i3 = 0;
        boolean z16 = true;
        if (this.G != 1) {
            z16 = false;
        }
        int y16 = y(z16);
        int translationY = (int) this.E.getTranslationY();
        int d16 = ((oo0.b) l(oo0.b.class)).d();
        QQViewPager s16 = ((oo0.c) l(oo0.c.class)).s();
        if (s16 != null) {
            i3 = s16.getHeight();
        }
        QLog.d("GuildAtDialog2", 4, "panelViewHeight = " + height + " scrollViewHeight = " + height2 + " visualHeight = " + y16 + " translationY = " + translationY + " viewPagerHeight = " + i3 + " littleTongueHeight = " + d16);
    }

    public void v0() {
        this.N.h().setRecyclerViewSelection(0);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    protected int x() {
        return this.K.f420571a.f420605t;
    }

    public void x0(boolean z16) {
        this.N.h().setEnableMultiSelectMode(z16);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public int y(boolean z16) {
        int e06;
        if (z16) {
            oo0.c cVar = (oo0.c) l(oo0.c.class);
            QQViewPager s16 = cVar.s();
            int top = cVar.c().getTop();
            int i3 = 0;
            if (top > 0) {
                if (s16 != null) {
                    i3 = s16.getTop();
                }
                e06 = top + i3;
            } else {
                if (cVar.r() != 8) {
                    i3 = this.K.f420571a.f420600o;
                }
                e06 = i3 + e0();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildAtDialog2", 4, "viewPagerTop = " + e06 + "QQViewPagerComponentTop = " + (e06 - cVar.c().getTop()));
            }
            return this.L.h(getHeight(), e06, this.N.h().c());
        }
        return -1;
    }

    public void y0(ze1.c cVar) {
        this.N.h().setSearchContext(cVar);
    }

    public void z0(int i3) {
        QQViewPager s16 = ((oo0.c) l(oo0.c.class)).s();
        if (s16 != null) {
            s16.setCurrentItem(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements vo0.b {
        c() {
        }

        @Override // vo0.b
        public void c(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
            h.this.P.c(new ArraySet(xo0.d.c(list)));
            h hVar = h.this;
            hVar.C0(hVar.N.h().h(), true);
        }

        @Override // vo0.b
        public void e(boolean z16, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list, int i3) {
            int a16 = aVar.a();
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3) {
                        if (a16 != 4) {
                            if (a16 == 5) {
                                h.this.P.d(z16, h.this.M.d(), xo0.d.f(((com.tencent.guild.aio.input.at.quickAt.selectmember.data.f) aVar).i()), list.size(), i3);
                            }
                        } else {
                            h.this.P.d(z16, h.this.M.d(), xo0.d.e(), list.size(), i3);
                        }
                    } else {
                        h.this.P.d(z16, h.this.M.d(), ((com.tencent.guild.aio.input.at.quickAt.selectmember.data.d) aVar).i(), list.size(), i3);
                    }
                } else {
                    h.this.P.d(z16, h.this.M.d(), ((com.tencent.guild.aio.input.at.quickAt.selectmember.data.e) aVar).i(), list.size(), i3);
                }
            } else {
                h.this.P.d(z16, h.this.M.d(), xo0.d.d(), list.size(), i3);
            }
            h hVar = h.this;
            hVar.C0(hVar.N.h().h(), false);
        }

        @Override // vo0.b
        public void g(boolean z16) {
            h.this.P.e(z16);
            h.this.C0(z16, false);
        }

        @Override // vo0.b
        public void i() {
        }
    }
}
