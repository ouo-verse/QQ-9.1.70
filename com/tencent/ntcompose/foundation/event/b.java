package com.tencent.ntcompose.foundation.event;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H&R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ntcompose/foundation/event/b;", "", "", "b", "", "a", "Z", "()Z", "setEnabled", "(Z)V", NodeProps.ENABLED, "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    public b() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public abstract void b();

    public b(boolean z16) {
        this.enabled = z16;
    }

    public /* synthetic */ b(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
