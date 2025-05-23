package com.tencent.mobileqq.guild.schedule.list;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.k;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildCalendarLayout;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.cr;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleListFragment extends QPublicBaseFragment {
    private View C;
    private View D;
    private boolean E;
    private uy1.j J;
    private com.tencent.mobileqq.guild.mainframe.a K;
    private View L;
    private View M;
    private View N;
    private View P;
    private View Q;
    private RecyclerViewWithHeaderFooter R;
    private GuildCalendarLayout S;
    private boolean T;
    private AppInterface U;
    private ny1.c V;
    private k W;
    private GuildScheduleCalendarHelper X;
    private boolean F = true;
    private boolean G = false;
    private boolean H = true;
    private boolean I = false;
    private final rr1.a Y = new a();
    private final oo1.a Z = new b();

    /* renamed from: a0, reason: collision with root package name */
    private final GPServiceObserver f233213a0 = new c();

    /* renamed from: b0, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.theme.d f233214b0 = new com.tencent.mobileqq.guild.theme.d() { // from class: my1.c
        @Override // com.tencent.mobileqq.guild.theme.d
        public final void onThemeChanged() {
            GuildScheduleListFragment.this.updateTheme();
        }
    };

    /* renamed from: c0, reason: collision with root package name */
    private final RectF f233215c0 = new RectF();

    /* renamed from: d0, reason: collision with root package name */
    private final int[] f233216d0 = new int[2];

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends rr1.a {
        a() {
        }

        @Override // rr1.a
        public boolean b(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
            }
            return GuildScheduleListFragment.this.di(motionEvent);
        }

        @Override // rr1.a
        public void c(rr1.i iVar) {
            if (iVar == null) {
                return;
            }
            int f16 = iVar.f();
            int a16 = iVar.a();
            int c16 = iVar.c();
            if (f16 == 3) {
                boolean z16 = true;
                if (c16 == 1) {
                    if (a16 == 2 || a16 == 3) {
                        GuildScheduleListFragment.this.ti();
                        if (!GuildScheduleListFragment.this.T) {
                            GuildScheduleListFragment.this.T = true;
                            return;
                        }
                        GuildScheduleListFragment guildScheduleListFragment = GuildScheduleListFragment.this;
                        if (a16 != 3) {
                            z16 = false;
                        }
                        guildScheduleListFragment.ri(z16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends oo1.a {
        b() {
        }

        @Override // oo1.a
        public void b(boolean z16, IGProChannelInfo iGProChannelInfo) {
            QLog.i("Guild.sch.ScheduleListFragment", 2, "onChannelDelete() isSuccess=" + z16 + ", channelInfo=" + iGProChannelInfo + ", " + iGProChannelInfo.getChannelUin() + " " + iGProChannelInfo.getChannelName());
            if (z16 && GuildScheduleListFragment.this.W != null && GuildScheduleListFragment.this.K != null && TextUtils.equals(GuildScheduleListFragment.this.W.w(), iGProChannelInfo.getChannelUin())) {
                GuildScheduleListFragment.this.Vh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            if (GuildScheduleListFragment.this.W != null && TextUtils.equals(str, GuildScheduleListFragment.this.W.z()) && TextUtils.equals(((IGPSService) GuildScheduleListFragment.this.U.getRuntimeService(IGPSService.class, "")).getSelfTinyId(), str2)) {
                GuildScheduleListFragment.this.qi(z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            QLog.i("Guild.sch.ScheduleListFragment", 2, "onChannelListUpdated() guildId=" + str);
            if (GuildScheduleListFragment.this.W != null && !TextUtils.isEmpty(GuildScheduleListFragment.this.W.w())) {
                IGProChannelInfo channelInfo = ((IGPSService) GuildScheduleListFragment.this.U.getRuntimeService(IGPSService.class, "")).getChannelInfo(GuildScheduleListFragment.this.W.w());
                QLog.i("Guild.sch.ScheduleListFragment", 2, "onChannelListUpdated() channelInfo=" + channelInfo);
                if (channelInfo == null) {
                    GuildScheduleListFragment.this.Vh();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            super.onChannelPermissionChanged(str, hashSet);
            k kVar = GuildScheduleListFragment.this.W;
            if (kVar != null && TextUtils.equals(kVar.z(), str) && hashSet != null && hashSet.contains(kVar.w())) {
                GuildScheduleListFragment guildScheduleListFragment = GuildScheduleListFragment.this;
                guildScheduleListFragment.qi(guildScheduleListFragment.W.F());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            super.onRemoveGuild(str);
            if (GuildScheduleListFragment.this.W != null && !TextUtils.isEmpty(GuildScheduleListFragment.this.W.z()) && GuildScheduleListFragment.this.W.E() && GuildScheduleListFragment.this.W.z().equals(str)) {
                GuildScheduleListFragment.this.Vh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements GuildScheduleCalendarHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f233220a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ oy1.c f233221b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ oy1.e f233222c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f233223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f233224e;

        d(ViewPager2 viewPager2, oy1.c cVar, oy1.e eVar, TextView textView, TextView textView2) {
            this.f233220a = viewPager2;
            this.f233221b = cVar;
            this.f233222c = eVar;
            this.f233223d = textView;
            this.f233224e = textView2;
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void a() {
            this.f233221b.n();
            this.f233222c.h();
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void b() {
            this.f233221b.k();
            this.f233222c.e();
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void c(int i3, int i16) {
            GuildScheduleListFragment.this.W.l0(i3, i16);
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void d() {
            this.f233221b.o();
            this.f233222c.i();
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void e() {
            this.f233221b.m();
            this.f233222c.g();
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper.a
        public void f(py1.a aVar, boolean z16) {
            boolean z17;
            GuildScheduleListFragment guildScheduleListFragment = GuildScheduleListFragment.this;
            if (this.f233220a.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            guildScheduleListFragment.wi(z17);
            GuildScheduleListFragment.this.S.E();
            this.f233221b.l(aVar);
            this.f233222c.f(aVar);
            GuildScheduleListFragment.this.ui(this.f233223d, this.f233224e, aVar);
            if (!z16 || GuildScheduleListFragment.this.ci(aVar)) {
                return;
            }
            GuildScheduleListFragment.this.W.c0(0);
            GuildScheduleListFragment.this.W.d0(2);
            GuildScheduleListFragment.this.W.j0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f233226d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f233227e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f233228f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f233229h;

        e(int i3, int i16, int i17, int i18) {
            this.f233226d = i3;
            this.f233227e = i16;
            this.f233228f = i17;
            this.f233229h = i18;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i3;
            int i16 = this.f233226d;
            rect.left = i16;
            rect.right = i16;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                rect.top = this.f233227e;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (childAdapterPosition == i3 - 1) {
                rect.bottom = this.f233228f;
            } else {
                rect.bottom = this.f233229h;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f233231d;

        f(LinearLayoutManager linearLayoutManager) {
            this.f233231d = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                int findFirstVisibleItemPosition = this.f233231d.findFirstVisibleItemPosition();
                GuildScheduleInfo w06 = GuildScheduleListFragment.this.V.w0(findFirstVisibleItemPosition);
                if (w06 != null) {
                    py1.a a16 = py1.a.a(w06.getDateMs());
                    if (!GuildScheduleListFragment.this.X.f233279v.equals(a16)) {
                        GuildScheduleListFragment.this.X.s(a16, false);
                    }
                    QLog.i("Guild.sch.ScheduleListFragment", 2, "onScrollStateChanged  " + findFirstVisibleItemPosition + " , " + new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH\u65f6mm\u5206ss\u79d2").format(new Date(a16.d())) + " ," + this.f233231d.getItemCount() + ", " + w06.getTitle());
                    return;
                }
                QLog.i("Guild.sch.ScheduleListFragment", 2, "onScrollStateChanged scheduleInfo is null " + findFirstVisibleItemPosition + " , " + findFirstVisibleItemPosition + " ," + this.f233231d.getItemCount());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            int findLastVisibleItemPosition = this.f233231d.findLastVisibleItemPosition();
            int findFirstVisibleItemPosition = this.f233231d.findFirstVisibleItemPosition();
            int itemCount = this.f233231d.getItemCount();
            if (!GuildScheduleListFragment.this.G && i16 > 0 && GuildScheduleListFragment.this.F && findLastVisibleItemPosition == itemCount - 1) {
                GuildScheduleListFragment.this.W.c0(1);
                GuildScheduleListFragment.this.W.d0(0);
                GuildScheduleListFragment.this.W.f0(false);
                GuildScheduleListFragment.this.G = true;
                QLog.i("Guild.sch.ScheduleListFragment", 2, "onScrolled down " + findLastVisibleItemPosition + "--" + itemCount);
                return;
            }
            if (!GuildScheduleListFragment.this.I && i16 < 0 && GuildScheduleListFragment.this.H && findFirstVisibleItemPosition == 0) {
                GuildScheduleListFragment.this.W.c0(2);
                GuildScheduleListFragment.this.W.d0(0);
                GuildScheduleListFragment.this.W.f0(false);
                GuildScheduleListFragment.this.I = true;
                QLog.i("Guild.sch.ScheduleListFragment", 2, "onScrolled up " + findFirstVisibleItemPosition + "--" + itemCount);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements com.tencent.mobileqq.guild.mainframe.a {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.a
        public GuildFacadeType a() {
            return GuildFacadeType.Standalone;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.a
        public QBaseActivity getActivity() {
            return (QBaseActivity) GuildScheduleListFragment.this.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements i {

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.mobileqq.guild.mainframe.e f233234a;

        public h(com.tencent.mobileqq.guild.mainframe.e eVar) {
            this.f233234a = eVar;
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public void a() {
            this.f233234a.getF227292a().guildCenterPanelInOrOut(0, true);
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public void b() {
            this.f233234a.getF227292a().guildCenterPanelInOrOut(2, true);
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public QBaseActivity getHostActivity() {
            return this.f233234a.getActivity();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface i {
        void a();

        void b();

        QBaseActivity getHostActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class j implements i {

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.mobileqq.guild.mainframe.a f233236a;

        public j(com.tencent.mobileqq.guild.mainframe.a aVar) {
            this.f233236a = aVar;
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public void a() {
            GuildClientParams guildClientParams = (GuildClientParams) GuildScheduleListFragment.this.getArguments().getParcelable("launch_params");
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelDetailFragment(ch.l(), this.f233236a.getActivity(), guildClientParams.G(), guildClientParams.u(), 0);
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public void b() {
            if (!GuildScheduleListFragment.this.onBackEvent()) {
                this.f233236a.getActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment.i
        public QBaseActivity getHostActivity() {
            return this.f233236a.getActivity();
        }
    }

    private void Ai(com.tencent.mobileqq.guild.mainframe.a aVar) {
        this.K = aVar;
    }

    private void Ci(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private void Di() {
        this.M = this.L.findViewById(R.id.w1a);
        this.S = (GuildCalendarLayout) this.L.findViewById(R.id.w19);
        TextView textView = (TextView) this.L.findViewById(R.id.wzu);
        TextView textView2 = (TextView) this.L.findViewById(R.id.wzt);
        int i3 = Calendar.getInstance().get(1);
        GuildScheduleCalendarHelper k3 = this.S.k();
        this.X = k3;
        k3.q(i3 - 10, i3 + 1);
        this.X.r(this.W.B());
        this.S.E();
        ViewPager2 viewPager2 = (ViewPager2) this.L.findViewById(R.id.wrg);
        this.X.p(new d(viewPager2, new oy1.c(viewPager2, this.S), new oy1.e((ViewPager2) this.L.findViewById(R.id.f165650x50), this.S), textView, textView2));
        ui(textView, textView2, this.X.f233279v);
        this.S.setOnToggleListener(new GuildCalendarLayout.c() { // from class: my1.e
            @Override // com.tencent.mobileqq.guild.schedule.list.widget.GuildCalendarLayout.c
            public final void a(boolean z16) {
                GuildScheduleListFragment.this.fi(z16);
            }
        });
    }

    private void Ei() {
        this.R = (RecyclerViewWithHeaderFooter) this.L.findViewById(R.id.w2y);
        Resources resources = getResources();
        int n3 = Utils.n(15.0f, resources);
        int n16 = Utils.n(13.0f, resources);
        int n17 = Utils.n(30.0f, resources);
        int n18 = Utils.n(21.0f, resources);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.R.setLayoutManager(linearLayoutManager);
        this.R.addItemDecoration(new e(n18, n3, n17, n16));
        this.R.addOnScrollListener(new f(linearLayoutManager));
        this.C = LayoutInflater.from(getContext()).inflate(R.layout.f7l, (ViewGroup) null);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f7l, (ViewGroup) null);
        this.D = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.zrq);
        TextView textView2 = (TextView) this.C.findViewById(R.id.zrq);
        textView.setText(R.string.f155221gx);
        textView2.setText(R.string.f155211gw);
        this.R.C(this.C);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        ny1.c cVar = new ny1.c(this.K, this.W);
        this.V = cVar;
        cVar.s0(this.W.C());
        uy1.j jVar = new uy1.j(this.V);
        this.J = jVar;
        this.R.addItemDecoration(jVar);
        this.R.setAdapter(this.V);
    }

    private void Fi() {
        View findViewById = this.L.findViewById(R.id.w38);
        this.P = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: my1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduleListFragment.this.hi(view);
            }
        });
        qi(this.W.F());
    }

    private void Gi() {
        new oy1.a(this.L.findViewById(R.id.x2f), oi(), this.W).k();
    }

    private void Ii() {
        if (this.Q == null) {
            View inflate = ((ViewStub) this.L.findViewById(R.id.w3b)).inflate();
            this.Q = inflate;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: my1.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduleListFragment.this.ji(view);
                }
            });
        }
        this.Q.setVisibility(0);
    }

    private void Th(HashMap<String, Object> hashMap) {
        GuildClientParams guildClientParams;
        Bundle arguments = getArguments();
        if (arguments != null && (guildClientParams = (GuildClientParams) arguments.getParcelable("launch_params")) != null && guildClientParams.F() != null) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams(guildClientParams.F(), hashMap);
        }
    }

    private void Uh() {
        if (!bx.e()) {
            Ii();
            bi(3000L);
            bx.r(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        com.tencent.mobileqq.guild.mainframe.a aVar = this.K;
        if (!(aVar instanceof com.tencent.mobileqq.guild.mainframe.e)) {
            if (!onBackEvent()) {
                this.K.getActivity().finish();
            }
        } else {
            GuildCenterPanelController Z0 = ((com.tencent.mobileqq.guild.mainframe.e) aVar).getF227292a().Z0();
            if (Z0 != null) {
                Z0.r();
            }
        }
    }

    private void bi(long j3) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: my1.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildScheduleListFragment.this.ei();
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean di(MotionEvent motionEvent) {
        View view = this.M;
        if (view == null || this.R == null) {
            return false;
        }
        view.getLocationOnScreen(this.f233216d0);
        RectF rectF = this.f233215c0;
        float f16 = this.f233216d0[0];
        rectF.left = f16;
        rectF.top = r2[1];
        rectF.right = f16 + this.M.getMeasuredWidth();
        RectF rectF2 = this.f233215c0;
        rectF2.bottom = rectF2.top + this.M.getMeasuredHeight() + this.R.getTranslationY();
        return this.f233215c0.contains(motionEvent.getRawX(), motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei() {
        View view = this.Q;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(boolean z16) {
        this.P.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        } else if (!o.a(view)) {
            this.P.setEnabled(false);
            this.W.u(new k.e() { // from class: com.tencent.mobileqq.guild.schedule.list.a
                @Override // com.tencent.mobileqq.guild.schedule.list.k.e
                public final void a(boolean z16) {
                    GuildScheduleListFragment.this.gi(z16);
                }
            }, ai());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ji(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        bi(0L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.setEnabled(false);
        view.setAlpha(0.5f);
        this.W.c0(0);
        this.W.d0(2);
        this.W.j0(this.X.f233279v);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static GuildScheduleListFragment ni(com.tencent.mobileqq.guild.mainframe.a aVar, GuildClientParams guildClientParams) {
        GuildScheduleListFragment guildScheduleListFragment = new GuildScheduleListFragment();
        Bundle bundle = new Bundle(GuildScheduleListFragment.class.getClassLoader());
        bundle.putParcelable("launch_params", guildClientParams);
        guildScheduleListFragment.setArguments(bundle);
        guildScheduleListFragment.setArguments(bundle);
        guildScheduleListFragment.Ai(aVar);
        GuildJumpDebugUtils.a("Guild.sch.ScheduleListFragment", "newInstance() params=", guildClientParams);
        return guildScheduleListFragment;
    }

    private i oi() {
        com.tencent.mobileqq.guild.mainframe.a aVar = this.K;
        if (aVar instanceof com.tencent.mobileqq.guild.mainframe.e) {
            return new h((com.tencent.mobileqq.guild.mainframe.e) aVar);
        }
        return new j(aVar);
    }

    private com.tencent.mobileqq.guild.mainframe.a pi() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z16) {
        this.E = z16;
        if (z16) {
            this.P.setVisibility(0);
            Uh();
        } else {
            this.P.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(boolean z16) {
        QLog.d("Guild.sch.ScheduleListFragment", 1, "onPageEnter isOpen:" + z16);
        ty1.a.g("gpro_quality#event#schedule_channel_list");
        k kVar = this.W;
        if (kVar != null) {
            kVar.f0(z16);
        }
    }

    private void si() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        GuildJumpDebugUtils.a("Guild.sch.ScheduleListFragment", "openScheduleDetailPageIfNeed arguments = ", arguments);
        GuildClientParams guildClientParams = (GuildClientParams) arguments.getParcelable("launch_params");
        GuildJumpDebugUtils.a("Guild.sch.ScheduleListFragment", "openScheduleDetailPageIfNeed launchParams = ", guildClientParams);
        Bundle F = guildClientParams.F();
        JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo = (JumpGuildParam.ChannelDetailPageJumpInfo) F.getParcelable(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO);
        if (channelDetailPageJumpInfo != null && !TextUtils.isEmpty(channelDetailPageJumpInfo.getDetailId())) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildClientParams.G(), guildClientParams.u());
            jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(channelDetailPageJumpInfo.getDetailId()));
            jumpGuildParam.getExtras().putAll(F);
            GuildJumpUtil.n(requireContext(), jumpGuildParam);
            return;
        }
        QLog.d("Guild.sch.ScheduleListFragment", 1, "openScheduleDetailPage detailPageJumpInfo is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        k kVar = this.W;
        if (kVar != null) {
            kVar.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(TextView textView, TextView textView2, py1.a aVar) {
        textView.setText(String.valueOf(aVar.f428062a));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ((aVar.f428063b + 1) + " \u6708"));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(26, true), 0, spannableStringBuilder.length() - 1, 34);
        textView2.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void updateTheme() {
        GuildCalendarLayout guildCalendarLayout = this.S;
        if (guildCalendarLayout != null) {
            guildCalendarLayout.F();
        }
        ny1.c cVar = this.V;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        this.J.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: vi, reason: merged with bridge method [inline-methods] */
    public void fi(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("sgrp_calendar_view_type", str);
        w.b(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.W.w(), hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.S, "em_sgrp_calendar_view", hashMap);
        VideoReport.reportEvent("clck", this.S, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("sgrp_calendar_view_type", str);
        w.b(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.W.w(), hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.S, "em_sgrp_calendar_date_number", hashMap);
        VideoReport.reportEvent("clck", this.S, hashMap);
    }

    private void xi(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void yi() {
        xi(this.P, "em_sgrp_create_event");
    }

    private void zi() {
        IGProChannelInfo x16 = this.W.x();
        if (x16 != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(String.valueOf(x16.getChannelUin()), hashMap);
            w.b(hashMap);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.L, x16, hashMap);
            Th(hashMap);
            GuildChannelReportManager.f231987a.b(getQBaseActivity(), this.L, GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST, "pg_sgrp_subchannel_calendar", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Bi(py1.a aVar, List<GuildScheduleInfo> list) {
        Ci(this.N, 8);
        boolean z16 = false;
        this.R.setVisibility(0);
        if (this.V != null) {
            if (this.W.D() == 1) {
                if (list.isEmpty()) {
                    this.F = false;
                    Ci(this.C, 0);
                }
                this.V.p0(aVar, list);
                this.G = false;
            } else if (this.W.D() == 2) {
                if (list.isEmpty()) {
                    this.H = false;
                    Ci(this.D, 0);
                    QQToast.makeText(getActivity(), 2, R.string.f155221gx, 0).show();
                } else {
                    this.V.q0(aVar, list);
                }
                this.I = false;
            } else {
                this.F = true;
                this.H = true;
                this.I = false;
                this.G = false;
                Ci(this.C, 8);
                if (list.size() == 0 && aVar.d() > Calendar.getInstance().getTimeInMillis()) {
                    GuildScheduleInfo y16 = new GuildScheduleInfo.a().K(1000L).D(aVar.d()).y();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(y16);
                    this.V.F0(aVar, arrayList);
                } else {
                    this.V.F0(aVar, list);
                }
            }
            GuildCalendarLayout guildCalendarLayout = this.S;
            if (this.V.getItemCount() > 0) {
                z16 = true;
            }
            guildCalendarLayout.setHasContent(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hi() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getString(R.string.f155151gq), "", getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: my1.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildScheduleListFragment.ii(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        ViewGroup rootView = createCustomDialog.getRootView();
        VideoReport.setPageId(rootView, "pg_sgrp_subchannel_calendar");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(rootView, this.W.x(), null);
        View findViewById = rootView.findViewById(R.id.dialogRightBtn);
        VideoReport.setElementId(findViewById, "em_sgrp_create_limit");
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(findViewById, EndExposurePolicy.REPORT_ALL);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ji() {
        if (this.N == null) {
            View inflate = ((ViewStub) this.L.findViewById(R.id.w7j)).inflate();
            this.N = inflate;
            inflate.findViewById(R.id.wvu).setOnClickListener(new View.OnClickListener() { // from class: my1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduleListFragment.this.ki(view);
                }
            });
        }
        Bi(this.X.f233279v, Collections.emptyList());
        Ci(this.N, 0);
        View findViewById = this.N.findViewById(R.id.wvu);
        findViewById.setEnabled(true);
        findViewById.setAlpha(1.0f);
        this.R.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ki(long j3, long j16, List<cr> list) {
        this.X.e(j3, j16, list);
    }

    public void Sh(py1.a aVar) {
        if (!this.X.A.containsKey(aVar) && this.E) {
            this.V.r0(new GuildScheduleInfo.a().K(1000L).D(aVar.d()).y());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wh(GuildScheduleInfo guildScheduleInfo) {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper;
        ny1.c cVar = this.V;
        if (cVar != null) {
            cVar.t0(guildScheduleInfo);
        }
        if (guildScheduleInfo != null && (guildScheduleCalendarHelper = this.X) != null) {
            guildScheduleCalendarHelper.A.remove(py1.a.a(guildScheduleInfo.getStartTimeMs()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Xh(long j3, py1.a aVar) {
        uy1.j jVar;
        if (this.V != null && isAdded()) {
            int u06 = this.V.u0(j3, aVar);
            int itemCount = this.V.getItemCount();
            if (u06 >= 0 && u06 < itemCount) {
                RecyclerView.LayoutManager layoutManager = this.R.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    if (u06 < 1) {
                        linearLayoutManager.scrollToPositionWithOffset(u06, 0);
                    } else if (this.V.w0(u06 - 1).getDateMs() == this.V.w0(u06).getDateMs() && (jVar = this.J) != null) {
                        try {
                            linearLayoutManager.scrollToPositionWithOffset(u06, jVar.a(this.R, u06).getHeight());
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            QLog.d("Guild.sch.ScheduleListFragment", 1, "[focusSchedule] catch a exception");
                            linearLayoutManager.scrollToPositionWithOffset(u06, 0);
                        }
                    } else {
                        linearLayoutManager.scrollToPositionWithOffset(u06, 0);
                    }
                    QLog.d("Guild.sch.ScheduleListFragment", 1, "cherish focusSchedule pos:" + u06 + "," + this.X.f233258a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public py1.b<Long> Yh(int i3, int i16) {
        return this.X.h(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<GuildScheduleInfo> Zh() {
        ny1.c cVar = this.V;
        if (cVar != null) {
            return cVar.x0();
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public py1.a ai() {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.X;
        if (guildScheduleCalendarHelper != null) {
            return guildScheduleCalendarHelper.f233279v;
        }
        return new py1.a();
    }

    public boolean ci(py1.a aVar) {
        boolean z16;
        if (aVar.d() >= new py1.a().d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.X.A.containsKey(aVar) || !this.E || !z16) {
            return false;
        }
        GuildScheduleInfo y16 = new GuildScheduleInfo.a().K(1000L).D(aVar.d()).y();
        this.V.r0(y16);
        Xh(y16.getScheduleId(), aVar);
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (di(motionEvent)) {
            this.L.dispatchTouchEvent(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void li(GuildScheduleInfo guildScheduleInfo) {
        ny1.c cVar = this.V;
        if (cVar != null) {
            cVar.A0(guildScheduleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mi(long j3, int i3) {
        ny1.c cVar = this.V;
        if (cVar != null) {
            cVar.B0(j3, i3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ty1.a.d("gpro_quality#event#schedule_channel_list");
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppInterface l3 = ch.l();
        this.U = l3;
        l3.addObserver(this.Z);
        ((IGPSService) this.U.getRuntimeService(IGPSService.class, "")).addObserver(this.f233213a0);
        k kVar = new k(this, this.U);
        this.W = kVar;
        kVar.Q();
        if (this.K == null) {
            ImmersiveUtils.adjustThemeStatusBar(requireActivity().getWindow());
            this.K = pi();
        }
        com.tencent.mobileqq.guild.mainframe.a aVar = this.K;
        if (aVar instanceof com.tencent.mobileqq.guild.mainframe.e) {
            ((com.tencent.mobileqq.guild.mainframe.e) aVar).getF227292a().N().addGestureListener(this.Y);
        }
        GuildThemeManager.g(this.f233214b0);
        GuildJumpDebugUtils.a("Guild.sch.ScheduleListFragment", "onCreate() intent = ", requireActivity().getIntent());
        si();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f7d, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.guild.mainframe.a aVar = this.K;
        if (aVar instanceof com.tencent.mobileqq.guild.mainframe.e) {
            ((com.tencent.mobileqq.guild.mainframe.e) aVar).getF227292a().N().removeGestureListener(this.Y);
        }
        this.U.removeObserver(this.Z);
        ((IGPSService) this.U.getRuntimeService(IGPSService.class, "")).deleteObserver(this.f233213a0);
        this.W.S();
        GuildThemeManager.j(this.f233214b0);
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        ty1.a.d("gpro_quality#event#schedule_channel_list");
        super.onDetach();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getHostActivity().getWindow());
        this.W.c0(0);
        ri(false);
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_LIST, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.L = view;
        Gi();
        Di();
        Ei();
        Fi();
        zi();
        yi();
        if (this.K.a() == GuildFacadeType.Standalone) {
            ti();
            ri(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ii(DialogInterface dialogInterface, int i3) {
    }
}
