package com.tencent.timi.game.team.impl.setting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import fm4.g;
import java.util.HashMap;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* loaded from: classes26.dex */
public class TeamClosePopupView extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f379657d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f379658e;

    /* renamed from: f, reason: collision with root package name */
    private PopupWindow f379659f;

    /* renamed from: h, reason: collision with root package name */
    private a f379660h;

    /* renamed from: i, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379661i;

    /* renamed from: m, reason: collision with root package name */
    private long f379662m;

    /* loaded from: classes26.dex */
    public interface a {
        void a();

        void b();
    }

    public TeamClosePopupView(Context context, long j3) {
        super(context);
        b(j3);
    }

    private void a() {
        View.inflate(getContext(), R.layout.f169132hx2, this);
    }

    private void b(long j3) {
        this.f379662m = j3;
        c();
        a();
        f();
        d();
    }

    private void c() {
        setOrientation(1);
        setPadding(0, 0, ViewUtils.dip2px(16.0f), 0);
    }

    private void d() {
        this.f379657d.setOnClickListener(this);
        this.f379658e.setOnClickListener(this);
    }

    private void e(long j3) {
        HashMap hashMap = new HashMap();
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379661i;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            hashMap.put("yes_game_id", String.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_data_info.game_id.get()));
        }
        ((b) mm4.b.b(b.class)).G2(this.f379659f.getContentView(), "pg_yes_smoba_team");
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((g) mm4.b.b(g.class)).K0(j3).getRoomInfo();
        this.f379661i = roomInfo;
        if (roomInfo != null) {
            ((b) mm4.b.b(b.class)).a(this.f379657d, false, "\u6536\u8d77\u8f66\u961f\u6309\u94ae", "em_yes_minsize_team", YoloRoomUtil.L(this.f379661i));
            ((b) mm4.b.b(b.class)).a(this.f379658e, false, "\u9000\u51fa\u8f66\u961f\u6309\u94ae", "em_yes_leave_team", YoloRoomUtil.L(this.f379661i));
        }
    }

    private void f() {
        this.f379657d = (TextView) findViewById(R.id.f93485_p);
        this.f379658e = (TextView) findViewById(R.id.f93495_q);
    }

    public void g(View view) {
        PopupWindow popupWindow = new PopupWindow(this, -2, -2);
        this.f379659f = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f379659f.showAsDropDown(view);
        e(this.f379662m);
        if (this.f379661i != null) {
            ((b) mm4.b.b(b.class)).reportEvent("imp", this.f379658e, YoloRoomUtil.L(this.f379661i));
            ((b) mm4.b.b(b.class)).reportEvent("imp", this.f379657d, YoloRoomUtil.L(this.f379661i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f93485_p) {
            a aVar2 = this.f379660h;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (view.getId() == R.id.f93495_q && (aVar = this.f379660h) != null) {
            aVar.a();
        }
        this.f379659f.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnActionClickListener(a aVar) {
        this.f379660h = aVar;
    }
}
