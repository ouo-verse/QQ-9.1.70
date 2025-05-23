package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerFeedCommentRepoKt {
    public static final b toJSON(List<QuickCommentItem> list) {
        b bVar = new b();
        for (QuickCommentItem quickCommentItem : list) {
            e eVar = new e();
            eVar.v("id", quickCommentItem.f114209id);
            eVar.v("text", quickCommentItem.text);
            eVar.v("trace", quickCommentItem.trace);
            bVar.t(eVar);
        }
        return bVar;
    }

    public static final List<QuickCommentItem> parseQuickCommentList(b bVar) {
        List<QuickCommentItem> emptyList;
        List<QuickCommentItem> emptyList2;
        if (bVar == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int c16 = bVar.c();
            for (int i3 = 0; i3 < c16; i3++) {
                e l3 = bVar.l(i3);
                if (l3 != null) {
                    arrayList.add(new QuickCommentItem(l3.p("id"), l3.p("text"), l3.p("trace")));
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            KLog.INSTANCE.e("parseQuickCommentList", "parseQuickCommentList error: " + th5);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
