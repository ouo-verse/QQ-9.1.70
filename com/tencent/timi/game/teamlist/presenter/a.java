package com.tencent.timi.game.teamlist.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.teamlist.presenter.c;
import com.tencent.timi.game.teamlist.view.d;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends RecyclerView.Adapter {
    private int C;
    private View.OnClickListener D;
    private int F;
    private c.b G;

    /* renamed from: m, reason: collision with root package name */
    private List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> f379810m = new ArrayList();
    private boolean E = false;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.teamlist.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class ViewOnClickListenerC9981a implements View.OnClickListener {
        ViewOnClickListenerC9981a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            gn4.a.a();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }
    }

    private void i0(RecyclerView.ViewHolder viewHolder, int i3) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (i3 == 0) {
            layoutParams.setMargins(ViewUtils.dpToPx(16.0f), 0, 0, 0);
        } else if (getNUM_BACKGOURND_ICON() == this.C && i3 == this.f379810m.size() - 1) {
            layoutParams.setMargins(ViewUtils.dpToPx(12.0f), 0, ViewUtils.dpToPx(16.0f), 0);
        } else {
            layoutParams.setMargins(ViewUtils.dpToPx(12.0f), 0, 0, 0);
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
    }

    private void j0(RecyclerView.ViewHolder viewHolder, int i3) {
        PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo = this.f379810m.get(i3);
        String str = "";
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        for (PremadesTeamServerOuterClass$YesGamePremadesTeamIcon premadesTeamServerOuterClass$YesGamePremadesTeamIcon : premadesTeamServerOuterClass$YesGamePremadesTeamInfo.icon_list.get()) {
            if ("t_bg".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str2 = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            } else if ("tag_icon".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str3 = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            } else if ("add".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            } else if (JoinPoint.SYNCHRONIZATION_LOCK.equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str6 = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            } else if ("text_normal_hue".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str4 = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            } else if ("text_weak_hue".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
                str5 = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value.get();
            }
        }
        d dVar = (d) viewHolder;
        dVar.p(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode.get(), 210.0f, 99.0f, str2, str3, str, str4, str5);
        dVar.o(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.name.get(), k0(premadesTeamServerOuterClass$YesGamePremadesTeamInfo));
        dVar.l(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.user_list.get(), str, str6);
        dVar.m(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get());
        dVar.n(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.type.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.grade_list.get(), this.G);
        fn4.a.f(viewHolder.itemView, String.valueOf(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id.get()), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.name.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.grade_list.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lane_type_list.get(), String.valueOf(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode_name.get()), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.user_list.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get());
    }

    private String k0(PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lable_list.get().size(); i3++) {
            if (i3 == 0) {
                sb5.append(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lable_list.get().get(0));
            } else if (i3 == 1) {
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
                sb5.append(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lable_list.get().get(1));
            }
        }
        return sb5.toString();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.f379810m.size() == 1) {
            return this.f379810m.size() + 1;
        }
        if (this.f379810m.size() < 2) {
            this.E = false;
        }
        if (this.E) {
            return this.f379810m.size() + 1;
        }
        return this.f379810m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == this.f379810m.size()) {
            if (this.f379810m.size() != 1) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public boolean l0() {
        return this.E;
    }

    public void m0(List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list, int i3, boolean z16, int i16) {
        this.f379810m = list;
        this.C = i3;
        this.E = z16;
        this.F = i16;
        notifyDataSetChanged();
    }

    public void n0(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof d) {
            i0(viewHolder, i3);
            j0(viewHolder, i3);
            return;
        }
        if (viewHolder instanceof com.tencent.timi.game.teamlist.view.b) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.setMargins(ViewUtils.dpToPx(12.0f), 0, ViewUtils.dpToPx(16.0f), 0);
            viewHolder.itemView.setLayoutParams(layoutParams);
            viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC9981a());
            ((com.tencent.timi.game.teamlist.view.b) viewHolder).l(this.F);
            fn4.a.d(viewHolder.itemView);
            return;
        }
        if (viewHolder instanceof com.tencent.timi.game.teamlist.view.c) {
            viewHolder.itemView.setOnClickListener(this.D);
            fn4.a.g(viewHolder.itemView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hy7, viewGroup, false));
        }
        if (i3 == 1) {
            return new com.tencent.timi.game.teamlist.view.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hy6, viewGroup, false));
        }
        if (i3 == 2) {
            return new com.tencent.timi.game.teamlist.view.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hy5, viewGroup, false));
        }
        return new b(new View(viewGroup.getContext()));
    }
}
