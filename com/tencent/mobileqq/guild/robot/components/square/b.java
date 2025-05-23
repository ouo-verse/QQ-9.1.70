package com.tencent.mobileqq.guild.robot.components.square;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.base.widget.RobotLoadingView;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.robot.components.square.RobotListFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListFilter;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotListCallback;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b implements RobotInfoFragment.a, IGetGuildRobotListCallback, View.OnClickListener, RobotListFragment.a {
    private WeakReference<FragmentActivity> C;
    private o D;
    private m E;
    private RobotLoadingView F;
    private View G;
    private TextView H;
    private TextView I;
    private View J;
    private RobotListFragment K;
    private boolean L = false;
    private ArrayList<Long> M;
    private a N;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f232245d;

    /* renamed from: e, reason: collision with root package name */
    private GuildChannel f232246e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f232247f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f232248h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f232249i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f232250m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f232251d;

        /* renamed from: e, reason: collision with root package name */
        private int f232252e;

        /* renamed from: f, reason: collision with root package name */
        private int f232253f;

        public a(int i3, int i16, int i17) {
            this.f232251d = i3;
            this.f232252e = i16;
            this.f232253f = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i3 = this.f232251d;
            int i16 = childAdapterPosition % i3;
            int i17 = this.f232253f;
            rect.left = (i16 * i17) / i3;
            rect.right = i17 - (((i16 + 1) * i17) / i3);
            if (childAdapterPosition >= i3) {
                rect.top = this.f232252e;
            }
        }
    }

    public b(RobotListFragment robotListFragment, ViewGroup viewGroup, GuildChannel guildChannel, ArrayList<String> arrayList) {
        this.f232245d = viewGroup;
        this.f232246e = guildChannel;
        this.C = new WeakReference<>(robotListFragment.getActivity());
        this.K = robotListFragment;
        f(arrayList);
        e(viewGroup);
    }

    private int d() {
        return ((bi.d() - (QQGuildUIUtil.f(16.0f) * 2)) - (QQGuildUIUtil.f(60.0f) * 5)) / 4;
    }

    private void e(View view) {
        if (this.C.get() == null) {
            return;
        }
        QLog.i("GuildShowRobotListController", 1, "init");
        RobotLoadingView robotLoadingView = new RobotLoadingView(this.C.get());
        this.F = robotLoadingView;
        robotLoadingView.setLoadingBg(R.drawable.guild_robot_list_loading_bg);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.efg, (ViewGroup) null);
        this.G = inflate;
        this.f232249i = (RecyclerView) inflate.findViewById(R.id.f115676wo);
        this.f232250m = (RecyclerView) this.G.findViewById(R.id.f71683ot);
        this.f232247f = (TextView) this.G.findViewById(R.id.f2189029);
        this.f232248h = (TextView) this.G.findViewById(R.id.f113926ry);
        this.H = (TextView) this.G.findViewById(R.id.uuf);
        this.J = this.G.findViewById(R.id.www);
        this.I = (TextView) this.G.findViewById(R.id.uu8);
        this.f232249i.setLayoutManager(new GridLayoutManager(view.getContext(), 5));
        a aVar = new a(5, QQGuildUIUtil.f(24.0f), d());
        this.N = aVar;
        this.f232249i.addItemDecoration(aVar);
        this.f232250m.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.D = new o(this.C.get(), null, this.f232246e, this);
        this.E = new m(this.C.get(), null, this.f232246e, this);
        this.f232249i.setAdapter(this.D);
        this.f232250m.setAdapter(this.E);
        this.f232249i.setItemAnimator(null);
        this.f232250m.setItemAnimator(null);
        k(this.f232249i, "em_qqrobot_added_module");
        k(this.f232250m, "em_qqrobot_not_added_module");
        l();
    }

    private void f(ArrayList<String> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildShowRobotListController", 1, "uins = " + arrayList);
        }
        this.M = new ArrayList<>(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.M.add(Long.valueOf(it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i3, GProGetGuildRobotListRsp gProGetGuildRobotListRsp, String str) {
        if (i3 == 0 && gProGetGuildRobotListRsp != null) {
            i(gProGetGuildRobotListRsp);
        } else {
            h(i3, str);
        }
    }

    private void h(int i3, String str) {
        this.L = false;
        QLog.w("GuildShowRobotListController", 1, "Network error, errCode = " + i3 + " msg = " + str);
    }

    private void i(GProGetGuildRobotListRsp gProGetGuildRobotListRsp) {
        ArrayList<GProGuildRobotInfo> addedList = gProGetGuildRobotListRsp.getAddedList();
        ArrayList<GProGuildRobotInfo> recommendList = gProGetGuildRobotListRsp.getRecommendList();
        if (this.f232245d == null) {
            return;
        }
        QLog.i("GuildShowRobotListController", 1, "add robot = " + addedList.size() + ", hot recommend = " + recommendList.size());
        if (this.D.getItemCount() == 0 && this.E.getItemCount() == 0) {
            this.f232245d.removeView(this.G);
            this.f232245d.removeView(this.F);
            this.f232245d.addView(this.G);
        }
        this.L = false;
        if (addedList.size() > 0) {
            this.D.q0(addedList);
            this.f232249i.setVisibility(0);
            this.H.setVisibility(8);
        } else {
            this.f232249i.setVisibility(8);
            this.H.setVisibility(0);
        }
        if (recommendList.size() > 0) {
            this.E.t0(recommendList);
            this.f232250m.setVisibility(0);
            this.I.setVisibility(8);
        } else {
            this.f232250m.setVisibility(8);
            this.I.setVisibility(0);
        }
    }

    private void k(Object obj, String str) {
        VideoReport.setElementId(obj, str);
        VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(obj, EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
    public void b(boolean z16) {
        if (z16) {
            l();
        }
    }

    public void j() {
        this.f232245d = null;
        this.F = null;
        this.G = null;
    }

    public void l() {
        ViewGroup viewGroup;
        ac g16;
        if (!this.L && (viewGroup = this.f232245d) != null) {
            this.L = true;
            viewGroup.removeView(this.F);
            if (this.D.getItemCount() == 0 && this.E.getItemCount() == 0) {
                this.f232245d.removeView(this.G);
                this.f232245d.addView(this.F);
            }
            if (this.f232246e == null || (g16 = sx1.f.g()) == null) {
                return;
            }
            g16.getGuildRobotList(new GProGetGuildRobotListReq(this.f232246e.b(), 0, 100, new GProGetGuildRobotListFilter(false), this.f232246e.a(), sx1.f.d(), this.M), this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f763641g && this.C.get() != null) {
            this.C.get().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.robot.components.square.RobotListFragment.a
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.N.f232253f = d();
        this.f232249i.invalidateItemDecorations();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotListCallback
    public void onGetGuildRobotList(final int i3, final String str, final GProGetGuildRobotListRsp gProGetGuildRobotListRsp) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.square.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.g(i3, gProGetGuildRobotListRsp, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
    public void a() {
    }

    @Override // com.tencent.mobileqq.guild.robot.components.square.RobotListFragment.a
    public void onResume() {
    }
}
