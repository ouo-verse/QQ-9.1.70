package com.tencent.timi.game.teamlist.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.teamlist.presenter.c;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.widget.MediumBoldTextView;
import fm4.g;
import gh4.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends RecyclerView.ViewHolder {
    private View E;
    private RCImageView F;
    private TeamListGiftImageView G;
    private MediumBoldTextView H;
    private TextView I;
    private TeamListAvatarStorkRoundImageView J;
    private TeamListAvatarStorkRoundImageView K;
    private TeamListAvatarStorkRoundImageView L;
    private TeamListAvatarStorkRoundImageView M;
    private TeamListAvatarStorkRoundImageView N;
    private TeamListAvatarStorkRoundImageView P;
    private ArrayList<TeamListAvatarStorkRoundImageView> Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.b f379894d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f379895e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f379896f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f379897h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f379898i;

        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.teamlist.view.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C9983a implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {
            C9983a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
                l.b("TeamListItemViewHolder", "setJoinTeam onSuccess");
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                l.b("TeamListItemViewHolder", "setJoinTeam onError:" + i3 + " errorMessage:" + str);
            }
        }

        a(c.b bVar, long j3, int i3, int i16, List list) {
            this.f379894d = bVar;
            this.f379895e = j3;
            this.f379896f = i3;
            this.f379897h = i16;
            this.f379898i = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpandHallLaunchParam expandHallLaunchParam;
            long j3;
            EventCollector.getInstance().onViewClickedBefore(view);
            c.b bVar = this.f379894d;
            if (bVar != null) {
                bVar.a(d.this.getAdapterPosition());
            }
            YoloRoomOuterClass$YoloRoomInfo j06 = ((g) mm4.b.b(g.class)).j0(5);
            gh4.e I0 = ((f) mm4.b.b(f.class)).I0();
            fm4.c cVar = null;
            if (I0 != null) {
                expandHallLaunchParam = I0.O();
            } else {
                expandHallLaunchParam = null;
            }
            if (I0 != null) {
                cVar = I0.getMReporterHelper().i();
            }
            if (expandHallLaunchParam != null) {
                if (j06 != null) {
                    j3 = j06.room_id.get();
                } else {
                    j3 = 0;
                }
                com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
                dVar.f379329f = cVar;
                dVar.f379330g = j3;
                dVar.f379324a = this.f379895e;
                dVar.f379325b = com.tencent.timi.game.utils.b.h(expandHallLaunchParam.f376301d);
                dVar.f379326c = 1;
                dVar.f379328e = this.f379896f;
                dVar.f379327d = ((g) mm4.b.b(g.class)).h2(this.f379896f);
                dVar.f379331h = 0L;
                com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
                cVar2.f379322a = this.f379897h;
                cVar2.f379323b = this.f379898i;
                ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, vf4.a.b(), dVar, cVar2, new C9983a());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(@NonNull View view) {
        super(view);
        this.Q = new ArrayList<>();
        this.E = view;
        this.F = (RCImageView) view.findViewById(R.id.f930159f);
        this.G = (TeamListGiftImageView) view.findViewById(R.id.f931259q);
        this.H = (MediumBoldTextView) view.findViewById(R.id.f931759v);
        this.I = (TextView) view.findViewById(R.id.f931359r);
        this.J = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f930559j);
        this.K = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f930659k);
        this.L = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f930759l);
        this.M = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f930859m);
        this.N = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f930959n);
        this.P = (TeamListAvatarStorkRoundImageView) view.findViewById(R.id.f931059o);
        this.Q.add(this.J);
        this.Q.add(this.K);
        this.Q.add(this.L);
        this.Q.add(this.M);
        this.Q.add(this.N);
        this.Q.add(this.P);
    }

    public void l(List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list, String str, String str2) {
        Iterator<TeamListAvatarStorkRoundImageView> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        for (int i3 = 0; i3 < list.size() && i3 < this.Q.size(); i3++) {
            PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo = list.get(i3);
            TeamListAvatarStorkRoundImageView teamListAvatarStorkRoundImageView = this.Q.get(i3);
            teamListAvatarStorkRoundImageView.setVisibility(0);
            String str3 = null;
            if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.uid.get() != 0) {
                int i16 = premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.gender.get();
                if (i16 == 1) {
                    teamListAvatarStorkRoundImageView.setBlueBg();
                } else if (i16 == 2) {
                    teamListAvatarStorkRoundImageView.setPinkBg();
                } else {
                    teamListAvatarStorkRoundImageView.setNormal();
                }
                Drawable drawable = this.E.getContext().getResources().getDrawable(R.drawable.ovu);
                if (!TextUtils.isEmpty(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.avatar.get())) {
                    teamListAvatarStorkRoundImageView.setDrawable(gn4.c.b(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.avatar.get(), drawable, 26.0f, 26.0f));
                } else {
                    teamListAvatarStorkRoundImageView.setDrawable(drawable);
                }
                teamListAvatarStorkRoundImageView.setLaneStr(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.lane_type_desc.get());
                List<YesGameInfoOuterClass$YesGameRoleAchievement> list2 = premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.role_achievement.get();
                if (list2.size() > 0) {
                    str3 = list2.get(0).icon.get();
                }
                teamListAvatarStorkRoundImageView.setIconDrawable(str3);
            } else if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.status.get() == 0) {
                teamListAvatarStorkRoundImageView.setNormal();
                teamListAvatarStorkRoundImageView.setDrawable(gn4.c.a(str, 26.0f, 26.0f));
                teamListAvatarStorkRoundImageView.setIconDrawable(null);
                teamListAvatarStorkRoundImageView.setLaneStr(null);
            } else {
                teamListAvatarStorkRoundImageView.setNormal();
                teamListAvatarStorkRoundImageView.setDrawable(gn4.c.a(str2, 26.0f, 26.0f));
                teamListAvatarStorkRoundImageView.setIconDrawable(null);
                teamListAvatarStorkRoundImageView.setLaneStr(null);
            }
        }
    }

    public void m(YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig) {
        if (yoloRoomOuterClass$YoloGiftConfig != null && yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get() != 0 && yoloRoomOuterClass$YoloGiftConfig.gift_num.get() != 0) {
            this.G.setVisibility(0);
            this.G.setGiftInfo(yoloRoomOuterClass$YoloGiftConfig.gift_num.get(), yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get());
        } else {
            this.G.setVisibility(8);
        }
    }

    public void n(long j3, int i3, int i16, YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig, List<Integer> list, c.b bVar) {
        this.E.setOnClickListener(new a(bVar, j3, i3, i16, list));
    }

    public void o(String str, String str2) {
        this.H.setText(str);
        this.I.setText(str2);
    }

    public void p(int i3, float f16, float f17, String str, String str2, String str3, String str4, String str5) {
        Drawable drawable;
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(f16);
        this.E.setLayoutParams(layoutParams);
        if (i3 == 3) {
            drawable = this.E.getContext().getResources().getDrawable(R.drawable.o_t);
        } else {
            drawable = this.E.getContext().getResources().getDrawable(R.drawable.o_s);
        }
        this.F.setRadius(ViewUtils.dip2px(6.0f));
        this.F.setImageDrawable(gn4.c.b(str, drawable, f16, f17));
        Iterator<TeamListAvatarStorkRoundImageView> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().setDrawable(gn4.c.a(str3, 26.0f, 26.0f));
        }
        if (!TextUtils.isEmpty(str4)) {
            this.H.setTextColor(fh4.c.a(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            this.I.setTextColor(fh4.c.a(str5));
        }
    }
}
