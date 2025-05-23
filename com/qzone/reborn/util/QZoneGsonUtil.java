package com.qzone.reborn.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/util/QZoneGsonUtil;", "", "Lcom/google/gson/Gson;", "b", "Lkotlin/Lazy;", "a", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneGsonUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneGsonUtil f59533a = new QZoneGsonUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy gson;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.qzone.reborn.util.QZoneGsonUtil$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
                gsonBuilder.disableHtmlEscaping();
                return gsonBuilder.create();
            }
        });
        gson = lazy;
    }

    QZoneGsonUtil() {
    }

    public final Gson a() {
        Object value = gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }
}
