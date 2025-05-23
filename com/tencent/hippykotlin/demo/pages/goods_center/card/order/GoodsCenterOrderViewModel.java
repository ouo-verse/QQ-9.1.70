package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.Iterator;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderViewModel implements IGoodsCenterCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterOrderViewModel.class, "rsp", "getRsp()Lcom/tencent/hippykotlin/demo/pages/goods_center/repository/protoc/GoodsCenterSelectProductsRsp;", 0)};
    public final ReadWriteProperty rsp$delegate = c.a(new GoodsCenterSelectProductsRsp(null, false, null, null, null, null, null, null, null, null, null, 0, null, InitSkin.DRAWABLE_COUNT, null));
    public boolean needRebuild = true;

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterOrderView();
    }

    public final GoodsCenterSelectProductsRsp getRsp() {
        return (GoodsCenterSelectProductsRsp) this.rsp$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void iconClick(Icon icon) {
        e eVar = new e();
        String str = icon.eventCode;
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportDT(str, m3);
        BridgeModule.openPage$default(utils.currentBridgeModule(), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), icon.url, "&is_ktv_product_center=1"), false, null, null, 30);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }

    public final void updateRsp(GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp, boolean z16) {
        if (z16) {
            this.rsp$delegate.setValue(this, $$delegatedProperties[0], goodsCenterSelectProductsRsp);
        } else {
            if (!this.needRebuild || goodsCenterSelectProductsRsp.turnover == null || goodsCenterSelectProductsRsp.navigation == null) {
                return;
            }
            this.rsp$delegate.setValue(this, $$delegatedProperties[0], goodsCenterSelectProductsRsp);
            this.needRebuild = false;
        }
    }
}
