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
import com.tencent.timi.game.team.impl.team.TeamContainerView;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.g;
import fm4.u;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamMicView extends URLImageView implements vm4.b {

    /* renamed from: d, reason: collision with root package name */
    private long f379638d;

    /* renamed from: e, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379639e;

    /* renamed from: f, reason: collision with root package name */
    private YesGameInfoOuterClass$GameConfigInfo f379640f;

    /* renamed from: h, reason: collision with root package name */
    private Observer<Boolean> f379641h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f379642d;

        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.team.impl.operate.TeamMicView$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C9977a implements nl4.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f379644a;

            C9977a(int i3) {
                this.f379644a = i3;
            }

            @Override // nl4.a
            public void a(boolean z16) {
                if (z16) {
                    TeamMicView.this.h(this.f379644a);
                    if (((sm4.a) mm4.b.b(sm4.a.class)).y3() && !((sm4.a) mm4.b.b(sm4.a.class)).a2(TeamMicView.this.f379638d)) {
                        f.c("\u5f00\u542f\u540e\uff0c\u4f60\u7684\u58f0\u97f3\u5c06\u88ab\u76f4\u64ad\u95f4\u89c2\u4f17\u542c\u5230\u3002");
                        return;
                    }
                    return;
                }
                l.e("GangupMicView", "click mic but permission false!!!");
            }
        }

        a(int i3) {
            this.f379642d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamMicView teamMicView = TeamMicView.this;
            teamMicView.g(teamMicView.f379638d);
            ((g) mm4.b.b(g.class)).A(TeamMicView.this.f379638d).p("click mic btn");
            int i16 = this.f379642d;
            if (i16 == 3) {
                f.c("\u4f60\u5df2\u88ab\u7981\u9ea6\uff0c\u6682\u65f6\u65e0\u6cd5\u53d1\u8a00\u3002");
            } else {
                if (i16 == 1) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (i3 != 1) {
                    TeamMicView.this.h(i3);
                } else {
                    ((nl4.c) mm4.b.b(nl4.c.class)).k2(new C9977a(i3));
                }
            }
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
            l.i("GangupMicView", "micLdObserver, onChanged - " + bool);
            TeamMicView.this.b(TeamContainerView.o(TeamMicView.this.f379638d, ((g) mm4.b.b(g.class)).K0(TeamMicView.this.f379638d).n()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements u {
        c() {
        }

        @Override // fm4.u
        public void j(boolean z16) {
            LiveData<Boolean> e16 = ((g) mm4.b.b(g.class)).m0(TeamMicView.this.f379638d).e();
            if (e16 != null) {
                e16.removeObserver(TeamMicView.this.f379641h);
                e16.observeForever(TeamMicView.this.f379641h);
            }
        }
    }

    public TeamMicView(Context context) {
        super(context);
        this.f379641h = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j3) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((g) mm4.b.b(g.class)).K0(j3).getRoomInfo();
        this.f379639e = roomInfo;
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
        L.put("yes_mic_status", String.valueOf(((g) mm4.b.b(g.class)).m0(j3).b() ? 1 : 0));
        ((ug4.b) mm4.b.b(ug4.b.class)).c(this, false, "\u8f93\u5165\u533a\u9ea6\u514b\u98ce\u6309\u94ae", "em_yes_mic", L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        ((g) mm4.b.b(g.class)).A(this.f379638d).O(null, i3, new d());
    }

    @Override // vm4.b
    public void b(int i3) {
        String str;
        int i16;
        if (i3 != 1) {
            i16 = R.drawable.o_z;
            if (i3 != 3) {
                str = this.f379640f.team_room_info.icon_input_mic_off.get();
            } else {
                str = this.f379640f.team_room_info.icon_input_mic_off.get();
            }
        } else {
            str = this.f379640f.team_room_info.icon_input_mic_on.get();
            i16 = R.drawable.f162572oa0;
        }
        com.tencent.timi.game.team.impl.b.f(this, str, i16);
        setOnClickListener(new a(i3));
    }

    public void i(long j3) {
        this.f379638d = j3;
        this.f379640f = ((h) mm4.b.b(h.class)).l1(((g) mm4.b.b(g.class)).K0(this.f379638d).o1());
        g(j3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f379638d != 0) {
            ((g) mm4.b.b(g.class)).k(this.f379638d).H(new c());
        }
        if (this.f379639e != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp", this, YoloRoomUtil.L(this.f379639e));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        LiveData<Boolean> e16;
        super.onDetachedFromWindow();
        if (this.f379638d != 0 && (e16 = ((g) mm4.b.b(g.class)).m0(this.f379638d).e()) != null) {
            e16.removeObserver(this.f379641h);
        }
        if (this.f379639e != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("imp_end", this, YoloRoomUtil.L(this.f379639e));
        }
    }

    public TeamMicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379641h = new b();
    }

    public TeamMicView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379641h = new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        d() {
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
