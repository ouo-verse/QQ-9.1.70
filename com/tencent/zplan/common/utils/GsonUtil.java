package com.tencent.zplan.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/common/utils/GsonUtil;", "", "Lcom/google/gson/Gson;", "a", "Lkotlin/Lazy;", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class GsonUtil {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final GsonUtil f385283b = new GsonUtil();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.tencent.zplan.common.utils.GsonUtil$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            gsonBuilder.disableHtmlEscaping();
            return gsonBuilder.create();
        }
    });

    GsonUtil() {
    }

    @NotNull
    public final Gson a() {
        return (Gson) gson.getValue();
    }
}
