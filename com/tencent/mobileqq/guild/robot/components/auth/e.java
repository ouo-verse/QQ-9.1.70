package com.tencent.mobileqq.guild.robot.components.auth;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.e;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends RecyclerView.Adapter<d> {
    private RobotAuthorizeAddInfo C;
    private List<com.tencent.mobileqq.guild.robot.components.auth.a> D;
    private int E;
    private final List<RobotAuthorizeAddInfo.Permission> F = new ArrayList();
    private final List<RobotAuthorizeAddInfo.Permission> G = new ArrayList();
    private final List<com.tencent.mobileqq.guild.robot.components.auth.a> H = new ArrayList();
    private final List<com.tencent.mobileqq.guild.robot.components.auth.a> I = new ArrayList();
    private final c J;

    /* renamed from: m, reason: collision with root package name */
    private final Context f232115m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Comparator<com.tencent.mobileqq.guild.robot.components.auth.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.guild.robot.components.auth.a aVar, com.tencent.mobileqq.guild.robot.components.auth.a aVar2) {
            return aVar2.a().getOrder() - aVar.a().getOrder();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements Comparator<com.tencent.mobileqq.guild.robot.components.auth.a> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.guild.robot.components.auth.a aVar, com.tencent.mobileqq.guild.robot.components.auth.a aVar2) {
            return aVar2.a().getOrder() - aVar.a().getOrder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private List<WeakReference<View>> f232118a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private Context f232119b;

        public c(Context context) {
            this.f232119b = context;
            for (int i3 = 0; i3 < 3; i3++) {
                this.f232118a.add(new WeakReference<>(LayoutInflater.from(context).inflate(R.layout.f168164f52, (ViewGroup) null)));
            }
        }

        public View a() {
            if (this.f232118a.size() <= 0) {
                return LayoutInflater.from(this.f232119b).inflate(R.layout.f168164f52, (ViewGroup) null);
            }
            View view = this.f232118a.remove(0).get();
            if (view == null) {
                return LayoutInflater.from(this.f232119b).inflate(R.layout.f168164f52, (ViewGroup) null);
            }
            return view;
        }

        public void b(View view) {
            this.f232118a.add(new WeakReference<>(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d extends RecyclerView.ViewHolder {
        private final TextView E;
        private final LinearLayout F;
        private final ImageView G;
        private final LinearLayout H;
        private boolean I;
        private c J;

        public d(@NonNull View view, c cVar) {
            super(view);
            this.I = false;
            this.E = (TextView) view.findViewById(R.id.f238507j);
            this.F = (LinearLayout) view.findViewById(R.id.f238207g);
            ImageView imageView = (ImageView) view.findViewById(R.id.f238407i);
            this.G = imageView;
            this.H = (LinearLayout) view.findViewById(R.id.f238307h);
            imageView.setRotation(0.0f);
            this.J = cVar;
        }

        private void o(View view, String str, HashMap<String, Object> hashMap) {
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
        public /* synthetic */ void p(com.tencent.mobileqq.guild.robot.components.auth.a aVar, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = !this.I;
            this.I = z16;
            aVar.d(z16);
            s(aVar);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void q(RobotAuthorizeAddInfo.Permission permission, CheckBox checkBox, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            permission.j(!permission.f());
            checkBox.setChecked(permission.f());
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(final com.tencent.mobileqq.guild.robot.components.auth.a aVar) {
            if (aVar == null) {
                return;
            }
            if (this.H.getChildCount() > 0) {
                for (int i3 = 0; i3 < this.H.getChildCount(); i3++) {
                    this.J.b(this.H.getChildAt(i3));
                }
                this.H.removeAllViews();
            }
            this.I = aVar.c();
            s(aVar);
            this.F.setOnClickListener(new View.OnClickListener() { // from class: ax1.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.d.this.p(aVar, view);
                }
            });
            if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeDefaultNight()) {
                this.E.setTextColor(Color.parseColor("#222222"));
            } else {
                this.E.setTextColor(Color.parseColor("#E8E9EA"));
            }
            this.E.setText(aVar.a().a());
        }

        private void s(com.tencent.mobileqq.guild.robot.components.auth.a aVar) {
            if (this.I) {
                this.H.setVisibility(0);
                for (final RobotAuthorizeAddInfo.Permission permission : aVar.b()) {
                    View a16 = this.J.a();
                    final CheckBox checkBox = (CheckBox) a16.findViewById(R.id.tpq);
                    TextView textView = (TextView) a16.findViewById(R.id.tpr);
                    LinearLayout linearLayout = (LinearLayout) a16.findViewById(R.id.f764841s);
                    checkBox.setChecked(permission.f());
                    textView.setText(permission.getTitle());
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ax1.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            e.d.q(RobotAuthorizeAddInfo.Permission.this, checkBox, view);
                        }
                    });
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a16.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(44.0f));
                    }
                    this.H.addView(a16, layoutParams);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("qq_robot_if_check", Boolean.valueOf(this.I));
                    hashMap.put("qq_robot_api_name", permission.getTitle());
                    hashMap.put("qq_robot_apigroup_name", permission.e());
                    o(this.itemView, "em_qqrobot_check_btn", hashMap);
                }
                this.G.setRotation(180.0f);
                return;
            }
            this.G.setRotation(0.0f);
            this.H.setVisibility(8);
            for (int i3 = 0; i3 < this.H.getChildCount(); i3++) {
                this.J.b(this.H.getChildAt(i3));
            }
            this.H.removeAllViews();
        }
    }

    public e(Context context) {
        this.f232115m = context;
        this.J = new c(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tencent.mobileqq.guild.robot.components.auth.a> list = this.D;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int i0() {
        return this.E;
    }

    public int j0() {
        List<RobotAuthorizeAddInfo.Permission> list;
        int i3 = 1;
        if (this.E == 1) {
            list = this.G;
        } else {
            list = this.F;
        }
        Iterator<RobotAuthorizeAddInfo.Permission> it = list.iterator();
        while (it.hasNext()) {
            i3 &= it.next().f() ? 1 : 0;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull d dVar, int i3) {
        dVar.r(this.D.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(this.f232115m).inflate(R.layout.f168165f53, viewGroup, false), this.J);
    }

    public void m0(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        if (robotAuthorizeAddInfo == null) {
            return;
        }
        this.C = robotAuthorizeAddInfo;
        List<RobotAuthorizeAddInfo.ClassInfo> b16 = robotAuthorizeAddInfo.b();
        this.C.g(1);
        for (RobotAuthorizeAddInfo.Permission permission : robotAuthorizeAddInfo.e()) {
            permission.j(true);
            if (!permission.g()) {
                this.F.add(permission);
            }
            this.G.add(permission);
        }
        for (RobotAuthorizeAddInfo.ClassInfo classInfo : b16) {
            ArrayList arrayList = new ArrayList();
            for (RobotAuthorizeAddInfo.Permission permission2 : this.G) {
                if (!TextUtils.isEmpty(permission2.e()) && permission2.e().equals(classInfo.a())) {
                    arrayList.add(permission2);
                }
            }
            if (arrayList.size() != 0) {
                this.H.add(new com.tencent.mobileqq.guild.robot.components.auth.a(classInfo, arrayList));
            }
        }
        for (RobotAuthorizeAddInfo.ClassInfo classInfo2 : b16) {
            ArrayList arrayList2 = new ArrayList();
            for (RobotAuthorizeAddInfo.Permission permission3 : this.F) {
                if (!TextUtils.isEmpty(permission3.e()) && permission3.e().equals(classInfo2.a())) {
                    arrayList2.add(permission3);
                }
            }
            if (arrayList2.size() != 0) {
                this.I.add(new com.tencent.mobileqq.guild.robot.components.auth.a(classInfo2, arrayList2));
            }
        }
        Collections.sort(this.I, new a());
        Collections.sort(this.H, new b());
        this.D = this.H;
    }

    public void n0(boolean z16) {
        List<com.tencent.mobileqq.guild.robot.components.auth.a> list;
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
        if (z16) {
            list = this.H;
        } else {
            list = this.I;
        }
        this.D = list;
        this.E = z16 ? 1 : 0;
        notifyDataSetChanged();
    }
}
