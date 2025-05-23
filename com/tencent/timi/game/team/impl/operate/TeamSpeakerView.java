package com.tencent.timi.game.team.impl.operate;

import ag4.h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.l;
import fm4.g;
import fm4.u;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamSpeakerView extends URLImageView implements vm4.c {

    /* renamed from: d, reason: collision with root package name */
    private long f379649d;

    /* renamed from: e, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379650e;

    /* renamed from: f, reason: collision with root package name */
    private YesGameInfoOuterClass$GameConfigInfo f379651f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f379652h;

    /* renamed from: i, reason: collision with root package name */
    private Observer<Boolean> f379653i;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamSpeakerView teamSpeakerView = TeamSpeakerView.this;
            teamSpeakerView.f(teamSpeakerView.f379649d);
            ((g) mm4.b.b(g.class)).m0(TeamSpeakerView.this.f379649d).c(!((g) mm4.b.b(g.class)).m0(TeamSpeakerView.this.f379649d).a());
            TeamSpeakerView.this.a();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            l.i("GangupSpeakerView", "speakerLdObserver, onChanged - " + bool);
            TeamSpeakerView.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements u {
        c() {
        }

        @Override // fm4.u
        public void j(boolean z16) {
            LiveData<Boolean> d16 = ((g) mm4.b.b(g.class)).m0(TeamSpeakerView.this.f379649d).d();
            if (d16 != null) {
                d16.removeObserver(TeamSpeakerView.this.f379653i);
                d16.observeForever(TeamSpeakerView.this.f379653i);
            }
        }
    }

    public TeamSpeakerView(Context context) {
        super(context);
        this.f379652h = new a();
        this.f379653i = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j3) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((g) mm4.b.b(g.class)).K0(j3).getRoomInfo();
        this.f379650e = roomInfo;
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
        L.put("yes_voice_status", String.valueOf(((g) mm4.b.b(g.class)).m0(j3).a() ? 1 : 0));
        ((ug4.b) mm4.b.b(ug4.b.class)).c(this, false, "\u8f93\u5165\u533a\u5587\u53ed\u6309\u94ae", "em_yes_voice", L);
    }

    @Override // vm4.c
    public void a() {
        String str;
        int i3;
        boolean a16 = ((g) mm4.b.b(g.class)).m0(this.f379649d).a();
        if (a16) {
            str = this.f379651f.team_room_info.icon_input_speaker_on.get();
        } else {
            str = this.f379651f.team_room_info.icon_input_speaker_off.get();
        }
        if (a16) {
            i3 = R.drawable.oac;
        } else {
            i3 = R.drawable.oab;
        }
        com.tencent.timi.game.team.impl.b.f(this, str, i3);
        setOnClickListener(this.f379652h);
    }

    public void g(long j3) {
        this.f379649d = j3;
        this.f379651f = ((h) mm4.b.b(h.class)).l1(((g) mm4.b.b(g.class)).K0(this.f379649d).o1());
        f(j3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f379649d != 0) {
            ((g) mm4.b.b(g.class)).k(this.f379649d).H(new c());
        }
        if (this.f379650e != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp", this, YoloRoomUtil.L(this.f379650e));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        LiveData<Boolean> d16;
        super.onDetachedFromWindow();
        if (this.f379649d != 0 && (d16 = ((g) mm4.b.b(g.class)).m0(this.f379649d).d()) != null) {
            d16.removeObserver(this.f379653i);
        }
        if (this.f379650e != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp_end", this, YoloRoomUtil.L(this.f379650e));
        }
    }

    public TeamSpeakerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379652h = new a();
        this.f379653i = new b();
    }

    public TeamSpeakerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379652h = new a();
        this.f379653i = new b();
    }
}
