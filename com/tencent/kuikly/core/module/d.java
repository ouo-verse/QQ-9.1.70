package com.tencent.kuikly.core.module;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/module/d;", "Lcom/tencent/kuikly/core/module/Module;", "", HippyControllerProps.STRING, "urlEncode", "urlDecode", "b", "a", "moduleName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends Module {
    public final String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return toNative(false, "base64Decode", string, null, true).toString();
    }

    public final String b(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return toNative(false, "base64Encode", string, null, true).toString();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRCodecModule";
    }

    public final String urlDecode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return toNative(false, "urlDecode", string, null, true).toString();
    }

    public final String urlEncode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return toNative(false, "urlEncode", string, null, true).toString();
    }
}
