package com.tencent.guild.aio.help;

import com.tencent.aio.api.help.d;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/help/BaseGuildHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class BaseGuildHelperProvider implements com.tencent.aio.api.help.d {
    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
        return d.a.a(this);
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> mapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("SendMsgFromCameraHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.BaseGuildHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new SendMsgFromCameraHelper();
            }
        }), TuplesKt.to("MiscPreloadHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.BaseGuildHelperProvider$getLifeCycleHelperCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new r();
            }
        }), TuplesKt.to("GPServiceObserverHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.BaseGuildHelperProvider$getLifeCycleHelperCreator$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new a();
            }
        }), TuplesKt.to("VideoPlayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.guild.aio.help.BaseGuildHelperProvider$getLifeCycleHelperCreator$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new v();
            }
        }));
        return mapOf;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
        return d.a.d(this);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
    @Nullable
    public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
        return d.a.f(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        return d.a.b(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        return d.a.e(this, aVar);
    }
}
