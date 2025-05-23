package com.tencent.ntcompose.core;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000j\u0002`\u0001\u001a$\u0010\n\u001a\u00020\t*\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007*\u001a\u0010\u000b\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/ntcompose/core/BaseRenderView;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "b", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/core/k;", "Lkotlin/collections/ArrayList;", "", "other", "", "a", "BaseRenderView", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {
    public static final boolean a(ArrayList<k> arrayList, Object obj) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (arrayList == obj) {
            return true;
        }
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        Iterator<k> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(it.next(), arrayList2.get(i3))) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static final ComposeRenderView b(DeclarativeBaseView<?, ?> declarativeBaseView) {
        Intrinsics.checkNotNullParameter(declarativeBaseView, "<this>");
        return new ComposeRenderView(declarativeBaseView);
    }
}
