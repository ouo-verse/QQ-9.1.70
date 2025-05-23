package com.tencent.kuikly.core.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/module/s;", "Lcom/tencent/kuikly/core/module/Module;", "", "snapshotKey", "", "a", "moduleName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class s extends Module {
    public final void a(String snapshotKey) {
        Intrinsics.checkNotNullParameter(snapshotKey, "snapshotKey");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("snapshotKey", snapshotKey);
        toNative(false, "snapshotPager", eVar.toString(), null, false);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRSnapshotModule";
    }
}
