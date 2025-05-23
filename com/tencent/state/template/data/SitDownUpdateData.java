package com.tencent.state.template.data;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/template/data/SitDownUpdateData;", "", "id", "", "type", "", NodeProps.VISIBLE, "", "(Ljava/lang/String;IZ)V", "getId", "()Ljava/lang/String;", "getType", "()I", "getVisible", "()Z", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SitDownUpdateData {
    private final String id;
    private final int type;
    private final boolean visible;

    public SitDownUpdateData(String id5, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.type = i3;
        this.visible = z16;
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}
