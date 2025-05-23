package com.tencent.mobileqq.guild.robot.components.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.c;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RobotAuthorizeAddInfo C;
    private int D;
    private int E;
    private final List<RobotAuthorizeAddInfo.Permission> F = new ArrayList();
    private final List<RobotAuthorizeAddInfo.Permission> G = new ArrayList();
    private List<d> H = new ArrayList();
    private List<d> I = new ArrayList();
    private List<d> J;

    /* renamed from: m, reason: collision with root package name */
    private final Context f232108m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    protected class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    protected class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.robot.components.auth.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    protected class C7875c extends RecyclerView.ViewHolder {
        TextView E;

        public C7875c(@NonNull View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.f771243i);
            this.E = textView;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                this.E.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dpToPx(44.0f)));
            } else {
                layoutParams.width = -1;
                layoutParams.height = ViewUtils.dpToPx(44.0f);
            }
        }

        public void l(d dVar) {
            this.E.setText(dVar.f232112d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e extends RecyclerView.ViewHolder {
        TextView E;
        GuildSwitchButton F;
        LinearLayout G;
        View H;

        public e(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f771343j);
            this.F = (GuildSwitchButton) view.findViewById(R.id.f771643m);
            this.G = (LinearLayout) view.findViewById(R.id.f165608wx3);
            this.H = view.findViewById(R.id.wwv);
        }

        private void m(View view, String str, HashMap<String, Object> hashMap) {
            if (view == null) {
                return;
            }
            VideoReport.setElementId(view, str);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParams(view, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(d dVar, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.F.getVisibility() != 8) {
                this.F.setCheckedOnly(!dVar.f232111c.f());
                dVar.f232111c.j(!dVar.f232111c.f());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void o(final d dVar, int i3, int i16, boolean z16) {
            this.E.setText(dVar.f232111c.getTitle());
            if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeDefaultNight()) {
                this.E.setTextColor(Color.parseColor("#222222"));
            } else {
                this.E.setTextColor(Color.parseColor("#E8E9EA"));
            }
            ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
            if (layoutParams == null) {
                this.G.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dpToPx(56.0f)));
            } else {
                layoutParams.width = -1;
                layoutParams.height = ViewUtils.dpToPx(56.0f);
            }
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.robot.components.auth.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.e.this.n(dVar, view);
                }
            });
            this.F.setCheckedOnly(dVar.f232111c.f());
            this.F.setOnClickListener(null);
            int i17 = 0;
            this.F.setClickable(false);
            if (i3 != 2 && i16 == 1) {
                this.F.setVisibility(8);
            } else {
                this.F.setVisibility(0);
            }
            View view = this.H;
            if (z16) {
                i17 = 8;
            }
            view.setVisibility(i17);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("qq_robot_if_check", Boolean.valueOf(dVar.f232111c.f()));
            hashMap.put("qq_robot_api_name", dVar.f232111c.getTitle());
            hashMap.put("qq_robot_apigroup_name", dVar.f232111c.e());
            m(this.itemView, "qq_robot_apigroup_name", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f extends RecyclerView.ViewHolder {
        RelativeLayout E;
        RelativeLayout F;
        ImageView G;
        ImageView H;

        public f(@NonNull View view) {
            super(view);
            this.E = (RelativeLayout) view.findViewById(R.id.wwj);
            this.F = (RelativeLayout) view.findViewById(R.id.f165605wx0);
            this.G = (ImageView) view.findViewById(R.id.wwi);
            this.H = (ImageView) view.findViewById(R.id.wwz);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.n0(true);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.n0(false);
            EventCollector.getInstance().onViewClicked(view);
        }

        public void p(d dVar, int i3, int i16) {
            if (i3 == 2) {
                if (i16 == 1) {
                    this.G.setVisibility(0);
                    this.H.setVisibility(8);
                } else {
                    this.G.setVisibility(8);
                    this.H.setVisibility(0);
                }
                this.E.setOnClickListener(new View.OnClickListener() { // from class: ax1.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.f.this.n(view);
                    }
                });
                this.F.setOnClickListener(new View.OnClickListener() { // from class: ax1.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.f.this.o(view);
                    }
                });
                return;
            }
            this.E.setOnClickListener(null);
            this.F.setOnClickListener(null);
            if (i16 == 1) {
                this.G.setImageResource(R.drawable.guild_add_guild_option_icon_disable);
                this.G.setVisibility(0);
                this.H.setVisibility(8);
            } else {
                this.H.setImageResource(R.drawable.guild_add_guild_option_icon_disable);
                this.G.setVisibility(8);
                this.H.setVisibility(0);
            }
        }
    }

    public c(Context context, int i3) {
        this.f232108m = context;
        this.D = i3;
    }

    private void k0(int i3, RobotAuthorizeAddInfo robotAuthorizeAddInfo, List<d> list) {
        list.add(new d(0, HardCodeUtil.qqStr(R.string.f154191e5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void n0(boolean z16) {
        List<d> list;
        if (z16) {
            Iterator<RobotAuthorizeAddInfo.Permission> it = this.G.iterator();
            while (it.hasNext()) {
                it.next().j(true);
            }
        } else {
            Iterator<RobotAuthorizeAddInfo.Permission> it5 = this.F.iterator();
            while (it5.hasNext()) {
                it5.next().j(true);
            }
        }
        this.C.g(z16 ? 1 : 0);
        this.E = z16 ? 1 : 0;
        if (z16) {
            list = this.I;
        } else {
            list = this.H;
        }
        this.J = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<d> list = this.J;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<d> list = this.J;
        if (list != null) {
            return list.get(i3).f232109a;
        }
        return -1;
    }

    public void j0(RobotAuthorizeAddInfo robotAuthorizeAddInfo, int i3) {
        List<d> list;
        k0(i3, robotAuthorizeAddInfo, this.I);
        k0(i3, robotAuthorizeAddInfo, this.H);
        this.I.add(new d(2, ""));
        this.H.add(new d(2, ""));
        List<RobotAuthorizeAddInfo.ClassInfo> b16 = robotAuthorizeAddInfo.b();
        for (RobotAuthorizeAddInfo.Permission permission : robotAuthorizeAddInfo.e()) {
            if (!permission.g()) {
                this.F.add(permission);
            }
            this.G.add(permission);
        }
        for (RobotAuthorizeAddInfo.ClassInfo classInfo : b16) {
            if (this.I.size() != 0) {
                List<d> list2 = this.I;
                if (list2.get(list2.size() - 1).f232109a == 0) {
                    List<d> list3 = this.I;
                    list3.remove(list3.size() - 1);
                }
            }
            this.I.add(new d(0, classInfo, null));
            for (RobotAuthorizeAddInfo.Permission permission2 : this.G) {
                if (!TextUtils.isEmpty(permission2.e()) && permission2.e().equals(classInfo.a())) {
                    this.I.add(new d(1, classInfo, permission2));
                }
            }
        }
        for (RobotAuthorizeAddInfo.ClassInfo classInfo2 : b16) {
            if (this.H.size() != 0) {
                List<d> list4 = this.H;
                if (list4.get(list4.size() - 1).f232109a == 0) {
                    List<d> list5 = this.H;
                    list5.remove(list5.size() - 1);
                }
            }
            this.H.add(new d(0, classInfo2, null));
            for (RobotAuthorizeAddInfo.Permission permission3 : this.F) {
                if (!TextUtils.isEmpty(permission3.e()) && permission3.e().equals(classInfo2.a())) {
                    this.H.add(new d(1, classInfo2, permission3));
                }
            }
        }
        this.I.add(new d(3, ""));
        this.H.add(new d(3, ""));
        int f16 = robotAuthorizeAddInfo.f();
        this.E = f16;
        if (f16 == 1) {
            list = this.I;
        } else {
            list = this.H;
        }
        this.J = list;
    }

    public RobotAuthorizeAddInfo l0() {
        return this.C;
    }

    public void m0(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        if (robotAuthorizeAddInfo == null) {
            return;
        }
        this.C = robotAuthorizeAddInfo;
        this.G.clear();
        this.F.clear();
        this.H.clear();
        this.I.clear();
        j0(robotAuthorizeAddInfo, this.D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof C7875c) {
            ((C7875c) viewHolder).l(this.J.get(i3));
            return;
        }
        if (viewHolder instanceof f) {
            ((f) viewHolder).p(this.J.get(i3), this.D, this.E);
            return;
        }
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            boolean z16 = true;
            if (i3 != getNUM_BACKGOURND_ICON() - 1 && this.J.get(i3 + 1).f232109a == 1) {
                z16 = false;
            }
            eVar.o(this.J.get(i3), this.D, this.E, z16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(this.f232108m);
        if (i3 == 0) {
            return new C7875c(from.inflate(R.layout.f168170f62, (ViewGroup) null));
        }
        if (i3 == 2) {
            return new f(from.inflate(R.layout.f5z, (ViewGroup) null));
        }
        if (i3 == 1) {
            return new e(from.inflate(R.layout.f168171f63, (ViewGroup) null));
        }
        if (i3 == 3) {
            return new b(from.inflate(R.layout.f168169f61, (ViewGroup) null));
        }
        return new a(from.inflate(R.layout.f59, (ViewGroup) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f232109a;

        /* renamed from: b, reason: collision with root package name */
        private RobotAuthorizeAddInfo.ClassInfo f232110b;

        /* renamed from: c, reason: collision with root package name */
        private RobotAuthorizeAddInfo.Permission f232111c;

        /* renamed from: d, reason: collision with root package name */
        private String f232112d;

        public d(int i3, RobotAuthorizeAddInfo.ClassInfo classInfo, RobotAuthorizeAddInfo.Permission permission) {
            this.f232109a = i3;
            this.f232110b = classInfo;
            this.f232111c = permission;
            if (classInfo != null) {
                this.f232112d = classInfo.a();
            }
        }

        public d(int i3, String str) {
            this.f232109a = i3;
            this.f232112d = str;
        }
    }
}
