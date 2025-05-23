package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCardBlock implements ISSOReqModel, ISSORspModel<GameCardBlock> {
    public final List<GameCard> gameCards;

    public GameCardBlock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<GameCard> list = this.gameCards;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((GameCard) it.next()).encode());
            }
        }
        eVar.v("game_cards", bVar);
        return eVar;
    }

    public GameCardBlock(List<GameCard> list) {
        this.gameCards = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameCardBlock decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("game_cards");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    GameCard gameCard = new GameCard(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 0, 1048575, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(gameCard.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        return new GameCardBlock(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
    }

    public /* synthetic */ GameCardBlock(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
