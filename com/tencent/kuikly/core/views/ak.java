package com.tencent.kuikly.core.views;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/views/ak;", "", "", "text", "e", "size", "b", "Lcom/tencent/kuikly/core/base/h;", "color", "a", "c", "", NodeProps.LINE_HEIGHT, "d", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "f", "()Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "propMap", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.nvi.serialization.json.e propMap = new com.tencent.kuikly.core.nvi.serialization.json.e();

    public final ak a(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.propMap.v("color", color.toString());
        return this;
    }

    public final ak b(Object size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.propMap.v("fontSize", size);
        return this;
    }

    public final ak c() {
        this.propMap.v("fontWeight", "500");
        return this;
    }

    public final ak d(float lineHeight) {
        this.propMap.v(NodeProps.LINE_HEIGHT, Float.valueOf(lineHeight));
        return this;
    }

    public final ak e(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.propMap.v("text", text);
        return this;
    }

    /* renamed from: f, reason: from getter */
    public final com.tencent.kuikly.core.nvi.serialization.json.e getPropMap() {
        return this.propMap;
    }
}
