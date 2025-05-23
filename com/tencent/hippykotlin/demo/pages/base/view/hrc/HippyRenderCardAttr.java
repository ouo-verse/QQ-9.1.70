package com.tencent.hippykotlin.demo.pages.base.view.hrc;

import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HippyRenderCardAttr extends k {
    public e hrcData;
    public int hrcId;

    public final e getHRCData() {
        e eVar = this.hrcData;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hrcData");
        return null;
    }
}
