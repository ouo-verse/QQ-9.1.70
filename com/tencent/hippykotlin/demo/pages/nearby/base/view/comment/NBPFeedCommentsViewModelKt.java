package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import p35.g;
import p35.h;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsViewModelKt {
    public static g copy$default(g gVar, int i3) {
        List mutableList;
        List<h> list = gVar.f425170e;
        String str = gVar.f425171f;
        boolean z16 = gVar.f425172h;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        return new g(i3, mutableList, str, z16);
    }
}
