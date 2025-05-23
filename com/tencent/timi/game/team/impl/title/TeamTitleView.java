package com.tencent.timi.game.team.impl.title;

import an4.l;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.main.e;
import com.tencent.timi.game.team.impl.main.f;
import com.tencent.timi.game.team.impl.setting.TeamClosePopupView;
import com.tencent.timi.game.team.impl.team.TeamInfoEx;
import fm4.g;
import java.util.HashMap;
import mm4.b;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigTeamRoom;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamTitleView extends RelativeLayout implements com.tencent.timi.game.team.impl.main.a, View.OnClickListener {
    private View.OnClickListener C;
    private long D;
    private YoloRoomOuterClass$YoloRoomInfo E;
    private CommonOuterClass$QQUserId F;

    /* renamed from: d, reason: collision with root package name */
    private TextView f379789d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f379790e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f379791f;

    /* renamed from: h, reason: collision with root package name */
    private URLImageView f379792h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f379793i;

    /* renamed from: m, reason: collision with root package name */
    private URLImageView f379794m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements TeamClosePopupView.a {
        a() {
        }

        @Override // com.tencent.timi.game.team.impl.setting.TeamClosePopupView.a
        public void a() {
            f.e(vf4.a.b(), TeamTitleView.this.D);
        }

        @Override // com.tencent.timi.game.team.impl.setting.TeamClosePopupView.a
        public void b() {
            if (TeamTitleView.this.C != null) {
                TeamTitleView.this.C.onClick(TeamTitleView.this);
            }
        }
    }

    public TeamTitleView(Context context) {
        super(context);
        l();
    }

    private static int e(boolean z16, int i3, int i16) {
        if (!z16) {
            return i16;
        }
        return i3;
    }

    private YoloRoomOuterClass$YoloRoomSpeakingPosInfo f() {
        return ((g) b.b(g.class)).K0(this.E.room_id.get()).L(((ll4.a) b.b(ll4.a.class)).E());
    }

    private void g() {
        TeamClosePopupView teamClosePopupView = new TeamClosePopupView(getContext(), this.D);
        teamClosePopupView.setOnActionClickListener(new a());
        teamClosePopupView.g(this.f379794m);
    }

    private void h() {
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null) {
            e.k(b16, this.D);
        }
    }

    private void j() {
        l.f26382a.g(f(), this.D, ((g) b.b(g.class)).t2(((g) b.b(g.class)).K0(this.D).getRoomInfo()));
    }

    private void k() {
        View.inflate(getContext(), R.layout.hx8, this);
    }

    private void l() {
        k();
        n();
        m();
    }

    private void m() {
        this.f379792h.setOnClickListener(this);
        this.f379793i.setOnClickListener(this);
        this.f379794m.setOnClickListener(this);
    }

    private void n() {
        this.f379789d = (TextView) findViewById(R.id.f93295_7);
        this.f379790e = (TextView) findViewById(R.id.f93275_5);
        this.f379791f = (TextView) findViewById(R.id.f93285_6);
        this.f379792h = (URLImageView) findViewById(R.id.f93325__);
        this.f379793i = (URLImageView) findViewById(R.id.f93315_9);
        this.f379794m = (URLImageView) findViewById(R.id.f93265_4);
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void A(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.D = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        this.E = yoloRoomOuterClass$YoloRoomInfo;
        this.F = commonOuterClass$QQUserId;
        d();
        c(yoloRoomOuterClass$YoloRoomInfo.room_id.get());
    }

    public void c(long j3) {
        HashMap hashMap = new HashMap();
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.E;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            hashMap.put("yes_game_id", String.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_data_info.game_id.get()));
            hashMap.put("yes_user_from", String.valueOf(this.E.room_data_info.create_from.get()));
        }
        ((ug4.b) b.b(ug4.b.class)).b(this, "pg_yes_smoba_team", hashMap);
        ((ug4.b) b.b(ug4.b.class)).a(this.f379793i, true, "\u8bbe\u7f6e\u6309\u94ae", "em_yes_config", YoloRoomUtil.L(((g) b.b(g.class)).K0(j3).getRoomInfo()));
    }

    public void d() {
        int i3;
        boolean z16;
        if (this.E != null && this.F != null) {
            YoloRoomOuterClass$YoloRoomInfo roomInfo = ((g) b.b(g.class)).K0(this.D).getRoomInfo();
            if (roomInfo != null) {
                this.f379789d.setText(roomInfo.introduce.get());
            }
            YoloRoomOuterClass$YoloCommonGameDataInfo w3 = ((g) b.b(g.class)).K0(this.D).w();
            if (w3 != null) {
                this.f379790e.setText(w3.game_desc.get());
                this.f379791f.setText("");
            }
            URLImageView uRLImageView = this.f379793i;
            if (((sm4.a) b.b(sm4.a.class)).a2(this.D)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            uRLImageView.setVisibility(i3);
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo f16 = f();
            boolean z17 = true;
            if (f16 != null && f16.guild_id.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || ((g) b.b(g.class)).t2(roomInfo) == 101) {
                z17 = false;
            }
            if (!z17 && !((sm4.a) b.b(sm4.a.class)).y3() && this.F.user_from.get() != 4) {
                this.f379792h.setVisibility(0);
            } else {
                this.f379792h.setVisibility(8);
            }
            ((ug4.b) b.b(ug4.b.class)).a(this.f379792h, false, "", "em_yes_share", YoloRoomUtil.L(this.E));
        }
    }

    public void o(boolean z16, YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        PBStringField pBStringField;
        int parseColor;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        YesGameInfoOuterClass$GameConfigTeamRoom yesGameInfoOuterClass$GameConfigTeamRoom = yesGameInfoOuterClass$GameConfigInfo.team_room_info;
        TextView textView = this.f379789d;
        if (z16 && !TextUtils.isEmpty(yesGameInfoOuterClass$GameConfigTeamRoom.color_title_name_gift.get())) {
            pBStringField = yesGameInfoOuterClass$GameConfigTeamRoom.color_title_name_gift;
        } else {
            pBStringField = yesGameInfoOuterClass$GameConfigTeamRoom.color_title_name;
        }
        com.tencent.timi.game.team.impl.b.c(textView, pBStringField.get(), e(z16, Color.parseColor("#E08300"), Color.parseColor("#1A1A1A")));
        TextView textView2 = this.f379790e;
        String str = yesGameInfoOuterClass$GameConfigTeamRoom.color_title_subdesc_txt.get();
        if (z16) {
            parseColor = getContext().getResources().getColor(R.color.f156809bx);
        } else {
            parseColor = Color.parseColor("#7f000000");
        }
        com.tencent.timi.game.team.impl.b.c(textView2, str, parseColor);
        com.tencent.timi.game.team.impl.b.c(this.f379791f, yesGameInfoOuterClass$GameConfigTeamRoom.color_title_subdesc_txt.get(), e(z16, getContext().getResources().getColor(R.color.f156809bx), Color.parseColor("#7f000000")));
        URLImageView uRLImageView = this.f379793i;
        if (z16 && !TextUtils.isEmpty(yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_setting.get())) {
            pBStringField2 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_setting;
        } else {
            pBStringField2 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_setting;
        }
        com.tencent.timi.game.team.impl.b.f(uRLImageView, pBStringField2.get(), e(z16, R.drawable.oa6, R.drawable.oa5));
        URLImageView uRLImageView2 = this.f379792h;
        if (z16 && !TextUtils.isEmpty(yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_share.get())) {
            pBStringField3 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_share;
        } else {
            pBStringField3 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_share;
        }
        com.tencent.timi.game.team.impl.b.f(uRLImageView2, pBStringField3.get(), e(z16, R.drawable.oa9, R.drawable.oa8));
        URLImageView uRLImageView3 = this.f379794m;
        if (z16 && !TextUtils.isEmpty(yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_close.get())) {
            pBStringField4 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_gift_close;
        } else {
            pBStringField4 = yesGameInfoOuterClass$GameConfigTeamRoom.icon_title_close;
        }
        com.tencent.timi.game.team.impl.b.f(uRLImageView3, pBStringField4.get(), e(z16, R.drawable.o_k, R.drawable.o_j));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f93325__) {
            j();
        } else if (view.getId() == R.id.f93315_9) {
            h();
        } else if (view.getId() == R.id.f93265_4) {
            g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnCollectClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public TeamTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l();
    }

    public TeamTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        l();
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void i(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx) {
    }
}
