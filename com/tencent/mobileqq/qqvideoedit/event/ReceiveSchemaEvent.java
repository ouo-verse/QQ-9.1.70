package com.tencent.mobileqq.qqvideoedit.event;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/event/ReceiveSchemaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", Node.ATTRS_ATTR, "", "", "(Ljava/util/Map;)V", "getAttrs", "()Ljava/util/Map;", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ReceiveSchemaEvent extends SimpleBaseEvent {

    @NotNull
    private final Map<String, String> attrs;

    public ReceiveSchemaEvent(@NotNull Map<String, String> attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.attrs = attrs;
    }

    @NotNull
    public final Map<String, String> getAttrs() {
        return this.attrs;
    }
}
