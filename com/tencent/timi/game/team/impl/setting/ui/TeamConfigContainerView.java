package com.tencent.timi.game.team.impl.setting.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectView;
import com.tencent.timi.game.team.impl.setting.ui.a;
import fm4.g;
import fm4.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCreateSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamConfigContainerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private List<YesGameInfoOuterClass$GameConfigItem> f379663d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.timi.game.team.impl.setting.ui.a> f379664e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.timi.game.team.impl.main.d f379665f;

    /* renamed from: h, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomParams f379666h;

    /* renamed from: i, reason: collision with root package name */
    private List<YesGameInfoOuterClass$GameConfigLinkageOption> f379667i;

    /* renamed from: m, reason: collision with root package name */
    private int f379668m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements a.InterfaceC9978a {
        a() {
        }

        @Override // com.tencent.timi.game.team.impl.setting.ui.a.InterfaceC9978a
        public void a(List<YesGameInfoOuterClass$GameConfigLinkageOption> list, boolean z16) {
            TeamConfigContainerView.this.f379667i = list;
            if (!z16) {
                TeamConfigContainerView.this.l(list);
            }
        }
    }

    public TeamConfigContainerView(Context context) {
        super(context);
        this.f379663d = new ArrayList();
        this.f379664e = new ArrayList();
        g();
    }

    private void g() {
        h();
    }

    private void h() {
        setOrientation(1);
    }

    public void b(List<YesGameInfoOuterClass$GameConfigItem> list) {
        this.f379663d.clear();
        this.f379663d.addAll(list);
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.timi.game.team.impl.setting.ui.a k3 = k(this, e(i3));
            if (k3 != null) {
                this.f379664e.add(k3);
                addView(k3.h());
                j(k3, i3);
            }
        }
    }

    public void c() {
        Iterator<com.tencent.timi.game.team.impl.setting.ui.a> it = this.f379664e.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public YoloRoomOuterClass$YoloGameRoomParams d() {
        YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams = new YoloRoomOuterClass$YoloGameRoomParams();
        yoloRoomOuterClass$YoloGameRoomParams.base_room_id.set(this.f379665f.f379558c);
        Iterator<com.tencent.timi.game.team.impl.setting.ui.a> it = this.f379664e.iterator();
        while (it.hasNext()) {
            it.next().g(yoloRoomOuterClass$YoloGameRoomParams);
        }
        h hVar = this.f379665f.f379560e;
        if (hVar != null) {
            if (!TextUtils.isEmpty(hVar.f399874a)) {
                YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig = new YoloRoomOuterClass$QQLiveRoomConfig();
                yoloRoomOuterClass$QQLiveRoomConfig.enter_condition.set(this.f379665f.f379560e.f399877d);
                yoloRoomOuterClass$QQLiveRoomConfig.qq_live_room_id.set(this.f379665f.f379560e.f399874a);
                yoloRoomOuterClass$QQLiveRoomConfig.qq_live_uid.set(this.f379665f.f379560e.f399875b);
                yoloRoomOuterClass$QQLiveRoomConfig.live_uid.set(this.f379665f.f379560e.f399879f);
                yoloRoomOuterClass$QQLiveRoomConfig.anchor_id.set(this.f379665f.f379560e.f399880g);
                yoloRoomOuterClass$QQLiveRoomConfig.trtc_room_id.set(this.f379665f.f379560e.f399876c);
                yoloRoomOuterClass$QQLiveRoomConfig.is_screen_capture.set(this.f379665f.f379560e.f399878e);
                yoloRoomOuterClass$YoloGameRoomParams.qq_live_room_config.set(yoloRoomOuterClass$QQLiveRoomConfig);
            }
            if (!TextUtils.isEmpty(this.f379665f.f379560e.f399881h)) {
                YoloRoomOuterClass$YoloRoomCreateSchema yoloRoomOuterClass$YoloRoomCreateSchema = new YoloRoomOuterClass$YoloRoomCreateSchema();
                yoloRoomOuterClass$YoloRoomCreateSchema.schema.set(this.f379665f.f379560e.f399881h);
                yoloRoomOuterClass$YoloGameRoomParams.create_schema.set(yoloRoomOuterClass$YoloRoomCreateSchema);
            }
        }
        return yoloRoomOuterClass$YoloGameRoomParams;
    }

    public int e(int i3) {
        return this.f379663d.get(i3).type.get();
    }

    public YoloRoomOuterClass$YoloRoomParams f() {
        int i3;
        this.f379666h = new YoloRoomOuterClass$YoloRoomParams();
        if (this.f379668m == 0) {
            int y16 = YoloRoomUtil.y(this.f379665f.f379563h);
            this.f379666h.room_type.set(y16);
            this.f379666h.is_private.set(0);
            PBInt32Field pBInt32Field = this.f379666h.voice_switch;
            if (((g) mm4.b.b(g.class)).h2(y16)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            pBInt32Field.set(i3);
            this.f379666h.create_from.set(this.f379665f.f379556a);
            this.f379666h.sub_create_from.set(this.f379665f.f379557b);
            fm4.c cVar = this.f379665f.f379559d;
            if (cVar != null) {
                this.f379666h.guild_id.set(cVar.f399871a);
                this.f379666h.channel_id.set(this.f379665f.f379559d.f399872b);
                this.f379666h.channel_name.set(this.f379665f.f379559d.f399873c);
            }
        }
        return this.f379666h;
    }

    public void i(com.tencent.timi.game.team.impl.main.d dVar, int i3) {
        this.f379665f = dVar;
        this.f379668m = i3;
    }

    public void j(com.tencent.timi.game.team.impl.setting.ui.a aVar, int i3) {
        aVar.o(new a());
        aVar.c(this.f379663d.get(i3), this.f379665f, this.f379667i, this.f379668m);
    }

    public com.tencent.timi.game.team.impl.setting.ui.a k(ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hwq, viewGroup, false));
        }
        if (i3 == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hwr, viewGroup, false), false);
        }
        if (i3 == 3) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hwr, viewGroup, false), true);
        }
        if (i3 == 4) {
            return new TeamConfigContinuousHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hwo, viewGroup, false));
        }
        if (i3 == 5) {
            GiftSelectView giftSelectView = new GiftSelectView(viewGroup.getContext());
            giftSelectView.setId(R.id.f928058v);
            return new b(giftSelectView);
        }
        return null;
    }

    public void l(List<YesGameInfoOuterClass$GameConfigLinkageOption> list) {
        for (com.tencent.timi.game.team.impl.setting.ui.a aVar : this.f379664e) {
            Iterator<YesGameInfoOuterClass$GameConfigLinkageOption> it = list.iterator();
            while (it.hasNext()) {
                if (aVar.i() == it.next().index.get()) {
                    aVar.n(list);
                }
            }
        }
    }

    public TeamConfigContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379663d = new ArrayList();
        this.f379664e = new ArrayList();
        g();
    }

    public TeamConfigContainerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379663d = new ArrayList();
        this.f379664e = new ArrayList();
        g();
    }
}
