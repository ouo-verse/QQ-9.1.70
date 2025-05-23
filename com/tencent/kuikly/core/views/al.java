package com.tencent.kuikly.core.views;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/views/al;", "", "Lcom/tencent/kuikly/core/views/ak;", TtmlNode.TAG_SPAN, "a", "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "b", "()Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "", "Ljava/util/List;", "spans", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<ak> spans = new ArrayList();

    public final al a(ak span) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.spans.add(span);
        return this;
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.b b() {
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        Iterator<T> it = this.spans.iterator();
        while (it.hasNext()) {
            bVar.t(((ak) it.next()).getPropMap());
        }
        return bVar;
    }
}
