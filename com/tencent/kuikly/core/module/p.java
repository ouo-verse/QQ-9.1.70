package com.tencent.kuikly.core.module;

import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/module/p;", "Lcom/tencent/kuikly/core/module/Module;", "", "pageName", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ISchemeApi.KEY_PAGE_DATA, "hotReloadIp", "", "b", "a", "moduleName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class p extends Module {
    public final void b(String pageName, com.tencent.kuikly.core.nvi.serialization.json.e r122, String hotReloadIp) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("pageName", pageName);
        if (hotReloadIp != null) {
            eVar.v("hotReloadIp", hotReloadIp);
        }
        if (r122 != null) {
            eVar.v(ISchemeApi.KEY_PAGE_DATA, r122);
        }
        Module.toNative$default(this, false, IndividuationPlugin.Method_OpenPage, eVar.toString(), null, false, 24, null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRRouterModule";
    }

    public final void a() {
        Module.toNative$default(this, false, "closePage", null, null, false, 24, null);
    }

    public static /* synthetic */ void c(p pVar, String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eVar = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        pVar.b(str, eVar, str2);
    }
}
