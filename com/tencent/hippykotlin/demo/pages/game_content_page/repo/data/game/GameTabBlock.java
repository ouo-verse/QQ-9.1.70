package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameTabBlock implements ISSOReqModel, ISSORspModel<GameTabBlock> {
    public final List<GameTab> gameTabs;
    public final String locatedTabId;

    public GameTabBlock(List<GameTab> list, String str) {
        this.gameTabs = list;
        this.locatedTabId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<GameTab> list = this.gameTabs;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((GameTab) it.next()).encode());
            }
        }
        eVar.v("game_tabs", bVar);
        eVar.v("located_tab_id", this.locatedTabId);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameTabBlock decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("game_tabs");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    GameTab gameTab = new GameTab(null, null, false, 7, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(gameTab.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        return new GameTabBlock(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, eVar.q("located_tab_id", ""));
    }
}
