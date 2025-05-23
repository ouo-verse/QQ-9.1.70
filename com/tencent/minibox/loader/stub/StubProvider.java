package com.tencent.minibox.loader.stub;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.minibox.loader.base.DelegatorProvider;
import com.tencent.minibox.loader.core.a;
import com.tencent.minibox.loader.core.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubProvider;", "Lcom/tencent/minibox/loader/base/DelegatorProvider;", "()V", "onCreate", "", "StubProviderP00", "StubProviderP01", "StubProviderP02", "StubProviderP03", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class StubProvider extends DelegatorProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubProvider$StubProviderP00;", "Lcom/tencent/minibox/loader/stub/StubProvider;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class StubProviderP00 extends StubProvider {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubProvider$StubProviderP01;", "Lcom/tencent/minibox/loader/stub/StubProvider;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class StubProviderP01 extends StubProvider {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubProvider$StubProviderP02;", "Lcom/tencent/minibox/loader/stub/StubProvider;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class StubProviderP02 extends StubProvider {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/minibox/loader/stub/StubProvider$StubProviderP03;", "Lcom/tencent/minibox/loader/stub/StubProvider;", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public static final class StubProviderP03 extends StubProvider {
    }

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
