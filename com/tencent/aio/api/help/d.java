package com.tencent.aio.api.help;

import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0017\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0017\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0017\u00a2\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0017\u00a2\u0006\u0004\b\u0007\u0010\fJ$\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0017J$\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/api/help/d;", "", "", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/help/a;", "param", "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/e;", "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/h;", "", "", "Lkotlin/Function0;", "getNormalHelperCreator", "getLifeCycleHelperCreator", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
        @Nullable
        public static h[] a(@NotNull d dVar) {
            return null;
        }

        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
        @Nullable
        public static h[] b(@NotNull d dVar, @NotNull com.tencent.aio.api.help.a param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return null;
        }

        @Nullable
        public static Map<String, Function0<h>> c(@NotNull d dVar, @NotNull com.tencent.aio.api.help.a param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return null;
        }

        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
        @Nullable
        public static e[] d(@NotNull d dVar) {
            return null;
        }

        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
        @Nullable
        public static e[] e(@NotNull d dVar, @NotNull com.tencent.aio.api.help.a param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return null;
        }

        @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
        @Nullable
        public static Map<String, Function0<e>> f(@NotNull d dVar, @NotNull com.tencent.aio.api.help.a param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return null;
        }
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    h[] getLifeCycleHelper();

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a param);

    @Nullable
    Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param);

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    e[] getNormalHelper();

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a param);

    @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
    @Nullable
    Map<String, Function0<e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a param);
}
