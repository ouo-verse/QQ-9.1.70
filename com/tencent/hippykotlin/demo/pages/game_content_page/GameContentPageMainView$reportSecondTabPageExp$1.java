package com.tencent.hippykotlin.demo.pages.game_content_page;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPageMainView$reportSecondTabPageExp$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ GameContentPageMainView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameContentPageMainView$reportSecondTabPageExp$1(GameContentPageMainView gameContentPageMainView) {
        super(0);
        this.this$0 = gameContentPageMainView;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a1 A[LOOP:0: B:12:0x009b->B:14:0x00a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke() {
        int i3;
        Iterator<String> c16;
        GameContentPageMainViewAttr access$getAttr = GameContentPageMainView.access$getAttr(this.this$0);
        ReadWriteProperty readWriteProperty = access$getAttr.currentTabIndex$delegate;
        KProperty<?>[] kPropertyArr = GameContentPageMainViewAttr.$$delegatedProperties;
        if (((Number) readWriteProperty.getValue(access$getAttr, kPropertyArr[3])).intValue() < GameContentPageMainView.access$getAttr(this.this$0).getTabItems().size()) {
            c<GameTab> tabItems = GameContentPageMainView.access$getAttr(this.this$0).getTabItems();
            GameContentPageMainViewAttr access$getAttr2 = GameContentPageMainView.access$getAttr(this.this$0);
            GameTab gameTab = tabItems.get(((Number) access$getAttr2.currentTabIndex$delegate.getValue(access$getAttr2, kPropertyArr[3])).intValue());
            e eVar = new e();
            eVar.v("second_tab_name", gameTab.name);
            if (gameTab.enableRedPoint) {
                Object obj = gameTab.getExtProps().get("redPointHasExp");
                if (obj == null) {
                    obj = Boolean.FALSE;
                }
                if (!((Boolean) obj).booleanValue()) {
                    i3 = 1;
                    eVar.t("is_red_spot", i3);
                    Utils.INSTANCE.logToNative("GameContentPageReporter EVENT_CODE_SECOND_TAB_EXP");
                    e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
                    c16 = eVar.c();
                    while (c16.hasNext()) {
                        String next = c16.next();
                        m3.v(next, eVar.p(next));
                    }
                    Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_second_tab_exp", m3);
                    if (gameTab.enableRedPoint) {
                        gameTab.getExtProps().put("redPointHasExp", Boolean.TRUE);
                    }
                }
            }
            i3 = 2;
            eVar.t("is_red_spot", i3);
            Utils.INSTANCE.logToNative("GameContentPageReporter EVENT_CODE_SECOND_TAB_EXP");
            e m36 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
            c16 = eVar.c();
            while (c16.hasNext()) {
            }
            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_second_tab_exp", m36);
            if (gameTab.enableRedPoint) {
            }
        }
        return Unit.INSTANCE;
    }
}
