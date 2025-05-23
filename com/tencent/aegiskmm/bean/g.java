package com.tencent.aegiskmm.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aegiskmm/bean/g;", "Lcom/tencent/aegiskmm/bean/h;", "Lcom/tencent/aegiskmm/bean/c;", "core", "", "d", "a", "Lcom/tencent/aegiskmm/bean/c;", "c", "()Lcom/tencent/aegiskmm/bean/c;", "setCore", "(Lcom/tencent/aegiskmm/bean/c;)V", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public abstract class g implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public c core;

    public final c c() {
        c cVar = this.core;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("core");
        }
        return cVar;
    }

    public final void d(c core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }
}
