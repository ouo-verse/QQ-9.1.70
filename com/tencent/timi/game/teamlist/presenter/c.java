package com.tencent.timi.game.teamlist.presenter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.teamlist.view.e;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends RecyclerView.Adapter {
    private int D;
    private int E;
    private b H;

    /* renamed from: m, reason: collision with root package name */
    private int f379822m = -1;
    private String C = "";
    private int F = -1;
    private List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> G = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(int i3);
    }

    private String i0(int i3, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo) {
        String str = "";
        for (int i16 = 0; i16 < premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lable_list.get().size(); i16++) {
            if (i16 == i3) {
                str = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lable_list.get().get(i3);
            }
        }
        return str;
    }

    private void j0(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        e eVar = (e) viewHolder;
        if (this.f379822m == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        eVar.q(z16);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        layoutParams.setMargins(0, ViewUtils.dpToPx(12.0f), 0, 0);
        if (i3 == 0) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (this.G.size() - 1 == i3) {
            layoutParams.setMargins(0, ViewUtils.dpToPx(12.0f), 0, ViewUtils.dpToPx(90.0f));
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
    }

    private int k0() {
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list;
        l.i("TeamListVerticalAdapter", "sourceID: " + this.F + " originID:" + this.C);
        if (this.F != 1 && (list = this.G) != null && list.size() != 0) {
            for (int i3 = 0; i3 < this.G.size(); i3++) {
                if (!TextUtils.isEmpty(this.C) && !this.G.get(i3).origin_id.get().equals(this.C)) {
                    l.i("TeamListVerticalAdapter", "divider pos: " + i3);
                    return i3;
                }
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.G.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == this.G.size()) {
            return 1;
        }
        return 0;
    }

    public void l0(List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list) {
        this.G = list;
        this.f379822m = k0();
        notifyDataSetChanged();
    }

    public void m0(b bVar) {
        this.H = bVar;
    }

    public void n0(String str, int i3, int i16) {
        this.C = str;
        this.D = i3;
        this.E = i16;
    }

    public void o0(int i3) {
        this.F = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof e) {
            j0(viewHolder, i3);
            PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo = this.G.get(i3);
            String str = "";
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            String str6 = str5;
            for (PremadesTeamServerOuterClass$YesGamePremadesTeamIcon premadesTeamServerOuterClass$YesGamePremadesTeamIcon : premadesTeamServerOuterClass$YesGamePremadesTeamInfo.icon_list.get()) {
                if ("l_bg".equals(premadesTeamServerOuterClass$YesGamePremadesTeamIcon.key.get())) {
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
            e eVar = (e) viewHolder;
            eVar.p(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode.get(), 287.0f, 108.0f, str2, str3, str, str4, str5);
            eVar.o(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.name.get(), i0(0, premadesTeamServerOuterClass$YesGamePremadesTeamInfo), i0(1, premadesTeamServerOuterClass$YesGamePremadesTeamInfo));
            eVar.l(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.user_list.get(), str, str6);
            eVar.m(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get());
            eVar.n(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.type.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.grade_list.get(), this.H);
            fn4.a.m(viewHolder.itemView, String.valueOf(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id.get()), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.name.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.grade_list.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.lane_type_list.get(), String.valueOf(premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode_name.get()), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.user_list.get(), premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.get());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hy_, viewGroup, false));
        }
        return new a(new View(viewGroup.getContext()));
    }
}
