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
public final class NavigationBlock implements ISSOReqModel, ISSORspModel<NavigationBlock> {
    public final List<IconButton> iconButtons;

    public NavigationBlock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<IconButton> list = this.iconButtons;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((IconButton) it.next()).encode());
            }
        }
        eVar.v("icon_buttons", bVar);
        return eVar;
    }

    public NavigationBlock(List<IconButton> list) {
        this.iconButtons = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final NavigationBlock decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("icon_buttons");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new IconButton(eVar2.q("title", ""), eVar2.q("jump_url", ""), eVar2.q("icon_default", ""), eVar2.q("icon_night", ""), eVar2.q("sub_title", "")));
                }
            }
        } else {
            arrayList = null;
        }
        return new NavigationBlock(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
    }

    public /* synthetic */ NavigationBlock(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
