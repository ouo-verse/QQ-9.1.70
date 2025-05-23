package com.tencent.minibox.loader;

import android.content.Context;
import com.tencent.minibox.loader.base.DelegatorProvider;
import com.tencent.minibox.loader.core.a;
import com.tencent.minibox.loader.core.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/minibox/loader/MiniBoxProvider;", "Lcom/tencent/minibox/loader/base/DelegatorProvider;", "()V", "onCreate", "", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class MiniBoxProvider extends DelegatorProvider {
    @Override // com.tencent.minibox.loader.base.DelegatorProvider, android.content.ContentProvider
    public boolean onCreate() {
        a aVar = a.f151655b;
        if (!aVar.b()) {
            e eVar = e.f151663b;
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            eVar.b(context);
            aVar.c();
        }
        return super.onCreate();
    }
}
