package com.tencent.mobileqq.guild.robot.components.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o extends RecyclerView.Adapter<b> {
    private List<GProGuildRobotInfo> C;
    private GuildChannel D;
    private RobotInfoFragment.a E;

    /* renamed from: m, reason: collision with root package name */
    private FragmentActivity f232281m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f232282a;

        a(List list) {
            this.f232282a = list;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i3, int i16) {
            return ((GProGuildRobotInfo) o.this.C.get(i3)).getRobotName().equals(((GProGuildRobotInfo) this.f232282a.get(i16)).getRobotName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i3, int i16) {
            if (((GProGuildRobotInfo) o.this.C.get(i3)).getRobotTid() == ((GProGuildRobotInfo) this.f232282a.get(i16)).getRobotTid()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f232282a.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return o.this.C.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.ViewHolder {
        public ImageView E;
        public TextView F;
        public ViewGroup G;
        public TextView H;

        public b(@NonNull View view) {
            super(view);
            l(view);
        }

        private void l(View view) {
            this.E = (ImageView) view.findViewById(R.id.f767642j);
            this.F = (TextView) view.findViewById(R.id.f770843e);
            this.G = (ViewGroup) view.findViewById(R.id.f2188028);
            this.H = (TextView) view.findViewById(R.id.f767342g);
        }
    }

    public o(FragmentActivity fragmentActivity, List<GProGuildRobotInfo> list, GuildChannel guildChannel, RobotInfoFragment.a aVar) {
        this.f232281m = fragmentActivity;
        this.C = list;
        this.D = guildChannel;
        this.E = aVar;
        if (list == null) {
            this.C = new ArrayList();
        }
    }

    private void k0(@NonNull b bVar, GProGuildRobotInfo gProGuildRobotInfo) {
        if (gProGuildRobotInfo.getTags().size() > 0) {
            bVar.H.setVisibility(0);
            bVar.H.setText(gProGuildRobotInfo.getTags().get(0));
            bVar.H.setBackgroundResource(R.drawable.guild_robot_global_flag);
        } else if (gProGuildRobotInfo.getRobotTestStatus() == 1) {
            bVar.H.setVisibility(0);
            bVar.H.setText(R.string.f153871d_);
            bVar.H.setBackgroundResource(R.drawable.guild_robot_develop_flag);
        } else {
            if (gProGuildRobotInfo.getRobotTestStatus() == 2) {
                bVar.H.setVisibility(0);
                bVar.H.setText(R.string.f153881da);
                bVar.H.setBackgroundResource(R.drawable.guild_robot_review_flag);
                return;
            }
            bVar.H.setVisibility(8);
        }
    }

    private Map<String, Object> l0(GProGuildRobotInfo gProGuildRobotInfo, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", Long.valueOf(gProGuildRobotInfo.getRobotUin()));
        hashMap.put("qq_robot_robot_name", gProGuildRobotInfo.getRobotName());
        hashMap.put("qq_robot_robot_location", Integer.valueOf(i3));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m0(GProGuildRobotInfo gProGuildRobotInfo, b bVar, int i3, View view) {
        RobotInfoFragment.xh(this.f232281m, String.valueOf(this.D.a()), String.valueOf(this.D.b()), "", String.valueOf(gProGuildRobotInfo.getRobotUin()), "2", false, this.E, 13);
        VideoReport.reportEvent("ev_qqrobot_jump_information", bVar.G, l0(gProGuildRobotInfo, i3));
        return Unit.INSTANCE;
    }

    private void p0(b bVar, GProGuildRobotInfo gProGuildRobotInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            bVar.E.setImageDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getFaceDrawableByUser((AppInterface) peekAppRuntime, String.valueOf(gProGuildRobotInfo.getRobotUin())));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final b bVar, final int i3) {
        final GProGuildRobotInfo gProGuildRobotInfo = this.C.get(i3);
        p0(bVar, gProGuildRobotInfo);
        bVar.F.setText(gProGuildRobotInfo.getRobotName());
        jt1.b.b(bVar.G, new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.square.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m06;
                m06 = o.this.m0(gProGuildRobotInfo, bVar, i3, (View) obj);
                return m06;
            }
        });
        k0(bVar, gProGuildRobotInfo);
        VideoReport.setElementId(bVar.G, "em_qqrobot_added_robot");
        VideoReport.setElementReuseIdentifier(bVar.G, String.valueOf(gProGuildRobotInfo.getRobotUin()));
        VideoReport.setElementExposePolicy(bVar.G, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(bVar.G, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(bVar.G, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(bVar.G, l0(gProGuildRobotInfo, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f5l, (ViewGroup) null));
    }

    public void q0(List<GProGuildRobotInfo> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new a(list));
        this.C.clear();
        this.C.addAll(list);
        calculateDiff.dispatchUpdatesTo(this);
    }
}
