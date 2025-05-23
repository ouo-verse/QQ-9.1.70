package com.tencent.timi.game.team.impl.setting.ui;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectView;
import com.tencent.timi.game.utils.l;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import um4.i;
import um4.k;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends com.tencent.timi.game.team.impl.setting.ui.a {
    private GiftSelectView D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements i.a {
        a() {
        }

        @Override // um4.i.a
        public void a() {
            b.this.D.setVisibility(8);
        }

        @Override // um4.i.a
        public void show() {
            b.this.D.setVisibility(0);
        }
    }

    public b(@NonNull View view) {
        super(view);
        this.D = (GiftSelectView) view;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ViewUtils.dip2px(26.0f);
        this.D.setLayoutParams(layoutParams);
    }

    private void r() {
        this.D.r(this.f379675e.f379564i.team_info.main_hue.get());
        k kVar = k.f439239a;
        kVar.c();
        kVar.e();
        i.f439236a.a(new a());
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void c(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        super.c(yesGameInfoOuterClass$GameConfigItem, dVar, list, i3);
        if (l() && this.f379675e.f379560e == null) {
            r();
        } else {
            this.D.setVisibility(8);
        }
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void f() {
        GiftSelectView giftSelectView = this.D;
        if (giftSelectView != null) {
            giftSelectView.o();
        }
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void g(YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
        YoloRoomOuterClass$YoloGiftConfig q16 = q();
        if (q16 != null) {
            yoloRoomOuterClass$YoloGameRoomParams.gift_config.set(q16);
        }
    }

    public YoloRoomOuterClass$YoloGiftConfig q() {
        if (this.D.getVisibility() != 0) {
            l.e("Team_Config", "getGiftConfig mGiftSelectView not enable");
            return null;
        }
        GiftSelectView.GiftServerDataEx p16 = this.D.p();
        if (p16 == null) {
            l.e("Team_Config", "getGiftConfig dataEx is null");
            return null;
        }
        YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = new YoloRoomOuterClass$YoloGiftConfig();
        yoloRoomOuterClass$YoloGiftConfig.gift_id.set(p16.getData().f264874d);
        yoloRoomOuterClass$YoloGiftConfig.gift_num.set(p16.getSelectCount());
        yoloRoomOuterClass$YoloGiftConfig.gift_name.set(p16.getData().f264876e);
        yoloRoomOuterClass$YoloGiftConfig.gift_material_id.set(p16.getData().C);
        yoloRoomOuterClass$YoloGiftConfig.gift_price.set(p16.getData().f264878f);
        l.h("Team_Config", 1, "getGiftConfig id:" + yoloRoomOuterClass$YoloGiftConfig.gift_id.get() + ", num:" + yoloRoomOuterClass$YoloGiftConfig.gift_num.get() + ", name:" + yoloRoomOuterClass$YoloGiftConfig.gift_name.get() + ", material_id:" + yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get());
        return yoloRoomOuterClass$YoloGiftConfig;
    }
}
