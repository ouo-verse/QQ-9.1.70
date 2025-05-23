package com.tencent.mobileqq.vas.qqmc;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.IConfigData;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b&\u0018\u0000 \u000b*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/VasJsonQQMC;", "T", "Lcom/tencent/freesia/IConfigData;", "Lcom/tencent/mobileqq/vas/qqmc/VasQQMC;", "()V", "getGenericClass", "Ljava/lang/Class;", "parse", "content", "", "([B)Lcom/tencent/freesia/IConfigData;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class VasJsonQQMC<T extends IConfigData> extends VasQQMC<T> {

    @NotNull
    private static final String TAG = "VasJsonQQMC";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Gson> gson$delegate = LazyKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.vas.qqmc.VasJsonQQMC$Companion$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Gson invoke() {
            return new Gson();
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/VasJsonQQMC$Companion;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Gson getGson() {
            return (Gson) VasJsonQQMC.gson$delegate.getValue();
        }

        Companion() {
        }
    }

    private final Class<?> getGenericClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        return (Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public T parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        try {
            Object fromJson = INSTANCE.getGson().fromJson(new JSONObject(new String(content, UTF_8)).toString(), (Class<Object>) getGenericClass());
            Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type T of com.tencent.mobileqq.vas.qqmc.VasJsonQQMC");
            return (T) fromJson;
        } catch (JsonSyntaxException e16) {
            com.tencent.xaction.log.b.c(TAG, 1, "QQMC:parse group: " + getGroup() + " content failed", e16);
            return defaultConfig();
        }
    }
}
