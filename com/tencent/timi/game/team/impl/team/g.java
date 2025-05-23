package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamMemberInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonUserGameData;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;
import ul4.q;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends RecyclerView.Adapter<h> {
    private LayoutInflater C;
    private CommonOuterClass$QQUserId E;
    private YoloRoomOuterClass$YoloGameRouteInfo F;
    private long G;
    private YoloRoomOuterClass$YoloRoomInfo H;
    private int I;
    private YesGameInfoOuterClass$GameConfigInfo J;
    private boolean L;
    private TeamInfoEx M;

    /* renamed from: m, reason: collision with root package name */
    private Context f379760m;
    protected List<com.tencent.timi.game.team.impl.team.e> D = new ArrayList();
    private HashMap<Integer, MicWaveViewLottie> K = new HashMap<>();
    private List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> N = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379761d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomSpeakingPosInfo f379762e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f379763f;

        a(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, h hVar) {
            this.f379761d = i3;
            this.f379762e = yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
            this.f379763f = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a()) {
                g.this.o0(this.f379761d, this.f379762e, this.f379763f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379765d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f379766e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomSpeakingPosInfo f379767f;

        b(CommonOuterClass$QQUserId commonOuterClass$QQUserId, h hVar, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo) {
            this.f379765d = commonOuterClass$QQUserId;
            this.f379766e = hVar;
            this.f379767f = yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            g.this.n0(this.f379765d, this.f379766e, this.f379767f);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public g(Context context, long j3, List<com.tencent.timi.game.team.impl.team.e> list, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, TeamInfoEx teamInfoEx) {
        this.f379760m = context;
        this.C = LayoutInflater.from(context);
        this.L = z16;
        this.G = j3;
        this.F = yoloRoomOuterClass$YoloGameRouteInfo;
        this.E = commonOuterClass$QQUserId;
        this.D.clear();
        if (list != null && list.size() > 0) {
            this.D.addAll(list);
        }
        this.H = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomInfo();
        this.I = ((fm4.g) mm4.b.b(fm4.g.class)).t2(this.H);
        this.M = teamInfoEx;
        this.J = ((ag4.h) mm4.b.b(ag4.h.class)).l1(this.I);
    }

    private QBaseActivity l0() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        Context context = this.f379760m;
        if (context instanceof QBaseActivity) {
            return (QBaseActivity) context;
        }
        return null;
    }

    private String m0(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i3, boolean z16) {
        YoloRoomOuterClass$YoloCommonGameSchema yoloRoomOuterClass$YoloCommonGameSchema;
        YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema;
        SmobaDataOuterClass$YoloTeamInfo smobaDataOuterClass$YoloTeamInfo;
        boolean z17;
        boolean z18;
        boolean z19;
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo = this.F;
        SmobaDataOuterClass$YoloTeamMemberInfo smobaDataOuterClass$YoloTeamMemberInfo = null;
        if (yoloRoomOuterClass$YoloGameRouteInfo != null && yoloRoomOuterClass$YoloGameRouteInfo.common_game_route_info.has()) {
            yoloRoomOuterClass$YoloCommonGameSchema = this.F.common_game_route_info.get().common_game_schema.get();
        } else {
            yoloRoomOuterClass$YoloCommonGameSchema = null;
        }
        boolean z26 = false;
        if (yoloRoomOuterClass$YoloCommonGameSchema != null && yoloRoomOuterClass$YoloCommonGameSchema.schemas.size() > 0) {
            for (int i16 = 0; i16 < yoloRoomOuterClass$YoloCommonGameSchema.schemas.size(); i16++) {
                yoloRoomOuterClass$YoloCommonGameOneSchema = yoloRoomOuterClass$YoloCommonGameSchema.schemas.get(i16);
                if (ll4.b.a(yoloRoomOuterClass$YoloCommonGameOneSchema.user_id.get(), yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id)) {
                    break;
                }
            }
        }
        yoloRoomOuterClass$YoloCommonGameOneSchema = null;
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo2 = this.F;
        if (yoloRoomOuterClass$YoloGameRouteInfo2 != null && yoloRoomOuterClass$YoloGameRouteInfo2.smoba_game_route_info.has()) {
            smobaDataOuterClass$YoloTeamInfo = this.F.smoba_game_route_info.team_info.get();
        } else {
            smobaDataOuterClass$YoloTeamInfo = null;
        }
        if (smobaDataOuterClass$YoloTeamInfo != null && smobaDataOuterClass$YoloTeamInfo.memberlist.size() > 0) {
            Iterator<SmobaDataOuterClass$YoloTeamMemberInfo> it = smobaDataOuterClass$YoloTeamInfo.memberlist.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SmobaDataOuterClass$YoloTeamMemberInfo next = it.next();
                if (next.yes_uid.get() == yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get()) {
                    smobaDataOuterClass$YoloTeamMemberInfo = next;
                    break;
                }
            }
        }
        if (yoloRoomOuterClass$YoloCommonGameOneSchema != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && smobaDataOuterClass$YoloTeamMemberInfo != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.get().user_smoba_game_data.get().update_status.get() == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        String str = "";
        if (i3 == 3) {
            if (z18) {
                str = "\u6e38\u620f\u4e2d";
            }
            z26 = true;
        } else if (i3 == 2 && z18) {
            str = "\u6e38\u620f\n\u623f\u95f4\u4e2d";
        } else if (z19) {
            str = "\u66f4\u65b0\u4e2d\n" + yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.get().user_smoba_game_data.get().update_process.get() + "%";
        } else {
            if (z17) {
                str = "\u542f\u52a8\n\u6e38\u620f\u4e2d";
            }
            z26 = true;
        }
        if (z26 && z16) {
            return "\u79bb\u5f00";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(CommonOuterClass$QQUserId commonOuterClass$QQUserId, @NotNull h hVar, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo) {
        sl4.a h16;
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(this.H);
        L.put("yes_to_uid", String.valueOf(commonOuterClass$QQUserId.uid.get()));
        L.put("yes_to_yes_uid", nn4.a.a(commonOuterClass$QQUserId.yes_uid.get()));
        ((ug4.b) mm4.b.b(ug4.b.class)).c(hVar.E, true, "\u5ea7\u4f4d\u533a\u7528\u6237\u5934\u50cf\u6309\u94ae", "em_yes_seat_user_head", L);
        ((fm4.g) mm4.b.b(fm4.g.class)).A(this.G).p("playerlist avatar click");
        boolean a26 = ((sm4.a) mm4.b.b(sm4.a.class)).a2(this.G);
        if (l0() != null && (h16 = com.tencent.timi.game.team.impl.team.c.f379747a.h(l0(), commonOuterClass$QQUserId, a26, this.G)) != null && (h16 instanceof q)) {
            ((q) h16).w1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, h hVar) {
        boolean z16;
        int i16 = i3 + 1;
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((fm4.g) mm4.b.b(fm4.g.class)).A(this.G).g(true, i16, new c());
            ((ug4.b) mm4.b.b(ug4.b.class)).c(hVar.L, true, "\u5ea7\u4f4d\u533a\u5ea7\u4f4d\u9501\u5b9a\u6309\u94ae", "em_yes_seat_unlock", YoloRoomUtil.L(this.H));
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
            createCustomDialog.setMessage("\u786e\u8ba4\u5173\u95ed\u8be5\u5ea7\u4f4d\u5417\uff1f");
            createCustomDialog.setPositiveButton("\u786e\u8ba4", new d(i16));
            createCustomDialog.setNegativeButton("\u53d6\u6d88", new e());
            createCustomDialog.show();
        }
        ((ug4.b) mm4.b.b(ug4.b.class)).c(hVar.L, true, "\u5ea7\u4f4d\u533a\u5ea7\u4f4d\u9501\u5b9a\u6309\u94ae", "em_yes_seat_lock", YoloRoomUtil.L(this.H));
    }

    private void p0(@NotNull h hVar, int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, boolean z16) {
        hVar.N.setVisibility(8);
        hVar.P.setVisibility(8);
        hVar.N.setBackgroundDrawable(null);
        hVar.E.k();
        hVar.F.i();
        hVar.E.setVisibility(8);
        hVar.S.setVisibility(8);
        if (this.L) {
            hVar.I.g();
            hVar.I.setVisibility(8);
            hVar.J.setVisibility(8);
            this.K.remove(Integer.valueOf(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.pos.get()));
        }
        hVar.H.setVisibility(8);
        hVar.G.setVisibility(8);
        hVar.L.setVisibility(0);
        hVar.M.setVisibility(8);
        hVar.E.setOnClickListener(null);
        hVar.Q.j();
        hVar.R.setVisibility(8);
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.status.get() != 1 && yoloRoomOuterClass$YoloRoomSpeakingPosInfo.status.get() != 2) {
            com.tencent.timi.game.team.impl.b.f(hVar.L, this.J.team_room_info.icon_player_pos_empty.get(), R.drawable.o_x);
            hVar.M.setVisibility(8);
            if (z16) {
                hVar.K.setVisibility(0);
                hVar.K.setOnClickListener(null);
                hVar.K.setImageResource(R.drawable.o_y);
            }
        } else {
            com.tencent.timi.game.team.impl.b.f(hVar.L, this.J.team_room_info.icon_player_pos_empty_lock.get(), R.drawable.o_w);
            hVar.M.setVisibility(0);
            hVar.M.setText("\u5ea7\u4f4d\u5173\u95ed");
            hVar.L.setOnClickListener(null);
            if (z16) {
                hVar.K.setVisibility(0);
                hVar.K.setOnClickListener(null);
                hVar.K.setImageDrawable(null);
            }
        }
        if (z16) {
            a aVar = new a(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, hVar);
            hVar.L.setOnClickListener(aVar);
            hVar.K.setOnClickListener(aVar);
        } else {
            hVar.L.setOnClickListener(null);
            hVar.K.setOnClickListener(null);
        }
    }

    private void q0(@NotNull h hVar, int i3, com.tencent.timi.game.team.impl.team.e eVar, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, CommonOuterClass$QQUserId commonOuterClass$QQUserId2) {
        boolean z17;
        boolean z18;
        int i16;
        boolean z19;
        String str;
        YoloRoomOuterClass$YoloCommonUserGameData yoloRoomOuterClass$YoloCommonUserGameData;
        hVar.L.setVisibility(8);
        hVar.M.setVisibility(8);
        hVar.N.setVisibility(0);
        YoloRoomOuterClass$YoloCommonUserGameData yoloRoomOuterClass$YoloCommonUserGameData2 = null;
        if (!TextUtils.isEmpty(eVar.a())) {
            hVar.P.setVisibility(0);
            hVar.N.setImageDrawable(URLDrawable.getFileDrawable(eVar.a(), URLDrawable.URLDrawableOptions.obtain()));
        } else {
            hVar.P.setVisibility(8);
            hVar.N.setImageDrawable(null);
        }
        ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, commonOuterClass$QQUserId);
        ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, this.E);
        if (this.I == 101) {
            z17 = true;
        } else {
            z17 = false;
        }
        hVar.K.setVisibility(8);
        hVar.K.setOnClickListener(null);
        hVar.E.setVisibility(0);
        hVar.E.setUserId(commonOuterClass$QQUserId2);
        hVar.F.setUserId(commonOuterClass$QQUserId2);
        if (!this.N.isEmpty()) {
            List<YesGameInfoOuterClass$YesGameRoleAchievement> list = this.N.get(i3).role_achievement.get();
            if (!list.isEmpty()) {
                hVar.S.setImageDrawable(((ei4.a) mm4.b.b(ei4.a.class)).m(list.get(0).icon.get(), URLDrawable.URLDrawableOptions.obtain()));
                hVar.S.setVisibility(0);
            } else {
                hVar.S.setVisibility(8);
            }
        }
        if (z17) {
            hVar.R.setVisibility(8);
            hVar.Q.setVisibility(0);
            hVar.Q.setState(commonOuterClass$QQUserId2, yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.user_smoba_game_data.hero_lane_type.get());
        } else {
            hVar.Q.j();
            hVar.R.setVisibility(0);
            hVar.R.setText(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.user_common_game_data.game_role_info.grade_level_short_name.get());
        }
        r0(hVar, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, commonOuterClass$QQUserId2);
        hVar.E.setOnClickListener(new b(commonOuterClass$QQUserId2, hVar, yoloRoomOuterClass$YoloRoomSpeakingPosInfo));
        YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data;
        if (yoloRoomOuterClass$YoloUserGameData != null && (yoloRoomOuterClass$YoloCommonUserGameData = yoloRoomOuterClass$YoloUserGameData.user_common_game_data) != null && yoloRoomOuterClass$YoloCommonUserGameData.has()) {
            yoloRoomOuterClass$YoloCommonUserGameData2 = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_game_data.user_common_game_data;
        }
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.leave_status.get() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo = this.F;
        if (yoloRoomOuterClass$YoloGameRouteInfo != null) {
            i16 = yoloRoomOuterClass$YoloGameRouteInfo.game_status.get();
        } else {
            i16 = 0;
        }
        if (i16 == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (yoloRoomOuterClass$YoloCommonUserGameData2 != null) {
            str = yoloRoomOuterClass$YoloCommonUserGameData2.game_status_desc.get();
        } else {
            str = "";
        }
        if (yoloRoomOuterClass$YoloCommonUserGameData2 != null && yoloRoomOuterClass$YoloCommonUserGameData2.update_status.get() == 1) {
            str = "\u66f4\u65b0\u4e2d\n" + yoloRoomOuterClass$YoloCommonUserGameData2.update_process.get() + "%";
        } else if (z19 && z18 && TextUtils.isEmpty(str)) {
            str = "\u79bb\u5f00";
        }
        if (z17) {
            str = m0(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16, z18);
        }
        hVar.G.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            hVar.H.setVisibility(0);
            hVar.H.setText(str);
        } else {
            hVar.H.setVisibility(8);
        }
    }

    private void r0(@NotNull h hVar, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        boolean z16;
        int i3 = 8;
        if (this.L) {
            hVar.I.setVisibility(0);
            hVar.I.n(((sm4.a) mm4.b.b(sm4.a.class)).x0(commonOuterClass$QQUserId, this.G), "\u961f\u957f");
            AvatarSpeakingMicImageView avatarSpeakingMicImageView = hVar.I;
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.voice_switch.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            avatarSpeakingMicImageView.setData(commonOuterClass$QQUserId, z16);
            hVar.J.setVisibility(0);
            hVar.J.setUserId(commonOuterClass$QQUserId);
            MicWaveViewLottie micWaveViewLottie = hVar.J;
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.voice_switch.get() == 1) {
                i3 = 0;
            }
            micWaveViewLottie.setVisibility(i3);
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get() != 0) {
                hVar.J.setTag(R.id.f93435_k, ((ll4.a) mm4.b.b(ll4.a.class)).o(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get()));
            }
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.uid.get() > 0) {
                hVar.J.setTag(R.id.f93425_j, ((ll4.a) mm4.b.b(ll4.a.class)).o(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.uid.get()));
            }
            this.K.put(Integer.valueOf(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.pos.get()), hVar.J);
            hVar.E.setNeedDrawSex(false);
            return;
        }
        hVar.I.setVisibility(8);
        hVar.J.setVisibility(8);
        hVar.E.setNeedDrawSex(true);
    }

    private void s0(StringBuilder sb5, Map.Entry<String, Integer> entry) {
        MicWaveViewLottie micWaveViewLottie;
        String key = entry.getKey();
        if (!TextUtils.isEmpty(key)) {
            for (Map.Entry<Integer, MicWaveViewLottie> entry2 : this.K.entrySet()) {
                if (entry2.getValue() != null) {
                    Object tag = entry2.getValue().getTag(R.id.f93435_k);
                    Object tag2 = entry2.getValue().getTag(R.id.f93425_j);
                    if (((tag instanceof String) && key.equals(tag)) || ((tag2 instanceof String) && !TextUtils.isEmpty((String) tag2) && key.equals(tag2))) {
                        micWaveViewLottie = entry2.getValue();
                        break;
                    }
                }
            }
            micWaveViewLottie = null;
            if (micWaveViewLottie != null) {
                micWaveViewLottie.j();
                return;
            }
            return;
        }
        sb5.append("uid not valid");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.D.size();
    }

    public void t0(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        boolean z16;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            StringBuilder sb5 = new StringBuilder("onAudioMemberMicLevelChanged - ");
            for (Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
                if (entry.getValue().intValue() > 10) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(entry.getKey() + "_" + entry.getValue() + "_" + z16 + " --- ");
                if (z16) {
                    try {
                        s0(sb5, entry);
                    } catch (Exception unused) {
                        sb5.append("parseLong exception");
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull h hVar, int i3) {
        com.tencent.timi.game.team.impl.team.e eVar = this.D.get(i3);
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo b16 = eVar.b();
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        boolean a16 = ll4.b.a(E, this.E);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = b16.user_id;
        com.tencent.timi.game.team.impl.b.c(hVar.F, this.J.team_room_info.color_player_pos_name.get(), -16777216);
        com.tencent.timi.game.team.impl.b.c(hVar.M, this.J.team_room_info.color_player_pos_subdesc.get(), Color.parseColor("#999999"));
        com.tencent.timi.game.team.impl.b.c(hVar.R, this.J.team_room_info.color_player_pos_subdesc.get(), Color.parseColor("#999999"));
        if (b16.user_id.yes_uid.get() != 0) {
            q0(hVar, i3, eVar, b16, E, a16, commonOuterClass$QQUserId);
        } else {
            p0(hVar, i3, b16, a16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new h(this.C.inflate(R.layout.f169131hx1, viewGroup, false), this.G);
    }

    public void w0(List<com.tencent.timi.game.team.impl.team.e> list, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo) {
        this.D.clear();
        if (list != null && list.size() > 0) {
            this.D.addAll(list);
        }
        this.F = yoloRoomOuterClass$YoloGameRouteInfo;
        notifyDataSetChanged();
    }

    public void x0(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (!ll4.b.a(commonOuterClass$QQUserId, this.E)) {
            this.E = commonOuterClass$QQUserId;
            notifyDataSetChanged();
        }
    }

    public void y0(TeamInfoEx teamInfoEx) {
        l.h("TeamPlayerAdapter", 1, "updateData teamInfoEx:" + teamInfoEx);
        this.M = teamInfoEx;
    }

    public void z0(List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list) {
        this.N.clear();
        this.N.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379770d;

        d(int i3) {
            this.f379770d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((fm4.g) mm4.b.b(fm4.g.class)).A(g.this.G).g(false, this.f379770d, new a());
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
