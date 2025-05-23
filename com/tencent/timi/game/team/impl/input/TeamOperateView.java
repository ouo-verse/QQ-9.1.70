package com.tencent.timi.game.team.impl.input;

import ag4.h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.team.impl.operate.TeamActionBtnView;
import com.tencent.timi.game.team.impl.operate.TeamMicView;
import com.tencent.timi.game.team.impl.operate.TeamSpeakerView;
import com.tencent.timi.game.team.impl.team.TeamInfoEx;
import fm4.g;
import mm4.b;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import vm4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamOperateView extends LinearLayout implements View.OnClickListener, com.tencent.timi.game.team.impl.main.a {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private a f379521d;

    /* renamed from: e, reason: collision with root package name */
    private URLImageView f379522e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f379523f;

    /* renamed from: h, reason: collision with root package name */
    private TeamActionBtnView f379524h;

    /* renamed from: i, reason: collision with root package name */
    private TeamSpeakerView f379525i;

    /* renamed from: m, reason: collision with root package name */
    private TeamMicView f379526m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a(View view);

        void b(View view);
    }

    public TeamOperateView(Context context) {
        super(context);
        f();
    }

    private void e() {
        View.inflate(getContext(), R.layout.hxh, this);
    }

    private void f() {
        g();
        e();
        j();
        h();
    }

    private void g() {
        setGravity(17);
    }

    private void h() {
        this.f379522e.setOnClickListener(this);
        this.f379523f.setOnClickListener(this);
    }

    private void j() {
        this.f379522e = (URLImageView) findViewById(R.id.f93355_c);
        this.f379523f = (URLImageView) findViewById(R.id.f93345_b);
        this.f379524h = (TeamActionBtnView) findViewById(R.id.f93335_a);
        this.f379525i = (TeamSpeakerView) findViewById(R.id.f93385_f);
        this.f379526m = (TeamMicView) findViewById(R.id.f93375_e);
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void A(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        long j3 = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        this.f379524h.r(j3);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((h) b.b(h.class)).l1(((g) b.b(g.class)).t2(yoloRoomOuterClass$YoloRoomInfo));
        com.tencent.timi.game.team.impl.b.f(this.f379522e, l16.team_room_info.icon_input_chat.get(), R.drawable.f162574oa2);
        com.tencent.timi.game.team.impl.b.f(this.f379523f, l16.team_room_info.icon_input_gift.get(), R.drawable.f162573oa1);
        this.f379526m.i(j3);
        this.f379525i.g(j3);
        if (!this.C) {
            this.f379526m.setVisibility(8);
            this.f379525i.setVisibility(8);
        }
    }

    public vm4.a a() {
        return this.f379524h;
    }

    public View b() {
        return this.f379523f;
    }

    public vm4.b c() {
        return this.f379526m;
    }

    public c d() {
        return this.f379525i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f93355_c) {
            a aVar2 = this.f379521d;
            if (aVar2 != null) {
                aVar2.a(view);
            }
        } else if (view.getId() == R.id.f93345_b && (aVar = this.f379521d) != null) {
            aVar.b(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnActionClickListener(a aVar) {
        this.f379521d = aVar;
    }

    public void setVoiceEnable(boolean z16) {
        this.C = z16;
    }

    public TeamOperateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public TeamOperateView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f();
    }

    @Override // com.tencent.timi.game.team.impl.main.a
    public void i(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx) {
    }
}
