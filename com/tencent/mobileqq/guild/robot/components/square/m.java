package com.tencent.mobileqq.guild.robot.components.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.base.widget.RobotLabelLayout;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m extends RecyclerView.Adapter<b> {
    private List<GProGuildRobotInfo> C;
    private AppRuntime D = MobileQQ.sMobileQQ.peekAppRuntime();
    private GuildChannel E;
    private RobotInfoFragment.a F;

    /* renamed from: m, reason: collision with root package name */
    private FragmentActivity f232274m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f232275a;

        a(List list) {
            this.f232275a = list;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i3, int i16) {
            return ((GProGuildRobotInfo) m.this.C.get(i3)).getRobotName().equals(((GProGuildRobotInfo) this.f232275a.get(i16)).getRobotName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i3, int i16) {
            if (((GProGuildRobotInfo) m.this.C.get(i3)).getRobotTid() == ((GProGuildRobotInfo) this.f232275a.get(i16)).getRobotTid()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f232275a.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return m.this.C.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.ViewHolder {
        private RoundCornerLayout E;
        private ImageView F;
        private TextView G;
        private TextView H;
        private Button I;
        private RobotLabelLayout J;
        private View K;
        private ViewGroup L;

        public b(@NonNull View view) {
            super(view);
            r(view);
        }

        private void r(View view) {
            this.E = (RoundCornerLayout) view.findViewById(R.id.ifh);
            this.F = (ImageView) view.findViewById(R.id.wwx);
            this.G = (TextView) view.findViewById(R.id.f165607wx2);
            this.H = (TextView) view.findViewById(R.id.wwr);
            this.I = (Button) view.findViewById(R.id.vwo);
            this.J = (RobotLabelLayout) view.findViewById(R.id.wwy);
            this.K = view.findViewById(R.id.f768442r);
            this.L = (ViewGroup) view.findViewById(R.id.b8q);
        }
    }

    public m(FragmentActivity fragmentActivity, List<GProGuildRobotInfo> list, GuildChannel guildChannel, RobotInfoFragment.a aVar) {
        this.f232274m = fragmentActivity;
        this.C = list;
        this.E = guildChannel;
        this.F = aVar;
        if (this.C == null) {
            this.C = new ArrayList();
        }
    }

    private Map<String, Object> m0(GProGuildRobotInfo gProGuildRobotInfo, int i3, List<String> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", Long.valueOf(gProGuildRobotInfo.getRobotUin()));
        hashMap.put("qq_robot_robot_name", gProGuildRobotInfo.getRobotName());
        hashMap.put("qq_robot_robot_location", Integer.valueOf(i3));
        hashMap.put("qq_robot_service_introduct", Arrays.toString(list.toArray()));
        hashMap.put("qq_robot_function_introduct", gProGuildRobotInfo.getRobotDesc());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(int i3, String str) {
        if (i3 == 10032) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f153371bx, 1).show();
            return;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f154591f8, 0).show();
            }
        } else {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f154601f9, 0).show();
            RobotInfoFragment.a aVar = this.F;
            if (aVar != null) {
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(GProGuildRobotInfo gProGuildRobotInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.c("robot_add_btn")) {
            RobotInfo robotInfo = new RobotInfo();
            robotInfo.u(gProGuildRobotInfo.getRobotUin());
            robotInfo.s(gProGuildRobotInfo.getRobotName());
            RobotAuthorizeAddFragment.Jh(this.f232274m, this.D, this.E, robotInfo, null, new vw1.d() { // from class: com.tencent.mobileqq.guild.robot.components.square.l
                @Override // vw1.d
                public final void a(int i3, String str) {
                    m.this.n0(i3, str);
                }
            }, "\u673a\u5668\u4eba\u5217\u8868");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit p0(GProGuildRobotInfo gProGuildRobotInfo, b bVar, int i3, ArrayList arrayList, View view) {
        RobotInfoFragment.xh(this.f232274m, String.valueOf(this.E.a()), String.valueOf(this.E.b()), "", String.valueOf(gProGuildRobotInfo.getRobotUin()), "2", false, this.F, 13);
        VideoReport.reportEvent("ev_qqrobot_jump_information", bVar.L, m0(gProGuildRobotInfo, i3, arrayList));
        return Unit.INSTANCE;
    }

    private void s0(b bVar, GProGuildRobotInfo gProGuildRobotInfo) {
        AppRuntime appRuntime = this.D;
        if (appRuntime instanceof AppInterface) {
            bVar.F.setImageDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getFaceDrawableByUser((AppInterface) appRuntime, String.valueOf(gProGuildRobotInfo.getRobotUin())));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final b bVar, final int i3) {
        final GProGuildRobotInfo gProGuildRobotInfo = this.C.get(i3);
        s0(bVar, gProGuildRobotInfo);
        bVar.G.setText(gProGuildRobotInfo.getRobotName());
        bVar.H.setText(gProGuildRobotInfo.getRobotDesc());
        ArrayList<GProGuildRobotFeature> robotFeatures = gProGuildRobotInfo.getRobotFeatures();
        final ArrayList arrayList = new ArrayList(robotFeatures.size());
        Iterator<GProGuildRobotFeature> it = robotFeatures.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        bVar.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.robot.components.square.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.this.o0(gProGuildRobotInfo, view);
            }
        });
        jt1.b.b(bVar.L, new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.square.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p06;
                p06 = m.this.p0(gProGuildRobotInfo, bVar, i3, arrayList, (View) obj);
                return p06;
            }
        });
        bVar.J.setPadding(ViewUtils.dip2px(6.0f), ViewUtils.dip2px(6.0f), 0, 0);
        bVar.J.setLabelMargin(ViewUtils.dpToPx(6.0f));
        bVar.J.b(arrayList);
        VideoReport.setElementId(bVar.L, "em_qqrobot_not_added_robot");
        VideoReport.setElementReuseIdentifier(bVar.L, String.valueOf(gProGuildRobotInfo.getRobotUin()));
        ViewGroup viewGroup = bVar.L;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(viewGroup, exposurePolicy);
        ViewGroup viewGroup2 = bVar.L;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(viewGroup2, clickPolicy);
        VideoReport.setElementClickPolicy(bVar.L, clickPolicy);
        VideoReport.setElementClickPolicy(bVar.I, clickPolicy);
        ViewGroup viewGroup3 = bVar.L;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(viewGroup3, endExposurePolicy);
        VideoReport.setElementParams(bVar.L, m0(gProGuildRobotInfo, i3, arrayList));
        VideoReport.setElementId(bVar.I, "em_qqrobot_add_robot");
        VideoReport.setElementReuseIdentifier(bVar.I, String.valueOf(gProGuildRobotInfo.getRobotUin()));
        VideoReport.setElementExposePolicy(bVar.I, exposurePolicy);
        VideoReport.setElementClickPolicy(bVar.I, clickPolicy);
        VideoReport.setElementEndExposePolicy(bVar.I, endExposurePolicy);
        VideoReport.setElementParams(bVar.I, m0(gProGuildRobotInfo, i3, arrayList));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f5k, (ViewGroup) null, true);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dpToPx(92.0f)));
        return new b(inflate);
    }

    public void t0(List<GProGuildRobotInfo> list) {
        String valueOf;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new a(list));
        this.C.clear();
        this.C.addAll(list);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("date size = ");
        if (list == null) {
            valueOf = null;
        } else {
            valueOf = String.valueOf(list.size());
        }
        sb5.append(valueOf);
        QLog.i("RobotRecommendationAdapter", 1, sb5.toString());
        calculateDiff.dispatchUpdatesTo(this);
    }
}
